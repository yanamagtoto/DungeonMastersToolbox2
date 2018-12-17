package com.example.andres.dungeonmasterstoolbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    public static DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        myDB = new DBHelper(this);

        initializeWiki();

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
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

    public void initializeWiki() {

        //Class inserts henny
        myDB.insertIntoClasses("Barbarian", "A fierce warrior of primitive background who can enter a battle rage.");
        myDB.insertIntoClasses("Fighter", "A master of martial combat, skilled with a variety of weapons and armor.");
        myDB.insertIntoClasses("Paladin", "A holy warrior bound to a sacred oath.");
        myDB.insertIntoClasses("Bard", "An inspiring magician whose power echoes the music of creation.");
        myDB.insertIntoClasses("Sorcerer", "A spellcaster who draws on inherent magic from a gift or bloodline.");
        myDB.insertIntoClasses("Wizard", "A scholarly magic-user capable of manipulating the structures of reality.");
        myDB.insertIntoClasses("Warlock", "A wielder of magic that is derived from a bargain with an extraplanar entity.");
        myDB.insertIntoClasses("Cleric", "A priestly champion who wields divine magic in service of a higher power.");
        myDB.insertIntoClasses("Druid", "A priest of the Old Faith, wielding the powers of nature—moonlight and plant growth, fire and lightning—and adopting animal forms.");
        myDB.insertIntoClasses("Monk", "A master of martial arts, harnessing the power of the body in pursuit of physical and spiritual perfection.");
        myDB.insertIntoClasses("Ranger", "A warrior who uses martial prowess and nature magic to combat threats on the edges of civilization.");
        myDB.insertIntoClasses("Rogue", "A scoundrel who uses stealth and trickery to overcome obstacles and enemies.");

        //Faction inserts
        myDB.insertIntoOGFaction("Factionless", "Be free!");
        myDB.insertIntoOGFaction("The Harpers", "An old organization that has risen, been shattered, and risen again several times. Its longevity and resilience are largely due to its decentralized, grassroots, secretive nature, and the near-autonomy of many of its members.");
        myDB.insertIntoOGFaction("The Order of the Gauntlet", "Many paladins and clerics of Tyr, Helm, Torm, and Hoar have joined this new organization, seeing it as—finally—a way of making common cause against the evils abroad in the world. ");
        myDB.insertIntoOGFaction("The Emerald Enclave", "A far-ranging group that opposes threats to the natural world and helps others survive the many perils of the wild. Members of the Emerald Enclave are spread far and wide, and usually operate in isolation. ");
        myDB.insertIntoOGFaction("The Lords Alliance", "A coalition of rulers from cities across Faerûn, who collectively agree that some solidarity is needed to keep evil at bay. The rulers of Waterdeep, Silverymoon, Neverwinter, and other free cities in the region dominate the Alliance. ");
        myDB.insertIntoOGFaction("The Zhentarim", "The Zhentarim seeks to become omnipresent and inescapable, more wealthy and powerful, and most importantly, untouchable. Everyone should fear to cross them. ");

        //Armors Inserts
        myDB.insertIntoEquipment("Padded", "armor", 8.0, "Padded Armor consists of quilted layers of cloth and batting", "5 GP", "Light, AC: 11 + Dex mod, Stealth disadvantage");
        myDB.insertIntoEquipment("Leather", "armor", 10.0, "The Breastplate and shoulder protectors of this armor are made of leather that has been stiffened by being boiled in oil. The rest of the armor is made of softer and more flexible materials.", "10 GP", "Light, AC: 11 + Dex mod");
        myDB.insertIntoEquipment("Studded Leather", "armor", 13.0, "Made from tough but flexible leather, studded leather is reinforced with close-set rivets or spikes.", "45 GP", "Light, AC: 12 + Dex mod, Stealth disadvantage");

        myDB.insertIntoEquipment("Hide", "armor", 12.0, "This crude armor consists of thick furs and pelts. It is commonly worn by Barbarian tribes, evil humanoids, and other folk who lack access to the tools and materials needed to create better armor.", "10 GP", "Medium, AC: 12 + Dex mod");
        myDB.insertIntoEquipment("Chain Shirt", "armor", 20.0, "Made of interlocking metal rings, a Chain Shirt is worn between layers of clothing or leather. This armor offers modest Protection to the wearer’s upper body and allows the sound of the rings rubbing against one another to be muffled by outer layers.", "50 GP", "Medium, AC: 13 + Dex mod");
        myDB.insertIntoEquipment("Scale Mail", "armor", 45.0, "This armor consists of a coat and leggings (and perhaps a separate skirt) of leather covered with overlapping pieces of metal, much like the scales of a fish. The suit includes gauntlets.", "50 GP", "Medium, AC: 14 + Dex mod, Stealth disadvantage");
        myDB.insertIntoEquipment("Breastplate", "armor", 20.0, " This armor consists of a fitted metal chest piece worn with supple leather. Although it leaves the legs and arms relatively unprotected, this armor provides good Protection for the wearer’s vital organs while leaving the wearer relatively unencumbered.", "400 GP", "Medium, AC: 14 + Dex mod");
        myDB.insertIntoEquipment("Half Plate", "armor", 40.0, "Half Plate consists of shaped metal plates that cover most of the wearer’s body. It does not include leg Protection beyond simple greaves that are attached with leather straps.", "750 GP", "Medium, AC: 15 + Dex mod, Stealth disadvantage");

        myDB.insertIntoEquipment("Ring Mail", "armor", 40.0, "This armor is Leather Armor with heavy rings sewn into it. The rings help reinforce the armor against blows from swords and axes. Ring Mail is inferior to Chain Mail, and it's usually worn only by those who can’t afford better armor.", "30 GP", "Heavy, AC: 14, Stealth disadvantage");
        myDB.insertIntoEquipment("Chain Mail", "armor", 55.0, "Made of interlocking metal rings, Chain Mail includes a layer of quilted fabric worn underneath the mail to prevent chafing and to cushion the impact of blows. The suit includes gauntlets.", "75 GP", "Heavy, AC: 16, Stealth disadvantage");
        myDB.insertIntoEquipment("Splint", "armor", 60.0, "This armor is made of narrow vertical strips of metal riveted to a backing of leather that is worn over cloth padding. Flexible Chain Mail protects the joints.", "200 GP", "Heavy, AC: 17, Stealth disadvantage");
        myDB.insertIntoEquipment("Plate", "armor", 65.0, "Plate consists of shaped, interlocking metal plates to cover the entire body. A suit of plate includes gauntlets, heavy leather boots, a visored helmet, and thick layers of padding underneath the armor. Buckles and straps distribute the weight over the body.", "1500 GP", "Heavy, AC: 18, Stealth disadvantage");

        //Weapon Inserts
        myDB.insertIntoEquipment("Club", "weapon", 2.0, "", "5 sp", "Simple Melee, DMG: 1d4 bludgeoning, Light");
        myDB.insertIntoEquipment("Dagger", "weapon", 1.0, "", "2 gp", "Simple Melee, DMG: 1d4 piercing, Finesse, light, thrown (range 20/60)");
        myDB.insertIntoEquipment("Greatclub", "weapon", 10.0, "", "2 sp", "Simple Melee, DMG: 1d8 bludgeoning, Two-handed");
        myDB.insertIntoEquipment("Handaxe", "weapon", 2.0, "", "5 gp", "Simple Melee, DMG: 1d6 slashing, Light, thrown (range 20/60)");
        myDB.insertIntoEquipment("Javelin", "weapon", 2.0, "", "2 gp", "Simple Melee, DMG: 1d6 piercing, Thrown (range 30/120)");
        myDB.insertIntoEquipment("Light Hammer", "weapon", 2.0, "", "2 gp", "Simple Melee, DMG: 1d4 bludgeoning, Light, thrown (range 20/60)");
        myDB.insertIntoEquipment("Mace", "weapon", 4.0, "", "5 gp", "Simple Melee, DMG: 1d6 bludgeoning");
        myDB.insertIntoEquipment("Quarterstaff", "weapon", 4.0, "", "2 sp", "Simple Melee, DMG: 1d6 bludgeoning, Versatile (1d8)");
        myDB.insertIntoEquipment("Sickle", "weapon", 2.0, "", "1 gp", "Simple Melee, DMG: 1d4 slashing, Light");
        myDB.insertIntoEquipment("Spear", "weapon", 3.0, "", "1 gp", "Simple Melee, DMG: 1d6 piercing, Thrown (range 20/60), versatile (1d8)");

        myDB.insertIntoEquipment("Crossbow, light", "weapon", 5.0, "", "25 gp", "Simple Ranged, DMG: 1d8 piercing, Ammunition (range 80/320), loading, two-handed");
        myDB.insertIntoEquipment("Dart", "weapon", .25, "", "5 cp", "Simple Ranged, DMG: 1d4 piercing, Finesse, thrown (range 20/60)");
        myDB.insertIntoEquipment("Shortbow", "weapon", 2.0, "", "25 gp", "Simple Ranged, DMG: 1d6 piercing, Ammunition (range 80/320), two-handed");
        myDB.insertIntoEquipment("Sling", "weapon", 2.0, "", "1 sp", "Simple Ranged, DMG: 1d4 bludgeoning, Ammunition (range 30/120)");

        myDB.insertIntoEquipment("Battleaxe", "weapon", 4.0, "", "10 gp", "Martial Melee, DMG: 1d8 slashing, Versatile (1d10)");
        myDB.insertIntoEquipment("Flail", "weapon", 2.0, "", "10 gp", "Martial Melee, DMG: 1d8 bludgeoning");
        myDB.insertIntoEquipment("Glaive", "weapon", 6.0, "", "20 gp", "Martial Melee, DMG: 1d10 slashing, Heavy, reach, two-handed");
        myDB.insertIntoEquipment("Greataxe", "weapon", 7.0, "", "30 gp", "Martial Melee, DMG: 1d12 slashing, Heavy, two-handed");
        myDB.insertIntoEquipment("Greatsword", "weapon", 6.0, "", "50 gp", "Martial Melee, DMG: 1d8 slashing, Versatile (1d10)");
        myDB.insertIntoEquipment("Halberd", "weapon", 6.0, "", "20 gp", "Martial Melee, DMG: 1d10 slashing, Heavy, reach, two-handed");
        myDB.insertIntoEquipment("Lance", "weapon", 6.0, "", "10 gp", "Martial Melee, DMG: 1d8 slashing, 1d12 piercing, Reach, special");
        myDB.insertIntoEquipment("Longsword", "weapon", 3.0, "", "15 gp", "Martial Melee, DMG: 1d8 slashing, Versatile (1d10)");
        myDB.insertIntoEquipment("Maul", "weapon", 4.0, "", "10 gp", "Martial Melee, DMG: 1d8 slashing, Versatile (1d10)");
        myDB.insertIntoEquipment("Battleaxe", "weapon", 4.0, "", "10 gp", "Martial Melee, DMG: 1d8 slashing, Versatile (1d10)");

        //spells
        myDB.insertIntoSpells("Animal Friendship",1,"This spell lets you convince a beast that you mean it no harm. Choose a beast that you can see within range. It must see and hear you. If the beast’s Intelligence is 4 or higher, the spell fails. Otherwise, the beast must succeed on a Wisdom saving throw or be charmed by you for the spell’s duration. If you or one of your companions harms the target, the spell ends. ","1 Action","30 ft","V, S, M (a morsel of food) ","24 hr",1,0,0,0,0,0);
        myDB.insertIntoSpells("Aid",2,"Your spell bolsters your allies with toughness and resolve. Choose up to three creatures within range. Each target’s hit point maximum and current hit points increase by 5 for the duration. ","1 Action","30 ft","V, S, M (a tiny strip of white cloth)","8 hrs",0,0,1,0,0,0);
        myDB.insertIntoSpells("Absorb Elements",1,"The spell captures some of the incoming energy, lessening its effect on you and storing it for your next melee attack. You have resistance to the triggering damage type until the start of your next turn. Also, the first time you hit with a melee attack on your next turn, the target takes an extra 1d6 damage of the triggering type, and the spell ends. ","Special","Self","S","1 Round",0,1,0,0,0,0);
        myDB.insertIntoSpells("Acid Splash",0,"You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a Dexterity saving throw or take 1d6 acid damage. ","1 Action","60 ft","V, S","Instantaneous",0,0,0,1,0,0);
        myDB.insertIntoSpells("Aganazzar's Scorcher",2,"A line of roaring flame 30 feet long and 5 feet wide emanates from you in a direction you choose. Each creature in the line must make a Dexterity saving throw. A creature takes 3d8 fire damage on a failed save, or half as much damage on a successful one. ","1 Action","30 ft","V, S, M (a red dragon’s scale)","Instantaneous",0,0,0,0,1,0);
        myDB.insertIntoSpells("Armor of Agathys",1," A protective magical force surrounds you, manifesting as a spectral frost that covers you and your gear. You gain 5 temporary hit points for the duration. If a creature hits you with a melee attack while you have these hit points, the creature takes 5 cold damage.  ","1 Action","Self","V, S, M (a cup of water)","1 hr",0,0,0,0,0,1);

        myDB.insertIntoEncounters("Awakened Shrub",0,10);
        myDB.insertIntoEncounters("Blood Hawk",1,25);
        myDB.insertIntoEncounters("Aarakocra",1,50);
        myDB.insertIntoEncounters("Ape",1,100);
        myDB.insertIntoEncounters("Animated Armor",1,200);
        myDB.insertIntoEncounters("Allosaurus",2,450);
        }
    }
