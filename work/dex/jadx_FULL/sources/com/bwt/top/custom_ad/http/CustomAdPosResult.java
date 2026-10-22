package com.bwt.top.custom_ad.http;

import com.easyjson.annotation.JSONField;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CustomAdPosResult implements Serializable {

    @JSONField(name = "acceleration")
    private int acceleration;
    private List<String> clickReport;
    private int ctype;
    private String deeplink;

    @JSONField(name = "description")
    private String desc;
    private List<String> displayReport;
    private List<String> dpf;
    private List<String> dps;
    private List<String> dpt;

    @JSONField(name = RemoteMessageConst.Notification.ICON)
    private String iconUrl;

    @JSONField(name = "img")
    private String imgUrl;
    private boolean isDownload;

    @JSONField(name = "ldp")
    private String jumpPage;
    private boolean keen;
    private String storePkg;

    @JSONField(name = "title")
    private String title;

    public int getAcceleration() {
        return this.acceleration;
    }

    public List<String> getClickReport() {
        return this.clickReport;
    }

    public int getCtype() {
        return this.ctype;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getDesc() {
        return this.desc;
    }

    public List<String> getDisplayReport() {
        return this.displayReport;
    }

    public List<String> getDpf() {
        return this.dpf;
    }

    public List<String> getDps() {
        return this.dps;
    }

    public List<String> getDpt() {
        return this.dpt;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getJumpPage() {
        return this.jumpPage;
    }

    public String getStorePkg() {
        return this.storePkg;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isDownload() {
        return this.isDownload;
    }

    public boolean isKeen() {
        return this.keen;
    }

    public void setAcceleration(int i) {
        this.acceleration = i;
    }

    public void setClickReport(List<String> list) {
        this.clickReport = list;
    }

    public void setCtype(int i) {
        this.ctype = i;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDisplayReport(List<String> list) {
        this.displayReport = list;
    }

    public void setDownload(boolean z) {
        this.isDownload = z;
    }

    public void setDpf(List<String> list) {
        this.dpf = list;
    }

    public void setDps(List<String> list) {
        this.dps = list;
    }

    public void setDpt(List<String> list) {
        this.dpt = list;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setJumpPage(String str) {
        this.jumpPage = str;
    }

    public void setKeen(boolean z) {
        this.keen = z;
    }

    public void setStorePkg(String str) {
        this.storePkg = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "ChannelAdPosResult{, ctype=" + this.ctype + "jumpPage='" + this.jumpPage + "', imgUrl='" + this.imgUrl + "', title='" + this.title + "', desc='" + this.desc + "', iconUrl='" + this.iconUrl + "', displayReport=" + this.displayReport + ", clickReport=" + this.clickReport + '}';
    }
}
