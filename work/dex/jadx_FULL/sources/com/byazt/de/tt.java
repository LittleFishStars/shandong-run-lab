package com.byazt.de;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.byazt.gq.t;
import com.byazt.nr.m;
import com.byazt.ut.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 111, 13})
public class tt {
    @NonNull
    public CopyOnWriteArrayList<com.byazt.nn.c> c(String str, String str2) {
        CopyOnWriteArrayList<com.byazt.nn.c> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = a.getKVStore(t.getContext(), str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    com.byazt.nn.c cVarC = com.byazt.nn.c.c(jSONObject.optJSONObject(itKeys.next()));
                    if (cVarC != null) {
                        copyOnWriteArrayList.add(cVarC);
                    }
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
        return copyOnWriteArrayList;
    }

    public void tt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        a.getKVStore(t.getContext(), str, 0).edit().putString(str2, "").apply();
    }

    public void c(String str, String str2, CopyOnWriteArrayList<com.byazt.nn.c> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (com.byazt.nn.c cVar : copyOnWriteArrayList) {
                if (cVar != null) {
                    jSONObject.put(String.valueOf(cVar.tt), cVar.c());
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
        a.getKVStore(t.getContext(), str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
