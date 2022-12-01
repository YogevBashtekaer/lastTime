import java.util.Scanner;
public class Exercise6 {
public static void main(String[]args){
    Scanner scanner = new Scanner(System.in);
    /*
    String str1 = "";
    String str2 = "x^2+3x+5=0";
    String str3 = "x^2-x=0";
    String str4 = "20x^2=0";
    String str5 = "-x^2-x-5=0";
    String str6 = "-x^2-5x+123=0";
    String str7 = "x+x^2=0";
    String str8 = "-20x^2-153x+5=9";
    */
    System.out.println("enter the equation");
    String equation = scanner.nextLine();
    boolean checkEquation = checkEquation(equation);
    System.out.println(checkEquation);
    if(checkEquation == false){
        System.out.println("the equation is not good");
    }
    else{
        int a = returnTheParameterA(equation);
        System.out.println(a);
        int b = returnTheParameterB(equation);
        System.out.println(b);
        int c = returnTheParameterC(equation);
        System.out.println(c);
        solutionsOfTheEquation(a,b,c);
    }
    }
    public static boolean checkEquation(String equation){
    boolean goodOrNot = true;
    if(equation.length() == 0){
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
        if (!equation.substring(lengthOfEquation - 2).equals(equalToZero)) {
            goodOrNot = false;
        } else if (!equation.substring(indexOfFirstX, indexOfFirstX + 3).equals(fromFirstX)) {
            goodOrNot = false;
        } else if (!(equation.substring(indexOfSecondX, indexOfSecondX + 2).equals(secondXWithPlus) ||
                equation.substring(indexOfSecondX, indexOfSecondX + 2).equals(secondXWithMinus) ||
                equation.substring(indexOfSecondX, indexOfSecondX + 2).equals(secondXWithEqual))) {
            goodOrNot = false;
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

