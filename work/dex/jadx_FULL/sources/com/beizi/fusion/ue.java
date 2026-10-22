package com.beizi.fusion;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.AdvertCacheDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.AdResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ext.ResponseExtModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.s2s.S2SAdVerifyModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.StrategyModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.strategy.cache.AdCacheModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ue extends fa implements ga {
    private static String h = "";
    private final b b;
    private final com.beizi.fusion.d c;
    private final Map d;
    private v e;
    private final fb f;
    private ba g;

    public class a implements pb {
        public a() {
        }

        @Override // com.beizi.fusion.pb
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(StrategyModel strategyModel, String str) {
            if (strategyModel != null) {
                return str.equals(strategyModel.getSpaceID());
            }
            return false;
        }
    }

    public static class b extends u {
        private rc b;

        private b(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(rc rcVar) {
            this.b = rcVar;
        }

        @Override // com.beizi.fusion.u
        public void a(Message message) {
            rc rcVar;
            if (message == null || (rcVar = this.b) == null) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                Object obj = message.obj;
                if (obj instanceof n1) {
                    rcVar.a((n1) obj);
                    return;
                }
                return;
            }
            if (i != 1) {
                return;
            }
            Object obj2 = message.obj;
            if (obj2 instanceof List) {
                rcVar.a((List) obj2);
            }
        }
    }

    public static abstract class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected Context f27828a;
        protected ConfigResponseModel b;
        protected ba c;
        protected CountDownLatch d;
        private g e;
        private Object f;
        protected AdTraceModel g;
        protected volatile boolean h = false;
        private n1 i;

        public e(Context context, ConfigResponseModel configResponseModel, AdTraceModel adTraceModel, ba baVar, CountDownLatch countDownLatch) {
            this.f27828a = context;
            this.b = configResponseModel;
            this.g = adTraceModel;
            this.c = baVar;
            this.d = countDownLatch;
        }

        public void a(g gVar) {
            this.e = gVar;
        }

        public Object b() {
            return this.f;
        }

        public void c() {
            if (this.e != null) {
                this.e.a(e() ? "RunHttp" : "RunLocal");
            }
        }

        public synchronized void d() {
            this.h = true;
            f();
        }

        public abstract boolean e();

        public void f() {
            CountDownLatch countDownLatch = this.d;
            if (countDownLatch != null) {
                countDownLatch.countDown();
                this.d = null;
            }
        }

        public synchronized void a(Object obj) {
            if (this.h) {
                return;
            }
            this.f = obj;
        }

        public void a(n1 n1Var) {
            this.i = n1Var;
        }

        public n1 a() {
            return this.i;
        }
    }

    public class f extends e {
        private final CountDownLatch j;
        private final AdCacheModel k;
        private final com.beizi.fusion.a l;
        private List m;

        public f(Context context, ConfigResponseModel configResponseModel, AdTraceModel adTraceModel, ba baVar, CountDownLatch countDownLatch, CountDownLatch countDownLatch2) {
            super(context, configResponseModel, adTraceModel, baVar, countDownLatch);
            this.j = countDownLatch2;
            this.k = ue.this.b(configResponseModel);
            this.l = (com.beizi.fusion.a) com.beizi.fusion.b.a().b(this.f27828a);
        }

        private List a(List list) {
            JSONObject jSONObjectC;
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdvertCacheDBModel advertCacheDBModel = (AdvertCacheDBModel) it.next();
                if (advertCacheDBModel != null && !TextUtils.isEmpty(advertCacheDBModel.getCacheData()) && (jSONObjectC = mg.c(advertCacheDBModel.getCacheData())) != null) {
                    AdItemModel adItemModel = new AdItemModel(jSONObjectC);
                    if (!adItemModel.hasParseException()) {
                        arrayList.add(adItemModel);
                    }
                }
            }
            return arrayList;
        }

        private long g() {
            long localWaitTime = this.k.getLocalWaitTime();
            long jH = this.c.h() - this.k.getAdvanceTime();
            if (jH > 0 && localWaitTime >= 0) {
                localWaitTime = Math.min(localWaitTime, jH);
            }
            if (localWaitTime < 200) {
                return 0L;
            }
            return localWaitTime;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.l.a(this.m);
        }

        @Override // com.beizi.fusion.ue.e
        public synchronized void d() {
            a((Object) null);
            super.d();
            this.j.countDown();
        }

        @Override // com.beizi.fusion.ue.e
        public boolean e() {
            return true;
        }

        @Override // com.beizi.fusion.ue.e
        public void f() {
            super.f();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ue.this.a(this.c)) {
                f();
                return;
            }
            if (!ue.this.a(this.k)) {
                f();
                return;
            }
            long jG = g();
            if (jG > 0) {
                try {
                    this.j.await(jG, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                }
            }
            if (!this.h) {
                List listA = this.l.a(this.c);
                this.m = listA;
                List listA2 = ue.this.a(a(listA), this.c, this.g);
                if (listA2 != null && !listA2.isEmpty()) {
                    a((Object) listA2);
                    c();
                }
            }
            f();
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f27829a;
        private final Map b;

        private g(Map map) {
            this.f27829a = new Object();
            this.b = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            e eVar;
            synchronized (this.f27829a) {
                Map map = this.b;
                if (map != null && (eVar = (e) map.get(str)) != null) {
                    eVar.d();
                    this.b.clear();
                }
            }
        }
    }

    public class h extends e {
        public h(Context context, ConfigResponseModel configResponseModel, AdTraceModel adTraceModel, ba baVar, CountDownLatch countDownLatch) {
            super(context, configResponseModel, adTraceModel, baVar, countDownLatch);
        }

        private boolean a(AdResponseModel adResponseModel) {
            com.beizi.fusion.d dVarB;
            if (adResponseModel != null) {
                S2SAdVerifyModel s2SAdVerify = adResponseModel.getS2SAdVerify();
                String strB = null;
                String s2sAdType = s2SAdVerify != null ? s2SAdVerify.getS2sAdType() : null;
                ba baVar = this.c;
                if (baVar != null && (dVarB = baVar.b()) != null) {
                    strB = dVarB.b();
                }
                if (!TextUtils.isEmpty(s2sAdType) && !TextUtils.isEmpty(strB) && s2sAdType != null && s2sAdType.equals(strB)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.beizi.fusion.ue.e
        public boolean e() {
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            lm lmVarF = this.c.f();
            if (lmVarF != null) {
                AdResponseModel adResponseModelB = lmVarF.b();
                if (adResponseModelB.hasParseException()) {
                    a(n1.ERROR_RESPONSE_PARSE_FAILED);
                } else if (a(adResponseModelB)) {
                    List listA = ue.this.a(adResponseModelB, this.c, this.g);
                    if (listA == null || listA.isEmpty()) {
                        a(n1.ERROR_NO_FILL);
                    } else {
                        a(listA);
                    }
                } else {
                    a(n1.ERROR_S2S_EXPRESS_TYPE_ERROR);
                }
            }
            f();
        }
    }

    public ue(Context context, com.beizi.fusion.d dVar) {
        super(context);
        this.b = new b(context);
        this.d = new ArrayMap();
        this.c = dVar;
        this.f = (fb) cn.a().b(this.f28103a);
    }

    public class d extends e {
        private final CountDownLatch j;
        private qb k;

        public class a extends qb {
            public a(long j) {
                super(j);
            }

            @Override // com.beizi.fusion.qb
            public void b() {
                d.this.a(n1.ERROR_REQUEST_TIME_OUT);
                d.this.k.a();
                d.this.f();
                d.this.j.countDown();
            }
        }

        public class b extends up {
            public b(Context context) {
                super(context);
            }

            @Override // com.beizi.fusion.up
            public void a(AdResponseModel adResponseModel, n1[] n1VarArr) {
                d.this.a(adResponseModel, n1VarArr[0]);
            }

            @Override // com.beizi.fusion.up
            public void b(nc ncVar) {
                d.this.a(n1.ERROR_REQUEST_FAILED);
                d.this.j.countDown();
                d.this.f();
            }
        }

        public d(Context context, ConfigResponseModel configResponseModel, AdTraceModel adTraceModel, ba baVar, CountDownLatch countDownLatch, CountDownLatch countDownLatch2) {
            super(context, configResponseModel, adTraceModel, baVar, countDownLatch);
            this.j = countDownLatch2;
            a(baVar);
        }

        private void a(ba baVar) {
            if (baVar != null) {
                this.k = new a(baVar.h() > 0 ? baVar.h() : 5000L);
            }
        }

        private void b(AdResponseModel adResponseModel) {
            com.beizi.fusion.g gVar;
            if (adResponseModel == null || adResponseModel.getExtraResponse() == null) {
                return;
            }
            ResponseExtModel extraResponse = adResponseModel.getExtraResponse();
            if (!extraResponse.isUpdateConfig() || (gVar = (com.beizi.fusion.g) com.beizi.fusion.h.a().b(this.f27828a)) == null || gVar.c() >= extraResponse.getUpdateTime()) {
                return;
            }
            gVar.h();
        }

        @Override // com.beizi.fusion.ue.e
        public boolean e() {
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ue.this.a(this.c)) {
                f();
                return;
            }
            if (ue.this.e.y() && !TextUtils.isEmpty(ue.h)) {
                try {
                    AdResponseModel adResponseModel = new AdResponseModel(mg.c(zd.a(this.f27828a.getAssets().open(ue.h))));
                    ue.this.a(adResponseModel);
                    a(adResponseModel);
                    a(ue.this.a(adResponseModel, this.c, this.g));
                    c();
                    f();
                    return;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            qb qbVar = this.k;
            if (qbVar != null) {
                qbVar.c();
            }
            String strA = no.a(ue.this.a(this.b), ue.this.e.z());
            v1 v1Var = new v1(this.f27828a);
            ba baVar = this.c;
            ue ueVar = ue.this;
            v1Var.a(baVar, ueVar.e, ueVar.c, this.g.getRequestTracSessionID(), this.g.getStrategyMD5());
            ue.this.a(strA, v1Var, new b(this.f27828a));
        }

        private void a(AdResponseModel adResponseModel) {
            if (adResponseModel == null || adResponseModel.getExtraResponse() == null) {
                return;
            }
            this.g.setSwitch4VInfo(adResponseModel.getExtraResponse().getSwitchBack());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AdResponseModel adResponseModel, n1 n1Var) {
            if (adResponseModel != null) {
                ue.this.a(adResponseModel);
                a(adResponseModel);
                if (this.h) {
                    com.beizi.fusion.a aVar = (com.beizi.fusion.a) com.beizi.fusion.b.a().b(this.f27828a);
                    if (aVar != null) {
                        aVar.a(this.c.g(), adResponseModel);
                    }
                } else {
                    List listA = ue.this.a(adResponseModel, this.c, this.g);
                    if (listA != null && !listA.isEmpty()) {
                        a(listA);
                        c();
                    }
                }
            } else {
                a(n1Var);
            }
            f();
            b(adResponseModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdCacheModel b(ConfigResponseModel configResponseModel) {
        StrategyModel strategyModel;
        if (configResponseModel == null || (strategyModel = (StrategyModel) k5.a(configResponseModel.getStrategyList(), this.g.g(), new a())) == null) {
            return null;
        }
        return strategyModel.getAdCache();
    }

    @Override // com.beizi.fusion.ga
    public void a(rc rcVar) {
        this.b.a(rcVar);
    }

    @Override // com.beizi.fusion.ga
    public void a(v vVar, ConfigResponseModel configResponseModel, ba baVar, AdTraceModel adTraceModel) {
        this.e = vVar;
        this.g = baVar;
        c cVar = new c(configResponseModel, baVar, adTraceModel);
        fb fbVar = this.f;
        if (fbVar != null) {
            fbVar.f(cVar);
        }
    }

    private List b(List list, ba baVar, AdTraceModel adTraceModel) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdItemModel adItemModel = (AdItemModel) it.next();
            AdTraceModel adTraceModelM165deepCopy = adTraceModel.m165deepCopy();
            adTraceModelM165deepCopy.bindBidModelInfo(adItemModel);
            arrayList.add(rd.a.a(this.f28103a, adItemModel, baVar, adTraceModelM165deepCopy));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ba baVar) {
        return (baVar == null || baVar.f() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdResponseModel adResponseModel) {
        q0 q0Var;
        if (adResponseModel == null || adResponseModel.getExtraResponse() == null || (q0Var = (q0) r0.a().b(this.f28103a)) == null) {
            return;
        }
        q0Var.a(adResponseModel.getExtraResponse().getBlackList());
    }

    private List b(AdResponseModel adResponseModel) {
        if (adResponseModel != null) {
            return adResponseModel.getAdItemList();
        }
        return null;
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AdTraceModel f27827a;
        private final ConfigResponseModel b;
        private final ba c;
        private final q9 d;

        private c(ConfigResponseModel configResponseModel, ba baVar, AdTraceModel adTraceModel) {
            AdTraceModel adTraceModelM165deepCopy = adTraceModel.m165deepCopy();
            this.f27827a = adTraceModelM165deepCopy;
            adTraceModelM165deepCopy.bindInitConfigInfo(ue.this.e);
            adTraceModelM165deepCopy.setRequestStartTs(System.currentTimeMillis());
            this.b = configResponseModel;
            this.c = baVar;
            this.d = (q9) p.a().b(ue.this.f28103a);
        }

        private void a(d dVar, f fVar, h hVar) {
            List list = (List) dVar.b();
            List list2 = (List) fVar.b();
            List list3 = (List) hVar.b();
            if (list == null && list2 == null && list3 == null) {
                if (dVar.a() != null) {
                    a(dVar.a());
                    return;
                } else if (hVar.a() != null) {
                    a(hVar.a());
                    return;
                } else {
                    a(n1.ERROR_NO_FILL);
                    return;
                }
            }
            boolean z = false;
            if (list == null) {
                if (list2 != null) {
                    this.f27827a.setByCacheAd(true);
                    z = true;
                    list = list2;
                } else {
                    list = list3;
                }
            }
            if (!z) {
                fVar.h();
            }
            if (list.isEmpty()) {
                a(n1.ERROR_NO_FILL);
            } else {
                a(list);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ((q0) r0.a().b(ue.this.f28103a)).a(this.c.g(), u7.EVENT_REPORT_LOAD_CODE);
            this.d.a(u7.EVENT_REPORT_REQUEST_CODE, this.f27827a);
            CountDownLatch countDownLatch = new CountDownLatch(3);
            CountDownLatch countDownLatch2 = new CountDownLatch(1);
            ue ueVar = ue.this;
            d dVar = ueVar.new d(ueVar.f28103a, this.b, this.f27827a, this.c, countDownLatch, countDownLatch2);
            ue ueVar2 = ue.this;
            f fVar = ueVar2.new f(ueVar2.f28103a, this.b, this.f27827a, this.c, countDownLatch, countDownLatch2);
            ue ueVar3 = ue.this;
            h hVar = ueVar3.new h(ueVar3.f28103a, this.b, this.f27827a, this.c, countDownLatch);
            ue.this.d.put("RunHttp", dVar);
            ue.this.d.put("RunLocal", fVar);
            g gVar = new g(ue.this.d);
            dVar.a(gVar);
            fVar.a(gVar);
            fb fbVar = ue.this.f;
            if (fbVar != null) {
                fbVar.b(dVar);
                ue.this.f.a(fVar);
                ue.this.f.a(hVar);
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                om.a(e);
            }
            a(dVar, fVar, hVar);
        }

        private void a(List list) {
            this.d.a(u7.EVENT_REPORT_REQUEST_SUCCESS_CODE, this.f27827a);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = list;
            ue.this.b.sendMessage(messageObtain);
        }

        private void a(n1 n1Var) {
            this.f27827a.setRequestFailInfo(n1Var);
            this.d.a(u7.EVENT_REPORT_REQUEST_FAIL_CODE, this.f27827a);
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.obj = n1Var;
            ue.this.b.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a(AdResponseModel adResponseModel, ba baVar, AdTraceModel adTraceModel) {
        return a(b(adResponseModel), baVar, adTraceModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a(List list, ba baVar, AdTraceModel adTraceModel) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return b(list, baVar, adTraceModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AdCacheModel adCacheModel) {
        return adCacheModel != null && adCacheModel.getEnable() == 1;
    }
}
