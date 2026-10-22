package com.kwad.components.core.n;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.n.a.a> abk = new ArrayList();

    @NonNull
    private final b<?> abl;

    @NonNull
    public final Context mContext;

    @NonNull
    public final View mRootView;

    public a(b<?> bVar) {
        this.abl = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Deprecated
    public final Activity getActivity() {
        return this.abl.getActivity();
    }

    public final void iM() {
        this.abl.finish();
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.abk.clear();
    }
}
