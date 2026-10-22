package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.student.StudentCardActivity;
import com.huachenjie.compat.page.student.StudentCardVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityStudentCardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f9162a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public StudentCardActivity.b f9163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public StudentCardVM f9164a;

    @NonNull
    public final TextView b;

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

    public ActivityStudentCardBinding(Object obj, View view, int i, View view2, ConstraintLayout constraintLayout, ImageView imageView, AvatarView avatarView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        super(obj, view, i);
        this.f34050a = view2;
        this.f9161a = constraintLayout;
        this.f9159a = imageView;
        this.f9162a = avatarView;
        this.f9160a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
        this.h = textView8;
    }

    public static ActivityStudentCardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityStudentCardBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityStudentCardBinding) ViewDataBinding.bind(obj, view, R.layout.activity_student_card);
    }

    @NonNull
    public static ActivityStudentCardBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityStudentCardBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityStudentCardBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityStudentCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_student_card, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityStudentCardBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityStudentCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_student_card, null, false, obj);
    }

    @Nullable
    public StudentCardActivity.b f() {
        return this.f9163a;
    }

    @Nullable
    public StudentCardVM g() {
        return this.f9164a;
    }

    public abstract void l(@Nullable StudentCardActivity.b bVar);

    public abstract void m(@Nullable StudentCardVM studentCardVM);
}
