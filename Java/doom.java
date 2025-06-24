// an doom rpg game runs on the terminal using classes and methods in java
//importing libs
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

// the main head of the code it compiles everything in 1 instruction so thats why java slow?
public class doom {
    public static void main(String[] args) {
    Player player = new Player("Alice");

    Difficulty difficulty = new Difficulty();
    difficulty.printDifficulties();
    difficulty.chooseDifficulties();
    // create enemy
    Enemy enemy = new Enemy("Hell Knight", difficulty.getDifficultyId());
    enemy.printStats();
    // create boss and kill a boss for goodies 
    Weapon rewardWeapon = new Weapon("core eject gun", 40);
    Boss boss= new Boss("Mankibus", difficulty.getDifficultyId(),rewardWeapon);

    boss.printStats();
    player.showInv();
    player.cooldown();
    player.usePunch();
    player.takeDmg(20);

    // Start battle loop
    Scanner scanner = new Scanner(System.in);
    while (player.isAlive() && enemy.isAlive()) {
        System.out.println("\nPress Enter to use Thunder Punch...");
        scanner.nextLine();
        player.usePunch();

        // Apply Thunder Punch damage manually
        Random rand = new Random();
        int chance = rand.nextInt(100);
        int damage = (chance < 10) ? 100 : 50;
        enemy.takePlayer(damage);

        if (!enemy.isAlive()) {
            System.out.println("Enemy defeated!");
            break;
        }
        if (!boss.isAlive()) {
            System.out.println("You defeated " + boss.name + "!");
            Weapon newWeapon = boss.getRewardWeapon();
            player.inventory.add(newWeapon);
            System.out.println("You gained a new weapon: " + newWeapon.name);
        }

        // Enemy attacks
        int enemyDamage = enemy.attack();
        player.takeDmg(enemyDamage);
    }
    scanner.close();
}

    
}
// ======difficulty class for SO the player can choose skill lvl======
class Difficulty {
    // decalaring the varaible that will display the text so the player can choose the lvl etc...
    String[] levels = {"I am too young to die", "Bring it on", "Nightmare", "ULTRAKILL MODE"};
    String selected = "Bring it on"; // Default fallback

    // function to display the levels if the you want a better fun challenge go on!
    public void printDifficulties() {
        for (String level : levels) {
            System.out.println(level);
        }
    }
    // function to take the user input and choose the skill level
    public void chooseDifficulties() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your choice (1-" + levels.length + "): ");
            int choice=scanner.nextInt();
            if(choice >= 1 && choice <=levels.length){
                selected = levels[choice - 1];
                System.out.println("you choosed" + selected);
            }else{
                System.out.println("error");
            }
        }
    }
    public String getDifficultyId(){
        return selected;
    }
}
// ========player class creating the stats=========
class Player{
    String name;
    ArrayList<Weapon> inventory= new ArrayList<>();
    float health=100f;
    int thunderPunchCharge=0;
    final int maxCharge=5;
    // displays the character name i named alice idk maybe for my future 3d fps game
    Player(String name){
        this.name = name;
        System.out.println("Welcome," +name+ "!");
        loadWeapons();
    }
    // creating weapons i know its from ultrakill
    private void loadWeapons(){
        inventory.add(new Weapon("revolver",23));
    }
    // eh it displays the player inventory
    public void showInv(){
        System.out.println("\n Your weapons:");
        for (Weapon w: inventory){
            w.printStats();
        }
    }
    // the cooldown keep the punch from being spammed tho the game isn't a thing
    public void cooldown(){
        thunderPunchCharge +=50;
        if (thunderPunchCharge >50) {
            thunderPunchCharge=maxCharge;
        }
        System.out.println("Thunder Punch Charge:"+thunderPunchCharge + "/" +maxCharge);
    }
    // funcrtion to allow the player to use the melle action you know GOTTA punch them all!
   public void usePunch(){
    if (thunderPunchCharge >=maxCharge) {
        System.out.println("THUNDER PUNCH ACTIVATED! Massive damage dealt.");
        thunderPunchCharge=0;
        // health the player upon using the attack gaings health for enemies
        health+=35;
        if (health >100f) {
            health=100f;
        }
        Random rand=new Random();
        int chance = rand.nextInt(100); // range of 0 to 99 
        int damage=(chance < 10) ? 100:50;
        if (chance < 10){
            damage=100; 
            System.out.println("YOU dealt massive damage: " + damage);
        }else{
            damage = 50; // Normal Thunder Punch damage
            System.out.println("You dealt: " + damage + " damage.");
            System.out.println("Health restored. Current Health: " + health);
        }
        damage = 50; // Normal Thunder Punch damage
        System.out.println("You dealt: " + damage + " damage.");
    }else{
        System.out.println("Not enough energy. Current: " + thunderPunchCharge + "/" + maxCharge);
    }
   }
   // function to give the player damage
   public void takeDmg(float amount){
    health -=amount;
    if (health < 0) {
        health=0;
    }
    System.out.println("You took " + amount + " damage. Current Health: " + health + "/100");
    // if the player health goes to zero preatty much game over for you.
    if (health==0) {
        System.out.println("YOU died");
    }
   }
   public boolean isAlive(){
        return health >0;
   }
}

// ====== Weapon Class for the player weapons ======
class Weapon {
    String name;
    int damage;

    Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
    public void printStats() {
        System.out.println("Weapon: " + name + " | Damage: " + damage);
    }
}

//====enemy class for the fights of course like how you think the game would be=====
class Enemy{
    String name;
    int health;
    int damage;

    Enemy(String name,String difficulty){
        this.name=name;
        enemyLvldifficulty(difficulty);
    }
    // function to determine what are the stats of the enemy depending on the choosen lvl skill
    private void enemyLvldifficulty(String difficulty){
        switch (difficulty) {
            case "I am too young to die":
                health=50;
                damage=20;
                break;
            case "Bring it on":
                health=55;
                damage=25;
                break;
            case "Nightmare":
                health=90;
                damage=35;
                break;
            case "ULTRAKILL MODE":
                health=120;
                damage=55;
                break;
            default:
                health=100;
                damage=21;
                break;
        }
    }
    // displays enemy stats
    public void printStats(){
        System.out.println("Enemy: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
    }
    // enemy reccives damage
    public void takePlayer(int amount){
        health-=amount;
        if (health < 0) {
            health=0;
        }
        System.out.println(name + " took " + amount + " damage. Remaining Health: " + health);   
    }
    // determines if enemy is dead or alive
    public boolean isAlive(){
        return health >0;
    }
    // function to enmemy attack
    public int attack(){
        System.out.println(name + " attacks for " + damage + " damage!");
        return damage;
    }
}

// boss class also player gains weapons from killing them
class Boss extends Enemy {
    Weapon rewardWeapon;

    Boss(String name, String difficulty, Weapon reward) {
        super(name, difficulty);
        this.rewardWeapon = reward;
    }

    public Weapon getRewardWeapon() {
        return rewardWeapon;
    }
    public boolean isAlive(){
        return health>0;
    }
}
