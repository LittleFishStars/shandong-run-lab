package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.InspirationRecordBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemInspirationRecordTitleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InspirationRecordBean f9505a;

    public HomeItemInspirationRecordTitleBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f34282a = textView;
    }

    public static HomeItemInspirationRecordTitleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemInspirationRecordTitleBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemInspirationRecordTitleBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_inspiration_record_title);
    }

    @NonNull
    public static HomeItemInspirationRecordTitleBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemInspirationRecordTitleBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemInspirationRecordTitleBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemInspirationRecordTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_inspiration_record_title, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemInspirationRecordTitleBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemInspirationRecordTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_inspiration_record_title, null, false, obj);
    }

    @Nullable
    public InspirationRecordBean f() {
        return this.f9505a;
    }

    public abstract void k(@Nullable InspirationRecordBean inspirationRecordBean);
}
