package com.tipwheal.obscurephoton.controller

import com.tipwheal.obscurephoton.service.BasketPlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/player")
class BasketPlayerController {

    @Autowired
    BasketPlayerService basketPlayerService

    @PostMapping("/all")
    List findAllPlayer() {
        return basketPlayerService.getAllPlayers()
    }

    @PostMapping("/random")
    void createRandomPlayer() {
        basketPlayerService.createRandomBasketPlayer()
    }
}
