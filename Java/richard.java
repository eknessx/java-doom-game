import java.util.Scanner;

public class richard {
        public static void main(String[] args) {
        Calculator insert = new Calculator();
        insert.selectoption();
        insert.chooseOptions();
        System.out.println("Selected Operation: " + insert.getId());
    }
}

// calculator class 
class Calculator{
    String[] options={"+","-","%","*","Random force algo"};
    String deafault="+";

    public void selectoption(){
        for (String option:options){
            System.out.println(option);
        }
    }
    public void chooseOptions(){
        try (Scanner scanner=new Scanner(System.in)){
            System.out.println("WELCOME TO RICHARD CALCULATOR EPIC GAME WITH HIDDEN SECRETS");
            System.out.print("Choose operation (1-"+options.length+"): ");
            int choice=scanner.nextInt();
            if (choice >= 1 && choice <=options.length) {
                deafault=options[choice-1];
                System.out.println("You choosed" +deafault);
            }else{
                System.out.println("error");
            }
        }
    }
    public String getId(){
        return deafault;
    }
}