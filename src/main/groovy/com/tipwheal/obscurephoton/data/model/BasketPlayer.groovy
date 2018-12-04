package com.tipwheal.obscurephoton.data.model

import com.tipwheal.obscurephoton.util.GlobalInfoPool

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class BasketPlayer {

    @Id
    @GeneratedValue
    long id

    String name

    int bornYear

    @ManyToOne
    BasketTeam team

    private BasketTeam getTeam() {
        team
    }

    String getTeamName() {
        if (team != null) {
            return team.getName()
        }
        null
    }

    int getAge() {
        GlobalInfoPool.currentYear - bornYear
    }
}
