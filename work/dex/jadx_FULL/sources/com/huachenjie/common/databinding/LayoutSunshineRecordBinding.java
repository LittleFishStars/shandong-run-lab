package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.common.R;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class LayoutSunshineRecordBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f33784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f8690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f8694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8695a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f8696b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final TextView p;

    public LayoutSunshineRecordBinding(@NonNull RelativeLayout rootView, @NonNull ImageView imgRunThumb, @NonNull TextView ivMorning, @NonNull TextView ivStatus, @NonNull LinearLayout llDesc, @NonNull BLLinearLayout llStatus, @NonNull LinearLayout llTotal, @NonNull TextView tvActivity, @NonNull TextView tvActivityRun, @NonNull TextView tvCalories, @NonNull TextView tvDateTime, @NonNull TextView tvDuration, @NonNull TextView tvErrorBtn, @NonNull TextView tvErrorInfo, @NonNull TextView tvFreeRunStatus, @NonNull TextView tvPace, @NonNull TextView tvRunDistance, @NonNull TextView tvRunDistanceUnit, @NonNull TextView tvScene, @NonNull TextView tvTotal, @NonNull BLTextView tvUnexpectedData, @NonNull TextView tvVisioning, @NonNull View vScene) {
        this.f8692a = rootView;
        this.f8690a = imgRunThumb;
        this.f8693a = ivMorning;
        this.f8696b = ivStatus;
        this.f8691a = llDesc;
        this.f8694a = llStatus;
        this.b = llTotal;
        this.c = tvActivity;
        this.d = tvActivityRun;
        this.e = tvCalories;
        this.f = tvDateTime;
        this.g = tvDuration;
        this.h = tvErrorBtn;
        this.i = tvErrorInfo;
        this.j = tvFreeRunStatus;
        this.k = tvPace;
        this.l = tvRunDistance;
        this.m = tvRunDistanceUnit;
        this.n = tvScene;
        this.o = tvTotal;
        this.f8695a = tvUnexpectedData;
        this.p = tvVisioning;
        this.f33784a = vScene;
    }

    @NonNull
    public static LayoutSunshineRecordBinding a(@NonNull View rootView) {
        BLLinearLayout bLLinearLayoutFindChildViewById;
        BLTextView bLTextViewFindChildViewById;
        View viewFindChildViewById;
        int i = R.id.img_run_thumb;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.iv_morning;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.iv_status;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.ll_desc;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null && (bLLinearLayoutFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.llStatus))) != null) {
                        i = R.id.ll_total;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout2 != null) {
                            i = R.id.tv_activity;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.tvActivityRun;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.tv_calories;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.tvDateTime;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView6 != null) {
                                            i = R.id.tv_duration;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView7 != null) {
                                                i = R.id.tvErrorBtn;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView8 != null) {
                                                    i = R.id.tvErrorInfo;
                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView9 != null) {
                                                        i = R.id.tvFreeRunStatus;
                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView10 != null) {
                                                            i = R.id.tv_pace;
                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView11 != null) {
                                                                i = R.id.tv_run_distance;
                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView12 != null) {
                                                                    i = R.id.tv_run_distance_unit;
                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView13 != null) {
                                                                        i = R.id.tv_scene;
                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView14 != null) {
                                                                            i = R.id.tv_total;
                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView15 != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tvUnexpectedData))) != null) {
                                                                                i = R.id.tv_visioning;
                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView16 != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.v_scene))) != null) {
                                                                                    return new LayoutSunshineRecordBinding((RelativeLayout) rootView, imageView, textView, textView2, linearLayout, bLLinearLayoutFindChildViewById, linearLayout2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, bLTextViewFindChildViewById, textView16, viewFindChildViewById);
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
    public static LayoutSunshineRecordBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static LayoutSunshineRecordBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.layout_sunshine_record, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f8692a;
    }
}
