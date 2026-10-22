package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class al implements com.kwad.sdk.core.webview.c.a {
    private final WebView ade;
    private boolean aqM;
    private Handler aqd;

    @Nullable
    private com.kwad.sdk.core.webview.c.c aqe;

    @Nullable
    private b fm;

    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt("height");
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.ac.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.ac.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.ac.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }

    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public al(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2) {
        this(bVar, bVar2, true);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aqe = null;
        this.fm = null;
        this.aqd.removeCallbacksAndMessages(null);
    }

    private al(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2, boolean z) {
        this.aqM = true;
        this.aqd = new Handler(Looper.getMainLooper());
        this.ade = bVar.ade;
        this.fm = bVar2;
        this.aqM = true;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.aqe = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.aqd.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.al.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (al.this.ade != null && al.this.aqM) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) al.this.ade.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.height;
                        marginLayoutParams.leftMargin = aVar2.leftMargin;
                        marginLayoutParams.rightMargin = aVar2.rightMargin;
                        marginLayoutParams.bottomMargin = aVar2.bottomMargin;
                        al.this.ade.setLayoutParams(marginLayoutParams);
                    }
                    if (al.this.fm != null) {
                        al.this.fm.a(aVar);
                    }
                }
            });
            this.aqd.post(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.al.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (al.this.aqe != null) {
                        al.this.aqe.b(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            cVar.onError(-1, e.getMessage());
        }
    }
}
