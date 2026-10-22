package com.kwad.sdk.components;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.app.AppPackageInfo;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface p extends b {
    JSONObject D(String str);

    Map<String, AppPackageInfo> P(Context context);

    void a(Context context, com.kwad.sdk.g.a<JSONArray> aVar);

    JSONArray[] b(Context context, List<String> list);

    @NonNull
    JSONArray c(@NonNull Map<String, AppPackageInfo> map);

    JSONObject e(Context context, String str);
}
