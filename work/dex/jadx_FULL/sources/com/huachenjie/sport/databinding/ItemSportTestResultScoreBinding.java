package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ScoringItem;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemSportTestResultScoreBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36534a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ScoringItem f13656a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public ItemSportTestResultScoreBinding(Object obj, View view, int i, LinearLayoutCompat linearLayoutCompat, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.f13655a = linearLayoutCompat;
        this.f36534a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
    }

    public static ItemSportTestResultScoreBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSportTestResultScoreBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemSportTestResultScoreBinding) ViewDataBinding.bind(obj, view, R.layout.item_sport_test_result_score);
    }

    @NonNull
    public static ItemSportTestResultScoreBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemSportTestResultScoreBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemSportTestResultScoreBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemSportTestResultScoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sport_test_result_score, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemSportTestResultScoreBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemSportTestResultScoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sport_test_result_score, null, false, obj);
    }

    @Nullable
    public ScoringItem f() {
        return this.f13656a;
    }

    public abstract void k(@Nullable ScoringItem scoringItem);
}
