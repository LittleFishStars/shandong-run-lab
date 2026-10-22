package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import com.beizi.fusion.asnp.common.analyse.model.IBaseEventReportModel;
import com.beizi.fusion.asnp.common.analyse.model.IStringEventEnum;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class am extends IBaseEventReportModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f27010a;
    private b b;
    private i c;
    private d d;
    private h e;
    private a f;
    private g g;
    private c h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;

    public static final class b extends ua {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27012a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;

        public b(Context context) {
            this.f27012a = xk.d(context);
            this.b = xk.c(context);
            this.c = context.getPackageName();
            this.d = xk.a(context) + "";
            this.e = xk.b(context) + "";
        }
    }

    public static final class c extends ua {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27013a;

        public c(String str) {
            this.f27013a = str;
        }
    }

    public static final class d extends ua {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27014a;
        private final String c = m0.d();
        private final String d = m0.c();
        private final String b = m0.a();
        private final String e = m0.b();
        private final String f = m0.e();
        private final String g = m0.f();
        private final String h = m0.a();

        public d(Context context) {
            this.f27014a = m0.a(context);
        }
    }

    public static final class e extends ua {
    }

    public static final class f extends ua {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27015a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        private final String g;
        private final String h;
        private final String i;
        private final String j;
        private final String k;
        private final String l;
        private final String m;
        private final String n;
        private final String o;
        private final String p;
        private final String q;
        private final String r;
        private final String s;
        private final String t;
        private final String u;
        private final String v;
        private final String w;
        private final String x;
        private final String y;
        private final String z;

        public f(yb ybVar) {
            this.f27015a = ybVar.getOAID();
            this.b = ybVar.m();
            this.c = ybVar.getOAID();
            this.d = ybVar.m();
            this.e = ybVar.b();
            this.f = ybVar.y() + "";
            this.g = ybVar.e();
            this.h = ybVar.h();
            this.i = ybVar.g();
            this.j = ybVar.n();
            this.k = ybVar.l();
            this.l = ybVar.p() + "";
            this.m = ybVar.v() + "";
            this.n = ybVar.i() + "";
            this.o = ybVar.c() + "";
            this.p = ybVar.B() + "";
            this.q = ybVar.j();
            this.r = ybVar.d();
            this.s = ybVar.F();
            this.t = ybVar.D();
            this.u = ybVar.s();
            this.v = ybVar.q();
            this.w = ybVar.A();
            this.x = ybVar.r();
            this.y = ybVar.a() + "";
            this.z = ybVar.E();
        }
    }

    public static final class g extends ua implements tb {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27016a;
        private final String b;
        private String c;
        private final String d;
        private final String e;

        public g(ConfigResponseModel configResponseModel) {
            this.f27016a = configResponseModel.getUpdateMD5();
            this.b = configResponseModel.getRequestUrlMD5();
            this.d = "";
            this.e = configResponseModel.getStatisticsMD5();
        }

        public g a() {
            return new g(this);
        }

        public void a(String str) {
            this.c = str;
        }

        private g(g gVar) {
            this.f27016a = gVar.f27016a;
            this.b = gVar.b;
            this.c = gVar.c;
            this.d = gVar.d;
            this.e = gVar.e;
        }
    }

    public static final class h extends ua implements tb {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27017a;
        private final String b;

        public h(String str, String str2) {
            this.f27017a = str;
            this.b = str2;
        }

        public h a() {
            return new h(this.f27017a, this.b);
        }
    }

    public static final class i extends ua {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27018a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;

        public i(v vVar) {
            this.f27018a = vVar.w();
            boolean zD = vVar.d();
            this.b = vVar.m();
            this.c = vVar.k();
            this.d = (zD ? 1 : 0) + "";
            this.e = a(vVar);
            this.f = vVar.e();
        }

        public String a(v vVar) {
            return mg.a(vVar.s());
        }
    }

    public am(IStringEventEnum iStringEventEnum) {
        super(iStringEventEnum);
        this.k = "";
        this.l = getEventCode();
        this.m = "NSDK";
        String str = System.currentTimeMillis() + "";
        this.i = str;
        this.n = str;
        this.j = nn.c();
    }

    public void a(e eVar) {
    }

    public void a(f fVar) {
        this.f27010a = fVar;
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    @Override // com.beizi.fusion.asnp.common.analyse.model.IBaseEventReportModel
    public am deepCopy() {
        am amVar = new am(this.event);
        f fVar = this.f27010a;
        if (fVar != null) {
            amVar.f27010a = fVar;
        }
        b bVar = this.b;
        if (bVar != null) {
            amVar.b = bVar;
        }
        i iVar = this.c;
        if (iVar != null) {
            amVar.c = iVar;
        }
        d dVar = this.d;
        if (dVar != null) {
            amVar.d = dVar;
        }
        h hVar = this.e;
        if (hVar != null) {
            amVar.e = hVar.a();
        }
        a aVar = this.f;
        if (aVar != null) {
            amVar.f = aVar.a();
        }
        g gVar = this.g;
        if (gVar != null) {
            amVar.g = gVar.a();
        }
        c cVar = this.h;
        if (cVar != null) {
            amVar.h = cVar;
        }
        return amVar;
    }

    public void a(i iVar) {
        this.c = iVar;
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public void a(h hVar) {
        this.e = hVar;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(g gVar) {
        this.g = gVar;
    }

    public void a(c cVar) {
        this.h = cVar;
    }

    public static final class a extends ua implements tb {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27011a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        private final String g;
        private final String h;
        private final String i;
        private final String j;
        private final String k;
        private final String l;
        private final String m;
        private final String n;
        private final String o;
        private final String p;
        private final String q;
        private final String r;
        private final String s;
        private final String t;
        private final String u;
        private final String v;
        private final String w;

        public a(AdTraceModel adTraceModel) {
            String str;
            String str2;
            this.w = adTraceModel.getComplain();
            this.v = adTraceModel.getCreateID();
            this.u = adTraceModel.getRequestCount() + "";
            this.t = adTraceModel.getPrice() + "";
            this.s = adTraceModel.getWinPrice();
            this.r = adTraceModel.getBidResult();
            this.q = adTraceModel.getCurrency();
            this.p = adTraceModel.getAdType().c();
            this.o = adTraceModel.getMaxTimeout() + "";
            this.n = adTraceModel.getMaterialID();
            this.m = adTraceModel.getOrderID();
            this.l = adTraceModel.getErrorMessage();
            if (adTraceModel.getErrorCode() != -1) {
                str = adTraceModel.getErrorCode() + "";
            } else {
                str = "";
            }
            this.k = str;
            if (adTraceModel.getInteractiveType() == -1) {
                str2 = "";
            } else {
                str2 = adTraceModel.getInteractiveType() + "";
            }
            this.j = str2;
            this.i = adTraceModel.getInteractionID();
            this.h = adTraceModel.getSchemeID();
            this.g = adTraceModel.getPrice() + "";
            this.f = adTraceModel.getDspID();
            this.e = adTraceModel.getAdType().c();
            this.d = adTraceModel.getSpaceID();
            this.c = adTraceModel.getCurrentTripTime() + "";
            this.f27011a = adTraceModel.getRequestTracSessionID();
            this.b = adTraceModel.getCacheRequestTraceSessionID();
        }

        public a a() {
            return new a(this);
        }

        private a(a aVar) {
            this.f27011a = aVar.f27011a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.g = aVar.g;
            this.h = aVar.h;
            this.i = aVar.i;
            this.j = aVar.j;
            this.k = aVar.k;
            this.l = aVar.l;
            this.m = aVar.m;
            this.n = aVar.n;
            this.o = aVar.o;
            this.p = aVar.p;
            this.q = aVar.q;
            this.r = aVar.r;
            this.s = aVar.s;
            this.t = aVar.t;
            this.u = aVar.u;
            this.v = aVar.v;
            this.w = aVar.w;
        }
    }
}
