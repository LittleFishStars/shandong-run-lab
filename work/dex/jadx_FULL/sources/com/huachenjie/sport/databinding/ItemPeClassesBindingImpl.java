package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.PEClassBean;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ItemPeClassesBindingImpl extends ItemPeClassesBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36520a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13619a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13622a;

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

    public ItemPeClassesBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f13619a, f36520a));
    }

    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x010e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0115 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x0117  */
    /* JADX WARN: Code duplicated, block: B:73:0x011e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0120  */
    /* JADX WARN: Code duplicated, block: B:79:0x012c  */
    /* JADX WARN: Code duplicated, block: B:81:0x012f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:82:0x0131  */
    /* JADX WARN: Code duplicated, block: B:83:0x0133  */
    /* JADX WARN: Code duplicated, block: B:86:0x013e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0662  */
    /* JADX WARN: Code duplicated, block: B:90:0x066d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0698  */
    /* JADX WARN: Code duplicated, block: B:95:0x06a9  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String subjectName;
        String teacherName;
        String str4;
        int iSafeUnbox;
        boolean z;
        boolean z2;
        boolean z3;
        int semesterStatus;
        boolean z4;
        long j2;
        boolean z5;
        Integer remainCount;
        String attendWeekDay;
        String semesterName;
        synchronized (this) {
            j = this.f13620a;
            this.f13620a = 0L;
        }
        PEClassBean pEClassBean = ((ItemPeClassesBinding) this).f13616a;
        Integer num = ((ItemPeClassesBinding) this).f13618a;
        String str5 = null;
        if ((j & 5) != 0) {
            if (pEClassBean != null) {
                String courseName = pEClassBean.getCourseName();
                String electiveEndDate = pEClassBean.getElectiveEndDate();
                subjectName = pEClassBean.getSubjectName();
                teacherName = pEClassBean.getTeacherName();
                remainCount = pEClassBean.getRemainCount();
                attendWeekDay = pEClassBean.getAttendWeekDay();
                semesterName = pEClassBean.getSemesterName();
                str5 = electiveEndDate;
                str3 = courseName;
            } else {
                str3 = null;
                subjectName = null;
                teacherName = null;
                remainCount = null;
                attendWeekDay = null;
                semesterName = null;
            }
            str5 = String.format("选课结束时间:%s", str5);
            str = remainCount + "人";
            str2 = attendWeekDay;
            str4 = semesterName;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            subjectName = null;
            teacherName = null;
            str4 = null;
        }
        if ((j & 7) != 0) {
            iSafeUnbox = ViewDataBinding.safeUnbox(num);
            if ((j & 6) != 0) {
                z2 = iSafeUnbox == 2;
                if ((j & 128) != 0) {
                    j = z2 ? j | 64 : j | 32;
                }
            } else {
                z2 = false;
            }
            boolean z6 = iSafeUnbox != 2;
            z3 = iSafeUnbox == 1;
            if ((j & 7) != 0) {
                j = z6 ? j | 16 : j | 8;
            }
            if ((j & 7) != 0) {
                j = z3 ? j | 256 : j | 128;
            }
            z = z6;
        } else {
            iSafeUnbox = 0;
            z = false;
            z2 = false;
            z3 = false;
        }
        long j3 = j & 128;
        if (j3 != 0) {
            z2 = iSafeUnbox == 2;
            if (j3 != 0) {
                j = z2 ? j | 64 : j | 32;
            }
        }
        boolean z7 = z2;
        if ((j & 16) != 0) {
            semesterStatus = pEClassBean != null ? pEClassBean.getSemesterStatus() : 0;
            z4 = semesterStatus == 2;
            j2 = j & 7;
            if (j2 != 0 || !z) {
                z4 = false;
            }
            if ((j & 64) == 0) {
                z5 = false;
            } else {
                if (pEClassBean != null) {
                    semesterStatus = pEClassBean.getSemesterStatus();
                }
                if (semesterStatus != 3) {
                    z5 = true;
                } else {
                    z5 = false;
                }
            }
            if ((j & 128) != 0 || !z7) {
                z5 = false;
            }
            if (j2 != 0) {
                z5 = false;
            } else if (z3) {
                z5 = true;
            }
            if ((j & 4) != 0) {
                LinearLayoutCompat linearLayoutCompat = this.f13621a;
                DrawablesBindingAdapter.h(linearLayoutCompat, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat, R.color.white)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
                DrawablesBindingAdapter.h(this.b, 0, -1051652, 0, 0.0f, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 13.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            }
            if ((5 & j) != 0) {
                TextViewBindingAdapter.setText(this.b, str3);
                TextViewBindingAdapter.setText(this.c, subjectName);
                TextViewBindingAdapter.setText(this.d, teacherName);
                TextViewBindingAdapter.setText(this.e, str2);
                TextViewBindingAdapter.setText(this.f, str4);
                TextViewBindingAdapter.setText(this.g, str5);
                TextViewBindingAdapter.setText(((ItemPeClassesBinding) this).f36519a, str);
            }
            if ((j & 6) != 0) {
                CommonBindingAdapter.l0(this.f, z7);
                CommonBindingAdapter.l0(this.g, z);
                CommonBindingAdapter.l0(((ItemPeClassesBinding) this).f13617a, z7);
            }
            if (j2 != 0) {
                CommonBindingAdapter.l0(this.f13622a, z5);
                boolean z8 = z4;
                CommonBindingAdapter.l0(this.h, z8);
                CommonBindingAdapter.l0(((ItemPeClassesBinding) this).f36519a, z8);
            }
        }
        semesterStatus = 0;
        j2 = j & 7;
        if (j2 != 0) {
            z4 = false;
        } else {
            z4 = false;
        }
        if ((j & 64) == 0) {
            z5 = false;
        } else {
            if (pEClassBean != null) {
                semesterStatus = pEClassBean.getSemesterStatus();
            }
            if (semesterStatus != 3) {
                z5 = true;
            } else {
                z5 = false;
            }
        }
        if ((j & 128) != 0) {
            z5 = false;
        } else {
            z5 = false;
        }
        if (j2 != 0) {
            z5 = false;
        } else if (z3) {
            z5 = true;
        }
        if ((j & 4) != 0) {
            LinearLayoutCompat linearLayoutCompat2 = this.f13621a;
            DrawablesBindingAdapter.h(linearLayoutCompat2, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat2, R.color.white)), 0, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            DrawablesBindingAdapter.h(this.b, 0, -1051652, 0, 0.0f, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 13.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if ((5 & j) != 0) {
            TextViewBindingAdapter.setText(this.b, str3);
            TextViewBindingAdapter.setText(this.c, subjectName);
            TextViewBindingAdapter.setText(this.d, teacherName);
            TextViewBindingAdapter.setText(this.e, str2);
            TextViewBindingAdapter.setText(this.f, str4);
            TextViewBindingAdapter.setText(this.g, str5);
            TextViewBindingAdapter.setText(((ItemPeClassesBinding) this).f36519a, str);
        }
        if ((j & 6) != 0) {
            CommonBindingAdapter.l0(this.f, z7);
            CommonBindingAdapter.l0(this.g, z);
            CommonBindingAdapter.l0(((ItemPeClassesBinding) this).f13617a, z7);
        }
        if (j2 != 0) {
            CommonBindingAdapter.l0(this.f13622a, z5);
            boolean z9 = z4;
            CommonBindingAdapter.l0(this.h, z9);
            CommonBindingAdapter.l0(((ItemPeClassesBinding) this).f36519a, z9);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13620a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13620a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemPeClassesBinding
    public void k(@Nullable Integer num) {
        ((ItemPeClassesBinding) this).f13618a = num;
        synchronized (this) {
            this.f13620a |= 2;
        }
        notifyPropertyChanged(ok0.o0);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ItemPeClassesBinding
    public void l(@Nullable PEClassBean pEClassBean) {
        ((ItemPeClassesBinding) this).f13616a = pEClassBean;
        synchronized (this) {
            this.f13620a |= 1;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            l((PEClassBean) obj);
        } else {
            if (ok0.o0 != i) {
                return false;
            }
            k((Integer) obj);
        }
        return true;
    }

    public ItemPeClassesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[8], (BLTextView) objArr[10]);
        this.f13620a = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13621a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.c = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.d = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.e = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[5];
        this.f = textView5;
        textView5.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[6];
        this.f13622a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView6 = (TextView) objArr[7];
        this.g = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[9];
        this.h = textView7;
        textView7.setTag(null);
        ((ItemPeClassesBinding) this).f36519a.setTag(null);
        ((ItemPeClassesBinding) this).f13617a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
