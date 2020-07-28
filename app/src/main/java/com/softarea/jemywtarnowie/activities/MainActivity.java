package com.softarea.jemywtarnowie.activities;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.softarea.jemywtarnowie.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

  NavController navController;
  DrawerLayout drawer;
  NavigationView navigationView;
  AppBarConfiguration appBarConfiguration;
  BottomNavigationView bottomNavigationView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    init();

    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(navigationView, navController);
    NavigationUI.setupWithNavController(bottomNavigationView, navController);
  }

  private void init() {
    drawer = findViewById(R.id.drawer);
    navigationView = findViewById(R.id.navigationView);
    bottomNavigationView = findViewById(R.id.navigation_bottom);

    navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_restaurant, R.id.navigation_dashboard, R.id.navigation_notifications)
      .setDrawerLayout(drawer)
      .build();
  }


  @Override
  public boolean onSupportNavigateUp() {
    return NavigationUI.navigateUp(navController, appBarConfiguration);
  }

  @Override
  public void onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

}
