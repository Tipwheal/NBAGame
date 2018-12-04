package com.tipwheal.obscurephoton.runner

import com.tipwheal.obscurephoton.data.dao.GlobalInfoDao
import com.tipwheal.obscurephoton.data.model.GlobalInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class InitRunner implements ApplicationRunner {

    @Autowired
    GlobalInfoDao globalInfoDao

    @Override
    void run(ApplicationArguments args) throws Exception {
        if (!globalInfoDao.existsById("currentYear")) {
            def year = new GlobalInfo()
            year.description = "currentYear"
            year.value = "2018"
            globalInfoDao.save(year)
        }
    }
}
