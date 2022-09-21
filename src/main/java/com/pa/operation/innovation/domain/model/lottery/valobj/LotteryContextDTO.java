package com.pa.operation.innovation.domain.model.lottery.valobj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotteryContextDTO {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 抽奖活动ID
     */
    private Integer lotteryId;
    /**
     * 纬度
     */
    private String lat;
    /**
     * 经度
     */
    private String lng;
}
