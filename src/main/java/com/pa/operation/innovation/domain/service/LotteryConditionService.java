package com.pa.operation.innovation.domain.service;

import com.pa.operation.innovation.domain.service.response.LotteryConditionResult;

/**
 * 领域服务-活动准入服务
 */
public interface LotteryConditionService {
    LotteryConditionResult checkLotteryCondition(int lotteryId, String userId);
}
