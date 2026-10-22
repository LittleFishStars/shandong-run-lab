package com.alibaba.triver.triver_render.view.refresh;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface ITriverPullRefreshService {

    public enum ITRiverRefreshStyle {
        LIGHT,
        DARK
    }

    public enum ITriverRefreshState {
        NONE,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING
    }

    int a();

    View a(Context context);

    void a(float f);

    void a(ITRiverRefreshStyle iTRiverRefreshStyle);

    void a(ITriverRefreshState iTriverRefreshState);
}
