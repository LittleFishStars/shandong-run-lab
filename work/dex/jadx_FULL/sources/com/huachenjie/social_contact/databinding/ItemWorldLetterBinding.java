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
import com.huachenjie.social_contact.bean.NoticeBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemWorldLetterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f13020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NoticeBean f13022a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13023b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f13024b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13025b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f13026c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13027c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f13028d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f13029d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f13030e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f13031e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final ImageView i;

    public ItemWorldLetterBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.f36198a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = imageView6;
        this.g = imageView7;
        this.h = imageView8;
        this.i = imageView9;
        this.f13019a = linearLayout;
        this.f13020a = relativeLayout;
        this.f13024b = relativeLayout2;
        this.f13026c = relativeLayout3;
        this.f13028d = relativeLayout4;
        this.f13030e = relativeLayout5;
        this.f13023b = linearLayout2;
        this.f13021a = textView;
        this.f13025b = textView2;
        this.f13027c = textView3;
        this.f13029d = textView4;
        this.f13031e = textView5;
    }

    public static ItemWorldLetterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemWorldLetterBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemWorldLetterBinding) ViewDataBinding.bind(obj, view, R.layout.item_world_letter);
    }

    @NonNull
    public static ItemWorldLetterBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemWorldLetterBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemWorldLetterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemWorldLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_world_letter, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemWorldLetterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemWorldLetterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_world_letter, null, false, obj);
    }

    @Nullable
    public NoticeBean f() {
        return this.f13022a;
    }

    public abstract void k(@Nullable NoticeBean noticeBean);
}
