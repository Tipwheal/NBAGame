package com.tipwheal.obscurephoton.service

import com.tipwheal.obscurephoton.data.dao.BasketPlayerDao
import com.tipwheal.obscurephoton.data.dao.BasketTeamDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContractService {

    @Autowired
    BasketPlayerDao basketPlayerDao

    @Autowired
    BasketTeamDao basketTeamDao

    /**
     *
     * @param team 球队
     * @param player
     */
    void makeContract(long teamId, long playerId) {
        def team = basketTeamDao.findById(teamId).get()
        def player = basketPlayerDao.findById(playerId).get()
        team.playerList.add(player)
        basketTeamDao.save(team)
    }
}
