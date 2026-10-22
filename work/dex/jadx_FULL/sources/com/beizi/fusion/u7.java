package com.beizi.fusion;

import com.beizi.fusion.asnp.common.analyse.model.IStringEventEnum;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum u7 implements IStringEventEnum {
    EVENT_REPORT_INIT_CODE("100.000"),
    EVENT_REPORT_INIT_SUCCESS_CODE("100.200"),
    EVENT_REPORT_INIT_FAIL_CODE("100.500"),
    EVENT_REPORT_LOAD_CODE("200.000"),
    EVENT_REPORT_REQUEST_CODE("250.000"),
    EVENT_REPORT_REQUEST_SUCCESS_CODE("250.200"),
    EVENT_REPORT_REQUEST_FAIL_CODE("250.500"),
    EVENT_REPORT_RENDER_CODE("260.000"),
    EVENT_REPORT_RENDER_SUCCESS_CODE("260.200"),
    EVENT_REPORT_RENDER_FAIL_CODE("260.500"),
    EVENT_REPORT_SHOW_CODE("270.000"),
    EVENT_REPORT_CALL_EXPOSURE_CODE("270.200"),
    EVENT_REPORT_EXPOSURE_CODE("270.201"),
    EVENT_REPORT_CALL_CLICK_CODE("280.200"),
    EVENT_REPORT_CLICK_CODE("280.201"),
    EVENT_REPORT_COMPLAIN_CODE("280.300"),
    EVENT_REPORT_CLOSE_CODE("290.000"),
    EVENT_REPORT_APP_INSTALLS_CODE("800.000"),
    EVENT_REPORT_CRASH_CODE("900.000");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27825a;

    u7(String str) {
        this.f27825a = str;
    }

    @Override // com.beizi.fusion.asnp.common.analyse.model.IStringEventEnum
    public String getEventCode() {
        return this.f27825a;
    }
}
