package com.huachenjie.compat.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.compat.page.student.UserFaceActivity;
import com.huachenjie.compat.page.student.UserFaceVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.wk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class CompatActivityUserFaceBindingImpl extends CompatActivityUserFaceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f9194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9196a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public UserFaceActivity.ClickProxy f34063a;

        public a a(UserFaceActivity.ClickProxy clickProxy) {
            this.f34063a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34063a.i(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f9191a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f34062a = null;
    }

    public CompatActivityUserFaceBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f9191a, f34062a));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String faceImg;
        BindingTitleBean value;
        a aVarA;
        synchronized (this) {
            j = this.f9192a;
            this.f9192a = 0L;
        }
        UserFaceVM userFaceVM = ((CompatActivityUserFaceBinding) this).f9190a;
        UserFaceActivity.ClickProxy clickProxy = ((CompatActivityUserFaceBinding) this).f9189a;
        long j2 = 44 & j;
        RequestOptions requestOptions = j2 != 0 ? ju3.n : null;
        if ((45 & j) != 0) {
            if ((j & 41) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = userFaceVM != null ? userFaceVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if (j2 == 0) {
                faceImg = null;
            } else {
                MutableLiveData<UserFaceBean> mutableLiveDataL = userFaceVM != null ? userFaceVM.l() : null;
                updateLiveDataRegistration(2, mutableLiveDataL);
                UserFaceBean value2 = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
                if (value2 != null) {
                    faceImg = value2.getFaceImg();
                } else {
                    faceImg = null;
                }
            }
        } else {
            faceImg = null;
            value = null;
        }
        long j3 = 48 & j;
        if (j3 == 0 || clickProxy == null) {
            aVarA = null;
        } else {
            a aVar = this.f9195a;
            if (aVar == null) {
                aVar = new a();
                this.f9195a = aVar;
            }
            aVarA = aVar.a(clickProxy);
        }
        if (j2 != 0) {
            CommonBindingAdapter.b0(this.f9193a, faceImg, requestOptions, false);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f9196a, aVarA, null);
        }
        if ((j & 41) != 0) {
            ((CompatActivityUserFaceBinding) this).f34061a.k(value);
        }
        ViewDataBinding.executeBindingsOn(((CompatActivityUserFaceBinding) this).f34061a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f9192a != 0) {
                return true;
            }
            return ((CompatActivityUserFaceBinding) this).f34061a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9192a = 32L;
        }
        ((CompatActivityUserFaceBinding) this).f34061a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.CompatActivityUserFaceBinding
    public void l(@Nullable UserFaceActivity.ClickProxy clickProxy) {
        ((CompatActivityUserFaceBinding) this).f9189a = clickProxy;
        synchronized (this) {
            this.f9192a |= 16;
        }
        notifyPropertyChanged(wk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.compat.databinding.CompatActivityUserFaceBinding
    public void m(@Nullable UserFaceVM userFaceVM) {
        ((CompatActivityUserFaceBinding) this).f9190a = userFaceVM;
        synchronized (this) {
            this.f9192a |= 8;
        }
        notifyPropertyChanged(wk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9192a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9192a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return p((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<UserFaceBean> mutableLiveData, int i) {
        if (i != wk0.f45614a) {
            return false;
        }
        synchronized (this) {
            this.f9192a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((CompatActivityUserFaceBinding) this).f34061a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (wk0.p0 == i) {
            m((UserFaceVM) obj);
        } else {
            if (wk0.k != i) {
                return false;
            }
            l((UserFaceActivity.ClickProxy) obj);
        }
        return true;
    }

    public CompatActivityUserFaceBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (LayoutToolbarBindingBinding) objArr[3]);
        this.f9192a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f9194a = relativeLayout;
        relativeLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f9193a = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f9196a = bLTextView;
        bLTextView.setTag(null);
        setContainedBinding(((CompatActivityUserFaceBinding) this).f34061a);
        setRootTag(view);
        invalidateAll();
    }
}
