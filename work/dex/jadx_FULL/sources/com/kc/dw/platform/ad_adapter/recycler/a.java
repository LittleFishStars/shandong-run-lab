package com.kc.dw.platform.ad_adapter.recycler;

import android.view.MotionEvent;
import android.view.View;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements View.OnTouchListener {
    public static final String j = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f39486a;
    public final List<View> b;
    public float c;
    public float d;
    public float e;
    public float f;
    public int g;
    public long h;
    public int i;

    public a(View view, int i) {
        this(view, i, null);
    }

    public a(View view, int i, List<View> list) {
        this.f39486a = view;
        this.i = i;
        this.b = list;
    }

    public void a(float f, float f2, long j2, float f3, float f4, int i) {
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00b3 A[Catch: Exception -> 0x012d, TryCatch #0 {Exception -> 0x012d, blocks: (B:9:0x003b, B:11:0x0042, B:13:0x0050, B:15:0x0056, B:43:0x00ad, B:46:0x00b3, B:47:0x00d4, B:49:0x00da, B:51:0x0110, B:53:0x0116, B:55:0x011c, B:17:0x0062, B:20:0x0069, B:21:0x006d, B:23:0x0073, B:25:0x007a, B:27:0x0083, B:38:0x00a4), top: B:62:0x003b, inners: #2 }] */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        View view2 = this.f39486a;
        if (view2 != null && this.i > 0) {
            try {
                this.f39486a.dispatchTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getX() - view2.getLeft(), motionEvent.getY() - view2.getTop(), motionEvent.getMetaState()));
                try {
                    if (motionEvent.getAction() == 0) {
                        this.c = 0.0f;
                        this.d = 0.0f;
                        this.e = 0.0f;
                        this.f = 0.0f;
                        this.g = 0;
                        List<View> list = this.b;
                        if (list == null || list.isEmpty()) {
                            this.c = motionEvent.getX();
                            this.d = motionEvent.getY();
                            this.e = motionEvent.getRawX();
                            this.f = motionEvent.getRawY();
                            this.g = 0;
                            this.h = System.currentTimeMillis();
                        } else {
                            List<View> list2 = this.b;
                            float rawX = motionEvent.getRawX();
                            float rawY = motionEvent.getRawY();
                            if (list2 == null) {
                                z2 = false;
                                break;
                            }
                            try {
                                if (!list2.isEmpty()) {
                                    Iterator<View> it = list2.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            View next = it.next();
                                            try {
                                                int[] iArr = new int[2];
                                                next.getLocationOnScreen(iArr);
                                                int i = iArr[0];
                                                int i2 = iArr[1];
                                                z = rawX >= ((float) i) && rawX <= ((float) (next.getWidth() + i)) && rawY >= ((float) i2) && rawY <= ((float) (next.getHeight() + i2));
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            if (z) {
                                                z2 = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            z2 = false;
                            break;
                            if (z2) {
                                this.c = motionEvent.getX();
                                this.d = motionEvent.getY();
                                this.e = motionEvent.getRawX();
                                this.f = motionEvent.getRawY();
                                this.g = 0;
                                this.h = System.currentTimeMillis();
                            }
                        }
                    } else if (motionEvent.getAction() == 1) {
                        float f = this.f39486a.getContext().getResources().getDisplayMetrics().density;
                        int iMax = (int) Math.max(Math.abs(this.e - motionEvent.getRawX()), Math.abs(this.f - motionEvent.getRawY()));
                        this.g = iMax;
                        if (iMax / f > this.i) {
                            float f2 = this.c;
                            if (f2 > 0.0f) {
                                float f3 = this.d;
                                if (f3 > 0.0f) {
                                    a(f2, f3, this.h, motionEvent.getX(), motionEvent.getY(), this.g);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                    LogUtil.dev(j, e2);
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
