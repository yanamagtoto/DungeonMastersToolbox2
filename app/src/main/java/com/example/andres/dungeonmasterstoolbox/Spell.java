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
import android.widget.ImageButton;

public class Spell extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageButton btn_spell_sorcerer;
    ImageButton btn_spell_bard;
    ImageButton btn_spell_wizard;
    ImageButton btn_spell_warlock;
    ImageButton btn_spell_druid;
    ImageButton btn_spell_cleric;
    DrawerLayout drawer;

    protected void onCreate (Bundle savedInstanceState) {
        //NOTE FOR SAM: I THINK THIS IS WHERE YOU PUT THE THING YOU SAID ABOUT EXTRAS (for transitioning from 1st screen to 2nd then 3rd screen)

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_spells_filter); // !! --- IMPORTANT
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initializeButtons();

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

    public void initializeButtons(){
        btn_spell_bard = findViewById(R.id.btn_spell_bard);
        btn_spell_bard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Spell.this, SpellList.class);
                i.putExtra("filter", "bard");
                startActivity(i);

            }
        });

        btn_spell_cleric = findViewById(R.id.btn_spell_cleric);
        btn_spell_cleric.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(Spell.this, SpellList.class);
            i.putExtra("filter", "cleric");
            startActivity(i);

            }
        });

        btn_spell_wizard = findViewById(R.id.btn_spell_wizard);
        btn_spell_wizard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Spell.this, SpellList.class);
                i.putExtra("filter", "wizard");
                startActivity(i);

            }
        });

        btn_spell_warlock = findViewById(R.id.btn_spell_warlock);
        btn_spell_warlock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Spell.this, SpellList.class);
                i.putExtra("filter", "warlock");
                startActivity(i);

            }
        });

        btn_spell_druid= findViewById(R.id.btn_spell_druid);
        btn_spell_druid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Spell.this, SpellList.class);
                i.putExtra("filter", "druid");
                startActivity(i);

            }
        });

        btn_spell_sorcerer = findViewById(R.id.btn_spell_sorcerer);
        btn_spell_sorcerer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Spell.this, SpellList.class);
                i.putExtra("filter", "sorcerer");
                startActivity(i);

            }
        });
    }
}
