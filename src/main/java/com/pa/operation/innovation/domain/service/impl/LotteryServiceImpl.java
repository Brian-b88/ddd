package com.pa.operation.innovation.domain.service.impl;

import com.pa.operation.innovation.domain.event.AwardSent;
import com.pa.operation.innovation.domain.model.lottery.aggregate.DrawLottery;
import com.pa.operation.innovation.domain.model.lottery.valobj.*;
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
    private UserCityInfoFacade userCityInfoFacade;
    @Resource
    private AwardSendService awardSendService;
    @Resource
    private AwardCounterFacade awardCounterFacade;

    @Override
    public IssueResponse issueLottery(LotteryContextDTO lotteryContext) {
        //获取抽奖配置聚合根
        DrawLottery drawLottery = drawLotteryRepo.getDrawLotteryById(lotteryContext.getLotteryId());
        //增加抽奖计数信息
        awardCounterFacade.incrTryCount(lotteryContext);
        //选中奖池
        AwardPool awardPool = drawLottery.chooseAwardPool(buildDrawLotteryContext(drawLottery, lotteryContext));
        //选中奖品
        Award award = awardPool.randomChooseAward();
        //发出奖品实体
        return buildIssueResponse(awardSendService.sendAward(award, lotteryContext));
    }

    /**
     *
     * @param drawLottery
     * @param lotteryContextDTO
     * @return
     */
    private DrawLotteryContext buildDrawLotteryContext(DrawLottery drawLottery, LotteryContextDTO lotteryContextDTO) {
        // 根据用户id和抽奖活动ID查询用户得分
        GameScore gameScore = new GameScore();
        // 根据经纬度查询用户位置
        MtCityInfo mtCityInfo = userCityInfoFacade.getMtCityInfo(lotteryContextDTO);
        return new DrawLotteryContext(mtCityInfo, gameScore);
    }

    private IssueResponse buildIssueResponse(AwardSendResponse awardSendResponse) {
        return null;
    }
}
