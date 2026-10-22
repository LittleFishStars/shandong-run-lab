package com.kc.dw.core.utils;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d {
    public static final int n = 0;
    public PackageBean c;
    public PackageBean d;
    public int e;
    public long f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<PackageBean.AppBean.PackBean> f39355a = new ArrayList<>();
    public final ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<>();
    public volatile boolean l = false;
    public final Object m = new Object();

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f39356a;
        public final d b;

        public a(d dVar, boolean z) {
            this.b = dVar;
            this.f39356a = z;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            if (this.b.a(this.f39356a)) {
                p0.a(com.kc.dw.base.a.getContext(), this.b.c);
            }
        }
    }

    @Keep
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f39357a = new d();
    }

    public final void a(PackageBean.AppBean appBean) {
        HashMap map;
        if (appBean == null) {
            return;
        }
        PackageBean packageBean = this.d;
        if (packageBean == null) {
            packageBean = o0.a().b;
            this.d = packageBean;
        }
        if (packageBean == null || packageBean.getApp() == null) {
            map = null;
        } else {
            map = new HashMap();
            List<PackageBean.AppBean.PackBean> required = packageBean.getApp().getRequired();
            if (required != null && !required.isEmpty()) {
                for (PackageBean.AppBean.PackBean packBean : required) {
                    if (!TextUtils.isEmpty(packBean.getId())) {
                        map.put(packBean.getId(), packBean);
                    }
                }
            }
            List<PackageBean.AppBean.PackBean> others = packageBean.getApp().getOthers();
            if (others != null && !others.isEmpty()) {
                for (PackageBean.AppBean.PackBean packBean2 : others) {
                    if (!TextUtils.isEmpty(packBean2.getId())) {
                        map.put(packBean2.getId(), packBean2);
                    }
                }
            }
        }
        if (map == null || map.isEmpty()) {
            return;
        }
        List<PackageBean.AppBean.PackBean> required2 = appBean.getRequired();
        if (required2 != null) {
            for (PackageBean.AppBean.PackBean packBean3 : required2) {
                PackageBean.AppBean.PackBean packBean4 = (PackageBean.AppBean.PackBean) map.get(packBean3.getId());
                if (packBean4 != null) {
                    packBean3.setInstalled(packBean4.getInstalled());
                    packBean3.setLastCheckTime(packBean4.getLastCheckTime());
                    packBean3.setExpirationTime(packBean4.getExpirationTime());
                }
            }
        }
        List<PackageBean.AppBean.PackBean> others2 = appBean.getOthers();
        if (others2 != null) {
            for (PackageBean.AppBean.PackBean packBean5 : others2) {
                PackageBean.AppBean.PackBean packBean6 = (PackageBean.AppBean.PackBean) map.get(packBean5.getId());
                if (packBean6 != null) {
                    packBean5.setInstalled(packBean6.getInstalled());
                    packBean5.setLastCheckTime(packBean6.getLastCheckTime());
                    packBean5.setExpirationTime(packBean6.getExpirationTime());
                }
            }
        }
    }

    public final void a(PackageBean packageBean) {
        try {
            if (packageBean != null) {
                this.c = packageBean;
                a(packageBean.getApp());
            } else {
                if (!this.f39355a.isEmpty()) {
                    return;
                }
                PackageBean packageBean2 = this.d;
                if (packageBean2 == null) {
                    packageBean2 = o0.a().b;
                    this.d = packageBean2;
                }
                if (packageBean2 == null) {
                    return;
                } else {
                    this.c = packageBean2;
                }
            }
            PackageBean packageBean3 = this.c;
            if (packageBean3 != null && packageBean3.getApp() != null) {
                Integer ttl = this.c.getApp().getTtl();
                this.e = ttl != null ? ttl.intValue() : 0;
                Integer a2 = this.c.getApp().getA();
                this.h = a2 != null ? a2.intValue() : 10;
                Integer b2 = this.c.getApp().getB();
                this.g = b2 != null ? b2.intValue() : 5;
                Integer c = this.c.getApp().getC();
                this.k = c != null ? c.intValue() : 200;
                Integer d = this.c.getApp().getD();
                this.i = d != null ? d.intValue() : com.alipay.sdk.m.j0.a.f25451a;
                Integer e = this.c.getApp().getE();
                this.j = e != null ? e.intValue() : 0;
                List<PackageBean.AppBean.PackBean> required = this.c.getApp().getRequired();
                List<PackageBean.AppBean.PackBean> others = this.c.getApp().getOthers();
                this.f39355a.clear();
                this.b.clear();
                if (required != null && !required.isEmpty()) {
                    this.f39355a.addAll(required);
                }
                if (others != null && !others.isEmpty()) {
                    this.f39355a.addAll(others);
                }
                for (PackageBean.AppBean.PackBean packBean : this.f39355a) {
                    if (packBean != null && packBean.getExpirationTime() == 0 && packBean.getLastCheckTime() > 0) {
                        packBean.setExpirationTime((((long) this.e) * 1000) + packBean.getLastCheckTime());
                    }
                    if (!TextUtils.isEmpty(packBean.getId()) && (packBean.getLastCheckTime() > 0 || packBean.getExpirationTime() > 0)) {
                        this.b.put(packBean.getId(), Boolean.valueOf(packBean.getInstalled()));
                    }
                }
                ArrayList<PackageBean.AppBean.PackBean> arrayList = this.f39355a;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Collections.sort(arrayList, new e(this));
                    return;
                }
                return;
            }
            this.f39355a.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(boolean z, boolean z2) {
        if (z) {
            ExecutorService executorService = f0.f39362a;
            f0.b.f39363a.a(new a(this, z2));
        } else if (a(z2)) {
            p0.a(com.kc.dw.base.a.getContext(), this.c);
        }
    }

    public final boolean a(boolean z) {
        try {
            if (this.f39355a.isEmpty()) {
                synchronized (this.m) {
                    a((PackageBean) null);
                }
            }
            if (this.f39355a.isEmpty()) {
                LogUtil.d("d", "finalList is empty");
                this.l = false;
                return false;
            }
            if (System.currentTimeMillis() - this.f < this.i) {
                LogUtil.d("d", "time interval too close");
                this.l = false;
                return false;
            }
            int i = z ? this.h : this.g;
            if (i <= 0) {
                LogUtil.e("d", "no check PackBean. isInit:" + z);
                this.l = false;
                return false;
            }
            if (this.l) {
                LogUtil.e("d", "isChecking. no check PackBean.");
                this.l = false;
                return false;
            }
            this.l = true;
            ArrayList<PackageBean.AppBean.PackBean> arrayList = this.f39355a;
            if (arrayList != null && !arrayList.isEmpty()) {
                Collections.sort(arrayList, new e(this));
            }
            int i2 = 0;
            for (PackageBean.AppBean.PackBean packBean : this.f39355a) {
                if (this.j == 0 && !com.kc.dw.core.service.c.a()) {
                    LogUtil.d("d", "app background, no check PackBean");
                    break;
                }
                if (p0.a(com.kc.dw.base.a.getContext(), this.e, packBean)) {
                    try {
                        this.b.put(packBean.getId(), Boolean.valueOf(packBean.getInstalled()));
                    } catch (Throwable unused) {
                    }
                    i2++;
                    if (i2 >= i) {
                        break;
                    }
                    int i3 = this.k;
                    if (i3 > 0) {
                        try {
                            Thread.sleep(i3);
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (i2 == 0) {
                LogUtil.d("d", "checkCount zero.");
                this.l = false;
                return false;
            }
            this.f = System.currentTimeMillis();
            o0 o0VarA = o0.a();
            PackageBean packageBean = this.c;
            o0VarA.getClass();
            try {
                o0VarA.b = packageBean;
                o0VarA.a(packageBean != null ? v.f39411a.toJson(packageBean) : null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.l = false;
            return true;
        } catch (Throwable unused3) {
            this.l = false;
            return false;
        }
    }
}
