package dev.razafindratelo.numPy.services.wishListService;

import dev.razafindratelo.numPy.dtos.postDtos.WishListDto;

import java.util.List;

public interface WishListService {
    WishListDto createWishList(WishListDto wishlistDto);
    WishListDto updateWishList(String wishlistId,WishListDto wishlistDto);
    WishListDto getWishListById(String id);
    List<WishListDto> getWishLists();
    void deleteWishList(String id);
}
