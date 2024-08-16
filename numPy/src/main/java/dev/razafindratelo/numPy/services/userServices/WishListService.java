package dev.razafindratelo.numPy.services.userServices;

import dev.razafindratelo.numPy.dtos.postDtos.WishListDto;
import dev.razafindratelo.numPy.dtos.userDtos.UserDto;

import java.util.List;

public interface WishListService {
    WishListDto createUser(UserDto userDto);
    WishListDto updateUser(String userId,UserDto userDto);
    WishListDto getUserById(String id);
    List<WishListDto> getAllUsers();
    void deleteWishList(String id);
}
