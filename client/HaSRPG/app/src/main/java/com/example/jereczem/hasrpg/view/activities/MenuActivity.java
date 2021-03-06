package com.example.jereczem.hasrpg.view.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.jereczem.hasrpg.view.fragments.LobbiesListFragment;
import com.example.jereczem.hasrpg.R;
import com.example.jereczem.hasrpg.view.drawer.DrawerLogic;
import com.example.jereczem.hasrpg.view.logic.MenuActivityLogic;


public class MenuActivity extends AppCompatActivity implements LobbiesListFragment.OnFragmentInteractionListener{

    private MenuActivityLogic menuActivityLogic;
    private DrawerLogic drawerLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        drawerLogic = new DrawerLogic(this);
        menuActivityLogic = new MenuActivityLogic(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        menuActivityLogic.moveTaskToBack();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                drawerLogic.openDrawerClick();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onFragmentInteraction(String id) {

    }
}
