package com.edu.ulab.app.mapper;

import com.edu.ulab.app.domain.User;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.web.request.UserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userRequestToUserDto(UserRequest userRequest);

    UserRequest userDtoToUserRequest(UserDto userDto);

    UserDto userEntityToUserDto(User user);
}
