package com.huachenjie.sport.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.bean.ClassDetailBean;
import com.huachenjie.sport.page.mine.choose_classes.ClassesDetailActivity;
import com.huachenjie.sport.page.mine.choose_classes.ClassesDetailVM;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityClassesDetailBindingImpl extends ActivityClassesDetailBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36384a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13177a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final View f13179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13180a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13183a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13184b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13185b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13186c;

    @NonNull
    public final TextView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13187d;

    @NonNull
    public final TextView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13188e;

    @NonNull
    public final TextView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13189f;

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

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ClassesDetailActivity.a f36385a;

        public a a(ClassesDetailActivity.a aVar) {
            this.f36385a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36385a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(20);
        f13177a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{19}, new int[]{R.layout.layout_toolbar_binding});
        f36384a = null;
    }

    public ActivityClassesDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, f13177a, f36384a));
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0192  */
    /* JADX WARN: Code duplicated, block: B:27:0x0065  */
    /* JADX WARN: Code duplicated, block: B:65:0x011d  */
    /* JADX WARN: Code duplicated, block: B:74:0x0139  */
    /* JADX WARN: Code duplicated, block: B:83:0x0157  */
    /* JADX WARN: Code duplicated, block: B:92:0x0173  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        String subjectName;
        String str;
        boolean zSafeUnbox;
        String attendWeekDay;
        String semesterName;
        String courseIntroduction;
        String value2;
        String courseName;
        BindingTitleBean value3;
        String courseLocation;
        ClassDetailBean value4;
        MutableLiveData<ClassDetailBean> mutableLiveDataM;
        Integer value5;
        String value6;
        boolean zSafeUnbox2;
        boolean z;
        String electiveEndDate;
        boolean z2;
        Integer value7;
        a aVarA;
        boolean z3;
        boolean zSafeUnbox3;
        String teacherName;
        synchronized (this) {
            j = this.f13178a;
            this.f13178a = 0L;
        }
        ClassesDetailVM classesDetailVM = ((ActivityClassesDetailBinding) this).f13176a;
        ClassesDetailActivity.a aVar = ((ActivityClassesDetailBinding) this).f36383a;
        if ((6143 & j) != 0) {
            if ((j & 5121) != 0) {
                MediatorLiveData<Boolean> mediatorLiveDataB = classesDetailVM != null ? classesDetailVM.B() : null;
                updateLiveDataRegistration(0, mediatorLiveDataB);
                zSafeUnbox3 = ViewDataBinding.safeUnbox(mediatorLiveDataB != null ? mediatorLiveDataB.getValue() : null);
            } else {
                zSafeUnbox3 = false;
            }
            if ((j & 5122) == 0) {
                value5 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataK = classesDetailVM != null ? classesDetailVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value5 = mutableLiveDataK.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 5124) != 0) {
                mutableLiveDataM = classesDetailVM != null ? classesDetailVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                value4 = mutableLiveDataM != null ? mutableLiveDataM.getValue() : null;
                if (value4 != null) {
                    courseName = value4.getCourseName();
                    courseLocation = value4.getCourseLocation();
                    courseIntroduction = value4.getCourseIntroduction();
                    semesterName = value4.getSemesterName();
                    attendWeekDay = value4.getAttendWeekDay();
                    electiveEndDate = value4.getElectiveEndDate();
                    subjectName = value4.getSubjectName();
                    teacherName = value4.getTeacherName();
                } else {
                    courseName = null;
                    courseLocation = null;
                    courseIntroduction = null;
                    semesterName = null;
                    attendWeekDay = null;
                    electiveEndDate = null;
                    subjectName = null;
                    teacherName = null;
                }
                z2 = !TextUtils.isEmpty(electiveEndDate);
            } else {
                mutableLiveDataM = null;
                value4 = null;
                courseName = null;
                courseLocation = null;
                courseIntroduction = null;
                semesterName = null;
                attendWeekDay = null;
                electiveEndDate = null;
                subjectName = null;
                teacherName = null;
                z2 = false;
            }
            long j2 = j & 5132;
            if (j2 != 0) {
                MediatorLiveData<Boolean> mediatorLiveDataC = classesDetailVM != null ? classesDetailVM.C() : null;
                updateLiveDataRegistration(3, mediatorLiveDataC);
                zSafeUnbox = ViewDataBinding.safeUnbox(mediatorLiveDataC != null ? mediatorLiveDataC.getValue() : null);
                if (j2 != 0) {
                    j = zSafeUnbox ? j | PlaybackStateCompat.ACTION_PREPARE : j | 8192;
                }
            } else {
                zSafeUnbox = false;
            }
            if ((j & 5136) == 0) {
                value6 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataJ = classesDetailVM != null ? classesDetailVM.j() : null;
                updateLiveDataRegistration(4, mediatorLiveDataJ);
                if (mediatorLiveDataJ != null) {
                    value6 = mediatorLiveDataJ.getValue();
                } else {
                    value6 = null;
                }
            }
            if ((j & 5152) == 0) {
                value2 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataT = classesDetailVM != null ? classesDetailVM.t() : null;
                updateLiveDataRegistration(5, mediatorLiveDataT);
                if (mediatorLiveDataT != null) {
                    value2 = mediatorLiveDataT.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 5184) == 0) {
                value7 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataI = classesDetailVM != null ? classesDetailVM.i() : null;
                updateLiveDataRegistration(6, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value7 = mutableLiveDataI.getValue();
                } else {
                    value7 = null;
                }
            }
            if ((j & 5248) == 0) {
                value3 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataY = classesDetailVM != null ? classesDetailVM.y() : null;
                updateLiveDataRegistration(7, mutableLiveDataY);
                if (mutableLiveDataY != null) {
                    value3 = mutableLiveDataY.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 5376) == 0) {
                value = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataL = classesDetailVM != null ? classesDetailVM.l() : null;
                updateLiveDataRegistration(8, mediatorLiveDataL);
                if (mediatorLiveDataL != null) {
                    value = mediatorLiveDataL.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 5632) != 0) {
                MediatorLiveData<Boolean> mediatorLiveDataA = classesDetailVM != null ? classesDetailVM.A() : null;
                updateLiveDataRegistration(9, mediatorLiveDataA);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mediatorLiveDataA != null ? mediatorLiveDataA.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            z = zSafeUnbox3;
            str = teacherName;
        } else {
            value = null;
            subjectName = null;
            str = null;
            zSafeUnbox = false;
            attendWeekDay = null;
            semesterName = null;
            courseIntroduction = null;
            value2 = null;
            courseName = null;
            value3 = null;
            courseLocation = null;
            value4 = null;
            mutableLiveDataM = null;
            value5 = null;
            value6 = null;
            zSafeUnbox2 = false;
            z = false;
            electiveEndDate = null;
            z2 = false;
            value7 = null;
        }
        long j3 = j & 6144;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f13183a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13183a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE) != 0) {
            MutableLiveData<ClassDetailBean> mutableLiveDataM2 = classesDetailVM != null ? classesDetailVM.m() : mutableLiveDataM;
            updateLiveDataRegistration(2, mutableLiveDataM2);
            if (mutableLiveDataM2 != null) {
                value4 = mutableLiveDataM2.getValue();
            }
            if (value4 != null) {
                electiveEndDate = value4.getElectiveEndDate();
            }
            z2 = !TextUtils.isEmpty(electiveEndDate);
        }
        String str2 = electiveEndDate;
        boolean z4 = z2;
        long j4 = j & 5132;
        if (j4 != 0) {
            z3 = zSafeUnbox ? z4 : false;
        } else {
            z3 = false;
        }
        if ((j & 5248) != 0) {
            this.f13182a.k(value3);
        }
        if ((j & 4096) != 0) {
            LinearLayoutCompat linearLayoutCompat = this.f13185b;
            int i = com.huachenjie.sport.R.color.white;
            DrawablesBindingAdapter.h(linearLayoutCompat, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat, i)), 0, 0.0f, 0.0f, 0.0f, 12.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            LinearLayoutCompat linearLayoutCompat2 = this.f13187d;
            DrawablesBindingAdapter.h(linearLayoutCompat2, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat2, i)), 0, 0.0f, 0.0f, 0.0f, 12.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
            LinearLayoutCompat linearLayoutCompat3 = this.f13188e;
            DrawablesBindingAdapter.h(linearLayoutCompat3, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(linearLayoutCompat3, i)), 0, 0.0f, 0.0f, 0.0f, 12.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if (j4 != 0) {
            CommonBindingAdapter.l0(this.f13179a, z3);
        }
        if ((j & 5124) != 0) {
            CommonBindingAdapter.l0(this.f13186c, z4);
            TextViewBindingAdapter.setText(this.f13180a, str2);
            TextViewBindingAdapter.setText(this.d, courseIntroduction);
            TextViewBindingAdapter.setText(this.f, courseName);
            TextViewBindingAdapter.setText(this.g, subjectName);
            TextViewBindingAdapter.setText(this.h, str);
            TextViewBindingAdapter.setText(this.i, semesterName);
            TextViewBindingAdapter.setText(this.j, attendWeekDay);
            TextViewBindingAdapter.setText(this.k, courseLocation);
        }
        if ((5376 & j) != 0) {
            TextViewBindingAdapter.setText(this.f13184b, value);
        }
        if ((5152 & j) != 0) {
            TextViewBindingAdapter.setText(this.c, value2);
        }
        if ((j & 5121) != 0) {
            CommonBindingAdapter.l0(this.f13188e, z);
        }
        if ((5632 & j) != 0) {
            CommonBindingAdapter.l0(this.e, zSafeUnbox2);
        }
        if ((j & 5136) != 0) {
            TextViewBindingAdapter.setText(this.e, value6);
        }
        if ((j & 5122) != 0) {
            CommonBindingAdapter.V(this.e, value5);
        }
        if ((5184 & j) != 0) {
            DrawablesBindingAdapter.h(this.e, 0, value7, 0, 0.0f, 0.0f, 0.0f, 8.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.e, aVarA, null);
        }
        if ((j & 5128) != 0) {
            boolean z5 = zSafeUnbox;
            CommonBindingAdapter.l0(this.b, z5);
            CommonBindingAdapter.l0(this.f13189f, z5);
        }
        ViewDataBinding.executeBindingsOn(this.f13182a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13178a != 0) {
                return true;
            }
            return this.f13182a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13178a = 4096L;
        }
        this.f13182a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityClassesDetailBinding
    public void l(@Nullable ClassesDetailActivity.a aVar) {
        ((ActivityClassesDetailBinding) this).f36383a = aVar;
        synchronized (this) {
            this.f13178a |= 2048;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityClassesDetailBinding
    public void m(@Nullable ClassesDetailVM classesDetailVM) {
        ((ActivityClassesDetailBinding) this).f13176a = classesDetailVM;
        synchronized (this) {
            this.f13178a |= 1024;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13178a |= 64;
        }
        return true;
    }

    public final boolean o(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13178a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return t((MediatorLiveData) obj, i2);
            case 1:
                return p((MutableLiveData) obj, i2);
            case 2:
                return r((MutableLiveData) obj, i2);
            case 3:
                return u((MediatorLiveData) obj, i2);
            case 4:
                return o((MediatorLiveData) obj, i2);
            case 5:
                return v((MediatorLiveData) obj, i2);
            case 6:
                return n((MutableLiveData) obj, i2);
            case 7:
                return w((MutableLiveData) obj, i2);
            case 8:
                return q((MediatorLiveData) obj, i2);
            case 9:
                return s((MediatorLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13178a |= 2;
        }
        return true;
    }

    public final boolean q(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13178a |= 256;
        }
        return true;
    }

    public final boolean r(MutableLiveData<ClassDetailBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13178a |= 4;
        }
        return true;
    }

    public final boolean s(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13178a |= 512;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13182a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((ClassesDetailVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((ClassesDetailActivity.a) obj);
        }
        return true;
    }

    public final boolean t(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13178a |= 1;
        }
        return true;
    }

    public final boolean u(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13178a |= 8;
        }
        return true;
    }

    public final boolean v(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13178a |= 32;
        }
        return true;
    }

    public final boolean w(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13178a |= 128;
        }
        return true;
    }

    public ActivityClassesDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10);
        this.f13178a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[19];
        this.f13182a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13181a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) objArr[1];
        this.f13185b = linearLayoutCompat2;
        linearLayoutCompat2.setTag(null);
        View view2 = (View) objArr[10];
        this.f13179a = view2;
        view2.setTag(null);
        LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) objArr[11];
        this.f13186c = linearLayoutCompat3;
        linearLayoutCompat3.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.f13180a = textView;
        textView.setTag(null);
        LinearLayoutCompat linearLayoutCompat4 = (LinearLayoutCompat) objArr[13];
        this.f13187d = linearLayoutCompat4;
        linearLayoutCompat4.setTag(null);
        TextView textView2 = (TextView) objArr[14];
        this.f13184b = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[15];
        this.c = textView3;
        textView3.setTag(null);
        LinearLayoutCompat linearLayoutCompat5 = (LinearLayoutCompat) objArr[16];
        this.f13188e = linearLayoutCompat5;
        linearLayoutCompat5.setTag(null);
        TextView textView4 = (TextView) objArr[17];
        this.d = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[18];
        this.e = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[2];
        this.f = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[3];
        this.g = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[4];
        this.h = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[5];
        this.i = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[6];
        this.j = textView10;
        textView10.setTag(null);
        View view3 = (View) objArr[7];
        this.b = view3;
        view3.setTag(null);
        LinearLayoutCompat linearLayoutCompat6 = (LinearLayoutCompat) objArr[8];
        this.f13189f = linearLayoutCompat6;
        linearLayoutCompat6.setTag(null);
        TextView textView11 = (TextView) objArr[9];
        this.k = textView11;
        textView11.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
