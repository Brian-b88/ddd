package com.pa.operation.innovation.domain.model.lottery.valobj;

import com.pa.operation.innovation.domain.model.lottery.aggregate.DrawLottery;
import lombok.Data;

/**
 * 值对象-抽奖上下文
 * 带有用户抽奖时的场景信息（抽奖得分或抽奖时所在的城市）
 */
@Data
public class DrawLotteryContext {

    public MtCityInfo getMtCityInfo() {
        return new MtCityInfo();
    }

    public GameScore getGameScore() {
        return new GameScore();
    }
}
