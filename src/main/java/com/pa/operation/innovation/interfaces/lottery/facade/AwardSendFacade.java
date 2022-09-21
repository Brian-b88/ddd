package com.pa.operation.innovation.interfaces.lottery.facade;

import com.pa.operation.innovation.domain.model.lottery.valobj.Award;
import com.pa.operation.innovation.domain.model.lottery.valobj.LotteryContext;
import com.pa.operation.innovation.domain.service.response.AwardSendResponse;
import org.springframework.stereotype.Component;

/**
 * 防腐层-奖品发放
 * 抽奖上下文在进行发券动作时，会依赖券码、平台券、外卖券三个上下文。抽奖上下文通过防腐层（Anticorruption Layer，ACL）对三个上下文进行了隔离，
 * 而三个券上下文通过开放主机服务（Open Host Service）作为发布语言（Published Language）对抽奖上下文提供访问机制。
 */
@Component
public class AwardSendFacade {

    public AwardSendResponse sendAward(Award award, LotteryContext lotteryContext) {
        return new AwardSendResponse();
    }
}
