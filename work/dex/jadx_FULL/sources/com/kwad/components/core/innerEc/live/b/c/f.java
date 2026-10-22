package com.kwad.components.core.innerEc.live.b.c;

import com.kwad.sdk.R;
import com.kwad.sdk.widget.swipe.HorizontalSwipeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends com.kwad.components.core.innerEc.live.b.a.a {
    private HorizontalSwipeLayout Wf;
    private final HorizontalSwipeLayout.a Wg = new HorizontalSwipeLayout.a() { // from class: com.kwad.components.core.innerEc.live.b.c.f.1
        @Override // com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.a
        public final void sh() {
            if (f.this.Ub.US != null) {
                f.this.Ub.US.ry();
            }
        }

        @Override // com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.a
        public final void si() {
            if (f.this.Ub.US != null) {
                f.this.Ub.US.rz();
            }
        }
    };

    @Override // com.kwad.components.core.innerEc.live.b.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Wf.a(this.Wg);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Wf = (HorizontalSwipeLayout) findViewById(R.id.ksad_live_horizontal_swipe_layout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Wf.b(this.Wg);
    }
}
