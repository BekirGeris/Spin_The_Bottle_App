package com.begers.dongel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

public class AnaSayfa extends AppCompatActivity {

    private AdView mAdView;

    private int numberOfPlayer;

    private RadioGroup radioGroup;
    private EditText editNames;
    private ImageButton butonAdd;
    private TextView textViewPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Players> players = new ArrayList<>();

        tanimlamalar();
        bannerReklam();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                numberOfPlayer = Integer.parseInt(rb.getText().toString().replace(" ",""));
                textViewPlayers.setText(getString(R.string.liste) + " (" + numberOfPlayer + ")");
                players.clear();
                butonAdd.setImageResource(R.drawable.oyuncu_add);
            }
        });

        butonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!editNames.getText().toString().replace(" ", "").equals("")){
                    players.add(new Players(editNames.getText().toString(), 0));
                }else {
                    Toast.makeText(getApplicationContext(), getString(R.string.toolsMessage_1), Toast.LENGTH_LONG).show();
                }
                editNames.setText("");

                textViewPlayers.setText(getString(R.string.liste) + " ("  + numberOfPlayer + ")");
                for (Players player : players){
                    textViewPlayers.setText(textViewPlayers.getText()  + "\n" + player.getPlayerName());
                }

                if (players.size() == numberOfPlayer - 1){
                    butonAdd.setImageResource(R.drawable.ikinci_sayfaya_git);
                }

                if (players.size() == numberOfPlayer){
                    //ikinci sayfaya git
                }
            }
        });

    }

    public void tanimlamalar(){
        MobileAds.initialize(this, getString(R.string.appId));
        radioGroup = findViewById(R.id.radio_grup);
        editNames = findViewById(R.id.edit_names);
        butonAdd = findViewById(R.id.buton_add);
        textViewPlayers = findViewById(R.id.text_players);
    }

    private void bannerReklam() {
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}