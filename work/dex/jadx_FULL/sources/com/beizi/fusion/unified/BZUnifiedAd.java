package com.beizi.fusion.unified;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.e3;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BZUnifiedAd {
    private int mAdType;
    private e3 mBZUnifiedManager;
    private String mSpaceId;
    private int mTimeout;

    public BZUnifiedAd(Context context, BZBZUnifiedAdRequestParameters bZBZUnifiedAdRequestParameters, BZUnifiedAdListener bZUnifiedAdListener) {
        this.mSpaceId = null;
        this.mTimeout = 5000;
        this.mAdType = 0;
        if (bZBZUnifiedAdRequestParameters != null) {
            this.mSpaceId = bZBZUnifiedAdRequestParameters.getSpaceId();
            this.mTimeout = bZBZUnifiedAdRequestParameters.getTimeout();
            this.mAdType = bZBZUnifiedAdRequestParameters.getAdType();
        }
        this.mBZUnifiedManager = new e3(context, this.mSpaceId, this.mTimeout, this.mAdType, bZUnifiedAdListener);
    }

    public void adsInteractiveActions(BZUnifiedAdActionData bZUnifiedAdActionData) {
        e3 e3Var = this.mBZUnifiedManager;
        if (e3Var == null) {
            return;
        }
        e3Var.a(bZUnifiedAdActionData);
    }

    public void destroy() {
        e3 e3Var = this.mBZUnifiedManager;
        if (e3Var == null) {
            return;
        }
        e3Var.Y();
    }

    public String getCustomExtraJsonData() {
        e3 e3Var = this.mBZUnifiedManager;
        if (e3Var == null) {
            return null;
        }
        return e3Var.s();
    }

    public boolean isValid() {
        e3 e3Var = this.mBZUnifiedManager;
        if (e3Var == null) {
            return false;
        }
        return e3Var.J();
    }

    public void loadAd() {
        e3 e3Var = this.mBZUnifiedManager;
        if (e3Var != null) {
            e3Var.Z();
        }
    }

    public void notifyVideoPlayProgress(int i) {
        e3 e3Var = this.mBZUnifiedManager;
        if (e3Var == null) {
            return;
        }
        e3Var.c(i);
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list) {
        e3 e3Var = this.mBZUnifiedManager;
        if (e3Var == null) {
            return;
        }
        e3Var.a(viewGroup, list);
    }

    public void sendLossNotificationWithInfo(Map map) {
        e3 e3Var = this.mBZUnifiedManager;
        if (e3Var == null || map == null) {
            return;
        }
        e3Var.a(map);
    }

    public void sendWinNotificationWithInfo(Map map) {
        e3 e3Var = this.mBZUnifiedManager;
        if (e3Var == null || map == null) {
            return;
        }
        e3Var.b(map);
    }

    public void setBidResponse(String str) {
        if (this.mBZUnifiedManager == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mBZUnifiedManager.m(str);
    }

    public void setSpaceParam(Map<String, Object> map) {
        e3 e3Var = this.mBZUnifiedManager;
        if (e3Var == null) {
            return;
        }
        e3Var.c(map);
    }
}
