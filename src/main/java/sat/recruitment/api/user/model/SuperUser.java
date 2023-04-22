package sat.recruitment.api.user.model;

import sat.recruitment.api.user.dto.UserDto;

public class SuperUser extends User {

    public SuperUser(final UserDto user, final Double maxPercentage, final Double maxMoneyValue) {
        super(user);
        this.maxPercentage = maxPercentage;
        this.maxMoneyValue = maxMoneyValue;
        applyPercentage();
    }

    @Override
    protected void applyPercentage() {
        var percentage = 0.0;
        if (this.money > maxMoneyValue) {
            percentage = maxPercentage;
        }
        this.money = (percentage * money) + money;
    }

}
