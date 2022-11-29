import java.util.Scanner;
public class Exercise5 {
    public static void main(String[]args){
        char [] board = {'1','2','3','4','5','6','7','8','9'};
        char player1 = 'x';
        char player2 = 'o';
        char playerTurn = 'x';
        boolean somoneWin = false;
        int indexToPut;
        int counter = 0;
        printBoard(board);
        do{
           if(counter == 9){
               break;
           }
           indexToPut =getPosionFromUser(board);
           somoneWin = placeSymbolOnBoard(board,indexToPut,playerTurn);
           if(playerTurn == player1){
               playerTurn = player2;
           }
           else{
               playerTurn = player1;
           }
           counter++;
        }while(!somoneWin);
        if(somoneWin == false){
            System.out.println("its equlas");
        }
    }

    public static void printBoard(char []board){
        for(int i = 0;i < board.length;i++){
            System.out.print(board[i]+"\t");
            if(i==2 || i ==5 || i==8){
                System.out.println();
            }
        }

    }
    public static boolean isAvailable(char[]board, int indexOnBoard){
        boolean freeOrNot = true;
        if(board[indexOnBoard] == 'x' || board[indexOnBoard] == 'o'){
             freeOrNot = false;
        }
        return freeOrNot;
    }
    public static int getPosionFromUser(char []board){
        Scanner scan = new Scanner(System.in);
        int index;
        boolean situationOfIndex = false;
        System.out.println("enter the index from 1 to 9");
        do{
            index = scan.nextInt();
            index -= 1;
            if(index < 9 && index >=0 ) {
                situationOfIndex = isAvailable(board, index);
                if(situationOfIndex == false){
                    System.out.println("this posion allready token");
                }
            }
            else{
                System.out.println("try again (only 1-9)");
            }
        }while(situationOfIndex == false);
        return index;
    }
    public static char checkWinner(char board[]){
        char win = '-';
        for(int i = 0 ; i<board.length ;i+=3){
            if(board[i] == board[i+1] && board[i]==board[i+2]){
               if(board[i] == 'x' || board[i] == 'o') {
                   win = board[i];
               }
            }
        }
        for(int i = 0;i< 3 ;i++){
            if(board[i] == board[i+3] && board[i] == board[i+6]){
                if(board[i] == 'x' || board[i] == 'o') {
                    win = board[i];
                }
            }
        }
        if(board[0] == board[4] && board[4] == board[8]){
            if(board[4] == 'x' || board[4] == 'o') {
                win = board[0];
            }
        }
        if (board[2] == board[4] && board[4] == board[6]){
            if(board[4] == 'x' || board[4] == 'o') {
                win = board[2];
            }
        }
        return win;
    }

    public static boolean placeSymbolOnBoard(char []board , int index , char player){
        boolean win = false;
        char check = '-';
        board[index]=player;
        printBoard(board);
        check = checkWinner(board);
        if (check == player){
            System.out.print("player "+ player + " win");
            win = true;
        }
        return win;
    }
}

