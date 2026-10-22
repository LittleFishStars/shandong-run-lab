package com.alibaba.triver.triver_render.view.refresh;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class LoadMoreFooter extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected TriverSwipeRefreshLayout.b f25242a;

    public enum LoadMoreState {
        NONE,
        PUSH_TO_LOAD,
        RELEASE_TO_LOAD,
        LOADING
    }

    public LoadMoreFooter(Context context) {
        super(context);
    }

    public abstract void a(LoadMoreState loadMoreState);

    public abstract LoadMoreState getCurrentState();

    public abstract TextView getLoadMoreTipView();

    public abstract void setLoadMoreTipColor(@ColorInt int i);

    public abstract void setLoadMoreTips(String[] strArr);

    public abstract void setProgress(float f);

    public void setPushLoadMoreListener(TriverSwipeRefreshLayout.b bVar) {
        this.f25242a = bVar;
    }
}
