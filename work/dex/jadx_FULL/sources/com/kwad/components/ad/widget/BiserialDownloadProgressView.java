package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class BiserialDownloadProgressView extends DownloadProgressView {
    public BiserialDownloadProgressView(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    public final void ot() {
        m.inflate(getContext(), R.layout.ksad_download_progress_biserial_layout, this);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    public final void ou() {
        this.Of = getResources().getDrawable(R.drawable.ksad_feed_download_progress_novel);
    }

    @Override // com.kwad.components.ad.widget.DownloadProgressView
    public final void ov() {
        this.Og = getResources().getDrawable(R.drawable.ksad_feed_actionbar_before_bg);
    }

    public BiserialDownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BiserialDownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
