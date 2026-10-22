package com.byazt.ouz;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.byazt.aas.pf;
import com.byazt.ete.v;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 1495})
public class SiteGestureView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28917a;
    public qy c;
    public float n;
    public long sp;
    public v tt;
    public float uj;
    public float ve;

    public SiteGestureView(Context context, v vVar, qy qyVar) {
        super(context);
        this.tt = vVar;
        this.c = qyVar;
        setTag(2097610717, "click");
    }

    private boolean c(int i, MotionEvent motionEvent) {
        if (this.tt.c() == 1 && this.c.c()) {
            com.byazt.nr.m.c("xdy", i + " ad");
            this.c.c(motionEvent);
            return false;
        }
        com.byazt.nr.m.c("xdy", i + " site");
        tt(i, motionEvent);
        return true;
    }

    private void tt(int i, MotionEvent motionEvent) {
        int[] iArrC = pf.c(this);
        com.byazt.ete.gr grVarC = new com.byazt.ete.gr.c().c("express_gesture_view").uj(this.n).ve(this.f28917a).tt(motionEvent.getRawX()).c(motionEvent.getRawY()).tt(this.sp).ve(getWidth()).uj(getHeight()).c(iArrC == null ? 0 : iArrC[0]).tt(iArrC != null ? iArrC[1] : 0).c(true).c(System.currentTimeMillis()).c();
        this.tt.c(i);
        this.c.c(this, 1, grVarC, this.tt);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.ve = pf.uj(getContext(), motionEvent.getX());
            this.uj = pf.uj(getContext(), motionEvent.getY());
            this.n = motionEvent.getRawX();
            this.f28917a = motionEvent.getRawY();
            this.sp = System.currentTimeMillis();
            this.c.c(motionEvent);
            if (this.tt.tt() == -1) {
                com.byazt.nr.m.c("xdy", "nt ad");
                return false;
            }
            if (!this.c.ve()) {
                com.byazt.nr.m.c("xdy", "un ad");
                return false;
            }
        } else {
            if (action == 1) {
                this.c.tt();
                float fUj = pf.uj(getContext(), motionEvent.getX());
                float fUj2 = pf.uj(getContext(), motionEvent.getY());
                if (this.tt.ve() == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    com.byazt.nr.m.c("xdy", "nh g");
                    tt(-1, motionEvent);
                    return true;
                }
                float f = fUj - this.ve;
                float f2 = fUj2 - this.uj;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (fAbs <= 3.0f && fAbs2 <= 3.0f) {
                    com.byazt.nr.m.c("xdy", "c ad");
                    this.c.c(motionEvent);
                    return true;
                }
                double dVe = this.tt.ve();
                int iUj = this.tt.uj();
                if (fAbs > fAbs2) {
                    if (fAbs > dVe) {
                        long j = iUj;
                        if (com.byazt.vgp.tt.c(j, 2L) && f < 0.0f) {
                            return c(2, motionEvent);
                        }
                        if (com.byazt.vgp.tt.c(j, 4L) && f > 0.0f) {
                            return c(4, motionEvent);
                        }
                    }
                } else if (fAbs2 > dVe) {
                    long j2 = iUj;
                    if (com.byazt.vgp.tt.c(j2, 8L) && f2 < 0.0f) {
                        return c(8, motionEvent);
                    }
                    if (com.byazt.vgp.tt.c(j2, 16L) && f2 > 0.0f) {
                        return c(16, motionEvent);
                    }
                }
                return false;
            }
            if (action == 3) {
                com.byazt.nr.m.c("xdy", "gesture cancel");
            }
        }
        return true;
    }
}
