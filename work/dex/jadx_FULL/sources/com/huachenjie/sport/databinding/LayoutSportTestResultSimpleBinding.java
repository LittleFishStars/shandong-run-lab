package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class LayoutSportTestResultSimpleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestResultScoreVM f13684a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public LayoutSportTestResultSimpleBinding(Object obj, View view, int i, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f36545a = view2;
        this.f13683a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static LayoutSportTestResultSimpleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSportTestResultSimpleBinding d(@NonNull View view, @Nullable Object obj) {
        return (LayoutSportTestResultSimpleBinding) ViewDataBinding.bind(obj, view, R.layout.layout_sport_test_result_simple);
    }

    @NonNull
    public static LayoutSportTestResultSimpleBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutSportTestResultSimpleBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutSportTestResultSimpleBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LayoutSportTestResultSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_sport_test_result_simple, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LayoutSportTestResultSimpleBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutSportTestResultSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_sport_test_result_simple, null, false, obj);
    }

    @Nullable
    public SportTestResultScoreVM f() {
        return this.f13684a;
    }

    public abstract void k(@Nullable SportTestResultScoreVM sportTestResultScoreVM);
}
