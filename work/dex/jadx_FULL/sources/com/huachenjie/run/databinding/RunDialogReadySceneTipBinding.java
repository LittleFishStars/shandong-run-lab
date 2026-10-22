package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.huachenjie.run.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class RunDialogReadySceneTipBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckBox f35557a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11774a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedScrollView f11777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11778a;

    @NonNull
    public final LinearLayout b;

    public RunDialogReadySceneTipBinding(@NonNull FrameLayout rootView, @NonNull CheckBox cbDontRemind, @NonNull LinearLayout llBody, @NonNull LinearLayout llDontRemind, @NonNull NestedScrollView svBody, @NonNull BLTextView tvKnow, @NonNull TextView tvTitle) {
        this.f11774a = rootView;
        this.f35557a = cbDontRemind;
        this.f11775a = llBody;
        this.b = llDontRemind;
        this.f11777a = svBody;
        this.f11778a = tvKnow;
        this.f11776a = tvTitle;
    }

    @NonNull
    public static RunDialogReadySceneTipBinding a(@NonNull View rootView) {
        BLTextView bLTextViewFindChildViewById;
        int i = R.id.cbDontRemind;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(rootView, i);
        if (checkBox != null) {
            i = R.id.llBody;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.llDontRemind;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout2 != null) {
                    i = R.id.svBody;
                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(rootView, i);
                    if (nestedScrollView != null && (bLTextViewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.tvKnow))) != null) {
                        i = R.id.tvTitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            return new RunDialogReadySceneTipBinding((FrameLayout) rootView, checkBox, linearLayout, linearLayout2, nestedScrollView, bLTextViewFindChildViewById, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }

    @NonNull
    public static RunDialogReadySceneTipBinding c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static RunDialogReadySceneTipBinding d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.run_dialog_ready_scene_tip, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f11774a;
    }
}
