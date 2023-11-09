
// Here is factory pattern that used to create and payment of three bill types 
public class Billfactory{
      public Bill createbill(String type){
        if(type==null){
            return null;
        }
        if (type.equals("Gas")){
            return new Gasbill();
        }
        else if(type.equals("Electricty")){
            return new Electrictybill();
        }
        else if (type.equals("Water")){
            return new Waterbill();
        }
        return null;
      }
}