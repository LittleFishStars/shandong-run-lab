package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.bean.JackpotBean;
import com.huachenjie.base.bean.LotteryDrawBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.home.R;
import com.huachenjie.home.page.draw.LotteryDrawFragment;
import com.huachenjie.home.page.draw.LotteryDrawVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.youth.banner.Banner;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeLayoutFlashCoinsHeaderBindingImpl extends HomeLayoutFlashCoinsHeaderBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9575a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9576a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9577a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9578a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9580a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f9582a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9583b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f9584c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLTextView f9585c;

    @NonNull
    public final TextView d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f9586e;

    @NonNull
    public final TextView f;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LotteryDrawFragment.a f34303a;

        public a a(LotteryDrawFragment.a aVar) {
            this.f34303a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34303a.e(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LotteryDrawFragment.a f34304a;

        public b a(LotteryDrawFragment.a aVar) {
            this.f34304a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34304a.d(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LotteryDrawFragment.a f34305a;

        public c a(LotteryDrawFragment.a aVar) {
            this.f34305a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34305a.a(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LotteryDrawFragment.a f34306a;

        public d a(LotteryDrawFragment.a aVar) {
            this.f34306a = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34306a.f(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34302a = sparseIntArray;
        sparseIntArray.put(R.id.iv_lottery_bg, 14);
        sparseIntArray.put(R.id.ll_winner_list_broadcast_container, 15);
        sparseIntArray.put(R.id.vp_winner_list, 16);
        sparseIntArray.put(R.id.iv_lottery_draw_podium, 17);
        sparseIntArray.put(R.id.tv_award_name, 18);
        sparseIntArray.put(R.id.vp_banner, 19);
        sparseIntArray.put(R.id.iv_lottery_desc, 20);
        sparseIntArray.put(R.id.fl_task_list, 21);
    }

    public HomeLayoutFlashCoinsHeaderBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 22, f9575a, f34302a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z3;
        String str5;
        String jackpotName;
        int i;
        b bVar;
        d dVar;
        c cVarA;
        long j2;
        a aVar;
        int iSafeUnbox;
        boolean zShowLotteryDraw;
        boolean zShowLotteryDraw2;
        boolean zShowLotteryDraw3;
        JackpotBean jackpotBeanFindLotteryDraw;
        JackpotBean jackpotBeanFindLotteryDraw2;
        JackpotBean jackpotBeanFindLotteryDraw3;
        int jackpotUse;
        String jackpotName2;
        int jackpotUse2;
        String jackpotName3;
        synchronized (this) {
            j = this.f9576a;
            this.f9576a = 0L;
        }
        LotteryDrawVM lotteryDrawVM = ((HomeLayoutFlashCoinsHeaderBinding) this).f9569a;
        LotteryDrawFragment.a aVar2 = ((HomeLayoutFlashCoinsHeaderBinding) this).f9568a;
        int i2 = 0;
        if ((23 & j) != 0) {
            if ((j & 21) != 0) {
                BaseViewModel.b bVarE = lotteryDrawVM != null ? lotteryDrawVM.e() : null;
                MutableLiveData<Integer> mutableLiveDataB = bVarE != null ? bVarE.b() : null;
                updateLiveDataRegistration(0, mutableLiveDataB);
                iSafeUnbox = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(mutableLiveDataB != null ? mutableLiveDataB.getValue() : null) + 44));
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 22) != 0) {
                MutableLiveData<LotteryDrawBean> mutableLiveDataK = lotteryDrawVM != null ? lotteryDrawVM.k() : null;
                updateLiveDataRegistration(1, mutableLiveDataK);
                LotteryDrawBean value = mutableLiveDataK != null ? mutableLiveDataK.getValue() : null;
                if (value != null) {
                    jackpotBeanFindLotteryDraw = value.findLotteryDraw(1);
                    jackpotBeanFindLotteryDraw2 = value.findLotteryDraw(2);
                    zShowLotteryDraw2 = value.showLotteryDraw(2);
                    zShowLotteryDraw3 = value.showLotteryDraw(0);
                    jackpotBeanFindLotteryDraw3 = value.findLotteryDraw(0);
                    zShowLotteryDraw = value.showLotteryDraw(1);
                } else {
                    zShowLotteryDraw = false;
                    zShowLotteryDraw2 = false;
                    zShowLotteryDraw3 = false;
                    jackpotBeanFindLotteryDraw = null;
                    jackpotBeanFindLotteryDraw2 = null;
                    jackpotBeanFindLotteryDraw3 = null;
                }
                if (jackpotBeanFindLotteryDraw != null) {
                    jackpotUse = jackpotBeanFindLotteryDraw.getJackpotUse();
                    jackpotName = jackpotBeanFindLotteryDraw.getJackpotName();
                } else {
                    jackpotUse = 0;
                    jackpotName = null;
                }
                if (jackpotBeanFindLotteryDraw2 != null) {
                    int jackpotUse3 = jackpotBeanFindLotteryDraw2.getJackpotUse();
                    jackpotName2 = jackpotBeanFindLotteryDraw2.getJackpotName();
                    i2 = jackpotUse3;
                } else {
                    jackpotName2 = null;
                }
                if (jackpotBeanFindLotteryDraw3 != null) {
                    jackpotName3 = jackpotBeanFindLotteryDraw3.getJackpotName();
                    jackpotUse2 = jackpotBeanFindLotteryDraw3.getJackpotUse();
                } else {
                    jackpotUse2 = 0;
                    jackpotName3 = null;
                }
                str2 = "" + jackpotUse;
                str3 = "" + i2;
                str = "" + jackpotUse2;
                i = iSafeUnbox;
                z3 = zShowLotteryDraw2;
                str4 = jackpotName2;
                str5 = jackpotName3;
                z2 = zShowLotteryDraw;
                z = zShowLotteryDraw3;
            } else {
                i = iSafeUnbox;
                z = false;
                z2 = false;
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                z3 = false;
                str5 = null;
                jackpotName = null;
            }
        } else {
            z = false;
            z2 = false;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            z3 = false;
            str5 = null;
            jackpotName = null;
            i = 0;
        }
        long j3 = j & 24;
        if (j3 == 0 || aVar2 == null) {
            bVar = null;
            dVar = null;
            cVarA = null;
            j2 = 21;
            aVar = null;
        } else {
            d dVar2 = this.f9582a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f9582a = dVar2;
            }
            d dVarA = dVar2.a(aVar2);
            a aVar3 = this.f9579a;
            if (aVar3 == null) {
                aVar3 = new a();
                this.f9579a = aVar3;
            }
            a aVarA = aVar3.a(aVar2);
            b bVar2 = this.f9580a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f9580a = bVar2;
            }
            b bVarA = bVar2.a(aVar2);
            c cVar = this.f9581a;
            if (cVar == null) {
                cVar = new c();
                this.f9581a = cVar;
            }
            cVarA = cVar.a(aVar2);
            aVar = aVarA;
            dVar = dVarA;
            bVar = bVarA;
            j2 = 21;
        }
        if ((j & j2) != 0) {
            CommonBindingAdapter.I(super.d, 0, i, 0, 0, null);
        }
        if ((j & 22) != 0) {
            CommonBindingAdapter.l0(((HomeLayoutFlashCoinsHeaderBinding) this).f9567a, z2);
            CommonBindingAdapter.l0(this.b, z3);
            TextViewBindingAdapter.setText(this.f9577a, str4);
            TextViewBindingAdapter.setText(this.f9583b, str3);
            TextViewBindingAdapter.setText(this.f9584c, jackpotName);
            TextViewBindingAdapter.setText(this.d, str2);
            CommonBindingAdapter.l0(this.c, z);
            TextViewBindingAdapter.setText(this.f9586e, str5);
            TextViewBindingAdapter.setText(this.f, str);
        }
        if (j3 != 0) {
            CommonBindingAdapter.q(((HomeLayoutFlashCoinsHeaderBinding) this).f9567a, bVar, null);
            CommonBindingAdapter.q(this.b, bVar, null);
            CommonBindingAdapter.q(this.e, dVar, null);
            CommonBindingAdapter.q(this.f9585c, cVarA, null);
            CommonBindingAdapter.q(this.c, bVar, null);
            CommonBindingAdapter.q(((HomeLayoutFlashCoinsHeaderBinding) this).f9573b, aVar, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9576a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9576a = 16L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeLayoutFlashCoinsHeaderBinding
    public void l(@Nullable LotteryDrawFragment.a aVar) {
        ((HomeLayoutFlashCoinsHeaderBinding) this).f9568a = aVar;
        synchronized (this) {
            this.f9576a |= 8;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeLayoutFlashCoinsHeaderBinding
    public void m(@Nullable LotteryDrawVM lotteryDrawVM) {
        ((HomeLayoutFlashCoinsHeaderBinding) this).f9569a = lotteryDrawVM;
        synchronized (this) {
            this.f9576a |= 4;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<LotteryDrawBean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9576a |= 2;
        }
        return true;
    }

    public final boolean o(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9576a |= 1;
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
        if (xk0.p0 == i) {
            m((LotteryDrawVM) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            l((LotteryDrawFragment.a) obj);
        }
        return true;
    }

    public HomeLayoutFlashCoinsHeaderBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (FrameLayout) objArr[21], (ImageView) objArr[14], (ImageView) objArr[20], (ImageView) objArr[17], (ImageView) objArr[1], (LinearLayout) objArr[4], (BLLinearLayout) objArr[15], (BLTextView) objArr[18], (BLTextView) objArr[13], (Banner) objArr[19], (Banner) objArr[16]);
        this.f9576a = -1L;
        super.d.setTag(null);
        ((HomeLayoutFlashCoinsHeaderBinding) this).f9567a.setTag("1");
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f9578a = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[10];
        this.b = linearLayout;
        linearLayout.setTag("2");
        TextView textView = (TextView) objArr[11];
        this.f9577a = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.f9583b = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) objArr[2];
        this.e = imageView;
        imageView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[3];
        this.f9585c = bLTextView;
        bLTextView.setTag(null);
        TextView textView3 = (TextView) objArr[5];
        this.f9584c = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[6];
        this.d = textView4;
        textView4.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[7];
        this.c = linearLayout2;
        linearLayout2.setTag("0");
        TextView textView5 = (TextView) objArr[8];
        this.f9586e = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[9];
        this.f = textView6;
        textView6.setTag(null);
        ((HomeLayoutFlashCoinsHeaderBinding) this).f9573b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
