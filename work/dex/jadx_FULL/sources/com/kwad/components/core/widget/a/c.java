package com.kwad.components.core.widget.a;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.cb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class c extends a {
    private View mRootView;

    public c(@NonNull View view, int i) {
        super(view, i);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public boolean ah() {
        return cb.a(this.mRootView, 70, true);
    }
}
