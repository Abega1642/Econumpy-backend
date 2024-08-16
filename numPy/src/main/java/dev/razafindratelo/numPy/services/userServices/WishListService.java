package dev.razafindratelo.numPy.services.userServices;

import dev.razafindratelo.numPy.dtos.postDtos.WishListDto;
import dev.razafindratelo.numPy.dtos.userDtos.UserDto;

import java.util.List;

public interface WishListService {
    WishListDto createWishList(WishListDto wishlistDto);
    WishListDto updateWishList(String wishlistId,WishListDto wishlistDto);
    WishListDto getWishListById(String id);
    List<WishListDto> getWishLists();
    void deleteWishList(String id);
}
