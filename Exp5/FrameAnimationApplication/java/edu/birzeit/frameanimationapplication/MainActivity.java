package edu.birzeit.frameanimationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        final ImageView imageView = (ImageView)
                findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionDrawable transitionDrawable = (TransitionDrawable)
                        imageView.getDrawable();
                transitionDrawable.startTransition(1000);

            }
        });



        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionDrawable transitionDrawable = (TransitionDrawable)
                        imageView.getDrawable();
                transitionDrawable.reverseTransition(1000);
            }
        });
    }
}