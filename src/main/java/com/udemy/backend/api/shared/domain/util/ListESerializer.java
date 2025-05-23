package com.udemy.backend.api.shared.domain.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.udemy.backend.api.shared.domain.data.Node;
import com.udemy.backend.api.shared.domain.operator.ListE;

public class ListESerializer extends JsonSerializer<ListE<?>> {
  @Override
  public void serialize(ListE<?> value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException {
    gen.writeStartArray();
    Node<?> current = value.getHead();
    while (current != null) {
      gen.writeObject(current.getData());
      current = current.getNext();
    }
    gen.writeEndArray();
  }
}