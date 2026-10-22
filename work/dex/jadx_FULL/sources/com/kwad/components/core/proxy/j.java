package com.kwad.components.core.proxy;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.q;
import com.kwad.sdk.utils.ab;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class j extends DialogFragment {
    private int a(FragmentTransaction fragmentTransaction, String str) {
        try {
            Boolean bool = Boolean.FALSE;
            ab.a(this, "mDismissed", bool);
            ab.a(this, "mShownByMe", Boolean.TRUE);
            ab.a(this, "mViewDestroyed", bool);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        return fragmentTransaction.add(this, str).commitAllowingStateLoss();
    }

    public abstract View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                super.dismissAllowingStateLoss();
            } else if (getActivity() == null) {
                super.dismissAllowingStateLoss();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // android.app.Fragment
    @Nullable
    public Context getContext() {
        return com.kwad.sdk.wrapper.m.wrapContextIfNeed(super.getContext());
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        q.checkInitSDK(context);
        super.onAttach(com.kwad.sdk.wrapper.m.wrapContextIfNeed(context));
    }

    @Override // android.app.Fragment
    @Nullable
    public final View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflaterEU = com.kwad.sdk.wrapper.m.eU(com.kwad.sdk.wrapper.m.wrapContextIfNeed(layoutInflater.getContext()));
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
        }
        return a(layoutInflaterEU, viewGroup);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return com.kwad.sdk.wrapper.m.eU(com.kwad.sdk.wrapper.m.wrapContextIfNeed(super.onGetLayoutInflater(bundle).getContext()));
    }

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        try {
            return super.show(fragmentTransaction, str);
        } catch (Throwable unused) {
            return a(fragmentTransaction, str);
        }
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            try {
                super.show(fragmentManager, str);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                a(fragmentManager.beginTransaction(), str);
            }
        } catch (Throwable unused) {
            ab.callMethod(this, "showAllowingStateLoss", fragmentManager, str);
        }
    }

    public final void a(FragmentManager fragmentManager, String str) {
        try {
            if (isAdded()) {
                return;
            }
            show(fragmentManager, str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
