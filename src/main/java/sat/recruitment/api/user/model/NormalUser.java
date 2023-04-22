package sat.recruitment.api.user.model;

import sat.recruitment.api.user.dto.UserDto;

public class NormalUser extends User {

    private Double minPercentage;

    public NormalUser(final UserDto user, final Double maxPercentage, final Double minPercentage, final Double maxMoney, final Double minMoney) {
        super(user);
        this.maxPercentage = maxPercentage;
        this.minPercentage = minPercentage;
        this.maxMoneyValue = maxMoney;
        this.minMoneyValue = minMoney;
        applyPercentage();
    }

    @Override
    protected void applyPercentage() {
        var percentage = 0.0;
        if (this.money > maxMoneyValue) {
            percentage = maxPercentage;
        } else if (money > minMoneyValue && money <= maxMoneyValue) {
            percentage = minPercentage;
        }
        this.money = (percentage * money) + this.money;
    }

    public void setMinPercentage(final Double minPercentage) {
        this.minPercentage = minPercentage;
    }
}
