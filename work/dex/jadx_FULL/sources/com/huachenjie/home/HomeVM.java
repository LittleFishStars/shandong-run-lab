package com.huachenjie.home;

import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.home.bean.AdPopupBean;
import com.huachenjie.home.bean.GoodStuffPickData;
import com.huachenjie.home.bean.HomeData;
import com.huachenjie.home.bean.JackpotAwardBean;
import com.huachenjie.home.bean.reward.HomeRewardBean;
import com.huachenjie.works.bean.BuddyTypeBean;
import com.huachenjie.works.bean.BuddyTypeScopeBean;
import com.huachenjie.works.bean.BuddyTypeScopeTypeBean;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huachenjie.works.external.bean.WorkNativeAdBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ip4;
import com.zj.adlib.r90;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bg\u0010hJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J \u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0002J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019R%\u0010\"\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00160\u00160\u001c8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u001c8\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u001c8\u0006¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!R%\u00100\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010,0,0+8\u0006¢\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b.\u0010/R\u001d\u00104\u001a\b\u0012\u0004\u0012\u0002010\u001c8\u0006¢\u0006\f\n\u0004\b2\u0010\u001f\u001a\u0004\b3\u0010!R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0006¢\u0006\f\n\u0004\b$\u0010-\u001a\u0004\b5\u0010/R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u0002070\u001c8\u0006¢\u0006\f\n\u0004\b8\u0010\u001f\u001a\u0004\b9\u0010!R#\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190;0\u001c8\u0006¢\u0006\f\n\u0004\b<\u0010\u001f\u001a\u0004\b=\u0010!R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020?0\u001c8\u0006¢\u0006\f\n\u0004\b@\u0010\u001f\u001a\u0004\bA\u0010!R\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020C0\u001c8\u0006¢\u0006\f\n\u0004\bD\u0010\u001f\u001a\u0004\bE\u0010!R\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020G0\u001c8\u0006¢\u0006\f\n\u0004\bH\u0010\u001f\u001a\u0004\bI\u0010!R\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020K0\u001c8\u0006¢\u0006\f\n\u0004\bL\u0010\u001f\u001a\u0004\bM\u0010!R#\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0;0\u001c8\u0006¢\u0006\f\n\u0004\bP\u0010\u001f\u001a\u0004\bQ\u0010!R#\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190;0\u001c8\u0006¢\u0006\f\n\u0004\bS\u0010\u001f\u001a\u0004\bT\u0010!R%\u0010X\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00160\u00160\u001c8\u0006¢\u0006\f\n\u0004\bV\u0010\u001f\u001a\u0004\bW\u0010!R%\u0010[\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00160\u00160\u001c8\u0006¢\u0006\f\n\u0004\bY\u0010\u001f\u001a\u0004\bZ\u0010!R%\u0010]\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00190\u00190\u001c8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b\\\u0010!R%\u0010_\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010,0,0\u001c8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001f\u001a\u0004\b^\u0010!R\"\u0010d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010.\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010e¨\u0006i"}, d2 = {"Lcom/huachenjie/home/HomeVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Lcom/huachenjie/home/bean/HomeData;", j.o, "Lcom/huachenjie/works/external/bean/WorkItemBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "T", "R", j.b, "Lhuachenjie/sdk/http/PageEntity;", "data", "p", "P", "Q", "O", "M", "W", "N", "V", "K", "L", "", "scopeType", "Y", "", "typeCode", "Z", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "s", "()Landroidx/lifecycle/MutableLiveData;", "bgHeaderTranslationY", "Lcom/huachenjie/home/HomeFunctionAdapter;", "b", "B", "headerAdapter", "Lcom/huachenjie/home/HomeGoodsAdapter;", "c", "A", "goodsAdapter", "Landroidx/lifecycle/MediatorLiveData;", "", "Landroidx/lifecycle/MediatorLiveData;", "I", "()Landroidx/lifecycle/MediatorLiveData;", "showSeaView", "Lcom/huachenjie/home/bean/reward/HomeRewardBean;", "d", "D", "homeRewardData", "C", "homeData", "Lcom/huachenjie/home/bean/JackpotAwardBean;", "e", "E", "jackpotAwardBean", "", "f", "H", "searchBannerList", "Lcom/huachenjie/home/bean/GoodStuffPickData;", y6b.f, "G", "promoSlotData", "Lcom/huachenjie/home/bean/AdPopupBean;", y6b.g, "q", "adPopupBean", "Lcom/huachenjie/works/external/adapter/WorksAdapter;", "i", "r", "adapter", "Lcom/huachenjie/works/bean/BuddyTypeBean;", "j", "u", "buddyTypeBean", "Lcom/huachenjie/works/bean/BuddyTypeScopeTypeBean;", "k", "x", "buddyTypeTabList", t.d, "y", "buddyTypeTabTitles", "m", "w", "buddyTypeTabIndex", "n", "t", "buddyScopeType", "v", "buddyTypeCode", "J", "isRefreshing", "F", "()I", "X", "(I)V", "pageNum", "Ljava/lang/String;", "refreshTime", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeVM.kt\ncom/huachenjie/home/HomeVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,321:1\n350#2,7:322\n288#2,2:330\n1549#2:332\n1620#2,3:333\n350#2,7:336\n1#3:329\n*S KotlinDebug\n*F\n+ 1 HomeVM.kt\ncom/huachenjie/home/HomeVM\n*L\n270#1:322,7\n276#1:330,2\n284#1:332\n284#1:333,3\n285#1:336,7\n*E\n"})
public final class HomeVM extends BaseViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> showSeaView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<HomeData> homeData;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<HomeRewardBean> homeRewardData;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<JackpotAwardBean> jackpotAwardBean;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<String>> searchBannerList;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<GoodStuffPickData> promoSlotData;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AdPopupBean> adPopupBean;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<WorksAdapter> adapter;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BuddyTypeBean> buddyTypeBean;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<BuddyTypeScopeTypeBean>> buddyTypeTabList;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<String>> buddyTypeTabTitles;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> buddyTypeTabIndex;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> buddyScopeType;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> buddyTypeCode;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> bgHeaderTranslationY = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<HomeFunctionAdapter> headerAdapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<HomeGoodsAdapter> goodsAdapter = new MutableLiveData<>();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34195a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34195a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34195a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34195a.invoke(obj);
        }
    }

    public HomeVM() {
        Boolean bool = Boolean.FALSE;
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>(bool);
        this.showSeaView = mediatorLiveData;
        this.homeRewardData = new MutableLiveData<>();
        MediatorLiveData<HomeData> mediatorLiveData2 = new MediatorLiveData<>();
        this.homeData = mediatorLiveData2;
        this.jackpotAwardBean = new MutableLiveData<>();
        this.searchBannerList = new MutableLiveData<>();
        this.promoSlotData = new MutableLiveData<>();
        this.adPopupBean = new MutableLiveData<>();
        this.adapter = new MutableLiveData<>();
        this.buddyTypeBean = new MutableLiveData<>();
        this.buddyTypeTabList = new MutableLiveData<>(CollectionsKt.emptyList());
        this.buddyTypeTabTitles = new MutableLiveData<>(CollectionsKt.emptyList());
        this.buddyTypeTabIndex = new MutableLiveData<>(0);
        this.buddyScopeType = new MutableLiveData<>(1);
        this.buddyTypeCode = new MutableLiveData<>("");
        this.isRefreshing = new MutableLiveData<>(bool);
        this.pageNum = 1;
        mediatorLiveData.addSource(mediatorLiveData2, new a(new Function1<HomeData, Unit>() { // from class: com.huachenjie.home.HomeVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HomeData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(HomeData homeData) {
                HomeVM.this.I().setValue(Boolean.valueOf(homeData.getHasSeaview()));
            }
        }));
    }

    public static /* synthetic */ void S(HomeVM homeVM, WorkItemBean workItemBean, int i, Object obj) {
        if ((i & 1) != 0) {
            workItemBean = null;
        }
        homeVM.R(workItemBean);
    }

    public static /* synthetic */ void U(HomeVM homeVM, WorkItemBean workItemBean, int i, Object obj) {
        if ((i & 1) != 0) {
            workItemBean = null;
        }
        homeVM.T(workItemBean);
    }

    @NotNull
    public final MutableLiveData<HomeGoodsAdapter> A() {
        return this.goodsAdapter;
    }

    @NotNull
    public final MutableLiveData<HomeFunctionAdapter> B() {
        return this.headerAdapter;
    }

    @NotNull
    public final MediatorLiveData<HomeData> C() {
        return this.homeData;
    }

    @NotNull
    public final MutableLiveData<HomeRewardBean> D() {
        return this.homeRewardData;
    }

    @NotNull
    public final MutableLiveData<JackpotAwardBean> E() {
        return this.jackpotAwardBean;
    }

    /* JADX INFO: renamed from: F, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @NotNull
    public final MutableLiveData<GoodStuffPickData> G() {
        return this.promoSlotData;
    }

    @NotNull
    public final MutableLiveData<List<String>> H() {
        return this.searchBannerList;
    }

    @NotNull
    public final MediatorLiveData<Boolean> I() {
        return this.showSeaView;
    }

    @NotNull
    public final MutableLiveData<Boolean> J() {
        return this.isRefreshing;
    }

    public final void K() {
        this.pageNum++;
        S(this, null, 1, null);
    }

    public final void L() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.home.HomeVM$queryBuddyTypeList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.o();
                return Boolean.FALSE;
            }
        }, null, new HomeVM$queryBuddyTypeList$2(this, null), 11, null);
    }

    public final void M() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.home.HomeVM$queryGoodStuffPick$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.G().setValue(new GoodStuffPickData(null, 1, null));
                return Boolean.FALSE;
            }
        }, null, new HomeVM$queryGoodStuffPick$2(this, null), 11, null);
    }

    public final void N() {
        BaseViewModelExtKt.b(this, false, false, null, null, new HomeVM$queryHomeAdPopup$1(this, null), 15, null);
    }

    public final void O() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.home.HomeVM$queryHomeData$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.C().setValue(this.this$0.z());
                return Boolean.FALSE;
            }
        }, null, new HomeVM$queryHomeData$2(this, null), 11, null);
    }

    public final void P() {
        BaseViewModelExtKt.b(this, false, false, null, null, new HomeVM$queryHomeReward$1(this, null), 15, null);
    }

    public final void Q() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.home.HomeVM$queryHomeSearchBanner$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.H().setValue(CollectionsKt.mutableListOf(new String[]{"输入内容搜索"}));
                return Boolean.TRUE;
            }
        }, null, new HomeVM$queryHomeSearchBanner$2(this, null), 11, null);
    }

    public final void R(final WorkItemBean bean) {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.home.HomeVM$queryPageList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.getPageNum() == 1) {
                    if (bean == null) {
                        WorksAdapter value = this.this$0.r().getValue();
                        if (value != null) {
                            value.setList(null);
                        }
                        WorksAdapter value2 = this.this$0.r().getValue();
                        if (value2 != null) {
                            value2.r();
                        }
                    } else {
                        WorksAdapter value3 = this.this$0.r().getValue();
                        if (value3 != null) {
                            value3.p();
                        }
                        WorksAdapter value4 = this.this$0.r().getValue();
                        if (value4 != null) {
                            value4.setList(CollectionsKt.listOf(bean));
                        }
                    }
                    this.this$0.J().setValue(Boolean.FALSE);
                } else {
                    HomeVM homeVM = this.this$0;
                    homeVM.X(homeVM.getPageNum() - 1);
                }
                WorksAdapter value5 = this.this$0.r().getValue();
                if (value5 != null && (loadMoreModule = value5.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new HomeVM$queryPageList$2(this, bean, null), 11, null);
    }

    public final void T(WorkItemBean bean) {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        R(bean);
    }

    public final void V() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.home.HomeVM$refreshList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                HomeVM.U(this.this$0, null, 1, null);
                return Boolean.TRUE;
            }
        }, null, new HomeVM$refreshList$2(this, null), 11, null);
    }

    public final void W() {
        BaseViewModelExtKt.b(this, false, false, null, null, new HomeVM$requestJackpotAward$1(this, null), 15, null);
    }

    public final void X(int i) {
        this.pageNum = i;
    }

    public final void Y(int scopeType) {
        Integer value = this.buddyScopeType.getValue();
        if (value != null && value.intValue() == scopeType) {
            return;
        }
        this.buddyScopeType.setValue(Integer.valueOf(scopeType));
        this.buddyTypeCode.setValue("");
        o();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0057  */
    public final void Z(@NotNull String typeCode) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(typeCode, "typeCode");
        if (Intrinsics.areEqual(this.buddyTypeCode.getValue(), typeCode)) {
            return;
        }
        this.buddyTypeCode.setValue(typeCode);
        MutableLiveData<Integer> mutableLiveData = this.buddyTypeTabIndex;
        List<BuddyTypeScopeTypeBean> value = this.buddyTypeTabList.getValue();
        if (value != null) {
            Iterator<BuddyTypeScopeTypeBean> it = value.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().getBuddyTypeCode(), typeCode)) {
                    break;
                } else {
                    i++;
                }
            }
            numValueOf = Integer.valueOf(i);
            if (!(numValueOf.intValue() >= 0)) {
                numValueOf = null;
            }
            if (numValueOf == null) {
                numValueOf = 0;
            }
        } else {
            numValueOf = 0;
        }
        mutableLiveData.setValue(numValueOf);
    }

    public final void o() {
        BuddyTypeScopeBean buddyTypeScopeBean;
        List<BuddyTypeScopeTypeBean> typeList;
        List<BuddyTypeScopeBean> list;
        Object next;
        int scopeType;
        Integer value;
        BuddyTypeBean value2 = this.buddyTypeBean.getValue();
        if (value2 == null || (list = value2.getList()) == null) {
            buddyTypeScopeBean = null;
        } else {
            Iterator<T> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                scopeType = ((BuddyTypeScopeBean) next).getScopeType();
                value = this.buddyScopeType.getValue();
                if (value == null) {
                    value = 1;
                }
            } while (!(value != null && scopeType == value.intValue()));
            buddyTypeScopeBean = (BuddyTypeScopeBean) next;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BuddyTypeScopeTypeBean("", "全部", null, 4, null));
        if (buddyTypeScopeBean != null && (typeList = buddyTypeScopeBean.getTypeList()) != null) {
            arrayList.addAll(typeList);
        }
        this.buddyTypeTabList.setValue(arrayList);
        MutableLiveData<List<String>> mutableLiveData = this.buddyTypeTabTitles;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((BuddyTypeScopeTypeBean) it2.next()).getBuddyTypeName());
        }
        mutableLiveData.setValue(arrayList2);
        MutableLiveData<Integer> mutableLiveData2 = this.buddyTypeTabIndex;
        Iterator it3 = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it3.hasNext()) {
                i = -1;
                break;
            }
            String buddyTypeCode = ((BuddyTypeScopeTypeBean) it3.next()).getBuddyTypeCode();
            String value3 = this.buddyTypeCode.getValue();
            if (value3 == null) {
                value3 = "";
            }
            if (Intrinsics.areEqual(buddyTypeCode, value3)) {
                break;
            } else {
                i++;
            }
        }
        Integer numValueOf = Integer.valueOf(i);
        Integer num = numValueOf.intValue() >= 0 ? numValueOf : null;
        if (num == null) {
            num = 0;
        }
        mutableLiveData2.setValue(num);
    }

    public final PageEntity<WorkItemBean> p(PageEntity<WorkItemBean> data) {
        JZUnifiedAdInfo jZUnifiedAdInfoC;
        if (data != null && data.getList() != null && !data.getList().isEmpty()) {
            AdPlatformSwitch adPlatformSwitchE = r90.e("hprp");
            int i = 1;
            if ((adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) && (jZUnifiedAdInfoC = ip4.b().c()) != null) {
                try {
                    int iCoerceAtMost = RangesKt.coerceAtMost(4, data.getList().size());
                    int i2 = -1;
                    for (int i3 = 0; i3 < iCoerceAtMost; i3++) {
                        if (((WorkItemBean) data.getList().get(i3)).getPostType() == 3) {
                            i2 = i3;
                        }
                    }
                    if (i2 != -1) {
                        i = 2;
                    }
                    int iCoerceAtMost2 = RangesKt.coerceAtMost(i, data.getList().size());
                    WorkNativeAdBean workNativeAdBean = new WorkNativeAdBean();
                    workNativeAdBean.setAdInfo(jZUnifiedAdInfoC);
                    if (iCoerceAtMost2 == data.getList().size()) {
                        data.getList().add(workNativeAdBean);
                    } else {
                        data.getList().add(iCoerceAtMost2, workNativeAdBean);
                    }
                    ip4.b().e(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    @NotNull
    public final MutableLiveData<AdPopupBean> q() {
        return this.adPopupBean;
    }

    @NotNull
    public final MutableLiveData<WorksAdapter> r() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> s() {
        return this.bgHeaderTranslationY;
    }

    @NotNull
    public final MutableLiveData<Integer> t() {
        return this.buddyScopeType;
    }

    @NotNull
    public final MutableLiveData<BuddyTypeBean> u() {
        return this.buddyTypeBean;
    }

    @NotNull
    public final MutableLiveData<String> v() {
        return this.buddyTypeCode;
    }

    @NotNull
    public final MutableLiveData<Integer> w() {
        return this.buddyTypeTabIndex;
    }

    @NotNull
    public final MutableLiveData<List<BuddyTypeScopeTypeBean>> x() {
        return this.buddyTypeTabList;
    }

    @NotNull
    public final MutableLiveData<List<String>> y() {
        return this.buddyTypeTabTitles;
    }

    public final HomeData z() {
        return new HomeData(null, null, false, 3, null);
    }
}
