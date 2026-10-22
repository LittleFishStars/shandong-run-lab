package com.beizi.fusion;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.update.UpdateModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.InitTraceModel;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class g {
    public static String i = "";
    private v c;
    private ConfigResponseModel d;
    private final Context g;
    private InitTraceModel h;
    private final Object b = new Object();
    private final CopyOnWriteArrayList e = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList f = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gd f27308a = b0.a().b();

    public enum a {
        EXPIRED,
        PREFER_UPDATE,
        VALID
    }

    public g(Context context) {
        this.g = context.getApplicationContext();
        g();
    }

    private ConfigResponseModel e() {
        v vVar = this.c;
        String strA = ((id) dh.a().b(this.g)).a((vVar == null || !vVar.z()) ? "HWw9dLkKDNgwNzWnlZfncmtPx6/S/OexIO9o3Ndz7NHBxRWzEV6Jz0AKSZAraeKqperf55vtOA7uwo/LDJxa2J4UOSxuX+RqqRylO8Xmop1cV5pcF2DIa9uwa1Znj9DH6wA+NoD6H/NVvutC40OEpiHoUKP2X7GT4IhVtxvVia9Va/rPxqkVQcWeJQHaNXcVmkbbqsMn074PHX5m7Y6tAh1u/inDt7lJNk8yKHLiPJqPKSHGJSWCqvVE2Mffi+aGEHk0sD71G8jvYy4iPmuKQ3YUe8soZxmCnFZ0cK6TeVHJNESRCbdbpotAIezV/TQKrU+L7ObzkAgr9JH+4N/WzqCgB6vkghsWvOPuOyNvam5Ozxk/U4ip1ukx+fPEwzKPBqa2hR11CBHm+dWTEgC/SmvvAb0bL7ud7SekhQJ56RszwKQUvgiXxlnjqlbBu8jEYiz+e1AjFKTHfyUS+9Un6IXP1GDKM3A2PXtayxKSH59vtI2JYCjsqvlrwlzRV1YmxcJ1mt60lMoLuUQtSmaz6vKAzi1yVs3KmaUjl1ln/EdaCbhZl0gBCQRXR2HB6YzsFVlPVabwFVjT7iQEFOH4AQZkfEIfp/a3Q3ymXZuODkxyFOkM/jbrXgZrpF9PXtUOyDFQBqiYKQx26Wxa2Cf/Eidkot/09PjPBWrnUCjFaznYk2EDUYSbr9ILqUPKrbrmaooNjSmQCcrffWwhGZ8DGBsbhYmUx7Ep9VZ7o92bV1swPJ7/3TuR+8+TFspnCDuozWtOgXjFRg3dUJcIk5hMvzIfDx//xpRkD8o1Kj+O4UVbCI16owB5iXjRnhZwXJ8Drb6nNY8VyUAXvSvtVHR/NVlG+CZCXZDx9UZmJh8v07OY0vRjmxuCuerVxnajunn5ZX63+US1pElr41R1RmfZJ9bpFjyXbLNlxSfiEjVC+RWNgfg8LRus733Mw6dHGzevCJIoj3tl24g435XoIjz/ONS6HLWJfgJeQSD3kkPFKvqSJ6ytr4KGMwMw3qX7YX89JytiJgCZ03BxGdsAXX4Ddq53Q/IoMeLgbnOTnb0Xd2tqwuexHEhu91wYgY0OdIRfTwL7OCiXa4ggEXPRUPkvRx0LjJqxFS8YyB6mFO6tNg9q/LJkcCUxbihLmiwa6oBSeW6wkutWxFaX+kF28fyHJdJkCYYG1rmD/Zl3/TBLGGPU1Rcw3PmacJ8no2Ns0kg00C26ZA2legRxxKOacwL1DEPqwUMCzBqFrRxNEOPvTJ6u+WWfUx30HC25FBlFNJR34bXIYHl1CZZJgVGWG/OatTXPQPKa9tPKdRjgHfQ3lDeaukdFgSSgyH8ZOhXa+N5Yo4+FplkVAPICgDYR5hiTdrUPKIKrzHNqqpiX/W1r//XBn2vmRaIPGhcVwbh0bL/KM0aedTvpbTiyCeyvKsCUpDTPGVaXim2SZaqOnsy4733Av2BEMPwdbAiHmVlf8rcGkZ7gYbWiXFPO0f5nKvPkoHjg+EfthW/w+zWjmtHSGgaot4CWV/jE95HcoOBAXxfCZnfxExc3vEu3c0Wf2WjJsNj1H1hSS6PtGBU7uqpF/U8Igd99K528CYs41VvfGAOAb5Csug/NoUwUp4etPtySPNjMCaY+sJ3cUaksdsbc/aE=" : "HWw9dLkKDNgwNzWnlZfncmtPx6/S/OexIO9o3Ndz7NHBxRWzEV6Jz0AKSZAraeKqperf55vtOA7uwo/LDJxa2J4UOSxuX+RqqRylO8Xmop1cV5pcF2DIa9uwa1Znj9DH6wA+NoD6H/NVvutC40OEpiHoUKP2X7GT4IhVtxvVia9Va/rPxqkVQcWeJQHaNXcVmkbbqsMn074PHX5m7Y6tAh1u/inDt7lJNk8yKHLiPJqPKSHGJSWCqvVE2Mffi+aGFQymFBwz+TyUCNXzSZPam11bmCrKEjhOnBkdbixXbhJi2qs1Uu4Bedg4LarV0DRevLTVCZOuYgFQgdGni9/uzEv7ltXSlhtnXLG05CAIoojzmPGCDz54hiMFk16YHOROgnoHRx7/WCyfd3XvVwJNpTGzhq1bNjZYLyrCznyhwDJg/Lm89JAHpfQfSo/qAFLziplAr3eQc7fQlmwv/IKkw7g89+LoZOBZNFG/z7gH1bX4QG47qpy7GajCUnTVxAaizzBxQsVXaF60CqaCYultuESuBFG8M8iaiAgvnA5vycGw+L6ZlafApaH1QzaPCZQqbggIGypZziYONW6sMpMu40EWt0nZ8cRTnk6/xmjQnFhT84RU6tTqJwTADhsAKiH1ibXH1rzgIb5eBE5jd1iC2Y3hSqE6fNdn+L6BYN+Rv2JThRmBKTrpuJcLJdRW2pdwkqzwJzVze0/hCvKN5O4J+0i8QrYp/14c6nrmmwMX21whwB4VyrZFiTSnEaqiBLWhiC0EY65UrY6VXofap712kvcGoUXGiObQpfYHtla8VvvfBdPNfFdKVlvgI26OhMB8yqXCfSN01v/A7yNxqcoK9T1MkNOEKAFwlSE6ZhTQ8fEiySnUwbDRRZxJRVwsrRBYHCz1nlwdEPL+9lhyxQyUj/g43OpJ/LUpieYNNszhZc1Lqb5hzT7vif1sH5CajEmHRpQ9oZS34s8B75u1C8OIUEVtxye4GStFHHH7yuQBEdBxnSXEPLv3IKWCvpfGM2ajO4eS9/VCf79eDKNrZFbIG1ytGtttsk5M+QZwsXp5AeVGNtRCPXUB0/Z19VhmTRMISLvH+uHth3475X5CYiWwwziHKWaCwM/g+EWx9TfTnr5QlqE+ss4vL6BmFwGVp66sR2a+C1At7vuBj8CAdbw02MxAqTqxt320M88jS+pAk9gjVS/emSbovWMeW1YsVUFNghikq4QloTD8R3fJdIOsdTu2+/FB2beVg2cGx4XQODvODpscsqzZVXs0cdRk7eL5i+h9hwWkuuF44k1jcQZDP8mIapyGlP/4XRGeXMWQsFFxy8rUypj0tazSOa28b6lgBbvnd7k0uJmW75zX8iIpk+6bKgzGA69Ceptc1fmbEOg+mnyuOmAV3o9lvbR288ThtV5+Nd1AO0KzspfXnjFUUikD4byfqDSo/Kdhzt4Xr1ei/Lzmwsaruym3iljogGnhqQFs9FsK5yKNUYWMTwaUgt7cd9Dv3Ny19u1Mds6aPON79S/VYXcb99ObaPyBgpI4gVrLz+4iOgi0Rh9Hg4wOWtPUYM3Xto2JW5o8pajyPQtCQ1GjTFwnE4KR1YPTy8tH3i+Dcos9cPPZL7yrpLgdy63H9VXjU3zvhI0h8mlw8D+9AhedjIFVSe0uF3vP/X4q", "1001", id.a.STEP_BY_STEP, false);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        ConfigResponseModel configResponseModel = new ConfigResponseModel(mg.c(strA));
        if (configResponseModel.hasParseException()) {
            return null;
        }
        return configResponseModel;
    }

    private void g() {
        if (this.g != null) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacksA = this.f27308a.a();
            Context context = this.g;
            if (context instanceof Application) {
                ((Application) context).registerActivityLifecycleCallbacks(activityLifecycleCallbacksA);
            } else if (context instanceof Activity) {
                ((Activity) context).getApplication().registerActivityLifecycleCallbacks(activityLifecycleCallbacksA);
            } else if (context instanceof Service) {
                ((Service) context).getApplication().registerActivityLifecycleCallbacks(activityLifecycleCallbacksA);
            }
        }
    }

    public void a(InitTraceModel initTraceModel) {
        this.h = initTraceModel;
    }

    public InitTraceModel b() {
        InitTraceModel initTraceModel = this.h;
        if (initTraceModel != null) {
            return initTraceModel.m166deepCopy();
        }
        return null;
    }

    public long c() {
        InitTraceModel initTraceModel = this.h;
        if (initTraceModel != null) {
            return initTraceModel.getInitEndTs();
        }
        return 0L;
    }

    public boolean d() {
        return this.d != null;
    }

    public boolean f() {
        ConfigResponseModel configResponseModelA;
        if (this.c.y()) {
            try {
                if (!TextUtils.isEmpty(i)) {
                    a(new ConfigResponseModel(mg.c(zd.a(this.g.getAssets().open(i)))), false, false);
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        String strA = p0.a(this.g, p0.b(), "asnpConfigV3", "");
        String strA2 = p0.a(this.g, p0.b(), "asnpCfgPattern", "101,1001");
        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strA2)) {
            String strA3 = ((id) dh.a().b(this.g)).a(strA, strA2, id.a.STEP_BY_STEP, false);
            if (!TextUtils.isEmpty(strA3) && (configResponseModelA = a(strA3)) != null) {
                a(configResponseModelA, false, false);
                return false;
            }
        }
        ConfigResponseModel configResponseModelE = e();
        if (configResponseModelE != null) {
            a(configResponseModelE, false, true);
        }
        return false;
    }

    public void h() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((lc) it.next()).a();
            }
        }
    }

    public v a() {
        return this.c;
    }

    private void c(final boolean z) {
        ((fb) cn.a().b(this.g)).f(new Runnable() { // from class: com.zj.adlib.g5b
            @Override // java.lang.Runnable
            public final void run() {
                this.f41826a.b(z);
            }
        });
    }

    public void a(v vVar) {
        this.c = vVar;
    }

    public void b(mc mcVar) {
        this.e.remove(mcVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z) {
        a aVarA = a(System.currentTimeMillis());
        CopyOnWriteArrayList copyOnWriteArrayList = this.e;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((mc) it.next()).a(this.d, aVarA, z);
        }
    }

    public ConfigResponseModel a(boolean z) {
        ConfigResponseModel configResponseModel;
        if (z && (configResponseModel = this.d) != null) {
            return configResponseModel.m164deepCopy();
        }
        return this.d;
    }

    public boolean c(long j) {
        if (this.d != null) {
            long jA = p0.a(this.g, p0.b(), "asnpConfigLast", 0L);
            UpdateModel update = this.d.getUpdate();
            if (update != null) {
                long j2 = j - jA;
                if (j2 > update.getExpireTime() && j2 < update.getMaxExpireTime()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(ConfigResponseModel configResponseModel, boolean z, boolean z2) {
        ConfigResponseModel configResponseModel2 = this.d;
        if (configResponseModel2 == null) {
            a(configResponseModel);
            if (z2) {
                return;
            }
            c(z);
            return;
        }
        if (z) {
            a(configResponseModel2.partUpdate(configResponseModel));
            p0.b(this.g, p0.b(), "asnpConfigLast", System.currentTimeMillis());
            c(true);
        }
    }

    public boolean b(long j) {
        if (this.d != null) {
            long jA = p0.a(this.g, p0.b(), "asnpConfigLast", 0L);
            UpdateModel update = this.d.getUpdate();
            if (update != null && j - jA > update.getMaxExpireTime()) {
                return true;
            }
        }
        return false;
    }

    private void a(ConfigResponseModel configResponseModel) {
        synchronized (this.b) {
            this.d = configResponseModel;
        }
    }

    private ConfigResponseModel a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConfigResponseModel configResponseModel = new ConfigResponseModel(mg.c(str));
        if (configResponseModel.hasParseException()) {
            return null;
        }
        return configResponseModel;
    }

    public void a(mc mcVar) {
        this.e.add(mcVar);
    }

    public void a(lc lcVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.contains(lcVar)) {
            return;
        }
        this.f.add(lcVar);
    }

    public a a(long j) {
        if (b(j)) {
            return c(j) ? a.PREFER_UPDATE : a.EXPIRED;
        }
        return a.VALID;
    }
}
