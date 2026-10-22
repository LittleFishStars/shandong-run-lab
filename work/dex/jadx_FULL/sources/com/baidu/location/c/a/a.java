package com.baidu.location.c.a;

import android.annotation.SuppressLint;
import android.content.Context;
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
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.alipay.sdk.m.y.l;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.baidu.location.c.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a implements com.baidu.location.c.b.a {
    public static int b;
    private static Class<?> w;
    private C0261a t;
    private b u;
    private c v;
    private Context x;
    private int e = 30;
    private int f = -1;
    private AtomicInteger g = new AtomicInteger(0);
    private float h = 0.2f;
    private boolean i = true;
    private boolean j = false;
    private TelephonyManager k = null;
    private TelephonyManager l = null;
    private TelephonyManager m = null;
    private SubscriptionManager n = null;
    private com.baidu.location.c.a o = new com.baidu.location.c.a();
    private com.baidu.location.c.a p = null;
    private List<com.baidu.location.c.a> q = null;
    private Executor r = null;
    private d s = null;
    private boolean y = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26408a = 0;
    private boolean z = false;
    private long A = 0;
    private long B = 0;
    private boolean C = false;
    private boolean D = true;
    private boolean E = false;
    private Handler F = null;
    private int G = -1;
    private int H = -1;
    private final Object I = new Object();

    /* JADX INFO: renamed from: com.baidu.location.c.a.a$a, reason: collision with other inner class name */
    public class C0261a extends TelephonyManager.CellInfoCallback {
        private C0261a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            if (!com.baidu.location.c.b.a.d || g.h().a(list)) {
                a.this.i();
            }
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onError(int i, Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.h().a("cell onError = " + i);
            }
        }
    }

    public class b extends TelephonyManager.CellInfoCallback {
        private b() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            boolean z = com.baidu.location.c.b.a.c;
            if (z && com.baidu.location.c.b.a.d) {
                g.h().a("onCellInfo");
            }
            if (list == null) {
                return;
            }
            boolean z2 = com.baidu.location.c.b.a.d;
            if (!z2 || g.h().a(list)) {
                if (z && z2) {
                    g.h().a("request sim1 cellInfo");
                }
                if (a.this.C) {
                    a aVar = a.this;
                    aVar.D = !aVar.D;
                }
                if (!a.this.C || a.this.D) {
                    a.this.i();
                }
            }
        }
    }

    public class c extends TelephonyManager.CellInfoCallback {
        private c() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            boolean z = com.baidu.location.c.b.a.d;
            if (!z || g.h().a(list)) {
                if (com.baidu.location.c.b.a.c && z) {
                    g.h().a("request sim2 cellInfo");
                }
                if (a.this.C) {
                    a aVar = a.this;
                    aVar.D = !aVar.D;
                }
                if (!a.this.C || a.this.D) {
                    a.this.i();
                }
            }
        }
    }

    public class d extends PhoneStateListener {
        public d() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            a.this.F.post(new Runnable() { // from class: com.baidu.location.c.a.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.h().a("cell received cellinfo change");
                        }
                        a.this.f();
                    } catch (Exception e) {
                        if (com.baidu.location.c.b.a.c) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            com.baidu.location.c.a aVar;
            int cdmaDbm;
            if (a.this.o != null) {
                if (a.this.o.i != 'g') {
                    if (a.this.o.i == 'c') {
                        aVar = a.this.o;
                        cdmaDbm = signalStrength.getCdmaDbm();
                    }
                    if (com.baidu.location.c.b.a.c || !com.baidu.location.c.b.a.d) {
                    }
                    g.h().a("cell strength===== cell singal strength changed : " + a.this.o.h);
                    return;
                }
                aVar = a.this.o;
                cdmaDbm = signalStrength.getGsmSignalStrength();
                aVar.h = cdmaDbm;
                if (com.baidu.location.c.b.a.c) {
                }
            }
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f26415a = new a();
    }

    private static int a(CellIdentityNr cellIdentityNr) {
        try {
            int iA = com.baidu.location.c.b.b.a(cellIdentityNr, "getHwTac");
            if (!com.baidu.location.c.b.a.c || !com.baidu.location.c.b.a.d) {
                return iA;
            }
            g.h().a(" get hw tac = " + iA);
            return iA;
        } catch (Throwable th) {
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.h().a(" get hw tac exception !" + th);
            }
            return -1;
        }
    }

    private int a(String str) {
        if (str == null || !str.contains("cl_s2")) {
            return -1;
        }
        try {
            Matcher matcher = Pattern.compile("cl_s2=[0-9]{1,}").matcher(str);
            if (!matcher.find()) {
                return -1;
            }
            String strGroup = matcher.group();
            return Integer.parseInt(strGroup.substring(strGroup.indexOf("cl_s2=") + 6, strGroup.length()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static a a() {
        return e.f26415a;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x02cf A[Catch: Exception -> 0x0482, TryCatch #8 {Exception -> 0x0482, blocks: (B:70:0x01e5, B:72:0x01ea, B:74:0x01f5, B:76:0x01f9, B:77:0x0202, B:79:0x0240, B:80:0x0244, B:81:0x0248, B:83:0x024e, B:85:0x0253, B:87:0x025e, B:89:0x0262, B:90:0x026b, B:98:0x0288, B:106:0x02a5, B:108:0x02cf, B:103:0x029e, B:105:0x02a2, B:95:0x0281, B:97:0x0285, B:109:0x02d5, B:119:0x030f, B:121:0x0313, B:123:0x0317, B:125:0x0322, B:133:0x033f, B:141:0x035c, B:155:0x039c, B:169:0x03d8, B:173:0x03e6, B:174:0x03e8, B:176:0x03f5, B:177:0x03fb, B:179:0x0404, B:180:0x040a, B:182:0x041f, B:166:0x03d1, B:168:0x03d5, B:152:0x0395, B:154:0x0399, B:138:0x0355, B:140:0x0359, B:130:0x0338, B:132:0x033c, B:118:0x030a, B:158:0x03a1, B:160:0x03ad, B:162:0x03b1, B:163:0x03c9, B:92:0x0271, B:144:0x0369, B:146:0x0371, B:148:0x0375, B:149:0x038d, B:135:0x0345, B:127:0x0328, B:111:0x02d9, B:113:0x02e6, B:115:0x02ea, B:100:0x028e), top: B:240:0x01e5, inners: #0, #1, #2, #3, #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x035c A[Catch: Exception -> 0x0482, TRY_LEAVE, TryCatch #8 {Exception -> 0x0482, blocks: (B:70:0x01e5, B:72:0x01ea, B:74:0x01f5, B:76:0x01f9, B:77:0x0202, B:79:0x0240, B:80:0x0244, B:81:0x0248, B:83:0x024e, B:85:0x0253, B:87:0x025e, B:89:0x0262, B:90:0x026b, B:98:0x0288, B:106:0x02a5, B:108:0x02cf, B:103:0x029e, B:105:0x02a2, B:95:0x0281, B:97:0x0285, B:109:0x02d5, B:119:0x030f, B:121:0x0313, B:123:0x0317, B:125:0x0322, B:133:0x033f, B:141:0x035c, B:155:0x039c, B:169:0x03d8, B:173:0x03e6, B:174:0x03e8, B:176:0x03f5, B:177:0x03fb, B:179:0x0404, B:180:0x040a, B:182:0x041f, B:166:0x03d1, B:168:0x03d5, B:152:0x0395, B:154:0x0399, B:138:0x0355, B:140:0x0359, B:130:0x0338, B:132:0x033c, B:118:0x030a, B:158:0x03a1, B:160:0x03ad, B:162:0x03b1, B:163:0x03c9, B:92:0x0271, B:144:0x0369, B:146:0x0371, B:148:0x0375, B:149:0x038d, B:135:0x0345, B:127:0x0328, B:111:0x02d9, B:113:0x02e6, B:115:0x02ea, B:100:0x028e), top: B:240:0x01e5, inners: #0, #1, #2, #3, #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0371 A[Catch: all -> 0x0394, TryCatch #2 {all -> 0x0394, blocks: (B:144:0x0369, B:146:0x0371, B:148:0x0375, B:149:0x038d), top: B:228:0x0369, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x039c A[Catch: Exception -> 0x0482, TRY_LEAVE, TryCatch #8 {Exception -> 0x0482, blocks: (B:70:0x01e5, B:72:0x01ea, B:74:0x01f5, B:76:0x01f9, B:77:0x0202, B:79:0x0240, B:80:0x0244, B:81:0x0248, B:83:0x024e, B:85:0x0253, B:87:0x025e, B:89:0x0262, B:90:0x026b, B:98:0x0288, B:106:0x02a5, B:108:0x02cf, B:103:0x029e, B:105:0x02a2, B:95:0x0281, B:97:0x0285, B:109:0x02d5, B:119:0x030f, B:121:0x0313, B:123:0x0317, B:125:0x0322, B:133:0x033f, B:141:0x035c, B:155:0x039c, B:169:0x03d8, B:173:0x03e6, B:174:0x03e8, B:176:0x03f5, B:177:0x03fb, B:179:0x0404, B:180:0x040a, B:182:0x041f, B:166:0x03d1, B:168:0x03d5, B:152:0x0395, B:154:0x0399, B:138:0x0355, B:140:0x0359, B:130:0x0338, B:132:0x033c, B:118:0x030a, B:158:0x03a1, B:160:0x03ad, B:162:0x03b1, B:163:0x03c9, B:92:0x0271, B:144:0x0369, B:146:0x0371, B:148:0x0375, B:149:0x038d, B:135:0x0345, B:127:0x0328, B:111:0x02d9, B:113:0x02e6, B:115:0x02ea, B:100:0x028e), top: B:240:0x01e5, inners: #0, #1, #2, #3, #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:160:0x03ad A[Catch: all -> 0x03d0, TryCatch #0 {all -> 0x03d0, blocks: (B:158:0x03a1, B:160:0x03ad, B:162:0x03b1, B:163:0x03c9), top: B:224:0x03a1, outer: #8 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:176:0x03f5 A[Catch: Exception -> 0x0482, TryCatch #8 {Exception -> 0x0482, blocks: (B:70:0x01e5, B:72:0x01ea, B:74:0x01f5, B:76:0x01f9, B:77:0x0202, B:79:0x0240, B:80:0x0244, B:81:0x0248, B:83:0x024e, B:85:0x0253, B:87:0x025e, B:89:0x0262, B:90:0x026b, B:98:0x0288, B:106:0x02a5, B:108:0x02cf, B:103:0x029e, B:105:0x02a2, B:95:0x0281, B:97:0x0285, B:109:0x02d5, B:119:0x030f, B:121:0x0313, B:123:0x0317, B:125:0x0322, B:133:0x033f, B:141:0x035c, B:155:0x039c, B:169:0x03d8, B:173:0x03e6, B:174:0x03e8, B:176:0x03f5, B:177:0x03fb, B:179:0x0404, B:180:0x040a, B:182:0x041f, B:166:0x03d1, B:168:0x03d5, B:152:0x0395, B:154:0x0399, B:138:0x0355, B:140:0x0359, B:130:0x0338, B:132:0x033c, B:118:0x030a, B:158:0x03a1, B:160:0x03ad, B:162:0x03b1, B:163:0x03c9, B:92:0x0271, B:144:0x0369, B:146:0x0371, B:148:0x0375, B:149:0x038d, B:135:0x0345, B:127:0x0328, B:111:0x02d9, B:113:0x02e6, B:115:0x02ea, B:100:0x028e), top: B:240:0x01e5, inners: #0, #1, #2, #3, #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x0404 A[Catch: Exception -> 0x0482, TryCatch #8 {Exception -> 0x0482, blocks: (B:70:0x01e5, B:72:0x01ea, B:74:0x01f5, B:76:0x01f9, B:77:0x0202, B:79:0x0240, B:80:0x0244, B:81:0x0248, B:83:0x024e, B:85:0x0253, B:87:0x025e, B:89:0x0262, B:90:0x026b, B:98:0x0288, B:106:0x02a5, B:108:0x02cf, B:103:0x029e, B:105:0x02a2, B:95:0x0281, B:97:0x0285, B:109:0x02d5, B:119:0x030f, B:121:0x0313, B:123:0x0317, B:125:0x0322, B:133:0x033f, B:141:0x035c, B:155:0x039c, B:169:0x03d8, B:173:0x03e6, B:174:0x03e8, B:176:0x03f5, B:177:0x03fb, B:179:0x0404, B:180:0x040a, B:182:0x041f, B:166:0x03d1, B:168:0x03d5, B:152:0x0395, B:154:0x0399, B:138:0x0355, B:140:0x0359, B:130:0x0338, B:132:0x033c, B:118:0x030a, B:158:0x03a1, B:160:0x03ad, B:162:0x03b1, B:163:0x03c9, B:92:0x0271, B:144:0x0369, B:146:0x0371, B:148:0x0375, B:149:0x038d, B:135:0x0345, B:127:0x0328, B:111:0x02d9, B:113:0x02e6, B:115:0x02ea, B:100:0x028e), top: B:240:0x01e5, inners: #0, #1, #2, #3, #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x041f A[Catch: Exception -> 0x0482, TRY_LEAVE, TryCatch #8 {Exception -> 0x0482, blocks: (B:70:0x01e5, B:72:0x01ea, B:74:0x01f5, B:76:0x01f9, B:77:0x0202, B:79:0x0240, B:80:0x0244, B:81:0x0248, B:83:0x024e, B:85:0x0253, B:87:0x025e, B:89:0x0262, B:90:0x026b, B:98:0x0288, B:106:0x02a5, B:108:0x02cf, B:103:0x029e, B:105:0x02a2, B:95:0x0281, B:97:0x0285, B:109:0x02d5, B:119:0x030f, B:121:0x0313, B:123:0x0317, B:125:0x0322, B:133:0x033f, B:141:0x035c, B:155:0x039c, B:169:0x03d8, B:173:0x03e6, B:174:0x03e8, B:176:0x03f5, B:177:0x03fb, B:179:0x0404, B:180:0x040a, B:182:0x041f, B:166:0x03d1, B:168:0x03d5, B:152:0x0395, B:154:0x0399, B:138:0x0355, B:140:0x0359, B:130:0x0338, B:132:0x033c, B:118:0x030a, B:158:0x03a1, B:160:0x03ad, B:162:0x03b1, B:163:0x03c9, B:92:0x0271, B:144:0x0369, B:146:0x0371, B:148:0x0375, B:149:0x038d, B:135:0x0345, B:127:0x0328, B:111:0x02d9, B:113:0x02e6, B:115:0x02ea, B:100:0x028e), top: B:240:0x01e5, inners: #0, #1, #2, #3, #4, #5, #7 }] */
    /* JADX WARN: Code duplicated, block: B:224:0x03a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x0369 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:230:0x0345 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:238:0x028e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private com.baidu.location.c.a a(CellInfo cellInfo, com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        boolean z;
        int cellConnectionStatus;
        int iIntValue;
        com.baidu.location.c.e eVarH;
        StringBuilder sb;
        String str;
        int i;
        com.baidu.location.c.e eVarH2;
        String str2;
        CellIdentityNr cellIdentityNr;
        int iD;
        int iA;
        int iB;
        int tac;
        CellSignalStrengthNr cellSignalStrengthNr;
        int cellConnectionStatus2;
        int i2 = Build.VERSION.SDK_INT;
        int iIntValue2 = Integer.valueOf(i2).intValue();
        if (iIntValue2 < 17) {
            return null;
        }
        com.baidu.location.c.a aVar2 = new com.baidu.location.c.a();
        if (cellInfo instanceof CellInfoGsm) {
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.h().a("CellInfoGsm");
            }
            aVar2.c = d(cellIdentity.getMcc());
            aVar2.d = d(cellIdentity.getMnc());
            aVar2.f26407a = d(cellIdentity.getLac());
            aVar2.b = d(cellIdentity.getCid());
            aVar2.i = 'g';
            aVar2.h = cellInfoGsm.getCellSignalStrength().getAsuLevel();
            aVar2.l = 2;
            if (i2 >= 28) {
                cellConnectionStatus = cellInfo.getCellConnectionStatus();
                aVar2.j = cellConnectionStatus;
            }
            z = true;
        } else {
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                boolean z2 = com.baidu.location.c.b.a.c;
                if (z2 && com.baidu.location.c.b.a.d) {
                    g.h().a("CellInfoCdma");
                    g.h().a("lat = " + cellIdentity2.getLatitude());
                    g.h().a("lon = " + cellIdentity2.getLongitude());
                }
                aVar2.e = cellIdentity2.getLatitude();
                aVar2.f = cellIdentity2.getLongitude();
                aVar2.d = d(cellIdentity2.getSystemId());
                aVar2.f26407a = d(cellIdentity2.getNetworkId());
                aVar2.b = d(cellIdentity2.getBasestationId());
                aVar2.i = 'c';
                aVar2.h = cellInfoCdma.getCellSignalStrength().getCdmaDbm();
                aVar2.l = 1;
                if (i2 >= 28) {
                    aVar2.j = cellInfo.getCellConnectionStatus();
                }
                if (aVar == null || (i = aVar.c) <= 0) {
                    try {
                        String networkOperator = telephonyManager.getNetworkOperator();
                        if (networkOperator == null || networkOperator.length() <= 0 || networkOperator.length() < 3 || (iIntValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue()) < 0) {
                            iIntValue = -1;
                        }
                    } catch (Exception e2) {
                        if (com.baidu.location.c.b.a.c) {
                            e2.printStackTrace();
                        }
                    }
                    if (iIntValue > 0) {
                        aVar2.c = iIntValue;
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            eVarH = g.h();
                            sb = new StringBuilder();
                            str = "cdma set old mcc = ";
                            sb.append(str);
                            sb.append(aVar2.c);
                            eVarH.a(sb.toString());
                        }
                    }
                } else {
                    aVar2.c = i;
                    if (z2 && com.baidu.location.c.b.a.d) {
                        eVarH = g.h();
                        sb = new StringBuilder();
                        str = "cdma set old cellinfo mcc = ";
                        sb.append(str);
                        sb.append(aVar2.c);
                        eVarH.a(sb.toString());
                    }
                }
            } else if (cellInfo instanceof CellInfoLte) {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                CellIdentityLte cellIdentity3 = cellInfoLte.getCellIdentity();
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.h().a("CellInfoLte");
                }
                aVar2.c = d(cellIdentity3.getMcc());
                aVar2.d = d(cellIdentity3.getMnc());
                aVar2.f26407a = d(cellIdentity3.getTac());
                aVar2.b = d(cellIdentity3.getCi());
                aVar2.i = 'g';
                aVar2.h = cellInfoLte.getCellSignalStrength().getAsuLevel();
                aVar2.l = 3;
                if (i2 >= 28) {
                    cellConnectionStatus = cellInfo.getCellConnectionStatus();
                    aVar2.j = cellConnectionStatus;
                }
            } else {
                z = false;
            }
            z = true;
        }
        if (iIntValue2 >= 18 && !z) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.h().a("CellInfoWcdma");
                    }
                    aVar2.c = d(cellIdentity4.getMcc());
                    aVar2.d = d(cellIdentity4.getMnc());
                    aVar2.f26407a = d(cellIdentity4.getLac());
                    aVar2.b = d(cellIdentity4.getCid());
                    aVar2.i = 'g';
                    aVar2.h = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                    aVar2.l = 4;
                    if (Build.VERSION.SDK_INT >= 28) {
                        cellConnectionStatus2 = cellInfo.getCellConnectionStatus();
                        aVar2.j = cellConnectionStatus2;
                    }
                } else if (Build.VERSION.SDK_INT >= 29) {
                    if (cellInfo instanceof CellInfoTdscdma) {
                        CellIdentityTdscdma cellIdentity5 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.h().a("CellInfoTdscdma");
                        }
                        if (cellIdentity5.getMccString() != null) {
                            try {
                                aVar2.c = Integer.valueOf(cellIdentity5.getMccString()).intValue();
                            } catch (Throwable th) {
                                if (com.baidu.location.c.b.a.c) {
                                    th.printStackTrace();
                                }
                            }
                            if (cellIdentity5.getMncString() != null) {
                                try {
                                    aVar2.d = Integer.valueOf(cellIdentity5.getMncString()).intValue();
                                } catch (Throwable th2) {
                                    if (com.baidu.location.c.b.a.c) {
                                        th2.printStackTrace();
                                    }
                                }
                            }
                            aVar2.f26407a = d(cellIdentity5.getLac());
                            aVar2.b = d(cellIdentity5.getCid());
                            aVar2.i = 'g';
                            aVar2.h = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getAsuLevel();
                            aVar2.l = 5;
                            if (Build.VERSION.SDK_INT >= 28) {
                                cellConnectionStatus2 = cellInfo.getCellConnectionStatus();
                                aVar2.j = cellConnectionStatus2;
                            }
                        } else {
                            if (cellIdentity5.getMncString() != null) {
                                aVar2.d = Integer.valueOf(cellIdentity5.getMncString()).intValue();
                            }
                            aVar2.f26407a = d(cellIdentity5.getLac());
                            aVar2.b = d(cellIdentity5.getCid());
                            aVar2.i = 'g';
                            aVar2.h = ((CellInfoTdscdma) cellInfo).getCellSignalStrength().getAsuLevel();
                            aVar2.l = 5;
                            if (Build.VERSION.SDK_INT >= 28) {
                                cellConnectionStatus2 = cellInfo.getCellConnectionStatus();
                                aVar2.j = cellConnectionStatus2;
                            }
                        }
                    } else if (cellInfo instanceof CellInfoNr) {
                        try {
                            CellIdentityNr cellIdentityNr2 = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity();
                            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                g.h().a(" get cell nr = " + cellIdentityNr2.toString());
                            }
                            cellIdentityNr = cellIdentityNr2;
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                            cellIdentityNr = null;
                        }
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.h().a("CellInfoNr");
                        }
                        if (cellIdentityNr != null) {
                            if (cellIdentityNr.getMccString() != null) {
                                try {
                                    aVar2.c = Integer.valueOf(cellIdentityNr.getMccString()).intValue();
                                } catch (Throwable th4) {
                                    if (com.baidu.location.c.b.a.c) {
                                        th4.printStackTrace();
                                    }
                                }
                                if (cellIdentityNr.getMncString() != null) {
                                    try {
                                        aVar2.d = Integer.valueOf(cellIdentityNr.getMncString()).intValue();
                                    } catch (Throwable th5) {
                                        if (com.baidu.location.c.b.a.c) {
                                            th5.printStackTrace();
                                        }
                                    }
                                    iD = d(cellIdentityNr.getTac());
                                    aVar2.f26407a = iD;
                                    if (iD == -1) {
                                        try {
                                            iA = a(cellIdentityNr);
                                            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                                g.h().a(" get nrtac for huawei = " + iA);
                                            }
                                            aVar2.f26407a = d(iA);
                                        } catch (Throwable th6) {
                                            if (com.baidu.location.c.b.a.c) {
                                                th6.printStackTrace();
                                            }
                                        }
                                        if (aVar2.f26407a == -1) {
                                            try {
                                                iB = b(cellIdentityNr.toString());
                                                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                                    g.h().a(" get nrtac for samsung = " + iB);
                                                }
                                                aVar2.f26407a = d(iB);
                                            } catch (Throwable th7) {
                                                if (com.baidu.location.c.b.a.c) {
                                                    th7.printStackTrace();
                                                }
                                            }
                                        }
                                        tac = cellIdentityNr.getTac();
                                        if (aVar2.f26407a == -1 && tac != Integer.MAX_VALUE) {
                                            aVar2.f26407a = tac;
                                        }
                                        if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                                            aVar2.b = cellIdentityNr.getNci();
                                        }
                                        aVar2.i = 'g';
                                        aVar2.l = 6;
                                        if (Build.VERSION.SDK_INT >= 28) {
                                            aVar2.j = cellInfo.getCellConnectionStatus();
                                        }
                                        cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                                        aVar2.h = cellSignalStrengthNr.getAsuLevel();
                                        if (aVar2.b()) {
                                            aVar2.p = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                                        }
                                    } else {
                                        if (aVar2.f26407a == -1) {
                                            iB = b(cellIdentityNr.toString());
                                            if (com.baidu.location.c.b.a.c) {
                                                g.h().a(" get nrtac for samsung = " + iB);
                                            }
                                            aVar2.f26407a = d(iB);
                                        }
                                        tac = cellIdentityNr.getTac();
                                        if (aVar2.f26407a == -1) {
                                            aVar2.f26407a = tac;
                                        }
                                        if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                                            aVar2.b = cellIdentityNr.getNci();
                                        }
                                        aVar2.i = 'g';
                                        aVar2.l = 6;
                                        if (Build.VERSION.SDK_INT >= 28) {
                                            aVar2.j = cellInfo.getCellConnectionStatus();
                                        }
                                        cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                                        aVar2.h = cellSignalStrengthNr.getAsuLevel();
                                        if (aVar2.b()) {
                                            aVar2.p = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                                        }
                                    }
                                } else {
                                    iD = d(cellIdentityNr.getTac());
                                    aVar2.f26407a = iD;
                                    if (iD == -1) {
                                        iA = a(cellIdentityNr);
                                        if (com.baidu.location.c.b.a.c) {
                                            g.h().a(" get nrtac for huawei = " + iA);
                                        }
                                        aVar2.f26407a = d(iA);
                                        if (aVar2.f26407a == -1) {
                                            iB = b(cellIdentityNr.toString());
                                            if (com.baidu.location.c.b.a.c) {
                                                g.h().a(" get nrtac for samsung = " + iB);
                                            }
                                            aVar2.f26407a = d(iB);
                                        }
                                        tac = cellIdentityNr.getTac();
                                        if (aVar2.f26407a == -1) {
                                            aVar2.f26407a = tac;
                                        }
                                        if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                                            aVar2.b = cellIdentityNr.getNci();
                                        }
                                        aVar2.i = 'g';
                                        aVar2.l = 6;
                                        if (Build.VERSION.SDK_INT >= 28) {
                                            aVar2.j = cellInfo.getCellConnectionStatus();
                                        }
                                        cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                                        aVar2.h = cellSignalStrengthNr.getAsuLevel();
                                        if (aVar2.b()) {
                                            aVar2.p = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                                        }
                                    } else {
                                        if (aVar2.f26407a == -1) {
                                            iB = b(cellIdentityNr.toString());
                                            if (com.baidu.location.c.b.a.c) {
                                                g.h().a(" get nrtac for samsung = " + iB);
                                            }
                                            aVar2.f26407a = d(iB);
                                        }
                                        tac = cellIdentityNr.getTac();
                                        if (aVar2.f26407a == -1) {
                                            aVar2.f26407a = tac;
                                        }
                                        if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                                            aVar2.b = cellIdentityNr.getNci();
                                        }
                                        aVar2.i = 'g';
                                        aVar2.l = 6;
                                        if (Build.VERSION.SDK_INT >= 28) {
                                            aVar2.j = cellInfo.getCellConnectionStatus();
                                        }
                                        cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                                        aVar2.h = cellSignalStrengthNr.getAsuLevel();
                                        if (aVar2.b()) {
                                            aVar2.p = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                                        }
                                    }
                                }
                            } else if (cellIdentityNr.getMncString() != null) {
                                aVar2.d = Integer.valueOf(cellIdentityNr.getMncString()).intValue();
                                iD = d(cellIdentityNr.getTac());
                                aVar2.f26407a = iD;
                                if (iD == -1) {
                                    iA = a(cellIdentityNr);
                                    if (com.baidu.location.c.b.a.c) {
                                        g.h().a(" get nrtac for huawei = " + iA);
                                    }
                                    aVar2.f26407a = d(iA);
                                    if (aVar2.f26407a == -1) {
                                        iB = b(cellIdentityNr.toString());
                                        if (com.baidu.location.c.b.a.c) {
                                            g.h().a(" get nrtac for samsung = " + iB);
                                        }
                                        aVar2.f26407a = d(iB);
                                    }
                                    tac = cellIdentityNr.getTac();
                                    if (aVar2.f26407a == -1) {
                                        aVar2.f26407a = tac;
                                    }
                                    if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                                        aVar2.b = cellIdentityNr.getNci();
                                    }
                                    aVar2.i = 'g';
                                    aVar2.l = 6;
                                    if (Build.VERSION.SDK_INT >= 28) {
                                        aVar2.j = cellInfo.getCellConnectionStatus();
                                    }
                                    cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                                    aVar2.h = cellSignalStrengthNr.getAsuLevel();
                                    if (aVar2.b()) {
                                        aVar2.p = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                                    }
                                } else {
                                    if (aVar2.f26407a == -1) {
                                        iB = b(cellIdentityNr.toString());
                                        if (com.baidu.location.c.b.a.c) {
                                            g.h().a(" get nrtac for samsung = " + iB);
                                        }
                                        aVar2.f26407a = d(iB);
                                    }
                                    tac = cellIdentityNr.getTac();
                                    if (aVar2.f26407a == -1) {
                                        aVar2.f26407a = tac;
                                    }
                                    if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                                        aVar2.b = cellIdentityNr.getNci();
                                    }
                                    aVar2.i = 'g';
                                    aVar2.l = 6;
                                    if (Build.VERSION.SDK_INT >= 28) {
                                        aVar2.j = cellInfo.getCellConnectionStatus();
                                    }
                                    cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                                    aVar2.h = cellSignalStrengthNr.getAsuLevel();
                                    if (aVar2.b()) {
                                        aVar2.p = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                                    }
                                }
                            } else {
                                iD = d(cellIdentityNr.getTac());
                                aVar2.f26407a = iD;
                                if (iD == -1) {
                                    iA = a(cellIdentityNr);
                                    if (com.baidu.location.c.b.a.c) {
                                        g.h().a(" get nrtac for huawei = " + iA);
                                    }
                                    aVar2.f26407a = d(iA);
                                    if (aVar2.f26407a == -1) {
                                        iB = b(cellIdentityNr.toString());
                                        if (com.baidu.location.c.b.a.c) {
                                            g.h().a(" get nrtac for samsung = " + iB);
                                        }
                                        aVar2.f26407a = d(iB);
                                    }
                                    tac = cellIdentityNr.getTac();
                                    if (aVar2.f26407a == -1) {
                                        aVar2.f26407a = tac;
                                    }
                                    if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                                        aVar2.b = cellIdentityNr.getNci();
                                    }
                                    aVar2.i = 'g';
                                    aVar2.l = 6;
                                    if (Build.VERSION.SDK_INT >= 28) {
                                        aVar2.j = cellInfo.getCellConnectionStatus();
                                    }
                                    cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                                    aVar2.h = cellSignalStrengthNr.getAsuLevel();
                                    if (aVar2.b()) {
                                        aVar2.p = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                                    }
                                } else {
                                    if (aVar2.f26407a == -1) {
                                        iB = b(cellIdentityNr.toString());
                                        if (com.baidu.location.c.b.a.c) {
                                            g.h().a(" get nrtac for samsung = " + iB);
                                        }
                                        aVar2.f26407a = d(iB);
                                    }
                                    tac = cellIdentityNr.getTac();
                                    if (aVar2.f26407a == -1) {
                                        aVar2.f26407a = tac;
                                    }
                                    if (cellIdentityNr.getNci() != Long.MAX_VALUE) {
                                        aVar2.b = cellIdentityNr.getNci();
                                    }
                                    aVar2.i = 'g';
                                    aVar2.l = 6;
                                    if (Build.VERSION.SDK_INT >= 28) {
                                        aVar2.j = cellInfo.getCellConnectionStatus();
                                    }
                                    cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                                    aVar2.h = cellSignalStrengthNr.getAsuLevel();
                                    if (aVar2.b()) {
                                        aVar2.p = String.format(Locale.US, "%d|%d|%d|%d|%d|%d|%d|%d", Integer.valueOf(cellSignalStrengthNr.getCsiRsrp()), Integer.valueOf(cellSignalStrengthNr.getCsiRsrq()), Integer.valueOf(cellSignalStrengthNr.getCsiSinr()), Integer.valueOf(cellSignalStrengthNr.getDbm()), Integer.valueOf(cellSignalStrengthNr.getLevel()), Integer.valueOf(cellSignalStrengthNr.getSsRsrp()), Integer.valueOf(cellSignalStrengthNr.getSsRsrq()), Integer.valueOf(cellSignalStrengthNr.getSsSinr()));
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                if (com.baidu.location.c.b.a.c) {
                    e3.printStackTrace();
                }
            }
        }
        if (cellInfo.isRegistered()) {
            aVar2.k = true;
        }
        try {
            if (iIntValue2 >= 30) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                boolean z3 = com.baidu.location.c.b.a.c;
                if (z3 && com.baidu.location.c.b.a.d) {
                    g.h().a("new cell delta1 time(ms) = " + SystemClock.elapsedRealtime());
                    g.h().a("new cell delta2 time(ms) = " + cellInfo.getTimestampMillis());
                    g.h().a("new cell delta3 time(ms) = " + jElapsedRealtime);
                }
                aVar2.g = System.currentTimeMillis() - jElapsedRealtime;
                if (z3) {
                    eVarH2 = g.h();
                    str2 = "new cell time apilevel up 30 (ms) = " + aVar2.g;
                    eVarH2.a(str2);
                }
            } else {
                long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                boolean z4 = com.baidu.location.c.b.a.c;
                if (z4 && com.baidu.location.c.b.a.d) {
                    g.h().a("new cell delta1 time(ns) = " + SystemClock.elapsedRealtimeNanos());
                    g.h().a("new cell delta2 time(ns) = " + cellInfo.getTimeStamp());
                    g.h().a("new cell delta3 time(ms) = " + jElapsedRealtimeNanos);
                }
                aVar2.g = System.currentTimeMillis() - jElapsedRealtimeNanos;
                if (z4 && com.baidu.location.c.b.a.d) {
                    eVarH2 = g.h();
                    str2 = "new cell time(ms) = " + aVar2.g;
                    eVarH2.a(str2);
                }
            }
        } catch (Error e4) {
            if (com.baidu.location.c.b.a.c) {
                e4.printStackTrace();
            }
            aVar2.g = System.currentTimeMillis();
        }
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            g.h().a("mcc = " + aVar2.c);
            g.h().a("mnc = " + aVar2.d);
            g.h().a("lac = " + aVar2.f26407a);
            g.h().a("cid = " + aVar2.b);
            g.h().a("cs = " + aVar2.j);
        }
        return aVar2;
    }

    private com.baidu.location.c.a a(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    private com.baidu.location.c.a a(CellLocation cellLocation, boolean z) {
        int iIntValue;
        if (cellLocation == null || this.k == null) {
            return null;
        }
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            g.h().a("set cell info..");
        }
        com.baidu.location.c.a aVar = new com.baidu.location.c.a();
        aVar.m = 1;
        if (z) {
            aVar.q = true;
        }
        aVar.g = System.currentTimeMillis();
        try {
            String networkOperator = this.k.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    iIntValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.c = iIntValue < 0 ? this.o.c : iIntValue;
                } else {
                    iIntValue = -1;
                }
                String strSubstring = networkOperator.substring(3);
                if (strSubstring != null) {
                    char[] charArray = strSubstring.toCharArray();
                    int i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                    iIntValue = Integer.valueOf(strSubstring.substring(0, i)).intValue();
                }
                if (iIntValue < 0) {
                    iIntValue = this.o.d;
                }
                aVar.d = iIntValue;
            }
            this.f26408a = this.k.getSimState();
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.h().a("sim state:" + this.f26408a);
            }
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
            b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            aVar.f26407a = gsmCellLocation.getLac();
            aVar.b = gsmCellLocation.getCid();
            aVar.i = 'g';
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.h().a("bslocation mNetworkType = 'g'");
            }
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.i = 'c';
            boolean z2 = com.baidu.location.c.b.a.c;
            if (z2 && com.baidu.location.c.b.a.d) {
                g.h().a("bslocation mNetworkType = 'c'");
            }
            if (w == null) {
                try {
                    w = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused) {
                    w = null;
                    return aVar;
                }
            }
            Class<?> cls = w;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.o.d;
                    }
                    aVar.d = systemId;
                    aVar.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.f26407a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (z2 && com.baidu.location.c.b.a.d) {
                        g.h().a("bslocation lat " + (((double) baseStationLatitude) / 14400.0d));
                    }
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (z2 && com.baidu.location.c.b.a.d) {
                        g.h().a("bslocation lon" + (((double) baseStationLongitude) / 14400.0d));
                    }
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f = baseStationLongitude;
                    }
                } catch (Exception e3) {
                    if (com.baidu.location.c.b.a.c) {
                        e3.printStackTrace();
                    }
                    b = 3;
                    return aVar;
                }
            }
        }
        g(aVar);
        return aVar;
    }

    private static int b(String str) {
        if (str == null || !str.contains("mNrTac")) {
            return -1;
        }
        Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(" ", ""));
        while (true) {
            int i = -1;
            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    String strGroup = matcher.group(1);
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.h().a(" pasrse mnrtac = " + strGroup);
                    }
                    try {
                        i = Integer.parseInt(strGroup);
                    } catch (Throwable th) {
                        if (com.baidu.location.c.b.a.c) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            return i;
        }
    }

    private static int d(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x010f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0127  */
    /* JADX WARN: Instruction removed from duplicated block: B:56:0x010f, please report this as an issue */
    @SuppressLint({"NewApi"})
    private String d(com.baidu.location.c.a aVar) {
        com.baidu.location.c.a aVarA;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = null;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.k.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    sb.append("&nc=");
                    HashSet hashSet = new HashSet();
                    long j = aVar != null ? aVar.g : 0L;
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered() && (aVarA = a(cellInfo, this.o, this.k)) != null) {
                            if (aVarA.f26407a != -1 && aVarA.b != -1) {
                                String str = aVarA.f26407a + "|" + aVarA.b;
                                if (!hashSet.contains(str)) {
                                    hashSet.add(str);
                                    sb.append(aVarA.c);
                                    sb.append("|");
                                    sb.append(aVarA.d);
                                    sb.append("|");
                                    sb.append(aVarA.f26407a);
                                    sb.append("|");
                                    sb.append(aVarA.b);
                                    sb.append("|");
                                    sb.append(aVarA.h);
                                    sb.append("|");
                                    sb.append(aVarA.g - j);
                                    sb.append(l.b);
                                }
                            }
                            if (Build.VERSION.SDK_INT > 28 && aVarA.l == 6 && aVarA.p != null && aVarA.b()) {
                                if (sb2 == null) {
                                    StringBuilder sb3 = new StringBuilder();
                                    try {
                                        sb3.append("&ncnr=");
                                        sb2 = sb3;
                                    } catch (Throwable th) {
                                        th = th;
                                        sb2 = sb3;
                                        if (com.baidu.location.c.b.a.c) {
                                            th.printStackTrace();
                                        }
                                        if (sb2 != null) {
                                            return sb.toString();
                                        }
                                        return sb.toString() + sb2.toString();
                                    }
                                }
                                sb2.append(f(aVarA));
                                sb2.append(LoginConstants.UNDER_LINE);
                                sb2.append(aVarA.p);
                                sb2.append(l.b);
                            }
                        }
                    }
                } else if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.h().a("getAllCellInfo = null");
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (sb2 != null) {
            return sb.toString();
        }
        return sb.toString() + sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00b0 A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:6:0x0010, B:8:0x0014, B:9:0x0020, B:11:0x0030, B:13:0x0033, B:16:0x0039, B:18:0x003c, B:19:0x003e, B:21:0x0044, B:23:0x004a, B:25:0x004f, B:27:0x0053, B:29:0x0057, B:30:0x008b, B:32:0x0092, B:34:0x0096, B:35:0x009c, B:39:0x00ac, B:41:0x00b0, B:42:0x00b7, B:44:0x00bb, B:46:0x00bf, B:48:0x00c8, B:50:0x00ce, B:52:0x00d2, B:53:0x00d8, B:57:0x00e8, B:59:0x00ec, B:60:0x00f3, B:62:0x00f7, B:64:0x00fb, B:66:0x0104, B:54:0x00db, B:56:0x00df, B:65:0x0102, B:36:0x009f, B:38:0x00a3, B:47:0x00c6, B:24:0x004d), top: B:95:0x0010 }] */
    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ec A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:6:0x0010, B:8:0x0014, B:9:0x0020, B:11:0x0030, B:13:0x0033, B:16:0x0039, B:18:0x003c, B:19:0x003e, B:21:0x0044, B:23:0x004a, B:25:0x004f, B:27:0x0053, B:29:0x0057, B:30:0x008b, B:32:0x0092, B:34:0x0096, B:35:0x009c, B:39:0x00ac, B:41:0x00b0, B:42:0x00b7, B:44:0x00bb, B:46:0x00bf, B:48:0x00c8, B:50:0x00ce, B:52:0x00d2, B:53:0x00d8, B:57:0x00e8, B:59:0x00ec, B:60:0x00f3, B:62:0x00f7, B:64:0x00fb, B:66:0x0104, B:54:0x00db, B:56:0x00df, B:65:0x0102, B:36:0x009f, B:38:0x00a3, B:47:0x00c6, B:24:0x004d), top: B:95:0x0010 }] */
    private void d() {
        TelephonyManager telephonyManagerCreateForSubscriptionId;
        TelephonyManager telephonyManager;
        Executor executor;
        TelephonyManager telephonyManagerCreateForSubscriptionId2;
        TelephonyManager telephonyManager2;
        Executor executor2;
        this.A = System.currentTimeMillis();
        if (this.i) {
            boolean z = false;
            try {
                if (this.n == null) {
                    this.n = (SubscriptionManager) this.x.getSystemService("telephony_subscription_service");
                }
                int[] subscriptionIds = this.n.getSubscriptionIds(0);
                int[] subscriptionIds2 = this.n.getSubscriptionIds(1);
                int i = -1;
                int i2 = (subscriptionIds == null || subscriptionIds.length <= 0) ? -1 : subscriptionIds[0];
                if (subscriptionIds2 != null && subscriptionIds2.length > 0) {
                    i = subscriptionIds2[0];
                }
                if (SubscriptionManager.isValidSubscriptionId(i2) && SubscriptionManager.isValidSubscriptionId(i)) {
                    this.C = true;
                } else {
                    this.C = false;
                }
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.h().a("getCellInfo: subId0 = " + i2 + ", subId1 = " + i + ", mLastSubId0 = " + this.G + ", mLastSubId1 = " + this.H);
                }
                if (SubscriptionManager.isValidSubscriptionId(i2)) {
                    if (this.l == null) {
                        telephonyManagerCreateForSubscriptionId2 = this.k.createForSubscriptionId(i2);
                    } else if (this.G != i2) {
                        this.l = null;
                        telephonyManagerCreateForSubscriptionId2 = this.k.createForSubscriptionId(i2);
                    } else {
                        if (this.u == null) {
                            this.u = new b();
                        }
                        telephonyManager2 = this.l;
                        if (telephonyManager2 != null && (executor2 = this.r) != null) {
                            telephonyManager2.requestCellInfoUpdate(executor2, this.u);
                            z = true;
                        }
                    }
                    this.l = telephonyManagerCreateForSubscriptionId2;
                    if (this.u == null) {
                        this.u = new b();
                    }
                    telephonyManager2 = this.l;
                    if (telephonyManager2 != null) {
                        telephonyManager2.requestCellInfoUpdate(executor2, this.u);
                        z = true;
                    }
                } else {
                    this.l = null;
                }
                if (SubscriptionManager.isValidSubscriptionId(i)) {
                    if (this.m == null) {
                        telephonyManagerCreateForSubscriptionId = this.k.createForSubscriptionId(i);
                    } else if (this.H != i) {
                        this.m = null;
                        telephonyManagerCreateForSubscriptionId = this.k.createForSubscriptionId(i);
                    } else {
                        if (this.v == null) {
                            this.v = new c();
                        }
                        telephonyManager = this.m;
                        if (telephonyManager != null && (executor = this.r) != null) {
                            telephonyManager.requestCellInfoUpdate(executor, this.v);
                            z = true;
                        }
                    }
                    this.m = telephonyManagerCreateForSubscriptionId;
                    if (this.v == null) {
                        this.v = new c();
                    }
                    telephonyManager = this.m;
                    if (telephonyManager != null) {
                        telephonyManager.requestCellInfoUpdate(executor, this.v);
                        z = true;
                    }
                } else {
                    this.m = null;
                }
                this.G = i2;
                this.H = i;
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
            }
            if (!z) {
                e();
            }
        } else {
            e();
        }
        synchronized (this.I) {
            try {
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.h().a("start waiting update to finish");
                }
                int i3 = this.g.get();
                if (i3 != 0) {
                    this.I.wait(i3);
                }
            } catch (InterruptedException e3) {
                if (com.baidu.location.c.b.a.c) {
                    e3.printStackTrace();
                }
            }
        }
    }

    private String e(com.baidu.location.c.a aVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        stringBuffer.append(aVar.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl2=%d|%d|%d|%d&cl_s2=%d&clp2=%d&cl_t2=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.f26407a), Long.valueOf(aVar.b), Integer.valueOf(aVar.h), Integer.valueOf(aVar.l), Long.valueOf(aVar.g)));
        if (aVar.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs2=");
            stringBuffer.append(aVar.j);
        }
        if (aVar.p != null) {
            stringBuffer.append("&clnrs2=");
            stringBuffer.append(aVar.p);
        }
        return stringBuffer.toString();
    }

    private void e() {
        if (this.t == null) {
            this.t = new C0261a();
        }
        Executor executor = this.r;
        if (executor != null) {
            this.k.requestCellInfoUpdate(executor, this.t);
        }
    }

    private String f(com.baidu.location.c.a aVar) {
        return String.format(Locale.CHINA, "%d|%d|%d|%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.f26407a), Long.valueOf(aVar.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        CellLocation cellLocation;
        com.baidu.location.c.a aVarA = a(this.o, this.k);
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d && aVarA != null) {
            g.h().a("new cell api = " + f(aVarA));
        }
        if (aVarA != null) {
            g(aVarA);
        }
        int i = this.f;
        boolean z = true;
        if (i >= 0 && Build.VERSION.SDK_INT > i) {
            z = false;
        }
        if (z && (aVarA == null || !aVarA.b())) {
            try {
                cellLocation = this.k.getCellLocation();
            } catch (Throwable unused) {
                cellLocation = null;
            }
            com.baidu.location.c.a aVarA2 = cellLocation != null ? a(cellLocation) : null;
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d && aVarA2 != null) {
                g.h().a(" old cell api = " + f(aVarA2));
            }
        }
    }

    private void g() {
        com.baidu.location.c.e eVarH;
        String str;
        String strA = com.baidu.location.c.b.b.a(this.x);
        if (strA == null) {
            return;
        }
        File file = new File(strA + File.separator + "lcvif2.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0L);
                long j = randomAccessFile.readLong();
                if (System.currentTimeMillis() - j > 60000) {
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.h().a("cellbuffer System.currentTimeMillis() - time > 1 *60 *1000" + j);
                    }
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                for (int i = 0; i < 3; i++) {
                    long j2 = randomAccessFile.readLong();
                    int i2 = randomAccessFile.readInt();
                    int i3 = randomAccessFile.readInt();
                    int i4 = randomAccessFile.readInt();
                    long j3 = randomAccessFile.readLong();
                    int i5 = randomAccessFile.readInt();
                    boolean z = com.baidu.location.c.b.a.c;
                    if (z && com.baidu.location.c.b.a.d) {
                        g.h().a("cellbuffer cell info = " + j2 + " " + i2 + " " + i3 + " " + i4 + " " + j3 + " " + i5);
                    }
                    char c2 = i5 == 1 ? 'g' : (char) 0;
                    if (i5 == 2) {
                        c2 = 'c';
                    }
                    char c3 = c2;
                    if (j2 != 0) {
                        com.baidu.location.c.a aVar = new com.baidu.location.c.a(i4, j3, i2, i3, 0, c3, -1);
                        aVar.g = j2;
                        if (aVar.b()) {
                            this.E = true;
                            this.q.add(aVar);
                        }
                        if (z && com.baidu.location.c.b.a.d) {
                            eVarH = g.h();
                            str = "loc cell " + b(aVar);
                            eVarH.a(str);
                        }
                    } else if (z && com.baidu.location.c.b.a.d) {
                        eVarH = g.h();
                        str = "loc cell time1 == 0";
                        eVarH.a(str);
                    }
                }
                randomAccessFile.close();
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
                file.delete();
            }
        }
    }

    private void g(com.baidu.location.c.a aVar) {
        com.baidu.location.c.a aVar2;
        com.baidu.location.c.a aVar3 = this.o;
        if (aVar.b() && ((aVar2 = this.o) == null || !aVar2.a(aVar) || a(this.o, aVar))) {
            this.o = aVar;
        }
        if (aVar.b()) {
            if (aVar3 == null || !aVar3.a(aVar)) {
                if (!aVar.b()) {
                    List<com.baidu.location.c.a> list = this.q;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.q.size();
                com.baidu.location.c.a aVar4 = size == 0 ? null : this.q.get(size - 1);
                if (aVar4 != null) {
                    long j = aVar4.b;
                    com.baidu.location.c.a aVar5 = this.o;
                    if (j == aVar5.b && aVar4.f26407a == aVar5.f26407a) {
                        return;
                    }
                }
                this.q.add(this.o);
                if (this.q.size() > 3) {
                    this.q.remove(0);
                }
                if (this.j) {
                    h();
                }
                this.E = false;
            }
        }
    }

    private void h() {
        List<com.baidu.location.c.a> list = this.q;
        if (list == null && this.p == null) {
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.h().a("cellbuffer mTrackList == null");
                return;
            }
            return;
        }
        if (list == null && this.p != null) {
            LinkedList linkedList = new LinkedList();
            this.q = linkedList;
            linkedList.add(this.p);
        }
        String strA = com.baidu.location.c.b.b.a(this.x);
        if (strA == null || this.q == null) {
            return;
        }
        File file = new File(strA + File.separator + "lcvif2.dat");
        int size = this.q.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(this.q.get(size - 1).g);
            randomAccessFile.writeInt(size);
            for (int i = 0; i < 3 - size; i++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeLong(-1L);
                randomAccessFile.writeInt(2);
            }
            for (int i2 = 0; i2 < size; i2++) {
                randomAccessFile.writeLong(this.q.get(i2).g);
                randomAccessFile.writeInt(this.q.get(i2).c);
                randomAccessFile.writeInt(this.q.get(i2).d);
                randomAccessFile.writeInt(this.q.get(i2).f26407a);
                randomAccessFile.writeLong(this.q.get(i2).b);
                if (this.q.get(i2).i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.q.get(i2).i == 'c') {
                    randomAccessFile.writeInt(2);
                } else {
                    randomAccessFile.writeInt(3);
                }
            }
            randomAccessFile.close();
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.F.post(new Runnable() { // from class: com.baidu.location.c.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f();
                    synchronized (a.this.I) {
                        a.this.I.notifyAll();
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.h().a("update mCellInfo completed");
                        }
                    }
                } catch (Exception e2) {
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.h().a("handleCellInfo error = " + e2);
                    }
                }
            }
        });
    }

    public com.baidu.location.c.a a(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            this.f26408a = telephonyManager.getSimState();
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                if (!com.baidu.location.c.b.a.c || !com.baidu.location.c.b.a.d) {
                    return null;
                }
                g.h().a("getAllCellInfo=null");
                return null;
            }
            com.baidu.location.c.a aVar2 = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z = aVar2 != null;
                    com.baidu.location.c.a aVarA = a(cellInfo, aVar, telephonyManager);
                    if (aVarA != null) {
                        if (aVarA.b()) {
                            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                g.h().a(" cell res.isValid() = " + f(aVarA));
                            }
                            if (z && aVar2 != null) {
                                aVar2.n = e(aVarA);
                                aVar2.o = f(aVarA);
                            }
                        } else {
                            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                g.h().a("res.isValid()");
                            }
                            aVarA = null;
                        }
                        if (aVar2 == null) {
                            aVar2 = aVarA;
                        }
                    }
                }
            }
            return aVar2;
        } catch (Throwable th) {
            if (!com.baidu.location.c.b.a.c) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public String a(com.baidu.location.c.a aVar) {
        String str = "";
        try {
            String strD = d(aVar);
            int iIntValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
            if ((strD != null && !"".equals(strD) && !"&nc=".equals(strD)) || iIntValue >= 17) {
                return strD;
            }
            str = strD;
            if (str == null || !"&nc=".equals(str)) {
                return str;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i) {
        this.g.set(i);
    }

    public void a(Context context) {
        d dVar;
        if (this.y) {
            return;
        }
        this.x = context;
        this.k = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        this.q = new LinkedList();
        if (Looper.myLooper() != null) {
            this.s = new d();
        }
        if (this.F == null) {
            this.F = new Handler(Looper.getMainLooper());
        }
        if (this.j) {
            g();
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= this.e) {
            if (this.r == null) {
                this.r = this.x.getMainExecutor();
            }
            this.z = com.baidu.location.c.b.b.a("android.telephony.TelephonyManager$CellInfoCallback");
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.h().a("isCellinfoCallbackExist = " + this.z);
            }
        }
        TelephonyManager telephonyManager = this.k;
        if (telephonyManager == null || (dVar = this.s) == null) {
            return;
        }
        if (i < this.e || !this.z) {
            try {
                telephonyManager.listen(dVar, 1280);
            } catch (Exception unused) {
            }
        }
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            g.h().a("cell manager start...");
        }
        this.y = true;
    }

    public void a(boolean z) {
        this.i = z;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x008d  */
    public boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        boolean z;
        if (aVar == null && aVar2 == null) {
            return false;
        }
        if (aVar == null || aVar2 == null) {
            return true;
        }
        float fAbs = Math.abs(aVar.h - aVar2.h);
        int i = aVar.h;
        if (i == 0) {
            i = -1;
        }
        float f = fAbs / i;
        boolean z2 = com.baidu.location.c.b.a.c;
        if (z2 && com.baidu.location.c.b.a.d) {
            g.h().a("cl-cache, str, old:" + aVar.h + " new:" + aVar2.h);
            com.baidu.location.c.e eVarH = g.h();
            StringBuilder sb = new StringBuilder();
            sb.append("cl-cache, str, diffRate:");
            sb.append(f);
            eVarH.a(sb.toString());
        }
        String str = aVar.n;
        if (str == null || aVar2.n == null) {
            z = false;
        } else {
            int iA = a(str);
            if (Math.abs(Math.abs(iA - a(aVar2.n)) / (iA != 0 ? iA : -1)) > this.h) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z2 && com.baidu.location.c.b.a.d) {
            g.h().a("cl-cache, isStrengthChange2:" + z);
        }
        return f > this.h || z;
    }

    public com.baidu.location.c.a b(com.baidu.location.c.a aVar, TelephonyManager telephonyManager) {
        CellLocation cellLocation;
        com.baidu.location.c.a aVarA = a(aVar, telephonyManager);
        if (Build.VERSION.SDK_INT <= 28 && (aVarA == null || !aVarA.b())) {
            try {
                cellLocation = telephonyManager.getCellLocation();
            } catch (Throwable unused) {
                cellLocation = null;
            }
            if (cellLocation != null) {
                aVarA = a(cellLocation);
            }
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d && aVarA != null) {
                g.h().a("main process: old cell api = " + f(aVarA));
            }
        }
        return aVarA;
    }

    public String b(com.baidu.location.c.a aVar) {
        int i;
        if (aVar == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.f26407a), Long.valueOf(aVar.b), Integer.valueOf(aVar.h)));
        if (aVar.e < Integer.MAX_VALUE && (i = aVar.f) < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(((double) i) / 14400.0d), Double.valueOf(((double) aVar.e) / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.g);
        stringBuffer.append("&cl_api=");
        stringBuffer.append(aVar.m);
        stringBuffer.append("&clp=");
        stringBuffer.append(aVar.l);
        if (aVar.p != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(aVar.p);
        }
        if (Build.VERSION.SDK_INT >= 28 && aVar.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(aVar.j);
        }
        try {
            List<com.baidu.location.c.a> list = this.q;
            if (list != null && list.size() > 0) {
                int size = this.q.size();
                stringBuffer.append("&clt=");
                for (int i2 = 0; i2 < size; i2++) {
                    com.baidu.location.c.a aVar2 = this.q.get(i2);
                    if (aVar2 != null) {
                        int i3 = aVar2.c;
                        if (i3 != aVar.c) {
                            stringBuffer.append(i3);
                        }
                        stringBuffer.append("|");
                        int i4 = aVar2.d;
                        if (i4 != aVar.d) {
                            stringBuffer.append(i4);
                        }
                        stringBuffer.append("|");
                        int i5 = aVar2.f26407a;
                        if (i5 != aVar.f26407a) {
                            stringBuffer.append(i5);
                        }
                        stringBuffer.append("|");
                        long j = aVar2.b;
                        if (j != aVar.b) {
                            stringBuffer.append(j);
                        }
                        stringBuffer.append("|");
                        stringBuffer.append((System.currentTimeMillis() - aVar2.g) / 1000);
                        stringBuffer.append(l.b);
                    }
                }
            }
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
        }
        if (this.f26408a > 100) {
            this.f26408a = 0;
        }
        int i6 = this.f26408a + (b << 8);
        boolean z = com.baidu.location.c.b.a.c;
        if (z && com.baidu.location.c.b.a.d) {
            g.h().a("sim state:" + this.f26408a + "," + i6);
        }
        stringBuffer.append("&cs=" + i6);
        String str = aVar.n;
        if (str != null) {
            stringBuffer.append(str);
        }
        if (z && com.baidu.location.c.b.a.d) {
            g.h().a("cell sb.toString() = " + stringBuffer.toString());
        }
        return stringBuffer.toString();
    }

    public void b() {
        TelephonyManager telephonyManager;
        if (this.y) {
            try {
                d dVar = this.s;
                if (dVar != null && (telephonyManager = this.k) != null) {
                    telephonyManager.listen(dVar, 0);
                }
                this.s = null;
                this.k = null;
                this.l = null;
                this.m = null;
                List<com.baidu.location.c.a> list = this.q;
                if (list != null) {
                    list.clear();
                    this.q = null;
                }
                if (this.j) {
                    h();
                }
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
            }
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.h().a("cell manager stop ...");
            }
            this.y = false;
        }
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(boolean z) {
        this.j = z;
    }

    public com.baidu.location.c.a c(int i) {
        com.baidu.location.c.a aVar;
        if (this.k != null) {
            try {
                f();
                boolean z = com.baidu.location.c.b.a.c;
                if (z && com.baidu.location.c.b.a.d) {
                    g.h().a(" lastDiffTime = " + this.B + ", diffTime = " + i);
                }
                if (Build.VERSION.SDK_INT >= 29 && this.z) {
                    if (i < Integer.MAX_VALUE) {
                        long j = i;
                        if (j == this.B) {
                            if (System.currentTimeMillis() - this.A > j) {
                                if (z && com.baidu.location.c.b.a.d) {
                                    g.h().a(" over diff time");
                                }
                            }
                        } else if (z && com.baidu.location.c.b.a.d) {
                            g.h().a("diff time is changed");
                        }
                        d();
                    }
                    this.B = i;
                }
            } catch (Exception e2) {
                if (com.baidu.location.c.b.a.c) {
                    e2.printStackTrace();
                }
            }
        }
        com.baidu.location.c.a aVar2 = this.o;
        if (aVar2 != null && aVar2.e()) {
            this.p = null;
            this.p = new com.baidu.location.c.a(this.o);
        }
        com.baidu.location.c.a aVar3 = this.o;
        if (aVar3 != null && aVar3.d() && (aVar = this.p) != null) {
            com.baidu.location.c.a aVar4 = this.o;
            if (aVar4.i == 'g') {
                aVar4.d = aVar.d;
                aVar4.c = aVar.c;
            }
        }
        return this.o;
    }

    public HashSet<String> c(com.baidu.location.c.a aVar) {
        com.baidu.location.c.a aVarA;
        StringBuilder sb;
        HashSet<String> hashSet = new HashSet<>();
        try {
            List<CellInfo> allCellInfo = this.k.getAllCellInfo();
            if (allCellInfo != null && allCellInfo.size() > 0) {
                for (CellInfo cellInfo : allCellInfo) {
                    if (!cellInfo.isRegistered() && (aVarA = a(cellInfo, this.o, this.k)) != null) {
                        int i = aVarA.f26407a;
                        String string = "";
                        if (i != -1 && aVarA.b != -1) {
                            if (aVar.f26407a != i) {
                                sb = new StringBuilder();
                                sb.append(aVarA.f26407a);
                                sb.append("|");
                                sb.append(aVarA.b);
                            } else {
                                sb = new StringBuilder();
                                sb.append(aVarA.b);
                                sb.append("");
                            }
                            string = sb.toString();
                        }
                        hashSet.add(string);
                    }
                }
            } else if (com.baidu.location.c.b.a.c) {
                Log.d("getAllCellInfo", "=null");
            }
        } catch (Exception | NoSuchMethodError e2) {
            e2.printStackTrace();
        }
        return hashSet;
    }

    public boolean c() {
        return this.E;
    }
}
