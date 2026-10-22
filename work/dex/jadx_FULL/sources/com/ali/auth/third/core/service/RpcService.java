package com.ali.auth.third.core.service;

import com.ali.auth.third.core.model.RpcRequest;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RpcService {
    String getDeviceId();

    <T> RpcResponse<T> invoke(RpcRequest rpcRequest, Class<T> cls);

    String invoke(RpcRequest rpcRequest);

    void logout();

    void registerSessionInfo(String str, String str2);

    <T> void remoteBusiness(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallbackWithCode rpcRequestCallbackWithCode);
}
