package com.byazt.ut;

import android.util.SparseArray;
import com.byazt.aas.nb;
import com.byazt.omf.gt;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 834, 46})
public class n implements com.byazt.dna.sl, Function {
    public com.byazt.dna.c c;

    public n(com.byazt.dna.c cVar) {
        this.c = cVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(isCypherV4());
            case 2:
                return getAppLogUrl();
            case 3:
                return getETAppLogUrl();
            case 4:
                return getStatsUrl();
            case 5:
                return Boolean.valueOf(isMiniEventUpload());
            case 6:
                return Boolean.valueOf(isUploadEventDebugInfo());
            case 7:
                return Boolean.valueOf(getDisable4TypeEncryptFallbackStatus());
            case 8:
                return Boolean.valueOf(isOpenMonitor());
            case 9:
                return Long.valueOf(getAdEventUploadInterval());
            case 10:
                return Integer.valueOf(getAdEventUploadBatch());
            case 11:
                return Integer.valueOf(getStatsBatch());
            case 12:
                return Integer.valueOf(getAdLogExceptionBatch());
            case 13:
                return Integer.valueOf(getMaxMemoryEventCount());
            default:
                return null;
        }
    }

    @Override // com.byazt.dna.sl
    public int getAdEventUploadBatch() {
        int iNb = gt.tt().nb();
        if (iNb < 0 || iNb == Integer.MAX_VALUE) {
            return 10;
        }
        return iNb;
    }

    @Override // com.byazt.dna.sl
    public long getAdEventUploadInterval() {
        long jCu = gt.tt().cu();
        if (jCu < 0 || jCu == 2147483647L) {
            return 5000L;
        }
        return jCu;
    }

    @Override // com.byazt.dna.sl
    public int getAdLogExceptionBatch() {
        int i = gt.tt().to();
        if (i <= 0 || i == Integer.MAX_VALUE) {
            return 100;
        }
        return i;
    }

    @Override // com.byazt.dna.sl
    public String getAppLogUrl() {
        return nb.gr();
    }

    @Override // com.byazt.dna.sl
    public boolean getDisable4TypeEncryptFallbackStatus() {
        return false;
    }

    @Override // com.byazt.dna.sl
    public String getETAppLogUrl() {
        return nb.zm();
    }

    @Override // com.byazt.dna.sl
    public int getMaxMemoryEventCount() {
        return gt.tt().aw();
    }

    @Override // com.byazt.dna.sl
    public int getStatsBatch() {
        return gt.tt().sv();
    }

    @Override // com.byazt.dna.sl
    public String getStatsUrl() {
        return nb.t("/api/ad/union/sdk/stats/batch/");
    }

    @Override // com.byazt.dna.sl
    public boolean isCypherV4() {
        return gt.tt().di();
    }

    @Override // com.byazt.dna.sl
    public boolean isMiniEventUpload() {
        return gt.tt().cl();
    }

    @Override // com.byazt.dna.sl
    public boolean isOpenMonitor() {
        return gt.tt().or();
    }

    @Override // com.byazt.dna.sl
    public boolean isUploadEventDebugInfo() {
        return gt.tt().zb();
    }
}
