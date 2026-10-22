package com.kc.dw.core.utils;

import com.kc.dw.core.domain.SsdAdInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DownloadDialogBean implements Serializable {
    private String app_feature;
    private String app_intor_url;
    private String app_intro;
    private String app_name;
    private List<SsdAdInfo.PermissionBean> app_permission;
    private String app_permission_url;
    private String app_privacy;
    private String app_private_agreement;
    private String app_size;
    private String app_ver;
    private String developer;
    private String payment_types;
    private float score;

    public String getApp_feature() {
        return this.app_feature;
    }

    public String getApp_intor_url() {
        return this.app_intor_url;
    }

    public String getApp_intro() {
        return this.app_intro;
    }

    public String getApp_name() {
        return this.app_name;
    }

    public List<SsdAdInfo.PermissionBean> getApp_permission() {
        return this.app_permission;
    }

    public String getApp_permission_url() {
        return this.app_permission_url;
    }

    public String getApp_privacy() {
        return this.app_privacy;
    }

    public String getApp_private_agreement() {
        return this.app_private_agreement;
    }

    public String getApp_size() {
        return this.app_size;
    }

    public String getApp_ver() {
        return this.app_ver;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public String getPayment_types() {
        return this.payment_types;
    }

    public float getScore() {
        return this.score;
    }

    public void setApp_feature(String str) {
        this.app_feature = str;
    }

    public void setApp_intor_url(String str) {
        this.app_intor_url = str;
    }

    public void setApp_intro(String str) {
        this.app_intro = str;
    }

    public void setApp_name(String str) {
        this.app_name = str;
    }

    public void setApp_permission(List<SsdAdInfo.PermissionBean> list) {
        this.app_permission = list;
    }

    public void setApp_permission_url(String str) {
        this.app_permission_url = str;
    }

    public void setApp_privacy(String str) {
        this.app_privacy = str;
    }

    public void setApp_private_agreement(String str) {
        this.app_private_agreement = str;
    }

    public void setApp_size(String str) {
        this.app_size = str;
    }

    public void setApp_ver(String str) {
        this.app_ver = str;
    }

    public void setDeveloper(String str) {
        this.developer = str;
    }

    public void setPayment_types(String str) {
        this.payment_types = str;
    }

    public void setScore(float f) {
        this.score = f;
    }
}
