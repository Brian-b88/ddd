package com.pa.operation.innovation.domain.model.lottery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 实体-用户领奖记录
 * 领奖凭据和存根
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLotteryLog {
    /**
     * 唯一标识
     */
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 抽奖活动ID
     */
    private String lotteryId;
    /**
     * 发奖时间
     */
    private Date issueDateTime;
    /**
     * 领取时间
     */
    private Date acquireDateTime;
}
