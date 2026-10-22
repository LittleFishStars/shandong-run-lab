package com.huachenjie.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.base.R;
import com.huachenjie.base.dsbridge_webview.WebContentView;
import com.noober.background.view.BLConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class BaseDialogCaptchaBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f32806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f6971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WebContentView f6972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f6973a;

    public BaseDialogCaptchaBinding(@NonNull BLConstraintLayout rootView, @NonNull ImageView ivClose, @NonNull TextView tvTitle, @NonNull WebContentView webContentView) {
        this.f6973a = rootView;
        this.f32806a = ivClose;
        this.f6971a = tvTitle;
        this.f6972a = webContentView;
    }

    @NonNull
    public static BaseDialogCaptchaBinding a(@NonNull View rootView) {
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.web_content_view;
                WebContentView webContentView = (WebContentView) ViewBindings.findChildViewById(rootView, i);
                if (webContentView != null) {
                    return new BaseDialogCaptchaBinding((BLConstraintLayout) rootView, imageView, textView, webContentView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static BaseDialogCaptchaBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static BaseDialogCaptchaBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.base_dialog_captcha, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.f6973a;
    }
}
