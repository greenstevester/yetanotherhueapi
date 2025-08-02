package io.github.greenstevester.heuvana.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Root container for button resource data from the Hue Bridge API.
 */
public class ButtonResourceRoot {

  @JsonProperty("errors")
  private List<Error> errors;

  @JsonProperty("data")
  private List<ButtonResource> data;

  /**
   * Gets any errors that occurred during the API call.
   *
   * @return the list of errors
   */
  public List<Error> getErrors() {
    return errors;
  }

  /**
   * Gets the button resource data.
   *
   * @return the list of button resources
   */
  public List<ButtonResource> getData() {
    return data;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
