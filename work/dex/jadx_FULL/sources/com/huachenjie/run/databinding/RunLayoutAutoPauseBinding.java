package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutAutoPauseBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12003a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12004b;

    @NonNull
    public final TextView c;

    public RunLayoutAutoPauseBinding(@NonNull View rootView, @NonNull ImageView ivClose, @NonNull TextView tvCountdown, @NonNull TextView tvTip, @NonNull TextView tvTitle, @NonNull View vBg) {
        this.f35644a = rootView;
        this.f12002a = ivClose;
        this.f12003a = tvCountdown;
        this.f12004b = tvTip;
        this.c = tvTitle;
        this.b = vBg;
    }

    @NonNull
    public static RunLayoutAutoPauseBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        int i = R.id.ivClose;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.tvCountdown;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tvTip;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.tvTitle;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.vBg))) != null) {
                        return new RunLayoutAutoPauseBinding(rootView, imageView, textView, textView2, textView3, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutAutoPauseBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.run_layout_auto_pause, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f35644a;
    }
}
