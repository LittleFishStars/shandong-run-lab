package com.alibaba.triver.triver_render.view.refresh;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.triver.triver_render.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends RefreshHeader {
    private static final long d = 400;
    Runnable c;
    private boolean e;
    private ImageView f;
    private TextView g;
    private Handler h;
    private Context i;
    private boolean j;

    public b(Context context) {
        super(context);
        this.e = false;
        this.h = new Handler(Looper.getMainLooper());
        this.j = true;
        this.c = new Runnable() { // from class: com.alibaba.triver.triver_render.view.refresh.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f == null || b.this.i == null) {
                    return;
                }
                if ((b.this.i instanceof Activity) && ((Activity) b.this.i).isFinishing()) {
                    return;
                }
                if (b.this.e) {
                    if (b.this.j) {
                        b.this.f.setImageResource(R.drawable.triver_tools_refresh_header_loading_black1);
                    } else {
                        b.this.f.setImageResource(R.drawable.triver_tools_refresh_header_loading_white1);
                    }
                    b.this.e = false;
                } else {
                    if (b.this.j) {
                        b.this.f.setImageResource(R.drawable.triver_tools_refresh_header_loading_black2);
                    } else {
                        b.this.f.setImageResource(R.drawable.triver_tools_refresh_header_loading_white2);
                    }
                    b.this.e = true;
                }
                b.this.h.postDelayed(this, b.d);
            }
        };
        a(RefreshHeader.RefreshState.NONE);
        this.i = context;
        View view = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.triver_tools_refresh_header, (ViewGroup) this, false);
        this.f = (ImageView) view.findViewById(R.id.triver_icon);
        this.g = (TextView) view.findViewById(R.id.triver_tip);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        addView(view, layoutParams);
        setBackgroundColor(0);
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

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void a(RefreshHeader.RefreshState refreshState) {
        this.b = refreshState;
        if (this.f == null) {
            return;
        }
        if (refreshState == RefreshHeader.RefreshState.PULL_TO_REFRESH || refreshState == RefreshHeader.RefreshState.REFRESHING || refreshState == RefreshHeader.RefreshState.RELEASE_TO_REFRESH) {
            this.g.setText(R.string.triver_tools_refresh_tip);
        }
        if (refreshState == RefreshHeader.RefreshState.REFRESHING) {
            this.h.post(this.c);
        } else {
            this.h.removeCallbacks(this.c);
        }
    }

    @Override // com.alibaba.triver.triver_render.view.refresh.RefreshHeader
    public void a(RefreshHeader.RefreshHeaderStyle refreshHeaderStyle) {
        TextView textView = this.g;
        if (textView != null) {
            if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.NORMAL) {
                textView.setTextColor(Color.parseColor("#FFFFFF"));
                this.f.setImageResource(R.drawable.triver_tools_refresh_header_loading_white1);
                this.j = false;
            } else if (refreshHeaderStyle == RefreshHeader.RefreshHeaderStyle.DARK) {
                textView.setTextColor(Color.parseColor("#111111"));
                this.f.setImageResource(R.drawable.triver_tools_refresh_header_loading_black1);
                this.j = true;
            }
        }
    }
}
