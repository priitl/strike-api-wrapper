package com.priitlaht.strikeapi.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * @author Priit Laht
 */
public class UnixTimestampDeserializer extends JsonDeserializer<Date> {

  @Override
  public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException {
    String timestamp = parser.getText().trim();
    return new Date(Long.valueOf(timestamp) * 1000);
  }
}
