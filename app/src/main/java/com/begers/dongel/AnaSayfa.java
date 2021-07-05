package com.begers.dongel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AnaSayfa extends AppCompatActivity {

    private int numberOfPlayer;

    private RadioGroup radioGroup;
    private EditText editNames;
    private Button butonAdd;
    private TextView textViewPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Players> players = new ArrayList<>();

        tanimlamalar();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                numberOfPlayer = Integer.parseInt(rb.getText().toString());
            }
        });

        butonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                players.add(new Players(editNames.getText().toString(), 0));
                editNames.setText("");

                textViewPlayers.setText("");
                for (Players player : players){
                    textViewPlayers.setText(textViewPlayers.getText()  + "" + player.getPlayerName() + "\n");
                }
            }
        });
    }

    public void tanimlamalar(){
        radioGroup = findViewById(R.id.radio_grup);
        editNames = findViewById(R.id.edit_names);
        butonAdd = findViewById(R.id.buton_add);
        textViewPlayers = findViewById(R.id.text_players);
    }

}