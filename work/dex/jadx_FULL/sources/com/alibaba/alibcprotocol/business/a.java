package com.alibaba.alibcprotocol.business;

import com.alibaba.baichuan.trade.common.mtop.NetworkBusiness;
import com.alibaba.baichuan.trade.common.mtop.NetworkRequest;
import com.alibaba.baichuan.trade.common.mtop.NetworkRequestListener;
import com.alibaba.baichuan.trade.common.mtop.NetworkResponse;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a extends NetworkBusiness {
    public a() {
        this.API_NAME = "mtop.taobao.bcbs.mini.convert";
        this.TIME_OUT = 90000;
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.NetworkBusiness
    public final NetworkResponse sendRequest(NetworkRequest networkRequest) {
        return super.sendRequest(networkRequest);
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.NetworkBusiness
    public final boolean sendRequest(NetworkRequest networkRequest, NetworkRequestListener networkRequestListener) {
        return super.sendRequest(networkRequest, networkRequestListener);
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.NetworkBusiness
    public final boolean sendRequest(Map<String, Object> map, NetworkRequestListener networkRequestListener) {
        return super.sendRequest(map, networkRequestListener);
    }

    @Override // com.alibaba.baichuan.trade.common.mtop.NetworkBusiness
    public final NetworkResponse sendRequest(Map<String, Object> map) {
        return super.sendRequest(map);
    }
}
