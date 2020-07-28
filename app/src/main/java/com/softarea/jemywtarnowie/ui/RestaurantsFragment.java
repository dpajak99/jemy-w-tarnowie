package com.softarea.jemywtarnowie.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.softarea.jemywtarnowie.R;
import com.softarea.jemywtarnowie.adapters.ExpandableHeightGridView;
import com.softarea.jemywtarnowie.adapters.RestaurantAdapter;
import com.softarea.jemywtarnowie.dao.RestaurantsDAO;
import com.softarea.jemywtarnowie.models.Restaurant;

import java.util.List;


public class RestaurantsFragment extends Fragment {

  public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_restaurants, container, false);

    RestaurantAdapter restaurantAdapter = new RestaurantAdapter(getContext(),
      R.layout.item_restaurant, (List<Restaurant>)
      RestaurantsDAO.getCategories(getActivity()));
    ExpandableHeightGridView grid = root.findViewById(R.id.gridview);
    grid.setVerticalScrollBarEnabled(true);
    grid.setAdapter(restaurantAdapter);
    grid.setExpanded(true);

    RelativeLayout relativeLayout = root.findViewById(R.id.relativeanimation);

    return root;
  }

}
