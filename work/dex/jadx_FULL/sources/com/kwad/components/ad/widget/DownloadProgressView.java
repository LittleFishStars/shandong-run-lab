package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class DownloadProgressView extends FrameLayout {
    protected TextView Oa;

    @ColorInt
    private int Ob;

    @ColorInt
    private int Oc;

    @ColorInt
    private int Od;
    private int Oe;
    protected Drawable Of;
    protected Drawable Og;
    private String Oh;
    private final KsAppDownloadListener en;
    protected TextProgressBar gl;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.Ob = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.Oc = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.Od = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.Oe = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.c.a.a.a(getContext(), 11.0f));
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.Of = drawable;
        if (drawable == null) {
            ou();
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.Og = drawable2;
        if (drawable2 == null) {
            ov();
        }
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.Oh = string;
        if (string == null) {
            this.Oh = "下载中  %s%%";
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initView() {
        ot();
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.gl = textProgressBar;
        textProgressBar.setTextDimen(this.Oe);
        this.gl.setTextColor(this.Oc, this.Od);
        this.gl.setProgressDrawable(this.Of);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.Oa = textView;
        textView.setTextColor(this.Ob);
        this.Oa.setTextSize(0, this.Oe);
        this.Oa.setVisibility(0);
        this.Oa.setBackground(this.Og);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    public final void aA(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEO = e.eO(adTemplate);
        this.mAdInfo = adInfoEO;
        this.Oa.setText(com.kwad.sdk.core.response.helper.a.aK(adInfoEO));
        this.gl.setVisibility(8);
        this.Oa.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.en;
    }

    public void ot() {
        m.inflate(getContext(), R.layout.ksad_download_progress_layout, this);
    }

    public void ou() {
        this.Of = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
    }

    public void ov() {
        this.Og = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        this.en = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.Oa.setText(com.kwad.sdk.core.response.helper.a.aK(downloadProgressView.mAdInfo));
                DownloadProgressView.this.Oa.setVisibility(0);
                DownloadProgressView.this.gl.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.Oa.setVisibility(8);
                DownloadProgressView.this.gl.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.gl.e(com.kwad.sdk.core.response.helper.a.cK(downloadProgressView.mAdTemplate), DownloadProgressView.this.gl.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.Oa.setText(com.kwad.sdk.core.response.helper.a.aK(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.Oa.setVisibility(8);
                DownloadProgressView.this.gl.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.gl.e(com.kwad.sdk.core.response.helper.a.af(downloadProgressView.mAdInfo), DownloadProgressView.this.gl.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i2) {
                DownloadProgressView.this.Oa.setVisibility(8);
                DownloadProgressView.this.gl.setVisibility(0);
                DownloadProgressView.this.gl.e(com.kwad.sdk.core.response.helper.a.Nx(), i2);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i2) {
                DownloadProgressView.this.Oa.setVisibility(8);
                DownloadProgressView.this.gl.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.gl.e(com.kwad.sdk.core.response.helper.a.y(i2, downloadProgressView.Oh), i2);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }
}
