package com.tipwheal.obscurephoton.data.model

import lombok.Builder

import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Builder
class BasketPlayer {

    @Id
    long id
    String name
    int bornYear
}
