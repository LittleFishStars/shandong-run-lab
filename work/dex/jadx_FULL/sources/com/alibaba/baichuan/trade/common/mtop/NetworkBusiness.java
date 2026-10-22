package com.alibaba.baichuan.trade.common.mtop;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class NetworkBusiness {
    protected String API_NAME = "";
    protected String API_VERSION = "1.0";
    protected boolean IS_NEED_LOGIN = false;
    protected Boolean IS_WUA = Boolean.FALSE;
    protected boolean IS_AUTH = false;
    protected boolean IS_POST = true;
    protected int TIME_OUT = -1;

    private NetworkRequest a(Map<String, Object> map) {
        NetworkRequest networkRequest = new NetworkRequest();
        networkRequest.apiName = this.API_NAME;
        networkRequest.apiVersion = this.API_VERSION;
        networkRequest.needLogin = this.IS_NEED_LOGIN;
        networkRequest.needWua = this.IS_WUA.booleanValue();
        networkRequest.needAuth = this.IS_AUTH;
        networkRequest.isPost = this.IS_POST;
        networkRequest.timeOut = this.TIME_OUT;
        networkRequest.requestType = networkRequest.hashCode();
        networkRequest.paramMap = map;
        return networkRequest;
    }

    public boolean sendRequest(Map<String, Object> map, NetworkRequestListener networkRequestListener) {
        return AlibcMtop.getInstance().sendRequest(networkRequestListener, a(map));
    }

    public NetworkResponse sendRequest(Map<String, Object> map) {
        return AlibcMtop.getInstance().sendRequest(a(map));
    }

    public NetworkResponse sendRequest(NetworkRequest networkRequest) {
        return AlibcMtop.getInstance().sendRequest(networkRequest);
    }

    public boolean sendRequest(NetworkRequest networkRequest, NetworkRequestListener networkRequestListener) {
        return AlibcMtop.getInstance().sendRequest(networkRequestListener, networkRequest);
    }
}
