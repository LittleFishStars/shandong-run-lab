package com.kc.cw.ad.internal.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.kc.cw.ad.AdActivity;
import com.kc.cw.ad.internal.p;
import com.kc.cw.ad.internal.q;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f extends a {
    public static f u;
    private final String A;
    private final Queue<e> B;
    private AdActivity.a C;
    protected boolean v;
    protected boolean w;
    private int x;
    private int y;
    private boolean z;

    public f(Context context, p pVar, boolean z, String str) {
        super(context, str);
        int iArgb = 0;
        this.x = 0;
        this.y = 10000;
        this.B = new LinkedList();
        this.C = null;
        this.v = false;
        this.w = false;
        this.g = pVar;
        this.h = z;
        this.A = str;
        this.d.a(pVar);
        if (d()) {
            iArgb = -16777216;
        } else if (!z) {
            iArgb = Color.argb(8, 0, 0, 0);
        }
        this.x = iArgb;
    }

    private boolean a(long j) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator<e> it = this.B.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            e next = it.next();
            if (next != null && j - next.a() <= q.x && j - next.a() >= 0 && !next.b()) {
                z = true;
                break;
            }
            arrayList.add(next);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.B.remove((e) it2.next());
        }
        return z;
    }

    private boolean b(c cVar) {
        if (cVar != null && !cVar.j()) {
            return true;
        }
        com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.f38946a, "Loaded an ad with an invalid displayable");
        return false;
    }

    @Override // com.kc.cw.ad.internal.e.a
    public void a(Context context) {
        if (context == null) {
            return;
        }
        if ((this.p && !this.o) || !this.s) {
            this.q = true;
            this.t = context;
            return;
        }
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.c, com.kc.cw.ad.internal.c.f.a(R.string.show_int));
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!a(jCurrentTimeMillis) || this.v) {
            com.kc.cw.ad.internal.c.f.d(com.kc.cw.ad.internal.c.f.f38946a, com.kc.cw.ad.internal.c.f.a(R.string.empty_queue));
            return;
        }
        Intent intent = new Intent(context, AdActivity.a());
        intent.addFlags(268435456);
        intent.putExtra("ACTIVITY_TYPE", "INTERSTITIAL");
        intent.putExtra("TIME", jCurrentTimeMillis);
        intent.putExtra("CLOSE_BUTTON_DELAY", this.y);
        u = this;
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
            u = null;
        }
    }

    @Override // com.kc.cw.ad.internal.e.a
    public void a(Context context, AttributeSet attributeSet) {
        super.a(context, attributeSet);
        try {
            this.f.a(-1, this.A);
            DisplayMetrics displayMetricsB = com.kc.cw.ad.internal.c.b.b(context);
            int top = displayMetricsB.heightPixels;
            int i = displayMetricsB.widthPixels;
            try {
                Activity activity = (Activity) context;
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
                top -= activity.getWindow().findViewById(android.R.id.content).getTop() + 0;
            } catch (Exception e) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            }
            q qVarA = q.a();
            int iP = (int) ((top / qVarA.p()) + 0.5f);
            this.d.b((int) ((i / qVarA.o()) + 0.5f));
            this.d.c(iP);
        } catch (Exception e2) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e2);
        }
    }

    @Override // com.kc.cw.ad.internal.e.a
    public boolean a(com.kc.cw.ad.internal.b.a.C1001a c1001a) {
        com.kc.cw.ad.internal.c cVar;
        h();
        getAdParameters().a(false);
        this.e = c1001a;
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.c, com.kc.cw.ad.internal.c.f.a(R.string.load_ad_int));
        if (!a() || (cVar = this.f) == null) {
            return false;
        }
        cVar.a();
        this.f.a(this.A);
        this.i = 1;
        this.j = 0;
        return true;
    }

    @Override // com.kc.cw.ad.internal.e.a
    public boolean a(c cVar) {
        if (!b(cVar)) {
            b(80102);
            return false;
        }
        c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.k();
        }
        if (!this.v && !this.w) {
            this.c = cVar;
            this.B.add(new d(cVar, Long.valueOf(System.currentTimeMillis()), false));
            return true;
        }
        if (cVar == null) {
            return true;
        }
        cVar.k();
        return true;
    }

    @Override // com.kc.cw.ad.internal.e.a, com.kc.cw.ad.AdLifeControl
    public void cancel() {
        super.cancel();
        u = null;
        this.B.clear();
    }

    @Override // com.kc.cw.ad.internal.e.a, com.kc.cw.ad.AdLifeControl
    public void destroy() {
        super.destroy();
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.c, com.kc.cw.ad.internal.c.f.a(R.string.destroy_int));
        com.kc.cw.ad.internal.c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
        this.B.clear();
        u = null;
    }

    public AdActivity.a getAdImplementation() {
        return this.C;
    }

    public Queue<e> getAdQueue() {
        return this.B;
    }

    public int getBackgroundColor() {
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.c, com.kc.cw.ad.internal.c.f.a(R.string.get_bg));
        return this.x;
    }

    public int getCloseButtonDelay() {
        return this.y;
    }

    @Override // com.kc.cw.ad.internal.a
    public p getMediaType() {
        return this.g;
    }

    @Override // com.kc.cw.ad.internal.e.a
    public boolean k() {
        return true;
    }

    @Override // com.kc.cw.ad.internal.e.a, com.kc.cw.ad.AdLifeControl
    public void onCreateLifeCycle() {
        super.onCreateLifeCycle();
    }

    @Override // com.kc.cw.ad.internal.e.a, com.kc.cw.ad.AdLifeControl
    public void onDestroyLifeCycle() {
        super.onDestroyLifeCycle();
    }

    @Override // com.kc.cw.ad.internal.e.a, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // com.kc.cw.ad.internal.e.a, com.kc.cw.ad.AdLifeControl
    public void onPauseLifeCycle() {
        super.onPauseLifeCycle();
    }

    @Override // com.kc.cw.ad.internal.e.a, com.kc.cw.ad.AdLifeControl
    public void onRestartLifeCycle() {
        super.onRestartLifeCycle();
    }

    @Override // com.kc.cw.ad.internal.e.a, com.kc.cw.ad.AdLifeControl
    public void onResumeLifeCycle() {
        super.onResumeLifeCycle();
    }

    @Override // com.kc.cw.ad.internal.e.a, com.kc.cw.ad.AdLifeControl
    public void onStartLifeCycle() {
        super.onStartLifeCycle();
    }

    @Override // com.kc.cw.ad.internal.e.a, com.kc.cw.ad.AdLifeControl
    public void onStopLifeCycle() {
        super.onStopLifeCycle();
    }

    @Override // com.kc.cw.ad.internal.e.a
    public void s() {
        this.v = true;
    }

    public void setAdImplementation(AdActivity.a aVar) {
        this.C = aVar;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.c, com.kc.cw.ad.internal.c.f.a(R.string.set_bg));
        this.x = i;
    }

    public void setCloseButtonDelay(int i) {
        this.y = Math.min(i, 10000);
    }

    public void setDismissOnClick(boolean z) {
        this.z = z;
    }

    public void u() {
        this.w = true;
    }

    public void v() {
        this.w = false;
    }
}
