package com.pa.operation.innovation.infrastructure.cache;

import com.pa.operation.innovation.domain.model.lottery.aggregate.DrawLottery;

/**
 * @author Rich Brain
 * @version 1.0.0
 * @description TODO
 * @createTime 2022年09月19日 22:18:00
 */
public interface DrawLotteryCacheAccessObj {
    DrawLottery get(int lotteryId);

    void add(int lotteryId, DrawLottery drawLottery);
}
