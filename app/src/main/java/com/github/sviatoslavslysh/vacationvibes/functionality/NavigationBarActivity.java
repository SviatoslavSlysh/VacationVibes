package com.github.sviatoslavslysh.vacationvibes.functionality;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.github.sviatoslavslysh.vacationvibes.R;
import com.github.sviatoslavslysh.vacationvibes.functionality.fragment.HistoryFragment;
import com.github.sviatoslavslysh.vacationvibes.functionality.fragment.HomeFragment;
import com.github.sviatoslavslysh.vacationvibes.functionality.fragment.ProfileFragment;
import com.github.sviatoslavslysh.vacationvibes.functionality.fragment.TutorialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.*;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;

public class NavigationBarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if (!tutorialdone.exists()) {
//            AlertDialog.Builder tutorial1 = new AlertDialog.Builder(NavigationBarActivity.this);
//            tutorial1.setMessage("test");
//            tutorial1.setTitle("test");
//            AlertDialog alertDialog = tutorial1.create();
//            alertDialog.show();
//        }
//        i want to put this to be its own fragment (TutorialFragment) but am having issues with it
//        commented out for now
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbar);

        BottomNavigationView navView = findViewById(R.id.navbar);
        navView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.navigation_profile) {
                selectedFragment = new ProfileFragment();
            } else if (itemId == R.id.navigation_history) {
                selectedFragment = new HistoryFragment();
            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            return true;
        });
        File tutorialdone = new File(getCacheDir(),"tutorialcompleted");
        if (!tutorialdone.exists()) {
            MaterialTapTargetPrompt.Builder tutorial1 = new MaterialTapTargetPrompt.Builder(NavigationBarActivity.this);
            tutorial1.setTarget(R.id.navigation_home);
            tutorial1.setPrimaryText("Home Page");
            tutorial1.setSecondaryText("This is the Home Page. this is sample text" +
                    "i cant think of what to type here right now but i will fill it out later" +
                    "test text");
            MaterialTapTargetPrompt test = tutorial1.create();
            test.show();
        }



        if (savedInstanceState == null) {
            navView.setSelectedItemId(R.id.navigation_home); // Задайте активный элемент по умолчанию
        }
    }

}
