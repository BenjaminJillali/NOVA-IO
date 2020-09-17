package com.example.nova_io;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ComputerConsole extends AppCompatActivity {

    int numLines = 0;

    public void exitButton(View view){
        Intent intentComputer = new Intent(this, ComputerInterface.class);
        startActivity(intentComputer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_console);

        // get the height and width of the screen
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);
        int height = outMetrics.heightPixels;
        int width  = outMetrics.widthPixels;

        final TextView consoleOutput = findViewById(R.id.consoleOutput);
        ViewGroup.MarginLayoutParams marginsConsoleOutput = (ViewGroup.MarginLayoutParams) consoleOutput.getLayoutParams();
        marginsConsoleOutput.setMargins(0, ((int) (0.1 * height)), 0, 0);
        marginsConsoleOutput.setMarginStart((int) (0.1 * width));
        consoleOutput.setMovementMethod(new ScrollingMovementMethod());

        final EditText userInput = findViewById(R.id.userInput);
        ViewGroup.MarginLayoutParams marginsUserInput = (ViewGroup.MarginLayoutParams) userInput.getLayoutParams();
        marginsUserInput.setMargins(0, 0, 0, ((int) (0.083 * height)));
        marginsUserInput.setMarginStart((int) (0.1 * width));

        final String[] userInputText = new String[1];

        userInput.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if((event.getAction()==KeyEvent.ACTION_DOWN)&&
                        (keyCode==KeyEvent.KEYCODE_ENTER)){
                            userInputText[0] = userInput.getText().toString();
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(userInput.getWindowToken(),0);
                            userInput.setText("");
                            //consoleOutput.append(userInputText[0] + "\n> ");
                            processUserInput(userInputText[0]);
                            return true;
                }
                return false;
            }
        });
    }

    protected void onStart(){
        super.onStart();

        // Hide the status bar.
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        TextView consoleOutput = findViewById(R.id.consoleOutput);
        consoleOutput.setText("> Welcome user : Hobonaut\n> ");
        numLines = 1;
        consoleOutput.setGravity(Gravity.TOP);
    }

    public void processUserInput(String inputString){

        TextView consoleOutput = findViewById(R.id.consoleOutput);

        if(inputString.toLowerCase().equals("help")){
            consoleOutput.append("\nThis is the HobOS console. You can use it to launch applications.\n" +
                    "KEYWORDS:\t\thelp : displays this message\n\t\t\t\t\t\t\t\t\t\t\t\t\t\tclear : clears the screen\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\texit OR return : exits the console and returns to the HobOS desktop\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\topen : opens one of the HobOS desktop apps.. Must be followed by app. name:\n" +
                    "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t'inventory', 'manual', 'diagnostics', 'nova-io', 'crew'\n> ");
            numLines += 6;
        }else if(inputString.toLowerCase().equals("clear")) {
            onStart();
        }else if(inputString.toLowerCase().equals("exit") || inputString.toLowerCase().equals("return")){
                Intent intentComputer = new Intent(this, ComputerInterface.class);
                startActivity(intentComputer);
        }else if(inputString.toLowerCase().contains("open")){
            if(inputString.toLowerCase().contains("inventory")){
                Intent intentComputer = new Intent(this, ComputerInventory.class);
                startActivity(intentComputer);
            }else if(inputString.toLowerCase().contains("manual")){
                Intent intentComputer = new Intent(this, ComputerManual.class);
                startActivity(intentComputer);
            }else if(inputString.toLowerCase().contains("diagnostics")){
                Intent intentComputer = new Intent(this, ComputerDiagnostics.class);
                startActivity(intentComputer);
            }else if(inputString.toLowerCase().contains("nova-io")){
                Intent intentComputer = new Intent(this, ComputerNovaIO.class);
                startActivity(intentComputer);
            }else if(inputString.toLowerCase().contains("crew")){
                Intent intentComputer = new Intent(this, ComputerCrewPortalOS.class);
                startActivity(intentComputer);
            }else{
                consoleOutput.append(" '" + inputString + "' " + "is not a recognized console command. Please enter valid command\n>");
                numLines++;
            }
        }else{
            consoleOutput.append(" '" + inputString + "' " + "is not a recognized console command. Please enter valid command\n>");
            numLines++;
        }

        if(numLines > 19){
            consoleOutput.setGravity(Gravity.BOTTOM);
        }
    }
}