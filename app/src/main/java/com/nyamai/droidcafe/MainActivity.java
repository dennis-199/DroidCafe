package com.nyamai.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.nyamai.droidcafe.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private String orderMessage;
    public static final String EXTRA_ORDER_KEY="MY KEY FOR ORDER MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        FloatingActionButton fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                intent.putExtra(EXTRA_ORDER_KEY,orderMessage);
                startActivity(intent);
            }
        });
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        switch (item.getItemId()){
            //OPEN ORDER ACTIVITY
            case R.id.action_order:
                Intent orderIntent = new Intent(MainActivity.this,OrderActivity.class);
                orderIntent.putExtra(EXTRA_ORDER_KEY,orderMessage);
                startActivity(orderIntent);
                return true;
            case R.id.action_call:
                Uri myUri = Uri.parse("tel:+254769584101");
                Intent callIntent = new Intent(Intent.ACTION_DIAL,myUri);
                startActivity(callIntent);
                return true;
            case R.id.action_status:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.action_location:
                String mLocation = "My location";
                String loc = mLocation;
                Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
                Intent locationintent = new Intent(Intent.ACTION_VIEW, addressUri);
                startActivity(locationintent);
                return true;
            case R.id.action_about_us:
                String url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";;
                Intent aboutUsIntent = new Intent(Intent.ACTION_VIEW);
                aboutUsIntent.setData(Uri.parse(url));
                startActivity(aboutUsIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    //displaying toast messages
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void showIceCreamOrderMessage(View view) {
        //displayToast(getString(R.string.iceCreamOrder));
        orderMessage = getString(R.string.iceCreamOrder);
        displayToast(orderMessage);
    }

    public void showDonutOrderMessage(View view) {
        //displayToast(getString(R.string.donutOrder));
        orderMessage = getString(R.string.donutOrder);
        displayToast(orderMessage);
    }

    public void showFroyoOrderMessage(View view) {
        orderMessage = getString(R.string.froyoOrder);
        displayToast(orderMessage);
        //displayToast(getString(R.string.froyoOrder));
    }
}