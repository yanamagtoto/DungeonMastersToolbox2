package com.example.andres.dungeonmasterstoolbox;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SavedVenue extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView savedVenues;
    DrawerLayout drawer;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_venuelist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initialize();
        appendDatabaseItemsToList();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.npc_generator) {
            Intent intent = new Intent(this, NPCGenerator.class);
            startActivity(intent);
        } else if (id == R.id.venue_generator) {
            Intent intent = new Intent(this, VenueGenerator.class);
            startActivity(intent);

        } else if (id == R.id.loot_generator) {
            Intent intent = new Intent(this, LootGenerator.class);
            startActivity(intent);

        } else if (id == R.id.faction_generator) {
            Intent intent = new Intent(this, FactionNameGenerator.class);
            startActivity(intent);

        } else if (id == R.id.encounter_generator) {
            Intent intent = new Intent(this, EncounterGenerator.class);
            startActivity(intent);

        } else if (id == R.id.mini_wiki) {
            Intent intent = new Intent(this, MiniWiki.class);
            startActivity(intent);

        } else if (id == R.id.saved_npc) {
            Intent intent = new Intent(this, SavedNPC.class);
            startActivity(intent);

        } else if (id == R.id.saved_factionName) {
            Intent intent = new Intent(this, SavedFactionName.class);
            startActivity(intent);

        } else if (id == R.id.saved_venue) {
            Intent intent = new Intent(this, SavedVenue.class);
            startActivity(intent);

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void  initialize(){
        savedVenues =  this.findViewById(R.id.txtview_saved_venues);
        savedVenues.setMovementMethod(new ScrollingMovementMethod());




    }

    public void appendDatabaseItemsToList(){
        DBHelper myDB = new DBHelper(this);

        Cursor res = myDB.getAllFromVenue();

        if(res.getCount() == 0) {
            Toast.makeText(this, "THERES BLLOODY NOTHING", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while (res.moveToNext()) {
                savedVenues.append("Name: ");
                savedVenues.append(res.getString(1));
                savedVenues.append("\n\r");
                savedVenues.append("Shops: ");
                savedVenues.append(res.getString(2));
                savedVenues.append("\n\r");
                savedVenues.append("\n\r");
            }
        }


    }
}
