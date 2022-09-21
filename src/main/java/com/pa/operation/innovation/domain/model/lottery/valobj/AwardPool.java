package com.pa.operation.innovation.domain.model.lottery.valobj;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 值对象-奖池
 */
public class AwardPool {
    private List<String> cityIds;//奖池支持的城市
    private List<Double> scores;//奖池支持的得分
    private String userGroupId;//奖池匹配的用户类型
    private List<Award> awards;//奖池中包含的奖品
    //当前奖池是否与城市匹配
    public boolean matchedCity(String cityId) {
        return cityIds.contains(cityId);
    }

    //当前奖池是否与用户得分匹配
    public boolean matchedScore(Double score) {
        return scores.contains(score);
    }

    //根据概率选择奖池
    public Award randomGetAward() {
        int sumOfProbablity = 0;
        for(Award award: awards) {
            sumOfProbablity += award.getAwardProbability();
        }
        int randomNumber = ThreadLocalRandom.current().nextInt(sumOfProbablity);
        int range = 0;
        for(Award award: awards) {
            range += award.getProbability();
            if(randomNumber<range) {
                return award;
            }
        }
        return null;
    }
}
