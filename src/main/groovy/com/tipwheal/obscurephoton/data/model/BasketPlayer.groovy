package com.tipwheal.obscurephoton.data.model

import com.tipwheal.obscurephoton.util.GlobalInfoPool
import lombok.Builder

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class BasketPlayer {

    @Id
    @GeneratedValue
    long id
    String name
    int bornYear

    int getAge() {
        GlobalInfoPool.currentYear - bornYear
    }
}
