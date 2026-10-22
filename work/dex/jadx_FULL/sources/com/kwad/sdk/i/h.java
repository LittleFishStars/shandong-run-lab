package com.kwad.sdk.i;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h {
    private d biC;
    private g biD;
    private ConcurrentLinkedQueue<i> biE;
    private f biF;
    private final AtomicBoolean biy;
    private final AtomicBoolean mHasInit;
    private static final AtomicBoolean biA = new AtomicBoolean(false);
    private static final AtomicInteger biB = new AtomicInteger(0);
    private static final float aJu = new Random().nextFloat();

    public static final class a {
        private static final h biI = new h(0);
    }

    public /* synthetic */ h(byte b) {
        this();
    }

    public static h RQ() {
        return a.biI;
    }

    private void RX() {
        ConcurrentLinkedQueue<i> concurrentLinkedQueue = this.biE;
        if (concurrentLinkedQueue == null) {
            return;
        }
        Iterator<i> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.biE.clear();
        this.biE = null;
    }

    private void b(final i iVar) {
        d dVar = this.biC;
        if (dVar == null || j.R(dVar.bil) || this.biD == null || this.biF == null) {
            return;
        }
        j.a(new n() { // from class: com.kwad.sdk.i.h.1
            @Override // com.kwad.sdk.i.n
            public final void doTask() {
                h hVar = h.this;
                e eVarA = hVar.a(hVar.biC, iVar);
                if (eVarA == null) {
                    return;
                }
                iVar.l(eVarA.aJV);
                m.a(iVar, eVarA.bim == 2);
            }
        });
    }

    private boolean c(e.b bVar) {
        List<String> list = bVar.bdt;
        if (j.R(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.biD.getSdkVersion(), it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean d(e.b bVar) {
        String androidId = this.biD.getAndroidId();
        String deviceId = this.biD.getDeviceId();
        String imei = this.biD.getImei();
        String oaid = this.biD.getOaid();
        List<String> list = bVar.biu;
        if (j.R(list)) {
            return true;
        }
        for (String str : list) {
            if (TextUtils.equals(str, androidId) || TextUtils.equals(str, deviceId) || TextUtils.equals(str, imei) || TextUtils.equals(str, oaid)) {
                return true;
            }
        }
        return false;
    }

    private static d gW(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Throwable unused) {
            j.Sa();
            return null;
        }
    }

    public final void RR() {
        if (!this.mHasInit.get() || this.biC == null) {
            return;
        }
        j.Sb();
        m.Sd();
    }

    public final synchronized void RS() {
        this.biy.set(true);
    }

    public final synchronized void RT() {
        this.biy.set(false);
    }

    public final g RU() {
        return this.biD;
    }

    public final f RV() {
        return this.biF;
    }

    public final long RW() {
        return this.biC.RJ();
    }

    public final void g(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (this.biy.get()) {
                    j.Sb();
                    return;
                }
                i iVarGZ = i.RZ().gX(str).gY(str2).gZ(str3);
                if (this.mHasInit.get()) {
                    b(iVarGZ);
                } else {
                    if (biA.get()) {
                        return;
                    }
                    j.Sb();
                    a(iVarGZ);
                }
            }
        } catch (Throwable unused) {
            j.Sa();
        }
    }

    private h() {
        this.mHasInit = new AtomicBoolean(false);
        this.biy = new AtomicBoolean(false);
    }

    private boolean b(e.b bVar) {
        List<String> list = bVar.bds;
        if (j.R(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(this.biD.getAppId(), it.next())) {
                return true;
            }
        }
        return false;
    }

    public final void a(String str, g gVar, f fVar) {
        if (this.mHasInit.get()) {
            return;
        }
        try {
            j.Sb();
            this.biD = gVar;
            this.biF = fVar;
            this.biC = gW(str);
            this.mHasInit.set(true);
            RX();
        } catch (Throwable unused) {
            biA.set(true);
            j.Sa();
        }
    }

    private static boolean c(e.a aVar, String str) {
        List<String> list = aVar.bir;
        if (j.R(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(e.a aVar, String str) {
        List<String> list = aVar.biq;
        if (j.R(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    private void a(i iVar) {
        if (this.biE == null) {
            this.biE = new ConcurrentLinkedQueue<>();
        }
        AtomicInteger atomicInteger = biB;
        if (atomicInteger.get() >= 500) {
            return;
        }
        atomicInteger.incrementAndGet();
        this.biE.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(d dVar, i iVar) {
        List<e> list = dVar.bil;
        if (j.R(list)) {
            return null;
        }
        for (e eVar : list) {
            if (a(eVar.bin) && a(eVar.bio, iVar)) {
                double d = eVar.aJV;
                if (d > AudioStats.AUDIO_AMPLITUDE_NONE && aJu <= d) {
                    return eVar;
                }
            }
        }
        return null;
    }

    private boolean a(e.b bVar) {
        if (bVar.biv != e.b.bis) {
            return bVar.RK();
        }
        bVar.cc(b(bVar) && c(bVar) && d(bVar));
        return bVar.RK();
    }

    private boolean a(e.a aVar, i iVar) {
        return a(aVar, iVar.biJ) && b(aVar, iVar.biK) && c(aVar, iVar.biL);
    }

    private static boolean a(e.a aVar, String str) {
        List<String> list = aVar.bip;
        if (j.R(list)) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next())) {
                return true;
            }
        }
        return false;
    }
}
