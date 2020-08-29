package com.example.nova_io;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ComputerInterface extends AppCompatActivity {

    // Open the corresponding activity (create intent)
    public void iconTapped(String iconID){
        Log.i("iconTapped", iconID);
        switch(iconID){
            case "diagnostics" : Intent intentDiagnostics = new Intent(this, ComputerDiagnostics.class);
                startActivity(intentDiagnostics);
                break;
            case "manual" : Intent intentManual = new Intent(this, ComputerManual.class);
                startActivity(intentManual);
                break;
            case "console" : Intent intentConsole = new Intent(this, ComputerConsole.class);
                startActivity(intentConsole);
                break;
            case "inventory" : Intent intentInventory = new Intent(this, ComputerInventory.class);
                startActivity(intentInventory);
                break;
            case "novaIO" : Intent intentNovaIO = new Intent(this, ComputerNovaIO.class);
                startActivity(intentNovaIO);
                break;
            case "crewPortalOS" : Intent intentCrewPortalOS = new Intent(this, ComputerCrewPortalOS.class);
                startActivity(intentCrewPortalOS);
                break;
            default : break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_interface);
    }

    protected void onStart(){
        super.onStart();

        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        // ImageViews and listeners for the icons //
        ImageView iconDiagnosticsView = (ImageView) findViewById(R.id.iconDiagnostics);
        iconDiagnosticsView.setAlpha(0.7f);
        iconDiagnosticsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setAlpha(1.0f);
                iconTapped("diagnostics");
            }
        });

        ImageView iconManualView = (ImageView) findViewById(R.id.iconManual);
        iconManualView.setAlpha(0.7f);
        iconManualView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setAlpha(1.0f);
                iconTapped("manual");
            }
        });

        ImageView iconConsoleView = (ImageView) findViewById(R.id.iconConsole);
        iconConsoleView.setAlpha(0.7f);
        iconConsoleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setAlpha(1.0f);
                iconTapped("console");
            }
        });

        ImageView iconInventoryView = (ImageView) findViewById(R.id.iconInventory);
        iconInventoryView.setAlpha(0.7f);
        iconInventoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setAlpha(1.0f);
                iconTapped("inventory");
            }
        });

        ImageView iconNovaIOView = (ImageView) findViewById(R.id.iconNovaIO);
        iconNovaIOView.setAlpha(0.7f);
        iconNovaIOView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setAlpha(1.0f);
                iconTapped("novaIO");
            }
        });

        ImageView iconCrewPortalOSView = (ImageView) findViewById(R.id.iconCrewPortalOS);
        iconCrewPortalOSView.setAlpha(0.7f);
        iconCrewPortalOSView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setAlpha(1.0f);
                iconTapped("crewPortalOS");
            }
        });
        //////////////////////////////////////////////////////
    }
}