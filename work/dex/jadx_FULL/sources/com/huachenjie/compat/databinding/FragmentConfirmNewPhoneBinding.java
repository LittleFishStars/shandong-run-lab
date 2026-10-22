package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.ClearableEditText;
import com.huachenjie.compat.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class FragmentConfirmNewPhoneBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f34069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ClearableEditText f9207a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ClearableEditText f9208b;

    public FragmentConfirmNewPhoneBinding(@NonNull LinearLayout linearLayout, @NonNull ClearableEditText clearableEditText, @NonNull ClearableEditText clearableEditText2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f34069a = linearLayout;
        this.f9207a = clearableEditText;
        this.f9208b = clearableEditText2;
        this.f9206a = textView;
        this.b = textView2;
    }

    @NonNull
    public static FragmentConfirmNewPhoneBinding a(@NonNull View view) {
        int i = R.id.edit_captcha;
        ClearableEditText clearableEditText = (ClearableEditText) ViewBindings.findChildViewById(view, i);
        if (clearableEditText != null) {
            i = R.id.edit_phone;
            ClearableEditText clearableEditText2 = (ClearableEditText) ViewBindings.findChildViewById(view, i);
            if (clearableEditText2 != null) {
                i = R.id.tv_get_captcha;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_left_count;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new FragmentConfirmNewPhoneBinding((LinearLayout) view, clearableEditText, clearableEditText2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static FragmentConfirmNewPhoneBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentConfirmNewPhoneBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_confirm_new_phone, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f34069a;
    }
}
