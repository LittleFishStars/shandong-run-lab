package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contrarywind.view.WheelView;
import com.huachenjie.common.R;
import com.noober.background.view.BLRelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class PickerviewCustomOptionsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Button f33798a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WheelView f8728a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f8729a;

    @NonNull
    public final Button b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8730b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final WheelView f8731b;

    @NonNull
    public final WheelView c;

    public PickerviewCustomOptionsBinding(@NonNull LinearLayout rootView, @NonNull Button btnCancel, @NonNull Button btnSubmit, @NonNull WheelView options1, @NonNull WheelView options2, @NonNull WheelView options3, @NonNull LinearLayout optionspicker, @NonNull BLRelativeLayout rvTopbar, @NonNull TextView tvTitle) {
        this.f8726a = rootView;
        this.f33798a = btnCancel;
        this.b = btnSubmit;
        this.f8728a = options1;
        this.f8731b = options2;
        this.c = options3;
        this.f8730b = optionspicker;
        this.f8729a = rvTopbar;
        this.f8727a = tvTitle;
    }

    @NonNull
    public static PickerviewCustomOptionsBinding a(@NonNull View rootView) {
        BLRelativeLayout bLRelativeLayoutFindChildViewById;
        int i = R.id.btnCancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.btnSubmit;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button2 != null) {
                i = R.id.options1;
                WheelView wheelView = (WheelView) ViewBindings.findChildViewById(rootView, i);
                if (wheelView != null) {
                    i = R.id.options2;
                    WheelView wheelView2 = (WheelView) ViewBindings.findChildViewById(rootView, i);
                    if (wheelView2 != null) {
                        i = R.id.options3;
                        WheelView wheelView3 = (WheelView) ViewBindings.findChildViewById(rootView, i);
                        if (wheelView3 != null) {
                            i = R.id.optionspicker;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout != null && (bLRelativeLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.rv_topbar))) != null) {
                                i = R.id.tvTitle;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView != null) {
                                    return new PickerviewCustomOptionsBinding((LinearLayout) rootView, button, button2, wheelView, wheelView2, wheelView3, linearLayout, bLRelativeLayoutFindChildViewById, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static PickerviewCustomOptionsBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static PickerviewCustomOptionsBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.pickerview_custom_options, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f8726a;
    }
}
