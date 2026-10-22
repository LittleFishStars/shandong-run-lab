package com.kwad.components.offline.e;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.e.a.i;
import com.kwad.sdk.components.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class b implements com.kwad.components.core.offline.a.f.c {
    private final ITkOfflineCompo axT;

    public b(@NonNull ITkOfflineCompo iTkOfflineCompo) {
        this.axT = iTkOfflineCompo;
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final t a(Context context, String str, int i, int i2, boolean z) {
        IOfflineCompoTachikomaContext context2 = this.axT.getContext(context, str, i, i2, z);
        if (context2 == null) {
            return null;
        }
        return new i(context2);
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i) {
        return this.axT.checkStyleTemplateById(context, str, str2, str3, i);
    }

    @Override // com.kwad.sdk.components.b
    public final Class<b> getComponentsType() {
        return b.class;
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final String getJsBaseDir(Context context, String str) {
        return this.axT.getJsBaseDir(context, str);
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final ITkOfflineCompo.TKState getState() {
        return this.axT.getState();
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener) {
        this.axT.loadTkFileByTemplateId(context, str, str2, str3, i, tKDownloadListener);
    }

    public final void onConfigRefresh(Context context, @NonNull JSONObject jSONObject) {
        this.axT.onConfigRefresh(context, jSONObject);
    }

    @Override // com.kwad.components.core.offline.a.f.c
    public final void onDestroy() {
        this.axT.onDestroy();
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.axT.priority();
    }
}
