package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mine.page.my_theme.MyThemeActivity;
import com.huachenjie.mine.page.my_theme.MyThemeViewModel;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineActivityMyThemeBindingImpl extends MineActivityMyThemeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11215a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11216a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f11217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11219a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MyThemeActivity.a f35302a;

        public a a(MyThemeActivity.a aVar) {
            this.f35302a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35302a.a(view);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f11213a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{3}, new int[]{R.layout.layout_toolbar_binding});
        f35301a = null;
    }

    public MineActivityMyThemeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f11213a, f35301a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:41:0x0083  */
    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions bgOptions;
        BindingTitleBean value;
        String value2;
        long j2;
        a aVarA;
        MutableLiveData<String> mutableLiveDataK;
        synchronized (this) {
            j = this.f11214a;
            this.f11214a = 0L;
        }
        MyThemeViewModel myThemeViewModel = ((MineActivityMyThemeBinding) this).f11212a;
        MyThemeActivity.a aVar = ((MineActivityMyThemeBinding) this).f35300a;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = myThemeViewModel != null ? myThemeViewModel.i() : null;
                updateLiveDataRegistration(0, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 22) != 0) {
                if (myThemeViewModel != null) {
                    mutableLiveDataK = myThemeViewModel.k();
                    bgOptions = myThemeViewModel.getBgOptions();
                } else {
                    bgOptions = null;
                    mutableLiveDataK = null;
                }
                updateLiveDataRegistration(1, mutableLiveDataK);
                value2 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                j2 = 24 & j;
                if (j2 != 0 || aVar == null) {
                    aVarA = null;
                } else {
                    a aVar2 = this.f11218a;
                    if (aVar2 == null) {
                        aVar2 = new a();
                        this.f11218a = aVar2;
                    }
                    aVarA = aVar2.a(aVar);
                }
                if ((21 & j) != 0) {
                    this.f11217a.k(value);
                }
                if ((j & 22) != 0) {
                    CommonBindingAdapter.b0(this.f11216a, value2, bgOptions, false);
                }
                if (j2 != 0) {
                    CommonBindingAdapter.q(this.f11219a, aVarA, null);
                }
                ViewDataBinding.executeBindingsOn(this.f11217a);
            }
            bgOptions = null;
        } else {
            bgOptions = null;
            value = null;
        }
        j2 = 24 & j;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if ((21 & j) != 0) {
            this.f11217a.k(value);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.b0(this.f11216a, value2, bgOptions, false);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f11219a, aVarA, null);
        }
        ViewDataBinding.executeBindingsOn(this.f11217a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11214a != 0) {
                return true;
            }
            return this.f11217a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11214a = 16L;
        }
        this.f11217a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineActivityMyThemeBinding
    public void l(@Nullable MyThemeActivity.a aVar) {
        ((MineActivityMyThemeBinding) this).f35300a = aVar;
        synchronized (this) {
            this.f11214a |= 8;
        }
        notifyPropertyChanged(ik0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineActivityMyThemeBinding
    public void m(@Nullable MyThemeViewModel myThemeViewModel) {
        ((MineActivityMyThemeBinding) this).f11212a = myThemeViewModel;
        synchronized (this) {
            this.f11214a |= 4;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11214a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11214a |= 1;
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
        this.f11217a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 == i) {
            m((MyThemeViewModel) obj);
        } else {
            if (ik0.k != i) {
                return false;
            }
            l((MyThemeActivity.a) obj);
        }
        return true;
    }

    public MineActivityMyThemeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f11214a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[3];
        this.f11217a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f11215a = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f11216a = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[2];
        this.f11219a = bLTextView;
        bLTextView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
