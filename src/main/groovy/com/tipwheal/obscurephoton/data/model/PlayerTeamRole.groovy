package com.tipwheal.obscurephoton.data.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

@Entity
class PlayerTeamRole {

    @Id
    @GeneratedValue
    long id

    @ManyToOne
    BasketTeam team

    @OneToOne
    @JoinColumn(unique = true)
    BasketPlayer player

    private BasketTeam getTeam() {
        team
    }
}
