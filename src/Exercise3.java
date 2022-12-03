public class Exercise3 {
    public static int[] arrayWithOutDoubleValue(int[]array){
        for(int i = 0 ; i < array.length ; i++){
            for(int j = i + 1 ; j<array.length;j++)
                if(array[i] == array[j]){
                    array = removeNumberFromArray(array , array[j] , j);
                    if(j < array.length){
                        if(array[i] == array[j]){
                            array = removeNumberFromArray(array , array[j] , j);
                        }
                    }
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
        int i=1;
        return newArray;
    }
}
