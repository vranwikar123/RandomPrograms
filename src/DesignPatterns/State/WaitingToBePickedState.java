package DesignPatterns.State;

public class WaitingToBePickedState implements FoodOrderState {

    @Override
    public void transitionToNext(FoodOrder order) {
        order.setState(new OutForDeliveryState());
    }

    @Override
    public void showStatus() {
        System.out.println("Food prepared and waiting to be picked.");
    }
}
