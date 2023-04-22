package sat.recruitment.api.user.model;

import sat.recruitment.api.user.dto.UserDto;

public class User {

    public enum Type {
        SUPERUSER,
        PREMIUM,
        NORMAL
    }

    //properties to other classes
    protected Double maxMoneyValue;

    protected Double minMoneyValue;

    protected Double maxPercentage;

    // fields

    public String name;
    public String email;
    public String address;
    public String phone;
    public Type userType;
    public Double money;

    public User(final UserBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.address = builder.address;
        this.phone = builder.phone;
        this.userType = builder.userType;
        this.money = builder.money;
    }

    public User(final String[] data) {
        this.name = data[0];
        this.email = data[1];
        this.phone = data[2];
        this.address = data[3];
        this.userType = Type.valueOf(data[4].toUpperCase());
        this.money = Double.valueOf(data[5]);
    }

    public User(final UserDto user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.userType = Type.valueOf(user.getUserType().toUpperCase());
        this.money = user.getMoney();
    }

    protected void applyPercentage() {
    }

    public Double getMaxMoneyValue() {
        return maxMoneyValue;
    }

    public Double getMinMoneyValue() {
        return minMoneyValue;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Type getUserType() {
        return userType;
    }

    public Double getMoney() {
        return money;
    }

    public static class UserBuilder {
        private String name;
        private String email;
        private String address;
        private String phone;
        private Type userType;
        private Double money;

        public UserBuilder withName(final String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withEmail(final String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withAddress(final String address) {
            this.address = address;
            return this;
        }

        public UserBuilder withPhone(final String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder withUserType(final Type userType) {
            this.userType = userType;
            return this;
        }

        private UserBuilder withMoney(final Double money) {
            this.money = money;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public void setMaxMoneyValue(final Double maxMoneyValue) {
        this.maxMoneyValue = maxMoneyValue;
    }

    public void setMinMoneyValue(final Double minMoneyValue) {
        this.minMoneyValue = minMoneyValue;
    }

    public void setMaxPercentage(final Double maxPercentage) {
        this.maxPercentage = maxPercentage;
    }
}

