package com.byazt.lz;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 601, 13})
public class tt implements c, Function {
    public volatile Function c;
    public volatile c tt;

    public tt(c cVar) {
        this.tt = cVar;
    }

    public tt(Function function) {
        this.c = function;
    }

    @Override // com.byazt.lz.c
    public boolean alist() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(this.tt.isCanUseLocation());
            case 2:
                uj tTLocation = this.tt.getTTLocation();
                return tTLocation != null ? new n(tTLocation) : tTLocation;
            case 3:
                return Boolean.valueOf(this.tt.alist());
            case 4:
                return Boolean.valueOf(this.tt.isCanUsePhoneState());
            case 5:
                return this.tt.getDevImei();
            case 6:
                return Boolean.valueOf(this.tt.isCanUseWifiState());
            case 7:
                return this.tt.getMacAddress();
            case 8:
                return Boolean.valueOf(this.tt.isCanUseWriteExternal());
            case 9:
                return this.tt.getDevOaid();
            case 10:
                return Boolean.valueOf(this.tt.isCanUseAndroidId());
            case 11:
                da mediationPrivacyConfig = this.tt.getMediationPrivacyConfig();
                return mediationPrivacyConfig != null ? new sl(mediationPrivacyConfig) : mediationPrivacyConfig;
            case 12:
                return this.tt.getAndroidId();
            case 13:
                return Boolean.valueOf(this.tt.isCanUsePermissionRecordAudio());
            case 14:
                return this.tt.userPrivacyConfig();
            case 15:
                return Boolean.valueOf(this.tt.isCanUseMessage());
            default:
                return null;
        }
    }

    @Override // com.byazt.lz.c
    public String getAndroidId() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.c
    public String getDevImei() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.c
    public String getDevOaid() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.c
    public String getMacAddress() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.c.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.lz.c
    public da getMediationPrivacyConfig() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        ?? Apply = this.c.apply(sparseArray);
        ?? slVar = Apply;
        if (Apply != 0) {
            slVar = new sl((Function) Apply);
        }
        return (da) slVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.lz.c
    public uj getTTLocation() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        ?? Apply = this.c.apply(sparseArray);
        ?? nVar = Apply;
        if (Apply != 0) {
            nVar = new n((Function) Apply);
        }
        return (uj) nVar;
    }

    @Override // com.byazt.lz.c
    public boolean isCanUseAndroidId() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUseLocation() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUseMessage() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUsePermissionRecordAudio() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUsePhoneState() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUseWifiState() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.c
    public boolean isCanUseWriteExternal() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.c
    public Map userPrivacyConfig() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (Map) this.c.apply(sparseArray);
    }
}
