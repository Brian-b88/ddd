package com.pa.operation.innovation.domain.service;

import com.pa.operation.innovation.domain.model.lottery.valobj.LotteryContext;
import com.pa.operation.innovation.domain.service.response.IssueResponse;

/**
 * 领域服务-抽奖服务
 * 领域服务就是通过串联领域对象、资源库和防腐层等一系列领域内的对象的行为，对其他上下文提供交互的接口
 */
public interface LotteryService {

    IssueResponse issueLottery(LotteryContext lotteryContext);

}
