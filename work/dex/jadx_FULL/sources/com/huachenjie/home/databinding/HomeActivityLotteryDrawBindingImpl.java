package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.base.bean.HomeInspirationBean;
import com.huachenjie.base.bean.LotteryDrawBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.home.R;
import com.huachenjie.home.page.draw.LotteryDrawFragment;
import com.huachenjie.home.page.draw.LotteryDrawVM;
import com.huachenjie.home.page.draw.PointsGoodStuffAdapter;
import com.huachenjie.home.widget.TopCropImageView;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeActivityLotteryDrawBindingImpl extends HomeActivityLotteryDrawBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9292a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f9296a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9298a;

    @NonNull
    public final View b;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f34207a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f34207a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f34207a.onRefresh();
        }
    }

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LotteryDrawFragment.a f34208a;

        public a a(LotteryDrawFragment.a aVar) {
            this.f34208a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34208a.c(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LotteryDrawFragment.a f34209a;

        public b a(LotteryDrawFragment.a aVar) {
            this.f34209a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34209a.b(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34206a = sparseIntArray;
        sparseIntArray.put(R.id.iv_title_bg, 8);
        sparseIntArray.put(R.id.iv_coins, 9);
        sparseIntArray.put(R.id.tv_coins, 10);
    }

    public HomeActivityLotteryDrawBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, f9292a, f34206a));
    }

    /* JADX WARN: Code duplicated, block: B:62:0x00ed  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean zSafeUnbox;
        int i;
        PointsGoodStuffAdapter value;
        String str;
        String str2;
        OnRefreshListenerImpl onRefreshListenerImplA;
        a aVarA;
        long j2;
        b bVarA;
        int iSafeUnbox;
        double convertedAmount;
        int total;
        String strFindAmount;
        synchronized (this) {
            j = this.f9293a;
            this.f9293a = 0L;
        }
        LotteryDrawVM lotteryDrawVM = ((HomeActivityLotteryDrawBinding) this).f9290a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((HomeActivityLotteryDrawBinding) this).f9287a;
        LotteryDrawFragment.a aVar = ((HomeActivityLotteryDrawBinding) this).f9289a;
        if ((159 & j) != 0) {
            if ((j & 145) != 0) {
                BaseViewModel.b bVarE = lotteryDrawVM != null ? lotteryDrawVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(0, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 146) != 0) {
                MutableLiveData<LotteryDrawBean> mutableLiveDataK = lotteryDrawVM != null ? lotteryDrawVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                LotteryDrawBean value2 = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                HomeInspirationBean inspiration = value2 != null ? value2.getInspiration() : null;
                if (inspiration != null) {
                    total = inspiration.getTotal();
                    convertedAmount = inspiration.getConvertedAmount();
                    strFindAmount = inspiration.findAmount();
                } else {
                    convertedAmount = AudioStats.AUDIO_AMPLITUDE_NONE;
                    total = 0;
                    strFindAmount = null;
                }
                str = "" + total;
                z = convertedAmount > -1.0d;
                str2 = String.format("≈ %s元", strFindAmount);
            } else {
                z = false;
                str = null;
                str2 = null;
            }
            if ((j & 148) != 0) {
                MutableLiveData<Boolean> mutableLiveDataO = lotteryDrawVM != null ? lotteryDrawVM.o() : null;
                updateLiveDataRegistration(2, mutableLiveDataO);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataO != null ? mutableLiveDataO.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 152) == 0) {
                i = iSafeUnbox;
                value = null;
            } else {
                MutableLiveData<PointsGoodStuffAdapter> mutableLiveDataI = lotteryDrawVM != null ? lotteryDrawVM.i() : null;
                updateLiveDataRegistration(3, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value = mutableLiveDataI.getValue();
                    i = iSafeUnbox;
                } else {
                    i = iSafeUnbox;
                    value = null;
                }
            }
        } else {
            z = false;
            zSafeUnbox = false;
            i = 0;
            value = null;
            str = null;
            str2 = null;
        }
        long j3 = 160 & j;
        if (j3 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f9296a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f9296a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        long j4 = 192 & j;
        if (j4 == 0 || aVar == null) {
            aVarA = null;
            j2 = 152;
            bVarA = null;
        } else {
            b bVar = this.f9298a;
            if (bVar == null) {
                bVar = new b();
                this.f9298a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f9297a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9297a = aVar2;
            }
            aVarA = aVar2.a(aVar);
            j2 = 152;
        }
        if ((j2 & j) != 0) {
            CommonBindingAdapter.g(this.f9295a, value, false, false);
        }
        if (j4 != 0) {
            CommonBindingAdapter.q(this.b, aVarA, null);
            CommonBindingAdapter.q(this.d, bVarA, null);
        }
        if (j3 != 0) {
            ((HomeActivityLotteryDrawBinding) this).f9288a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((148 & j) != 0) {
            ((HomeActivityLotteryDrawBinding) this).f9288a.setRefreshing(zSafeUnbox);
        }
        if ((146 & j) != 0) {
            TextViewBindingAdapter.setText(super.b, str);
            CommonBindingAdapter.l0(this.c, z);
            TextViewBindingAdapter.setText(this.c, str2);
        }
        if ((j & 145) != 0) {
            CommonBindingAdapter.I(((HomeActivityLotteryDrawBinding) this).f34205a, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9293a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9293a = 128L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityLotteryDrawBinding
    public void m(@Nullable LotteryDrawFragment.a aVar) {
        ((HomeActivityLotteryDrawBinding) this).f9289a = aVar;
        synchronized (this) {
            this.f9293a |= 64;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeActivityLotteryDrawBinding
    public void n(@Nullable LotteryDrawVM lotteryDrawVM) {
        ((HomeActivityLotteryDrawBinding) this).f9290a = lotteryDrawVM;
        synchronized (this) {
            this.f9293a |= 16;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<PointsGoodStuffAdapter> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9293a |= 8;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return r((MutableLiveData) obj, i2);
        }
        if (i == 1) {
            return q((MutableLiveData) obj, i2);
        }
        if (i == 2) {
            return p((MutableLiveData) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return o((MutableLiveData) obj, i2);
    }

    public final boolean p(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9293a |= 4;
        }
        return true;
    }

    public final boolean q(MutableLiveData<LotteryDrawBean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9293a |= 2;
        }
        return true;
    }

    public final boolean r(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9293a |= 1;
        }
        return true;
    }

    @Override // com.huachenjie.home.databinding.HomeActivityLotteryDrawBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((HomeActivityLotteryDrawBinding) this).f9287a = onRefreshListener;
        synchronized (this) {
            this.f9293a |= 32;
        }
        notifyPropertyChanged(xk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 == i) {
            n((LotteryDrawVM) obj);
        } else if (xk0.R == i) {
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            m((LotteryDrawFragment.a) obj);
        }
        return true;
    }

    public HomeActivityLotteryDrawBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ImageView) objArr[9], (TopCropImageView) objArr[8], (SwipeRefreshLayout) objArr[1], (TextView) objArr[10], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[7], (View) objArr[3]);
        this.f9293a = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9294a = constraintLayout;
        constraintLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) objArr[2];
        this.f9295a = recyclerView;
        recyclerView.setTag(null);
        View view2 = (View) objArr[4];
        this.b = view2;
        view2.setTag(null);
        ((HomeActivityLotteryDrawBinding) this).f9288a.setTag(null);
        super.b.setTag(null);
        this.c.setTag(null);
        this.d.setTag(null);
        ((HomeActivityLotteryDrawBinding) this).f34205a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
