package com.byazt.sgn;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.lbn.TTViewStub;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 133})
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f29021a = false;
    public View c;
    public View i;
    public tt n;
    public com.byazt.jzl.uj sp;
    public TextView tt;
    public com.byazt.un.tt uj;
    public Context ve;
    public TTViewStub x;

    public enum c {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    public interface tt {
        boolean da();

        void t();
    }

    private void uj() {
        View view = this.c;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        if (this.ve == null) {
            return;
        }
        uj();
    }

    private void tt() {
        this.sp = null;
    }

    public void c(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.i = view;
        this.ve = gt.getContext().getApplicationContext();
        try {
            this.x = new TTViewStub(context, new com.byazt.wol.x());
        } catch (Throwable unused) {
        }
    }

    private void c(Context context, View view, boolean z) {
        TTViewStub tTViewStub;
        if (context == null || view == null || (tTViewStub = this.x) == null || tTViewStub.getParent() == null || this.c != null) {
            return;
        }
        this.x.c();
        this.c = view.findViewById(2114387870);
        this.tt = (TextView) view.findViewById(2114387817);
        View viewFindViewById = view.findViewById(2114387880);
        if (z) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.z.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    z.this.ve();
                    if (z.this.uj != null) {
                        z.this.uj.c(c.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    public void c(com.byazt.un.tt ttVar, tt ttVar2) {
        this.n = ttVar2;
        this.uj = ttVar;
    }

    public boolean c(int i, com.byazt.jzl.uj ujVar, boolean z) {
        Context context = this.ve;
        if (context != null && ujVar != null) {
            try {
                c(context, this.i, z);
                this.sp = ujVar;
                if (i == 1 || i == 2) {
                    return c(i);
                }
                return true;
            } catch (Throwable th) {
                com.byazt.nr.m.c(th);
            }
        }
        return true;
    }

    private boolean c(int i) {
        tt ttVar;
        if (c() || this.f29021a) {
            return true;
        }
        if (this.uj != null && (ttVar = this.n) != null) {
            if (ttVar.da()) {
                this.uj.n(null, null);
            }
            this.uj.c(c.PAUSE_VIDEO, (String) null);
        }
        c(this.sp, true);
        return false;
    }

    public void c(boolean z) {
        if (z) {
            tt();
        }
        uj();
    }

    public boolean c() {
        View view = this.c;
        return view != null && view.getVisibility() == 0;
    }

    private void c(com.byazt.jzl.uj ujVar, boolean z) {
        View view;
        String str;
        View view2;
        if (ujVar == null || (view = this.c) == null || this.ve == null || view.getVisibility() == 0) {
            return;
        }
        tt ttVar = this.n;
        if (ttVar != null) {
            ttVar.t();
        }
        int iCeil = (int) Math.ceil((ujVar.getSize() * 1.0d) / 1048576.0d);
        if (z) {
            str = "播放将消耗" + iCeil + "MB流量";
        } else {
            str = "播放将消耗流量";
        }
        pf.c(this.c, 0);
        pf.c(this.tt, str);
        if (!pf.uj(this.c) || (view2 = this.c) == null) {
            return;
        }
        view2.bringToFront();
    }
}
