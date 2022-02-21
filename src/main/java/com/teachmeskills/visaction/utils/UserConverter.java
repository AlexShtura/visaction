/*package com.teachmeskills.visaction.utils;

import com.teachmeskills.visaction.model.User;
import com.teachmeskills.visaction.model.dto.UserDto;
import com.teachmeskills.visaction.model.dto.UserRegistrationDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static UserDto convertUserEntityToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .mobileNumber(user.getMobileNumber())
                .build();
    }

    public static User convertUserDtoToUserEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .age(userDto.getAge())
                .mobileNumber(userDto.getMobileNumber())
                .build();
    }

    public static UserRegistrationDto convertUserEntityToUserRegistrationDto(User user) {
        return UserRegistrationDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public static User convertUserRegistrationDtoToUserEntity(UserRegistrationDto userRegistrationDto) {
        return User.builder()
                .id(userRegistrationDto.getId())
                .username(userRegistrationDto.getUsername())
                .password(userRegistrationDto.getPassword())
                .build();
    }
}*/

