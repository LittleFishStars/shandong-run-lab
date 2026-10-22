package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mine.bean.MineData;
import com.huachenjie.mine.page.qr_code.MineQrCodeActivity;
import com.huachenjie.mine.page.qr_code.MineQrCodeVM;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.aw9;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineActivityMyQrCodeBindingImpl extends MineActivityMyQrCodeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f11210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11211a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MineQrCodeActivity.a f35299a;

        public a a(MineQrCodeActivity.a aVar) {
            this.f35299a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35299a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        f11207a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{5}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35298a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mine.R.id.blMineCard, 6);
        sparseIntArray.put(com.huachenjie.mine.R.id.flQRCode, 7);
        sparseIntArray.put(com.huachenjie.mine.R.id.ivQRCode, 8);
    }

    public MineActivityMyQrCodeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f11207a, f35298a));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0074  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        BindingTitleBean value;
        String str;
        String str2;
        String nickName;
        a aVarA;
        String avatar;
        String alumniId;
        synchronized (this) {
            j = this.f11208a;
            this.f11208a = 0L;
        }
        MineQrCodeVM mineQrCodeVM = ((MineActivityMyQrCodeBinding) this).f11205a;
        MineQrCodeActivity.a aVar = ((MineActivityMyQrCodeBinding) this).f11204a;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                MutableLiveData<MineData> mutableLiveDataJ = mineQrCodeVM != null ? mineQrCodeVM.j() : null;
                updateLiveDataRegistration(0, mutableLiveDataJ);
                MineData value2 = mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null;
                if (value2 != null) {
                    nickName = value2.getNickName();
                    avatar = value2.getAvatar();
                    alumniId = value2.getAlumniId();
                } else {
                    alumniId = null;
                    nickName = null;
                    avatar = null;
                }
                str = String.format("ID：%s", alumniId);
            } else {
                str = null;
                nickName = null;
                avatar = null;
            }
            if ((j & 22) == 0) {
                str2 = avatar;
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = mineQrCodeVM != null ? mineQrCodeVM.i() : null;
                updateLiveDataRegistration(1, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                    str2 = avatar;
                } else {
                    str2 = avatar;
                    value = null;
                }
            }
        } else {
            value = null;
            str = null;
            str2 = null;
            nickName = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11211a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11211a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((21 & j) != 0) {
            aw9.d(((MineActivityMyQrCodeBinding) this).f11203a, str2, false, null);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(((MineActivityMyQrCodeBinding) this).f11202a, nickName);
        }
        if ((j & 22) != 0) {
            this.f11210a.k(value);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.c, aVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f11210a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11208a != 0) {
                return true;
            }
            return this.f11210a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11208a = 16L;
        }
        this.f11210a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineActivityMyQrCodeBinding
    public void l(@Nullable MineQrCodeActivity.a aVar) {
        ((MineActivityMyQrCodeBinding) this).f11204a = aVar;
        synchronized (this) {
            this.f11208a |= 8;
        }
        notifyPropertyChanged(ik0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineActivityMyQrCodeBinding
    public void m(@Nullable MineQrCodeVM mineQrCodeVM) {
        ((MineActivityMyQrCodeBinding) this).f11205a = mineQrCodeVM;
        synchronized (this) {
            this.f11208a |= 4;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<MineData> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11208a |= 1;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11208a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f11210a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 == i) {
            m((MineQrCodeVM) obj);
        } else {
            if (ik0.k != i) {
                return false;
            }
            l((MineQrCodeActivity.a) obj);
        }
        return true;
    }

    public MineActivityMyQrCodeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (BLConstraintLayout) objArr[6], (BLConstraintLayout) objArr[7], (AvatarView) objArr[1], (ImageView) objArr[8], (TextView) objArr[2]);
        this.f11208a = -1L;
        ((MineActivityMyQrCodeBinding) this).f11203a.setTag(null);
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[5];
        this.f11210a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f11209a = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.b = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.c = textView2;
        textView2.setTag(null);
        ((MineActivityMyQrCodeBinding) this).f11202a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
