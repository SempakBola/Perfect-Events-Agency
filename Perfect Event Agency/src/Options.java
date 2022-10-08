public class Options {
    private boolean isHireBand;
    private boolean isSoundSystem;
    private boolean isFlowerDecoration;

    private double costofBand = 1000.00;
    private double costofSoundSytem =  2000.00;
    private double costofFlowers = 500.00;

    EventID eventID = new EventID();

    public Options(){
        this.isHireBand = false;
        this.isSoundSystem = false;
        this.isFlowerDecoration = false;
    }

    //getter and setter methods


    public boolean setIsHireBand(boolean isHireBand) {
        this.isHireBand = isHireBand;
        return isHireBand;
    }



    public boolean setIsSoundSystem(boolean isSoundSystem) {
        this.isSoundSystem = isSoundSystem;
        return isSoundSystem;
    }



    public boolean setIsFlowerDecoration(boolean isFlowerDecoration) {
        this.isFlowerDecoration = isFlowerDecoration;
        return isFlowerDecoration;
    }
    public boolean isIsHireBand() {

        return isHireBand;
    }

    public boolean isIsFlowerDecoration() {

        return isFlowerDecoration;
    }

    public boolean isIsSoundSystem() {
        return isSoundSystem;
    }

   public double OptionCost(){
        double selectedOptionCost = 0;
        if(isIsFlowerDecoration()){
            selectedOptionCost = costofFlowers;
        }
       if(isIsHireBand()){
           selectedOptionCost = costofBand;
       }
       if (isIsHireBand()){
           selectedOptionCost = costofSoundSytem;
       }
       return  selectedOptionCost;
   }

    public void str(){
        System.out.println("Hire Band: " + isIsHireBand());
        System.out.println("Sound System: " + isIsSoundSystem());
        System.out.println("Flower Decoration: " + isIsFlowerDecoration());
    }


}
