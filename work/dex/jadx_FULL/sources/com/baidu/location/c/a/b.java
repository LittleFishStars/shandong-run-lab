package com.baidu.location.c.a;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.DhcpInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alipay.sdk.m.y.l;
import com.baidu.location.c.e;
import com.baidu.location.c.g;
import com.baidu.location.c.k;
import com.zj.adlib.u15;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b implements com.baidu.location.c.b.a {
    private Context h;
    private boolean b = false;
    private WifiManager e = null;
    private C0262b f = null;
    private k g = null;
    private AtomicInteger i = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f26416a = 0;
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private String m = null;
    private final Object n = new Object();
    private final Object o = new Object();
    private Handler p = null;
    private String q = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f26417a = new b();
    }

    /* JADX INFO: renamed from: com.baidu.location.c.a.b$b, reason: collision with other inner class name */
    public class C0262b extends BroadcastReceiver {
        private C0262b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            if ((!com.baidu.location.c.b.a.d || g.h().a(intent)) && intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                b.this.f26416a = System.currentTimeMillis() / 1000;
                b.this.p.post(new Runnable() { // from class: com.baidu.location.c.a.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.i();
                        synchronized (b.this.n) {
                            b.this.n.notifyAll();
                            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                g.h().a("WifiScan finished, in callback.");
                            }
                        }
                    }
                });
            }
        }
    }

    public static b a() {
        return a.f26417a;
    }

    private k a(k kVar) {
        if (kVar != null) {
            return new k(kVar.f26442a, kVar.b);
        }
        return null;
    }

    public static boolean a(k kVar, k kVar2, float f) {
        if (kVar != null && kVar2 != null) {
            List<ScanResult> list = kVar.f26442a;
            List<ScanResult> list2 = kVar2.f26442a;
            if (list == list2) {
                return true;
            }
            if (list != null && list2 != null) {
                int size = list.size();
                int size2 = list2.size();
                if (size == 0 && size2 == 0) {
                    return true;
                }
                if (size != 0 && size2 != 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = list.get(i2) != null ? list.get(i2).BSSID : null;
                        if (str != null) {
                            for (int i3 = 0; i3 < size2; i3++) {
                                String str2 = list2.get(i3) != null ? list2.get(i3).BSSID : null;
                                if (str2 != null && str.equals(str2)) {
                                    i++;
                                    break;
                                }
                            }
                        }
                    }
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.h().a("wifi same!" + (i / size));
                    }
                    if (i >= size * f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    private String b(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    private String b(String str) {
        if (str != null) {
            return (str.contains("&") || str.contains(l.b)) ? str.replace("&", LoginConstants.UNDER_LINE).replace(l.b, LoginConstants.UNDER_LINE) : str;
        }
        return str;
    }

    private void g() {
        try {
            if (this.e.isWifiEnabled() || this.e.isScanAlwaysAvailable()) {
                this.e.startScan();
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.h().a("wifimanager start scan ...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.j = System.currentTimeMillis();
        synchronized (this.n) {
            try {
                int i = this.i.get();
                if (i != 0) {
                    this.n.wait(i);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private String h() {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = this.e;
        if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
            return null;
        }
        return b(dhcpInfo.gateway);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        WifiManager wifiManager = this.e;
        if (wifiManager == null) {
            return;
        }
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (scanResults != null && scanResults.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    long j = 0;
                    for (int i = 0; i < scanResults.size(); i++) {
                        if (i == 0) {
                            try {
                                j = (jCurrentTimeMillis - scanResults.get(0).timestamp) / 1000000;
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = 0;
                            }
                            sb.append(scanResults.get(0).BSSID + l.b + Math.abs(scanResults.get(0).level) + l.b + scanResults.get(0).SSID.trim() + l.b + scanResults.get(0).frequency + l.b + j + "|");
                        }
                        sb.append(scanResults.get(i).BSSID + l.b + Math.abs(scanResults.get(i).level) + l.b + scanResults.get(i).SSID.trim() + l.b + scanResults.get(i).frequency + l.b + (((jCurrentTimeMillis - scanResults.get(i).timestamp) / 1000000) - j) + "|");
                    }
                    sb.append("\t");
                    sb.append(simpleDateFormat.format(new Date(jCurrentTimeMillis)));
                    sb.append("\t");
                    sb.append(jCurrentTimeMillis);
                    sb.append("\tnull\n");
                    g.h().a(sb.toString());
                }
            }
            if (scanResults != null) {
                k kVar = new k(scanResults, System.currentTimeMillis());
                synchronized (this.o) {
                    k kVar2 = this.g;
                    if (kVar2 == null || !a(kVar, kVar2)) {
                        this.g = kVar;
                    }
                }
            }
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
        }
    }

    public k a(long j) {
        e eVarH;
        String str;
        if (this.e != null && j < 2147483647L) {
            boolean z = com.baidu.location.c.b.a.c;
            if (z && com.baidu.location.c.b.a.d) {
                g.h().a("Wi-Fi diffTime = " + j + "mLastDiffTime = " + this.k);
            }
            if (j == this.k) {
                if (z && com.baidu.location.c.b.a.d) {
                    g.h().a("System.currentTimeMillis() = " + System.currentTimeMillis() + "wifi diffTime = " + j + ", mScanTime = " + this.j);
                }
                if (System.currentTimeMillis() - this.j > j) {
                    if (z && com.baidu.location.c.b.a.d) {
                        eVarH = g.h();
                        str = "time is over";
                        eVarH.a(str);
                    }
                    g();
                }
            } else {
                if (z && com.baidu.location.c.b.a.d) {
                    eVarH = g.h();
                    str = "diffTime is changed";
                    eVarH.a(str);
                }
                g();
            }
        }
        this.k = j;
        return this.g;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x0212  */
    /* JADX WARN: Code duplicated, block: B:114:0x0217  */
    /* JADX WARN: Code duplicated, block: B:126:0x0269  */
    /* JADX WARN: Code duplicated, block: B:128:0x0270  */
    /* JADX WARN: Code duplicated, block: B:141:0x02bd A[Catch: Exception -> 0x04eb, Error -> 0x04ed, TryCatch #2 {Error -> 0x04ed, blocks: (B:106:0x01fe, B:115:0x021b, B:117:0x0221, B:119:0x022d, B:121:0x023d, B:153:0x0324, B:139:0x02b9, B:141:0x02bd, B:129:0x0272, B:131:0x0278, B:133:0x0284, B:135:0x0294, B:144:0x02c4, B:146:0x02cc, B:148:0x02d0, B:149:0x02f2, B:154:0x0330, B:156:0x033d, B:158:0x0341, B:161:0x0360, B:163:0x0368, B:165:0x0373, B:169:0x0382, B:171:0x038c, B:173:0x0398, B:176:0x03ac, B:183:0x03d0, B:170:0x0389, B:185:0x03d8, B:187:0x03f0, B:191:0x0403, B:194:0x041d, B:196:0x0423, B:198:0x0432, B:199:0x044a, B:201:0x0450, B:203:0x0458, B:207:0x0475, B:204:0x0461, B:206:0x046f, B:208:0x0479, B:210:0x047d, B:212:0x0481, B:213:0x049d, B:215:0x04a6, B:217:0x04c6, B:221:0x04d5, B:223:0x04da, B:224:0x04e4), top: B:245:0x01fe }] */
    /* JADX WARN: Code duplicated, block: B:142:0x02c1 A[PHI: r6 r7
      0x02c1: PHI (r6v51 char) = (r6v49 char), (r6v49 char), (r6v49 char), (r6v49 char), (r6v55 char) binds: [B:127:0x026e, B:130:0x0276, B:132:0x0282, B:134:0x0292, B:123:0x0261] A[DONT_GENERATE, DONT_INLINE]
      0x02c1: PHI (r7v23 java.util.Random) = 
      (r7v21 java.util.Random)
      (r7v21 java.util.Random)
      (r7v21 java.util.Random)
      (r7v21 java.util.Random)
      (r7v25 java.util.Random)
     binds: [B:127:0x026e, B:130:0x0276, B:132:0x0282, B:134:0x0292, B:123:0x0261] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:144:0x02c4 A[Catch: Exception -> 0x04eb, Error -> 0x04ed, TryCatch #2 {Error -> 0x04ed, blocks: (B:106:0x01fe, B:115:0x021b, B:117:0x0221, B:119:0x022d, B:121:0x023d, B:153:0x0324, B:139:0x02b9, B:141:0x02bd, B:129:0x0272, B:131:0x0278, B:133:0x0284, B:135:0x0294, B:144:0x02c4, B:146:0x02cc, B:148:0x02d0, B:149:0x02f2, B:154:0x0330, B:156:0x033d, B:158:0x0341, B:161:0x0360, B:163:0x0368, B:165:0x0373, B:169:0x0382, B:171:0x038c, B:173:0x0398, B:176:0x03ac, B:183:0x03d0, B:170:0x0389, B:185:0x03d8, B:187:0x03f0, B:191:0x0403, B:194:0x041d, B:196:0x0423, B:198:0x0432, B:199:0x044a, B:201:0x0450, B:203:0x0458, B:207:0x0475, B:204:0x0461, B:206:0x046f, B:208:0x0479, B:210:0x047d, B:212:0x0481, B:213:0x049d, B:215:0x04a6, B:217:0x04c6, B:221:0x04d5, B:223:0x04da, B:224:0x04e4), top: B:245:0x01fe }] */
    /* JADX WARN: Code duplicated, block: B:151:0x031e  */
    /* JADX WARN: Code duplicated, block: B:160:0x035d  */
    /* JADX WARN: Code duplicated, block: B:163:0x0368 A[Catch: Exception -> 0x04eb, Error -> 0x04ed, TryCatch #2 {Error -> 0x04ed, blocks: (B:106:0x01fe, B:115:0x021b, B:117:0x0221, B:119:0x022d, B:121:0x023d, B:153:0x0324, B:139:0x02b9, B:141:0x02bd, B:129:0x0272, B:131:0x0278, B:133:0x0284, B:135:0x0294, B:144:0x02c4, B:146:0x02cc, B:148:0x02d0, B:149:0x02f2, B:154:0x0330, B:156:0x033d, B:158:0x0341, B:161:0x0360, B:163:0x0368, B:165:0x0373, B:169:0x0382, B:171:0x038c, B:173:0x0398, B:176:0x03ac, B:183:0x03d0, B:170:0x0389, B:185:0x03d8, B:187:0x03f0, B:191:0x0403, B:194:0x041d, B:196:0x0423, B:198:0x0432, B:199:0x044a, B:201:0x0450, B:203:0x0458, B:207:0x0475, B:204:0x0461, B:206:0x046f, B:208:0x0479, B:210:0x047d, B:212:0x0481, B:213:0x049d, B:215:0x04a6, B:217:0x04c6, B:221:0x04d5, B:223:0x04da, B:224:0x04e4), top: B:245:0x01fe }] */
    /* JADX WARN: Code duplicated, block: B:182:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:185:0x03d8 A[Catch: Exception -> 0x04eb, Error -> 0x04ed, TryCatch #2 {Error -> 0x04ed, blocks: (B:106:0x01fe, B:115:0x021b, B:117:0x0221, B:119:0x022d, B:121:0x023d, B:153:0x0324, B:139:0x02b9, B:141:0x02bd, B:129:0x0272, B:131:0x0278, B:133:0x0284, B:135:0x0294, B:144:0x02c4, B:146:0x02cc, B:148:0x02d0, B:149:0x02f2, B:154:0x0330, B:156:0x033d, B:158:0x0341, B:161:0x0360, B:163:0x0368, B:165:0x0373, B:169:0x0382, B:171:0x038c, B:173:0x0398, B:176:0x03ac, B:183:0x03d0, B:170:0x0389, B:185:0x03d8, B:187:0x03f0, B:191:0x0403, B:194:0x041d, B:196:0x0423, B:198:0x0432, B:199:0x044a, B:201:0x0450, B:203:0x0458, B:207:0x0475, B:204:0x0461, B:206:0x046f, B:208:0x0479, B:210:0x047d, B:212:0x0481, B:213:0x049d, B:215:0x04a6, B:217:0x04c6, B:221:0x04d5, B:223:0x04da, B:224:0x04e4), top: B:245:0x01fe }] */
    /* JADX WARN: Code duplicated, block: B:187:0x03f0 A[Catch: Exception -> 0x04eb, Error -> 0x04ed, TryCatch #2 {Error -> 0x04ed, blocks: (B:106:0x01fe, B:115:0x021b, B:117:0x0221, B:119:0x022d, B:121:0x023d, B:153:0x0324, B:139:0x02b9, B:141:0x02bd, B:129:0x0272, B:131:0x0278, B:133:0x0284, B:135:0x0294, B:144:0x02c4, B:146:0x02cc, B:148:0x02d0, B:149:0x02f2, B:154:0x0330, B:156:0x033d, B:158:0x0341, B:161:0x0360, B:163:0x0368, B:165:0x0373, B:169:0x0382, B:171:0x038c, B:173:0x0398, B:176:0x03ac, B:183:0x03d0, B:170:0x0389, B:185:0x03d8, B:187:0x03f0, B:191:0x0403, B:194:0x041d, B:196:0x0423, B:198:0x0432, B:199:0x044a, B:201:0x0450, B:203:0x0458, B:207:0x0475, B:204:0x0461, B:206:0x046f, B:208:0x0479, B:210:0x047d, B:212:0x0481, B:213:0x049d, B:215:0x04a6, B:217:0x04c6, B:221:0x04d5, B:223:0x04da, B:224:0x04e4), top: B:245:0x01fe }] */
    /* JADX WARN: Code duplicated, block: B:214:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:217:0x04c6 A[Catch: Exception -> 0x04eb, Error -> 0x04ed, TryCatch #2 {Error -> 0x04ed, blocks: (B:106:0x01fe, B:115:0x021b, B:117:0x0221, B:119:0x022d, B:121:0x023d, B:153:0x0324, B:139:0x02b9, B:141:0x02bd, B:129:0x0272, B:131:0x0278, B:133:0x0284, B:135:0x0294, B:144:0x02c4, B:146:0x02cc, B:148:0x02d0, B:149:0x02f2, B:154:0x0330, B:156:0x033d, B:158:0x0341, B:161:0x0360, B:163:0x0368, B:165:0x0373, B:169:0x0382, B:171:0x038c, B:173:0x0398, B:176:0x03ac, B:183:0x03d0, B:170:0x0389, B:185:0x03d8, B:187:0x03f0, B:191:0x0403, B:194:0x041d, B:196:0x0423, B:198:0x0432, B:199:0x044a, B:201:0x0450, B:203:0x0458, B:207:0x0475, B:204:0x0461, B:206:0x046f, B:208:0x0479, B:210:0x047d, B:212:0x0481, B:213:0x049d, B:215:0x04a6, B:217:0x04c6, B:221:0x04d5, B:223:0x04da, B:224:0x04e4), top: B:245:0x01fe }] */
    /* JADX WARN: Code duplicated, block: B:219:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:220:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:223:0x04da A[Catch: Exception -> 0x04eb, Error -> 0x04ed, TryCatch #2 {Error -> 0x04ed, blocks: (B:106:0x01fe, B:115:0x021b, B:117:0x0221, B:119:0x022d, B:121:0x023d, B:153:0x0324, B:139:0x02b9, B:141:0x02bd, B:129:0x0272, B:131:0x0278, B:133:0x0284, B:135:0x0294, B:144:0x02c4, B:146:0x02cc, B:148:0x02d0, B:149:0x02f2, B:154:0x0330, B:156:0x033d, B:158:0x0341, B:161:0x0360, B:163:0x0368, B:165:0x0373, B:169:0x0382, B:171:0x038c, B:173:0x0398, B:176:0x03ac, B:183:0x03d0, B:170:0x0389, B:185:0x03d8, B:187:0x03f0, B:191:0x0403, B:194:0x041d, B:196:0x0423, B:198:0x0432, B:199:0x044a, B:201:0x0450, B:203:0x0458, B:207:0x0475, B:204:0x0461, B:206:0x046f, B:208:0x0479, B:210:0x047d, B:212:0x0481, B:213:0x049d, B:215:0x04a6, B:217:0x04c6, B:221:0x04d5, B:223:0x04da, B:224:0x04e4), top: B:245:0x01fe }] */
    /* JADX WARN: Code duplicated, block: B:226:0x04e9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:238:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:263:0x0330 A[EDGE_INSN: B:263:0x0330->B:154:0x0330 BREAK  A[LOOP:0: B:41:0x00c8->B:153:0x0324], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00d0  */
    @SuppressLint({"NewApi"})
    public String a(int i, boolean z, k kVar, int i2) {
        Throwable th;
        String str;
        int rssi;
        String strReplace;
        long jElapsedRealtimeNanos;
        boolean z2;
        boolean z3;
        String str2;
        int i3;
        long j;
        int i4;
        char c;
        int i5;
        StringBuffer stringBuffer;
        int i6;
        boolean z4;
        String str3;
        boolean z5;
        int i7;
        b bVar;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z6;
        Random random;
        char c2;
        Random random2;
        long j2;
        boolean z7;
        char c3;
        Exception exc;
        b bVar2 = this;
        int i12 = i;
        if (kVar == null || kVar.a() < 1) {
            return null;
        }
        try {
            try {
                Random random3 = new Random();
                StringBuffer stringBuffer2 = new StringBuffer(512);
                StringBuilder sb = new StringBuilder();
                ArrayList<Long> arrayList = new ArrayList();
                WifiInfo wifiInfoF = f();
                String strA = bVar2.a(wifiInfoF, (String) null);
                if (wifiInfoF == null || strA == null) {
                    str = null;
                    rssi = -1;
                    strReplace = null;
                } else {
                    strReplace = strA.replace(u15.f19942b, "");
                    rssi = wifiInfoF.getRssi();
                    String strH = a().h();
                    if (rssi < 0) {
                        rssi = -rssi;
                    }
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.h().a("wifi connected mac = " + strReplace);
                        g.h().a("wifi connected mac rssi= " + rssi);
                    }
                    str = strH;
                }
                try {
                    jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
                    while (true) {
                        str3 = ";%d;";
                        z5 = z3;
                        if (i4 < i12) {
                            break;
                        }
                        i5++;
                        int i13 = i12;
                        if (kVar.f26442a.get(i4) != null) {
                            this = bVar2;
                            z6 = z2;
                            random = random3;
                            c2 = c;
                            c = c2;
                        } else {
                            this = bVar2;
                            z6 = z2;
                            random = random3;
                            c2 = c;
                            c = c2;
                        }
                        i4++;
                        z3 = z5;
                        bVar2 = this;
                        random3 = random;
                        z2 = z6;
                        i12 = i13;
                        th = e;
                        if (com.baidu.location.c.b.a.c) {
                            return null;
                        }
                        th.printStackTrace();
                        return null;
                    }
                } catch (Error unused) {
                    jElapsedRealtimeNanos = 0;
                }
                z2 = jElapsedRealtimeNanos > 0;
                if (z2) {
                    z2 = z2 && z;
                }
                int size = kVar.f26442a.size();
                if (size > i12) {
                    z3 = i12 < i2;
                    str2 = str;
                    i3 = rssi;
                    j = 0;
                    i4 = 0;
                    c = 0;
                    i5 = 0;
                    int i14 = 0;
                    stringBuffer = null;
                    i6 = 0;
                    z4 = true;
                    while (true) {
                        str3 = ";%d;";
                        z5 = z3;
                        if (i4 < i12) {
                            break;
                            break;
                        }
                        i5++;
                        int i15 = i12;
                        if (kVar.f26442a.get(i4) != null || kVar.f26442a.get(i4).level == 0) {
                            this = bVar2;
                            z6 = z2;
                            random = random3;
                            c2 = c;
                        } else {
                            if (z2) {
                                try {
                                    random2 = random3;
                                    z6 = z2;
                                    try {
                                        j2 = (jElapsedRealtimeNanos - kVar.f26442a.get(i4).timestamp) / 1000000;
                                    } catch (Exception e) {
                                        e = e;
                                        Exception exc2 = e;
                                        if (com.baidu.location.c.b.a.c) {
                                            exc2.printStackTrace();
                                        }
                                        j2 = 0;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    random2 = random3;
                                    z6 = z2;
                                }
                                try {
                                    boolean z8 = com.baidu.location.c.b.a.c;
                                    if (z8 && com.baidu.location.c.b.a.d) {
                                        g.h().a("wifi noUpdateTime = " + j2);
                                    }
                                    arrayList.add(Long.valueOf(j2));
                                    if (j2 > j) {
                                        if (z8) {
                                            g.h().a("wifi maxScanTime = " + j2);
                                        }
                                        j = j2;
                                    }
                                } catch (Error e3) {
                                    e = e3;
                                    th = e;
                                    if (com.baidu.location.c.b.a.c) {
                                        return null;
                                    }
                                    th.printStackTrace();
                                    return null;
                                } catch (Exception e4) {
                                    e = e4;
                                    th = e;
                                    if (com.baidu.location.c.b.a.c) {
                                        return null;
                                    }
                                    th.printStackTrace();
                                    return null;
                                }
                            } else {
                                random2 = random3;
                                z6 = z2;
                                c = c;
                                strReplace = strReplace;
                            }
                            try {
                                if (kVar.f26442a.get(i4).is80211mcResponder()) {
                                    StringBuffer stringBuffer3 = stringBuffer == null ? new StringBuffer() : stringBuffer;
                                    try {
                                        stringBuffer3.append(i4);
                                        stringBuffer3.append("|");
                                        stringBuffer = stringBuffer3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        stringBuffer = stringBuffer3;
                                        th.printStackTrace();
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            if (z4) {
                                stringBuffer2.append("&wf=");
                                z4 = false;
                            } else {
                                stringBuffer2.append("|");
                                sb.append("|");
                            }
                            String str4 = kVar.f26442a.get(i4).BSSID;
                            if (str4 != null) {
                                String strReplace2 = str4.replace(u15.f19942b, "");
                                stringBuffer2.append(strReplace2);
                                sb.append(strReplace2);
                                int i16 = kVar.f26442a.get(i4).level;
                                if (i16 < 0) {
                                    i16 = -i16;
                                }
                                String str5 = String.format(Locale.CHINA, ";%d;", Integer.valueOf(i16));
                                stringBuffer2.append(str5);
                                sb.append(str5);
                                i14++;
                                if (strReplace != null) {
                                    strReplace = strReplace;
                                    if (strReplace.equals(strReplace2)) {
                                        this = this;
                                        try {
                                            try {
                                                kVar.e = this.a(kVar.f26442a.get(i4).capabilities);
                                                i6 = i14;
                                                z7 = true;
                                            } catch (Error e5) {
                                                e = e5;
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                        }
                                    }
                                    if (z7) {
                                        random = random2;
                                        c2 = c;
                                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                            g.h().a("wifi str add connected ssid = " + kVar.f26442a.get(i4).SSID);
                                        }
                                        stringBuffer2.append(this.b(kVar.f26442a.get(i4).SSID));
                                        sb.append(this.b(kVar.f26442a.get(i4).SSID));
                                    } else {
                                        c3 = 2;
                                        if (c == 0) {
                                            random = random2;
                                            try {
                                                if (random.nextInt(10) == 2 || kVar.f26442a.get(i4).SSID == null || kVar.f26442a.get(i4).SSID.length() >= 30) {
                                                    c2 = c;
                                                    c3 = c2;
                                                } else {
                                                    stringBuffer2.append(this.b(kVar.f26442a.get(i4).SSID));
                                                    sb.append(this.b(kVar.f26442a.get(i4).SSID));
                                                    c3 = 1;
                                                }
                                                c = c3;
                                            } catch (Exception e7) {
                                                exc = e7;
                                                c2 = c;
                                                if (com.baidu.location.c.b.a.c) {
                                                    exc.printStackTrace();
                                                }
                                                c = c2;
                                            }
                                        } else {
                                            random = random2;
                                            c2 = c;
                                            if (c2 != 1) {
                                                try {
                                                    if (random.nextInt(20) == 1 || kVar.f26442a.get(i4).SSID == null || kVar.f26442a.get(i4).SSID.length() >= 30) {
                                                        c3 = c2;
                                                    } else {
                                                        stringBuffer2.append(this.b(kVar.f26442a.get(i4).SSID));
                                                        sb.append(this.b(kVar.f26442a.get(i4).SSID));
                                                    }
                                                } catch (Exception e8) {
                                                    exc = e8;
                                                    if (com.baidu.location.c.b.a.c) {
                                                        exc.printStackTrace();
                                                    }
                                                    c = c2;
                                                }
                                            } else {
                                                c3 = c2;
                                            }
                                            c = c3;
                                        }
                                        i4++;
                                        z3 = z5;
                                        bVar2 = this;
                                        random3 = random;
                                        z2 = z6;
                                        i12 = i15;
                                    }
                                } else {
                                    strReplace = strReplace;
                                }
                                z7 = false;
                                if (z7) {
                                    c3 = 2;
                                    if (c == 0) {
                                        random = random2;
                                        if (random.nextInt(10) == 2) {
                                        }
                                        c2 = c;
                                        c3 = c2;
                                        c = c3;
                                    } else {
                                        random = random2;
                                        c2 = c;
                                        if (c2 != 1) {
                                            c3 = c2;
                                        } else if (random.nextInt(20) == 1) {
                                            c3 = c2;
                                        } else {
                                            c3 = c2;
                                        }
                                        c = c3;
                                    }
                                    i4++;
                                    z3 = z5;
                                    bVar2 = this;
                                    random3 = random;
                                    z2 = z6;
                                    i12 = i15;
                                } else {
                                    random = random2;
                                    c2 = c;
                                    if (com.baidu.location.c.b.a.c) {
                                        g.h().a("wifi str add connected ssid = " + kVar.f26442a.get(i4).SSID);
                                    }
                                    stringBuffer2.append(this.b(kVar.f26442a.get(i4).SSID));
                                    sb.append(this.b(kVar.f26442a.get(i4).SSID));
                                }
                            } else {
                                this = this;
                                random = random2;
                                c2 = c;
                                strReplace = strReplace;
                            }
                        }
                        c = c2;
                        i4++;
                        z3 = z5;
                        bVar2 = this;
                        random3 = random;
                        z2 = z6;
                        i12 = i15;
                        th = e;
                        if (com.baidu.location.c.b.a.c) {
                            return null;
                        }
                        th.printStackTrace();
                        return null;
                    }
                    i7 = i12;
                    bVar = bVar2;
                    bVar.q = sb.toString();
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.h().a("last wifi str = " + bVar.q);
                    }
                    if (z5) {
                        i11 = i7;
                        boolean z9 = true;
                        while (i11 < kVar.f26442a.size()) {
                            int i17 = i5 + 1;
                            if (kVar.f26442a.get(i11) == null && kVar.f26442a.get(i11).level != 0) {
                                if (z9) {
                                    stringBuffer2.append("&wf2=");
                                    z9 = false;
                                } else {
                                    stringBuffer2.append("|");
                                }
                                String str6 = kVar.f26442a.get(i11).BSSID;
                                if (str6 != null) {
                                    stringBuffer2.append(str6.replace(u15.f19942b, ""));
                                    int i18 = kVar.f26442a.get(i11).level;
                                    if (i18 < 0) {
                                        i18 = -i18;
                                    }
                                    stringBuffer2.append(String.format(Locale.CHINA, str3, Integer.valueOf(i18)));
                                }
                                if (i17 >= i2) {
                                    break;
                                }
                                z9 = z9;
                            }
                            i11++;
                            str3 = str3;
                            i5 = i17;
                        }
                    }
                    if (!z4) {
                        return null;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("&wf_n=");
                    i8 = i6;
                    sb2.append(i8);
                    stringBuffer2.append(sb2.toString());
                    if (stringBuffer != null) {
                        stringBuffer2.append("&wf_mc=");
                        stringBuffer2.append(stringBuffer.toString());
                    }
                    if (strReplace != null && i3 != -1) {
                        stringBuffer2.append("&wf_rs=" + i3);
                    }
                    if (j > 10 || arrayList.size() <= 0 || ((Long) arrayList.get(0)).longValue() <= 0) {
                        i9 = 0;
                    } else {
                        StringBuffer stringBuffer4 = new StringBuffer(128);
                        stringBuffer4.append("&wf_ut=");
                        i9 = 0;
                        Long l = (Long) arrayList.get(0);
                        boolean z10 = true;
                        for (Long l2 : arrayList) {
                            if (z10) {
                                stringBuffer4.append(l2.longValue());
                                z10 = false;
                            } else {
                                long jLongValue = l2.longValue() - l.longValue();
                                if (jLongValue != 0) {
                                    stringBuffer4.append("");
                                    stringBuffer4.append(jLongValue);
                                }
                            }
                            stringBuffer4.append("|");
                        }
                        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                            g.h().a("wifi scantime list str = " + stringBuffer4.toString());
                        }
                        stringBuffer2.append(stringBuffer4.toString());
                    }
                    stringBuffer2.append("&wf_st=");
                    stringBuffer2.append(kVar.b);
                    stringBuffer2.append("&wf_et=");
                    stringBuffer2.append(kVar.c);
                    stringBuffer2.append("&wf_vt=");
                    stringBuffer2.append(bVar.f26416a);
                    if (i8 > 0) {
                        kVar.d = true;
                        stringBuffer2.append("&wf_en=");
                        if (kVar.e) {
                            i10 = 1;
                        } else {
                            i10 = i9;
                        }
                        stringBuffer2.append(i10);
                    }
                    if (str2 != null) {
                        stringBuffer2.append("&wf_gw=");
                        stringBuffer2.append(str2);
                    }
                    return stringBuffer2.toString();
                }
                i12 = size;
                str2 = str;
                i3 = rssi;
                j = 0;
                i4 = 0;
                c = 0;
                i5 = 0;
                int i19 = 0;
                stringBuffer = null;
                i6 = 0;
                z4 = true;
                i7 = i12;
                bVar = bVar2;
                bVar.q = sb.toString();
                if (com.baidu.location.c.b.a.c) {
                    g.h().a("last wifi str = " + bVar.q);
                }
                if (z5) {
                    i11 = i7;
                    boolean z11 = true;
                    while (i11 < kVar.f26442a.size()) {
                        int i110 = i5 + 1;
                        if (kVar.f26442a.get(i11) == null) {
                        }
                        i11++;
                        str3 = str3;
                        i5 = i110;
                    }
                }
                if (!z4) {
                    return null;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("&wf_n=");
                i8 = i6;
                sb3.append(i8);
                stringBuffer2.append(sb3.toString());
                if (stringBuffer != null) {
                    stringBuffer2.append("&wf_mc=");
                    stringBuffer2.append(stringBuffer.toString());
                }
                if (strReplace != null) {
                    stringBuffer2.append("&wf_rs=" + i3);
                }
                if (j > 10) {
                    i9 = 0;
                } else {
                    i9 = 0;
                }
                stringBuffer2.append("&wf_st=");
                stringBuffer2.append(kVar.b);
                stringBuffer2.append("&wf_et=");
                stringBuffer2.append(kVar.c);
                stringBuffer2.append("&wf_vt=");
                stringBuffer2.append(bVar.f26416a);
                if (i8 > 0) {
                    kVar.d = true;
                    stringBuffer2.append("&wf_en=");
                    if (kVar.e) {
                        i10 = 1;
                    } else {
                        i10 = i9;
                    }
                    stringBuffer2.append(i10);
                }
                if (str2 != null) {
                    stringBuffer2.append("&wf_gw=");
                    stringBuffer2.append(str2);
                }
                return stringBuffer2.toString();
            } catch (Error e9) {
                e = e9;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    public synchronized String a(WifiInfo wifiInfo, String str) {
        if (wifiInfo == null && str == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.l > 1000) {
            if (wifiInfo != null) {
                this.m = wifiInfo.getBSSID();
            } else {
                this.m = str;
            }
            this.l = jCurrentTimeMillis;
        }
        return this.m;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:103:0x0201  */
    /* JADX WARN: Code duplicated, block: B:104:0x0208  */
    /* JADX WARN: Code duplicated, block: B:106:0x0213  */
    /* JADX WARN: Code duplicated, block: B:131:0x0225 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x01ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:92:0x01bc  */
    /* JADX WARN: Instruction removed from duplicated block: B:106:0x0213, please report this as an issue */
    public String a(k kVar, int i, String str, boolean z, int i2) {
        long jElapsedRealtimeNanos;
        boolean z2;
        StringBuffer stringBuffer;
        int size;
        long j;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z3;
        String str2;
        int i7;
        int i8;
        int i9;
        String str3;
        boolean z4;
        StringBuffer stringBuffer2;
        Long l;
        Iterator it;
        long jLongValue;
        long jLongValue2;
        long j2;
        if (kVar.a() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
            while (true) {
                if (i4 >= size) {
                    str2 = ";%d;";
                    i7 = size;
                    i8 = i5;
                    i9 = i6;
                    break;
                }
                i7 = size;
                if (kVar.f26442a.get(i4) == null || kVar.f26442a.get(i4).level == 0) {
                    jElapsedRealtimeNanos = jElapsedRealtimeNanos;
                } else {
                    int i10 = i3 + 1;
                    if (z3) {
                        stringBuffer.append("&wf=");
                        z3 = false;
                    } else {
                        stringBuffer.append("|");
                    }
                    String strReplace = kVar.f26442a.get(i4).BSSID.replace(u15.f19942b, "");
                    stringBuffer.append(strReplace);
                    if (str != 0 && strReplace.equals(str)) {
                        i6 = i10;
                    }
                    int i11 = kVar.f26442a.get(i4).level;
                    if (i11 < 0) {
                        i11 = -i11;
                    }
                    boolean z5 = z3;
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i11)));
                    i8 = i5 + 1;
                    if (z2) {
                        try {
                            str2 = ";%d;";
                            try {
                                j2 = (jElapsedRealtimeNanos - kVar.f26442a.get(i4).timestamp) / 1000000;
                            } catch (Throwable th) {
                                th = th;
                                if (com.baidu.location.c.b.a.c) {
                                    th.printStackTrace();
                                }
                                j2 = 0;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = ";%d;";
                        }
                        boolean z6 = com.baidu.location.c.b.a.c;
                        if (z6 && com.baidu.location.c.b.a.d) {
                            g.h().a("wifi noUpdateTime = " + j2);
                        }
                        arrayList.add(Long.valueOf(j2));
                        if (j2 > j) {
                            if (z6 && com.baidu.location.c.b.a.d) {
                                g.h().a("wifi maxScanTime = " + j2);
                            }
                            j = j2;
                        }
                    } else {
                        str2 = ";%d;";
                        jElapsedRealtimeNanos = jElapsedRealtimeNanos;
                    }
                    if (i8 > i) {
                        i9 = i6;
                        z3 = z5;
                        break;
                    }
                    i5 = i8;
                    i3 = i10;
                    z3 = z5;
                }
                i4++;
                size = i7;
                jElapsedRealtimeNanos = jElapsedRealtimeNanos;
            }
        } catch (Error unused) {
            jElapsedRealtimeNanos = 0;
        }
        z2 = jElapsedRealtimeNanos > 0;
        stringBuffer = new StringBuffer(512);
        size = kVar.f26442a.size();
        j = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        i6 = 0;
        z3 = true;
        if (z) {
            return stringBuffer.toString();
        }
        if (i9 > 0) {
            stringBuffer.append("&wf_n=");
            stringBuffer.append(i9);
        }
        if (i8 > i) {
            str3 = "|";
            if (i2 > i + 1) {
                int i12 = i8;
                int i13 = i7;
                while (true) {
                    if (i12 < i13) {
                        if (i12 == i8) {
                            stringBuffer.append("&wf2=");
                        } else {
                            stringBuffer.append(str3);
                        }
                        stringBuffer.append(kVar.f26442a.get(i12).BSSID.replace(u15.f19942b, ""));
                        int i14 = kVar.f26442a.get(i12).level;
                        if (i14 < 0) {
                            i14 = -i14;
                        }
                        Locale locale = Locale.CHINA;
                        z4 = true;
                        Object[] objArr = {Integer.valueOf(i14)};
                        String str4 = str2;
                        stringBuffer.append(String.format(locale, str4, objArr));
                        if (i12 >= i2) {
                            break;
                        }
                        i12++;
                        str2 = str4;
                    }
                }
            }
            if (z3) {
                return null;
            }
            if (j > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                stringBuffer2 = new StringBuffer(128);
                stringBuffer2.append("&wf_ut=");
                l = (Long) arrayList.get(0);
                it = arrayList.iterator();
                while (it.hasNext()) {
                    jLongValue = ((Long) it.next()).longValue();
                    if (z4) {
                        stringBuffer2.append(jLongValue);
                        z4 = false;
                    } else {
                        jLongValue2 = jLongValue - l.longValue();
                        if (jLongValue2 != 0) {
                            stringBuffer2.append("" + jLongValue2);
                        }
                    }
                    stringBuffer2.append(str3);
                }
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.h().a("wifi scantime list str = " + stringBuffer2.toString());
                }
                stringBuffer.append(stringBuffer2.toString());
            }
            return stringBuffer.toString();
        }
        str3 = r4;
        z4 = true;
        if (z3) {
            return null;
        }
        if (j > 10) {
            stringBuffer2 = new StringBuffer(128);
            stringBuffer2.append("&wf_ut=");
            l = (Long) arrayList.get(0);
            it = arrayList.iterator();
            while (it.hasNext()) {
                jLongValue = ((Long) it.next()).longValue();
                if (z4) {
                    stringBuffer2.append(jLongValue);
                    z4 = false;
                } else {
                    jLongValue2 = jLongValue - l.longValue();
                    if (jLongValue2 != 0) {
                        stringBuffer2.append("" + jLongValue2);
                    }
                }
                stringBuffer2.append(str3);
            }
            if (com.baidu.location.c.b.a.c) {
                g.h().a("wifi scantime list str = " + stringBuffer2.toString());
            }
            stringBuffer.append(stringBuffer2.toString());
        }
        return stringBuffer.toString();
    }

    public void a(int i) {
        this.i.set(i);
    }

    public void a(Context context, List<String> list) {
        if (this.b) {
            return;
        }
        this.h = context;
        this.e = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.f = new C0262b();
        if (this.p == null) {
            this.p = new Handler(Looper.getMainLooper());
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (!list.contains("android.net.wifi.SCAN_RESULTS")) {
            list.add("android.net.wifi.SCAN_RESULTS");
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.h.registerReceiver(this.f, new IntentFilter(it.next()));
            }
        } catch (Exception e) {
            if (com.baidu.location.c.b.a.c) {
                e.printStackTrace();
            }
        }
        this.b = true;
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            g.h().a("wifimanager start ...");
        }
    }

    public boolean a(k kVar, k kVar2) {
        List<ScanResult> list = kVar.f26442a;
        if (list == null || kVar2 == null || kVar2.f26442a == null) {
            return false;
        }
        int iMin = Math.min(list.size(), kVar2.f26442a.size());
        for (int i = 0; i < iMin; i++) {
            try {
                if (kVar.f26442a.get(i) != null) {
                    String str = kVar.f26442a.get(i).BSSID;
                    String str2 = kVar2.f26442a.get(i).BSSID;
                    if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                        return false;
                    }
                }
            } catch (Exception e) {
                if (com.baidu.location.c.b.a.c) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return true;
    }

    public void b() {
        if (this.b) {
            try {
                this.h.unregisterReceiver(this.f);
                this.f26416a = 0L;
            } catch (Exception e) {
                if (com.baidu.location.c.b.a.c) {
                    e.printStackTrace();
                }
            }
            this.f = null;
            this.e = null;
            this.b = false;
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.h().a("wifimanager stop ...");
            }
        }
    }

    public long c() {
        return this.j;
    }

    public k d() {
        k kVarA;
        synchronized (this.o) {
            kVarA = a(this.g);
        }
        if (kVarA == null || !kVarA.b()) {
            try {
                WifiManager wifiManager = this.e;
                kVarA = wifiManager != null ? new k(wifiManager.getScanResults(), this.j) : new k(null, 0L);
            } catch (Exception e) {
                if (com.baidu.location.c.b.a.c) {
                    e.printStackTrace();
                }
            }
        }
        return kVarA;
    }

    public String e() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo wifiInfoF = a().f();
        String strA = a(wifiInfoF, (String) null);
        if (wifiInfoF == null || strA == null) {
            return null;
        }
        String strReplace = strA.replace(u15.f19942b, "");
        int rssi = wifiInfoF.getRssi();
        String strH = a().h();
        if (rssi < 0) {
            rssi = -rssi;
        }
        if (strReplace == null || rssi >= 100 || "020000000000".equals(strReplace)) {
            return null;
        }
        stringBuffer.append("&wf=");
        stringBuffer.append(strReplace);
        stringBuffer.append(l.b);
        stringBuffer.append("" + rssi + l.b);
        String ssid = wifiInfoF.getSSID();
        if (ssid != null && (ssid.contains("&") || ssid.contains(l.b))) {
            ssid = ssid.replace("&", LoginConstants.UNDER_LINE);
        }
        stringBuffer.append(ssid);
        stringBuffer.append("&wf_n=1");
        if (strH != null) {
            stringBuffer.append("&wf_gw=");
            stringBuffer.append(strH);
        }
        return stringBuffer.toString();
    }

    public WifiInfo f() {
        try {
            WifiManager wifiManager = this.e;
            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
            String strA = a(connectionInfo, (String) null);
            if (connectionInfo != null && strA != null && connectionInfo.getRssi() > -100) {
                String strReplace = strA.replace(u15.f19942b, "");
                if (!"000000000000".equals(strReplace) && !"".equals(strReplace) && !"020000000000".equals(strReplace)) {
                    return connectionInfo;
                }
            }
        } catch (Error | Exception unused) {
        }
        return null;
    }
}
