package com.softarea.jemywtarnowie.dao;

import android.content.Context;

import com.softarea.jemywtarnowie.models.Restaurant;
import com.softarea.jemywtarnowie.utils.DataUtils;
import com.softarea.jemywtarnowie.utils.StringUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsDAO {
  public static List<Restaurant> getCategories(Context context) {
    List<Restaurant> categories = new ArrayList<>();
    try {
      JSONArray array = new JSONArray(DataUtils.readJSON(context, "restaurants.json"));

      for (int i = 0; i < array.length(); i++) {
        JSONObject object = array.getJSONObject(i);
        categories.add(new Restaurant(
          object.getString("slug"),
          object.getString("name"),
          object.getString("address"),
          object.getString("delivery_min"),
          object.getString("hours"),
          StringUtils.toStringArray(object.getJSONArray("telephone")),
          object.getString("logo_url"),
          object.getString("menu_url"),
          StringUtils.toStringArray(object.getJSONArray("tags"))));
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return categories;
  }
}
