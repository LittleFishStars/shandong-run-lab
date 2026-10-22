package com.huachenjie.sport.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.mine.attendance.photo.AttendancePhotoActivity;
import com.huachenjie.sport.page.mine.attendance.photo.AttendancePhotoVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityAttendancePhotoBindingImpl extends ActivityAttendancePhotoBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36360a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f13120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f13123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13124a;

    @NonNull
    public final BLTextView b;

    @NonNull
    public final BLTextView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendancePhotoActivity.a f36361a;

        public a a(AttendancePhotoActivity.a aVar) {
            this.f36361a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36361a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendancePhotoActivity.a f36362a;

        public b a(AttendancePhotoActivity.a aVar) {
            this.f36362a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36362a.a(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AttendancePhotoActivity.a f36363a;

        public c a(AttendancePhotoActivity.a aVar) {
            this.f36363a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f36363a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        f13114a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{7}, new int[]{R.layout.layout_toolbar_binding});
        f36360a = null;
    }

    public ActivityAttendancePhotoBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13114a, f36360a));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:59:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00d9  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        boolean z;
        BindingTitleBean value2;
        boolean zIsEmpty;
        String str;
        long j2;
        b bVarA;
        c cVarA;
        a aVarA;
        synchronized (this) {
            j = this.f13115a;
            this.f13115a = 0L;
        }
        AttendancePhotoVM attendancePhotoVM = ((ActivityAttendancePhotoBinding) this).f13113a;
        AttendancePhotoActivity.a aVar = ((ActivityAttendancePhotoBinding) this).f36359a;
        long j3 = j & 22;
        RequestOptions requestOptions = j3 != 0 ? ju3.k : null;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = attendancePhotoVM != null ? attendancePhotoVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if (j3 != 0) {
                MutableLiveData<String> mutableLiveDataH = attendancePhotoVM != null ? attendancePhotoVM.h() : null;
                updateLiveDataRegistration(1, mutableLiveDataH);
                value = mutableLiveDataH != null ? mutableLiveDataH.getValue() : null;
                zIsEmpty = TextUtils.isEmpty(value);
                if (j3 != 0) {
                    j |= zIsEmpty ? 64L : 32L;
                }
                z = !zIsEmpty;
                str = zIsEmpty ? "立即拍照" : "立即打卡";
            } else {
                value = null;
                z = false;
            }
            j2 = j & 24;
            if (j2 != 0 || aVar == null) {
                bVarA = null;
                cVarA = null;
                aVarA = null;
            } else {
                c cVar = this.f13122a;
                if (cVar == null) {
                    cVar = new c();
                    this.f13122a = cVar;
                }
                cVarA = cVar.a(aVar);
                a aVar2 = this.f13120a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f13120a = aVar2;
                }
                aVarA = aVar2.a(aVar);
                b bVar = this.f13121a;
                if (bVar == null) {
                    bVar = new b();
                    this.f13121a = bVar;
                }
                bVarA = bVar.a(aVar);
            }
            if ((21 & j) != 0) {
                this.f13119a.k(value2);
            }
            if (j2 != 0) {
                CommonBindingAdapter.q(this.f13123a, aVarA, null);
                CommonBindingAdapter.q(this.b, bVarA, null);
                CommonBindingAdapter.q(this.c, cVarA, null);
            }
            if ((j & 22) != 0) {
                CommonBindingAdapter.b0(this.f13116a, value, requestOptions, false);
                CommonBindingAdapter.l0(this.f13118a, zIsEmpty);
                CommonBindingAdapter.l0(this.f13124a, z);
                TextViewBindingAdapter.setText(this.c, str);
            }
            ViewDataBinding.executeBindingsOn(this.f13119a);
        }
        value = null;
        z = false;
        value2 = null;
        zIsEmpty = false;
        str = null;
        j2 = j & 24;
        if (j2 != 0) {
            bVarA = null;
            cVarA = null;
            aVarA = null;
        } else {
            bVarA = null;
            cVarA = null;
            aVarA = null;
        }
        if ((21 & j) != 0) {
            this.f13119a.k(value2);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f13123a, aVarA, null);
            CommonBindingAdapter.q(this.b, bVarA, null);
            CommonBindingAdapter.q(this.c, cVarA, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.b0(this.f13116a, value, requestOptions, false);
            CommonBindingAdapter.l0(this.f13118a, zIsEmpty);
            CommonBindingAdapter.l0(this.f13124a, z);
            TextViewBindingAdapter.setText(this.c, str);
        }
        ViewDataBinding.executeBindingsOn(this.f13119a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13115a != 0) {
                return true;
            }
            return this.f13119a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13115a = 16L;
        }
        this.f13119a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendancePhotoBinding
    public void l(@Nullable AttendancePhotoActivity.a aVar) {
        ((ActivityAttendancePhotoBinding) this).f36359a = aVar;
        synchronized (this) {
            this.f13115a |= 8;
        }
        notifyPropertyChanged(ok0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityAttendancePhotoBinding
    public void m(@Nullable AttendancePhotoVM attendancePhotoVM) {
        ((ActivityAttendancePhotoBinding) this).f13113a = attendancePhotoVM;
        synchronized (this) {
            this.f13115a |= 4;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13115a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13115a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13119a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 == i) {
            m((AttendancePhotoVM) obj);
        } else {
            if (ok0.k != i) {
                return false;
            }
            l((AttendancePhotoActivity.a) obj);
        }
        return true;
    }

    public ActivityAttendancePhotoBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f13115a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[7];
        this.f13119a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13117a = linearLayout;
        linearLayout.setTag(null);
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) objArr[1];
        this.f13123a = bLConstraintLayout;
        bLConstraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.f13116a = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f13118a = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[4];
        this.f13124a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[5];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        BLTextView bLTextView3 = (BLTextView) objArr[6];
        this.c = bLTextView3;
        bLTextView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
