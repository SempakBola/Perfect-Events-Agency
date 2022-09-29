public class Options {
    private boolean isHireBand;
    private boolean isSoundSystem;
    private boolean isFlowerDecoration;

    public Options(){
        this.isHireBand = false;
        this.isSoundSystem = false;
        this.isFlowerDecoration = false;
    }

    //getter and setter methods
    public boolean isIsHireBand() {
        return isHireBand;
    }

    public void setIsHireBand(boolean isHireBand) {
        this.isHireBand = isHireBand;
    }

    public boolean isIsSoundSystem() {
        return isSoundSystem;
    }

    public void setIsSoundSystem(boolean isSoundSystem) {
        this.isSoundSystem = isSoundSystem;
    }

    public boolean isIsFlowerDecoration() {
        return isFlowerDecoration;
    }

    public void setIsFlowerDecoration(boolean isFlowerDecoration) {
        this.isFlowerDecoration = isFlowerDecoration;
    }

    public void str(){
        System.out.println("Hire Band: " + isHireBand);
        System.out.println("Sound System: " + isSoundSystem);
        System.out.println("Flower Decoration: " + isFlowerDecoration);
    }

}
