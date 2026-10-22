package com.beizi.fusion.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class S2SBiddingConfig {

    @JsonNode(key = "appKey")
    private String appKey;

    @JsonNode(key = "secret")
    private String secret;

    @JsonNode(key = "url")
    private String url;

    public String getAppKey() {
        return this.appKey;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
