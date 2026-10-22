package cj.mobile.wm;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class qa {

    public static class dexb {
        public final String dexa;
        public final com.wangmai.insightvision.openadsdk.j.j.t dexb;

        public dexb(String str, com.wangmai.insightvision.openadsdk.j.j.t tVar) {
            this.dexa = str;
            this.dexb = tVar;
        }
    }

    public static da dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, long j, List<aa> list) {
        w9.dexa dexaVarDexc = mVar.dexc();
        if (dexaVarDexc == null) {
            return new da(304, null, true, j, list);
        }
        return new da(304, dexaVarDexc.dexa, true, j, na.dexa(list, dexaVarDexc));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.j.j.d */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.j.j.l */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.j.j.r */
    public static dexb dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, IOException iOException, long j, oa oaVar, byte[] bArr) throws com.wangmai.insightvision.openadsdk.j.j.l, com.wangmai.insightvision.openadsdk.j.j.d, com.wangmai.insightvision.openadsdk.j.j.r {
        if (iOException instanceof SocketTimeoutException) {
            return new dexb("socket", new com.wangmai.insightvision.openadsdk.j.j.s());
        }
        if (iOException instanceof MalformedURLException) {
            throw new RuntimeException("Bad URL " + mVar.dexo(), iOException);
        }
        if (oaVar == null) {
            if (mVar.dexu()) {
                return new dexb("connection", new com.wangmai.insightvision.openadsdk.j.j.l());
            }
            throw new com.wangmai.insightvision.openadsdk.j.j.l(iOException);
        }
        int iDexd = oaVar.dexd();
        ia.dexc("Unexpected response code %d for %s", Integer.valueOf(iDexd), mVar.dexo());
        if (bArr == null) {
            return new dexb("network", new com.wangmai.insightvision.openadsdk.j.j.j());
        }
        da daVar = new da(iDexd, bArr, false, SystemClock.elapsedRealtime() - j, oaVar.dexc());
        if (iDexd == 401 || iDexd == 403) {
            return new dexb("auth", new com.wangmai.insightvision.openadsdk.j.j.a(daVar));
        }
        if (iDexd >= 400 && iDexd <= 499) {
            throw new com.wangmai.insightvision.openadsdk.j.j.d(daVar);
        }
        if (iDexd < 500 || iDexd > 599 || !mVar.dexv()) {
            throw new com.wangmai.insightvision.openadsdk.j.j.r(daVar);
        }
        return new dexb("server", new com.wangmai.insightvision.openadsdk.j.j.r(daVar));
    }

    public static void dexa(long j, com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, byte[] bArr, int i) {
        if (ia.dexb) {
            Object[] objArr = new Object[5];
            objArr[0] = mVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(mVar.dexl().b());
            ia.dexb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.wangmai.insightvision.openadsdk.j.j.t */
    public static void dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, dexb dexbVar) throws com.wangmai.insightvision.openadsdk.j.j.t {
        ha haVarDexl = mVar.dexl();
        int iDexm = mVar.dexm();
        try {
            haVarDexl.dexa(dexbVar.dexb);
            mVar.dexa(String.format("%s-retry [timeout=%s]", dexbVar.dexa, Integer.valueOf(iDexm)));
        } catch (com.wangmai.insightvision.openadsdk.j.j.t e) {
            mVar.dexa(String.format("%s-timeout-giveup [timeout=%s]", dexbVar.dexa, Integer.valueOf(iDexm)));
            throw e;
        }
    }

    public static byte[] dexa(InputStream inputStream, int i, la laVar) throws Throwable {
        byte[] bArrDexa;
        ra raVar = new ra(laVar, i);
        try {
            bArrDexa = laVar.dexa(1024);
            while (true) {
                try {
                    int i2 = inputStream.read(bArrDexa);
                    if (i2 == -1) {
                        break;
                    }
                    raVar.write(bArrDexa, 0, i2);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                            ia.dexd("Error occurred when closing InputStream", new Object[0]);
                        }
                    }
                    laVar.dexa(bArrDexa);
                    raVar.close();
                    throw th;
                }
            }
            byte[] byteArray = raVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                ia.dexd("Error occurred when closing InputStream", new Object[0]);
            }
            laVar.dexa(bArrDexa);
            raVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArrDexa = null;
        }
    }
}
