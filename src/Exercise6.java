import java.util.Scanner;
public class Exercise6 {
public static void main(String[]args){
    Scanner scanner = new Scanner(System.in);
    System.out.println("enter the equation");
    String equation = scanner.nextLine();
    boolean checkEquation = checkEquation(equation);
    if(checkEquation == false){
        System.out.println("the equation is not good");
    }
    else{
        int a = returnTheParameterA(equation);
        int b = returnTheParameterB(equation);
        int c = returnTheParameterC(equation);
        solutionsOfTheEquation(a,b,c);
    }
    }
    public static boolean checkEquation(String equation){
    boolean goodOrNot = true;
    if(equation.length() == 0 || equation.length() == 1){
        goodOrNot = false;
    }
    else {
        int lengthOfEquation = equation.length();

        String equalToZero = "=0";

        int indexOfFirstX = equation.indexOf('x');
        String fromFirstX = "x^2";

        int indexOfSecondX = 0;
        String secondXWithPlus = "x+";
        String secondXWithMinus = "x-";
        String secondXWithEqual = "x=";
        int counter = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == 'x') {
                indexOfSecondX = i;
                counter++;
                if (counter == 2) {
                    break;
                }
            }
        }
        int checkPlusAndMinus = 0;
        for(int i = indexOfFirstX + 2;i<indexOfSecondX;i++){
            if(equation.charAt(i) == '+' || equation.charAt(i) == '-'){
                checkPlusAndMinus++;
            }
        }
        if (!equation.substring(lengthOfEquation - 2).equals(equalToZero)) {
            goodOrNot = false;
        } else if (!equation.substring(indexOfFirstX, indexOfFirstX + 3).equals(fromFirstX)) {
            goodOrNot = false;
        } else if (!(equation.substring(indexOfSecondX, indexOfSecondX + 2).equals(secondXWithPlus) ||
                equation.substring(indexOfSecondX, indexOfSecondX + 2).equals(secondXWithMinus) ||
                equation.substring(indexOfSecondX, indexOfSecondX + 2).equals(secondXWithEqual))) {
            goodOrNot = false;
        }
        else if(checkPlusAndMinus > 1){
            goodOrNot = false;
        }
        else if(indexOfFirstX > 2){
            if(equation.charAt( indexOfFirstX - 1) == '+' || equation.charAt( indexOfFirstX - 1) == '-'){
                goodOrNot = false;
            }
        }
    }
    return goodOrNot;
    }

    public static int returnTheParameterA(String equation){
    int a = 0;
    int indexOfFirstX = equation.indexOf('x');
    String beforFirstX = equation.substring(0,indexOfFirstX);
    char firstCharAtEquation = equation.charAt(0);
    if(indexOfFirstX == 0)
        a = 1;
    else if(firstCharAtEquation == '-' && indexOfFirstX == 1){
        a = -1;
    }
    else if(firstCharAtEquation == '-' && indexOfFirstX != 1){
        String str =equation.substring(0,indexOfFirstX);
        a = (Integer.parseInt(str));
    }
    else{
        a = Integer.parseInt(beforFirstX);
    }

    return a;
    }

    public static int returnTheParameterB(String equation){
    int b = 0;
    int indexOfFirstX = equation.indexOf('x');
    String newEquation = equation.substring(indexOfFirstX+3);
    int indexOfSecondX = newEquation.indexOf('x');
    newEquation = newEquation.substring(0,indexOfSecondX);
    if(newEquation.length() == 1) {
        if (newEquation.charAt(0) == '+') {
        b = 1;
    }
        else{
            b = -1;
        }
    }
    else if(newEquation.charAt(0)== '-'){
        newEquation = newEquation.substring(1);
        b = -1 * Integer.parseInt(newEquation);
    }
    else{
        b = Integer.parseInt(newEquation);
    }
    return b;
    }

    public static int returnTheParameterC(String equation) {
        int c = 0;
        int indexOfFirstX = equation.indexOf('x');
        String newEquation = equation.substring(indexOfFirstX+3);
        int indexOfSecondX = newEquation.indexOf('x');
        int indexOfEqual = newEquation.indexOf('=');
        newEquation = newEquation.substring(indexOfSecondX + 1,indexOfEqual);
        if(newEquation.length()==0){
            c = 0;
        }
        else if(newEquation.charAt(0) == '-'){
            newEquation = newEquation.substring(1);
            c = -1 * Integer.parseInt(newEquation);
        }
        else {
            c = Integer.parseInt(newEquation);
        }

        return c;
    }

    public static void solutionsOfTheEquation(int a, int b,int c){
        double x1,x2;
        int sum = (b*b)-(4*a*c);
        if(sum<0){
            System.out.println("there is no solution");
        }
        else if(sum == 0){
            x1=-b/(a*2);
            System.out.println("x1 = "+x1);
        }
        else{
            x1 = (-b + Math.sqrt(sum))/(a*2);
            x2 = (-b - Math.sqrt(sum))/(a*2);
            System.out.println("x1 = "+x1+ " , x2 = "+x2);
        }
    }
}

