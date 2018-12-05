package com.tipwheal.obscurephoton.data.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
class TeamGameInfo {

    @Id
    @GeneratedValue
    long id

    int score

    @OneToMany
    @JoinColumn(name = "team_info_id")
    List<PlayerGameInfo> playerList
}
