package primus.pawel.DAY_06;

class LanternFish {
    int internalTimer;
    static final int MAX_INTERNAL = 6;

    LanternFish(final int internalTimer) {
        this.internalTimer = internalTimer;
    }

    int getInternalTimer() {
        return internalTimer;
    }

    void minusInternalDay(){
        this.internalTimer--;
    }

    void restInternalTimer(){
        this.internalTimer = MAX_INTERNAL;
    }



}
