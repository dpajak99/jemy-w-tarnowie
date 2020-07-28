package com.softarea.jemywtarnowie.utils;

import org.json.JSONArray;

public class StringUtils {
  public static String[] toStringArray(JSONArray array) {
    if (array == null)
      return null;

    String[] arr = new String[array.length()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = array.optString(i);
    }
    return arr;
  }

  public static String join(String... values) {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < values.length; i++) {
      sb.append(values[i]);
    }
    return sb.toString();
  }
}
