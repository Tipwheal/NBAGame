package com.tipwheal.obscurephoton.controller

import com.tipwheal.obscurephoton.service.BasketTeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/team")
class BasketTeamController {

    @Autowired
    BasketTeamService basketTeamService

    @PostMapping("/all")
    List getAllTeams() {
        basketTeamService.getAllTeams()
    }

    @PostMapping("/name/{name}")
    List getTeamByName(@PathVariable String name) {
        null
    }
}
