package com.beizi.fusion;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.AppEventId;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class q1 {
    public static String t = null;
    public static String u = "";
    private static String v = "AdManager";
    private static q1 w;
    private static String x;
    private static String y;
    private static String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27670a;
    private f9 c;
    private ik d;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private Map s;
    private boolean b = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = true;
    private String l = "0";
    private List m = new CopyOnWriteArrayList();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q1.this.o();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q1.this.f();
            q1.this.k();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = e2.a(q1.this.f27670a);
            Log.e(q1.v, "code honor Oaid:" + strA);
            if (!TextUtils.isEmpty(strA)) {
                co.b(q1.this.f27670a, "__HONOROAID__", strA);
            }
            if (TextUtils.isEmpty(strA) || RequestInfo.getInstance(q1.this.f27670a).getDevInfo() == null) {
                return;
            }
            RequestInfo.getInstance(q1.this.f27670a).getDevInfo().setHonorOaid(strA);
        }
    }

    private void C() {
        try {
            f9.a(this.f27670a).b(5);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (Build.BRAND.equalsIgnoreCase("HONOR")) {
                String str = (String) co.a(this.f27670a, "__HONOROAID__", (Object) "");
                if (!TextUtils.isEmpty(str) && RequestInfo.getInstance(this.f27670a).getDevInfo() != null) {
                    RequestInfo.getInstance(this.f27670a).getDevInfo().setHonorOaid(str);
                }
                v3.b().a().execute(new d());
            }
        } catch (Exception unused) {
        }
    }

    public static q1 h() {
        if (w == null) {
            synchronized (q1.class) {
                if (w == null) {
                    w = new q1();
                }
            }
        }
        return w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            new b7(gk.c).b(this.f27670a);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            if ("0".equals(ResponseInfo.getInstance(this.f27670a).getSmFlag())) {
                int iIntValue = ((Integer) co.a(this.f27670a, "SM_STATUS", (Object) 0)).intValue();
                int i = 1;
                if (iIntValue == 1) {
                    co.b(this.f27670a, "SM_STATUS", 3);
                    co.b(this.f27670a, "SM_STATUS_EXPIRE_TIME", Long.valueOf(System.currentTimeMillis()));
                    iIntValue = 3;
                }
                if (iIntValue == 0 || iIntValue == 2) {
                    co.b(this.f27670a, "SM_STATUS", 1);
                } else {
                    i = iIntValue;
                }
                if (i != 3) {
                    if (s6.a(this.f27670a)) {
                        s6.a(this.f27670a, new c());
                    }
                    co.b(this.f27670a, "SM_STATUS", 2);
                } else {
                    Long l = (Long) co.a(this.f27670a, "SM_STATUS_EXPIRE_TIME", (Object) Long.valueOf(Long.parseLong("0")));
                    if (l.longValue() == 0 || System.currentTimeMillis() - l.longValue() <= 864000000) {
                        return;
                    }
                    co.b(this.f27670a, "SM_STATUS", 0);
                    co.b(this.f27670a, "SM_STATUS_EXPIRE_TIME", Long.valueOf(Long.parseLong("0")));
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!this.h) {
            g6.a().a(this.f27670a);
        }
        ResponseInfo.getInstance(this.f27670a).init();
        if (!this.f) {
            this.d.b.a(1);
            B();
        }
        i();
        if (!this.f) {
            if (this.d.b.a() == 1) {
                this.d.b.a(2);
            } else {
                Log.i("BeiZis", "init status error not kInitStatusBegin");
            }
        }
        a((BeiZiInitCallBack) null);
    }

    public void A() {
        d();
        if (this.f && this.b && this.f27670a != null && this.d.b.a() == 0) {
            this.d.b.a(1);
            this.d.b.a(2);
        }
    }

    public void B() {
        Context context = this.f27670a;
        if (context != null && this.c == null) {
            if (ResponseInfo.getInstance(context).isInit()) {
                EventCar.getInstance(this.f27670a).goRoad(new EventBean(u, "", "410.000", "", h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                EventCar.getInstance(this.f27670a).goRoad(new EventBean(u, "", "410.200", "", h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            } else {
                EventCar.getInstance(this.f27670a).goRoad(new EventBean(u, "", "410.000", "", h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                EventCar.getInstance(this.f27670a).goRoad(new EventBean(u, "", "410.500", "", h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            }
            f9 f9VarA = f9.a(this.f27670a);
            this.c = f9VarA;
            f9VarA.b(0);
        }
    }

    public void a(Context context, String str, String str2, String str3) {
        synchronized (q1.class) {
            Log.e("BeiZis", "init start applicationCode：" + str);
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            if (this.b) {
                a((BeiZiInitCallBack) null);
            } else {
                this.f27670a = context.getApplicationContext();
                String strA = oo.a();
                u = strA;
                EventBean eventBean = new EventBean(strA, "", "", "", str, "", "", String.valueOf(System.currentTimeMillis()), "");
                this.d = new ik(eventBean);
                Log.d("BeiZis", "SDK_VERSION_MANAGER:5.5.0.2");
                t = str;
                y = str2;
                z = str3;
                ik ikVar = this.d;
                ikVar.b.addObserver(ikVar);
                this.d.a().a(eventBean);
                AppEventId.getInstance(this.f27670a).setAppStart();
                AppEventId.getInstance(this.f27670a).setAppSdkInit();
                rf.a().a(this.f27670a);
                if (this.d.b.a() == 0) {
                    if (BeiZis.isIsSyncInit()) {
                        o();
                    } else {
                        v3.b().a().execute(new a());
                    }
                    this.b = true;
                } else {
                    Log.i("BeiZis", "init status error not kInitStatusUnknown");
                }
            }
            Log.e("BeiZis", "init end");
        }
    }

    public q1 b(String str) {
        x = str;
        return w;
    }

    public String c() {
        return y;
    }

    public void d() {
        if (this.n) {
            return;
        }
        this.n = true;
        if (al.c()) {
            if (BeiZis.isLimitPersonalAds()) {
                return;
            }
            if (BeiZis.getCustomController() != null && (BeiZis.getCustomController() == null || !BeiZis.getCustomController().isCanUseOaid())) {
                return;
            }
        }
        v3.b().a().execute(new b());
    }

    public Map e() {
        return this.s;
    }

    public ik g() {
        return this.d;
    }

    public void i() {
        if (al.c()) {
            if (BeiZis.isLimitPersonalAds()) {
                return;
            }
            if (BeiZis.getCustomController() != null && (BeiZis.getCustomController() == null || !BeiZis.getCustomController().isCanUseOaid())) {
                return;
            }
        }
        String str = (String) co.a(this.f27670a, "__OAID__", (Object) "");
        if (TextUtils.isEmpty(str) || RequestInfo.getInstance(this.f27670a).getDevInfo() == null) {
            return;
        }
        RequestInfo.getInstance(this.f27670a).getDevInfo().setOaid(str);
    }

    public String l() {
        return z;
    }

    public Context m() {
        return this.f27670a;
    }

    public String n() {
        return this.l;
    }

    public boolean p() {
        return this.j;
    }

    public boolean q() {
        return BeiZis.getCustomController() == null || BeiZis.getCustomController().isCanUseAndroidId();
    }

    public boolean r() {
        return this.k;
    }

    public boolean s() {
        return this.q;
    }

    public boolean t() {
        return this.f;
    }

    public boolean u() {
        return (BeiZis.getCustomController() == null || !BeiZis.getCustomController().forbidSensor() || ResponseInfo.getInstance(this.f27670a).isOpenSensor()) ? false : true;
    }

    public boolean v() {
        return this.i;
    }

    public boolean w() {
        return this.p;
    }

    public boolean x() {
        return this.r;
    }

    public boolean y() {
        return this.o;
    }

    public boolean z() {
        return this.g;
    }

    public String b() {
        return t;
    }

    public void b(BeiZiInitCallBack beiZiInitCallBack) {
        a(beiZiInitCallBack);
    }

    public class c implements jc {
        public c() {
        }

        @Override // com.beizi.fusion.jc
        public void a(String str) {
            Log.e(q1.v, "code sm Oaid:" + str);
            if (!TextUtils.isEmpty(str)) {
                co.b(q1.this.f27670a, "__OAID__", str);
                co.b(q1.this.f27670a, "__SMOAID__", str);
                if (RequestInfo.getInstance(q1.this.f27670a).getDevInfo() != null) {
                    if (al.c() && BeiZis.isLimitPersonalAds()) {
                        return;
                    }
                    RequestInfo.getInstance(q1.this.f27670a).getDevInfo().setOaid(str);
                    RequestInfo.getInstance(q1.this.f27670a).getDevInfo().setSmOaid(str);
                    return;
                }
                return;
            }
            if (Build.BRAND.equalsIgnoreCase("HONOR")) {
                String str2 = (String) co.a(q1.this.f27670a, "__HONOROAID__", (Object) "");
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                co.b(q1.this.f27670a, "__OAID__", str2);
                co.b(q1.this.f27670a, "__SMOAID__", str2);
                if (RequestInfo.getInstance(q1.this.f27670a).getDevInfo() != null && (!al.c() || !BeiZis.isLimitPersonalAds())) {
                    RequestInfo.getInstance(q1.this.f27670a).getDevInfo().setOaid(str2);
                    RequestInfo.getInstance(q1.this.f27670a).getDevInfo().setSmOaid(str2);
                }
            }
            q1.this.j();
        }

        @Override // com.beizi.fusion.jc
        public void a(Exception exc) {
            q1.this.j();
        }
    }

    public void a(Map map) {
        if (map == null) {
            return;
        }
        try {
            this.s = map;
            if (map.containsKey("forbid_config_network")) {
                Object obj = map.get("forbid_config_network");
                if (obj instanceof Boolean) {
                    this.f = ((Boolean) obj).booleanValue();
                }
            }
            if (map.containsKey("speed_first_strategy")) {
                Object obj2 = map.get("speed_first_strategy");
                if (obj2 instanceof Boolean) {
                    this.g = ((Boolean) obj2).booleanValue();
                }
            }
            if (map.containsKey("forbid_collect_crash")) {
                Object obj3 = map.get("forbid_collect_crash");
                if (obj3 instanceof Boolean) {
                    this.h = ((Boolean) obj3).booleanValue();
                }
            }
            if (map.containsKey("forbid_verify_window_focus")) {
                Object obj4 = map.get("forbid_verify_window_focus");
                if (obj4 instanceof Boolean) {
                    this.i = ((Boolean) obj4).booleanValue();
                }
            }
            if (map.containsKey("allow_use_app_status")) {
                Object obj5 = map.get("allow_use_app_status");
                if (obj5 instanceof Boolean) {
                    this.j = ((Boolean) obj5).booleanValue();
                }
            }
            if (map.containsKey("isCanUseSimOperator")) {
                Object obj6 = map.get("isCanUseSimOperator");
                if (obj6 instanceof Boolean) {
                    this.k = ((Boolean) obj6).booleanValue();
                }
            }
            if (map.containsKey("simOperator")) {
                Object obj7 = map.get("simOperator");
                if (obj7 instanceof String) {
                    this.l = (String) obj7;
                }
            }
            if (map.containsKey("open_location_frequency")) {
                Object obj8 = map.get("open_location_frequency");
                if (obj8 instanceof Boolean) {
                    this.o = ((Boolean) obj8).booleanValue();
                }
            }
            if (map.containsKey("limit_location_frequency")) {
                Object obj9 = map.get("limit_location_frequency");
                if (obj9 instanceof Boolean) {
                    this.p = ((Boolean) obj9).booleanValue();
                }
            }
            if (map.containsKey("forbid_collect_store_info")) {
                Object obj10 = map.get("forbid_collect_store_info");
                if (obj10 instanceof Boolean) {
                    this.q = ((Boolean) obj10).booleanValue();
                }
            }
            if (map.containsKey("open_async")) {
                Object obj11 = map.get("open_async");
                if (obj11 instanceof Boolean) {
                    this.r = ((Boolean) obj11).booleanValue();
                }
            }
        } catch (Exception unused) {
        }
    }

    public String a(String str) {
        String appId;
        String spaceId;
        try {
            if (TextUtils.isEmpty(str) || this.f27670a == null || !this.b) {
                return null;
            }
            d();
            AdSpacesBean adSpaceBean = ResponseInfo.getInstance(this.f27670a).getAdSpaceBean(str);
            if (adSpaceBean == null) {
                C();
                return vq.a(this.f27670a, null, null);
            }
            List<AdSpacesBean.BuyerBean> buyer = adSpaceBean.getBuyer();
            if (buyer != null && !buyer.isEmpty()) {
                Iterator<AdSpacesBean.BuyerBean> it = buyer.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        appId = null;
                        spaceId = null;
                        break;
                    }
                    AdSpacesBean.BuyerBean next = it.next();
                    if (next != null && "S2S".equalsIgnoreCase(next.getBidType())) {
                        appId = next.getAppId();
                        spaceId = next.getSpaceId();
                        break;
                    }
                }
                if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(spaceId)) {
                    return vq.a(this.f27670a, appId, spaceId);
                }
                C();
                return vq.a(this.f27670a, null, null);
            }
            C();
            return vq.a(this.f27670a, null, null);
        } catch (Exception unused) {
            return vq.a(this.f27670a, null, null);
        }
    }

    public String a() {
        return BeiZis.getCustomController() == null ? "" : BeiZis.getCustomController().getAndroidId();
    }

    private synchronized void a(BeiZiInitCallBack beiZiInitCallBack) {
        try {
            if (BeiZis.isIsSyncInit()) {
                return;
            }
            if (beiZiInitCallBack != null) {
                if (this.b) {
                    beiZiInitCallBack.success();
                    return;
                } else {
                    this.m.add(beiZiInitCallBack);
                    return;
                }
            }
            this.b = true;
            Iterator it = this.m.iterator();
            while (it.hasNext()) {
                ((BeiZiInitCallBack) it.next()).success();
            }
            this.m.clear();
        } catch (Throwable unused) {
        }
    }
}
