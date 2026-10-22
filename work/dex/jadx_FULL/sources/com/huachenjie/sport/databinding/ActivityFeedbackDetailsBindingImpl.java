package com.huachenjie.sport.databinding;

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
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.FeedbackData;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.mine.helpercenter.FeedBackV2VM;
import com.huachenjie.sport.page.mine.helpercenter.FeedbackDetailsAdapter;
import com.zj.adlib.ok0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityFeedbackDetailsBindingImpl extends ActivityFeedbackDetailsBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13239a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13240a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f13243a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13244a;

    @NonNull
    public final TextView b;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f13239a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        f36402a = null;
    }

    public ActivityFeedbackDetailsBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13239a, f36402a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a8  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        FeedbackDetailsAdapter value;
        BindingTitleBean value2;
        boolean z;
        String content;
        String auditResult;
        boolean z2;
        String str;
        String str2;
        synchronized (this) {
            j = this.f13240a;
            this.f13240a = 0L;
        }
        FeedBackV2VM feedBackV2VM = ((ActivityFeedbackDetailsBinding) this).f36401a;
        if ((31 & j) != 0) {
            if ((j & 25) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataO = feedBackV2VM != null ? feedBackV2VM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value2 = mutableLiveDataO.getValue();
                } else {
                    value2 = null;
                }
            }
            long j2 = j & 26;
            if (j2 != 0) {
                MediatorLiveData<FeedbackData> mediatorLiveDataJ = feedBackV2VM != null ? feedBackV2VM.j() : null;
                updateLiveDataRegistration(1, mediatorLiveDataJ);
                FeedbackData value3 = mediatorLiveDataJ != null ? mediatorLiveDataJ.getValue() : null;
                if (value3 != null) {
                    auditResult = value3.getAuditResult();
                    content = value3.getContent();
                } else {
                    content = null;
                    auditResult = null;
                }
                z2 = auditResult == null;
                z = content == null;
                if (j2 != 0) {
                    j |= z2 ? 256L : 128L;
                }
                if ((j & 26) != 0) {
                    j |= z ? 64L : 32L;
                }
            } else {
                z = false;
                content = null;
                auditResult = null;
                z2 = false;
            }
            if ((j & 28) == 0) {
                value = null;
            } else {
                MediatorLiveData<FeedbackDetailsAdapter> mediatorLiveDataI = feedBackV2VM != null ? feedBackV2VM.i() : null;
                updateLiveDataRegistration(2, mediatorLiveDataI);
                if (mediatorLiveDataI != null) {
                    value = mediatorLiveDataI.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            z = false;
            content = null;
            auditResult = null;
            z2 = false;
        }
        long j3 = 26 & j;
        if (j3 != 0) {
            if (z) {
                content = "";
            }
            if (z2) {
                auditResult = "";
            }
            str = content;
            str2 = auditResult;
        } else {
            str = null;
            str2 = null;
        }
        if ((25 & j) != 0) {
            this.f13244a.k(value2);
        }
        if (j3 != 0) {
            TextViewBindingAdapter.setText(this.f13241a, str2);
            TextViewBindingAdapter.setText(this.b, str);
        }
        if ((j & 28) != 0) {
            CommonBindingAdapter.g(this.f13243a, value, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f13244a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13240a != 0) {
                return true;
            }
            return this.f13244a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13240a = 16L;
        }
        this.f13244a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityFeedbackDetailsBinding
    public void k(@Nullable FeedBackV2VM feedBackV2VM) {
        ((ActivityFeedbackDetailsBinding) this).f36401a = feedBackV2VM;
        synchronized (this) {
            this.f13240a |= 8;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean l(MediatorLiveData<FeedbackDetailsAdapter> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13240a |= 4;
        }
        return true;
    }

    public final boolean m(MediatorLiveData<FeedbackData> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13240a |= 2;
        }
        return true;
    }

    public final boolean n(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13240a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return n((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return m((MediatorLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return l((MediatorLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13244a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((FeedBackV2VM) obj);
        return true;
    }

    public ActivityFeedbackDetailsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3);
        this.f13240a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f13244a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13242a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13241a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.b = textView2;
        textView2.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[3];
        this.f13243a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
