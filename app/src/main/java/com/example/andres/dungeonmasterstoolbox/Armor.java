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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Armor extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    TextView theArmor;
    Button btn_back;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_armors); // !! --- IMPORTANT
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

    @Override
    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
    public void initialize(){
        theArmor = findViewById(R.id.txtview_wiki_armorList);
        theArmor.setMovementMethod(new ScrollingMovementMethod());

    }

    public void appendDatabaseItemsToList() {
        DBHelper myDB = new DBHelper(this);

        Cursor res = myDB.getAllArmors();
        ArrayList<String> armorsList = new ArrayList<>();

        if (res.getCount() == 0) {
            Toast.makeText(this, "THERES BLLOODY NOTHING", Toast.LENGTH_SHORT).show();
            return;
        } else { //myDB.insertIntoEquipment("Club", "weapon", 2.0, "", "5 sp", "Simple Melee, DMG: 1d4 bludgeoning, Light");
            while (res.moveToNext()) {
                theArmor.append("Name: ");
                theArmor.append(res.getString(1));
                theArmor.append("\n\r");
                theArmor.append("Weight: ");
                theArmor.append("\n\r");
                theArmor.append(res.getString(3));
                theArmor.append("Cost: ");
                theArmor.append(res.getString(5));
                theArmor.append("\n\r");
                theArmor.append("Properties: ");
                theArmor.append(res.getString(6));
                theArmor.append("\n\r");
                theArmor.append("\n\r");
                theArmor.append("\n\r");
            }
        }
    }
}

