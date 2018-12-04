package com.tipwheal.obscurephoton.data.dao

import com.tipwheal.obscurephoton.data.model.BasketPlayer
import org.springframework.data.jpa.repository.JpaRepository

interface BasketPlayerDao extends JpaRepository<BasketPlayer, Long> {
}
