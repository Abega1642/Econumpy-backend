package dev.razafindratelo.numPy.controller;

import dev.razafindratelo.numPy.dtos.postDtos.WishListDto;
import dev.razafindratelo.numPy.services.wishListService.WishListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class WishListController {

    private WishListService wishListService;

    @GetMapping("/wishlist")
    public ResponseEntity<List<WishListDto>> getWishList() {
        List<WishListDto> eventDtoList = wishListService.getWishLists();
        return ResponseEntity.ok(eventDtoList);
    }

    @GetMapping("/whishlist/{eventId}")
    public ResponseEntity<WishListDto> getEvent(@PathVariable String wishlistId) {
        WishListDto wishListDto = wishListService.getWishListById(wishlistId);
        return ResponseEntity.ok(wishListDto);
    }

    @PostMapping("/wishlist/add")
    public ResponseEntity<WishListDto> addWishlist(@RequestBody WishListDto wishListDto) {
        WishListDto addEvent = wishListService.createWishList(wishListDto);
        return new ResponseEntity<>(addEvent, HttpStatus.CREATED);
    }

    @PutMapping("/wishlist/update/{wishlistId}")
    public ResponseEntity<WishListDto> updateEvent(@PathVariable("wishlistId") String wishlistId, @RequestBody WishListDto wishlistDto) {
        WishListDto updateEvent = wishListService.updateWishList(wishlistId, wishlistDto);
        return new ResponseEntity<>(updateEvent, HttpStatus.OK);
    }

    @DeleteMapping("/wishlist/delete/{wishlistId}")
    public String deleteWishlist(@PathVariable("wishlistId") String  wishlistId) {
        wishListService.deleteWishList(wishlistId);
        return "Wishlist deleted with success !";
    }
}
