package com.leacuke.android.modernartui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;


public class ModernActivity extends ActionBarActivity {

    FrameLayout frameOne;
    FrameLayout frameTwo;
    FrameLayout frameThree;
    FrameLayout frameFour;
    FrameLayout frameFive;
    FrameLayout frameSix;
    FrameLayout frameSeven;
    SeekBar seekBar;

//    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_modern);
        setContentView(R.layout.fragment_modern);

        initialize();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Random rnd = new Random();
                frameOne.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                frameTwo.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                frameThree.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                frameFour.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                frameFive.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                frameSeven.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));

                switch (progress) {
                    case 0:
                        initializeColors();
                        Toast.makeText(getApplicationContext(), "Colors have been reset!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "All non-white rectangles are changing colors.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initialize() {

        frameOne = (FrameLayout) findViewById(R.id.frameOne);
        frameTwo = (FrameLayout) findViewById(R.id.frameTwo);
        frameThree = (FrameLayout) findViewById(R.id.frameThree);
        frameFour = (FrameLayout) findViewById(R.id.frameFour);
        frameFive = (FrameLayout) findViewById(R.id.frameFive);
        frameSix = (FrameLayout) findViewById(R.id.frameSix);
        frameSeven = (FrameLayout) findViewById(R.id.frameSeven);
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
    }

    // set original colors back
    private void initializeColors() {

        frameOne.setBackgroundColor(Color.parseColor("#ff0bffb9"));
        frameTwo.setBackgroundColor(Color.parseColor("#ffff0e0d"));
        frameThree.setBackgroundColor(Color.parseColor("#ffffb60b"));
        frameFour.setBackgroundColor(Color.parseColor("#ff3bff23"));
        frameFive.setBackgroundColor(Color.parseColor("#fffaff6d"));
//        frameSix.setBackgroundColor(Color.parseColor("#044bf972"));
        frameSeven.setBackgroundColor(Color.parseColor("#ff3452ff"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modern, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                showDialog();
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    void showDialog() {
        MyDialogFragment myDiag = new MyDialogFragment();
        myDiag.show(getSupportFragmentManager(), "Diag");
    }


}
