package com.example.nova_io;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ComputerManual extends AppCompatActivity {

    public void exitButton(View view){
        Intent intentComputer = new Intent(this, ComputerInterface.class);
        startActivity(intentComputer);
    }

    public void changeText(String contentListItem){

        TextView txt = findViewById(R.id.novaScriptText);

        switch(contentListItem){
            case "welcome" : txt.setText(R.string.welcome_text);
                break;

            case "syntax" : txt.setText(R.string.syntax_text);
                break;

            case "keywords" : txt.setText(R.string.keywords_text);
                break;

            case "movementLibrary" : txt.setText(R.string.movementLibrary_text);
                break;

            default : break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_manual);

        // get the height and width of the screen
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);
        int height = outMetrics.heightPixels;
        int width  = outMetrics.widthPixels;

        // Textviews and listeners for the contents list //
        TextView contentsWelcomeView = findViewById(R.id.contentsWelcome);
        ViewGroup.MarginLayoutParams marginsContentsWelcomeView = (ViewGroup.MarginLayoutParams) contentsWelcomeView.getLayoutParams();
        marginsContentsWelcomeView.setMargins(0, ((int) (0.15 * height)), 0, 0);
        marginsContentsWelcomeView.setMarginStart((int) (0.125 * width));
        contentsWelcomeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText("welcome");
            }
        });

        TextView contentsSyntaxView = findViewById(R.id.contentsSyntax);
        ViewGroup.MarginLayoutParams marginsContentsSyntaxView = (ViewGroup.MarginLayoutParams) contentsSyntaxView.getLayoutParams();
        marginsContentsSyntaxView.setMargins(0, ((int) (0.225 * height)), 0, 0);
        marginsContentsSyntaxView.setMarginStart((int) (0.125 * width));
        contentsSyntaxView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText("syntax");
            }
        });

        TextView contentsKeywordsView =  findViewById(R.id.contentsKeywords);
        ViewGroup.MarginLayoutParams marginsContentsKeywordsView = (ViewGroup.MarginLayoutParams) contentsKeywordsView.getLayoutParams();
        marginsContentsKeywordsView.setMargins(0, ((int) (0.3 * height)), 0, 0);
        marginsContentsKeywordsView.setMarginStart((int) (0.125 * width));
        contentsKeywordsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText("keywords");
            }
        });

        TextView contentsMovementLibraryView = findViewById(R.id.contentsMovementLibrary);
        ViewGroup.MarginLayoutParams marginsContentsMovementLibraryView = (ViewGroup.MarginLayoutParams) contentsMovementLibraryView.getLayoutParams();
        marginsContentsMovementLibraryView.setMargins(0, ((int) (0.375 * height)), 0, 0);
        marginsContentsMovementLibraryView.setMarginStart((int) (0.125 * width));
        contentsMovementLibraryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText("movementLibrary");
            }
        });

        TextView contentsNovaScriptView = findViewById(R.id.novaScriptText);
        ViewGroup.MarginLayoutParams marginsContentsNovaScriptView = (ViewGroup.MarginLayoutParams) contentsNovaScriptView.getLayoutParams();
        marginsContentsNovaScriptView.setMargins(0, ((int) (0.15 * height)), 0, 0);
        marginsContentsNovaScriptView.setMarginStart((int) (0.4 * width));
        contentsNovaScriptView.setText(R.string.welcome_text);
        /////////////////////////////////////////////
    }

    protected void onStart(){
        super.onStart();

        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}