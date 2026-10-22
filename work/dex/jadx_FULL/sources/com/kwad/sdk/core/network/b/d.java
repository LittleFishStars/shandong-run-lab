package com.kwad.sdk.core.network.b;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d implements b {
    private static String aUA = "";
    private static boolean aUu = true;
    public static double aUv = 1.0d;
    private static volatile boolean aUz = false;
    private long aUw = -1;
    private long aUx = -1;
    private long aUy = -1;
    private j aUB = new j();

    public d() {
        aUv = new Random().nextDouble();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: ME, reason: merged with bridge method [inline-methods] */
    public d Mw() {
        this.aUB.aTF = SystemClock.elapsedRealtime();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: MF, reason: merged with bridge method [inline-methods] */
    public d Mx() {
        this.aUx = SystemClock.elapsedRealtime();
        eY("this.responseReceiveTime:" + this.aUx);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: MG, reason: merged with bridge method [inline-methods] */
    public d My() {
        if (aF(this.aUw) && aF(this.aUx)) {
            this.aUB.aTM = this.aUx - this.aUw;
            eY("info.waiting_response_cost:" + this.aUB.aTM);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: MH, reason: merged with bridge method [inline-methods] */
    public d Mz() {
        if (aF(this.aUB.aTF)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.aUw = jElapsedRealtime;
            j jVar = this.aUB;
            jVar.aTz = jElapsedRealtime - jVar.aTF;
            if (aF(jVar.aTx)) {
                j jVar2 = this.aUB;
                jVar2.aTy = jVar2.aTz - jVar2.aTx;
            }
            eY("info.request_create_cost:" + this.aUB.aTz);
            eY("info.requestAddParamsCost:" + this.aUB.aTy);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: MI, reason: merged with bridge method [inline-methods] */
    public d MB() {
        if (aF(this.aUx)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.aUy = jElapsedRealtime;
            this.aUB.aTK = jElapsedRealtime - this.aUx;
            eY("info.response_parse_cost:" + this.aUB.aTK);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: MJ, reason: merged with bridge method [inline-methods] */
    public d MC() {
        if (aF(this.aUy)) {
            this.aUB.aTR = SystemClock.elapsedRealtime() - this.aUy;
            MK();
            eY("info.response_done_cost:" + this.aUB.aTR);
        }
        return this;
    }

    private void MK() {
        j jVar = this.aUB;
        if (jVar == null || jVar.aTQ != 1 || aI(jVar.aTR)) {
            return;
        }
        this.aUB.aTR = -1L;
    }

    private d ML() {
        this.aUB.aTU = (int) com.kwad.sdk.ip.direct.a.Rh();
        this.aUB.aTV = (int) com.kwad.sdk.ip.direct.a.Ri();
        this.aUB.aTW = (int) com.kwad.sdk.ip.direct.a.Rj();
        return this;
    }

    private void MM() {
        i iVarC = c(this.aUB);
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(iVarC);
        }
        com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", "reportError" + iVarC.toJson().toString());
    }

    private static boolean aF(long j) {
        return j != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: aG, reason: merged with bridge method [inline-methods] */
    public d aE(long j) {
        this.aUB.aTL = j;
        eY("responseSize:" + j);
        return this;
    }

    private d aH(long j) {
        this.aUB.aTN = j;
        eY("totalCost:" + j);
        return this;
    }

    private static boolean aI(long j) {
        return j >= 50;
    }

    private static boolean c(@NonNull i iVar) {
        if (TextUtils.isEmpty(iVar.url)) {
            return true;
        }
        String lowerCase = iVar.url.toLowerCase();
        return lowerCase.contains("beta") || lowerCase.contains("test") || lowerCase.contains("staging");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: eB, reason: merged with bridge method [inline-methods] */
    public d ex(int i) {
        this.aUB.httpCode = i;
        eY("http_code:" + i);
        return this;
    }

    private d eC(int i) {
        this.aUB.aTQ = i;
        eY("hasData:" + i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: eD, reason: merged with bridge method [inline-methods] */
    public d ez(int i) {
        this.aUB.result = i;
        eY("result:" + i);
        return this;
    }

    private static void eY(String str) {
        if (aUu) {
            com.kwad.sdk.core.d.c.d("NetworkMonitorRecorder", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: eZ, reason: merged with bridge method [inline-methods] */
    public d eT(String str) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        this.aUB.url = str;
        if (str.contains("?")) {
            String[] strArrSplit = str.split("\\?");
            if (strArrSplit.length > 0) {
                str = strArrSplit[0];
            }
        }
        if (!TextUtils.isEmpty(str)) {
            eY("url:" + str);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: fa, reason: merged with bridge method [inline-methods] */
    public d eU(String str) {
        try {
            this.aUB.host = Uri.parse(str).getHost();
            eY("host:" + this.aUB.host);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.e("NetworkMonitorRecorder", Log.getStackTraceString(e));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: fb, reason: merged with bridge method [inline-methods] */
    public d eV(String str) {
        this.aUB.errorMsg = str;
        eY(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: fc, reason: merged with bridge method [inline-methods] */
    public d eW(String str) {
        this.aUB.aTv = str;
        eY("reqType:" + str);
        fe(com.kwad.sdk.ip.direct.a.Rg());
        ML();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.b.b
    /* JADX INFO: renamed from: fd, reason: merged with bridge method [inline-methods] */
    public d eX(String str) {
        this.aUB.aTP = str;
        eY("requestId:" + str);
        return this;
    }

    private d fe(String str) {
        this.aUB.aTS = str;
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b MA() {
        if (aF(this.aUB.aTF)) {
            this.aUB.aTx = SystemClock.elapsedRealtime() - this.aUB.aTF;
            eY("info.request_prepare_cost:" + this.aUB.aTx);
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final b eA(int i) {
        j jVar = this.aUB;
        jVar.aTT = i;
        if (i != 0) {
            jVar.aTw = 1;
        }
        return this;
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final /* synthetic */ b ey(int i) {
        return eC(1);
    }

    @Override // com.kwad.sdk.core.network.b.b
    public final void report() {
        if (c((i) this.aUB)) {
            return;
        }
        if (this.aUB.httpCode != 200) {
            MM();
            return;
        }
        long jElapsedRealtime = aF(this.aUB.aTF) ? SystemClock.elapsedRealtime() - this.aUB.aTF : -1L;
        aH(jElapsedRealtime);
        if (jElapsedRealtime > 30000 || jElapsedRealtime <= -1) {
            return;
        }
        k kVar = (k) ServiceProvider.get(k.class);
        if (kVar != null) {
            kVar.a(this.aUB);
        }
        eY("report normal" + this.aUB.toString());
    }

    private static i c(j jVar) {
        i iVar = new i();
        iVar.errorMsg = jVar.errorMsg;
        iVar.host = jVar.host;
        iVar.httpCode = jVar.httpCode;
        iVar.aTv = jVar.aTv;
        iVar.url = jVar.url;
        iVar.aTw = jVar.aTw;
        return iVar;
    }
}
