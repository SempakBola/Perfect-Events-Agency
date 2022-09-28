public class Options {
    private boolean isHireBand;
    private boolean isSoundSystem;
    private boolean isFlowerDecoration;

    public Options(boolean isHireBand, boolean isSoundSystem, boolean isFlowerDecoration) {
        this.isHireBand = isHireBand;
        this.isSoundSystem = isSoundSystem;
        this.isFlowerDecoration = isFlowerDecoration;
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

}
