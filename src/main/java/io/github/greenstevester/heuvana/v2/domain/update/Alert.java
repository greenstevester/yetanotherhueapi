package io.github.greenstevester.heuvana.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.greenstevester.heuvana.v2.domain.JsonStringUtil;

/**
 * Represents an alert update command for a Hue device.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alert {

  @JsonProperty("action")
  private AlertType action;

  /**
   * Gets the alert action type.
   *
   * @return the alert action type
   */
  public AlertType getAction() {
    return action;
  }

  /**
   * Sets the alert action type.
   *
   * @param action the alert action type to set
   * @return this alert object for method chaining
   */
  public Alert setAction(AlertType action) {
    this.action = action;
    return this;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
