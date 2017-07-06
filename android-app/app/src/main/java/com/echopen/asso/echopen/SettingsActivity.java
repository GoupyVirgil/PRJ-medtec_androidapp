package com.echopen.asso.echopen;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class SettingsActivity extends Activity implements View.OnClickListener {
    String SEXE;
    String MORPHOLOGIE;
    String AGE;
    String ORGANE;
    ArrayList<ImageButton> sexe_buttons = new ArrayList<>();
    ArrayList<ImageButton> morphologie_buttons = new ArrayList<>();
    ArrayList<ImageButton> organe_buttons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageButton start_button = (ImageButton) findViewById(R.id.scan_start_button);

        ImageButton woman_button = (ImageButton) findViewById(R.id.button_woman);
        ImageButton man_button = (ImageButton) findViewById(R.id.button_man);

        ImageButton heart_button = (ImageButton) findViewById(R.id.button_heart);
        ImageButton stomac_button = (ImageButton) findViewById(R.id.button_stomac);
        ImageButton lung_button = (ImageButton) findViewById(R.id.button_lung);
        ImageButton foetus_button = (ImageButton) findViewById(R.id.button_foetus);
        ImageButton vessie_button = (ImageButton) findViewById(R.id.button_vessie);

        ImageButton ecto_button = (ImageButton) findViewById(R.id.button_ecto);
        ImageButton meso_button = (ImageButton) findViewById(R.id.button_meso);
        ImageButton endo_button = (ImageButton) findViewById(R.id.button_endo);

        // ********* add buttons to ArrayList to set state ********* //
        sexe_buttons.add(woman_button);
        sexe_buttons.add(man_button);

        organe_buttons.add(heart_button);
        organe_buttons.add(stomac_button);
        organe_buttons.add(lung_button);
        organe_buttons.add(foetus_button);
        organe_buttons.add(vessie_button);

        morphologie_buttons.add(ecto_button);
        morphologie_buttons.add(meso_button);
        morphologie_buttons.add(endo_button);


        // ********* set listeners ********* //
        start_button.setOnClickListener(this);

        woman_button.setOnClickListener(this);
        man_button.setOnClickListener(this);

        heart_button.setOnClickListener(this);
        stomac_button.setOnClickListener(this);
        lung_button.setOnClickListener(this);
        foetus_button.setOnClickListener(this);
        vessie_button.setOnClickListener(this);

        ecto_button.setOnClickListener(this);
        meso_button.setOnClickListener(this);
        endo_button.setOnClickListener(this);

        // ********* style TextView ********* //
        TextView title = (TextView) findViewById(R.id.title);
        TextView settings_subtitle1 = (TextView) findViewById(R.id.settings_subtitle1);
        TextView settings_subtitle2 = (TextView) findViewById(R.id.settings_subtitle2);
        TextView settings_subtitle3 = (TextView) findViewById(R.id.settings_subtitle3);
        TextView settings_subtitle4 = (TextView) findViewById(R.id.settings_subtitle4);
        TextView settings_radio1 = (TextView) findViewById(R.id.radio_input_text1);
        TextView settings_radio2 = (TextView) findViewById(R.id.radio_input_text2);
        TextView settings_radio3 = (TextView) findViewById(R.id.radio_input_text3);

        setFont(title,"Moderat-Bold.ttf");
        setFont(settings_subtitle1,"Moderat-Bold.ttf");
        setFont(settings_subtitle2,"Moderat-Bold.ttf");
        setFont(settings_subtitle3,"Moderat-Bold.ttf");
        setFont(settings_subtitle4,"Moderat-Bold.ttf");
        setFont(settings_radio1,"Avernir-Book.ttf");
        setFont(settings_radio2,"Avernir-Book.ttf");
        setFont(settings_radio3,"Avernir-Book.ttf");
    }

    // ********* click switch case ********* //
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.scan_start_button:
                startActivity(new Intent( this, ScanActivity.class));
                break;
            case R.id.button_woman:
                SEXE = "woman";
                setSelectedAttribut(view, sexe_buttons);
                break;
            case R.id.button_man:
                SEXE = "man";
                setSelectedAttribut(view, sexe_buttons);
                break;
            case R.id.button_heart:
                ORGANE = "heart";
                setSelectedAttribut(view, organe_buttons);
                break;
            case R.id.button_stomac:
                ORGANE = "stomac";
                setSelectedAttribut(view, organe_buttons);
                break;
            case R.id.button_lung:
                ORGANE = "lung";
                setSelectedAttribut(view, organe_buttons);
                break;
            case R.id.button_foetus:
                ORGANE = "foetus";
                setSelectedAttribut(view, organe_buttons);
                break;
            case R.id.button_vessie:
                ORGANE = "vessie";
                setSelectedAttribut(view, organe_buttons);
                break;
            case R.id.button_ecto:
                MORPHOLOGIE = "ecto";
                setSelectedAttribut(view, morphologie_buttons);
                break;
            case R.id.button_meso:
                MORPHOLOGIE = "meso";
                setSelectedAttribut(view, morphologie_buttons);
                break;
            case R.id.button_endo:
                MORPHOLOGIE = "endo";
                setSelectedAttribut(view, morphologie_buttons);
                break;
        }
    }

    public static void setSelectedAttribut(View button, ArrayList button_list){
            unselectButton(button_list);
            button.setSelected(true);
    }

    public static void unselectButton(ArrayList button_list){

        for (int i = 0; i < button_list.size(); i++) {
            ImageButton button = (ImageButton) button_list.get(i);
            button.setSelected(false);
        }
    }

    public void setFont(TextView textView, String fontName) {
        if(fontName != null){
            try {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + fontName);
                textView.setTypeface(typeface);
            } catch (Exception e) {
                Log.e("FONT", fontName + " not found", e);
            }
        }
    }
}