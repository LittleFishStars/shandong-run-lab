package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.dressing_table.tag.UserTagFragment;
import com.huachenjie.mine.page.dressing_table.tag.UserTagVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentUserTagBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public UserTagFragment.a f11312a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public UserTagVM f11313a;

    public MineFragmentUserTagBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f35341a = recyclerView;
    }

    public static MineFragmentUserTagBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentUserTagBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentUserTagBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_user_tag);
    }

    @NonNull
    public static MineFragmentUserTagBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentUserTagBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentUserTagBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentUserTagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_user_tag, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentUserTagBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentUserTagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_user_tag, null, false, obj);
    }

    @Nullable
    public UserTagFragment.a f() {
        return this.f11312a;
    }

    @Nullable
    public UserTagVM g() {
        return this.f11313a;
    }

    public abstract void l(@Nullable UserTagFragment.a aVar);

    public abstract void m(@Nullable UserTagVM userTagVM);
}
