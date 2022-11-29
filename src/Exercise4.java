public class Exercise4 {
    public static void main(String[]args){
        int []array ={1,2,3,4,5,6,7};
        System.out.println(checkingUpDownIndex(array));
    }
    public static int checkingUpDownIndex(int array[]){
        int index = -1;
        int bigNumberInArray = array[0];
        int indexOfBigNumberInArray=0;
        for(int i = 0;i<array.length-1;i++){
            if(array[i]<array[i+1]){
                bigNumberInArray = array[i+1];
                indexOfBigNumberInArray = i+1;
            }
        }
        boolean upToTheBigNumber=true;
        boolean downFromTheBigNumber=true;
        if(indexOfBigNumberInArray != 0 && indexOfBigNumberInArray !=array.length-1) {
            for (int i = 0; i < indexOfBigNumberInArray; i++) {
                if (array[i] > array[i + 1]) {
                    upToTheBigNumber = false;
                }
            }
            for (int i = indexOfBigNumberInArray ; i < array.length - 1; i++) {
                if (array[i] <= array[i + 1]) {
                    downFromTheBigNumber = false;
                }
            }
            if (upToTheBigNumber && downFromTheBigNumber) {
                index = indexOfBigNumberInArray;
            }
        }
        return index;
    }
}
