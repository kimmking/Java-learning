package annotations.myprocessor.bean;

import annotations.myprocessor.annotation.Factory;

/**
 * @author https://wangwei.one
 * @date 8/4/20
 */
@Factory(id = "Calzone", type = Meal.class)
public class CalzonePizza implements Meal {

    @Override
    public float getPrice() {
        return 8.5f;
    }
}
