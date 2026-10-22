package com.byazt.hw;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.gqp.yp;
import com.byazt.nr.m;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 77, 46})
public class n {
    public int my;
    public tt n;
    public Context sp;
    public boolean uj;
    public c ve;
    public uj x;
    public long tt = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28632a = false;
    public int i = 0;
    public long da = 19700101000L;
    public int sl = 0;
    public HashMap<String, Integer> t = new HashMap<>();
    public HashMap<String, Integer> u = new HashMap<>();
    public int yp = 0;
    public HashMap<String, Integer> z = new HashMap<>();
    public HashMap<String, Integer> m = new HashMap<>();
    public boolean nu = true;
    public Map<String, Integer> rh = new HashMap();
    public Handler c = new Handler(Looper.getMainLooper()) { // from class: com.byazt.hw.n.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            n.this.tt(message.arg1 != 0);
        }
    };

    private n() {
    }

    private boolean c(int i) {
        return i >= 200 && i < 400;
    }

    private void da() {
        com.byazt.lf.ve.tt("TNCManager", "resetTNCControlState");
        this.sl = 0;
        this.t.clear();
        this.u.clear();
        this.yp = 0;
        this.z.clear();
        this.m.clear();
    }

    private void i() {
        SharedPreferences sharedPreferencesTt = com.byazt.nys.tt.tt(this.sp, c(), 0);
        this.i = sharedPreferencesTt.getInt("tnc_probe_cmd", 0);
        this.da = sharedPreferencesTt.getLong("tnc_probe_version", 19700101000L);
    }

    public ve a() {
        uj ujVar = this.x;
        if (ujVar != null) {
            return ujVar.ve();
        }
        return null;
    }

    public void n() {
        this.rh.clear();
    }

    public Map<String, String> sp() {
        ve veVarA = a();
        if (veVarA != null) {
            return veVarA.uj;
        }
        return null;
    }

    public c tt() {
        return this.ve;
    }

    public tt uj() {
        return this.n;
    }

    public boolean ve() {
        return this.uj;
    }

    public uj x() {
        return this.x;
    }

    private void tt(String str) {
        Map<String, String> mapSp;
        if (TextUtils.isEmpty(str) || (mapSp = sp()) == null || !mapSp.containsValue(str)) {
            return;
        }
        if (this.rh.get(str) == null) {
            this.rh.put(str, 1);
        } else {
            this.rh.put(str, Integer.valueOf(this.rh.get(str).intValue() + 1));
        }
    }

    private boolean uj(String str) {
        Map<String, String> mapSp = sp();
        if (mapSp == null) {
            return false;
        }
        String str2 = mapSp.get(str);
        if (TextUtils.isEmpty(str2) || this.rh.get(str2) == null || this.rh.get(str2).intValue() < 3) {
            return false;
        }
        com.byazt.lf.ve.tt("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(str)));
        return true;
    }

    private void ve(String str) {
        if (!TextUtils.isEmpty(str) && this.rh.containsKey(str)) {
            this.rh.put(str, 0);
        }
    }

    public String c() {
        return "ttnet_tnc_config" + this.my;
    }

    public void c(boolean z) {
        this.uj = z;
    }

    public void c(tt ttVar) {
        this.n = ttVar;
    }

    public synchronized void c(Context context, boolean z) {
        if (!this.f28632a) {
            if (context != null) {
                this.sp = context.getApplicationContext();
            }
            this.nu = z;
            this.x = new uj(context, z, this.my);
            if (z) {
                i();
            }
            com.byazt.lf.ve.tt("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.i + " probeVersion: " + this.da);
            this.ve = sp.c().c(this.my, this.sp);
            this.f28632a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(boolean z) {
        ve veVarA = a();
        if (veVarA == null) {
            return;
        }
        com.byazt.lf.ve.tt("TNCManager", "doUpdateRemote, ".concat(String.valueOf(z)));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.tt + (((long) veVarA.sl) * 1000) > jElapsedRealtime) {
            com.byazt.lf.ve.tt("TNCManager", "doUpdateRemote, time limit");
        } else {
            this.tt = jElapsedRealtime;
            sp.c().c(this.my, this.sp).ve();
        }
    }

    public String c(String str) {
        String protocol;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
            String host = null;
            try {
                URL url = new URL(str);
                protocol = url.getProtocol();
                try {
                    host = url.getHost();
                } catch (Throwable th) {
                    th = th;
                    m.c(th);
                }
            } catch (Throwable th2) {
                th = th2;
                protocol = null;
            }
            if (!TextUtils.isEmpty(protocol) && (("http".equals(protocol) || "https".equals(protocol)) && !TextUtils.isEmpty(host))) {
                if (uj(host)) {
                    com.byazt.lf.ve.tt("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(host)));
                    return str;
                }
                Map<String, String> mapSp = sp();
                if (mapSp != null && mapSp.containsKey(host)) {
                    String str2 = mapSp.get(host);
                    if (TextUtils.isEmpty(str2)) {
                        return str;
                    }
                    com.byazt.lf.ve.tt("TNCManager", "handleHostMapping, match, origin: ".concat(str));
                    String str3 = protocol + "://" + host;
                    String str4 = protocol + "://" + str2;
                    if (str.startsWith(str3)) {
                        str = str.replaceFirst(str3, str4);
                    }
                    com.byazt.lf.ve.tt("TNCManager", "handleHostMapping, target: ".concat(String.valueOf(str)));
                    return str;
                }
                com.byazt.lf.ve.tt("TNCManager", "handleHostMapping, nomatch: ".concat(String.valueOf(host)));
            }
        }
        return str;
    }

    public n(int i) {
        this.my = i;
    }

    private boolean tt(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        ve veVarA = a();
        return (veVarA == null || TextUtils.isEmpty(veVarA.u) || !veVarA.u.contains(String.valueOf(i))) ? false : true;
    }

    public synchronized void c(yp ypVar, com.byazt.gqp.m mVar) {
        URL urlC;
        if (ypVar == null || mVar == null) {
            return;
        }
        if (this.nu) {
            if (com.byazt.lf.a.c(this.sp)) {
                try {
                    urlC = ypVar.tt().c();
                } catch (Exception unused) {
                    urlC = null;
                }
                if (urlC == null) {
                    return;
                }
                String protocol = urlC.getProtocol();
                String host = urlC.getHost();
                String path = urlC.getPath();
                String strC = c(ypVar);
                int iVe = mVar.ve();
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(strC)) {
                        return;
                    }
                    com.byazt.lf.ve.tt("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + strC + "#" + iVe);
                    ve veVarA = a();
                    if (veVarA != null && veVarA.tt) {
                        c(mVar, host);
                    }
                    if (veVarA == null) {
                        return;
                    }
                    com.byazt.lf.ve.tt("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + strC + "#" + iVe + " " + this.sl + "#" + this.t.size() + "#" + this.u.size() + " " + this.yp + "#" + this.z.size() + "#" + this.m.size());
                    if (iVe > 0) {
                        if (c(iVe)) {
                            if (this.sl > 0 || this.yp > 0) {
                                da();
                            }
                            ve(host);
                            return;
                        }
                        if (!tt(iVe)) {
                            this.yp++;
                            this.z.put(path, 0);
                            this.m.put(strC, 0);
                            if (this.yp >= veVarA.x && this.z.size() >= veVarA.i && this.m.size() >= veVarA.da) {
                                com.byazt.lf.ve.tt("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + strC + "#" + iVe);
                                c(false, 0L);
                                da();
                            }
                            tt(host);
                        }
                    }
                }
            }
        }
    }

    private String c(yp ypVar) {
        if (ypVar == null || ypVar.tt() == null || ypVar.tt().c() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(ypVar.tt().c().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    public synchronized void c(yp ypVar, Exception exc) {
        URL urlC;
        if (ypVar != null) {
            if (ypVar.tt() != null && exc != null) {
                if (this.nu) {
                    if (com.byazt.lf.a.c(this.sp)) {
                        try {
                            urlC = ypVar.tt().c();
                        } catch (Exception unused) {
                            urlC = null;
                        }
                        if (urlC == null) {
                            return;
                        }
                        String protocol = urlC.getProtocol();
                        String host = urlC.getHost();
                        String path = urlC.getPath();
                        String strC = c(ypVar);
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            ve veVarA = a();
                            if (veVarA == null) {
                                return;
                            }
                            com.byazt.lf.ve.tt("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + strC + "# " + this.sl + "#" + this.t.size() + "#" + this.u.size() + " " + this.yp + "#" + this.z.size() + "#" + this.m.size());
                            this.sl = this.sl + 1;
                            this.t.put(path, 0);
                            this.u.put(strC, 0);
                            if (this.sl >= veVarA.n && this.t.size() >= veVarA.f28633a && this.u.size() >= veVarA.sp) {
                                com.byazt.lf.ve.tt("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + strC);
                                c(false, 0L);
                                da();
                            }
                            tt(host);
                        }
                    }
                }
            }
        }
    }

    private void c(com.byazt.gqp.m mVar, String str) {
        int i;
        long j;
        ve veVarA;
        if (mVar != null && this.nu) {
            String strC = mVar.c("tnc-cmd", null);
            if (TextUtils.isEmpty(strC)) {
                com.byazt.lf.ve.tt("TNCManager", "handleTncProbe, no probeProto, ".concat(String.valueOf(str)));
                return;
            }
            String[] strArrSplit = strC.split("@");
            if (strArrSplit != null && strArrSplit.length == 2) {
                try {
                    i = Integer.parseInt(strArrSplit[0]);
                    try {
                        j = Long.parseLong(strArrSplit[1]);
                    } catch (Throwable th) {
                        th = th;
                        m.c(th);
                        com.byazt.lf.ve.tt("TNCManager", "handleTncProbe, probeProto except, ".concat(String.valueOf(str)));
                        j = 0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = 0;
                }
                com.byazt.lf.ve.tt("TNCManager", "handleTncProbe, local: " + this.i + "@" + this.da + " svr: " + i + "@" + j + " " + str);
                if (j <= this.da) {
                    return;
                }
                this.i = i;
                this.da = j;
                com.byazt.nys.tt.tt(this.sp, c(), 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
                if (this.i != 10000 || (veVarA = a()) == null) {
                    return;
                }
                Random random = new Random(System.currentTimeMillis());
                int i2 = veVarA.t;
                long jNextInt = i2 > 0 ? ((long) random.nextInt(i2)) * 1000 : 0L;
                com.byazt.lf.ve.tt("TNCManager", "handleTncProbe, updateConfig delay: " + jNextInt + " " + str);
                c(true, jNextInt);
                return;
            }
            com.byazt.lf.ve.tt("TNCManager", "handleTncProbe, probeProto err, ".concat(String.valueOf(str)));
        }
    }

    private void c(boolean z, long j) {
        if (this.c.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.c.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.c.sendMessageDelayed(messageObtainMessage, j);
        } else {
            this.c.sendMessage(messageObtainMessage);
        }
    }
}
