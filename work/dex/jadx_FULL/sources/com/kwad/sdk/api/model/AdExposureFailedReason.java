package com.kwad.sdk.api.model;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Keep
public class AdExposureFailedReason {
    public String adRequestId;
    public String adTitle;
    public String adUserName;
    public String adnMaterialUrl;
    public String adnName;
    public int winEcpm = -9999;
    public int adnType = -9999;
    public int isShow = -9999;
    public int isClick = -9999;
    public int adnMaterialType = -9999;

    public AdExposureFailedReason setAdRequestId(String str) {
        this.adRequestId = str;
        return this;
    }

    public AdExposureFailedReason setAdTitle(String str) {
        this.adTitle = str;
        return this;
    }

    public AdExposureFailedReason setAdUserName(String str) {
        this.adUserName = str;
        return this;
    }

    public AdExposureFailedReason setAdnMaterialType(int i) {
        this.adnMaterialType = i;
        return this;
    }

    public AdExposureFailedReason setAdnMaterialUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.adnMaterialUrl = URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                this.adnMaterialUrl = "";
            }
        }
        return this;
    }

    public AdExposureFailedReason setAdnName(String str) {
        this.adnName = str;
        return this;
    }

    public AdExposureFailedReason setAdnType(int i) {
        this.adnType = i;
        return this;
    }

    public AdExposureFailedReason setIsClick(int i) {
        this.isClick = i;
        return this;
    }

    public AdExposureFailedReason setIsShow(int i) {
        this.isShow = i;
        return this;
    }

    public AdExposureFailedReason setWinEcpm(int i) {
        this.winEcpm = i;
        return this;
    }
}
