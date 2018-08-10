package com.soumit.fragmentcomm;

import android.content.Context;
import android.content.Intent;
import android.icu.util.VersionInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";
    FragmentManager fragmentManager;
    Button addA, addB, removeA, removeB, replaceAwithB, replaceBwithA, attachA, detachA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        setupButtons();
    }

    public void setupButtons(){
        addA = findViewById(R.id.add_a);
        addB = findViewById(R.id.add_b);
        removeA = findViewById(R.id.remove_a);
        removeB = findViewById(R.id.remove_b);
        replaceAwithB = findViewById(R.id.replace_a_w_b);
        replaceBwithA = findViewById(R.id.replace_b_w_a);
        attachA = findViewById(R.id.attach_a);
        detachA = findViewById(R.id.detach_a);
        addA.setOnClickListener(this);
        addB.setOnClickListener(this);
        removeA.setOnClickListener(this);
        removeB.setOnClickListener(this);
        replaceAwithB.setOnClickListener(this);
        replaceBwithA.setOnClickListener(this);
        attachA.setOnClickListener(this);
        detachA.setOnClickListener(this);
    }

    public void addA(View v){
        Log.d(TAG, "-----------------------addA: called------------------------------");
        FragmentA f1 = new FragmentA();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.group, f1, "A");
        transaction.commit();
    }
    public void removeA(View v){
        Log.d(TAG, "-----------------------removeA: called------------------------------");
        FragmentA f1 = (FragmentA) fragmentManager.findFragmentByTag("A");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(f1 != null){
            transaction.remove(f1);
            transaction.commit();
        }else {
            Toast.makeText(this, "Fragment A was not added before !", Toast.LENGTH_SHORT).show();
        }
    }
    public void addB(View v){
        Log.d(TAG, "-----------------------addB: called------------------------------");
        FragmentB f2 = new FragmentB();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.group, f2,"B");
        transaction.commit();
    }
    public void removeB(View v){
        Log.d(TAG, "-----------------------removeB: called------------------------------");
        FragmentB f2 = (FragmentB) fragmentManager.findFragmentByTag("B");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(f2 != null){
            transaction.remove(f2);
            transaction.commit();
        }else {
            Toast.makeText(this, "Fragment B was not added before !", Toast.LENGTH_SHORT).show();
        }
    }
    public void replaceAwithB(View v){
        Log.d(TAG, "-----------------------replaceAwithB: called------------------------------");
        FragmentB f2 = new FragmentB();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.group, f2, "B");
        transaction.commit();
    }
    public void replaceBwithA(View v){
        Log.d(TAG, "-----------------------replaceBwithA: called------------------------------");
        FragmentA f1 = new FragmentA();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.group, f1, "A");
        transaction.commit();
    }
  public void attachA(View v){
      Log.d(TAG, "-----------------------attachA: called------------------------------");
      FragmentA f1 = (FragmentA) fragmentManager.findFragmentByTag("A");
      FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
      if(f1 != null){
          transaction.attach(f1);
          transaction.commit();
      }
    }
  public void detachA(View v){
      Log.d(TAG, "-----------------------detachA: called------------------------------");
      FragmentB f1 = (FragmentB) fragmentManager.findFragmentByTag("B");
      FragmentTransaction transaction = fragmentManager.beginTransaction();
      if(f1 != null){
          transaction.detach(f1);
          transaction.commit();
      }
    }


    @Override
    public void onClick(View view) {
        int selectionId = view.getId();
        switch (selectionId){
            case R.id.add_a :
                addA(view);
                break;
            case R.id.add_b:
                addB(view);
                break;
            case R.id.remove_a :
                removeA(view);
                break;
            case R.id.remove_b:
                removeB(view);
                break;
            case R.id.replace_a_w_b:
                replaceAwithB(view);
                break;
            case R.id.replace_b_w_a:
                replaceBwithA(view);
                break;
            case R.id.attach_a:
                attachA(view);
                break;
            case R.id.detach_a:
                detachA(view);
                break;
        }
    }
}

















