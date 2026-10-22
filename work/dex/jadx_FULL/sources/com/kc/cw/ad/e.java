package com.kc.cw.ad;

import android.app.Activity;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.kc.cw.ad.internal.e.f;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e implements AdActivity.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f38823a;
    private com.kc.cw.ad.internal.e.b b;
    private com.kc.cw.ad.internal.e.c c;
    private FrameLayout d;
    private FrameLayout.LayoutParams e;
    private long f;
    private f g;

    public e(Activity activity) {
        this.f38823a = activity;
    }

    private void a(f fVar) {
        com.kc.cw.ad.internal.e.e eVarPoll;
        int i;
        int creativeWidth;
        int creativeHeight;
        this.g = fVar;
        if (fVar == null) {
            return;
        }
        fVar.setAdImplementation(this);
        this.d.setBackgroundColor(this.g.getBackgroundColor());
        this.d.removeAllViews();
        if (this.g.getParent() != null) {
            ((ViewGroup) this.g.getParent()).removeAllViews();
        }
        while (true) {
            eVarPoll = this.g.getAdQueue().poll();
            if (eVarPoll == null || (this.f - eVarPoll.a() <= q.x && this.f - eVarPoll.a() >= 0)) {
                break;
            } else {
                com.kc.cw.ad.internal.c.f.d(com.kc.cw.ad.internal.c.f.f38946a, com.kc.cw.ad.internal.c.f.a(R.string.too_old));
            }
        }
        if (eVarPoll == null || eVarPoll.c() == null) {
            return;
        }
        com.kc.cw.ad.internal.e.b bVarC = eVarPoll.c();
        this.b = bVarC;
        if (bVarC.a() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.b.a()).setBaseContext(this.f38823a);
            d dVar = this.b.d;
            if (dVar != null) {
                ((MutableContextWrapper) dVar.getContext()).setBaseContext(this.f38823a);
            }
        }
        if ((this.b.getCreativeWidth() != 1 || this.b.getCreativeHeight() != 1) && this.f38823a.getResources().getConfiguration().orientation != 2) {
            try {
                i = this.g.getAdParameters().b().getApplicationInfo().targetSdkVersion;
            } catch (Exception e) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                i = 0;
            }
            if (i <= 26 || Build.VERSION.SDK_INT != 26) {
                AdActivity.a(this.f38823a, this.b.q());
            } else {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "Only fullscreen activities can request orientation");
            }
        }
        this.c = this.b.c();
        View view = this.b.c().getView();
        boolean z = view instanceof d;
        View view2 = view;
        if (z) {
            FrameLayout frameLayout = new FrameLayout(this.f38823a);
            frameLayout.setBackgroundColor(-16777216);
            frameLayout.addView(view, this.e);
            view2 = frameLayout;
        }
        if (this.b.m()) {
            this.d.addView(view2, this.e);
        } else {
            if (this.f38823a.getRequestedOrientation() == 0) {
                creativeWidth = (int) (this.b.getCreativeHeight() * q.a().t);
                creativeHeight = this.b.getCreativeWidth();
            } else {
                creativeWidth = (int) (this.b.getCreativeWidth() * q.a().t);
                creativeHeight = this.b.getCreativeHeight();
            }
            int i2 = (int) (creativeHeight * q.a().u);
            int screenWidth = ViewUtil.getScreenWidth(this.b.a());
            if (creativeWidth > screenWidth || creativeWidth <= 0) {
                creativeWidth = screenWidth;
            }
            int screenHeight = ViewUtil.getScreenHeight(this.b.a());
            if (i2 > screenHeight || i2 <= 0) {
                i2 = screenHeight;
            }
            this.d.addView(view2, new FrameLayout.LayoutParams(creativeWidth, i2, 17));
            this.d.setLayoutParams(new FrameLayout.LayoutParams(screenWidth, screenHeight, 17));
        }
        this.c.l();
    }

    @Override // com.kc.cw.ad.AdActivity.a
    public void a() {
        com.kc.cw.ad.internal.e.e eVarPeek;
        Activity activity;
        int i;
        f fVar = f.u;
        if (fVar == null || fVar.getAdQueue() == null || (eVarPeek = f.u.getAdQueue().peek()) == null || eVarPeek.c() == null) {
            this.f38823a.finish();
            return;
        }
        try {
            WindowManager.LayoutParams attributes = this.f38823a.getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            this.f38823a.getWindow().setAttributes(attributes);
            com.kc.cw.ad.internal.e.b bVarC = eVarPeek.c();
            if (bVarC.n()) {
                activity = this.f38823a;
                i = R.style.SSAdDialogStyle;
            } else {
                activity = this.f38823a;
                i = R.style.SSAdDialogStyleTran;
            }
            activity.setTheme(i);
            if (bVarC.m()) {
                this.f38823a.setTheme(R.style.SSAdTheme_Black);
                ViewUtil.hideSystemTitleBarUI(this.f38823a);
            }
            this.d = new FrameLayout(this.f38823a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
            this.e = layoutParams;
            this.d.setLayoutParams(layoutParams);
            this.f38823a.setContentView(this.d);
            this.f = this.f38823a.getIntent().getLongExtra("TIME", System.currentTimeMillis());
            a(f.u);
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            this.f38823a.finish();
        }
    }

    @Override // com.kc.cw.ad.AdActivity.a
    public void b() {
        com.kc.cw.ad.internal.e.b bVar = this.b;
        if (bVar != null) {
            d dVar = bVar.d;
            if (dVar != null) {
                dVar.n();
            }
            f fVar = this.g;
            if (fVar != null) {
                fVar.onResumeLifeCycle();
            }
        }
    }

    @Override // com.kc.cw.ad.AdActivity.a
    public void c() {
        com.kc.cw.ad.internal.e.b bVar = this.b;
        if (bVar != null) {
            d dVar = bVar.d;
            if (dVar != null) {
                dVar.m();
            }
            f fVar = this.g;
            if (fVar != null) {
                fVar.onPauseLifeCycle();
            }
        }
    }

    @Override // com.kc.cw.ad.AdActivity.a
    public void d() {
        com.kc.cw.ad.internal.e.b bVar = this.b;
        if (bVar != null) {
            ViewUtil.removeChildFromParent(bVar.c);
            this.b.k();
            d dVar = this.b.d;
            if (dVar != null) {
                dVar.k();
            }
        }
        f fVar = this.g;
        if (fVar != null) {
            fVar.setAdImplementation(null);
            this.g.onDestroyLifeCycle();
            this.g.destroy();
            this.g = null;
        }
        this.f38823a.finish();
    }

    @Override // com.kc.cw.ad.AdActivity.a
    public void e() {
    }

    public void f() {
        com.kc.cw.ad.internal.e.c cVarC;
        com.kc.cw.ad.internal.e.c cVar;
        FrameLayout frameLayout;
        View view;
        ViewGroup.LayoutParams layoutParams;
        com.kc.cw.ad.internal.e.b bVar = this.b;
        if (bVar == null || (cVarC = bVar.c()) == (cVar = this.c)) {
            return;
        }
        this.d.removeView(cVar.getView());
        if (cVarC instanceof d) {
            frameLayout = this.d;
            view = cVarC.getView();
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        } else {
            frameLayout = this.d;
            view = cVarC.getView();
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        frameLayout.addView(view, layoutParams);
        this.c = cVarC;
        cVarC.l();
    }
}
