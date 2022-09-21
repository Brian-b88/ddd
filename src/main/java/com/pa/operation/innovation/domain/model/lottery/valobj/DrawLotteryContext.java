package com.pa.operation.innovation.domain.model.lottery.valobj;

import com.pa.operation.innovation.domain.model.lottery.aggregate.DrawLottery;
import lombok.Data;

@Data
public class DrawLotteryContext {

    public MtCityInfo getMtCityInfo() {
        return new MtCityInfo();
    }

    public GameScore getGameScore() {
        return new GameScore();
    }
}
