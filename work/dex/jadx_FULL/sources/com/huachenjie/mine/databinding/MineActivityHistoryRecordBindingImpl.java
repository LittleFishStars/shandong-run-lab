package com.huachenjie.mine.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.history.HistoryRecordActivity;
import com.huachenjie.mine.page.history.HistoryRecordViewModel;
import com.zj.adlib.ik0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MineActivityHistoryRecordBindingImpl extends MineActivityHistoryRecordBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11196a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11201a;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HistoryRecordActivity.a f35295a;

        public a a(HistoryRecordActivity.a aVar) {
            this.f35295a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35295a.b(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HistoryRecordActivity.a f35296a;

        public b a(HistoryRecordActivity.a aVar) {
            this.f35296a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f35296a.c(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35294a = sparseIntArray;
        sparseIntArray.put(R.id.tab_layout, 4);
        sparseIntArray.put(R.id.view_pager, 5);
    }

    public MineActivityHistoryRecordBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f11196a, f35294a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        b bVarA;
        a aVarA;
        synchronized (this) {
            j = this.f11197a;
            this.f11197a = 0L;
        }
        HistoryRecordViewModel historyRecordViewModel = ((MineActivityHistoryRecordBinding) this).f11195a;
        HistoryRecordActivity.a aVar = ((MineActivityHistoryRecordBinding) this).f11194a;
        long j2 = 11 & j;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            BaseViewModel.b bVarE = historyRecordViewModel != null ? historyRecordViewModel.e() : null;
            MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
            updateLiveDataRegistration(0, mutableLiveDataB);
            iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null);
        }
        int i = iSafeUnbox;
        long j3 = j & 12;
        if (j3 == 0 || aVar == null) {
            bVarA = null;
            aVarA = null;
        } else {
            b bVar = this.f11201a;
            if (bVar == null) {
                bVar = new b();
                this.f11201a = bVar;
            }
            bVarA = bVar.a(aVar);
            a aVar2 = this.f11200a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f11200a = aVar2;
            }
            aVarA = aVar2.a(aVar);
        }
        if (j2 != 0) {
            CommonBindingAdapter.O(((MineActivityHistoryRecordBinding) this).f35293a, 0, i, 0, 0, null);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(this.f11199a, bVarA, null);
            CommonBindingAdapter.q(((MineActivityHistoryRecordBinding) this).f11191a, aVarA, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11197a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11197a = 8L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineActivityHistoryRecordBinding
    public void l(@Nullable HistoryRecordActivity.a aVar) {
        ((MineActivityHistoryRecordBinding) this).f11194a = aVar;
        synchronized (this) {
            this.f11197a |= 4;
        }
        notifyPropertyChanged(ik0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.mine.databinding.MineActivityHistoryRecordBinding
    public void m(@Nullable HistoryRecordViewModel historyRecordViewModel) {
        ((MineActivityHistoryRecordBinding) this).f11195a = historyRecordViewModel;
        synchronized (this) {
            this.f11197a |= 2;
        }
        notifyPropertyChanged(ik0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != ik0.f42374a) {
            return false;
        }
        synchronized (this) {
            this.f11197a |= 1;
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
    public boolean setVariable(int i, @Nullable Object obj) {
        if (ik0.p0 == i) {
            m((HistoryRecordViewModel) obj);
        } else {
            if (ik0.k != i) {
                return false;
            }
            l((HistoryRecordActivity.a) obj);
        }
        return true;
    }

    public MineActivityHistoryRecordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[1], (SelectBoldTabLayout) objArr[4], (ImageView) objArr[2], (ViewPager2) objArr[5]);
        this.f11197a = -1L;
        ((MineActivityHistoryRecordBinding) this).f35293a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f11198a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f11199a = textView;
        textView.setTag(null);
        ((MineActivityHistoryRecordBinding) this).f11191a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
