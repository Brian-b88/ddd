package com.pa.operation.innovation.domain.service.impl;

import com.pa.operation.innovation.domain.event.AwardSent;
import com.pa.operation.innovation.domain.model.lottery.valobj.Award;
import com.pa.operation.innovation.domain.model.lottery.valobj.LotteryContext;
import com.pa.operation.innovation.domain.service.AwardSendService;
import com.pa.operation.innovation.domain.service.response.AwardSendResponse;
import com.pa.operation.innovation.infrastructure.mq.RocketMQService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AwardSendServiceImpl implements AwardSendService {

    @Resource
    private RocketMQService rocketMQService;
    @Override
    public AwardSendResponse sendAward(Award award, LotteryContext lotteryContext) {
        // 记录用户得奖信息
        AwardSendResponse awardSendResponse = new AwardSendResponse();
        // 领域事件建模
        AwardSent awardSent = buildAwardSend(award, lotteryContext);
        // 发出通知
        rocketMQService.send(awardSent);
        return awardSendResponse;
    }

    // 领域事件建模
    private AwardSent buildAwardSend(Award award, LotteryContext lotteryContextDTO) {
        return new AwardSent();
    }
}
