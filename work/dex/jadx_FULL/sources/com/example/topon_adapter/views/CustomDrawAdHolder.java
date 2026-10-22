package com.example.topon_adapter.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.ltmb.ltsdk.core.load.data.DrawAdDataSource;
import com.ltmb.ltsdk.core.view.holder.custom.DrawAdCustomHolder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CustomDrawAdHolder extends DrawAdCustomHolder {
    private final ATNativePrepareInfo atNativePrepareInfo;
    private final ViewGroup drawAdKeView;

    public CustomDrawAdHolder(Context context, ViewGroup viewGroup, DrawAdDataSource drawAdDataSource, ATNativePrepareInfo aTNativePrepareInfo) {
        super(context, drawAdDataSource);
        this.drawAdKeView = viewGroup;
        this.atNativePrepareInfo = aTNativePrepareInfo;
    }

    public void destroy() {
    }

    public View getCloseView() {
        ATNativePrepareInfo aTNativePrepareInfo = this.atNativePrepareInfo;
        if (aTNativePrepareInfo != null) {
            return aTNativePrepareInfo.getCloseView();
        }
        return null;
    }

    public ViewGroup getRootView() {
        return this.drawAdKeView;
    }

    public View getShakeView() {
        return null;
    }

    public void showAd() {
    }
}
