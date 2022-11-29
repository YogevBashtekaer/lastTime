import  java.util.Scanner;
public class Exercise1 {
    public static void main(String[]args){
        printsLargerThenAverageNumbers();

    }

    public static void printsLargerThenAverageNumbers(){
        Scanner scan = new Scanner(System.in);
        final int NUMBERS_FOR_ARRAY = 10;
        int [] array = new int[NUMBERS_FOR_ARRAY] ;
        double average = 0;
        System.out.println("enter "+ NUMBERS_FOR_ARRAY+ " numbers");
        for(int i = 0 ; i < array.length ; i++ ){
            array[i] = scan.nextInt();
            average += array[i];
        }
        average/= NUMBERS_FOR_ARRAY;
        for(int i = 0 ; i < array.length ; i++ ){
            if(array[i] > average){
                System.out.print(array[i] +"\t");
            }
        }
    }
}
