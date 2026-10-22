package com.ltmb.ltadsdk.adx.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.b;
import com.ltmb.ltadsdk.api.internal.AdPluginProxy;
import com.ltmb.ltadsdk.api.internal.IRemoteOpen;
import com.ltmb.ltadsdk.pkg.d;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.e;
import com.ltmb.ltadsdk.pkg.e5;
import com.ltmb.ltadsdk.pkg.f;
import com.ltmb.ltadsdk.pkg.f3;
import com.ltmb.ltadsdk.pkg.l0;
import com.ltmb.ltadsdk.pkg.n0;
import com.ltmb.ltadsdk.pkg.o0;
import com.ltmb.ltadsdk.pkg.p3;
import com.ltmb.ltadsdk.pkg.q1;
import com.ltmb.ltadsdk.pkg.s3;
import com.ltmb.ltadsdk.pkg.x5;
import com.ltmb.ltadsdk.pkg.x6;
import com.ltmb.ltadsdk.pkg.y;
import com.ltmb.ltadsdk.pkg.y5;
import com.ltmb.ltadsdk.pkg.y6;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ltmb/ltadsdk/adx/ui/activity/AdxDpActivity;", "Landroid/app/Activity;", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdxDpActivity extends Activity {
    public boolean b;
    public p3 c;
    public boolean d;
    public long e;
    public e g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public long m;
    public boolean n;
    public JSONObject o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40304a = 1000;
    public String f = "";

    public static final class a extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f40305a = new a();

        public a() {
            super(0);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            return Unit.INSTANCE;
        }
    }

    public AdxDpActivity() {
        a aVar = a.f40305a;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0133  */
    /* JADX WARN: Code duplicated, block: B:95:0x0287  */
    public final void a(boolean z, int i, int i2) {
        String str;
        List<String> list;
        String str2;
        List list2;
        p3 p3Var = this.c;
        if (p3Var != null) {
            p3Var.a(Boolean.valueOf(z), i);
        }
        this.c = null;
        d9 d9Var = d9.d;
        if (d9.a) {
            d9Var.a("dp success=" + z + ", code=" + i + ", alreadyReport=" + this.k);
        }
        if (!this.k) {
            if (z) {
                e eVar = this.g;
                boolean z2 = this.n;
                if (eVar != null) {
                    try {
                        if (d9.a) {
                            d9Var.a("reportAdDeeplink dtype=" + i2 + ", alreadyReport=" + ((d) eVar).x);
                        }
                        if (!((d) eVar).x) {
                            q1.a aVar = new q1.a((String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, 262143);
                            aVar.c(String.valueOf(System.currentTimeMillis()));
                            l0 l0Var = ((d) eVar).d;
                            if (l0Var != null && (list2 = l0Var.a) != null) {
                                Iterator it = list2.iterator();
                                while (it.hasNext()) {
                                    String str3 = (String) it.next();
                                    Intrinsics.checkNotNullParameter(aVar, "macro");
                                    Iterator it2 = it;
                                    try {
                                        List<Pair> listListOf = CollectionsKt.listOf(TuplesKt.to("__AEVENTTIME__", aVar.r));
                                        if (str3 == null) {
                                            str3 = "";
                                        } else {
                                            String str4 = str3.length() > 0 ? str3 : null;
                                            if (str4 != null) {
                                                String strReplace$default = str4;
                                                for (Pair pair : listListOf) {
                                                    strReplace$default = StringsKt.replace$default(strReplace$default, (String) pair.component1(), (String) pair.component2(), false, 4, (Object) null);
                                                }
                                                if (strReplace$default != null) {
                                                    str3 = strReplace$default;
                                                } else {
                                                    str3 = "";
                                                }
                                            } else {
                                                str3 = "";
                                            }
                                        }
                                    } catch (Throwable unused) {
                                        if (str3 == null) {
                                            str3 = "";
                                        }
                                    }
                                    s3 s3Var = new s3(str3);
                                    s3Var.a = 5;
                                    String strV = eVar.v();
                                    Intrinsics.checkNotNullExpressionValue(strV, "ads.slotId");
                                    s3Var.d(strV);
                                    String strD = eVar.d();
                                    Intrinsics.checkNotNullExpressionValue(strD, "ads.adCodeId");
                                    s3Var.a(strD);
                                    String str5 = ((d) eVar).k;
                                    Intrinsics.checkNotNullExpressionValue(str5, "ads.adId");
                                    s3Var.b(str5);
                                    String str6 = ((d) eVar).p;
                                    Intrinsics.checkNotNullExpressionValue(str6, "ads.requestId");
                                    s3Var.c(str6);
                                    Map mapO = eVar.o();
                                    if (mapO != null) {
                                        s3Var.a(mapO);
                                    }
                                    s3Var.a(x5.a);
                                    it = it2;
                                }
                            }
                            ((d) eVar).x = true;
                            n0 n0VarI = eVar.I();
                            n0VarI.a("destroy", Boolean.valueOf(eVar.X));
                            n0VarI.u = eVar.j();
                            f fVar = ((d) eVar).g;
                            if (fVar == null || (str2 = fVar.c) == null) {
                                str2 = "";
                            }
                            n0VarI.w = str2;
                            n0VarI.a("dtype", Integer.valueOf(i2));
                            n0VarI.a("fromplg", Boolean.valueOf(z2));
                            n0VarI.a("calledmedia", Boolean.valueOf(eVar.Y));
                            Intrinsics.checkNotNullExpressionValue(n0VarI, "params");
                            Intrinsics.checkNotNullParameter(n0VarI, "params");
                            Intrinsics.checkNotNullParameter("sdk_ad_deep_suc", b.k);
                            Intrinsics.checkNotNullParameter(n0VarI, "params");
                            o0.t.a().a("sdk_ad_deep_suc", n0VarI);
                        }
                    } catch (Throwable th) {
                        d9.d.a(th);
                    }
                }
            } else {
                e eVar2 = this.g;
                if (eVar2 != null) {
                    try {
                        if (!((d) eVar2).y) {
                            q1.a aVar2 = new q1.a((String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, 262143);
                            aVar2.c(String.valueOf(System.currentTimeMillis()));
                            l0 l0Var2 = ((d) eVar2).d;
                            if (l0Var2 != null && (list = l0Var2.b) != null) {
                                for (String str7 : list) {
                                    Intrinsics.checkNotNullParameter(aVar2, "macro");
                                    try {
                                        List<Pair> listListOf2 = CollectionsKt.listOf(TuplesKt.to("__AEVENTTIME__", aVar2.r));
                                        if (str7 == null) {
                                            str7 = "";
                                        } else {
                                            String str8 = str7.length() > 0 ? str7 : null;
                                            if (str8 != null) {
                                                String strReplace$default2 = str8;
                                                for (Pair pair2 : listListOf2) {
                                                    strReplace$default2 = StringsKt.replace$default(strReplace$default2, (String) pair2.component1(), (String) pair2.component2(), false, 4, (Object) null);
                                                }
                                                if (strReplace$default2 != null) {
                                                    str7 = strReplace$default2;
                                                } else {
                                                    str7 = "";
                                                }
                                            } else {
                                                str7 = "";
                                            }
                                        }
                                    } catch (Throwable unused2) {
                                        if (str7 == null) {
                                            str7 = "";
                                        }
                                    }
                                    s3 s3Var2 = new s3(str7);
                                    s3Var2.a = 21;
                                    String strV2 = eVar2.v();
                                    Intrinsics.checkNotNullExpressionValue(strV2, "ads.slotId");
                                    s3Var2.d(strV2);
                                    String strD2 = eVar2.d();
                                    Intrinsics.checkNotNullExpressionValue(strD2, "ads.adCodeId");
                                    s3Var2.a(strD2);
                                    String str9 = ((d) eVar2).k;
                                    Intrinsics.checkNotNullExpressionValue(str9, "ads.adId");
                                    s3Var2.b(str9);
                                    String str10 = ((d) eVar2).p;
                                    Intrinsics.checkNotNullExpressionValue(str10, "ads.requestId");
                                    s3Var2.c(str10);
                                    Map mapO2 = eVar2.o();
                                    if (mapO2 != null) {
                                        s3Var2.a(mapO2);
                                    }
                                    s3Var2.a(y5.a);
                                }
                            }
                            ((d) eVar2).y = true;
                            n0 n0VarI2 = eVar2.I();
                            n0VarI2.g = i;
                            n0VarI2.u = eVar2.j();
                            f fVar2 = ((d) eVar2).g;
                            if (fVar2 == null || (str = fVar2.c) == null) {
                                str = "";
                            }
                            n0VarI2.w = str;
                            n0VarI2.v = y6.g.a();
                            n0VarI2.a("destroy", Boolean.valueOf(eVar2.X));
                            Intrinsics.checkNotNullExpressionValue(n0VarI2, "params");
                            Intrinsics.checkNotNullParameter(n0VarI2, "params");
                            Intrinsics.checkNotNullParameter("sdk_ad_deep_fail", b.k);
                            Intrinsics.checkNotNullParameter(n0VarI2, "params");
                            o0.t.a().a("sdk_ad_deep_fail", n0VarI2);
                        }
                    } catch (Throwable th2) {
                        d9.d.a(th2);
                    }
                }
            }
        }
        this.k = true;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.e;
        d9 d9Var = d9.d;
        if (d9.a) {
            d9Var.a("onActivityResult requestCode=" + i + ", resultCode=" + i2 + ", isBackground=" + this.b + ", time=" + jElapsedRealtime);
        }
        if (i == this.f40304a) {
            this.d = true;
            a(jElapsedRealtime <= ((long) 50), 1003, 0);
        }
        if (isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x025f, code lost:
    
        a(false, 1002, 0);
        finish();
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(@Nullable Bundle bundle) {
        p3 p3Var;
        String str;
        ActivityInfo activityInfo;
        f fVar;
        String packageName;
        e eVar;
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("get_info_key", 0);
        if (intExtra == 0) {
            finish();
            return;
        }
        e5 e5Var = e5.f;
        String str2 = null;
        try {
            p3Var = (p3) e5.e.get(intExtra);
        } catch (Throwable th) {
            d9.d.a(th);
            p3Var = null;
        }
        this.c = p3Var;
        this.g = e5.f.a(intExtra, true);
        try {
            e5.e.remove(intExtra);
        } catch (Throwable th2) {
            d9.d.a(th2);
        }
        String stringExtra = getIntent().getStringExtra("dp_url");
        String stringExtra2 = getIntent().getStringExtra("pkg_name");
        try {
            boolean booleanExtra = getIntent().getBooleanExtra("key_sy_from_plg", false);
            this.n = booleanExtra;
            if (booleanExtra && (eVar = this.g) != null) {
                this.o = new JSONObject(((d) eVar).l);
                ((d) eVar).l = null;
            }
        } catch (Throwable th3) {
            d9.d.a(th3);
        }
        this.f = getIntent().getStringExtra("caller_pkg_name");
        d9 d9Var = d9.d;
        if (d9.a) {
            d9Var.a("frompg=" + this.n + ", dpUrl=" + stringExtra + ", pkgName=" + stringExtra2 + ", mCallerPkgName=" + this.f);
        }
        if (stringExtra == null || stringExtra.length() == 0) {
            if (stringExtra2 == null || stringExtra2.length() == 0) {
                a(false, 1000, 0);
                finish();
                return;
            }
        }
        this.b = false;
        if (TextUtils.isEmpty(stringExtra)) {
            if (TextUtils.isEmpty(stringExtra2)) {
                a(false, 1000, 0);
                finish();
                return;
            }
            Intrinsics.checkNotNull(stringExtra2);
            try {
                Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(stringExtra2);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.addFlags(32768);
                    launchIntentForPackage.addFlags(268435456);
                    this.h = true;
                    if (a(false, null)) {
                        this.m = SystemClock.elapsedRealtime();
                        this.l = true;
                    } else {
                        startActivity(launchIntentForPackage);
                    }
                } else {
                    a(false, 1002, 0);
                    finish();
                }
            } catch (Throwable th4) {
                d9.d.a(th4);
                a(false, 1002, 0);
                finish();
            }
            return;
        }
        Intrinsics.checkNotNull(stringExtra);
        try {
            if (d9.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("getIntentPkgName=");
                if (TextUtils.isEmpty(this.f)) {
                    packageName = getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "this.packageName");
                } else {
                    packageName = this.f;
                    Intrinsics.checkNotNull(packageName);
                }
                sb.append(packageName);
                d9Var.a(sb.toString());
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringExtra));
            intent.addFlags(32768);
            intent.addFlags(268435456);
            PackageManager packageManager = getPackageManager();
            ResolveInfo resolveInfoResolveActivity = Build.VERSION.SDK_INT >= 33 ? packageManager.resolveActivity(intent, PackageManager.ResolveInfoFlags.of(0L)) : packageManager.resolveActivity(intent, 0);
            x6 x6Var = x6.g;
            e eVar2 = this.g;
            String strD = x6Var.d(this, (eVar2 == null || (fVar = ((d) eVar2).g) == null) ? null : fVar.c);
            e eVar3 = this.g;
            String string = resolveInfoResolveActivity != null ? resolveInfoResolveActivity.toString() : null;
            boolean z = packageManager == null;
            boolean z2 = this.n;
            if (eVar3 != null) {
                try {
                    n0 n0VarI = eVar3.I();
                    n0VarI.u = eVar3.j();
                    f fVar2 = ((d) eVar3).g;
                    if (fVar2 == null || (str = fVar2.c) == null) {
                        str = "";
                    }
                    n0VarI.a("pkgname", str);
                    if (string == null) {
                        string = "";
                    }
                    n0VarI.a("found", string);
                    if (strD == null) {
                        strD = "";
                    }
                    n0VarI.a("dpappversion", strD);
                    n0VarI.a("ctxempty", Boolean.FALSE);
                    n0VarI.a("pkgempty", Boolean.valueOf(z));
                    n0VarI.a("fromplg", Boolean.valueOf(z2));
                    n0VarI.v = y6.g.a();
                    Intrinsics.checkNotNullExpressionValue(n0VarI, "params");
                    Intrinsics.checkNotNullParameter("sdk_ad_deep_parse", b.k);
                    Intrinsics.checkNotNullParameter(n0VarI, "params");
                    o0.t.a().a("sdk_ad_deep_parse", n0VarI);
                } catch (Throwable th5) {
                    d9.d.a(th5);
                }
            }
            if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
                str2 = activityInfo.packageName;
            }
            if (d9.a) {
                d9Var.a("openDeeplink info=" + resolveInfoResolveActivity);
            }
            if (resolveInfoResolveActivity != null) {
                this.h = true;
                if (!a(true, str2)) {
                    startActivity(intent);
                    return;
                } else {
                    this.m = SystemClock.elapsedRealtime();
                    this.l = true;
                    return;
                }
            }
        } catch (Throwable th6) {
            d9.d.a(th6);
        }
        a(false, 1001, 0);
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            this.g = null;
            this.o = null;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        d9 d9Var = d9.d;
        if (d9.a) {
            d9Var.a("onPause start");
        }
        super.onPause();
        this.e = SystemClock.elapsedRealtime();
        this.b = true;
        this.i = true;
        if (d9.a) {
            d9Var.a("onPause end");
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x006b  */
    @Override // android.app.Activity
    public void onResume() {
        boolean z;
        d9 d9Var = d9.d;
        if (d9.a) {
            d9Var.a("onResume start");
        }
        long j = y.z.a().m;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (d9.a) {
            d9Var.a("encdptime=" + j + ", callsuc=" + this.l + ", sucts=" + this.m + ", cost=" + (jElapsedRealtime - this.m));
        }
        if (j > 0 && this.l) {
            long j2 = this.m;
            if (j2 > 0 && jElapsedRealtime - j2 >= j) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (d9.a) {
            d9Var.a("dcall=" + this.h + ", pause=" + this.i + ", stopped=" + this.j + ", encDpSuc=" + z);
        }
        super.onResume();
        if (this.h && this.i) {
            if (!this.j) {
                if (z) {
                    d9Var.a("enter encdp");
                    this.m = 0L;
                    if (this.c != null) {
                        a(true, 0, 1);
                    }
                } else if (this.c != null) {
                    a(false, 1004, 0);
                }
            }
            if (!isFinishing()) {
                finish();
            }
        }
        if (d9.a) {
            d9Var.a("onResume end");
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        d9 d9Var = d9.d;
        if (d9.a) {
            d9Var.a("onStop start");
        }
        super.onStop();
        if (d9.a) {
            d9Var.a("onStop end");
        }
        try {
            this.j = true;
            a(true ^ this.d, 1003, 0);
            if (!this.h || isFinishing()) {
                return;
            }
            finish();
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public final boolean a(boolean z, String str) {
        boolean zOpenOnly;
        try {
            if (this.g == null) {
                return false;
            }
            boolean z2 = this.n;
            if (z2 && this.o == null) {
                return false;
            }
            if (!z2) {
                Boolean bool = (Boolean) f3.a(f3.b, this, "allow_call_remote_open_only", Boolean.FALSE, (String) null, 8);
                if (!(bool != null ? bool.booleanValue() : false)) {
                    return false;
                }
            }
            IRemoteOpen remoteOpen = AdPluginProxy.getRemoteOpen();
            if (remoteOpen != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("hddp", Boolean.valueOf(y.z.a().i));
                if (str == null) {
                    str = "";
                }
                linkedHashMap.put("targetPkg", str);
                if (this.n) {
                    JSONObject jSONObject = this.o;
                    Intrinsics.checkNotNull(jSONObject);
                    zOpenOnly = remoteOpen.openOnly(this, jSONObject, z, linkedHashMap);
                } else {
                    e eVar = this.g;
                    Intrinsics.checkNotNull(eVar);
                    String str2 = ((d) eVar).l;
                    Intrinsics.checkNotNullExpressionValue(str2, "mAdsBean!!.originData");
                    zOpenOnly = remoteOpen.openOnly(this, str2, z, linkedHashMap);
                }
                d9 d9Var = d9.d;
                if (d9.a) {
                    d9Var.a("call remoteOpenOnly result=" + zOpenOnly);
                }
                return zOpenOnly;
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
        return false;
    }
}
