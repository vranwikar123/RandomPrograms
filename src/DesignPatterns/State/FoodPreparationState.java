package DesignPatterns.State;

public class FoodPreparationState implements FoodOrderState {

    @Override
    public void transitionToNext(FoodOrder order) {
        order.setState(new WaitingToBePickedState());
    }

    @Override
    public void showStatus() {
        System.out.println("Food preparation started, waiting for the food to be prepared.");
    }
}
