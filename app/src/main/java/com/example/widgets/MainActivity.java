package com.example.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    // when image button is clicked, take the current value of the counter and increment it by 1 and display the new value
    public void onImageButtonClicked(View view) {
        // get the current value of the counter
        TextView TextView = findViewById(R.id.textView);
        String counterString = TextView.getText().toString();
        int counter = Integer.parseInt(counterString);
        // increment the counter
        counter++;

        // display the new value of the counter
        TextView.setText(Integer.toString(counter));
    }

    // when normal button is clicked, add the value in the edit text to the counter and display the new value
    public void onButtonClicked(View view) {
        // get the current value of the counter
        TextView TextView = findViewById(R.id.textView);
        String counterString = TextView.getText().toString();
        int counter = Integer.parseInt(counterString);

        // get the value in the edit text
        TextView EditText = findViewById(R.id.editTextNumber);
        String editTextString = EditText.getText().toString();
        int editText = Integer.parseInt(editTextString);

        // add the value in the edit text to the counter
        counter += editText;

        // display the new value of the counter
        TextView.setText(Integer.toString(counter));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        ImageButton CookieButton = findViewById(R.id.imageButton);



        // listeners
        CookieButton.setOnClickListener(new View.OnClickListener() {
            // when image button is clicked, take the current value of the counter and increment it by 1 and display the new value
            @Override
            public void onClick(View v) {
                onImageButtonClicked(v);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            // when normal button is clicked, add the value in the edit text to the counter and display the new value
            @Override
            public void onClick(View v) {
                onButtonClicked(v);
            }
        });



    }
}
