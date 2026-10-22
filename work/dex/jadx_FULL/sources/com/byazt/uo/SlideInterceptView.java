package com.byazt.uo;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.aas.pf;
import com.byazt.dna.qp;
import com.byazt.ete.gr;
import com.byazt.ete.s;
import com.byazt.nr.d;
import com.byazt.omf.gt;
import com.byazt.ouz.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 139, 2293})
public class SlideInterceptView extends View implements qp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f29104a;
    public float c;
    public final com.byazt.dq.c da;
    public final c i;
    public float n;
    public final d sl;
    public boolean sp;
    public final Map<Integer, tt> t;
    public float tt;
    public MotionEvent uj;
    public long ve;
    public final s x;

    public interface c {
        n c();

        void c(View view, gr grVar);
    }

    @com.byazt.zqa.c(c = {0, 1, 139, 1491})
    public static class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f29105a = false;
        public float c;
        public float n;
        public MotionEvent sp;
        public float tt;
        public float uj;
        public long ve;

        public tt(float f, float f2, long j, MotionEvent motionEvent) {
            this.c = f;
            this.tt = f2;
            this.ve = j;
            this.uj = f;
            this.n = f2;
            this.sp = motionEvent;
        }
    }

    public SlideInterceptView(Context context, s sVar, c cVar) {
        super(context);
        this.sp = false;
        this.da = new com.byazt.dq.c();
        this.sl = new d(this);
        this.t = new HashMap();
        this.x = sVar;
        this.i = cVar;
    }

    private void c(MotionEvent motionEvent) {
        n nVarC;
        c cVar = this.i;
        if (cVar == null || (nVarC = cVar.c()) == null) {
            return;
        }
        nVarC.ve(motionEvent.getDeviceId());
        nVarC.tt(motionEvent.getSource());
        nVarC.uj(motionEvent.getToolType(0));
    }

    private boolean c(float f, float f2, int i, int i2) {
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        boolean z3 = (i & 4) == 4;
        boolean z4 = (i & 8) == 8;
        if (z && (-f2) > i2) {
            return true;
        }
        if (z2 && f2 > i2) {
            return true;
        }
        if (!z3 || (-f) <= i2) {
            return z4 && f > ((float) i2);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:53:0x0110  */
    /* JADX WARN: Code duplicated, block: B:56:0x0119 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x011a A[RETURN] */
    private boolean tt(MotionEvent motionEvent) {
        boolean z;
        c cVar;
        c cVar2;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        this.n = motionEvent.getX();
        this.f29104a = motionEvent.getY();
        this.uj = motionEvent;
        float f = x - this.c;
        float f2 = y - this.tt;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.ve;
        int iRh = this.x.rh();
        int iVe = pf.ve(getContext(), this.x.my());
        int iGu = this.x.gu();
        int iVe2 = pf.ve(getContext(), this.x.gr());
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.sl.removeMessages(1);
                if (c(f, f2, iRh, iVe)) {
                    if (!this.sp) {
                        this.sp = true;
                        cVar2 = this.i;
                        if (cVar2 != null) {
                            cVar2.c(this, c(x, y, motionEvent, (byte) 2));
                        }
                    }
                } else if (!c(f, f2, jCurrentTimeMillis, iGu, iVe2)) {
                    z = this.sp ? false : true;
                } else if (!this.sp) {
                    this.sp = true;
                    cVar = this.i;
                    if (cVar != null) {
                        cVar.c(this, c(x, y, motionEvent, (byte) 5));
                    }
                }
            } else if (action != 2) {
                if (action == 3) {
                    float rawX = motionEvent.getRawX();
                    if (motionEvent.getRawY() == 0.0f && rawX == 0.0f) {
                        this.sl.removeMessages(1);
                    } else {
                        this.sl.removeMessages(1);
                        if (c(f, f2, iRh, iVe)) {
                            if (!this.sp) {
                                this.sp = true;
                                cVar2 = this.i;
                                if (cVar2 != null) {
                                    cVar2.c(this, c(x, y, motionEvent, (byte) 2));
                                }
                            }
                        } else if (!c(f, f2, jCurrentTimeMillis, iGu, iVe2)) {
                            if (!this.sp) {
                                this.sp = true;
                                cVar = this.i;
                                if (cVar != null) {
                                    cVar.c(this, c(x, y, motionEvent, (byte) 5));
                                }
                            }
                        } else if (this.sp) {
                        }
                    }
                }
            } else if (this.x.qy() == 1 && c(f, f2, iRh, iVe)) {
                if (!this.sp) {
                    this.sp = true;
                    c cVar3 = this.i;
                    if (cVar3 != null) {
                        cVar3.c(this, c(x, y, motionEvent, (byte) 2));
                    }
                }
            } else if (c(f, f2, jCurrentTimeMillis, iGu, iVe2) && !this.sp) {
                this.sp = true;
                c cVar4 = this.i;
                if (cVar4 != null) {
                    cVar4.c(this, c(x, y, motionEvent, (byte) 5));
                }
            }
            if (z) {
                this.da.c(this);
            }
            if (this.sp) {
                return false;
            }
            return true;
        }
        this.c = x;
        this.tt = y;
        this.ve = System.currentTimeMillis();
        if (iGu > 0) {
            this.sl.sendEmptyMessageDelayed(1, iGu);
        }
        if (z) {
            this.da.c(this);
        }
        if (this.sp) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0097  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:49:0x0116  */
    /* JADX WARN: Code duplicated, block: B:51:0x0130  */
    private boolean ve(MotionEvent motionEvent) {
        tt ttVar;
        int iGu;
        tt ttVar2;
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        if (actionMasked == 0) {
            ttVar = new tt(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex), System.currentTimeMillis(), motionEvent);
            this.t.put(Integer.valueOf(pointerId), ttVar);
            if (actionMasked == 0) {
                float f = ttVar.c;
                this.c = f;
                float f2 = ttVar.tt;
                this.tt = f2;
                this.ve = ttVar.ve;
                this.n = f;
                this.f29104a = f2;
                this.uj = motionEvent;
                iGu = this.x.gu();
                if (iGu > 0) {
                    this.sl.sendEmptyMessageDelayed(1, iGu);
                }
            }
        } else if (actionMasked == 1) {
            ttVar2 = this.t.get(Integer.valueOf(pointerId));
            if (ttVar2 != null && !ttVar2.f29105a) {
                c(ttVar2, ttVar2.uj - ttVar2.c, ttVar2.n - ttVar2.tt, System.currentTimeMillis() - ttVar2.ve, ttVar2.uj, ttVar2.n, motionEvent, true);
            }
            this.t.remove(Integer.valueOf(pointerId));
            if (actionMasked == 1) {
                this.sl.removeMessages(1);
                if (this.sp && this.t.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.da.c(this);
                }
                this.t.clear();
                this.sp = false;
            }
        } else if (actionMasked == 2) {
            boolean z2 = false;
            for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                tt ttVar3 = this.t.get(Integer.valueOf(motionEvent.getPointerId(i)));
                if (ttVar3 != null && !ttVar3.f29105a) {
                    float x = motionEvent.getX(i);
                    float y = motionEvent.getY(i);
                    ttVar3.uj = x;
                    ttVar3.n = y;
                    ttVar3.sp = motionEvent;
                    if (c(ttVar3, x - ttVar3.c, y - ttVar3.tt, System.currentTimeMillis() - ttVar3.ve, x, y, motionEvent, false)) {
                        z2 = true;
                    }
                }
            }
            if (motionEvent.getPointerCount() > 0) {
                this.n = motionEvent.getX(0);
                this.f29104a = motionEvent.getY(0);
                this.uj = motionEvent;
            }
            if (z2) {
                this.sp = true;
            }
        } else if (actionMasked == 3) {
            this.sl.removeMessages(1);
            this.t.clear();
            this.sp = false;
        } else if (actionMasked == 5) {
            ttVar = new tt(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex), System.currentTimeMillis(), motionEvent);
            this.t.put(Integer.valueOf(pointerId), ttVar);
            if (actionMasked == 0) {
                float f3 = ttVar.c;
                this.c = f3;
                float f4 = ttVar.tt;
                this.tt = f4;
                this.ve = ttVar.ve;
                this.n = f3;
                this.f29104a = f4;
                this.uj = motionEvent;
                iGu = this.x.gu();
                if (iGu > 0) {
                    this.sl.sendEmptyMessageDelayed(1, iGu);
                }
            }
        } else if (actionMasked == 6) {
            ttVar2 = this.t.get(Integer.valueOf(pointerId));
            if (ttVar2 != null) {
                c(ttVar2, ttVar2.uj - ttVar2.c, ttVar2.n - ttVar2.tt, System.currentTimeMillis() - ttVar2.ve, ttVar2.uj, ttVar2.n, motionEvent, true);
            }
            this.t.remove(Integer.valueOf(pointerId));
            if (actionMasked == 1) {
                this.sl.removeMessages(1);
                if (this.sp) {
                    z = false;
                } else {
                    z = false;
                }
                if (z) {
                    this.da.c(this);
                }
                this.t.clear();
                this.sp = false;
            }
        }
        return !this.sp;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.da.c(motionEvent)) {
            return false;
        }
        com.byazt.dq.c cVar = this.da;
        StringBuilder sb = new StringBuilder();
        sb.append(getId());
        cVar.c(this, sb.toString(), motionEvent);
        c(motionEvent);
        return gt.tt().tw() ? ve(motionEvent) : tt(motionEvent);
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        if (!gt.tt().tw()) {
            if (!c(this.n - this.c, this.f29104a - this.tt, System.currentTimeMillis() - this.ve, this.x.gu(), pf.ve(getContext(), this.x.gr())) || this.sp) {
                return;
            }
            this.sp = true;
            c cVar = this.i;
            if (cVar != null) {
                cVar.c(this, c(this.n, this.f29104a, this.uj, (byte) 5));
                return;
            }
            return;
        }
        Iterator<Map.Entry<Integer, tt>> it = this.t.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            tt value = it.next().getValue();
            if (value != null && !value.f29105a && c(value.uj - value.c, value.n - value.tt, System.currentTimeMillis() - value.ve, this.x.gu(), pf.ve(getContext(), this.x.gr()))) {
                value.f29105a = true;
                c cVar2 = this.i;
                if (cVar2 != null) {
                    cVar2.c(this, c(value, value.uj, value.n, value.sp, (byte) 5));
                }
                z = true;
            }
        }
        if (z) {
            this.sp = true;
        }
    }

    private boolean c(tt ttVar, float f, float f2, long j, float f3, float f4, MotionEvent motionEvent, boolean z) {
        int iRh = this.x.rh();
        int iVe = pf.ve(getContext(), this.x.my());
        int iGu = this.x.gu();
        int iVe2 = pf.ve(getContext(), this.x.gr());
        if ((z || this.x.qy() == 1) && !ttVar.f29105a) {
            if (c(f, f2, iRh, iVe)) {
                ttVar.f29105a = true;
                c cVar = this.i;
                if (cVar != null) {
                    cVar.c(this, c(ttVar, f3, f4, motionEvent, (byte) 2));
                }
                return true;
            }
        }
        if (ttVar.f29105a || !c(f, f2, j, iGu, iVe2)) {
            return false;
        }
        ttVar.f29105a = true;
        c cVar2 = this.i;
        if (cVar2 != null) {
            cVar2.c(this, c(ttVar, f3, f4, motionEvent, (byte) 5));
        }
        return true;
    }

    private boolean c(float f, float f2, long j, int i, int i2) {
        if (i <= 0 || j < i) {
            return false;
        }
        float f3 = i2;
        return Math.abs(f) <= f3 && Math.abs(f2) <= f3;
    }

    private gr c(float f, float f2, MotionEvent motionEvent, byte b) {
        gr.c cVar = new gr.c();
        cVar.uj(this.c);
        cVar.ve(this.tt);
        cVar.tt(f);
        cVar.c(f2);
        cVar.c(b);
        cVar.c(b == 1);
        cVar.tt(this.ve);
        cVar.c(System.currentTimeMillis());
        return cVar.c();
    }

    private gr c(tt ttVar, float f, float f2, MotionEvent motionEvent, byte b) {
        gr.c cVar = new gr.c();
        cVar.uj(ttVar.c);
        cVar.ve(ttVar.tt);
        cVar.tt(f);
        cVar.c(f2);
        cVar.c(b == 1);
        cVar.c(b);
        cVar.tt(ttVar.ve);
        cVar.c(System.currentTimeMillis());
        return cVar.c();
    }

    public void c() {
        this.sl.removeMessages(1);
        this.t.clear();
    }
}
