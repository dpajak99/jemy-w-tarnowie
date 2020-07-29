package com.softarea.jemywtarnowie.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;

import com.softarea.jemywtarnowie.R;
import com.softarea.jemywtarnowie.models.Restaurant;
import com.softarea.jemywtarnowie.utils.ImageUtils;
import com.softarea.jemywtarnowie.utils.StringUtils;

import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {
  private static class ViewHolder {
    private CardView restaurantItem;
    private ImageView restaurantImage;
    private TextView restaurantName;
    private TextView restaurantAddress;
    private TextView restaurantTimeOpen;
    private TextView restaurantPhone;

  }

  public RestaurantAdapter(Context context, int textViewResourceId, List<Restaurant> items) {
    super(context, textViewResourceId, items);
  }

  @NonNull
  @SuppressLint("DefaultLocale")
  public View getView(int position, View convertView, @NonNull ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      convertView = LayoutInflater.from(this.getContext())
        .inflate(R.layout.item_restaurant, parent, false);

      viewHolder = new ViewHolder();
      viewHolder.restaurantItem = convertView.findViewById(R.id.card_restaurant);
      viewHolder.restaurantImage = convertView.findViewById(R.id.image_restaurant);
      viewHolder.restaurantName = convertView.findViewById(R.id.text_restaurant);
      viewHolder.restaurantAddress = convertView.findViewById(R.id.text_address);
      viewHolder.restaurantTimeOpen = convertView.findViewById(R.id.text_open);
      viewHolder.restaurantPhone = convertView.findViewById(R.id.text_phone);

      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }

    final Restaurant restaurant = getItem(position);
    if (restaurant != null) {
      ImageUtils.loadImage(getContext(), restaurant.getLogoUrl(), viewHolder.restaurantImage);
      viewHolder.restaurantName.setText(restaurant.getName());
      viewHolder.restaurantAddress.setText(restaurant.getAddress());
      viewHolder.restaurantTimeOpen.setText(restaurant.getHours());
      String stringResult = "";
      for (int i = 0; i < restaurant.getTelephone().length; i++) {
        stringResult = StringUtils.join(stringResult, restaurant.getTelephone()[i]);
        if (i != restaurant.getTelephone().length - 1) {
          stringResult = StringUtils.join(stringResult, "\n");
        }
      }
      viewHolder.restaurantPhone.setText(stringResult);

      final View finalConvertView = convertView;
      viewHolder.restaurantItem.setOnClickListener(view -> {
        Bundle result = new Bundle();
        result.putSerializable("restaurant", restaurant);

        Navigation.findNavController(finalConvertView).navigate(R.id.navigation_order, result);
      });
    }
    return convertView;
  }
}

