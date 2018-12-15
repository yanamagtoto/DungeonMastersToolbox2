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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Class extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView listOfNames;
    DBHelper myDB;

    DrawerLayout drawer; //WHAT I DID IDK IF ITS CORRECT SAM :-(((
    Button barbarian;
    Button bard;
    Button cleric;
    Button druid;
    Button fighter;
    Button monk;
    Button paladin;
    Button ranger;
    Button rogue;
    Button sorcerer;
    Button warlock;
    Button wizard;
    TextView className;
    TextView classDescription;
    ImageView barbarian_Image;
    ImageView bard_Image;
    ImageView cleric_Image;
    ImageView druid_Image;
    ImageView fighter_Image;
    ImageView monk_Image;
    ImageView paladin_Image;
    ImageView ranger_Image;
    ImageView rogue_Image;
    ImageView sorcerer_Image;
    ImageView warlock_Image;
    ImageView wizard_Image;


    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_classes); // !! --- IMPORTANT
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        barbarian = (Button) findViewById(R.id.btn_barbarian);
        bard = (Button) findViewById(R.id.btn_bard);
        cleric = (Button) findViewById(R.id.btn_cleric);
        druid = (Button) findViewById(R.id.btn_druid);
        fighter = (Button) findViewById(R.id.btn_fighter);
        monk = (Button) findViewById(R.id.btn_monk);
        paladin = (Button) findViewById(R.id.btn_paladin);
        ranger = (Button) findViewById(R.id.btn_ranger);
        rogue = (Button) findViewById(R.id.btn_rogue);
        sorcerer = (Button) findViewById(R.id.btn_sorcerer);
        warlock = (Button) findViewById(R.id.btn_warlock);
        wizard = (Button) findViewById(R.id.btn_wizard);
        className = (TextView) findViewById(R.id.txtview_className);
        classDescription = (TextView) findViewById(R.id.txtview_description);
        barbarian_Image.setImageResource(R.drawable.class_logo_barbarian);
        bard_Image.setImageResource(R.drawable.class_logo_bard);
        cleric_Image.setImageResource(R.drawable.class_logo_cleric);
        druid_Image.setImageResource(R.drawable.class_logo_druid);
        fighter_Image.setImageResource(R.drawable.class_logo_fighter);
        monk_Image.setImageResource(R.drawable.class_logo_monk);
        paladin_Image.setImageResource(R.drawable.class_logo_paladin);
        ranger_Image.setImageResource(R.drawable.class_logo_ranger);
        rogue_Image.setImageResource(R.drawable.class_logo_rogue);
        sorcerer_Image.setImageResource(R.drawable.class_logo_sorcerer);
        warlock_Image.setImageResource(R.drawable.class_logo_warlock);
        wizard_Image.setImageResource(R.drawable.class_logo_wizard);

        initialize();

    }

    public void initialize () {
        barbarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void appendDatabaseItemsToList(){

        Cursor res = myDB.getAllFromSavedFactions();
        ArrayList<String> factionNames = new ArrayList<>();

        if(res.getCount() == 0) {
            Toast.makeText(this, "THERES BLLOODY NOTHING", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while (res.moveToNext()) {
                factionNames.add(res.getString(1));
            }
        }

        for(int i = 0; i < factionNames.size(); i++){
            listOfNames.append(factionNames.get(i));
            listOfNames.append("\n\r");
        }


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
}
