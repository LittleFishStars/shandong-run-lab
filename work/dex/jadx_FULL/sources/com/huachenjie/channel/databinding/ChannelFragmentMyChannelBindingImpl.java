package com.huachenjie.channel.databinding;

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
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelDetail;
import com.huachenjie.channel.page.my_channel.MyChannelFragment;
import com.huachenjie.channel.page.my_channel.MyChannelVM;
import com.huachenjie.channel.widget.NotSaveStateTabLayout;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelFragmentMyChannelBindingImpl extends ChannelFragmentMyChannelBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f7845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ChannelLayoutMyChannelHeaderBinding f7846a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        f7843a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"channel_layout_my_channel_header"}, new int[]{1}, new int[]{R.layout.channel_layout_my_channel_header});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33193a = sparseIntArray;
        sparseIntArray.put(R.id.fl_ad, 2);
        sparseIntArray.put(R.id.fl_content, 3);
        sparseIntArray.put(R.id.ll_page, 4);
        sparseIntArray.put(R.id.tab_layout, 5);
        sparseIntArray.put(R.id.fl_page_content, 6);
    }

    public ChannelFragmentMyChannelBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f7843a, f33193a));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        RequestOptions requestOptions;
        synchronized (this) {
            j = this.f7844a;
            this.f7844a = 0L;
        }
        MyChannelVM myChannelVM = ((ChannelFragmentMyChannelBinding) this).f7840a;
        MyChannelFragment.ClickProxy clickProxy = ((ChannelFragmentMyChannelBinding) this).f7839a;
        long j2 = 11 & j;
        MyChannelDetail myChannelDetail = null;
        bgOption = null;
        RequestOptions bgOption = null;
        if (j2 != 0) {
            MutableLiveData<MyChannelDetail> mutableLiveDataL = myChannelVM != null ? myChannelVM.l() : null;
            updateLiveDataRegistration(0, mutableLiveDataL);
            MyChannelDetail value = mutableLiveDataL != null ? mutableLiveDataL.getValue() : null;
            if ((j & 10) != 0 && myChannelVM != null) {
                bgOption = myChannelVM.getBgOption();
            }
            requestOptions = bgOption;
            myChannelDetail = value;
        } else {
            requestOptions = null;
        }
        long j3 = 12 & j;
        if (j2 != 0) {
            this.f7846a.m(myChannelDetail);
        }
        if ((j & 10) != 0) {
            this.f7846a.n(requestOptions);
        }
        if (j3 != 0) {
            this.f7846a.o(clickProxy);
        }
        ViewDataBinding.executeBindingsOn(this.f7846a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f7844a != 0) {
                return true;
            }
            return this.f7846a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7844a = 8L;
        }
        this.f7846a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentMyChannelBinding
    public void l(@Nullable MyChannelFragment.ClickProxy clickProxy) {
        ((ChannelFragmentMyChannelBinding) this).f7839a = clickProxy;
        synchronized (this) {
            this.f7844a |= 4;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelFragmentMyChannelBinding
    public void m(@Nullable MyChannelVM myChannelVM) {
        ((ChannelFragmentMyChannelBinding) this).f7840a = myChannelVM;
        synchronized (this) {
            this.f7844a |= 2;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<MyChannelDetail> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7844a |= 1;
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
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f7846a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((MyChannelVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((MyChannelFragment.ClickProxy) obj);
        }
        return true;
    }

    public ChannelFragmentMyChannelBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[2], (FrameLayout) objArr[3], (FrameLayout) objArr[6], (BLLinearLayout) objArr[4], (NotSaveStateTabLayout) objArr[5]);
        this.f7844a = -1L;
        ChannelLayoutMyChannelHeaderBinding channelLayoutMyChannelHeaderBinding = (ChannelLayoutMyChannelHeaderBinding) objArr[1];
        this.f7846a = channelLayoutMyChannelHeaderBinding;
        setContainedBinding(channelLayoutMyChannelHeaderBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f7845a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
