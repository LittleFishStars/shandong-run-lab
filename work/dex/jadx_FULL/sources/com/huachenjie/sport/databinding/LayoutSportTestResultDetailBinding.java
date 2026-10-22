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
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreActivity;
import com.huachenjie.sport.page.mine.sport_test.result.SportTestResultScoreVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class LayoutSportTestResultDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13674a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestResultScoreActivity.a f13675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportTestResultScoreVM f13676a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13677b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13678b;

    @NonNull
    public final View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13679c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public LayoutSportTestResultDetailBinding(Object obj, View view, int i, View view2, View view3, View view4, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.f36543a = view2;
        this.b = view3;
        this.c = view4;
        this.f13674a = recyclerView;
        this.f13678b = recyclerView2;
        this.f13673a = textView;
        this.f13677b = textView2;
        this.f13679c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
    }

    public static LayoutSportTestResultDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutSportTestResultDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (LayoutSportTestResultDetailBinding) ViewDataBinding.bind(obj, view, R.layout.layout_sport_test_result_detail);
    }

    @NonNull
    public static LayoutSportTestResultDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutSportTestResultDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutSportTestResultDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LayoutSportTestResultDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_sport_test_result_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LayoutSportTestResultDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutSportTestResultDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_sport_test_result_detail, null, false, obj);
    }

    @Nullable
    public SportTestResultScoreActivity.a f() {
        return this.f13675a;
    }

    @Nullable
    public SportTestResultScoreVM g() {
        return this.f13676a;
    }

    public abstract void l(@Nullable SportTestResultScoreActivity.a aVar);

    public abstract void m(@Nullable SportTestResultScoreVM sportTestResultScoreVM);
}
