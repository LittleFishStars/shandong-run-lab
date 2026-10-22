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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemSportTestChooseDateBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f13641a;

    @Bindable
    public String f;

    public ItemSportTestChooseDateBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f36528a = textView;
    }

    public static ItemSportTestChooseDateBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSportTestChooseDateBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemSportTestChooseDateBinding) ViewDataBinding.bind(obj, view, R.layout.item_sport_test_choose_date);
    }

    @NonNull
    public static ItemSportTestChooseDateBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemSportTestChooseDateBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemSportTestChooseDateBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemSportTestChooseDateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sport_test_choose_date, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemSportTestChooseDateBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemSportTestChooseDateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sport_test_choose_date, null, false, obj);
    }

    @Nullable
    public String f() {
        return this.f;
    }

    @Nullable
    public Boolean g() {
        return this.f13641a;
    }

    public abstract void l(@Nullable String str);

    public abstract void m(@Nullable Boolean bool);
}
