package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class KsView extends FrameLayout {
    public KsView(Context context) {
        super(context);
        A(context);
    }

    private void A(Context context) {
        if (XK()) {
            m.inflate(context, R.layout.ksad_custom_custom_view, this);
        } else {
            m.inflate(context, R.layout.ksad_only_view, this);
        }
    }

    private static boolean XK() {
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        boolean zEnableInflaterOptimize = hVar != null ? hVar.enableInflaterOptimize() : false;
        com.kwad.sdk.core.d.c.d("KsView", "enableFullName: " + zEnableInflaterOptimize);
        return zEnableInflaterOptimize;
    }

    public KsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        A(context);
    }

    public KsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        A(context);
    }

    @RequiresApi(api = 21)
    public KsView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        A(context);
    }
}
