package com.kuaishou.weapon.p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class o {
    public static s a(JSONObject jSONObject) {
        p pVarB = b(jSONObject);
        if (pVarB == null) {
            return null;
        }
        int iA = pVarB.a();
        String strL = pVarB.l();
        String strJ = pVarB.j();
        boolean z = pVarB.d() == 1;
        boolean z2 = pVarB.h() == 1;
        int iE = pVarB.e();
        String strC = pVarB.c();
        String strF = pVarB.f();
        String strB = pVarB.b();
        PackageInfo packageInfo = new PackageInfo();
        try {
            packageInfo.packageName = strF;
            packageInfo.versionName = strL;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            if (!TextUtils.isEmpty(strF) && !TextUtils.isEmpty(strB) && strB.startsWith(Consts.DOT)) {
                applicationInfo.name = strF + strB;
                applicationInfo.className = strF + strB;
            }
            applicationInfo.theme = pVarB.i();
            packageInfo.applicationInfo = applicationInfo;
            List<p.a> listM = pVarB.m();
            if (listM != null && listM.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < listM.size(); i++) {
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.name = listM.get(i).c();
                    activityInfo.theme = listM.get(i).b();
                    activityInfo.labelRes = listM.get(i).a();
                    if (!TextUtils.isEmpty(activityInfo.name)) {
                        arrayList.add(activityInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
        } catch (Throwable unused) {
        }
        s sVar = new s(packageInfo, iA, strF, strL, strJ, strC);
        sVar.v = z;
        sVar.x = iE;
        int iA2 = pVarB.k() == null ? 0 : pVarB.k().a();
        int iB = pVarB.k() == null ? -1 : pVarB.k().b();
        sVar.t = iA2;
        sVar.u = iB;
        sVar.s = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT > 29 && z2) {
            z2 = pVarB.g() == 1;
        }
        sVar.y = z2;
        return sVar;
    }

    private static p b(JSONObject jSONObject) {
        try {
            p pVar = new p();
            pVar.a(jSONObject.optInt("wk"));
            pVar.a(jSONObject.optString("wan"));
            pVar.b(jSONObject.optString("wm"));
            pVar.b(jSONObject.optInt("wo"));
            pVar.c(jSONObject.optInt("wpr"));
            pVar.c(jSONObject.optString(bg.q));
            pVar.e(jSONObject.optInt("ws", 1));
            pVar.d(jSONObject.optInt("wh", 0));
            pVar.f(jSONObject.optInt("wt"));
            pVar.d(jSONObject.optString("wu"));
            pVar.e(jSONObject.optString("wv"));
            JSONArray jSONArray = jSONObject.getJSONArray("wa");
            ArrayList arrayList = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                p.a aVar = new p.a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                aVar.a(jSONObject2.optInt("r"));
                aVar.b(jSONObject2.optInt("t"));
                aVar.a(jSONObject2.getString("n"));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar);
            }
            pVar.a(arrayList);
            p.b bVar = new p.b();
            JSONObject jSONObject3 = jSONObject.getJSONObject(AliyunLogKey.KEY_WEIGHT);
            bVar.a(jSONObject3.optInt("duration"));
            bVar.b(jSONObject3.optInt("network"));
            pVar.a(bVar);
            return pVar;
        } catch (Exception unused) {
            return null;
        }
    }
}
