package com.dipoletech.basesimulator;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dipoletech.basesimulator.classes.GameModeDialog;
import com.dipoletech.basesimulator.classes.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private View rootView;
    private ImageButton plusButton,minusButton;
    private Button allOffButton, allOnButton, gameModeButton;
    private Button bitButton1, bitButton2, bitButton3, bitButton4, bitButton5, bitButton6, bitButton7, bitButton8;
    private TextView gameModeStatusTextView,counterTextView;
    private int count;

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8;
    private List<ImageView> images;
    private String gameModeText;

    private boolean gameMode;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        count = 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //grab all the image views
        imageView1 = (ImageView) rootView.findViewById(R.id.img_1);
        imageView1.setTag("off");
        imageView2 = (ImageView) rootView.findViewById(R.id.img_2);
        imageView2.setTag("off");
        imageView3 = (ImageView) rootView.findViewById(R.id.img_4);
        imageView3.setTag("off");
        imageView4 = (ImageView) rootView.findViewById(R.id.img_8);
        imageView4.setTag("off");
        imageView5 = (ImageView) rootView.findViewById(R.id.img_16);
        imageView5.setTag("off");
        imageView6 = (ImageView) rootView.findViewById(R.id.img_32);
        imageView6.setTag("off");
        imageView7 = (ImageView) rootView.findViewById(R.id.img_64);
        imageView7.setTag("off");
        imageView8 = (ImageView) rootView.findViewById(R.id.img_128);
        imageView8.setTag("off");

        //create the array of image Views

        images = new ArrayList();
        images.add(imageView1);
        images.add(imageView2);
        images.add(imageView3);
        images.add(imageView4);
        images.add(imageView5);
        images.add(imageView6);
        images.add(imageView7);
        images.add(imageView8);

        //grab all the bitButtons
        bitButton1 = (Button) rootView.findViewById(R.id.button_128);
        bitButton2 = (Button) rootView.findViewById(R.id.button_64);
        bitButton3 = (Button) rootView.findViewById(R.id.button_32);
        bitButton4 = (Button) rootView.findViewById(R.id.button_16);
        bitButton5 = (Button) rootView.findViewById(R.id.button_8);
        bitButton6 = (Button) rootView.findViewById(R.id.button_4);
        bitButton7 = (Button) rootView.findViewById(R.id.button_2);
        bitButton8 = (Button) rootView.findViewById(R.id.button_1);

        //add listeners to all the bit Buttons
        bitButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapImageView(imageView8);
            }
        });
        bitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapImageView(imageView7);
            }
        });
        bitButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapImageView(imageView6);
            }
        });
        bitButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapImageView(imageView5);
            }
        });
        bitButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapImageView(imageView4);
            }
        });
        bitButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapImageView(imageView3);
            }
        });
        bitButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapImageView(imageView2);
            }
        });
        bitButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapImageView(imageView1);
            }
        });

        allOffButton = (Button) rootView.findViewById(R.id.all_off_button);
        allOnButton = (Button) rootView.findViewById(R.id.all_on_button);
        gameModeButton = (Button) rootView.findViewById(R.id.game_mode_button);

        plusButton = (ImageButton) rootView.findViewById(R.id.plus_button);
        minusButton = (ImageButton) rootView.findViewById(R.id.minus_button);
        gameModeStatusTextView = (TextView) rootView.findViewById(R.id.game_mode_status_text);
        counterTextView = (TextView) rootView.findViewById(R.id.counter_text);

        allOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set all the drawable to green
                   allOn();
            }
        });
        allOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               allOff();
            }
        });

        gameModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showGameModeDialog();
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the maximum is reaches which is 255
                if (count == 255)
                {
                    Snackbar.make(v, "You have reached the maximum which is  255", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                }else {
                    count = count + 1;
                    updateCounterStatus();
                    lightBulbs();
                }

            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the count is zero and ensure that the user does not go below zero
                if (count == 0) {
                    Snackbar.make(v, "You have reached the minimum which is  0", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                } else {
                    count = count - 1;
                    updateCounterStatus();
                    lightBulbs();
                }

            }
        });



        return rootView;
    }

    private void allOff() {
        for (ImageView image : images) {
            image.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.green_light_bulb));
            image.setTag("off");
            counterTextView.setText(String.valueOf(0));
            count = 0;
            gameModeStatusTextView.setText(getActivity().getResources().getString(R.string.game_mode_null));
        }
    }

    private void allOn() {
        for (ImageView image : images) {

            image.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.red_light_bulb));
            image.setTag("on");
        }
    }

    private void showGameModeDialog() {
        GameModeDialog dialog = new GameModeDialog();
        dialog.setCancelable(false);
        dialog.show(getFragmentManager(), "GAME_MODE");
    }

    private void swapImageView(ImageView imageView) {

        if (!(imageView.getTag()=="off"))
        {
            imageView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.green_light_bulb));
            imageView.setTag("off");
        }else {
            imageView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.red_light_bulb));
            imageView.setTag("on");
        }
        if (gameMode)
        {
            gameStart();
        }else {
            //show th user what he has
            displayBinaryValue();
        }
    }

    private void displayBinaryValue() {
        String imagesBinaryMode = Utility.getBinaryStringFromImageView(images);
        //here i will write a function that will convert a binary to decimal Integer

        count = Utility.getDecimalFromBinary(imagesBinaryMode);
        updateCounterStatus();
        gameModeStatusTextView.setText(String.format(getActivity().getResources().getString(R.string.game_mode_text_format),
                count, String.valueOf(imagesBinaryMode)
        ));
    }


    private void lightBulbs() {
        String binaryString = Integer.toBinaryString(count);
        List<Integer> bits = new ArrayList<>(8);
        for (int count = binaryString.length()-1; count >=0; count--)
        {
            int bit = Integer.parseInt(String.valueOf(binaryString.charAt(count)));
            bits.add(bit);
        }
      //  Toast.makeText(getActivity(), bits.size() + " "+ images.size(), Toast.LENGTH_LONG).show();
      // use bits.siz()
        for (int i = bits.size()-1; i>=0; i--)
        {
            if ( bits.get(i) != null && bits.get(i) == 1)
            {
                ImageView currentView = images.get(i);
                currentView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.red_light_bulb));
                currentView.setTag("on");


            }else {
                ImageView currentView = images.get(i);
                currentView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.green_light_bulb));
                currentView.setTag("off");
            }
        }

        displayBinaryValue();
    }

    private void animateBulbs(String biString) {
        List<Integer> bits = new ArrayList<>(8);

        for (int count = biString.length() - 1; count >= 0; count--) {
            int bit = Integer.parseInt(String.valueOf(biString.charAt(count)));
            bits.add(bit);
        }
        //  Toast.makeText(getActivity(), bits.size() + " "+ images.size(), Toast.LENGTH_LONG).show();
        // use bits.siz()
        for (int i = bits.size() - 1; i >= 0; i--) {
            if (bits.get(i) != null && bits.get(i) == 1) {
                ImageView currentView = images.get(i);
                @SuppressWarnings("ResourceType") AnimationDrawable drawable = (AnimationDrawable) getActivity().getResources().getDrawable(R.anim.splash);

                currentView.setImageDrawable(drawable);
                drawable.start();
                currentView.setTag("on");

            } else {
                ImageView currentView = images.get(i);
                currentView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.green_light_bulb));
                currentView.setTag("off");
            }
        }

        displayBinaryValue();
    }


    private void updateCounterStatus() {
        //convert the decimal to binary
        counterTextView.setText(String.valueOf(count));
    }

    public void setGameMode(String text)
    {
        gameModeText = text;
        gameModeStatusTextView.setText(String.format(getActivity().getResources().getString(R.string.game_mode_format), text));
        //Toast.makeText(getActivity(), "text", Toast.LENGTH_LONG).show();
        gameMode = true;

        //once the game mode is set disable plus and minus buttons
        //chang ethe string written in the game mod button to Reset
        //remove the onclick listener and add a new on
        plusButton.setEnabled(false);
        minusButton.setEnabled(false);
        gameModeButton.setText(getActivity().getResources().getString(R.string.string_reset));
        gameModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelGameMode("Game Mode Cancelled");
                allOff();

            }
        });

        //start the game
        //turn all off
        allOff();
        //how do i code the game now
        gameStart();

    }

    private void cancelGameMode(String message) {
        gameMode = false;
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
        gameModeStatusTextView.setText(getActivity().getResources().getString(R.string.game_mode_null));
        gameModeButton.setText(getActivity().getResources().getString(R.string.game_mode));
        plusButton.setEnabled(true);
        minusButton.setEnabled(true);
        gameModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //notify the user
                Snackbar.make(rootView, "Your Game Begins now. Enter the Binary equivalent of " + gameModeText +
                        "Time is 2 min.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                showGameModeDialog();
            }
        });
    }

    private void gameStart() {

        //this game needs the binary value of the game mod
        //this game continuously monitor the small buttons and return the equivalent binary value
        //when this values match  each other, then the game is over
        //time shall be given for every game mode
        String binaryGameModeValue = Integer.toBinaryString(Integer.parseInt(gameModeText));

        //now lets begin coding
        //since i have an array of the image view, i need to get all the tags and arrange it and
        //then compare
        //this helper function will always return a string representing the tags in binary format
        String imagesBinaryMode = Utility.getBinaryStringFromImageView(images);
        //compare the two

        //pad up with zeros
        binaryGameModeValue  = Utility.padUpZeros(binaryGameModeValue);

        //show me what is happening inside the coder, but commented out now
        //Toast.makeText(getActivity(),"Binary Mode: "+ binaryGameModeValue+"Image Mode: "+String.valueOf(imagesBinaryMode),Toast.LENGTH_LONG).show();

        if(binaryGameModeValue.equals(String.valueOf(imagesBinaryMode)))
        {
            //do the animation
            animateBulbs(binaryGameModeValue);
            //animateBulbs(binaryGameModeValue);

            //then game over show the game over dialog
//            GameOverDialog gameOver = new GameOverDialog();
//            gameOver.setCancelable(false);
//            gameOver.show(getFragmentManager().beginTransaction(),"GAME_OVER");




        }


    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            Intent sIntent = new Intent(getActivity(),SettingsActivity.class);
            startActivity(sIntent);

        }
        if (id == R.id.action_b_compute) {
            Intent bIntent = new Intent(getActivity(), BinaryOperationActivity.class);
            startActivity(bIntent);

        }
        return true;
    }


}
