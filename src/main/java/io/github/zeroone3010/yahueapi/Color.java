package io.github.greenstevester.yahueapi;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Use this class to define a color for a color light -- or for a room with color lights.
 */
public record Color(float red, float green, float blue) {

  /**
   * Creates a {@code Color} object with the specified red, green, and blue parts.
   * Same as {@link Color#of(float, float, float)}.
   *
   * @param red   A float number from 0 to 1 inclusive
   * @param green A float number from 0 to 1 inclusive
   * @param blue  A float number from 0 to 1 inclusive
   * @throws IllegalArgumentException if the values are out of range
   * @since 3.0.0
   */
  public Color {
    if (Stream.of(red, green, blue).anyMatch(value -> !MathUtil.isInRange(value, 0f, 1f))) {
      throw new IllegalArgumentException("Color value out of range");
    }
  }

  // Legacy getters for backward compatibility
  public float getRed() {
    return red;
  }

  public float getGreen() {
    return green;
  }

  public float getBlue() {
    return blue;
  }

  /**
   * Creates a {@code Color} object with the specified red, green, and blue parts.
   * Same as {@link Color#Color(float, float, float)}.
   *
   * @param red   A float number from 0 to 1 inclusive
   * @param green A float number from 0 to 1 inclusive
   * @param blue  A float number from 0 to 1 inclusive
   * @return A {@code Color} object
   * @throws IllegalArgumentException if the values are out of range
   */
  public static Color of(final float red, final float green, final float blue) {
    return new Color(red, green, blue);
  }

  /**
   * Creates a {@code Color} object with the specified red, green, and blue parts.
   *
   * @param red   An integer number from 0 to 255 inclusive
   * @param green An integer number from 0 to 255 inclusive
   * @param blue  An integer number from 0 to 255 inclusive
   * @return A {@code Color} object
   * @throws IllegalArgumentException if the values are out of range
   */
  public static Color of(final int red, final int green, final int blue) {
    return new Color(red / 255f, green / 255f, blue / 255f);
  }

  /**
   * Creates a {@code Color} object from the given integer such that the least significant byte (0xFF) represent blue,
   * the next byte green (0xFF00) and the next one red (0xFF0000). All other bytes are ignored.
   *
   * @param redGreenBlue An integer representing a 24-bit RGB color
   * @return A {@code Color} object, as parsed from the three lowest bytes of the given integer
   */
  public static Color of(final int redGreenBlue) {
    return fromInt(redGreenBlue & 0xFFFFFF);
  }

  /**
   * Creates a {@code Color} object from the given integer such that the least significant byte (0xFF) represent blue,
   * the next byte green (0xFF00) and the next one red (0xFF0000). All other bytes are ignored.
   *
   * @param redGreenBlue An integer representing a 24-bit RGB color
   * @return A {@code Color} object, as parsed from the three lowest bytes of the given integer
   * @throws IllegalArgumentException if the input value is null
   */
  public static Color of(final Integer redGreenBlue) {
    if (redGreenBlue == null) {
      throw new IllegalArgumentException("Null is not an acceptable color value.");
    }
    return Color.of(redGreenBlue.intValue() & 0xFFFFFF);
  }

  /**
   * Creates a {@code Color} object from the given string that should represent a three bytes long hexadecimal number.
   *
   * @param hexRgb Six hexadecimal digits, with an optional number sign (#) in front. For example, {@code #ff0000} for red,
   *               or {@code 00FF00} for blue.
   * @return A {@code Color} object, or an {@code IllegalArgumentException} if the value is not of the required format
   * @throws IllegalArgumentException in case the parameter cannot be parsed as a color string
   */
  public static Color of(final String hexRgb) {
    return Optional.ofNullable(hexRgb)
        .map(string -> string.replaceAll("[# ]", ""))
        .filter(string -> string.length() == 6)
        .map(hex -> {
          try {
            return Integer.parseInt(hex, 16);
          } catch (final NumberFormatException e) {
            return null;
          }
        })
        .map(integer -> Color.of(integer.intValue()))
        .orElseThrow(() -> new IllegalArgumentException(String.format("'%s' could not be parsed as a color", hexRgb)));
  }

  /**
   * Accepts another kind of `Color` object, such as an instance of a {@code java.awt.Color} or {@code android.graphics.Color},
   * and tries to parse it into this kind of a {@code Color} object.
   *
   * @param otherColorObject An instance of another sensible color object that provides methods with which one can
   *                         read the red, green, and blue component values.
   * @return A {@code Color} object.
   * @throws IllegalArgumentException in case the parameter cannot be parsed as a color
   */
  public static Color of(final Object otherColorObject) {
    if (otherColorObject == null) {
      throw new IllegalArgumentException("null cannot be parsed as a color.");
    }

    var redMethod = findMethod(otherColorObject, "red", "getRed");
    var greenMethod = findMethod(otherColorObject, "green", "getGreen");
    var blueMethod = findMethod(otherColorObject, "blue", "getBlue");

    if (redMethod.isEmpty() || greenMethod.isEmpty() || blueMethod.isEmpty()) {
      throw new IllegalArgumentException("The given object cannot be parsed as a color.");
    }

    var returnType = redMethod.get().getReturnType();
    if (!returnType.equals(blueMethod.get().getReturnType())
        || !returnType.equals(greenMethod.get().getReturnType())) {

      throw new IllegalArgumentException("The given object cannot be parsed as a color: mismatching getter method return types.");
    }

    try {
      var red = (Number) redMethod.get().invoke(otherColorObject);
      var green = (Number) greenMethod.get().invoke(otherColorObject);
      var blue = (Number) blueMethod.get().invoke(otherColorObject);

      if (red instanceof Integer) {
        return Color.of(red.intValue(), green.intValue(), blue.intValue());
      } else if (red instanceof Double || red instanceof Float) {
        return Color.of(red.floatValue(), green.floatValue(), blue.floatValue());
      } else {
        throw new IllegalArgumentException("Unsupported number type: " + red.getClass());
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("The given object cannot be parsed as a color.", e);
    }
  }

  private static Color fromInt(final int color) {
    return new Color(
        ((color & 0xFF0000) >> 16) / 255f,
        ((color & 0xFF00) >> 8) / 255f,
        (color & 0xFF) / 255f
    );
  }

  private static Optional<Method> findMethod(final Object target, final String name1, final String name2) {
    var methods = target.getClass().getMethods();
    return Arrays.stream(methods).sequential()
        .filter(m -> name1.equals(m.getName()) || name2.equals(m.getName()))
        .findFirst();
  }
}
