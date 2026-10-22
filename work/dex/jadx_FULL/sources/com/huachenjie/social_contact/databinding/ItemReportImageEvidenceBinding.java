package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemReportImageEvidenceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f12981a;

    @NonNull
    public final ImageView b;

    @Bindable
    public String f;

    public ItemReportImageEvidenceBinding(Object obj, View view, int i, ImageView imageView, BLImageView bLImageView, ImageView imageView2) {
        super(obj, view, i);
        this.f36187a = imageView;
        this.f12981a = bLImageView;
        this.b = imageView2;
    }

    public static ItemReportImageEvidenceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemReportImageEvidenceBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemReportImageEvidenceBinding) ViewDataBinding.bind(obj, view, R.layout.item_report_image_evidence);
    }

    @NonNull
    public static ItemReportImageEvidenceBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemReportImageEvidenceBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemReportImageEvidenceBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemReportImageEvidenceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_report_image_evidence, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemReportImageEvidenceBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemReportImageEvidenceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_report_image_evidence, null, false, obj);
    }

    @Nullable
    public String f() {
        return this.f;
    }

    public abstract void k(@Nullable String str);
}
