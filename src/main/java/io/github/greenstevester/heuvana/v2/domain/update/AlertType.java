package io.github.greenstevester.heuvana.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Enumeration of alert types for Hue devices.
 */
public enum AlertType {
  /**
   * An alert type not supported by this version of this library.
   */
  @JsonEnumDefaultValue UNKNOWN,
  /**
   * Breathe alert type - performs a breathe effect on the light.
   */
  @JsonProperty("breathe") BREATHE
}
