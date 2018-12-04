package com.tipwheal.obscurephoton.controller

import com.tipwheal.obscurephoton.service.GlobalInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/global")
class GlobalInfoController {

    @Autowired
    GlobalInfoService globalInfoService

    @PostMapping("/all")
    List getGlobalInfo() {
        globalInfoService.getGlobalInfo()
    }
}
