package com.tipwheal.obscurephoton.service

import com.tipwheal.obscurephoton.data.dao.BasketPlayerDao
import com.tipwheal.obscurephoton.data.dao.BasketTeamDao
import com.tipwheal.obscurephoton.data.dao.PlayerTeamRoleDao
import com.tipwheal.obscurephoton.data.model.PlayerTeamRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ContractService {

    @Autowired
    BasketPlayerDao basketPlayerDao

    @Autowired
    BasketTeamDao basketTeamDao

    @Autowired
    PlayerTeamRoleDao playerTeamRoleDao

    /**
     *
     * @param team 球队
     * @param player
     */
    void makeContract(long teamId, long playerId) {
        def team = basketTeamDao.findById(teamId).get()
        def player = basketPlayerDao.findById(playerId).get()
        def role = new PlayerTeamRole(team: team, player: player)
        team.playerList.add(role)
        playerTeamRoleDao.save(role)
        basketTeamDao.save(team)
    }

    void breakContract(long teamId, long playerId) {
        def team = basketTeamDao.findById(teamId).get()
        def player = team.playerList.find { p -> p.id == playerId }
        team.playerList.remove(player)
        basketTeamDao.save(team)
    }
}
