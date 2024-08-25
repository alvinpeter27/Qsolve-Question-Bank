package com.example.qsolve;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView homeMenu;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private Button Mechanical_sample_button;

    private Button civil_samplePage_button;

    private Button computer_samplePage_button;

    private AppCompatButton buy_button1,buy_button2,buy_button3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize views using findViewById
        homeMenu = view.findViewById(R.id.home_menu);
        drawerLayout = view.findViewById(R.id.drawer_layout);
        navigationView = view.findViewById(R.id.nav_view);
        Mechanical_sample_button=view.findViewById(R.id.Mechanical_sample_button);
        civil_samplePage_button=view.findViewById(R.id.civil_samplePage_button);
        computer_samplePage_button=view.findViewById(R.id.computer_samplePage_button);
        AppCompatButton viewSyllabusButton=view.findViewById(R.id.view_syllabus);
        buy_button1=view.findViewById(R.id.buy_button1);
        buy_button2=view.findViewById(R.id.buy_button2);
        buy_button3=view.findViewById(R.id.buy_button3);


        buy_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Buy_Computer_Fragment());
            }
        });

        buy_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadFragment(new Buy_Civil_Fragment());              //   civil buy button

            }
        });



        buy_button1.setOnClickListener(new View.OnClickListener() {            //mechanical buy now button
            @Override
            public void onClick(View v) {

                loadFragment(new Buy_Mechanical_Fragment());

            }
        });

        viewSyllabusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogFragment bottomSheetDialogFragment=new com.example.qsolve.BottomSheetDialogFragment();
                bottomSheetDialogFragment.show(getChildFragmentManager(),"BottomSheetDialogFragment");
            }
        });

        // Set NavigationItemSelectedListener
        navigationView.setNavigationItemSelectedListener(this);
        homeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {           //navigation drawer
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        Mechanical_sample_button.setOnClickListener(new View.OnClickListener() {               //mechanical sample page button
            @Override
            public void onClick(View v) {

                loadFragment(new Mechanical_SamplePage_Fragment());
            }
        });

        civil_samplePage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Civil_samplepageFragment2());

            }
        });

        computer_samplePage_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Computer_samplePage_Fragment());
            }
        });




        // Load the default fragment
        if (savedInstanceState == null) {
            loadFragment(new DefaultFragment());
        }

        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {          //navigation drawer item click
        Fragment fragment = null;
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            fragment = new HomeFragment();
        } else if (itemId == R.id.nav_person) {
            fragment = new My_profileFragment();
        } else if (itemId == R.id.nav_about) {
            fragment = new aboutFragment();
        } else if (itemId == R.id.nav_change_password) {
            fragment = new changePassword_Fragment();
        } else if (itemId == R.id.logout_nav) {
            // Handle logout
            logout();
            return true;
        }

        if (fragment != null) {
            loadFragment(fragment);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (currentFragment != null) {
            fragmentTransaction.remove(currentFragment);
        }
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void logout() {
        // Redirect to MainActivity and clear the activity stack
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);  //logout item
        startActivity(intent);
        if (getActivity() != null) {
            getActivity().finish();
        }
    }
}
