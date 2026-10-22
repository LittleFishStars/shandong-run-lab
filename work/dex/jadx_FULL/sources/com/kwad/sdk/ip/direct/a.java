package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.i;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.service.a.h;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static int bgL = -1;
    private static volatile boolean bgM;
    private static c bgU;
    private static HandlerThread bgV;
    private static Handler bgW;
    private static List<HttpDnsInfo.IpInfo> bgN = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> bgO = new CopyOnWriteArrayList();
    private static List<HttpDnsInfo.IpInfo> bgP = new CopyOnWriteArrayList();
    private static List<c> bgQ = new CopyOnWriteArrayList();
    private static List<c> bgR = new CopyOnWriteArrayList();
    private static PriorityBlockingQueue<c> bgS = new PriorityBlockingQueue<>();
    private static AtomicInteger bgT = new AtomicInteger(0);
    private static volatile boolean bgX = false;
    private static float bgY = -1.0f;
    private static float bgZ = -1.0f;
    private static float bha = -1.0f;
    private static int bhb = 0;
    private static volatile boolean bhc = false;
    private static volatile boolean bhd = false;
    private static NetworkMonitor.a bhe = new NetworkMonitor.a() { // from class: com.kwad.sdk.ip.direct.a.1
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange");
            if (!a.bhd) {
                a.access$002(true);
            } else {
                a.access$102(true);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "*********onNetworkChange sHasNetChanged true");
            }
        }
    };
    private static Runnable bhf = new Runnable() { // from class: com.kwad.sdk.ip.direct.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.Rk();
        }
    };

    private static void P(List<HttpDnsInfo.IpInfo> list) {
        b(list, bgQ);
        if (bgQ.isEmpty()) {
            return;
        }
        Iterator<c> it = bgQ.iterator();
        float fRA = 0.0f;
        while (it.hasNext()) {
            fRA += it.next().RA();
        }
        bgY = fRA / bgQ.size();
    }

    private static void Q(List<HttpDnsInfo.IpInfo> list) {
        b(list, bgR);
        if (bgR.isEmpty()) {
            return;
        }
        int weight = 0;
        float weight2 = 0.0f;
        for (c cVar : bgR) {
            if (cVar != null) {
                weight += cVar.getWeight();
                weight2 += cVar.getWeight() * cVar.RA();
            }
        }
        if (weight != 0) {
            bgZ = weight2 / weight;
        }
    }

    private static void Rf() {
        Handler handler;
        if (bgX || (handler = bgW) == null) {
            return;
        }
        handler.obtainMessage(1).sendToTarget();
    }

    public static String Rg() {
        c cVar = bgU;
        return cVar != null ? cVar.getIp() : "";
    }

    public static float Rh() {
        return bgY;
    }

    public static float Ri() {
        return bgZ;
    }

    public static float Rj() {
        return bha;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Rk() {
        Rp();
        List<HttpDnsInfo.IpInfo> list = bgN;
        List<HttpDnsInfo.IpInfo> list2 = bgO;
        clear();
        if (bgX) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "is picking return");
            return;
        }
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "start pick");
        bgX = true;
        P(list);
        Q(list2);
        if (bgQ.isEmpty() && bgR.isEmpty()) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar == null) {
                bgX = false;
                return;
            } else {
                if (!hVar.FR()) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isIpPreferEnable:false");
                    bgX = false;
                    return;
                }
                Rn();
            }
        }
        bgX = false;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "end pick");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Rl() {
        if (Rm()) {
            return;
        }
        Ro();
    }

    private static boolean Rm() {
        List<c> list = bgQ;
        List<c> list2 = bgR;
        if (!list.isEmpty()) {
            bgU = list.get(new Random().nextInt(list.size()));
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from recommend:" + bgU);
            bhb = 1;
            return true;
        }
        int i = 0;
        if (list2.isEmpty()) {
            return false;
        }
        Random random = new Random();
        int weight = 0;
        for (c cVar : list2) {
            if (cVar != null) {
                weight += cVar.getWeight();
            }
        }
        if (weight <= 0) {
            return false;
        }
        int iNextInt = random.nextInt(weight);
        for (int i2 = 0; i2 < list2.size(); i2++) {
            if (list2.get(i2) != null) {
                iNextInt -= list2.get(i2).getWeight();
            }
            if (iNextInt < 0) {
                i = i2;
                break;
            }
        }
        bgU = list2.get(i);
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from backUp:" + bgU);
        bhb = 2;
        return true;
    }

    private static void Rn() {
        List<HttpDnsInfo.IpInfo> list = bgP;
        if (list.isEmpty()) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                c cVarF = b.f(ipInfo.ip, bgL);
                if (cVarF.isSuccess()) {
                    bgS.offer(cVarF);
                }
            }
        }
        c cVarPeek = bgS.peek();
        if (cVarPeek != null) {
            bha = cVarPeek.RA();
        }
    }

    private static void Ro() {
        if (bgS.isEmpty()) {
            return;
        }
        c cVarPeek = bgS.peek();
        if (cVarPeek.RA() < bgL) {
            bgU = cVarPeek;
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set from Other:" + bgU);
            bhb = 3;
        }
    }

    private static void Rp() {
        if (bgL == -1) {
            h hVar = (h) ServiceProvider.get(h.class);
            if (hVar != null) {
                bgL = hVar.FS();
            } else {
                bgL = 200;
            }
        }
    }

    private static boolean Rq() {
        if (bhc) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sHasNetChanged direct can not use");
            return false;
        }
        int i = bgT.get();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "value:" + i);
        return i <= 3;
    }

    private static void Rr() {
        bgT.getAndIncrement();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "addFailedTimes:" + bgT.intValue());
    }

    public static void Rs() {
        c cVar;
        Handler handler;
        if (!bgM || (cVar = bgU) == null || TextUtils.isEmpty(cVar.getIp()) || (handler = bgW) == null) {
            return;
        }
        handler.obtainMessage(2).sendToTarget();
    }

    public static void Rt() {
        Rr();
        Ru();
        Rv();
        bhb = 0;
        Rl();
        Rk();
    }

    private static void Ru() {
        HttpDnsInfo.IpInfo ipInfo;
        HttpDnsInfo.IpInfo next;
        c cVar = bgU;
        String ip = cVar == null ? "" : cVar.getIp();
        if (TextUtils.isEmpty(ip)) {
            return;
        }
        Iterator<HttpDnsInfo.IpInfo> it = bgN.iterator();
        while (true) {
            ipInfo = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != null && TextUtils.equals(ip, next.ip)) {
                break;
            }
        }
        if (next != null) {
            bgN.remove(next);
            next = null;
        }
        for (HttpDnsInfo.IpInfo ipInfo2 : bgO) {
            if (ipInfo2 != null && TextUtils.equals(ip, ipInfo2.ip)) {
                next = ipInfo2;
                break;
            }
        }
        if (next != null) {
            bgO.remove(next);
        } else {
            ipInfo = next;
        }
        for (HttpDnsInfo.IpInfo ipInfo3 : bgP) {
            if (ipInfo3 != null && TextUtils.equals(ip, ipInfo3.ip)) {
                ipInfo = ipInfo3;
                break;
            }
        }
        if (ipInfo != null) {
            bgP.remove(ipInfo);
        }
    }

    private static void Rv() {
        c next;
        if (bgU == null) {
            return;
        }
        List<c> list = bgQ;
        if (list != null && !list.isEmpty() && bgQ.contains(bgU)) {
            bgQ.remove(bgU);
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sRecommendEntityList remove:" + bgU);
        }
        List<c> list2 = bgR;
        if (list2 != null && !list2.isEmpty()) {
            if (bgR.contains(bgU)) {
                bgR.remove(bgU);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove:" + bgU);
            }
            Iterator<c> it = bgR.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && TextUtils.equals(next.getIp(), bgU.getIp())) {
                    com.kwad.sdk.core.d.c.d("IpDirect_Helper", "set removeEntity:" + next.getIp());
                    break;
                }
            }
            if (next != null) {
                bgR.remove(next);
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", "sBackUpIpEntityList remove removeEntity:" + next);
            }
        }
        c cVarPeek = bgS.peek();
        if (cVarPeek != null && cVarPeek == bgU) {
            bgS.poll();
        }
        bgU = null;
    }

    public static void a(HttpDnsInfo httpDnsInfo) {
        if (httpDnsInfo == null) {
            return;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.w("IpDirect_Helper", "sdkConfigProvider == null");
            return;
        }
        boolean zFQ = hVar.FQ();
        bgM = zFQ;
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isEnable:" + zFQ);
        if (zFQ) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", httpDnsInfo.toString());
            List<HttpDnsInfo.IpInfo> list = httpDnsInfo.recommendList;
            bgN = list;
            bgO = httpDnsInfo.backUpList;
            bgP = httpDnsInfo.otherList;
            if (list.isEmpty() && bgO.isEmpty() && bgP.isEmpty()) {
                com.kwad.sdk.core.d.c.w("IpDirect_Helper", "HttpDnsInfo is empty");
            } else {
                init();
                Rf();
            }
        }
    }

    public static /* synthetic */ boolean access$002(boolean z) {
        bhd = true;
        return true;
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        bhc = true;
        return true;
    }

    private static void b(List<HttpDnsInfo.IpInfo> list, List<c> list2) {
        if (list == null) {
            return;
        }
        for (HttpDnsInfo.IpInfo ipInfo : list) {
            if (ipInfo != null && !TextUtils.isEmpty(ipInfo.ip)) {
                com.kwad.sdk.core.d.c.d("IpDirect_Helper", ipInfo.toString());
                c cVarF = b.f(ipInfo.ip, bgL);
                cVarF.fb(ipInfo.weight);
                if (cVarF.isSuccess() && cVarF.RA() < bgL) {
                    list2.add(cVarF);
                }
            }
        }
    }

    private static void clear() {
        bgQ.clear();
        bgR.clear();
        bgS.clear();
    }

    @Nullable
    public static String gM(String str) {
        if (!bgM) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost return by sIpDirectEnable false");
            return "";
        }
        if (gN(str)) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "isHostInvalid:false ：" + str);
            return "";
        }
        if (!Rq()) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "canUseIpDirect:false");
            return "";
        }
        String strRg = Rg();
        com.kwad.sdk.core.d.c.d("IpDirect_Helper", "getIpByHost ip:" + strRg);
        return strRg;
    }

    private static boolean gN(String str) {
        boolean z = !TextUtils.equals("https://" + str, i.EI());
        if (z) {
            com.kwad.sdk.core.d.c.d("IpDirect_Helper", "非核心域名 current host:" + i.EI() + "try direct host:https://" + str);
        }
        return z;
    }

    public static int getType() {
        return bhb;
    }

    private static void init() {
        if (bgV != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("IpDirectHelper");
        bgV = handlerThread;
        handlerThread.start();
        bgW = new Handler(bgV.getLooper()) { // from class: com.kwad.sdk.ip.direct.a.2
            @Override // android.os.Handler
            public final void handleMessage(@NonNull Message message) {
                int i = message.what;
                if (i == 1) {
                    a.Rk();
                    a.Rl();
                } else {
                    if (i != 2) {
                        return;
                    }
                    a.Rt();
                }
            }
        };
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar != null) {
            NetworkMonitor.getInstance().a(fVar.getContext(), bhe);
        }
    }
}
