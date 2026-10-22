package com.beizi.fusion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.bzunified.BeiZiUnifiedAdListener;
import com.beizi.fusion.bzunified.BeiZiUnifiedAdResponse;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.ChannelBidResult;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.unified.BZUnifiedAdListener;
import com.beizi.fusion.unified.BZUnifiedAdResponse;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageActivity;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class m3 implements o1, Observer {
    protected static Context X = null;
    private static boolean Y = false;
    private long A;
    private List B;
    private fh D;
    private e E;
    private boolean F;
    private long R;
    private Map S;
    protected boolean T;
    private String W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f27528a;
    protected EventBean b;
    protected ViewGroup c;
    protected String d;
    protected long e;
    protected View f;
    protected i3 g;
    protected d2 h;
    protected String l;
    private m3 n;
    private AdSpacesBean o;
    private long r;
    private ik z;
    protected Map i = new Hashtable();
    protected ArrayList j = new ArrayList();
    protected boolean k = false;
    private boolean m = false;
    private long p = 500;
    private long q = 100;
    private volatile int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 1;
    private int w = 2;
    private Timer x = null;
    private boolean y = false;
    private boolean C = false;
    private boolean G = false;
    private AdSpacesBean H = null;
    private s1 I = null;
    protected boolean J = false;
    private int K = 0;
    private int L = 1;
    private int M = 2;
    protected boolean N = false;
    private boolean O = false;
    private boolean P = false;
    protected d2 Q = null;
    protected Handler U = new a(Looper.getMainLooper());
    private TimerTask V = null;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Log.d("BeiZis", "bid time out");
                m3 m3Var = m3.this;
                m3Var.t = m3Var.v;
                if (m3Var.h != null) {
                    m3Var.b(2);
                    return;
                }
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                m3.this.X();
                ik ikVarG = q1.h().g();
                m3.this.z = new ik(new EventBean(q1.u, "", "", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                m3 m3Var2 = m3.this;
                m3Var2.I = m3Var2.z.a();
                m3 m3Var3 = m3.this;
                m3Var3.b = m3Var3.z.b();
                m3.this.S();
                m3 m3Var4 = m3.this;
                m3Var4.I.a(m3Var4.b);
                m3.this.b();
                if (ikVarG == null || ikVarG.b.a() != 2 || m3.this.z.c.a() != 0) {
                    m3.this.a(10000);
                    return;
                }
                m3.this.z.c.a(1);
                if (m3.this.z.c.a() != 1) {
                    m3.this.z.c.a(-2);
                    m3.this.a("kGetLocalConfigStatusInternalError");
                    return;
                }
                m3.this.z.c.a(2);
                m3 m3Var5 = m3.this;
                m3Var5.o = b5.a(m3Var5.f27528a, m3Var5.l, m3Var5.o());
                m3 m3Var6 = m3.this;
                if (m3Var6.o != null) {
                    m3Var6.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                    return;
                }
                Log.d("BeiZis", "update spaceBean is null and return fail");
                if (m3.this.z.c.a() != 2) {
                    m3.this.z.c.a(-2);
                    m3.this.a("kGetLocalConfigStatusInternalError");
                    return;
                }
                int iA = b5.a();
                if (iA == 1) {
                    m3.this.z.c.a(4);
                    m3.this.a(10001);
                    return;
                } else if (iA == 2) {
                    m3.this.z.c.a(5);
                    m3.this.a(PublishOrgMessageActivity.K);
                    return;
                } else if (iA != 3) {
                    m3.this.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                    return;
                } else {
                    m3.this.z.c.a(6);
                    m3.this.a(10110);
                    return;
                }
            }
            Log.d("BeiZis", "========update inner outTime==========:" + System.currentTimeMillis());
            m3 m3Var7 = m3.this;
            m3Var7.t = m3Var7.w;
            ik ikVar = m3Var7.z;
            if (ikVar != null) {
                ikVar.a(true);
            }
            m3 m3Var8 = m3.this;
            if (m3Var8.z == null) {
                return;
            }
            d2 d2Var = m3Var8.h;
            if (d2Var == null) {
                m3Var8.a(AVMDLDataLoader.KeyIsEnableEventInfo);
                Map mapC = m3.this.C();
                if (mapC != null) {
                    for (d2 d2Var2 : mapC.values()) {
                        AdSpacesBean.BuyerBean buyerBeanM = d2Var2.m();
                        if (buyerBeanM != null) {
                            m3.this.b(d2Var2, 2);
                            jh.a("BeiZis", "AdRequest timeout channel = " + buyerBeanM.getId() + ",mManagerObserver.mChannelResultStatus.getStatus(channel) = " + m3.this.z.h.a(buyerBeanM.getBuyerSpaceUuId()));
                            if (m3.this.z.h.a(buyerBeanM.getBuyerSpaceUuId()) < 4) {
                                m3.this.z.h.a(buyerBeanM.getBuyerSpaceUuId(), -1);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            d2Var.d();
            m3 m3Var9 = m3.this;
            m3Var9.b(m3Var9.h.x(), m3.this.h.r());
            if ("4".equals(m3.this.o())) {
                m3 m3Var10 = m3.this;
                if (!m3Var10.J) {
                    m3Var10.h.G0();
                    m3.this.J = true;
                }
            }
            Map mapC2 = m3.this.C();
            if (mapC2 != null) {
                for (d2 d2Var3 : mapC2.values()) {
                    AdSpacesBean.BuyerBean buyerBeanM2 = d2Var3.m();
                    AdSpacesBean.BuyerBean buyerBeanM3 = m3.this.h.m();
                    if (buyerBeanM2 != null && buyerBeanM3 != null && (TextUtils.isEmpty(buyerBeanM2.getBuyerSpaceUuId()) || TextUtils.isEmpty(buyerBeanM3.getBuyerSpaceUuId()) || !buyerBeanM2.getBuyerSpaceUuId().equals(buyerBeanM3.getBuyerSpaceUuId()))) {
                        m3.this.b(d2Var3, 2);
                        jh.a("BeiZis", "AdRequest timeout channel = " + buyerBeanM2.getId() + ",mManagerObserver.mChannelResultStatus.getStatus(channel) = " + m3.this.z.h.a(buyerBeanM2.getBuyerSpaceUuId()));
                        if (d2Var3.h() == b2.ADDEFAULT) {
                            m3.this.z.h.a(buyerBeanM2.getBuyerSpaceUuId(), -1);
                        }
                    }
                }
            }
        }
    }

    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                Log.d("BeiZis", "========update outTime==========:" + System.currentTimeMillis());
                Handler handler = m3.this.U;
                if (handler != null) {
                    handler.sendEmptyMessage(3);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f27531a;

        public c(ViewGroup viewGroup) {
            this.f27531a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            m3.this.b(this.f27531a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27532a;
        final /* synthetic */ EventItem b;

        public d(String str, EventItem eventItem) {
            this.f27532a = str;
            this.b = eventItem;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                i6.a(m3.this.f27528a).a(this.f27532a, this.b);
            } catch (Exception unused) {
            }
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                int intExtra = intent.getIntExtra("updateResult", 0);
                m3.this.F = true;
                if (TextUtils.equals(action, "com.ad.action.UPDATE_CONFIG_SUCCESS")) {
                    if (intExtra == 1) {
                        Timer timer = m3.this.x;
                        if (timer != null) {
                            timer.cancel();
                            m3.this.x = null;
                        }
                        m3 m3Var = m3.this;
                        m3Var.a(m3Var.c);
                    } else if (intExtra == 0) {
                        m3 m3Var2 = m3.this;
                        if (m3Var2.G) {
                            Timer timer2 = m3Var2.x;
                            if (timer2 != null) {
                                timer2.cancel();
                                m3.this.x = null;
                            }
                            m3 m3Var3 = m3.this;
                            m3Var3.a(m3Var3.c);
                        }
                    }
                }
                m3.this.X();
            } catch (Exception unused) {
            }
        }
    }

    public m3(Context context, String str, i3 i3Var, long j) {
        if (context != null) {
            this.f27528a = context;
            X = context.getApplicationContext();
        }
        this.l = str;
        this.g = i3Var;
        this.e = j;
        this.n = this;
        if (X != null || i3Var == null) {
            return;
        }
        a(10132);
    }

    private boolean E() {
        AdSpacesBean adSpacesBean = this.o;
        if (adSpacesBean == null) {
            return false;
        }
        AdSpacesBean.BidBean bid = adSpacesBean.getBid();
        if (bid != null) {
            this.p = bid.getReserveFRWTime();
            this.q = bid.getReserveTime();
            this.r = bid.getTimeOut();
            if (q1.h().z() && this.r <= 0) {
                this.r = 800L;
            }
        }
        Log.d("BeiZis", this.e + ":mUsableTime=====" + this.p + "=====mLastTime:" + this.q);
        long j = this.e;
        if (j <= this.q) {
            a(10120);
            this.z.c.a(7);
            return true;
        }
        if (j > this.p) {
            U();
        } else {
            this.t = this.v;
        }
        V();
        return false;
    }

    private void F() {
        try {
            if (this.h == null) {
                return;
            }
            d2 d2VarW = w();
            ChannelBidResult channelBidResult = new ChannelBidResult();
            if (d2VarW != null) {
                channelBidResult.setEcpm(c(d2VarW));
                channelBidResult.setChannelName(d2VarW.x());
                channelBidResult.setBidType(d2VarW.l());
            } else {
                channelBidResult.setEcpm(c(this.h));
                channelBidResult.setChannelName(this.h.x());
                channelBidResult.setBidType(this.h.l());
            }
            this.h.b(channelBidResult);
        } catch (Exception unused) {
        }
    }

    private void G() {
        j8.a(X, this.l);
    }

    private void H() {
        if (this.D != null) {
            return;
        }
        this.D = fh.a(X);
        IntentFilter intentFilter = new IntentFilter("com.ad.action.UPDATE_CONFIG_SUCCESS");
        e eVar = new e();
        this.E = eVar;
        this.D.a(eVar, intentFilter);
    }

    private boolean K() {
        Iterator it = C().values().iterator();
        while (it.hasNext()) {
            if (((d2) it.next()).h() == b2.ADDEFAULT) {
                return true;
            }
        }
        return false;
    }

    private boolean L() {
        if (!this.P) {
            return false;
        }
        d2 d2Var = this.Q;
        return d2Var == null || d2Var.h() == b2.ADDEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setReqId(this.d);
            R();
            this.b.setAppId(q1.h().b());
            this.b.setSpaceId(this.l);
            this.b.setReserveTime(String.valueOf(this.e));
        }
    }

    private void T() {
        String str;
        AdSpacesBean adSpacesBean = this.o;
        if (adSpacesBean != null) {
            String adType = adSpacesBean.getAdType();
            adType.getClass();
            switch (adType) {
                case "NATIVE":
                    str = "5";
                    break;
                case "SPLASH":
                    str = "2";
                    break;
                case "INTERSTITIAL":
                    str = "3";
                    break;
                case "REWARDEDVIDEO":
                    str = "1";
                    break;
                case "DRAWFLOW":
                    str = "7";
                    break;
                case "INTERACTIVECARD":
                    str = "13";
                    break;
                case "FULLSCREENVIDEO":
                    str = "6";
                    break;
                case "REGIONALNATIVE":
                    str = "12";
                    break;
                case "BANNER":
                    str = "4";
                    break;
                default:
                    str = null;
                    break;
            }
            EventBean eventBean = this.b;
            if (eventBean != null) {
                eventBean.setAdType(str);
            }
        }
    }

    private void U() {
        if (this.U != null) {
            long jMin = this.e - this.p;
            long j = this.r;
            if (j > 0) {
                jMin = Math.min(jMin, j - 50);
            }
            if (jMin <= 0) {
                jMin = 100;
            }
            this.U.sendEmptyMessageDelayed(1, jMin);
        }
    }

    private void V() {
        if (this.U != null) {
            long jMin = this.e - this.q;
            long j = this.r;
            if (j > 0) {
                jMin = Math.min(jMin, j);
            }
            if (jMin <= 0) {
                jMin = 1000;
            }
            this.U.sendEmptyMessageDelayed(2, jMin);
        }
    }

    private void W() {
        try {
            if (this.F) {
                return;
            }
            H();
            f9.a(X).b(5);
            if (this.x == null) {
                this.x = new Timer();
            }
            if (this.V == null) {
                this.V = new b();
            }
            if (this.x == null || this.V == null) {
                return;
            }
            long jMin = this.e;
            if (jMin > 2000) {
                jMin = 2000;
            }
            long j = this.r;
            if (j > 0) {
                jMin = Math.min(jMin, j);
            }
            this.x.schedule(this.V, jMin);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        e eVar;
        try {
            fh fhVar = this.D;
            if (fhVar == null || (eVar = this.E) == null) {
                return;
            }
            fhVar.a(eVar);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ViewGroup viewGroup) {
        AdSpacesBean.ComponentBean component;
        List<AdSpacesBean.BuyerBean> buyer;
        AdSpacesBean.BidComponent bidComponent;
        List<AdSpacesBean> adSpaces;
        AdSpacesBean adSpacesBean;
        if (this.C || this.f27528a == null || X == null) {
            return;
        }
        this.R = System.currentTimeMillis();
        q1.h().A();
        q1.h().B();
        this.c = viewGroup;
        this.A = System.currentTimeMillis();
        this.d = oo.a();
        ik ikVarG = q1.h().g();
        ik ikVar = new ik(new EventBean(q1.u, "", "", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        this.z = ikVar;
        this.I = ikVar.a();
        this.b = this.z.b();
        S();
        this.I.a(this.b);
        b();
        if (!BeiZis.isIsSyncInit() && ((ikVarG == null || ikVarG.b.a() != 2) && !this.O)) {
            ResponseInfo.getInstance(X).init();
            this.O = true;
        }
        if (ikVarG != null) {
            jh.c("BeiZis", "mInitObserver.mInitStatus.getStatus() = " + ikVarG.b.a() + ",mManagerObserver.mGetLocalConfigStatus.getStatus() = " + this.z.c.a());
        }
        if ((ikVarG == null || ikVarG.b.a() != 2 || this.z.c.a() != 0) && !this.O) {
            if (!this.F) {
                a(10000);
                return;
            } else {
                this.C = false;
                W();
                return;
            }
        }
        this.z.c.a(1);
        if (this.z.c.a() != 1) {
            this.z.c.a(-2);
            a("kGetLocalConfigStatusInternalError");
            return;
        }
        this.z.c.a(2);
        AdSpacesBean adSpacesBeanA = b5.a(this.f27528a, this.l, o());
        this.o = adSpacesBeanA;
        if (adSpacesBeanA == null) {
            Log.d("BeiZis", "spaceBean is null and return fail mUpdateConfigSuccess:" + this.F);
            if (!this.F) {
                Log.e("BeiZis", "startUpdateConfig");
                this.C = false;
                W();
                return;
            }
            if (this.z.c.a() != 2) {
                this.z.c.a(-2);
                a("kGetLocalConfigStatusInternalError");
                return;
            }
            int iA = b5.a();
            if (iA == 1) {
                this.z.c.a(4);
                a(10001);
                return;
            } else if (iA == 2) {
                this.z.c.a(5);
                a(PublishOrgMessageActivity.K);
                return;
            } else {
                if (iA == 3) {
                    this.z.c.a(6);
                    a(10110);
                    return;
                }
                return;
            }
        }
        EventBean eventBean = this.b;
        if (eventBean != null) {
            eventBean.setPlatformFilterSsid(adSpacesBeanA.getFilterSsid());
            this.b.setComponentSsid(this.o.getComponentSsid());
            this.b.setBzComponentSsid(this.o.getBzComponentSsid());
            T();
        }
        ResponseInfo responseInfo = ResponseInfo.getInstance(X);
        Manager manager = responseInfo.getManager();
        if (manager == null || (adSpaces = manager.getAdSpaces()) == null || adSpaces.size() <= 0 || (adSpacesBean = adSpaces.get(0)) == null) {
            component = null;
            buyer = null;
            bidComponent = null;
        } else {
            component = adSpacesBean.getComponent();
            bidComponent = adSpacesBean.getBidComponent();
            buyer = adSpacesBean.getBuyer();
        }
        if ((component == null && bidComponent == null) || buyer == null || buyer.size() <= 0) {
            this.C = false;
            W();
            return;
        }
        long maxValidTime = responseInfo.getMaxValidTime();
        if (maxValidTime == 0) {
            maxValidTime = 2592000000L;
        }
        if (System.currentTimeMillis() - ((Long) co.a(X, "lastUpdateTime", (Object) Long.valueOf(new Date(0L).getTime()))).longValue() > maxValidTime) {
            this.C = false;
            this.G = true;
            W();
            return;
        }
        this.G = false;
        this.C = true;
        if (this.z.c.a() == 2) {
            this.z.c.a(3);
            if (E()) {
                return;
            }
            G();
            if (this.z.c()) {
                this.z.c.a(-1);
            } else {
                a(this.o);
            }
        }
    }

    private void d(Map map) {
        if (map == null || map.size() == 0) {
            D();
            return;
        }
        for (d2 d2Var : map.values()) {
            d2Var.A0();
            d2Var.a(true);
        }
    }

    private String e(String str) {
        jh.a("BeiZis", "enter convertSelfChannel buyerId = " + str);
        return oo.b().equals(str) ? "BEIZI" : str;
    }

    private boolean f(d2 d2Var) {
        if (d2Var == null) {
            return false;
        }
        for (d2 d2Var2 : C().values()) {
            AdSpacesBean.BuyerBean buyerBeanM = d2Var2.m();
            AdSpacesBean.BuyerBean buyerBeanM2 = d2Var.m();
            if (buyerBeanM != null && buyerBeanM2 != null && (TextUtils.isEmpty(buyerBeanM.getBuyerSpaceUuId()) || TextUtils.isEmpty(buyerBeanM2.getBuyerSpaceUuId()) || !buyerBeanM.getBuyerSpaceUuId().equals(buyerBeanM2.getBuyerSpaceUuId()))) {
                if (e(d2Var2) || d(d2Var2)) {
                    double dB = b(d2Var2);
                    if (d2Var2.h() == b2.ADDEFAULT || dB > c(d2Var)) {
                        return false;
                    }
                } else {
                    jh.b("BeiZis", "worker.getAdStatus():" + d2Var2.h() + u15.f19942b + d2Var2.x());
                    if (d2Var2.h() != b2.ADFAIL && c(d2Var2) > c(d2Var)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void g() {
        ik ikVar = this.z;
        if (ikVar == null || ikVar.k.a() != 0) {
            return;
        }
        this.z.k.a(1);
    }

    private boolean h(String str) {
        return false;
    }

    private void i() {
        Handler handler = this.U;
        if (handler != null) {
            handler.removeMessages(1);
        }
        Timer timer = this.x;
        if (timer != null) {
            timer.cancel();
            this.x = null;
        }
    }

    private void j() {
        Handler handler = this.U;
        if (handler != null) {
            handler.removeMessages(2);
        }
        Timer timer = this.x;
        if (timer != null) {
            timer.cancel();
            this.x = null;
        }
    }

    private synchronized void k() {
        this.j.clear();
    }

    private d2 w() {
        Map mapC;
        AdSpacesBean.BuyerBean buyerBeanM;
        try {
            AdSpacesBean.BuyerBean buyerBeanM2 = this.h.m();
            if (buyerBeanM2 != null && (mapC = C()) != null && mapC.size() > 0) {
                d2 d2Var = null;
                for (d2 d2Var2 : mapC.values()) {
                    if (d2Var2 != null && (buyerBeanM = d2Var2.m()) != null && (TextUtils.isEmpty(buyerBeanM.getBuyerSpaceUuId()) || TextUtils.isEmpty(buyerBeanM2.getBuyerSpaceUuId()) || !buyerBeanM.getBuyerSpaceUuId().equals(buyerBeanM2.getBuyerSpaceUuId()))) {
                        if (d2Var2.h() == b2.ADLOAD) {
                            jh.a("BeiZis", "handleSendWinNotice ---getSecondAdWorker---" + d2Var2.h() + "---" + d2Var2.x() + ";getPrice:" + c(d2Var2));
                            if (d2Var == null || c(d2Var2) > c(d2Var)) {
                                d2Var = d2Var2;
                            }
                        }
                    }
                }
                return d2Var;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public int A() {
        AdSpacesBean adSpacesBean = this.o;
        if (adSpacesBean == null || adSpacesBean.getEventStrategy() == null) {
            return Integer.MAX_VALUE;
        }
        AdSpacesBean.EventStrategyBean eventStrategy = this.o.getEventStrategy();
        if (eventStrategy.getValidTimeShow() >= 0) {
            return eventStrategy.getValidTimeShow();
        }
        return Integer.MAX_VALUE;
    }

    public String B() {
        AdSpacesBean.BuyerBean buyerBeanM;
        d2 d2Var = this.h;
        if (d2Var == null || (buyerBeanM = d2Var.m()) == null || TextUtils.isEmpty(buyerBeanM.getBuyerSpaceUuId())) {
            return null;
        }
        return buyerBeanM.getBuyerSpaceUuId();
    }

    public Map C() {
        return this.i;
    }

    public void D() {
        this.z.e.a(3);
        a(10140);
    }

    public boolean I() {
        return Y;
    }

    public boolean J() {
        d2 d2Var = this.h;
        if (d2Var == null) {
            return false;
        }
        return d2Var.R();
    }

    public void M() {
        i3 i3Var = this.g;
        if (i3Var == null || !(i3Var instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) i3Var).onRewarded();
    }

    public void N() {
        i3 i3Var = this.g;
        if (i3Var == null || !(i3Var instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) i3Var).onRewardedVideoCacheSuccess();
    }

    public void O() {
        i3 i3Var = this.g;
        if (i3Var == null || !(i3Var instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) i3Var).onRewardedVideoComplete();
    }

    public void P() {
        i3 i3Var = this.g;
        if (i3Var == null || !(i3Var instanceof RewardedVideoAdListener)) {
            return;
        }
        ((RewardedVideoAdListener) i3Var).onRewardedVideoPlayError();
    }

    public boolean Q() {
        return (n() == 2 || n() == 3) ? false : true;
    }

    public abstract void R();

    public abstract d2 a(AdSpacesBean.ForwardBean forwardBean, String str, AdSpacesBean.BuyerBean buyerBean, List list, d2 d2Var);

    public void a(ViewGroup viewGroup) {
        if (q1.h().x()) {
            v3.b().a().execute(new c(viewGroup));
        } else {
            b(viewGroup);
        }
    }

    public void c() {
        this.N = true;
        i();
        j();
        d2 d2Var = this.h;
        if (d2Var != null) {
            d2Var.g();
        }
        if (this.K != this.L) {
            this.g = null;
        }
        Map map = this.i;
        if (map != null) {
            map.clear();
        }
        ArrayList arrayList = this.j;
        if (arrayList != null) {
            arrayList.clear();
        }
        if (this.n != null) {
            this.n = null;
        }
        X();
        l();
    }

    public void h() {
        ik ikVar = this.z;
        if (ikVar != null) {
            if (ikVar.k.a() == 1 || this.z.k.a() == 3 || this.z.k.a() == 4) {
                this.z.k.a(2);
            }
        }
    }

    public void l() {
        ik ikVar = this.z;
        if (ikVar != null) {
            ikVar.c.deleteObservers();
            this.z.d.deleteObservers();
            this.z.e.deleteObservers();
            this.z.f.deleteObservers();
            this.z.g.deleteObservers();
            this.z.h.deleteObservers();
            this.z.i.deleteObservers();
            this.z.j.deleteObservers();
            this.z.k.deleteObservers();
            this.z.l.deleteObservers();
        }
    }

    public synchronized void m() {
        ArrayList arrayList = this.j;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((a2) obj).c();
        }
        k();
    }

    public int n() {
        return this.s;
    }

    public String o() {
        EventBean eventBean = this.b;
        if (eventBean != null) {
            return eventBean.getAdType();
        }
        return null;
    }

    public String p() {
        return this.l;
    }

    public String q() {
        return this.W;
    }

    public String r() {
        d2 d2Var = this.h;
        if (d2Var == null) {
            return null;
        }
        return d2Var.n();
    }

    public String s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestUuid", this.d);
            a(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public ik t() {
        return this.z;
    }

    public long u() {
        return this.R;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
    }

    public String v() {
        return this.d;
    }

    public String x() {
        AdSpacesBean adSpacesBean = this.H;
        if (adSpacesBean != null) {
            return adSpacesBean.getSpaceId();
        }
        return null;
    }

    public Map y() {
        if (this.S == null) {
            this.S = new HashMap();
        }
        this.S.put("bz_spaceId", this.l);
        return this.S;
    }

    public int z() {
        return this.t;
    }

    public void k(String str) {
        ik ikVar = this.z;
        if (ikVar != null) {
            ikVar.i.a(str, 5);
        }
    }

    private void e() {
        if (this.z != null) {
            jh.c("BeiZis", "mManagerObserver.mManagerResultStatus.getStatus() = " + this.z.k.a());
        }
        ik ikVar = this.z;
        if (ikVar != null) {
            if (ikVar.k.a() == 3 || this.z.k.a() == 1 || this.z.k.a() == 2) {
                this.z.k.a(4);
            }
        }
    }

    private s5 g(String str) {
        l(str);
        return s5.SUCCESS;
    }

    @Override // com.beizi.fusion.o1
    public void a(String str) {
        jh.b("BeiZis", "enter handleAdRequestStatusError error is " + str);
        a(10131);
    }

    public void m(String str) {
        this.W = str;
    }

    private boolean i(String str) {
        return str.equals("HPFRW");
    }

    public void a(String str, String str2, EventItem eventItem) {
        if (Arrays.asList(z5.f28099a).contains(str)) {
            j8.a(str2, eventItem);
            v3.b().a().execute(new d(str2, eventItem));
        }
    }

    public void d(String str) {
        if (this.s < 2 || h(str)) {
            if (this.K == 0) {
                this.K = this.L;
            }
            Log.d("BeiZis", "AdShow:" + str);
            this.s = 2;
            i3 i3Var = this.g;
            if (i3Var != null) {
                if (i3Var instanceof AdListener) {
                    ((AdListener) i3Var).onAdShown();
                } else if (i3Var instanceof RewardedVideoAdListener) {
                    ((RewardedVideoAdListener) i3Var).onRewardedVideoAdShown();
                } else if (i3Var instanceof NativeAdListener) {
                    ((NativeAdListener) i3Var).onAdShown();
                } else if (i3Var instanceof InterstitialAdListener) {
                    ((InterstitialAdListener) i3Var).onAdShown();
                } else if (i3Var instanceof NativeUnifiedAdListener) {
                    ((NativeUnifiedAdListener) i3Var).onAdShown();
                } else if (i3Var instanceof UnifiedSplashAdListener) {
                    ((UnifiedSplashAdListener) i3Var).onAdShown();
                } else if (i3Var instanceof BZUnifiedAdListener) {
                    ((BZUnifiedAdListener) i3Var).onAdShown();
                }
            }
            h();
            m();
        }
    }

    public void j(String str) {
        ik ikVar = this.z;
        if (ikVar != null) {
            ikVar.i.a(str, 4);
        }
    }

    public void a(AdSpacesBean adSpacesBean) {
        if (this.z.c.a() == 3 && this.z.d.a() == 0) {
            this.z.d.a(1);
            this.i.clear();
            AdSpacesBean.FilterBean filter = adSpacesBean.getFilter();
            this.B = adSpacesBean.getBuyer();
            c2.a(this.f27528a, this.e, filter, this.z, p(), null, null, this);
            if (this.z.d.a() == 2) {
                if (this.z.c()) {
                    this.z.d.a(-1);
                    return;
                }
                a("200.000", this.l, new EventItem("200.000", String.valueOf(System.currentTimeMillis()), null, null));
                this.H = adSpacesBean;
                jh.b("BeiZis", "normal request");
                a(this.H.getComponent(), false);
                return;
            }
            a(this.z.d.a(), 6, "platform error = ");
            Log.d("BeiZis", "AdDispenses AdFilter fail:" + s1.a(this.z.d));
            a(10130);
            return;
        }
        this.z.d.a(-2);
        a("kPlatformFilterStatusInternalError");
    }

    public boolean e(d2 d2Var) {
        return "S2S".equalsIgnoreCase(d2Var.l());
    }

    public void f() {
        ik ikVar = this.z;
        if (ikVar != null) {
            if (ikVar.k.a() == 0 || this.z.k.a() == 1) {
                this.z.k.a(5);
            }
        }
    }

    private void l(String str) {
        ik ikVar = this.z;
        if (ikVar != null) {
            ikVar.i.a(str, 3);
        }
    }

    private s5 f(String str) {
        j(str);
        return s5.FAIL;
    }

    public void c(String str) {
        if (this.K == this.L) {
            this.K = this.M;
        }
        i3 i3Var = this.g;
        if (i3Var != null) {
            if (i3Var instanceof AdListener) {
                ((AdListener) i3Var).onAdClosed();
            } else if (i3Var instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) i3Var).onRewardedVideoAdClosed();
            } else if (i3Var instanceof NativeAdListener) {
                ((NativeAdListener) i3Var).onAdClosed();
            } else if (i3Var instanceof InterstitialAdListener) {
                ((InterstitialAdListener) i3Var).onAdClosed();
            } else if (i3Var instanceof UnifiedSplashAdListener) {
                ((UnifiedSplashAdListener) i3Var).onAdClosed();
            }
        }
        e();
    }

    private void d() {
        if (this.z != null) {
            jh.c("BeiZis", "mManagerObserver.mManagerResultStatus.getStatus() = " + this.z.k.a());
        }
        ik ikVar = this.z;
        if (ikVar != null) {
            if (ikVar.k.a() == 1 || this.z.k.a() == 2 || this.z.k.a() == 3) {
                this.z.k.a(3);
            }
        }
    }

    private double c(d2 d2Var) {
        if (d2Var == null || d2Var.m() == null) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        AdSpacesBean.BuyerBean buyerBeanM = d2Var.m();
        if (!d(d2Var) && !e(d2Var)) {
            return buyerBeanM.getAvgPrice();
        }
        if (buyerBeanM.getBidPrice() > AudioStats.AUDIO_AMPLITUDE_NONE) {
            return buyerBeanM.getBidPrice();
        }
        return buyerBeanM.getAvgPrice();
    }

    public void a(AdSpacesBean.ComponentBean componentBean, boolean z) {
        EventBean eventBean;
        jh.a("BeiZis", "enter auctionAndRequestAd");
        if (this.o == null) {
            return;
        }
        List list = this.B;
        if (list != null && list.size() != 0) {
            if (n() >= 1) {
                jh.a("BeiZis", "auctionAndRequestAd ad aleady callback");
                return;
            }
            if (!z) {
                this.z.e.a(1);
            }
            List<AdSpacesBean.ForwardBean> listA = a(componentBean, this.B, z);
            if (!z) {
                this.z.e.a(2);
            }
            ArrayList arrayList = new ArrayList();
            if (listA != null && listA.size() > 0) {
                for (AdSpacesBean.ForwardBean forwardBean : listA) {
                    if (a(forwardBean.getBuyerId(), this.B, forwardBean.getBuyerSpaceUuId()) != null) {
                        arrayList.add(forwardBean);
                    }
                }
            }
            int switchFiveVersion = this.o.getSwitchFiveVersion();
            int iA = nm.a().a(this.o.getSpaceId());
            if (iA == 0) {
                if (switchFiveVersion == 1) {
                    this.T = true;
                }
            } else if (iA == 1) {
                this.T = true;
            }
            if (this.T) {
                if (!TextUtils.isEmpty(this.W) || q1.h().u()) {
                    this.T = false;
                } else {
                    Map map = this.S;
                    if (map != null && (map.containsKey("materialInfo") || this.S.containsKey("returnInteraction"))) {
                        this.T = false;
                    }
                }
            }
            if (this.T && (eventBean = this.b) != null) {
                eventBean.setIsFiveVersion("1");
            }
            d(a(arrayList));
            return;
        }
        jh.a("BeiZis", "auctionAndRequestAd mBuyerBeanList == null ");
    }

    public boolean d(d2 d2Var) {
        return "C2S".equalsIgnoreCase(d2Var.l());
    }

    public void c(Map map) {
        this.S = map;
    }

    private List a(AdSpacesBean.ComponentBean componentBean, List list, boolean z) {
        List listA;
        AdSpacesBean adSpacesBean;
        ArrayList arrayList = new ArrayList();
        if (!z && (adSpacesBean = this.o) != null && adSpacesBean.getBid() != null && this.o.getBidComponent() != null && this.o.getBidComponent().getBidList() != null && this.o.getBidComponent().getBidList().size() > 0) {
            arrayList.addAll(this.o.getBidComponent().getBidList());
        }
        if (this.o != null && componentBean != null && (listA = c2.a(componentBean, list, p())) != null && listA.size() > 0) {
            arrayList.addAll(listA);
        }
        return arrayList;
    }

    public Map a(List list) throws CloneNotSupportedException {
        AdSpacesBean.BuyerBean buyerBeanM168clone;
        if (list == null || list.size() == 0) {
            return null;
        }
        jh.a("BeiZis", "generateWorkers forwardBeans.size() = " + list.size());
        Hashtable hashtable = new Hashtable();
        for (int i = 0; i < list.size(); i++) {
            AdSpacesBean.ForwardBean forwardBean = (AdSpacesBean.ForwardBean) list.get(i);
            if (forwardBean != null) {
                String buyerId = forwardBean.getBuyerId();
                String buyerSpaceUuId = forwardBean.getBuyerSpaceUuId();
                AdSpacesBean.BuyerBean buyerBeanA = a(buyerId, this.B, forwardBean.getBuyerSpaceUuId());
                if (buyerBeanA != null) {
                    try {
                        buyerBeanM168clone = buyerBeanA.m168clone();
                    } catch (CloneNotSupportedException unused) {
                        buyerBeanM168clone = null;
                    }
                    if (buyerBeanM168clone != null) {
                        this.I.a(buyerBeanM168clone, forwardBean);
                        this.z.f.a(buyerSpaceUuId, 1);
                        if (a(forwardBean, buyerBeanM168clone, buyerSpaceUuId)) {
                            d2 d2VarA = a(forwardBean, buyerId, buyerBeanM168clone, buyerBeanM168clone.getRenderView(), null);
                            if (d2VarA != null) {
                                d2VarA.a(forwardBean.getSleepTime());
                                d2VarA.a(forwardBean);
                                d2VarA.a(buyerBeanM168clone);
                                d2VarA.b(buyerBeanM168clone.getBidType());
                                a(buyerId, buyerSpaceUuId, d2VarA);
                                hashtable.put(e(buyerId) + buyerSpaceUuId, d2VarA);
                                jh.a("BeiZis", "generateWorkers put new " + buyerId + " worker into workerList");
                            }
                        }
                    }
                }
            }
        }
        return hashtable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ik ikVar = this.z;
        if (ikVar != null) {
            ikVar.c.addObserver(ikVar);
            ik ikVar2 = this.z;
            ikVar2.d.addObserver(ikVar2);
            ik ikVar3 = this.z;
            ikVar3.e.addObserver(ikVar3);
            ik ikVar4 = this.z;
            ikVar4.f.addObserver(ikVar4);
            ik ikVar5 = this.z;
            ikVar5.g.addObserver(ikVar5);
            ik ikVar6 = this.z;
            ikVar6.h.addObserver(ikVar6);
            ik ikVar7 = this.z;
            ikVar7.i.addObserver(ikVar7);
            ik ikVar8 = this.z;
            ikVar8.j.addObserver(ikVar8);
            ik ikVar9 = this.z;
            ikVar9.k.addObserver(ikVar9);
            ik ikVar10 = this.z;
            ikVar10.l.addObserver(ikVar10);
        }
    }

    private boolean a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean, String str) {
        this.z.f.a(str, 2);
        if (buyerBean != null) {
            try {
                long jLongValue = ((Long) co.a(this.f27528a, "complain_config_" + buyerBean.getSpaceId(), (Object) 0L)).longValue();
                AdSpacesBean.ComplainBean complain = buyerBean.getComplain();
                if (complain != null) {
                    if (System.currentTimeMillis() - jLongValue < complain.getDuration()) {
                        this.z.f.a(str, 10);
                        return false;
                    }
                }
            } catch (Exception unused) {
            }
        }
        c2.a(this.f27528a, this.e, buyerBean.getFilter(), this.z, p(), buyerBean.getBuyerSpaceUuId(), buyerBean.getSpaceId(), this);
        if (this.z.f.a(str) == 3) {
            if (this.z.c()) {
                this.z.f.a(str, -1);
                return false;
            }
            if (a(forwardBean, buyerBean) != 2) {
                return false;
            }
            this.z.f.a(str, 3);
            return true;
        }
        a(this.z.f.a(str), 7, "channel error = ");
        Log.d("BeiZis", "AdDispense buyerBean AdFilter fail:" + s1.a(str, this.z.f));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d2 d2Var, int i) {
        try {
            if (e(d2Var) || d(d2Var)) {
                ChannelBidResult channelBidResult = new ChannelBidResult();
                d2 d2Var2 = this.h;
                if (d2Var2 != null) {
                    channelBidResult.setBidType(d2Var2.l());
                    channelBidResult.setChannelName(this.h.x());
                    channelBidResult.setReason(i);
                    channelBidResult.setEcpm(c(this.h));
                } else {
                    channelBidResult.setEcpm(AudioStats.AUDIO_AMPLITUDE_NONE);
                    channelBidResult.setChannelName("other");
                    channelBidResult.setBidType("other");
                    channelBidResult.setReason(i);
                }
                d2Var.a(channelBidResult);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        a(this.h, i);
        this.h.d();
        b(this.h.x(), this.h.r());
        if (!"4".equals(o()) || this.J) {
            return;
        }
        this.h.G0();
        this.J = true;
    }

    public s5 a(d2 d2Var) {
        AdSpacesBean.BuyerBean buyerBeanM = d2Var.m();
        if (buyerBeanM == null) {
            return null;
        }
        String id = buyerBeanM.getId();
        String buyerSpaceUuId = buyerBeanM.getBuyerSpaceUuId();
        String zone = buyerBeanM.getZone();
        jh.a("BeiZis", "enter comparePrices compareWorker:" + d2Var.x() + ",mCurrentHighestWorker:" + this.h);
        if (h(d2Var.x())) {
            return a(buyerSpaceUuId, d2Var, id);
        }
        ik ikVar = this.z;
        if (ikVar != null) {
            ikVar.i.a(buyerSpaceUuId, 1);
        }
        if (this.s >= 1) {
            b(d2Var, 1);
            return f(buyerSpaceUuId);
        }
        if (L()) {
            return a(buyerSpaceUuId, d2Var);
        }
        boolean zI = i(zone);
        boolean zF = f(d2Var);
        StringBuilder sb = new StringBuilder();
        sb.append("channel == mTimeStage = ");
        sb.append(this.t == this.v);
        sb.append(";isNeedComparePrices = ");
        sb.append(zI);
        sb.append(",isHighestPrice:");
        sb.append(zF);
        sb.append(";mCurrentHighestWorker:");
        sb.append(this.h);
        jh.a("BeiZis", sb.toString());
        if (this.t == this.u && zI && !zF) {
            double dC = c(d2Var);
            double dC2 = c(this.h);
            if (this.h != null && dC <= dC2) {
                b(d2Var, 1);
                if (f(this.h)) {
                    b(1);
                }
                return f(buyerSpaceUuId);
            }
            return a(buyerSpaceUuId, d2Var);
        }
        return a(buyerSpaceUuId, d2Var, id);
    }

    public void b(String str, View view) {
        Log.d("BeiZis", "AdLoaded:" + str);
        if (this.k) {
            return;
        }
        F();
        a(this.h, 1);
        this.k = true;
        this.s = 1;
        i();
        j();
        i3 i3Var = this.g;
        if (i3Var != null) {
            if (i3Var instanceof AdListener) {
                ((AdListener) i3Var).onAdLoaded();
            } else if (i3Var instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) i3Var).onRewardedVideoAdLoaded();
            } else if (i3Var instanceof InterstitialAdListener) {
                ((InterstitialAdListener) i3Var).onAdLoaded();
            } else if (i3Var instanceof NativeAdListener) {
                if (view != null) {
                    d2 d2Var = this.h;
                    if (d2Var != null && d2Var.v() == 1) {
                        ((NativeAdListener) this.g).onAdLoaded(null);
                    } else {
                        d2 d2Var2 = this.h;
                        if (d2Var2 != null && d2Var2.r() != null) {
                            ((NativeAdListener) this.g).onAdLoaded(this.h.r());
                        } else {
                            D();
                        }
                    }
                } else {
                    D();
                }
            } else if (i3Var instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) i3Var).onAdLoaded(this.h.q());
            }
        }
        g();
        Y = true;
    }

    private void a(d2 d2Var, int i) {
        if (d2Var == null) {
            return;
        }
        for (d2 d2Var2 : C().values()) {
            AdSpacesBean.BuyerBean buyerBeanM = d2Var2.m();
            AdSpacesBean.BuyerBean buyerBeanM2 = d2Var.m();
            if (buyerBeanM != null && buyerBeanM2 != null && (TextUtils.isEmpty(buyerBeanM.getBuyerSpaceUuId()) || TextUtils.isEmpty(buyerBeanM2.getBuyerSpaceUuId()) || !buyerBeanM.getBuyerSpaceUuId().equals(buyerBeanM2.getBuyerSpaceUuId()))) {
                b(d2Var2, i);
                if (d2Var2.u() == s5.TO_DETERMINE) {
                    j(buyerBeanM.getBuyerSpaceUuId());
                } else if (d2Var2.h() == b2.ADDEFAULT) {
                    k(buyerBeanM.getBuyerSpaceUuId());
                }
            }
        }
    }

    public void b(String str) {
        i3 i3Var = this.g;
        if (i3Var != null) {
            if (i3Var instanceof AdListener) {
                ((AdListener) i3Var).onAdClicked();
            } else if (i3Var instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) i3Var).onRewardedVideoClick();
            } else if (i3Var instanceof NativeAdListener) {
                ((NativeAdListener) i3Var).onAdClick();
            } else if (i3Var instanceof InterstitialAdListener) {
                ((InterstitialAdListener) i3Var).onAdClick();
            } else if (i3Var instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) i3Var).onAdClick();
            } else if (i3Var instanceof UnifiedSplashAdListener) {
                ((UnifiedSplashAdListener) i3Var).onAdClick();
            } else if (i3Var instanceof BZUnifiedAdListener) {
                ((BZUnifiedAdListener) i3Var).onAdClick();
            }
        }
        d();
    }

    private void a(String str, String str2, d2 d2Var) {
        this.i.put(e(str) + LoginConstants.UNDER_LINE + str2, d2Var);
    }

    public AdSpacesBean.BuyerBean a(String str, List list, String str2) {
        return c2.a(str, list, str2);
    }

    public void a(int i, int i2, String str) {
        if (i != i2 || j8.b(this.l) == null) {
            return;
        }
        j8.d(str + j8.b(this.l).toString());
    }

    private int a(AdSpacesBean.ForwardBean forwardBean, AdSpacesBean.BuyerBean buyerBean) {
        if (forwardBean == null || buyerBean == null) {
            return 0;
        }
        String buyerSpaceUuId = buyerBean.getBuyerSpaceUuId();
        if (this.z.f.a(buyerSpaceUuId) == 3) {
            this.z.g.a(buyerSpaceUuId, 1);
            if (this.z.g.a(buyerSpaceUuId) == 1) {
                if (this.e <= (forwardBean.getSleepTime() + System.currentTimeMillis()) - this.A) {
                    this.z.g.a(buyerSpaceUuId, 4);
                    return 4;
                }
                if (this.z.k.a() == 2) {
                    this.z.g.a(buyerSpaceUuId, 6);
                    return 6;
                }
                jh.a("BeiZis", "mUsableTime = " + this.e + " forwardBean.getSleepTime() + System.currentTimeMillis() - mEnterRequestMethodTime = " + ((forwardBean.getSleepTime() + System.currentTimeMillis()) - this.A) + ",forwardBean.getSleepTime() = " + forwardBean.getSleepTime());
                if (this.z.c()) {
                    this.z.g.a(buyerSpaceUuId, -1);
                    return -1;
                }
                this.z.g.a(buyerSpaceUuId, 2);
                return 2;
            }
        }
        this.z.g.a(buyerSpaceUuId, -2);
        return -2;
    }

    private double b(d2 d2Var) {
        AdSpacesBean.BuyerBean buyerBeanM;
        return (d2Var == null || (buyerBeanM = d2Var.m()) == null) ? AudioStats.AUDIO_AMPLITUDE_NONE : buyerBeanM.getBidPrice();
    }

    public void b(Map map) {
        d2 d2Var = this.h;
        if (d2Var == null || map == null) {
            return;
        }
        d2Var.d(map);
    }

    public void a(AdSpacesBean.ComponentBean componentBean, String str, boolean z, int i) {
        if (componentBean != null && (TextUtils.isEmpty(str) || (!"C2S".equalsIgnoreCase(str) && !"S2S".equalsIgnoreCase(str)))) {
            a(componentBean, true);
            return;
        }
        d2 d2Var = this.h;
        if (d2Var != null && f(d2Var)) {
            b(1);
        } else {
            a(i);
        }
    }

    public void a() {
        d2 d2Var = this.h;
        if (d2Var != null) {
            d2Var.C0();
        }
    }

    public void a(String str, UnifiedSplashAdResponse unifiedSplashAdResponse) {
        Log.d("BeiZis", "AdLoaded:" + str);
        if (this.k) {
            return;
        }
        F();
        a(this.h, 1);
        this.k = true;
        this.s = 1;
        i();
        j();
        i3 i3Var = this.g;
        if (i3Var != null && (i3Var instanceof UnifiedSplashAdListener)) {
            ((UnifiedSplashAdListener) i3Var).onAdLoaded(unifiedSplashAdResponse);
        }
        g();
        Y = true;
    }

    public void a(String str, BeiZiUnifiedAdResponse beiZiUnifiedAdResponse) {
        Log.d("BeiZis", "AdLoaded:" + str);
        if (this.k) {
            return;
        }
        F();
        a(this.h, 1);
        this.k = true;
        this.s = 1;
        i();
        j();
        i3 i3Var = this.g;
        if (i3Var != null && (i3Var instanceof BeiZiUnifiedAdListener)) {
            ((BeiZiUnifiedAdListener) i3Var).onAdLoaded(beiZiUnifiedAdResponse);
        }
        g();
        Y = true;
    }

    public void a(String str, BZUnifiedAdResponse bZUnifiedAdResponse) {
        Log.d("BeiZis", "AdLoaded:" + str);
        if (this.k) {
            return;
        }
        F();
        a(this.h, 1);
        this.k = true;
        this.s = 1;
        i();
        j();
        i3 i3Var = this.g;
        if (i3Var != null && (i3Var instanceof BZUnifiedAdListener)) {
            ((BZUnifiedAdListener) i3Var).onAdLoaded(bZUnifiedAdResponse);
        }
        g();
        Y = true;
    }

    public void a(String str, int i) {
        i3 i3Var = this.g;
        if (i3Var != null) {
            if (i3Var instanceof AdListener) {
                ((AdListener) i3Var).onAdFailedToLoad(i);
            } else if (i3Var instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) i3Var).onRewardedVideoAdFailedToLoad(i);
            } else if (i3Var instanceof NativeAdListener) {
                ((NativeAdListener) i3Var).onAdFailed(i);
            } else if (i3Var instanceof InterstitialAdListener) {
                ((InterstitialAdListener) i3Var).onAdFailed(i);
            } else if (i3Var instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) i3Var).onAdFailed(i);
            } else if (i3Var instanceof UnifiedSplashAdListener) {
                ((UnifiedSplashAdListener) i3Var).onAdFailed(i);
            } else if (i3Var instanceof BeiZiUnifiedAdListener) {
                ((BeiZiUnifiedAdListener) i3Var).onAdFailed(i);
            } else if (i3Var instanceof BZUnifiedAdListener) {
                ((BZUnifiedAdListener) i3Var).onAdFailed(i);
            }
        }
        i();
        j();
        this.s = 3;
        f();
        Y = true;
    }

    public void a(int i) {
        if (i != 10140) {
            if (this.s >= 1) {
                return;
            }
            if (i != 9999 && (L() || K())) {
                return;
            }
        }
        if (q1.h().z() && i == 9999) {
            i = 3;
        }
        i3 i3Var = this.g;
        if (i3Var != null) {
            if (i3Var instanceof AdListener) {
                ((AdListener) i3Var).onAdFailedToLoad(i);
            } else if (i3Var instanceof RewardedVideoAdListener) {
                ((RewardedVideoAdListener) i3Var).onRewardedVideoAdFailedToLoad(i);
            } else if (i3Var instanceof NativeAdListener) {
                ((NativeAdListener) i3Var).onAdFailed(i);
            } else if (i3Var instanceof InterstitialAdListener) {
                ((InterstitialAdListener) i3Var).onAdFailed(i);
            } else if (i3Var instanceof NativeUnifiedAdListener) {
                ((NativeUnifiedAdListener) i3Var).onAdFailed(i);
            } else if (i3Var instanceof UnifiedSplashAdListener) {
                ((UnifiedSplashAdListener) i3Var).onAdFailed(i);
            } else if (i3Var instanceof BeiZiUnifiedAdListener) {
                ((BeiZiUnifiedAdListener) i3Var).onAdFailed(i);
            } else if (i3Var instanceof BZUnifiedAdListener) {
                ((BZUnifiedAdListener) i3Var).onAdFailed(i);
            }
        }
        i();
        j();
        this.s = 3;
        f();
        Y = true;
    }

    public void a(String str, View view) {
        i3 i3Var = this.g;
        if (i3Var != null && view != null && (i3Var instanceof NativeAdListener)) {
            ((NativeAdListener) i3Var).onAdClosed(view);
        }
        e();
    }

    public void a(long j) {
        i3 i3Var = this.g;
        if (i3Var == null || !(i3Var instanceof AdListener)) {
            return;
        }
        ((AdListener) i3Var).onAdTick(j);
    }

    private s5 a(String str, d2 d2Var) {
        jh.a("BeiZis", "comparePrices handleCompeteToDetermine worker:" + d2Var.x());
        this.h = d2Var;
        this.z.i.a(str, 2);
        j();
        return s5.TO_DETERMINE;
    }

    private s5 a(String str, d2 d2Var, String str2) {
        if (!this.y) {
            a(d2Var, str2);
            i();
            j();
            return g(str);
        }
        b(d2Var, 1);
        return f(str);
    }

    private void a(d2 d2Var, String str) {
        this.y = true;
        jh.a("BeiZis", "---handleCompeteSuccess---" + str + "---" + c(d2Var));
        this.h = d2Var;
        a(d2Var, 1);
    }

    public void a(i3 i3Var) {
        this.g = i3Var;
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void a(Map map) {
        if (map == null) {
            return;
        }
        try {
            d2 d2Var = this.h;
            if (d2Var != null) {
                d2Var.c(map);
                return;
            }
            Map mapC = C();
            if (mapC != null && mapC.size() != 0) {
                for (d2 d2Var2 : mapC.values()) {
                    if (d2Var2 != null && d2Var2.x().equalsIgnoreCase("BEIZI")) {
                        d2Var2.c(map);
                        return;
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void a(JSONObject jSONObject) {
        Map map;
        JSONObject jSONObjectP;
        if (jSONObject == null) {
            return;
        }
        try {
            if (this.h != null && (map = this.S) != null && map.containsKey("materialInfo") && (jSONObjectP = this.h.p()) != null && jSONObjectP.has("materialInfo")) {
                jSONObject.put("materialInfo", jSONObjectP.optJSONObject("materialInfo"));
            }
        } catch (Throwable unused) {
        }
    }
}
