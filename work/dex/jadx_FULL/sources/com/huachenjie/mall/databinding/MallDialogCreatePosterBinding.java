package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.dialog.poster.CreatePosterDialog;
import com.huachenjie.mall.dialog.poster.CreatePosterVM;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallDialogCreatePosterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34901a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f10525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreatePosterDialog.a f10526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreatePosterVM f10527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f10529a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10530b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f10531c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f10532d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f10533e;

    @NonNull
    public final ImageView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f10534f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public MallDialogCreatePosterBinding(Object obj, View view, int i, AvatarView avatarView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, BLTextView bLTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, BLView bLView, ConstraintLayout constraintLayout, View view2) {
        super(obj, view, i);
        this.f10525a = avatarView;
        this.f10521a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = imageView6;
        this.f10522a = linearLayout;
        this.f10528a = bLTextView;
        this.f10523a = textView;
        this.f10530b = textView2;
        this.f10531c = textView3;
        this.f10532d = textView4;
        this.f10533e = textView5;
        this.f10534f = textView6;
        this.g = textView7;
        this.h = textView8;
        this.i = textView9;
        this.f10529a = bLView;
        this.f10524a = constraintLayout;
        this.f34901a = view2;
    }

    public static MallDialogCreatePosterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallDialogCreatePosterBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallDialogCreatePosterBinding) ViewDataBinding.bind(obj, view, R.layout.mall_dialog_create_poster);
    }

    @NonNull
    public static MallDialogCreatePosterBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallDialogCreatePosterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallDialogCreatePosterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallDialogCreatePosterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_create_poster, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallDialogCreatePosterBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallDialogCreatePosterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_create_poster, null, false, obj);
    }

    @Nullable
    public CreatePosterDialog.a f() {
        return this.f10526a;
    }

    @Nullable
    public CreatePosterVM g() {
        return this.f10527a;
    }

    public abstract void l(@Nullable CreatePosterDialog.a aVar);

    public abstract void m(@Nullable CreatePosterVM createPosterVM);
}
