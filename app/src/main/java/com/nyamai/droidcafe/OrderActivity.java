package com.nyamai.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //get the intent sent from the main activity
        Intent intent=getIntent();
        String displayMessage = intent.getStringExtra(MainActivity.EXTRA_ORDER_KEY);
        //create a textview variable to connect with the textview in the layout
        TextView orderDisplay = findViewById(R.id.display_order);
        //setting the textview with the message retrieved from main activity
        orderDisplay.setText(displayMessage);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.sameDay:
                if(checked){
                    displayToast(getString(R.string.same_day_messenger_service));
                }break;
            case R.id.nextDay:
                if(checked){
                    displayToast(getString(R.string.next_day_ground_delivery));
                }break;
            case R.id.pickUp:
                if(checked){
                    displayToast(getString(R.string.pick_up));
                }break;
            default:
                break;
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
