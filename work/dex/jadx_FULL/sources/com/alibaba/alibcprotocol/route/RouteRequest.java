package com.alibaba.alibcprotocol.route;

import com.alibaba.alibcprotocol.route.model.ActionDO;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RouteRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f23618a;
    private String b;
    private String c;
    private String d;
    private String e;
    private List<ActionDO> f;
    private boolean g = true;
    private Map<String, String> h;
    private Map<String, Object> i;

    public RouteRequest(String str, String str2) {
        this.f23618a = str;
        this.c = str2;
    }

    public List<ActionDO> getActionList() {
        return this.f;
    }

    public String getBizType() {
        return this.e;
    }

    public Map<String, String> getCodes() {
        return this.h;
    }

    public Map<String, Object> getExtParams() {
        return this.i;
    }

    public String getPageType() {
        return this.d;
    }

    public String getRawUrl() {
        return this.f23618a;
    }

    public String getRegexUrl() {
        return this.b;
    }

    public String getSuiteCode() {
        return this.c;
    }

    public boolean isLaunchApp() {
        return this.g;
    }

    public void setActionList(List<ActionDO> list) {
        this.f = list;
    }

    public void setBizType(String str) {
        this.e = str;
    }

    public void setCodes(Map<String, String> map) {
        this.h = map;
    }

    public void setExtParams(Map<String, Object> map) {
        this.i = map;
    }

    public void setLaunchApp(boolean z) {
        this.g = z;
    }

    public void setPageType(String str) {
        this.d = str;
    }

    public void setRawUrl(String str) {
        this.f23618a = str;
    }

    public void setRegexUrl(String str) {
        this.b = str;
    }

    public void setSuiteCode(String str) {
        this.c = str;
    }

    public String toString() {
        return "[rawUrl=" + this.f23618a + ", suiteCode=" + this.c + ", pageType=" + this.d + ", bizType=" + this.e + "]";
    }

    public RouteRequest(String str, Map<String, String> map) {
        this.f23618a = str;
        this.h = map;
    }
}
