package dev.razafindratelo.numPy.services.userServices;

import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(String userId,UserDto userDto);
    UserDto getUserById(String id);
    List<UserDto> getAllUsers();
    void deleteEvent(String id);
    boolean checkUserLogin(UserDto userDto);
}
