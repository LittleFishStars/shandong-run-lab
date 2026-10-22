package com.huachenjie.mall.page.goods_detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.triver.basic.api.RequestPermission;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.a;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.bean.TabEntity;
import com.huachenjie.base.bean.VideoBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.im.custom.ShareCommodityAttachment;
import com.huachenjie.im.custom.ShareGoodsAttachment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.MerchantsBean;
import com.huachenjie.mall.bean.goods_detail.GoodsActivity;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailAttribute;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailOneGoodsComment;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailPicture;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailShop;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSku;
import com.huachenjie.mall.databinding.MallActivityGoodsDetailBinding;
import com.huachenjie.mall.databinding.MallViewGoodsDetailHeaderBinding;
import com.huachenjie.mall.dialog.poster.CreatePosterDialog;
import com.huachenjie.mall.page.check_order.CheckOrderActivity;
import com.huachenjie.mall.page.comment.list.CommodityCommentListActivity;
import com.huachenjie.mall.page.course_detail.CourseDetailActivity;
import com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity.ClickProxy;
import com.huachenjie.mall.page.goods_detail.preview.ImagePreviewActivity;
import com.huachenjie.mall.page.goods_detail.preview.ImagePreviewView;
import com.huachenjie.mall.page.goods_detail.preview.PlayerManager;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import com.huachenjie.mall.page.try_see_list.TrySeeListActivity;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.works.page.share.OnShareCallback;
import com.huachenjie.works.page.share.ShareWorksDialog;
import com.huachenjie.works.page.share.enums.ExtendEvents;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.zj.adlib.ar6;
import com.zj.adlib.dj1;
import com.zj.adlib.fx7;
import com.zj.adlib.hk0;
import com.zj.adlib.iy5;
import com.zj.adlib.mq5;
import com.zj.adlib.su9;
import com.zj.adlib.y57;
import com.zj.adlib.y6b;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import huachenjie.sdk.share.sharebody.WebPageBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Route(path = zj7.g.GOOD_DETAIL)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 N2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002XNB\u0007¢\u0006\u0004\bV\u0010WJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0017J\"\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001f\u001a\u00020\u0006H\u0014J\b\u0010 \u001a\u00020\u0006H\u0014J\b\u0010!\u001a\u00020\u0006H\u0014J\b\u0010\"\u001a\u00020\u0006H\u0016J\u001a\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$H\u0016R\u001b\u0010+\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010/\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010(\u001a\u0004\b-\u0010.R\u001b\u00102\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010(\u001a\u0004\b1\u0010*R\u001b\u00105\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010(\u001a\u0004\b4\u0010*R\u001b\u00108\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010(\u001a\u0004\b7\u0010*R\u001b\u0010<\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010(\u001a\u0004\b:\u0010;R\u001d\u0010?\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010(\u001a\u0004\b>\u0010*R\u0016\u0010B\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010E\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010(\u001a\u0004\bD\u0010.R\u0016\u0010G\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010AR\u001f\u0010L\u001a\u00060HR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010(\u001a\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010(\u001a\u0004\bS\u0010T¨\u0006Y"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityGoodsDetailBinding;", "Lcom/huachenjie/mall/page/goods_detail/GoodsDetailVM;", "", "isDark", "", "K0", "G0", "initToolbar", "", CreatePosterDialog.SHARE_NO, "L0", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailBean;", "goodsDetailBean", "I0", "v0", "S", "", "getLayoutResID", "", "", "V", "initView", "initData", "W", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "onResume", "onPause", "onDestroy", "onBackPressed", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "b", "Lkotlin/Lazy;", "A0", "()Ljava/lang/String;", "goodsNo", "c", "D0", "()I", "squareType", "d", "x0", "cooperationNo", "e", "F0", "traceNo", "f", "C0", "source", y6b.f, "z0", "()Z", "fromReward", y6b.g, "y0", "exchangeCode", "K", "I", "bannerHeight", "i", "E0", "toolbarHeight", "L", "toolbarType", "Lcom/huachenjie/mall/page/goods_detail/GoodsDetailActivity$ClickProxy;", "j", "w0", "()Lcom/huachenjie/mall/page/goods_detail/GoodsDetailActivity$ClickProxy;", "clickProxy", "Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog;", "a", "Lcom/huachenjie/mall/page/goods_detail/GoodsSpecificationDialog;", "specificationDialog", "Lcom/huachenjie/mall/databinding/MallViewGoodsDetailHeaderBinding;", "k", "B0", "()Lcom/huachenjie/mall/databinding/MallViewGoodsDetailHeaderBinding;", "headerBinding", "<init>", "()V", "ClickProxy", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class GoodsDetailActivity extends BaseMVVMActivity<MallActivityGoodsDetailBinding, GoodsDetailVM> {

    @NotNull
    public static final String A = "source";

    @NotNull
    public static final String B = "fromReward";

    @NotNull
    public static final String C = "exchangeCode";
    public static final int M = 0;
    public static final int N = 1;
    public static final int O = 3;
    public static final int P = 1101;
    public static final int Q = 1102;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "goodsNo";

    @NotNull
    public static final String x = "squareType";

    @NotNull
    public static final String y = "cooperationNo";

    @NotNull
    public static final String z = "traceNo";

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int toolbarType;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public GoodsSpecificationDialog specificationDialog;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy goodsNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$goodsNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("goodsNo");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy squareType = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$squareType$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m530invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra("squareType", 0));
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy cooperationNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$cooperationNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("cooperationNo");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy traceNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$traceNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("traceNo");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy source = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$source$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("source");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final Lazy fromReward = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$fromReward$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m526invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra("fromReward", false));
        }
    });

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final Lazy exchangeCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$exchangeCode$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("exchangeCode");
        }
    });

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int bannerHeight = fx7.j();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final Lazy toolbarHeight = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$toolbarHeight$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m531invoke() {
            int iB = SizeUtils.b(44.0f);
            Integer value = GoodsDetailActivity.i0(this.this$0).e().c().getValue();
            Intrinsics.checkNotNull(value);
            return Integer.valueOf(iB + value.intValue());
        }
    });

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final Lazy clickProxy = LazyKt.lazy(new Function0<ClickProxy>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$clickProxy$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final GoodsDetailActivity.ClickProxy m523invoke() {
            return this.this$0.new ClickProxy();
        }
    });

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final Lazy headerBinding = LazyKt.lazy(new Function0<MallViewGoodsDetailHeaderBinding>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$headerBinding$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MallViewGoodsDetailHeaderBinding m528invoke() {
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.mall_view_goods_detail_header, null, false);
            Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(\n            lay…          false\n        )");
            MallViewGoodsDetailHeaderBinding mallViewGoodsDetailHeaderBinding = (MallViewGoodsDetailHeaderBinding) viewDataBindingInflate;
            mallViewGoodsDetailHeaderBinding.m(Integer.valueOf(this.this$0.bannerHeight));
            mallViewGoodsDetailHeaderBinding.o(GoodsDetailActivity.i0(this.this$0));
            mallViewGoodsDetailHeaderBinding.n(this.this$0.w0());
            ImagePreviewView imagePreviewView = mallViewGoodsDetailHeaderBinding.f11036a;
            final GoodsDetailActivity goodsDetailActivity = this.this$0;
            imagePreviewView.setOnItemClickListener(new Function1<Integer, Unit>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$headerBinding$2.1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    List<VideoBean> goodsVideoList;
                    GoodsDetailBean value = GoodsDetailActivity.i0(goodsDetailActivity).u().getValue();
                    VideoBean videoBean = (value == null || (goodsVideoList = value.getGoodsVideoList()) == null) ? null : (VideoBean) CollectionsKt.getOrNull(goodsVideoList, 0);
                    GoodsDetailBean value2 = GoodsDetailActivity.i0(goodsDetailActivity).u().getValue();
                    ArrayList<ImageBean> mainImageList = value2 != null ? value2.getMainImageList() : null;
                    if (mainImageList == null || mainImageList.isEmpty()) {
                        return;
                    }
                    goodsDetailActivity.startActivityForResult(ImagePreviewActivity.INSTANCE.a(goodsDetailActivity, videoBean, mainImageList, i), 1101);
                }
            });
            mallViewGoodsDetailHeaderBinding.setLifecycleOwner(this.this$0);
            return mallViewGoodsDetailHeaderBinding;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsDetailActivity$ClickProxy;", "", "Landroid/view/View;", "view", "", "b", "e", y6b.f, "d", "f", "c", y6b.g, "a", "<init>", "(Lcom/huachenjie/mall/page/goods_detail/GoodsDetailActivity;)V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@NotNull View view) {
            GoodsActivity activityInfo;
            Intrinsics.checkNotNullParameter(view, "view");
            GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.c);
            sb.append("/#/mall/mall-flash-sale?activityNo=");
            GoodsDetailBean value = GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue();
            sb.append((value == null || (activityInfo = value.getActivityInfo()) == null) ? null : activityInfo.getActivityNo());
            su9.v(goodsDetailActivity, sb.toString());
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GoodsDetailActivity.this.onBackPressed();
        }

        public final void c(@NotNull View view) {
            MerchantsBean desc;
            GoodsDetailBean value;
            String url;
            Intrinsics.checkNotNullParameter(view, "view");
            GoodsDetailShop shopInfo = GoodsDetailActivity.i0(GoodsDetailActivity.this).getShopInfo();
            if (shopInfo == null || (desc = shopInfo.getDesc()) == null || (value = GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.goodsDetail.value ?: return@let");
            String accId = desc.getAccId();
            String shopNo = desc.getShopNo();
            String goodsNo = value.getGoodsNo();
            String goodsName = value.getGoodsName();
            GoodsDetailPicture goodsDetailPicture = (GoodsDetailPicture) CollectionsKt.firstOrNull(value.getDetailImageList());
            if (goodsDetailPicture == null || (url = goodsDetailPicture.getUrl()) == null) {
                url = "";
            }
            dj1.b0(accId, shopNo, new ShareGoodsAttachment(goodsNo, goodsName, url));
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GoodsDetailBean value = GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue();
            ArrayList<GoodsDetailAttribute> goodsAttributeList = value != null ? value.getGoodsAttributeList() : null;
            if (goodsAttributeList == null || goodsAttributeList.isEmpty()) {
                return;
            }
            GoodsParamDialog goodsParamDialogA = GoodsParamDialog.INSTANCE.a(goodsAttributeList);
            FragmentManager supportFragmentManager = GoodsDetailActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            goodsParamDialogA.show(supportFragmentManager, Reflection.getOrCreateKotlinClass(GoodsParamDialog.class).getSimpleName());
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue() == null) {
                return;
            }
            GoodsDetailVM goodsDetailVMI0 = GoodsDetailActivity.i0(GoodsDetailActivity.this);
            String strA0 = GoodsDetailActivity.this.A0();
            Intrinsics.checkNotNullExpressionValue(strA0, "goodsNo");
            goodsDetailVMI0.p(strA0);
        }

        public final void f(@NotNull View view) {
            String shopNo;
            Intrinsics.checkNotNullParameter(view, "view");
            GoodsDetailBean value = GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue();
            if (value == null || (shopNo = value.getShopNo()) == null) {
                return;
            }
            MerchantsActivity.Companion bVar = MerchantsActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            bVar.a(context, shopNo);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void g(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue() == null || GoodsDetailActivity.i0(GoodsDetailActivity.this).getSelSpecIndexArray() == null) {
                return;
            }
            GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
            GoodsSpecificationDialog.Companion bVar = GoodsSpecificationDialog.INSTANCE;
            GoodsDetailBean value = GoodsDetailActivity.i0(goodsDetailActivity).u().getValue();
            Intrinsics.checkNotNull(value);
            GoodsDetailBean goodsDetailBean = value;
            int[] selSpecIndexArray = GoodsDetailActivity.i0(GoodsDetailActivity.this).getSelSpecIndexArray();
            Intrinsics.checkNotNull(selSpecIndexArray);
            boolean zAreEqual = Intrinsics.areEqual(GoodsDetailActivity.i0(GoodsDetailActivity.this).r().getValue(), Boolean.TRUE);
            String value2 = GoodsDetailActivity.i0(GoodsDetailActivity.this).y().getValue();
            if (value2 == null) {
                value2 = "";
            }
            int iD0 = GoodsDetailActivity.this.D0();
            String strC0 = GoodsDetailActivity.this.C0();
            Intrinsics.checkNotNullExpressionValue(strC0, "source");
            String strF0 = GoodsDetailActivity.this.F0();
            Intrinsics.checkNotNullExpressionValue(strF0, "traceNo");
            boolean zZ0 = GoodsDetailActivity.this.z0();
            String strY0 = GoodsDetailActivity.this.y0();
            final GoodsDetailActivity goodsDetailActivity2 = GoodsDetailActivity.this;
            goodsDetailActivity.specificationDialog = bVar.a(goodsDetailBean, selSpecIndexArray, zAreEqual, value2, iD0, strC0, strF0, zZ0, strY0, new Function1<int[], Unit>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$ClickProxy$clickSpecification$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((int[]) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull int[] iArr) {
                    Intrinsics.checkNotNullParameter(iArr, o.f);
                    GoodsDetailActivity.i0(goodsDetailActivity2).Q(iArr);
                }
            });
            GoodsSpecificationDialog goodsSpecificationDialog = GoodsDetailActivity.this.specificationDialog;
            if (goodsSpecificationDialog != null) {
                FragmentManager supportFragmentManager = GoodsDetailActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                goodsSpecificationDialog.show(supportFragmentManager, Reflection.getOrCreateKotlinClass(GoodsSpecificationDialog.class).getSimpleName());
            }
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void h(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue() == null) {
                return;
            }
            GoodsDetailBean value = GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue();
            Intrinsics.checkNotNull(value);
            int type = value.getType();
            GoodsDetailBean value2 = GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue();
            Intrinsics.checkNotNull(value2);
            int subType = value2.getSubType();
            if (type != 2) {
                return;
            }
            GoodsDetailBean value3 = GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue();
            Intrinsics.checkNotNull(value3);
            if (value3.getMultipleSku()) {
                TrySeeListActivity.Companion aVar = TrySeeListActivity.INSTANCE;
                GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
                String strA0 = goodsDetailActivity.A0();
                Intrinsics.checkNotNullExpressionValue(strA0, "goodsNo");
                aVar.a(goodsDetailActivity, strA0, subType == 201 ? 0 : 1);
                return;
            }
            GoodsDetailBean value4 = GoodsDetailActivity.i0(GoodsDetailActivity.this).u().getValue();
            Intrinsics.checkNotNull(value4);
            GoodsDetailSku goodsDetailSku = (GoodsDetailSku) CollectionsKt.firstOrNull(value4.getSkuList());
            if (goodsDetailSku == null) {
                return;
            }
            if (subType == 201) {
                CourseDetailActivity.INSTANCE.c(GoodsDetailActivity.this, goodsDetailSku.getSkuNo());
            } else {
                EpisodesDetailActivity.INSTANCE.c(GoodsDetailActivity.this, goodsDetailSku.getSkuNo());
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/GoodsDetailActivity$a;", "", "Landroid/content/Context;", "context", "", "goodsNo", "", "a", "", "COMMENT_POSITION", "I", "DETAIL_POSITION", "INFO_POSITION", "KEY_EXCHANGE_CODE", "Ljava/lang/String;", "KEY_GOODS_COOPERATION_NO", "KEY_GOODS_FROM_REWARD", "KEY_GOODS_NO", "KEY_GOODS_SQUARE_TYPE", "KEY_SOURCE", "KEY_TRACE_NO", "REQUEST_CODE_CHECK_ORDER", "REQUEST_CODE_PREVIEW", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String goodsNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
            Intent intent = new Intent(context, (Class<?>) GoodsDetailActivity.class);
            intent.putExtra("goodsNo", goodsNo);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/mall/page/goods_detail/GoodsDetailActivity$b", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", bo.g, "a", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OnTabSelectListener {
        public b() {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int p0) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
            RecyclerView.LayoutManager layoutManager = GoodsDetailActivity.h0(GoodsDetailActivity.this).f10225a.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (position == 0) {
                linearLayoutManager.scrollToPosition(0);
            } else if (position == 1) {
                linearLayoutManager.scrollToPositionWithOffset(1, GoodsDetailActivity.this.E0());
            } else {
                if (position != 2) {
                    return;
                }
                linearLayoutManager.scrollToPositionWithOffset(3, GoodsDetailActivity.this.E0());
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35188a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35188a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35188a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35188a.invoke(obj);
        }
    }

    public static final void H0(GoodsDetailAdapter goodsDetailAdapter, GoodsDetailActivity goodsDetailActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(goodsDetailAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(goodsDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (goodsDetailAdapter.getItem(i) instanceof GoodsDetailOneGoodsComment) {
            CommodityCommentListActivity.Companion aVar = CommodityCommentListActivity.INSTANCE;
            String strA0 = goodsDetailActivity.A0();
            Intrinsics.checkNotNullExpressionValue(strA0, "goodsNo");
            aVar.a(goodsDetailActivity, strA0);
        }
    }

    public static final void J0(GoodsDetailActivity goodsDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(goodsDetailActivity, "this$0");
        goodsDetailActivity.onBackPressed();
    }

    public static final /* synthetic */ MallActivityGoodsDetailBinding h0(GoodsDetailActivity goodsDetailActivity) {
        return goodsDetailActivity.getMBinding();
    }

    public static final /* synthetic */ GoodsDetailVM i0(GoodsDetailActivity goodsDetailActivity) {
        return goodsDetailActivity.getMViewModel();
    }

    public final String A0() {
        return (String) this.goodsNo.getValue();
    }

    public final MallViewGoodsDetailHeaderBinding B0() {
        return (MallViewGoodsDetailHeaderBinding) this.headerBinding.getValue();
    }

    public final String C0() {
        return (String) this.source.getValue();
    }

    public final int D0() {
        return ((Number) this.squareType.getValue()).intValue();
    }

    public final int E0() {
        return ((Number) this.toolbarHeight.getValue()).intValue();
    }

    public final String F0() {
        return (String) this.traceNo.getValue();
    }

    public final void G0() {
        MutableLiveData<GoodsDetailAdapter> mutableLiveDataQ = getMViewModel().q();
        final GoodsDetailAdapter goodsDetailAdapter = new GoodsDetailAdapter();
        goodsDetailAdapter.setHeaderWithEmptyEnable(false);
        View root = B0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headerBinding.root");
        BaseQuickAdapter.setHeaderView$default(goodsDetailAdapter, root, 0, 0, 6, null);
        y57.d(goodsDetailAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.jv3
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                GoodsDetailActivity.H0(goodsDetailAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataQ.setValue(goodsDetailAdapter);
    }

    public final void I0(GoodsDetailBean goodsDetailBean) {
        int i;
        if (!getMBinding().f34797a.isInflated()) {
            ViewStub viewStub = getMBinding().f34797a.getViewStub();
            if (viewStub != null) {
                if (goodsDetailBean.getType() == 3) {
                    i = R.layout.mall_layout_goods_detail_bottom_point;
                } else if (D0() == 1 || D0() == 2) {
                    i = R.layout.mall_layout_goods_detail_bottom_distributing;
                } else {
                    i = D0() == 3 ? R.layout.mall_layout_goods_detail_bottom_team_leader : R.layout.mall_layout_goods_detail_bottom;
                }
                viewStub.setLayoutResource(i);
                viewStub.inflate();
            }
            ViewDataBinding binding = getMBinding().f34797a.getBinding();
            if (binding != null) {
                binding.setVariable(hk0.p0, getMViewModel());
                binding.setVariable(hk0.k, w0());
                binding.setLifecycleOwner(this);
            }
        }
        View root = getMBinding().f34797a.getRoot();
        if (root != null) {
            root.setVisibility(goodsDetailBean.getGoodsStatus() == 1 ? 0 : 8);
        }
        getMViewModel().M(goodsDetailBean);
    }

    public final void K0(boolean isDark) {
        e.p3(this).G2(R.color.transparent).T2(isDark).u1(R.color.white).G1(true).a1();
    }

    public final void L0(String shareNo) {
        String salePoint;
        CreatePosterDialog.Companion bVar = CreatePosterDialog.INSTANCE;
        GoodsDetailBean value = getMViewModel().u().getValue();
        if (value == null || (salePoint = value.getSalePoint()) == null) {
            salePoint = "";
        }
        String strA0 = A0();
        Intrinsics.checkNotNullExpressionValue(strA0, "goodsNo");
        CreatePosterDialog createPosterDialogA = bVar.a(shareNo, salePoint, strA0);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        createPosterDialogA.show(supportFragmentManager, Reflection.getOrCreateKotlinClass(CreatePosterDialog.class).getSimpleName());
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        K0(false);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.k), w0())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @SuppressLint({"MissingPermission"})
    public void W() {
        getMViewModel().u().observe(this, new c(new Function1<GoodsDetailBean, Unit>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GoodsDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GoodsDetailBean goodsDetailBean) {
                float width;
                if (goodsDetailBean.getGoodsStatus() != 1) {
                    this.this$0.K0(true);
                    GoodsDetailActivity.h0(this.this$0).getRoot().setBackgroundColor(-1);
                    GoodsDetailAdapter value = GoodsDetailActivity.i0(this.this$0).q().getValue();
                    if (value != null) {
                        View viewInflate = LayoutInflater.from(this.this$0).inflate(R.layout.view_state_empty_view, (ViewGroup) null);
                        viewInflate.setPadding(0, SizeUtils.b(260.0f), 0, 0);
                        ((TextView) viewInflate.findViewById(R.id.tv_empty)).setText("当前商品已下架");
                        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(this@GoodsDetailAct…                        }");
                        value.setEmptyView(viewInflate);
                    }
                } else {
                    this.this$0.K0(false);
                    GoodsDetailActivity.h0(this.this$0).getRoot().setBackgroundColor(ar6.E);
                    GoodsDetailAdapter value2 = GoodsDetailActivity.i0(this.this$0).q().getValue();
                    if (value2 != null) {
                        value2.removeEmptyView();
                    }
                    if (!goodsDetailBean.getMainImageList().isEmpty()) {
                        try {
                            width = goodsDetailBean.getMainImageList().get(0).getWidth() / goodsDetailBean.getMainImageList().get(0).getHeight();
                        } catch (Exception unused) {
                            width = 1.0f;
                        }
                        this.this$0.bannerHeight = (int) (fx7.j() / (width > 0.0f ? width : 1.0f));
                        this.this$0.B0().setVariable(hk0.f, Integer.valueOf(this.this$0.bannerHeight));
                    }
                    if (!this.this$0.B0().f35082a.isInflated()) {
                        ViewStub viewStub = this.this$0.B0().f35082a.getViewStub();
                        if (viewStub != null) {
                            viewStub.setLayoutResource((!goodsDetailBean.getActivityFlag() || goodsDetailBean.getActivityInfo() == null || goodsDetailBean.getActivityInfo().getActivityTypeValue() == 3 || this.this$0.D0() > 0) ? R.layout.mall_view_goods_detail_header_content : R.layout.mall_view_goods_detail_header_activity_content);
                            viewStub.inflate();
                        }
                        ViewDataBinding binding = this.this$0.B0().f35082a.getBinding();
                        if (binding != null) {
                            GoodsDetailActivity goodsDetailActivity = this.this$0;
                            binding.setVariable(hk0.p0, GoodsDetailActivity.i0(goodsDetailActivity));
                            binding.setVariable(hk0.k, goodsDetailActivity.w0());
                            binding.setLifecycleOwner(goodsDetailActivity);
                        }
                    }
                    List<VideoBean> goodsVideoList = goodsDetailBean.getGoodsVideoList();
                    VideoBean videoBean = goodsVideoList != null ? (VideoBean) CollectionsKt.getOrNull(goodsVideoList, 0) : null;
                    if (videoBean != null) {
                        PlayerManager.INSTANCE.a().w(videoBean.getUrl());
                    }
                    this.this$0.B0().f11036a.initData(videoBean, goodsDetailBean.getMainImageList(), iy5.c(this.this$0), true, 0, false);
                }
                GoodsDetailActivity goodsDetailActivity2 = this.this$0;
                Intrinsics.checkNotNullExpressionValue(goodsDetailBean, o.f);
                goodsDetailActivity2.I0(goodsDetailBean);
            }
        }));
        getMViewModel().A().observe(this, new c(new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$initDataObserve$2

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/mall/page/goods_detail/GoodsDetailActivity$initDataObserve$2$a", "Lcom/huachenjie/works/page/share/OnShareCallback;", "Lcom/netease/nimlib/sdk/msg/attachment/MsgAttachment;", "f", "", "a", "Lhuachenjie/sdk/share/sharebody/WebPageBody;", y6b.f, "Lcom/huachenjie/works/page/share/enums/ExtendEvents;", "type", "c", "mall_release"}, k = 1, mv = {1, 8, 0})
            public static final class a implements OnShareCallback {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ GoodsDetailActivity f35189a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ String f11116a;
                public final /* synthetic */ String b;
                public final /* synthetic */ String c;
                public final /* synthetic */ String d;
                public final /* synthetic */ String e;

                public a(String str, String str2, String str3, String str4, String str5, GoodsDetailActivity goodsDetailActivity) {
                    this.f11116a = str;
                    this.b = str2;
                    this.c = str3;
                    this.d = str4;
                    this.e = str5;
                    this.f35189a = goodsDetailActivity;
                }

                @Override // com.huachenjie.works.page.share.OnShareCallback
                public void a() {
                }

                @Override // com.huachenjie.works.page.share.OnShareCallback
                public void c(@NotNull ExtendEvents type) {
                    Intrinsics.checkNotNullParameter(type, "type");
                    if (type == ExtendEvents.POSTER) {
                        GoodsDetailActivity goodsDetailActivity = this.f35189a;
                        String str = this.e;
                        Intrinsics.checkNotNullExpressionValue(str, CreatePosterDialog.SHARE_NO);
                        goodsDetailActivity.L0(str);
                    }
                }

                @Override // com.huachenjie.works.page.share.OnShareCallback
                @NotNull
                public MsgAttachment f() {
                    ShareCommodityAttachment shareCommodityAttachment = new ShareCommodityAttachment();
                    shareCommodityAttachment.setGoodsName(this.f11116a);
                    shareCommodityAttachment.setSalePoint(this.b);
                    shareCommodityAttachment.setMainImageUrl(this.c);
                    shareCommodityAttachment.setGoodsNo(this.d);
                    shareCommodityAttachment.setTraceNo(this.e);
                    return shareCommodityAttachment;
                }

                @Override // com.huachenjie.works.page.share.OnShareCallback
                @NotNull
                /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
                public WebPageBody e() {
                    return new WebPageBody(this.f11116a, Environment.c + "/#/mall/goods?no=" + this.e, this.f11116a, this.b);
                }
            }

            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                String url;
                String goodsNo;
                String salePoint;
                String goodsName;
                ArrayList<ImageBean> mainImageList;
                ImageBean imageBean;
                if (TextUtils.isEmpty(str) || GoodsDetailActivity.i0(this.this$0).u().getValue() == null) {
                    return;
                }
                GoodsDetailBean value = GoodsDetailActivity.i0(this.this$0).u().getValue();
                if (value == null || (mainImageList = value.getMainImageList()) == null || (imageBean = (ImageBean) CollectionsKt.getOrNull(mainImageList, 0)) == null || (url = imageBean.getUrl()) == null) {
                    url = "";
                }
                GoodsDetailBean value2 = GoodsDetailActivity.i0(this.this$0).u().getValue();
                String str2 = (value2 == null || (goodsName = value2.getGoodsName()) == null) ? "" : goodsName;
                GoodsDetailBean value3 = GoodsDetailActivity.i0(this.this$0).u().getValue();
                String str3 = (value3 == null || (salePoint = value3.getSalePoint()) == null) ? "" : salePoint;
                GoodsDetailBean value4 = GoodsDetailActivity.i0(this.this$0).u().getValue();
                ShareWorksDialog shareWorksDialogB = ShareWorksDialog.INSTANCE.b(url, new a(str2, str3, url, (value4 == null || (goodsNo = value4.getGoodsNo()) == null) ? "" : goodsNo, str, this.this$0));
                FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                shareWorksDialogB.show(supportFragmentManager, ShareWorksDialog.class.getName());
            }
        }));
        getMViewModel().r().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                GoodsSpecificationDialog goodsSpecificationDialog;
                GoodsSpecificationDialog goodsSpecificationDialog2 = this.this$0.specificationDialog;
                boolean z2 = false;
                if (goodsSpecificationDialog2 != null && goodsSpecificationDialog2.isAdded()) {
                    z2 = true;
                }
                if (!z2 || (goodsSpecificationDialog = this.this$0.specificationDialog) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                goodsSpecificationDialog.updateCanExchange(bool.booleanValue());
            }
        }));
        getMViewModel().y().observe(this, new c(new Function1<String, Unit>() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity$initDataObserve$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                GoodsSpecificationDialog goodsSpecificationDialog;
                GoodsSpecificationDialog goodsSpecificationDialog2 = this.this$0.specificationDialog;
                boolean z2 = false;
                if (goodsSpecificationDialog2 != null && goodsSpecificationDialog2.isAdded()) {
                    z2 = true;
                }
                if (!z2 || (goodsSpecificationDialog = this.this$0.specificationDialog) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(str, o.f);
                goodsSpecificationDialog.updateRemainTimeStr(str);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_goods_detail;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().D().setValue(Integer.valueOf(D0()));
        getMViewModel().I(x0());
        getMViewModel().x().setValue(Boolean.valueOf(D0() > 0));
        getMViewModel().J(z0());
        GoodsDetailVM mViewModel = getMViewModel();
        String strA0 = A0();
        Intrinsics.checkNotNullExpressionValue(strA0, "goodsNo");
        GoodsDetailVM.H(mViewModel, strA0, false, 2, null);
        String strA1 = A0();
        Intrinsics.checkNotNullExpressionValue(strA1, "goodsNo");
        mq5.d(this, strA1);
    }

    public final void initToolbar() {
        MutableLiveData<BindingTitleBean> mutableLiveDataE = getMViewModel().E();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataE.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("商品详情").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.iv3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GoodsDetailActivity.J0(this.f42450a, view);
            }
        }).setShowDivider(true));
        getMBinding().f10225a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.mall.page.goods_detail.GoodsDetailActivity.initToolbar.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                float fAbs;
                float f;
                int i;
                int i2;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                float fE0 = GoodsDetailActivity.this.bannerHeight - GoodsDetailActivity.this.E0();
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
                if (iFindFirstVisibleItemPosition == 0) {
                    fAbs = Math.abs(viewFindViewByPosition != null ? viewFindViewByPosition.getTop() : 0);
                } else {
                    fAbs = fE0;
                }
                float fCoerceAtMost = RangesKt.coerceAtMost(fAbs / fE0, 1.0f);
                GoodsDetailActivity.h0(GoodsDetailActivity.this).f10226a.f35069a.setAlpha(fCoerceAtMost);
                if (fCoerceAtMost >= 0.5d) {
                    f = (fCoerceAtMost - 0.5f) * 2;
                    i = RunIndexRecordAdapter.K;
                    i2 = 1;
                } else {
                    f = 2 * (0.5f - fCoerceAtMost);
                    i = -1;
                    i2 = 0;
                }
                if (GoodsDetailActivity.this.toolbarType != i2) {
                    GoodsDetailActivity.this.toolbarType = i2;
                    GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
                    goodsDetailActivity.K0(goodsDetailActivity.toolbarType != 0);
                }
                ImageView imageView = GoodsDetailActivity.h0(GoodsDetailActivity.this).f10226a.f11000a;
                imageView.setColorFilter(i);
                imageView.setAlpha(f);
                ImageView imageView2 = GoodsDetailActivity.h0(GoodsDetailActivity.this).f10226a.b;
                imageView2.setColorFilter(i);
                imageView2.setAlpha(f);
                if (viewFindViewByPosition != null && viewFindViewByPosition.getBottom() <= GoodsDetailActivity.this.E0()) {
                    iFindFirstVisibleItemPosition++;
                }
                if (iFindFirstVisibleItemPosition >= 3) {
                    GoodsDetailActivity.h0(GoodsDetailActivity.this).f10226a.f11001a.setCurrentTab(2);
                } else if (iFindFirstVisibleItemPosition < 1) {
                    GoodsDetailActivity.h0(GoodsDetailActivity.this).f10226a.f11001a.setCurrentTab(0);
                } else {
                    GoodsDetailActivity.h0(GoodsDetailActivity.this).f10226a.f11001a.setCurrentTab(1);
                }
            }
        });
        getMBinding().f10226a.f11001a.setTabData(CollectionsKt.arrayListOf(new CustomTabEntity[]{new TabEntity("商品"), new TabEntity("评价"), new TabEntity("详情")}));
        getMBinding().f10226a.f11001a.setOnTabSelectListener(new b());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        G0();
        initToolbar();
        PlayerManager.INSTANCE.a().m();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            return;
        }
        if (requestCode == 1101) {
            B0().f11036a.setCurrentPosition(data != null ? data.getIntExtra("position", 0) : 0);
            B0().f11036a.rebindTextureView();
        } else if (requestCode == 1102) {
            if (data != null ? data.getBooleanExtra(CheckOrderActivity.t, false) : false) {
                GoodsDetailVM mViewModel = getMViewModel();
                String strA0 = A0();
                Intrinsics.checkNotNullExpressionValue(strA0, "goodsNo");
                mViewModel.G(strA0, false);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        v0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        PlayerManager.INSTANCE.a().j();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, @Nullable KeyEvent event) {
        if (keyCode == 4) {
            v0();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        B0().f11036a.pause();
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        B0().f11036a.resume();
    }

    public final void v0() {
        if (a.D().size() == 1) {
            ARouter.getInstance().build(zj7.a.HOME).navigation();
        }
    }

    public final ClickProxy w0() {
        return (ClickProxy) this.clickProxy.getValue();
    }

    public final String x0() {
        return (String) this.cooperationNo.getValue();
    }

    public final String y0() {
        return (String) this.exchangeCode.getValue();
    }

    public final boolean z0() {
        return ((Boolean) this.fromReward.getValue()).booleanValue();
    }
}
