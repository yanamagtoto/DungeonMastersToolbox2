package com.example.andres.dungeonmasterstoolbox;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class NPCGenerator extends AppCompatActivity {

    TextView npcNameView;
    TextView sexView;
    TextView raceView;
    TextView occupationView;
    TextView alignmentView;
    Button generate;
    Button save;
    DrawerLayout drawer;
    DBHelper mydb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npc_generator);

        mydb = new DBHelper(this);


        inititialize();

    }

    public void inititialize(){
        npcNameView = findViewById(R.id.txtview_npcName);
        sexView = findViewById(R.id.txtview_npcSex);
        raceView = findViewById(R.id.txtview_npcRace);
        occupationView = findViewById(R.id.txtview_npcOccup);
        alignmentView = findViewById(R.id.txtview_npcAllignment);

        generate = findViewById(R.id.btn_npc_generate);
        generate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                generateNPC();
            }
        });

        save = findViewById(R.id.btn_npc_save);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                saveNPC(mydb);

            }
        });

    }

    public void saveNPC(DBHelper mydb){

        //mydb.insertIntoNPC();

    }

    public void generateNPC(){


        //call the generates, then append.

        String sex = generateSex();
        String race = generateRace();
        String name = generateName(race, sex);
        String occupation = generateOccupation();
        String alignment = generateAlignment();


        //put append code here.

        npcNameView.setText(name);
        sexView.setText(sex);
        raceView.setText(race);
        occupationView.setText(occupation);
        alignmentView.setText(alignment);



    }

    public String generateName(String race, String sex){
        String name = "";

        switch (race){
            case "Human":
                name = generateHumanName(sex);
                break;
            case "Dwarf":
                name = generateDwarfName(sex);
                break;
            case "Elf":
                name = generateElfName(sex);
                break;
            case "Dragonborn":
                name = generateDragonbornName(sex);
                break;
            case "Gnome":
                name = generateGnomeName(sex);
                break;
            case "Tiefling":
                name = generateTieflingName(sex);
                break;
            case "Halfling":
                name = generateHalflingName(sex);
                break;
            case "Half-Orc":
                name = generateHalfOrcName(sex);
                break;
            case "Half-Elf":
                name = generateHalfElfName(sex);
                break;

        }

        return name;
    }

    public String generateOccupation(){

        String occupation = "";

        String[] occupations = new String[] {"sailor", "farmer", "acolyte", "soldier", "servant", "hunter", "entertainer", "locksmith", "blacksmith", "brewer", "scribe",
                "carpenter", "cartographer", "shoemaker", "baker", "jeweler", "leatherworker", "mason", "painter", "potter", "sailmaker", "wagon maker",
                "weaver", "carver", "slaver", "moneylender", "bounty hunter", "guard", "spy", "tradesman", "prostitute"};

        Random rand = new Random();

        int n = rand.nextInt(occupations.length) ;

        occupation = occupations[n];


        return occupation;
    }

    public String generateAlignment(){

        String alignment = "";

        String[] alignments = new String[] {"Lawful Good","Neutral Good","Chaotic Good","Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};

        Random rand = new Random();

        int n = rand.nextInt(9) ;

        alignment = alignments[n];

        return alignment;
    }


    public String generateRace(){

        String race = "";

        String[] races = new String[] {"Human","Elf","Dwarf","Dragonborn", "Tiefling", "Gnome", "Halfling", "Half-Elf", "Half-Orc"};

        Random rand = new Random();

        int n = rand.nextInt(9) ;

        race = races[n];

        return race;

    }



    public String generateSex(){

        Random rand = new Random();

        int n = rand.nextInt(2) ;

        if(n == 0){
            return "Male";
        }else{
            return "Female";
        }

    }

    /*
    THIS PART IS FOR GENERATING THE NAMES OF THE PEOPLE!!!!!!!

    EACH RACE HAS A DIFFERENT NAME WHEN IT COMES TO FEMALE AND MALES!

    These are all called by the generate name function!

     */

    //"Human","Elf","Dwarf","Dragonborn", "Tiefling", "Gnome", "Halfling", "Half-Elf", "Half-Orc"

    public String generateHumanName(String sex){
        String name = "";

        if(sex.equals("Male")){

            String[] firstname = new String[]{"Aseir", "Haseid", "Kheed", "Zasheir", "Fodel", "Glar", "Grigor", "Igan", "Ivor", "Kosef", "Mival", "Pavel", "Sergor", "Darvin", "Dorn",
                    "Evendur", "Gorstag", "Helm", "Morn", "Randal", "Stedd", "Ander", "Blath", "Bran", "Frath", "Geth", "Lander", "Luth", "Malcer", "Stor", "Taman",
                    "Bareris", "Kethoth", "Mumed", "Urhur", "Borivik", "Faurgar", "Jandar", "Kanithar", "Madislak", "Ralmevik", "Shaumar", "Vladislak", "Chen", "Chi",
                    "Fai", "Jiang", "Jun", "Lian", "Long", "Meng", "Shan", "Wen", "Anton", "Diero", "Marcon", "Pieron", "Rimardo", "Romero", "Salazar", "Umbero"};

            String[] surname = new String[]{"Dumein", "Jassan", "Khalid", "Mostana", "Pashar", "Rein", "Amblecrown", "Buckman", "Dundragon", "Evenwood", "Greycastle",
                    "Tallstag", "Bersk", "Chernin", "Dotsk", "Kulenov", "Marsk", "Nemetsk", "Shemov", "Starag", "Brightwood", "Helder", "Hornraven", "Lackman",
                    "Stormwind", "Windrivver", "Anskuld", "Fezim", "Hahpet", "Nathandem", "Sepret", "Chergoba", "Dyernina", "Ulmokina", "Chien", "Huang",
                    "Kao", "Kung", "Lao", "Ling", "Mei", "Pin", "Shin", "Sum", "Tan", "Wan", "Agosto", "Astorio", "Calabra", "Domine", "Falone", "Marivaldi", "Pisacar"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }else{

            String[] firstname = new String[]{"Atala", "Ceidil", "Hama", "Jasmal", "Meilil", "Yasheira", "Zasheida", "Arveene", "Esvele", "Jhessail", "Kerri", "Lureene", "Miri", "Rowan",
                    "Tessele", "Alethra", "Kara", "Katernin", "Mara", "Natali", "Olma", "Tana", "Zora", "Betha", "Cefrey", "Kethra", "Mara", "Olga", "Silifrey", "Westra",
                    "Arizima", "Chathi", "Nephis", "Nulara", "Murithi", "Sefris", "Thola", "Umara", "Zolis", "Hulmarra", "Immith", "Imzel", "Navarra", "Shevarra",
                    "Tammith", "Yuldra", "Bai", "Chao", "Jia", "Lei", "Mei", "Qiao", "Shui", "Tai", "Balama", "Dona", "Faila", "Jalana", "Luisa", "Marta", "Quara", "Selise", "Vonda"};

            String[] surname = new String[]{"Dumein", "Jassan", "Khalid", "Mostana", "Pashar", "Rein", "Amblecrown", "Buckman", "Dundragon", "Evenwood", "Greycastle",
                    "Tallstag", "Bersk", "Chernin", "Dotsk", "Kulenov", "Marsk", "Nemetsk", "Shemov", "Starag", "Brightwood", "Helder", "Hornraven", "Lackman",
                    "Stormwind", "Windrivver", "Anskuld", "Fezim", "Hahpet", "Nathandem", "Sepret", "Chergoba", "Dyernina", "Ulmokina", "Chien", "Huang",
                    "Kao", "Kung", "Lao", "Ling", "Mei", "Pin", "Shin", "Sum", "Tan", "Wan", "Agosto", "Astorio", "Calabra", "Domine", "Falone", "Marivaldi", "Pisacar"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }




        return name;

    }

    public String generateElfName(String sex){
        String name = "";

        if(sex.equals("Male")){

            String[] firstname = new String[]{"Adran", "Aelar", "Aramil", "Arannis", "Aust", "Berrian", "Carric" , "Enialis", "Erdan", "Erevan", "Galinndan", "Hadarai", "Heian", "Himo",
                    "Immeral", "Laucian", "Mindartis", "Paelias", "Peren", "Quarion", "Riardon", "Rolen", "Soveliss", "Thamior", "Tharivol", "Theren", "Varis"};

            String[] surname = new String[]{"Amakiir", "Amastacia", "Galanodel", "Holimion", "Liadon", "Meliamne", "Nai'lo", "Siannodel", "Xiloscient"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }else{

            String[] firstname = new String[]{"Adrie", "Althaea", "Anastrianna", "Andraste", "Antinua", "Bethrynna", "Birel", "Caelynn", "Drusilia", "Enna", "Felosial", "Ielenia",
                    "Jelenneth", "Keyleth", "Leshanna", "Lia", "Meriele", "Mialee", "Naivara", "Quelenna", "Quillathe", "Sariel", "Shanairra", "Silaqui", "Theirastra",
                    "Thia", "Vadania", "Valanthe"};

            String[] surname = new String[]{"Amakiir", "Amastacia", "Galanodel", "Holimion", "Liadon", "Meliamne", "Nai'lo", "Siannodel", "Xiloscient"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }




        return name;
    }

    public String generateDwarfName(String sex){
        String name = "";

        if(sex.equals("Male")){

            String[] firstname = new String[]{"Adrik", "Alberich", "Baern", "Barendd", "Brottor", "Bruenor", "Dain", "Darrak", "Delg", "Eberk", "Einkil", "Fargrim", "Flint", "Gardain",
                    "Harbek", "Kildrak", "Morgran", "Orsik", "Oskar", "Rangrim", "Rurik", "Taklinn", "Thoradin", "Thorin", "Tordek", "Travok", "Ulfgar", "Veit", "Vondal"};

            String[] surname = new String[]{"Balderk", "Battlehammer", "Brawnanvil",
                    "Dankil", "Fireforge", "Frostbeard", "Gorunn", "Holderhek", "Ironfist", "Loderr", "Lutgehr", "Rumnaheim", "Strakeln", "Torunn", "Ungart"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }else{

            String[] firstname = new String[]{"Amber", "Artin", "Audhild", "Bardryn", "Diesa", "Eldeth", "Falkrunn", "Finellen", "Gunnloda", "Gurdis", "Helja", "Hlin", "Kathra",
                    "Kristryd", "Ilde", "Liftrasa", "Mardred", "Riswynn", "Sannl", "Torbera", "Torgga", "Vistra"};

            String[] surname = new String[]{"Balderk", "Battlehammer", "Brawnanvil",
                    "Dankil", "Fireforge", "Frostbeard", "Gorunn", "Holderhek", "Ironfist", "Loderr", "Lutgehr", "Rumnaheim", "Strakeln", "Torunn", "Ungart"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }

        return name;
    }


    public String generateDragonbornName(String sex){

        String name = "";

        if(sex.equals("Male")){

            String[] firstname = new String[]{"Adrik", "Alberich", "Baern", "Barendd", "Brottor", "Bruenor", "Dain", "Darrak", "Delg", "Eberk", "Einkil", "Fargrim", "Flint", "Gardain",
                    "Harbek", "Kildrak", "Morgran", "Orsik", "Oskar", "Rangrim", "Rurik", "Taklinn", "Thoradin", "Thorin", "Tordek", "Travok", "Ulfgar", "Veit", "Vondal"};

            String[] surname = new String[]{"Balderk", "Battlehammer", "Brawnanvil",
                    "Dankil", "Fireforge", "Frostbeard", "Gorunn", "Holderhek", "Ironfist", "Loderr", "Lutgehr", "Rumnaheim", "Strakeln", "Torunn", "Ungart"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }else{

            String[] firstname = new String[]{"Amber", "Artin", "Audhild", "Bardryn", "Diesa", "Eldeth", "Falkrunn", "Finellen", "Gunnloda", "Gurdis", "Helja", "Hlin", "Kathra",
                    "Kristryd", "Ilde", "Liftrasa", "Mardred", "Riswynn", "Sannl", "Torbera", "Torgga", "Vistra"};

            String[] surname = new String[]{"Balderk", "Battlehammer", "Brawnanvil",
                    "Dankil", "Fireforge", "Frostbeard", "Gorunn", "Holderhek", "Ironfist", "Loderr", "Lutgehr", "Rumnaheim", "Strakeln", "Torunn", "Ungart"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }

        return name;
    }


    public String generateTieflingName(String sex){

        String name = "";

        if(sex.equals("Male")){

            String[] firstname = new String[]{"Akmenos", "Amnon", "Barakas", "Damakos", "Ekemon", "Kairon", "Leucis", "Melech", "Mordai", "Morthos", "Pelaios", "Skamos", "Therai",
                    "Art", "Fear", "Hope", "Music", "Nowhere", "Poetry", "Quest", "Random", "Sorrow", "Torment"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            name = firstname[first] ;

        }else{

            String[] firstname = new String[]{"Akta", "Anakis", "Criella", "Damaia", "Ea", "Kallista", "Lerissa", "Makaria", "Nemeia", "Orianna", "Phelaia", "Rieta",
                    "Art", "Fear", "Hope", "Music", "Nowhere", "Poetry", "Quest", "Random", "Sorrow", "Torment"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            name = firstname[first] ;
        }

        return name;
    }


    public String generateGnomeName(String sex){

        String name = "";

        if(sex.equals("Male")){

            String[] firstname = new String[]{"Alston", "Alvyn", "Boddynock", "Brocc", "Burgell", "Dimble", "Eldon", "Erky", "Fonkin", "Frug", "Gerbo", "Gimble", "Glim",
                    "Jebeddo", "Kellen", "Nam foodle", "Orryn", "Roondar", "Seebo", "Sindri", "Warryn", "Wrenn", "Zook","Aleslosh", "Badger", "Cloak", "Doublelock", "Ku", "Oneshoe", "Sparklegem" , "Stump"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            name = firstname[first];

        }else{

            String[] firstname = new String[]{"Bimpnottin", "Breena",
                    "Caramip", "Carlin", "Donella", "Duvamil", "Ella", "Ellyjobell", "Ellywick", "Lilli", "Loopmottin", "Lorilla", "Mardnab", "Nissa", "Nyx", "Oda", "Orla",
                    "Roywyn", "Shamil", "Tana", "Waywocket", "Zanna","Aleslosh", "Badger", "Cloak", "Doublelock", "Ku", "Oneshoe", "Sparklegem" , "Stump"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            name = firstname[first];

        }

        return name;
    }


    public String generateHalflingName(String sex){

        String name = "";

        if(sex.equals("Male")){

            String[] firstname = new String[]{"Alton", "Ander", "Cade", "Corrin", "Eldon", "Errich", "Finnan", "Garret", "Lindal", "Lyle", "Merric", "Milo", "Osborn", "Perrin", "Reed",
                    "Roscoe", "Wellby"};

            String[] surname = new String[]{"Brushgather", "Goodbarrel", "Greenbottle", "High-hill", "Hilltopple", "Leagallow",
                    "Tealeaf", "Thorngage", "Tosscobble", "Underbough"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }else {

            String[] firstname = new String[]{"Andry", "Bree", "Callie", "Cora", "Euphemia", "Jillian", "Kithri", "Lavinia", "Lidda", "Merla", "Nedda", "Paela", "Portia",
                    "Seraphina", "Shaena", "Trym", "Vani", "Verna"};

            String[] surname = new String[]{"Brushgather", "Goodbarrel", "Greenbottle", "High-hill", "Hilltopple", "Leagallow",
                    "Tealeaf", "Thorngage", "Tosscobble", "Underbough"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }


        return name;
    }


    public String generateHalfOrcName(String sex){
        String name = "";

        if(sex.equals("Male")){

            String[] firstname = new String[]{"Aseir", "Haseid", "Kheed", "Zasheir", "Fodel", "Glar", "Grigor", "Igan", "Ivor", "Kosef", "Mival", "Pavel", "Sergor", "Darvin", "Dorn",
                    "Evendur", "Gorstag", "Helm", "Morn", "Randal", "Stedd", "Ander", "Blath", "Bran", "Frath", "Geth", "Lander", "Luth", "Malcer", "Stor", "Taman",
                    "Bareris", "Kethoth", "Mumed", "Urhur", "Borivik", "Faurgar", "Jandar", "Kanithar", "Madislak", "Ralmevik", "Shaumar", "Vladislak", "Chen", "Chi",
                    "Fai", "Jiang", "Jun", "Lian", "Long", "Meng", "Shan", "Wen", "Anton", "Diero", "Marcon", "Pieron", "Rimardo", "Romero", "Salazar", "Umbero",
                    "Dench", "Feng", "Gell", "Henk", "Holg", "Imsh", "Keth", "Krusk", "Mhurren", "Ront", "Shump", "Thokk"};

            String[] surname = new String[]{"Dumein", "Jassan", "Khalid", "Mostana", "Pashar", "Rein", "Amblecrown", "Buckman", "Dundragon", "Evenwood", "Greycastle",
                    "Tallstag", "Bersk", "Chernin", "Dotsk", "Kulenov", "Marsk", "Nemetsk", "Shemov", "Starag", "Brightwood", "Helder", "Hornraven", "Lackman",
                    "Stormwind", "Windrivver", "Anskuld", "Fezim", "Hahpet", "Nathandem", "Sepret", "Chergoba", "Dyernina", "Ulmokina", "Chien", "Huang",
                    "Kao", "Kung", "Lao", "Ling", "Mei", "Pin", "Shin", "Sum", "Tan", "Wan", "Agosto", "Astorio", "Calabra", "Domine", "Falone", "Marivaldi", "Pisacar"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }else{

            String[] firstname = new String[]{"Atala", "Ceidil", "Hama", "Jasmal", "Meilil", "Yasheira", "Zasheida", "Arveene", "Esvele", "Jhessail", "Kerri", "Lureene", "Miri", "Rowan",
                    "Tessele", "Alethra", "Kara", "Katernin", "Mara", "Natali", "Olma", "Tana", "Zora", "Betha", "Cefrey", "Kethra", "Mara", "Olga", "Silifrey", "Westra",
                    "Arizima", "Chathi", "Nephis", "Nulara", "Murithi", "Sefris", "Thola", "Umara", "Zolis", "Hulmarra", "Immith", "Imzel", "Navarra", "Shevarra",
                    "Tammith", "Yuldra", "Bai", "Chao", "Jia", "Lei", "Mei", "Qiao", "Shui", "Tai", "Balama", "Dona", "Faila", "Jalana", "Luisa", "Marta", "Quara", "Selise", "Vonda", "Baggi", "Emen",
                    "Engong", "Kansif", "Myev", "Neega", "Ovak", "Ownka", "Shautha", "Sutha", "Vola", "Volen", "Yevelda", "Adran", "Aelar", "Aramil", "Arannis", "Aust", "Berrian", "Carric" , "Enialis", "Erdan", "Erevan", "Galinndan", "Hadarai", "Heian", "Himo",
                    "Immeral", "Laucian", "Mindartis", "Paelias", "Peren", "Quarion", "Riardon", "Rolen", "Soveliss", "Thamior", "Tharivol", "Theren", "Varis"};

            String[] surname = new String[]{"Dumein", "Jassan", "Khalid", "Mostana", "Pashar", "Rein", "Amblecrown", "Buckman", "Dundragon", "Evenwood", "Greycastle",
                    "Tallstag", "Bersk", "Chernin", "Dotsk", "Kulenov", "Marsk", "Nemetsk", "Shemov", "Starag", "Brightwood", "Helder", "Hornraven", "Lackman",
                    "Stormwind", "Windrivver", "Anskuld", "Fezim", "Hahpet", "Nathandem", "Sepret", "Chergoba", "Dyernina", "Ulmokina", "Chien", "Huang",
                    "Kao", "Kung", "Lao", "Ling", "Mei", "Pin", "Shin", "Sum", "Tan", "Wan", "Agosto", "Astorio", "Calabra", "Domine", "Falone", "Marivaldi", "Pisacar",};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }

        return name;
    }


    public String generateHalfElfName(String sex){
        String name = "";

        if(sex.equals("Male")){

            String[] firstname = new String[]{"Aseir", "Haseid", "Kheed", "Zasheir", "Fodel", "Glar", "Grigor", "Igan", "Ivor", "Kosef", "Mival", "Pavel", "Sergor", "Darvin", "Dorn",
                    "Evendur", "Gorstag", "Helm", "Morn", "Randal", "Stedd", "Ander", "Blath", "Bran", "Frath", "Geth", "Lander", "Luth", "Malcer", "Stor", "Taman",
                    "Bareris", "Kethoth", "Mumed", "Urhur", "Borivik", "Faurgar", "Jandar", "Kanithar", "Madislak", "Ralmevik", "Shaumar", "Vladislak", "Chen", "Chi",
                    "Fai", "Jiang", "Jun", "Lian", "Long", "Meng", "Shan", "Wen", "Anton", "Diero", "Marcon", "Pieron", "Rimardo", "Romero", "Salazar", "Umbero"};

            String[] surname = new String[]{"Dumein", "Jassan", "Khalid", "Mostana", "Pashar", "Rein", "Amblecrown", "Buckman", "Dundragon", "Evenwood", "Greycastle",
                    "Tallstag", "Bersk", "Chernin", "Dotsk", "Kulenov", "Marsk", "Nemetsk", "Shemov", "Starag", "Brightwood", "Helder", "Hornraven", "Lackman",
                    "Stormwind", "Windrivver", "Anskuld", "Fezim", "Hahpet", "Nathandem", "Sepret", "Chergoba", "Dyernina", "Ulmokina", "Chien", "Huang",
                    "Kao", "Kung", "Lao", "Ling", "Mei", "Pin", "Shin", "Sum", "Tan", "Wan", "Agosto", "Astorio", "Calabra", "Domine",
                    "Falone", "Marivaldi", "Pisacar", "Amakiir", "Amastacia", "Galanodel", "Holimion", "Liadon", "Meliamne", "Nai'lo", "Siannodel", "Xiloscient"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }else{

            String[] firstname = new String[]{"Atala", "Ceidil", "Hama", "Jasmal", "Meilil", "Yasheira", "Zasheida", "Arveene", "Esvele", "Jhessail", "Kerri", "Lureene", "Miri", "Rowan",
                    "Tessele", "Alethra", "Kara", "Katernin", "Mara", "Natali", "Olma", "Tana", "Zora", "Betha", "Cefrey", "Kethra", "Mara", "Olga", "Silifrey", "Westra",
                    "Arizima", "Chathi", "Nephis", "Nulara", "Murithi", "Sefris", "Thola", "Umara", "Zolis", "Hulmarra", "Immith", "Imzel", "Navarra", "Shevarra",
                    "Tammith", "Yuldra", "Bai", "Chao", "Jia", "Lei", "Mei", "Qiao", "Shui", "Tai", "Balama", "Dona", "Faila", "Jalana", "Luisa", "Marta", "Quara", "Selise", "Vonda",
                    "Adrie", "Althaea", "Anastrianna", "Andraste", "Antinua", "Bethrynna", "Birel", "Caelynn", "Drusilia", "Enna", "Felosial", "Ielenia",
                    "Jelenneth", "Keyleth", "Leshanna", "Lia", "Meriele", "Mialee", "Naivara", "Quelenna", "Quillathe", "Sariel", "Shanairra", "Silaqui", "Theirastra",
                    "Thia", "Vadania", "Valanthe"};

            String[] surname = new String[]{"Dumein", "Jassan", "Khalid", "Mostana", "Pashar", "Rein", "Amblecrown", "Buckman", "Dundragon", "Evenwood", "Greycastle",
                    "Tallstag", "Bersk", "Chernin", "Dotsk", "Kulenov", "Marsk", "Nemetsk", "Shemov", "Starag", "Brightwood", "Helder", "Hornraven", "Lackman",
                    "Stormwind", "Windrivver", "Anskuld", "Fezim", "Hahpet", "Nathandem", "Sepret", "Chergoba", "Dyernina", "Ulmokina", "Chien", "Huang",
                    "Kao", "Kung", "Lao", "Ling", "Mei", "Pin", "Shin", "Sum", "Tan", "Wan",
                    "Agosto", "Astorio", "Calabra", "Domine", "Falone", "Marivaldi", "Pisacar", "Amakiir", "Amastacia", "Galanodel", "Holimion", "Liadon", "Meliamne", "Nai'lo", "Siannodel", "Xiloscient"};

            int fbounds = firstname.length; //fbounds is the size of the array of the first name

            int lbounds = surname.length; //lbounds is the size of the array of the first name

            Random rand = new Random();

            int first = rand.nextInt(fbounds);

            int sur = rand.nextInt(lbounds);

            name = firstname[first] + " " + surname[sur];

        }




        return name;
    }







}
