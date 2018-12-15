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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class EncounterGenerator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    EditText numEnemy;
    EditText CR;
    Button generateEncounter;
    TextView encounters;
    DBHelper myDB;

    DrawerLayout drawer;

    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encounter_generator);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.myDB = new DBHelper(this);




        initialize();



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

    public void initialize(){
        numEnemy = findViewById(R.id.editText_num_enemy);
        CR = findViewById(R.id.editText_cr);
        encounters = findViewById(R.id.txtView_encounters);

        generateEncounter = findViewById(R.id.btn_enemy_generate);
        generateEncounter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                generateTheEncounter();
            }
        });

    }

    public void generateTheEncounter() {
        int totalExp = 0;

        encounters.setText("");

        if(CR.getText().toString().equals("") || numEnemy.getText().toString().equals("")){
            Toast.makeText(this, "You didnt enter a challenge rating or the number of enemies! How am I supposed to generate stuff? :(", Toast.LENGTH_SHORT).show();
            return;
        }else{
            int cr = Integer.parseInt(CR.getText().toString());
            int numEnemies =   Integer.parseInt(numEnemy.getText().toString());

            if(cr > 20 || cr < 1){
                Toast.makeText(this, "You Entered a challenge rating that is not within range! How am I supposed to generate stuff? :(", Toast.LENGTH_SHORT).show();
                return;
            }else{
                    Random rand = new Random();

                    //get the enemy from thedatabase
                    Cursor res = myDB.getAllDataFromEncounters(cr);
                    ArrayList<Encounter> possibleEnemies = new ArrayList<>();

                    if(res.getCount() == 0) {
                        Toast.makeText(this, "THERES BLLOODY NOTHING", Toast.LENGTH_SHORT).show();
                        return;
                    }else{
                        while (res.moveToNext()) {
                            Encounter e = new Encounter(res.getString(1),res.getInt(2),res.getInt(3));
                            possibleEnemies.add(e);
                        }
                    }

                    myDB.close();

                    while(numEnemies != 0){
                        //generate number of enemies
                        int index =  rand.nextInt(possibleEnemies.size()); //what is the creature to be encountered?
                        int currEnemies =  rand.nextInt(numEnemies) +1 ; //how many enemies will this creature be
                        //append to the text box
                        encounters.append(possibleEnemies.get(index).getName() + " * " + currEnemies);
                        encounters.append("\n\r");


                        int currExp = possibleEnemies.get(index).getEXP() * currEnemies;

                        totalExp = totalExp + currExp;

                        numEnemies = numEnemies - currEnemies;
                    }

                encounters.append("\n\r");
                encounters.append("TOTAL EXP OF THE ENCOUNTER: " + totalExp);

            }


        }

    }


}
