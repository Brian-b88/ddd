package com.pa.operation.innovation.domain.service.impl;

import com.pa.operation.innovation.domain.service.LotteryRiskService;
import com.pa.operation.innovation.domain.service.request.RiskRequest;
import com.pa.operation.innovation.domain.service.response.RiskAccessToken;
import org.springframework.stereotype.Service;

@Service
public class LotteryRiskServiceImpl implements LotteryRiskService {
    @Override
    public RiskAccessToken acquire(RiskRequest buildRiskReq) {
        return null;
    }
}
