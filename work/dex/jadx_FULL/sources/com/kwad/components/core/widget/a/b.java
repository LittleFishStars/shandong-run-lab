package com.kwad.components.core.widget.a;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.core.fragment.KsFragment;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends a {
    private final AtomicBoolean awA;
    private KsFragment awF;
    private String awG;

    public b(@NonNull KsFragment ksFragment, @NonNull View view, int i) {
        super(view, 70);
        this.awA = new AtomicBoolean(false);
        this.awF = ksFragment;
    }

    private static boolean a(@NonNull KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean ah() {
        KsFragment ksFragment = this.awF;
        if (ksFragment == null) {
            return false;
        }
        if (a(ksFragment)) {
            this.awG = "message fragment";
            return false;
        }
        this.awG = "message view";
        return Ac();
    }

    @Override // com.kwad.components.core.widget.a.a, com.kwad.sdk.core.j.a
    public final void release() {
        super.release();
        this.awF = null;
    }
}
