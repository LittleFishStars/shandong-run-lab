package com.huachenjie.home.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.coroutines.adapters.Converters;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.coroutines.adapters.ViewBindingAdapter;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.binding_adapter.DrawablesBindingAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.home.HomeFragment;
import com.huachenjie.home.HomeFunctionAdapter;
import com.huachenjie.home.HomeGoodsAdapter;
import com.huachenjie.home.HomeVM;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.AwardBean;
import com.huachenjie.home.bean.GoodStuffPickData;
import com.huachenjie.home.bean.HomeData;
import com.huachenjie.home.bean.HomeHeaderBean;
import com.huachenjie.home.bean.InspirationBean;
import com.huachenjie.home.bean.JackpotAwardBean;
import com.huachenjie.home.bean.PromoSlotBean;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.youth.banner.Banner;
import com.zj.adlib.jj8;
import com.zj.adlib.ku3;
import com.zj.adlib.xk0;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeFragmentMainBindingImpl extends HomeFragmentMainBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9431a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnRefreshListenerImpl f9434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f9435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f9436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f9437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f9438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f9439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f9440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f9441a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f9442b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f9443b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f9444c;

    @NonNull
    public final View d;

    @NonNull
    public final View e;

    @NonNull
    public final View f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final ImageView f9445f;

    @NonNull
    public final ImageView g;

    @NonNull
    public final ImageView h;

    @NonNull
    public final ImageView i;

    @NonNull
    public final ImageView j;

    public static class OnRefreshListenerImpl implements SwipeRefreshLayout.OnRefreshListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SwipeRefreshLayout.OnRefreshListener f34253a;

        public OnRefreshListenerImpl a(SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
            this.f34253a = onRefreshListener;
            if (onRefreshListener == null) {
                return null;
            }
            return this;
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            this.f34253a.onRefresh();
        }
    }

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeFragment.ClickProxy f34254a;

        public a a(HomeFragment.ClickProxy clickProxy) {
            this.f34254a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34254a.e(view);
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeFragment.ClickProxy f34255a;

        public b a(HomeFragment.ClickProxy clickProxy) {
            this.f34255a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34255a.g(view);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeFragment.ClickProxy f34256a;

        public c a(HomeFragment.ClickProxy clickProxy) {
            this.f34256a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34256a.i(view);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeFragment.ClickProxy f34257a;

        public d a(HomeFragment.ClickProxy clickProxy) {
            this.f34257a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34257a.j(view);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeFragment.ClickProxy f34258a;

        public e a(HomeFragment.ClickProxy clickProxy) {
            this.f34258a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34258a.b(view);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HomeFragment.ClickProxy f34259a;

        public f a(HomeFragment.ClickProxy clickProxy) {
            this.f34259a = clickProxy;
            if (clickProxy == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f34259a.h(view);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34252a = sparseIntArray;
        sparseIntArray.put(R.id.v_bg_header, 28);
        sparseIntArray.put(R.id.iv_shandong, 29);
        sparseIntArray.put(R.id.vp_search, 30);
        sparseIntArray.put(R.id.coordinatorLayout, 31);
        sparseIntArray.put(R.id.app_bar, 32);
        sparseIntArray.put(R.id.toolbar, 33);
        sparseIntArray.put(R.id.iv_flash_coins, 34);
        sparseIntArray.put(R.id.home_ic_flash_coins_small, 35);
        sparseIntArray.put(R.id.v_right_center_line, 36);
        sparseIntArray.put(R.id.vs_buddy_plaza, 37);
    }

    public HomeFragmentMainBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 38, f9431a, f34252a));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:107:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:108:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:110:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:111:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:113:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:114:0x0200  */
    /* JADX WARN: Code duplicated, block: B:116:0x0203  */
    /* JADX WARN: Code duplicated, block: B:117:0x0205  */
    /* JADX WARN: Code duplicated, block: B:121:0x0210 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:122:0x0212  */
    /* JADX WARN: Code duplicated, block: B:123:0x021f  */
    /* JADX WARN: Code duplicated, block: B:126:0x022b  */
    /* JADX WARN: Code duplicated, block: B:127:0x0232  */
    /* JADX WARN: Code duplicated, block: B:130:0x0239 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x023b  */
    /* JADX WARN: Code duplicated, block: B:132:0x023f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0247  */
    /* JADX WARN: Code duplicated, block: B:137:0x024e  */
    /* JADX WARN: Code duplicated, block: B:141:0x025e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:142:0x0260  */
    /* JADX WARN: Code duplicated, block: B:143:0x0265  */
    /* JADX WARN: Code duplicated, block: B:146:0x026e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x0270  */
    /* JADX WARN: Code duplicated, block: B:148:0x027e  */
    /* JADX WARN: Code duplicated, block: B:151:0x0289  */
    /* JADX WARN: Code duplicated, block: B:152:0x0290  */
    /* JADX WARN: Code duplicated, block: B:154:0x0296  */
    /* JADX WARN: Code duplicated, block: B:157:0x02a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:158:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:159:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:162:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:163:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:165:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:169:0x02dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:170:0x02de  */
    /* JADX WARN: Code duplicated, block: B:171:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:174:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:175:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:177:0x031e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0050  */
    /* JADX WARN: Code duplicated, block: B:70:0x015f  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean z;
        String str;
        boolean z2;
        boolean zShowBadge;
        boolean z3;
        boolean z4;
        String str2;
        int iFindTitleImageRes;
        String str3;
        String imgUrl;
        int i;
        boolean z5;
        HomeGoodsAdapter homeGoodsAdapter;
        boolean z6;
        HomeFunctionAdapter value;
        WorksAdapter value2;
        boolean z7;
        boolean zSafeUnbox;
        int iA;
        int i2;
        int iSafeUnbox;
        int iSafeUnbox2;
        String str4;
        String imgUrl2;
        boolean hasSeaview;
        boolean z8;
        int iFindButtonImageRes;
        String strFindSeaViewUrl;
        OnRefreshListenerImpl onRefreshListenerImplA;
        d dVar;
        e eVarA;
        b bVar;
        f fVar;
        a aVar;
        c cVar;
        RequestOptions requestOptions;
        RequestOptions requestOptions2;
        boolean z9;
        HomeGoodsAdapter value3;
        boolean zSafeUnbox2;
        String str5;
        boolean zShowAward;
        String imgUrl3;
        boolean zShowAward2;
        String strFindBadge;
        int iFindSeaViewBgColor;
        boolean z10;
        long j2;
        int iSafeUnbox3;
        MutableLiveData<Integer> mutableLiveDataS;
        Integer value4;
        BaseViewModel.b bVarE;
        MutableLiveData<Integer> mutableLiveDataC;
        Integer value5;
        MutableLiveData<Integer> mutableLiveDataB;
        int i3;
        Integer value6;
        MediatorLiveData<Boolean> mediatorLiveDataI;
        Boolean value7;
        long j3;
        MutableLiveData<GoodStuffPickData> mutableLiveDataG;
        GoodStuffPickData value8;
        List<PromoSlotBean> promoSlots;
        int size;
        List<HomeHeaderBean> functionEntries;
        boolean zShowAward3;
        InspirationBean inspiration;
        AwardBean awardBeanFindAwardBean;
        AwardBean awardBeanFindAwardBean2;
        AwardBean awardBeanFindAwardBean3;
        float convertedAmount;
        int total;
        String strFindAmount;
        synchronized (this) {
            j = this.f9432a;
            this.f9432a = 0L;
        }
        HomeVM homeVM = ((HomeFragmentMainBinding) this).f9421a;
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = ((HomeFragmentMainBinding) this).f9417a;
        HomeFragment.ClickProxy clickProxy = ((HomeFragmentMainBinding) this).f9420a;
        long j4 = j & 18464;
        RequestOptions requestOptions3 = j4 != 0 ? ku3.f42909a : null;
        if ((20479 & j) != 0) {
            if ((j & 18433) == 0) {
                value3 = null;
            } else {
                MutableLiveData<HomeGoodsAdapter> mutableLiveDataA = homeVM != null ? homeVM.A() : null;
                updateLiveDataRegistration(0, mutableLiveDataA);
                if (mutableLiveDataA != null) {
                    value3 = mutableLiveDataA.getValue();
                } else {
                    value3 = null;
                }
            }
            if ((j & 18436) != 0) {
                MutableLiveData<Boolean> mutableLiveDataJ = homeVM != null ? homeVM.J() : null;
                updateLiveDataRegistration(2, mutableLiveDataJ);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(mutableLiveDataJ != null ? mutableLiveDataJ.getValue() : null);
            } else {
                zSafeUnbox2 = false;
            }
            if ((j & 18440) != 0) {
                MutableLiveData<JackpotAwardBean> mutableLiveDataE = homeVM != null ? homeVM.E() : null;
                updateLiveDataRegistration(3, mutableLiveDataE);
                JackpotAwardBean value9 = mutableLiveDataE != null ? mutableLiveDataE.getValue() : null;
                if (value9 != null) {
                    inspiration = value9.getInspiration();
                    awardBeanFindAwardBean = value9.findAwardBean(2);
                    zShowAward = value9.showAward(2);
                    awardBeanFindAwardBean2 = value9.findAwardBean(0);
                    zShowAward2 = value9.showAward(0);
                    iFindTitleImageRes = value9.findTitleImageRes();
                    zShowBadge = value9.showBadge();
                    iFindButtonImageRes = value9.findButtonImageRes();
                    awardBeanFindAwardBean3 = value9.findAwardBean(1);
                    strFindBadge = value9.findBadge();
                    zShowAward3 = value9.showAward(1);
                } else {
                    zShowAward3 = false;
                    zShowAward = false;
                    zShowAward2 = false;
                    iFindTitleImageRes = 0;
                    zShowBadge = false;
                    iFindButtonImageRes = 0;
                    inspiration = null;
                    awardBeanFindAwardBean = null;
                    awardBeanFindAwardBean2 = null;
                    awardBeanFindAwardBean3 = null;
                    strFindBadge = null;
                }
                if (inspiration != null) {
                    convertedAmount = inspiration.getConvertedAmount();
                    strFindAmount = inspiration.findAmount();
                    total = inspiration.getTotal();
                } else {
                    convertedAmount = 0.0f;
                    total = 0;
                    strFindAmount = null;
                }
                imgUrl2 = awardBeanFindAwardBean != null ? awardBeanFindAwardBean.getImgUrl() : null;
                imgUrl3 = awardBeanFindAwardBean2 != null ? awardBeanFindAwardBean2.getImgUrl() : null;
                imgUrl = awardBeanFindAwardBean3 != null ? awardBeanFindAwardBean3.getImgUrl() : null;
                z4 = zShowAward3;
                z = convertedAmount > -1.0f;
                str = String.format("≈ %s元", strFindAmount);
                str5 = "" + total;
            } else {
                str = null;
                str5 = null;
                zShowAward = false;
                imgUrl2 = null;
                imgUrl3 = null;
                zShowAward2 = false;
                iFindTitleImageRes = 0;
                zShowBadge = false;
                iFindButtonImageRes = 0;
                imgUrl = null;
                strFindBadge = null;
                z = false;
                z4 = false;
            }
            if ((j & 18448) == 0) {
                value2 = null;
            } else {
                MutableLiveData<WorksAdapter> mutableLiveDataR = homeVM != null ? homeVM.r() : null;
                updateLiveDataRegistration(4, mutableLiveDataR);
                if (mutableLiveDataR != null) {
                    value2 = mutableLiveDataR.getValue();
                } else {
                    value2 = null;
                }
            }
            if (j4 != 0) {
                MediatorLiveData<HomeData> mediatorLiveDataC = homeVM != null ? homeVM.C() : null;
                updateLiveDataRegistration(5, mediatorLiveDataC);
                HomeData value10 = mediatorLiveDataC != null ? mediatorLiveDataC.getValue() : null;
                if (value10 != null) {
                    functionEntries = value10.getFunctionEntries();
                    hasSeaview = value10.getHasSeaview();
                    strFindSeaViewUrl = value10.findSeaViewUrl();
                    iFindSeaViewBgColor = value10.findSeaViewBgColor();
                } else {
                    iFindSeaViewBgColor = 0;
                    functionEntries = null;
                    hasSeaview = false;
                    strFindSeaViewUrl = null;
                }
                z10 = !hasSeaview;
                z8 = (functionEntries != null ? functionEntries.size() : 0) > 0;
            } else {
                iFindSeaViewBgColor = 0;
                z8 = false;
                hasSeaview = false;
                strFindSeaViewUrl = null;
                z10 = false;
            }
            if ((j & 18496) != 0) {
                MutableLiveData<HomeFunctionAdapter> mutableLiveDataB2 = homeVM != null ? homeVM.B() : null;
                updateLiveDataRegistration(6, mutableLiveDataB2);
                value = mutableLiveDataB2 != null ? mutableLiveDataB2.getValue() : null;
                if ((j & 18560) != 0) {
                    if (homeVM != null) {
                        mutableLiveDataG = homeVM.G();
                    } else {
                        mutableLiveDataG = null;
                    }
                    updateLiveDataRegistration(7, mutableLiveDataG);
                    if (mutableLiveDataG != null) {
                        value8 = mutableLiveDataG.getValue();
                    } else {
                        value8 = null;
                    }
                    if (value8 != null) {
                        promoSlots = value8.getPromoSlots();
                    } else {
                        promoSlots = null;
                    }
                    if (promoSlots != null) {
                        size = promoSlots.size();
                    } else {
                        size = 0;
                    }
                    z6 = size > 0;
                    j2 = j & 18688;
                    if (j2 != 0) {
                        if (homeVM != null) {
                            mediatorLiveDataI = homeVM.I();
                        } else {
                            mediatorLiveDataI = null;
                        }
                        updateLiveDataRegistration(8, mediatorLiveDataI);
                        if (mediatorLiveDataI != null) {
                            value7 = mediatorLiveDataI.getValue();
                        } else {
                            value7 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(value7);
                        if (j2 != 0) {
                            if (zSafeUnbox) {
                                j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                            } else {
                                j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                            }
                            j |= j3;
                        }
                        if (zSafeUnbox) {
                            iA = jj8.a(16.0f);
                        }
                        if ((j & 19458) != 0) {
                            if (homeVM != null) {
                                bVarE = homeVM.e();
                            } else {
                                bVarE = null;
                            }
                            if ((j & 18434) != 0) {
                                if (bVarE != null) {
                                    i3 = 1;
                                    mutableLiveDataB = bVarE.b();
                                } else {
                                    mutableLiveDataB = null;
                                    i3 = 1;
                                }
                                updateLiveDataRegistration(i3, mutableLiveDataB);
                                if (mutableLiveDataB != null) {
                                    value6 = mutableLiveDataB.getValue();
                                } else {
                                    value6 = null;
                                }
                                iSafeUnbox = ViewDataBinding.safeUnbox(value6);
                            } else {
                                zSafeUnbox = zSafeUnbox;
                                iA = iA;
                                iSafeUnbox = 0;
                            }
                            if ((j & 19456) != 0) {
                                if (bVarE != null) {
                                    mutableLiveDataC = bVarE.c();
                                } else {
                                    mutableLiveDataC = null;
                                }
                                updateLiveDataRegistration(10, mutableLiveDataC);
                                if (mutableLiveDataC != null) {
                                    value5 = mutableLiveDataC.getValue();
                                } else {
                                    value5 = null;
                                }
                                iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(value5) + jj8.a(44.0f)));
                            }
                            if ((j & 18944) != 0) {
                                if (homeVM != null) {
                                    mutableLiveDataS = homeVM.s();
                                } else {
                                    mutableLiveDataS = null;
                                }
                                updateLiveDataRegistration(9, mutableLiveDataS);
                                if (mutableLiveDataS != null) {
                                    value4 = mutableLiveDataS.getValue();
                                } else {
                                    value4 = null;
                                }
                                iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                            } else {
                                iSafeUnbox2 = 0;
                            }
                            i = iSafeUnbox3;
                            z2 = zShowAward2;
                            homeGoodsAdapter = value3;
                            i2 = iFindSeaViewBgColor;
                            z3 = zShowAward;
                            str2 = imgUrl3;
                            z5 = zSafeUnbox2;
                            str3 = strFindBadge;
                            z7 = z10;
                            str4 = str5;
                        } else {
                            zSafeUnbox = zSafeUnbox;
                            iA = iA;
                            iSafeUnbox = 0;
                        }
                        iSafeUnbox3 = 0;
                        if ((j & 18944) != 0) {
                            if (homeVM != null) {
                                mutableLiveDataS = homeVM.s();
                            } else {
                                mutableLiveDataS = null;
                            }
                            updateLiveDataRegistration(9, mutableLiveDataS);
                            if (mutableLiveDataS != null) {
                                value4 = mutableLiveDataS.getValue();
                            } else {
                                value4 = null;
                            }
                            iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                        } else {
                            iSafeUnbox2 = 0;
                        }
                        i = iSafeUnbox3;
                        z2 = zShowAward2;
                        homeGoodsAdapter = value3;
                        i2 = iFindSeaViewBgColor;
                        z3 = zShowAward;
                        str2 = imgUrl3;
                        z5 = zSafeUnbox2;
                        str3 = strFindBadge;
                        z7 = z10;
                        str4 = str5;
                    } else {
                        z6 = z6;
                        str5 = str5;
                        zSafeUnbox = false;
                    }
                    iA = 0;
                    if ((j & 19458) != 0) {
                        if (homeVM != null) {
                            bVarE = homeVM.e();
                        } else {
                            bVarE = null;
                        }
                        if ((j & 18434) != 0) {
                            if (bVarE != null) {
                                i3 = 1;
                                mutableLiveDataB = bVarE.b();
                            } else {
                                mutableLiveDataB = null;
                                i3 = 1;
                            }
                            updateLiveDataRegistration(i3, mutableLiveDataB);
                            if (mutableLiveDataB != null) {
                                value6 = mutableLiveDataB.getValue();
                            } else {
                                value6 = null;
                            }
                            iSafeUnbox = ViewDataBinding.safeUnbox(value6);
                        } else {
                            zSafeUnbox = zSafeUnbox;
                            iA = iA;
                            iSafeUnbox = 0;
                        }
                        if ((j & 19456) != 0) {
                            if (bVarE != null) {
                                mutableLiveDataC = bVarE.c();
                            } else {
                                mutableLiveDataC = null;
                            }
                            updateLiveDataRegistration(10, mutableLiveDataC);
                            if (mutableLiveDataC != null) {
                                value5 = mutableLiveDataC.getValue();
                            } else {
                                value5 = null;
                            }
                            iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(value5) + jj8.a(44.0f)));
                        }
                        if ((j & 18944) != 0) {
                            if (homeVM != null) {
                                mutableLiveDataS = homeVM.s();
                            } else {
                                mutableLiveDataS = null;
                            }
                            updateLiveDataRegistration(9, mutableLiveDataS);
                            if (mutableLiveDataS != null) {
                                value4 = mutableLiveDataS.getValue();
                            } else {
                                value4 = null;
                            }
                            iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                        } else {
                            iSafeUnbox2 = 0;
                        }
                        i = iSafeUnbox3;
                        z2 = zShowAward2;
                        homeGoodsAdapter = value3;
                        i2 = iFindSeaViewBgColor;
                        z3 = zShowAward;
                        str2 = imgUrl3;
                        z5 = zSafeUnbox2;
                        str3 = strFindBadge;
                        z7 = z10;
                        str4 = str5;
                    } else {
                        zSafeUnbox = zSafeUnbox;
                        iA = iA;
                        iSafeUnbox = 0;
                    }
                    iSafeUnbox3 = 0;
                    if ((j & 18944) != 0) {
                        if (homeVM != null) {
                            mutableLiveDataS = homeVM.s();
                        } else {
                            mutableLiveDataS = null;
                        }
                        updateLiveDataRegistration(9, mutableLiveDataS);
                        if (mutableLiveDataS != null) {
                            value4 = mutableLiveDataS.getValue();
                        } else {
                            value4 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                    } else {
                        iSafeUnbox2 = 0;
                    }
                    i = iSafeUnbox3;
                    z2 = zShowAward2;
                    homeGoodsAdapter = value3;
                    i2 = iFindSeaViewBgColor;
                    z3 = zShowAward;
                    str2 = imgUrl3;
                    z5 = zSafeUnbox2;
                    str3 = strFindBadge;
                    z7 = z10;
                    str4 = str5;
                } else {
                    value = value;
                }
                j2 = j & 18688;
                if (j2 != 0) {
                    if (homeVM != null) {
                        mediatorLiveDataI = homeVM.I();
                    } else {
                        mediatorLiveDataI = null;
                    }
                    updateLiveDataRegistration(8, mediatorLiveDataI);
                    if (mediatorLiveDataI != null) {
                        value7 = mediatorLiveDataI.getValue();
                    } else {
                        value7 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(value7);
                    if (j2 != 0) {
                        if (zSafeUnbox) {
                            j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        } else {
                            j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        }
                        j |= j3;
                    }
                    if (zSafeUnbox) {
                        iA = jj8.a(16.0f);
                    }
                    if ((j & 19458) != 0) {
                        if (homeVM != null) {
                            bVarE = homeVM.e();
                        } else {
                            bVarE = null;
                        }
                        if ((j & 18434) != 0) {
                            if (bVarE != null) {
                                i3 = 1;
                                mutableLiveDataB = bVarE.b();
                            } else {
                                mutableLiveDataB = null;
                                i3 = 1;
                            }
                            updateLiveDataRegistration(i3, mutableLiveDataB);
                            if (mutableLiveDataB != null) {
                                value6 = mutableLiveDataB.getValue();
                            } else {
                                value6 = null;
                            }
                            iSafeUnbox = ViewDataBinding.safeUnbox(value6);
                        } else {
                            zSafeUnbox = zSafeUnbox;
                            iA = iA;
                            iSafeUnbox = 0;
                        }
                        if ((j & 19456) != 0) {
                            if (bVarE != null) {
                                mutableLiveDataC = bVarE.c();
                            } else {
                                mutableLiveDataC = null;
                            }
                            updateLiveDataRegistration(10, mutableLiveDataC);
                            if (mutableLiveDataC != null) {
                                value5 = mutableLiveDataC.getValue();
                            } else {
                                value5 = null;
                            }
                            iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(value5) + jj8.a(44.0f)));
                        }
                        if ((j & 18944) != 0) {
                            if (homeVM != null) {
                                mutableLiveDataS = homeVM.s();
                            } else {
                                mutableLiveDataS = null;
                            }
                            updateLiveDataRegistration(9, mutableLiveDataS);
                            if (mutableLiveDataS != null) {
                                value4 = mutableLiveDataS.getValue();
                            } else {
                                value4 = null;
                            }
                            iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                        } else {
                            iSafeUnbox2 = 0;
                        }
                        i = iSafeUnbox3;
                        z2 = zShowAward2;
                        homeGoodsAdapter = value3;
                        i2 = iFindSeaViewBgColor;
                        z3 = zShowAward;
                        str2 = imgUrl3;
                        z5 = zSafeUnbox2;
                        str3 = strFindBadge;
                        z7 = z10;
                        str4 = str5;
                    } else {
                        zSafeUnbox = zSafeUnbox;
                        iA = iA;
                        iSafeUnbox = 0;
                    }
                    iSafeUnbox3 = 0;
                    if ((j & 18944) != 0) {
                        if (homeVM != null) {
                            mutableLiveDataS = homeVM.s();
                        } else {
                            mutableLiveDataS = null;
                        }
                        updateLiveDataRegistration(9, mutableLiveDataS);
                        if (mutableLiveDataS != null) {
                            value4 = mutableLiveDataS.getValue();
                        } else {
                            value4 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                    } else {
                        iSafeUnbox2 = 0;
                    }
                    i = iSafeUnbox3;
                    z2 = zShowAward2;
                    homeGoodsAdapter = value3;
                    i2 = iFindSeaViewBgColor;
                    z3 = zShowAward;
                    str2 = imgUrl3;
                    z5 = zSafeUnbox2;
                    str3 = strFindBadge;
                    z7 = z10;
                    str4 = str5;
                } else {
                    z6 = z6;
                    str5 = str5;
                    zSafeUnbox = false;
                }
                iA = 0;
                if ((j & 19458) != 0) {
                    if (homeVM != null) {
                        bVarE = homeVM.e();
                    } else {
                        bVarE = null;
                    }
                    if ((j & 18434) != 0) {
                        if (bVarE != null) {
                            i3 = 1;
                            mutableLiveDataB = bVarE.b();
                        } else {
                            mutableLiveDataB = null;
                            i3 = 1;
                        }
                        updateLiveDataRegistration(i3, mutableLiveDataB);
                        if (mutableLiveDataB != null) {
                            value6 = mutableLiveDataB.getValue();
                        } else {
                            value6 = null;
                        }
                        iSafeUnbox = ViewDataBinding.safeUnbox(value6);
                    } else {
                        zSafeUnbox = zSafeUnbox;
                        iA = iA;
                        iSafeUnbox = 0;
                    }
                    if ((j & 19456) != 0) {
                        if (bVarE != null) {
                            mutableLiveDataC = bVarE.c();
                        } else {
                            mutableLiveDataC = null;
                        }
                        updateLiveDataRegistration(10, mutableLiveDataC);
                        if (mutableLiveDataC != null) {
                            value5 = mutableLiveDataC.getValue();
                        } else {
                            value5 = null;
                        }
                        iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(value5) + jj8.a(44.0f)));
                    }
                    if ((j & 18944) != 0) {
                        if (homeVM != null) {
                            mutableLiveDataS = homeVM.s();
                        } else {
                            mutableLiveDataS = null;
                        }
                        updateLiveDataRegistration(9, mutableLiveDataS);
                        if (mutableLiveDataS != null) {
                            value4 = mutableLiveDataS.getValue();
                        } else {
                            value4 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                    } else {
                        iSafeUnbox2 = 0;
                    }
                    i = iSafeUnbox3;
                    z2 = zShowAward2;
                    homeGoodsAdapter = value3;
                    i2 = iFindSeaViewBgColor;
                    z3 = zShowAward;
                    str2 = imgUrl3;
                    z5 = zSafeUnbox2;
                    str3 = strFindBadge;
                    z7 = z10;
                    str4 = str5;
                } else {
                    zSafeUnbox = zSafeUnbox;
                    iA = iA;
                    iSafeUnbox = 0;
                }
                iSafeUnbox3 = 0;
                if ((j & 18944) != 0) {
                    if (homeVM != null) {
                        mutableLiveDataS = homeVM.s();
                    } else {
                        mutableLiveDataS = null;
                    }
                    updateLiveDataRegistration(9, mutableLiveDataS);
                    if (mutableLiveDataS != null) {
                        value4 = mutableLiveDataS.getValue();
                    } else {
                        value4 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                } else {
                    iSafeUnbox2 = 0;
                }
                i = iSafeUnbox3;
                z2 = zShowAward2;
                homeGoodsAdapter = value3;
                i2 = iFindSeaViewBgColor;
                z3 = zShowAward;
                str2 = imgUrl3;
                z5 = zSafeUnbox2;
                str3 = strFindBadge;
                z7 = z10;
                str4 = str5;
            } else {
                str = str;
            }
            if ((j & 18560) != 0) {
                if (homeVM != null) {
                    mutableLiveDataG = homeVM.G();
                } else {
                    mutableLiveDataG = null;
                }
                updateLiveDataRegistration(7, mutableLiveDataG);
                if (mutableLiveDataG != null) {
                    value8 = mutableLiveDataG.getValue();
                } else {
                    value8 = null;
                }
                if (value8 != null) {
                    promoSlots = value8.getPromoSlots();
                } else {
                    promoSlots = null;
                }
                if (promoSlots != null) {
                    size = promoSlots.size();
                } else {
                    size = 0;
                }
                if (size > 0) {
                }
                j2 = j & 18688;
                if (j2 != 0) {
                    if (homeVM != null) {
                        mediatorLiveDataI = homeVM.I();
                    } else {
                        mediatorLiveDataI = null;
                    }
                    updateLiveDataRegistration(8, mediatorLiveDataI);
                    if (mediatorLiveDataI != null) {
                        value7 = mediatorLiveDataI.getValue();
                    } else {
                        value7 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(value7);
                    if (j2 != 0) {
                        if (zSafeUnbox) {
                            j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                        } else {
                            j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                        }
                        j |= j3;
                    }
                    if (zSafeUnbox) {
                        iA = jj8.a(16.0f);
                    }
                    if ((j & 19458) != 0) {
                        if (homeVM != null) {
                            bVarE = homeVM.e();
                        } else {
                            bVarE = null;
                        }
                        if ((j & 18434) != 0) {
                            if (bVarE != null) {
                                i3 = 1;
                                mutableLiveDataB = bVarE.b();
                            } else {
                                mutableLiveDataB = null;
                                i3 = 1;
                            }
                            updateLiveDataRegistration(i3, mutableLiveDataB);
                            if (mutableLiveDataB != null) {
                                value6 = mutableLiveDataB.getValue();
                            } else {
                                value6 = null;
                            }
                            iSafeUnbox = ViewDataBinding.safeUnbox(value6);
                        } else {
                            zSafeUnbox = zSafeUnbox;
                            iA = iA;
                            iSafeUnbox = 0;
                        }
                        if ((j & 19456) != 0) {
                            if (bVarE != null) {
                                mutableLiveDataC = bVarE.c();
                            } else {
                                mutableLiveDataC = null;
                            }
                            updateLiveDataRegistration(10, mutableLiveDataC);
                            if (mutableLiveDataC != null) {
                                value5 = mutableLiveDataC.getValue();
                            } else {
                                value5 = null;
                            }
                            iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(value5) + jj8.a(44.0f)));
                        }
                        if ((j & 18944) != 0) {
                            if (homeVM != null) {
                                mutableLiveDataS = homeVM.s();
                            } else {
                                mutableLiveDataS = null;
                            }
                            updateLiveDataRegistration(9, mutableLiveDataS);
                            if (mutableLiveDataS != null) {
                                value4 = mutableLiveDataS.getValue();
                            } else {
                                value4 = null;
                            }
                            iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                        } else {
                            iSafeUnbox2 = 0;
                        }
                        i = iSafeUnbox3;
                        z2 = zShowAward2;
                        homeGoodsAdapter = value3;
                        i2 = iFindSeaViewBgColor;
                        z3 = zShowAward;
                        str2 = imgUrl3;
                        z5 = zSafeUnbox2;
                        str3 = strFindBadge;
                        z7 = z10;
                        str4 = str5;
                    } else {
                        zSafeUnbox = zSafeUnbox;
                        iA = iA;
                        iSafeUnbox = 0;
                    }
                    iSafeUnbox3 = 0;
                    if ((j & 18944) != 0) {
                        if (homeVM != null) {
                            mutableLiveDataS = homeVM.s();
                        } else {
                            mutableLiveDataS = null;
                        }
                        updateLiveDataRegistration(9, mutableLiveDataS);
                        if (mutableLiveDataS != null) {
                            value4 = mutableLiveDataS.getValue();
                        } else {
                            value4 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                    } else {
                        iSafeUnbox2 = 0;
                    }
                    i = iSafeUnbox3;
                    z2 = zShowAward2;
                    homeGoodsAdapter = value3;
                    i2 = iFindSeaViewBgColor;
                    z3 = zShowAward;
                    str2 = imgUrl3;
                    z5 = zSafeUnbox2;
                    str3 = strFindBadge;
                    z7 = z10;
                    str4 = str5;
                } else {
                    z6 = z6;
                    str5 = str5;
                    zSafeUnbox = false;
                }
                iA = 0;
                if ((j & 19458) != 0) {
                    if (homeVM != null) {
                        bVarE = homeVM.e();
                    } else {
                        bVarE = null;
                    }
                    if ((j & 18434) != 0) {
                        if (bVarE != null) {
                            i3 = 1;
                            mutableLiveDataB = bVarE.b();
                        } else {
                            mutableLiveDataB = null;
                            i3 = 1;
                        }
                        updateLiveDataRegistration(i3, mutableLiveDataB);
                        if (mutableLiveDataB != null) {
                            value6 = mutableLiveDataB.getValue();
                        } else {
                            value6 = null;
                        }
                        iSafeUnbox = ViewDataBinding.safeUnbox(value6);
                    } else {
                        zSafeUnbox = zSafeUnbox;
                        iA = iA;
                        iSafeUnbox = 0;
                    }
                    if ((j & 19456) != 0) {
                        if (bVarE != null) {
                            mutableLiveDataC = bVarE.c();
                        } else {
                            mutableLiveDataC = null;
                        }
                        updateLiveDataRegistration(10, mutableLiveDataC);
                        if (mutableLiveDataC != null) {
                            value5 = mutableLiveDataC.getValue();
                        } else {
                            value5 = null;
                        }
                        iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(value5) + jj8.a(44.0f)));
                    }
                    if ((j & 18944) != 0) {
                        if (homeVM != null) {
                            mutableLiveDataS = homeVM.s();
                        } else {
                            mutableLiveDataS = null;
                        }
                        updateLiveDataRegistration(9, mutableLiveDataS);
                        if (mutableLiveDataS != null) {
                            value4 = mutableLiveDataS.getValue();
                        } else {
                            value4 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                    } else {
                        iSafeUnbox2 = 0;
                    }
                    i = iSafeUnbox3;
                    z2 = zShowAward2;
                    homeGoodsAdapter = value3;
                    i2 = iFindSeaViewBgColor;
                    z3 = zShowAward;
                    str2 = imgUrl3;
                    z5 = zSafeUnbox2;
                    str3 = strFindBadge;
                    z7 = z10;
                    str4 = str5;
                } else {
                    zSafeUnbox = zSafeUnbox;
                    iA = iA;
                    iSafeUnbox = 0;
                }
                iSafeUnbox3 = 0;
                if ((j & 18944) != 0) {
                    if (homeVM != null) {
                        mutableLiveDataS = homeVM.s();
                    } else {
                        mutableLiveDataS = null;
                    }
                    updateLiveDataRegistration(9, mutableLiveDataS);
                    if (mutableLiveDataS != null) {
                        value4 = mutableLiveDataS.getValue();
                    } else {
                        value4 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                } else {
                    iSafeUnbox2 = 0;
                }
                i = iSafeUnbox3;
                z2 = zShowAward2;
                homeGoodsAdapter = value3;
                i2 = iFindSeaViewBgColor;
                z3 = zShowAward;
                str2 = imgUrl3;
                z5 = zSafeUnbox2;
                str3 = strFindBadge;
                z7 = z10;
                str4 = str5;
            } else {
                value = value;
            }
            j2 = j & 18688;
            if (j2 != 0) {
                if (homeVM != null) {
                    mediatorLiveDataI = homeVM.I();
                } else {
                    mediatorLiveDataI = null;
                }
                updateLiveDataRegistration(8, mediatorLiveDataI);
                if (mediatorLiveDataI != null) {
                    value7 = mediatorLiveDataI.getValue();
                } else {
                    value7 = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(value7);
                if (j2 != 0) {
                    if (zSafeUnbox) {
                        j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    } else {
                        j3 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    }
                    j |= j3;
                }
                if (zSafeUnbox) {
                    iA = jj8.a(16.0f);
                }
                if ((j & 19458) != 0) {
                    if (homeVM != null) {
                        bVarE = homeVM.e();
                    } else {
                        bVarE = null;
                    }
                    if ((j & 18434) != 0) {
                        if (bVarE != null) {
                            i3 = 1;
                            mutableLiveDataB = bVarE.b();
                        } else {
                            mutableLiveDataB = null;
                            i3 = 1;
                        }
                        updateLiveDataRegistration(i3, mutableLiveDataB);
                        if (mutableLiveDataB != null) {
                            value6 = mutableLiveDataB.getValue();
                        } else {
                            value6 = null;
                        }
                        iSafeUnbox = ViewDataBinding.safeUnbox(value6);
                    } else {
                        zSafeUnbox = zSafeUnbox;
                        iA = iA;
                        iSafeUnbox = 0;
                    }
                    if ((j & 19456) != 0) {
                        if (bVarE != null) {
                            mutableLiveDataC = bVarE.c();
                        } else {
                            mutableLiveDataC = null;
                        }
                        updateLiveDataRegistration(10, mutableLiveDataC);
                        if (mutableLiveDataC != null) {
                            value5 = mutableLiveDataC.getValue();
                        } else {
                            value5 = null;
                        }
                        iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(value5) + jj8.a(44.0f)));
                    }
                    if ((j & 18944) != 0) {
                        if (homeVM != null) {
                            mutableLiveDataS = homeVM.s();
                        } else {
                            mutableLiveDataS = null;
                        }
                        updateLiveDataRegistration(9, mutableLiveDataS);
                        if (mutableLiveDataS != null) {
                            value4 = mutableLiveDataS.getValue();
                        } else {
                            value4 = null;
                        }
                        iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                    } else {
                        iSafeUnbox2 = 0;
                    }
                    i = iSafeUnbox3;
                    z2 = zShowAward2;
                    homeGoodsAdapter = value3;
                    i2 = iFindSeaViewBgColor;
                    z3 = zShowAward;
                    str2 = imgUrl3;
                    z5 = zSafeUnbox2;
                    str3 = strFindBadge;
                    z7 = z10;
                    str4 = str5;
                } else {
                    zSafeUnbox = zSafeUnbox;
                    iA = iA;
                    iSafeUnbox = 0;
                }
                iSafeUnbox3 = 0;
                if ((j & 18944) != 0) {
                    if (homeVM != null) {
                        mutableLiveDataS = homeVM.s();
                    } else {
                        mutableLiveDataS = null;
                    }
                    updateLiveDataRegistration(9, mutableLiveDataS);
                    if (mutableLiveDataS != null) {
                        value4 = mutableLiveDataS.getValue();
                    } else {
                        value4 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                } else {
                    iSafeUnbox2 = 0;
                }
                i = iSafeUnbox3;
                z2 = zShowAward2;
                homeGoodsAdapter = value3;
                i2 = iFindSeaViewBgColor;
                z3 = zShowAward;
                str2 = imgUrl3;
                z5 = zSafeUnbox2;
                str3 = strFindBadge;
                z7 = z10;
                str4 = str5;
            } else {
                z6 = z6;
                str5 = str5;
                zSafeUnbox = false;
            }
            iA = 0;
            if ((j & 19458) != 0) {
                if (homeVM != null) {
                    bVarE = homeVM.e();
                } else {
                    bVarE = null;
                }
                if ((j & 18434) != 0) {
                    if (bVarE != null) {
                        i3 = 1;
                        mutableLiveDataB = bVarE.b();
                    } else {
                        mutableLiveDataB = null;
                        i3 = 1;
                    }
                    updateLiveDataRegistration(i3, mutableLiveDataB);
                    if (mutableLiveDataB != null) {
                        value6 = mutableLiveDataB.getValue();
                    } else {
                        value6 = null;
                    }
                    iSafeUnbox = ViewDataBinding.safeUnbox(value6);
                } else {
                    zSafeUnbox = zSafeUnbox;
                    iA = iA;
                    iSafeUnbox = 0;
                }
                if ((j & 19456) != 0) {
                    if (bVarE != null) {
                        mutableLiveDataC = bVarE.c();
                    } else {
                        mutableLiveDataC = null;
                    }
                    updateLiveDataRegistration(10, mutableLiveDataC);
                    if (mutableLiveDataC != null) {
                        value5 = mutableLiveDataC.getValue();
                    } else {
                        value5 = null;
                    }
                    iSafeUnbox3 = ViewDataBinding.safeUnbox(Integer.valueOf(ViewDataBinding.safeUnbox(value5) + jj8.a(44.0f)));
                }
                if ((j & 18944) != 0) {
                    if (homeVM != null) {
                        mutableLiveDataS = homeVM.s();
                    } else {
                        mutableLiveDataS = null;
                    }
                    updateLiveDataRegistration(9, mutableLiveDataS);
                    if (mutableLiveDataS != null) {
                        value4 = mutableLiveDataS.getValue();
                    } else {
                        value4 = null;
                    }
                    iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
                } else {
                    iSafeUnbox2 = 0;
                }
                i = iSafeUnbox3;
                z2 = zShowAward2;
                homeGoodsAdapter = value3;
                i2 = iFindSeaViewBgColor;
                z3 = zShowAward;
                str2 = imgUrl3;
                z5 = zSafeUnbox2;
                str3 = strFindBadge;
                z7 = z10;
                str4 = str5;
            } else {
                zSafeUnbox = zSafeUnbox;
                iA = iA;
                iSafeUnbox = 0;
            }
            iSafeUnbox3 = 0;
            if ((j & 18944) != 0) {
                if (homeVM != null) {
                    mutableLiveDataS = homeVM.s();
                } else {
                    mutableLiveDataS = null;
                }
                updateLiveDataRegistration(9, mutableLiveDataS);
                if (mutableLiveDataS != null) {
                    value4 = mutableLiveDataS.getValue();
                } else {
                    value4 = null;
                }
                iSafeUnbox2 = ViewDataBinding.safeUnbox(value4);
            } else {
                iSafeUnbox2 = 0;
            }
            i = iSafeUnbox3;
            z2 = zShowAward2;
            homeGoodsAdapter = value3;
            i2 = iFindSeaViewBgColor;
            z3 = zShowAward;
            str2 = imgUrl3;
            z5 = zSafeUnbox2;
            str3 = strFindBadge;
            z7 = z10;
            str4 = str5;
        } else {
            requestOptions3 = requestOptions3;
            z = false;
            str = null;
            z2 = false;
            zShowBadge = false;
            z3 = false;
            z4 = false;
            str2 = null;
            iFindTitleImageRes = 0;
            str3 = null;
            imgUrl = null;
            i = 0;
            z5 = false;
            homeGoodsAdapter = null;
            z6 = false;
            value = null;
            value2 = null;
            z7 = false;
            zSafeUnbox = false;
            iA = 0;
            i2 = 0;
            iSafeUnbox = 0;
            iSafeUnbox2 = 0;
            str4 = null;
            imgUrl2 = null;
            hasSeaview = false;
            z8 = false;
            iFindButtonImageRes = 0;
            strFindSeaViewUrl = null;
        }
        long j5 = j & 20480;
        if (j5 == 0 || onRefreshListener == null) {
            onRefreshListenerImplA = null;
        } else {
            OnRefreshListenerImpl onRefreshListenerImpl = this.f9434a;
            if (onRefreshListenerImpl == null) {
                onRefreshListenerImpl = new OnRefreshListenerImpl();
                this.f9434a = onRefreshListenerImpl;
            }
            onRefreshListenerImplA = onRefreshListenerImpl.a(onRefreshListener);
        }
        long j6 = j & 24576;
        if (j6 == 0 || clickProxy == null) {
            dVar = null;
            eVarA = null;
            bVar = null;
            fVar = null;
            aVar = null;
            cVar = null;
        } else {
            f fVar2 = this.f9440a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f9440a = fVar2;
            }
            f fVarA = fVar2.a(clickProxy);
            a aVar2 = this.f9435a;
            if (aVar2 == null) {
                aVar2 = new a();
                this.f9435a = aVar2;
            }
            a aVarA = aVar2.a(clickProxy);
            b bVar2 = this.f9436a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f9436a = bVar2;
            }
            b bVarA = bVar2.a(clickProxy);
            c cVar2 = this.f9437a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f9437a = cVar2;
            }
            c cVarA = cVar2.a(clickProxy);
            d dVar2 = this.f9438a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f9438a = dVar2;
            }
            d dVarA = dVar2.a(clickProxy);
            e eVar = this.f9439a;
            if (eVar == null) {
                eVar = new e();
                this.f9439a = eVar;
            }
            eVarA = eVar.a(clickProxy);
            bVar = bVarA;
            fVar = fVarA;
            aVar = aVarA;
            cVar = cVarA;
            dVar = dVarA;
        }
        long j7 = j & 18440;
        if (j7 != 0) {
            RequestOptions requestOptions4 = ku3.c;
            requestOptions2 = ku3.b;
            requestOptions = requestOptions4;
        } else {
            requestOptions = null;
            requestOptions2 = null;
        }
        if ((j & 19456) != 0) {
            CommonBindingAdapter.G(((HomeFragmentMainBinding) this).f9410a, i);
        }
        if (j6 != 0) {
            CommonBindingAdapter.q(((HomeFragmentMainBinding) this).f9411a, eVarA, null);
            CommonBindingAdapter.q(((HomeFragmentMainBinding) this).f9412a, bVar, null);
            CommonBindingAdapter.q(this.h, aVar, null);
            CommonBindingAdapter.q(this.e, cVar, null);
            CommonBindingAdapter.q(this.f, aVar, null);
            CommonBindingAdapter.q(this.j, fVar, null);
            CommonBindingAdapter.q(((HomeFragmentMainBinding) this).f9422a, cVar, null);
            CommonBindingAdapter.q(((HomeFragmentMainBinding) this).f9423a, cVar, null);
            CommonBindingAdapter.q(((HomeFragmentMainBinding) this).c, dVar, null);
        }
        if (j7 != 0) {
            CommonBindingAdapter.i(((HomeFragmentMainBinding) this).f9425b, z4);
            CommonBindingAdapter.b0(((HomeFragmentMainBinding) this).f9425b, imgUrl, requestOptions, false);
            CommonBindingAdapter.i(super.d, z2);
            RequestOptions requestOptions5 = requestOptions2;
            CommonBindingAdapter.b0(super.d, str2, requestOptions5, false);
            CommonBindingAdapter.l0(this.f9444c, z);
            TextViewBindingAdapter.setText(this.f9444c, str);
            CommonBindingAdapter.l0(this.f9442b, zShowBadge);
            TextViewBindingAdapter.setText(this.f9442b, str3);
            DrawablesBindingAdapter.e(this.f9445f, iFindTitleImageRes);
            CommonBindingAdapter.i(this.g, z3);
            CommonBindingAdapter.b0(this.g, imgUrl2, requestOptions5, false);
            DrawablesBindingAdapter.e(this.h, iFindButtonImageRes);
            TextViewBindingAdapter.setText(((HomeFragmentMainBinding) this).f9427b, str4);
        }
        if ((j & 18944) != 0 && ViewDataBinding.getBuildSdkInt() >= 11) {
            this.f9433a.setTranslationY(iSafeUnbox2);
        }
        if ((j & 18688) != 0) {
            CommonBindingAdapter.G(this.d, iA);
            CommonBindingAdapter.l0(((HomeFragmentMainBinding) this).c, zSafeUnbox);
        }
        if ((j & 18464) != 0) {
            CommonBindingAdapter.l0(this.f9441a, z8);
            CommonBindingAdapter.l0(this.f9443b, z7);
            CommonBindingAdapter.l0(this.i, hasSeaview);
            ViewBindingAdapter.setBackground(this.i, Converters.convertColorToDrawable(i2));
            CommonBindingAdapter.b0(this.i, strFindSeaViewUrl, requestOptions3, false);
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE) != 0) {
            CommonBindingAdapter.I(this.f9441a, 16, 0, 16, 12, null);
        }
        if ((j & 18434) != 0) {
            CommonBindingAdapter.I(this.c, 0, iSafeUnbox, 0, 0, null);
        }
        if ((j & 18448) != 0) {
            z9 = false;
            CommonBindingAdapter.g(((HomeFragmentMainBinding) this).f9416a, value2, false, false);
        } else {
            z9 = false;
        }
        if ((j & 18496) != 0) {
            CommonBindingAdapter.g(((HomeFragmentMainBinding) this).f9428b, value, z9, z9);
        }
        if ((j & 18560) != 0) {
            CommonBindingAdapter.l0(((HomeFragmentMainBinding) this).f9430c, z6);
        }
        if ((j & 18433) != 0) {
            CommonBindingAdapter.g(((HomeFragmentMainBinding) this).f9430c, homeGoodsAdapter, false, false);
        }
        if (j5 != 0) {
            ((HomeFragmentMainBinding) this).f9418a.setOnRefreshListener(onRefreshListenerImplA);
        }
        if ((j & 18436) != 0) {
            ((HomeFragmentMainBinding) this).f9418a.setRefreshing(z5);
        }
        if (((HomeFragmentMainBinding) this).f9415a.getBinding() != null) {
            ViewDataBinding.executeBindingsOn(((HomeFragmentMainBinding) this).f9415a.getBinding());
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9432a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9432a = PlaybackStateCompat.ACTION_PREPARE;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeFragmentMainBinding
    public void m(@Nullable HomeFragment.ClickProxy clickProxy) {
        ((HomeFragmentMainBinding) this).f9420a = clickProxy;
        synchronized (this) {
            this.f9432a |= 8192;
        }
        notifyPropertyChanged(xk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeFragmentMainBinding
    public void n(@Nullable HomeVM homeVM) {
        ((HomeFragmentMainBinding) this).f9421a = homeVM;
        synchronized (this) {
            this.f9432a |= 2048;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<WorksAdapter> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return q((MutableLiveData) obj, i2);
            case 1:
                return x((MutableLiveData) obj, i2);
            case 2:
                return t((MutableLiveData) obj, i2);
            case 3:
                return u((MutableLiveData) obj, i2);
            case 4:
                return o((MutableLiveData) obj, i2);
            case 5:
                return s((MediatorLiveData) obj, i2);
            case 6:
                return r((MutableLiveData) obj, i2);
            case 7:
                return v((MutableLiveData) obj, i2);
            case 8:
                return w((MediatorLiveData) obj, i2);
            case 9:
                return p((MutableLiveData) obj, i2);
            case 10:
                return y((MutableLiveData) obj, i2);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 512;
        }
        return true;
    }

    public final boolean q(MutableLiveData<HomeGoodsAdapter> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 1;
        }
        return true;
    }

    public final boolean r(MutableLiveData<HomeFunctionAdapter> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 64;
        }
        return true;
    }

    public final boolean s(MediatorLiveData<HomeData> mediatorLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 32;
        }
        return true;
    }

    @Override // com.huachenjie.home.databinding.HomeFragmentMainBinding
    public void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener) {
        ((HomeFragmentMainBinding) this).f9417a = onRefreshListener;
        synchronized (this) {
            this.f9432a |= 4096;
        }
        notifyPropertyChanged(xk0.R);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 == i) {
            n((HomeVM) obj);
        } else if (xk0.R == i) {
            setRefresh((SwipeRefreshLayout.OnRefreshListener) obj);
        } else {
            if (xk0.k != i) {
                return false;
            }
            m((HomeFragment.ClickProxy) obj);
        }
        return true;
    }

    public final boolean t(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 4;
        }
        return true;
    }

    public final boolean u(MutableLiveData<JackpotAwardBean> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 8;
        }
        return true;
    }

    public final boolean v(MutableLiveData<GoodStuffPickData> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 128;
        }
        return true;
    }

    public final boolean w(MediatorLiveData<Boolean> mediatorLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 256;
        }
        return true;
    }

    public final boolean x(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 2;
        }
        return true;
    }

    public final boolean y(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9432a |= 1024;
        }
        return true;
    }

    public HomeFragmentMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 11, (AppBarLayout) objArr[32], (CoordinatorLayout) objArr[31], (FrameLayout) objArr[4], (TextView) objArr[35], (ImageView) objArr[27], (ImageView) objArr[20], (ImageView) objArr[34], (ImageView) objArr[21], (ImageView) objArr[29], (LinearLayout) objArr[6], (RecyclerView) objArr[26], (RecyclerView) objArr[12], (RecyclerView) objArr[13], (SwipeRefreshLayout) objArr[8], (LinearLayout) objArr[33], (TextView) objArr[14], (BLTextView) objArr[17], (View) objArr[28], (BLView) objArr[16], (View) objArr[36], (View) objArr[9], (Banner) objArr[30], new ViewStubProxy((ViewStub) objArr[37]));
        this.f9432a = -1L;
        ((HomeFragmentMainBinding) this).f9410a.setTag(null);
        ((HomeFragmentMainBinding) this).f9411a.setTag(null);
        ((HomeFragmentMainBinding) this).f9425b.setTag(null);
        super.d.setTag(null);
        ((HomeFragmentMainBinding) this).f9412a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[1];
        this.f9433a = constraintLayout;
        constraintLayout.setTag(null);
        View view2 = (View) objArr[10];
        this.d = view2;
        view2.setTag(null);
        BLFrameLayout bLFrameLayout = (BLFrameLayout) objArr[11];
        this.f9441a = bLFrameLayout;
        bLFrameLayout.setTag(null);
        TextView textView = (TextView) objArr[15];
        this.f9444c = textView;
        textView.setTag(null);
        BLTextView bLTextView = (BLTextView) objArr[18];
        this.f9442b = bLTextView;
        bLTextView.setTag(null);
        ImageView imageView = (ImageView) objArr[19];
        this.f9445f = imageView;
        imageView.setTag(null);
        BLView bLView = (BLView) objArr[2];
        this.f9443b = bLView;
        bLView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[22];
        this.g = imageView2;
        imageView2.setTag(null);
        ImageView imageView3 = (ImageView) objArr[23];
        this.h = imageView3;
        imageView3.setTag(null);
        View view3 = (View) objArr[24];
        this.e = view3;
        view3.setTag(null);
        View view4 = (View) objArr[25];
        this.f = view4;
        view4.setTag(null);
        ImageView imageView4 = (ImageView) objArr[3];
        this.i = imageView4;
        imageView4.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[5];
        this.c = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView5 = (ImageView) objArr[7];
        this.j = imageView5;
        imageView5.setTag(null);
        ((HomeFragmentMainBinding) this).f9416a.setTag(null);
        ((HomeFragmentMainBinding) this).f9428b.setTag(null);
        ((HomeFragmentMainBinding) this).f9430c.setTag(null);
        ((HomeFragmentMainBinding) this).f9418a.setTag(null);
        ((HomeFragmentMainBinding) this).f9427b.setTag(null);
        ((HomeFragmentMainBinding) this).f9422a.setTag(null);
        ((HomeFragmentMainBinding) this).f9423a.setTag(null);
        ((HomeFragmentMainBinding) this).c.setTag(null);
        ((HomeFragmentMainBinding) this).f9415a.setContainingBinding(this);
        setRootTag(view);
        invalidateAll();
    }
}
