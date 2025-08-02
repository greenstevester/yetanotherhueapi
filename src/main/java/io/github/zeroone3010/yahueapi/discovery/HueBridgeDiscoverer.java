package io.github.greenstevester.yahueapi.discovery;

import java.util.concurrent.CompletableFuture;

/**
 * An interface for an automatic Hue Bridge discovery method.
 */
interface HueBridgeDiscoverer {
  CompletableFuture<Void> discoverBridges();
}
