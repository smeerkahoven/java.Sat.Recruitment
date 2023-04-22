package sat.recruitment.api.user.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

@Data
public class UserDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\d{1,10}$", flags = { Flag.CASE_INSENSITIVE, Flag.MULTILINE }, message = "The phone number is invalid.")
    private String phone;

    @NotBlank(message = "UserType is required")
    private String userType;

    @NotNull(message = "Money is required")
    @DecimalMin(value = "0.0", message = "Please enter a valid money value")
    private Double money;

    public UserDto(final String name, final String email, final String address, final String phone, final String userType,
                   final Double money) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.userType = userType;
        this.money = money;
    }

    public UserDto() {

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

    public String getUserType() {
        return userType;
    }

    public Double getMoney() {
        return money;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public void setUserType(final String userType) {
        this.userType = userType;
    }

    public void setMoney(final Double money) {
        this.money = money;
    }
}

