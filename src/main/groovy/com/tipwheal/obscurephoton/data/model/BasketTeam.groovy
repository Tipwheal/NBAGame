package com.tipwheal.obscurephoton.data.model

import lombok.Builder

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class BasketTeam {

    @Id
    @GeneratedValue
    long id

    String name

    @OneToMany
    List<BasketPlayer> playerList
}
