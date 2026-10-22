package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RankItemData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemSunshineRankingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f11979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RankItemData f11980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f11981a;

    @Bindable
    public Integer b;

    public RunItemSunshineRankingBinding(Object _bindingComponent, View _root, int _localFieldCount, AvatarView ivAvatar, LinearLayout llLikeNum, TextView tvMyUpdateMs) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11979a = ivAvatar;
        this.f35635a = llLikeNum;
        this.f11978a = tvMyUpdateMs;
    }

    public static RunItemSunshineRankingBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemSunshineRankingBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemSunshineRankingBinding) ViewDataBinding.bind(component, view, R.layout.run_item_sunshine_ranking);
    }

    @NonNull
    public static RunItemSunshineRankingBinding i(@NonNull LayoutInflater inflater) {
        return l(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemSunshineRankingBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return k(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemSunshineRankingBinding k(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemSunshineRankingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_sunshine_ranking, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemSunshineRankingBinding l(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemSunshineRankingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_sunshine_ranking, null, false, component);
    }

    @Nullable
    public Integer f() {
        return this.b;
    }

    @Nullable
    public Integer g() {
        return this.f11981a;
    }

    @Nullable
    public RankItemData h() {
        return this.f11980a;
    }

    public abstract void m(@Nullable Integer listType);

    public abstract void n(@Nullable Integer sexType);

    public abstract void o(@Nullable RankItemData vm);
}
