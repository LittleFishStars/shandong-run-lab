package com.ltmb.beiziadapter.unified;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ltmb.ltsdk.core.load.data.DrawAdDataSource;
import com.ltmb.ltsdk.core.view.holder.custom.DrawAdCustomHolder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class CustomDrawAdHolder extends DrawAdCustomHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f40261a;

    public CustomDrawAdHolder(Context context, ViewGroup viewGroup, DrawAdDataSource drawAdDataSource) {
        super(context, drawAdDataSource);
        this.f40261a = viewGroup;
    }

    public void destroy() {
    }

    public View getCloseView() {
        return null;
    }

    public ViewGroup getRootView() {
        return this.f40261a;
    }

    public View getShakeView() {
        return null;
    }

    public void showAd() {
    }
}
