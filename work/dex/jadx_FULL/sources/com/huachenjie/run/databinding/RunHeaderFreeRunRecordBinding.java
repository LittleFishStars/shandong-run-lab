package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.widget.CustomerTextView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunHeaderFreeRunRecordBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CustomerTextView f11909a;

    @NonNull
    public final CustomerTextView b;

    @NonNull
    public final CustomerTextView c;

    @NonNull
    public final CustomerTextView d;

    public RunHeaderFreeRunRecordBinding(@NonNull RelativeLayout rootView, @NonNull ImageView runImgStopWatch, @NonNull CustomerTextView tvBestPace, @NonNull CustomerTextView tvBurnedCalories, @NonNull CustomerTextView tvCostedTime, @NonNull CustomerTextView tvTotalDistance) {
        this.f11908a = rootView;
        this.f35604a = runImgStopWatch;
        this.f11909a = tvBestPace;
        this.b = tvBurnedCalories;
        this.c = tvCostedTime;
        this.d = tvTotalDistance;
    }

    @NonNull
    public static RunHeaderFreeRunRecordBinding a(@NonNull View rootView) {
        int i = R.id.run_img_stop_watch;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.tv_best_pace;
            CustomerTextView customerTextView = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
            if (customerTextView != null) {
                i = R.id.tv_burned_calories;
                CustomerTextView customerTextView2 = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
                if (customerTextView2 != null) {
                    i = R.id.tv_costed_time;
                    CustomerTextView customerTextView3 = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
                    if (customerTextView3 != null) {
                        i = R.id.tv_total_distance;
                        CustomerTextView customerTextView4 = (CustomerTextView) ViewBindings.findChildViewById(rootView, i);
                        if (customerTextView4 != null) {
                            return new RunHeaderFreeRunRecordBinding((RelativeLayout) rootView, imageView, customerTextView, customerTextView2, customerTextView3, customerTextView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunHeaderFreeRunRecordBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunHeaderFreeRunRecordBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_header_free_run_record, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f11908a;
    }
}
