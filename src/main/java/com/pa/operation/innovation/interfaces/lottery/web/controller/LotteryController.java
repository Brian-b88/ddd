package com.pa.operation.innovation.interfaces.lottery.web.controller;


import com.pa.operation.innovation.application.LotteryApplicationService;
import com.pa.operation.innovation.common.Response;
import com.pa.operation.innovation.domain.model.lottery.valobj.LotteryContextDTO;
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
        return lotteryApplicationService.participateLottery(buildLotteryContextDTO(userId, lotteryId, lat, lng));
    }

    /**
     * DTO->DO
     * @param userId
     * @param lotteryId
     * @param lat
     * @param lng
     * @return
     */
    LotteryContextDTO buildLotteryContextDTO(String userId, Integer lotteryId, String lat, String lng) {
        return new LotteryContextDTO(userId, lotteryId, lat, lng);
    }
}
