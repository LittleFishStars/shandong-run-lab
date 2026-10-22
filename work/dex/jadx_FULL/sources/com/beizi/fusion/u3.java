package com.beizi.fusion;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.AdvertCacheDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class u3 {
    private static u3 b;
    private static Map c = new HashMap();
    private static Context d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27802a = "KEY_AD_CACHE_CONTENT_";

    public class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(z4 z4Var, z4 z4Var2) {
            return z4Var.a() > z4Var2.a() ? 1 : -1;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a8.a(q1.h().m());
            a8.a(q1.h().m(), 5);
        }
    }

    public class c implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(z4 z4Var, z4 z4Var2) {
            return z4Var.a() > z4Var2.a() ? 1 : -1;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27806a;
        final /* synthetic */ EventBean b;
        final /* synthetic */ w1 c;
        final /* synthetic */ th d;

        public class a implements ti {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f27807a;
            final /* synthetic */ String b;

            public a(String str, String str2) {
                this.f27807a = str;
                this.b = str2;
            }

            @Override // com.beizi.fusion.ti
            public void a(int i) {
            }

            @Override // com.beizi.fusion.ti
            public void a(String str) {
                try {
                    on onVar = new on(str, null, d.this.d);
                    d dVar = d.this;
                    u3.this.a(onVar, str, this.f27807a, this.b, dVar.d);
                    if (d.this.b != null) {
                        if (onVar.b()) {
                            EventBean eventBeanM167clone = d.this.b.m167clone();
                            eventBeanM167clone.setEventCode("255.400");
                            u3.this.a(eventBeanM167clone);
                        } else {
                            EventBean eventBeanM167clone2 = d.this.b.m167clone();
                            eventBeanM167clone2.setEventCode("255.500");
                            eventBeanM167clone2.setErrorCode("3");
                            u3.this.a(eventBeanM167clone2);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public d(int i, EventBean eventBean, w1 w1Var, th thVar) {
            this.f27806a = i;
            this.b = eventBean;
            this.c = w1Var;
            this.d = thVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strG;
            for (int i = 0; i < this.f27806a; i++) {
                try {
                    String strA = po.a();
                    EventBean eventBean = this.b;
                    if (eventBean != null) {
                        eventBean.setReqId(strA);
                        this.b.setEventCode("255.300");
                        u3.this.a(this.b);
                    }
                    String strA2 = po.a();
                    w1 w1Var = new w1();
                    w1Var.c(strA2);
                    w1Var.a(true);
                    w1 w1Var2 = this.c;
                    if (w1Var2 != null) {
                        strG = w1Var2.g();
                        w1Var.d(strG);
                        w1Var.a(this.c.e());
                        w1Var.b(this.c.b());
                    } else {
                        strG = null;
                    }
                    new vi().a(w1Var, new a(strA2, strG), this.d);
                } catch (Exception unused) {
                }
            }
        }
    }

    public class e implements of.f {
        public e() {
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
        }
    }

    public class f implements vp.e {
        public f() {
        }

        @Override // com.beizi.fusion.vp.e
        public void a() {
        }

        @Override // com.beizi.fusion.vp.e
        public void a(String str) {
        }
    }

    public static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27810a;

        static {
            int[] iArr = new int[th.values().length];
            f27810a = iArr;
            try {
                iArr[th.NEW_SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27810a[th.NATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27810a[th.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27810a[th.REWARDEDVIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static synchronized u3 b() {
        if (b == null) {
            synchronized (u3.class) {
                d = a4.j().g();
                b = new u3();
            }
        }
        return b;
    }

    public synchronized void a(EventBean eventBean, int i, w1 w1Var, th thVar) {
        List listD;
        if (i >= 1 && w1Var != null) {
            try {
                String strG = w1Var.g();
                LinkedList linkedList = c.containsKey(strG) ? (LinkedList) c.get(strG) : null;
                if ((linkedList == null || linkedList.isEmpty()) && (listD = d(strG)) != null && listD.size() > 0) {
                    linkedList = new LinkedList(listD);
                    c.put(strG, linkedList);
                }
                int size = (linkedList == null || linkedList.size() <= 0) ? 0 : linkedList.size();
                if (i >= 1 && size < i) {
                    b(eventBean, i - size, w1Var, thVar);
                }
            } catch (Exception unused) {
            }
        }
    }

    public z4 c(String str) {
        z4 z4Var;
        try {
            LinkedList linkedList = c.containsKey(str) ? (LinkedList) c.get(str) : null;
            if (linkedList == null || linkedList.isEmpty()) {
                List listD = d(str);
                if (listD != null && !listD.isEmpty()) {
                    LinkedList linkedList2 = new LinkedList(listD);
                    c.put(str, linkedList2);
                    linkedList = linkedList2;
                }
                return null;
            }
            if (linkedList.isEmpty() || (z4Var = (z4) linkedList.pollLast()) == null || z4Var.b() < System.currentTimeMillis()) {
                return null;
            }
            return z4Var;
        } catch (Exception unused) {
        }
    }

    public List d(String str) {
        try {
            String strA = pm.a(d, this.f27802a + str);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            String strA2 = h3.a(strA);
            if (TextUtils.isEmpty(strA2)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(strA2);
            if (jSONArray.length() < 1) {
                return null;
            }
            ArrayList arrayList = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    long jOptLong = jSONObjectOptJSONObject.has(AdvertCacheDBModel.COLUMN_EXPIRE_TIME) ? jSONObjectOptJSONObject.optLong(AdvertCacheDBModel.COLUMN_EXPIRE_TIME) : 0L;
                    if (jOptLong >= System.currentTimeMillis()) {
                        z4 z4Var = new z4();
                        z4Var.b(jOptLong);
                        if (jSONObjectOptJSONObject.has(StrategyEventDBModel.COLUMN_SPACE_ID)) {
                            z4Var.b(jSONObjectOptJSONObject.optString(StrategyEventDBModel.COLUMN_SPACE_ID));
                        }
                        if (jSONObjectOptJSONObject.has(AdvertCacheDBModel.COLUMN_CACHE_TIME)) {
                            z4Var.a(jSONObjectOptJSONObject.optLong(AdvertCacheDBModel.COLUMN_CACHE_TIME));
                        }
                        if (jSONObjectOptJSONObject.has("requestId")) {
                            z4Var.a(jSONObjectOptJSONObject.optString("requestId"));
                        }
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(z4Var);
                    }
                }
            }
            Collections.sort(arrayList, new a());
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void b(EventBean eventBean, int i, w1 w1Var, th thVar) {
        if (i < 1) {
            return;
        }
        w3.c().a().execute(new d(i, eventBean, w1Var, thVar));
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        vp.c().a(d, str, false, new f());
    }

    public void a() {
        Executors.newSingleThreadScheduledExecutor().schedule(new b(), 10000L, TimeUnit.MILLISECONDS);
    }

    public void a(z4 z4Var) {
        if (z4Var == null) {
            return;
        }
        try {
            System.currentTimeMillis();
            a8.a(d, z4Var.d(), z4Var.c());
        } catch (Exception unused) {
        }
    }

    public void a(z4 z4Var, int i, int i2) {
        if (z4Var == null) {
            return;
        }
        try {
            if (z4Var.b() >= System.currentTimeMillis() && i == 1) {
                String strD = z4Var.d();
                LinkedList linkedList = c.containsKey(strD) ? (LinkedList) c.get(strD) : null;
                if (linkedList == null || linkedList.isEmpty()) {
                    linkedList = new LinkedList();
                }
                linkedList.add(z4Var);
                Collections.sort(linkedList, new c());
                if (linkedList.size() > i2) {
                    linkedList.removeFirst();
                }
                if (a(linkedList, strD)) {
                    c.put(strD, linkedList);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public on a(z4 z4Var, th thVar) {
        if (z4Var == null) {
            return null;
        }
        try {
            String strD = z4Var.d();
            String strB = a8.b(d, strD, z4Var.c());
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            on onVar = new on(strB, null, thVar);
            if (!onVar.b()) {
                return null;
            }
            LinkedList linkedList = c.containsKey(strD) ? (LinkedList) c.get(strD) : null;
            if (linkedList != null && !linkedList.isEmpty()) {
                a(linkedList, strD);
                return onVar;
            }
            pm.c(d, this.f27802a + strD);
            return onVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public void a(on onVar, String str, String str2, String str3, th thVar) {
        int iC;
        try {
            if (onVar.b() && (iC = onVar.C()) > 0 && a8.a(d, str3, str2, str)) {
                z4 z4Var = new z4();
                long jCurrentTimeMillis = System.currentTimeMillis();
                z4Var.a(jCurrentTimeMillis);
                z4Var.b(jCurrentTimeMillis + ((long) (iC * 1000)));
                z4Var.a(str2);
                z4Var.b(str3);
                LinkedList linkedList = c.containsKey(str3) ? (LinkedList) c.get(str3) : null;
                if (linkedList == null || linkedList.isEmpty()) {
                    linkedList = new LinkedList();
                }
                linkedList.add(z4Var);
                a(linkedList, str3);
                c.put(str3, linkedList);
                int i = g.f27810a[thVar.ordinal()];
                if (i == 1) {
                    String strI = onVar.I();
                    if (onVar.J() == n7.RENDER_PIC) {
                        a(strI);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    a(((c4) onVar.O()).getImageUrl());
                    return;
                }
                if (i != 3) {
                    if (i == 4 && onVar.o0()) {
                        String strE0 = onVar.e0();
                        String strG = onVar.G();
                        if (!TextUtils.isEmpty(strE0)) {
                            b(strE0);
                        }
                        if (TextUtils.isEmpty(strG)) {
                            return;
                        }
                        a(strG);
                        return;
                    }
                    return;
                }
                boolean zO0 = onVar.o0();
                String strD = onVar.D();
                String strE1 = onVar.e0();
                if (zO0) {
                    b(strE1);
                } else {
                    a(strD);
                }
            }
        } catch (Exception unused) {
        }
    }

    private boolean a(LinkedList linkedList, String str) {
        if (linkedList != null) {
            try {
                if (!linkedList.isEmpty()) {
                    String strB = h3.b(linkedList.toString());
                    if (TextUtils.isEmpty(strB)) {
                        return false;
                    }
                    pm.c(d, this.f27802a + str, strB);
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        of.a((Context) null).a(str, false, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(EventBean eventBean) {
        EventCar.getInstance(d).goRoad(eventBean);
    }
}
