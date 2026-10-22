package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.TSensorModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ai extends ua {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private String W;
    private String X;
    private String Y;
    private int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27006a = "-999";
    private long a0;
    private final Context b;
    private int c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public ai(Context context, xa xaVar, AdTraceModel adTraceModel) {
        this.b = context.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(xaVar.getEventCode());
        String str = "";
        sb.append("");
        this.g = sb.toString();
        this.d = adTraceModel.getRequestTracSessionID();
        this.f = System.currentTimeMillis() + "";
        this.c = adTraceModel.getInteractiveType();
        this.e = adTraceModel.getCacheRequestTraceSessionID();
        if (this.c != -1) {
            str = this.c + "";
        }
        this.h = str;
        this.X = adTraceModel.getVideoExtUserID();
        this.Y = adTraceModel.getVideoExtCustomData();
        this.Z = adTraceModel.getByCacheAd();
        this.a0 = adTraceModel.getVideoDuration();
        hf.b viewRecorder = adTraceModel.getViewRecorder();
        if (viewRecorder != null) {
            g(viewRecorder);
            h(viewRecorder);
            f(viewRecorder);
            e(viewRecorder);
            a(viewRecorder);
            b(viewRecorder);
            c(viewRecorder);
            d(viewRecorder);
        }
        we.c sensorRecord = adTraceModel.getSensorRecord();
        if (sensorRecord != null) {
            a(sensorRecord, adTraceModel.getTSensorModel());
            a(this.c, adTraceModel.getTSensorModel());
        }
    }

    private void a(int i, TSensorModel tSensorModel) {
        if (tSensorModel == null || tSensorModel.getSld() == null) {
            return;
        }
        if (i == dd.a.CLICK_INTERACTIVE_TRIGGER.getEventCode() || i == dd.a.OPTIMIZE_INTERACTIVE_TRIGGER.getEventCode() || i == dd.a.INVOKE_INTERACTIVE_TRIGGER.getEventCode() || i == dd.a.LANDING_PAGE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.W = tSensorModel.getSld().getClk();
            return;
        }
        if (i == dd.a.GESTURE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.W = tSensorModel.getSld().getScroll();
            return;
        }
        if (i == dd.a.SHAKE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.W = tSensorModel.getSld().getShake();
        } else if (i == dd.a.EULER_INTERACTIVE_TRIGGER.getEventCode()) {
            this.W = tSensorModel.getSld().getTurn();
        } else {
            this.W = tSensorModel.getSld().getOther();
        }
    }

    private void b(hf.b bVar) {
        float fE = bVar.e();
        float fB = bVar.b();
        if (this.c != dd.a.CLICK_INTERACTIVE_TRIGGER.getEventCode() && this.c != dd.a.GESTURE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.t = "-999";
            this.J = "-999";
            this.x = "-999";
            this.N = "-999";
            this.p = "-999";
            this.F = "-999";
            return;
        }
        this.t = fE + "";
        this.J = a(fE);
        this.x = fE + "";
        this.N = a(fE);
        this.p = fB + "";
        this.F = a(fB);
    }

    private void c(hf.b bVar) {
        float fI = bVar.i();
        float f = bVar.f();
        if (this.c != dd.a.CLICK_INTERACTIVE_TRIGGER.getEventCode() && this.c != dd.a.GESTURE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.u = "-999";
            this.K = "-999";
            this.y = "-999";
            this.O = "-999";
            this.q = "-999";
            this.G = "-999";
            return;
        }
        this.n = bVar.h() + "";
        this.u = fI + "";
        this.K = a(fI);
        this.y = fI + "";
        this.O = a(fI);
        this.q = f + "";
        this.G = a(f);
    }

    private void d(hf.b bVar) {
        float fJ = bVar.j();
        float fG = bVar.g();
        if (this.c != dd.a.CLICK_INTERACTIVE_TRIGGER.getEventCode() && this.c != dd.a.GESTURE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.v = "-999";
            this.L = "-999";
            this.z = "-999";
            this.P = "-999";
            this.r = "-999";
            this.H = "-999";
            return;
        }
        this.v = fJ + "";
        this.L = a(fJ);
        this.z = fJ + "";
        this.P = a(fJ);
        this.r = fG + "";
        this.H = a(fG);
    }

    private void e(hf.b bVar) {
        float fK = bVar.k();
        this.l = fK + "";
        this.D = a(fK);
    }

    private void f(hf.b bVar) {
        float fL = bVar.l();
        this.k = fL + "";
        this.C = a(fL);
    }

    private void g(hf.b bVar) {
        float fM = bVar.m();
        this.i = fM + "";
        this.A = a(fM);
    }

    private void h(hf.b bVar) {
        float fN = bVar.n();
        this.j = fN + "";
        this.B = a(fN);
    }

    private void a(we.c cVar, TSensorModel tSensorModel) {
        if (tSensorModel != null) {
            if (tSensorModel.getType() == 1) {
                this.Q = tSensorModel.getAglx();
                this.R = tSensorModel.getAgly();
                this.S = tSensorModel.getAglz();
                this.T = tSensorModel.getAccx();
                this.U = tSensorModel.getAccy();
                this.V = tSensorModel.getAccz();
            }
            if (tSensorModel.getType() != 2 || cVar == null) {
                return;
            }
            we.b bVarA = cVar.a(1);
            if (bVarA != null) {
                this.T = bVarA.f27907a > ((float) tSensorModel.getAccx()) ? bVarA.f27907a : nl.a(tSensorModel.getAccx());
                this.U = bVarA.b > ((float) tSensorModel.getAccy()) ? bVarA.b : nl.a(tSensorModel.getAccy());
                this.V = bVarA.c > ((float) tSensorModel.getAccz()) ? bVarA.c : nl.a(tSensorModel.getAccz());
            }
            we.b bVarA2 = cVar.a(4);
            if (bVarA2 != null) {
                this.Q = bVarA2.f27907a > ((float) tSensorModel.getAglx()) ? bVarA2.f27907a : nl.a(tSensorModel.getAglx());
                this.R = bVarA2.b > ((float) tSensorModel.getAgly()) ? bVarA2.b : nl.a(tSensorModel.getAgly());
                this.S = bVarA2.c > ((float) tSensorModel.getAglz()) ? bVarA2.c : nl.a(tSensorModel.getAglz());
            }
        }
    }

    private void a(hf.b bVar) {
        float fD = bVar.d();
        float fA = bVar.a();
        if (this.c != dd.a.CLICK_INTERACTIVE_TRIGGER.getEventCode() && this.c != dd.a.GESTURE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.s = "-999";
            this.I = "-999";
            this.w = "-999";
            this.M = "-999";
            this.o = "-999";
            this.E = "-999";
            return;
        }
        this.m = bVar.c() + "";
        this.s = fD + "";
        this.I = a(fD);
        this.w = fD + "";
        this.M = a(fD);
        this.o = fA + "";
        this.E = a(fA);
    }

    private String a(float f) {
        return gn.a.b(this.b, f) + "";
    }
}
