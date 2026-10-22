package com.ali.auth.third.core.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RpcRequestCallbackWithCode {
    void onError(String str, RpcResponse rpcResponse);

    void onSuccess(RpcResponse rpcResponse);

    void onSystemError(String str, RpcResponse rpcResponse);
}
