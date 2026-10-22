package com.huachenjie.mall.api;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.alipay.sdk.m.y.o;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.gson.Gson;
import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
import com.huachenjie.mall.bean.ApplyRefundRequestBean;
import com.huachenjie.mall.bean.CommodityCommentBean;
import com.huachenjie.mall.bean.EpisodeDetailBean;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.huachenjie.mall.bean.ExpressCompanyListBean;
import com.huachenjie.mall.bean.ExpressLogisticsOutBean;
import com.huachenjie.mall.bean.MallBannerBean;
import com.huachenjie.mall.bean.MallNavigationBean;
import com.huachenjie.mall.bean.MallPaySwitchConfig;
import com.huachenjie.mall.bean.MallSearchBannerBean;
import com.huachenjie.mall.bean.MerchantsBean;
import com.huachenjie.mall.bean.MyCourseOrEpisodesBean;
import com.huachenjie.mall.bean.MyRefundBean;
import com.huachenjie.mall.bean.MyRefundDetailBean;
import com.huachenjie.mall.bean.OrderCountBean;
import com.huachenjie.mall.bean.OrderPayBean;
import com.huachenjie.mall.bean.OrderReasonListBean;
import com.huachenjie.mall.bean.PosterBackgroundBean;
import com.huachenjie.mall.bean.PosterDetailBean;
import com.huachenjie.mall.bean.RuleCenterBean;
import com.huachenjie.mall.bean.TradeBaseInfo;
import com.huachenjie.mall.bean.TradeOrderResult;
import com.huachenjie.mall.bean.TrySeeVideoBean;
import com.huachenjie.mall.bean.WriteReviewRequestBean;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.dialog.poster.CreatePosterDialog;
import com.huachenjie.mall.external.bean.CommodityBean;
import com.huachenjie.mall.external.bean.SelectGoodsBean;
import com.huachenjie.mall.page.comment.list.CommodityCommentListFragment;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity;
import com.huachenjie.mall.page.home_tab.MallItemFragment;
import com.huachenjie.mall.page.test.TestVideoDetailBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.PageEntity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\bµ\u0001\u0010¶\u0001J7\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010 \u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000fJ\u0015\u0010$\u001a\u0004\u0018\u00010#H\u0086@ø\u0001\u0000¢\u0006\u0004\b$\u0010\u001fJ¡\u0001\u00103\u001a\u0004\u0018\u0001022\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u000b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001d\u00107\u001a\u0004\u0018\u00010#2\u0006\u00106\u001a\u000205H\u0086@ø\u0001\u0000¢\u0006\u0004\b7\u00108J#\u0010:\u001a\n\u0012\u0004\u0012\u000209\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b:\u0010;J%\u0010=\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001d\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010 \u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b@\u0010\u000fJ-\u0010D\u001a\u0004\u0018\u00010\u00192\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ-\u0010F\u001a\u0004\u0018\u00010\u00192\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bF\u0010EJ#\u0010G\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\bG\u0010;Je\u0010S\u001a\u0004\u0018\u00010\u001d2\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020QH\u0086@ø\u0001\u0000¢\u0006\u0004\bS\u0010TJ\u001d\u0010U\u001a\u0004\u0018\u00010Q2\u0006\u0010\u0013\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bU\u0010\u000fJ\u001d\u0010V\u001a\u0004\u0018\u00010Q2\u0006\u0010\u0013\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bV\u0010\u000fJm\u0010W\u001a\u0004\u0018\u00010\u00192\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020Q2\u0006\u0010\u0013\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bW\u0010XJ\u001d\u0010Z\u001a\u0004\u0018\u00010Q2\u0006\u00106\u001a\u00020YH\u0086@ø\u0001\u0000¢\u0006\u0004\bZ\u0010[J3\u0010^\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b^\u0010_J=\u0010a\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\u000b2\b\u0010`\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\u001d\u0010d\u001a\u0004\u0018\u00010c2\u0006\u0010&\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bd\u0010\u000fJ\u001d\u0010f\u001a\u0004\u0018\u00010c2\u0006\u0010e\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bf\u0010\u000fJ/\u0010i\u001a\u0004\u0018\u00010c2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u00032\b\u0010h\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bi\u0010_JO\u0010n\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u000b2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bn\u0010oJ\u001b\u0010q\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\bq\u0010\u001fJ\u001d\u0010s\u001a\u0004\u0018\u00010r2\u0006\u0010%\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bs\u0010\u000fJ;\u0010u\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\u00072\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\bu\u0010vJ\u0015\u0010x\u001a\u0004\u0018\u00010wH\u0086@ø\u0001\u0000¢\u0006\u0004\bx\u0010\u001fJ\u0015\u0010y\u001a\u0004\u0018\u00010wH\u0086@ø\u0001\u0000¢\u0006\u0004\by\u0010\u001fJ\u001d\u0010|\u001a\u0004\u0018\u00010{2\u0006\u0010z\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b|\u0010\u000fJ\u0015\u0010~\u001a\u0004\u0018\u00010}H\u0086@ø\u0001\u0000¢\u0006\u0004\b~\u0010\u001fJ(\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u007f\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0081\u0001\u0010\u001bJ(\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00192\u0007\u0010\u0082\u0001\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0083\u0001\u0010>J\u001f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\f\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0084\u0001\u0010\u000fJ\u001f\u0010\u0085\u0001\u001a\u0004\u0018\u00010#2\u0006\u0010\u0017\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0085\u0001\u0010\u000fJ\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0086\u0001\u0010\u000fJ/\u0010\u0088\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0087\u0001\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J/\u0010\u008a\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0087\u0001\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u0089\u0001J&\u0010\u008c\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008b\u0001\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u008c\u0001\u0010;J&\u0010\u008d\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008b\u0001\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u008d\u0001\u0010;J.\u0010\u008f\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u008f\u0001\u0010\u001bJ<\u0010\u0092\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0091\u0001\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u0090\u0001\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J=\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00012\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0096\u0001\u0010EJC\u0010\u0098\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u00010\u00072\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0098\u0001\u0010EJ*\u0010\u009a\u0001\u001a\u0004\u0018\u00010#2\u0007\u0010\u0099\u0001\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u009a\u0001\u0010>J7\u0010\u009c\u0001\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u000b2\u0007\u0010\u009b\u0001\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J>\u0010¡\u0001\u001a\u0004\u0018\u00010\u00192\b\u0010 \u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u0099\u0001\u001a\u00020\u000b2\u0007\u0010\u009e\u0001\u001a\u00020\u00032\b\u0010 \u0001\u001a\u00030\u009f\u0001H\u0086@ø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¢\u0001J1\u0010¤\u0001\u001a\u000b\u0012\u0005\u0012\u00030£\u0001\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\\\u001a\u0004\u0018\u00010\u000bH\u0086@ø\u0001\u0000¢\u0006\u0006\b¤\u0001\u0010\u0089\u0001J\u001e\u0010¦\u0001\u001a\u000b\u0012\u0005\u0012\u00030¥\u0001\u0018\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0005\b¦\u0001\u0010\u001fJ\u001e\u0010¨\u0001\u001a\u000b\u0012\u0005\u0012\u00030§\u0001\u0018\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0005\b¨\u0001\u0010\u001fJ5\u0010©\u0001\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\u00072\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0005\b©\u0001\u0010_J\u0018\u0010«\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b«\u0001\u0010\u001fJ.\u0010\u00ad\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0007\u0010¬\u0001\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u00ad\u0001\u0010\u001bJ\u001e\u0010¯\u0001\u001a\u000b\u0012\u0005\u0012\u00030®\u0001\u0018\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0005\b¯\u0001\u0010\u001fJ!\u0010²\u0001\u001a\u0005\u0018\u00010±\u00012\u0007\u0010°\u0001\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0005\b²\u0001\u0010\u000fJ \u0010´\u0001\u001a\u0005\u0018\u00010³\u00012\u0006\u0010%\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0005\b´\u0001\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006·\u0001"}, d2 = {"Lcom/huachenjie/mall/api/MallModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/mall/api/MallApi;", "", "pageNum", "orderStatus", "commentStatus", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/base/bean/MyOrderBean;", "O", "(ILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "orderNo", "Lcom/huachenjie/base/bean/mall/OrderDetailBean;", "R", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "goodsCount", "skuNo", "goodsUnitPrice", "addressNo", "Lcom/huachenjie/mall/bean/TradeBaseInfo;", "m", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tradeNo", "cancelReasonType", "", "f", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "w", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "orderItemNo", "Lcom/huachenjie/base/bean/OrderGoodsBean;", "X", "Lcom/alibaba/fastjson/JSONObject;", "d0", "shopNo", "goodsNo", "goodsSkuNo", "goodsPriceTotal", "payPointsTotal", "orderAmount", "postage", o.b, "payPointsUnit", "requestId", "source", "traceNo", "exchangeCode", "Lcom/huachenjie/mall/bean/TradeOrderResult;", "k0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/ApplyRefundRequestBean;", "requestBean", "d", "(Lcom/huachenjie/mall/bean/ApplyRefundRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/MyRefundBean;", "q", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelReason", "e", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/MyRefundDetailBean;", "p", "refundOrderNo", "logisticCoCode", "logisticSid", t.d, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", y6b.g, j.b, "receiverName", "receiverPhone", "provinceCode", "provinceName", "cityCode", "cityName", "districtCode", "districtName", "address", "", "defaultFlag", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "j0", "m0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/WriteReviewRequestBean;", "n0", "(Lcom/huachenjie/mall/bean/WriteReviewRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshTime", "Lcom/huachenjie/mall/bean/CommodityCommentBean;", "L", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CommodityCommentListFragment.EVALUATE, "t", "(Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailBean;", "C", "activityGoodsNo", "E", "squareType", "cooperationNo", "b0", MallItemFragment.NAVIGATION_NO, "catNo", "keyword", "Lcom/huachenjie/mall/external/bean/CommodityBean;", "u", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/MallNavigationBean;", "G", "Lcom/huachenjie/mall/bean/MerchantsBean;", "K", "type", "J", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/OrderReasonListBean;", "Y", "S", ExpressLogisticsActivity.t, "Lcom/huachenjie/mall/bean/ExpressLogisticsOutBean;", "D", "Lcom/huachenjie/mall/bean/ExpressCompanyListBean;", "B", "payType", "Lcom/huachenjie/mall/bean/OrderPayBean;", "n", "orderAddressNo", y6b.f, "P", "c0", "k", "Lcom/huachenjie/mall/external/bean/SelectGoodsBean;", "W", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", "Lcom/huachenjie/mall/bean/MyCourseOrEpisodesBean;", "M", "N", "Lcom/huachenjie/mall/bean/TrySeeVideoBean;", "e0", "currWorksNo", "Lcom/huachenjie/mall/page/test/TestVideoDetailBean;", "g0", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "episodeNo", "Lcom/huachenjie/mall/bean/EpisodeDetailBean;", "x", "Lcom/huachenjie/mall/bean/EpisodeItemBean;", j.o, "episodeItemNo", "f0", "subType", "I", "(ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sort", "", "watchDuration", "i0", "(Ljava/lang/String;Ljava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/RuleCenterBean;", "Z", "Lcom/huachenjie/mall/bean/MallBannerBean;", "F", "Lcom/huachenjie/mall/bean/MallSearchBannerBean;", "H", "a0", "Lcom/huachenjie/mall/bean/OrderCountBean;", "Q", ALPParamConstant.SHOPID, "s", "Lcom/huachenjie/mall/bean/PosterBackgroundBean;", "U", CreatePosterDialog.SHARE_NO, "Lcom/huachenjie/mall/bean/PosterDetailBean;", "V", "Lcom/huachenjie/mall/bean/MallPaySwitchConfig;", "T", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class MallModel extends BaseRepository<MallApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MallModel f34763a = new MallModel();

    public static /* synthetic */ Object A(MallModel mallModel, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return mallModel.z(str, str2, str3, continuation);
    }

    public static /* synthetic */ Object h0(MallModel mallModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return mallModel.g0(i, str, str2, continuation);
    }

    public static /* synthetic */ Object y(MallModel mallModel, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return mallModel.x(str, str2, str3, continuation);
    }

    @Nullable
    public final Object B(@NotNull Continuation<? super ExpressCompanyListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryExpressCompanyList$2(null), continuation);
    }

    @Nullable
    public final Object C(@NotNull String str, @NotNull Continuation<? super GoodsDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryGoodsDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object D(@NotNull String str, @NotNull Continuation<? super ExpressLogisticsOutBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryLogisticTrack$2(str, null), continuation);
    }

    @Nullable
    public final Object E(@NotNull String str, @NotNull Continuation<? super GoodsDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryLotteryGoodsDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object F(@NotNull Continuation<? super PageEntity<MallBannerBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryMallBanner$2(null), continuation);
    }

    @Nullable
    public final Object G(@NotNull Continuation<? super PageEntity<MallNavigationBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryMallNavigation$2(null), continuation);
    }

    @Nullable
    public final Object H(@NotNull Continuation<? super PageEntity<MallSearchBannerBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryMallSearchBanner$2(null), continuation);
    }

    @Nullable
    public final Object I(int i, @NotNull String str, int i2, @NotNull Continuation<? super PageEntity<CommodityBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryMallTypeGoods$2(i, str, i2, null), continuation);
    }

    @Nullable
    public final Object J(@NotNull String str, int i, int i2, @NotNull String str2, @NotNull Continuation<? super PageEntity<CommodityBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryMerchantsCommodityList$2(str, i, i2, str2, null), continuation);
    }

    @Nullable
    public final Object K(@NotNull String str, @NotNull Continuation<? super MerchantsBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryMerchantsDes$2(str, null), continuation);
    }

    @Nullable
    public final Object L(@NotNull String str, int i, @NotNull String str2, @NotNull Continuation<? super PageEntity<CommodityCommentBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryMyCommentList$2(str, i, str2, null), continuation);
    }

    @Nullable
    public final Object M(int i, @NotNull Continuation<? super PageEntity<MyCourseOrEpisodesBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryMyCourseList$2(i, null), continuation);
    }

    @Nullable
    public final Object N(int i, @NotNull Continuation<? super PageEntity<MyCourseOrEpisodesBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryMyEpisodesList$2(i, null), continuation);
    }

    @Nullable
    public final Object O(int i, @Nullable Integer num, @Nullable Integer num2, @NotNull Continuation<? super PageEntity<MyOrderBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryMyOrderList$2(i, num, num2, null), continuation);
    }

    @Nullable
    public final Object P(@NotNull String str, @NotNull Continuation<? super ShippingAddressBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryOrderAddress$2(str, null), continuation);
    }

    @Nullable
    public final Object Q(@NotNull Continuation<? super OrderCountBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryOrderCount$2(null), continuation);
    }

    @Nullable
    public final Object R(@NotNull String str, @NotNull Continuation<? super OrderDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryOrderDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object S(@NotNull Continuation<? super OrderReasonListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryOrderReason$2(null), continuation);
    }

    @Nullable
    public final Object T(@NotNull String str, @NotNull Continuation<? super MallPaySwitchConfig> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryPayChannel$2(str, null), continuation);
    }

    @Nullable
    public final Object U(@NotNull Continuation<? super PageEntity<PosterBackgroundBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryPosterBgList$2(null), continuation);
    }

    @Nullable
    public final Object V(@NotNull String str, @NotNull Continuation<? super PosterDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryPosterDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object W(int i, @NotNull String str, @NotNull Continuation<? super PageEntity<SelectGoodsBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryRecommendGoodList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object X(@NotNull String str, @NotNull Continuation<? super OrderGoodsBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryRefundGoodsInfo$2(str, null), continuation);
    }

    @Nullable
    public final Object Y(@NotNull Continuation<? super OrderReasonListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryRefundReason$2(null), continuation);
    }

    @Nullable
    public final Object Z(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<RuleCenterBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryRuleCenterList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object a0(@NotNull String str, int i, @NotNull String str2, @NotNull Continuation<? super PageEntity<CommodityBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$querySearchMallList$2(str, i, str2, null), continuation);
    }

    @Nullable
    public final Object b0(@NotNull String str, int i, @Nullable String str2, @NotNull Continuation<? super GoodsDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$querySquareGoodsDetail$2(str, i, str2, null), continuation);
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, boolean z, @NotNull Continuation<? super ShippingAddressBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$addAddress$2(str, str2, str3, str4, str5, str6, str7, str8, str9, z, null), continuation);
    }

    @Nullable
    public final Object c0(@NotNull String str, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryTradeProgress$2(str, null), continuation);
    }

    @Nullable
    public final Object d(@NotNull ApplyRefundRequestBean applyRefundRequestBean, @NotNull Continuation<? super JSONObject> continuation) {
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(applyRefundRequestBean);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(requestBean)");
        return BaseRepositoryExtKt.a(this, new MallModel$applyAfterSale$2(companion.create(json, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object d0(@NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryTradeRequestId$2(null), continuation);
    }

    @Nullable
    public final Object e(@NotNull String str, @NotNull String str2, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$cancelAfterSale$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object e0(@NotNull String str, int i, @NotNull Continuation<? super PageEntity<TrySeeVideoBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryTrySeeList$2(str, i, null), continuation);
    }

    @Nullable
    public final Object f(@NotNull String str, int i, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$cancelOrder$2(str, i, null), continuation);
    }

    @Nullable
    public final Object f0(@NotNull String str, @Nullable String str2, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryVideoUrl$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull String str2, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$changeOrderAddress$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object g0(int i, @Nullable String str, @NotNull String str2, @NotNull Continuation<? super PageEntity<TestVideoDetailBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryVideoWorkList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object h(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$changeRefundExpress$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object i(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$confirmReceive$2(str, null), continuation);
    }

    @Nullable
    public final Object i0(@Nullable String str, @NotNull String str2, int i, long j, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$reportWatchedProgress$2(str, str2, i, j, null), continuation);
    }

    @Nullable
    public final Object j(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$deleteAddress$2(str, null), continuation);
    }

    @Nullable
    public final Object j0(@NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$setDefaultAddress$2(str, null), continuation);
    }

    @Nullable
    public final Object k(@NotNull String str, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$encodeGoodsNo$2(str, null), continuation);
    }

    @Nullable
    public final Object k0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i, @NotNull String str5, int i2, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, int i3, @NotNull String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @NotNull Continuation<? super TradeOrderResult> continuation) {
        Map mapMutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("addressNo", str), TuplesKt.to("requestId", str10), TuplesKt.to("postage", str7), TuplesKt.to("goodsPriceTotal", str5), TuplesKt.to("payPointsTotal", Boxing.boxInt(i2)), TuplesKt.to("orderAmount", str6), TuplesKt.to("goodsInfo", MapsKt.mapOf(new Pair[]{TuplesKt.to("shopNo", str2), TuplesKt.to("goodsCount", Boxing.boxInt(i)), TuplesKt.to("goodsNo", str3), TuplesKt.to("skuNo", str4), TuplesKt.to(o.b, str8), TuplesKt.to("goodsUnitPrice", str9), TuplesKt.to("payPointsUnit", Boxing.boxInt(i3))}))});
        if (!TextUtils.isEmpty(str11) || !TextUtils.isEmpty(str12)) {
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("source", str11 == null ? "" : str11);
            pairArr[1] = TuplesKt.to("traceNo", str12 != null ? str12 : "");
            mapMutableMapOf.put("bizSource", MapsKt.mapOf(pairArr));
        }
        if (!(str13 == null || str13.length() == 0)) {
            mapMutableMapOf.put("exchangeCode", str13);
        }
        String jSONString = JSON.toJSONString(mapMutableMapOf);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new MallModel$submitTradeOrder$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object l(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$fillRefundExpress$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object m(int i, @NotNull String str, @NotNull String str2, @Nullable String str3, @NotNull Continuation<? super TradeBaseInfo> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$getTradeBaseInfo$2(i, str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object m0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, boolean z, @NotNull String str10, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$updateAddress$2(str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10, null), continuation);
    }

    @Nullable
    public final Object n(@NotNull String str, int i, @NotNull Continuation<? super OrderPayBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$orderTradePay$2(str, i, null), continuation);
    }

    @Nullable
    public final Object n0(@NotNull WriteReviewRequestBean writeReviewRequestBean, @NotNull Continuation<? super Boolean> continuation) {
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(writeReviewRequestBean);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(requestBean)");
        return BaseRepositoryExtKt.a(this, new MallModel$writeReview$2(companion.create(json, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object o(int i, @NotNull Continuation<? super PageEntity<ShippingAddressBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryAddressList$2(i, null), continuation);
    }

    @Nullable
    public final Object p(@NotNull String str, @NotNull Continuation<? super MyRefundDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryAfterSaleDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object q(int i, @NotNull Continuation<? super PageEntity<MyRefundBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryAfterSaleList$2(i, null), continuation);
    }

    @Nullable
    public final Object r(int i, @NotNull String str, @NotNull Continuation<? super PageEntity<SelectGoodsBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryBoughtGoodList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object s(@NotNull String str, int i, @NotNull Continuation<? super PageEntity<MyOrderBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryChooseShopOrderList$2(str, i, null), continuation);
    }

    @Nullable
    public final Object t(@NotNull String str, @Nullable Integer num, int i, @NotNull String str2, @NotNull Continuation<? super PageEntity<CommodityCommentBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryCommodityCommentList$2(str, num, i, str2, null), continuation);
    }

    @Nullable
    public final Object u(int i, @NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Continuation<? super PageEntity<CommodityBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryCommodityList$2(i, str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object w(@NotNull Continuation<? super ShippingAddressBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryDefaultAddress$2(null), continuation);
    }

    @Nullable
    public final Object x(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull Continuation<? super EpisodeDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryEpisodeDetail$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object z(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull Continuation<? super PageEntity<EpisodeItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new MallModel$queryEpisodeItemPage$2(str, str2, str3, null), continuation);
    }
}
