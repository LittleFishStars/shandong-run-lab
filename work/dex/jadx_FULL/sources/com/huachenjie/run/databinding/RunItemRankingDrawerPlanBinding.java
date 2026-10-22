package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunItemRankingDrawerPlanBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckTextView f35625a;

    @NonNull
    public final CheckTextView b;

    public RunItemRankingDrawerPlanBinding(@NonNull CheckTextView rootView, @NonNull CheckTextView tv) {
        this.f35625a = rootView;
        this.b = tv;
    }

    @NonNull
    public static RunItemRankingDrawerPlanBinding a(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        CheckTextView checkTextView = (CheckTextView) rootView;
        return new RunItemRankingDrawerPlanBinding(checkTextView, checkTextView);
    }

    @NonNull
    public static RunItemRankingDrawerPlanBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunItemRankingDrawerPlanBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_item_ranking_drawer_plan, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CheckTextView getRoot() {
        return this.f35625a;
    }
}
