package com.pa.operation.innovation.domain.service;

import com.pa.operation.innovation.domain.model.lottery.valobj.Award;
import com.pa.operation.innovation.domain.model.lottery.valobj.LotteryContextDTO;
import com.pa.operation.innovation.domain.service.response.AwardSendResponse;

public interface AwardSendService {
    AwardSendResponse sendAward(Award award, LotteryContextDTO lotteryContext);
}
