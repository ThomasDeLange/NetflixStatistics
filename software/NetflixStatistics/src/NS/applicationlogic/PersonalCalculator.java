package NS.applicationlogic;

public class PersonalCalculator implements Calculator {

    private int value = 0;

    public int giveValue(){
        return value;
    }

    public void increase(){
        value++;
    }
}
