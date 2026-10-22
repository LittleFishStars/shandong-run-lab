package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutPaceErrorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35679a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12106a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12107b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunLayoutPaceErrorBinding(@NonNull View rootView, @NonNull TextView tvCountdown, @NonNull TextView tvLimit, @NonNull TextView tvTip, @NonNull TextView tvTitle, @NonNull View vBg) {
        this.f35679a = rootView;
        this.f12106a = tvCountdown;
        this.f12107b = tvLimit;
        this.c = tvTip;
        this.d = tvTitle;
        this.b = vBg;
    }

    @NonNull
    public static RunLayoutPaceErrorBinding a(@NonNull View rootView) {
        View viewFindChildViewById;
        int i = R.id.tvCountdown;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tvLimit;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.tvTip;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.tvTitle;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.vBg))) != null) {
                        return new RunLayoutPaceErrorBinding(rootView, textView, textView2, textView3, textView4, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutPaceErrorBinding b(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.run_layout_pace_error, parent);
        return a(parent);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f35679a;
    }
}
