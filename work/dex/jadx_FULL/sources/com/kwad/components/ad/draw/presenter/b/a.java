package com.kwad.components.ad.draw.presenter.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private InterfaceC1135a eY;

    @Nullable
    private b eZ;
    private boolean fa = false;
    private AdTemplate mAdTemplate;

    /* JADX INFO: renamed from: com.kwad.components.ad.draw.presenter.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC1135a {
        void bb();
    }

    public interface b {
        boolean bc();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC1135a interfaceC1135a) {
        this.eY = interfaceC1135a;
    }

    public final void ba() {
        InterfaceC1135a interfaceC1135a;
        if (this.fa) {
            return;
        }
        this.fa = true;
        if (e.eO(this.mAdTemplate).status == 1 || e.eO(this.mAdTemplate).status == 2 || e.eO(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.eZ;
        if ((bVar == null || !bVar.bc()) && (interfaceC1135a = this.eY) != null) {
            interfaceC1135a.bb();
        }
    }

    @MainThread
    public final void a(b bVar) {
        this.eZ = bVar;
    }
}
