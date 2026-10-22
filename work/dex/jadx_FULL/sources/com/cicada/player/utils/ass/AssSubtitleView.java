package com.cicada.player.utils.ass;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AssSubtitleView extends RelativeLayout {
    private AssResolver mAssResolver;
    private List<AssTextView> mAssSubtitleView;
    private int videoHeight;
    private int videoWidth;

    public AssSubtitleView(Context context) {
        super(context);
        this.mAssSubtitleView = new ArrayList();
        this.videoWidth = 0;
        this.videoHeight = 0;
        init(context);
    }

    public AssSubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAssSubtitleView = new ArrayList();
        this.videoWidth = 0;
        this.videoHeight = 0;
        init(context);
    }

    public AssSubtitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAssSubtitleView = new ArrayList();
        this.videoWidth = 0;
        this.videoHeight = 0;
        init(context);
    }

    private void init(Context context) {
        this.mAssResolver = new AssResolver(context);
    }

    public void destroy() {
        AssResolver assResolver = this.mAssResolver;
        if (assResolver != null) {
            assResolver.destroy();
        }
    }

    public synchronized void dismiss(long j) {
        ArrayList arrayList = new ArrayList();
        for (AssTextView assTextView : this.mAssSubtitleView) {
            if (assTextView.getSubtitleId().longValue() == j) {
                removeView(assTextView);
                this.mAssResolver.dismiss(assTextView);
                arrayList.add(assTextView);
            }
        }
        this.mAssSubtitleView.removeAll(arrayList);
    }

    public void setAssHeader(String str) {
        this.mAssResolver.setAssHeaders(str);
    }

    public void setFontTypeFace(Map<String, Typeface> map) {
        this.mAssResolver.setFontTypeMap(map);
    }

    public synchronized void setVideoRenderSize(int i, int i2) {
        if (this.videoWidth != i || this.videoHeight != i2) {
            this.videoWidth = i;
            this.videoHeight = i2;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.videoWidth;
                layoutParams.height = this.videoHeight;
                setLayoutParams(layoutParams);
            }
            this.mAssResolver.setVideoDisplaySize(this.videoWidth, this.videoHeight);
            ArrayList<AssTextView> arrayList = new ArrayList();
            arrayList.addAll(this.mAssSubtitleView);
            for (AssTextView assTextView : arrayList) {
                long jLongValue = assTextView.getSubtitleId().longValue();
                String content = assTextView.getContent();
                dismiss(jLongValue);
                show(jLongValue, content);
            }
        }
    }

    public synchronized void show(long j, String str) {
        AssTextView assDialog = this.mAssResolver.setAssDialog(str);
        if (assDialog != null) {
            assDialog.setSubtitleId(Long.valueOf(j));
            addView(assDialog);
            this.mAssSubtitleView.add(assDialog);
        }
        invalidate();
    }
}
