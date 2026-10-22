package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 13})
public class tt implements c, Function {
    public volatile Function c;
    public volatile c tt;

    public tt(c cVar) {
        this.tt = cVar;
    }

    public tt(Function function) {
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

    @Override // com.byazt.dna.c
    public int getAgeGroup() {
        if (this.tt != null) {
            return this.tt.getAgeGroup();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.c
    public String getAppChannel() {
        if (this.tt != null) {
            return this.tt.getAppChannel();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.c
    public String getAppId() {
        if (this.tt != null) {
            return this.tt.getAppId();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.c
    public String getAppName() {
        if (this.tt != null) {
            return this.tt.getAppName();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.c
    public String getAppVersion() {
        if (this.tt != null) {
            return this.tt.getAppVersion();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        return (String) this.c.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.dna.c
    public com.byazt.lz.c getCustomController() {
        ?? ttVar;
        if (this.tt != null) {
            return this.tt.getCustomController();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            ttVar = Apply;
            ttVar = new com.byazt.lz.tt((Function) Apply);
        }
        ttVar = Apply;
        return (com.byazt.lz.c) ttVar;
    }

    @Override // com.byazt.dna.c
    public String getData() {
        if (this.tt != null) {
            return this.tt.getData();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.c
    public int[] getDirectDownloadNetworkType() {
        if (this.tt != null) {
            return this.tt.getDirectDownloadNetworkType();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (int[]) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.c
    public Object getExtra(String str) {
        if (this.tt != null) {
            return this.tt.getExtra(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.c
    public Map getInitExtra() {
        if (this.tt != null) {
            return this.tt.getInitExtra();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        return (Map) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.c
    public String getKeywords() {
        if (this.tt != null) {
            return this.tt.getKeywords();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.c.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.dna.c
    public com.byazt.lz.a getMediationConfig() {
        ?? iVar;
        if (this.tt != null) {
            return this.tt.getMediationConfig();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            iVar = Apply;
            iVar = new com.byazt.lz.i((Function) Apply);
        }
        iVar = Apply;
        return (com.byazt.lz.a) iVar;
    }

    @Override // com.byazt.dna.c
    public String getPackageName() {
        if (this.tt != null) {
            return this.tt.getPackageName();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.c
    public int getPluginUpdateConfig() {
        if (this.tt != null) {
            return this.tt.getPluginUpdateConfig();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.c
    public String getSdkApiVersion() {
        if (this.tt != null) {
            return this.tt.getSdkApiVersion();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        return (String) this.c.apply(sparseArray);
    }

    public Object getService(String str) {
        return com.byazt.ut.uj.getService(str, this);
    }

    @Override // com.byazt.dna.c
    public int getThemeStatus() {
        if (this.tt != null) {
            return this.tt.getThemeStatus();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.c
    public int getTitleBarTheme() {
        if (this.tt != null) {
            return this.tt.getTitleBarTheme();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.c
    public String getVersionCode() {
        if (this.tt != null) {
            return this.tt.getVersionCode();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.c
    public boolean isAllowShowNotify() {
        if (this.tt != null) {
            return this.tt.isAllowShowNotify();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.c
    public boolean isDebug() {
        if (this.tt != null) {
            return this.tt.isDebug();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.c
    public boolean isPaid() {
        if (this.tt != null) {
            return this.tt.isPaid();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.c
    public boolean isPlugin() {
        if (this.tt != null) {
            return this.tt.isPlugin();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.c
    public boolean isSupportMultiProcess() {
        if (this.tt != null) {
            return this.tt.isSupportMultiProcess();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.c
    public boolean isUseMediation() {
        if (this.tt != null) {
            return this.tt.isUseMediation();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.c
    public void updateInitParams(SparseArray sparseArray) {
        if (this.tt != null) {
            this.tt.updateInitParams(sparseArray);
            return;
        }
        SparseArray sparseArray2 = new SparseArray();
        sparseArray2.put(0, 20);
        sparseArray2.put(1, sparseArray);
        this.c.apply(sparseArray2);
    }
}
