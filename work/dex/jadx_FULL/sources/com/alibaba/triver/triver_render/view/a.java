package com.alibaba.triver.triver_render.view;

import android.graphics.Bitmap;
import android.view.View;
import com.uc.webview.export.extension.EmbedViewConfig;
import com.uc.webview.export.extension.IEmbedView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements IEmbedView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f25226a;
    private com.alibaba.ariver.engine.api.embedview.IEmbedView b;
    private EmbedViewConfig c;

    public a(View view, com.alibaba.ariver.engine.api.embedview.IEmbedView iEmbedView, EmbedViewConfig embedViewConfig) {
        this.f25226a = view;
        this.b = iEmbedView;
        this.c = embedViewConfig;
    }

    public Bitmap getSnapShot() {
        return this.b.getSnapshot();
    }

    public View getView() {
        return this.f25226a;
    }
}
