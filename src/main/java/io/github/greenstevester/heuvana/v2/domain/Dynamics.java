package io.github.greenstevester.heuvana.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents dynamics information for Hue lights.
 * Contains animation speed and status information for dynamic effects.
 */
public class Dynamics {

  @JsonProperty("speed")
  private float speed;

  @JsonProperty("status")
  private String status;

  @JsonProperty("status_values")
  private List<String> statusValues;

  @JsonProperty("speed_valid")
  private boolean speedValid;

  /**
   * Gets the animation speed for dynamic effects.
   *
   * @return animation speed value
   */
  public float getSpeed() {
    return speed;
  }

  /**
   * Gets the current dynamics status.
   *
   * @return status string
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the list of valid status values.
   *
   * @return list of valid status values
   */
  public List<String> getStatusValues() {
    return statusValues;
  }

  /**
   * Checks if the current speed value is valid.
   *
   * @return true if speed is valid, false otherwise
   */
  public boolean isSpeedValid() {
    return speedValid;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
