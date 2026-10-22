package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.al;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g extends c {
    private final com.kwad.components.core.video.a.InterfaceC1231a iq;

    public g(@NonNull Context context) {
        super(context);
        this.iq = new com.kwad.components.core.video.a.InterfaceC1231a() { // from class: com.kwad.components.ad.feed.widget.g.1
            @Override // com.kwad.components.core.video.a.InterfaceC1231a
            public final void a(int i, al.a aVar) {
                int i2;
                int i3 = 3;
                boolean z = false;
                if (i == 1) {
                    i2 = 15;
                } else if (i == 2) {
                    i2 = 16;
                } else if (i != 3) {
                    i2 = 35;
                } else {
                    i2 = 39;
                    i3 = 1;
                    z = true;
                }
                g.this.cp();
                com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(g.this.getContext()).aJ(g.this.mAdTemplate).b(g.this.mApkDownloadHelper).aN(i3).as(z).au(true).aL(5).aM(i2).d(aVar).aw(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.g.1.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        g.this.zN();
                    }
                }));
            }
        };
        setmIsShowComplianceView(false);
        setRadiusDp(4);
    }

    @Override // com.kwad.components.ad.feed.widget.c, com.kwad.components.core.widget.b
    public final void bC() {
        super.bC();
        View viewFindViewById = findViewById(R.id.ksad_feed_biserial_video);
        if (viewFindViewById != null) {
            viewFindViewById.setClipToOutline(true);
        }
    }

    @Override // com.kwad.components.ad.feed.widget.c
    public final void cx() {
        this.ij.setRatio(1.7857143f);
    }

    @Override // com.kwad.components.ad.feed.widget.c
    public final int getDefaultClickArea() {
        return 3;
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_biserial_video;
    }

    @Override // com.kwad.components.ad.feed.widget.c
    public final com.kwad.components.core.video.a.InterfaceC1231a getVideoAdClickListener() {
        return this.iq;
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
        if (com.kwad.sdk.core.config.e.KD()) {
            return;
        }
        setBackgroundColor(-1);
    }
}
