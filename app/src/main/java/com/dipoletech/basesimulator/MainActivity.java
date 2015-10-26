package com.dipoletech.basesimulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dipoletech.basesimulator.classes.GameModeDialog;

public class MainActivity extends AppCompatActivity implements GameModeDialog.GameModeDialogInterface
            {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void getGameModeString(String text) {
        MainActivityFragment frag =(MainActivityFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (frag!=null)
        {
            frag.setGameMode(text);
        }

    }

}
