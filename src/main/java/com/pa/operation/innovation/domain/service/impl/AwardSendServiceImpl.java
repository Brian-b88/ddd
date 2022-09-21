package com.pa.operation.innovation.domain.service.impl;

import com.pa.operation.innovation.domain.model.lottery.valobj.Award;
import com.pa.operation.innovation.domain.model.lottery.valobj.LotteryContext;
import com.pa.operation.innovation.domain.service.AwardSendService;
import com.pa.operation.innovation.domain.service.response.AwardSendResponse;
import org.springframework.stereotype.Service;

@Service
public class AwardSendServiceImpl implements AwardSendService {
    @Override
    public AwardSendResponse sendAward(Award award, LotteryContext lotteryContext) {
        return null;
    }
}
