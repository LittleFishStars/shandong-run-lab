package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.run.R;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemIndexRecordBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Group f11940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SportRecord f11941a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11942a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f11943a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final Group f11944b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f11945b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f11946b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLTextView f11947c;

    @NonNull
    public final TextView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final BLTextView f11948d;

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

    public RunItemIndexRecordBinding(Object _bindingComponent, View _root, int _localFieldCount, Group groupAppeal, Group groupScene, BLTextView ivMorning, BLTextView ivStatus, BLTextView tvActivityRun, TextView tvCalories, TextView tvDateTime, TextView tvDuration, TextView tvErrorBtn, TextView tvErrorInfo, TextView tvPace, TextView tvRunDistance, TextView tvRunDistanceUnit, TextView tvScene, TextView tvTotal, BLTextView tvVisioning, BLView vAppealDivider, BLView vScene) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11940a = groupAppeal;
        this.f11944b = groupScene;
        this.f11942a = ivMorning;
        this.f11945b = ivStatus;
        this.f11947c = tvActivityRun;
        this.f35620a = tvCalories;
        this.b = tvDateTime;
        this.c = tvDuration;
        this.d = tvErrorBtn;
        this.e = tvErrorInfo;
        this.f = tvPace;
        this.g = tvRunDistance;
        this.h = tvRunDistanceUnit;
        this.i = tvScene;
        this.j = tvTotal;
        this.f11948d = tvVisioning;
        this.f11943a = vAppealDivider;
        this.f11946b = vScene;
    }

    public static RunItemIndexRecordBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemIndexRecordBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemIndexRecordBinding) ViewDataBinding.bind(component, view, R.layout.run_item_index_record);
    }

    @NonNull
    public static RunItemIndexRecordBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemIndexRecordBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemIndexRecordBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemIndexRecordBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_index_record, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemIndexRecordBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemIndexRecordBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_index_record, null, false, component);
    }

    @Nullable
    public SportRecord f() {
        return this.f11941a;
    }

    public abstract void k(@Nullable SportRecord bean);
}
