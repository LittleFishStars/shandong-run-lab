package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.flyco.tablayout.CommonTabLayout;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.AttendanceActivity;
import com.huachenjie.sport.page.mine.attendance.AttendanceVM;
import com.noober.background.view.BLFrameLayout;
import com.zj.adlib.aw9;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityAttendanceBindingImpl extends ActivityAttendanceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13098a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13099a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13102a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f13105a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceActivity.a f36353a;

        public a a(AttendanceActivity.a aVar) {
            this.f36353a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36353a.f(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceActivity.a f36354a;

        public b a(AttendanceActivity.a aVar) {
            this.f36354a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36354a.b(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceActivity.a f36355a;

        public c a(AttendanceActivity.a aVar) {
            this.f36355a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36355a.c(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendanceActivity.a f36356a;

        public d a(AttendanceActivity.a aVar) {
            this.f36356a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36356a.d(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36352a = sparseIntArray;
        sparseIntArray.put(R.id.tv_record_list_title, 8);
        sparseIntArray.put(R.id.tab_attendance_list, 9);
        sparseIntArray.put(R.id.fragment_container, 10);
    }

    public ActivityAttendanceBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f13098a, f36352a));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0042  */
    /* JADX WARN: Code duplicated, block: B:31:0x006a  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int iSafeUnbox;
        String str;
        String userName;
        String name;
        c cVarA;
        d dVarA;
        a aVarA;
        b bVarA;
        Long l;
        String avatar;
        synchronized (this) {
            j = this.f13099a;
            this.f13099a = 0L;
        }
        AttendanceVM attendanceVM = ((ActivityAttendanceBinding) this).f13096a;
        AttendanceActivity.a aVar = ((ActivityAttendanceBinding) this).f13095a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                userName = null;
                avatar = null;
            } else {
                MutableLiveData<CommonUserInfo> mutableLiveDataO = attendanceVM != null ? attendanceVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                CommonUserInfo value = mutableLiveDataO != null ? mutableLiveDataO.getValue() : null;
                if (value != null) {
                    avatar = value.getAvatar();
                    userName = value.getUserName();
                } else {
                    userName = null;
                    avatar = null;
                }
            }
            if ((j & 42) == 0) {
                name = null;
            } else {
                MutableLiveData<SemesterBean> mutableLiveDataH = attendanceVM != null ? attendanceVM.h() : null;
                updateLiveDataRegistration(1, mutableLiveDataH);
                SemesterBean value2 = mutableLiveDataH != null ? mutableLiveDataH.getValue() : null;
                if (value2 != null) {
                    name = value2.getName();
                } else {
                    name = null;
                }
            }
            if ((j & 44) != 0) {
                MutableLiveData<Integer> mutableLiveData = attendanceVM != null ? ((BaseVM) attendanceVM).f33644a : null;
                updateLiveDataRegistration(2, mutableLiveData);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            str = avatar;
        } else {
            iSafeUnbox = 0;
            str = null;
            userName = null;
            name = null;
        }
        long j2 = j & 48;
        if (j2 == 0 || aVar == null) {
            cVarA = null;
            dVarA = null;
            aVarA = null;
            bVarA = null;
        } else {
            d dVar = this.f13105a;
            if (dVar == null) {
                dVar = new d();
                this.f13105a = dVar;
            }
            dVarA = dVar.a(aVar);
            a aVar2 = this.f13102a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f13102a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            b bVar = this.f13103a;
            if (bVar == null) {
                bVar = new b();
                this.f13103a = bVar;
            }
            bVarA = bVar.a(aVar);
            c cVar = this.f13104a;
            if (cVar == null) {
                cVar = new c();
                this.f13104a = cVar;
            }
            cVarA = cVar.a(aVar);
        }
        if ((41 & j) != 0) {
            l = null;
            aw9.d(((ActivityAttendanceBinding) this).f13094a, str, false, null);
            TextViewBindingAdapter.setText(this.f13100a, userName);
        } else {
            l = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ActivityAttendanceBinding) this).f13092a, bVarA, l);
            CommonBindingAdapter.q(super.b, cVarA, l);
            CommonBindingAdapter.q(this.c, dVarA, l);
            CommonBindingAdapter.q(this.d, aVarA, l);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.O(this.f13101a, 0, iSafeUnbox, 0, 0, null);
        }
        if ((j & 42) != 0) {
            TextViewBindingAdapter.setText(this.b, name);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13099a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13099a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendanceBinding
    public void l(@Nullable AttendanceActivity.a aVar) {
        ((ActivityAttendanceBinding) this).f13095a = aVar;
        synchronized (this) {
            this.f13099a |= 16;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendanceBinding
    public void m(@Nullable AttendanceVM attendanceVM) {
        ((ActivityAttendanceBinding) this).f13096a = attendanceVM;
        synchronized (this) {
            this.f13099a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<SemesterBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13099a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13099a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<CommonUserInfo> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13099a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((AttendanceVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((AttendanceActivity.a) obj);
        }
        return true;
    }

    public ActivityAttendanceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (FrameLayout) objArr[10], (AvatarView) objArr[5], (ImageView) objArr[1], (ImageView) objArr[2], (ImageView) objArr[4], (ImageView) objArr[3], (CommonTabLayout) objArr[9], (BLFrameLayout) objArr[8]);
        this.f13099a = -1L;
        ((ActivityAttendanceBinding) this).f13094a.setTag(null);
        ((ActivityAttendanceBinding) this).f13092a.setTag(null);
        super.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13101a = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.f13100a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.b = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
