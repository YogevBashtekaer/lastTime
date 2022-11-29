public class Exercise3 {
    public static void main(String[]args){
        int[] numbers = {1,4,7,1,8,9,2,1,3,8,0};
        //int[] numbers = {};
        int[] newArray = arrayWithOutDoubleValue(numbers);
        for(int i = 0 ; i < newArray.length; i++) {
            System.out.print(newArray[i] + "\t");
        }

    }

    public static int[] arrayWithOutDoubleValue(int[]array){
        for(int i = 0 ; i < array.length ; i++){
            for(int j = i + 1 ; j<array.length;j++)
                if(array[i] == array[j]){
                    array = removeNumberFromArray(array , array[j] , j);
                }
        }
        return array;
    }
    public static int[] removeNumberFromArray(int[]array,int numberToRemove,int index){
        int [] newArray = new int[array.length-1];
        for(int i = 0 ; i < index ;i++){
            newArray[i] = array[i];
        }
        for(int i = index ; i < newArray.length ; i++){
            newArray[i] = array[i+1];
        }
        return newArray;
    }
}
