package com.softarea.jemywtarnowie.models;

import java.io.Serializable;
import java.util.Arrays;

public class Restaurant implements Serializable {
  private String slug;
  private String name;
  private String address;
  private String delivery_min;
  private String hours;
  private String[] telephone;
  private String logo_url;
  private String menu_url;
  private String[] tags;

  public Restaurant(String slug, String name, String address, String delivery_min, String hours, String[] telephone, String logo_url, String menu_url, String[] tags) {
    this.slug = slug;
    this.name = name;
    this.address = address;
    this.delivery_min = delivery_min;
    this.hours = hours;
    this.telephone = telephone;
    this.logo_url = logo_url;
    this.menu_url = menu_url;
    this.tags = tags;
  }

  @Override
  public String toString() {
    return "Restaurant{" +
      "slug='" + slug + '\'' +
      ", name='" + name + '\'' +
      ", address='" + address + '\'' +
      ", delivery_min='" + delivery_min + '\'' +
      ", hours='" + hours + '\'' +
      ", telephone=" + Arrays.toString(telephone) +
      ", logo_url='" + logo_url + '\'' +
      ", menu_url='" + menu_url + '\'' +
      ", tags=" + Arrays.toString(tags) +
      '}';
  }

  public String getSlug() {
    return slug;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getDeliveryMin() {
    return delivery_min;
  }

  public String getHours() {
    return hours;
  }

  public String[] getTelephone() {
    return telephone;
  }

  public String getLogoUrl() {
    return logo_url;
  }

  public String getMenuUrl() {
    return menu_url;
  }

  public String[] getTags() {
    return tags;
  }
}
