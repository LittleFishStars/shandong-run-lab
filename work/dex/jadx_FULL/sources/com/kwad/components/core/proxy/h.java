package com.kwad.components.core.proxy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class h extends KsFragment implements com.kwad.sdk.l.a.b {
    protected ViewGroup aiO;
    private final com.kwad.sdk.l.a.a mBackPressDelete = new com.kwad.sdk.l.a.a();
    protected Context mContext;
    protected ViewGroup oC;

    public final <T extends View> T findViewById(int i) {
        ViewGroup viewGroup = this.oC;
        if (viewGroup != null) {
            return (T) viewGroup.findViewById(i);
        }
        throw new IllegalArgumentException("ID does not reference a View inside this View");
    }

    public ViewGroup nP() {
        return null;
    }

    public boolean onBackPressed() {
        return this.mBackPressDelete.onBackPressed();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            this.mContext = com.kwad.sdk.wrapper.m.wrapContextIfNeed(getActivity());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        this.aiO = viewGroup;
        if (this.oC == null) {
            ViewGroup viewGroupNP = nP();
            this.oC = viewGroupNP;
            if (viewGroupNP == null && rI() != 0) {
                this.oC = (ViewGroup) layoutInflaterFrom.inflate(rI(), viewGroup, false);
            }
        }
        return this.oC;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (getHost() != null) {
            com.kwad.components.core.t.g.destroyFragment(this.mContext, getView());
        }
    }

    public int rI() {
        return 0;
    }
}
