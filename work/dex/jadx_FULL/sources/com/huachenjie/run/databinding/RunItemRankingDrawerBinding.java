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
public final class RunItemRankingDrawerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckTextView f35624a;

    @NonNull
    public final CheckTextView b;

    public RunItemRankingDrawerBinding(@NonNull CheckTextView rootView, @NonNull CheckTextView tv) {
        this.f35624a = rootView;
        this.b = tv;
    }

    @NonNull
    public static RunItemRankingDrawerBinding a(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        CheckTextView checkTextView = (CheckTextView) rootView;
        return new RunItemRankingDrawerBinding(checkTextView, checkTextView);
    }

    @NonNull
    public static RunItemRankingDrawerBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunItemRankingDrawerBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_item_ranking_drawer, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CheckTextView getRoot() {
        return this.f35624a;
    }
}
