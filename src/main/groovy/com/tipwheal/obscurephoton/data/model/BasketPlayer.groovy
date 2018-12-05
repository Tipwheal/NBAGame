package com.tipwheal.obscurephoton.data.model

import com.tipwheal.obscurephoton.util.GlobalInfoPool

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class BasketPlayer {

    @Id
    @GeneratedValue
    long id

    String name

    int bornYear

    int scoreAbility

    @OneToOne(mappedBy = "player")
    PlayerTeamRole role

    private PlayerTeamRole getRole() {
        role
    }

    String getTeamName() {
        if (role != null) {
            return role.team.getName()
        }
        null
    }

    int getAge() {
        GlobalInfoPool.currentYear - bornYear
    }
}
