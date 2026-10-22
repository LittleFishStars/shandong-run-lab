package com.byazt.rx;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.byazt.mg.da;
import com.byazt.nr.m;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 152, 54})
public final class ve {
    public Context c;

    public ve(Context context) {
        this.c = context;
    }

    private void tt() {
        File[] fileArrC = c(com.byazt.mg.x.c(this.c), ".npth");
        if (fileArrC == null) {
            return;
        }
        Arrays.sort(fileArrC, Collections.reverseOrder());
        for (int i = 0; i < fileArrC.length && i < 50; i++) {
            File file = fileArrC[i];
            try {
                if (com.byazt.kr.c.c().c(file.getAbsolutePath())) {
                    com.byazt.mg.uj.c(file);
                } else {
                    com.byazt.xz.ve veVarVe = com.byazt.mg.uj.ve(file.getAbsolutePath());
                    if (veVarVe != null && veVarVe.tt() != null) {
                        JSONObject jSONObjectTt = veVarVe.tt();
                        c(file.getName(), jSONObjectTt);
                        veVarVe.tt().put("upload_scene", "launch_scan");
                        if (com.byazt.jz.tt.c(veVarVe.c(), jSONObjectTt.toString(), veVarVe.ve()).c() && !com.byazt.mg.uj.c(file)) {
                            com.byazt.kr.c.c().c(com.byazt.bk.c.c(file.getAbsolutePath()));
                        }
                    }
                }
            } catch (Exception e) {
                da.tt(e);
            }
        }
    }

    public void c(boolean z) {
        c();
        if (z) {
            tt();
        }
    }

    private void c() {
        try {
            SharedPreferences sharedPreferencesTt = com.byazt.nys.tt.tt(this.c, "npth", 0);
            long j = sharedPreferencesTt.getLong("history_time", -1L);
            if (j < 0) {
                sharedPreferencesTt.edit().putLong("history_time", System.currentTimeMillis()).apply();
            } else if (System.currentTimeMillis() - j > 86400000) {
                com.byazt.mg.uj.c(com.byazt.mg.x.tt(this.c));
                sharedPreferencesTt.edit().putLong("history_time", System.currentTimeMillis()).apply();
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    private com.byazt.uy.ve c(String str, JSONObject jSONObject) {
        if (jSONObject == null && TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("launch_")) {
            return com.byazt.uy.ve.LAUNCH;
        }
        if (str.startsWith("anr_")) {
            return com.byazt.uy.ve.ANR;
        }
        if (str.startsWith("java_")) {
            if (jSONObject.optInt("is_dart") == 1) {
                return com.byazt.uy.ve.DART;
            }
            if (jSONObject.optInt("isJava") == 1) {
                return com.byazt.uy.ve.JAVA;
            }
        }
        return null;
    }

    @Nullable
    private File[] c(File file, String str) {
        if (!file.exists()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return file.listFiles();
        }
        return file.listFiles(new FilenameFilter() { // from class: com.byazt.rx.ve.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                return str2 != null && str2.endsWith(".npth");
            }
        });
    }
}
