package com.pa.operation.innovation.domain.model.lottery.aggregate;

import com.pa.operation.innovation.domain.model.lottery.valobj.*;

import java.util.List;

/**
 * 聚合根-抽奖
 * 我们通过抽奖(DrawLottery)这个聚合根来控制抽奖行为
 * 一个抽奖包括了抽奖ID（LotteryId）以及多个奖池（AwardPool），而一个奖池针对一个特定的用户群体（UserGroup）设置了多个奖品（Award）。
 */
public class DrawLottery {

    private Long lotteryId; //抽奖id
    private List<AwardPool> awardPools; //奖池列表

    //getter & setter
    public void setLotteryId(Long lotteryId) {
        if(lotteryId == null || lotteryId<=0){
            throw new IllegalArgumentException("非法的抽奖id");
        }
        this.lotteryId = lotteryId;
    }

    //根据抽奖入参context选择奖池
    public AwardPool chooseAwardPool(DrawLotteryContext context) {
        if(context.getMtCityInfo()!=null) {
            return chooseAwardPoolByCityInfo(awardPools, context.getMtCityInfo());
        } else {
            return chooseAwardPoolByScore(awardPools, context.getGameScore());
        }
    }

    //根据抽奖所在城市选择奖池
    private AwardPool chooseAwardPoolByCityInfo(List<AwardPool> awardPools, MtCityInfo cityInfo) {
        for(AwardPool awardPool: awardPools) {
            if(awardPool.matchedCity(cityInfo.getCityId())) {
                return awardPool;
            }
        }
        return null;
    }

    private AwardPool chooseAwardPoolByScore(List<AwardPool> awardPools, GameScore gameScore) {
        for(AwardPool awardPool: awardPools) {
            if(awardPool.matchedScore(gameScore.getScore())) {
                return awardPool;
            }
        }
        return null;
    }
}
