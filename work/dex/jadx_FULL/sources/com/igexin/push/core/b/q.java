package com.igexin.push.core.b;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.igexin.push.extension.mod.BaseActionBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class q extends BaseActionBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f37969a;

    private long a() {
        return this.f37969a;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0058  */
    private static q a(String str) throws JSONException {
        long j;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        q qVar = new q();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("actionid")) {
            qVar.setActionId(jSONObject.getString("actionid"));
        }
        if (jSONObject.has("type")) {
            qVar.setType(jSONObject.getString("type"));
        }
        if (jSONObject.has("do")) {
            qVar.setDoActionId(jSONObject.getString("do"));
        }
        if (jSONObject.has("delay")) {
            double d = jSONObject.getDouble("delay");
            if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                j = (long) (d * 1000.0d);
            } else {
                j = 200;
            }
        } else {
            j = 200;
        }
        qVar.f37969a = j;
        return qVar;
    }

    private void a(long j) {
        this.f37969a = j;
    }
}
