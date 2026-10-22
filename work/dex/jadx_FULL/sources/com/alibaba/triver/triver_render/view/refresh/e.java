package com.alibaba.triver.triver_render.view.refresh;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.triver_render.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends RefreshHeader {
    private ITriverPullRefreshService c;
    private ProgressView d;

    public e(Context context) {
        super(context);
        this.c = null;
        a(RefreshHeader.RefreshState.NONE);
        ITriverPullRefreshService iTriverPullRefreshService = this.c;
        if (iTriverPullRefreshService != null) {
            addView(iTriverPullRefreshService.a(context));
            return;
        }
        ProgressView progressView = new ProgressView(context);
        this.d = progressView;
        progressView.setAutoPlay(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = CommonUtils.dip2px(context, 20.0f);
        addView(this.d, layoutParams);
        this.d.b();
        setBackgroundColor(0);
    }

    private ITriverPullRefreshService.ITriverRefreshState b(RefreshHeader.RefreshState refreshState) {
        if (refreshState == RefreshHeader.RefreshState.NONE) {
            return ITriverPullRefreshService.ITriverRefreshState.NONE;
        }
        if (refreshState == RefreshHeader.RefreshState.PULL_TO_REFRESH) {
            return ITriverPullRefreshService.ITriverRefreshState.PULL_TO_REFRESH;
        }
        if (refreshState == RefreshHeader.RefreshState.REFRESHING) {
            return ITriverPullRefreshService.ITriverRefreshState.REFRESHING;
        }
        return refreshState == RefreshHeader.RefreshState.RELEASE_TO_REFRESH ? ITriverPullRefreshService.ITriverRefreshState.RELEASE_TO_REFRESH : ITriverPullRefreshService.ITriverRefreshState.NONE;
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void a(RefreshHeader.RefreshState refreshState) {
        this.b = refreshState;
        if (this.c != null) {
            this.c.a(b(refreshState));
            return;
        }
        ProgressView progressView = this.d;
        if (progressView == null) {
            return;
        }
        if (refreshState == RefreshHeader.RefreshState.REFRESHING) {
            progressView.c();
        } else {
            progressView.b();
        }
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void a(String[] strArr, @Nullable String str) {
    }

    public ProgressView getProgressView() {
        return this.d;
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
        ITriverPullRefreshService iTriverPullRefreshService = this.c;
        if (iTriverPullRefreshService != null) {
            iTriverPullRefreshService.a(f);
        }
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

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void a(RefreshHeader.RefreshHeaderStyle refreshHeaderStyle) {
        if (this.c != null) {
            this.c.a(b(refreshHeaderStyle));
            return;
        }
        ProgressView progressView = this.d;
        if (progressView != null) {
            if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.NORMAL) {
                progressView.setDotsBackground(R.drawable.triver_progress_view_bg_white);
            } else if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.DARK) {
                progressView.setDotsBackground(R.drawable.triver_progress_view_bg);
            }
        }
    }

    private ITriverPullRefreshService.ITRiverRefreshStyle b(RefreshHeader.RefreshHeaderStyle refreshHeaderStyle) {
        if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.DARK) {
            return ITriverPullRefreshService.ITRiverRefreshStyle.DARK;
        }
        if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.NORMAL) {
            return ITriverPullRefreshService.ITRiverRefreshStyle.LIGHT;
        }
        return null;
    }
}
