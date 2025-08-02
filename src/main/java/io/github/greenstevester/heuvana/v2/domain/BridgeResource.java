package io.github.greenstevester.heuvana.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Represents a Hue Bridge resource.
 */
@JsonTypeName("bridge")
public class BridgeResource extends Resource {
  @JsonProperty("bridge_id")
  private String bridgeId;

  /**
   * Gets the unique identifier of the bridge.
   *
   * @return the bridge ID
   */
  public String getBridgeId() {
    return bridgeId;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
