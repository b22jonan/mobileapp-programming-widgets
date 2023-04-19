package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int addPerSecond = 0;
    int TotalCookies = 0;
    // when image button is clicked, take the current value of the counter and increment it by 1 and display the new value
    public void onImageButtonClicked(View view) {
        // get the current value of the counter
        TextView TextView = (TextView ) findViewById(R.id.textView);
        String counterString = TextView.getText().toString();
        int counter = Integer.parseInt(counterString);
        // increment the counter
        counter++;
        TotalCookies++;
        // display the new value of the counter
        TextView.setText(Integer.toString(counter));
    }

    // when the noraml button is pressed remove 20 from the counter and add 1 cookie every second
    public void onNormalButtonClicked(View view) {
        if (TotalCookies >= 20) {
            // get the current value of the counter
            TextView TextView = (TextView ) findViewById(R.id.textView);
            String counterString = TextView.getText().toString();
            int counter = Integer.parseInt(counterString);
            // decrement the counter by 20
            counter -= 20;
            TotalCookies -= 20;
            // display the new value of the counter
            TextView.setText(Integer.toString(counter));
            // add 1 cookie every second
            addPerSecond++;
        }
    }

    // create a thread that adds addPerSecond cookies every second
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // get the current value of the counter
            TextView TextView = (TextView ) findViewById(R.id.textView);
            String counterString = TextView.getText().toString();
            int counter = Integer.parseInt(counterString);
            // increment the counter
            counter += addPerSecond;
            TotalCookies += addPerSecond;
            // display the new value of the counter
            TextView.setText(Integer.toString(counter));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }
}
