package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alipay.sdk.m.y.l;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.zj.adlib.a7b;
import com.zj.adlib.boa;
import com.zj.adlib.mna;
import com.zj.adlib.nna;
import com.zj.adlib.pna;
import com.zj.adlib.qna;
import com.zj.adlib.sja;
import com.zj.adlib.tna;
import com.zj.adlib.wna;
import com.zj.adlib.yna;
import com.zj.adlib.zwa;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ay f25883a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f716a = "";
    public static String b = "";
    public static boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f717a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nna f722a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pna f723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qna f724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public yna f725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f727a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<ax> f726a = new Vector();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z f720a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public z f728b = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public z f730c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f719a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public mna f721a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f729b = true;

    public interface a {
        void a();

        void a(ax axVar);

        void b(ax axVar);

        void c(ax axVar);
    }

    public class b extends it {
        public final /* synthetic */ String f;

        public b(String str) {
            this.f = str;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            ax axVarH = ay.this.H(this.f);
            if (axVarH != null) {
                try {
                    if (!axVarH.c().equals(axVarH.c) && !axVarH.c().equals(axVarH.e)) {
                        String pinyin = axVarH.getPinyin();
                        if (pinyin.length() > 0) {
                            String strN = ay.this.f725a.n(pinyin);
                            if (strN == null) {
                                strN = axVarH.getVersion();
                            }
                            if (ay.b.length() > 0 && strN != null && ay.n(ay.b, strN)) {
                                axVarH.j();
                            }
                        }
                    }
                    if (ay.this.f718a != null) {
                        synchronized (ay.this) {
                            try {
                                ay.this.f718a.b(axVarH);
                            } catch (Throwable th) {
                                a7b.m(th, "OfflineDownloadManager", "checkUpdatefinally");
                            }
                        }
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    if (ay.this.f718a != null) {
                        synchronized (ay.this) {
                            try {
                                ay.this.f718a.b(axVarH);
                            } catch (Throwable th2) {
                                a7b.m(th2, "OfflineDownloadManager", "checkUpdatefinally");
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    if (ay.this.f718a != null) {
                        synchronized (ay.this) {
                            try {
                                ay.this.f718a.b(axVarH);
                            } catch (Throwable th4) {
                                a7b.m(th4, "OfflineDownloadManager", "checkUpdatefinally");
                            }
                        }
                    }
                    throw th3;
                }
            }
            ay.this.K();
            sja sjaVarC = new com.amap.api.col.p0003l.b(ay.this.f717a, ay.b).c();
            if (ay.this.f718a != null) {
                if (sjaVarC == null) {
                    if (ay.this.f718a != null) {
                        synchronized (ay.this) {
                            try {
                                ay.this.f718a.b(axVarH);
                            } catch (Throwable th5) {
                                a7b.m(th5, "OfflineDownloadManager", "checkUpdatefinally");
                            }
                        }
                        return;
                    }
                    return;
                }
                if (sjaVarC.c()) {
                    ay.this.c();
                }
            }
            if (ay.this.f718a != null) {
                synchronized (ay.this) {
                    try {
                        ay.this.f718a.b(axVarH);
                    } catch (Throwable th6) {
                        a7b.m(th6, "OfflineDownloadManager", "checkUpdatefinally");
                    }
                }
            }
        }
    }

    public class c extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ax f25885a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f732a;

        public c(ax axVar, boolean z) {
            this.f25885a = axVar;
            this.f732a = z;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            try {
                if (this.f25885a.c().equals(this.f25885a.f25880a)) {
                    if (ay.this.f718a != null) {
                        ay.this.f718a.c(this.f25885a);
                        return;
                    }
                    return;
                }
                if (this.f25885a.getState() != 7 && this.f25885a.getState() != -1) {
                    ay.this.f723a.a(this.f25885a);
                    if (ay.this.f718a != null) {
                        ay.this.f718a.c(this.f25885a);
                        return;
                    }
                    return;
                }
                ay.this.f723a.a(this.f25885a);
                if (!this.f732a || ay.this.f718a == null) {
                    return;
                }
                ay.this.f718a.c(this.f25885a);
            } catch (Throwable th) {
                a7b.m(th, "requestDelete", "removeExcecRunnable");
            }
        }
    }

    public class d extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ax f25886a;

        public d(ax axVar) {
            this.f25886a = axVar;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            try {
                if (ay.this.f727a) {
                    ay.this.K();
                    sja sjaVarC = new com.amap.api.col.p0003l.b(ay.this.f717a, ay.b).c();
                    if (sjaVarC != null) {
                        ay.C(ay.this);
                        if (sjaVarC.c()) {
                            ay.this.c();
                        }
                    }
                }
                this.f25886a.setVersion(ay.b);
                this.f25886a.f();
            } catch (AMapException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                a7b.m(th, "OfflineDownloadManager", "startDownloadRunnable");
            }
        }
    }

    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof ax) {
                    ax axVar = (ax) obj;
                    axVar.getCity();
                    axVar.getcompleteCode();
                    axVar.getState();
                    if (ay.this.f718a != null) {
                        ay.this.f718a.a(axVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public ay(Context context) {
        this.f717a = context;
    }

    public static /* synthetic */ boolean C(ay ayVar) {
        ayVar.f727a = false;
        return false;
    }

    public static void L() {
        f25883a = null;
        c = true;
    }

    public static void M(String str) {
        f716a = str;
    }

    public static ay b(Context context) {
        if (f25883a == null) {
            synchronized (ay.class) {
                if (f25883a == null && !c) {
                    f25883a = new ay(context.getApplicationContext());
                }
            }
        }
        return f25883a;
    }

    public static boolean n(String str, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            try {
                if (str.charAt(i) > str2.charAt(i)) {
                    return true;
                }
                if (str.charAt(i) < str2.charAt(i)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final void A(ax axVar) throws AMapException {
        K();
        if (axVar == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        if (this.f730c == null) {
            this.f730c = i.b("AMapOfflineDownload");
        }
        try {
            this.f730c.b(new d(axVar));
        } catch (Throwable th) {
            a7b.m(th, "startDownload", "downloadExcecRunnable");
        }
    }

    public final void B(String str) throws AMapException {
        ax axVarJ = J(str);
        if (axVarJ == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        A(axVarJ);
    }

    public final String D(String str) {
        ax axVarH;
        return (str == null || (axVarH = H(str)) == null) ? "" : axVarH.getAdcode();
    }

    public final void E() {
        try {
            tna tnaVarA = this.f725a.a("000001");
            if (tnaVarA != null) {
                this.f725a.m("000001");
                tnaVarA.b("100000");
                this.f725a.e(tnaVarA);
            }
        } catch (Throwable th) {
            a7b.m(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    public final void F() {
        if ("".equals(zwa.f0(this.f717a))) {
            return;
        }
        File file = new File(zwa.f0(this.f717a) + "offlinemapv4.png");
        String strD = !file.exists() ? boa.d(this.f717a, "offlinemapv4.png") : boa.n(file);
        if (strD != null) {
            try {
                G(strD);
            } catch (JSONException e2) {
                if (file.exists()) {
                    file.delete();
                }
                a7b.m(e2, "MapDownloadManager", "paseJson io");
                e2.printStackTrace();
            }
        }
    }

    public final void G(String str) throws JSONException {
        nna nnaVar;
        List<OfflineMapProvince> listF = boa.f(str, this.f717a.getApplicationContext());
        if (listF == null || listF.size() == 0 || (nnaVar = this.f722a) == null) {
            return;
        }
        nnaVar.i(listF);
    }

    public final ax H(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f726a) {
            for (ax axVar : this.f726a) {
                if (str.equals(axVar.getCity()) || str.equals(axVar.getPinyin())) {
                    return axVar;
                }
            }
            return null;
        }
    }

    public final void I() {
        for (tna tnaVar : this.f725a.c()) {
            if (tnaVar != null && tnaVar.a() != null && tnaVar.e().length() > 0) {
                int i = ((wna) tnaVar).c;
                if (i != 4 && i != 7 && i >= 0) {
                    ((wna) tnaVar).c = 3;
                }
                ax axVarH = H(tnaVar.a());
                if (axVarH != null) {
                    String strC = tnaVar.c();
                    if (strC == null || !n(b, strC)) {
                        axVarH.a(((wna) tnaVar).c);
                        axVarH.setCompleteCode(tnaVar.i());
                    } else {
                        axVarH.a(7);
                    }
                    if (tnaVar.c().length() > 0) {
                        axVarH.setVersion(tnaVar.c());
                    }
                    List<String> listJ = this.f725a.j(tnaVar.e());
                    StringBuffer stringBuffer = new StringBuffer();
                    Iterator<String> it = listJ.iterator();
                    while (it.hasNext()) {
                        stringBuffer.append(it.next());
                        stringBuffer.append(l.b);
                    }
                    axVarH.a(stringBuffer.toString());
                    nna nnaVar = this.f722a;
                    if (nnaVar != null) {
                        nnaVar.c(axVarH);
                    }
                }
            }
        }
    }

    public final ax J(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f726a) {
            for (ax axVar : this.f726a) {
                if (str.equals(axVar.getCode())) {
                    return axVar;
                }
            }
            return null;
        }
    }

    public final void K() throws AMapException {
        if (!zwa.h0(this.f717a)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    public final void N() {
        synchronized (this) {
            this.f718a = null;
        }
    }

    public final void d() {
        this.f725a = yna.b(this.f717a.getApplicationContext());
        E();
        this.f719a = new e(this.f717a.getMainLooper());
        this.f722a = new nna(this.f717a);
        this.f724a = qna.a();
        M(zwa.f0(this.f717a));
        try {
            F();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.f726a) {
            Iterator<OfflineMapProvince> it = this.f722a.b().iterator();
            while (it.hasNext()) {
                for (OfflineMapCity offlineMapCity : it.next().getCityList()) {
                    if (offlineMapCity != null) {
                        this.f726a.add(new ax(this.f717a, offlineMapCity));
                    }
                }
            }
        }
        mna mnaVar = new mna(this.f717a);
        this.f721a = mnaVar;
        mnaVar.start();
    }

    public final void e(ax axVar) {
        f(axVar, false);
    }

    public final void f(ax axVar, boolean z) {
        if (this.f723a == null) {
            this.f723a = new pna(this.f717a);
        }
        if (this.f728b == null) {
            this.f728b = i.b("AMapOfflineRemove");
        }
        try {
            this.f728b.b(new c(axVar, z));
        } catch (Throwable th) {
            a7b.m(th, "requestDelete", "removeExcecRunnable");
        }
    }

    public final void g(a aVar) {
        this.f718a = aVar;
    }

    public final void h(String str) {
        try {
            if (str != null) {
                if (this.f720a == null) {
                    this.f720a = i.b("AMapOfflineCheckUpdate");
                }
                this.f720a.b(new b(str));
            } else {
                a aVar = this.f718a;
                if (aVar != null) {
                    aVar.b(null);
                }
            }
        } catch (Throwable th) {
            a7b.m(th, "OfflineDownloadManager", "checkUpdate");
        }
    }

    public final void j() {
        I();
        a aVar = this.f718a;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Throwable th) {
                a7b.m(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public final void k(ax axVar) {
        try {
            qna qnaVar = this.f724a;
            if (qnaVar != null) {
                qnaVar.c(axVar, this.f717a);
            }
        } catch (ff e2) {
            e2.printStackTrace();
        }
    }

    public final boolean m(String str) {
        return H(str) != null;
    }

    public final void p(ax axVar) {
        nna nnaVar = this.f722a;
        if (nnaVar != null) {
            nnaVar.c(axVar);
        }
        e eVar = this.f719a;
        if (eVar != null) {
            Message messageObtainMessage = eVar.obtainMessage();
            messageObtainMessage.obj = axVar;
            this.f719a.sendMessage(messageObtainMessage);
        }
    }

    public final void q(String str) {
        ax axVarH = H(str);
        if (axVarH != null) {
            t(axVarH);
            f(axVarH, true);
            return;
        }
        a aVar = this.f718a;
        if (aVar != null) {
            try {
                aVar.c(axVarH);
            } catch (Throwable th) {
                a7b.m(th, "OfflineDownloadManager", "remove");
            }
        }
    }

    public final void s() {
        synchronized (this.f726a) {
            for (ax axVar : this.f726a) {
                if (axVar.c().equals(axVar.c) || axVar.c().equals(axVar.b)) {
                    t(axVar);
                    axVar.g();
                }
            }
        }
    }

    public final void t(ax axVar) {
        qna qnaVar = this.f724a;
        if (qnaVar != null) {
            qnaVar.b(axVar);
        }
    }

    public final void u(String str) {
        ax axVarH = H(str);
        if (axVarH != null) {
            axVarH.f();
        }
    }

    public final void v() {
        synchronized (this.f726a) {
            for (ax axVar : this.f726a) {
                if (axVar.c().equals(axVar.c)) {
                    axVar.g();
                    break;
                }
            }
        }
    }

    public final void w(ax axVar) {
        qna qnaVar = this.f724a;
        if (qnaVar != null) {
            qnaVar.e(axVar);
        }
    }

    public final void x(String str) throws AMapException {
        ax axVarH = H(str);
        if (str == null || str.length() <= 0 || axVarH == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        A(axVarH);
    }

    public final void z() {
        z zVar = this.f720a;
        if (zVar != null) {
            zVar.f();
        }
        z zVar2 = this.f730c;
        if (zVar2 != null) {
            zVar2.f();
            this.f730c = null;
        }
        mna mnaVar = this.f721a;
        if (mnaVar != null) {
            if (mnaVar.isAlive()) {
                this.f721a.interrupt();
            }
            this.f721a = null;
        }
        e eVar = this.f719a;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
            this.f719a = null;
        }
        qna qnaVar = this.f724a;
        if (qnaVar != null) {
            qnaVar.d();
            this.f724a = null;
        }
        nna nnaVar = this.f722a;
        if (nnaVar != null) {
            nnaVar.w();
        }
        L();
        this.f727a = true;
        N();
    }

    public final void c() throws AMapException {
        if (this.f722a == null) {
            return;
        }
        com.amap.api.col.p0003l.d dVar = new com.amap.api.col.p0003l.d(this.f717a, "");
        dVar.e(this.f717a);
        List<OfflineMapProvince> listC = dVar.c();
        if (this.f726a != null) {
            this.f722a.i(listC);
        }
        List<ax> list = this.f726a;
        if (list != null) {
            synchronized (list) {
                Iterator<OfflineMapProvince> it = this.f722a.b().iterator();
                while (it.hasNext()) {
                    for (OfflineMapCity offlineMapCity : it.next().getCityList()) {
                        for (ax axVar : this.f726a) {
                            if (offlineMapCity.getPinyin().equals(axVar.getPinyin())) {
                                String version = axVar.getVersion();
                                if (axVar.getState() == 4 && b.length() > 0 && n(b, version)) {
                                    axVar.j();
                                    axVar.setUrl(offlineMapCity.getUrl());
                                    axVar.s();
                                } else {
                                    axVar.setCity(offlineMapCity.getCity());
                                    axVar.setUrl(offlineMapCity.getUrl());
                                    axVar.s();
                                    axVar.setAdcode(offlineMapCity.getAdcode());
                                    axVar.setVersion(offlineMapCity.getVersion());
                                    axVar.setSize(offlineMapCity.getSize());
                                    axVar.setCode(offlineMapCity.getCode());
                                    axVar.setJianpin(offlineMapCity.getJianpin());
                                    axVar.setPinyin(offlineMapCity.getPinyin());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
