package com.pa.operation.innovation.domain.service.impl;

import com.pa.operation.innovation.domain.model.lottery.aggregate.DrawLottery;
import com.pa.operation.innovation.domain.model.lottery.valobj.Award;
import com.pa.operation.innovation.domain.model.lottery.valobj.AwardPool;
import com.pa.operation.innovation.domain.model.lottery.valobj.DrawLotteryContext;
import com.pa.operation.innovation.domain.model.lottery.valobj.LotteryContext;
import com.pa.operation.innovation.domain.service.AwardSendService;
import com.pa.operation.innovation.domain.service.LotteryService;
import com.pa.operation.innovation.domain.service.response.AwardSendResponse;
import com.pa.operation.innovation.domain.service.response.IssueResponse;
import com.pa.operation.innovation.infrastructure.repository.DrawLotteryRepository;
import com.pa.operation.innovation.interfaces.lottery.facade.AwardCounterFacade;
import com.pa.operation.innovation.interfaces.lottery.facade.UserCityInfoFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LotteryServiceImpl implements LotteryService {
    @Resource
    private DrawLotteryRepository drawLotteryRepo;
    @Resource
    private UserCityInfoFacade UserCityInfoFacade;
    @Resource
    private AwardSendService awardSendService;
    @Resource
    private AwardCounterFacade awardCounterFacade;

    @Override
    public IssueResponse issueLottery(LotteryContext lotteryContext) {
        DrawLottery drawLottery = drawLotteryRepo.getDrawLotteryById(lotteryContext.getLotteryId());//获取抽奖配置聚合根
        awardCounterFacade.incrTryCount(lotteryContext);//增加抽奖计数信息
        AwardPool awardPool = drawLottery.chooseAwardPool(buildDrawLotteryContext(drawLottery, lotteryContext));//选中奖池
        Award award = awardPool.randomChooseAward();//选中奖品
        return buildIssueResponse(awardSendService.sendAward(award, lotteryContext));//发出奖品实体
    }

    private DrawLotteryContext buildDrawLotteryContext(DrawLottery drawLottery, LotteryContext lotteryContext) {
        return null;
    }

    private IssueResponse buildIssueResponse(AwardSendResponse awardSendResponse) {
        return null;
    }
}
