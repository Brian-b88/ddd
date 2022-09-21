package com.pa.operation.innovation.sao;

import com.pa.operation.innovation.sao.request.LbsRequest;
import com.pa.operation.innovation.sao.response.LbsResponse;

/**
 * 外部用户城市信息RPC服务
 */
public interface LbsSao {
    /**
     * 查询城市信息
     * @param request
     * @return
     */
    LbsResponse getLbsCityInfo(LbsRequest request);
}
