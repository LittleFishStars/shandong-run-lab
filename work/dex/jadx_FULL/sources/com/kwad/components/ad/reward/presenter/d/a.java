package com.kwad.components.ad.reward.presenter.d;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.presenter.d.b.c;
import com.kwad.components.ad.reward.presenter.d.b.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class a extends com.kwad.components.ad.reward.presenter.b implements g, j {
    public a() {
        dz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }

    private void ds() {
        this.uj.b(this);
        com.kwad.components.ad.reward.a.gs().a(this);
    }

    private void fh() {
        List<Presenter> listSA = SA();
        if (listSA == null) {
            return;
        }
        for (Object obj : listSA) {
            if (obj instanceof c) {
                ((c) obj).ka();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        ds();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void dd() {
        fh();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dr() {
        fh();
    }

    public void dz() {
        a(new d());
        a(new com.kwad.components.ad.reward.presenter.d.b.a());
        a(new com.kwad.components.ad.reward.presenter.d.b.b());
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.c(this);
        com.kwad.components.ad.reward.a.gs().b(this);
    }
}
