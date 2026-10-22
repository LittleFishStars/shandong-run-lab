package com.byazt.sv;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.byazt.aas.my;
import com.byazt.aas.nb;
import com.byazt.by.uj;
import com.byazt.dna.u;
import com.byazt.ete.yf;
import com.byazt.nr.a;
import com.byazt.nr.da;
import com.byazt.xgx.tt;
import com.byazt.xix.ve;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 613, 20})
public class c {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile c c;
    public static final List<String> u = Arrays.asList("-10001", "-10008", "103111", "105002", "-5", "-2", "-15", "-10", "-11");
    public final uj n;
    public final Context tt;
    public final yf uj;
    public final ve ve;
    public String[] x;
    public final AtomicBoolean sp = new AtomicBoolean(false);
    public long i = 0;
    public long da = 0;
    public long sl = 0;
    public long t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f29033a = true;

    private c(Context context) {
        this.tt = context;
        this.ve = ve.c(context);
        uj ujVarC = uj.c();
        this.n = ujVarC;
        if (ujVarC == null) {
            this.uj = new yf("", "-1", "", "");
            return;
        }
        String strVe = ujVarC.ve("cr", 3300000L);
        if (TextUtils.isEmpty(strVe)) {
            this.uj = new yf("", "", "", "");
        } else {
            this.uj = new yf(ujVarC.ve("vd", c(strVe)), ujVarC.ve(NotificationCompat.CATEGORY_ERROR, c(strVe)), ujVarC.ve("tk", c(strVe)), ujVarC.ve("cr", c(strVe)));
        }
        ve();
    }

    private boolean tt() {
        uj ujVar = this.n;
        if (ujVar != null) {
            String strVe = ujVar.ve("cr", 3300000L);
            if (!TextUtils.isEmpty(strVe) && !TextUtils.isEmpty(this.n.ve("tk", c(strVe)))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        this.sp.set(false);
        this.ve.tt();
    }

    private void ve() {
        uj ujVar = this.n;
        if (ujVar != null) {
            this.da = ujVar.tt("uni_fir_ts", 0L);
            if (nb.c(System.currentTimeMillis(), this.da)) {
                this.sl = this.n.tt("uni_times", 0L);
                this.t = this.n.tt("uni_ts", 0L);
            } else {
                this.sl = 0L;
                this.t = 0L;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    private long c(String str) {
        byte b;
        switch (str) {
            case "1":
                b = 1;
                break;
            case "2":
                b = 0;
                break;
            case "3":
                b = 2;
                break;
            default:
                b = -1;
                break;
        }
        return b != 0 ? 3300000L : 50000L;
    }

    public static c c(Context context) {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c(context);
                }
            }
        }
        return c;
    }

    public yf c() {
        if (!tt() && this.f29033a) {
            if (!this.sp.compareAndSet(false, true)) {
                return this.uj;
            }
            da.c().post(new Runnable() { // from class: com.byazt.sv.c.1
                /* JADX WARN: Code duplicated, block: B:53:0x00d7  */
                /* JADX WARN: Code duplicated, block: B:55:0x00ea  */
                /* JADX WARN: Code duplicated, block: B:57:0x00f5  */
                /* JADX WARN: Code duplicated, block: B:59:0x0104  */
                @Override // java.lang.Runnable
                public void run() {
                    int iC;
                    String strConcat;
                    final ArrayList arrayList = new ArrayList();
                    byte b = -1;
                    if (tt.c(c.this.tt, "android.permission.ACCESS_NETWORK_STATE") != -1) {
                        iC = c.this.ve.c();
                        if (iC != 3 || tt.c(c.this.tt, "android.permission.CHANGE_NETWORK_STATE") != -1) {
                            if (iC == 3 || iC == 2) {
                                String simOperatorCode = ((u) com.byazt.ut.uj.getService("device_info_new")).getSimOperatorCode();
                                simOperatorCode.hashCode();
                                switch (simOperatorCode.hashCode()) {
                                    case 48:
                                        if (simOperatorCode.equals("0")) {
                                            b = 0;
                                        }
                                        break;
                                    case 49:
                                        if (simOperatorCode.equals("1")) {
                                            b = 1;
                                        }
                                        break;
                                    case 50:
                                        if (simOperatorCode.equals("2")) {
                                            b = 2;
                                        }
                                        break;
                                    case 51:
                                        if (simOperatorCode.equals("3")) {
                                            b = 3;
                                        }
                                        break;
                                    case 52:
                                        if (simOperatorCode.equals("4")) {
                                            b = 4;
                                        }
                                        break;
                                    case 54:
                                        if (simOperatorCode.equals("6")) {
                                            b = 5;
                                        }
                                        break;
                                }
                                switch (b) {
                                    case 0:
                                        c.this.f29033a = false;
                                        strConcat = "3";
                                        break;
                                    case 1:
                                        arrayList.add("https://msg.cmpassport.com/h5/getMobile");
                                        strConcat = "";
                                        break;
                                    case 2:
                                        arrayList.add("https://nisportal.10010.com:9001/api?appid=1554778161154");
                                        strConcat = "";
                                        break;
                                    case 3:
                                        arrayList.add("https://id6.me/gw/preuniq.do");
                                        strConcat = "";
                                        break;
                                    case 4:
                                    case 5:
                                        arrayList.add("https://msg.cmpassport.com/h5/getMobile");
                                        arrayList.add("https://id6.me/gw/preuniq.do");
                                        arrayList.add("https://nisportal.10010.com:9001/api?appid=1554778161154");
                                        strConcat = "";
                                        break;
                                    default:
                                        c.this.f29033a = false;
                                        strConcat = "2";
                                        break;
                                }
                            } else {
                                strConcat = "4".concat(String.valueOf(iC));
                            }
                        }
                        if (!TextUtils.isEmpty(strConcat)) {
                            c.this.uj.c("", strConcat, "", "");
                            c.this.sp.set(false);
                            return;
                        }
                        c.this.uj.c("", "1", "", "");
                        if (iC == 3) {
                            c.this.ve.c(new ve.c() { // from class: com.byazt.sv.c.1.1
                                @Override // com.byazt.xix.ve.c
                                public void c(Network network) {
                                    if (network == null) {
                                        c.this.uj();
                                    } else {
                                        c.this.c(network, (List<String>) arrayList);
                                    }
                                }
                            });
                        } else {
                            c.this.c((Network) null, arrayList);
                        }
                    }
                    iC = 0;
                    c.this.f29033a = false;
                    strConcat = "5";
                    if (!TextUtils.isEmpty(strConcat)) {
                        c.this.uj.c("", strConcat, "", "");
                        c.this.sp.set(false);
                        return;
                    }
                    c.this.uj.c("", "1", "", "");
                    if (iC == 3) {
                        c.this.ve.c(new ve.c() { // from class: com.byazt.sv.c.1.1
                            @Override // com.byazt.xix.ve.c
                            public void c(Network network) {
                                if (network == null) {
                                    c.this.uj();
                                } else {
                                    c.this.c(network, (List<String>) arrayList);
                                }
                            }
                        });
                    } else {
                        c.this.c((Network) null, arrayList);
                    }
                }
            });
            return this.uj;
        }
        return this.uj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    public void c(Network network, List<String> list) {
        byte b;
        String str;
        String str2;
        String strC;
        String str3;
        String strC2;
        for (String str4 : list) {
            try {
                int iHashCode = str4.hashCode();
                if (iHashCode != 15305274) {
                    if (iHashCode != 899606572) {
                        if (iHashCode == 1964448447 && str4.equals("https://id6.me/gw/preuniq.do")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (str4.equals("https://nisportal.10010.com:9001/api?appid=1554778161154")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str4.equals("https://msg.cmpassport.com/h5/getMobile")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    str = "1";
                    str2 = null;
                    strC = str4;
                    str3 = "0";
                    strC2 = com.byazt.xix.uj.c();
                } else if (b != 1) {
                    if (b != 2) {
                        this.sp.set(false);
                        return;
                    }
                    long j = this.sl + 1;
                    this.sl = j;
                    uj ujVar = this.n;
                    if (ujVar != null) {
                        ujVar.c("uni_times", j);
                        if (this.sl == 1) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            this.da = jCurrentTimeMillis;
                            this.n.c("uni_fir_ts", jCurrentTimeMillis);
                        }
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    str = "2";
                    if (nb.c(jCurrentTimeMillis2, this.da) && this.sl >= 30 && jCurrentTimeMillis2 - this.t < 3000000) {
                        this.uj.c("2", "7", "", "2");
                    } else {
                        long jCurrentTimeMillis3 = System.currentTimeMillis();
                        this.t = jCurrentTimeMillis3;
                        uj ujVar2 = this.n;
                        if (ujVar2 != null) {
                            ujVar2.c("uni_ts", jCurrentTimeMillis3);
                        }
                        strC = str4;
                        strC2 = null;
                        str2 = null;
                        str3 = "2";
                    }
                } else {
                    String strC3 = com.byazt.nr.c.c(8);
                    str2 = strC3;
                    str = "3";
                    strC2 = null;
                    str3 = "1";
                    strC = com.byazt.xix.uj.c(str4, strC3);
                }
                c(network, strC, strC2, str, str3, str2);
            } catch (Exception unused) {
                this.uj.c("", "6", "", "");
            }
            if (!TextUtils.isEmpty(this.uj.tt()) || (!TextUtils.isEmpty(this.uj.c()) && !u.contains(this.uj.c()))) {
                break;
            }
        }
        if (!TextUtils.isEmpty(this.uj.c()) && u.contains(this.uj.c())) {
            this.f29033a = false;
        }
        uj();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void c(Network network, String str, String str2, String str3, String str4, String str5) {
        byte b;
        String str6;
        String string;
        JSONObject jSONObjectC = ("1".equals(str3) && TextUtils.isEmpty(str2)) ? null : com.byazt.xix.tt.c(network, str, str2);
        String str7 = "";
        if (jSONObjectC == null) {
            this.uj.c(str4, "6", "", str3);
            return;
        }
        try {
            switch (str3.hashCode()) {
                case 49:
                    if (!str3.equals("1")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 50:
                    if (!str3.equals("2")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 51:
                    if (!str3.equals("3")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                JSONObject jSONObject = jSONObjectC.getJSONObject("body");
                String string2 = jSONObject.getString("resultCode");
                if ("103000".equals(string2)) {
                    string = jSONObject.getString("token");
                    str6 = string;
                    str7 = "0";
                } else {
                    str6 = "";
                    str7 = string2;
                }
            } else if (b == 1) {
                String strValueOf = String.valueOf(jSONObjectC.getInt("result"));
                if ("0".equals(strValueOf)) {
                    string = new JSONObject(com.byazt.xix.c.c(false, a.c(jSONObjectC.getString("data")), str5)).getString("accessCode");
                    str6 = string;
                    str7 = "0";
                } else {
                    str7 = strValueOf;
                    str6 = "";
                }
            } else if (b != 2) {
                str6 = "";
            } else {
                String strOptString = jSONObjectC.has("code") ? jSONObjectC.optString("code") : "";
                if (jSONObjectC.has("authurl")) {
                    String string3 = jSONObjectC.getString("authurl");
                    if (!TextUtils.isEmpty(string3)) {
                        Pair<String, String> pairC = c(network, string3 + "/api?appid=1554778161154", str3, str4);
                        Object obj = pairC.first;
                        if (obj != null) {
                            strOptString = (String) obj;
                        }
                        Object obj2 = pairC.second;
                        if (obj2 != null) {
                            str7 = (String) obj2;
                        }
                    }
                }
                str6 = str7;
                str7 = strOptString;
            }
            this.uj.c(str4, str7, str6, str3);
            if (this.n == null || TextUtils.isEmpty(str6)) {
                return;
            }
            this.n.ve("vd", str4);
            this.n.ve("cr", str3);
            this.n.ve(NotificationCompat.CATEGORY_ERROR, str7);
            this.n.ve("tk", str6);
        } catch (Exception unused) {
        }
    }

    private Pair<String, String> c(Network network, String str, String str2, String str3) {
        String string;
        JSONObject jSONObjectC = com.byazt.xix.tt.c(network, str, null);
        try {
            if (jSONObjectC == null) {
                this.uj.c(str3, "6", "", str2);
                return new Pair<>("6", "");
            }
            String string2 = jSONObjectC.has("err_code") ? jSONObjectC.getString("err_code") : "6";
            if (this.x == null || System.currentTimeMillis() - this.i > 3600000) {
                this.x = my.tt(com.byazt.vxy.c.n());
                this.i = System.currentTimeMillis();
            }
            String[] strArr = this.x;
            if (strArr.length == 2 && !TextUtils.isEmpty(strArr[1])) {
                this.uj.c(this.x[1]);
            }
            if (jSONObjectC.has("province")) {
                this.uj.tt(jSONObjectC.getString("province"));
            }
            if (jSONObjectC.has("code")) {
                string2 = "0";
                string = jSONObjectC.getString("code");
            } else {
                string = "";
            }
            return new Pair<>(string2, string);
        } catch (Throwable unused) {
            return new Pair<>("6", "");
        }
    }
}
