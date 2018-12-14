package com.example.andres.dungeonmasterstoolbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class VenueGenerator extends AppCompatActivity {

    TextView venueDetails;
    TextView venueName;
    Button generateVenue;
    Button saveVenue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_generator);

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








}
