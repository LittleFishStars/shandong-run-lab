package com.alibaba.baichuan.trade.common.ut;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UserTrackParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24567a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private int s;
    private String t;
    private Map<String, String> u;

    public Map<String, String> getProps() {
        return this.u;
    }

    private UserTrackParams(UTBuilder uTBuilder) {
        this.d = uTBuilder.d;
        this.e = uTBuilder.e;
        this.f24567a = uTBuilder.f24568a;
        this.f = uTBuilder.f;
        this.i = uTBuilder.g;
        this.b = uTBuilder.b;
        this.c = uTBuilder.c;
        this.j = uTBuilder.h;
        this.k = uTBuilder.i;
        this.l = uTBuilder.j;
        this.m = uTBuilder.k;
        this.n = uTBuilder.l;
        this.o = uTBuilder.m;
        this.p = uTBuilder.n;
        this.u = uTBuilder.u;
        this.q = uTBuilder.o;
        this.r = uTBuilder.p;
        this.s = uTBuilder.q;
        this.t = uTBuilder.r;
        this.g = uTBuilder.s;
        this.h = uTBuilder.t;
    }

    public static class UTBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24568a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String n;
        private String o;
        private String p;
        private int q;
        private String r;
        private String s;
        private String t;
        private Map<String, String> u;

        public UTBuilder(String str, String str2, String str3) {
            this.d = str;
            this.e = str2;
            this.f = str3;
            HashMap map = new HashMap(16);
            this.u = map;
            map.put("appkey", str);
            this.u.put("ttid", str2);
            this.u.put(UserTrackConstant.SDK_TYPE, str3);
        }

        public UserTrackParams build() {
            return new UserTrackParams(this);
        }

        public UTBuilder setAppkey(String str) {
            this.d = str;
            this.u.put("appkey", str);
            return this;
        }

        public UTBuilder setContainerType(String str) {
            this.s = str;
            if (!TextUtils.isEmpty(str)) {
                this.u.put(UserTrackConstant.CONTAINER_TYPE, str);
            }
            return this;
        }

        public UTBuilder setCostTime(String str) {
            this.k = str;
            if (!TextUtils.isEmpty(str)) {
                this.u.put("costTime", str);
            }
            return this;
        }

        public UTBuilder setErrCode(String str) {
            this.b = str;
            this.u.put("errorCode", str);
            return this;
        }

        public UTBuilder setErrMsg(String str) {
            this.c = str;
            this.u.put("errorMsg", str);
            return this;
        }

        public UTBuilder setErrorType(String str) {
            this.p = str;
            if (!TextUtils.isEmpty(str)) {
                this.u.put(UserTrackConstant.ERROR_TYPE, str);
            }
            return this;
        }

        public UTBuilder setJumpType(int i) {
            this.q = i;
            this.u.put(UserTrackConstant.JUMP_TYPE, String.valueOf(i));
            return this;
        }

        public UTBuilder setOpenType(String str) {
            this.t = str;
            if (!TextUtils.isEmpty(str)) {
                this.u.put("openType", str);
            }
            return this;
        }

        public UTBuilder setOriginalUrl(String str) {
            this.i = str;
            this.u.put(UserTrackConstant.ORIGINAL_URL, str);
            return this;
        }

        public UTBuilder setResultUrl(String str) {
            this.j = str;
            this.u.put(UserTrackConstant.RESULT_URL, str);
            return this;
        }

        public UTBuilder setSdkType(String str) {
            this.f = str;
            this.u.put(UserTrackConstant.SDK_TYPE, "ultimate");
            return this;
        }

        public UTBuilder setSdkVersion(String str) {
            this.g = str;
            this.u.put("sdkVersion", str);
            return this;
        }

        public UTBuilder setSessionValid(String str) {
            this.n = str;
            if (!TextUtils.isEmpty(str)) {
                this.u.put(UserTrackConstant.SESSION_VALID, str);
            }
            return this;
        }

        public UTBuilder setSign(String str) {
            this.r = str;
            if (!TextUtils.isEmpty(str)) {
                this.u.put(UserTrackConstant.SIGN, str);
            }
            return this;
        }

        public UTBuilder setStatus(String str) {
            this.h = str;
            this.u.put("status", str);
            return this;
        }

        public UTBuilder setSuccess(String str) {
            this.f24568a = str;
            this.u.put(UserTrackConstant.IS_SUCCESS, str);
            return this;
        }

        public UTBuilder setSuiteCode(String str) {
            this.o = str;
            if (!TextUtils.isEmpty(str)) {
                this.u.put(UserTrackConstant.SUITE_CODE, str);
            }
            return this;
        }

        public UTBuilder setTbInstalled(String str) {
            this.m = str;
            if (!TextUtils.isEmpty(str)) {
                this.u.put(UserTrackConstant.TB_INSTALLED, str);
            }
            return this;
        }

        public UTBuilder setTtid(String str) {
            this.e = str;
            this.u.put("ttid", AlibcBaseTradeCommon.ttid);
            return this;
        }

        public UTBuilder setUrlType(String str) {
            this.l = str;
            if (!TextUtils.isEmpty(str)) {
                this.u.put(UserTrackConstant.URL_TYPE, str);
            }
            return this;
        }

        public UTBuilder() {
            this.e = AlibcBaseTradeCommon.ttid;
            this.d = AlibcBaseTradeCommon.getAppKey();
            this.f = "ultimate";
            this.g = "5.0.2.5";
            HashMap map = new HashMap(16);
            this.u = map;
            map.put("appkey", this.d);
            this.u.put("ttid", this.e);
            this.u.put(UserTrackConstant.SDK_TYPE, this.f);
            this.u.put("sdkVersion", this.g);
        }
    }
}
