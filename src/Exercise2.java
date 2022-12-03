public class Exercise2 {
     public static String phoneNumber(String phoneNumber){
         String firstNumbers;
         String lastNumbers;
         String israeliPrefix = "9725";
         String phoneAreaCode = "05";
         if(phoneNumber.length()==10 && phoneNumber.substring(0,2).contains(phoneAreaCode)){
             firstNumbers = phoneNumber.substring(0,3);
             lastNumbers = phoneNumber.substring(3);
             phoneNumber =firstNumbers+"-"+lastNumbers;
         }
         else if(phoneNumber.length()==11 && phoneNumber.charAt(3)=='-'){
         }
         else if(phoneNumber.length()==12 && phoneNumber.substring(0,6).contains(israeliPrefix)){
             firstNumbers = 0 + phoneNumber.substring(3,5);
             lastNumbers = phoneNumber.substring(5);
             phoneNumber = firstNumbers+"-"+lastNumbers;
         }
         else{
             phoneNumber ="";
         }
         int i=1;
         return phoneNumber;
     }
}
