package DesignPatterns.State;

public class OrderInitiatedState implements FoodOrderState {

    @Override
    public void transitionToNext(FoodOrder order) {
        order.setState(new OrderPlacedState());
    }

    @Override
    public void showStatus() {
        System.out.println("Order initiated, waiting for the order to be placed.");
    }
}
