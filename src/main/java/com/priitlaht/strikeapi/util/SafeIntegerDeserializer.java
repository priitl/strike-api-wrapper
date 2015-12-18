package com.priitlaht.strikeapi.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * @author Priit Laht
 */
public class SafeIntegerDeserializer extends JsonDeserializer<Integer> {

  @Override
  public Integer deserialize(JsonParser parser, DeserializationContext context) throws IOException {
    try {
      return Integer.parseInt(parser.getText().trim());
    } catch (NumberFormatException e) {
      return 0;
    }
  }
}
