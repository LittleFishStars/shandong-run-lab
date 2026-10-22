package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class w implements com.kwad.sdk.core.webview.c.a {
    protected com.kwad.sdk.core.webview.c.c atX;

    @NonNull
    protected CopyOnWriteArrayList<com.kwad.sdk.core.b> atY = new CopyOnWriteArrayList<>();

    public void a(final com.kwad.sdk.core.b bVar) {
        if (this.atX != null) {
            by.runOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.b.w.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    com.kwad.sdk.core.webview.c.c cVar = w.this.atX;
                    if (cVar != null) {
                        cVar.b(bVar);
                    }
                }
            });
        } else {
            this.atY.add(bVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void onDestroy() {
        this.atX = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.atX = cVar;
        if (this.atY.size() > 0) {
            for (com.kwad.sdk.core.b bVar : this.atY) {
                a(bVar);
                this.atY.remove(bVar);
            }
        }
    }
}
