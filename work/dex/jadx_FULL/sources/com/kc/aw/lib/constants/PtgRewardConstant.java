package com.kc.aw.lib.constants;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgRewardConstant {

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface REWARD_PARAMS {
        public static final String EXTRA = "extra";
        public static final String REWARD_AMOUNT = "reward_amount";
        public static final String REWARD_NAME = "reward_name";
        public static final String SERVER_CODE = "server_code";
        public static final String SERVER_MSG = "server_msg";
        public static final String USER_ID = "user_id";
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface REWARD_VERIFY {
        public static final int NEED_VERIFY = 1;
        public static final int NO_VERIFY = 0;
    }

    @Keep
    public enum ServerErr {
        DEF(-1, "有效奖励"),
        SUC(200, "有效奖励"),
        SUC_ERR(200, "无效奖励"),
        ERR_DATA(400, "数据类型异常"),
        ERR_PAR(401, "数据解析异常"),
        ERR_PARAMS(403, "参数异常"),
        ERR_BODY(404, "服务端地址或广告参数为空"),
        ERR_NET(405, "网络异常"),
        ERR_TIMEOUT(406, "网络超时"),
        ERR_SERVER(407, "服务端异常");

        private final int code;
        private final String msg;

        ServerErr(int i, String str) {
            this.code = i;
            this.msg = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
