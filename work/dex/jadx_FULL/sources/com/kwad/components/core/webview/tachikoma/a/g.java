package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.components.m;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class g implements m {
    public abstract void a(y yVar);

    public abstract void bV();

    public abstract void bW();

    public abstract void bX();

    public abstract void bY();

    @Override // com.kwad.sdk.components.m
    public final Object call(@Nullable Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            try {
                final y yVar = new y();
                if (objArr[0] instanceof String) {
                    yVar.parseJson(new JSONObject((String) objArr[0]));
                    by.runOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.a.g.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            if (yVar.zr()) {
                                g.this.bY();
                                return;
                            }
                            if (yVar.zt()) {
                                return;
                            }
                            if (yVar.zu()) {
                                g.this.bW();
                                return;
                            }
                            if (yVar.zv()) {
                                g.this.bV();
                            } else if (yVar.zs()) {
                                g.this.bX();
                            } else if (yVar.isFailed()) {
                                g.this.a(yVar);
                            }
                        }
                    });
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
