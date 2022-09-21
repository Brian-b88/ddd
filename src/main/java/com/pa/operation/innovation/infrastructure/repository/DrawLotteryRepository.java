package com.pa.operation.innovation.infrastructure.repository;

import com.pa.operation.innovation.domain.model.lottery.aggregate.DrawLottery;
import com.pa.operation.innovation.infrastructure.dao.AwardDao;
import com.pa.operation.innovation.infrastructure.dao.AwardPoolDao;
import com.pa.operation.innovation.infrastructure.cache.DrawLotteryCacheAccessObj;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DrawLotteryRepository {

    @Resource
    private AwardDao awardDao;
    @Resource
    private AwardPoolDao awardPoolDao;
    @Resource
    private DrawLotteryCacheAccessObj drawLotteryCacheAccessObj;

    public DrawLottery getDrawLotteryById(int lotteryId) {
        DrawLottery drawLottery = drawLotteryCacheAccessObj.get(lotteryId);
        if(drawLottery!=null){
            return drawLottery;
        }
        drawLottery = getDrawLotteryFromDB(lotteryId);
        drawLotteryCacheAccessObj.add(lotteryId, drawLottery);
        return drawLottery;
    }

    private DrawLottery getDrawLotteryFromDB(int lotteryId) {
        return new DrawLottery();
    }
}
