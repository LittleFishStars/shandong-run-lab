package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.bean.RunRecordStatusLog;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemRunRecordStatusBinding extends ViewDataBinding {

    @Bindable
    public int K;

    @Bindable
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunRecordStatusLog f11967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public boolean f11968a;

    @Bindable
    public boolean b;

    @Bindable
    public boolean c;

    @Bindable
    public boolean d;

    @Bindable
    public boolean e;

    @Bindable
    public String f;

    @Bindable
    public String g;

    @Bindable
    public String h;

    @Bindable
    public String i;

    @Bindable
    public String j;

    public RunItemRunRecordStatusBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvFace) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35631a = rvFace;
    }

    public static RunItemRunRecordStatusBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemRunRecordStatusBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemRunRecordStatusBinding) ViewDataBinding.bind(component, view, R.layout.run_item_run_record_status);
    }

    @NonNull
    public static RunItemRunRecordStatusBinding t(@NonNull LayoutInflater inflater) {
        return w(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemRunRecordStatusBinding u(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return v(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemRunRecordStatusBinding v(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemRunRecordStatusBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_run_record_status, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemRunRecordStatusBinding w(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemRunRecordStatusBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_run_record_status, null, false, component);
    }

    public abstract void A(boolean showAppealTime);

    public abstract void B(boolean showContent);

    public abstract void C(boolean showFace);

    public abstract void D(boolean showGradient);

    public abstract void E(boolean showTag);

    public abstract void F(int tagBg);

    public abstract void G(@Nullable String tagText);

    public abstract void H(@Nullable String time);

    public abstract void I(@Nullable String title);

    @Nullable
    public String f() {
        return this.i;
    }

    @Nullable
    public RunRecordStatusLog g() {
        return this.f11967a;
    }

    @Nullable
    public String getContent() {
        return this.j;
    }

    @Nullable
    public String getTitle() {
        return this.f;
    }

    public int h() {
        return this.K;
    }

    public boolean j() {
        return this.c;
    }

    public boolean k() {
        return this.d;
    }

    public boolean l() {
        return this.e;
    }

    public boolean o() {
        return this.b;
    }

    public boolean p() {
        return this.f11968a;
    }

    public int q() {
        return this.L;
    }

    @Nullable
    public String r() {
        return this.g;
    }

    @Nullable
    public String s() {
        return this.h;
    }

    public abstract void setContent(@Nullable String content);

    public abstract void x(@Nullable String appealTime);

    public abstract void y(@Nullable RunRecordStatusLog bean);

    public abstract void z(int cardBg);
}
