package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.CampusLetterBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemCampusLetterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CampusLetterBean f13556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13557a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13558b;

    public ItemCampusLetterBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, BLTextView bLTextView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f13554a = imageView;
        this.b = imageView2;
        this.f13555a = textView;
        this.f13557a = bLTextView;
        this.f13558b = textView2;
        this.f36497a = view2;
    }

    public static ItemCampusLetterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCampusLetterBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemCampusLetterBinding) ViewDataBinding.bind(obj, view, R.layout.item_campus_letter);
    }

    @NonNull
    public static ItemCampusLetterBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemCampusLetterBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemCampusLetterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemCampusLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_campus_letter, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemCampusLetterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemCampusLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_campus_letter, null, false, obj);
    }

    @Nullable
    public CampusLetterBean f() {
        return this.f13556a;
    }

    public abstract void k(@Nullable CampusLetterBean campusLetterBean);
}
