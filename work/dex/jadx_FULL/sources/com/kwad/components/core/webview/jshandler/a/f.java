package com.kwad.components.core.webview.jshandler.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.p;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private final WeakReference<Context> arZ;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String text;
    }

    public f(Context context) {
        this.arZ = new WeakReference<>(context);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            Context context = this.arZ.get() != null ? this.arZ.get() : null;
            if (context != null) {
                a aVar = new a();
                aVar.parseJson(new JSONObject(str));
                if (p.a(context, "ksad_landing_page", aVar.text)) {
                    cVar.b(null);
                } else {
                    cVar.onError(-1, "写入错误");
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "setClipBoard";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
