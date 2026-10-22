package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageClubAdapter;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageDialog;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageDialogVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.tk0;
import com.zj.adlib.xq8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelDialogPublishOrgMessageBindingImpl extends ChannelDialogPublishOrgMessageBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33151a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7748a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7751a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7752a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f7753a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishOrgMessageDialog.a f33152a;

        public a a(PublishOrgMessageDialog.a aVar) {
            this.f33152a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33152a.a(view);
        }
    }

    public ChannelDialogPublishOrgMessageBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f7748a, f33151a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        PublishOrgMessageClubAdapter value;
        Integer value2;
        a aVarA;
        synchronized (this) {
            j = this.f7749a;
            this.f7749a = 0L;
        }
        PublishOrgMessageDialogVM publishOrgMessageDialogVM = ((ChannelDialogPublishOrgMessageBinding) this).f7746a;
        PublishOrgMessageDialog.a aVar = ((ChannelDialogPublishOrgMessageBinding) this).f33150a;
        if ((23 & j) != 0) {
            if ((j & 21) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataR = publishOrgMessageDialogVM != null ? publishOrgMessageDialogVM.r() : null;
                updateLiveDataRegistration(0, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 22) == 0) {
                value = null;
            } else {
                MutableLiveData<PublishOrgMessageClubAdapter> mutableLiveDataB = publishOrgMessageDialogVM != null ? publishOrgMessageDialogVM.B() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                if (mutableLiveDataB != null) {
                    value = mutableLiveDataB.getValue();
                } else {
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
        }
        long j2 = 24 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f7752a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7752a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if ((16 & j) != 0) {
            CommonBindingAdapter.I(this.f7753a, 0, 44, 0, 0, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f7750a, aVarA, null);
        }
        if ((22 & j) != 0) {
            CommonBindingAdapter.g(this.f7751a, value, false, false);
        }
        if ((j & 21) != 0) {
            xq8.a(((ChannelDialogPublishOrgMessageBinding) this).f7747a, value2, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7749a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7749a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelDialogPublishOrgMessageBinding
    public void l(@Nullable PublishOrgMessageDialog.a aVar) {
        ((ChannelDialogPublishOrgMessageBinding) this).f33150a = aVar;
        synchronized (this) {
            this.f7749a |= 8;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelDialogPublishOrgMessageBinding
    public void m(@Nullable PublishOrgMessageDialogVM publishOrgMessageDialogVM) {
        ((ChannelDialogPublishOrgMessageBinding) this).f7746a = publishOrgMessageDialogVM;
        synchronized (this) {
            this.f7749a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<PublishOrgMessageClubAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7749a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7749a |= 1;
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
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((PublishOrgMessageDialogVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((PublishOrgMessageDialog.a) obj);
        }
        return true;
    }

    public ChannelDialogPublishOrgMessageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (StateLayout) objArr[2]);
        this.f7749a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f7753a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f7750a = imageView;
        imageView.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[3];
        this.f7751a = recyclerView;
        recyclerView.setTag(null);
        ((ChannelDialogPublishOrgMessageBinding) this).f7747a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
