package com.alibaba.triver.triver_render.view.refresh;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends RefreshHeader {
    private ProgressView c;

    public d(Context context) {
        super(context);
        a(RefreshHeader.RefreshState.NONE);
        setBackgroundColor(0);
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void a(RefreshHeader.RefreshHeaderStyle refreshHeaderStyle) {
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void a(RefreshHeader.RefreshState refreshState) {
        this.b = refreshState;
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void a(String[] strArr, @Nullable String str) {
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public View getRefreshView() {
        return this;
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public View getSecondFloorView() {
        return null;
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void setProgress(float f) {
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void setRefreshTipColor(int i) {
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void setRefreshTips(String[] strArr) {
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void setSecondFloorView(View view) {
    }
}
