package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.compat.R;
import com.huachenjie.compat.bean.CourseInfo;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ItemStudentCourseBindingImpl extends ItemStudentCourseBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9213a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f9215a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34072a = sparseIntArray;
        sparseIntArray.put(R.id.titleCourseName, 5);
    }

    public ItemStudentCourseBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f9213a, f34072a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String teacherName;
        String subjectName;
        String courseName;
        String attendWeekDay;
        synchronized (this) {
            j = this.f9214a;
            this.f9214a = 0L;
        }
        CourseInfo courseInfo = ((ItemStudentCourseBinding) this).f9211a;
        long j2 = j & 3;
        if (j2 == 0 || courseInfo == null) {
            teacherName = null;
            subjectName = null;
            courseName = null;
            attendWeekDay = null;
        } else {
            teacherName = courseInfo.getTeacherName();
            subjectName = courseInfo.getSubjectName();
            courseName = courseInfo.getCourseName();
            attendWeekDay = courseInfo.getAttendWeekDay();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(((ItemStudentCourseBinding) this).f34071a, attendWeekDay);
            TextViewBindingAdapter.setText(this.b, courseName);
            TextViewBindingAdapter.setText(this.c, subjectName);
            TextViewBindingAdapter.setText(this.d, teacherName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9214a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9214a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ItemStudentCourseBinding
    public void k(@Nullable CourseInfo courseInfo) {
        ((ItemStudentCourseBinding) this).f9211a = courseInfo;
        synchronized (this) {
            this.f9214a |= 1;
        }
        notifyPropertyChanged(wk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.g != i) {
            return false;
        }
        k((CourseInfo) obj);
        return true;
    }

    public ItemStudentCourseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (BLTextView) objArr[5], (TextView) objArr[4], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[3]);
        this.f9214a = -1L;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[0];
        this.f9215a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ((ItemStudentCourseBinding) this).f34071a.setTag(null);
        this.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
