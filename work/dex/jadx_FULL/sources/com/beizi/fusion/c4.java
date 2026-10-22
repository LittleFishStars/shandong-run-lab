package com.beizi.fusion;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.aliyun.auth.core.AliyunVodKey;
import com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.v2.activity.BeiZiLandingPageActivity;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.zj.adlib.u15;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c4 implements mi {
    public static c4 w0;
    private boolean A;
    private e5 B;
    private View C;
    private List D;
    private ji E;
    private View.OnClickListener F;
    private long H;
    private int I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private x1.b.C0333b U;
    private x1.b.a V;
    private boolean W;
    private boolean X;
    private int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private mi.a f27122a;
    private String b;
    private String c;
    private String d;
    private nh e0;
    private String f;
    private int f0;
    private String g;
    private String g0;
    private String h;
    private String h0;
    private x1.b i;
    private String i0;
    private String j;
    private kj j0;
    private double k;
    private boolean k0;
    private String l;
    private List l0;
    private String m;
    private gp m0;
    private String n;
    private boolean n0;
    private HashMap o;
    private String o0;
    private String p0;
    private boolean q0;
    private int r0;
    private int s0;
    private uk t0;
    private int u0;
    private f5 v0;
    private on.e x;
    private on.e y;
    private String z;
    private ArrayList e = new ArrayList();
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private ArrayList s = new ArrayList();
    private ArrayList t = new ArrayList();
    private ArrayList u = new ArrayList();
    private ArrayList v = new ArrayList();
    private ArrayList w = new ArrayList();
    private String G = "";
    private int Y = 0;
    private boolean a0 = true;
    private boolean b0 = false;
    private long c0 = System.currentTimeMillis();
    private boolean d0 = true;

    public class a implements yn {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27123a;

        public a(View view) {
            this.f27123a = view;
        }

        @Override // com.beizi.fusion.yn
        public void a() {
            ArrayList arrayList = c4.this.v;
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            ArrayList arrayList2 = c4.this.v;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                new zn(c4.this.a((String) obj, this.f27123a)).b();
            }
            c4.this.v = null;
        }
    }

    public class b implements GestureDetector.OnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27124a;

        public b(View view) {
            this.f27124a = view;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c4.this.H = System.currentTimeMillis();
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (c4.this.w != null) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                ArrayList arrayList = c4.this.w;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    String strA = pp.a((String) obj, x + "", y + "", rawX + "", rawY + "", String.valueOf(c4.this.H), String.valueOf(System.currentTimeMillis()), "", 0, c4.this.u0);
                    if (!TextUtils.isEmpty(c4.this.G)) {
                        strA = strA.replace("__REQUESTUUID__", c4.this.G);
                    }
                    if (c4.this.A) {
                        strA = strA.replace(uo.b, "1");
                    }
                    new h5(po.a(this.f27124a, strA)).execute(new Void[0]);
                }
            }
            c4.this.w = null;
            return false;
        }
    }

    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f27125a;

        public c(GestureDetector gestureDetector) {
            this.f27125a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f27125a.onTouchEvent(motionEvent);
        }
    }

    public class d implements GestureDetector.OnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f27126a;

        public d(View view) {
            this.f27126a = view;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c4.this.H = System.currentTimeMillis();
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (c4.this.w != null) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                ArrayList arrayList = c4.this.w;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    String strA = pp.a((String) obj, x + "", y + "", rawX + "", rawY + "", String.valueOf(c4.this.H), String.valueOf(System.currentTimeMillis()), "", 0, c4.this.u0);
                    if (!TextUtils.isEmpty(c4.this.G)) {
                        strA = strA.replace("__REQUESTUUID__", c4.this.G);
                    }
                    if (c4.this.A) {
                        strA = strA.replace(uo.b, "1");
                    }
                    new h5(po.a(this.f27126a, strA)).execute(new Void[0]);
                }
            }
            c4.this.w = null;
            return false;
        }
    }

    public class e implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f27127a;

        public e(GestureDetector gestureDetector) {
            this.f27127a = gestureDetector;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f27127a.onTouchEvent(motionEvent);
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ArrayList arrayList = c4.this.w;
                if (arrayList != null) {
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        String str = (String) obj;
                        kh.a("lance", "setClickListener:" + str);
                        new h5(str).execute(new Void[0]);
                    }
                }
                Context context = view.getContext();
                View rootView = view.getRootView();
                if (rootView != null) {
                    context = rootView.getContext();
                }
                c4 c4Var = c4.this;
                c4Var.Y = 0;
                c4Var.a(c4Var.h, c4Var.g, context);
                ji jiVar = c4.this.E;
                if (jiVar != null) {
                    jiVar.a();
                }
                c4.this.w = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class g implements m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27129a;

        public g(Context context) {
            this.f27129a = context;
        }

        @Override // com.beizi.fusion.m1
        public void a() {
            try {
                x1.b.C0333b c0333b = c4.this.U;
                if (c0333b != null) {
                    List listK = c0333b.k();
                    c4.this.U.q(null);
                    bm.a(listK);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.beizi.fusion.m1
        public void b() {
            try {
                if (c4.this.d0) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    c4 c4Var = c4.this;
                    if (jCurrentTimeMillis - c4Var.c0 > 2000) {
                        return;
                    }
                    x1.b.C0333b c0333b = c4Var.U;
                    if (c0333b != null) {
                        List listJ = c0333b.j();
                        c4.this.U.p(null);
                        bm.a(listJ);
                    }
                    c4 c4Var2 = c4.this;
                    c4Var2.a(c4Var2.g, this.f27129a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class h implements m1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27130a;
        final /* synthetic */ Context b;

        public h(int i, Context context) {
            this.f27130a = i;
            this.b = context;
        }

        @Override // com.beizi.fusion.m1
        public void a() {
        }

        @Override // com.beizi.fusion.m1
        public void b() {
            try {
                if (this.f27130a == 0) {
                    c4 c4Var = c4.this;
                    c4Var.d0 = true;
                    c4Var.b(this.b);
                }
            } catch (Exception unused) {
                c4 c4Var2 = c4.this;
                c4Var2.d0 = false;
                x1.b.C0333b c0333b = c4Var2.U;
                if (c0333b != null) {
                    List listC = c0333b.c();
                    c4.this.U.e(null);
                    bm.a(listC);
                }
                c4 c4Var3 = c4.this;
                c4Var3.a(this.b, c4Var3.g);
            }
        }
    }

    private void B() {
        this.F = new f();
    }

    private boolean w() {
        oh ohVarD;
        try {
            f5 f5Var = this.v0;
            if (f5Var == null || (ohVarD = f5Var.d()) == null) {
                return false;
            }
            int iE = ohVarD.e();
            return iE == 1 || iE == 2;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean x() {
        int i = this.I;
        if (i == 2) {
            return !TextUtils.isEmpty(this.M) && this.M.startsWith("http");
        }
        return i == 5 && !TextUtils.isEmpty(this.M);
    }

    private boolean y() {
        if (TextUtils.isEmpty(this.J) || TextUtils.isEmpty(this.O) || TextUtils.isEmpty(this.N) || TextUtils.isEmpty(this.R) || TextUtils.isEmpty(this.T)) {
            return false;
        }
        if (TextUtils.isEmpty(this.Q) && TextUtils.isEmpty(this.P)) {
            return false;
        }
        int i = this.I;
        return i == 2 || i == 5;
    }

    public boolean A() {
        return this.n0;
    }

    public void a(on.e eVar) {
        this.y = eVar;
    }

    public void b(on.e eVar) {
        this.x = eVar;
    }

    @Override // com.beizi.fusion.mi
    public String c() {
        return this.g;
    }

    @Override // com.beizi.fusion.mi
    public String d() {
        return this.c;
    }

    @Override // com.beizi.fusion.mi
    public void destroy() {
        e5 e5Var = this.B;
        if (e5Var != null) {
            e5Var.a();
        }
        this.p = true;
        this.C = null;
        this.D = null;
        this.E = null;
        r();
    }

    public void e(String str) {
        this.G = str;
    }

    @Override // com.beizi.fusion.mi
    public boolean f() {
        return this.p;
    }

    @Override // com.beizi.fusion.mi
    public String g() {
        return this.p0;
    }

    @Override // com.beizi.fusion.mi
    public String getAppName() {
        return this.i0;
    }

    @Override // com.beizi.fusion.mi
    public String getIconUrl() {
        return this.f;
    }

    @Override // com.beizi.fusion.mi
    public String getImageUrl() {
        return this.d;
    }

    @Override // com.beizi.fusion.mi
    public boolean h() {
        return this.q0;
    }

    @Override // com.beizi.fusion.mi
    public String i() {
        return TextUtils.isEmpty(this.g0) ? "0" : this.g0;
    }

    @Override // com.beizi.fusion.mi
    public ArrayList j() {
        return this.s;
    }

    @Override // com.beizi.fusion.mi
    public String k() {
        return this.j;
    }

    @Override // com.beizi.fusion.mi
    public ArrayList l() {
        return this.u;
    }

    @Override // com.beizi.fusion.mi
    public int m() {
        return this.r0;
    }

    @Override // com.beizi.fusion.mi
    public on.e n() {
        return this.y;
    }

    @Override // com.beizi.fusion.mi
    public int o() {
        return this.s0;
    }

    @Override // com.beizi.fusion.mi
    public ApkBean p() {
        int i = this.I;
        if (i != 2 && i != 5) {
            return null;
        }
        ApkBean apkBean = new ApkBean();
        apkBean.setApkName(this.J);
        apkBean.setAppVersion(this.N);
        apkBean.setAppDeveloper(this.O);
        apkBean.setAppPermissionsDesc(this.P);
        apkBean.setAppPermissionsUrl(this.Q);
        apkBean.setAppPrivacyUrl(this.R);
        apkBean.setAppintro(this.T);
        apkBean.setPkgName(this.K);
        return apkBean;
    }

    @Override // com.beizi.fusion.mi
    public String q() {
        return this.o0;
    }

    public void r() {
        w0 = null;
    }

    public List s() {
        return this.l0;
    }

    public int t() {
        return this.Y;
    }

    public kj u() {
        return this.j0;
    }

    public gp v() {
        return this.m0;
    }

    public boolean z() {
        return this.k0;
    }

    public static c4 a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ArrayList arrayListA = ng.a(ng.a(jSONObject, "ImpressionTrackers"));
        c4 c4Var = new c4();
        if (arrayListA != null) {
            c4Var.v = arrayListA;
        }
        c4Var.b = ng.e(jSONObject, "Headline");
        c4Var.c = ng.e(jSONObject, "Body");
        c4Var.d = ng.e(jSONObject, "Image");
        JSONArray jSONArrayA = ng.a(jSONObject, "Images");
        JSONArray jSONArrayA2 = ng.a(jSONObject, "Videos");
        JSONArray jSONArrayA3 = ng.a(jSONObject, "Texts");
        if (jSONArrayA != null) {
            for (int i = 0; i < jSONArrayA.length(); i++) {
                c4Var.s.add((String) jSONArrayA.get(i));
            }
        }
        if (jSONArrayA2 != null) {
            for (int i2 = 0; i2 < jSONArrayA2.length(); i2++) {
                c4Var.t.add((String) jSONArrayA2.get(i2));
            }
        }
        if (jSONArrayA3 != null) {
            for (int i3 = 0; i3 < jSONArrayA3.length(); i3++) {
                c4Var.u.add((String) jSONArrayA3.get(i3));
            }
        }
        if (jSONObject.has("AppIcon")) {
            c4Var.f27122a = mi.a.APP_INSTALL;
            c4Var.f = ng.e(jSONObject, "AppIcon");
            c4Var.j = ng.e(jSONObject, AliyunVodKey.KEY_VOD_ACTION);
            c4Var.k = ng.b(jSONObject, "Star");
            c4Var.l = ng.e(jSONObject, "Store");
            c4Var.m = ng.e(jSONObject, "Price");
        } else {
            c4Var.f27122a = mi.a.CONTENT;
            c4Var.f = ng.e(jSONObject, "Logo");
            c4Var.j = ng.e(jSONObject, AliyunVodKey.KEY_VOD_ACTION);
            c4Var.n = ng.e(jSONObject, "Advertiser");
        }
        ArrayList arrayListA2 = ng.a(ng.a(jSONObject, "ClickTrackers"));
        if (arrayListA2 != null) {
            c4Var.w = arrayListA2;
        }
        c4Var.o = ng.a(ng.d(jSONObject, TypedValues.Custom.NAME));
        c4Var.g0 = ng.e(jSONObject, "taskAction");
        c4Var.h0 = ng.e(jSONObject, "packName");
        c4Var.i0 = ng.e(jSONObject, "appName");
        c4Var.o0 = ng.e(jSONObject, VideoPlayerActivity.t);
        c4Var.p0 = ng.e(jSONObject, "lauchImageUrl");
        c4Var.r0 = ng.c(jSONObject, "videoW");
        c4Var.s0 = ng.c(jSONObject, "videoH");
        return c4Var;
    }

    @Override // com.beizi.fusion.mi
    public String b() {
        return this.b;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(String str) {
        this.h = str;
    }

    public void e(boolean z) {
        this.A = z;
    }

    private void c(Context context) {
        this.c0 = System.currentTimeMillis();
        a4.j().a(new g(context));
        if (a(context)) {
            return;
        }
        b(context);
    }

    private boolean d(Context context) {
        x1.b bVar = this.i;
        if (bVar == null) {
            return false;
        }
        try {
            if (bVar.o() == 0) {
                return false;
            }
            String strR = this.i.r();
            String strS = this.i.s();
            String strQ = this.i.q();
            if (!TextUtils.isEmpty(strR) && !TextUtils.isEmpty(strS)) {
                return hq.a(context, strR, strS, strQ);
            }
            String strW = this.i.w();
            if (!TextUtils.isEmpty(strW)) {
                return hq.a(context, strW);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b(String str) {
        this.v.add(str);
    }

    @Override // com.beizi.fusion.mi
    public String e() {
        return this.h0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        if (context == null) {
            return;
        }
        Uri uri = Uri.parse(this.h);
        if (uri.getScheme() != null && uri.getScheme().equals("bzopen") && !TextUtils.isEmpty(uri.getHost()) && uri.getPathSegments().size() > 0) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.LAUNCHER");
            String queryParameter = uri.getQueryParameter("flags");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    if (!queryParameter.startsWith("0x") && !queryParameter.startsWith("0X")) {
                        intent.setFlags(Integer.parseInt(queryParameter));
                    } else {
                        intent.setFlags(Integer.parseInt(queryParameter.substring(2), 16));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            intent.setComponent(new ComponentName(uri.getHost(), uri.getPathSegments().get(0)));
            String queryParameter2 = uri.getQueryParameter("rect");
            if (!TextUtils.isEmpty(queryParameter2)) {
                try {
                    String[] strArrSplit = queryParameter2.split(u15.f19942b);
                    if (strArrSplit.length == 4) {
                        Rect rect = new Rect();
                        rect.set(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3]));
                        intent.setSourceBounds(rect);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            context.startActivity(intent);
            return;
        }
        if (this.h.startsWith("hwpps://landingpage")) {
            Intent intent2 = new Intent();
            intent2.setData(uri);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
            return;
        }
        if (this.h.startsWith("intent")) {
            Intent uri2 = null;
            try {
                uri2 = Intent.parseUri(this.h, 1);
                uri2.addFlags(268435456);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            context.startActivity(uri2);
            return;
        }
        Intent intent3 = new Intent("android.intent.action.VIEW", uri);
        intent3.addFlags(805339136);
        context.startActivity(intent3);
    }

    public void c(boolean z) {
        this.k0 = z;
    }

    public x1.d c(int i) {
        List list = this.l0;
        if (list != null && !list.isEmpty()) {
            for (x1.d dVar : this.l0) {
                if (dVar.x() == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void d(boolean z) {
        this.n0 = z;
    }

    @Override // com.beizi.fusion.mi
    public boolean a(View view, oi oiVar) {
        if (!this.p && view != null) {
            e5 e5Var = this.B;
            if (e5Var != null) {
                this.C = null;
                e5Var.a();
                this.B = null;
            }
            this.B = new e5(view, oiVar, new a(view));
            this.C = view;
        }
        return false;
    }

    private boolean b(String str, Context context) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    @Override // com.beizi.fusion.mi
    public void b(int i) {
        this.f0 = i;
    }

    public void b(boolean z) {
        this.q0 = z;
    }

    public String a(String str, View view) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.z)) {
            str = str.replace(uo.f27840a, this.z);
        }
        String strReplace = str;
        if (view != null) {
            if (!TextUtils.isEmpty(this.G)) {
                strReplace = strReplace.replace("__REQUESTUUID__", this.G);
            }
            if (this.A) {
                strReplace = strReplace.replace(uo.b, "1");
            }
            return po.a(0, view, strReplace);
        }
        return pp.a(strReplace, "", "", "", "", "", "", "");
    }

    @Override // com.beizi.fusion.mi
    public on.e a() {
        return this.x;
    }

    @Override // com.beizi.fusion.mi
    public boolean a(View view, ji jiVar) {
        if (this.p || view == null) {
            return false;
        }
        this.E = jiVar;
        this.C = view;
        GestureDetector gestureDetector = new GestureDetector(new b(view));
        B();
        view.setOnTouchListener(new c(gestureDetector));
        view.setOnClickListener(this.F);
        return true;
    }

    @Override // com.beizi.fusion.mi
    public boolean a(View view, List list, ji jiVar) {
        if (!a(view, jiVar)) {
            return false;
        }
        if (list == null || list.size() <= 0) {
            return true;
        }
        view.setOnClickListener(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            View view2 = (View) it.next();
            view2.setOnTouchListener(new e(new GestureDetector(new d(view))));
            view2.setOnClickListener(this.F);
        }
        this.D = list;
        return true;
    }

    public void a(x1.b bVar) {
        this.i = bVar;
        this.U = bVar.m();
        this.I = bVar.n();
        this.J = bVar.a();
        this.K = bVar.t();
        this.L = bVar.b();
        this.M = bVar.d();
        if (TextUtils.isEmpty(this.J)) {
            this.J = "BeiZi";
        }
        if (TextUtils.isEmpty(this.L)) {
            this.L = "Ad Download";
        }
        this.N = bVar.i();
        this.O = bVar.c();
        this.P = bVar.f();
        this.Q = bVar.g();
        this.R = bVar.h();
        this.S = bVar.e();
        this.T = bVar.j();
        x1.b.a aVarL = bVar.l();
        this.V = aVarL;
        if (aVarL != null) {
            if (aVarL.a() == 1) {
                this.W = true;
            }
            if (this.V.b() == 1) {
                this.X = true;
            }
            this.Z = this.V.c();
        }
    }

    public void a(String str) {
        this.w.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2, Context context) {
        x1.b.C0333b c0333b;
        x1.b.C0333b c0333b2;
        if (w()) {
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                boolean z = pg.a(context, str) || a8.a(context, this.K) || str.startsWith("hwpps://landingpage") || str.startsWith("intent") || str.startsWith("hap://");
                if (z && (c0333b2 = this.U) != null) {
                    List listF = c0333b2.f();
                    this.U.h(null);
                    bm.a(listF);
                }
                this.d0 = true;
                c(context);
                if (!z && (c0333b = this.U) != null) {
                    List listG = c0333b.g();
                    this.U.i(null);
                    bm.a(listG);
                }
                x1.b.C0333b c0333b3 = this.U;
                if (c0333b3 != null) {
                    List listD = c0333b3.d();
                    this.U.f(null);
                    bm.a(listD);
                }
                return true;
            } catch (Exception unused) {
                this.d0 = false;
                x1.b.C0333b c0333b4 = this.U;
                if (c0333b4 != null) {
                    List listC = c0333b4.c();
                    this.U.e(null);
                    bm.a(listC);
                }
                a(context, str2);
                return true;
            }
        }
        a(context, str2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str) {
        try {
            if (y() && x()) {
                int i = this.I;
                if (i == 2) {
                    if (a8.a(context, this.K)) {
                        a8.b(context, this.K);
                        x1.b.C0333b c0333b = this.U;
                        if (c0333b != null) {
                            List listI = c0333b.i();
                            this.U.l(null);
                            bm.a(listI);
                            return;
                        }
                        return;
                    }
                    a(context, 1);
                    return;
                }
                if (i == 5) {
                    if (pg.a(context, this.M)) {
                        if (!this.X && this.Y != 0) {
                            a(context, 2);
                            return;
                        }
                        b(this.M, context);
                        x1.b.C0333b c0333b2 = this.U;
                        if (c0333b2 != null) {
                            List listI2 = c0333b2.i();
                            this.U.l(null);
                            bm.a(listI2);
                            return;
                        }
                        return;
                    }
                    a(str, context);
                    return;
                }
                return;
            }
            a(str, context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, int i) {
        try {
            File fileF = a8.f(context);
            String absolutePath = fileF != null ? fileF.getAbsolutePath() : "";
            ApkBean apkBean = new ApkBean(this.M, this.K + ".apk", this.K, absolutePath, this.J, this.L, context.getPackageName() + ".bz.fileprovider", this.U, this.N, this.O, this.P, this.Q, this.R, this.S, this.T);
            apkBean.setSendLocalBroadcast(true);
            Bundle bundle = new Bundle();
            bundle.putSerializable("apkBean", apkBean);
            bundle.putInt("type", i);
            bundle.putBoolean("isCanJump", this.W);
            bundle.putBoolean("isDownload", y());
            if (i == 2) {
                x1.b.C0333b c0333b = this.U;
                if (c0333b != null) {
                    bundle.putStringArrayList("openList", (ArrayList) c0333b.i());
                }
                bundle.putString("landingPageUrl", this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
                bundle.putString("deeplinkUrl", this.h);
                bundle.putInt("webDeepLink", this.Z);
            }
            Serializable serializable = this.e0;
            if (serializable != null) {
                bundle.putSerializable("lpOptimizeModule", serializable);
            }
            Intent intent = new Intent(context, (Class<?>) BeiZiDownloadDialogActivity.class);
            intent.putExtra("data", bundle);
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, Context context) {
        if (str != null && !str.isEmpty()) {
            if (d(context)) {
                x1.b.C0333b c0333b = this.U;
                if (c0333b != null) {
                    List listH = c0333b.h();
                    this.U.k(null);
                    bm.a(listH);
                }
                return true;
            }
            if (!this.a0) {
                if (!b(str, context)) {
                    return false;
                }
                ji jiVar = this.E;
                if (jiVar != null) {
                    jiVar.b();
                }
                return true;
            }
            try {
                Intent intent = new Intent(context, (Class<?>) BeiZiLandingPageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("isRedirectionCanJump", this.W);
                bundle.putBoolean("isDownload", y());
                if (!TextUtils.isEmpty(this.h)) {
                    bundle.putBoolean("webDeepLink", this.Z == 1);
                    bundle.putString("deeplinkUrl", this.h);
                }
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString("landingPageUrl", str);
                }
                x1.b.C0333b c0333b2 = this.U;
                if (c0333b2 != null) {
                    bundle.putSerializable("followTrackExt", c0333b2);
                }
                nh nhVar = this.e0;
                if (nhVar != null) {
                    bundle.putSerializable("lpOptimizeModule", nhVar);
                }
                intent.putExtra("data", bundle);
                intent.setFlags(268435456);
                context.startActivity(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.beizi.fusion.mi
    public void a(View view, String str, String str2, String str3, String str4, int i, ji jiVar) {
        try {
            this.Y = i;
            ArrayList arrayList = this.w;
            if (arrayList != null) {
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    int i3 = i2 + 1;
                    String strA = pp.a((String) arrayList.get(i2), str + "", str2 + "", str3 + "", str4 + "", String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()), "", i, this.u0);
                    if (!TextUtils.isEmpty(this.G)) {
                        strA = strA.replace("__REQUESTUUID__", this.G);
                    }
                    if (this.A) {
                        strA = strA.replace(uo.b, "1");
                    }
                    new h5(po.a(view, strA)).execute(new Void[0]);
                    i2 = i3;
                }
            }
            this.w = null;
            Context context = view.getContext();
            View rootView = view.getRootView();
            if (rootView != null) {
                context = rootView.getContext();
            }
            a(this.h, this.g, context);
            if (jiVar != null) {
                jiVar.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z) {
        this.d0 = z;
    }

    public void a(nh nhVar) {
        this.e0 = nhVar;
    }

    public void a(kj kjVar) {
        this.j0 = kjVar;
    }

    public void a(List list) {
        this.l0 = list;
    }

    public void a(x1.d dVar, View view) {
        x1.b bVarL;
        String strG;
        if (dVar == null || (bVarL = dVar.l()) == null) {
            return;
        }
        dVar.b(true);
        List listV = bVarL.v();
        if (listV != null) {
            for (int i = 0; i < listV.size(); i++) {
                x1.h hVar = (x1.h) listV.get(i);
                if (hVar != null && !TextUtils.isEmpty(hVar.g()) && view != null) {
                    if (!TextUtils.isEmpty(this.G)) {
                        strG = hVar.g().replace("__REQUESTUUID__", this.G);
                    } else {
                        strG = hVar.g();
                    }
                    if (!TextUtils.isEmpty(this.z)) {
                        strG = strG.replace(uo.f27840a, this.z);
                    }
                    if (this.A) {
                        strG = strG.replace(uo.b, "1");
                    }
                    new h5(po.a(0, view, strG)).executeOnExecutor(w3.c().g(), new Void[0]);
                }
                hVar.j(null);
            }
        }
    }

    public void a(x1.d dVar, View view, g5 g5Var, String str, String str2, int i) {
        String strA;
        x1.b bVarL = dVar.l();
        if (bVarL == null) {
            return;
        }
        dVar.a(true);
        List listV = bVarL.v();
        if (listV != null) {
            for (int i2 = 0; i2 < listV.size(); i2++) {
                x1.h hVar = (x1.h) listV.get(i2);
                if (hVar != null && !TextUtils.isEmpty(hVar.a())) {
                    if (!TextUtils.isEmpty(this.G)) {
                        strA = pp.a(hVar.a(), g5Var, str, str2, "", i).replace("__REQUESTUUID__", this.G);
                    } else {
                        strA = pp.a(hVar.a(), g5Var, str, str2, "", i);
                    }
                    if (this.A) {
                        strA = strA.replace(uo.b, "1");
                    }
                    new h5(po.a(view, strA)).executeOnExecutor(w3.c().g(), new Void[0]);
                }
                hVar.a(null);
            }
        }
    }

    public void a(gp gpVar) {
        this.m0 = gpVar;
    }

    public void a(uk ukVar) {
        this.t0 = ukVar;
    }

    private boolean a(Context context) {
        try {
            uk ukVar = this.t0;
            if (ukVar == null) {
                return false;
            }
            String strC = ukVar.c();
            String strB = this.t0.b();
            int iA = this.t0.a();
            if (TextUtils.isEmpty(strC) || TextUtils.isEmpty(strB) || !a4.j().p()) {
                return false;
            }
            String strA = h3.a(strC);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            new zh().a(this.h, strA, strB, new h(iA, context));
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.beizi.fusion.mi
    public void a(int i) {
        this.u0 = i;
    }

    public void a(f5 f5Var) {
        this.v0 = f5Var;
    }
}
