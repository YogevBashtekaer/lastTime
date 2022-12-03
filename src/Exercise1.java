import  java.util.Scanner;
public class Exercise1 {
    public static void printsLargerThenAverageNumbers(){
        Scanner scan = new Scanner(System.in);
        int sizeOfArray = 10;
        int [] array = new int[sizeOfArray] ;
        double average = 0;
        System.out.println("enter "+ sizeOfArray+ " numbers");
        for(int i = 0 ; i < array.length ; i++ ){
            array[i] = scan.nextInt();
            average += array[i];
        }
        average/= sizeOfArray;
        for(int i = 0 ; i < array.length ; i++ ){
            if(array[i] > average){
                System.out.print(array[i] +"\t");
            }
        }
    }
}
