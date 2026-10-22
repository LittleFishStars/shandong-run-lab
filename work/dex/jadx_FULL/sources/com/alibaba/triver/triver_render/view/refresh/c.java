package com.alibaba.triver.triver_render.view.refresh;

import android.content.Context;
import android.widget.TextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends LoadMoreFooter {
    private LoadMoreFooter.LoadMoreState b;

    public c(Context context) {
        super(context);
        LoadMoreFooter.LoadMoreState loadMoreState = LoadMoreFooter.LoadMoreState.NONE;
        this.b = loadMoreState;
        a(loadMoreState);
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.LoadMoreFooter
    public void a(LoadMoreFooter.LoadMoreState loadMoreState) {
        this.b = loadMoreState;
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.LoadMoreFooter
    public LoadMoreFooter.LoadMoreState getCurrentState() {
        return this.b;
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.LoadMoreFooter
    public TextView getLoadMoreTipView() {
        return new TextView(getContext());
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.LoadMoreFooter
    public void setLoadMoreTipColor(int i) {
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.LoadMoreFooter
    public void setLoadMoreTips(String[] strArr) {
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.LoadMoreFooter
    public void setProgress(float f) {
    }
}
