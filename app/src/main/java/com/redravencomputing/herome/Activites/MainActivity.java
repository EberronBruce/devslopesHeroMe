package com.redravencomputing.herome.Activites;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.redravencomputing.herome.Fragments.BackstoryFragment;
import com.redravencomputing.herome.Fragments.MainFragment;
import com.redravencomputing.herome.Fragments.PickPowerFragment;
import com.redravencomputing.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener, BackstoryFragment.BackstoryInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new MainFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.fragment_container, fragment);
            transaction.commit();
        }
    }

    public void loadPickPowerScreen(String primaryPower) {

        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        pickPowerFragment.setHowPower(primaryPower);
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, pickPowerFragment).commit()
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();

    }

    public void loadBackstoryScreen(String howPower, String secondPower, int secondPowerId) {

        BackstoryFragment backstoryFragment = new BackstoryFragment();
        backstoryFragment.setHowPower(howPower);
        backstoryFragment.setSecondPower(secondPower);
        backstoryFragment.setSecondPowerId(secondPowerId);

        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,backstoryFragment).addToBackStack(null).commit();

    }

    public void reloadMainScreen() {
        MainFragment mainFragment = new MainFragment();
        this.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,mainFragment).commit();

    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerInteraction(Uri uri) {

    }

    @Override
    public void onBackstoryInteraction(Uri uri) {

    }
}
