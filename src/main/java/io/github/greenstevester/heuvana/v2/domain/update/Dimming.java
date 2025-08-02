package io.github.greenstevester.heuvana.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.greenstevester.heuvana.v2.domain.JsonStringUtil;

/**
 * Update object for modifying dimming settings on Hue lights.
 * Used to send brightness changes to the Bridge API.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dimming {

  /**
   * Default constructor for Dimming.
   * Creates an instance with default values.
   */
  public Dimming() {
    // No initialization required, default values suffice
  }


  @JsonProperty("brightness")
  private int brightness;

  /**
   * Gets the brightness level to be set.
   *
   * @return brightness percentage (1-100)
   */
  public int getBrightness() {
    return brightness;
  }

  /**
   * Brightness percentage. value cannot be 0, writing 0 changes it to the lowest possible brightness.
   *
   * @param brightness A number greater than zero and maximum of 100.
   * @return Self, so that one can also use this method like a fluent builder.
   */
  public Dimming setBrightness(int brightness) {
    this.brightness = brightness;
    return this;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
