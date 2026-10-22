package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {
    private static final String TAG = "c";
    public final String Nt;
    public final boolean aGw;
    public final boolean bdA;
    public final boolean bdB;
    public final com.kwad.sdk.crash.model.c bdE;
    public final com.kwad.sdk.crash.model.a bdF;
    public final h bdG;
    public final String[] bdH;
    public final String[] bdI;
    public final boolean bdJ;
    public final f bdK;
    public final String bdL;
    public final String bdM;
    public final String bdN;
    public final String bdO;
    public final String bdP;
    public final String bdQ;
    public final String bdR;
    public final String bdS;
    public final String bdT;
    public final List<com.kwad.sdk.crash.a> bdU;
    public final double bdv;
    public final String channel;
    public final Context context;
    public final String platform;
    public final String sdkVersion;

    public static class a {
        private String Nt;
        private int aWw;
        private String appId;
        private String appName;
        private String appPackageName;
        private String appVersion;
        private f bdK;
        private String bdL;
        private String bdM;
        private String bdN;
        private String bdO;
        private String bdP;
        private String bdV;
        private h bdW;
        private String[] bdX;
        public String[] bdY;
        private String channel;
        private Context context;
        private String platform;
        private String sdkApiVersion;
        private int sdkApiVersionCode;
        public int sdkType;
        private String sdkVersion;
        private boolean bdJ = false;
        private boolean bdA = false;
        private boolean bdB = false;
        private boolean aGw = false;
        private String bdQ = "";
        private String bdR = "";
        private String bdS = "";
        private String bdT = "";
        private List<com.kwad.sdk.crash.a> bdU = new ArrayList();
        private double bdv = 1.0d;

        public final a N(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        com.kwad.sdk.crash.a aVar = new com.kwad.sdk.crash.a();
                        aVar.parseJson(jSONObject);
                        this.bdU.add(aVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.w(c.TAG, Log.getStackTraceString(e));
                    }
                }
            }
            return this;
        }

        public final c Qc() {
            return new c(this, (byte) 0);
        }

        public final a bW(boolean z) {
            this.bdA = z;
            return this;
        }

        public final a bX(boolean z) {
            this.bdB = z;
            return this;
        }

        public final a bY(boolean z) {
            this.aGw = z;
            return this;
        }

        public final a cw(Context context) {
            this.context = context;
            return this;
        }

        public final a eV(int i) {
            this.aWw = i;
            return this;
        }

        public final a eW(int i) {
            this.sdkApiVersionCode = i;
            return this;
        }

        public final a eX(int i) {
            this.sdkType = 1;
            return this;
        }

        public final a fW(String str) {
            this.bdQ = str;
            return this;
        }

        public final a fX(String str) {
            this.bdR = str;
            return this;
        }

        public final a fY(String str) {
            this.platform = str;
            return this;
        }

        public final a fZ(String str) {
            this.bdL = str;
            return this;
        }

        public final a ga(String str) {
            this.Nt = str;
            return this;
        }

        public final a gb(String str) {
            this.channel = str;
            return this;
        }

        public final a gc(String str) {
            this.bdP = str;
            return this;
        }

        public final a gd(String str) {
            this.bdV = str;
            return this;
        }

        public final a ge(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a gf(String str) {
            this.sdkApiVersion = str;
            return this;
        }

        public final a gg(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a gh(String str) {
            this.appId = str;
            return this;
        }

        public final a gi(String str) {
            this.appName = str;
            return this;
        }

        public final a gj(String str) {
            this.appVersion = str;
            return this;
        }

        public final a gk(String str) {
            this.bdM = str;
            return this;
        }

        public final a gl(String str) {
            this.bdN = str;
            return this;
        }

        public final a gm(String str) {
            this.bdS = str;
            return this;
        }

        public final a gn(String str) {
            this.bdT = str;
            return this;
        }

        public final a a(f fVar) {
            this.bdK = fVar;
            return this;
        }

        public final a d(String[] strArr) {
            this.bdX = strArr;
            return this;
        }

        public final a e(String[] strArr) {
            this.bdY = strArr;
            return this;
        }

        public final a k(double d) {
            this.bdv = d;
            return this;
        }

        public final a a(h hVar) {
            this.bdW = hVar;
            return this;
        }
    }

    public /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final f Qa() {
        return this.bdK;
    }

    public final boolean isDebugMode() {
        return this.bdJ;
    }

    private c(a aVar) {
        com.kwad.sdk.crash.model.c cVar = new com.kwad.sdk.crash.model.c();
        this.bdE = cVar;
        com.kwad.sdk.crash.model.a aVar2 = new com.kwad.sdk.crash.model.a();
        this.bdF = aVar2;
        ArrayList arrayList = new ArrayList();
        this.bdU = arrayList;
        this.bdJ = aVar.bdJ;
        this.bdA = aVar.bdA;
        this.bdB = aVar.bdB;
        this.aGw = aVar.aGw;
        this.bdQ = aVar.bdQ;
        this.bdR = aVar.bdR;
        this.bdS = aVar.bdS;
        this.bdT = aVar.bdT;
        this.context = aVar.context;
        this.bdK = aVar.bdK;
        this.platform = aVar.platform;
        this.bdL = aVar.bdL;
        this.bdM = aVar.bdM;
        this.bdN = aVar.bdN;
        this.sdkVersion = aVar.sdkVersion;
        this.Nt = aVar.Nt;
        this.channel = aVar.channel;
        this.bdO = aVar.bdO;
        this.bdP = aVar.bdP;
        aVar2.mAppId = aVar.appId;
        aVar2.mAppName = aVar.appName;
        aVar2.beC = aVar.appVersion;
        aVar2.beB = aVar.appPackageName;
        cVar.beM = aVar.sdkApiVersion;
        cVar.beN = aVar.sdkApiVersionCode;
        cVar.mSdkVersion = aVar.sdkVersion;
        cVar.beL = aVar.aWw;
        cVar.beK = aVar.bdV;
        cVar.beO = aVar.sdkType;
        this.bdG = aVar.bdW;
        this.bdH = aVar.bdX;
        this.bdI = aVar.bdY;
        arrayList.addAll(aVar.bdU);
        this.bdv = aVar.bdv;
    }
}
