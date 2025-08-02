package io.github.greenstevester.heuvana.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents alert settings for a Hue device.
 */
public class Alert {

  @JsonProperty("action_values")
  private List<String> actionValues;

  /**
   * Gets the list of available action values for alerts.
   *
   * @return the list of action values
   */
  public List<String> getActionValues() {
    return actionValues;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
