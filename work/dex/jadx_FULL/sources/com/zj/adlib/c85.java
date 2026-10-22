package com.zj.adlib;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import com.androidquery.util.Constants;
import com.byazt.bv.BaseConstants;
import com.coremedia.iso.boxes.FreeSpaceBox;
import com.ipd.dsp.internal.i.q;
import java.util.Locale;
import org.json.JSONObject;
import org.xml.sax.XMLReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c85 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ApplicationInfo f40921a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static PackageInfo f15752a = null;
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final String f15753e = "aqs.skip";
    public static final String f = "•";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f15754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f15756a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hq f15758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15760a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f15761b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f15762b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f15763c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f15764c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f15765d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f15755a = 720000;
    public int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f15757a = new b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15759a = Locale.getDefault().toString();

    public class b implements DialogInterface.OnClickListener, Html.TagHandler {
        public b() {
        }

        public final void a(String str, JSONObject jSONObject, c30 c30Var) {
            if (c85.this.f15764c) {
                return;
            }
            c85.this.f15764c = true;
            c85.this.f15754a = 0;
            c85.this.callback(str, jSONObject, c30Var);
        }

        public void b(String str, String str2, c30 c30Var) {
            if (str2 == null || str2.length() <= 1000) {
                return;
            }
            String strX = c85.this.x();
            b30 b30Var = new b30();
            b30Var.G0(strX).E0(JSONObject.class).P(this, "marketCb");
            b30Var.h0("html", str2);
            c85.this.f15758a.X0(c85.this.f15754a).c(b30Var);
        }

        public void c(String str, JSONObject jSONObject, c30 c30Var) {
            if (c85.this.f15756a.isFinishing()) {
                return;
            }
            if (jSONObject == null) {
                a(str, jSONObject, c30Var);
                return;
            }
            String strOptString = jSONObject.optString("status");
            if (!"1".equals(strOptString)) {
                if ("0".equals(strOptString)) {
                    c30Var.q();
                    return;
                } else {
                    a(str, jSONObject, c30Var);
                    return;
                }
            }
            if (jSONObject.has("dialog")) {
                a(str, jSONObject, c30Var);
            }
            if (!c85.this.f15762b && jSONObject.optBoolean("fetch", false) && c30Var.o() == 1) {
                c85.this.f15762b = true;
                String strOptString2 = jSONObject.optString("marketUrl", null);
                b30 b30Var = new b30();
                b30Var.G0(strOptString2).E0(String.class).P(this, "detailCb");
                c85.this.f15758a.X0(c85.this.f15754a).c(b30Var);
            }
        }

        @Override // android.text.Html.TagHandler
        public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            if ("li".equals(str)) {
                if (!z) {
                    editable.append("\n");
                    return;
                }
                editable.append(q.a.i);
                editable.append(c85.f);
                editable.append(q.a.i);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == -3) {
                c85.K(c85.this.f15756a, c85.this.f15765d);
            } else if (i == -2) {
                c85.E(c85.this.f15756a, c85.this.f15763c);
            } else {
                if (i != -1) {
                    return;
                }
                c85.E(c85.this.f15756a, c85.this.f15761b);
            }
        }
    }

    public c85(Activity activity) {
        this.f15756a = activity;
        this.f15758a = new hq(activity);
        String strV = v();
        this.f15761b = strV;
        this.f15763c = strV;
    }

    public static boolean E(Activity activity, String str) {
        if (str == null) {
            return false;
        }
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String G(String str) {
        return "<small>" + str + "</small>";
    }

    public static void K(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(f15753e, str).commit();
    }

    public static String y(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(f15753e, null);
    }

    public final int A() {
        return w().versionCode;
    }

    public final boolean B() {
        return !this.f15756a.isFinishing();
    }

    public c85 C(int i) {
        this.b = i;
        return this;
    }

    public c85 D(String str) {
        this.f15759a = str;
        return this;
    }

    public final boolean F(String str, int i) {
        if (str.equals(y(this.f15756a))) {
            return false;
        }
        String strZ = z();
        int iA = A();
        if (strZ.equals(str) || iA > i) {
            return false;
        }
        return J(strZ, str, this.b);
    }

    public c85 H(int i) {
        this.f15754a = i;
        return this;
    }

    public c85 I(String str) {
        this.f15761b = str;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0050 A[RETURN] */
    public final boolean J(String str, String str2, int i) {
        if (str.equals(str2)) {
            return false;
        }
        try {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            if (strArrSplit.length >= 3 && strArrSplit2.length >= 3) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            return true;
                        }
                    }
                    if (strArrSplit[strArrSplit.length - 3].equals(strArrSplit2[strArrSplit2.length - 3])) {
                        return false;
                    }
                    return true;
                }
                if (!strArrSplit[strArrSplit.length - 1].equals(strArrSplit2[strArrSplit2.length - 1])) {
                    return true;
                }
                if (!strArrSplit[strArrSplit.length - 2].equals(strArrSplit2[strArrSplit2.length - 2])) {
                    return true;
                }
                if (strArrSplit[strArrSplit.length - 3].equals(strArrSplit2[strArrSplit2.length - 3])) {
                    return true;
                }
                return false;
            }
            return true;
        } catch (Exception e2) {
            gq.Q(e2);
            return true;
        }
    }

    public c85 L(String str) {
        this.f15763c = str;
        return this;
    }

    public void callback(String str, JSONObject jSONObject, c30 c30Var) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("version", "0");
        int iOptInt = jSONObject.optInt("code", 0);
        gq.j("version", z() + c25.j + strOptString + u15.f19942b + A() + c25.j + iOptInt);
        gq.j("outdated", Boolean.valueOf(F(strOptString, iOptInt)));
        if (this.f15760a || F(strOptString, iOptInt)) {
            showUpdateDialog(jSONObject);
        }
    }

    public void o() {
        String strX = x();
        b30 b30Var = new b30();
        b30Var.G0(strX).E0(JSONObject.class).P(this.f15757a, "marketCb").z(!this.f15760a).v(this.f15755a);
        this.f15758a.X0(this.f15754a).c(b30Var);
    }

    public c85 p(long j) {
        this.f15755a = j;
        return this;
    }

    public c85 q(boolean z) {
        this.f15760a = z;
        return this;
    }

    public final Drawable r() {
        return t().loadIcon(this.f15756a.getPackageManager());
    }

    public final String s() {
        return t().packageName;
    }

    public void showUpdateDialog(JSONObject jSONObject) {
        if (jSONObject != null && this.f15765d == null && B()) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("dialog");
            String strOptString = jSONObjectOptJSONObject.optString("update", "Update");
            String strOptString2 = jSONObjectOptJSONObject.optString(FreeSpaceBox.TYPE, "Skip");
            String strOptString3 = jSONObjectOptJSONObject.optString("rate", "Rate");
            String strOptString4 = jSONObjectOptJSONObject.optString("wbody", "");
            String strOptString5 = jSONObjectOptJSONObject.optString("title", "Update Available");
            gq.j("wbody", strOptString4);
            this.f15765d = jSONObject.optString("version", null);
            AlertDialog alertDialogCreate = new AlertDialog.Builder(this.f15756a).setIcon(r()).setTitle(strOptString5).setPositiveButton(strOptString3, this.f15757a).setNeutralButton(strOptString2, this.f15757a).setNegativeButton(strOptString, this.f15757a).create();
            alertDialogCreate.setMessage(Html.fromHtml(G(strOptString4), null, this.f15757a));
            this.f15758a.q1(alertDialogCreate);
        }
    }

    public final ApplicationInfo t() {
        if (f40921a == null) {
            f40921a = this.f15756a.getApplicationInfo();
        }
        return f40921a;
    }

    public final String u() {
        return "https://androidquery.appspot.com";
    }

    public final String v() {
        return BaseConstants.MARKET_PREFIX + s();
    }

    public final PackageInfo w() {
        if (f15752a == null) {
            try {
                f15752a = this.f15756a.getPackageManager().getPackageInfo(s(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return f15752a;
    }

    public final String x() {
        String str = u() + "/api/market?app=" + s() + "&locale=" + this.f15759a + "&version=" + z() + "&code=" + A() + "&aq=" + Constants.f1189a;
        if (!this.f15760a) {
            return str;
        }
        return str + "&force=true";
    }

    public final String z() {
        return w().versionName;
    }
}
