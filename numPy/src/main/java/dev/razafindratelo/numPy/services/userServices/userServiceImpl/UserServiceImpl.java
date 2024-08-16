package dev.razafindratelo.numPy.services.userServices.userServiceImpl;

import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.services.userServices.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUserById(String id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public void deleteEvent(String id) {

    }

    @Override
    public boolean checkUserLogin(UserDto userDto) {
        return false;
    }
}
