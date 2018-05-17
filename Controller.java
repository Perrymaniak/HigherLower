package sample;

import java.util.Random;

public class Controller {
    public int PickRandomNumber(){
        int number = 0;
        Random random = new Random();
        number = random.nextInt(100);
        return number;
    }

    public String MakeAGuess(String userGuess, int randomNumber){
        System.out.println("DIAG - INSIDE MAKEAGUESS");
        int iUserGuess = Integer.parseInt(userGuess);
        if(iUserGuess > randomNumber) {
            return "lower!";
        }
        else if(iUserGuess < randomNumber) {
            return "higher!";
        }
        else {
            return "bingo!";
        }
    }
}
