package com.kc.dw.platform.ad_adapter.splash;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.t0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ShakeUtil {
    public SensorManager c;
    public float e;
    public String h;
    public long i;
    public int indexLocal;
    public SsdAdInfo.DClickData j;
    public Sensor k;
    public Sensor l;
    public Sensor m;
    public List<com.kc.dw.platform.ad_adapter.splash.b> w;
    public List<com.kc.dw.platform.ad_adapter.splash.b> x;
    public List<com.kc.dw.platform.ad_adapter.splash.b> y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39541a = 1;
    public long b = 500;
    public boolean d = false;
    public float[] f = new float[3];
    public List<com.kc.dw.platform.ad_adapter.splash.a> g = new ArrayList();
    public SensorEventListener n = new a(this);
    public float o = 0.0f;
    public float p = 0.0f;
    public float q = 0.0f;
    public float r = 0.0f;
    public float s = 0.0f;
    public float t = 0.0f;
    public final float[] u = new float[3];
    public int v = 0;

    @Keep
    public class a implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ShakeUtil f39542a;

        public a(ShakeUtil shakeUtil) {
            this.f39542a = shakeUtil;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            try {
                if (sensorEvent.sensor.getType() == 4) {
                    ShakeUtil shakeUtil = this.f39542a;
                    shakeUtil.getClass();
                    try {
                        float f = shakeUtil.e;
                        if (f != 0.0f && shakeUtil.d) {
                            float f2 = sensorEvent.timestamp;
                            if ((f2 - f) * 1.0E-9f >= 10.0f) {
                                shakeUtil.e = f2;
                            }
                            float f3 = shakeUtil.e;
                            float[] fArr = sensorEvent.values;
                            shakeUtil.a(fArr[0], fArr[1], fArr[2], (f2 - f3) * 1.0E-9f);
                        }
                        shakeUtil.e = sensorEvent.timestamp;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                if (sensorEvent.sensor.getType() == 1 || sensorEvent.sensor.getType() == 4 || sensorEvent.sensor.getType() == 9) {
                    ShakeUtil.a(this.f39542a, sensorEvent);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Keep
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ShakeUtil f39543a = new ShakeUtil();
    }

    @Keep
    public interface c {
        void onShake(int i, boolean z, int i2, ShakeResult shakeResult);
    }

    public ShakeUtil() {
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.y = new ArrayList();
    }

    public static void a(ShakeUtil shakeUtil, SensorEvent sensorEvent) {
        shakeUtil.getClass();
        try {
            if (shakeUtil.d) {
                int type = sensorEvent.sensor.getType();
                if (type != 1) {
                    if (type != 4) {
                        if (type != 9) {
                            return;
                        }
                        float[] fArr = sensorEvent.values;
                        shakeUtil.r = fArr[0];
                        shakeUtil.s = fArr[1];
                        shakeUtil.t = fArr[2];
                        return;
                    }
                    for (com.kc.dw.platform.ad_adapter.splash.a aVar : shakeUtil.g) {
                        int i = aVar.f;
                        if (i == 1 || i == 3 || i == 4 || i == 5) {
                            if (aVar.g && aVar.h == 1 && aVar.b != null && (i == 4 || i == 5)) {
                                if (aVar.s) {
                                    float[] fArr2 = sensorEvent.values;
                                    float f = fArr2[0];
                                    float f2 = fArr2[1];
                                    float f3 = fArr2[2];
                                    if (Math.abs(f) > 2.0f || Math.abs(f2) > 2.0f || Math.abs(f3) > 2.0f) {
                                        shakeUtil.w.add(new com.kc.dw.platform.ad_adapter.splash.b(f, f2, f3, System.currentTimeMillis()));
                                    }
                                }
                            }
                        }
                    }
                    return;
                }
                float[] fArr3 = sensorEvent.values;
                float f4 = fArr3[0];
                shakeUtil.o = f4;
                float f5 = fArr3[1];
                shakeUtil.p = f5;
                float f6 = fArr3[2];
                shakeUtil.q = f6;
                try {
                    float[] fArr4 = shakeUtil.u;
                    float f7 = fArr4[0];
                    if (f7 == 0.0f && fArr4[1] == 0.0f && fArr4[2] == 0.0f) {
                        fArr4[0] = f4;
                        fArr4[1] = f5;
                        fArr4[2] = f6;
                        return;
                    }
                    shakeUtil.v = 0;
                    if (f7 == f4) {
                        shakeUtil.v = 1;
                    }
                    if (fArr4[1] == f5) {
                        shakeUtil.v++;
                    }
                    if (fArr4[2] == f6) {
                        shakeUtil.v++;
                    }
                    if (shakeUtil.v >= 2) {
                        fArr4[0] = f4;
                        fArr4[1] = f5;
                        fArr4[2] = f6;
                        return;
                    }
                    fArr4[0] = f4;
                    fArr4[1] = f5;
                    fArr4[2] = f6;
                    float f8 = f4 - shakeUtil.r;
                    float f9 = f5 - shakeUtil.s;
                    float f10 = f6 - shakeUtil.t;
                    double dSqrt = Math.sqrt((f10 * f10) + (f9 * f9) + (f8 * f8));
                    if ((shakeUtil.r == 0.0f && shakeUtil.s == 0.0f && shakeUtil.t == 0.0f) || (shakeUtil.o == 0.0f && shakeUtil.p == 0.0f && shakeUtil.q == 0.0f)) {
                        dSqrt -= 9.8d;
                    }
                    double dAtan = (dSqrt * 100.0d) / 30.0d;
                    if (80.0d < dAtan) {
                        dAtan = (((Math.atan((dAtan - 80.0d) / 30.0d) * 20.0d) * 2.0d) / 3.141592653589793d) + 80.0d;
                    }
                    shakeUtil.a(dAtan, shakeUtil.o, shakeUtil.p, shakeUtil.q, sensorEvent);
                } catch (Throwable th) {
                    float[] fArr5 = shakeUtil.u;
                    float[] fArr6 = sensorEvent.values;
                    fArr5[0] = fArr6[0];
                    fArr5[1] = fArr6[1];
                    fArr5[2] = fArr6[2];
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ShakeUtil getInstance() {
        return b.f39543a;
    }

    public void a() {
        this.d = false;
        float[] fArr = this.f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        this.e = 0.0f;
        List<com.kc.dw.platform.ad_adapter.splash.b> list = this.w;
        if (list != null) {
            list.clear();
        }
        List<com.kc.dw.platform.ad_adapter.splash.b> list2 = this.y;
        if (list2 != null) {
            list2.clear();
        }
        List<com.kc.dw.platform.ad_adapter.splash.b> list3 = this.x;
        if (list3 != null) {
            list3.clear();
        }
        SensorManager sensorManager = this.c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.n);
            this.c = null;
            this.l = null;
            this.m = null;
            this.k = null;
        }
        List<com.kc.dw.platform.ad_adapter.splash.a> list4 = this.g;
        if (list4 != null) {
            list4.clear();
        }
        float[] fArr2 = this.u;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 0.0f;
    }

    public final void a(double d, float f, float f2, float f3, SensorEvent sensorEvent) {
        try {
            List<com.kc.dw.platform.ad_adapter.splash.a> list = this.g;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (com.kc.dw.platform.ad_adapter.splash.a aVar : this.g) {
                int i = aVar.f;
                if (i == 1 || i == 3 || i == 4 || i == 5 || i == 7) {
                    if (aVar.g && aVar.h == 1 && aVar.b != null) {
                        if (i == 4 || i == 5) {
                            long j = p0.j;
                            if (j <= 0) {
                                j = 2000;
                            }
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            if (jCurrentTimeMillis - aVar.u > j) {
                                this.w.clear();
                                this.x.clear();
                                aVar.t = false;
                                aVar.s = false;
                            }
                            if (!aVar.s) {
                                if (d < aVar.d) {
                                    return;
                                }
                                aVar.s = true;
                                aVar.u = jCurrentTimeMillis;
                            }
                            if (!aVar.t) {
                                if (c() || a(f, f2, f3)) {
                                    aVar.t = true;
                                    this.w.clear();
                                    this.x.clear();
                                    return;
                                }
                                return;
                            }
                            if (d >= aVar.e) {
                                aVar.c();
                                if (aVar.n > aVar.m) {
                                    a(aVar, false, (int) d, f, f2, f3);
                                }
                            } else if (aVar.a() && d >= aVar.o) {
                                aVar.c();
                                if (aVar.n > aVar.m) {
                                    a(aVar, true, (int) d, f, f2, f3);
                                }
                            }
                            this.x.clear();
                            this.w.clear();
                        } else if (d >= aVar.d) {
                            aVar.c();
                            if (aVar.n > aVar.m) {
                                a(aVar, false, (int) d, f, f2, f3);
                            }
                        } else if (aVar.a() && d >= aVar.o) {
                            aVar.c();
                            if (aVar.n > aVar.m) {
                                a(aVar, true, (int) d, f, f2, f3);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(float f, float f2, float f3, float f4) {
        float f5;
        boolean z;
        float degrees;
        float degrees2;
        float degrees3;
        boolean z2;
        boolean z3;
        List<com.kc.dw.platform.ad_adapter.splash.a> list = this.g;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.kc.dw.platform.ad_adapter.splash.a aVar : this.g) {
            int i = aVar.f;
            if (i == 2 || i == 3 || i == 5 || i == 6 || i == 7 || i == 8) {
                if (aVar.g && aVar.h == 1 && aVar.b != null) {
                    double d = aVar.q;
                    if (i == 6 || i == 7 || i == 8) {
                        long j = p0.j;
                        if (j <= 0) {
                            j = 3000;
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - aVar.u > j) {
                            this.y.clear();
                            aVar.u = jCurrentTimeMillis;
                            aVar.t = false;
                            aVar.s = false;
                            float[] fArr = this.f;
                            fArr[0] = 0.0f;
                            fArr[1] = 0.0f;
                            fArr[2] = 0.0f;
                        }
                        float[] fArr2 = this.f;
                        float f6 = (f * f4) + fArr2[0];
                        fArr2[0] = f6;
                        if (f6 * f < 0.0f) {
                            fArr2[0] = 0.0f;
                        }
                        float f7 = (f2 * f4) + fArr2[1];
                        fArr2[1] = f7;
                        if (f7 * f2 < 0.0f) {
                            fArr2[1] = 0.0f;
                        }
                        float f8 = (f3 * f4) + fArr2[2];
                        fArr2[2] = f8;
                        if (f8 * f3 < 0.0f) {
                            fArr2[2] = 0.0f;
                        }
                        float degrees4 = (float) Math.toDegrees(fArr2[0]);
                        float degrees5 = (float) Math.toDegrees(this.f[1]);
                        float degrees6 = (float) Math.toDegrees(this.f[2]);
                        aVar.a();
                        double d2 = aVar.q;
                        double d3 = aVar.e;
                        if (Math.abs(degrees4) > 2.0f || Math.abs(degrees5) > 2.0f || Math.abs(degrees6) > 2.0f) {
                            this.y.add(new com.kc.dw.platform.ad_adapter.splash.b(degrees4, degrees5, degrees6, System.currentTimeMillis()));
                        }
                        if (this.y.isEmpty()) {
                            degrees5 = degrees5;
                            f5 = degrees6;
                            z = false;
                        } else {
                            long j2 = p0.j;
                            long j3 = j2 > 0 ? j2 : 3000L;
                            Iterator<com.kc.dw.platform.ad_adapter.splash.b> it = this.y.iterator();
                            double d4 = d2;
                            double d5 = d4;
                            int i2 = 0;
                            int i3 = 0;
                            int i4 = 0;
                            while (true) {
                                if (it.hasNext()) {
                                    com.kc.dw.platform.ad_adapter.splash.b next = it.next();
                                    degrees5 = degrees5;
                                    if (System.currentTimeMillis() - next.d > j3) {
                                        it.remove();
                                    } else {
                                        float f9 = next.f39545a;
                                        float f10 = next.b;
                                        float f11 = next.c;
                                        f5 = degrees6;
                                        if (Math.abs(f9) > d2) {
                                            i2 = f9 > 0.0f ? i2 | 1 : i2 | 2;
                                            d2 = d3;
                                        }
                                        if (Math.abs(f10) > d4) {
                                            i3 = f10 > 0.0f ? i3 | 1 : i3 | 2;
                                            d4 = d3;
                                        }
                                        int i5 = i3;
                                        if (Math.abs(f11) > d5) {
                                            z2 = false;
                                            i4 = f11 > 0.0f ? i4 | 1 : i4 | 2;
                                            d5 = d3;
                                        } else {
                                            z2 = false;
                                        }
                                        int i6 = i4;
                                        if (i2 == 3 || i5 == 3 || i6 == 3) {
                                            z = true;
                                        } else {
                                            i3 = i5;
                                            i4 = i6;
                                            degrees6 = f5;
                                        }
                                    }
                                } else {
                                    degrees5 = degrees5;
                                    f5 = degrees6;
                                    z = false;
                                }
                            }
                        }
                        if (!z) {
                            return;
                        }
                        d = aVar.e;
                        this.y.clear();
                        degrees = degrees4;
                        degrees2 = f5;
                        degrees3 = degrees5;
                    } else {
                        float[] fArr3 = this.f;
                        float f12 = (f * f4) + fArr3[0];
                        fArr3[0] = f12;
                        fArr3[1] = (f2 * f4) + fArr3[1];
                        fArr3[2] = (f3 * f4) + fArr3[2];
                        degrees = (float) Math.toDegrees(f12);
                        degrees3 = (float) Math.toDegrees(this.f[1]);
                        degrees2 = (float) Math.toDegrees(this.f[2]);
                    }
                    int iMax = Math.max((int) Math.abs(degrees), Math.max((int) Math.abs(degrees3), (int) Math.abs(degrees2)));
                    double d6 = iMax;
                    if (d6 >= d) {
                        aVar.c();
                        if (aVar.n > aVar.m) {
                            z3 = false;
                            b(aVar, z3, (iMax * 100) / 90, degrees, degrees3, degrees2);
                        }
                    } else if (aVar.a()) {
                        if (d6 >= aVar.p) {
                            aVar.c();
                        }
                        if (aVar.n > aVar.m) {
                            d();
                            z3 = true;
                            b(aVar, z3, (iMax * 100) / 90, degrees, degrees3, degrees2);
                        }
                    }
                }
            }
        }
    }

    public void a(int i) {
        List<com.kc.dw.platform.ad_adapter.splash.a> list = this.g;
        if (list == null || list.size() == 0) {
            a();
            return;
        }
        Iterator<com.kc.dw.platform.ad_adapter.splash.a> it = this.g.iterator();
        while (it.hasNext()) {
            if (i == it.next().f39544a) {
                it.remove();
            }
        }
        SdkHandler.getInstance().postDelay(new d(this), 1000L);
    }

    public void a(int i, int i2, int i3, long j, int i4, int i5, int i6, c cVar) {
        try {
            com.kc.dw.base.a.getContext();
            this.b = j;
            float[] fArr = this.f;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            float[] fArr2 = this.u;
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0.0f;
            this.r = 0.0f;
            this.s = 0.0f;
            this.t = 0.0f;
            this.f39541a = i3;
            com.kc.dw.platform.ad_adapter.splash.a aVar = new com.kc.dw.platform.ad_adapter.splash.a();
            aVar.h = 1;
            aVar.i = this.h;
            aVar.k = this.j;
            aVar.j = this.i;
            aVar.m = i4;
            aVar.f39544a = i5;
            aVar.c = i6;
            aVar.b = cVar;
            aVar.d = i2;
            if (i2 < 1 || i2 > 100) {
                aVar.d = 50;
                aVar.q = 20.0d;
            } else {
                double d = (((double) i2) * 90.0d) / 100.0d;
                aVar.q = d;
                if (d < 2.0d) {
                    aVar.q = 2.0d;
                }
            }
            if (i <= 0 || i > 100) {
                i = aVar.d;
            }
            aVar.e = i;
            aVar.f = i3;
            aVar.g = true;
            aVar.b();
            this.g.add(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i, boolean z) {
        List<com.kc.dw.platform.ad_adapter.splash.a> list = this.g;
        if (list == null || list.size() == 0) {
            return;
        }
        boolean z2 = true;
        for (com.kc.dw.platform.ad_adapter.splash.a aVar : this.g) {
            if (i == aVar.f39544a) {
                aVar.g = z;
            }
            if (aVar.g) {
                z2 = false;
            }
        }
        if (z2) {
            e();
        } else {
            f();
        }
        SdkHandler.getInstance().postDelay(new d(this), 1000L);
    }

    public final void a(com.kc.dw.platform.ad_adapter.splash.a aVar, boolean z, int i, float f, float f2, float f3) {
        if (z) {
            try {
                d();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.d = false;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        ShakeResult shakeResult = new ShakeResult();
        shakeResult.setShakeX(f);
        shakeResult.setShakeY(f2);
        shakeResult.setShakeZ(f3);
        int i2 = aVar.f;
        if (i2 == 4 || i2 == 5) {
            aVar.b.onShake(64, z, i, shakeResult);
        } else {
            aVar.b.onShake(4, z, i, shakeResult);
        }
        this.g.remove(aVar);
    }

    public void a(String str, long j, SsdAdInfo.DClickData dClickData) {
        this.h = str;
        this.i = j;
        this.j = dClickData;
    }

    public void a(boolean z) {
        this.d = z;
        try {
            new Handler().postDelayed(new com.kc.dw.platform.ad_adapter.splash.c(this), this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean a(float f, float f2, float f3) {
        float fAcos;
        if (this.x.size() == 0) {
            this.x.add(new com.kc.dw.platform.ad_adapter.splash.b(f - this.r, f2 - this.s, f3 - this.t, System.currentTimeMillis()));
        } else {
            List<com.kc.dw.platform.ad_adapter.splash.b> list = this.x;
            com.kc.dw.platform.ad_adapter.splash.b bVar = list.get(list.size() - 1);
            float f4 = bVar.f39545a;
            float f5 = bVar.b;
            float f6 = bVar.c;
            float f7 = f - this.r;
            float f8 = f2 - this.s;
            float f9 = f3 - this.t;
            if ((Math.abs(f4) >= 2.0f || Math.abs(f5) >= 2.0f || Math.abs(f6) >= 2.0f) && (Math.abs(f7) >= 2.0f || Math.abs(f8) >= 2.0f || Math.abs(f9) >= 2.0f)) {
                fAcos = (float) (Math.acos(((double) ((f6 * f9) + ((f5 * f8) + (f7 * f4)))) / (Math.sqrt(Math.pow(f6, 2.0d) + (Math.pow(f5, 2.0d) + Math.pow(f4, 2.0d))) * Math.sqrt(Math.pow(f9, 2.0d) + (Math.pow(f8, 2.0d) + Math.pow(f7, 2.0d))))) * 57.29577951308232d);
            } else {
                fAcos = 0.0f;
            }
            if (fAcos > 60.0f) {
                this.x.add(new com.kc.dw.platform.ad_adapter.splash.b(f - this.r, f2 - this.s, f3 - this.t, System.currentTimeMillis()));
            }
        }
        long j = p0.j;
        if (j <= 0) {
            j = 2000;
        }
        if (this.x.size() <= 0) {
            return false;
        }
        Iterator<com.kc.dw.platform.ad_adapter.splash.b> it = this.x.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (System.currentTimeMillis() - it.next().d > j) {
                it.remove();
            } else {
                i++;
            }
        }
        return i >= 5;
    }

    public int b() {
        return (int) (((Math.random() * 9.0d) + 1.0d) * 1.0E7d);
    }

    public final void b(com.kc.dw.platform.ad_adapter.splash.a aVar, boolean z, int i, float f, float f2, float f3) {
        try {
            this.d = false;
            this.e = 0.0f;
            float[] fArr = this.f;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            ShakeResult shakeResult = new ShakeResult();
            shakeResult.setTurnX(f);
            shakeResult.setTurnY(f2);
            shakeResult.setTurnZ(f3);
            int i2 = aVar.f;
            if (i2 == 6 || i2 == 7 || i2 == 8) {
                aVar.b.onShake(256, z, i, shakeResult);
            } else {
                aVar.b.onShake(8, z, i, shakeResult);
            }
            this.g.remove(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean c() {
        float f;
        try {
            float fMax = 0.0f;
            float fMax2 = 0.0f;
            float fMax3 = 0.0f;
            for (com.kc.dw.platform.ad_adapter.splash.b bVar : this.w) {
                fMax = Math.max(fMax, Math.abs(bVar.f39545a));
                fMax2 = Math.max(fMax2, Math.abs(bVar.b));
                fMax3 = Math.max(fMax3, Math.abs(bVar.c));
            }
            char c2 = (fMax < fMax2 || fMax < fMax3) ? (fMax2 < fMax || fMax2 < fMax3) ? 'Z' : 'Y' : 'X';
            boolean z = false;
            boolean z2 = false;
            for (com.kc.dw.platform.ad_adapter.splash.b bVar2 : this.w) {
                switch (c2) {
                    case 'X':
                        f = bVar2.f39545a;
                        break;
                    case 'Y':
                        f = bVar2.b;
                        break;
                    case 'Z':
                        f = bVar2.c;
                        break;
                    default:
                        f = 0.0f;
                        break;
                }
                if (f > 0.0f) {
                    z = true;
                }
                if (f < 0.0f) {
                    z2 = true;
                }
                if (z && z2) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public final void d() {
        t0.a aVar = t0.f39405a.get(this.h + this.i);
        if (aVar != null) {
            if (!aVar.b) {
            }
            t0.f39405a.put(this.h + this.i, aVar);
        }
        aVar = new t0.a();
        aVar.f39406a = true;
        t0.a(this.h, 5);
        t0.a(this.h, 7);
        t0.f39405a.put(this.h + this.i, aVar);
    }

    public void e() {
        SensorManager sensorManager = this.c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.n);
        }
    }

    public void f() {
        try {
            SensorManager sensorManager = this.c;
            if (sensorManager != null) {
                this.c.registerListener(this.n, sensorManager.getDefaultSensor(4), 2);
                this.c.registerListener(this.n, this.c.getDefaultSensor(9), 1);
                this.c.registerListener(this.n, this.c.getDefaultSensor(1), 2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
