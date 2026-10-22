package com.baidu.location.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.ali.auth.third.login.LoginConstants;
import com.alipay.sdk.m.y.l;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.baidu.location.b.aa;
import com.baidu.location.b.p;
import com.baidu.location.b.v;
import com.baidu.location.pb.CellCommonValue;
import com.baidu.location.pb.CellValue;
import com.baidu.location.pb.CellValueList;
import com.baidu.location.pb.LteCellValue;
import com.baidu.location.pb.NrCellValue;
import com.google.protobuf.micro.ByteStringMicro;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f {
    private g e;
    private b f;
    private TelephonyManager g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f26434a = "NetLocDataManager";
    private final int b = 2000;
    private final int c = 100;
    private final int d = 30000;
    private ConnectivityManager h = null;
    private WifiManager i = null;
    private Handler j = null;
    private String k = null;
    private boolean l = false;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    private boolean q = false;
    private boolean r = false;
    private long s = 0;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final f f26435a = new f();
    }

    public class b extends e {
        private long b = 0;
        private boolean c = false;

        public b() {
        }

        @Override // com.baidu.location.c.e
        public void a(String str) {
        }

        @Override // com.baidu.location.c.e
        public boolean a(Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                final boolean booleanExtra = intent.getBooleanExtra("resultsUpdated", true);
                f.this.n = System.currentTimeMillis() / 1000;
                if (f.this.j == null) {
                    return true;
                }
                f.this.j.post(new Runnable() { // from class: com.baidu.location.c.f.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!f.this.l) {
                            f.this.l = booleanExtra;
                        }
                        p.c().i();
                        if (System.currentTimeMillis() - v.b() <= 5000) {
                            aa.a().c();
                        }
                    }
                });
            } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
                if (!((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) || System.currentTimeMillis() - this.b < 5000) {
                    return false;
                }
                this.b = System.currentTimeMillis();
                if (!this.c) {
                    this.c = true;
                    return false;
                }
                if (f.this.j == null) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.baidu.location.c.e
        public boolean a(List<CellInfo> list) {
            return true;
        }
    }

    public static class c implements Comparator<ScanResult> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult2.level - scanResult.level;
        }
    }

    public static class d implements Comparator<h> {
        private d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            return hVar.g - hVar2.g;
        }
    }

    public static f a() {
        return a.f26435a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0, types: [android.telephony.TelephonyManager, com.baidu.location.c.h] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.baidu.location.c.h] */
    private h a(CellInfo cellInfo, TelephonyManager telephonyManager) {
        ?? r14;
        long jElapsedRealtime;
        long jCurrentTimeMillis;
        long jElapsedRealtimeNanos;
        long jCurrentTimeMillis2;
        long jElapsedRealtimeNanos2;
        long jCurrentTimeMillis3;
        int i = Build.VERSION.SDK_INT;
        h hVar = null;
        CellIdentityNr cellIdentityNr = null;
        try {
            if (cellInfo instanceof CellInfoGsm) {
                h hVar2 = new h();
                CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                hVar2.f26441a = 1;
                if (cellInfo.isRegistered()) {
                    hVar2.d = 1;
                }
                if (i >= 28) {
                    hVar2.b = cellIdentity.getMccString();
                    hVar2.c = cellIdentity.getMncString();
                    hVar2.f = cellInfo.getCellConnectionStatus();
                } else {
                    hVar2.b = cellIdentity.getMcc() == Integer.MAX_VALUE ? null : String.valueOf(cellIdentity.getMcc());
                    hVar2.c = cellIdentity.getMnc() != Integer.MAX_VALUE ? String.valueOf(cellIdentity.getMnc()) : null;
                }
                if (i >= 30) {
                    jElapsedRealtimeNanos2 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                    jCurrentTimeMillis3 = System.currentTimeMillis();
                } else {
                    jElapsedRealtimeNanos2 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                    jCurrentTimeMillis3 = System.currentTimeMillis();
                }
                hVar2.e = jCurrentTimeMillis3 - jElapsedRealtimeNanos2;
                r14 = hVar2;
            } else {
                if (cellInfo instanceof CellInfoCdma) {
                    h hVar3 = new h();
                    CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                    hVar3.f26441a = 2;
                    hVar3.c = cellIdentity2.getSystemId() != Integer.MAX_VALUE ? String.valueOf(cellIdentity2.getSystemId()) : null;
                    if (cellInfo.isRegistered()) {
                        hVar3.d = 1;
                    }
                    if (i >= 28) {
                        hVar3.f = cellInfo.getCellConnectionStatus();
                    }
                    try {
                        String networkOperator = telephonyManager.getNetworkOperator();
                        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                            hVar3.b = networkOperator.substring(0, 3);
                        }
                    } catch (Exception unused) {
                    }
                    try {
                        if (i >= 30) {
                            hVar3.e = System.currentTimeMillis() - (SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis());
                        } else {
                            hVar3.e = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                        }
                    } catch (Error unused2) {
                        hVar3.e = System.currentTimeMillis();
                    }
                    return hVar3;
                }
                if (!(cellInfo instanceof CellInfoWcdma)) {
                    try {
                        if (i >= 29 && (cellInfo instanceof CellInfoTdscdma)) {
                            h hVar4 = new h();
                            CellIdentityTdscdma cellIdentity3 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                            hVar4.f26441a = 5;
                            if (cellInfo.isRegistered()) {
                                hVar4.d = 1;
                            }
                            hVar4.b = cellIdentity3.getMccString();
                            hVar4.c = cellIdentity3.getMncString();
                            hVar4.f = cellInfo.getCellConnectionStatus();
                            if (i >= 30) {
                                jElapsedRealtime = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                                jCurrentTimeMillis = System.currentTimeMillis();
                                hVar = hVar4;
                            } else {
                                jElapsedRealtime = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                                jCurrentTimeMillis = System.currentTimeMillis();
                                hVar = hVar4;
                            }
                        } else if (cellInfo instanceof CellInfoLte) {
                            i iVar = new i();
                            CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                            CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                            CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                            iVar.f26441a = 3;
                            if (cellInfo.isRegistered()) {
                                iVar.d = 1;
                            }
                            iVar.h = cellIdentity4.getCi();
                            iVar.i = cellIdentity4.getPci();
                            iVar.j = cellIdentity4.getTac();
                            iVar.r = cellSignalStrength.getTimingAdvance();
                            if (i >= 28) {
                                iVar.b = cellIdentity4.getMccString();
                                iVar.c = cellIdentity4.getMncString();
                                iVar.f = cellInfo.getCellConnectionStatus();
                                iVar.l = cellIdentity4.getBandwidth();
                            } else {
                                if (cellIdentity4.getMcc() != Integer.MAX_VALUE) {
                                    iVar.b = String.valueOf(cellIdentity4.getMcc());
                                }
                                if (cellIdentity4.getMnc() != Integer.MAX_VALUE) {
                                    iVar.c = String.valueOf(cellIdentity4.getMnc());
                                }
                            }
                            iVar.k = cellIdentity4.getEarfcn();
                            if (i >= 29) {
                                iVar.m = Math.abs(cellSignalStrength.getRssi());
                            }
                            iVar.n = Math.abs(cellSignalStrength.getRsrp());
                            iVar.g = Math.abs(cellSignalStrength.getRsrp());
                            iVar.o = cellSignalStrength.getRsrq();
                            int rssnr = cellSignalStrength.getRssnr();
                            if (rssnr == Integer.MAX_VALUE && cellInfo.isRegistered()) {
                                rssnr = t();
                            }
                            iVar.p = rssnr;
                            iVar.q = cellSignalStrength.getCqi();
                            jElapsedRealtime = i >= 30 ? SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis() : (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                            jCurrentTimeMillis = System.currentTimeMillis();
                            hVar = iVar;
                        } else {
                            if (i < 29 || !(cellInfo instanceof CellInfoNr)) {
                                return null;
                            }
                            j jVar = new j();
                            try {
                                cellIdentityNr = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                            if (cellIdentityNr != null) {
                                jVar.f26441a = 6;
                                jVar.b = cellIdentityNr.getMccString();
                                jVar.c = cellIdentityNr.getMncString();
                                jVar.h = cellIdentityNr.getNci();
                                jVar.i = cellIdentityNr.getPci();
                                int tac = cellIdentityNr.getTac();
                                jVar.j = tac;
                                if (tac == Integer.MAX_VALUE) {
                                    try {
                                        jVar.j = a(cellIdentityNr);
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (jVar.j == Integer.MAX_VALUE) {
                                    try {
                                        jVar.j = a(cellIdentityNr.toString());
                                    } catch (Throwable unused4) {
                                    }
                                }
                                jVar.k = cellIdentityNr.getNrarfcn();
                            }
                            if (cellInfo.isRegistered()) {
                                jVar.d = 1;
                            }
                            jVar.f = cellInfo.getCellConnectionStatus();
                            jVar.l = Math.abs(cellSignalStrengthNr.getSsRsrp());
                            jVar.g = Math.abs(cellSignalStrengthNr.getSsRsrp());
                            jVar.m = Math.abs(cellSignalStrengthNr.getSsRsrq());
                            jVar.n = cellSignalStrengthNr.getSsSinr();
                            jVar.o = Math.abs(cellSignalStrengthNr.getCsiRsrp());
                            jVar.p = Math.abs(cellSignalStrengthNr.getCsiRsrq());
                            jVar.q = cellSignalStrengthNr.getCsiSinr();
                            jVar.e = System.currentTimeMillis() - (i >= 30 ? SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis() : (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
                            r14 = jVar;
                        }
                        hVar.e = jCurrentTimeMillis - jElapsedRealtime;
                        return hVar;
                    } catch (Error unused5) {
                        hVar.e = System.currentTimeMillis();
                        return hVar;
                    }
                }
                h hVar5 = new h();
                CellIdentityWcdma cellIdentity5 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                hVar5.f26441a = 4;
                if (cellInfo.isRegistered()) {
                    hVar5.d = 1;
                }
                if (i >= 28) {
                    hVar5.b = cellIdentity5.getMccString();
                    hVar5.c = cellIdentity5.getMncString();
                    hVar5.f = cellInfo.getCellConnectionStatus();
                } else {
                    hVar5.b = cellIdentity5.getMcc() == Integer.MAX_VALUE ? null : String.valueOf(cellIdentity5.getMcc());
                    hVar5.c = cellIdentity5.getMnc() != Integer.MAX_VALUE ? String.valueOf(cellIdentity5.getMnc()) : null;
                }
                if (i >= 30) {
                    jElapsedRealtimeNanos = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                    jCurrentTimeMillis2 = System.currentTimeMillis();
                } else {
                    jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                    jCurrentTimeMillis2 = System.currentTimeMillis();
                }
                hVar5.e = jCurrentTimeMillis2 - jElapsedRealtimeNanos;
                r14 = hVar5;
            }
        } catch (Error unused6) {
            telephonyManager.e = System.currentTimeMillis();
            r14 = telephonyManager;
        }
        return r14;
    }

    private String a(List<CellInfo> list, TelephonyManager telephonyManager, int i, int[] iArr, boolean z, int i2) {
        ArrayList arrayList = new ArrayList();
        if (i != 1 && com.baidu.location.b.c.b().cb != 1) {
            return null;
        }
        boolean z2 = com.baidu.location.b.c.b().cb != 1 && z;
        Iterator<CellInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next(), telephonyManager));
        }
        return a(a(arrayList, i2), iArr, z2);
    }

    private String a(List<h> list, int[] iArr, boolean z) {
        if (list == null || list.size() == 0) {
            return null;
        }
        CellValueList cellValueList = new CellValueList();
        for (h hVar : list) {
            CellValue cellValue = new CellValue();
            CellCommonValue cellCommonValue = new CellCommonValue();
            cellCommonValue.setCellType(hVar.f26441a);
            String str = hVar.b;
            if (str != null) {
                cellCommonValue.setMcc(ByteStringMicro.copyFromUtf8(str));
            }
            String str2 = hVar.c;
            if (str2 != null) {
                cellCommonValue.setMnc(ByteStringMicro.copyFromUtf8(str2));
            }
            cellCommonValue.setRegistered(hVar.d);
            cellCommonValue.setTimestamp(hVar.e);
            int i = hVar.f;
            if (i != Integer.MAX_VALUE) {
                cellCommonValue.setCellconnectionstatus(i);
            }
            if (!z) {
                cellValue.setCellCommonValue(cellCommonValue);
            }
            if (hVar instanceof i) {
                LteCellValue lteCellValue = new LteCellValue();
                i iVar = (i) hVar;
                int i2 = iVar.h;
                if (i2 != Integer.MAX_VALUE && (!z || iArr[0] == 1)) {
                    lteCellValue.setCi(i2);
                }
                int i3 = iVar.i;
                if (i3 != Integer.MAX_VALUE && (!z || iArr[1] == 1)) {
                    lteCellValue.setPci(i3);
                }
                int i4 = iVar.j;
                if (i4 != Integer.MAX_VALUE && (!z || iArr[2] == 1)) {
                    lteCellValue.setTac(i4);
                }
                int i5 = iVar.k;
                if (i5 != Integer.MAX_VALUE && (!z || iArr[3] == 1)) {
                    lteCellValue.setEarfcn(i5);
                }
                int i6 = iVar.l;
                if (i6 != Integer.MAX_VALUE && (!z || iArr[4] == 1)) {
                    lteCellValue.setBandwidth(i6);
                }
                int i7 = iVar.m;
                if (i7 != Integer.MAX_VALUE && (!z || iArr[5] == 1)) {
                    lteCellValue.setRssi(i7);
                }
                int i8 = iVar.n;
                if (i8 != Integer.MAX_VALUE && (!z || iArr[6] == 1)) {
                    lteCellValue.setRsrp(i8);
                }
                int i9 = iVar.o;
                if (i9 != Integer.MAX_VALUE && (!z || iArr[7] == 1)) {
                    lteCellValue.setRsrq(i9);
                }
                int i10 = iVar.p;
                if (i10 != Integer.MAX_VALUE && (!z || iArr[8] == 1)) {
                    lteCellValue.setRssnr(i10);
                }
                int i11 = iVar.q;
                if (i11 != Integer.MAX_VALUE && (!z || iArr[9] == 1)) {
                    lteCellValue.setCqi(i11);
                }
                int i12 = iVar.r;
                if (i12 != Integer.MAX_VALUE && (!z || iArr[10] == 1)) {
                    lteCellValue.setTimingadvance(i12);
                }
                cellValue.setLteCellValue(lteCellValue);
            } else if (hVar instanceof j) {
                NrCellValue nrCellValue = new NrCellValue();
                j jVar = (j) hVar;
                long j = jVar.h;
                if (j != Long.MAX_VALUE && (!z || iArr[0] == 1)) {
                    nrCellValue.setCi(j);
                }
                int i13 = jVar.i;
                if (i13 != Integer.MAX_VALUE && (!z || iArr[1] == 1)) {
                    nrCellValue.setPci(i13);
                }
                int i14 = jVar.j;
                if (i14 != Integer.MAX_VALUE && (!z || iArr[2] == 1)) {
                    nrCellValue.setTac(i14);
                }
                int i15 = jVar.k;
                if (i15 != Integer.MAX_VALUE && (!z || iArr[11] == 1)) {
                    nrCellValue.setNrarfcn(i15);
                }
                int i16 = jVar.l;
                if (i16 != Integer.MAX_VALUE && (!z || iArr[12] == 1)) {
                    nrCellValue.setSsrsrp(i16);
                }
                int i17 = jVar.m;
                if (i17 != Integer.MAX_VALUE && (!z || iArr[13] == 1)) {
                    nrCellValue.setSsrsrq(i17);
                }
                int i18 = jVar.n;
                if (i18 != Integer.MAX_VALUE && (!z || iArr[14] == 1)) {
                    nrCellValue.setSssinr(i18);
                }
                int i19 = jVar.o;
                if (i19 != Integer.MAX_VALUE && (!z || iArr[15] == 1)) {
                    nrCellValue.setCsirsrp(i19);
                }
                int i20 = jVar.p;
                if (i20 != Integer.MAX_VALUE && (!z || iArr[16] == 1)) {
                    nrCellValue.setCsirsrq(i20);
                }
                int i21 = jVar.q;
                if (i21 != Integer.MAX_VALUE && (!z || iArr[17] == 1)) {
                    nrCellValue.setCsisinr(i21);
                }
                cellValue.setNrCellValue(nrCellValue);
            }
            cellValueList.addCellValue(cellValue);
        }
        return Base64.encodeToString(cellValueList.toByteArray(), 0);
    }

    private static List<h> a(List<h> list, int i) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list;
        }
        Collections.sort(list.subList(1, list.size()), new d());
        list.size();
        return list.subList(0, Math.min(list.size(), i));
    }

    private void a(TelephonyManager telephonyManager, int i, int[] iArr, boolean z, int i2) {
        if (telephonyManager != null) {
            try {
                this.k = a(telephonyManager.getAllCellInfo(), telephonyManager, i, iArr, z, i2);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean a(com.baidu.location.c.a aVar, int i, int i2) {
        return false;
    }

    private boolean a(k kVar, long j) {
        long jElapsedRealtimeNanos;
        List<ScanResult> list;
        long j2;
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            jElapsedRealtimeNanos = 0;
        }
        boolean z = jElapsedRealtimeNanos > 0;
        if (!z || (list = kVar.f26442a) == null || list.size() == 0) {
            return false;
        }
        int size = kVar.f26442a.size();
        if (size > 16) {
            size = 16;
        }
        long j3 = 0;
        long j4 = 0;
        for (int i = 0; i < size; i++) {
            if (kVar.f26442a.get(i) != null && kVar.f26442a.get(i).level != 0 && z) {
                try {
                    j2 = (jElapsedRealtimeNanos - kVar.f26442a.get(i).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j2 = 0;
                }
                j3 += j2;
                if (j2 > j4) {
                    j4 = j2;
                }
            }
        }
        return j4 * 1000 > j || (j3 / ((long) size)) * 1000 > j;
    }

    private String b(String str) {
        if (str != null && str.length() > com.baidu.location.b.c.b().dm) {
            str = str.substring(0, com.baidu.location.b.c.b().dm);
        }
        if (str != null) {
            return (str.contains("&") || str.contains(l.b)) ? str.replace("&", LoginConstants.UNDER_LINE).replace(l.b, LoginConstants.UNDER_LINE) : str;
        }
        return str;
    }

    private String c(String str) {
        if (str != null) {
            return (str.contains("&") || str.contains(l.b)) ? str.replace("&", LoginConstants.UNDER_LINE).replace(l.b, LoginConstants.UNDER_LINE) : str;
        }
        return str;
    }

    private synchronized String s() {
        String str;
        str = this.k;
        return (str == null || str.length() == 0) ? null : this.k.replace("\n", "");
    }

    private int t() {
        try {
            TelephonyManager telephonyManager = this.g;
            if (telephonyManager != null) {
                return com.baidu.location.e.h.a(telephonyManager.getSignalStrength(), "getLteRssnr");
            }
            return Integer.MAX_VALUE;
        } catch (Exception unused) {
            return Integer.MAX_VALUE;
        }
    }

    public int a(CellIdentityNr cellIdentityNr) {
        try {
            return com.baidu.location.e.h.a(cellIdentityNr, "getHwTac");
        } catch (Throwable unused) {
            return -1;
        }
    }

    public int a(k kVar) {
        int i;
        for (int i2 = 0; i2 < kVar.a(); i2++) {
            if (kVar.f26442a.get(i2) != null && (i = -kVar.f26442a.get(i2).level) > 0) {
                return i;
            }
        }
        return 0;
    }

    public int a(String str) {
        if (str == null || !str.contains("mNrTac")) {
            return -1;
        }
        Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(" ", ""));
        while (true) {
            int i = -1;
            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    try {
                        i = Integer.parseInt(matcher.group(1));
                    } catch (Throwable unused) {
                    }
                }
            }
            return i;
        }
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        g gVar = this.e;
        if (gVar != null) {
            return gVar.a(aVar, telephonyManager);
        }
        return null;
    }

    public k a(int i) {
        g gVar = this.e;
        if (gVar != null) {
            return gVar.e(i);
        }
        return null;
    }

    public String a(int i, k kVar) {
        if (i == 0) {
            return null;
        }
        int i2 = 1;
        if (kVar.a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = kVar.f26442a.size();
        int i3 = com.baidu.location.e.h.N;
        if (size > i3) {
            size = i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            if (kVar.f26442a.get(i5) != null) {
                if ((i2 & i) != 0 && kVar.f26442a.get(i5).BSSID != null) {
                    stringBuffer.append(i4 == 0 ? "&ssid=" : "|");
                    stringBuffer.append(kVar.f26442a.get(i5).BSSID.replace(u15.f19942b, ""));
                    stringBuffer.append(l.b);
                    stringBuffer.append(c(kVar.f26442a.get(i5).SSID));
                    i4++;
                }
                i2 <<= 1;
            }
        }
        return stringBuffer.toString();
    }

    public String a(int i, boolean z, k kVar, int i2) {
        g gVar = this.e;
        if (gVar != null) {
            return gVar.a(i, z, kVar, i2);
        }
        return null;
    }

    public String a(WifiInfo wifiInfo, String str) {
        g gVar = this.e;
        if (gVar != null) {
            return gVar.a(wifiInfo, str);
        }
        return null;
    }

    public String a(com.baidu.location.c.a aVar) {
        g gVar = this.e;
        if (gVar != null) {
            return gVar.a(aVar);
        }
        return null;
    }

    public String a(k kVar, int i, String str, boolean z, int i2) {
        g gVar = this.e;
        if (gVar != null) {
            return gVar.a(kVar, i, str, z, i2);
        }
        return null;
    }

    public synchronized void a(Context context) {
        if (this.e == null) {
            return;
        }
        try {
            this.g = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            this.i = (WifiManager) context.getSystemService("wifi");
            this.h = (ConnectivityManager) context.getSystemService("connectivity");
            if (Looper.myLooper() != null) {
                this.j = new Handler();
            }
            this.e.a(g.a.GET_ALL_DATA);
            a(true);
            this.e.b(true);
            this.e.c(30);
            this.e.a(false);
            this.e.a(context, new ArrayList());
        } catch (Exception unused) {
        }
    }

    public void a(boolean z) {
        int i;
        g gVar;
        g gVar2 = this.e;
        if (gVar2 == null || this.r == z) {
            return;
        }
        if (z) {
            gVar2.a(100);
            gVar = this.e;
            i = 2000;
        } else {
            i = 0;
            gVar2.a(0);
            gVar = this.e;
        }
        gVar.b(i);
        this.r = z;
    }

    public boolean a(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.o;
        if (jCurrentTimeMillis >= 0 && jCurrentTimeMillis <= 2000) {
            return false;
        }
        this.o = System.currentTimeMillis();
        if (com.baidu.location.e.h.f != 4) {
            a(0);
        }
        g gVar = this.e;
        return gVar != null && gVar.c() - j > 0;
    }

    public boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        g gVar = this.e;
        if (gVar != null) {
            return gVar.a(aVar, aVar2);
        }
        return false;
    }

    public boolean a(k kVar, k kVar2, float f) {
        boolean zA = kVar2.a(kVar, f);
        long jCurrentTimeMillis = System.currentTimeMillis() - com.baidu.location.b.b.c;
        if (jCurrentTimeMillis <= 0 || jCurrentTimeMillis >= 30000 || !zA || c(kVar2) - c(kVar) <= 30) {
            return zA;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public long b(k kVar) {
        long jElapsedRealtimeNanos;
        long j;
        List<ScanResult> list = kVar.f26442a;
        if (list == null || list.size() == 0) {
            return 0L;
        }
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            jElapsedRealtimeNanos = 0;
        }
        boolean z = jElapsedRealtimeNanos > 0;
        if (!z) {
            return 0L;
        }
        int size = kVar.f26442a.size();
        if (size > 16) {
            size = 16;
        }
        long j2 = 2147483647L;
        for (int i = 0; i < size; i++) {
            if (kVar.f26442a.get(i) != null && kVar.f26442a.get(i).level != 0 && z) {
                try {
                    j = (jElapsedRealtimeNanos - kVar.f26442a.get(i).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j = 0;
                }
                if (j < j2) {
                    j2 = j;
                }
            }
        }
        if (!z) {
            j2 = 0;
        }
        if (j2 < 0) {
            return 0L;
        }
        return j2;
    }

    public String b(com.baidu.location.c.a aVar) {
        if (this.e == null) {
            return null;
        }
        return this.e.c(aVar) + "&cl_list=" + s();
    }

    public synchronized void b() {
        if (this.e == null) {
            this.e = new g();
        }
        try {
            b bVar = new b();
            this.f = bVar;
            g gVar = this.e;
            if (gVar != null) {
                gVar.a(bVar);
            }
        } catch (Exception unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public boolean b(long j) {
        k kVarR;
        try {
            return (this.i.isWifiEnabled() || this.i.isScanAlwaysAvailable()) && !l() && (kVarR = r()) != null && a(kVarR, j);
        } catch (Exception | NoSuchMethodError unused) {
            return false;
        }
    }

    public long c(k kVar) {
        long jElapsedRealtimeNanos;
        long j;
        if (kVar.a() == 0) {
            return 0L;
        }
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            jElapsedRealtimeNanos = 0;
        }
        boolean z = jElapsedRealtimeNanos > 0;
        if (!z) {
            return 0L;
        }
        int size = kVar.f26442a.size();
        if (size > 16) {
            size = 16;
        }
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        for (int i = 0; i < size; i++) {
            if (kVar.f26442a.get(i) != null && kVar.f26442a.get(i).level != 0 && z) {
                try {
                    j = (jElapsedRealtimeNanos - kVar.f26442a.get(i).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j = 0;
                }
                j4 += j;
                j2++;
                if (j > j3) {
                    j3 = j;
                }
            }
        }
        return j2 > 1 ? (j4 - j3) / (j2 - 1) : j3;
    }

    public HashSet<String> c(com.baidu.location.c.a aVar) {
        g gVar = this.e;
        if (gVar != null) {
            return gVar.b(aVar);
        }
        return null;
    }

    public void c() {
        g gVar = this.e;
        if (gVar != null) {
            gVar.b();
        }
    }

    public synchronized void d() {
        c();
        this.g = null;
        this.i = null;
        this.f = null;
    }

    public boolean e() {
        g gVar = this.e;
        if (gVar != null) {
            return gVar.d();
        }
        return false;
    }

    public synchronized com.baidu.location.c.a f() {
        if (this.e == null) {
            return null;
        }
        a(this.g, com.baidu.location.e.h.aJ, com.baidu.location.e.h.aK, com.baidu.location.e.h.aL, com.baidu.location.e.h.aM);
        com.baidu.location.c.a aVarD = this.e.d(30000);
        this.q = a(aVarD, 30000, com.baidu.location.b.c.b().dI);
        return aVarD;
    }

    public int g() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = this.h;
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 0;
            }
            return activeNetworkInfo.getSubtype();
        } catch (Exception unused) {
            return 0;
        }
    }

    public String h() {
        int simState = -1;
        try {
            TelephonyManager telephonyManager = this.g;
            if (telephonyManager != null) {
                simState = telephonyManager.getSimState();
            }
        } catch (Exception unused) {
        }
        return "&sim=" + simState;
    }

    public void i() {
        this.s = 0L;
    }

    public boolean j() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.m;
        if (jCurrentTimeMillis - j > 0 && jCurrentTimeMillis - j <= 5000) {
            return false;
        }
        this.m = jCurrentTimeMillis;
        i();
        return k();
    }

    public boolean k() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        g gVar = this.e;
        long jC = gVar != null ? gVar.c() : 0L;
        long j = jCurrentTimeMillis - jC;
        if (j > 0) {
            long j2 = this.s;
            if (j <= j2 + 5000 || jCurrentTimeMillis - (this.n * 1000) <= j2 + 5000) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 28 && j < 25000) {
                return false;
            }
            if (l() && !m() && j <= this.s + 10000) {
                return false;
            }
        }
        return a(jC);
    }

    public boolean l() {
        try {
            ConnectivityManager connectivityManager = this.h;
            if (connectivityManager != null) {
                return connectivityManager.getNetworkInfo(1).isConnected();
            }
            return false;
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public boolean m() {
        return false;
    }

    @SuppressLint({"NewApi"})
    public String n() {
        WifiManager wifiManager = this.i;
        if (wifiManager == null) {
            return "";
        }
        try {
            return (wifiManager.isWifiEnabled() || this.i.isScanAlwaysAvailable()) ? "&wifio=1" : "";
        } catch (Exception | NoSuchMethodError unused) {
            return "";
        }
    }

    public String o() {
        g gVar = this.e;
        if (gVar == null || com.baidu.location.e.h.f == 4) {
            return null;
        }
        return gVar.e();
    }

    public WifiInfo p() {
        g gVar;
        if (com.baidu.location.e.h.f == 4 || (gVar = this.e) == null) {
            return null;
        }
        return gVar.f();
    }

    public String q() {
        k kVarR;
        if (com.baidu.location.b.c.b().dl == 0 || (kVarR = r()) == null || kVarR.a() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ScanResult scanResult : kVarR.f26442a) {
            if (scanResult != null && scanResult.level != 0 && scanResult.BSSID != null) {
                arrayList.add(scanResult);
            }
        }
        Collections.sort(arrayList, new c());
        int iMin = Math.min(com.baidu.location.b.c.b().dn, arrayList.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iMin; i++) {
            String strReplace = ((ScanResult) arrayList.get(i)).BSSID.replace(u15.f19942b, "");
            String strB = b(((ScanResult) arrayList.get(i)).SSID);
            int i2 = ((ScanResult) arrayList.get(i)).level;
            if (i2 < 0) {
                i2 = -i2;
            }
            sb.append(strReplace + "," + strB + "," + i2);
            sb.append(l.b);
        }
        return sb.toString();
    }

    public k r() {
        g gVar = this.e;
        return (gVar == null || com.baidu.location.e.h.f == 4) ? new k(null, 0L) : gVar.g();
    }
}
