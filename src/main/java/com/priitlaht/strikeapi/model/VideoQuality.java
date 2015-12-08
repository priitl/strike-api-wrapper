package com.priitlaht.strikeapi.model;

/**
 * @author Priit Laht
 */
public enum VideoQuality {
  SD480P("480P"), HD720P("720P"), HD1080P("1080P");

  public String value;

  VideoQuality(String value) {
    this.value = value;
  }
}
