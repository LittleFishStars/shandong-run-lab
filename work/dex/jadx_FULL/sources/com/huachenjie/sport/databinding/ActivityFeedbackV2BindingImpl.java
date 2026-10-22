package com.huachenjie.sport.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.sport.page.mine.helpercenter.FeedBackV2VM;
import com.huachenjie.sport.widget.photowall.PhotoWall;
import com.zj.adlib.ok0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ActivityFeedbackV2BindingImpl extends ActivityFeedbackV2Binding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13247a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f13248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f13251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13252a;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(ActivityFeedbackV2BindingImpl.this.f13248a);
            FeedBackV2VM feedBackV2VM = ((ActivityFeedbackV2Binding) ActivityFeedbackV2BindingImpl.this).f36403a;
            if (feedBackV2VM != null) {
                MutableLiveData<String> mutableLiveDataL = feedBackV2VM.l();
                if (mutableLiveDataL != null) {
                    mutableLiveDataL.setValue(textString);
                }
            }
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(5);
        f13246a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{4}, new int[]{R.layout.layout_toolbar_binding});
        f36404a = null;
    }

    public ActivityFeedbackV2BindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13246a, f36404a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:34:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        List<String> value;
        BindingTitleBean value2;
        String value3;
        String value4;
        synchronized (this) {
            j = this.f13247a;
            this.f13247a = 0L;
        }
        FeedBackV2VM feedBackV2VM = ((ActivityFeedbackV2Binding) this).f36403a;
        if ((63 & j) != 0) {
            if ((j & 49) == 0) {
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
            if ((j & 50) == 0) {
                value3 = null;
            } else {
                MediatorLiveData<String> mediatorLiveDataM = feedBackV2VM != null ? feedBackV2VM.m() : null;
                updateLiveDataRegistration(1, mediatorLiveDataM);
                if (mediatorLiveDataM != null) {
                    value3 = mediatorLiveDataM.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 52) == 0) {
                value4 = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = feedBackV2VM != null ? feedBackV2VM.l() : null;
                updateLiveDataRegistration(2, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value4 = mutableLiveDataL.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 56) == 0) {
                value = null;
            } else {
                MutableLiveData<List<String>> mutableLiveDataK = feedBackV2VM != null ? feedBackV2VM.k() : null;
                updateLiveDataRegistration(3, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value = mutableLiveDataK.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            value3 = null;
            value4 = null;
        }
        if ((49 & j) != 0) {
            this.f13252a.k(value2);
        }
        if ((52 & j) != 0) {
            TextViewBindingAdapter.setText(this.f13248a, value4);
        }
        if ((32 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.f13248a, null, null, null, this.f13251a);
            com.huachenjie.sport.widget.photowall.a.b(((ActivityFeedbackV2Binding) this).f13245a, null, 4, 19, 10);
        }
        if ((50 & j) != 0) {
            TextViewBindingAdapter.setText(this.f13249a, value3);
        }
        if ((j & 56) != 0) {
            ((ActivityFeedbackV2Binding) this).f13245a.setImages(value);
        }
        ViewDataBinding.executeBindingsOn(this.f13252a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13247a != 0) {
                return true;
            }
            return this.f13252a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13247a = 32L;
        }
        this.f13252a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.sport.databinding.ActivityFeedbackV2Binding
    public void k(@Nullable FeedBackV2VM feedBackV2VM) {
        ((ActivityFeedbackV2Binding) this).f36403a = feedBackV2VM;
        synchronized (this) {
            this.f13247a |= 16;
        }
        notifyPropertyChanged(ok0.p0);
        super.requestRebind();
    }

    public final boolean m(MutableLiveData<List<String>> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13247a |= 8;
        }
        return true;
    }

    public final boolean n(MutableLiveData<String> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13247a |= 4;
        }
        return true;
    }

    public final boolean o(MediatorLiveData<String> mediatorLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13247a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return p((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return o((MediatorLiveData) obj, i2);
        }
        if (i == 2) {
            return n((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return m((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != ok0.f43764a) {
            return false;
        }
        synchronized (this) {
            this.f13247a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13252a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ok0.p0 != i) {
            return false;
        }
        k((FeedBackV2VM) obj);
        return true;
    }

    public ActivityFeedbackV2BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (PhotoWall) objArr[3]);
        this.f13251a = new a();
        this.f13247a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[4];
        this.f13252a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr[0];
        this.f13250a = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        EditText editText = (EditText) objArr[1];
        this.f13248a = editText;
        editText.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13249a = textView;
        textView.setTag(null);
        ((ActivityFeedbackV2Binding) this).f13245a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
