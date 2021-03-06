package com.example.andres.dungeonmasterstoolbox;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import java.util.Random;

public class FactionNameGenerator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView factionName;
    Button saveFaction;
    Button generateFaction;
    DrawerLayout drawer;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faction_name_generator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        initialize();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

            factionName = findViewById(R.id.txtview_factionName);

            saveFaction = findViewById(R.id.btn_faction_save);
            saveFaction.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    saveFaction();
                }
            });
            generateFaction = findViewById(R.id.btn_faction_generate);
            generateFaction.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    factionName.setText(generateFactionName());
                }
            });

        }

        public String generateFactionName(){

            String faction = "";

            String[] names = new String[]{ "the Courageous", "the Earth", "the Sentinels", "Protection", "Freedom" , "the Groovy" ,"Tense" ,"The Aesthetic", "Glamour",
                    "The Cowardly" , "The Small" , "The Round", "The Past",  "Daffolds", "the Remarkable", "the Colorful", "the Well-Mannered", "Kindness",
                    "Fortune", "Redemption", "the Broad" , "the Five", "the Cynical", "Strange", "Lovely", "The Unwieldy", "The Sage", "The Obedient",
                    "the Mist", "the Wide-eyed"

            };

            String[] prefixes = new String[]{"The Order of ", "The Circle of ", "The Soldiers of ", "The Knights of ", "Voices of ", "The Children of "};

            Random rand = new Random();

            int first = rand.nextInt(names.length);
            int prefix = rand.nextInt(prefixes.length);

            faction = prefixes[prefix]+names[first];


            return faction;
        }

        public void saveFaction(){
            DBHelper mydb = new DBHelper(this);

            boolean isSuccess = mydb.insertIntoSavedFaction(factionName.getText().toString());

            if(isSuccess){
                Toast.makeText(this, "Sucessfully Saved!",
                        Toast.LENGTH_LONG).show();
            }

        }
    }


