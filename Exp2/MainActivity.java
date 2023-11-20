package edu.birzeit.customerlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        LinearLayout firstLinearLayout=new LinearLayout(this);
        Button addButton =new Button(this);
        LinearLayout secondLinearLayout=new LinearLayout(this);
        ScrollView scrollView=new ScrollView(this);
        firstLinearLayout.setOrientation(LinearLayout.VERTICAL);
        secondLinearLayout.setOrientation(LinearLayout.VERTICAL);
        addButton.setText("Add Customer");
        addButton.setLayoutParams(new
                LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup
                .LayoutParams.WRAP_CONTENT));
        firstLinearLayout.addView(addButton);
        scrollView.addView(secondLinearLayout);
        firstLinearLayout.addView(scrollView);
        setContentView(firstLinearLayout);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new
                        Intent(MainActivity.this,AddCustomerActivity.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });
        for(Customer objCustomer : Customer.customersArrayList) {
            TextView txtCustomerInfo = new TextView(this) ;
            txtCustomerInfo.setTextAppearance(androidx.appcompat.R.style.TextAppearance_AppCompat_Display2);
            txtCustomerInfo.setText(objCustomer.toString());
            secondLinearLayout .addView(txtCustomerInfo);
        }

    }
}