public class lesson1 {
    public static void main(String[] args) {
        boolean isavlive=false;
        int health=(int)(Math.random()*101);
        int damage=100;
        // creating statements
        if (health>100){
            System.out.println("player health"+health);
            System.out.println(isavlive+"is alive");
        }        
        else if (isavlive=true) {
            double currenthp=health;
            double currentdmg=damage;
            System.out.println("player recived damage");
            System.out.println("player current hp:");
            System.out.println(currenthp-currentdmg);
        }
        else{
            isavlive=false;
            System.out.println(isavlive+" the player died");
        }
        switch (health) {
            // creating 2 cases 1 and 2
            case 1:
                boolean case1= (health<100) ? true : false;
                System.out.print(case1);
                break;
            case 2:
                boolean case2= (health-damage==0) ? true :false;
                System.out.print(case2);
                break;
            case 3:
            boolean case3= (health+damage==0)? true:false;   
            System.out.println(case3);

        }
    }
}