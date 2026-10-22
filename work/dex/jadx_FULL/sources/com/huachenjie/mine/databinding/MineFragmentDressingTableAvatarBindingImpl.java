package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarVM;
import com.noober.background.view.BLTextView;
import com.zj.adlib.aw9;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineFragmentDressingTableAvatarBindingImpl extends MineFragmentDressingTableAvatarBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35306a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11224a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11227a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f11228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11230a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AvatarFragment.a f35307a;

        public a a(AvatarFragment.a aVar) {
            this.f35307a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35307a.a(view);
        }
    }

    public MineFragmentDressingTableAvatarBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f11224a, f35306a));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        String value;
        a aVarA;
        synchronized (this) {
            j = this.f11225a;
            this.f11225a = 0L;
        }
        AvatarVM avatarVM = ((MineFragmentDressingTableAvatarBinding) this).f11223a;
        AvatarFragment.a aVar = ((MineFragmentDressingTableAvatarBinding) this).f35305a;
        long j2 = 11 & j;
        if (j2 == 0) {
            value = null;
        } else {
            MutableLiveData<String> mutableLiveDataJ = avatarVM != null ? avatarVM.j() : null;
            updateLiveDataRegistration(0, mutableLiveDataJ);
            if (mutableLiveDataJ != null) {
                value = mutableLiveDataJ.getValue();
            } else {
                value = null;
            }
        }
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f11229a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11229a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f11226a, aVarA, null);
            CommonBindingAdapter.q(this.f11230a, aVarA, null);
        }
        if (j2 != 0) {
            aw9.d(this.f11228a, value, false, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11225a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11225a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentDressingTableAvatarBinding
    public void l(@Nullable AvatarFragment.a aVar) {
        ((MineFragmentDressingTableAvatarBinding) this).f35305a = aVar;
        synchronized (this) {
            this.f11225a |= 4;
        }
        notifyPropertyChanged(ik0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineFragmentDressingTableAvatarBinding
    public void m(@Nullable AvatarVM avatarVM) {
        ((MineFragmentDressingTableAvatarBinding) this).f11223a = avatarVM;
        synchronized (this) {
            this.f11225a |= 2;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11225a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 == i) {
            m((AvatarVM) obj);
        } else {
            if (ik0.k != i) {
                return false;
            }
            l((AvatarFragment.a) obj);
        }
        return true;
    }

    public MineFragmentDressingTableAvatarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f11225a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f11227a = relativeLayout;
        relativeLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[1];
        this.f11226a = frameLayout;
        frameLayout.setTag(null);
        AvatarView avatarView = (AvatarView) objArr[2];
        this.f11228a = avatarView;
        avatarView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f11230a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
