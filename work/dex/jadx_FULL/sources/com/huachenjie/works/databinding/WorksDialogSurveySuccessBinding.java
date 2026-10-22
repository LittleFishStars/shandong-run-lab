package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogSurveySuccessBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f14132a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseViewModel f14134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f14135a;

    public WorksDialogSurveySuccessBinding(Object _bindingComponent, View _root, int _localFieldCount, BLTextView btClose, ImageView ivImage, LinearLayout llContainer, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14135a = btClose;
        this.f36887a = ivImage;
        this.f14132a = llContainer;
        this.f14133a = tvName;
    }

    public static WorksDialogSurveySuccessBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogSurveySuccessBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogSurveySuccessBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_survey_success);
    }

    @NonNull
    public static WorksDialogSurveySuccessBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogSurveySuccessBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogSurveySuccessBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogSurveySuccessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_survey_success, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogSurveySuccessBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogSurveySuccessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_survey_success, null, false, component);
    }

    @Nullable
    public BaseViewModel f() {
        return this.f14134a;
    }

    public abstract void k(@Nullable BaseViewModel vm);
}
