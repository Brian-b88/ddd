package com.pa.operation.innovation.domain.event;

import java.util.Date;

/**
 * 事件建模-奖品已发出
 */
public class AwardSent {

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
    private Integer lotteryId;
    /**
     * 事件发生时间
     */
    private Date businessCreatedDate;
}
