package com.beizi.fusion;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.huachenjie.common.video.VideoPlayerActivity;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class k3 {
    protected boolean A;
    private String B;
    private String C;
    private Map D;
    protected boolean E;
    protected boolean F;
    protected boolean G;
    protected boolean H;
    private boolean K;
    private String L;
    private String M;
    public boolean N;
    private String O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f27459a;
    protected r1 b;
    protected on c;
    protected boolean d;
    protected String e;
    protected String f;
    protected String k;
    protected String l;
    protected th m;
    protected int n;
    protected int o;
    protected int p;
    protected int q;
    protected z4 r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    protected boolean v;
    protected EventBean w;
    protected boolean x;
    protected String y;
    protected AdSpacesBean.BuyerBean z;
    protected boolean g = false;
    protected boolean h = false;
    protected boolean i = false;
    protected boolean j = false;
    private boolean I = false;
    protected Handler J = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 16) {
                return;
            }
            k3.this.H();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                EventBean eventBeanM167clone = k3.this.w.m167clone();
                eventBeanM167clone.setEventCode("280.000");
                if (k3.this.t) {
                    eventBeanM167clone.setIsCacheAd("1");
                }
                EventCar.getInstance(k3.this.f27459a).goRoad(eventBeanM167clone);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public k3(Context context, th thVar) {
        this.b = null;
        this.f27459a = context.getApplicationContext();
        this.m = thVar;
        r1 r1Var = new r1(context);
        this.b = r1Var;
        r1Var.a(thVar);
    }

    private void I() {
        w3.c().a().execute(new c());
    }

    private void J() {
        if (this.q <= 0) {
            return;
        }
        b();
        int i = this.p;
        if (i <= 0) {
            H();
            return;
        }
        Handler handler = this.J;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(16, i);
        }
    }

    private void K() {
        String str = this.l;
        this.k = str;
        r1 r1Var = this.b;
        if (r1Var != null) {
            r1Var.b(str);
        }
    }

    private void L() {
        if (this.v || !this.t || this.u) {
            return;
        }
        this.v = true;
        u3.b().a(this.r, 1, this.q);
    }

    public String A() {
        return this.M;
    }

    public boolean B() {
        return this.x;
    }

    public boolean C() {
        return this.d;
    }

    public boolean D() {
        return this.g;
    }

    public boolean E() {
        return this.t;
    }

    public boolean F() {
        try {
            on onVar = this.c;
            if (onVar == null) {
                return false;
            }
            return onVar.n0();
        } catch (Exception unused) {
            return false;
        }
    }

    public void G() {
        if (this.h) {
            return;
        }
        this.h = true;
        if (TextUtils.isEmpty(this.B)) {
            if ("S2S".equalsIgnoreCase(this.C)) {
                a(3);
                return;
            } else {
                J();
                w3.c().b().execute(new b());
                return;
            }
        }
        on onVar = new on(this.B, null, this.b.a());
        if (!onVar.b()) {
            a(3);
        } else if (!a(onVar.g())) {
            a(12);
        } else {
            this.l = onVar.V();
            a(true, onVar.d(), null, onVar);
        }
    }

    public boolean H() {
        on onVarA;
        if (this.I) {
            return false;
        }
        this.I = true;
        if (this.q <= 0 || this.s) {
            return false;
        }
        try {
            z4 z4VarC = u3.b().c(i());
            if (z4VarC == null || (onVarA = u3.b().a(z4VarC, this.m)) == null) {
                return false;
            }
            if (this.s) {
                u3.b().a(z4VarC, 1, this.q);
                return false;
            }
            if (!a(onVarA, z4VarC)) {
                return false;
            }
            a(false, null, z4VarC, onVarA);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public abstract void a(int i);

    public void a(AdSpacesBean.BuyerBean buyerBean) {
        if (buyerBean == null) {
            return;
        }
        this.z = buyerBean;
        int cacheNum = buyerBean.getCacheNum();
        this.q = cacheNum;
        if (cacheNum > 0) {
            int waitTime = buyerBean.getWaitTime();
            int lastTime = buyerBean.getLastTime();
            if (lastTime <= 0) {
                lastTime = 100;
            }
            if (waitTime >= 0) {
                this.p = Math.min(waitTime, this.o - lastTime);
            } else {
                this.p = this.o - lastTime;
            }
            if (this.p <= 0) {
                this.p = 100;
            }
        }
        this.E = buyerBean.getIsImageSpeed() == 1;
        this.F = buyerBean.getIsHideInteraction() == 1;
        this.G = buyerBean.getIsPlaceHolder() == 1;
        this.H = buyerBean.getIsAnimation() == 1;
    }

    public abstract void a(on onVar);

    public void b(int i) {
        this.o = i;
    }

    public void c() {
    }

    public void c(String str) {
        this.B = str;
    }

    public void d() {
        on onVar = this.c;
        if (onVar != null) {
            onVar.a(false);
            this.c.a();
        }
        L();
        e();
    }

    public void e(String str) {
        this.e = str;
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            this.l = po.a();
            K();
        } else {
            this.l = str;
            K();
        }
    }

    public AdSpacesBean.BuyerBean g() {
        return this.z;
    }

    public String h() {
        return this.f;
    }

    public String i() {
        return this.y;
    }

    public String j() {
        on onVar = this.c;
        if (onVar == null) {
            return null;
        }
        return onVar.s();
    }

    public int k() {
        int i = this.n;
        if (i <= 0) {
            return 5;
        }
        return i;
    }

    public long l() {
        z4 z4Var;
        try {
            if (this.t && (z4Var = this.r) != null) {
                return z4Var.a();
            }
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public int m() {
        on onVar = this.c;
        if (onVar == null) {
            return 0;
        }
        return onVar.u();
    }

    public List n() {
        on onVar = this.c;
        if (onVar == null) {
            return null;
        }
        return onVar.v();
    }

    public f5 o() {
        on onVar = this.c;
        if (onVar == null) {
            return null;
        }
        return onVar.w();
    }

    public cl p() {
        on onVar = this.c;
        if (onVar == null) {
            return null;
        }
        return onVar.x();
    }

    public Map q() {
        on onVar = this.c;
        if (onVar == null) {
            return null;
        }
        return onVar.y();
    }

    public JSONObject r() {
        int iIntValue;
        String strC0;
        try {
            Map map = this.D;
            if (map == null || !map.containsKey("materialInfo")) {
                return null;
            }
            Object obj = this.D.get("materialInfo");
            if (!(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) == 0) {
                return null;
            }
            if (iIntValue != 1 && iIntValue != 101 && iIntValue != 1001) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.c != null) {
                JSONObject jSONObject2 = new JSONObject();
                if (iIntValue == 1 || iIntValue == 101 || iIntValue == 1001) {
                    th thVar = this.m;
                    if (thVar == th.NEW_SPLASH || thVar == th.NATIVE) {
                        strC0 = this.c.I();
                    } else if (thVar == th.INTERSTITIAL) {
                        strC0 = this.c.D();
                    } else if (thVar == th.REWARDEDVIDEO) {
                        strC0 = this.c.G();
                    } else {
                        strC0 = thVar == th.SPLASHUNIFIED ? this.c.c0() : null;
                    }
                    if (!TextUtils.isEmpty(strC0) && strC0.startsWith("http")) {
                        jSONObject2.put("imageUrl", strC0);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(strC0);
                        jSONObject2.put("imageUrls", jSONArray);
                    }
                    String strE0 = this.c.e0();
                    if (!TextUtils.isEmpty(strE0)) {
                        jSONObject2.put(VideoPlayerActivity.t, strE0);
                    }
                    String strI = this.c.i();
                    if (!TextUtils.isEmpty(strI)) {
                        jSONObject2.put("crid", strI);
                    }
                }
                if (iIntValue == 101 || iIntValue == 1001) {
                    String strZ = this.c.z();
                    if (!TextUtils.isEmpty(strZ)) {
                        jSONObject2.put("deeplinkUrl", strZ);
                    }
                    String strF = this.c.F();
                    if (!TextUtils.isEmpty(strF)) {
                        jSONObject2.put("landingPageUrl", strF);
                    }
                    String strA = this.c.A();
                    if (!TextUtils.isEmpty(strA)) {
                        jSONObject2.put("downloadUrl", strA);
                    }
                    String strM = this.c.M();
                    if (!TextUtils.isEmpty(strM)) {
                        jSONObject2.put("miniProgramId", strM);
                    }
                    String strN = this.c.N();
                    if (!TextUtils.isEmpty(strN)) {
                        jSONObject2.put("miniProgramPath", strN);
                    }
                }
                if (iIntValue == 1001) {
                    String strS = this.c.S();
                    if (!TextUtils.isEmpty(strS)) {
                        jSONObject2.put("orderId", strS);
                    }
                }
                jSONObject.put("materialInfo", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String s() {
        on onVar = this.c;
        if (onVar == null) {
            return null;
        }
        return onVar.F();
    }

    public np t() {
        on onVar = this.c;
        if (onVar == null) {
            return null;
        }
        return onVar.P();
    }

    public kj u() {
        on onVar = this.c;
        if (onVar == null) {
            return null;
        }
        return onVar.Q();
    }

    public wk v() {
        on onVar = this.c;
        if (onVar == null) {
            return null;
        }
        return onVar.R();
    }

    public String w() {
        return this.e;
    }

    public String x() {
        return this.l;
    }

    public Map y() {
        on onVar = this.c;
        if (onVar == null) {
            return null;
        }
        return onVar.X();
    }

    public on z() {
        return this.c;
    }

    public void b(String str) {
        this.y = str;
        r1 r1Var = this.b;
        if (r1Var != null) {
            r1Var.a(str);
        }
    }

    public void c(Map map) {
        this.D = map;
    }

    public void e() {
        Handler handler = this.J;
        if (handler != null) {
            handler.removeMessages(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        try {
            if (TextUtils.isEmpty(this.O) || i == 0) {
                return;
            }
            nm.a().a(this.O, 1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void b(boolean z) {
        this.d = z;
    }

    public void b(Map map) {
        on onVar = this.c;
        if (onVar == null || map == null) {
            return;
        }
        onVar.b(map);
    }

    public void d(String str) {
        this.C = str;
    }

    public String f() {
        return this.L;
    }

    private void b() {
        Object obj;
        Object obj2;
        w1 w1Var = new w1();
        w1Var.d(this.y);
        Map map = this.D;
        if (map != null) {
            if (map.containsKey("orderList") && (obj2 = this.D.get("orderList")) != null && (obj2 instanceof List)) {
                List list = (List) obj2;
                if (list.size() > 0) {
                    w1Var.a(list);
                }
            }
            if (this.D.containsKey("interactionType") && (obj = this.D.get("interactionType")) != null && (obj instanceof Integer)) {
                w1Var.b(((Integer) obj).intValue());
            }
        }
        u3.b().a(this.w, this.q, w1Var, this.m);
    }

    public k3(Context context, String str, th thVar) {
        this.b = null;
        this.f27459a = context.getApplicationContext();
        this.y = str;
        this.m = thVar;
        r1 r1Var = new r1(context);
        this.b = r1Var;
        r1Var.a(str);
        this.b.a(thVar);
    }

    public void a(EventBean eventBean) {
        this.w = eventBean;
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            new vi().a(k3.this.a(), new a(), k3.this.m);
        }

        public class a implements ti {
            public a() {
            }

            @Override // com.beizi.fusion.ti
            public void a(String str) {
                try {
                    on onVar = new on(str, null, k3.this.b.a());
                    k3.this.c(onVar.Z());
                    a4.j().a(onVar.t());
                    k3 k3Var = k3.this;
                    if (k3Var.t) {
                        k3Var.a(onVar, str);
                        return;
                    }
                    k3Var.e();
                    if (onVar.b()) {
                        k3.this.a(true, onVar.d(), null, onVar);
                    } else {
                        if (k3.this.H()) {
                            return;
                        }
                        k3.this.a(3);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.beizi.fusion.ti
            public void a(int i) {
                k3 k3Var = k3.this;
                k3Var.h = false;
                if (k3Var.t) {
                    return;
                }
                k3Var.e();
                if (k3.this.H()) {
                    return;
                }
                k3.this.a(i);
            }
        }
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(Map map) {
        if (this.c == null || map == null) {
            return;
        }
        L();
        this.c.a(map);
    }

    private boolean a(on onVar, z4 z4Var) {
        Object obj;
        try {
            Map map = this.D;
            if (map == null || !map.containsKey("orderList") || (obj = this.D.get("orderList")) == null || !(obj instanceof List)) {
                return true;
            }
            List list = (List) obj;
            if (list.isEmpty()) {
                return true;
            }
            String strS = onVar.S();
            if (TextUtils.isEmpty(strS) || list.contains(strS)) {
                return true;
            }
            u3.b().a(z4Var);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, String str, z4 z4Var, on onVar) {
        if (this.A) {
            if (z) {
                a(onVar, str);
                return;
            } else {
                if (this.s) {
                    u3.b().a(z4Var, 1, this.q);
                    return;
                }
                return;
            }
        }
        this.A = true;
        this.c = onVar;
        if (z) {
            this.s = true;
        } else {
            this.t = true;
            if (z4Var != null) {
                String strC = z4Var.c();
                this.l = strC;
                r1 r1Var = this.b;
                if (r1Var != null) {
                    r1Var.b(strC);
                }
            }
            this.r = z4Var;
            on onVar2 = this.c;
            if (onVar2 != null) {
                onVar2.d(true);
            }
        }
        I();
        a(onVar);
    }

    public void a(on onVar, String str) {
        if (onVar == null || !onVar.b() || TextUtils.isEmpty(str)) {
            return;
        }
        u3.b().a(onVar, str, this.k, this.y, this.m);
    }

    public boolean a(i7 i7Var) {
        th thVar = this.m;
        if (thVar == th.NEW_SPLASH || thVar == th.SPLASHUNIFIED || thVar == th.SPLASH) {
            return i7Var == i7.ADP_LOADING;
        }
        if (thVar == th.NATIVE) {
            return i7Var == i7.ADP_NATIVE;
        }
        if (thVar == th.INTERSTITIAL) {
            return i7Var == i7.ADP_TABLE;
        }
        return thVar == th.REWARDEDVIDEO && i7Var == i7.ADP_IVIDEO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w1 a() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        w1 w1Var = new w1();
        w1Var.d(this.y);
        w1Var.c(this.l);
        w1Var.a(false);
        w1Var.b(this.K);
        Map map = this.D;
        if (map != null) {
            if (map.containsKey("orderList") && (obj6 = this.D.get("orderList")) != null && (obj6 instanceof List)) {
                List list = (List) obj6;
                if (list.size() > 0) {
                    w1Var.a(list);
                }
            }
            if (this.D.containsKey("interactionType") && (obj5 = this.D.get("interactionType")) != null && (obj5 instanceof Integer)) {
                w1Var.b(((Integer) obj5).intValue());
            }
            if (this.D.containsKey("bz_user_id") && (obj4 = this.D.get("bz_user_id")) != null && (obj4 instanceof String)) {
                this.L = (String) obj4;
            }
            if (this.D.containsKey("bz_user_custom_data") && (obj3 = this.D.get("bz_user_custom_data")) != null && (obj3 instanceof String)) {
                this.M = (String) obj3;
            }
            if (this.D.containsKey("window_scene") && (obj2 = this.D.get("window_scene")) != null && (obj2 instanceof Boolean)) {
                this.N = ((Boolean) obj2).booleanValue();
            }
            if (this.D.containsKey("bz_spaceId") && (obj = this.D.get("bz_spaceId")) != null && (obj instanceof String)) {
                this.O = (String) obj;
            }
        }
        if (a4.j().p()) {
            String strA = new zh().a();
            if (!TextUtils.isEmpty(strA)) {
                strA = h3.b(strA);
            }
            w1Var.b(strA);
        }
        return w1Var;
    }

    public void a(boolean z) {
        this.K = z;
    }

    public void a(ViewGroup viewGroup, int i) {
        try {
            on onVar = this.c;
            if (onVar == null) {
                return;
            }
            if (i == 0) {
                onVar.e(viewGroup, this.l);
                return;
            }
            if (i == 25) {
                onVar.b(viewGroup, this.l);
                return;
            }
            if (i == 50) {
                onVar.c(viewGroup, this.l);
            } else if (i == 75) {
                onVar.d(viewGroup, this.l);
            } else if (i == 100) {
                onVar.a(viewGroup, this.l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
