package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.RunRankBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemHuodongRunRanksBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final AvatarView f36517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunRankBean f13611a;

    public ItemHuodongRunRanksBinding(Object obj, View view, int i, AvatarView avatarView) {
        super(obj, view, i);
        this.f36517a = avatarView;
    }

    public static ItemHuodongRunRanksBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHuodongRunRanksBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemHuodongRunRanksBinding) ViewDataBinding.bind(obj, view, R.layout.item_huodong_run_ranks);
    }

    @NonNull
    public static ItemHuodongRunRanksBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemHuodongRunRanksBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemHuodongRunRanksBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemHuodongRunRanksBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_huodong_run_ranks, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemHuodongRunRanksBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemHuodongRunRanksBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_huodong_run_ranks, null, false, obj);
    }

    @Nullable
    public RunRankBean f() {
        return this.f13611a;
    }

    public abstract void k(@Nullable RunRankBean runRankBean);
}
