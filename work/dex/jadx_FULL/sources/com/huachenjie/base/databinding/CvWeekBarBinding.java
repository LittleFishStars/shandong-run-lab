package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class CvWeekBarBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f32813a;

    public CvWeekBarBinding(@NonNull View rootView) {
        this.f32813a = rootView;
    }

    @NonNull
    public static CvWeekBarBinding a(@NonNull View rootView) {
        if (rootView != null) {
            return new CvWeekBarBinding(rootView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CvWeekBarBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.cv_week_bar, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f32813a;
    }
}
