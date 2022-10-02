public class Options {
    private boolean isHireBand;
    private boolean isSoundSystem;
    private boolean isFlowerDecoration;

    private double costofBand = 1000.00;
    private double costofSoundSytem =  2000.00;
    private double costofFlowers = 500.00;

    public Options(){
        this.isHireBand = false;
        this.isSoundSystem = false;
        this.isFlowerDecoration = false;
    }

    //getter and setter methods
    public boolean isIsHireBand() {
        return isHireBand;
    }

    public boolean setIsHireBand(boolean isHireBand) {
        this.isHireBand = isHireBand;
        return isHireBand;
    }

    public boolean isIsSoundSystem() {
        return isSoundSystem;
    }

    public boolean setIsSoundSystem(boolean isSoundSystem) {
        this.isSoundSystem = isSoundSystem;
        return isSoundSystem;
    }

    public boolean isIsFlowerDecoration() {
        return isFlowerDecoration;
    }

    public boolean setIsFlowerDecoration(boolean isFlowerDecoration) {
        this.isFlowerDecoration = isFlowerDecoration;
        return isFlowerDecoration;
    }

    public double getCostofBand() {
        return costofBand;
    }

    public void setCostofBand(double costofBand) {
        this.costofBand = costofBand;
    }

    public double getCostofSoundSytem() {
        return costofSoundSytem;
    }

    public void setCostofSoundSytem(double costofSoundSytem) {
        this.costofSoundSytem = costofSoundSytem;
    }

    public double getCostofFlowers() {
        return costofFlowers;
    }

    public void setCostofFlowers(double costofFlowers) {
        this.costofFlowers = costofFlowers;
    }

    public void str(){
        System.out.println("Hire Band: " + isHireBand);
        System.out.println("Sound System: " + isSoundSystem);
        System.out.println("Flower Decoration: " + isFlowerDecoration);
    }

}
