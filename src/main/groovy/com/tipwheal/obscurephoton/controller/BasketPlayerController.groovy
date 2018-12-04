package com.tipwheal.obscurephoton.controller

import com.tipwheal.obscurephoton.service.BasketPlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class BasketPlayerController {

    @Autowired
    BasketPlayerService testService

    @PostMapping
    List findAllPlayer() {
        return testService.getAllPlayers()
    }

    void createRandomPlayer() {

    }
}
