public class InputValidator {

    public boolean validateInput (String input){

        if(input.matches("^[\\[]{1}[A-Z]{1}[12A-Z]{1}[\\]][\\s]{1}[0-9]{1,2}([:][0-6]{1}[0-9]{1})([.][0-9]{3})?$")){
            return true;
        }
        else {
            return false;
        }
    }

}
