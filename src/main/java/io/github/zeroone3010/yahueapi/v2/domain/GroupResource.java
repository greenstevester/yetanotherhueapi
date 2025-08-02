package io.github.greenstevester.yahueapi.v2.domain;

import java.util.List;
import java.util.UUID;

public interface GroupResource {
  ResourceType getType();

  UUID getId();

  String getIdV1();

  List<ResourceIdentifier> getServices();

  Metadata getMetadata();

  List<ResourceIdentifier> getChildren();
}
