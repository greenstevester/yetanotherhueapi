package io.github.greenstevester.heuvana.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents dimming information for Hue lights.
 * Contains brightness level and minimum dim level constraints.
 */
public class Dimming {

  @JsonProperty("brightness")
  private int brightness;

  @JsonProperty("min_dim_level")
  private Integer minDimLevel;

  /**
   * Gets the current brightness level.
   *
   * @return brightness percentage (0-100)
   */
  public int getBrightness() {
    return brightness;
  }

  /**
   * Gets the minimum dim level supported by the light.
   *
   * @return minimum dim level percentage, or null if not specified
   */
  public Integer getMinDimLevel() {
    return minDimLevel;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
