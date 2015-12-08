package com.priitlaht.strikeapi.model;

import java.util.Date;

import lombok.Data;

/**
 * @author Priit Laht
 */
@Data
public class Torrent {
  private String hash;
  private String title;
  private String category;
  private String subcategory;
  private int seeds;
  private int leeches;
  private int fileCount;
  private int size;
  private Date uploadDate;
  private String magnetUri;
}
