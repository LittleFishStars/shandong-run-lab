package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.kuaishou.weapon.p0.jni.A;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f40145a;
    private int b;
    private h c;

    public w(Context context) {
        this.b = 0;
        this.f40145a = context;
        h hVarA = h.a(context, "re_po_rt");
        this.c = hVarA;
        if (hVarA != null) {
            this.b = hVarA.b(dd.r, 0);
        }
    }

    public JSONArray a(int i) {
        try {
            new A(this.f40145a, i);
            JSONArray jsonObject = A.getJsonObject();
            JSONArray jSONArray = new JSONArray();
            if (jsonObject != null) {
                for (int i2 = 0; i2 < jsonObject.length(); i2++) {
                    jSONArray.put(jsonObject.get(i2));
                }
                A.setJsonObject(null);
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public JSONArray b(int i) {
        try {
            return c(i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONArray c(int i) {
        return d(i);
    }

    public JSONArray d(int i) {
        String[] packagesForUid;
        JSONArray jSONArray = new JSONArray();
        try {
            PackageManager packageManager = this.f40145a.getPackageManager();
            for (int i2 = 1000; i2 <= 19999; i2++) {
                try {
                    packagesForUid = packageManager.getPackagesForUid(i2);
                } catch (Exception unused) {
                    packagesForUid = null;
                }
                if (packagesForUid != null) {
                    for (String str : packagesForUid) {
                        try {
                            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                            if (i != 1 || (packageInfo.applicationInfo.flags & 1) != 1) {
                                v vVar = new v(packageInfo, this.f40145a);
                                vVar.h();
                                jSONArray.put(vVar.k());
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        } catch (Exception unused3) {
        }
        return jSONArray;
    }
}
