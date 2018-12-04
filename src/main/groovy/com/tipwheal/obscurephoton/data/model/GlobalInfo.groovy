package com.tipwheal.obscurephoton.data.model

import lombok.Builder
import lombok.Data

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class GlobalInfo {

    @Id
    String description

    String value

    int getIntValue() {
        return Integer.parseInt(value)
    }
}
