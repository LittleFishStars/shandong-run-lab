package com.kwad.components.core.offline.a.f;

import android.content.Context;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface c extends com.kwad.sdk.components.b {
    t a(Context context, String str, int i, int i2, boolean z);

    StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i);

    String getJsBaseDir(Context context, String str);

    ITkOfflineCompo.TKState getState();

    void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener);

    void onDestroy();
}
