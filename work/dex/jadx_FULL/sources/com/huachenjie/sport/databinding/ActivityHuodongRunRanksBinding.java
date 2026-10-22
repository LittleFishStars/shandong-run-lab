package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.huodong.run_rank.HuodongRunRanksVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityHuodongRunRanksBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f13281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HuodongRunRanksVM f13282a;

    public ActivityHuodongRunRanksBinding(Object obj, View view, int i, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f36411a = recyclerView;
        this.f13281a = layoutToolbarBindingBinding;
    }

    public static ActivityHuodongRunRanksBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityHuodongRunRanksBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityHuodongRunRanksBinding) ViewDataBinding.bind(obj, view, R.layout.activity_huodong_run_ranks);
    }

    @NonNull
    public static ActivityHuodongRunRanksBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityHuodongRunRanksBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityHuodongRunRanksBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityHuodongRunRanksBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_huodong_run_ranks, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityHuodongRunRanksBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityHuodongRunRanksBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_huodong_run_ranks, null, false, obj);
    }

    @Nullable
    public HuodongRunRanksVM f() {
        return this.f13282a;
    }

    public abstract void k(@Nullable HuodongRunRanksVM huodongRunRanksVM);
}
