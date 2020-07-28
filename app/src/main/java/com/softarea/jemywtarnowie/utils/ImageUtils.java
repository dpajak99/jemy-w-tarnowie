package com.softarea.jemywtarnowie.utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageUtils {
  public static void loadImage(Context context, String url, ImageView imageView) {
    Picasso.with(context).load(url)
      .into(imageView);
  }
}
