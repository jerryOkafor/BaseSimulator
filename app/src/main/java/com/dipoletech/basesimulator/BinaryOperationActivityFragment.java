package com.dipoletech.basesimulator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dipoletech.basesimulator.classes.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class BinaryOperationActivityFragment extends Fragment {
    //define the constant strings
    private static  final String DIVISION = "division";
    private static  final String MULTIPLICATION = "multiplication";
    private static  final String ADDITION = "addition";
    private static  final String SUBTRACTION = "subtraction";
    private static  final String NOP = "nop";


    private View rootView;
    List<ImageView> firstOperandImages;
    List<ImageView> secondOperandImages;
    List<ImageView> answerImages;
    
    ImageView firstOperandImage1, firstOperandImage2, firstOperandImage3, firstOperandImage4, firstOperandImage5,
            firstOperandImage6, firstOperandImage7, firstOperandImage8;

    ImageView secondOperandImage1, secondOperandImage2, secondOperandImage3, secondOperandImage4, secondOperandImage5,
            secondOperandImage6, secondOperandImage7, secondOperandImage8;
    ImageView answerImage1, answerImage2, answerImage3, answerImage4, answerImage5, answerImage6, answerImage7,
                answerImage8;

    private CheckBox checkBox1,checkBox2;

    private Button bitButton1, bitButton2, bitButton3, bitButton4, bitButton5, bitButton6, bitButton7, bitButton8;

    private ImageButton divideButton,multiplyButton,plusButton,subtractButton;

    private Button resetButton, executeButton;
    private String currentOperation;
    private String operandString1, operandString2,answerString;
    private String currentOperationString;
    private TextView operationTextView;

    public BinaryOperationActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initialize all the image arrays we need
        firstOperandImages = new ArrayList<>();
        secondOperandImages = new ArrayList<>();
        answerImages = new ArrayList<>();

        answerString = "00000000";
        currentOperation = NOP;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_binary_operation, container, false);
        operationTextView = (TextView) rootView.findViewById(R.id.operation_status_text);
        //grab all the checkbox
        checkBox1 = (CheckBox) rootView.findViewById(R.id.operand1_checkBox);
        checkBox2 = (CheckBox) rootView.findViewById(R.id.operand2_checkBox);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox2.setChecked(false);
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(false);
            }
        });


        //garb all the first row image views
        firstOperandImage1 = (ImageView) rootView.findViewById(R.id.operand1_img_1);
        firstOperandImage1.setTag("off");
        
        firstOperandImage2 = (ImageView) rootView.findViewById(R.id.operand1_img_2);
        firstOperandImage2.setTag("off");
        
        firstOperandImage3 = (ImageView) rootView.findViewById(R.id.operand1_img_4);
        firstOperandImage3.setTag("off");
        
        firstOperandImage4 = (ImageView) rootView.findViewById(R.id.operand1_img_8);
        firstOperandImage4.setTag("off");
        
        firstOperandImage5 = (ImageView) rootView.findViewById(R.id.operand1_img_16);
        firstOperandImage5.setTag("off");
        
        firstOperandImage6 = (ImageView) rootView.findViewById(R.id.operand1_img_32);
        firstOperandImage6.setTag("off");
        
        firstOperandImage7 = (ImageView) rootView.findViewById(R.id.operand1_img_64);
        firstOperandImage7.setTag("off");
        
        firstOperandImage8 = (ImageView) rootView.findViewById(R.id.operand1_img_128);
        firstOperandImage8.setTag("off");
        
        //this image id for the second roe operand
        secondOperandImage1 = (ImageView) rootView.findViewById(R.id.operand2_img_1);
        secondOperandImage1.setTag("off");

        secondOperandImage2 = (ImageView) rootView.findViewById(R.id.operand2_img_2);
        secondOperandImage2.setTag("off");

        secondOperandImage3 = (ImageView) rootView.findViewById(R.id.operand2_img_4);
        secondOperandImage3.setTag("off");

        secondOperandImage4 = (ImageView) rootView.findViewById(R.id.operand2_img_8);
        secondOperandImage4.setTag("off");

        secondOperandImage5 = (ImageView) rootView.findViewById(R.id.operand2_img_16);
        secondOperandImage5.setTag("off");

        secondOperandImage6 = (ImageView) rootView.findViewById(R.id.operand2_img_32);
        secondOperandImage6.setTag("off");

        secondOperandImage7 = (ImageView) rootView.findViewById(R.id.operand2_img_64);
        secondOperandImage7.setTag("off");

        secondOperandImage8 = (ImageView) rootView.findViewById(R.id.operand2_img_128);
        secondOperandImage8.setTag("off");


        //answer images begins
        answerImage1 = (ImageView) rootView.findViewById(R.id.answer_img_1);
        answerImage1.setTag("off");

        answerImage2 = (ImageView) rootView.findViewById(R.id.answer_img_2);
        answerImage2.setTag("off");

        answerImage3 = (ImageView) rootView.findViewById(R.id.answer_img_4);
        answerImage3.setTag("off");

        answerImage4 = (ImageView) rootView.findViewById(R.id.answer_img_8);
        answerImage4.setTag("off");

        answerImage5 = (ImageView) rootView.findViewById(R.id.answer_img_16);
        answerImage5.setTag("off");

        answerImage6 = (ImageView) rootView.findViewById(R.id.answer_img_32);
        answerImage6.setTag("off");

        answerImage7 = (ImageView) rootView.findViewById(R.id.answer_img_64);
        answerImage7.setTag("off");

        answerImage8 = (ImageView) rootView.findViewById(R.id.answer_img_128);
        answerImage8.setTag("off");


        //start adding all the image arrays
        firstOperandImages.add(firstOperandImage1);
        firstOperandImages.add(firstOperandImage2);
        firstOperandImages.add(firstOperandImage3);
        firstOperandImages.add(firstOperandImage4);
        firstOperandImages.add(firstOperandImage5);
        firstOperandImages.add(firstOperandImage6);
        firstOperandImages.add(firstOperandImage7);
        firstOperandImages.add(firstOperandImage8);

        //adding second operand images
        secondOperandImages.add(secondOperandImage1);
        secondOperandImages.add(secondOperandImage2);
        secondOperandImages.add(secondOperandImage3);
        secondOperandImages.add(secondOperandImage4);
        secondOperandImages.add(secondOperandImage5);
        secondOperandImages.add(secondOperandImage6);
        secondOperandImages.add(secondOperandImage7);
        secondOperandImages.add(secondOperandImage8);

        //adding the answer images
        answerImages.add(answerImage1);
        answerImages.add(answerImage2);
        answerImages.add(answerImage3);
        answerImages.add(answerImage4);
        answerImages.add(answerImage5);
        answerImages.add(answerImage6);
        answerImages.add(answerImage7);
        answerImages.add(answerImage8);


        //grab all the bitButtons
        bitButton1 = (Button) rootView.findViewById(R.id.button_128);
        bitButton2 = (Button) rootView.findViewById(R.id.button_64);
        bitButton3 = (Button) rootView.findViewById(R.id.button_32);
        bitButton4 = (Button) rootView.findViewById(R.id.button_16);
        bitButton5 = (Button) rootView.findViewById(R.id.button_8);
        bitButton6 = (Button) rootView.findViewById(R.id.button_4);
        bitButton7 = (Button) rootView.findViewById(R.id.button_2);
        bitButton8 = (Button) rootView.findViewById(R.id.button_1);

        bitButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked())
                {
                    swapImageView(firstOperandImage8);
                } else if(checkBox2.isChecked())
                {

                    swapImageView(secondOperandImage8);
                }
            }
        });
        bitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    swapImageView(firstOperandImage7);
                } else if (checkBox2.isChecked()) {

                    swapImageView(secondOperandImage7);
                }
            }
        });

        bitButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    swapImageView(firstOperandImage6);
                } else if (checkBox2.isChecked()) {

                    swapImageView(secondOperandImage6);
                }
            }
        });

        bitButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    swapImageView(firstOperandImage5);
                } else if (checkBox2.isChecked()) {

                    swapImageView(secondOperandImage5);
                }
            }
        });
        bitButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    swapImageView(firstOperandImage4);
                } else if (checkBox2.isChecked()) {

                    swapImageView(secondOperandImage4);
                }
            }
        });

        bitButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    swapImageView(firstOperandImage3);
                } else if (checkBox2.isChecked()) {

                    swapImageView(secondOperandImage3);
                }
            }
        });

        bitButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    swapImageView(firstOperandImage2);
                } else if (checkBox2.isChecked()) {

                    swapImageView(secondOperandImage2);
                }
            }
        });

        bitButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    swapImageView(firstOperandImage1);
                } else if (checkBox2.isChecked()) {

                    swapImageView(secondOperandImage1);
                }
            }
        });


        divideButton = (ImageButton) rootView.findViewById(R.id.division_button);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation = DIVISION;
                execute();

            }
        });

        multiplyButton = (ImageButton) rootView.findViewById(R.id.multiplication_button);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation = MULTIPLICATION;
                execute();
            }
        });

        plusButton = (ImageButton) rootView.findViewById(R.id.addition_button);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation = ADDITION;
                execute();
            }
        });


        subtractButton = (ImageButton) rootView.findViewById(R.id.subtraction_button);
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation = SUBTRACTION;
                execute();
            }
        });

        resetButton = (Button) rootView.findViewById(R.id.button_reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOperation = NOP;
                allOff(firstOperandImages);
                allOff(secondOperandImages);
                allOff(answerImages);
                checkBox2.setChecked(false);
                checkBox1.setChecked(false);

            }
        });
        executeButton = (Button) rootView.findViewById(R.id.execute_button);
        executeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               execute();
            }
        });



        return rootView;
    }

    private void execute() {

        //get all the strings
        operandString1 = Utility.getBinaryStringFromImageView(firstOperandImages);
        operandString2 = Utility.getBinaryStringFromImageView(secondOperandImages);

        //lightBulbs(operandString2);
        switch (currentOperation) {
            case NOP: //current operation holder is null
            {
                answerString = Utility.padUpZeros("0");
                break;
            }
            case MULTIPLICATION: //current operation is set tp *
            {
                //this string shall be formatted soon
                answerString = Utility.multiplyBinaryStrings(operandString1, operandString2);
                currentOperationString = String.format(getActivity().getResources().getString(
                        R.string.current_operation_text_format), operandString1, " * ", operandString2, answerString);
                break;

            }
            case DIVISION: {
                answerString = Utility.divideBinaryStrings(operandString1, operandString2);
                currentOperationString = String.format(getActivity().getResources().getString(
                                R.string.current_operation_text_format), operandString1,
                        getActivity().getResources().getString(
                                R.string.division_sign), operandString2, answerString);
                break;
            }
            case ADDITION: {
                answerString = Utility.addTwoBinaryStrings(operandString1, operandString2);
                currentOperationString = String.format(getActivity().getResources().getString(
                                R.string.current_operation_text_format), operandString1,
                        getActivity().getResources().getString(
                                R.string.plus_sign), operandString2, answerString);
                break;
            }
            case SUBTRACTION: {
                answerString = Utility.subtractTwoBinaryStrings(operandString1, operandString2);
                currentOperationString = String.format(getActivity().getResources().getString(
                        R.string.current_operation_text_format), operandString1, "-", operandString2, answerString);
                break;
            }
            default: {
                currentOperationString = "Some things are not right.";
            }
        }


        lightBulbs(answerString);

    }

    private void allOff(List<ImageView> images) {
        for (ImageView image : images) {
            image.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.green_light_bulb));
            image.setTag("off");
//            counterTextView.setText(String.valueOf(0));
//            count = 0;
//            gameModeStatusTextView.setText(getActivity().getResources().getString(R.string.game_mode_null));
        }
    }


    private void swapImageView(ImageView imageView) {

        if (!(imageView.getTag() == "off")) {
            imageView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.green_light_bulb));
            imageView.setTag("off");
        } else {
            imageView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.red_light_bulb));
            imageView.setTag("on");
        }



    }

    private void lightBulbs(String binaryString) {
        List<Integer> bits = new ArrayList<>(8);
        for (int count = binaryString.length() - 1; count >= 0; count--) {
            int bit = Integer.parseInt(String.valueOf(binaryString.charAt(count)));
            bits.add(bit);
        }

        //  Toast.makeText(getActivity(), bits.size() + " "+ images.size(), Toast.LENGTH_LONG).show();

        //use bits.siz()
        for (int i = bits.size() - 1; i >= 0; i--) {
            if (bits.get(i) != null && bits.get(i) == 1) {
                ImageView currentView = answerImages.get(i);
                currentView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.red_light_bulb));
                currentView.setTag("on");

            } else {
                ImageView currentView = answerImages.get(i);
                currentView.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.green_light_bulb));
                currentView.setTag("off");

            }
        }

        displayOperationValue();
    }

    private void displayOperationValue() {

        operationTextView.setText(currentOperationString);
    }

}
