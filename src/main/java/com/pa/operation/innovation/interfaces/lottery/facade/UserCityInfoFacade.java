package com.pa.operation.innovation.interfaces.lottery.facade;

import com.pa.operation.innovation.domain.model.lottery.valobj.LotteryContextDTO;
import com.pa.operation.innovation.domain.model.lottery.valobj.MtCityInfo;
import com.pa.operation.innovation.sao.LbsSao;
import com.pa.operation.innovation.sao.request.LbsRequest;
import com.pa.operation.innovation.sao.response.LbsResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserCityInfoFacade {

    @Resource
    private LbsSao lbsSao;//外部用户城市信息RPC服务

    public MtCityInfo getMtCityInfo(LotteryContextDTO context) {
        LbsRequest lbsReq = new LbsRequest();
        lbsReq.setLat(context.getLat());
        lbsReq.setLng(context.getLng());
        LbsResponse resp = lbsSao.getLbsCityInfo(lbsReq);
        return buildMtCityInfo(resp);
    }

    private MtCityInfo buildMtCityInfo(LbsResponse resp) {
        return new MtCityInfo();
    }
}
