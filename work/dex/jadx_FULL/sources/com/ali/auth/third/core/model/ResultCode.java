package com.ali.auth.third.core.model;

import com.ali.auth.third.core.message.Message;
import com.ali.auth.third.core.message.MessageUtils;
import com.alipay.sdk.m.k0.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ResultCode {
    public int code;
    public String message;
    public static final ResultCode SUCCESS = new ResultCode(100, c.p);
    public static final ResultCode IGNORE = new ResultCode(-100, "IGNORE");
    public static final ResultCode CAPTCHA_RELOGIN = new ResultCode(103, "CAPTCHA_RELOGIN");
    public static final ResultCode TRUST_LOGIN = new ResultCode(104, "TRUST_LOGIN");
    public static final ResultCode CONTINUE_LOGIN = new ResultCode(105, Constants.ACTION_CONTINUELOGIN);
    public static final ResultCode CHECK = new ResultCode(108, "CHECK");
    public static final ResultCode BUSY_CONTROL = new ResultCode(111, "busy control");
    public static final ResultCode USER_CANCEL = new ResultCode(10003, "USER_CANCEL");
    public static final ResultCode SYSTEM_EXCEPTION = new ResultCode(10010, "SYSTEM_EXCEPTION");

    public ResultCode(int i) {
        this(i, null);
    }

    public ResultCode(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public static ResultCode create(int i, Object... objArr) {
        return new ResultCode(i, MessageUtils.getMessageContent(i, objArr));
    }

    public static ResultCode create(Message message) {
        return new ResultCode(message.code, message.message);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && ResultCode.class == obj.getClass() && this.code == ((ResultCode) obj).code;
    }

    public int hashCode() {
        return this.code + 31;
    }

    public boolean isSuccess() {
        return this.code == 100;
    }
}
