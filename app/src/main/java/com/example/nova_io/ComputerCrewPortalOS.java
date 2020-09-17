package com.example.nova_io;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ComputerCrewPortalOS extends AppCompatActivity {

    public void exitButton(View view){
        Intent intentComputer = new Intent(this, ComputerInterface.class);
        startActivity(intentComputer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_crew_portal_o_s);

    }

    protected void onStart(){
        super.onStart();

        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        // get the height and width of the screen
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);
        int height = outMetrics.heightPixels;
        int width  = outMetrics.widthPixels;

        final ImageView nextButton = (ImageView)findViewById(R.id.nextButton);
        final ImageView nextButton2 = (ImageView)findViewById(R.id.nextButton2);
        // layout parameters for the fuel percentage text
        ViewGroup.MarginLayoutParams marginParamsNextButton = (ViewGroup.MarginLayoutParams) nextButton.getLayoutParams();
        ViewGroup.MarginLayoutParams marginParamsNextButton2 = (ViewGroup.MarginLayoutParams) nextButton2.getLayoutParams();
        int marginBottom = (int) (0.3 * height);
        int marginEnd = (int) (0.26 * width);
        marginParamsNextButton.setMargins(0, 0, 0, marginBottom);
        marginParamsNextButton.setMarginEnd(marginEnd);
        marginParamsNextButton2.setMargins(0, 0, 0, marginBottom);
        marginParamsNextButton2.setMarginEnd(marginEnd);

        final ImageView backButton = (ImageView)findViewById(R.id.backButton);
        // layout parameters for the fuel percentage text
        ViewGroup.MarginLayoutParams marginParamsBackButton = (ViewGroup.MarginLayoutParams) backButton.getLayoutParams();
        marginBottom = (int) (0.3 * height);
        marginEnd = (int) (0.7 * width);
        marginParamsBackButton.setMargins(0, 0, 0, marginBottom);
        marginParamsBackButton.setMarginEnd(marginEnd);

        // Load the ImageView that will host the animation and
        // set its background to our AnimationDrawable XML resource.
        final ImageView img = (ImageView)findViewById(R.id.background_imageView);
        img.setBackgroundResource(R.drawable.portal_os_loading);
        // Get the background, which has been compiled to an AnimationDrawable object.
        final AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        // Start the animation (looped playback by default)
        frameAnimation.start();

        final Handler handler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                handler.removeCallbacks(this);
                crew(nextButton, nextButton2, backButton, img);
            }
        };
        handler.postDelayed(r, 9100); // Total animation duration = 9100
    }

    public void crew(final ImageView nextButton, final ImageView nextButton2, final ImageView backButton, final ImageView img){
        img.setBackgroundResource(R.drawable.portal_os_crew0004);
        nextButton.setVisibility(View.VISIBLE);
        nextButton2.setVisibility(View.INVISIBLE);
        backButton.setVisibility(View.INVISIBLE);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRequired(nextButton, nextButton2, backButton, img);
            }
        });
    }

    public void updateRequired(final ImageView nextButton, final ImageView nextButton2, final ImageView backButton, final ImageView img){
        img.setBackgroundResource(R.drawable.portal_os_update_required);
        nextButton.setVisibility(View.INVISIBLE);
        backButton.setVisibility(View.VISIBLE);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crew(nextButton, nextButton2, backButton, img);
            }
        });

        nextButton2.setVisibility(View.VISIBLE);
        nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButton.setVisibility(View.INVISIBLE);
                nextButton2.setVisibility(View.INVISIBLE);
                updating(img);
            }
        });
    }

    public void updating(final ImageView img){
        img.setBackgroundResource(R.drawable.portal_os_updating);
        final AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

        // Start the animation (looped playback by default)
        frameAnimation.start();
        final Handler handler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                handler.removeCallbacks(this);
                exitButton(img);
            }
        };
        handler.postDelayed(r, 4700);
    }
}

