package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ak implements com.kwad.sdk.core.webview.c.a {
    private final Handler aqd = new Handler(Looper.getMainLooper());

    @Nullable
    private com.kwad.sdk.core.webview.c.c aqe;
    private b fn;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int aqL = -1;
        public int type;
    }

    public interface b {
        @MainThread
        void a(a aVar);
    }

    public ak(b bVar) {
        this.fn = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.fn;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.fn = null;
        this.aqe = null;
        this.aqd.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            this.aqe = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.aqd.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.ak.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (ak.this.aqe != null) {
                        ak.this.aqe.b(null);
                    }
                    ak.this.b(aVar);
                }
            });
        } catch (Exception e) {
            this.aqe.onError(-1, e.getMessage());
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
