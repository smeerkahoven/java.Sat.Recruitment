package sat.recruitment.api.user.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sat.recruitment.api.user.dto.UserDto;

@Component
public class UserBuilder {

    @Value("${users.maxMoneyValue:100}")
    private Double maxMoneyValue;

    @Value("${users.minMoneyValue:10}")
    private Double minMoneyValue;

    @Value("${users.normal.maxPercentage:0.12}")
    private Double normalMaxPercentage;

    @Value("${users.normal.minPercentage:0.8}")
    private Double normalMinPercentage;

    @Value("${users.premium.maxPercentage:2}")
    private Double premiumMaxPercentage;

    @Value("${users.super.maxPercentage:0.2}")
    private Double superMaxPercentage;

    public User build(final UserDto user) {
        switch (User.Type.valueOf(user.getUserType().toUpperCase())) {
            case NORMAL:
                return new NormalUser(user, normalMaxPercentage, normalMinPercentage, maxMoneyValue, minMoneyValue);
            case PREMIUM:
                return new PremiumUser(user, premiumMaxPercentage, maxMoneyValue);
            case SUPERUSER:
                return new SuperUser(user, superMaxPercentage, maxMoneyValue);
            default:
                return null;
        }
    }
}
