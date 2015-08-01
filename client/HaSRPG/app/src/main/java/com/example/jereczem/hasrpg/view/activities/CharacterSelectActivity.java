package com.example.jereczem.hasrpg.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.jereczem.hasrpg.R;
import com.example.jereczem.hasrpg.data.PlayerData;
import com.example.jereczem.hasrpg.view.logic.CharacterSelectLogic;


public class CharacterSelectActivity extends AppCompatActivity{
    private PlayerData playerData;
    private CharacterSelectLogic characterSelectLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_select);
        Intent intent = getIntent();
        playerData = (PlayerData)intent.getSerializableExtra("playerData");
        characterSelectLogic = new CharacterSelectLogic(this, playerData);
    }

    public void rightChase(View view) {
        characterSelectLogic.rightChaseClick();
    }

    public void leftChase(View view) {
        characterSelectLogic.leftChaseClick();
    }

    public void rightHunter(View view) {
        characterSelectLogic.rightHunterClick();
    }

    public void leftHunter(View view) {
        characterSelectLogic.leftHunterClick();
    }

    public void saveSelectedCharacters(View view) {
    }

}
