package com.dipoletech.basesimulator.classes;/**
 * Created by DABBY(3pleMinds) on 20-Oct-15.
 */

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.dipoletech.basesimulator.R;
/**
 * DABBY(3pleMinds) 20-Oct-15 7:58 AM 2015 10
 * 20 07 58 BaseSimulator
 **/
public class GameModeDialog extends DialogFragment {
    private EditText gameModeText;
    private ImageButton closeButton;
    private Button okButton;

    public GameModeDialog() {
        super();
    }

    public interface GameModeDialogInterface
    {
        void getGameModeString(String text);
    }

    private GameModeDialogInterface mListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.layout_game_mode,container,false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        closeButton = (ImageButton) rootView.findViewById(R.id.close_button);
        okButton = (Button) rootView.findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameModeText.getText().toString().isEmpty())
                {
                   // Toast.makeText(getActivity(),"Input Field is Empty",Toast.LENGTH_LONG).show();
                    gameModeText.setError("Enter a valid Number");
                }
                else {

                    mListener.getGameModeString(gameModeText.getText().toString());
                    dismiss();
                }
            }
        });

        gameModeText = (EditText) rootView.findViewById(R.id.game_mode_text);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return rootView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return super.onCreateDialog(savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            mListener = (GameModeDialogInterface) activity;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()
                    +" Must implement GameModeDialogInterface Listener");
        }
    }
}

