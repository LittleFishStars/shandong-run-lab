package com.beizi.fusion;

import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.zj.adlib.i55;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum n1 {
    ERROR_NO_FILL(2001, "no bid model fill"),
    ERROR_RESPONSE_PARSE_FAILED(2002, "ad response parse failed"),
    ERROR_SDK_NOT_INIT(2003, "sdk not init"),
    ERROR_REQUEST_TOO_OFTEN(2004, "request too often"),
    ERROR_AD_BEING_COMPLAINED(2005, "ad type being complained"),
    ERROR_REQUEST_TIME_OUT(2006, "request timeout"),
    ERROR_REQUEST_FAILED(2007, "request error"),
    ERROR_INVALID_CONFIG(2008, "invalid config"),
    ERROR_AD_REQUESTING(2009, "ad is requesting"),
    ERROR_UNITE_CONTROL(2010, "unite control"),
    ERROR_RENDER_FAILED(2011, "render failed"),
    ERROR_ACTIVITY_ISSUE(2012, "local activity error"),
    ERROR_INVALID_SPACE_ID(GLMapStaticValue.AM_PARAMETERNAME_MAPMODESTATE, "invalid space id"),
    ERROR_AD_NOT_READY_TO_SHOW(2014, "ad not ready to show"),
    ERROR_S2S_VERIFICATION_FAILED(2015, "s2s verification failed"),
    ERROR_S2S_EXPRESS_TYPE_ERROR(2016, "s2s express type error"),
    ERROR_UNEXPECTED(i55.b, "error unexpected");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27547a;
    private final String b;

    n1(int i, String str) {
        this.f27547a = i;
        this.b = str;
    }

    public int b() {
        return this.f27547a;
    }

    public String c() {
        return this.b;
    }
}
