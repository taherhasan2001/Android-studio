package edu.birzeit.fragmentssecondapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;
    FirstFragment firstFragment;
    SecondFragment secondFragment;

    boolean firstIs_firstFragment = false;
    boolean firstIs_secondFragment = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSWAP = findViewById(R.id.swab_button);
        Button buttonAddF1 = findViewById(R.id.add_f1);
        Button buttonRmF1 = findViewById(R.id.rm_f1);
        Button buttonAttachF1 = findViewById(R.id.attach_f1);
        Button buttonDetachF1 = findViewById(R.id.detach_f1);
        Button buttonAddF2 = findViewById(R.id.add_f2);
        Button buttonRmF2 = findViewById(R.id.rm_f2);
        Button buttonAttachF2 = findViewById(R.id.attach_f2);
        Button buttonDetachF2 = findViewById(R.id.detach_f2);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        buttonAddF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment existingFragment = fragmentManager.findFragmentByTag("FirstFrag");
                if (existingFragment == null) {
                    if (fragmentTransaction == null || !fragmentTransaction.isEmpty()) {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        firstFragment = new FirstFragment();
                        fragmentTransaction.add(R.id.root_layout, firstFragment, "FirstFrag");
                        fragmentTransaction.commit();

                        // Reset fragmentTransaction after commit
                        fragmentTransaction = null;
                        if (!firstIs_secondFragment) // if the second is not exist make this on the top
                            firstIs_firstFragment = true;
                    }
                }
            }
        });

        buttonRmF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment existingFragment = fragmentManager.findFragmentByTag("FirstFrag");
                if (existingFragment != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.remove(existingFragment);
                    fragmentTransaction.commitAllowingStateLoss();
                    if(firstIs_firstFragment) { // remove from the top if second exist it will be on the top
                            firstIs_firstFragment = false;
                            Fragment testFragment = fragmentManager.findFragmentByTag("SecondFrag");
                        if (testFragment != null){
                            firstIs_secondFragment = true;
                        }
                    }
                }
            }
        });

        buttonAttachF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstFragment != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.attach(firstFragment);
                    fragmentTransaction.commit();
                    if (!firstIs_secondFragment) // if the second is not exist make this on the top
                        firstIs_firstFragment = true;
                }
            }
        });

        buttonDetachF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstFragment != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.detach(firstFragment);
                    fragmentTransaction.commit();
                    if(firstIs_firstFragment) { // remove from the top if second exist it will be on the top
                        firstIs_firstFragment = false;
                        Fragment testFragment = fragmentManager.findFragmentByTag("SecondFrag");
                        if (testFragment != null){
                            firstIs_secondFragment = true;
                        }
                    }

                }
            }
        });

        buttonAddF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment existingFragment = fragmentManager.findFragmentByTag("SecondFrag");
                if (existingFragment == null) {
                    if (fragmentTransaction == null || !fragmentTransaction.isEmpty()) {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        secondFragment = new SecondFragment(); // Replace with the appropriate fragment class
                        fragmentTransaction.add(R.id.root_layout, secondFragment, "SecondFrag");
                        fragmentTransaction.commit();

                        // Reset fragmentTransaction after commit
                        fragmentTransaction = null;
                        if (!firstIs_firstFragment) // if the second is not exist make this on the top
                            firstIs_secondFragment = true;
                    }
                }
            }
        });

        buttonRmF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment existingFragment = fragmentManager.findFragmentByTag("SecondFrag");
                if (existingFragment != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.remove(existingFragment);
                    fragmentTransaction.commitAllowingStateLoss();

                    if(firstIs_secondFragment) { // remove from the top if second exist it will be on the top
                        firstIs_secondFragment = false;
                        Fragment testFragment = fragmentManager.findFragmentByTag("SecondFrag");
                        if (testFragment != null){
                            firstIs_firstFragment = true;
                        }
                    }
                }
            }
        });

        buttonAttachF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondFragment != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.attach(secondFragment);
                    fragmentTransaction.commit();
                    if (!firstIs_firstFragment) // if the second is not exist make this on the top
                        firstIs_secondFragment = true;
                }
            }
        });

        buttonDetachF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (secondFragment != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.detach(secondFragment);
                    fragmentTransaction.commit();

                    if(firstIs_secondFragment) { // remove from the top if second exist it will be on the top
                        firstIs_secondFragment = false;
                        Fragment testFragment = fragmentManager.findFragmentByTag("SecondFrag");
                        if (testFragment != null){
                            firstIs_firstFragment = true;
                        }
                    }
                }
            }
        });

        buttonSWAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment existingFragment1 = fragmentManager.findFragmentByTag("FirstFrag");
                Fragment existingFragment2 = fragmentManager.findFragmentByTag("SecondFrag");

                if (existingFragment1 != null && existingFragment2 != null) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                    if (firstIs_firstFragment) {
                        fragmentTransaction.replace(R.id.root_layout, secondFragment, "SecondFrag");
                        fragmentTransaction.replace(R.id.root_layout, firstFragment, "FirstFrag");
                        firstIs_firstFragment = false;
                        firstIs_secondFragment = true;
                    } else {
                        fragmentTransaction.replace(R.id.root_layout, firstFragment, "FirstFrag");
                        fragmentTransaction.replace(R.id.root_layout, secondFragment, "SecondFrag");
                        firstIs_firstFragment = true;
                        firstIs_secondFragment = false;
                    }

                    fragmentTransaction.commit();
                }
            }
        });

    }
}
