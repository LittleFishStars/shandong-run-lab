package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreActivity;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivitySportTestResultBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewStubProxy f36436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestResultScoreActivity.a f13366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestResultScoreVM f13367a;

    public ActivitySportTestResultBinding(Object obj, View view, int i, ViewStubProxy viewStubProxy) {
        super(obj, view, i);
        this.f36436a = viewStubProxy;
    }

    public static ActivitySportTestResultBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySportTestResultBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivitySportTestResultBinding) ViewDataBinding.bind(obj, view, R.layout.activity_sport_test_result);
    }

    @NonNull
    public static ActivitySportTestResultBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySportTestResultBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySportTestResultBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySportTestResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_sport_test_result, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivitySportTestResultBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySportTestResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_sport_test_result, null, false, obj);
    }

    @Nullable
    public SportTestResultScoreActivity.a f() {
        return this.f13366a;
    }

    @Nullable
    public SportTestResultScoreVM g() {
        return this.f13367a;
    }

    public abstract void l(@Nullable SportTestResultScoreActivity.a aVar);

    public abstract void m(@Nullable SportTestResultScoreVM sportTestResultScoreVM);
}
