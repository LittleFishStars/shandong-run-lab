package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.mine.R;
import com.huachenjie.works.bean.PostItemBean;
import com.huachenjie.works.widget.PostNineGridView;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineItemPostBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f11331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PostItemBean f11332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PostNineGridView f11333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11334a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public MineItemPostBinding(Object obj, View view, int i, AvatarView avatarView, PostNineGridView postNineGridView, BLLinearLayout bLLinearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f11331a = avatarView;
        this.f11333a = postNineGridView;
        this.f11334a = bLLinearLayout;
        this.f35347a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static MineItemPostBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineItemPostBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineItemPostBinding) ViewDataBinding.bind(obj, view, R.layout.mine_item_post);
    }

    @NonNull
    public static MineItemPostBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineItemPostBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineItemPostBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineItemPostBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_item_post, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineItemPostBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineItemPostBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_item_post, null, false, obj);
    }

    @Nullable
    public PostItemBean f() {
        return this.f11332a;
    }

    public abstract void k(@Nullable PostItemBean postItemBean);
}
