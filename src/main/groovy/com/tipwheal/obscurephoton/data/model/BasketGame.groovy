package com.tipwheal.obscurephoton.data.model


import javax.persistence.*

@Entity
class BasketGame {

    @Id
    @GeneratedValue
    long id

    long winnerId

    @OneToOne(cascade = [CascadeType.PERSIST, CascadeType.REFRESH])
    @JoinColumn(unique = true)
    TeamGameInfo homeTeamInfo

    @OneToOne(cascade = [CascadeType.PERSIST, CascadeType.REFRESH])
    @JoinColumn(unique = true)
    TeamGameInfo visitorTeamInfo

}
