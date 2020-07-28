package com.softarea.jemywtarnowie.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DataUtils {
  public static String readJSON(Context context, String fileName) {
    try (InputStream is = context.getAssets().open(fileName)) {

      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);

      return new String(buffer, StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
