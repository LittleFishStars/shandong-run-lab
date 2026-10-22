package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.sport.R;
import com.huachenjie.sport.widget.ProgressBarView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class DialogExamNotFinishTipBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ProgressBarView f13396a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public DialogExamNotFinishTipBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ProgressBarView progressBarView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.f13395a = constraintLayout;
        this.f36447a = textView;
        this.b = textView2;
        this.f13396a = progressBarView;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
    }

    @NonNull
    public static DialogExamNotFinishTipBinding a(@NonNull View view) {
        int i = R.id.bt_left;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bt_right;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.progress;
                ProgressBarView progressBarView = (ProgressBarView) ViewBindings.findChildViewById(view, i);
                if (progressBarView != null) {
                    i = R.id.tv_exam_process;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tv_max;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.tv_process;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                return new DialogExamNotFinishTipBinding((ConstraintLayout) view, textView, textView2, progressBarView, textView3, textView4, textView5);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogExamNotFinishTipBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogExamNotFinishTipBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_exam_not_finish_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f13395a;
    }
}
