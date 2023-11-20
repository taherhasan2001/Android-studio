package com.example.customerlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout secondLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        LinearLayout firstLinearLayout=new LinearLayout(this);
        Button addButton =new Button(this);
        secondLinearLayout=new LinearLayout(this);
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



//
//        for(Customer objCustomer : Customer.customersArrayList) {
//            TextView txtCustomerInfo = new TextView(this) ;
//            txtCustomerInfo.setTextAppearance(androidx.appcompat.R.style.TextAppearance_AppCompat_Display2);
//            txtCustomerInfo.setText(objCustomer.toString());
//            secondLinearLayout .addView(txtCustomerInfo);
//        }

    }

    protected void onResume() {
        super.onResume();
        DataBaseHelper dataBaseHelper =new
                DataBaseHelper(MainActivity.this,"EXP4", null,1);
        Cursor allCustomersCursor = dataBaseHelper.getAllCustomers();
        secondLinearLayout.removeAllViews();
        while (allCustomersCursor.moveToNext()){
            TextView textView =new TextView(MainActivity.this);
            textView.setText(
                    "Id= "+allCustomersCursor.getString(0)
                            +"\nName= "+allCustomersCursor.getString(1)
                            +"\nPhone= "+allCustomersCursor.getString(2)
                            +"\nGender= "+allCustomersCursor.getString(3)
                            +"\n\n"
            );
            secondLinearLayout.addView(textView);
        }
    }
}