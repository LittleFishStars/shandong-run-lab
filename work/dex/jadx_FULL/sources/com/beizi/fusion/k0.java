package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.InitTraceModel;
import com.beizi.fusion.asnp.common.analyse.model.IBaseEventReportModel;
import com.beizi.fusion.asnp.common.analyse.model.IStringEventEnum;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class k0 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f27457a;
        private am.f b;
        private am.b c;
        private am.i d;
        private am.d e;
        private am.g f;
        private am.a g;
        private am.h h;
        private am.c i;

        private a(Context context) {
            this.f27457a = context.getApplicationContext();
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(InitTraceModel initTraceModel) {
            this.h = new am.h(initTraceModel.getStartID(), initTraceModel.getRoundTripTime() + "");
            return this;
        }

        private a b() {
            this.c = new am.b(this.f27457a);
            return this;
        }

        private a c() {
            this.e = new am.d(this.f27457a);
            return this;
        }

        private a d() {
            this.b = new am.f(((n) o.a().b(this.f27457a)).b());
            return this;
        }

        private a e() {
            ConfigResponseModel configResponseModelA;
            g gVar = (g) h.a().b(this.f27457a);
            if (gVar != null && (configResponseModelA = gVar.a(true)) != null) {
                this.f = new am.g(configResponseModelA);
            }
            return this;
        }

        private a f() {
            v vVarA;
            g gVar = (g) h.a().b(this.f27457a);
            if (gVar != null && (vVarA = gVar.a()) != null) {
                this.d = new am.i(vVarA);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(AdTraceModel adTraceModel) {
            this.g = new am.a(adTraceModel);
            am.g gVar = this.f;
            if (gVar != null) {
                gVar.a(adTraceModel.getStrategyMD5());
            }
            return this;
        }

        private a a() {
            c();
            e();
            f();
            b();
            d();
            InitTraceModel initTraceModelB = ((g) h.a().b(this.f27457a)).b();
            if (initTraceModelB != null) {
                a(initTraceModelB);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(String str) {
            this.i = new am.c(str);
            return this;
        }

        public IBaseEventReportModel a(IStringEventEnum iStringEventEnum) {
            am amVar = new am(iStringEventEnum);
            amVar.a(this.g);
            amVar.a(this.c);
            amVar.a(this.e);
            amVar.a((am.e) null);
            amVar.a(this.b);
            amVar.a(this.f);
            amVar.a(this.d);
            amVar.a(this.h);
            amVar.a(this.i);
            return amVar;
        }
    }

    public static IBaseEventReportModel a(Context context, IStringEventEnum iStringEventEnum, InitTraceModel initTraceModel) {
        return new a(context).a(initTraceModel).a(iStringEventEnum);
    }

    public static IBaseEventReportModel a(Context context, IStringEventEnum iStringEventEnum, AdTraceModel adTraceModel) {
        return new a(context).a(adTraceModel).a(iStringEventEnum);
    }

    public static IBaseEventReportModel a(Context context, IStringEventEnum iStringEventEnum, String str) {
        return new a(context).a(str).a(iStringEventEnum);
    }
}
