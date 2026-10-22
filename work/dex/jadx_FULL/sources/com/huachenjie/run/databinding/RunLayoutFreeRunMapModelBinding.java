package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.databinding.LayoutGpsSignalBinding;
import com.huachenjie.common.widget.BackgroundChronometer;
import com.huachenjie.common.widget.CustomerTextView;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunLayoutFreeRunMapModelBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f35661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutGpsSignalBinding f12045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BackgroundChronometer f12046a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f12047a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f12048a;

    @NonNull
    public final RelativeLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12049b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f12050b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f12051b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public RunLayoutFreeRunMapModelBinding(@NonNull RelativeLayout rootView, @NonNull RelativeLayout rlMapModel, @NonNull LayoutGpsSignalBinding signalLayout, @NonNull ShadowLayout slRelocation, @NonNull ShadowLayout slStatics, @NonNull TextView tvAccuracy, @NonNull TextView tvCaloriesTitle, @NonNull CustomerTextView tvCaloriesValue, @NonNull TextView tvDistanceTitle, @NonNull CustomerTextView tvDistanceValue, @NonNull TextView tvDurationTitle, @NonNull BackgroundChronometer tvDurationValue, @NonNull TextView tvSignCount) {
        this.f35661a = rootView;
        this.b = rlMapModel;
        this.f12045a = signalLayout;
        this.f12048a = slRelocation;
        this.f12051b = slStatics;
        this.f12044a = tvAccuracy;
        this.f12049b = tvCaloriesTitle;
        this.f12047a = tvCaloriesValue;
        this.c = tvDistanceTitle;
        this.f12050b = tvDistanceValue;
        this.d = tvDurationTitle;
        this.f12046a = tvDurationValue;
        this.e = tvSignCount;
    }

    @NonNull
    public static RunLayoutFreeRunMapModelBinding a(@NonNull View rootView) {
        RelativeLayout relativeLayout = (RelativeLayout) rootView;
        int i = R.id.signalLayout;
        View viewFindChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (viewFindChildViewById != null) {
            LayoutGpsSignalBinding layoutGpsSignalBindingA = LayoutGpsSignalBinding.a(viewFindChildViewById);
            i = R.id.sl_relocation;
            ShadowLayout shadowLayout = (ShadowLayout) ViewBindings.findChildViewById(rootView, i);
            if (shadowLayout != null) {
                i = R.id.sl_statics;
                ShadowLayout shadowLayout2 = (ShadowLayout) ViewBindings.findChildViewById(rootView, i);
                if (shadowLayout2 != null) {
                    i = R.id.tvAccuracy;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.tv_calories_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.tv_calories_value;
                            CustomerTextView customerTextView = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
                            if (customerTextView != null) {
                                i = R.id.tv_distance_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.tv_distance_value;
                                    CustomerTextView customerTextView2 = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
                                    if (customerTextView2 != null) {
                                        i = R.id.tv_duration_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            i = R.id.tv_duration_value;
                                            BackgroundChronometer backgroundChronometer = (BackgroundChronometer) ViewBindings.findChildViewById(rootView, i);
                                            if (backgroundChronometer != null) {
                                                i = R.id.tvSignCount;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView5 != null) {
                                                    return new RunLayoutFreeRunMapModelBinding(relativeLayout, relativeLayout, layoutGpsSignalBindingA, shadowLayout, shadowLayout2, textView, textView2, customerTextView, textView3, customerTextView2, textView4, backgroundChronometer, textView5);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunLayoutFreeRunMapModelBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunLayoutFreeRunMapModelBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_layout_free_run_map_model, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f35661a;
    }
}
