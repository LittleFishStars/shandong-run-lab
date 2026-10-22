package com.flyco.tablayout.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.flyco.tablayout.R;
import com.flyco.tablayout.widget.MsgView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class LayoutTabBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f30233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f1827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final MsgView f1828a;

    @NonNull
    public final TextView b;

    public LayoutTabBinding(@NonNull RelativeLayout relativeLayout, @NonNull MsgView msgView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f30233a = relativeLayout;
        this.f1828a = msgView;
        this.f1827a = textView;
        this.b = textView2;
    }

    @NonNull
    public static LayoutTabBinding a(@NonNull View view) {
        int i = R.id.rtv_msg_tip;
        MsgView msgView = (MsgView) ViewBindings.findChildViewById(view, i);
        if (msgView != null) {
            i = R.id.tv_placehold_scale;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_tab_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new LayoutTabBinding((RelativeLayout) view, msgView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static LayoutTabBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutTabBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_tab, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f30233a;
    }
}
