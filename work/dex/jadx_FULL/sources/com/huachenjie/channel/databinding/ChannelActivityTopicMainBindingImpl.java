package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.page.topic_main.TopicMainActivity;
import com.huachenjie.channel.page.topic_main.TopicMainVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.noober.background.view.BLImageView;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelActivityTopicMainBindingImpl extends ChannelActivityTopicMainBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33135a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f7709a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f7710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f7711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f7712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f7713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f7714a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TopicMainActivity.a f33136a;

        public a a(TopicMainActivity.a aVar) {
            this.f33136a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33136a.f(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TopicMainActivity.a f33137a;

        public b a(TopicMainActivity.a aVar) {
            this.f33137a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33137a.c(view);
        }
    }

    public ChannelActivityTopicMainBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f7709a, f33135a));
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    /* JADX WARN: Code duplicated, block: B:39:0x0082  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        WorksAdapter value;
        Integer value2;
        int i;
        a aVarA;
        b bVarA;
        int iSafeUnbox;
        synchronized (this) {
            j = this.f7710a;
            this.f7710a = 0L;
        }
        TopicMainVM topicMainVM = ((ChannelActivityTopicMainBinding) this).f7707a;
        TopicMainActivity.a aVar = ((ChannelActivityTopicMainBinding) this).f7706a;
        if ((47 & j) != 0) {
            if ((j & 41) == 0) {
                value2 = null;
            } else {
                MutableLiveData<Integer> mutableLiveDataO = topicMainVM != null ? topicMainVM.o() : null;
                updateLiveDataRegistration(0, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value2 = mutableLiveDataO.getValue();
                } else {
                    value2 = null;
                }
            }
            if ((j & 42) != 0) {
                BaseViewModel.b bVarE = topicMainVM != null ? topicMainVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(1, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 44) == 0) {
                i = iSafeUnbox;
                value = null;
            } else {
                MutableLiveData<WorksAdapter> mutableLiveDataM = topicMainVM != null ? topicMainVM.m() : null;
                updateLiveDataRegistration(2, mutableLiveDataM);
                if (mutableLiveDataM != null) {
                    value = mutableLiveDataM.getValue();
                    i = iSafeUnbox;
                } else {
                    i = iSafeUnbox;
                    value = null;
                }
            }
        } else {
            value = null;
            value2 = null;
            i = 0;
        }
        long j2 = 48 & j;
        if (j2 == 0 || aVar == null) {
            aVarA = null;
            bVarA = null;
        } else {
            b bVar = this.f7714a;
            if (bVar == null) {
                bVar = new b();
                this.f7714a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f7713a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f7713a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.q(((ChannelActivityTopicMainBinding) this).f7708a, bVarA, null);
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
        if ((j & 41) != 0) {
            CommonBindingAdapter.w(this.f7711a, value2);
        }
        if ((42 & j) != 0) {
            CommonBindingAdapter.O(this.f7711a, 0, i, 0, 0, null);
        }
        if ((j & 44) != 0) {
            CommonBindingAdapter.g(((ChannelActivityTopicMainBinding) this).f33134a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7710a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7710a = 32L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityTopicMainBinding
    public void l(@Nullable TopicMainActivity.a aVar) {
        ((ChannelActivityTopicMainBinding) this).f7706a = aVar;
        synchronized (this) {
            this.f7710a |= 16;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelActivityTopicMainBinding
    public void m(@Nullable TopicMainVM topicMainVM) {
        ((ChannelActivityTopicMainBinding) this).f7707a = topicMainVM;
        synchronized (this) {
            this.f7710a |= 8;
        }
        notifyPropertyChanged(tk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<WorksAdapter> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7710a |= 4;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7710a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return o((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return n((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != tk0.f44939a) {
            return false;
        }
        synchronized (this) {
            this.f7710a |= 2;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.p0 == i) {
            m((TopicMainVM) obj);
        } else {
            if (tk0.k != i) {
                return false;
            }
            l((TopicMainActivity.a) obj);
        }
        return true;
    }

    public ChannelActivityTopicMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (BLImageView) objArr[3], (BLImageView) objArr[4], (RecyclerView) objArr[1]);
        this.f7710a = -1L;
        ((ChannelActivityTopicMainBinding) this).f7708a.setTag(null);
        this.b.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f7712a = relativeLayout;
        relativeLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[2];
        this.f7711a = frameLayout;
        frameLayout.setTag(null);
        ((ChannelActivityTopicMainBinding) this).f33134a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
