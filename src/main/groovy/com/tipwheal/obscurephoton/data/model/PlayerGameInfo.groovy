package com.tipwheal.obscurephoton.data.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class PlayerGameInfo {

    @Id
    long id

    long playerId

    String name

    int score

    int minutes

    @ManyToOne
    TeamGameInfo team

    private TeamGameInfo getTeam() {
        team
    }
}
