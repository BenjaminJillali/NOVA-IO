package com.example.nova_io;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ComputerDiagnostics extends AppCompatActivity {

    long shipVelocity = 10350;
    long fuelPercentCounter = 0;
    float fuelPercentage = 82.09f;

    public void exitButton(View view){
        Intent intentComputer = new Intent(this, ComputerInterface.class);
        startActivity(intentComputer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_diagnostics);

        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        ImageView img = (ImageView)findViewById(R.id.background_imageView);
        img.setBackgroundResource(R.drawable.background_anim);
        // Get the background, which has been compiled to an AnimationDrawable object.
        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        // Start the animation (looped playback by default).
        frameAnimation.start();

        String fuelPercentageString = Float.toString(fuelPercentage);
        TextView fuelPercentageText = (TextView) findViewById(R.id.fuel);
        String percentSign = " %";
        String fullPercentage = fuelPercentageString + percentSign;
        fuelPercentageText.setText(fullPercentage);

        // get the height and width of the screen
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);
        int height = outMetrics.heightPixels;
        int width  = outMetrics.widthPixels;
        //System.out.println("height : " + height + "    width : " + width);

        // layout parameters for the fuel percentage text
        ViewGroup.MarginLayoutParams marginParamsFuel = (ViewGroup.MarginLayoutParams) fuelPercentageText.getLayoutParams();
        int marginTop = (int) (0.33 * height);
        int marginStart = (int) (0.39 * width);
        marginParamsFuel.setMargins(0, marginTop, 0, 0);
        marginParamsFuel.setMarginStart(marginStart);

        // layout parameters for the velocity text
        final TextView shipVelocityText = (TextView) findViewById(R.id.velocity);
        ViewGroup.MarginLayoutParams marginParamsVelocity = (ViewGroup.MarginLayoutParams) shipVelocityText.getLayoutParams();
        int marginBottom = (int) (0.255 * height);
        marginStart = (int) (0.24 * width);
        marginParamsVelocity.setMargins(0, 0, 0, marginBottom);
        marginParamsVelocity.setMarginStart(marginStart);


        final Handler handlerTimer = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                //
                if(((fuelPercentCounter / 1000) % 10) == 0){
                    fuelPercentage -= 0.001f;
                    String fuelPercentageString = String.format("%.2f", fuelPercentage);
                    //String.format("%.2f", fuelPercentageString);
                    TextView fuelPercentageText = (TextView) findViewById(R.id.fuel);
                    String percentSign = " %";
                    String fullPercentage = fuelPercentageString + percentSign;
                    fuelPercentageText.setText(fullPercentage);
                }
                shipVelocity += 10;
                fuelPercentCounter++;
                String shipVelocityString = Long.toString(shipVelocity);
                String units = " m/s";
                String fullVelocity = shipVelocityString + units;
                shipVelocityText.setText(fullVelocity);
                //
                handlerTimer.postDelayed(this, 1000);
            }
        };
        handlerTimer.post(run);
    }

    protected void onStart(){
        super.onStart();

        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}