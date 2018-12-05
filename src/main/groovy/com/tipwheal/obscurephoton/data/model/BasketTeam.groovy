package com.tipwheal.obscurephoton.data.model

import lombok.Builder

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToMany

@Entity
class BasketTeam {

    @Id
    @GeneratedValue
    long id

    String name

    @OneToMany
    @JoinColumn(name="team_id")
    List<PlayerTeamRole> playerList
}
