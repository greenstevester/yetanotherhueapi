package io.github.greenstevester.heuvana.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the configuration information of a Hue Bridge.
 */
public class BridgeConfig {
  @JsonProperty("name")
  private String name;
  @JsonProperty("mac")
  private String mac;

  /**
   * Gets the name of the bridge.
   *
   * @return the bridge name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the MAC address of the bridge.
   *
   * @return the MAC address
   */
  public String getMac() {
    return mac;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
