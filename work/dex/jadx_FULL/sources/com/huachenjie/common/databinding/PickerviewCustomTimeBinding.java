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
public final class PickerviewCustomTimeBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Button f33799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final WheelView f8734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f8735a;

    @NonNull
    public final Button b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8736b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final WheelView f8737b;

    @NonNull
    public final WheelView c;

    @NonNull
    public final WheelView d;

    @NonNull
    public final WheelView e;

    @NonNull
    public final WheelView f;

    public PickerviewCustomTimeBinding(@NonNull LinearLayout rootView, @NonNull Button btnCancel, @NonNull Button btnSubmit, @NonNull WheelView day, @NonNull WheelView hour, @NonNull WheelView min, @NonNull WheelView month, @NonNull BLRelativeLayout rvTopbar, @NonNull WheelView second, @NonNull LinearLayout timepicker, @NonNull TextView tvTitle, @NonNull WheelView year) {
        this.f8732a = rootView;
        this.f33799a = btnCancel;
        this.b = btnSubmit;
        this.f8734a = day;
        this.f8737b = hour;
        this.c = min;
        this.d = month;
        this.f8735a = rvTopbar;
        this.e = second;
        this.f8736b = timepicker;
        this.f8733a = tvTitle;
        this.f = year;
    }

    @NonNull
    public static PickerviewCustomTimeBinding a(@NonNull View rootView) {
        BLRelativeLayout bLRelativeLayoutFindChildViewById;
        int i = R.id.btnCancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.btnSubmit;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button2 != null) {
                i = R.id.day;
                WheelView wheelView = (WheelView) ViewBindings.findChildViewById(rootView, i);
                if (wheelView != null) {
                    i = R.id.hour;
                    WheelView wheelView2 = (WheelView) ViewBindings.findChildViewById(rootView, i);
                    if (wheelView2 != null) {
                        i = R.id.min;
                        WheelView wheelView3 = (WheelView) ViewBindings.findChildViewById(rootView, i);
                        if (wheelView3 != null) {
                            i = R.id.month;
                            WheelView wheelView4 = (WheelView) ViewBindings.findChildViewById(rootView, i);
                            if (wheelView4 != null && (bLRelativeLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.rv_topbar))) != null) {
                                i = R.id.second;
                                WheelView wheelView5 = (WheelView) ViewBindings.findChildViewById(rootView, i);
                                if (wheelView5 != null) {
                                    i = R.id.timepicker;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout != null) {
                                        i = R.id.tvTitle;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView != null) {
                                            i = R.id.year;
                                            WheelView wheelView6 = (WheelView) ViewBindings.findChildViewById(rootView, i);
                                            if (wheelView6 != null) {
                                                return new PickerviewCustomTimeBinding((LinearLayout) rootView, button, button2, wheelView, wheelView2, wheelView3, wheelView4, bLRelativeLayoutFindChildViewById, wheelView5, linearLayout, textView, wheelView6);
                                            }
                                        }
                                    }
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
    public static PickerviewCustomTimeBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static PickerviewCustomTimeBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.pickerview_custom_time, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f8732a;
    }
}
