//in this lesson code i made i wanted to make a java code that calculates the percentage of numbers
public class lesson2 {
    public static void main(String[] args) {
        //main variable to store the esitamated percentage
     float data[]={20f,12f,6f,8f,77f,44f};
     
     //number counting thats equal to 0
     int numCount=0;

     System.out.println("Even numbers:");
     //variable to count the length of the array
     float count=data.length;
     
        for (float result : data){
            //Checks if the number is an int or even
            if (result==(int) result&&((int) result)%2==0){
                System.out.println(result);
                numCount++;
            }
        }
        //Calculates the percentage of even numbers and everything 
        float percentage=((float)numCount/count)*100;
        System.out.println("Percentage of even numbers: " + percentage + "%");
    }
}


