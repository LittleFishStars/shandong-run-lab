package com.baichuan.nb_trade.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class InitResult {
    public int errCode;
    public String errMsg;
    public boolean success;

    public static InitResult newFailureResult(int i, String str) {
        InitResult initResult = new InitResult();
        initResult.errCode = i;
        initResult.errMsg = str;
        return initResult;
    }

    public static InitResult newSuccessResult() {
        InitResult initResult = new InitResult();
        initResult.success = true;
        return initResult;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
