package com.tipwheal.obscurephoton.service

import com.tipwheal.obscurephoton.data.dao.GlobalInfoDao
import com.tipwheal.obscurephoton.data.model.GlobalInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GlobalInfoService {

    @Autowired
    GlobalInfoDao globalInfoDao

    List getGlobalInfo() {
        globalInfoDao.findAll()
    }

    void resetGlobalInfo() {
        globalInfoDao.deleteAll()
        def year = new GlobalInfo(description: "year", value: "2018")
        globalInfoDao.save year
    }
}
