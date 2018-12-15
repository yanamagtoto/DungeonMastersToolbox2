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

import java.util.Random;

public class VenueGenerator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView venueDetails;
    TextView venueName;
    Button generateVenue;
    Button saveVenue;
    DrawerLayout drawer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_generator);

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


    public void initialize(){  //initializes the buttons & views.

        venueDetails = findViewById(R.id.txt_view_venue_details);
        venueName = findViewById(R.id.txtview_venueName);

        generateVenue = findViewById(R.id.btn_venue_generate);
        generateVenue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                generateVenue();
            }
        });

        saveVenue = findViewById(R.id.btn_venue_save);
        saveVenue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });



    }

    public void generateVenue(){

        int determiner = venueDeterminer();

        venueName.setText(generateVenueName(determiner));

        venueDetails.setText(generateStores(determiner));

    }


    public int venueDeterminer(){
        //town of, city, castle prefixes.
        Random rand = new Random();
        int first = rand.nextInt(3); //0 - town, 1 - castle, 2 - city

        return first;
    }

    public String generateVenueName(int type){
        String venueName = "";

        String[] names = new String[]{"Erith" ,"Tottenham" ,"Icemeet", "Aermagh" ,"Gilramore",
                "Ironhaven", "Jongvale", "Kilerth", "Mournstead", "Burnsley" ,
                "Veritas", "Wolfwater" ,"Whaelrdrake" ,"Aucteraden", "Aynor",
                "Davenport" ,"Tarmsworth" ,"Blue Field" ,"Ffestiniog", "Barmwich",
                "Queenstown" ,"Durnatel" ,"Wellspring" ,"Auchtermuchty", "Merton" ,
                "Lewes", "Bamborourgh", "Runswick", "Bl,eakburn" ,"Carningsby" ,
                "Red Hawk", "Rivermouth", "Cirrane" ,"Garthram" ,"Larnwick" ,"Taedmorden" ,
                "Wanborne" ,"Mensfield", "Hankala", "Eanverness" ,"Cromerth", "Northwich" ,
                "Holsworthy", "Archensheen", "Wombourne" ,"Auchenshuggle" ,"Carleone",
                "Bellmare Fool's" ,"March Wolford", "Bromwich" ,"Glaenarm", "Warthford" ,"Redwick" ,"Bush" ,
                "Matlock", "King's Watch", "Alnwick" ,"Eldham"
        };

        Random rand = new Random();
        int pointer = rand.nextInt(names.length);



        switch(type){
            case 0: //town
                venueName = "Town of " + names[pointer];
                break;
            case 1:
                venueName =  names[pointer] + " Castle";
                break;
            case 2:
                venueName =  names[pointer] + " City";
                break;

        }

        return venueName;
    }

    public String generateStores(int type){ //gets the type of venue, town ba, city ba or castle?
        String shoplist = "";
        int amountOfShops = 0;

        String[] firstNoun = new String[]{"Goofy", "Courageous", "Earthy", "Ordinary", "Mundane","Cute", "Free" ,"Groovy" ,"Tense" ,"Youthful", "Acoustic",
                "Cowardly" , "Small" , "Round", "Past",  "Daffy", "Remarkable", "Super", "Colorful","Cultured", "Polite",
                "Zany", "Internal", "Boiling", "Comfortable", "Broad" , "Five", "Cynical", "Strange", "Lovely", "Unwieldy", "Intelligent", "Obedient",
                "Ratty", "Misty", "Naughty", "Wide-eyed" };


        String[] secondNoun = new String[]{"Plant", "Quiet", "Verse",  "Bomb", "Street", "Discovery", "Act", "Account", "Kick", "Friend", "Book",
                "Sleet", "Rate", "Form", "Cloth", "Jellyfish", "Attraction", "Eyes", "North", "Rub", "Water", "House" , "Treatment",
                "Mouth",  "Stone", "Spiders", "Dirt", "Friction", "Marble", "Mass", "Salt" ,"Heat",
                "Mist" , "Stove", "Key", "Invention", "Smell", "Ticket", "Yarn"};

        String[] prefixes = new String[]{" Alchemy Shop", " Tavern", " Enchanter", " Blacksmith", " Market", " General Store"};

        Random rand = new Random();

        switch(type){
            case 0:
                amountOfShops = 3;
                for(int i = 0; i < amountOfShops; i++){

                    int first = rand.nextInt(firstNoun.length);
                    int second = rand.nextInt(secondNoun.length);
                    int prefix = rand.nextInt(prefixes.length);

                    if(i != 0){ //put commas at the shops after the first
                        shoplist = shoplist + ", ";
                    }

                    shoplist = shoplist + " " + firstNoun[first] + " " + secondNoun[second] + " " + prefixes[prefix];
                }


                break;
            case 1:
                amountOfShops = 5;
                for(int i = 0; i < amountOfShops; i++){

                    int first = rand.nextInt(firstNoun.length);
                    int second = rand.nextInt(secondNoun.length);
                    int prefix = rand.nextInt(prefixes.length);

                    if(i != 0){ //put commas at the shops after the first
                        shoplist = shoplist + ", ";
                    }

                    shoplist = shoplist + " " + firstNoun[first] + " " + secondNoun[second] + " " + prefixes[prefix];
                }

                break;
            case 2:
                amountOfShops = 9;

                for(int i = 0; i < amountOfShops; i++){

                    int first = rand.nextInt(firstNoun.length);
                    int second = rand.nextInt(secondNoun.length);
                    int prefix = rand.nextInt(prefixes.length);

                    if(i != 0){ //put commas at the shops after the first
                        shoplist = shoplist + ", ";
                    }

                    shoplist = shoplist + " " + firstNoun[first] + " " + secondNoun[second] + " " + prefixes[prefix];
                }

                break;

        }


        return shoplist;

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
}
