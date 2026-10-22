package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"AppCompatCustomView"})
public class KsConvertButton extends KSCornerButton implements KsAppDownloadListener {

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    public KsConvertButton(Context context) {
        super(context);
    }

    private void bS(@Nullable String str) {
        if (str != null) {
            setText(str);
        }
    }

    @Nullable
    private String getAdActionDesc() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            return com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        }
        return null;
    }

    public final void a(@Nullable com.kwad.components.core.e.d.d dVar, AdTemplate adTemplate) {
        this.mApkDownloadHelper = dVar;
        this.mAdTemplate = adTemplate;
        if (dVar != null) {
            dVar.b(this);
        }
        bS(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        bS(adTemplate != null ? com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        bS(getAdActionDesc());
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        bS(adTemplate != null ? com.kwad.sdk.core.response.helper.a.af(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        bS("下载中..." + i + "%");
    }

    public KsConvertButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsConvertButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsConvertButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
