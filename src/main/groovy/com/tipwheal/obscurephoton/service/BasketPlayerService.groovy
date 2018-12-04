package com.tipwheal.obscurephoton.service

import com.tipwheal.obscurephoton.config.StaticPolicy
import com.tipwheal.obscurephoton.data.dao.BasketPlayerDao
import com.tipwheal.obscurephoton.data.model.BasketPlayer
import com.tipwheal.obscurephoton.util.RandomUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BasketPlayerService {

    @Autowired
    BasketPlayerDao basketPlayerDao

    @Autowired
    GlobalInfoService globalInfoService

    List getAllPlayers() {
        return basketPlayerDao.findAll()
    }

    void createRandomBasketPlayer() {
        int year = globalInfoService.currentYear
        int age = RandomUtil.randomInt(StaticPolicy.ROOKIE_MIN_AGE, StaticPolicy.ROOKIE_MAX_AGE)
        int bornYear = year - age
        def player = new BasketPlayer(name: "bob", bornYear: bornYear)
        basketPlayerDao.save(player)
    }
}
