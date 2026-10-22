package com.alibaba.alibcprotocol.route.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ConfigDO implements Serializable {
    private static final long serialVersionUID = -8274481029778394940L;
    private List<String> addParamUrls;
    private List<BizPatternDO> bizPattern;
    private List<CodeConfigDO> codeConfig;
    private List<String> components;
    private String config_ver;
    private String em;
    private String[] forbidByCode;
    private MiscDO misc;
    private List<RouteConfigDO> routeConfig;
    private String sign;
    private int st = 1;
    private List<UrlTypeDO> urlTypeConfig;
    private String version;

    public List<String> getAddParamUrls() {
        return this.addParamUrls;
    }

    public List<BizPatternDO> getBizPattern() {
        return this.bizPattern;
    }

    public List<CodeConfigDO> getCodeConfig() {
        return this.codeConfig;
    }

    public List<String> getComponents() {
        return this.components;
    }

    public String getConfig_ver() {
        return this.config_ver;
    }

    public String getEm() {
        return this.em;
    }

    public String[] getForbidByCode() {
        return this.forbidByCode;
    }

    public MiscDO getMisc() {
        return this.misc;
    }

    public List<RouteConfigDO> getRouteConfig() {
        return this.routeConfig;
    }

    public String getSign() {
        return this.sign;
    }

    public int getSt() {
        return this.st;
    }

    public List<UrlTypeDO> getUrlTypeConfig() {
        return this.urlTypeConfig;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAddParamUrls(List<String> list) {
        this.addParamUrls = list;
    }

    public void setBizPattern(List<BizPatternDO> list) {
        this.bizPattern = list;
    }

    public void setCodeConfig(List<CodeConfigDO> list) {
        this.codeConfig = list;
    }

    public void setComponents(List<String> list) {
        this.components = list;
    }

    public void setConfig_ver(String str) {
        this.config_ver = str;
    }

    public void setEm(String str) {
        this.em = str;
    }

    public void setForbidByCode(String[] strArr) {
        this.forbidByCode = strArr;
    }

    public void setMisc(MiscDO miscDO) {
        this.misc = miscDO;
    }

    public void setRouteConfig(List<RouteConfigDO> list) {
        this.routeConfig = list;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSt(int i) {
        this.st = i;
    }

    public void setUrlTypeConfig(List<UrlTypeDO> list) {
        this.urlTypeConfig = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
