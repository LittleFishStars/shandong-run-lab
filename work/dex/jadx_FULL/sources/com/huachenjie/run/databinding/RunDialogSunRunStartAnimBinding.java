package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.widget.SunRunStartAnimView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunDialogSunRunStartAnimBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final SunRunStartAnimView f35561a;

    @NonNull
    public final SunRunStartAnimView b;

    public RunDialogSunRunStartAnimBinding(@NonNull SunRunStartAnimView rootView, @NonNull SunRunStartAnimView sunRunStartAnim) {
        this.f35561a = rootView;
        this.b = sunRunStartAnim;
    }

    @NonNull
    public static RunDialogSunRunStartAnimBinding a(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        SunRunStartAnimView sunRunStartAnimView = (SunRunStartAnimView) rootView;
        return new RunDialogSunRunStartAnimBinding(sunRunStartAnimView, sunRunStartAnimView);
    }

    @NonNull
    public static RunDialogSunRunStartAnimBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunDialogSunRunStartAnimBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_dialog_sun_run_start_anim, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SunRunStartAnimView getRoot() {
        return this.f35561a;
    }
}
