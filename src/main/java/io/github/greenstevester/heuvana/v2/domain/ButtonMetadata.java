package io.github.greenstevester.heuvana.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Metadata for a button resource.
 */
public class ButtonMetadata {
  @JsonProperty("control_id")
  private int controlId;

  /**
   * minimum: 0 – maximum: 8
   *
   * @return Number of the button on the switch device.
   */
  public int getControlId() {
    return controlId;
  }

  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
