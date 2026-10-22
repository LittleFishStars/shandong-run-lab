package com.byazt.rx;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 152, 20})
public class c {
    public Context c;
    public com.byazt.uy.n tt;
    public Map<String, Object> ve;

    public c(@NonNull Context context, @NonNull com.byazt.uy.n nVar) {
        this.c = context;
        this.tt = nVar;
    }

    @Nullable
    public Map<String, Object> c() {
        Map<String, Object> mapC = this.tt.c();
        if (mapC == null) {
            mapC = new HashMap<>(4);
        }
        if (c(mapC)) {
            try {
                PackageInfo packageInfo = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 128);
                mapC.put("version_name", packageInfo.versionName);
                mapC.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (mapC.get("update_version_code") == null) {
                    Bundle bundle = packageInfo.applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = mapC.get("version_code");
                    }
                    mapC.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                mapC.put("version_name", com.byazt.mg.c.n(this.c));
                mapC.put("version_code", Integer.valueOf(com.byazt.mg.c.a(this.c)));
                if (mapC.get("update_version_code") == null) {
                    mapC.put("update_version_code", mapC.get("version_code"));
                }
            }
        }
        return mapC;
    }

    public String n() {
        return this.tt.tt();
    }

    @Nullable
    public Map<String, Object> tt() {
        if (this.ve == null) {
            this.ve = this.tt.sp();
        }
        return this.ve;
    }

    public String uj() {
        return com.byazt.mg.c.uj(this.c);
    }

    @NonNull
    public com.byazt.uy.n ve() {
        return this.tt;
    }

    public static boolean c(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey(AlibcCommonConstant.APP_VERSION) || map.containsKey("version_name")) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }
}
