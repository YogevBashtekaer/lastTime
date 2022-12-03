import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int [] array = {1,2,3,2,1,2,1};

        int[] newArray = printWithoutDuplications(array);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]+ " ");
        }
    }
    public static int[] printWithoutDuplications(int[] array) {
        int counter = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    counter++;
                    break;
                }
            }
        }
        int[] newArray = new int[array.length - counter];
        int indexNewArray = 0;
        int counterOfCheckingIfTheNumberAppearsFirst = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] != array[j]) {
                    counterOfCheckingIfTheNumberAppearsFirst++;
                } else {
                    counterOfCheckingIfTheNumberAppearsFirst = 0;
                    break;
                }
            }
            if (counterOfCheckingIfTheNumberAppearsFirst == i) {
                newArray[indexNewArray] = array[i];
                indexNewArray++;
            }
            counterOfCheckingIfTheNumberAppearsFirst = 0;
        }
        return newArray;

    }
}
