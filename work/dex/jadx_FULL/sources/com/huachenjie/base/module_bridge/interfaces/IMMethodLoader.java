package com.huachenjie.base.module_bridge.interfaces;

import androidx.annotation.NonNull;
import com.huachenjie.common.callback.ValueCallback;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface IMMethodLoader {
    void a(@NonNull ValueCallback<JSONArray> callback);

    void b(@NonNull ValueCallback<Boolean> callback);
}
