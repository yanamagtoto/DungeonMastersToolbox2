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
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LootGenerator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    EditText LootCR;
    TextView theLoot;
    Button GenerateLoot;
    DrawerLayout drawer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loot_generator);

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

    public void initialize(){
        LootCR = findViewById(R.id.editText_lootCR);

        theLoot = findViewById(R.id.txtview_loot);
        theLoot.setMovementMethod(new ScrollingMovementMethod());

        GenerateLoot = findViewById(R.id.btn_loot_generate);
        GenerateLoot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                generateTheLoot();
            }
        });

    }

    public void generateTheLoot(){
        if(LootCR.getText().toString().equals("")){
            Toast.makeText(this, "You didnt enter a challenge rating! How am I supposed to generate stuff? :(", Toast.LENGTH_SHORT).show();
            return;
        }else{
            int CR = Integer.parseInt(LootCR.getText().toString());

            if(CR > 20 || CR < 1){
                Toast.makeText(this, "You Entered a challenge rating that is not within range! How am I supposed to generate stuff? :(", Toast.LENGTH_SHORT).show();
                return;
            }else{
                theLoot.setText("");
                theLoot.append(generatePlatinum(CR));
                theLoot.append("\n\r");
                theLoot.append(generateGold(CR));
                theLoot.append("\n\r");
                theLoot.append(generateSilver(CR));
                theLoot.append("\n\r");
                theLoot.append(generateCopper(CR));
                theLoot.append("\n\r");
                theLoot.append(generateTreasure(CR));
            }



        }


    }


    public String generatePlatinum(int CR){
        int numberToBeDivided = CR * 10;
        Random rand = new Random();

        int money =  rand.nextInt(numberToBeDivided);

        String stringMoney = money + " Platinum Coins";

        return stringMoney;
    }

    public String generateGold(int CR){
        int numberToBeDivided = CR * 50;
        Random rand = new Random();

        int money =  rand.nextInt(numberToBeDivided);


        String stringMoney = money + " Gold Coins";

        return stringMoney;
    }

    public String generateSilver(int CR){
        int numberToBeDivided = CR * 100;
        Random rand = new Random();

        int money =  rand.nextInt(numberToBeDivided);


        String stringMoney = money + " Silver Coins";

        return stringMoney;
    }

    public String generateCopper(int CR){
        int numberToBeDivided = CR * 150;
        Random rand = new Random();

        int money =  rand.nextInt(numberToBeDivided);

        String stringMoney = money + " Copper Coins";

        return stringMoney;
    }



    public String generateTreasure(int CR){
        String listOfValuables = "Treasures: ";

        int numOfValuablesToGen = CR * 3;
        // so bale generate Treasure is basically you give an item, then enclose it in the the

        String[] valuables = new String[]{ "Amethyst", "Topaz", "Diamond" , "Silk", "Velvet", "Furs", "Ivory", "Pottery", "Linen", "Incense", "Silverware",
                "Bronze Bust", "Golden Bust", "Painting of a Woman", "Painting of a Dog", "Painting of a Pig", "Painting of a Man", "Painting of a King",
                "Golden Necklace", "Silver Necklace", "Bronze Necklace", "Ruby", "Dice", "Hairpin"
        };

        String[] costs = new String[]{ " (200 gp)", " (10 pp)", " (100 gp)", " (50 gp)", " (25 gp)", " (10 gp)"

        };

        Random rand = new Random();

        for(int i = 0; i < numOfValuablesToGen; i++){

            int first = rand.nextInt(valuables.length);
            int second = rand.nextInt(costs.length);

            if(i != 0){ //put commas at the shops after the first
               listOfValuables = listOfValuables + ", ";
            }

            listOfValuables = listOfValuables + " " + valuables[first] + " " + costs[second];

        }

        return listOfValuables;
    }


}
