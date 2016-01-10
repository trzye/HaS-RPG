package com.example.jereczem.hasrpg.view.adapters;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.jereczem.hasrpg.R;
import com.example.jereczem.hasrpg.playgame.ArrayData;
import com.example.jereczem.hasrpg.playgame.ChaseData;
import com.example.jereczem.hasrpg.playgame.ChaseStatus;
import com.example.jereczem.hasrpg.playgame.HunterData;
import com.example.jereczem.hasrpg.sockets.events.attack.AttackEvent;
import com.example.jereczem.hasrpg.view.fragments.LobbiesFragment;

import java.util.ArrayList;

/**
 * Created by Michał on 2016-01-07.
 */
public class ChaseDataAdapter extends ArrayAdapter<ArrayData<ChaseData>> {
    private Double myLatitude = 0.0;
    private Double myLongitude = 0.0;

    public void setMyLatitude(Double myLatitude) {
        this.myLatitude = myLatitude;
    }

    public void setMyLongitude(Double myLongitude) {
        this.myLongitude = myLongitude;
    }

    public ChaseDataAdapter(Context context, int resource, ArrayList<ArrayData<ChaseData>> chaseData) {
        super(context, resource, chaseData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_chase, null);
        }

        ArrayData<ChaseData> chaseData = getItem(position);

        if(chaseData != null){
            setViewFromChaseData(chaseData, v);
        }
        return v;
    }

    private void setViewFromChaseData(final ArrayData<ChaseData> chaseData, View v) {
        TextView chaseName = (TextView) v.findViewById(R.id.chaseDataName);
        TextView chaseLvl = (TextView) v.findViewById(R.id.chaseDataLevel);
        TextView chaseDistance = (TextView) v.findViewById(R.id.chaseDataDistance);
        TextView chaseStatus = (TextView) v.findViewById(R.id.chaseDataStatus);

        ChaseData chase = chaseData.getData();

        chaseName.setText(chase.getName());
        chaseLvl.setText(String.valueOf(chase.getChase().getLevel()));

        Location myLocation = new Location(LocationManager.GPS_PROVIDER);
        myLocation.setLatitude(myLatitude);
        myLocation.setLongitude(myLongitude);

        Location chaseLocation = new Location(LocationManager.GPS_PROVIDER);
        chaseLocation.setLatitude(chase.getLatitude());
        chaseLocation.setLongitude(chase.getLongitude());

        final Float distance = myLocation.distanceTo(chaseLocation);
        chaseDistance.setText(String.valueOf(distance.intValue()));

        chaseStatus.setText(chase.getStatus().name());

        AttackButton attackButton = (AttackButton) v.findViewById(R.id.attackChaseDataButton);
        attackButton.setAttackedId(chaseData.getUserID());

        if(distance > 20){
            attackButton.setClickable(false);
        } else {
            attackButton.setClickable(true);
        }
    }
}