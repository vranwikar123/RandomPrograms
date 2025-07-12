package DesignPatterns.State;

public class FoodOrder {

    private FoodOrderState state = new OrderInitiatedState();

    public void setState(FoodOrderState state) {
        this.state = state;
    }

    public FoodOrderState getState() {
        return state;
    }

    public void transitionToNextState() {
        state.transitionToNext(this);
    }

    public void showCurrentStatus() {
        state.showStatus();
    }
}
