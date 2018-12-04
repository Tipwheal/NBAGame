package com.tipwheal.obscurephoton.data.dao

import com.tipwheal.obscurephoton.data.model.GlobalInfo
import org.springframework.data.jpa.repository.JpaRepository

interface GlobalInfoDao extends JpaRepository<GlobalInfo, String>{

}