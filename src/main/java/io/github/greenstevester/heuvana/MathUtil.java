package io.github.greenstevester.heuvana;

final class MathUtil {
  private MathUtil() {
    // prevent
  }

  static boolean isInRange(final Float value, final float min, final float max) {
    return value != null && value >= min && value <= max;
  }
}
