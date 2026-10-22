package com.huachenjie.run.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.bean.FinishRunResult;
import com.huachenjie.run.bean.RunFinishBannerBean;
import com.huachenjie.run.bean.RunFinishBannerData;
import com.huachenjie.run.binding.RunBindingAdapter;
import com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessActivity;
import com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessMoodAdapter;
import com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessVM;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.zj.adlib.ju3;
import com.zj.adlib.lk0;
import com.zj.adlib.ll7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivitySunshineRunSuccessBindingImpl extends RunActivitySunshineRunSuccessBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f11646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f11647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f11648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f11649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f11650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11651a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f11652b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11653b;

    @NonNull
    public final ImageView f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final ImageView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRunSuccessActivity.a f35508a;

        public a a(SunshineRunSuccessActivity.a value) {
            this.f35508a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35508a.b(arg0);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRunSuccessActivity.a f35509a;

        public b a(SunshineRunSuccessActivity.a value) {
            this.f35509a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35509a.a(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SunshineRunSuccessActivity.a f35510a;

        public c a(SunshineRunSuccessActivity.a value) {
            this.f35510a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f35510a.c(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(34);
        f11644a = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"layout_toolbar_binding"}, new int[]{24}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35507a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.ivTrophy, 25);
        sparseIntArray.put(com.huachenjie.run.R.id.ivBrand, 26);
        sparseIntArray.put(com.huachenjie.run.R.id.barrierHeaderBottom, 27);
        sparseIntArray.put(com.huachenjie.run.R.id.barrierHeaderEnd, 28);
        sparseIntArray.put(com.huachenjie.run.R.id.tvCongrats, 29);
        sparseIntArray.put(com.huachenjie.run.R.id.tvGoalReached, 30);
        sparseIntArray.put(com.huachenjie.run.R.id.tvDistanceLabel, 31);
        sparseIntArray.put(com.huachenjie.run.R.id.flExpressAd, 32);
        sparseIntArray.put(com.huachenjie.run.R.id.flFd, 33);
    }

    public RunActivitySunshineRunSuccessBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 34, f11644a, f35507a));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x018f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x0191  */
    /* JADX WARN: Code duplicated, block: B:102:0x0198  */
    /* JADX WARN: Code duplicated, block: B:105:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:106:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:108:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:111:0x01c4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:113:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:116:0x01df  */
    /* JADX WARN: Code duplicated, block: B:117:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:119:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:120:0x0216  */
    /* JADX WARN: Code duplicated, block: B:122:0x0227  */
    /* JADX WARN: Code duplicated, block: B:123:0x022c  */
    /* JADX WARN: Code duplicated, block: B:125:0x0230  */
    /* JADX WARN: Code duplicated, block: B:126:0x0235  */
    /* JADX WARN: Code duplicated, block: B:128:0x0239  */
    /* JADX WARN: Code duplicated, block: B:129:0x023e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0241  */
    /* JADX WARN: Code duplicated, block: B:132:0x0246  */
    /* JADX WARN: Code duplicated, block: B:134:0x024a  */
    /* JADX WARN: Code duplicated, block: B:137:0x0267 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x0269  */
    /* JADX WARN: Code duplicated, block: B:139:0x0276  */
    /* JADX WARN: Code duplicated, block: B:142:0x0282  */
    /* JADX WARN: Code duplicated, block: B:143:0x0289  */
    /* JADX WARN: Code duplicated, block: B:145:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:150:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:180:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:181:0x03af  */
    /* JADX WARN: Code duplicated, block: B:184:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:186:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:189:0x0416  */
    /* JADX WARN: Code duplicated, block: B:192:0x0438  */
    /* JADX WARN: Code duplicated, block: B:195:0x0446  */
    /* JADX WARN: Code duplicated, block: B:198:0x045a  */
    /* JADX WARN: Code duplicated, block: B:200:0x0471  */
    /* JADX WARN: Code duplicated, block: B:203:0x0481  */
    /* JADX WARN: Code duplicated, block: B:206:0x048f  */
    /* JADX WARN: Code duplicated, block: B:209:0x049c  */
    /* JADX WARN: Code duplicated, block: B:212:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:215:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x0122  */
    /* JADX WARN: Code duplicated, block: B:78:0x0140  */
    /* JADX WARN: Code duplicated, block: B:87:0x015e  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        long j2;
        Boolean value;
        boolean zShowBannerByIndex;
        boolean zShowBannerByIndex2;
        boolean z;
        String str;
        boolean zShowBannerByIndex3;
        String picUrl;
        boolean zSafeUnbox;
        Drawable drawable;
        String str2;
        SpannableStringBuilder value2;
        String value3;
        String value4;
        SunshineRunSuccessMoodAdapter moodAdapter;
        String str3;
        String str4;
        String str5;
        boolean zSafeUnbox2;
        boolean z2;
        BindingTitleBean bindingTitleBean;
        boolean zShowBannerByIndex4;
        String picUrl2;
        String picUrl3;
        b bVarA;
        c cVar;
        a aVarA;
        c cVarA;
        String str6;
        String str7;
        Drawable drawable2;
        boolean zSafeUnbox3;
        BindingTitleBean value5;
        boolean zSafeUnbox4;
        String picUrl4;
        long j3;
        MutableLiveData<Long> mutableLiveDataS;
        Long value6;
        MutableLiveData<RunFinishBannerData> mutableLiveDataK;
        RunFinishBannerData value7;
        RunFinishBannerBean runFinishBannerBean;
        RunFinishBannerBean runFinishBannerBeanFindBannerByIndex;
        RunFinishBannerBean runFinishBannerBeanFindBannerByIndex2;
        RunFinishBannerBean runFinishBannerBeanFindBannerByIndex3;
        RunFinishBannerBean runFinishBannerBeanFindBannerByIndex4;
        MutableLiveData<Boolean> mutableLiveDataR;
        Boolean value8;
        long j4;
        long j5;
        Long rewardDistance;
        Integer rewardTimes;
        Integer num;
        synchronized (this) {
            j = this.f11645a;
            this.f11645a = 0L;
        }
        SunshineRunSuccessVM sunshineRunSuccessVM = ((RunActivitySunshineRunSuccessBinding) this).f11636a;
        SunshineRunSuccessActivity.a aVar = ((RunActivitySunshineRunSuccessBinding) this).f11635a;
        float f = 0.0f;
        if ((8191 & j) != 0) {
            if ((j & 5121) != 0) {
                MutableLiveData<Boolean> mutableLiveDataW = sunshineRunSuccessVM != null ? sunshineRunSuccessVM.w() : null;
                updateLiveDataRegistration(0, mutableLiveDataW);
                zSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataW != null ? mutableLiveDataW.getValue() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 5122) != 0) {
                MutableLiveData<FinishRunResult> mutableLiveDataT = sunshineRunSuccessVM != null ? sunshineRunSuccessVM.t() : null;
                updateLiveDataRegistration(1, mutableLiveDataT);
                FinishRunResult value9 = mutableLiveDataT != null ? mutableLiveDataT.getValue() : null;
                if (value9 != null) {
                    rewardTimes = value9.getRewardTimes();
                    Integer validDistance = value9.getValidDistance();
                    rewardDistance = value9.getRewardDistance();
                    num = validDistance;
                } else {
                    rewardDistance = null;
                    rewardTimes = null;
                    num = null;
                }
                str7 = String.format("次数+%s", rewardTimes);
                ll7 ll7Var = ll7.f43096a;
                String strF = ll7Var.f(num, true, true, 1);
                String strI = ll7Var.i(rewardDistance, true, true, 1);
                str3 = String.format("%1s", strF);
                str6 = String.format("奖励%s", strI);
            } else {
                str6 = null;
                str7 = null;
                str3 = null;
            }
            if ((j & 7172) != 0) {
                MutableLiveData<Boolean> mutableLiveDataP = sunshineRunSuccessVM != null ? sunshineRunSuccessVM.p() : null;
                updateLiveDataRegistration(2, mutableLiveDataP);
                value = mutableLiveDataP != null ? mutableLiveDataP.getValue() : null;
                zSafeUnbox3 = ViewDataBinding.safeUnbox(value);
                if ((j & 5124) != 0) {
                    if (zSafeUnbox3) {
                        j4 = j | PlaybackStateCompat.ACTION_PREPARE;
                        j5 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    } else {
                        j4 = j | 8192;
                        j5 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                    j = j4 | j5;
                }
                if ((j & 5124) != 0) {
                    drawable2 = AppCompatResources.getDrawable(((RunActivitySunshineRunSuccessBinding) this).c.getContext(), zSafeUnbox3 ? com.huachenjie.run.R.drawable.run_bg_succ_mood_btn_highlight : com.huachenjie.run.R.drawable.run_bg_succ_mood_btn_normal);
                    f = zSafeUnbox3 ? 1.0f : 0.4f;
                } else {
                    drawable2 = null;
                }
            } else {
                drawable2 = null;
                value = null;
                zSafeUnbox3 = false;
            }
            if ((j & 5128) == 0) {
                value3 = null;
            } else {
                MutableLiveData<String> mutableLiveDataO = sunshineRunSuccessVM != null ? sunshineRunSuccessVM.o() : null;
                updateLiveDataRegistration(3, mutableLiveDataO);
                if (mutableLiveDataO != null) {
                    value3 = mutableLiveDataO.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 5136) == 0) {
                value4 = null;
            } else {
                MutableLiveData<String> mutableLiveDataL = sunshineRunSuccessVM != null ? sunshineRunSuccessVM.l() : null;
                updateLiveDataRegistration(4, mutableLiveDataL);
                if (mutableLiveDataL != null) {
                    value4 = mutableLiveDataL.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 5152) == 0) {
                value5 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataI = sunshineRunSuccessVM != null ? sunshineRunSuccessVM.i() : null;
                updateLiveDataRegistration(5, mutableLiveDataI);
                if (mutableLiveDataI != null) {
                    value5 = mutableLiveDataI.getValue();
                } else {
                    value5 = null;
                }
            }
            if ((j & 5184) != 0) {
                MutableLiveData<SpannableStringBuilder> mutableLiveDataN = sunshineRunSuccessVM != null ? sunshineRunSuccessVM.n() : null;
                updateLiveDataRegistration(6, mutableLiveDataN);
                value2 = mutableLiveDataN != null ? mutableLiveDataN.getValue() : null;
                if ((j & 5248) != 0) {
                    if (sunshineRunSuccessVM != null) {
                        mutableLiveDataR = sunshineRunSuccessVM.r();
                    } else {
                        mutableLiveDataR = null;
                    }
                    updateLiveDataRegistration(7, mutableLiveDataR);
                    if (mutableLiveDataR != null) {
                        value8 = mutableLiveDataR.getValue();
                    } else {
                        value8 = null;
                    }
                    zSafeUnbox4 = ViewDataBinding.safeUnbox(value8);
                    zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
                } else {
                    value2 = value2;
                    zSafeUnbox4 = false;
                    zSafeUnbox2 = false;
                }
                if ((j & 5376) != 0) {
                    if (sunshineRunSuccessVM != null) {
                        mutableLiveDataK = sunshineRunSuccessVM.k();
                    } else {
                        mutableLiveDataK = null;
                    }
                    updateLiveDataRegistration(8, mutableLiveDataK);
                    if (mutableLiveDataK != null) {
                        value7 = mutableLiveDataK.getValue();
                    } else {
                        value7 = null;
                    }
                    if (value7 != null) {
                        runFinishBannerBeanFindBannerByIndex2 = value7.findBannerByIndex(3);
                        zShowBannerByIndex2 = value7.showBannerByIndex(2);
                        runFinishBannerBeanFindBannerByIndex3 = value7.findBannerByIndex(1);
                        zShowBannerByIndex3 = value7.showBannerByIndex(0);
                        zShowBannerByIndex = value7.showBannerByIndex(1);
                        runFinishBannerBeanFindBannerByIndex4 = value7.findBannerByIndex(0);
                        runFinishBannerBeanFindBannerByIndex = value7.findBannerByIndex(2);
                        zShowBannerByIndex4 = value7.showBannerByIndex(3);
                    } else {
                        zShowBannerByIndex4 = false;
                        runFinishBannerBean = null;
                        runFinishBannerBeanFindBannerByIndex = null;
                        zShowBannerByIndex2 = false;
                        runFinishBannerBeanFindBannerByIndex2 = null;
                        runFinishBannerBeanFindBannerByIndex3 = null;
                        zShowBannerByIndex3 = false;
                        zShowBannerByIndex = false;
                    }
                    if (runFinishBannerBeanFindBannerByIndex2 != null) {
                        picUrl3 = runFinishBannerBeanFindBannerByIndex2.getPicUrl();
                    } else {
                        picUrl3 = null;
                    }
                    if (runFinishBannerBeanFindBannerByIndex3 != null) {
                        runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                        picUrl = runFinishBannerBeanFindBannerByIndex3.getPicUrl();
                    } else {
                        runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                        picUrl = null;
                    }
                    if (runFinishBannerBean != null) {
                        runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                        picUrl4 = runFinishBannerBean.getPicUrl();
                    } else {
                        runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                        picUrl4 = null;
                    }
                    if (runFinishBannerBeanFindBannerByIndex != null) {
                        runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                        runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                        picUrl2 = runFinishBannerBeanFindBannerByIndex.getPicUrl();
                    } else {
                        runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                        runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                        picUrl2 = null;
                    }
                    j3 = 5632;
                } else {
                    zSafeUnbox4 = zSafeUnbox4;
                    value5 = value5;
                    zSafeUnbox = zSafeUnbox;
                    zShowBannerByIndex4 = false;
                    picUrl4 = null;
                    picUrl2 = null;
                    j3 = 5632;
                    zShowBannerByIndex2 = false;
                    picUrl3 = null;
                    picUrl = null;
                    zShowBannerByIndex3 = false;
                    zShowBannerByIndex = false;
                }
                if ((j & j3) != 0) {
                    if (sunshineRunSuccessVM != null) {
                        mutableLiveDataS = sunshineRunSuccessVM.s();
                    } else {
                        mutableLiveDataS = null;
                    }
                    updateLiveDataRegistration(9, mutableLiveDataS);
                    if (mutableLiveDataS != null) {
                        value6 = mutableLiveDataS.getValue();
                    } else {
                        value6 = null;
                    }
                    str2 = String.format("%1s", ll7.f43096a.p(ViewDataBinding.safeUnbox(value6), false));
                } else {
                    zShowBannerByIndex4 = zShowBannerByIndex4;
                    picUrl4 = picUrl4;
                    str2 = null;
                }
                j2 = 0;
                if ((j & 5120) != 0 || sunshineRunSuccessVM == null) {
                    moodAdapter = null;
                } else {
                    moodAdapter = sunshineRunSuccessVM.getMoodAdapter();
                }
                z2 = zSafeUnbox4;
                str4 = str7;
                str = picUrl4;
                bindingTitleBean = value5;
                str5 = str6;
                z = zSafeUnbox3;
                drawable = drawable2;
            } else {
                value4 = value4;
            }
            if ((j & 5248) != 0) {
                if (sunshineRunSuccessVM != null) {
                    mutableLiveDataR = sunshineRunSuccessVM.r();
                } else {
                    mutableLiveDataR = null;
                }
                updateLiveDataRegistration(7, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value8 = mutableLiveDataR.getValue();
                } else {
                    value8 = null;
                }
                zSafeUnbox4 = ViewDataBinding.safeUnbox(value8);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(!zSafeUnbox4));
            } else {
                value2 = value2;
                zSafeUnbox4 = false;
                zSafeUnbox2 = false;
            }
            if ((j & 5376) != 0) {
                if (sunshineRunSuccessVM != null) {
                    mutableLiveDataK = sunshineRunSuccessVM.k();
                } else {
                    mutableLiveDataK = null;
                }
                updateLiveDataRegistration(8, mutableLiveDataK);
                if (mutableLiveDataK != null) {
                    value7 = mutableLiveDataK.getValue();
                } else {
                    value7 = null;
                }
                if (value7 != null) {
                    runFinishBannerBeanFindBannerByIndex2 = value7.findBannerByIndex(3);
                    zShowBannerByIndex2 = value7.showBannerByIndex(2);
                    runFinishBannerBeanFindBannerByIndex3 = value7.findBannerByIndex(1);
                    zShowBannerByIndex3 = value7.showBannerByIndex(0);
                    zShowBannerByIndex = value7.showBannerByIndex(1);
                    runFinishBannerBeanFindBannerByIndex4 = value7.findBannerByIndex(0);
                    runFinishBannerBeanFindBannerByIndex = value7.findBannerByIndex(2);
                    zShowBannerByIndex4 = value7.showBannerByIndex(3);
                } else {
                    zShowBannerByIndex4 = false;
                    runFinishBannerBean = null;
                    runFinishBannerBeanFindBannerByIndex = null;
                    zShowBannerByIndex2 = false;
                    runFinishBannerBeanFindBannerByIndex2 = null;
                    runFinishBannerBeanFindBannerByIndex3 = null;
                    zShowBannerByIndex3 = false;
                    zShowBannerByIndex = false;
                }
                if (runFinishBannerBeanFindBannerByIndex2 != null) {
                    picUrl3 = runFinishBannerBeanFindBannerByIndex2.getPicUrl();
                } else {
                    picUrl3 = null;
                }
                if (runFinishBannerBeanFindBannerByIndex3 != null) {
                    runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                    picUrl = runFinishBannerBeanFindBannerByIndex3.getPicUrl();
                } else {
                    runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                    picUrl = null;
                }
                if (runFinishBannerBean != null) {
                    runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                    picUrl4 = runFinishBannerBean.getPicUrl();
                } else {
                    runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                    picUrl4 = null;
                }
                if (runFinishBannerBeanFindBannerByIndex != null) {
                    runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                    runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                    picUrl2 = runFinishBannerBeanFindBannerByIndex.getPicUrl();
                } else {
                    runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                    runFinishBannerBean = runFinishBannerBeanFindBannerByIndex4;
                    picUrl2 = null;
                }
                j3 = 5632;
            } else {
                zSafeUnbox4 = zSafeUnbox4;
                value5 = value5;
                zSafeUnbox = zSafeUnbox;
                zShowBannerByIndex4 = false;
                picUrl4 = null;
                picUrl2 = null;
                j3 = 5632;
                zShowBannerByIndex2 = false;
                picUrl3 = null;
                picUrl = null;
                zShowBannerByIndex3 = false;
                zShowBannerByIndex = false;
            }
            if ((j & j3) != 0) {
                if (sunshineRunSuccessVM != null) {
                    mutableLiveDataS = sunshineRunSuccessVM.s();
                } else {
                    mutableLiveDataS = null;
                }
                updateLiveDataRegistration(9, mutableLiveDataS);
                if (mutableLiveDataS != null) {
                    value6 = mutableLiveDataS.getValue();
                } else {
                    value6 = null;
                }
                str2 = String.format("%1s", ll7.f43096a.p(ViewDataBinding.safeUnbox(value6), false));
            } else {
                zShowBannerByIndex4 = zShowBannerByIndex4;
                picUrl4 = picUrl4;
                str2 = null;
            }
            j2 = 0;
            if ((j & 5120) != 0) {
                moodAdapter = null;
            } else {
                moodAdapter = null;
            }
            z2 = zSafeUnbox4;
            str4 = str7;
            str = picUrl4;
            bindingTitleBean = value5;
            str5 = str6;
            z = zSafeUnbox3;
            drawable = drawable2;
        } else {
            j2 = 0;
            f = 0.0f;
            value = null;
            zShowBannerByIndex = false;
            zShowBannerByIndex2 = false;
            z = false;
            str = null;
            zShowBannerByIndex3 = false;
            picUrl = null;
            zSafeUnbox = false;
            drawable = null;
            str2 = null;
            value2 = null;
            value3 = null;
            value4 = null;
            moodAdapter = null;
            str3 = null;
            str4 = null;
            str5 = null;
            zSafeUnbox2 = false;
            z2 = false;
            bindingTitleBean = null;
            zShowBannerByIndex4 = false;
            picUrl2 = null;
            picUrl3 = null;
        }
        long j6 = j & 5376;
        RequestOptions requestOptions = j6 != j2 ? ju3.h : null;
        long j7 = j & 7172;
        if (j7 != j2) {
            if (aVar != null) {
                c cVar2 = this.f11649a;
                if (cVar2 == null) {
                    cVar2 = new c();
                    this.f11649a = cVar2;
                }
                cVarA = cVar2.a(aVar);
            } else {
                cVarA = null;
            }
            if ((j & 6144) == 0 || aVar == null) {
                cVar = cVarA;
                bVarA = null;
            } else {
                a aVar2 = this.f11647a;
                if (aVar2 == null) {
                    aVar2 = new a();
                    this.f11647a = aVar2;
                }
                aVarA = aVar2.a(aVar);
                c cVar3 = cVarA;
                b bVar = this.f11648a;
                if (bVar == null) {
                    bVar = new b();
                    this.f11648a = bVar;
                }
                bVarA = bVar.a(aVar);
                cVar = cVar3;
            }
            if ((j & 5121) != 0) {
                CommonBindingAdapter.l0(((RunActivitySunshineRunSuccessBinding) this).f11629a, zSafeUnbox);
                CommonBindingAdapter.l0(((RunActivitySunshineRunSuccessBinding) this).f11637a, zSafeUnbox);
            }
            if ((j & 5124) != 0) {
                ImageViewBindingAdapter.setImageDrawable(((RunActivitySunshineRunSuccessBinding) this).c, drawable);
                CommonBindingAdapter.c0(((RunActivitySunshineRunSuccessBinding) this).d, f);
                CommonBindingAdapter.e0(((RunActivitySunshineRunSuccessBinding) this).f11633a, z);
                RunBindingAdapter.a(((RunActivitySunshineRunSuccessBinding) this).f11633a, value);
                RunBindingAdapter.b(super.f, value);
                RunBindingAdapter.b(super.g, value);
            }
            if (j6 != j2) {
                CommonBindingAdapter.l0(((RunActivitySunshineRunSuccessBinding) this).f11630a, zShowBannerByIndex3);
                CommonBindingAdapter.l0(this.f, zShowBannerByIndex3);
                CommonBindingAdapter.b0(this.f, str, requestOptions, false);
                CommonBindingAdapter.l0(this.g, zShowBannerByIndex);
                CommonBindingAdapter.b0(this.g, picUrl, requestOptions, false);
                CommonBindingAdapter.l0(this.h, zShowBannerByIndex2);
                CommonBindingAdapter.b0(this.h, picUrl2, requestOptions, false);
                CommonBindingAdapter.l0(this.i, zShowBannerByIndex4);
                CommonBindingAdapter.b0(this.i, picUrl3, requestOptions, false);
            }
            if ((6144 & j) != 0) {
                CommonBindingAdapter.q(this.f, aVarA, null);
                CommonBindingAdapter.q(this.g, aVarA, null);
                CommonBindingAdapter.q(this.h, aVarA, null);
                CommonBindingAdapter.q(this.i, aVarA, null);
                CommonBindingAdapter.q(this.f11651a, bVarA, null);
            }
            if ((j & 5152) != 0) {
                this.f11646a.k(bindingTitleBean);
            }
            if ((5248 & j) != 0) {
                CommonBindingAdapter.l0(this.f11653b, z2);
                CommonBindingAdapter.l0(this.f11652b, zSafeUnbox2);
            }
            if ((j & 5122) != 0) {
                TextViewBindingAdapter.setText(this.j, str5);
                TextViewBindingAdapter.setText(this.k, str4);
                TextViewBindingAdapter.setText(((RunActivitySunshineRunSuccessBinding) this).f11641c, str3);
            }
            if (j7 != j2) {
                ViewBindingAdapter.setOnClick(((RunActivitySunshineRunSuccessBinding) this).f11633a, cVar, z);
            }
            if ((5120 & j) != 0) {
                CommonBindingAdapter.g(((RunActivitySunshineRunSuccessBinding) this).f11634a, moodAdapter, false, false);
            }
            if ((j & 5136) != 0) {
                TextViewBindingAdapter.setText(((RunActivitySunshineRunSuccessBinding) this).f11631a, value4);
            }
            if ((j & 5128) != 0) {
                TextViewBindingAdapter.setText(super.f, value3);
            }
            if ((5184 & j) != 0) {
                CommonBindingAdapter.j0(super.h, value2);
            }
            if ((j & 5632) != 0) {
                TextViewBindingAdapter.setText(super.i, str2);
            }
            ViewDataBinding.executeBindingsOn(this.f11646a);
        }
        bVarA = null;
        cVar = null;
        aVarA = null;
        if ((j & 5121) != 0) {
            CommonBindingAdapter.l0(((RunActivitySunshineRunSuccessBinding) this).f11629a, zSafeUnbox);
            CommonBindingAdapter.l0(((RunActivitySunshineRunSuccessBinding) this).f11637a, zSafeUnbox);
        }
        if ((j & 5124) != 0) {
            ImageViewBindingAdapter.setImageDrawable(((RunActivitySunshineRunSuccessBinding) this).c, drawable);
            CommonBindingAdapter.c0(((RunActivitySunshineRunSuccessBinding) this).d, f);
            CommonBindingAdapter.e0(((RunActivitySunshineRunSuccessBinding) this).f11633a, z);
            RunBindingAdapter.a(((RunActivitySunshineRunSuccessBinding) this).f11633a, value);
            RunBindingAdapter.b(super.f, value);
            RunBindingAdapter.b(super.g, value);
        }
        if (j6 != j2) {
            CommonBindingAdapter.l0(((RunActivitySunshineRunSuccessBinding) this).f11630a, zShowBannerByIndex3);
            CommonBindingAdapter.l0(this.f, zShowBannerByIndex3);
            CommonBindingAdapter.b0(this.f, str, requestOptions, false);
            CommonBindingAdapter.l0(this.g, zShowBannerByIndex);
            CommonBindingAdapter.b0(this.g, picUrl, requestOptions, false);
            CommonBindingAdapter.l0(this.h, zShowBannerByIndex2);
            CommonBindingAdapter.b0(this.h, picUrl2, requestOptions, false);
            CommonBindingAdapter.l0(this.i, zShowBannerByIndex4);
            CommonBindingAdapter.b0(this.i, picUrl3, requestOptions, false);
        }
        if ((6144 & j) != 0) {
            CommonBindingAdapter.q(this.f, aVarA, null);
            CommonBindingAdapter.q(this.g, aVarA, null);
            CommonBindingAdapter.q(this.h, aVarA, null);
            CommonBindingAdapter.q(this.i, aVarA, null);
            CommonBindingAdapter.q(this.f11651a, bVarA, null);
        }
        if ((j & 5152) != 0) {
            this.f11646a.k(bindingTitleBean);
        }
        if ((5248 & j) != 0) {
            CommonBindingAdapter.l0(this.f11653b, z2);
            CommonBindingAdapter.l0(this.f11652b, zSafeUnbox2);
        }
        if ((j & 5122) != 0) {
            TextViewBindingAdapter.setText(this.j, str5);
            TextViewBindingAdapter.setText(this.k, str4);
            TextViewBindingAdapter.setText(((RunActivitySunshineRunSuccessBinding) this).f11641c, str3);
        }
        if (j7 != j2) {
            ViewBindingAdapter.setOnClick(((RunActivitySunshineRunSuccessBinding) this).f11633a, cVar, z);
        }
        if ((5120 & j) != 0) {
            CommonBindingAdapter.g(((RunActivitySunshineRunSuccessBinding) this).f11634a, moodAdapter, false, false);
        }
        if ((j & 5136) != 0) {
            TextViewBindingAdapter.setText(((RunActivitySunshineRunSuccessBinding) this).f11631a, value4);
        }
        if ((j & 5128) != 0) {
            TextViewBindingAdapter.setText(super.f, value3);
        }
        if ((5184 & j) != 0) {
            CommonBindingAdapter.j0(super.h, value2);
        }
        if ((j & 5632) != 0) {
            TextViewBindingAdapter.setText(super.i, str2);
        }
        ViewDataBinding.executeBindingsOn(this.f11646a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11645a != 0) {
                return true;
            }
            return this.f11646a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11645a = 4096L;
        }
        this.f11646a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivitySunshineRunSuccessBinding
    public void l(@Nullable SunshineRunSuccessActivity.a Click) {
        ((RunActivitySunshineRunSuccessBinding) this).f11635a = Click;
        synchronized (this) {
            this.f11645a |= 2048;
        }
        notifyPropertyChanged(lk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivitySunshineRunSuccessBinding
    public void m(@Nullable SunshineRunSuccessVM Vm) {
        ((RunActivitySunshineRunSuccessBinding) this).f11636a = Vm;
        synchronized (this) {
            this.f11645a |= 1024;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean n(MutableLiveData<RunFinishBannerData> VmBannerData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11645a |= 256;
        }
        return true;
    }

    public final boolean o(MutableLiveData<String> VmCalorieText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11645a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return p((MutableLiveData) object, fieldId);
            case 1:
                return v((MutableLiveData) object, fieldId);
            case 2:
                return s((MutableLiveData) object, fieldId);
            case 3:
                return r((MutableLiveData) object, fieldId);
            case 4:
                return o((MutableLiveData) object, fieldId);
            case 5:
                return w((MutableLiveData) object, fieldId);
            case 6:
                return q((MutableLiveData) object, fieldId);
            case 7:
                return t((MutableLiveData) object, fieldId);
            case 8:
                return n((MutableLiveData) object, fieldId);
            case 9:
                return u((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<Boolean> VmIsActivityRunLiveD, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11645a |= 1;
        }
        return true;
    }

    public final boolean q(MutableLiveData<SpannableStringBuilder> VmMoodQuestionSpan, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11645a |= 64;
        }
        return true;
    }

    public final boolean r(MutableLiveData<String> VmMoodRewardText, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11645a |= 8;
        }
        return true;
    }

    public final boolean s(MutableLiveData<Boolean> VmMoodSubmitHighlight, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11645a |= 4;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f11646a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 == variableId) {
            m((SunshineRunSuccessVM) variable);
        } else {
            if (lk0.k != variableId) {
                return false;
            }
            l((SunshineRunSuccessActivity.a) variable);
        }
        return true;
    }

    public final boolean t(MutableLiveData<Boolean> VmMoodSurveyVisible, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11645a |= 128;
        }
        return true;
    }

    public final boolean u(MutableLiveData<Long> VmMyAvgSpeed, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11645a |= 512;
        }
        return true;
    }

    public final boolean v(MutableLiveData<FinishRunResult> VmResultLiveData, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11645a |= 2;
        }
        return true;
    }

    public final boolean w(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11645a |= 32;
        }
        return true;
    }

    public RunActivitySunshineRunSuccessBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 10, (Barrier) bindings[27], (Barrier) bindings[28], (FrameLayout) bindings[32], (FrameLayout) bindings[33], (ImageView) bindings[5], (ImageView) bindings[26], (ImageView) bindings[18], (ImageView) bindings[20], (ImageView) bindings[25], (BLLinearLayout) bindings[6], (LinearLayout) bindings[9], (ConstraintLayout) bindings[17], (RecyclerView) bindings[16], (TextView) bindings[3], (TextView) bindings[29], (TextView) bindings[2], (TextView) bindings[31], (TextView) bindings[30], (TextView) bindings[21], (TextView) bindings[19], (TextView) bindings[15], (TextView) bindings[4]);
        this.f11645a = -1L;
        ((RunActivitySunshineRunSuccessBinding) this).f11629a.setTag(null);
        ((RunActivitySunshineRunSuccessBinding) this).c.setTag(null);
        ((RunActivitySunshineRunSuccessBinding) this).d.setTag(null);
        ((RunActivitySunshineRunSuccessBinding) this).f11637a.setTag(null);
        ((RunActivitySunshineRunSuccessBinding) this).f11630a.setTag(null);
        BLFrameLayout bLFrameLayout = (BLFrameLayout) bindings[0];
        this.f11650a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[1];
        this.b = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) bindings[10];
        this.f = imageView;
        imageView.setTag("0");
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) bindings[24];
        this.f11646a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        ImageView imageView2 = (ImageView) bindings[11];
        this.g = imageView2;
        imageView2.setTag("1");
        ImageView imageView3 = (ImageView) bindings[12];
        this.h = imageView3;
        imageView3.setTag("2");
        ImageView imageView4 = (ImageView) bindings[13];
        this.i = imageView4;
        imageView4.setTag("3");
        BLLinearLayout bLLinearLayout = (BLLinearLayout) bindings[14];
        this.f11653b = bLLinearLayout;
        bLLinearLayout.setTag(null);
        BLFrameLayout bLFrameLayout2 = (BLFrameLayout) bindings[22];
        this.f11652b = bLFrameLayout2;
        bLFrameLayout2.setTag(null);
        BLTextView bLTextView = (BLTextView) bindings[23];
        this.f11651a = bLTextView;
        bLTextView.setTag(null);
        TextView textView = (TextView) bindings[7];
        this.j = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[8];
        this.k = textView2;
        textView2.setTag(null);
        ((RunActivitySunshineRunSuccessBinding) this).f11633a.setTag(null);
        ((RunActivitySunshineRunSuccessBinding) this).f11634a.setTag(null);
        ((RunActivitySunshineRunSuccessBinding) this).f11631a.setTag(null);
        ((RunActivitySunshineRunSuccessBinding) this).f11641c.setTag(null);
        super.f.setTag(null);
        super.g.setTag(null);
        super.h.setTag(null);
        super.i.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
