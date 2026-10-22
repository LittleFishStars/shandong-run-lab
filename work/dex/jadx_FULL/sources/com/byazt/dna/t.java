package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 66})
public class t implements sl, Function {
    public volatile Function c;
    public volatile sl tt;

    public t(sl slVar) {
        this.tt = slVar;
    }

    public t(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Function function;
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.tt != null ? this.tt : this.c;
        }
        if (iIntValue == -4 && (function = (Function) sparseArray.get(1)) != null) {
            this.tt = null;
            this.c = function;
        }
        return null;
    }

    @Override // com.byazt.dna.sl
    public int getAdEventUploadBatch() {
        if (this.tt != null) {
            return this.tt.getAdEventUploadBatch();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.sl
    public long getAdEventUploadInterval() {
        if (this.tt != null) {
            return this.tt.getAdEventUploadInterval();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.dna.sl
    public int getAdLogExceptionBatch() {
        if (this.tt != null) {
            return this.tt.getAdLogExceptionBatch();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.sl
    public String getAppLogUrl() {
        if (this.tt != null) {
            return this.tt.getAppLogUrl();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.sl
    public boolean getDisable4TypeEncryptFallbackStatus() {
        if (this.tt != null) {
            return this.tt.getDisable4TypeEncryptFallbackStatus();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.sl
    public String getETAppLogUrl() {
        if (this.tt != null) {
            return this.tt.getETAppLogUrl();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.sl
    public int getMaxMemoryEventCount() {
        if (this.tt != null) {
            return this.tt.getMaxMemoryEventCount();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.sl
    public int getStatsBatch() {
        if (this.tt != null) {
            return this.tt.getStatsBatch();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.sl
    public String getStatsUrl() {
        if (this.tt != null) {
            return this.tt.getStatsUrl();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.sl
    public boolean isCypherV4() {
        if (this.tt != null) {
            return this.tt.isCypherV4();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.sl
    public boolean isMiniEventUpload() {
        if (this.tt != null) {
            return this.tt.isMiniEventUpload();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.sl
    public boolean isOpenMonitor() {
        if (this.tt != null) {
            return this.tt.isOpenMonitor();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.sl
    public boolean isUploadEventDebugInfo() {
        if (this.tt != null) {
            return this.tt.isUploadEventDebugInfo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }
}
