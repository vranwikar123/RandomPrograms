package DesignPatterns.State;

public class DeliveredState implements FoodOrderState {

    @Override
    public void transitionToNext(FoodOrder order) {
        System.out.println("Food is already delivered to the respective customer");
    }

    @Override
    public void showStatus() {
        System.out.println("Food delivered to the Customer.");
    }
}
