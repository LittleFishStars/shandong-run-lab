package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.video.AliVideoView;
import com.huachenjie.mall.page.test.TestPlayActivity;
import com.huachenjie.mall.page.test.TestPlayVM;
import com.huachenjie.mall.page.test.TestVideoAdapter;
import com.noober.background.view.BLTextView;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityTestPlayBindingImpl extends MallActivityTestPlayBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f10462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f10463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10464a;

    @NonNull
    public final BLTextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TestPlayActivity.a f34880a;

        public a a(TestPlayActivity.a aVar) {
            this.f34880a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34880a.a(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TestPlayActivity.a f34881a;

        public b a(TestPlayActivity.a aVar) {
            this.f34881a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34881a.b(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        f10459a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34879a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.video_view, 5);
        sparseIntArray.put(com.huachenjie.mall.R.id.fl_replay, 6);
        sparseIntArray.put(com.huachenjie.mall.R.id.fl_start_play, 7);
    }

    public MallActivityTestPlayBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f10459a, f34879a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        TestVideoAdapter value;
        BindingTitleBean value2;
        a aVarA;
        b bVarA;
        synchronized (this) {
            j = this.f10460a;
            this.f10460a = 0L;
        }
        TestPlayVM testPlayVM = ((MallActivityTestPlayBinding) this).f10458a;
        TestPlayActivity.a aVar = ((MallActivityTestPlayBinding) this).f10457a;
        if ((45 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = testPlayVM != null ? testPlayVM.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value2 = mutableLiveDataI.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 44) == 0) {
                value = null;
            } else {
                MutableLiveData<TestVideoAdapter> mutableLiveDataJ = testPlayVM != null ? testPlayVM.j() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j2 = 48 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f10463a;
            if (bVar == null) {
                bVar = new b();
                this.f10463a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f10462a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f10462a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f10464a, bVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
        if ((44 & j) != 0) {
            CommonBindingAdapter.g(((MallActivityTestPlayBinding) this).f10454a, value, false, false);
        }
        if ((j & 41) != 0) {
            ((MallActivityTestPlayBinding) this).f10455a.k(value2);
        }
        ViewDataBinding.executeBindingsOn(((MallActivityTestPlayBinding) this).f10455a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10460a != 0) {
                return true;
            }
            return ((MallActivityTestPlayBinding) this).f10455a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10460a = 32L;
        }
        ((MallActivityTestPlayBinding) this).f10455a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityTestPlayBinding
    public void l(@Nullable TestPlayActivity.a aVar) {
        ((MallActivityTestPlayBinding) this).f10457a = aVar;
        synchronized (this) {
            this.f10460a |= 16;
        }
        notifyPropertyChanged(hk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityTestPlayBinding
    public void m(@Nullable TestPlayVM testPlayVM) {
        ((MallActivityTestPlayBinding) this).f10458a = testPlayVM;
        synchronized (this) {
            this.f10460a |= 8;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean n(LayoutToolbarBindingBinding layoutToolbarBindingBinding, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10460a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<TestVideoAdapter> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10460a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return n((LayoutToolbarBindingBinding) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10460a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        ((MallActivityTestPlayBinding) this).f10455a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 == i) {
            m((TestPlayVM) obj);
        } else {
            if (hk0.k != i) {
                return false;
            }
            l((TestPlayActivity.a) obj);
        }
        return true;
    }

    public MallActivityTestPlayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (FrameLayout) objArr[6], (FrameLayout) objArr[7], (RecyclerView) objArr[3], (LayoutToolbarBindingBinding) objArr[4], (AliVideoView) objArr[5]);
        this.f10460a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10461a = linearLayout;
        linearLayout.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[1];
        this.f10464a = bLTextView;
        bLTextView.setTag(null);
        BLTextView bLTextView2 = (BLTextView) objArr[2];
        this.b = bLTextView2;
        bLTextView2.setTag(null);
        ((MallActivityTestPlayBinding) this).f10454a.setTag(null);
        setContainedBinding(((MallActivityTestPlayBinding) this).f10455a);
        setRootTag(view);
        invalidateAll();
    }
}
