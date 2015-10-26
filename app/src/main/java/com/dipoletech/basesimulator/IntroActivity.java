package com.dipoletech.basesimulator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.dipoletech.basesimulator.IntroSlides.FirstSlide;
import com.github.paolorotolo.appintro.AppIntro;

public class IntroActivity extends AppIntro {


    private SharedPreferences sharedPreferences;
    private static final String MY_PREFS = "my_pref";
    private static final String FirstTime = "first_timr";

    @Override
    public void init(Bundle savedInstanceState) {
        sharedPreferences = getSharedPreferences(MY_PREFS, this.MODE_PRIVATE);
        boolean timeS = sharedPreferences.getBoolean(FirstTime, false);
        if (!timeS) {
            //make changes here

            // Add your slides fragments here
            // AppIntro will automatically generate the dots indicator and buttons.
            addSlide(new FirstSlide());
//            addSlide(new SecondSlide());
//            addSlide(new ThirdSlide());
//            addSlide(new FourthSlide());
//            addSlide(new FifthSlide());

            // Instead of fragments, you can also use our default slide
            // Just set a title, description, background and image. AppIntro will do the rest
            // addSlide(AppIntroFragment.newInstance("First Slide","Welcome",R.drawable.ic_done_white_24px,2));

            // OPTIONAL METHODS
            // Override bar/separator color
            // setBarColor(Color.parseColor("#3F51B5"));
            // setSeparatorColor(Color.parseColor("#2196F3"));


            // Hide Skip/Done button
            showSkipButton(true);
            showDoneButton(true);

            // Turn vibration on and set intensity
            // NOTE: you will probably need to ask VIBRATE permission in Manifest
            setVibrate(true);
            setVibrateIntensity(30);

        } else {
            launchMainActivity();
        }


    }

    @Override
    public void onSkipPressed() {
        launchMainActivity();

    }

    @Override
    public void onDonePressed() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(FirstTime, true);
        editor.commit();
        launchMainActivity();

    }

    private void launchMainActivity() {
        Intent mIntent = new Intent(this,MainActivity.class);
        startActivity(mIntent);
        finish();

    }
}
