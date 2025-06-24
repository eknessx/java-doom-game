// the code here is an example of the halt condition
public class lesson3 {
    public static void main(String[] args) {
        int result = sum(4, 8); // in this line we declare the int var and we use the method to enter args 4 and 8
        System.out.println("Sum: " + result); // it will display the results out put would be 30
    }
    // the used method to make the halt condition
    public static int sum(int start, int end) {
        if (end > start) { // it will occure if the end greater than start also the halt condition would trigger if the start > end
            return end + sum(start, end - 1);
        } else {
            return end; // base case: when end == start
        }
    }
}