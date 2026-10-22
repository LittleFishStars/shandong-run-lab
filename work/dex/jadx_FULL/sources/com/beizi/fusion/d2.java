package com.beizi.fusion;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.ChannelBidResult;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.unified.BZUnifiedAdActionData;
import com.beizi.fusion.widget.BZLpView;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class d2 extends Observable implements a2 {
    protected f5 E;
    protected int F;
    protected int G;
    protected String H;
    private BZLpView P;
    private boolean Q;
    private ViewGroup R;
    private boolean S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ik f27152a;
    protected EventBean b;
    protected String c;
    protected m3 d;
    protected AdSpacesBean.BuyerBean e;
    protected AdSpacesBean.ForwardBean f;
    protected String h;
    protected String i;
    protected s5 g = null;
    protected b2 j = b2.ADDEFAULT;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private boolean o = false;
    private long p = 0;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private TimerTask u = null;
    private Timer v = null;
    private long w = 0;
    private boolean x = false;
    private String y = "WATERFALL";
    private int z = 0;
    private boolean A = false;
    private boolean B = false;
    private String C = null;
    protected int D = 0;
    protected boolean I = false;
    protected boolean J = false;
    protected long K = 0;
    protected Handler L = new a(Looper.getMainLooper());
    private boolean M = false;
    private boolean N = false;
    private ViewGroup O = null;
    private boolean T = true;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                m3 m3Var = d2.this.d;
                if (m3Var == null || m3Var.n() >= 1 || d2.this.d.z() == 2) {
                    return;
                }
                d2.this.z0();
                return;
            }
            if (i == 2) {
                jh.c("BeiZis", "before handleAdClose");
                d2.this.b0();
                d2.this.y();
            } else if (i == 3 && message.obj != null) {
                d2.this.a(message);
                d2.this.J0();
                if (d2.this.P()) {
                    return;
                }
                d2.this.a(message.arg1);
            }
        }
    }

    public class b implements BZLpView.d {
        public b() {
        }

        @Override // com.beizi.fusion.widget.BZLpView.d
        public void onDetachedFromWindow() {
            d2.this.T();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d2 d2Var = d2.this;
                if (d2Var.T) {
                    d2Var.X();
                    d2.this.T();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean K() {
        return J() && E();
    }

    private boolean Q() {
        ik ikVar = this.f27152a;
        return (ikVar == null || ikVar.c()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        BZLpView bZLpView;
        BZLpView bZLpView2;
        try {
            ViewGroup viewGroup = this.O;
            if (viewGroup != null && (bZLpView2 = this.P) != null) {
                viewGroup.removeView(bZLpView2);
            }
            this.O = null;
            ViewGroup viewGroup2 = this.R;
            if (viewGroup2 != null && (bZLpView = this.P) != null) {
                viewGroup2.removeView(bZLpView);
            }
            this.R = null;
            this.P = null;
        } catch (Throwable unused) {
        }
    }

    private boolean a(String str) {
        return false;
    }

    private void e() {
        Timer timer;
        StringBuilder sb = new StringBuilder();
        sb.append("mAdLifeManager != null ? ");
        sb.append(this.d != null);
        jh.b("BeiZis", sb.toString());
        if (this.d != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("enter cancelExposureTaskIfNeed (System.currentTimeMillis() - mStartLoadTime) = ");
            sb2.append(System.currentTimeMillis() - this.w);
            sb2.append(",mAdLifeManager.getValidExposureTime() = ");
            sb2.append(this.d.A());
            sb2.append(",mExposureTimerTask != null ? ");
            sb2.append(this.u != null);
            sb2.append(",mExposureTimer != null ? ");
            sb2.append(this.v != null);
            jh.b("BeiZis", sb2.toString());
        }
        if (this.d == null || System.currentTimeMillis() - this.w >= this.d.A() || this.u == null || (timer = this.v) == null) {
            return;
        }
        timer.cancel();
        w0();
    }

    public void A() {
        q0();
    }

    public abstract void A0();

    public void B() {
        e0();
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(10140);
        }
    }

    public void B0() {
        try {
            f5 f5Var = this.E;
            if (f5Var == null) {
                this.G = 0;
                return;
            }
            int iC = f5Var.c();
            this.F = iC;
            if (iC != 0) {
                this.G = this.E.e() + 1;
            } else {
                this.G = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void C() {
        m3 m3Var = this.d;
        if (m3Var != null) {
            this.f27152a = m3Var.t();
        }
        AdSpacesBean.BuyerBean buyerBean = this.e;
        if (buyerBean != null) {
            this.c = buyerBean.getBuyerSpaceUuId();
        }
    }

    public void C0() {
    }

    public void D() {
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            ikVar.a().a(this.e, this.f);
        }
    }

    public void D0() {
        this.K = System.currentTimeMillis() + 1000;
    }

    public boolean E() {
        return this.M;
    }

    public void E0() {
        if (J()) {
            c(3);
        }
    }

    public boolean F() {
        return "BPDI".equalsIgnoreCase(l());
    }

    public void F0() {
        if (w() != 3) {
            jh.a("BeiZisBid", "mWorker = " + this + ",set ad suc");
            c(2);
        }
    }

    public boolean G() {
        return "C2S".equalsIgnoreCase(l());
    }

    public abstract void G0();

    public boolean H() {
        return "S2S".equalsIgnoreCase(l());
    }

    public void H0() {
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            ikVar.a().a(this.c, this.b);
        }
    }

    public boolean I() {
        return H() || G();
    }

    public void I0() {
        if (this.d == null || !M()) {
            return;
        }
        m3 m3Var = this.d;
        m3Var.a("290.300", m3Var.p(), new EventItem("290.300", String.valueOf(System.currentTimeMillis()), x(), this.i));
    }

    public boolean J() {
        return G();
    }

    public void J0() {
        if (this.d == null || !M()) {
            return;
        }
        m3 m3Var = this.d;
        m3Var.a("280.500", m3Var.p(), new EventItem("280.500", String.valueOf(System.currentTimeMillis()), x(), this.i));
    }

    public void K0() {
        if (this.d == null || !M()) {
            return;
        }
        m3 m3Var = this.d;
        m3Var.a("255.200", m3Var.p(), new EventItem("255.200", String.valueOf(System.currentTimeMillis()), x(), this.i));
    }

    public boolean L() {
        return J() && !E();
    }

    public void L0() {
        if (this.d == null || !M()) {
            return;
        }
        m3 m3Var = this.d;
        m3Var.a("280.300", m3Var.p(), new EventItem("280.300", String.valueOf(System.currentTimeMillis()), x(), this.i));
    }

    public boolean M() {
        return "WATERFALL".equalsIgnoreCase(l());
    }

    public boolean N() {
        return M() || F();
    }

    public boolean O() {
        return ((this.F == 0 && this.I && !this.J) || this.G == 2) ? false : true;
    }

    public boolean P() {
        return this.A;
    }

    public abstract boolean R();

    public void S() {
    }

    public void T() {
    }

    public void U() {
    }

    public boolean V() {
        m3 m3Var = this.d;
        if (m3Var == null || !m3Var.Q()) {
            return false;
        }
        return N() || I();
    }

    public boolean W() {
        if (this.d != null) {
            jh.b("BeiZis", "adStatus = " + this.d.n());
        }
        m3 m3Var = this.d;
        return m3Var != null && m3Var.n() < 1;
    }

    public void Y() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportAdClick mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 7);
        }
    }

    public void Z() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportAdClickCallBack mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 17);
        }
    }

    public void a(Activity activity) {
    }

    public void a(Context context) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(ViewGroup viewGroup, List list) {
    }

    public void a(UnifiedSplashActionData unifiedSplashActionData) {
    }

    public void a(AdSpacesBean.ForwardBean forwardBean) {
        this.f = forwardBean;
    }

    public void a(ChannelBidResult channelBidResult) {
    }

    public void a(BZUnifiedAdActionData bZUnifiedAdActionData) {
    }

    public void a0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportAdClickClose mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 8);
        }
    }

    public void b(int i) {
    }

    public void b(ChannelBidResult channelBidResult) {
    }

    public void b(String str) {
        this.y = str;
    }

    public void b0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportAdClose mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 9);
        }
    }

    public void c(int i) {
        this.m = i;
    }

    public abstract void c(Map map);

    public void c0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportAdClickCallBack mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 22);
        }
    }

    public void d(int i) {
        this.k = i;
    }

    public abstract void d(Map map);

    public void d0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportAdExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 6);
        }
    }

    public void e0() {
        if (Q()) {
            E0();
            if (L()) {
                j0();
                d(3);
            }
            jh.b("BeiZis", "channel " + this.c + " reportAdLoadFail mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f27152a.h.a(this.c));
            if (K()) {
                return;
            }
            this.f27152a.h.a(this.c, 11);
        }
    }

    public void f() {
        if (this.g == null && this.d != null && Q()) {
            this.g = this.d.a(this);
        }
    }

    public void f0() {
        if (Q()) {
            if (G()) {
                k0();
            }
            if (L()) {
                d(2);
                x0();
            }
            z();
            jh.b("BeiZis", "channel " + this.c + " reportAdLoaded mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f27152a.h.a(this.c));
            if (K()) {
                return;
            }
            this.f27152a.h.a(this.c, 4);
        }
    }

    public void g() {
        Handler handler = this.L;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        X();
    }

    public void g0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportAdRequest mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 3);
        }
    }

    public abstract b2 h();

    public void h0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportAdRewarded mManagerObserver.mChannelResultStatus.getStatus(channel)  = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 12);
        }
    }

    public Map i() {
        Map mapY;
        Object obj;
        try {
            HashMap map = new HashMap();
            m3 m3Var = this.d;
            if (m3Var != null && (mapY = m3Var.y()) != null && mapY.containsKey("materialInfo") && (obj = mapY.get("materialInfo")) != null && (obj instanceof Integer)) {
                map.put("materialInfo", (Integer) obj);
            }
            map.put("auctionInfo", 1);
            map.put("sensorInfo", 1);
            return map;
        } catch (Exception unused) {
            return Collections.EMPTY_MAP;
        }
    }

    public void i0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportAdShow mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 5);
        }
    }

    public List j() {
        Map mapY;
        try {
            m3 m3Var = this.d;
            if (m3Var != null && (mapY = m3Var.y()) != null && mapY.containsKey("orderList")) {
                Object obj = mapY.get("orderList");
                if (obj instanceof List) {
                    return (List) obj;
                }
            }
        } catch (Exception unused) {
        }
        return Collections.EMPTY_LIST;
    }

    public void j0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportParticipateBid mManagerObserver.mBidChannelStatus.getStatus(channel)  = " + this.f27152a.l.a(this.c));
        }
    }

    public int k() {
        oh ohVarD;
        try {
            f5 f5Var = this.E;
            if (f5Var == null || (ohVarD = f5Var.d()) == null) {
                return 0;
            }
            int iA = ohVarD.a();
            if (iA <= 0 || ohVarD.e() == 2) {
                return iA;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public void k0() {
        if (this.f27152a == null || !"C2S".equalsIgnoreCase(l())) {
            return;
        }
        jh.b("BeiZis", "channel " + this.c + " reportC2SPrice mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f27152a.h.a(this.c));
        this.f27152a.h.a(this.c, 20);
    }

    public String l() {
        return this.y;
    }

    public void l0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportChannelClickEnhance GrayPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f27152a.j.a(this.c));
            this.f27152a.j.a(this.c, 1);
        }
    }

    public abstract AdSpacesBean.BuyerBean m();

    public void m0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportChannelClickEnhance LayerPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f27152a.j.a(this.c));
            this.f27152a.j.a(this.c, 3);
        }
    }

    public abstract String n();

    public void n0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportChannelClickEnhance RandomPass mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f27152a.j.a(this.c));
            this.f27152a.j.a(this.c, 2);
        }
    }

    public Map o() {
        return null;
    }

    public void o0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportChannelClickEnhance ReduceArea mManagerObserver.mChannelClickEnhanceStatus.getStatus(channel)  = " + this.f27152a.j.a(this.c));
            this.f27152a.j.a(this.c, 4);
        }
    }

    public JSONObject p() {
        return null;
    }

    public void p0() {
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            ikVar.i.a(this.c, 4);
        }
    }

    public NativeUnifiedAdResponse q() {
        return null;
    }

    public void q0() {
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            ikVar.i.a(this.c, 1);
            this.f27152a.i.a(this.c, 4);
        }
    }

    public View r() {
        return null;
    }

    public void r0() {
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            ikVar.i.a(this.c, 9);
            jh.a("BeiZis", "channel == ---reportComparisonSendLossNotification---" + x());
        }
    }

    public String s() {
        return null;
    }

    public void s0() {
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            ikVar.i.a(this.c, 8);
            jh.a("BeiZis", "channel == ---reportComparisonSendWinNotification---" + x());
        }
    }

    public String t() {
        m3 m3Var;
        if (!"S2S".equals(l()) || (m3Var = this.d) == null) {
            return null;
        }
        String strQ = m3Var.q();
        if (TextUtils.isEmpty(strQ)) {
            return null;
        }
        return strQ;
    }

    public void t0() {
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            ikVar.i.a(this.c, 3);
            jh.a("BeiZis", "channel == ---reportComparisonSuccess---" + x());
        }
    }

    public s5 u() {
        return this.g;
    }

    public void u0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportInitBegin mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 1);
        }
    }

    public int v() {
        return this.D;
    }

    public void v0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportInitEnd mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 2);
        }
    }

    public int w() {
        return this.m;
    }

    public void w0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportNotEnoughExposureTime mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 14);
        }
    }

    public abstract String x();

    public void x0() {
        if (this.f27152a == null || this.B) {
            return;
        }
        jh.b("BeiZis", "channel " + this.c + " reportParticipateBid mManagerObserver.mBidChannelStatus.getStatus(channel)  = " + this.f27152a.l.a(this.c));
        this.B = true;
    }

    public void y() {
        if ((this.q || this.d == null) && !a(x())) {
            return;
        }
        this.d.c(x());
        this.q = true;
        if (this.x) {
            e();
        }
    }

    public void y0() {
        if (this.f27152a != null) {
            jh.b("BeiZis", "channel " + this.c + " reportValidTimeExposure mManagerObserver.mChannelResultStatus.getStatus(channel) = " + this.f27152a.h.a(this.c));
            this.f27152a.h.a(this.c, 13);
        }
    }

    public abstract void z();

    public abstract void z0();

    public void a(AdSpacesBean.BuyerBean buyerBean) {
        this.e = buyerBean;
    }

    public JSONObject b(Map map) {
        if (map == null) {
            return null;
        }
        try {
            if (!map.containsKey("materialInfo")) {
                return null;
            }
            String str = (String) map.get("materialInfo");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.beizi.fusion.a2
    public void c() {
        if (h() != b2.ADSHOW) {
            p0();
        }
    }

    public void d() {
        t0();
    }

    public void a(boolean z) {
        this.o = z;
    }

    public void a(long j) {
        this.p = j;
    }

    public void a(Message message) {
        EventBean eventBean;
        if (this.f27152a == null || (eventBean = this.b) == null) {
            return;
        }
        eventBean.setError(String.valueOf(message.obj));
        this.b.setErrorCode(String.valueOf(message.arg1));
        H0();
        e0();
        this.b.setError(null);
        this.b.setErrorCode(null);
        H0();
    }

    public void e(Map map) {
        Object obj;
        if (map == null) {
            return;
        }
        try {
            if (map.containsKey("rollback4v") && (obj = map.get("rollback4v")) != null && (obj instanceof Integer) && ((Integer) obj).intValue() != 0) {
                nm.a().a(this.d.x(), 2);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void a(int i) {
        AdSpacesBean.BuyerBean buyerBean;
        if (this.j == b2.ADLOAD && (buyerBean = this.e) != null && !TextUtils.isEmpty(buyerBean.getBuyerSpaceUuId()) && !TextUtils.isEmpty(this.d.B()) && this.e.getBuyerSpaceUuId().equals(this.d.B())) {
            this.j = b2.ADFAIL;
            this.d.a(this.e.getBuyerSpaceUuId(), i);
            return;
        }
        this.j = b2.ADFAIL;
        if (this.d == null || this.f == null) {
            return;
        }
        if (W()) {
            this.d.a(this.f.getComponent(), l(), true, i);
        } else {
            jh.c("BeiZis", "fail distribute direct fail");
            this.d.a(i);
        }
    }

    public void a(String str, int i) {
        if (Q()) {
            Message messageObtainMessage = this.L.obtainMessage(3, str);
            messageObtainMessage.arg1 = i;
            this.L.sendMessage(messageObtainMessage);
        }
    }

    public void a(double d) {
        if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
            if ("BEIZI".equalsIgnoreCase(x())) {
                this.e.setAvgPrice(d);
                EventBean eventBean = this.b;
                if (eventBean != null) {
                    eventBean.setBeiZiPrice(String.valueOf(d));
                }
            }
            if (I()) {
                this.e.setBidPrice(d);
                EventBean eventBean2 = this.b;
                if (eventBean2 != null) {
                    eventBean2.setBidPrice(String.valueOf(d));
                }
            }
            H0();
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0154 A[Catch: Exception -> 0x01ad, TryCatch #2 {Exception -> 0x01ad, blocks: (B:6:0x000c, B:9:0x0014, B:12:0x001a, B:15:0x0022, B:18:0x002a, B:20:0x0030, B:21:0x005b, B:25:0x0076, B:56:0x0132, B:58:0x0154, B:65:0x0179, B:67:0x017f, B:69:0x0183, B:71:0x018e, B:81:0x01a1, B:83:0x01a5, B:84:0x01a9, B:79:0x019c, B:80:0x019f, B:60:0x015c, B:61:0x0162, B:64:0x0169, B:54:0x0129, B:26:0x0086), top: B:93:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:59:0x015a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x015c A[Catch: Exception -> 0x01ad, TryCatch #2 {Exception -> 0x01ad, blocks: (B:6:0x000c, B:9:0x0014, B:12:0x001a, B:15:0x0022, B:18:0x002a, B:20:0x0030, B:21:0x005b, B:25:0x0076, B:56:0x0132, B:58:0x0154, B:65:0x0179, B:67:0x017f, B:69:0x0183, B:71:0x018e, B:81:0x01a1, B:83:0x01a5, B:84:0x01a9, B:79:0x019c, B:80:0x019f, B:60:0x015c, B:61:0x0162, B:64:0x0169, B:54:0x0129, B:26:0x0086), top: B:93:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0162 A[Catch: Exception -> 0x01ad, TryCatch #2 {Exception -> 0x01ad, blocks: (B:6:0x000c, B:9:0x0014, B:12:0x001a, B:15:0x0022, B:18:0x002a, B:20:0x0030, B:21:0x005b, B:25:0x0076, B:56:0x0132, B:58:0x0154, B:65:0x0179, B:67:0x017f, B:69:0x0183, B:71:0x018e, B:81:0x01a1, B:83:0x01a5, B:84:0x01a9, B:79:0x019c, B:80:0x019f, B:60:0x015c, B:61:0x0162, B:64:0x0169, B:54:0x0129, B:26:0x0086), top: B:93:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0168  */
    /* JADX WARN: Code duplicated, block: B:64:0x0169 A[Catch: Exception -> 0x01ad, TryCatch #2 {Exception -> 0x01ad, blocks: (B:6:0x000c, B:9:0x0014, B:12:0x001a, B:15:0x0022, B:18:0x002a, B:20:0x0030, B:21:0x005b, B:25:0x0076, B:56:0x0132, B:58:0x0154, B:65:0x0179, B:67:0x017f, B:69:0x0183, B:71:0x018e, B:81:0x01a1, B:83:0x01a5, B:84:0x01a9, B:79:0x019c, B:80:0x019f, B:60:0x015c, B:61:0x0162, B:64:0x0169, B:54:0x0129, B:26:0x0086), top: B:93:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:71:0x018e A[Catch: Exception -> 0x01ad, TryCatch #2 {Exception -> 0x01ad, blocks: (B:6:0x000c, B:9:0x0014, B:12:0x001a, B:15:0x0022, B:18:0x002a, B:20:0x0030, B:21:0x005b, B:25:0x0076, B:56:0x0132, B:58:0x0154, B:65:0x0179, B:67:0x017f, B:69:0x0183, B:71:0x018e, B:81:0x01a1, B:83:0x01a5, B:84:0x01a9, B:79:0x019c, B:80:0x019f, B:60:0x015c, B:61:0x0162, B:64:0x0169, B:54:0x0129, B:26:0x0086), top: B:93:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0191  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a5 A[Catch: Exception -> 0x01ad, TryCatch #2 {Exception -> 0x01ad, blocks: (B:6:0x000c, B:9:0x0014, B:12:0x001a, B:15:0x0022, B:18:0x002a, B:20:0x0030, B:21:0x005b, B:25:0x0076, B:56:0x0132, B:58:0x0154, B:65:0x0179, B:67:0x017f, B:69:0x0183, B:71:0x018e, B:81:0x01a1, B:83:0x01a5, B:84:0x01a9, B:79:0x019c, B:80:0x019f, B:60:0x015c, B:61:0x0162, B:64:0x0169, B:54:0x0129, B:26:0x0086), top: B:93:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01a9 A[Catch: Exception -> 0x01ad, TRY_LEAVE, TryCatch #2 {Exception -> 0x01ad, blocks: (B:6:0x000c, B:9:0x0014, B:12:0x001a, B:15:0x0022, B:18:0x002a, B:20:0x0030, B:21:0x005b, B:25:0x0076, B:56:0x0132, B:58:0x0154, B:65:0x0179, B:67:0x017f, B:69:0x0183, B:71:0x018e, B:81:0x01a1, B:83:0x01a5, B:84:0x01a9, B:79:0x019c, B:80:0x019f, B:60:0x015c, B:61:0x0162, B:64:0x0169, B:54:0x0129, B:26:0x0086), top: B:93:0x000c }] */
    public void a(Context context, ViewGroup viewGroup, String str) {
        f5 f5Var;
        oh ohVarD;
        int width;
        int height;
        int iA;
        int iA2;
        int iA3;
        int iA4;
        View rootView;
        int iD;
        Handler handler;
        if (context == null || viewGroup == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str) && (f5Var = this.E) != null && (ohVarD = f5Var.d()) != null && ohVarD.e() != 0) {
                if (this.Q) {
                    cl clVar = new cl();
                    clVar.f("0");
                    clVar.g("0");
                    clVar.e("100%");
                    clVar.c("100%");
                    ohVarD.b(2);
                    ohVarD.d(1);
                    ohVarD.c(0);
                    ohVarD.a(0);
                    ohVarD.a(clVar);
                    this.E.a(ohVarD);
                    X();
                    this.T = false;
                }
                this.Q = true;
                this.R = viewGroup;
                BZLpView bZLpView = new BZLpView(context);
                this.P = bZLpView;
                bZLpView.setData(str);
                int iB = ohVarD.b();
                cl clVarC = ohVarD.c();
                if (iB != 0 && iB != 1) {
                    width = so.j(context);
                    height = so.g(context) + so.a(context, 44.0f);
                } else {
                    width = viewGroup.getWidth();
                    height = viewGroup.getHeight();
                }
                if (clVarC != null) {
                    try {
                        String strE = clVarC.e();
                        String strC = clVarC.c();
                        String strF = clVarC.f();
                        String strG = clVarC.g();
                        if (strE.endsWith("%")) {
                            iA = (Integer.parseInt(strE.substring(0, strE.indexOf("%"))) * width) / 100;
                        } else {
                            iA = so.a(context, Integer.parseInt(strE));
                        }
                        try {
                            if (strC.endsWith("%")) {
                                iA2 = (Integer.parseInt(strC.substring(0, strC.indexOf("%"))) * height) / 100;
                            } else {
                                iA2 = so.a(context, Integer.parseInt(strC));
                            }
                            try {
                                if (strF.endsWith("%")) {
                                    iA3 = (Integer.parseInt(strF.substring(0, strF.indexOf("%"))) * width) / 100;
                                } else {
                                    iA3 = so.a(context, Integer.parseInt(strF));
                                }
                                try {
                                    if (strG.endsWith("%")) {
                                        iA4 = (Integer.parseInt(strG.substring(0, strG.indexOf("%"))) * height) / 100;
                                    } else {
                                        iA4 = so.a(context, Integer.parseInt(strG));
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    e.printStackTrace();
                                    iA4 = 0;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                iA3 = 0;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            iA2 = 0;
                            iA3 = iA2;
                            e.printStackTrace();
                            iA4 = 0;
                            this.P.setLayoutParams(new FrameLayout.LayoutParams(iA, iA2));
                            this.P.setX(iA3);
                            this.P.setY(iA4);
                            this.P.setOnDetachedFromWindowListener(new b());
                            if (iB == 0) {
                                viewGroup.addView(this.P, 0);
                            } else if (iB == 1) {
                                viewGroup.addView(this.P);
                            } else {
                                rootView = viewGroup.getRootView();
                                if (rootView == null) {
                                    return;
                                }
                                ViewGroup viewGroup2 = (ViewGroup) rootView.findViewById(android.R.id.content);
                                this.O = viewGroup2;
                                viewGroup2.addView(this.P);
                            }
                            iD = ohVarD.d();
                            if (iD > 0) {
                                handler.postDelayed(new c(), iD);
                            }
                            if (iB == 0) {
                                this.S = true;
                            } else if (iA3 >= width) {
                                this.S = true;
                            } else {
                                this.S = true;
                            }
                            if (this.S) {
                                T();
                            } else {
                                S();
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        iA = 0;
                        iA2 = 0;
                    }
                } else {
                    iA4 = 0;
                    iA = 0;
                    iA2 = 0;
                    iA3 = 0;
                }
                this.P.setLayoutParams(new FrameLayout.LayoutParams(iA, iA2));
                this.P.setX(iA3);
                this.P.setY(iA4);
                this.P.setOnDetachedFromWindowListener(new b());
                if (iB == 0) {
                    viewGroup.addView(this.P, 0);
                } else if (iB == 1) {
                    viewGroup.addView(this.P);
                } else {
                    rootView = viewGroup.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup3 = (ViewGroup) rootView.findViewById(android.R.id.content);
                    this.O = viewGroup3;
                    viewGroup3.addView(this.P);
                }
                iD = ohVarD.d();
                if (iD > 0 && (handler = this.L) != null) {
                    handler.postDelayed(new c(), iD);
                }
                if (iB == 0) {
                    this.S = true;
                } else if ((iA3 >= width && iA3 > (-width)) || (iA4 < height && iA4 > (-height))) {
                    this.S = false;
                } else {
                    this.S = true;
                }
                if (this.S) {
                    T();
                } else {
                    S();
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public String a(Map map) {
        if (map == null) {
            return null;
        }
        try {
            if (!map.containsKey("auctionInfo")) {
                return null;
            }
            String str = (String) map.get("auctionInfo");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        } catch (Exception unused) {
            return null;
        }
    }
}
