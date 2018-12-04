package com.tipwheal.obscurephoton.controller

import com.tipwheal.obscurephoton.data.model.BasketPlayer
import com.tipwheal.obscurephoton.data.model.BasketTeam
import com.tipwheal.obscurephoton.service.ContractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/contract")
class ContractController {

    @Autowired
    ContractService contractService

    @PostMapping("/make")
    void makeContract(long teamId, long playerId) {
        contractService.makeContract(teamId, playerId)
    }

    @PostMapping("/break")
    void breakContract(long teamId, long playerId) {
        contractService.breakContract(teamId, playerId)
    }
}
