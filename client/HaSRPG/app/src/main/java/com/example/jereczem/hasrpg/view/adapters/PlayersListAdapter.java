package com.example.jereczem.hasrpg.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jereczem.hasrpg.R;
import com.example.jereczem.hasrpg.data.player.PlayerData;

import java.util.ArrayList;

/**
 * Created by jereczem on 05.09.15.
 */
public class PlayersListAdapter extends ArrayAdapter<PlayerData> {
    public PlayersListAdapter(Context context, int resource, ArrayList<PlayerData> playerDatas) {
        super(context, resource, playerDatas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_player, null);
        }

        PlayerData playerData = getItem(position);

        if(playerData != null){
            TextView playerName = (TextView) v.findViewById(R.id.playerNameTextView);
            TextView playerStatus = (TextView) v.findViewById(R.id.playerStatusTextView);
            TextView hunterLevel = (TextView) v.findViewById(R.id.hunterLevelTextView);
            TextView chaseLevel = (TextView) v.findViewById(R.id.chaseLevelTextView);

            playerName.setText(playerData.getLogin());
            playerStatus.setText(R.string.player_status);
            hunterLevel.setText(R.string.hunter_level_lobby);
            chaseLevel.setText(R.string.chase_level_lobby);

            playerStatus.setText(playerStatus.getText().toString().replace("[magic]",
                    playerData.getStatus().name()
                    ));

            hunterLevel.setText(hunterLevel.getText().toString().replace("[]",
                    playerData.getHunters().get(playerData.getHunterNumber()).getLevel().toString()));

            chaseLevel.setText(chaseLevel.getText().toString().replace("[]",
                    playerData.getChases().get(playerData.getChaseNumber()).getLevel().toString()));
        }

        return v;
    }
}
