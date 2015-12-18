package com.priitlaht.strikeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.priitlaht.strikeapi.util.SafeIntegerDeserializer;
import com.priitlaht.strikeapi.util.UnixTimestampDeserializer;

import java.util.Date;

import lombok.Data;

/**
 * @author Priit Laht
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Torrent {
  @JsonProperty(value = "torrent_hash")
  private String hash;
  @JsonProperty(value = "torrent_title")
  private String title;
  @JsonProperty(value = "torrent_category")
  private String category;
  @JsonProperty(value = "sub_category")
  private String subcategory;
  @JsonProperty(value = "seeds")
  @JsonDeserialize(using = SafeIntegerDeserializer.class)
  private int seeds;
  @JsonProperty(value = "leeches")
  @JsonDeserialize(using = SafeIntegerDeserializer.class)
  private int leeches;
  @JsonProperty(value = "file_count")
  @JsonDeserialize(using = SafeIntegerDeserializer.class)
  private int fileCount;
  @JsonProperty(value = "size")
  @JsonDeserialize(using = SafeIntegerDeserializer.class)
  private int size;
  @JsonProperty(value = "imdbid")
  private String imdbId;
  @JsonProperty(value = "upload_date")
  @JsonDeserialize(using = UnixTimestampDeserializer.class)
  private Date uploadDate;

  private String getMagnetUri() {
    return "magnet:?xt=urn:btih:" + hash;
  }
}
