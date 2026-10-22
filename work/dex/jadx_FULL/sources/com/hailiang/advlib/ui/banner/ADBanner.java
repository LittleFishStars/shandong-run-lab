package com.hailiang.advlib.ui.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import com.hailiang.advlib.common.e;
import com.hailiang.advlib.core.ICliBundle;
import com.hailiang.advlib.core.ICliUtils;
import com.hailiang.advlib.core.IMultiAdObject;
import com.hailiang.advlib.core.c;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class ADBanner extends LinearLayout implements Banner {
    public Banner _remote_banner;

    public ADBanner(Context context) {
        super(context);
        this._remote_banner = null;
        InitInstance(this);
        OnBannerInit();
    }

    public ADBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this._remote_banner = null;
        InitInstance(this);
        OnBannerInit();
    }

    public ADBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this._remote_banner = null;
        InitInstance(this);
        OnBannerInit();
    }

    private boolean checkInstancePresent() {
        if (this._remote_banner == null) {
            InitInstance(this);
        }
        if (this._remote_banner != null) {
            return true;
        }
        Log.e("ADBanner", "Instance not present!");
        e.a(getContext(), -1);
        return false;
    }

    public void InitInstance(LinearLayout linearLayout) {
        if (this._remote_banner == null) {
            this._remote_banner = c.a(linearLayout);
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void OnBannerInit() {
        if (checkInstancePresent()) {
            this._remote_banner.OnBannerInit();
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void UpdateView(ICliBundle iCliBundle) {
        if (checkInstancePresent()) {
            this._remote_banner.UpdateView(iCliBundle);
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void setADStateListener(IMultiAdObject.ADStateListener aDStateListener) {
        if (checkInstancePresent()) {
            try {
                this._remote_banner.setADStateListener(aDStateListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void setPageUniqueId(int i) {
        if (checkInstancePresent()) {
            try {
                this._remote_banner.setPageUniqueId(i);
            } catch (AbstractMethodError e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void setStateListener(ICliUtils.BannerStateListener bannerStateListener) {
        if (checkInstancePresent()) {
            this._remote_banner.setStateListener(bannerStateListener);
        }
    }

    @Override // com.hailiang.advlib.ui.banner.Banner
    public void updateViewWithAds(Object obj) {
        if (checkInstancePresent()) {
            this._remote_banner.updateViewWithAds(obj);
        }
    }
}
