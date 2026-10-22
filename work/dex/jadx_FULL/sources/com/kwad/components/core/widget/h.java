package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@RequiresApi(api = 21)
public final class h extends ViewOutlineProvider {
    private float awz;

    private h(float f) {
        this.awz = f;
    }

    @RequiresApi(api = 21)
    public static void f(View view, float f) {
        if (f <= 0.0f) {
            view.setOutlineProvider(null);
            view.setClipToOutline(false);
        } else {
            view.setOutlineProvider(new h(f));
            view.setClipToOutline(true);
        }
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.awz);
    }
}
