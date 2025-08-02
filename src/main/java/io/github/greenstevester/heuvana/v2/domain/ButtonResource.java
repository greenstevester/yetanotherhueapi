package io.github.greenstevester.heuvana.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Represents a button resource from the Hue Bridge.
 */
@JsonTypeName("button")
public class ButtonResource extends Resource {

  @JsonProperty("owner")
  private ResourceIdentifier owner;

  @JsonProperty("metadata")
  private ButtonMetadata metadata;

  @JsonProperty("button")
  private ButtonSpecifics button;

  /**
   * Gets the button metadata.
   *
   * @return the button metadata
   */
  public ButtonMetadata getMetadata() {
    return metadata;
  }

  /**
   * Gets the button specifics.
   *
   * @return the button specifics
   */
  public ButtonSpecifics getButton() {
    return button;
  }
}
