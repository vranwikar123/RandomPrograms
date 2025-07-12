package DesignPatterns.State;

public interface FoodOrderState {

    void transitionToNext(FoodOrder order);

    void showStatus();
}
