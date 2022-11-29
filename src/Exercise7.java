import java.util.Random;
import java.util.Scanner;
public class Exercise7 {
    final int DIGIT_0NE = 1;
    final int DIGIT_TWO = 2;
    final int DIGIT_TREE = 3;
    final int DIGIT_FOUR = 4;
    public static void main(String[]args){
        int secretNumber = secretNumber();
        instructions();
        int playerTurns = howManyTurns();
        int guess = 0;
        while(secretNumber != guess && playerTurns > 0) {
             guess = getGuess();
            hints(guess, secretNumber);
            playerTurns = fineThePlayer(guess,playerTurns);
            playerTurns--;
        }
        if(playerTurns <= 0){
            System.out.println("you lose");
        }
    }

    public static int secretNumber(){
        Random random = new Random();
        int digits[] = {0,0,0,0};
        int secretNumber = 0;
        digits[0] = random.nextInt(1, 7);
        do{
            digits[1] = random.nextInt(1, 7);
        }while (digits[0] == digits[1]);

        do{
            digits[2] = random.nextInt(1, 7);
        }while (digits[2] == digits[0] || digits[2] == digits[1] );

        do{
            digits[3] = random.nextInt(1, 7);
        }while (digits[3] == digits[0] || digits[3] == digits[1] || digits[3] ==digits[2]);

        for(int i = 0;i <  4;i++){
            secretNumber += digits[i];
            if(i<3){
                secretNumber *= 10;
            }
        }
        return secretNumber;
    }
    public static int howManyTurns(){
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int playerChoose = 0;
        System.out.println("choose your difficulty level:");
        System.out.println("press 1 for easy level (20 opportunities)");
        System.out.println("press 2 for medium level(15 opportunities)");
        System.out.println("press 3 for hard level(10 opportunities)");
        System.out.println("press 4 for a surprising level(between 5 to 25 opportunities)");
        do{
            playerChoose = scan.nextInt();
            if(playerChoose > 4 || playerChoose < 1){
                System.out.println("try again");
            }
        }while (playerChoose > 4 || playerChoose < 1);
        if(playerChoose == 1){
            playerChoose = 20;
        }
        else if(playerChoose == 2){
            playerChoose = 15;
        }
        else if (playerChoose == 3) {
            playerChoose = 10;
        }
        else{
            playerChoose = random.nextInt(5,26);
        }
        return playerChoose;
    }

    public static void hints(int guess,int secretNumber){
        if(checkWinner(guess,secretNumber)==true){

        }
        else {
            int arrayGuess[] = new int[4];
            int arraySecretNumber[] = new int[4];
            for (int i = 3; i > -1; i--) {
                arrayGuess[i] = guess % 10;
                guess /= 10;
            }
            for (int i = 3; i > -1; i--) {
                arraySecretNumber[i] = secretNumber % 10;
                secretNumber /= 10;
            }
            int correectLocation = 0;
            for (int i = 0; i < arrayGuess.length; i++) {
                if (arrayGuess[i] == arraySecretNumber[i]) {
                    correectLocation++;
                }
            }
            int halfGuess = 0;
            for (int i = 0; i < arrayGuess.length; i++) {
                for (int j = 0; j < arrayGuess.length; j++) {
                    if (arrayGuess[i] == arraySecretNumber[j] && i != j) {
                        halfGuess++;
                        break;
                    }
                }
            }
            System.out.println("you have " + correectLocation + " correct guess and " + halfGuess + " half guess");
        }
    }

    public static int fineThePlayer(int guess,int turnLeft){
        int arrayGuess[] = new int[4];
        int toEqualTurnLeft = turnLeft;
        for(int i = 3;i > -1;i--){
            arrayGuess[i] = guess % 10;
            guess /=10;
        }
        for(int i = 0;i < arrayGuess.length; i++){
            for(int j = i + 1;j<arrayGuess.length;j++){
                if(arrayGuess[i]==arrayGuess[j]){
                    turnLeft -= 2;
                    System.out.println("i am fining you for entering an incorrect number int -2 turns");
                    break;
                }
            }
            if(turnLeft != toEqualTurnLeft){
                break;
            }
        }
        return turnLeft;
    }

    public static int getGuess(){
        Scanner scan = new Scanner(System.in);
        int guess;
        int arrayGuess [] =new int [3];
        System.out.println("enter your guess (only 4 digits between 1-6)");
        boolean checkNumber;
        do{
            checkNumber = true;
          guess = scan.nextInt();
          if(guess >6666 ||guess < 1111){
              checkNumber = false;
              System.out.println("try again");
          }
          else {
              for (int i = 0; i < arrayGuess.length; i++) {
                  arrayGuess[i] = guess % 10;
                  if (arrayGuess[i] < 1 || arrayGuess[i] > 6) {
                      System.out.println("try again");
                      checkNumber = false;
                      break;
                  }
              }
          }
        }while(checkNumber == false);
        return guess;
    }

    public static boolean checkWinner(int guess,int secretNumber){
        boolean winOrLoss = false;
        if (guess == secretNumber) {
            winOrLoss = true;
            System.out.println("the secret number is: " +secretNumber);
            System.out.println("you win!!!!");
        }
        return winOrLoss;
    }

    public static void instructions(){
        System.out.println("we play guess the number");
        System.out.println("you need to guess number with 4 digit and every digit between 1-6");
        System.out.println("if you try to guess number with at least 2 same digits i take from you 2 turns");
    }
}
