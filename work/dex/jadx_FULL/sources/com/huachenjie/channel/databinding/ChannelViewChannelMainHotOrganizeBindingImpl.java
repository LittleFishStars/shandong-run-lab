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
import com.huachenjie.channel.page.channel_main.organize.ChannelMainHotOrganizeAdapter;
import com.huachenjie.channel.page.channel_main.organize.ChannelMainOrganizeFragment;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.tk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ChannelViewChannelMainHotOrganizeBindingImpl extends ChannelViewChannelMainHotOrganizeBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8222a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8223a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f8224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f8225a;

    @NonNull
    public final TextView b;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ChannelMainOrganizeFragment.a f33329a;

        public a a(ChannelMainOrganizeFragment.a aVar) {
            this.f33329a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f33329a.a(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33328a = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
    }

    public ChannelViewChannelMainHotOrganizeBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f8222a, f33328a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        a aVarA;
        synchronized (this) {
            j = this.f8223a;
            this.f8223a = 0L;
        }
        ChannelMainHotOrganizeAdapter channelMainHotOrganizeAdapter = ((ChannelViewChannelMainHotOrganizeBinding) this).f8219a;
        ChannelMainOrganizeFragment.a aVar = ((ChannelViewChannelMainHotOrganizeBinding) this).f8220a;
        Boolean bool = ((ChannelViewChannelMainHotOrganizeBinding) this).f8221a;
        long j2 = 9 & j;
        long j3 = 10 & j;
        if (j3 == 0 || aVar == null) {
            aVarA = null;
        } else {
            a aVar2 = this.f8225a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f8225a = aVar2;
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
            CommonBindingAdapter.g(((ChannelViewChannelMainHotOrganizeBinding) this).f8218a, channelMainHotOrganizeAdapter, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8223a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8223a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelViewChannelMainHotOrganizeBinding
    public void m(@Nullable ChannelMainHotOrganizeAdapter channelMainHotOrganizeAdapter) {
        ((ChannelViewChannelMainHotOrganizeBinding) this).f8219a = channelMainHotOrganizeAdapter;
        synchronized (this) {
            this.f8223a |= 1;
        }
        notifyPropertyChanged(tk0.b);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelViewChannelMainHotOrganizeBinding
    public void n(@Nullable ChannelMainOrganizeFragment.a aVar) {
        ((ChannelViewChannelMainHotOrganizeBinding) this).f8220a = aVar;
        synchronized (this) {
            this.f8223a |= 2;
        }
        notifyPropertyChanged(tk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.channel.databinding.ChannelViewChannelMainHotOrganizeBinding
    public void o(@Nullable Boolean bool) {
        ((ChannelViewChannelMainHotOrganizeBinding) this).f8221a = bool;
        synchronized (this) {
            this.f8223a |= 4;
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
            m((ChannelMainHotOrganizeAdapter) obj);
        } else if (tk0.k == i) {
            n((ChannelMainOrganizeFragment.a) obj);
        } else {
            if (tk0.V != i) {
                return false;
            }
            o((Boolean) obj);
        }
        return true;
    }

    public ChannelViewChannelMainHotOrganizeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (RecyclerView) objArr[2], (TextView) objArr[3]);
        this.f8223a = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f8224a = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.b = textView;
        textView.setTag(null);
        ((ChannelViewChannelMainHotOrganizeBinding) this).f8218a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
