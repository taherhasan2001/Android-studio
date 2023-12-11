package edu.birzeit.sharedpreferencesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextUserName;
    EditText editTextPassword;
    Button buttonSave;
    Button buttonGoToSecondActivity;
    SharedPrefManager sharedPrefManager;
    Intent intent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_application);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editText_password);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonGoToSecondActivity = (Button) findViewById(R.id.buttonGoToSecondActivity);
        sharedPrefManager =SharedPrefManager.getInstance(this);
        intent = new Intent(MainActivity.this,SecondActivity.class);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPrefManager.writeString("userName",editTextUserName.getText().toString());

                sharedPrefManager.writeString("password",editTextPassword.getText().toString());
                Toast.makeText(MainActivity.this, "Values written to shared Preferences",
                        Toast.LENGTH_SHORT).show();
            }
        });
        buttonGoToSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });
    }

}