package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.campus_letter.LetterDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityLetterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final WebView f36416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public LetterDetailVM f13306a;

    public ActivityLetterBinding(Object obj, View view, int i, TextView textView, WebView webView) {
        super(obj, view, i);
        this.f13305a = textView;
        this.f36416a = webView;
    }

    public static ActivityLetterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityLetterBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityLetterBinding) ViewDataBinding.bind(obj, view, R.layout.activity_letter);
    }

    @NonNull
    public static ActivityLetterBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityLetterBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityLetterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_letter, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityLetterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_letter, null, false, obj);
    }

    @Nullable
    public LetterDetailVM f() {
        return this.f13306a;
    }

    public abstract void k(@Nullable LetterDetailVM letterDetailVM);
}
