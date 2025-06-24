public class script {

    public static void main(String[] args){
        int age=21;
        boolean status=true;
        String name="ekness";
        float score1=100;
        System.out.println("name: " + name +" status " + status +" age " +age);
        if (status=true) {
            System.out.println("its true");
        }
        else{
            System.out.println("false");
        }
        while (age >100) {
            System.out.print(age);
            age++;
            if (age>30) {
                System.out.println("current age: "+age);
                break;
            }
        }
        for (int score2=50; score2>=100; score1=score2+1){
            System.out.println(score1);
        }
    }
    public static void fuck(String[] args) {
        int score=0;
        String player="ekness";
        boolean isavlive=true;
        float health=100f;
        if (player=="ekness"){
            System.out.println(player);
        }
        else{
            System.out.println("the fuck are you?");
        }
        if (health >100){
            System.out.println("alive");
        }
        else{
            System.out.println("YOU DIED");
        }
        System.out.println(isavlive);
        while (score<0) {
            
        }
        
    }
}