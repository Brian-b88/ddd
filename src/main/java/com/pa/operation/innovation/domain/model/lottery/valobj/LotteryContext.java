package com.pa.operation.innovation.domain.model.lottery.valobj;

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
public class LotteryContext {

    private String userId;
    private Integer lotteryId;

    private String lat;
    private String lng;

    public String getUserId() {
        return userId;
    }

    public int getLotteryId() {
        return lotteryId;
    }
}
