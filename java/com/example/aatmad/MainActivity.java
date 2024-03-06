package com.example.aatmad;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_home) {
                    // Redirect to the MainActivity (Home)
                    // If needed, you can add additional logic or simply finish()
                    // the current fragment transactions to go back to the main activity.
                    getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    return true;
                } else if (itemId == R.id.action_recycling_tips) {
                    replaceFragment(new RecyclingTipsFragment());
                    return true;
                } else if (itemId == R.id.action_profile) {
                    replaceFragment(new ProfileFragment());
                    return true;
                }
                return false;
            }
        });

        // Set the default fragment
        replaceFragment(new RecyclingTipsFragment());

        // Set click listeners for grid layout items
        setGridItemClickListeners();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(android.R.id.content, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void setGridItemClickListeners() {
        findViewById(R.id.cardView1).setOnClickListener(view -> {
            // Redirect to Find Nearest Dustbins page
            replaceFragment(new FindDustbinsFragment());
        });

        findViewById(R.id.cardView2).setOnClickListener(view -> {
            // Redirect to Recycling Tips page
            replaceFragment(new RecyclingTipsFragment());
        });

        findViewById(R.id.cardView3).setOnClickListener(view -> {
            // Redirect to Rewards page
            replaceFragment(new RewardsFragment());
        });

        findViewById(R.id.cardView4).setOnClickListener(view -> {
            // Redirect to Segregation Process page
            replaceFragment(new SegregationProcessFragment());
        });
    }
}
