package com.pa.operation.innovation.application;

import com.pa.operation.innovation.common.Response;
import com.pa.operation.innovation.common.ResponseCode;
import com.pa.operation.innovation.common.ResponseMsg;
import com.pa.operation.innovation.domain.model.lottery.valobj.LotteryContext;
import com.pa.operation.innovation.domain.service.LotteryConditionService;
import com.pa.operation.innovation.domain.service.LotteryRiskService;
import com.pa.operation.innovation.domain.service.LotteryService;
import com.pa.operation.innovation.domain.service.request.RiskRequest;
import com.pa.operation.innovation.domain.service.response.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 应用服务-抽奖
 */
@Service
public class LotteryApplicationService {

    @Resource
    private LotteryRiskService riskService;
    @Resource
    private LotteryConditionService conditionService;
    @Resource
    private LotteryService lotteryService;

    //用户参与抽奖活动
    public Response<PrizeInfo, ErrorData> participateLottery(LotteryContext lotteryContext) {
        //校验用户登录信息
        validateLoginInfo(lotteryContext);
        //校验风控
        RiskAccessToken riskToken = riskService.acquire(buildRiskReq(lotteryContext));
        //活动准入检查
        LotteryConditionResult conditionResult = conditionService.checkLotteryCondition(lotteryContext.getLotteryId(),lotteryContext.getUserId());
        //抽奖并返回结果
        IssueResponse issueResponse = lotteryService.issueLottery(lotteryContext);
        if(issueResponse!=null && issueResponse.getCode() == IssueResponse.OK) {
            return buildSuccessResponse(issueResponse.getPrizeInfo());
        } else {
            return buildErrorResponse(ResponseCode.ISSUE_LOTTERY_FAIL, ResponseMsg.ISSUE_LOTTERY_FAIL);
        }
    }

    private RiskRequest buildRiskReq(LotteryContext lotteryContext) {
        return null;
    }

    private void validateLoginInfo(LotteryContext lotteryContext){
        return;
    }
    private Response<PrizeInfo, ErrorData> buildErrorResponse (int code, String msg){
        return null;
    }
    private Response<PrizeInfo, ErrorData> buildSuccessResponse (PrizeInfo prizeInfo){
        return null;
    }
}
