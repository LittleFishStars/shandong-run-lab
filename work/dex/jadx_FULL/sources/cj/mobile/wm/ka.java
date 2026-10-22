package cj.mobile.wm;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ka implements ba {
    public final ja dexa;
    public final la dexb;

    public ka(ja jaVar) {
        this(jaVar, new la(4096));
    }

    public ka(ja jaVar, la laVar) {
        this.dexa = jaVar;
        this.dexb = laVar;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.j.j.t */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001a, code lost:
    
        r12 = r3.dexd();
        r0 = r3.dexc();
     */
    @Override // cj.mobile.wm.ba
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public da dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar) throws com.wangmai.insightvision.openadsdk.j.j.t {
        IOException iOException;
        oa oaVar;
        byte[] bArr;
        oa oaVarDexa;
        int iDexd;
        List<aa> listDexc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                oaVarDexa = this.dexa.dexa(mVar, na.dexa(mVar.dexc()));
                try {
                    break;
                } catch (IOException e) {
                    bArr = null;
                    oaVar = oaVarDexa;
                    iOException = e;
                }
            } catch (IOException e2) {
                iOException = e2;
                oaVar = null;
                bArr = null;
            }
            qa.dexa(mVar, qa.dexa(mVar, iOException, jElapsedRealtime, oaVar, bArr));
        }
        if (iDexd == 304) {
            return qa.dexa(mVar, SystemClock.elapsedRealtime() - jElapsedRealtime, listDexc);
        }
        InputStream inputStreamDexa = oaVarDexa.dexa();
        byte[] bArrDexa = inputStreamDexa != null ? qa.dexa(inputStreamDexa, oaVarDexa.dexb(), this.dexb) : new byte[0];
        qa.dexa(SystemClock.elapsedRealtime() - jElapsedRealtime, mVar, bArrDexa, iDexd);
        if (iDexd < 200 || iDexd > 299) {
            throw new IOException();
        }
        return new da(iDexd, bArrDexa, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listDexc);
    }
}
