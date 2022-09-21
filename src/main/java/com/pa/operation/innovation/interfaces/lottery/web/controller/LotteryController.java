package com.pa.operation.innovation.interfaces.lottery.web.controller;


import com.pa.operation.innovation.application.LotteryApplicationService;
import com.pa.operation.innovation.common.Response;
import com.pa.operation.innovation.domain.model.lottery.valobj.LotteryContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Resource
    private LotteryApplicationService lotteryApplicationService;

    @RequestMapping("/draw")
    public Response draw(String userId, Integer lotteryId, String lat, String lng) {
        return lotteryApplicationService.participateLottery(buildLotteryContext(userId, lotteryId, lat, lng));
    }

    LotteryContext buildLotteryContext(String userId, Integer lotteryId, String lat, String lng) {
        return new LotteryContext(userId, lotteryId, lat, lng);
    }
}
