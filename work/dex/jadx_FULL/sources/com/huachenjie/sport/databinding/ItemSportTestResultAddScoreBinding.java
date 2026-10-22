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
import com.huachenjie.sport.bean.AddPointItem;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemSportTestResultAddScoreBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AddPointItem f13651a;

    public ItemSportTestResultAddScoreBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f36532a = textView;
    }

    public static ItemSportTestResultAddScoreBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSportTestResultAddScoreBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemSportTestResultAddScoreBinding) ViewDataBinding.bind(obj, view, R.layout.item_sport_test_result_add_score);
    }

    @NonNull
    public static ItemSportTestResultAddScoreBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemSportTestResultAddScoreBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemSportTestResultAddScoreBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemSportTestResultAddScoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sport_test_result_add_score, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemSportTestResultAddScoreBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemSportTestResultAddScoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sport_test_result_add_score, null, false, obj);
    }

    @Nullable
    public AddPointItem f() {
        return this.f13651a;
    }

    public abstract void k(@Nullable AddPointItem addPointItem);
}
