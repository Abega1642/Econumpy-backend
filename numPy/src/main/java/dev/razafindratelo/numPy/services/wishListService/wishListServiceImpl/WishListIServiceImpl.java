package dev.razafindratelo.numPy.services.wishListService.wishListServiceImpl;

import dev.razafindratelo.numPy.dtos.postDtos.WishListDto;
import dev.razafindratelo.numPy.services.wishListService.WishListService;

import java.util.List;

public class WishListIServiceImpl implements WishListService {
    @Override
    public WishListDto createWishList(WishListDto wishlistDto) {
        return null;
    }

    @Override
    public WishListDto updateWishList(String wishlistId, WishListDto wishlistDto) {
        return null;
    }

    @Override
    public WishListDto getWishListById(String id) {
        return null;
    }

    @Override
    public List<WishListDto> getWishLists() {
        return List.of();
    }

    @Override
    public void deleteWishList(String id) {

    }
}
