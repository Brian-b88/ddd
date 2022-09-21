package com.pa.operation.innovation.domain.model.lottery.valobj;

import com.pa.operation.innovation.domain.model.lottery.aggregate.DrawLottery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 值对象-抽奖上下文
 * 带有用户抽奖时的场景信息（抽奖得分或抽奖时所在的城市）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrawLotteryContext {

    private MtCityInfo mtCityInfo;

    private GameScore gameScore;
}
