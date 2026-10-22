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
import com.huachenjie.channel.page.manage_channel.topic_chat.TopicListAdapter;
import com.huachenjie.channel.page.manage_channel.topic_chat.TopicListDialog;
import com.huachenjie.channel.page.manage_channel.topic_chat.TopicListVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelDialogTopicListBindingImpl extends ChannelDialogTopicListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33156a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7759a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f7764a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TopicListDialog.a f33157a;

        public a a(TopicListDialog.a aVar) {
            this.f33157a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33157a.a(view);
        }
    }

    public ChannelDialogTopicListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f7759a, f33156a));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0080  */
    /* JADX WARN: Code duplicated, block: B:42:0x0083  */
    /* JADX WARN: Code duplicated, block: B:45:0x008e  */
    /* JADX WARN: Code duplicated, block: B:48:0x009f  */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        TopicListAdapter value;
        long j2;
        a aVarA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f7760a;
            this.f7760a = 0L;
        }
        TopicListVM topicListVM = ((ChannelDialogTopicListBinding) this).f7758a;
        TopicListDialog.a aVar = ((ChannelDialogTopicListBinding) this).f33155a;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                BaseViewModel.b bVarE = topicListVM != null ? topicListVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataA = bVarE != null ? bVarE.a() : null;
                updateLiveDataRegistration(0, mutableLiveDataA);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataA != null ? mutableLiveDataA.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 22) != 0) {
                MutableLiveData<TopicListAdapter> mutableLiveDataJ = topicListVM != null ? topicListVM.j() : null;
                updateLiveDataRegistration(1, mutableLiveDataJ);
                if (mutableLiveDataJ != null) {
                    value = mutableLiveDataJ.getValue();
                    i = iSafeUnbox;
                }
                j2 = 24 & j;
                if (j2 != 0 || aVar == null) {
                    aVarA = null;
                } else {
                    a aVar2 = this.f7763a;
                    if (aVar2 == null) {
                        aVar2 = new a();
                        this.f7763a = aVar2;
                    }
                    aVarA = aVar2.a(aVar);
                }
                if (j2 != 0) {
                    CommonBindingAdapter.q(this.f7761a, aVarA, null);
                }
                if ((j & 21) != 0) {
                    CommonBindingAdapter.I(this.f7762a, 0, 0, 0, i, null);
                }
                if ((j & 22) != 0) {
                    CommonBindingAdapter.g(this.f7762a, value, false, false);
                }
            }
            i = iSafeUnbox;
        } else {
            i = 0;
        }
        value = null;
        j2 = 24 & j;
        if (j2 != 0) {
            aVarA = null;
        } else {
            aVarA = null;
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(this.f7761a, aVarA, null);
        }
        if ((j & 21) != 0) {
            CommonBindingAdapter.I(this.f7762a, 0, 0, 0, i, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.g(this.f7762a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7760a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7760a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelDialogTopicListBinding
    public void l(@Nullable TopicListDialog.a aVar) {
        ((ChannelDialogTopicListBinding) this).f33155a = aVar;
        synchronized (this) {
            this.f7760a |= 8;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelDialogTopicListBinding
    public void m(@Nullable TopicListVM topicListVM) {
        ((ChannelDialogTopicListBinding) this).f7758a = topicListVM;
        synchronized (this) {
            this.f7760a |= 4;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<TopicListAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7760a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7760a |= 1;
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
            m((TopicListVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((TopicListDialog.a) obj);
        }
        return true;
    }

    public ChannelDialogTopicListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2);
        this.f7760a = -1L;
        BLLinearLayout bLLinearLayout = (BLLinearLayout) objArr[0];
        this.f7764a = bLLinearLayout;
        bLLinearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f7761a = imageView;
        imageView.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f7762a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
