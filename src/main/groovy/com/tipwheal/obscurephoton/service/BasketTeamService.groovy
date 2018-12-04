package com.tipwheal.obscurephoton.service

import com.tipwheal.obscurephoton.data.dao.BasketTeamDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BasketTeamService {

    @Autowired
    BasketTeamDao basketTeamDao

    List getAllTeams() {
        basketTeamDao.findAll()
    }
}
