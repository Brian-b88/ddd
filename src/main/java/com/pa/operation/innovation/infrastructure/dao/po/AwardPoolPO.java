package com.pa.operation.innovation.infrastructure.dao.po;

import com.pa.operation.innovation.domain.model.lottery.valobj.Award;

import java.util.List;

/**
 * 数据库持久化对象-奖池
 */
public class AwardPoolPO {
    private String cityIds;//奖池支持的城市
    private String scores;//奖池支持的得分
    private int userGroupType;//奖池匹配的用户类型
    private List<Award> awards;//奖池中包含的奖品

    //当前奖池是否与城市匹配
    public boolean matchedCity(int cityId) {
        return true;
    }

    //当前奖池是否与用户得分匹配
    public boolean matchedScore(int score) {
        return true;
    }

    //根据概率选择奖池
    public Award randomGetAward() {
        return new Award();
    }
}
