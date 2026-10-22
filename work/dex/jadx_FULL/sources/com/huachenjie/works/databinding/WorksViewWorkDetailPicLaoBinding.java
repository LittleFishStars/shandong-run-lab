package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.works.R;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class WorksViewWorkDetailPicLaoBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLView f37118a;

    public WorksViewWorkDetailPicLaoBinding(@NonNull BLView rootView) {
        this.f37118a = rootView;
    }

    @NonNull
    public static WorksViewWorkDetailPicLaoBinding a(@NonNull View rootView) {
        if (rootView != null) {
            return new WorksViewWorkDetailPicLaoBinding((BLView) rootView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static WorksViewWorkDetailPicLaoBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static WorksViewWorkDetailPicLaoBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.works_view_work_detail_pic_lao, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLView getRoot() {
        return this.f37118a;
    }
}
