package sat.recruitment.api.user.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {

    private String message;

    public UserResponse(final String message) {
        this.message = message;
    }
}
