package com.byazt.dq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.beizi.fusion.widget.ScrollClickView;
import com.byazt.cd.x;
import com.byazt.sz.m;
import com.byazt.sz.rh;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1212, 46})
public class n {
    public m da;
    public m i;
    public c m;
    public String sl;
    public Context t;
    public boolean u;
    public boolean yp;
    public boolean z;
    public int c = 0;
    public int tt = Integer.MAX_VALUE;
    public int ve = Integer.MAX_VALUE;
    public AtomicBoolean uj = new AtomicBoolean(true);
    public float n = Float.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28419a = Float.MIN_VALUE;
    public Map<Integer, Float> sp = new HashMap();
    public Map<Integer, Float> x = new HashMap();

    public n(Context context, m mVar, boolean z, boolean z2, boolean z3) {
        this.t = context;
        this.i = mVar;
        this.u = z;
        this.yp = z2;
        this.z = z3;
        ve();
    }

    private void ve() {
        if (this.yp) {
            this.m = new c();
        }
        m mVar = this.i;
        if (mVar == null) {
            return;
        }
        this.c = mVar.ve().optInt("slideThreshold");
        this.sl = this.i.ve().optString("slideDirection");
        this.tt = this.i.ve().optInt("frequency", Integer.MAX_VALUE);
        this.ve = this.i.ve().optInt("effectiveDuration", Integer.MAX_VALUE);
        this.uj.get();
    }

    public void tt() {
        this.n = Float.MIN_VALUE;
        this.f28419a = Float.MIN_VALUE;
        this.sp.clear();
        this.x.clear();
    }

    public void c() {
        if (this.ve == Integer.MAX_VALUE) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.byazt.dq.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.uj.set(false);
            }
        }, this.ve);
    }

    private void c(int i) {
        this.sp.remove(Integer.valueOf(i));
        this.x.remove(Integer.valueOf(i));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:54:0x010f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0114 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x0116  */
    /* JADX WARN: Code duplicated, block: B:60:0x011f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0126  */
    private boolean tt(rh rhVar, com.byazt.xj.ve veVar, MotionEvent motionEvent, boolean z) {
        float fFloatValue;
        float fFloatValue2;
        float x;
        float y;
        int iTt;
        int iTt2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        if (actionMasked == 0) {
            this.sp.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getX(actionIndex)));
            this.x.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(actionIndex)));
            Objects.toString(this.sp.get(Integer.valueOf(pointerId)));
            Objects.toString(this.x.get(Integer.valueOf(pointerId)));
        } else {
            if (actionMasked == 1) {
                if (this.sp.containsKey(Integer.valueOf(pointerId)) && this.x.containsKey(Integer.valueOf(pointerId))) {
                    fFloatValue = this.sp.get(Integer.valueOf(pointerId)).floatValue();
                    fFloatValue2 = this.x.get(Integer.valueOf(pointerId)).floatValue();
                    x = motionEvent.getX(actionIndex);
                    y = motionEvent.getY(actionIndex);
                    if (!this.u && Math.abs(x - fFloatValue) <= 10.0f && Math.abs(y - fFloatValue2) <= 10.0f && rhVar != null) {
                        c(pointerId);
                        rhVar.c(this.da, veVar, veVar);
                        return true;
                    }
                    if (this.c != 0 && rhVar != null) {
                        c(pointerId);
                        c(rhVar, this.i, veVar);
                        return true;
                    }
                    iTt = x.tt(this.t, x - fFloatValue);
                    iTt2 = x.tt(this.t, y - fFloatValue2);
                    if (TextUtils.equals(this.sl, ScrollClickView.DIR_UP)) {
                        iTt = -iTt2;
                    } else if (!TextUtils.equals(this.sl, ScrollClickView.DIR_DOWN)) {
                        iTt = iTt2;
                    } else if (TextUtils.equals(this.sl, "left")) {
                        iTt = -iTt;
                    } else if (!TextUtils.equals(this.sl, "right")) {
                        iTt = (int) Math.abs(Math.sqrt(Math.pow(iTt, 2.0d) + Math.pow(iTt2, 2.0d)));
                    }
                    if (iTt >= this.c) {
                        c(pointerId);
                        c(veVar);
                    } else if (rhVar != null) {
                        c(pointerId);
                        c(rhVar, this.i, veVar);
                        return true;
                    }
                }
                return false;
            }
            if (actionMasked == 3) {
                for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                    int pointerId2 = motionEvent.getPointerId(i);
                    if (this.sp.containsKey(Integer.valueOf(pointerId2)) && this.x.containsKey(Integer.valueOf(pointerId2))) {
                        c(pointerId2);
                    }
                }
                return false;
            }
            if (actionMasked == 5) {
                this.sp.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getX(actionIndex)));
                this.x.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(actionIndex)));
                Objects.toString(this.sp.get(Integer.valueOf(pointerId)));
                Objects.toString(this.x.get(Integer.valueOf(pointerId)));
            } else if (actionMasked == 6) {
                if (this.sp.containsKey(Integer.valueOf(pointerId))) {
                    fFloatValue = this.sp.get(Integer.valueOf(pointerId)).floatValue();
                    fFloatValue2 = this.x.get(Integer.valueOf(pointerId)).floatValue();
                    x = motionEvent.getX(actionIndex);
                    y = motionEvent.getY(actionIndex);
                    if (!this.u) {
                    }
                    if (this.c != 0) {
                    }
                    iTt = x.tt(this.t, x - fFloatValue);
                    iTt2 = x.tt(this.t, y - fFloatValue2);
                    if (TextUtils.equals(this.sl, ScrollClickView.DIR_UP)) {
                        iTt = -iTt2;
                    } else if (!TextUtils.equals(this.sl, ScrollClickView.DIR_DOWN)) {
                        iTt = iTt2;
                    } else if (TextUtils.equals(this.sl, "left")) {
                        iTt = -iTt;
                    } else if (!TextUtils.equals(this.sl, "right")) {
                        iTt = (int) Math.abs(Math.sqrt(Math.pow(iTt, 2.0d) + Math.pow(iTt2, 2.0d)));
                    }
                    if (iTt >= this.c) {
                        c(pointerId);
                        c(veVar);
                    } else if (rhVar != null) {
                        c(pointerId);
                        c(rhVar, this.i, veVar);
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean c(rh rhVar, com.byazt.xj.ve veVar, MotionEvent motionEvent, boolean z) {
        c cVar = this.m;
        if (cVar != null) {
            if (cVar.c(motionEvent)) {
                return false;
            }
            this.m.c(veVar, motionEvent);
        }
        if (this.z) {
            return tt(rhVar, veVar, motionEvent, z);
        }
        return ve(rhVar, veVar, motionEvent, z);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0030  */
    /* JADX WARN: Code duplicated, block: B:36:0x008c  */
    /* JADX WARN: Code duplicated, block: B:37:0x008e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0098  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:45:0x00af  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00da  */
    private boolean ve(rh rhVar, com.byazt.xj.ve veVar, MotionEvent motionEvent, boolean z) {
        float x;
        float y;
        int iTt;
        int iTt2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.n = motionEvent.getX();
            this.f28419a = motionEvent.getY();
        } else if (action == 1) {
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (!this.u && Math.abs(x - this.n) <= 10.0f && Math.abs(y - this.f28419a) <= 10.0f && rhVar != null) {
                tt();
                rhVar.c(this.da, veVar, veVar);
                return true;
            }
            if (this.c != 0 && rhVar != null) {
                tt();
                c(rhVar, this.i, veVar);
                return true;
            }
            iTt = x.tt(this.t, x - this.n);
            iTt2 = x.tt(this.t, y - this.f28419a);
            if (TextUtils.equals(this.sl, ScrollClickView.DIR_UP)) {
                iTt = -iTt2;
            } else if (!TextUtils.equals(this.sl, ScrollClickView.DIR_DOWN)) {
                iTt = iTt2;
            } else if (TextUtils.equals(this.sl, "left")) {
                iTt = -iTt;
            } else if (!TextUtils.equals(this.sl, "right")) {
                iTt = (int) Math.abs(Math.sqrt(Math.pow(iTt, 2.0d) + Math.pow(iTt2, 2.0d)));
            }
            if (iTt >= this.c) {
                tt();
                c(veVar);
                return false;
            }
            if (rhVar != null) {
                tt();
                c(rhVar, this.i, veVar);
                return true;
            }
            tt();
        } else if (action == 3) {
            if (this.n == Float.MIN_VALUE || this.f28419a == Float.MIN_VALUE) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            if (motionEvent.getRawY() != 0.0f || rawX != 0.0f) {
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (!this.u) {
                }
                if (this.c != 0) {
                }
                iTt = x.tt(this.t, x - this.n);
                iTt2 = x.tt(this.t, y - this.f28419a);
                if (TextUtils.equals(this.sl, ScrollClickView.DIR_UP)) {
                    iTt = -iTt2;
                } else if (!TextUtils.equals(this.sl, ScrollClickView.DIR_DOWN)) {
                    iTt = iTt2;
                } else if (TextUtils.equals(this.sl, "left")) {
                    iTt = -iTt;
                } else if (!TextUtils.equals(this.sl, "right")) {
                    iTt = (int) Math.abs(Math.sqrt(Math.pow(iTt, 2.0d) + Math.pow(iTt2, 2.0d)));
                }
                if (iTt >= this.c) {
                    tt();
                    c(veVar);
                    return false;
                }
                if (rhVar != null) {
                    tt();
                    c(rhVar, this.i, veVar);
                    return true;
                }
                tt();
            }
        }
        return true;
    }

    private void c(com.byazt.xj.ve veVar) {
        c cVar = this.m;
        if (cVar != null) {
            cVar.c(veVar);
        }
    }

    private void c(rh rhVar, m mVar, com.byazt.xj.ve veVar) {
        if (this.tt <= 0) {
            c(veVar);
            return;
        }
        if (!this.uj.get()) {
            c(veVar);
            return;
        }
        rhVar.c(mVar, veVar, veVar);
        int i = this.tt;
        if (i != Integer.MAX_VALUE) {
            this.tt = i - 1;
        }
    }

    public n(Context context, m mVar, m mVar2, boolean z, boolean z2, boolean z3) {
        this.t = context;
        this.i = mVar;
        this.da = mVar2;
        this.u = z;
        this.yp = z2;
        this.z = z3;
        ve();
    }
}
