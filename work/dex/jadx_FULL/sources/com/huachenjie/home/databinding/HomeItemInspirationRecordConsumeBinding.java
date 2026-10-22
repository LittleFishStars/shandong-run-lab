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
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemInspirationRecordConsumeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public InspirationRecordBean f9490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9491a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public HomeItemInspirationRecordConsumeBinding(Object obj, View view, int i, BLTextView bLTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        super(obj, view, i);
        this.f9491a = bLTextView;
        this.f9489a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.f34277a = view2;
    }

    public static HomeItemInspirationRecordConsumeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemInspirationRecordConsumeBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemInspirationRecordConsumeBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_inspiration_record_consume);
    }

    @NonNull
    public static HomeItemInspirationRecordConsumeBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemInspirationRecordConsumeBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemInspirationRecordConsumeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemInspirationRecordConsumeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_inspiration_record_consume, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemInspirationRecordConsumeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemInspirationRecordConsumeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_inspiration_record_consume, null, false, obj);
    }

    @Nullable
    public InspirationRecordBean f() {
        return this.f9490a;
    }

    public abstract void k(@Nullable InspirationRecordBean inspirationRecordBean);
}
