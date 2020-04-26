package com.example.timequest.Entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;


public class TrialQuestion {


    private Integer questionNumber;

    private String question;

    private String option1;

    private String option2;

    private String option3;

    private Integer answerNumber;

    private String quizBackground;

    public TrialQuestion(Integer questionNumber, String question, String option1, String option2, String option3, Integer answerNumber, String quizBackground) {
        this.questionNumber = questionNumber;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNumber = answerNumber;
        this.quizBackground = quizBackground;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public String getQuizBackground() {
        return quizBackground;
    }

    public void setQuizBackground(String quizBackground) {
        this.quizBackground = quizBackground;
    }

    //quiz bank data
    public static ArrayList<TrialQuestion> getTrialQuiz(String civilisation) {
        ArrayList<TrialQuestion> trialQuiz = new ArrayList<>();
        switch (civilisation) {
            case "Spartan Warrior":
                trialQuiz.add(new TrialQuestion(1, "What is the purpose of the Spartan army?", "To express Greek's democratic ideals", "To train tough and disciplined warriors to fight for Greek's democratic ideals", "To fight for the Greek Gods", 2, "d"));
                trialQuiz.add(new TrialQuestion(2, "Which of the following is NOT true?", "Spartan citizens were not allowed to engage in trade", "Spartan warriors were made forced to undertake slave work such as making clothing and farming, to toughen their mentality", "Spartan children were often discarded at birth, if found physically or mentally handicapped", 2, "d"));
                trialQuiz.add(new TrialQuestion(3, "Why were Spartan boys beat if they were caught stealing food?", "Because of the fact that they let themself be caught", "Because stealing is against Spartan idealology", "Because food supply was limited for the Spartan civilisation", 1, "d"));
                trialQuiz.add(new TrialQuestion(4, "What are Spartan boys given at age 12?", "Affection", "A helmet", "A red cloak", 3, "d"));
                trialQuiz.add(new TrialQuestion(5, "What was the ritual that Spartan had to undertake as part of their initiation into adulthood?", "Kratos", "Krypton", "Krypetia", 3, "d"));
                trialQuiz.add(new TrialQuestion(6, "Which of the following is NOT true regarding being voted into a public mess?", "Spartan men are eligible to be voted in at age 20", "If men are not voted in at age 30, they are denied from full Spartan citizenship", "Both of the above are true", 3, "d"));
                trialQuiz.add(new TrialQuestion(7, "Which of the following is true?", "Spartans were not allowed to be married until the age of 20", "Slaves vastly outnumbered the Spartans, causing many Spartans to live in constant fear", "Spartans were warned against drinking alcohol since childhood as that would ruin the prestigious image of the Spartan Army", 2, "d"));
                trialQuiz.add(new TrialQuestion(8, "What are Spartan men constantly competing for?", "To join the formidable phalanx", "To impress Ares - the God of War in hopes that he would support them in battle", "To join the Hippeis - the royal guard of honour consisting of the 300 best warriors", 3, "d"));
                trialQuiz.add(new TrialQuestion(9, "What happens when man in a phalanx is injured or cut down?", "Men behind them would instantly walk up forward and take their place", "The phalanx would come to a halt and defend that man", "The phalanx formation would break and the Spartan soldiers would charge at the enemy", 1, "d"));
                trialQuiz.add(new TrialQuestion(10, "What is my favourite holiday?", "The brutal training regime I've been subjected to my entire life, was basically a holiday to me.", "War", "This is a trick question. None of the above", 2, "d"));
                break;

            case "Roman Legionary":
                trialQuiz.add(new TrialQuestion(1, "How big are our Legions typically?", "6000 men", "300 men", "10000 men", 1, "d"));
                trialQuiz.add(new TrialQuestion(2, "Why is it beneficial to have men of similar height be in the Legionnaire?", "To make the tortoise formation more consistent, thereby more formidable", "To promote equality within the Legionnaire", "To make it harder to differentiate between the soldiers, thereby confusing the enemy", 1, "d"));
                trialQuiz.add(new TrialQuestion(3, "Which of the following is NOT true?", "A single Roman legion once faced off against a horde of 25000 Germanic barbarians and won", "You do not need to be a Roman citizen to join the Legionnaire", "To join the Legionnaire, you would need to be at least 5 and a half feet tall", 2, "d"));
                trialQuiz.add(new TrialQuestion(4, "How were non-Legions repaid for their service?", "Receive pension and a plot of land after 25 years of service", "Gain Roman citizenship only", "Earn a pension at the end of service and Roman citizenship", 3, "d"));
                trialQuiz.add(new TrialQuestion(5, "Why is it beneficial to have harsh penalties for Legion infrations?", "To ensure that Legions are properly operating and monitoring borders of dangerous territories", "To filter out as many underperforming Legions as possible to maintain quality", "To promote equality between all Legions to ensure that motivations are consistent", 1, "d"));
                trialQuiz.add(new TrialQuestion(6, "What was the Legion scutum (body shield) made out of?", "Layered iron armour", "Canvas and Leather covering iron armour", "Layered wood covered by canvas and leather", 3, "d"));
                trialQuiz.add(new TrialQuestion(7, "Which of the following is TRUE?", "Skills of Legion prior to joining military dictate the additional assigned duties ", "Legions have a rotation system so that all members experience each duty", "Non-legion members perform the additional duties, allowing the Legions to focus on enhancing their physical strength", 1, "d"));
                trialQuiz.add(new TrialQuestion(8, "What made Legion attack strategy so successful?", "Limited scouting, close coordination and attacking first with light infantry ", "Heavy scouting, close coordination and attacking first with light infantry", "Limited scouting, attacking first with heavy calvary and then light infantry to fight enemy wings", 2, "d"));
                trialQuiz.add(new TrialQuestion(9, "What is NOT a benefit of the Legionnaire's defensive encampments?", "Excavated ditch surrounding camp provided an obstacle for enemies to attack", "Allows Legions to get closer to the enemy camp without being seen", "High vantage point of encampment towers allowed Legions to shoot arrows at enemies from above", 2, "d"));
                trialQuiz.add(new TrialQuestion(10, "Outside of fighting, what were some rules that Legions had to follow?", "All battlefield spoils were to be equally distributed amongst Legions and could be solf for personal profit", "Legions were strictly not allowed to see any outside members when at an alternate garrison", "Legions were forbidden from marrying and having families unless a senior officer or general", 3, "d"));
                break;

            case "Neanderthal":
                trialQuiz.add(new TrialQuestion(1, "Which of the following statements is true about Neandertals?", "Neandertals had relatively large brow ridges and nose with low sloping foreheads", "Neandertals had smaller than average brains compared to that of the modern human", "Neandertals are less intelligent than modern animals and cannot understand abstract concepts", 1, "d"));
                trialQuiz.add(new TrialQuestion(2, "What did Neandertals ingest to avoid sickness?", "Mammoth meat", "Lichens and mosses", "Unpleasant fungus", 3, "d"));
                trialQuiz.add(new TrialQuestion(3, "How did Neandertals draw and leave imprints on cave walls?", "Mixing vegetable pigment, blood and dirt", "Mixing mammoth fat with dirt and blood", "Mixing dried reed with dirt and blood", 2, "d"));
                trialQuiz.add(new TrialQuestion(4, "Which areas did the Neanderthals inhabit?", "Between Europe's Altantic Coast and Central Asia", "The Americas", "Asia", 1, "d"));
                trialQuiz.add(new TrialQuestion(5, "What are the roles and responsibilities of male Neanderthals?", "Hunt for game and other meats", "Nurse and care for young children", "Forage forest for berries and vegetables", 1, "d"));
                trialQuiz.add(new TrialQuestion(6, "What modern traditions did Neanderthals NOT share with humans?", "Took care of the elderly and those who could no longer provide value to group", "Engage in trade for items", "Left the dead unburied and exposed", 3, "d"));
                trialQuiz.add(new TrialQuestion(7, "How did Neanderthals communicate?", "Combination of proto-language and body language", "Words and body language", "Proto-language", 1, "d"));
                trialQuiz.add(new TrialQuestion(8, "Why were mammoths the preferred prey for Neanderthals?", "Tools used were designed for throwing at mammoths", "Lack of speed made it easier to attack and kill", "Mammoth meat lasts longer than other meats", 2, "d"));
                trialQuiz.add(new TrialQuestion(9, "What were the tools used by Neanderthals to hunt?", "Bone needles and axe", "Spears and sharpened rocks", "Bow and arrows", 2, "d"));
                trialQuiz.add(new TrialQuestion(10, "How did Neanderthals start fires?", "Using rocks and flint", "Used powder magnesium dioxide and rocks", "By keeping embers from discovering fires from natural phenomen ", 3, "d"));
                break;

            case "Viking":
                trialQuiz.add(new TrialQuestion(1, "What was most of our warriors life spent on doing?", "War", "Farming", "Sailing", 2, "d"));
                trialQuiz.add(new TrialQuestion(2, "What region were we originally from before spreading into other territory?", "Russia", "Netherlands", "Scandinavia", 3, "d"));
                trialQuiz.add(new TrialQuestion(3, "What made life hard in the Viking age? ", "The constant fighitng and desire to conquer", "The land was hard to farm on and food was difficult to produce", "There weren't many women and the viking gene pool favours men to be born, leading to a reprodction issue", 2, "d"));
                trialQuiz.add(new TrialQuestion(4, "From around how many viking households in a village?", "15-50", "50-100", "100-150", 1, "d"));
                trialQuiz.add(new TrialQuestion(5, "What were slaves also called in the viking age?", "Slaves", "Thralls", "Peasants ", 2, "d"));
                trialQuiz.add(new TrialQuestion(6, "In tough seasons where there is a great food shortage, what did we resort to eating?", "Wild , potentially dangerous mushrooms", "Thralls", "Their household pets", 2, "d"));
                trialQuiz.add(new TrialQuestion(7, "What were the iconic features of our warships?", "A large sail, oars, and a handcrafted headpost on the front of the ship", "Canons on the side to shoot at enemies", "A launcher on the boat that propels axes at enemies", 1, "d"));
                trialQuiz.add(new TrialQuestion(8, "What was one way someone could identify your statuts in viking society? ", "How beautiful your wife is", "The type of weapon and armour that you are wearing ", "How luscious and long your beard and hair is", 2, "d"));
                trialQuiz.add(new TrialQuestion(9, "What were the main weapons that our warriors wielded?", "Spears, shields and axes", "Guns and grenades", "Swords", 1, "d"));
                trialQuiz.add(new TrialQuestion(10, "Why were axes the preferred weapon?", "Axes were far easier to make and doubled as a farm tool", "They seemed more manly than other weapons", "You could throw axes but not weapons such as a sword", 1, "d"));
                break;

            case "Qing Eunuch":
                trialQuiz.add(new TrialQuestion(1, "At what age did Emperor Qing come into power?", "6", "13", "18", 2, "d"));
                trialQuiz.add(new TrialQuestion(2, "What was the primary purpose in having the terracotta warriors built?", "Because the Qin Dynasty loved arts and crafts", "It was a tradition passed through generations", "Emperor Qin wanted an army to accompany him into his next life so he can continue ruling", 3, "d"));
                trialQuiz.add(new TrialQuestion(3, "What did the empty 4th chamber of the necropolis suggest?", "Emperor Qin used an empty room for meditating", "Emperor Qin died before the completion of the project", "It was for his wives", 2, "d"));
                trialQuiz.add(new TrialQuestion(4, "What does terracotta actually mean?", "Reddish brown clay", "A Type of Metal ", "Formidable ", 1, "d"));
                trialQuiz.add(new TrialQuestion(5, "How were the vast underground chambers of Emperor Qin originally found?", "A teracotta warrior escaped and led farmers to the chamber", "There were crypted signs that led to it ", "Farmers stumbled upon it when looking down a well", 3, "d"));
                trialQuiz.add(new TrialQuestion(6, "What else was sculpted for Emperor Qin to accompany him to the after life?", "Chopsticks and eating utensils", "Horse carriages ", "Basketballs", 2, "d"));
                trialQuiz.add(new TrialQuestion(7, "When did Emperor Qin begin building his underground necropolis?", "1 year into his reign", "5 years into his reign", "Before he became emperor", 1, "d"));
                trialQuiz.add(new TrialQuestion(8, "How long did the Qing mutlicultural dynasty last? ", "Three centuries", "Four centuries", "Five centuries", 1, "d"));
                trialQuiz.add(new TrialQuestion(9, "What was NOT one of the challenges the dynasty faced in the late 18th century?", "Not enough population growth", "Corruption ", "Internal revolts", 1, "d"));
                trialQuiz.add(new TrialQuestion(10, "Why hasn't Emperor Qin's tomb been excavated?", "It is impossible to access because of the formidable terracotta warriors guarding it", "There is no way to expose it without damaging the tombs integrity ", "Excavators haven't been bothered to and it is not a priority", 2, "d"));
                break;

            case "Egyptian Man":
                trialQuiz.add(new TrialQuestion(1, "What shape of structure were we famous for constructing?", "Cylinders", "Cubes", "Pyramids", 3, "d"));
                trialQuiz.add(new TrialQuestion(2, "What infestation were we subject to?", "Locusts", "Lice", "Fruit fly", 2, "d"));
                trialQuiz.add(new TrialQuestion(3, "For how many years was Tutankhamuns tomb left undisturbed for?  ", "3000", "5000", "10000", 1, "d"));
                trialQuiz.add(new TrialQuestion(4, "What was peculiar about Tutankhamuns mummification? ", "There was art painted on it", "The 90 degree erection", "His whole body was dipped in gold", 2, "d"));
                trialQuiz.add(new TrialQuestion(5, "What were condoms at the time made out of?", "Latex", "Cows intestine", "Sheep intestine", 3, "d"));
                trialQuiz.add(new TrialQuestion(6, "Why are the bodies of beautiful women left to decay for a few days after death?", "It was claimed to be good for their skin", "Some Egyptian men were not trrusted and found to engage in necrophelia ", "It was a part of their culture to do so", 2, "d"));
                trialQuiz.add(new TrialQuestion(7, "How did the parasytic worms enter the bodies of the Egyptians?", "Through contaminated water", "Through contaminated food ", "Through sexual transmission ", 1, "d"));
                trialQuiz.add(new TrialQuestion(8, "How did we try to deal with our issue of obesity?", "Exerciesed more and reduced diet ", "Took laxatives 3 times a month", "Had liposuction done", 2, "d"));
                trialQuiz.add(new TrialQuestion(9, "What was the phrase coined by us to proctologists?", "Shepherd of the Anus", "Deposit examiner", "Anus healer", 1, "d"));
                trialQuiz.add(new TrialQuestion(10, "How did the Egyptians believe enemas came to be?", "Dcotors came up with the concept ", "Their god developed teh enema and gave it to men as a gift ", "Ancestors had left paintings depicting what an enema does", 2, "d"));
                break;

            case "North Sentinel Islander":
                trialQuiz.add(new TrialQuestion(1, "Where is the North Sentinel Island located?", "West of the other Andaman Islands", "East of the other Andaman Islands", "North of the other Andaman Islands", 1, "d"));
                trialQuiz.add(new TrialQuestion(2, "Around how long have we been isolated from the rest of the world?", "1000 years", "15000 years", "60000 years", 2, "d"));
                trialQuiz.add(new TrialQuestion(3, "What are we experts at?", "Making fire", "Agriculture", "Hunting", 3, "d"));
                trialQuiz.add(new TrialQuestion(4, "What weapons do we NOT typically use to hunt?", "Harpoons", "Flatbows", "Clubs", 3, "d"));
                trialQuiz.add(new TrialQuestion(5, "How did we greet a team of anthropologist vistors in 1974?d", "We showed them around the island and helped them film their documentary", "With a bunch of ARROWS!!!", "We hid and avoided them", 2, "d"));
                trialQuiz.add(new TrialQuestion(6, "When was our only friendly encounter with you outsider people?", "1991", "1974", "2006", 1, "d"));
                trialQuiz.add(new TrialQuestion(7, "What does footage from our friendly encounter with you outsiders show?", "Sentinelese people touching the expiditioners out of curiousity", "Sentinelese people hailing the visitors with arrows", "Sentinelese people dancing with the visitors", 1, "d"));
                trialQuiz.add(new TrialQuestion(8, "What happened to the fishermen who came close to our island in 2006?", "We killed them", "I would rather not know....", "They joined our tribe", 1, "d"));
                trialQuiz.add(new TrialQuestion(9, "The India government declared travel within ____ miles within our island as prohibited.", "3", "5", "9", 1, "d"));
                trialQuiz.add(new TrialQuestion(10, "How large is our tribe?", "15 people", "500 people", "There isn't a clear answer", 3, "d"));
                break;

            case "Cossack Warrior":
                trialQuiz.add(new TrialQuestion(1, "Which treaty ended hostilities between Polish-Lithuanian Commonwealth and the Ottoman Empire", "Treaty of Scandanavia", "Treaty of Zurawno", "Treaty of Mylitene", 2, "d"));
                trialQuiz.add(new TrialQuestion(2, "Why did Cossack Leader Petro Doroshenko ally with the Ottoman Empire?", "Russian forces were invading Cossack territory resulting in Cossack forces requiring more men", "Wanted to combine forces with the Ottoman Empire to enslave Polish peasants after the downfall of the Cossack - Polish alliance", "Reclaim independence and reunite fractured Cossack state after shifting Polish-Moscow alliances", 3, "d"));
                trialQuiz.add(new TrialQuestion(3, "What are the conditions in becoming a member of the Cossack Batallion?", "Must speak a Slavic language, must undergo 5 years of training and remain unmarried", "Any race, must undergo 7 years of training and remain unmarried ", "Must be a Christian Orthodox, must undergo 3 years of training and remain unmarried", 2, "d"));
                trialQuiz.add(new TrialQuestion(4, "Which of the following is NOT a reason why the Cossack - Ottoman Empire alliance caused outrage?", "Allying with Muslims against fellow Christians was looked down upon", "Ottoman allies ravaged towns and enslaved peasants", "Ottoman troops had attempted to invade Cossak territory a year prior to alliance created", 3, "d"));
                trialQuiz.add(new TrialQuestion(5, "What are the Cossack values?", "Independence, equality, and fraternity", "Conquering, power, fraternity", "Oppression, expansion, fraternity, ", 1, "d"));
                trialQuiz.add(new TrialQuestion(6, "Which of the following is NOT correct about the Sich?", "Sich's location shifts with the tide of the Cossack's military action", "The centre of Sich life is the military barracks where the majority of the batallion and regime live", "Settlement has administrative buildings, military base and schools", 2, "d"));
                trialQuiz.add(new TrialQuestion(7, "What were the Cossacks known for in the 17th century?", "Infamous for being independent and defiant that used guerilla warfare tactics to enable violent attacks to maintain independence", "Fighters of the Polish-Lithuanian Commonwealth that aimed to expand Polish borders", "Russian military warriors that conquered Siberia and Central Asia in return for land and privileges", 1, "d"));
                trialQuiz.add(new TrialQuestion(8, "Who was Ivan Sirko planning his first attack on?", "Polish forces", "Ottoman Empire forces", "Russian forces", 2, "d"));
                trialQuiz.add(new TrialQuestion(9, "Stepan's 180 men Cossack Batallion consisted of..", "Strictly Orthodox Christians that speak Slavic languages", "Orthodox Christians, Greeks, Tatars and Mongolian Kalmyks", "Greeks, Russians and Polish forces", 2, "d"));
                trialQuiz.add(new TrialQuestion(10, "What was the aim of the 1659 Treaty of Hadiach?", "To repair alliance between Polish and Cossack forces and create a Polish - Lithuanian - Rutenian Commonwealth", "To overcome the Russian-Polish differences and establish a treaty that freed Cossacks from Polish influence under the protection of the Russian Tsar", "To create the Russian-Polish alliance that recognised Cossacks as rebels against Runethian property and land", 1, "d"));
                break;

            case "Norman Crusader":
                trialQuiz.add(new TrialQuestion(1, "In what year did the Normans sail towards England with intent to conquer", "1102", "1066", "1041", 2, "d"));
                trialQuiz.add(new TrialQuestion(2, "Where did the name 'Norman' come from?", "It was named after the Captain of the ships", "Name given to invaders by French locals because of the direction that they came from", "Named after King Norman Frank", 2, "d"));
                trialQuiz.add(new TrialQuestion(3, "Which of the following is NOT true?", "Normandy, France is named after the Normans", "Normans converted from Norse to Christianity", "Norman negotiations failed with Viking Leader in 911", 3, "d"));
                trialQuiz.add(new TrialQuestion(4, "Where was the battle between the Normans and England?", "Normandy", "Hastings", "Scandanavia", 2, "d"));
                trialQuiz.add(new TrialQuestion(5, "How did the battle between the Normans and England end?", "The King of England got shot in the eye", "The English Army starved", "The Duke of Normandy got killed by an axe to the heart", 1, "d"));
                trialQuiz.add(new TrialQuestion(6, "Which countries did Normans NOT conquer", "Ireland", "Iceland", "Wales", 2, "d"));
                trialQuiz.add(new TrialQuestion(7, "When was the First Crusade?", "1089 - 1093", "1095-1099", "1075-1088", 2, "d"));
                trialQuiz.add(new TrialQuestion(8, "Which kingdom did Normans form in 1130?", "Kingdom of Sicily", "Kingdom of Morocco", "Kingdom of Macedonia", 1, "d"));
                trialQuiz.add(new TrialQuestion(9, "What is the name of the tapestry which shows the story of the Norman conquest?", "The Bayeux Tapestry", "The Hastings Tapestry", "The Norman Tapestry", 1, "d"));
                trialQuiz.add(new TrialQuestion(10, "Who was the King of England before the Norman Conquest?", "William of Normandy", "Edward the Confessor", "Harold Godwinson", 3, "d"));
                break;

            case "Athenian Man":
                trialQuiz.add(new TrialQuestion(1, "Athenian male's roles and responsibilities do NOT include:", "Attending the meeting of the Ekklėsia to make political decisions", "Purchase food and wine", "Teach children domestic skills", 3, "d"));
                trialQuiz.add(new TrialQuestion(2, "Who were on the opposing sides of the Peloponnesian war?", "Athens and Rome", "Athens and Sparta", "Sparta and Troy", 2, "d"));
                trialQuiz.add(new TrialQuestion(3, "Why are daughters considered liabilities in Athenian culture?", "They require dowries to find husbands", "A slave needs to teach them reading and writing", "They heavily influence politics", 1, "d"));
                trialQuiz.add(new TrialQuestion(4, "Which of the following is TRUE?", "A plague wiped out 75% of the Athenian population during the Peloponnesian War", "Any native-born is able to gain Athenian citizenship", "To attend the citizen meeting you must be a native born male who has completed military training", 3, "d"));
                trialQuiz.add(new TrialQuestion(5, "At what age would Athenian females generally be married?", "12-20", "20-25", "8-12", 2, "d"));
                trialQuiz.add(new TrialQuestion(6, "Which of the following is NOT one of Ancient Athen's strengths?", "Has a superior fleet and maritime empire", "Has a strong army on land", "Has a strong economy and trade society", 2, "d"));
                trialQuiz.add(new TrialQuestion(7, "What was the Agora NOT used for?", "To hold political debate", "House a marketplace", "Hold sports tournaments", 3, "d"));
                trialQuiz.add(new TrialQuestion(8, "How do heralds purify the Pynx Hill?", "Sprinkle pig's blood", "Sprinkle vinegar on everyone", "Pour Holy Water down the hill", 1, "d"));
                trialQuiz.add(new TrialQuestion(9, "Which city led a revolt against Athens in 427 BCE", "Troy", "Thrace", "Mytilene", 3, "d"));
                trialQuiz.add(new TrialQuestion(10, "You are an Ancient Athenian citizen if:", "You're a native born male with foreign parents", "Your father is Athenian, your mother can be foreign or Athenian", "You are a male with Athenian parents", 3, "d"));
                break;
        }
        return trialQuiz;

    }
}
