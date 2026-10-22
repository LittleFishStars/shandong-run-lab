package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.dialog.PropLetterDialog;
import com.huachenjie.social_contact.vm.PropLetterVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogPropLetterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12890a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12891a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PropLetterDialog.a f12892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PropLetterVM f12893a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12894b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12895c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f12896d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    public DialogPropLetterBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.f36149a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = imageView6;
        this.g = imageView7;
        this.h = imageView8;
        this.f12890a = relativeLayout;
        this.f12894b = relativeLayout2;
        this.f12895c = relativeLayout3;
        this.f12896d = relativeLayout4;
        this.f12889a = linearLayout;
        this.f12891a = textView;
    }

    public static DialogPropLetterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogPropLetterBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogPropLetterBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_prop_letter);
    }

    @NonNull
    public static DialogPropLetterBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogPropLetterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogPropLetterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogPropLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_prop_letter, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogPropLetterBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogPropLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_prop_letter, null, false, obj);
    }

    @Nullable
    public PropLetterDialog.a f() {
        return this.f12892a;
    }

    @Nullable
    public PropLetterVM g() {
        return this.f12893a;
    }

    public abstract void l(@Nullable PropLetterDialog.a aVar);

    public abstract void m(@Nullable PropLetterVM propLetterVM);
}
