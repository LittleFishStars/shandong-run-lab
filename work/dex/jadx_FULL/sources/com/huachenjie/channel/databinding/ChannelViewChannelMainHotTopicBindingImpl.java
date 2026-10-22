package com.huachenjie.channel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.channel_main.topic.ChannelMainHotTopicAdapter;
import com.huachenjie.channel.page.channel_main.topic.ChannelMainTopicFragment;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelViewChannelMainHotTopicBindingImpl extends ChannelViewChannelMainHotTopicBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8230a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8233a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChannelMainTopicFragment.a f33332a;

        public a a(ChannelMainTopicFragment.a aVar) {
            this.f33332a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33332a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33331a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
    }

    public ChannelViewChannelMainHotTopicBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f8230a, f33331a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f8231a;
            this.f8231a = 0L;
        }
        ChannelMainHotTopicAdapter channelMainHotTopicAdapter = ((ChannelViewChannelMainHotTopicBinding) this).f8227a;
        ChannelMainTopicFragment.a aVar = ((ChannelViewChannelMainHotTopicBinding) this).f8228a;
        Boolean bool = ((ChannelViewChannelMainHotTopicBinding) this).f8229a;
        long j2 = 9 & j;
        long j3 = 10 & j;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f8233a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8233a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        long j4 = j & 12;
        boolean zSafeUnbox = j4 != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        if (j4 != 0) {
            CommonBindingAdapter.l0(this.b, zSafeUnbox);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.b, aVarA, null);
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(((ChannelViewChannelMainHotTopicBinding) this).f8226a, channelMainHotTopicAdapter, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8231a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8231a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelViewChannelMainHotTopicBinding
    public void m(@Nullable ChannelMainHotTopicAdapter channelMainHotTopicAdapter) {
        ((ChannelViewChannelMainHotTopicBinding) this).f8227a = channelMainHotTopicAdapter;
        synchronized (this) {
            this.f8231a |= 1;
        }
        notifyPropertyChanged(tk0.b);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelViewChannelMainHotTopicBinding
    public void n(@Nullable ChannelMainTopicFragment.a aVar) {
        ((ChannelViewChannelMainHotTopicBinding) this).f8228a = aVar;
        synchronized (this) {
            this.f8231a |= 2;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelViewChannelMainHotTopicBinding
    public void o(@Nullable Boolean bool) {
        ((ChannelViewChannelMainHotTopicBinding) this).f8229a = bool;
        synchronized (this) {
            this.f8231a |= 4;
        }
        notifyPropertyChanged(tk0.V);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (tk0.b == i) {
            m((ChannelMainHotTopicAdapter) obj);
        } else if (tk0.k == i) {
            n((ChannelMainTopicFragment.a) obj);
        } else {
            if (tk0.V != i) {
                return false;
            }
            o((Boolean) obj);
        }
        return true;
    }

    public ChannelViewChannelMainHotTopicBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[2], (TextView) objArr[3]);
        this.f8231a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f8232a = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.b = textView;
        textView.setTag(null);
        ((ChannelViewChannelMainHotTopicBinding) this).f8226a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
