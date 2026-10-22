package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.bean.StudentCard;
import com.huachenjie.compat.page.student.StudentCardActivity;
import com.huachenjie.compat.page.student.StudentCardVM;
import com.huachenjie.compat.page.student.StudentCourseAdapter;
import com.zj.adlib.aw9;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ActivityStudentCardBindingImpl extends ActivityStudentCardBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f9168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9169a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9170a;

    @NonNull
    public final ConstraintLayout b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public StudentCardActivity.b f34052a;

        public a a(StudentCardActivity.b bVar) {
            this.f34052a = bVar;
            if (bVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34052a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public StudentCardActivity.b f34053a;

        public b a(StudentCardActivity.b bVar) {
            this.f34053a = bVar;
            if (bVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34053a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(15);
        f9165a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{12}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34051a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.compat.R.id.cl_student_card, 13);
        sparseIntArray.put(com.huachenjie.compat.R.id.iv_bg, 14);
    }

    public ActivityStudentCardBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, f9165a, f34051a));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ec  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        StudentCourseAdapter value;
        boolean zSafeUnbox;
        String str;
        String str2;
        String userName;
        String studentNumber;
        String str3;
        String str4;
        BindingTitleBean value2;
        String departmentName;
        String str5;
        b bVarA;
        a aVarA;
        String gradeName;
        String schoolName;
        String className;
        String avatar;
        String avatarFrameImgUrl;
        MutableLiveData<StudentCourseAdapter> mutableLiveData;
        MutableLiveData<CommonUserInfo> mutableLiveData2;
        CommonUserInfo value3;
        SchoolInfo schoolInfo;
        synchronized (this) {
            j = this.f9166a;
            this.f9166a = 0L;
        }
        StudentCardVM studentCardVM = ((ActivityStudentCardBinding) this).f9164a;
        StudentCardActivity.b bVar = ((ActivityStudentCardBinding) this).f9163a;
        if ((191 & j) != 0) {
            if ((j & 161) != 0) {
                MutableLiveData<Boolean> mutableLiveData3 = studentCardVM != null ? studentCardVM.l : null;
                updateLiveDataRegistration(0, mutableLiveData3);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData3 != null ? mutableLiveData3.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 162) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveData4 = studentCardVM != null ? studentCardVM.i : null;
                updateLiveDataRegistration(1, mutableLiveData4);
                if (mutableLiveData4 != null) {
                    value2 = mutableLiveData4.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 164) != 0) {
                MutableLiveData<StudentCard> mutableLiveData5 = studentCardVM != null ? studentCardVM.k : null;
                updateLiveDataRegistration(2, mutableLiveData5);
                StudentCard value4 = mutableLiveData5 != null ? mutableLiveData5.getValue() : null;
                if (value4 != null) {
                    schoolInfo = value4.getSchoolInfo();
                    departmentName = value4.formatDepartmentName();
                    userName = value4.getUserName();
                } else {
                    userName = null;
                    schoolInfo = null;
                    departmentName = null;
                }
                if (schoolInfo != null) {
                    gradeName = schoolInfo.getGradeName();
                    schoolName = schoolInfo.getSchoolName();
                    className = schoolInfo.getClassName();
                    studentNumber = schoolInfo.getStudentNumber();
                } else {
                    studentNumber = null;
                }
                if ((j & 168) == 0) {
                    avatar = null;
                    avatarFrameImgUrl = null;
                } else {
                    if (studentCardVM != null) {
                        mutableLiveData2 = studentCardVM.j;
                    } else {
                        mutableLiveData2 = null;
                    }
                    updateLiveDataRegistration(3, mutableLiveData2);
                    if (mutableLiveData2 != null) {
                        value3 = mutableLiveData2.getValue();
                    } else {
                        value3 = null;
                    }
                    if (value3 != null) {
                        avatarFrameImgUrl = value3.getAvatarFrameImgUrl();
                        avatar = value3.getAvatar();
                    } else {
                        avatar = null;
                        avatarFrameImgUrl = null;
                    }
                }
                if ((j & 176) == 0) {
                    str5 = avatar;
                    str4 = avatarFrameImgUrl;
                    str = gradeName;
                    str2 = schoolName;
                    str3 = className;
                    value = null;
                } else {
                    if (studentCardVM != null) {
                        mutableLiveData = studentCardVM.n;
                    } else {
                        mutableLiveData = null;
                    }
                    updateLiveDataRegistration(4, mutableLiveData);
                    if (mutableLiveData != null) {
                        value = mutableLiveData.getValue();
                        str5 = avatar;
                        str4 = avatarFrameImgUrl;
                        str = gradeName;
                        str2 = schoolName;
                        str3 = className;
                    } else {
                        str5 = avatar;
                        str4 = avatarFrameImgUrl;
                        str = gradeName;
                        str2 = schoolName;
                        str3 = className;
                        value = null;
                    }
                }
            } else {
                userName = null;
                studentNumber = null;
                departmentName = null;
            }
            gradeName = null;
            schoolName = null;
            className = null;
            if ((j & 168) == 0) {
                avatar = null;
                avatarFrameImgUrl = null;
            } else {
                if (studentCardVM != null) {
                    mutableLiveData2 = studentCardVM.j;
                } else {
                    mutableLiveData2 = null;
                }
                updateLiveDataRegistration(3, mutableLiveData2);
                if (mutableLiveData2 != null) {
                    value3 = mutableLiveData2.getValue();
                } else {
                    value3 = null;
                }
                if (value3 != null) {
                    avatarFrameImgUrl = value3.getAvatarFrameImgUrl();
                    avatar = value3.getAvatar();
                } else {
                    avatar = null;
                    avatarFrameImgUrl = null;
                }
            }
            if ((j & 176) == 0) {
                str5 = avatar;
                str4 = avatarFrameImgUrl;
                str = gradeName;
                str2 = schoolName;
                str3 = className;
                value = null;
            } else {
                if (studentCardVM != null) {
                    mutableLiveData = studentCardVM.n;
                } else {
                    mutableLiveData = null;
                }
                updateLiveDataRegistration(4, mutableLiveData);
                if (mutableLiveData != null) {
                    value = mutableLiveData.getValue();
                    str5 = avatar;
                    str4 = avatarFrameImgUrl;
                    str = gradeName;
                    str2 = schoolName;
                    str3 = className;
                } else {
                    str5 = avatar;
                    str4 = avatarFrameImgUrl;
                    str = gradeName;
                    str2 = schoolName;
                    str3 = className;
                    value = null;
                }
            }
        } else {
            value = null;
            zSafeUnbox = false;
            str = null;
            str2 = null;
            userName = null;
            studentNumber = null;
            str3 = null;
            str4 = null;
            value2 = null;
            departmentName = null;
            str5 = null;
        }
        long j2 = j & 192;
        if (j2 == 0 || bVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar2 = this.f9170a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f9170a = bVar2;
            }
            bVarA = bVar2.a(bVar);
            a aVar = this.f9169a;
            if (aVar == null) {
                aVar = new a();
                this.f9169a = aVar;
            }
            aVarA = aVar.a(bVar);
        }
        if ((j & 128) != 0) {
            View view = ((ActivityStudentCardBinding) this).f34050a;
            DrawablesBindingAdapter.h(view, 0, Integer.valueOf(ViewDataBinding.getColorFromResource(view, com.huachenjie.compat.R.color.white)), 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 13.0f, 0.0f, 13.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, 0, 0, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null);
        }
        if ((j & 168) != 0) {
            aw9.d(((ActivityStudentCardBinding) this).f9162a, str5, false, null);
            aw9.c(((ActivityStudentCardBinding) this).f9162a, str4, null);
        }
        if ((162 & j) != 0) {
            this.f9168a.k(value2);
        }
        if ((176 & j) != 0) {
            CommonBindingAdapter.g(this.f9167a, value, false, false);
        }
        if ((j & 161) != 0) {
            CommonBindingAdapter.l0(((ActivityStudentCardBinding) this).f9160a, zSafeUnbox);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityStudentCardBinding) this).f9160a, bVarA, null);
            CommonBindingAdapter.q(super.b, aVarA, null);
        }
        if ((j & 164) != 0) {
            TextViewBindingAdapter.setText(this.c, str2);
            TextViewBindingAdapter.setText(this.d, str3);
            TextViewBindingAdapter.setText(this.e, departmentName);
            TextViewBindingAdapter.setText(this.f, str);
            TextViewBindingAdapter.setText(this.g, userName);
            TextViewBindingAdapter.setText(this.h, studentNumber);
        }
        ViewDataBinding.executeBindingsOn(this.f9168a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9166a != 0) {
                return true;
            }
            return this.f9168a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9166a = 128L;
        }
        this.f9168a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityStudentCardBinding
    public void l(@Nullable StudentCardActivity.b bVar) {
        ((ActivityStudentCardBinding) this).f9163a = bVar;
        synchronized (this) {
            this.f9166a |= 64;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.ActivityStudentCardBinding
    public void m(@Nullable StudentCardVM studentCardVM) {
        ((ActivityStudentCardBinding) this).f9164a = studentCardVM;
        synchronized (this) {
            this.f9166a |= 32;
        }
        notifyPropertyChanged(wk0.L);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<StudentCourseAdapter> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9166a |= 16;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9166a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 3) {
            return r((MutableLiveData) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<StudentCard> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9166a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9166a |= 2;
        }
        return true;
    }

    public final boolean r(MutableLiveData<CommonUserInfo> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9166a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f9168a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.L == i) {
            m((StudentCardVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((StudentCardActivity.b) obj);
        }
        return true;
    }

    public ActivityStudentCardBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (View) objArr[8], (ConstraintLayout) objArr[13], (ImageView) objArr[14], (AvatarView) objArr[1], (TextView) objArr[10], (TextView) objArr[9], (TextView) objArr[4], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[3]);
        this.f9166a = -1L;
        ((ActivityStudentCardBinding) this).f34050a.setTag(null);
        ((ActivityStudentCardBinding) this).f9162a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[12];
        this.f9168a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[11];
        this.f9167a = recyclerView;
        recyclerView.setTag(null);
        ((ActivityStudentCardBinding) this).f9160a.setTag(null);
        super.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        this.e.setTag(null);
        this.f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
