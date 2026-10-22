package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class LayoutWebNetworkErrorSpineBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f33797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8725a;

    public LayoutWebNetworkErrorSpineBinding(@NonNull LinearLayout rootView, @NonNull BLTextView webNetErrorBt) {
        this.f33797a = rootView;
        this.f8725a = webNetErrorBt;
    }

    @NonNull
    public static LayoutWebNetworkErrorSpineBinding a(@NonNull View rootView) {
        int i = R.id.web_net_error_bt;
        BLTextView bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (bLTextViewFindChildViewById != null) {
            return new LayoutWebNetworkErrorSpineBinding((LinearLayout) rootView, bLTextViewFindChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static LayoutWebNetworkErrorSpineBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutWebNetworkErrorSpineBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_web_network_error_spine, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f33797a;
    }
}
