package com.tipwheal.obscurephoton.service

import com.tipwheal.obscurephoton.data.dao.BasketPlayerDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BasketPlayerService {

    @Autowired
    BasketPlayerDao basketPlayerDao

    List getAllPlayers() {
        return basketPlayerDao.findAll()
    }

    void createRandomBasketPlayer() {

    }
}
