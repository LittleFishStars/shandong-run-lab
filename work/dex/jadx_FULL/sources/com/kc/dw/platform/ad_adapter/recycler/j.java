package com.kc.dw.platform.ad_adapter.recycler;

import android.content.Context;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.view.ShakeImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39507a;
    public final RelativeLayout b;
    public final ShakeImageView c;
    public final i d;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f39508a;

        public a(j jVar) {
            this.f39508a = jVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            this.f39508a.c.stopAnimation();
            this.f39508a.b.setVisibility(8);
        }
    }

    public j(i iVar, Context context, RelativeLayout relativeLayout, ShakeImageView shakeImageView) {
        this.d = iVar;
        this.f39507a = context;
        this.b = relativeLayout;
        this.c = shakeImageView;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            DisplayMetrics displayMetrics = this.f39507a.getResources().getDisplayMetrics();
            int measuredHeight = this.d.c.getMeasuredHeight();
            if (p0.e() && measuredHeight < displayMetrics.density * 120.0f) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
                layoutParams.height = Math.max(measuredHeight - 70, (int) (displayMetrics.density * 70.0f));
                layoutParams.width = -2;
                layoutParams.addRule(13);
                this.b.setLayoutParams(layoutParams);
            }
            this.b.setVisibility(0);
            this.c.startAnimation();
            this.b.postDelayed(new a(this), 2000L);
        } catch (Throwable unused) {
        }
    }
}
