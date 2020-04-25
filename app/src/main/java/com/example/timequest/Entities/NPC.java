package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

public class NPC {

    private int npcID;

    private String npcName;

    //searchterm used for API learning content
    private String searchTerm;

    //what the NPC greets the user with
    private String welcomeSpeech;

    //what the NPC says to the user if they beat the trial
    private String endingSpeech;

    //what the NPC says to the user if they fail the trial
    private String failSpeech;



    //what they look like
    private String npcAvatar;

    //VideoID for video player
    private String videoID;

    //what the NPC says to the user if they fail the trial
    private String perfectSpeech;

    public NPC(int npcID, String npcName, String searchTerm, String welcomeSpeech, String endingSpeech, String failSpeech, String npcAvatar, String videoID, String perfectSpeech) {
        this.npcID = npcID;
        this.npcName = npcName;
        this.searchTerm = searchTerm;
        this.welcomeSpeech = welcomeSpeech;
        this.endingSpeech = endingSpeech;
        this.failSpeech = failSpeech;
        this.npcAvatar = npcAvatar;
        this.videoID = videoID;
        this.perfectSpeech = perfectSpeech;
    }

    public int getNpcID() {
        return npcID;
    }

    public void setNpcID(int npcID) {
        this.npcID = npcID;
    }

    public String getNpcName() {
        return npcName;
    }

    public void setNpcName(String npcName) {
        this.npcName = npcName;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getWelcomeSpeech() {
        return welcomeSpeech;
    }

    public void setWelcomeSpeech(String welcomeSpeech) {
        this.welcomeSpeech = welcomeSpeech;
    }

    public String getEndingSpeech() {
        return endingSpeech;
    }

    public void setEndingSpeech(String endingSpeech) {
        this.endingSpeech = endingSpeech;
    }

    public String getFailSpeech() {
        return failSpeech;
    }

    public void setFailSpeech(String failSpeech) {
        this.failSpeech = failSpeech;
    }

    public String getNpcAvatar() {
        return npcAvatar;
    }

    public void setNpcAvatar(String npcAvatar) {
        this.npcAvatar = npcAvatar;
    }

    public String getVideoID() {
        return videoID;
    }

    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    public String getPerfectSpeech() {
        return perfectSpeech;
    }

    public void setPerfectSpeech(String perfectSpeech) {
        this.perfectSpeech = perfectSpeech;
    }

    public static ArrayList<NPC> addNPCData(){
        ArrayList<NPC> npcs = new ArrayList<>();
        npcs.add(new NPC(1, "Spartan Warrior",
                "spartan_army","You there! You seem like a fine soldier.\n" +
                        "I'm a Spartan! If you beat me, I'll let you join our legendary ranks...\n" +
                        "but I have to warn you...we're no common army. \n I'll leave you at the top of Mount Taygetus if you're not strong enough!",
                "I admit defeat.\n You're truly a warror worthy of our army. Here is a token of our battle...may it bring you good fortune in your travels!",
                "You're no match for the might of Sparta!", "npcspartan","pJJxWdJVpvU","pERFect"));
        npcs.add(new NPC(2, "Viking","vikings",
                "Viking: Ey Hello! What brings you here?\n" +
                        "We're about to set sail to seek out foreign land and bring back some peasants to do our slave work...\n " +
                        "Oh! You want to join us?\n" +
                        "Pass this challenge and you're free to hop on.\n" +
                        "\n", "Viking: A bare pass. As promised, please board before we start sailing after everything has been loaded. Here, take this body armour with you. \n" +
                "It'll be useful if we encounter any unwelcomed guests on the way...\n" +
                "Prove that you're a worthy citizen and I will reward you with more.\n" +
                "\n","Viking: An absolute failure! Stop blocking the way and leave.\n Come back once you've revised your learnings!\n" +
                "\n", "npcviking","FfLYCodzaBA","Viking: An absolute beauty.\n" +
                "Here, take these items with you. You will need our wooden shield for blocking unwelcomed arrows, and a helmet for when the time comes.\n" +
                "\n"));
        npcs.add(new NPC(3, "Roman Legionary","legionary",
                "Roman Legionary: Welcome to Rome, heart of the glorious Roman Empire.\n" +
                        "...\n" +
                        "You want to see the emperor? A peasant like you can't possibly imagine seeing our emperor!\n" +
                        "I see you're looking for trouble...how about this - if you conquer this challenge, I'll let you keep your head! ",
                "You really did it! What a turn of events!\n" +
                        "Maybe you aren't looking for trouble after all. Here, this will prove you're part of the empire now!",
                "Did you really think you could beat an elite Roman like myself? \n" +
                         "The Emperor will never see you at this rate. Come back when you've properly trained!", "npcroman","BIqWKPA83V0","Roman Legionary: Surprise Surprise. \n " +
                "You are indeed a different kind of peasant... Maybe even a potential recruit for our Godly Roman army. Here, take these items. They are made for a tough soldier like you.\n" +
                "\n"));
        npcs.add(new NPC(4, "Athenian Man","Classical_Athens",
                "Ancient Athenian: Oh! Hello there... Thank the heavens you're not a Sparta!\n" +
                        "We are absolutely no match for the Spartan's on land... " +
                        "\nWhat brings you here at dawn? " +
                        "\nWHAT? You want to attend the citizens meeting? You seem like a lanky boy who definitely did not go to military training... " +
                        "\nLook, pass this challenge and we'll see.\n" +
                        "\n", "Ancient Athenian: Hmm a bare pass, but you still passed. Here, take this item. \n " +
                "If you prove to be an exceptional native born male who has completed military training by completing with a perfect score, I will wllingly hand you our Athenian robe and handcrafted pot.\n" +
                "\n","Ancient Athenian: You're an absolute failure!\nRevise our teachings and prove that you are a worthy Athenian native.\n" +
                "\n", "npcathenian","ar8S6virCwM","Ancient Athenian: So you are a superior Athenian who has fought for our holy land!\n" +
                "Please, take all these items. They are gifts from us, only for native Athenians.\n" +
                "\n"));
        npcs.add(new NPC(5, "Norman Crusader","normans",
                "Norman: Bonjour! What brings you here to this deadly place of Hastings?\n" +
                        "Oh, I see you want to fight for our King to help him get what is rightfully his... " +
                        "\nPass this challenge and we will see. We need to determine whether a young chap like you is capable of beheading the King of England!\n" +
                        "\n", "Norman: Looks like you're barely a suitable soldier for our gracious Norman army.\n" +
                "As a kind gesture, please take this shield. It's our traditional kite shield specially made for mounted cavalry." +
                "\nWe have many items for worthy soldiers, only for the ones who complete with a perfect score.\n" +
                "\n","Norman: Echec! Means failure in our old French dialect... It also describes you!" +
                "\nHow dare you come to the battleground of Hastings and bring us trouble, only to prove that you are not a worthy soldier at all! " +
                "\nRevise our teachings and come find us. We might've already conquered England by then! \n" +
                "\n", "npcnorman","Owf5Uq4oFps","Norman: Lovely! I now formally invite you to join our army.\n" +
                "Here, take these items with you. Our traditional kite shield for mounted cavalries when travelling through the country, a battle sword for close-range killings and our metal nasal helmets to protect your head!" +
                "\nNow please, come join us for a small briefing about our plan of attack. \n" +
                "\n"));
        npcs.add(new NPC(6, "Cossack Warrior","cossacks",
                "Cossack Warrior: How beautiful is the serene sunset on the Dnipro river..." +
                        "\nOh hello there! You look like an unfamiliar face. What brings you here? ..... " +
                        "\nI see.. you want to learn about the Cossack nomadic way of life and our different people.\n" +
                        "Alright then, I'll take you along our Sich whilst I tell you about past. " +
                        "\nAre you ready?\n" +
                        "\n", "Cossack Warrior: Fair play my friend. Here, take this handcrafted shashka as a gift from us..." +
                "\nI wish I could give you more items, but they are only for civilians who complete the trial with a perfect score." +
                "\nYou'll have to revise my teachings first.\n" +
                "\n","Cossack Warrior: A fine young man who doesn't have a brain I see!" +
                "\nI cannot believe I brought you around our Sich for you to only fail me." +
                "\nLooks like you should be put into our Sich schools to educate you!" +
                "\nRevise my teachings and take the trial quiz again!\n" +
                "\n", "npccossack","33cP54FcERA","Cossack Warrior: Ah, fantastic!" +
                "\nHere, take these items as a form of reward for being a knowledgable individual." +
                "\nI hope you enjoyed learning about our Cossack culture and heritage." +
                "\nI'll have to go now, we're about to have a feast with dried fish, salted pork fat and lots of wine! Goodbye.\n" +
                "\n"));
        npcs.add(new NPC(7, "Neanderthal","neanderthal",
                "Neanderthal: Oh hello there! Apologies I am building a hunt for my family for the upcoming winter snow." +
                        "\n What brings you here? You can't be one of us... You are perfectly clothed!" +
                        "\n What?! You're from the future, and you say we will be extinct? How dare you!" +
                        "\n What do you even know about us?" +
                        "\n Take this challenge, and then we'll talk.\n" +
                        "\n", "Neanderthal: You do seem to know a bit about us... but not everything!" +
                "\nTake this pig leg and leave. Come back when you prove to me that you actually know who we are!\n" +
                "\n","Neanderthal: Ah ha! I was right." +
                "\nYou fully clothed human being. How can we all be extinct?" +
                "\nIf us Neanderthals can survive the winter storm of Europe and Asia, we can survive anything!" +
                "\n .... Still not satisfied? Check your learnings and prove to us you're right!\n" +
                "\n", "npcneanderthal","G2i2vCu9WMo","Neanderthal: I can't believe it..." +
                "\n Us Neanderthals are innovative and capable of doing anything... and here you come bearing bad news from the future." +
                "\nThis is so sad... Please... take all these items and mark our greatness in the books of History. \n" +
                "\n"));
        npcs.add(new NPC(8, "Qing Eunuch","qing_dynasty",
                "\"Qing Eunuch: Da jia hao!\n" +
                        "Are you also here to serve our Great Emperor of the Qing Dynasty?" +
                        "\n Oh, I see that you're looking to work for our Emperor." +
                        "\n Ok, let me take you on a journey to learn about our Great Dynasty and our way of life." +
                        "\n I will be sure to award you with our traditional items and give you work if you sucessfully pass the test. \"\n" +
                        "\n", "Qing Eunuch: Hmm.. good try." +
                "\nAs promised, here is a traditional chinese scroll with the writings of our Great Emperor. I have a lot more items waiting to be collected, so come back once you have revised your learnings...." +
                "\nOh I have to go now! It's the Emperors meal time. \n" +
                "\n","Qing Eunuch: What a waste of my valuable time!" +
                "\n I should be serving the Emperor's meal right now, but here I am being bothered by a peasant like you." +
                "\n Leave! Come back once you've mastered your learnings. \n" +
                "\n", "npcqing","mP5p4QbvPtc","Qing Eunuch: Our Emperor will be happy to have a knowledgable man serve the Great Dynasty!" +
                "\nHere, take these items with you to officially become one of us." +
                "\nI will also need to purify your body before you start serving the Emperor.\n" +
                "\n"));

        npcs.add(new NPC(9, "North Sentinel Islander","sentinelese"
                ,"North Sentinel Islander: .....What are you doing here? No visitors allowed!" +
                "\nGet off our island! ...You want to learn what happens to trespassers like you?" +
                "\nFine, I'll let you stay with us if you pass our trial...\n",
                "North Sentinel Islander: Ok.. I apologise for the hostility..." +
                        "\nPlease accept this gift from our people - it is our sacred mask." +
                        "\nWe have a few more sacred itmes to give to you, but only if you can complete the trial with a perfect score.\n" +
                        "\n",
                        "North Sentinel Islander: Wow!" +
                                "\nYou dare to uninvitingly come to our island, take my precious time, only to fail a simple trial?\n" +
                        "Leave now!", "npcsentinel","Xk4gunNQVec","North Sentinel Islander: Nice job...you are clearly very knowledgeable of our people." +
                "\nPlease accept these gifts from us." +
                "\nYou are free to stay and film whatever documentary you want....\n"));

        npcs.add(new NPC(10, "Egyptian Man","ancient_egypt",
                "Egyptian: Welcome to Egypt. I hope your journey along the Nile was smooth." +
                        "\nI must apologise for the sails transporting timber and gold up the stream." +
                        "\nSo, what brings you here?..." +
                        "\nI see that you want to learn more about our Egyptian way of life. Here, let me take you on a adventure." +
                        "\nAre you ready?\n" +
                        "\n", "Egyptian: I thought my teachings would be more successful, but at least you passed." +
                "\nHere, take this scepter as a souvenir. We have a lot more items for you, but only if you complete the trial with a perfect score!" +
                "\nI'll have to go and help build the Great Pyramid now. \n" +
                "\n","Egyptian: Were you even paying attention?! " +
                "\nI have foregone my valuable hours of building the Great Pyramid for our Pharaoh to teach you, and you dare to fail this challenge!" +
                "\nFind me once you've revised your content!\n" +
                "\n", "npcegyptian","QYVZFWHKWKI&t","Egyptian: Our Pharaoh would be so happy to know that a foreigner appreciates the greatness he has created." +
                "\nThank you so much for coming." +
                "\nHere, take these valuable items with you. They represent the Greatness of our ruler, the Pharaoh." +
                "\nHe is as calm and benevolent as the Nile.... I hope you have a safe journey back." +
                "\nI will go back to building the Great Pyramid for our Pharaoh. \n" +
                "\n"));
        return npcs;
    }

}
