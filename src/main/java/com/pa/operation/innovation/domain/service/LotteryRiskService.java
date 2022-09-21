package com.pa.operation.innovation.domain.service;

import com.pa.operation.innovation.domain.service.request.RiskRequest;
import com.pa.operation.innovation.domain.service.response.RiskAccessToken;

/**
 * 领域服务-风控服务
 */
public interface LotteryRiskService {
    RiskAccessToken acquire(RiskRequest buildRiskReq);
}
