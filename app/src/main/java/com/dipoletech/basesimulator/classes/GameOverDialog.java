package com.dipoletech.basesimulator.classes;/**
 * Created by DABBY(3pleMinds) on 21-Oct-15.
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
import android.widget.ImageButton;

import com.dipoletech.basesimulator.R;

/**
 * DABBY(3pleMinds) 21-Oct-15 4:24 AM 2015 10
 * 21 04 24 BaseSimulator
 **/
public class GameOverDialog extends DialogFragment
    {
        private View rootView;
        private ImageButton closeButton;

        public GameOverDialog() {
            super();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
             super.onCreateView(inflater, container, savedInstanceState);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            rootView = inflater.inflate(R.layout.game_over,container,false);
                    closeButton = (ImageButton) rootView.findViewById(R.id.close_button);
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
        }
    }

