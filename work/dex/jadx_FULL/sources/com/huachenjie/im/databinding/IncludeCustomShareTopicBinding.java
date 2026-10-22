package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.im.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class IncludeCustomShareTopicBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f9778a;

    @NonNull
    public final TextView b;

    public IncludeCustomShareTopicBinding(@NonNull View view, @NonNull RoundImageView roundImageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f34453a = view;
        this.f9778a = roundImageView;
        this.f9777a = textView;
        this.b = textView2;
    }

    @NonNull
    public static IncludeCustomShareTopicBinding a(@NonNull View view) {
        int i = R.id.topicImage;
        RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, i);
        if (roundImageView != null) {
            i = R.id.tvHot;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tvTopicName;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new IncludeCustomShareTopicBinding(view, roundImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static IncludeCustomShareTopicBinding b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.include_custom_share_topic, viewGroup);
        return a(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f34453a;
    }
}
