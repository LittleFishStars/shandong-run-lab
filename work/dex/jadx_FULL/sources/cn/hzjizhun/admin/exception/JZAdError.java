package cn.hzjizhun.admin.exception;

import cn.hzjizhun.admin.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JZAdError extends Exception {
    public static final int CODE_BAIDU_ERROR = 601;
    public static final int CODE_CHANNEL_ERROR = 301;
    public static final int CODE_CONFIG_NO_AD_POS_ERROR = 11;
    public static final int CODE_GDT_ERROR = 201;
    public static final int CODE_INIT_CONFIG_ERROR = 101;
    public static final int CODE_INIT_CONFIG_NET_ERROR = 102;
    public static final int CODE_INIT_ERROR = 100;
    public static final int CODE_JZ_ERROR = 501;
    public static final int CODE_LOAD_IMAGE_ERROR = 302;
    public static final int CODE_THIRD_NO_AD_ERROR = 10;
    public static final int CODE_ZHIKE_ERROR = 401;
    private int errorCode;
    private String errorMsg;

    public JZAdError(int i, String str) {
        this.errorCode = i;
        this.errorMsg = str;
    }

    public int errorCode() {
        return this.errorCode;
    }

    public String errorMsg() {
        return this.errorMsg;
    }

    public void log() {
        ALog.i("AdError", "errorCode:" + this.errorCode + ", errorMsg:" + this.errorMsg);
    }

    public JZAdError(int i) {
        this(i, "");
    }

    private JZAdError() {
    }
}
