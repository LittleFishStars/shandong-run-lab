package com.kwad.components.core.innerEc.live.end;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements a {
    private final List<c> WZ = new CopyOnWriteArrayList();
    private boolean Xa;

    @Override // com.kwad.components.core.innerEc.live.end.a
    public final void a(@NonNull c cVar) {
        this.WZ.add(cVar);
    }

    @Override // com.kwad.components.core.innerEc.live.end.a
    public final void b(@NonNull c cVar) {
        this.WZ.remove(cVar);
    }

    @Override // com.kwad.components.core.innerEc.live.end.a
    public final boolean sD() {
        return this.Xa;
    }

    @Override // com.kwad.components.core.innerEc.live.end.a
    public final void a(@NonNull LiveAudienceEndReason liveAudienceEndReason) {
        this.Xa = true;
        Iterator<c> it = this.WZ.iterator();
        while (it.hasNext()) {
            it.next().sg();
        }
    }
}
