package com.byazt.kg;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.byazt.mg.yp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 428, 46})
public class n {
    public static JSONObject c(boolean z) throws JSONException {
        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("thread_number", 1);
        jSONObject.put("mainStackFromTrace", yp.c(stackTrace));
        return jSONObject;
    }

    public static String c(Context context, int i) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfoC = com.byazt.mg.c.c(context, i);
        if (processErrorStateInfoC == null || Process.myPid() != processErrorStateInfoC.pid) {
            return null;
        }
        return tt.c(processErrorStateInfoC);
    }
}
