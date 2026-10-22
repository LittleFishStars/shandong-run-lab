package com.kwad.components.ad.splashscreen.e;

import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.core.config.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends com.kwad.components.core.widget.a.c {
    public d(@NonNull View view, int i) {
        super(view, i);
    }

    @Override // com.kwad.components.core.widget.a.a, com.kwad.sdk.utils.cc.a
    public final void a(Message message) {
        long jKL = e.KL();
        if (message.what == 666) {
            zZ();
            this.ca.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, jKL);
        }
    }

    @Override // com.kwad.components.core.widget.a.c, com.kwad.components.core.widget.a.a
    public final boolean ah() {
        com.kwad.sdk.core.c.b.LW();
        if (!com.kwad.sdk.core.c.b.isEnable()) {
            return super.ah();
        }
        com.kwad.sdk.core.c.b.LW();
        return com.kwad.sdk.core.c.b.isAppOnForeground() && super.ah();
    }
}
