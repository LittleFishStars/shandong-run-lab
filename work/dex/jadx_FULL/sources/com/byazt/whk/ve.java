package com.byazt.whk;

import android.content.Context;
import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface ve {
    void init(Context context, Function<SparseArray<Object>, Object> function);

    boolean isPitayaEnvAvailable();

    boolean isPitayaInitSuccess();

    void onAppLogEvent(String str, JSONObject jSONObject);

    void queryPackage(String str, Function<SparseArray<Object>, Object> function);

    void runTask(String str, JSONObject jSONObject, Function<SparseArray<Object>, Object> function);
}
