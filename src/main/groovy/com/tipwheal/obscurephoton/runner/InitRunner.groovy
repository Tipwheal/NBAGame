package com.tipwheal.obscurephoton.runner

import com.tipwheal.obscurephoton.data.dao.BasketTeamDao
import com.tipwheal.obscurephoton.data.dao.GlobalInfoDao
import com.tipwheal.obscurephoton.data.model.BasketTeam
import com.tipwheal.obscurephoton.data.model.GlobalInfo
import com.tipwheal.obscurephoton.util.GlobalInfoPool
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class InitRunner implements ApplicationRunner {

    @Autowired
    GlobalInfoDao globalInfoDao

    @Autowired
    BasketTeamDao basketTeamDao

    @Override
    void run(ApplicationArguments args) throws Exception {
        if (!globalInfoDao.existsById("currentYear")) {
            def year = new GlobalInfo(description: "currentYear", value: "2018")
            globalInfoDao.save(year)
        }
        def currentYear = globalInfoDao.findById("currentYear").get().intValue
        GlobalInfoPool.currentYear = currentYear
        if (basketTeamDao.findAll().size() == 0) {
            def createTeam = {
                name ->
                    BasketTeam team = new BasketTeam(name: name)
                    basketTeamDao.save(team)
            }
            ["雷霆", "马刺", "勇士", "火箭"].each(createTeam)
        }
    }
}
