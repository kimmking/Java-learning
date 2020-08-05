package annotations.myprocessor.bean;

import annotations.myprocessor.annotation.Factory;

/**
 * @author https://wangwei.one
 * @date 8/4/20
 */
@Factory(id = "Tiramisu", type = Meal.class)
public class Tiramisu implements Meal {

    @Override
    public float getPrice() {
        return 4.5f;
    }
}
