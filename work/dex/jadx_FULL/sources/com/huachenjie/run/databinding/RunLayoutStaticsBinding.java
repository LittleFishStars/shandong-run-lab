package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.google.android.flexbox.FlexboxLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.RunDetailActivity;
import com.huachenjie.run.page.run_detail.RunDetailVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutStaticsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12180a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FlexboxLayout f12181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutMetricsContentBinding f12182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailActivity.a f12183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailVM f12184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12187a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12188b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f12189b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunLayoutStaticsBinding(Object _bindingComponent, View _root, int _localFieldCount, BLConstraintLayout clStaticsCard, FlexboxLayout flexTags, ImageView ivTitleActivity, RunLayoutMetricsContentBinding layoutMetricsInCard, LinearLayout llActivityInfo, LinearLayout llMetricsInCard, BLLinearLayout llSceneIcons, TextView tvDistance, BLTextView tvDynamicTrack, TextView tvNickname, TextView tvStudentNo, TextView tvTitle, BLTextView tvVisioning) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f12185a = clStaticsCard;
        this.f12181a = flexTags;
        this.f35707a = ivTitleActivity;
        this.f12182a = layoutMetricsInCard;
        this.f12179a = llActivityInfo;
        this.b = llMetricsInCard;
        this.f12186a = llSceneIcons;
        this.f12180a = tvDistance;
        this.f12187a = tvDynamicTrack;
        this.f12188b = tvNickname;
        this.c = tvStudentNo;
        this.d = tvTitle;
        this.f12189b = tvVisioning;
    }

    public static RunLayoutStaticsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutStaticsBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutStaticsBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_statics);
    }

    @NonNull
    public static RunLayoutStaticsBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutStaticsBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutStaticsBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutStaticsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_statics, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutStaticsBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutStaticsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_statics, null, false, component);
    }

    @Nullable
    public RunDetailActivity.a f() {
        return this.f12183a;
    }

    @Nullable
    public RunDetailVM g() {
        return this.f12184a;
    }

    public abstract void l(@Nullable RunDetailActivity.a click);

    public abstract void m(@Nullable RunDetailVM vm);
}
