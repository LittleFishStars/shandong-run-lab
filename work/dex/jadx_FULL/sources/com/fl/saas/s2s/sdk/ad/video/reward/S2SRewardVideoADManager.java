package com.fl.saas.s2s.sdk.ad.video.reward;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class S2SRewardVideoADManager {
    private AdInfoPoJo mAdInfoPoJo;
    private AdSource mAdSource;
    private boolean mIsCache;
    private OnS2SRewardVideoADListener mListener;

    public S2SRewardVideoADManager(boolean z, AdSource adSource) {
        this.mIsCache = z;
        this.mAdSource = adSource;
    }

    public void destroy() {
        this.mAdInfoPoJo = null;
        this.mListener = null;
    }

    public AdInfoPoJo getAdInfoPoJo() {
        return this.mAdInfoPoJo;
    }

    public AdSource getAdSource() {
        return this.mAdSource;
    }

    public S2SRewardVideoADManager init(List<AdInfoPoJo> list, OnS2SRewardVideoADListener onS2SRewardVideoADListener) {
        if (list != null && list.size() > 0) {
            AdInfoPoJo adInfoPoJo = list.get(0);
            if (onS2SRewardVideoADListener != null) {
                this.mListener = onS2SRewardVideoADListener;
                if (adInfoPoJo != null) {
                    this.mAdInfoPoJo = adInfoPoJo;
                    onS2SRewardVideoADListener.onLoad(this);
                } else {
                    onError("视频地址为空");
                }
            }
        }
        return this;
    }

    public boolean isCache() {
        return this.mIsCache;
    }

    public boolean isReady() {
        if (getAdInfoPoJo() == null) {
            return false;
        }
        if (!TextUtils.isEmpty(getAdInfoPoJo().video_url)) {
            return true;
        }
        if (getAdInfoPoJo().rd_countdown > 0) {
            return !TextUtils.isEmpty(getAdInfoPoJo().img_url);
        }
        return false;
    }

    public void onClick() {
        OnS2SRewardVideoADListener onS2SRewardVideoADListener = this.mListener;
        if (onS2SRewardVideoADListener != null) {
            onS2SRewardVideoADListener.onClick("");
        }
    }

    public void onClose() {
        OnS2SRewardVideoADListener onS2SRewardVideoADListener = this.mListener;
        if (onS2SRewardVideoADListener != null) {
            onS2SRewardVideoADListener.onClose();
        }
    }

    public void onComplete() {
        OnS2SRewardVideoADListener onS2SRewardVideoADListener = this.mListener;
        if (onS2SRewardVideoADListener != null) {
            AdInfoPoJo adInfoPoJo = this.mAdInfoPoJo;
            onS2SRewardVideoADListener.onComplete(adInfoPoJo != null ? adInfoPoJo.price : 0);
        }
    }

    public void onError(int i, String str) {
        OnS2SRewardVideoADListener onS2SRewardVideoADListener = this.mListener;
        if (onS2SRewardVideoADListener != null) {
            onS2SRewardVideoADListener.onError(YdError.create(i, str));
        }
    }

    public void onError(String str) {
        onError(0, str);
    }

    public void onReward() {
        OnS2SRewardVideoADListener onS2SRewardVideoADListener = this.mListener;
        if (onS2SRewardVideoADListener != null) {
            AdInfoPoJo adInfoPoJo = this.mAdInfoPoJo;
            onS2SRewardVideoADListener.onReward(adInfoPoJo != null ? adInfoPoJo.price : 0);
        }
    }

    public void onSkip() {
        OnS2SRewardVideoADListener onS2SRewardVideoADListener = this.mListener;
        if (onS2SRewardVideoADListener != null) {
            onS2SRewardVideoADListener.onSkip();
        }
    }

    public void showAd(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) S2SRewardVideoActivity.class);
            AdInfoPoJo adInfoPoJo = this.mAdInfoPoJo;
            if (adInfoPoJo != null) {
                intent.putExtra("draw_type", adInfoPoJo.draw_type);
            }
            S2SRewardVideoActivity.setAdInfo(this);
            activity.startActivity(intent);
        }
    }
}
