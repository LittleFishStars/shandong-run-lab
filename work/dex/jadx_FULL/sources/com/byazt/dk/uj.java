package com.byazt.dk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import com.byazt.su.DownloadModel;
import com.byazt.t.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface uj {
    AlertDialog c(Activity activity, boolean z, c cVar);

    String c(boolean z);

    JSONObject c();

    void c(int i, String str, Map<String, Object> map, n nVar);

    void c(Activity activity, String[] strArr, a aVar);

    void c(x xVar, boolean z);

    void c(String str, byte[] bArr, String str2, n nVar);

    void c(WeakReference<Context> weakReference, boolean z, c cVar);

    void c(JSONObject jSONObject, String str);

    boolean c(Context context, String str);

    boolean c(DownloadModel downloadModel);

    boolean c(DownloadModel downloadModel, DownloadInfo downloadInfo);

    boolean c(String str);

    sp tt();

    void tt(String str);

    boolean tt(DownloadModel downloadModel, DownloadInfo downloadInfo);

    boolean ve();
}
