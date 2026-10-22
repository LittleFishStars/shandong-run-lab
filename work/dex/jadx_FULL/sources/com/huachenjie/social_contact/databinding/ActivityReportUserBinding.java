package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.report.ReportUserActivity;
import com.huachenjie.social_contact.page.report.ReportUserVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityReportUserBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f36102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ReportUserActivity.a f12773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ReportUserVM f12774a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12775b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12776b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public ActivityReportUserBinding(Object obj, View view, int i, EditText editText, RecyclerView recyclerView, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f36102a = editText;
        this.f12772a = recyclerView;
        this.f12770a = linearLayout;
        this.b = linearLayout2;
        this.f12776b = recyclerView2;
        this.f12771a = textView;
        this.f12775b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static ActivityReportUserBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityReportUserBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityReportUserBinding) ViewDataBinding.bind(obj, view, R.layout.activity_report_user);
    }

    @NonNull
    public static ActivityReportUserBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityReportUserBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityReportUserBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityReportUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_report_user, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityReportUserBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityReportUserBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_report_user, null, false, obj);
    }

    @Nullable
    public ReportUserActivity.a f() {
        return this.f12773a;
    }

    @Nullable
    public ReportUserVM g() {
        return this.f12774a;
    }

    public abstract void l(@Nullable ReportUserActivity.a aVar);

    public abstract void m(@Nullable ReportUserVM reportUserVM);
}
