package com.huachenjie.mall.api;

import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.common.bean.BaseEntity;
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
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JM\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00072\b\b\u0001\u0010\r\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0001\u0010\u0011\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0001\u0010\r\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0010JE\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00072\b\b\u0001\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\u0018\u001a\u00020\f2\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\fH§@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u00072\b\b\u0001\u0010\u001d\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0010J\u001b\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u0007H§@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0007H§@ø\u0001\u0000¢\u0006\u0004\b$\u0010\"J%\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u00072\b\b\u0001\u0010&\u001a\u00020%H§@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J%\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u00072\b\b\u0001\u0010&\u001a\u00020%H§@ø\u0001\u0000¢\u0006\u0004\b*\u0010)J5\u0010,\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020+\u0018\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J/\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0001\u0010.\u001a\u00020\f2\b\b\u0001\u0010/\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\b0\u00101J%\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u00072\b\b\u0001\u0010.\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0010J9\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0001\u0010.\u001a\u00020\f2\b\b\u0001\u00104\u001a\u00020\f2\b\b\u0001\u00105\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\b6\u00107J9\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0001\u0010.\u001a\u00020\f2\b\b\u0001\u00104\u001a\u00020\f2\b\b\u0001\u00105\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\b8\u00107J5\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b9\u0010-J\u007f\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u00072\b\b\u0001\u0010:\u001a\u00020\f2\b\b\u0001\u0010;\u001a\u00020\f2\b\b\u0001\u0010<\u001a\u00020\f2\b\b\u0001\u0010=\u001a\u00020\f2\b\b\u0001\u0010>\u001a\u00020\f2\b\b\u0001\u0010?\u001a\u00020\f2\b\b\u0001\u0010@\u001a\u00020\f2\b\b\u0001\u0010A\u001a\u00020\f2\b\b\u0001\u0010B\u001a\u00020\f2\b\b\u0001\u0010D\u001a\u00020CH§@ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ%\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0\u00072\b\b\u0001\u0010\u0019\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\bG\u0010\u0010J%\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0\u00072\b\b\u0001\u0010\u0019\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\bH\u0010\u0010J\u0089\u0001\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0001\u0010:\u001a\u00020\f2\b\b\u0001\u0010;\u001a\u00020\f2\b\b\u0001\u0010<\u001a\u00020\f2\b\b\u0001\u0010=\u001a\u00020\f2\b\b\u0001\u0010>\u001a\u00020\f2\b\b\u0001\u0010?\u001a\u00020\f2\b\b\u0001\u0010@\u001a\u00020\f2\b\b\u0001\u0010A\u001a\u00020\f2\b\b\u0001\u0010B\u001a\u00020\f2\b\b\u0001\u0010D\u001a\u00020C2\b\b\u0001\u0010\u0019\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ%\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0\u00072\b\b\u0001\u0010&\u001a\u00020%H§@ø\u0001\u0000¢\u0006\u0004\bK\u0010)JI\u0010N\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020M\u0018\u00010\b0\u00072\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010L\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bN\u0010OJU\u0010R\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020M\u0018\u00010\b0\u00072\b\b\u0001\u0010P\u001a\u00020\f2\n\b\u0001\u0010Q\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010L\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bR\u0010SJc\u0010X\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020W\u0018\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010L\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010T\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010U\u001a\u0004\u0018\u00010\f2\n\b\u0001\u0010V\u001a\u0004\u0018\u00010\fH§@ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ!\u0010[\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020Z\u0018\u00010\b0\u0007H§@ø\u0001\u0000¢\u0006\u0004\b[\u0010\"J%\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010]0\u00072\b\b\u0001\u0010\\\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\b^\u0010\u0010JS\u0010`\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020W\u0018\u00010\b0\u00072\b\b\u0001\u0010\\\u001a\u00020\f2\b\b\u0001\u0010_\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010L\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b`\u0010aJ\u001b\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010b0\u0007H§@ø\u0001\u0000¢\u0006\u0004\bc\u0010\"J\u001b\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010b0\u0007H§@ø\u0001\u0000¢\u0006\u0004\bd\u0010\"J#\u0010f\u001a\b\u0012\u0004\u0012\u00020e0\u00072\b\b\u0001\u0010P\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\bf\u0010\u0010J#\u0010h\u001a\b\u0012\u0004\u0012\u00020e0\u00072\b\b\u0001\u0010g\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\bh\u0010\u0010J9\u0010k\u001a\b\u0012\u0004\u0012\u00020e0\u00072\b\b\u0001\u0010P\u001a\u00020\f2\b\b\u0001\u0010i\u001a\u00020\u00022\n\b\u0001\u0010j\u001a\u0004\u0018\u00010\fH§@ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ%\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010n0\u00072\b\b\u0001\u0010m\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\bo\u0010\u0010J\u001b\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010p0\u0007H§@ø\u0001\u0000¢\u0006\u0004\bq\u0010\"J/\u0010t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010s0\u00072\b\b\u0001\u0010\u0011\u001a\u00020\f2\b\b\u0001\u0010r\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bt\u0010\u0014J/\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\b\b\u0001\u0010u\u001a\u00020\f2\b\b\u0001\u0010\u0019\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\bv\u00101J%\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u00072\b\b\u0001\u0010\r\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\bw\u0010\u0010J%\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u00072\b\b\u0001\u0010\u0011\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\bx\u0010\u0010J%\u0010y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u00072\b\b\u0001\u0010P\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0004\by\u0010\u0010J?\u0010{\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020z\u0018\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010L\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b{\u0010|J?\u0010}\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020z\u0018\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010L\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b}\u0010|J5\u0010\u007f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020~\u0018\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u007f\u0010-J7\u0010\u0080\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020~\u0018\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u0080\u0001\u0010-JC\u0010\u0082\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010\b0\u00072\b\b\u0001\u0010P\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001JN\u0010\u0086\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0085\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0003\u0010L\u001a\u0004\u0018\u00010\f2\t\b\u0001\u0010\u0084\u0001\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001JA\u0010\u008a\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010\u00072\u000b\b\u0003\u0010\u0088\u0001\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\fH§@ø\u0001\u0000¢\u0006\u0005\b\u008a\u0001\u00107J]\u0010\u008d\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008c\u00010\b0\u00072\u000b\b\u0003\u0010\u0088\u0001\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\f2\t\b\u0001\u0010\u008b\u0001\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J2\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020#0\u00072\t\b\u0001\u0010\u008f\u0001\u001a\u00020\f2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\fH§@ø\u0001\u0000¢\u0006\u0005\b\u0090\u0001\u00101JM\u0010\u0092\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020W\u0018\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010L\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u00022\t\b\u0001\u0010\u0091\u0001\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001JL\u0010\u0097\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\f2\t\b\u0001\u0010\u008f\u0001\u001a\u00020\f2\t\b\u0001\u0010\u0094\u0001\u001a\u00020\u00022\n\b\u0001\u0010\u0096\u0001\u001a\u00030\u0095\u0001H§@ø\u0001\u0000¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001JD\u0010\u009a\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030\u0099\u0001\u0018\u00010\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010L\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u009a\u0001\u0010|J$\u0010\u009c\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030\u009b\u0001\u0018\u00010\b0\u0007H§@ø\u0001\u0000¢\u0006\u0005\b\u009c\u0001\u0010\"J$\u0010\u009e\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030\u009d\u0001\u0018\u00010\b0\u0007H§@ø\u0001\u0000¢\u0006\u0005\b\u009e\u0001\u0010\"JK\u0010\u009f\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020W\u0018\u00010\b0\u00072\b\b\u0001\u0010V\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010L\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u009f\u0001\u0010OJ\u001e\u0010¡\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010 \u00010\u0007H§@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010\"JB\u0010¢\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\b\b\u0001\u0010\\\u001a\u00020\f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0006\b¢\u0001\u0010\u0083\u0001J$\u0010¤\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030£\u0001\u0018\u00010\b0\u0007H§@ø\u0001\u0000¢\u0006\u0005\b¤\u0001\u0010\"J)\u0010§\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010¦\u00010\u00072\t\b\u0001\u0010¥\u0001\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0005\b§\u0001\u0010\u0010J(\u0010©\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010¨\u00010\u00072\b\b\u0001\u0010\\\u001a\u00020\fH§@ø\u0001\u0000¢\u0006\u0005\b©\u0001\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006ª\u0001"}, d2 = {"Lcom/huachenjie/mall/api/MallApi;", "", "", "pageNum", "pageSize", "orderStatus", "commentStatus", "Lcom/huachenjie/common/bean/BaseEntity;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/base/bean/MyOrderBean;", "M", "(IILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "orderNo", "Lcom/huachenjie/base/bean/mall/OrderDetailBean;", "Z", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tradeNo", "cancelReasonType", "U", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w", "goodsCount", "skuNo", "goodsUnitPrice", "addressNo", "Lcom/huachenjie/mall/bean/TradeBaseInfo;", "i0", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "orderItemNo", "Lcom/huachenjie/base/bean/OrderGoodsBean;", y6b.g, "Lcom/huachenjie/base/bean/mall/ShippingAddressBean;", "v", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/alibaba/fastjson/JSONObject;", "G", "Lokhttp3/RequestBody;", "body", "Lcom/huachenjie/mall/bean/TradeOrderResult;", "d", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "O", "Lcom/huachenjie/mall/bean/MyRefundBean;", "J", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refundOrderNo", "cancelReason", "y", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/MyRefundDetailBean;", "s", "logisticCoCode", "logisticSid", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e0", "C", "receiverName", "receiverPhone", "provinceCode", "provinceName", "cityCode", "cityName", "districtCode", "districtName", "address", "", "defaultFlag", "B", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "p", "h0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "I", "refreshTime", "Lcom/huachenjie/mall/bean/CommodityCommentBean;", "Q", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "goodsNo", CommodityCommentListFragment.EVALUATE, "R", "(Ljava/lang/String;Ljava/lang/Integer;ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", MallItemFragment.NAVIGATION_NO, "catNo", "keyword", "Lcom/huachenjie/mall/external/bean/CommodityBean;", "H", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/MallNavigationBean;", "S", "shopNo", "Lcom/huachenjie/mall/bean/MerchantsBean;", "q", "type", "K", "(Ljava/lang/String;IILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/OrderReasonListBean;", "N", "e", "Lcom/huachenjie/mall/bean/goods_detail/GoodsDetailBean;", "g0", "activityGoodsNo", "F", "squareType", "cooperationNo", j.o, "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExpressLogisticsActivity.t, "Lcom/huachenjie/mall/bean/ExpressLogisticsOutBean;", "V", "Lcom/huachenjie/mall/bean/ExpressCompanyListBean;", "c0", "payType", "Lcom/huachenjie/mall/bean/OrderPayBean;", y6b.f, "orderAddressNo", "i", "t", "j", "A", "Lcom/huachenjie/mall/external/bean/SelectGoodsBean;", "L", "(ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f0", "Lcom/huachenjie/mall/bean/MyCourseOrEpisodesBean;", "X", j.b, "Lcom/huachenjie/mall/bean/TrySeeVideoBean;", "d0", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currWorksNo", "Lcom/huachenjie/mall/page/test/TestVideoDetailBean;", "c", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "episodeNo", "Lcom/huachenjie/mall/bean/EpisodeDetailBean;", "E", "pageNo", "Lcom/huachenjie/mall/bean/EpisodeItemBean;", "a0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "episodeItemNo", "b0", "subType", "r", "(ILjava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sort", "", "watchDuration", "W", "(Ljava/lang/String;Ljava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/mall/bean/RuleCenterBean;", "n", "Lcom/huachenjie/mall/bean/MallBannerBean;", "D", "Lcom/huachenjie/mall/bean/MallSearchBannerBean;", "k", "P", "Lcom/huachenjie/mall/bean/OrderCountBean;", "Y", "f", "Lcom/huachenjie/mall/bean/PosterBackgroundBean;", t.d, CreatePosterDialog.SHARE_NO, "Lcom/huachenjie/mall/bean/PosterDetailBean;", "u", "Lcom/huachenjie/mall/bean/MallPaySwitchConfig;", "x", "mall_release"}, k = 1, mv = {1, 8, 0})
public interface MallApi {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ Object a(MallApi mallApi, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryEpisodeDetail");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return mallApi.E(str, str2, str3, continuation);
        }

        public static /* synthetic */ Object b(MallApi mallApi, String str, String str2, String str3, int i, int i2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return mallApi.a0((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, i, i2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryEpisodeItemPage");
        }

        public static /* synthetic */ Object c(MallApi mallApi, String str, String str2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryVideoUrl");
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return mallApi.b0(str, str2, continuation);
        }

        public static /* synthetic */ Object d(MallApi mallApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryVideoWorkList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return mallApi.c(i, i2, str, str2, continuation);
        }
    }

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/share")
    @Nullable
    Object A(@Field("goodsNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/user/address/save")
    @Nullable
    Object B(@Field("receiverName") @NotNull String str, @Field("receiverPhone") @NotNull String str2, @Field("provinceCode") @NotNull String str3, @Field("provinceName") @NotNull String str4, @Field("cityCode") @NotNull String str5, @Field("cityName") @NotNull String str6, @Field("districtCode") @NotNull String str7, @Field("districtName") @NotNull String str8, @Field("address") @NotNull String str9, @Field("defaultFlag") boolean z, @NotNull Continuation<? super BaseEntity<ShippingAddressBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/user/address/list")
    @Nullable
    Object C(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<ShippingAddressBean>>> continuation);

    @POST("run-front/api/mall/basic/banner/list")
    @Nullable
    Object D(@NotNull Continuation<? super BaseEntity<PageEntity<MallBannerBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/episode/detail")
    @Nullable
    Object E(@Field("episodeNo") @Nullable String str, @Field("orderItemNo") @Nullable String str2, @Field("skuNo") @Nullable String str3, @NotNull Continuation<? super BaseEntity<EpisodeDetailBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/app/lottery/detail")
    @Nullable
    Object F(@Field("activityGoodsNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<GoodsDetailBean>> continuation);

    @POST("run-front/api/trade/requestId")
    @Nullable
    Object G(@NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/page")
    @Nullable
    Object H(@Field("pageNum") int i, @Field("refreshTime") @NotNull String str, @Field("pageSize") int i2, @Field(MallItemFragment.NAVIGATION_NO) @Nullable String str2, @Field("catNo") @Nullable String str3, @Field("keyword") @Nullable String str4, @NotNull Continuation<? super BaseEntity<PageEntity<CommodityBean>>> continuation);

    @POST("run-front/api/trade/comment")
    @Nullable
    Object I(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Boolean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/afterSale/list")
    @Nullable
    Object J(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<MyRefundBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/shop/page")
    @Nullable
    Object K(@Field("shopNo") @NotNull String str, @Field("type") int i, @Field("pageNum") int i2, @Field("refreshTime") @NotNull String str2, @Field("pageSize") int i3, @NotNull Continuation<? super BaseEntity<PageEntity<CommodityBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/recommend/page/list")
    @Nullable
    Object L(@Field("pageNum") int i, @Field("refreshTime") @NotNull String str, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<SelectGoodsBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/order/list")
    @Nullable
    Object M(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("orderStatus") @Nullable Integer num, @Field("commentStatus") @Nullable Integer num2, @NotNull Continuation<? super BaseEntity<PageEntity<MyOrderBean>>> continuation);

    @POST("run-front/api/trade/afterSale/applyReason")
    @Nullable
    Object N(@NotNull Continuation<? super BaseEntity<OrderReasonListBean>> continuation);

    @POST("run-front/api/trade/afterSale/apply")
    @Nullable
    Object O(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/page/search")
    @Nullable
    Object P(@Field("keyword") @NotNull String str, @Field("pageNum") int i, @Field("refreshTime") @NotNull String str2, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<CommodityBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/comment/list")
    @Nullable
    Object Q(@Field("orderNo") @NotNull String str, @Field("pageNum") int i, @Field("refreshTime") @NotNull String str2, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<CommodityCommentBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/goods/comment/list")
    @Nullable
    Object R(@Field("goodsNo") @NotNull String str, @Field(CommodityCommentListFragment.EVALUATE) @Nullable Integer num, @Field("pageNum") int i, @Field("refreshTime") @NotNull String str2, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<CommodityCommentBean>>> continuation);

    @POST("run-front/api/mall/goods/navigation")
    @Nullable
    Object S(@NotNull Continuation<? super BaseEntity<PageEntity<MallNavigationBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/user/address/del")
    @Nullable
    Object T(@Field("addressNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Boolean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/cancel")
    @Nullable
    Object U(@Field("tradeNo") @NotNull String str, @Field("cancelReasonType") int i, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/logistic/trace")
    @Nullable
    Object V(@Field(ExpressLogisticsActivity.t) @NotNull String str, @NotNull Continuation<? super BaseEntity<ExpressLogisticsOutBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/order/watched/progress")
    @Nullable
    Object W(@Field("orderItemNo") @Nullable String str, @Field("episodeItemNo") @NotNull String str2, @Field("sort") int i, @Field("watchDuration") long j, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/order/course/list")
    @Nullable
    Object X(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<MyCourseOrEpisodesBean>>> continuation);

    @POST("run-front/api/trade/order/count")
    @Nullable
    Object Y(@NotNull Continuation<? super BaseEntity<OrderCountBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/details")
    @Nullable
    Object Z(@Field("orderNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<OrderDetailBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/episode/item/page")
    @Nullable
    Object a0(@Field("episodeNo") @Nullable String str, @Field("orderItemNo") @Nullable String str2, @Field("skuNo") @Nullable String str3, @Field("pageNo") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<EpisodeItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/episode/item/videoUrl")
    @Nullable
    Object b0(@Field("episodeItemNo") @NotNull String str, @Field("orderItemNo") @Nullable String str2, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/video/list")
    @Nullable
    Object c(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("currWorksNo") @NotNull String str2, @NotNull Continuation<? super BaseEntity<PageEntity<TestVideoDetailBean>>> continuation);

    @POST("run-front/api/mall/logistic/company/nameSearch")
    @Nullable
    Object c0(@NotNull Continuation<? super BaseEntity<ExpressCompanyListBean>> continuation);

    @POST("run-front/api/trade/order/submit")
    @Nullable
    Object d(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<TradeOrderResult>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/episode/page")
    @Nullable
    Object d0(@Field("goodsNo") @NotNull String str, @Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<TrySeeVideoBean>>> continuation);

    @POST("run-front/api/trade/cancelReason")
    @Nullable
    Object e(@NotNull Continuation<? super BaseEntity<OrderReasonListBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/afterSale/returnLogistic/update")
    @Nullable
    Object e0(@Field("refundOrderNo") @NotNull String str, @Field("logisticCoCode") @NotNull String str2, @Field("logisticSid") @NotNull String str3, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/message/order/list")
    @Nullable
    Object f(@Field("shopNo") @NotNull String str, @Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<MyOrderBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/purchased/goods/page/list")
    @Nullable
    Object f0(@Field("pageNum") int i, @Field("refreshTime") @NotNull String str, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<SelectGoodsBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/pay")
    @Nullable
    Object g(@Field("tradeNo") @NotNull String str, @Field("payType") int i, @NotNull Continuation<? super BaseEntity<OrderPayBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/app/detail")
    @Nullable
    Object g0(@Field("goodsNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<GoodsDetailBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/aftersale/goodsInfo")
    @Nullable
    Object h(@Field("orderItemNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<OrderGoodsBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/user/address/update")
    @Nullable
    Object h0(@Field("receiverName") @NotNull String str, @Field("receiverPhone") @NotNull String str2, @Field("provinceCode") @NotNull String str3, @Field("provinceName") @NotNull String str4, @Field("cityCode") @NotNull String str5, @Field("cityName") @NotNull String str6, @Field("districtCode") @NotNull String str7, @Field("districtName") @NotNull String str8, @Field("address") @NotNull String str9, @Field("defaultFlag") boolean z, @Field("addressNo") @NotNull String str10, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/receiveAddress/change")
    @Nullable
    Object i(@Field("orderAddressNo") @NotNull String str, @Field("addressNo") @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/goods/baseInfo")
    @Nullable
    Object i0(@Field("goodsCount") int i, @Field("skuNo") @NotNull String str, @Field("goodsUnitPrice") @NotNull String str2, @Field("addressNo") @Nullable String str3, @NotNull Continuation<? super BaseEntity<TradeBaseInfo>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/payment/progress")
    @Nullable
    Object j(@Field("tradeNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @POST("run-front/api/mall/goods/search/preset/list")
    @Nullable
    Object k(@NotNull Continuation<? super BaseEntity<PageEntity<MallSearchBannerBean>>> continuation);

    @POST("run-front/api/mall/goods/share/poster/list")
    @Nullable
    Object l(@NotNull Continuation<? super BaseEntity<PageEntity<PosterBackgroundBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/afterSale/returnLogistic/submit")
    @Nullable
    Object m(@Field("refundOrderNo") @NotNull String str, @Field("logisticCoCode") @NotNull String str2, @Field("logisticSid") @NotNull String str3, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/basic/board/page")
    @Nullable
    Object n(@Field("pageNum") int i, @Field("refreshTime") @Nullable String str, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<RuleCenterBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/order/episodes/list")
    @Nullable
    Object o(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<MyCourseOrEpisodesBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/user/address/updateDefault")
    @Nullable
    Object p(@Field("addressNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Boolean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/shop/score")
    @Nullable
    Object q(@Field("shopNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<MerchantsBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/pageForType")
    @Nullable
    Object r(@Field("pageNum") int i, @Field("refreshTime") @NotNull String str, @Field("pageSize") int i2, @Field("subType") int i3, @NotNull Continuation<? super BaseEntity<PageEntity<CommodityBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/afterSale/details")
    @Nullable
    Object s(@Field("refundOrderNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<MyRefundDetailBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/order/address")
    @Nullable
    Object t(@Field("orderNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<ShippingAddressBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/share/getPosterDetail")
    @Nullable
    Object u(@Field(CreatePosterDialog.SHARE_NO) @NotNull String str, @NotNull Continuation<? super BaseEntity<PosterDetailBean>> continuation);

    @POST("run-front/api/user/address/default")
    @Nullable
    Object v(@NotNull Continuation<? super BaseEntity<ShippingAddressBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/received")
    @Nullable
    Object w(@Field("orderNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/goods/shop/pay/channel")
    @Nullable
    Object x(@Field("shopNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<MallPaySwitchConfig>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/trade/afterSale/cancel")
    @Nullable
    Object y(@Field("refundOrderNo") @NotNull String str, @Field("cancelReason") @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/mall/commerce/square/goods/detail")
    @Nullable
    Object z(@Field("goodsNo") @NotNull String str, @Field("squareType") int i, @Field("cooperationNo") @Nullable String str2, @NotNull Continuation<? super BaseEntity<GoodsDetailBean>> continuation);
}
