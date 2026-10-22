package com.beizi.fusion;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.anim.RenderAnimModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.notify.NotifyPropModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class fi extends b6 {
    protected final Map t;
    protected final Map u;
    protected final List v;
    protected final Map w;
    protected final AtomicInteger x;
    private boolean y;
    private final b z;

    public class a extends c {
        public a() {
            super("CAROUSEL");
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.ud
        public void a(View view) {
            super.a(view);
            View view2 = fi.this.q;
            if (view2 instanceof ScopeExpressContainer) {
                ScopeExpressContainer.d.a((ScopeExpressContainer) view2, view);
            }
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.ud
        public void f() {
            super.f();
            if (fi.this.x.decrementAndGet() == 0) {
                fi.this.p.g();
            }
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.td
        public void onAdClicked() {
            super.onAdClicked();
            View view = fi.this.q;
            if (view instanceof ScopeExpressContainer) {
                ScopeExpressContainer.d.j((ScopeExpressContainer) view);
            }
        }
    }

    public class c extends b6.a {
        protected String b;
        protected String c;
        protected final String d;

        public c(String str) {
            super();
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            this.c = str;
        }

        public void a(String str) {
            this.b = str;
        }

        @Override // com.beizi.fusion.b6.a
        public boolean l() {
            return "PRIMARY".equals(this.d);
        }
    }

    public class d extends c {
        public d() {
            super("NOTIFY");
        }

        private void c(String str) {
            f fVar;
            if (m() == null || (fVar = (f) fi.this.u.get(this.c)) == null) {
                return;
            }
            fVar.a(str);
        }

        private pd m() {
            return (pd) fi.this.t.get(this.b);
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.ud
        public void a(View view) {
            f fVar;
            c("ready");
            fi fiVar = fi.this;
            if (!fiVar.y || fiVar.u == null || m() == null || (fVar = (f) fi.this.u.get(this.c)) == null) {
                return;
            }
            fVar.f();
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.sd
        public void b() {
            f fVar;
            super.b();
            if (fi.this.u == null || m() == null || (fVar = (f) fi.this.u.get(this.c)) == null) {
                return;
            }
            fVar.d();
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.ud
        public void f() {
            c("error");
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.td
        public void onAdClicked() {
            f fVar;
            super.onAdClicked();
            if (fi.this.u == null || m() == null || (fVar = (f) fi.this.u.get(this.c)) == null) {
                return;
            }
            fVar.a();
            fVar.e();
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static int f27300a = 17;
        static int b = 18;

        public abstract void a();

        public abstract void a(String str);

        public abstract String b();

        public abstract void c();

        public abstract void d();

        public abstract void e();

        public abstract void f();

        public abstract void g();
    }

    public class g extends c {
        public g() {
            super("PRIMARY");
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.sd
        public void b() {
            f fVar;
            fi fiVar = fi.this;
            fiVar.y = true;
            if (fiVar.v.isEmpty()) {
                super.b();
            }
            Map map = fi.this.u;
            if (map != null && (fVar = (f) map.get(this.c)) != null && "ready".equals(fVar.b())) {
                fVar.f();
            }
            ScopeExpressContainer.d.i((ScopeExpressContainer) fi.this.q);
        }

        @Override // com.beizi.fusion.b6.a, com.beizi.fusion.sd
        public void onAdClosed() {
            super.onAdClosed();
            fi.this.y = false;
        }
    }

    public fi(Context context, ba baVar, com.beizi.fusion.d dVar) {
        super(context, baVar, dVar);
        this.y = false;
        this.t = new HashMap();
        this.v = new ArrayList();
        this.w = new HashMap();
        this.u = new HashMap();
        this.z = new b(this.b.getApplicationContext());
        this.x = new AtomicInteger();
    }

    private e a(NotifyPropModel notifyPropModel) {
        if (notifyPropModel != null) {
            return new e(notifyPropModel);
        }
        return null;
    }

    private List p() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.t.values());
        arrayList.addAll(this.v);
        return arrayList;
    }

    private void r() {
        List list = this.v;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((pd) it.next()).b();
            }
            this.v.clear();
        }
    }

    private void s() {
        Map map = this.t;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((pd) it.next()).b();
            }
            this.t.clear();
        }
        Map map2 = this.u;
        if (map2 != null) {
            Iterator it2 = map2.values().iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).c();
            }
            this.u.clear();
        }
    }

    @Override // com.beizi.fusion.b6
    public pd b(rd rdVar) {
        wo woVarD = d(rdVar);
        AdItemModel adItemModelC = rdVar.c();
        if (adItemModelC != null) {
            if (a(this.p)) {
                ((c) this.p).a(adItemModelC.getBindId());
            }
            NotifyPropModel notifyProp = adItemModelC.getNotifyProp();
            if (notifyProp != null) {
                e eVarA = a(adItemModelC.getNotifyProp());
                String bindId = notifyProp.getBindId();
                if (a(this.p)) {
                    ((c) this.p).b(bindId);
                }
                if (eVarA != null && !TextUtils.isEmpty(bindId)) {
                    this.u.put(bindId, eVarA);
                }
            }
        }
        woVarD.a((td) this.p);
        woVarD.a((sd) this.p);
        woVarD.a((vd) this.p);
        return woVarD;
    }

    public wo c(rd rdVar) {
        return new wo(rdVar);
    }

    public wo d(rd rdVar) {
        return new wo(rdVar);
    }

    @Override // com.beizi.fusion.b6
    public b6.a j() {
        return new g();
    }

    @Override // com.beizi.fusion.b6
    public void k() {
        super.k();
        s();
        r();
        b bVar = this.z;
        if (bVar != null) {
            bVar.b();
        }
    }

    public b6.a q() {
        return new a();
    }

    public void t() {
        pd pdVar = this.r;
        if (pdVar != null) {
            pdVar.a((ud) this.p);
        }
        for (pd pdVar2 : p()) {
            pdVar2.a((ud) this.w.get(Integer.valueOf(pdVar2.hashCode())));
        }
    }

    public class e extends f {
        private final NotifyPropModel c;
        private final RenderAnimModel d;
        private String e;
        private View f;

        private e(NotifyPropModel notifyPropModel) {
            this.e = "idle";
            this.c = notifyPropModel;
            this.d = notifyPropModel.getAnim();
        }

        @Override // com.beizi.fusion.fi.f
        public void a() {
            b bVar = fi.this.z;
            if (bVar == null || !bVar.hasMessages(f.b)) {
                return;
            }
            fi.this.z.removeMessages(f.b);
        }

        @Override // com.beizi.fusion.fi.f
        public String b() {
            return this.e;
        }

        @Override // com.beizi.fusion.fi.f
        public void c() {
            this.e = "";
        }

        @Override // com.beizi.fusion.fi.f
        public void d() {
            if (fi.this.z != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = f.b;
                messageObtain.obj = this;
                fi.this.z.sendMessageDelayed(messageObtain, this.c.getRemain());
            }
        }

        @Override // com.beizi.fusion.fi.f
        public void e() {
            View view = this.f;
            if (view != null) {
                RenderAnimModel renderAnimModel = this.d;
                int direction = renderAnimModel != null ? renderAnimModel.getDirection() : 0;
                RenderAnimModel renderAnimModel2 = this.d;
                zp.b(view, direction, renderAnimModel2 != null ? renderAnimModel2.getDuration() : 0L);
            }
        }

        @Override // com.beizi.fusion.fi.f
        public void f() {
            if (fi.this.z != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = f.f27300a;
                messageObtain.obj = this;
                fi.this.z.sendMessageDelayed(messageObtain, this.c.getDelay());
            }
        }

        @Override // com.beizi.fusion.fi.f
        public void g() {
            pd pdVar = (pd) fi.this.t.get(this.c.getBindId());
            if (pdVar != null) {
                View viewA = pdVar.a();
                this.f = viewA;
                if (fi.this.q instanceof ViewGroup) {
                    viewA.setVisibility(4);
                    View view = this.f;
                    ViewGroup viewGroup = (ViewGroup) fi.this.q;
                    RenderAnimModel renderAnimModel = this.d;
                    int direction = renderAnimModel != null ? renderAnimModel.getDirection() : 0;
                    RenderAnimModel renderAnimModel2 = this.d;
                    zp.a(view, viewGroup, direction, renderAnimModel2 != null ? renderAnimModel2.getDuration() : 0L);
                }
            }
        }

        @Override // com.beizi.fusion.fi.f
        public void a(String str) {
            this.e = str;
        }
    }

    @Override // com.beizi.fusion.b6
    public void a(rd rdVar) {
        AdItemModel adItemModelC;
        if (rdVar == null || (adItemModelC = rdVar.c()) == null) {
            return;
        }
        List listA = a(adItemModelC);
        if (listA == null || listA.isEmpty()) {
            super.a(rdVar);
        } else {
            a(rdVar, listA);
            t();
        }
    }

    public static final class b extends iq {
        public b(Context context) {
            super(context.getApplicationContext());
        }

        private void b(Message message) {
            if (message != null) {
                Object obj = message.obj;
                if (obj instanceof f) {
                    if (message.what == f.f27300a) {
                        ((f) obj).g();
                    }
                    if (message.what == f.b) {
                        ((f) message.obj).e();
                    }
                }
            }
        }

        @Override // com.beizi.fusion.iq
        public void a(Message message) {
            b(message);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (hasMessages(f.f27300a)) {
                removeMessages(f.f27300a);
            }
            if (hasMessages(f.b)) {
                removeMessages(f.b);
            }
        }
    }

    public void a(rd rdVar, List list) {
        this.t.clear();
        this.w.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdItemModel adItemModel = (AdItemModel) it.next();
            if (adItemModel != null) {
                a(rdVar, adItemModel);
            }
        }
    }

    public void a(rd rdVar, AdItemModel adItemModel) {
        if ("NOTIFY".equals(adItemModel.getCategory())) {
            pd pdVarA = a(rdVar, adItemModel, new d());
            if (pdVarA != null) {
                this.t.put(adItemModel.getBindId(), pdVarA);
                return;
            }
            return;
        }
        if ("CAROUSEL".equals(adItemModel.getCategory())) {
            this.x.incrementAndGet();
            this.v.add(a(rdVar, adItemModel, q()));
        }
    }

    private List a(AdItemModel adItemModel) {
        if (adItemModel != null) {
            return adItemModel.getChildAds();
        }
        return null;
    }

    public final boolean a(b6.a aVar) {
        if (aVar != null) {
            return c.class.isAssignableFrom(this.p.getClass());
        }
        return false;
    }

    public pd a(rd rdVar, AdItemModel adItemModel, b6.a aVar) {
        AdItemModel adItemModelC = rdVar.c();
        AdItemModel adItemModelA = a(adItemModelC, adItemModel);
        if (adItemModelA == null) {
            return null;
        }
        Context context = this.b;
        ba baVarB = rdVar.b();
        boolean zIsIndependentAd = adItemModelA.isIndependentAd();
        AdTraceModel adTraceModelA = rdVar.a();
        if (!zIsIndependentAd) {
            adTraceModelA = adTraceModelA.m165deepCopy();
        }
        wo woVarC = c(rd.a.a(context, adItemModelA, baVarB, adTraceModelA));
        if (a(aVar)) {
            ((c) aVar).a(adItemModelA.getBindId());
        }
        woVarC.a((td) aVar);
        woVarC.a((sd) aVar);
        woVarC.a((vd) aVar);
        this.w.put(Integer.valueOf(woVarC.hashCode()), aVar);
        NotifyPropModel notifyProp = adItemModelC.getNotifyProp();
        if (notifyProp != null) {
            e eVarA = a(adItemModelC.getNotifyProp());
            String bindId = notifyProp.getBindId();
            if (a(aVar)) {
                ((c) aVar).b(bindId);
            }
            if (eVarA != null && !TextUtils.isEmpty(bindId)) {
                this.u.put(bindId, eVarA);
            }
        }
        return woVarC;
    }

    public final AdItemModel a(AdItemModel adItemModel, AdItemModel adItemModel2) {
        if (adItemModel2 == null) {
            return null;
        }
        if (adItemModel2.isIndependentAd()) {
            return adItemModel2;
        }
        if (adItemModel == null) {
            return null;
        }
        AdItemModel.AdItemModelWrapper adItemModelWrapper = new AdItemModel.AdItemModelWrapper(adItemModel.asJsonObject());
        adItemModelWrapper.recoverMonitor(adItemModel.getEventModels());
        NativeModel.NativeModelWrapper nativeModelWrapper = new NativeModel.NativeModelWrapper(adItemModel.getNativeModel().asJsonObject());
        NativeModel nativeModel = adItemModel2.getNativeModel();
        if (nativeModel != null) {
            nativeModelWrapper.updateWrapperScheme(nativeModel.getRender());
        }
        adItemModelWrapper.updateWrapperBasicInfo(adItemModel2.getBindId(), adItemModel2.getCategory());
        adItemModelWrapper.updateWrapperNotify(adItemModel2.getNotifyProp());
        adItemModelWrapper.updateWrapperNative(nativeModelWrapper);
        return adItemModelWrapper;
    }
}
