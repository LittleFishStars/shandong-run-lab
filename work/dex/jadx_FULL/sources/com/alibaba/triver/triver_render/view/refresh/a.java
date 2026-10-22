package com.alibaba.triver.triver_render.view.refresh;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.triver.triver_render.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends RefreshHeader {
    private RoundProgressBar c;
    private TextView d;
    private ImageView e;

    public a(Context context) {
        super(context);
        a(RefreshHeader.RefreshState.NONE);
        View view = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.triver_open_refresh_header, (ViewGroup) this, false);
        this.c = (RoundProgressBar) view.findViewById(R.id.triver_progress);
        this.d = (TextView) view.findViewById(R.id.triver_tip);
        this.e = (ImageView) view.findViewById(R.id.triver_icon);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        addView(view, layoutParams);
        setBackgroundColor(0);
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void a(RefreshHeader.RefreshState refreshState) {
        this.b = refreshState;
        if (this.c == null) {
            return;
        }
        if (refreshState == RefreshHeader.RefreshState.PULL_TO_REFRESH) {
            this.d.setText(R.string.triver_open_pullrefresh_tip);
            this.e.setVisibility(0);
        } else if (refreshState == RefreshHeader.RefreshState.REFRESHING) {
            this.d.setText(R.string.triver_open_refresh_tip);
            this.e.setVisibility(8);
            this.c.a();
        } else if (refreshState == RefreshHeader.RefreshState.RELEASE_TO_REFRESH) {
            this.d.setText(R.string.triver_open_releaserefresh_tip);
            this.e.setVisibility(0);
        }
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
        this.c.setProgress((int) (f * 100.0f));
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
        TextView textView = this.d;
        if (textView != null) {
            if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.NORMAL) {
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                this.c.setRingProgressColor(Color.parseColor("#FFFFFF"));
                this.e.setImageResource(R.drawable.triver_refresh_arrow);
            } else if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.DARK) {
                textView.setTextColor(Color.parseColor("#999999"));
                this.c.setRingProgressColor(Color.parseColor("#999999"));
                this.e.setImageResource(R.drawable.triver_refresh_arrow_gray);
            }
        }
    }
}
