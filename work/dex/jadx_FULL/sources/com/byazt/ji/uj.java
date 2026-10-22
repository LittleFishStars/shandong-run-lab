package com.byazt.ji;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.widget.ScrollClickView;
import com.byazt.pm.u;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 222, 15})
public class uj extends tt {
    public AtomicBoolean m;
    public u my;
    public int nu;
    public String rh;
    public float sl;
    public float t;
    public int u;
    public AtomicInteger yp;
    public int z;

    public uj(Context context) {
        super(context);
        this.u = 0;
        this.yp = new AtomicInteger(Integer.MAX_VALUE);
        this.z = Integer.MAX_VALUE;
        this.m = new AtomicBoolean(true);
        this.nu = 0;
        this.rh = ScrollClickView.DIR_UP;
    }

    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        Object obj;
        Object obj2;
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        Map<String, Object> map = this.n;
        if (map != null) {
            Object obj3 = map.get(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
            String strValueOf = "all";
            if (obj3 != null && !TextUtils.isEmpty(String.valueOf(obj3))) {
                strValueOf = String.valueOf(obj3);
            }
            this.rh = strValueOf;
            Object obj4 = this.n.get(SchoolActivitySuccessActivity.x);
            if (obj4 == null) {
                this.u = 0;
            } else {
                this.u = com.byazt.cd.ve.c(String.valueOf(obj4), 0);
            }
            if (this.yp.get() == Integer.MAX_VALUE && (obj2 = this.n.get("frequency")) != null) {
                this.yp.set(com.byazt.cd.ve.c(String.valueOf(obj2), Integer.MAX_VALUE));
            }
            if (this.z == Integer.MAX_VALUE && (obj = this.n.get("effectiveDuration")) != null) {
                this.z = com.byazt.cd.ve.c(String.valueOf(obj), Integer.MAX_VALUE);
            }
            Object obj5 = this.n.get("inView");
            if (obj5 != null) {
                this.nu = com.byazt.cd.ve.c(String.valueOf(obj5), 0);
            }
            this.m.get();
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        c();
        u uVar = this.my;
        return uVar != null ? uVar.c(this.tt, motionEvent, this.c, this, this.rh, this.u, this.yp, this.nu, this.m.get()) : c(this.tt, motionEvent);
    }

    private void c() {
        if (this.z == Integer.MAX_VALUE || this.tt == null || System.currentTimeMillis() - this.tt.gu() < this.z) {
            return;
        }
        this.m.set(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0054  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0066  */
    /* JADX WARN: Code duplicated, block: B:27:0x0068  */
    /* JADX WARN: Code duplicated, block: B:29:0x0070  */
    /* JADX WARN: Code duplicated, block: B:30:0x0072  */
    /* JADX WARN: Code duplicated, block: B:32:0x007a  */
    /* JADX WARN: Code duplicated, block: B:33:0x007c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0084  */
    /* JADX WARN: Code duplicated, block: B:36:0x0086  */
    /* JADX WARN: Code duplicated, block: B:38:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x008f  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00af  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00bc A[RETURN] */
    private boolean c(com.byazt.xj.ve veVar, MotionEvent motionEvent) {
        float x;
        float y;
        int iTt;
        int iTt2;
        byte b;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.sl = motionEvent.getX();
            this.t = motionEvent.getY();
        } else if (action == 1) {
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (this.u != 0 && this.c != null) {
                return c(veVar, x, y);
            }
            iTt = com.byazt.cd.x.tt(this.da, x - this.sl);
            iTt2 = com.byazt.cd.x.tt(this.da, y - this.t);
            switch (this.rh) {
                case "up":
                    b = 0;
                    break;
                case "all":
                    b = 4;
                    break;
                case "down":
                    b = 1;
                    break;
                case "left":
                    b = 2;
                    break;
                case "right":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b != 0) {
                iTt = -iTt2;
            } else if (b != 1) {
                iTt = iTt2;
            } else if (b != 2) {
                iTt = -iTt;
            } else if (b != 3) {
                iTt = (int) Math.abs(Math.sqrt(Math.pow(iTt, 2.0d) + Math.pow(iTt2, 2.0d)));
            }
            if (iTt >= this.u) {
                return false;
            }
            if (this.c != null) {
                this.sl = 0.0f;
                this.t = 0.0f;
                return c(veVar, x, y);
            }
        } else if (action == 3) {
            float rawX = motionEvent.getRawX();
            if (motionEvent.getRawY() != 0.0f || rawX != 0.0f) {
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (this.u != 0) {
                }
                iTt = com.byazt.cd.x.tt(this.da, x - this.sl);
                iTt2 = com.byazt.cd.x.tt(this.da, y - this.t);
                switch (this.rh) {
                    case 3739:
                        if (r6.equals(ScrollClickView.DIR_UP)) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case 96673:
                        if (r6.equals("all")) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case 3089570:
                        if (r6.equals(ScrollClickView.DIR_DOWN)) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 3317767:
                        if (r6.equals("left")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 108511772:
                        if (r6.equals("right")) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b != 0) {
                    iTt = -iTt2;
                } else if (b != 1) {
                    iTt = iTt2;
                } else if (b != 2) {
                    iTt = -iTt;
                } else if (b != 3) {
                    iTt = (int) Math.abs(Math.sqrt(Math.pow(iTt, 2.0d) + Math.pow(iTt2, 2.0d)));
                }
                if (iTt >= this.u) {
                    return false;
                }
                if (this.c != null) {
                    this.sl = 0.0f;
                    this.t = 0.0f;
                    return c(veVar, x, y);
                }
            }
        }
        return true;
    }

    private boolean c(com.byazt.xj.ve veVar, float f, float f2) {
        if (this.yp.get() <= 0 || !this.m.get()) {
            return false;
        }
        if (this.nu == 1 && !c(veVar.i(), f, f2)) {
            return false;
        }
        this.c.c(veVar, this.f28697a, this.ve.tt(), this.ve);
        if (this.yp.get() != Integer.MAX_VALUE) {
            this.yp.decrementAndGet();
        }
        return true;
    }

    private boolean c(View view, float f, float f2) {
        return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
    }

    public void c(u uVar) {
        this.my = uVar;
    }
}
