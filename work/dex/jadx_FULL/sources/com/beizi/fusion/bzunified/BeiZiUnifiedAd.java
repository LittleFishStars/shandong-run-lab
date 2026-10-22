package com.beizi.fusion.bzunified;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.q4;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZiUnifiedAd {
    private q4 mBeiZiUnifiedManager;
    private String mSpaceId;
    private int mTimeout;

    public BeiZiUnifiedAd(Context context, BeiZiUnifiedAdRequestParameters beiZiUnifiedAdRequestParameters, BeiZiUnifiedAdListener beiZiUnifiedAdListener) {
        this.mSpaceId = null;
        this.mTimeout = 5000;
        if (beiZiUnifiedAdRequestParameters != null) {
            this.mSpaceId = beiZiUnifiedAdRequestParameters.getSpaceId();
            this.mTimeout = beiZiUnifiedAdRequestParameters.getTimeout();
        }
        this.mBeiZiUnifiedManager = new q4(context, this.mSpaceId, this.mTimeout, beiZiUnifiedAdListener);
    }

    public void destroy() {
        q4 q4Var = this.mBeiZiUnifiedManager;
        if (q4Var == null) {
            return;
        }
        q4Var.Y();
    }

    public String getCustomExtraData() {
        q4 q4Var = this.mBeiZiUnifiedManager;
        if (q4Var == null) {
            return null;
        }
        return q4Var.r();
    }

    public String getCustomExtraJsonData() {
        q4 q4Var = this.mBeiZiUnifiedManager;
        if (q4Var == null) {
            return null;
        }
        return q4Var.s();
    }

    public boolean isLoaded() {
        q4 q4Var = this.mBeiZiUnifiedManager;
        if (q4Var != null) {
            return q4Var.Z();
        }
        return false;
    }

    public boolean isValid() {
        q4 q4Var = this.mBeiZiUnifiedManager;
        if (q4Var == null) {
            return false;
        }
        return q4Var.J();
    }

    public void loadAd() {
        q4 q4Var = this.mBeiZiUnifiedManager;
        if (q4Var != null) {
            q4Var.a0();
        }
    }

    public void sendLossNotificationWithInfo(Map map) {
        q4 q4Var = this.mBeiZiUnifiedManager;
        if (q4Var == null || map == null) {
            return;
        }
        q4Var.a(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        q4 q4Var = this.mBeiZiUnifiedManager;
        if (q4Var == null || map == null) {
            return;
        }
        q4Var.b(map);
    }

    public void setBidResponse(String str) {
        if (this.mBeiZiUnifiedManager == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mBeiZiUnifiedManager.m(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        q4 q4Var = this.mBeiZiUnifiedManager;
        if (q4Var == null) {
            return;
        }
        q4Var.c(map);
    }
}
