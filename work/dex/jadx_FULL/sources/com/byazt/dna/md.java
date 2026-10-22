package com.byazt.dna;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1151, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF})
public class md implements p, Function {
    public volatile Function c;
    public volatile p tt;

    public md(p pVar) {
        this.tt = pVar;
    }

    public md(Function function) {
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

    @Override // com.byazt.dna.p
    public String getAndroidId() {
        if (this.tt != null) {
            return this.tt.getAndroidId();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getAppLogDid() {
        if (this.tt != null) {
            return this.tt.getAppLogDid();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getBoot() {
        if (this.tt != null) {
            return this.tt.getBoot();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getBuildSerial() {
        if (this.tt != null) {
            return this.tt.getBuildSerial();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getCarrierName() {
        if (this.tt != null) {
            return this.tt.getCarrierName();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getCompilingTime() {
        if (this.tt != null) {
            return this.tt.getCompilingTime();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public int getConnType() {
        if (this.tt != null) {
            return this.tt.getConnType();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.p
    public String getDeviceModel() {
        if (this.tt != null) {
            return this.tt.getDeviceModel();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getDeviceName() {
        if (this.tt != null) {
            return this.tt.getDeviceName();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public int getDeviceType(boolean z) {
        if (this.tt != null) {
            return this.tt.getDeviceType(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        sparseArray.put(1, Boolean.valueOf(z));
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.p
    public String getDisplayDensity() {
        if (this.tt != null) {
            return this.tt.getDisplayDensity();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public int getDisplayDpi() {
        if (this.tt != null) {
            return this.tt.getDisplayDpi();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 46);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.p
    public String getImei(Boolean bool) {
        if (this.tt != null) {
            return this.tt.getImei(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, bool);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getImsi(Boolean bool) {
        if (this.tt != null) {
            return this.tt.getImsi(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        sparseArray.put(1, bool);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getIpv4() {
        if (this.tt != null) {
            return this.tt.getIpv4();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getIpv6() {
        if (this.tt != null) {
            return this.tt.getIpv6();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getLanguage() {
        if (this.tt != null) {
            return this.tt.getLanguage();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getLocalLanguage() {
        if (this.tt != null) {
            return this.tt.getLocalLanguage();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.c.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.dna.p
    public com.byazt.fn.c getLocation() {
        ?? ttVar;
        if (this.tt != null) {
            return this.tt.getLocation();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            ttVar = Apply;
            ttVar = new com.byazt.fn.tt((Function) Apply);
        }
        ttVar = Apply;
        return (com.byazt.fn.c) ttVar;
    }

    @Override // com.byazt.dna.p
    public String getMacAddress(Boolean bool) {
        if (this.tt != null) {
            return this.tt.getMacAddress(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        sparseArray.put(1, bool);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getMcc() {
        if (this.tt != null) {
            return this.tt.getMcc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getMcc2() {
        if (this.tt != null) {
            return this.tt.getMcc2();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 49);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getMnc() {
        if (this.tt != null) {
            return this.tt.getMnc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getMnc2() {
        if (this.tt != null) {
            return this.tt.getMnc2();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 50);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String[] getNewIpAddrs(boolean z) {
        if (this.tt != null) {
            return this.tt.getNewIpAddrs(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String[]) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getOAID(boolean z) {
        if (this.tt != null) {
            return this.tt.getOAID(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public int getOs() {
        if (this.tt != null) {
            return this.tt.getOs();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.p
    public String getOsVersion() {
        if (this.tt != null) {
            return this.tt.getOsVersion();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getRom() {
        if (this.tt != null) {
            return this.tt.getRom();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getRomInfo() {
        if (this.tt != null) {
            return this.tt.getRomInfo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 45);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getSSID(Boolean bool) {
        if (this.tt != null) {
            return this.tt.getSSID(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, bool);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public int getScreenHeight() {
        if (this.tt != null) {
            return this.tt.getScreenHeight();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 47);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.p
    public int getScreenWidth() {
        if (this.tt != null) {
            return this.tt.getScreenWidth();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 48);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.p
    public String getTimeZone() {
        if (this.tt != null) {
            return this.tt.getTimeZone();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public int getTimeZoneInt() {
        if (this.tt != null) {
            return this.tt.getTimeZoneInt();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.dna.p
    public String getTotalMem() {
        if (this.tt != null) {
            return this.tt.getTotalMem();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getTotalSpace() {
        if (this.tt != null) {
            return this.tt.getTotalSpace();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getUUId() {
        if (this.tt != null) {
            return this.tt.getUUId();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getUserAgent() {
        if (this.tt != null) {
            return this.tt.getUserAgent();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getVendor() {
        if (this.tt != null) {
            return this.tt.getVendor();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getWebViewUA() {
        if (this.tt != null) {
            return this.tt.getWebViewUA();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.dna.p
    public String getWifiMac(Boolean bool) {
        if (this.tt != null) {
            return this.tt.getWifiMac(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, bool);
        return (String) this.c.apply(sparseArray);
    }
}
