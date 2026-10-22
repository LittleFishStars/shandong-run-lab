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
public final class WorksViewWorkDetailVideoLaoBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLView f37120a;

    public WorksViewWorkDetailVideoLaoBinding(@NonNull BLView rootView) {
        this.f37120a = rootView;
    }

    @NonNull
    public static WorksViewWorkDetailVideoLaoBinding a(@NonNull View rootView) {
        if (rootView != null) {
            return new WorksViewWorkDetailVideoLaoBinding((BLView) rootView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static WorksViewWorkDetailVideoLaoBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static WorksViewWorkDetailVideoLaoBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.works_view_work_detail_video_lao, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLView getRoot() {
        return this.f37120a;
    }
}
