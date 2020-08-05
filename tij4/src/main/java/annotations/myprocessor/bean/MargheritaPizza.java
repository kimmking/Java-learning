package annotations.myprocessor.bean;

import annotations.myprocessor.annotation.Factory;

/**
 * @author https://wangwei.one
 * @date 8/4/20
 */
@Factory(id = "Margherita", type = Meal.class)
public class MargheritaPizza implements Meal {

    @Override
    public float getPrice() {
        return 6.0f;
    }
}
