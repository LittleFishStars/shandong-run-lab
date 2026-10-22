package com.kwad.components.core.webview.jshandler.a;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.local.LocalWriteResult;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.i;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private static SimpleDateFormat asa = new SimpleDateFormat("yyyyMMddHHmmss");
    private final WeakReference<Context> arZ;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String asc;
        private byte[] asd;
        private String ase;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            String[] strArrSplit = this.asc.split(";base64,");
            if (strArrSplit.length >= 2) {
                String str = strArrSplit[0];
                if (str.startsWith("data:")) {
                    this.ase = str.substring(5);
                }
                this.asd = com.kwad.sdk.core.a.c.LQ().decode(strArrSplit[1]);
            }
        }

        public final byte[] yF() {
            return this.asd;
        }

        public final String yG() {
            return this.ase;
        }
    }

    public e(Context context) {
        this.arZ = new WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d("SaveImageHandler", "notifySuccess function callback: " + cVar);
        by.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.b(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "saveImage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
        final Context context = this.arZ.get();
        if (context == null) {
            return;
        }
        i.execute(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    com.kwad.sdk.core.d.c.d("SaveImageHandler", "saveImageData mime type: " + aVar.yG());
                    LocalWriteResult localWriteResultA = com.kwad.sdk.core.local.b.a(context, aVar.yG(), aVar.yF(), "ksad_image_" + e.asa.format(new Date()));
                    if (LocalWriteResult.SUCCESS.equals(localWriteResultA)) {
                        e.this.b(cVar);
                    } else if (LocalWriteResult.FAIL.equals(localWriteResultA)) {
                        e.this.a(cVar, "write error", -1);
                    } else {
                        e.this.a(cVar, "permission denied", -2);
                    }
                } catch (Throwable th) {
                    e.this.a(cVar, "error_" + th.getMessage(), -3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.c.c cVar, final String str, final int i) {
        com.kwad.sdk.core.d.c.d("SaveImageHandler", "notifyError msg: " + str);
        by.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onError(i, str);
                }
            }
        });
    }
}
