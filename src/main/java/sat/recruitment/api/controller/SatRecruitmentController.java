package sat.recruitment.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sat.recruitment.api.user.dto.UserDto;
import sat.recruitment.api.user.model.User;
import sat.recruitment.api.user.model.UserBuilder;
import sat.recruitment.api.user.model.UserResponse;
import sat.recruitment.api.user.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1")
public class SatRecruitmentController {

	final Logger logger = LoggerFactory.getLogger(SatRecruitmentController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserBuilder builder;

	@PostMapping(value = "/create-user", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody final UserDto userRequest) {
		logger.info("Start create-user");

		final User newUser = builder.build(userRequest);

		if (userService.isDuplicated(newUser)){
			return new ResponseEntity<>(new UserResponse("User duplicated!"),HttpStatus.BAD_REQUEST);
		}

		logger.info("Finish create-user");
		return new ResponseEntity<>(new UserResponse("User Created!"),HttpStatus.OK);
	}
}
