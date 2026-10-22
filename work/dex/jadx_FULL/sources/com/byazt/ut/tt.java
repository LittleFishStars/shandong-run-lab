package com.byazt.ut;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.aas.nb;
import com.byazt.omf.p;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 834, 13})
public class tt<T> implements com.byazt.dna.c<T>, Function<Object, Object> {
    public volatile SparseArray c;
    public String mAppId;
    public com.byazt.lz.c n;
    public String tt;
    public com.byazt.lz.a uj;
    public volatile com.byazt.dj.c ve;

    public tt(String str) {
        this.mAppId = str;
    }

    private com.byazt.dj.c c() {
        if (this.ve == null && this.c != null) {
            this.ve = new com.byazt.dj.c(this.c);
        }
        return this.ve;
    }

    private void tt() {
        if (c() == null) {
            return;
        }
        this.n = new com.byazt.yhr.c(com.byazt.omf.x.m().nu());
    }

    private void ve() {
        com.byazt.je.c cVarZ;
        com.byazt.dj.c cVarC = c();
        if (cVarC == null || (cVarZ = cVarC.z()) == null) {
            return;
        }
        this.uj = new com.byazt.yhr.tt(cVarZ);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -3) {
            ats_setAtsField((SparseArray) sparseArray.get(1));
            return null;
        }
        if (iIntValue == -2) {
            return ats_getAtsField();
        }
        switch (iIntValue) {
            case 2:
                return getAppId();
            case 3:
                return Boolean.valueOf(isSupportMultiProcess());
            case 4:
                return getExtra((String) sparseArray.get(1));
            case 5:
                return getAppName();
            case 6:
                return Boolean.valueOf(isPaid());
            case 7:
                return getKeywords();
            case 8:
                return getData();
            case 9:
                return Integer.valueOf(getTitleBarTheme());
            case 10:
                return Boolean.valueOf(isAllowShowNotify());
            case 11:
                return Boolean.valueOf(isDebug());
            case 12:
                return getDirectDownloadNetworkType();
            case 13:
                com.byazt.lz.c customController = getCustomController();
                return customController != null ? new com.byazt.lz.tt(customController) : customController;
            case 14:
                return Integer.valueOf(getPluginUpdateConfig());
            case 15:
                return Integer.valueOf(getAgeGroup());
            case 16:
                return Integer.valueOf(getThemeStatus());
            case 17:
                com.byazt.lz.a mediationConfig = getMediationConfig();
                return mediationConfig != null ? new com.byazt.lz.i(mediationConfig) : mediationConfig;
            case 18:
                return Boolean.valueOf(isUseMediation());
            case 19:
                return getInitExtra();
            case 20:
                updateInitParams((SparseArray) sparseArray.get(1));
                return null;
            case 21:
                return getAppVersion();
            case 22:
                return getPackageName();
            case 23:
                return getVersionCode();
            case 24:
                return getSdkApiVersion();
            case 25:
                return Boolean.valueOf(isPlugin());
            case 26:
                return getAppChannel();
            case 27:
                return getService((String) sparseArray.get(1));
            default:
                return null;
        }
    }

    public SparseArray ats_getAtsField() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.c);
        sparseArray.put(2, this.tt);
        return sparseArray;
    }

    public void ats_setAtsField(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.c = (SparseArray) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            this.tt = (String) obj2;
        }
    }

    @Override // com.byazt.dna.c
    public int getAgeGroup() {
        com.byazt.dj.c cVarC = c();
        if (cVarC == null) {
            return 0;
        }
        return cVarC.u();
    }

    @Override // com.byazt.dna.c
    public String getAppChannel() {
        return com.byazt.fh.c.i();
    }

    @Override // com.byazt.dna.c
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.byazt.dna.c
    public String getAppName() {
        String str = this.tt;
        if (str != null) {
            return str;
        }
        com.byazt.dj.c cVarC = c();
        if (cVarC == null) {
            return "";
        }
        String strTt = cVarC.tt();
        this.tt = strTt;
        if (TextUtils.isEmpty(strTt)) {
            this.tt = com.byazt.fh.c.da();
        }
        return this.tt;
    }

    @Override // com.byazt.dna.c
    public String getAppVersion() {
        return com.byazt.fh.c.n();
    }

    @Override // com.byazt.dna.c
    public com.byazt.lz.c getCustomController() {
        com.byazt.lz.c cVar = this.n;
        if (cVar != null) {
            return cVar;
        }
        tt();
        return this.n;
    }

    @Override // com.byazt.dna.c
    public String getData() {
        com.byazt.dj.c cVarC = c();
        return cVarC == null ? "" : cVarC.n();
    }

    @Override // com.byazt.dna.c
    public int[] getDirectDownloadNetworkType() {
        com.byazt.dj.c cVarC = c();
        return cVarC == null ? new int[0] : cVarC.i();
    }

    @Override // com.byazt.dna.c
    public Object getExtra(String str) {
        Map<String, Object> mapNu;
        com.byazt.dj.c cVarC = c();
        if (cVarC == null || (mapNu = cVarC.nu()) == null) {
            return null;
        }
        return mapNu.get(str);
    }

    @Override // com.byazt.dna.c
    public Map<String, Object> getInitExtra() {
        com.byazt.dj.c cVarC = c();
        return cVarC == null ? Collections.emptyMap() : cVarC.nu();
    }

    @Override // com.byazt.dna.c
    public String getKeywords() {
        com.byazt.dj.c cVarC = c();
        return cVarC == null ? "" : cVarC.uj();
    }

    @Override // com.byazt.dna.c
    public com.byazt.lz.a getMediationConfig() {
        com.byazt.lz.a aVar = this.uj;
        if (aVar != null) {
            return aVar;
        }
        ve();
        return this.uj;
    }

    @Override // com.byazt.dna.c
    public String getPackageName() {
        return nb.x();
    }

    @Override // com.byazt.dna.c
    public int getPluginUpdateConfig() {
        com.byazt.dj.c cVarC = c();
        if (cVarC == null) {
            return 0;
        }
        return cVarC.t();
    }

    @Override // com.byazt.dna.c
    public String getSdkApiVersion() {
        return p.n;
    }

    public T getService(String str) {
        return (T) uj.getService(str, this);
    }

    @Override // com.byazt.dna.c
    public int getThemeStatus() {
        com.byazt.dj.c cVarC = c();
        if (cVarC == null) {
            return 0;
        }
        return cVarC.yp();
    }

    @Override // com.byazt.dna.c
    public int getTitleBarTheme() {
        com.byazt.dj.c cVarC = c();
        if (cVarC == null) {
            return 0;
        }
        return cVarC.a();
    }

    @Override // com.byazt.dna.c
    public String getVersionCode() {
        return nb.i();
    }

    @Override // com.byazt.dna.c
    public boolean isAllowShowNotify() {
        com.byazt.dj.c cVarC = c();
        if (cVarC == null) {
            return false;
        }
        return cVarC.sp();
    }

    @Override // com.byazt.dna.c
    public boolean isDebug() {
        com.byazt.dj.c cVarC = c();
        if (cVarC == null) {
            return false;
        }
        return cVarC.x();
    }

    @Override // com.byazt.dna.c
    public boolean isPaid() {
        com.byazt.dj.c cVarC = c();
        if (cVarC == null) {
            return false;
        }
        return cVarC.ve();
    }

    @Override // com.byazt.dna.c
    public boolean isPlugin() {
        return p.c();
    }

    @Override // com.byazt.dna.c
    public boolean isSupportMultiProcess() {
        return com.byazt.by.ve.c().tt();
    }

    @Override // com.byazt.dna.c
    public boolean isUseMediation() {
        com.byazt.dj.c cVarC = c();
        if (cVarC == null) {
            return false;
        }
        return cVarC.m();
    }

    @Override // com.byazt.dna.c
    public void updateInitParams(SparseArray sparseArray) {
        if (this.c == sparseArray) {
            return;
        }
        this.c = sparseArray;
        this.ve = new com.byazt.dj.c(sparseArray);
        if (this.uj != null) {
            ve();
        }
        if (this.n != null) {
            tt();
        }
    }
}
