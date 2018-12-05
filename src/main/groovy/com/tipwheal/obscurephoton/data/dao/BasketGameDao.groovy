package com.tipwheal.obscurephoton.data.dao

import com.tipwheal.obscurephoton.data.model.BasketGame
import org.springframework.data.jpa.repository.JpaRepository

interface BasketGameDao extends JpaRepository<BasketGame, Long>{

}