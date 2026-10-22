package com.kwad.sdk.m;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class f {
    public static final String TAG = "Ranger_" + f.class.getSimpleName();

    private static void a(@NonNull d dVar) {
        try {
            a.a(dVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, Log.getStackTraceString(th));
        }
    }

    public static void d(@NonNull d dVar) {
        if (new Random().nextFloat() >= dVar.sampleRate) {
            com.kwad.sdk.core.d.c.d(TAG, "config.sampleRate：" + dVar.sampleRate + " return");
            return;
        }
        if (dVar.TL()) {
            a(dVar);
        }
        if (dVar.TM()) {
            e(dVar);
        }
        if (dVar.TN()) {
            f(dVar);
        }
    }

    public static void dC(final String str) {
        i.schedule(new bi() { // from class: com.kwad.sdk.m.f.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    com.kwad.sdk.core.d.c.w(f.TAG, "config is empty");
                    return;
                }
                d dVarHy = f.hy(str2);
                if (dVarHy != null) {
                    com.kwad.sdk.core.d.c.d(f.TAG, "config:" + dVarHy.toJson().toString());
                }
                if (dVarHy == null || dVarHy.TK()) {
                    return;
                }
                f.d(dVarHy);
            }
        }, 0L, TimeUnit.SECONDS);
    }

    private static void e(d dVar) {
        c.TI().c(dVar);
    }

    private static void f(final d dVar) {
        GlobalThreadPools.NX().execute(new Runnable() { // from class: com.kwad.sdk.m.f.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    b.TD().b(dVar);
                    b.TD().TF();
                    b.TD().clearAll();
                    b.TD().start();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.e(f.TAG, Log.getStackTraceString(e));
                }
            }
        });
    }

    public static d hy(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.parseJson(jSONObject);
            return dVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w(TAG, e);
            return null;
        }
    }
}
