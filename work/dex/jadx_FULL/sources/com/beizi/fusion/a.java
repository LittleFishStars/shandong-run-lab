package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.AdvertCacheDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.AdResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.bid.BiddingModel3;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.requrl.RequestUrlModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.StrategyModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.cache.AdCacheModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    private final l b;
    private final Context c;
    private final ScheduledExecutorService f;
    private final k g = new C0292a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f26981a = new ArrayMap();
    private final HashMap d = new HashMap();
    private final HashMap e = new HashMap();

    public class b implements mc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.beizi.fusion.g f26983a;

        public b(com.beizi.fusion.g gVar) {
            this.f26983a = gVar;
        }

        @Override // com.beizi.fusion.mc
        public void a(ConfigResponseModel configResponseModel, com.beizi.fusion.g.a aVar, boolean z) {
            a.this.a();
            if (com.beizi.fusion.g.a.VALID != aVar || configResponseModel == null) {
                return;
            }
            a.this.c(configResponseModel.getStrategyList());
            a.this.c();
            a.this.a(configResponseModel.getRequestUrl());
            gl.a().a(a.this.c, configResponseModel.getRequestUrl());
            this.f26983a.b(this);
        }
    }

    public class c implements k5.a {
        public c() {
        }

        @Override // com.beizi.fusion.k5.a
        public Long a(AdvertCacheDBModel advertCacheDBModel) {
            return Long.valueOf(advertCacheDBModel.getPrimaryID());
        }
    }

    public static class d extends fa {
        public d(Context context) {
            super(context);
        }

        @Override // com.beizi.fusion.za
        public void a(String str, db dbVar, sa saVar) {
            super.a(str, dbVar, saVar);
        }

        @Override // com.beizi.fusion.fa
        public String a(ConfigResponseModel configResponseModel) {
            return super.a(configResponseModel);
        }
    }

    public static class e extends ba {
        public e(ba.c cVar) {
            super(cVar);
        }
    }

    public static class f extends ba.c {
        private final com.beizi.fusion.d l;

        private f(AdCacheModel adCacheModel, com.beizi.fusion.d dVar) {
            a(adCacheModel.getBatchFetchCount());
            this.l = dVar;
            a(10000L);
        }

        @Override // com.beizi.fusion.ba.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(ba.c cVar) {
            return new e(this);
        }

        @Override // com.beizi.fusion.ba.c
        public com.beizi.fusion.d a() {
            return this.l;
        }
    }

    public static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f26985a;
        private final Context b;
        private final AdCacheModel c;
        private final String d;
        private com.beizi.fusion.d e;
        private sa f;

        /* JADX INFO: renamed from: com.beizi.fusion.a$g$a, reason: collision with other inner class name */
        public class C0293a extends up {
            public C0293a(Context context) {
                super(context);
            }

            @Override // com.beizi.fusion.up
            public void a(AdResponseModel adResponseModel, n1[] n1VarArr) {
                if (adResponseModel != null) {
                    ((a) com.beizi.fusion.b.a().b(g.this.b)).a(g.this.d, adResponseModel);
                }
            }

            @Override // com.beizi.fusion.up
            public void b(nc ncVar) {
            }
        }

        private g(Context context, String str, AdCacheModel adCacheModel) {
            this.b = context;
            this.c = adCacheModel;
            this.d = str;
            this.f26985a = new d(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.beizi.fusion.d dVar) {
            this.e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a()) {
                if (b0.a().a(this.b) || b0.a().b(this.b)) {
                    v1 v1Var = new v1(this.b);
                    e eVar = (e) new f(this.c, this.e).a(this.d);
                    com.beizi.fusion.g gVar = (com.beizi.fusion.g) com.beizi.fusion.h.a().b(this.b);
                    v vVarA = gVar.a();
                    ConfigResponseModel configResponseModelA = gVar.a(false);
                    v1Var.a(eVar, vVarA, eVar.b(), nn.a(), configResponseModelA.getStrategyMD5(this.d));
                    String strA = no.a(this.f26985a.a(configResponseModelA), vVarA.z());
                    if (this.f == null) {
                        this.f = new C0293a(this.b);
                    }
                    this.f26985a.a(strA, v1Var, this.f);
                }
            }
        }

        private boolean a() {
            return ((a) com.beizi.fusion.b.a().b(this.b)).c(this.d) < this.c.getCacheMaxQty();
        }
    }

    public static class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f26986a;
        private final Context b;

        private i(Context context, String str) {
            this.f26986a = str;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            nf.b().a(this.b, this.f26986a, ph.TEMPORARY);
        }
    }

    public static class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f26987a;
        private final Context b;
        private final fb c;

        /* JADX INFO: renamed from: com.beizi.fusion.a$j$a, reason: collision with other inner class name */
        public class C0294a extends b1 {
            public C0294a() {
            }

            @Override // com.beizi.fusion.sa
            public void a(nc ncVar) {
            }

            @Override // com.beizi.fusion.b1
            public void a(ra raVar) {
                JSONArray jSONArrayB;
                if (raVar != null) {
                    String strB = raVar.b();
                    if (TextUtils.isEmpty(strB) || (jSONArrayB = mg.b(strB)) == null || jSONArrayB.length() <= 0) {
                        return;
                    }
                    for (int i = 0; i < jSONArrayB.length(); i++) {
                        String strA = mg.a(jSONArrayB, i);
                        if (!TextUtils.isEmpty(strA)) {
                            j jVar = j.this;
                            jVar.c.c(new i(jVar.b, strA));
                        }
                    }
                }
            }
        }

        private j(Context context, String str, fb fbVar) {
            this.b = context.getApplicationContext();
            this.f26987a = str;
            this.c = fbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            u9 u9Var = (u9) o0.a().b(this.b);
            String strE = ((com.beizi.fusion.g) com.beizi.fusion.h.a().b(this.b)).a().e();
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            u9Var.a(this.f26987a + "?id=" + f3.c(strE), new C0294a());
        }
    }

    public interface k {
        void a(String str);

        void a(String str, h hVar);
    }

    public a(Context context) {
        this.c = context.getApplicationContext();
        this.b = (l) m.a().b(context);
        fb fbVar = (fb) cn.a().b(null);
        if (fbVar instanceof bn) {
            this.f = ((bn) fbVar).a();
        } else {
            this.f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RequestUrlModel requestUrlModel) {
        if (requestUrlModel != null) {
            String preloadImageUrl = requestUrlModel.getPreloadImageUrl();
            fb fbVar = (fb) cn.a().b(this.c);
            fbVar.b(new j(this.c, preloadImageUrl, fbVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List list) {
        synchronized (this.e) {
            this.e.clear();
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    StrategyModel strategyModel = (StrategyModel) it.next();
                    if (strategyModel != null) {
                        this.e.put(strategyModel.getSpaceID(), strategyModel.getAdCache());
                    }
                }
            }
        }
    }

    public void b() {
        com.beizi.fusion.g gVar = (com.beizi.fusion.g) com.beizi.fusion.h.a().b(this.c);
        gVar.a(new b(gVar));
    }

    /* JADX INFO: renamed from: com.beizi.fusion.a$a, reason: collision with other inner class name */
    public class C0292a implements k {
        public C0292a() {
        }

        @Override // com.beizi.fusion.a.k
        public void a(String str) {
            synchronized (a.this.d) {
                a.this.d.remove(str);
            }
        }

        @Override // com.beizi.fusion.a.k
        public void a(String str, h hVar) {
            synchronized (a.this.d) {
                a.this.d.put(str, hVar);
            }
        }
    }

    public boolean b(String str) {
        synchronized (this.e) {
            boolean z = false;
            if (TextUtils.isEmpty(str) || !this.e.containsKey(str)) {
                return false;
            }
            AdCacheModel adCacheModel = (AdCacheModel) this.e.get(str);
            if (adCacheModel != null && adCacheModel.getEnable() == 1) {
                z = true;
            }
            return z;
        }
    }

    private Set a(Set set, Set set2) {
        HashSet hashSet = new HashSet();
        if (set != null) {
            hashSet.addAll(set);
        }
        if (set2 != null) {
            hashSet.addAll(set2);
        }
        return hashSet;
    }

    public static class h extends cb {
        private final String d;
        private final ScheduledExecutorService e;
        private AdCacheModel f;
        private final k g;
        private volatile boolean h;

        private h(Context context, String str, AdCacheModel adCacheModel, ScheduledExecutorService scheduledExecutorService, k kVar) {
            super(new g(context.getApplicationContext(), str, adCacheModel));
            this.h = false;
            this.e = scheduledExecutorService;
            this.d = str;
            this.g = kVar;
            this.f = adCacheModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void a(AdCacheModel adCacheModel) {
            if (!adCacheModel.equals(this.f)) {
                this.f = adCacheModel;
                f();
                e();
                k kVar = this.g;
                if (kVar != null) {
                    kVar.a(this.d, this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean d() {
            return this.h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void e() {
            if (this.f.getCacheRefreshInterval() > 0) {
                this.h = true;
                a(0L, this.f.getCacheRefreshInterval(), TimeUnit.MILLISECONDS);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void f() {
            this.h = false;
            c();
            k kVar = this.g;
            if (kVar != null) {
                kVar.a(this.d);
            }
        }

        @Override // com.beizi.fusion.cb
        public ScheduledExecutorService b() {
            return this.e;
        }

        public void a(com.beizi.fusion.d dVar) {
            Runnable runnableA = a();
            if (runnableA instanceof g) {
                ((g) runnableA).a(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.b != null) {
            this.b.a(AdvertCacheDBModel.class, "status = ? OR expireTime < ? ", new String[]{"1", String.valueOf(System.currentTimeMillis())});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        HashMap map;
        synchronized (this.d) {
            Set setKeySet = this.d.keySet();
            synchronized (this.e) {
                map = new HashMap(this.e);
            }
            Set<String> setA = a(setKeySet, map.keySet());
            if (!setA.isEmpty()) {
                for (String str : setA) {
                    h hVar = (h) this.d.get(str);
                    AdCacheModel adCacheModel = (AdCacheModel) map.get(str);
                    if (hVar != null) {
                        if (adCacheModel != null && adCacheModel.getEnable() != 0) {
                            hVar.a(adCacheModel);
                        } else {
                            hVar.f();
                        }
                    } else if (adCacheModel != null && adCacheModel.getEnable() == 1) {
                        this.d.put(str, new h(this.c, str, adCacheModel, this.f, this.g));
                    }
                }
            }
        }
    }

    private void b(List list) {
        l lVar = this.b;
        if (lVar != null) {
            lVar.b();
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((AdvertCacheDBModel) it.next()).getPrimaryID()));
                }
                this.b.a(AdvertCacheDBModel.class, new String[]{"status"}, new String[]{"1"}, arrayList);
                this.b.h();
            } catch (Exception unused) {
            } finally {
                this.b.d();
            }
        }
    }

    public List a(ba baVar) {
        if (baVar == null || TextUtils.isEmpty(baVar.g())) {
            return null;
        }
        String strG = baVar.g();
        if (!b(strG)) {
            return null;
        }
        h hVar = (h) this.d.get(strG);
        if (hVar != null && !hVar.d()) {
            hVar.a(baVar.b());
            hVar.e();
        }
        int iA = baVar.a();
        AdCacheModel adCacheModel = (AdCacheModel) this.e.get(strG);
        if (adCacheModel != null) {
            return a(strG, iA, adCacheModel.getPriorityMode());
        }
        return null;
    }

    private List a(String str, int i2, int i3) {
        String strB;
        l lVar = this.b;
        if (lVar == null) {
            return null;
        }
        if (i3 == 0) {
            strB = lVar.b(AdvertCacheDBModel.COLUMN_CACHE_TIME);
        } else {
            strB = lVar.b("ecpm");
        }
        List listA = this.b.a(AdvertCacheDBModel.class, "cacheKey = ? AND status = ? AND expireTime > ? ", new String[]{str, "0", String.valueOf(System.currentTimeMillis())}, strB, i2);
        if (listA == null || listA.isEmpty()) {
            return null;
        }
        b(listA);
        return listA;
    }

    public void a(String str, AdResponseModel adResponseModel) {
        l lVar;
        List<AdItemModel> listA = a(adResponseModel);
        if (listA == null || listA.isEmpty() || (lVar = this.b) == null) {
            return;
        }
        lVar.b();
        try {
            for (AdItemModel adItemModel : listA) {
                if (adItemModel != null) {
                    AdvertCacheDBModel advertCacheDBModel = new AdvertCacheDBModel();
                    BiddingModel3 biddingModel = adItemModel.getBiddingModel();
                    advertCacheDBModel.setCacheEcpm(String.valueOf(biddingModel != null ? (int) biddingModel.getPrice() : 0));
                    advertCacheDBModel.setCacheTime(String.valueOf(System.currentTimeMillis()));
                    advertCacheDBModel.setExpireTime(adItemModel.getExpired() + "");
                    advertCacheDBModel.setCacheStatus("0");
                    advertCacheDBModel.setCacheKey(str);
                    advertCacheDBModel.setCacheData(adItemModel.toJsonString());
                    this.b.a(advertCacheDBModel);
                }
            }
            this.b.h();
        } catch (Exception unused) {
        } finally {
            this.b.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(String str) {
        l lVar = this.b;
        if (lVar == null) {
            return 0;
        }
        return lVar.a(AdvertCacheDBModel.class, "cacheKey = ? AND status = ? AND expireTime > ? ", new String[]{str, "0", System.currentTimeMillis() + ""}, this.b.b(AdvertCacheDBModel.COLUMN_CACHE_DATA));
    }

    private List a(AdResponseModel adResponseModel) {
        if (adResponseModel != null) {
            return adResponseModel.getAdItemList();
        }
        return null;
    }

    public synchronized View a(String str) {
        if (!this.f26981a.containsKey(str)) {
            return null;
        }
        return (View) this.f26981a.remove(str);
    }

    public synchronized String a(ba baVar, View view) {
        if (baVar == null) {
            return "";
        }
        String strA = a(baVar.g(), baVar.b());
        this.f26981a.put(strA, view);
        return strA;
    }

    private String a(String str, com.beizi.fusion.d dVar) {
        return qh.a(str + dVar.c() + System.currentTimeMillis());
    }

    public void a(List list) {
        if (list == null || this.b == null) {
            return;
        }
        this.b.a(AdvertCacheDBModel.class, new String[]{"status"}, new String[]{"0"}, k5.a(list, new c()));
    }
}
