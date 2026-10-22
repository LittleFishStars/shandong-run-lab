package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, 215})
public class yp implements u, Function {
    public volatile Function c;
    public volatile u tt;

    public yp(u uVar) {
        this.tt = uVar;
    }

    public yp(Function function) {
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

    @Override // com.byazt.dna.u
    public String getActiveSimOperatorStr() {
        if (this.tt != null) {
            return this.tt.getActiveSimOperatorStr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getAndroidId() {
        if (this.tt != null) {
            return this.tt.getAndroidId();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getAsyncWifiMac() {
        if (this.tt != null) {
            return this.tt.getAsyncWifiMac();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getBoot() {
        if (this.tt != null) {
            return this.tt.getBoot();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getBuildSerial() {
        if (this.tt != null) {
            return this.tt.getBuildSerial();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getCarrierName() {
        if (this.tt != null) {
            return this.tt.getCarrierName();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getCompilingTime() {
        if (this.tt != null) {
            return this.tt.getCompilingTime();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getDeviceModel() {
        if (this.tt != null) {
            return this.tt.getDeviceModel();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getDeviceName() {
        if (this.tt != null) {
            return this.tt.getDeviceName();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public int getDeviceType(boolean z) {
        if (this.tt != null) {
            return this.tt.getDeviceType(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, Boolean.valueOf(z));
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.u
    public int getDisplayDpi() {
        if (this.tt != null) {
            return this.tt.getDisplayDpi();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.u
    public String getEmuiInfo() {
        if (this.tt != null) {
            return this.tt.getEmuiInfo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getImei(Boolean bool) {
        if (this.tt != null) {
            return this.tt.getImei(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        sparseArray.put(1, bool);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getImsi(Boolean bool) {
        if (this.tt != null) {
            return this.tt.getImsi(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        sparseArray.put(1, bool);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public Map getIpInfoMap(boolean z) {
        if (this.tt != null) {
            return this.tt.getIpInfoMap(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Boolean.valueOf(z));
        return (Map) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getLanguage() {
        if (this.tt != null) {
            return this.tt.getLanguage();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getLocalLanguage() {
        if (this.tt != null) {
            return this.tt.getLocalLanguage();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.c.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.dna.u
    public com.byazt.fn.c getLocation(boolean z) {
        ?? ttVar;
        if (this.tt != null) {
            return this.tt.getLocation(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, Boolean.valueOf(z));
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            ttVar = Apply;
            ttVar = new com.byazt.fn.tt((Function) Apply);
        }
        ttVar = Apply;
        return (com.byazt.fn.c) ttVar;
    }

    @Override // com.byazt.dna.u
    public String getMacAddress(Boolean bool) {
        if (this.tt != null) {
            return this.tt.getMacAddress(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, bool);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getMcc() {
        if (this.tt != null) {
            return this.tt.getMcc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getMcc2() {
        if (this.tt != null) {
            return this.tt.getMcc2();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getMnc() {
        if (this.tt != null) {
            return this.tt.getMnc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getMnc2() {
        if (this.tt != null) {
            return this.tt.getMnc2();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getNetworkSignalType(int i) {
        if (this.tt != null) {
            return this.tt.getNetworkSignalType(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        sparseArray.put(1, Integer.valueOf(i));
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String[] getNewIpAddrs(boolean z) {
        if (this.tt != null) {
            return this.tt.getNewIpAddrs(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String[]) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public int getOs() {
        if (this.tt != null) {
            return this.tt.getOs();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.u
    public String getOsVersion() {
        if (this.tt != null) {
            return this.tt.getOsVersion();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public int getRealNetworkType(long j) {
        if (this.tt != null) {
            return this.tt.getRealNetworkType(j);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, Long.valueOf(j));
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.u
    public String getRom() {
        if (this.tt != null) {
            return this.tt.getRom();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getRomInfo() {
        if (this.tt != null) {
            return this.tt.getRomInfo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getSSID(Boolean bool) {
        if (this.tt != null) {
            return this.tt.getSSID(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        sparseArray.put(1, bool);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public float getScreenBright() {
        if (this.tt != null) {
            return this.tt.getScreenBright();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        return ((Float) this.c.apply(sparseArray)).floatValue();
    }

    @Override // com.byazt.dna.u
    public int getScreenHeight() {
        if (this.tt != null) {
            return this.tt.getScreenHeight();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.u
    public int getScreenWidth() {
        if (this.tt != null) {
            return this.tt.getScreenWidth();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.u
    public String getSimOperator() {
        if (this.tt != null) {
            return this.tt.getSimOperator();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getSimOperatorCode() {
        if (this.tt != null) {
            return this.tt.getSimOperatorCode();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 45);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getTimeZone() {
        if (this.tt != null) {
            return this.tt.getTimeZone();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public int getTimeZoneInt() {
        if (this.tt != null) {
            return this.tt.getTimeZoneInt();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.u
    public long getUnlockTime() {
        if (this.tt != null) {
            return this.tt.getUnlockTime();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 46);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.dna.u
    public String getUserAgent() {
        if (this.tt != null) {
            return this.tt.getUserAgent();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getVendor() {
        if (this.tt != null) {
            return this.tt.getVendor();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getWebViewUA(boolean z) {
        if (this.tt != null) {
            return this.tt.getWebViewUA(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public String getWifiMac(Boolean bool) {
        if (this.tt != null) {
            return this.tt.getWifiMac(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        sparseArray.put(1, bool);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public boolean isScreenOn() {
        if (this.tt != null) {
            return this.tt.isScreenOn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.dna.u
    public void registerNetworkMonitor(com.byazt.fn.ve veVar) {
        if (this.tt != null) {
            this.tt.registerNetworkMonitor(veVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        if (veVar != null) {
            veVar = new com.byazt.fn.uj(veVar);
        }
        sparseArray.put(1, veVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.u
    public void removeNetworkMonitor(com.byazt.fn.ve veVar) {
        if (this.tt != null) {
            this.tt.removeNetworkMonitor(veVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        if (veVar != null) {
            veVar = new com.byazt.fn.uj(veVar);
        }
        sparseArray.put(1, veVar);
        this.c.apply(sparseArray);
    }
}
