package com.huachenjie.works.api;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.gson.Gson;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
import com.huachenjie.works.bean.BroadcastFloorBean;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.huachenjie.works.bean.BroadcastFloorMessageImageBean;
import com.huachenjie.works.bean.BroadcastFloorMessageVoiceBean;
import com.huachenjie.works.bean.BuddyCardBean;
import com.huachenjie.works.bean.ChannelTabBean;
import com.huachenjie.works.bean.ChatGroupBean;
import com.huachenjie.works.bean.CreateTopicResultBean;
import com.huachenjie.works.bean.GoodStuffBean;
import com.huachenjie.works.bean.GoodStuffTabData;
import com.huachenjie.works.bean.MultipleActivityData;
import com.huachenjie.works.bean.OfficialActivityBean;
import com.huachenjie.works.bean.OperatorCheckBean;
import com.huachenjie.works.bean.OriginalCategoryListBean;
import com.huachenjie.works.bean.OriginalPageEntity;
import com.huachenjie.works.bean.PostCategoryBean;
import com.huachenjie.works.bean.PostCategoryDataBean;
import com.huachenjie.works.bean.PostDetailBean;
import com.huachenjie.works.bean.PostItemBean;
import com.huachenjie.works.bean.PostedSchoolBean;
import com.huachenjie.works.bean.PublishPostRequestBean;
import com.huachenjie.works.bean.RecommendWorksBean;
import com.huachenjie.works.bean.SchoolMateBean;
import com.huachenjie.works.bean.SchoolmateConfigBean;
import com.huachenjie.works.bean.ThisSchoolBean;
import com.huachenjie.works.bean.ValidWorks;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.bean.WorksTagBean;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentImageBean;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.bean.dorm.DormEnergyBean;
import com.huachenjie.works.bean.dorm.DormExchangeBean;
import com.huachenjie.works.bean.dorm.DormUserInfoBean;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.huachenjie.works.bean.publish.PubWorkTopicBean;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.bean.publish.PubWorksRequestIdBean;
import com.huachenjie.works.bean.publish.PublishWorksBean;
import com.huachenjie.works.bean.search.SearchHotSpotBean;
import com.huachenjie.works.external.bean.ChannelBean;
import com.huachenjie.works.external.bean.CommentOnMeBean;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huachenjie.works.page.activity.ActivityListActivity;
import com.kuaishou.weapon.p0.bo;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0080\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J-\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJG\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\r2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013JG\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0010J\u001d\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001a\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010 \u001a\u0004\u0018\u00010\u001fH\u0086@ø\u0001\u0000¢\u0006\u0004\b \u0010!JS\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J;\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b'\u0010(JS\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b,\u0010&J;\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b/\u0010(J#\u00103\u001a\u0002022\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b3\u00104J#\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b6\u0010\u001dJ7\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b8\u0010(J7\u00109\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b9\u0010(J?\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b<\u0010=J?\u0010>\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b>\u0010=J?\u0010D\u001a\u0004\u0018\u0001072\u0006\u0010?\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010BH\u0086@ø\u0001\u0000¢\u0006\u0004\bD\u0010EJ?\u0010G\u001a\u0004\u0018\u0001072\u0006\u0010?\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00052\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010BH\u0086@ø\u0001\u0000¢\u0006\u0004\bG\u0010EJG\u0010I\u001a\u0004\u0018\u00010;2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010BH\u0086@ø\u0001\u0000¢\u0006\u0004\bI\u0010JJG\u0010K\u001a\u0004\u0018\u00010;2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010BH\u0086@ø\u0001\u0000¢\u0006\u0004\bK\u0010JJ\u001b\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\bM\u0010!J#\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\u00072\u0006\u0010N\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bP\u0010\u001dJ/\u0010Q\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bQ\u0010\nJO\u0010U\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010R\u001a\u00020\u00052\b\b\u0002\u0010S\u001a\u00020\u00032\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ\u001d\u0010Y\u001a\u0004\u0018\u00010X2\u0006\u0010W\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ/\u0010\\\u001a\n\u0012\u0004\u0012\u00020[\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\\\u0010\nJ#\u0010]\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b]\u0010\u001dJ+\u0010^\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b^\u0010\nJ\u001b\u0010`\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b`\u0010!J\u001d\u0010c\u001a\u0004\u0018\u00010b2\u0006\u0010a\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bc\u0010\u001dJ\u001d\u0010e\u001a\u0004\u0018\u00010d2\u0006\u0010W\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\be\u0010ZJ?\u0010k\u001a\u0004\u0018\u00010j2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u00052\b\u0010i\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ\u001d\u0010m\u001a\u0004\u0018\u00010j2\u0006\u0010\u001a\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bm\u0010\u001dJ7\u0010o\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010n\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bo\u0010(J)\u0010q\u001a\u0004\u0018\u00010j2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010p\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\bq\u0010rJ\u0015\u0010t\u001a\u0004\u0018\u00010sH\u0086@ø\u0001\u0000¢\u0006\u0004\bt\u0010!J\u001d\u0010v\u001a\u0004\u0018\u00010u2\u0006\u0010:\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bv\u0010\u001dJ\u001d\u0010w\u001a\u0004\u0018\u00010u2\u0006\u0010:\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bw\u0010\u001dJ\u0015\u0010y\u001a\u0004\u0018\u00010xH\u0086@ø\u0001\u0000¢\u0006\u0004\by\u0010!J3\u0010|\u001a\n\u0012\u0004\u0012\u00020{\u0018\u00010\u00072\u0006\u0010z\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b|\u0010}J3\u0010~\u001a\n\u0012\u0004\u0012\u00020{\u0018\u00010\u00072\u0006\u0010z\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b~\u0010}JA\u0010\u0083\u0001\u001a\u0004\u0018\u00010j2\b\u0010?\u001a\u0004\u0018\u00010\u00052\b\u0010C\u001a\u0004\u0018\u00010\u007f2\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0007\u0010\u0082\u0001\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0017\u0010\u0085\u0001\u001a\u0004\u0018\u00010uH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0085\u0001\u0010!J\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010{2\u0006\u0010F\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0086\u0001\u0010\u001dJ\u0018\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0088\u0001\u0010!J5\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u008b\u0001\u0010\u0013J \u0010\u008d\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010\u008c\u0001\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u008d\u0001\u0010ZJ#\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00012\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0090\u0001\u0010\u001dJ \u0010\u0092\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010\u0091\u0001\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0092\u0001\u0010\u001dJ\u0018\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0094\u0001\u0010!J'\u0010\u0097\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0096\u0001\u0018\u00010\u00072\u0007\u0010\u0095\u0001\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0097\u0001\u0010\u001dJW\u0010\u009b\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u009a\u0001\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u009b\u0001\u0010&J=\u0010\u009c\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u009a\u0001\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u009c\u0001\u0010(J!\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u009f\u0001\u0010\u001dJ\u0017\u0010 \u0001\u001a\u0004\u0018\u00010sH\u0086@ø\u0001\u0000¢\u0006\u0005\b \u0001\u0010!J\"\u0010£\u0001\u001a\u0004\u0018\u00010u2\b\u0010¢\u0001\u001a\u00030¡\u0001H\u0086@ø\u0001\u0000¢\u0006\u0006\b£\u0001\u0010¤\u0001J:\u0010¦\u0001\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0007\u0010¥\u0001\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b¦\u0001\u0010(JB\u0010§\u0001\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0007\u0010¥\u0001\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b§\u0001\u0010=JB\u0010¨\u0001\u001a\u0004\u0018\u0001072\u0006\u0010?\u001a\u00020\u00052\u0007\u0010¥\u0001\u001a\u00020\u00052\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010BH\u0086@ø\u0001\u0000¢\u0006\u0005\b¨\u0001\u0010EJJ\u0010©\u0001\u001a\u0004\u0018\u00010;2\u0006\u0010?\u001a\u00020\u00052\u0007\u0010¥\u0001\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00052\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010BH\u0086@ø\u0001\u0000¢\u0006\u0005\b©\u0001\u0010JJ\u001f\u0010ª\u0001\u001a\u0004\u0018\u00010u2\u0006\u0010:\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\bª\u0001\u0010\u001dJ \u0010«\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010\u009d\u0001\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b«\u0001\u0010\u001dJ \u0010¬\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010\u009d\u0001\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b¬\u0001\u0010\u001dJD\u0010\u00ad\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010\u009d\u0001\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u00052\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u00ad\u0001\u0010lJ\u001f\u0010®\u0001\u001a\u0004\u0018\u00010j2\u0006\u0010\"\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b®\u0001\u0010\u001dJ\u0018\u0010°\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b°\u0001\u0010!J\u001e\u0010²\u0001\u001a\u000b\u0012\u0005\u0012\u00030±\u0001\u0018\u00010\u0007H\u0086@ø\u0001\u0000¢\u0006\u0005\b²\u0001\u0010!J\u0018\u0010´\u0001\u001a\u0005\u0018\u00010³\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b´\u0001\u0010!JA\u0010¹\u0001\u001a\u000b\u0012\u0005\u0012\u00030¸\u0001\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0007\u0010µ\u0001\u001a\u00020\u00052\u0007\u0010¶\u0001\u001a\u00020\u00052\u0007\u0010·\u0001\u001a\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0005\b¹\u0001\u0010=J\u0018\u0010»\u0001\u001a\u0005\u0018\u00010º\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b»\u0001\u0010!J\u0018\u0010½\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b½\u0001\u0010!J\u0018\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b¿\u0001\u0010!J*\u0010Â\u0001\u001a\u0004\u0018\u00010j2\u0007\u0010À\u0001\u001a\u00020\u00052\u0007\u0010Á\u0001\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u0018\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\bÅ\u0001\u0010!J'\u0010Ç\u0001\u001a\u0004\u0018\u00010j2\r\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050@H\u0086@ø\u0001\u0000¢\u0006\u0006\bÇ\u0001\u0010È\u0001J`\u0010Ì\u0001\u001a\u000b\u0012\u0005\u0012\u00030Ë\u0001\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010É\u0001\u001a\u0004\u0018\u00010\u00052\u000b\b\u0002\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00052\u0011\b\u0002\u0010Æ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010@H\u0086@ø\u0001\u0000¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u0017\u0010Î\u0001\u001a\u0004\u0018\u00010jH\u0086@ø\u0001\u0000¢\u0006\u0005\bÎ\u0001\u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006Ñ\u0001"}, d2 = {"Lcom/huachenjie/works/api/RequestModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/works/api/WorksApi;", "", "pageNum", "", "refreshTime", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/works/bean/WorkDetailBean;", j.o, "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyword", "type", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;", "l0", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/bean/publish/PubWorkTopicBean;", "n0", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/base/bean/UserInfoBean;", "B0", "Lcom/huachenjie/works/bean/publish/PublishWorksBean;", "worksBean", "v", "(Lcom/huachenjie/works/bean/publish/PublishWorksBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", yj7.g.WORKS_NO, "Lcom/huachenjie/works/bean/ValidWorks;", "X0", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "K0", "Lcom/huachenjie/works/bean/search/SearchHotSpotBean;", "A0", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelNo", yj7.b.SUBJECT_NO, "Lcom/huachenjie/works/external/bean/WorkItemBean;", "R0", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P0", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelClassificationNo", "channelNumber", "Lcom/huachenjie/works/external/bean/ChannelBean;", "F", "title", "Lcom/huachenjie/works/bean/BuddyCardBean;", "D", "buddyCode", "applyMessage", "", "c", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/bean/ChatGroupBean;", "G0", "Lcom/huachenjie/works/bean/comment/CommentBean;", "K", "M", "commentNo", "Lcom/huachenjie/works/bean/comment/CommentReplyBean;", "Q", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "O", "content", "", "atUserList", "Lcom/huachenjie/works/bean/comment/CommentImageBean;", "image", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/huachenjie/works/bean/comment/CommentImageBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", yj7.g.BROADCAST_QUOTE_NO, "t", "targetCommentNo", j.b, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/huachenjie/works/bean/comment/CommentImageBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "u", "Lcom/huachenjie/works/bean/RecommendWorksBean;", "s0", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "Lcom/huachenjie/works/bean/WorksTagBean;", "F0", "t0", "channelCategoryNo", "sportFlag", "workCategoryNo", "v0", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ActivityListActivity.t, "Lcom/huachenjie/works/bean/OfficialActivityBean;", "w", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/external/bean/CommentOnMeBean;", "I", "x", "y", "Lcom/huachenjie/works/bean/ChannelTabBean;", "H", "subjectName", "Lcom/huachenjie/works/bean/CreateTopicResultBean;", y6b.g, "Lcom/huachenjie/works/bean/MultipleActivityData;", "V", "targetType", "authorNo", "shareAppUserCode", "targetNo", "", y6b.f, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "N0", "currWorksNo", "I0", "visit", "U0", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/bean/publish/PubWorksRequestIdBean;", t.d, "Lcom/alibaba/fastjson/JSONObject;", "i", "k", "Lcom/huachenjie/works/bean/BroadcastFloorBean;", "A", "scope", "Lcom/huachenjie/works/bean/BroadcastFloorMessageBean;", "C", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "Lcom/huachenjie/works/bean/BroadcastFloorMessageImageBean;", "Lcom/huachenjie/works/bean/BroadcastFloorMessageVoiceBean;", "voice", "requestId", "s", "(Ljava/lang/String;Lcom/huachenjie/works/bean/BroadcastFloorMessageImageBean;Lcom/huachenjie/works/bean/BroadcastFloorMessageVoiceBean;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r0", "q0", "Lcom/huachenjie/works/bean/OriginalCategoryListBean;", "X", "originalNo", "Lcom/huachenjie/works/bean/OriginalPageEntity;", "Y", "attachmentType", "W0", "schoolCode", "Lcom/huachenjie/works/bean/ThisSchoolBean;", "H0", "adCode", "d", "Lcom/huachenjie/works/bean/PostCategoryDataBean;", "Z", "postTypeId", "Lcom/huachenjie/works/bean/PostCategoryBean;", "a0", "postType", "tagNo", "Lcom/huachenjie/works/bean/PostItemBean;", "i0", "g0", "postNo", "Lcom/huachenjie/works/bean/PostDetailBean;", "f0", bo.g, "Lcom/huachenjie/works/bean/PublishPostRequestBean;", "requestBean", "r", "(Lcom/huachenjie/works/bean/PublishPostRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bizNo", "b0", "d0", "p", "q", "j", "V0", "M0", "e", "m", "Lcom/huachenjie/works/bean/OperatorCheckBean;", "W", "Lcom/huachenjie/works/bean/PostedSchoolBean;", "k0", "Lcom/huachenjie/works/bean/GoodStuffTabData;", "T", "zoneNo", "deviceType", "deviceNumber", "Lcom/huachenjie/works/bean/GoodStuffBean;", "S", "Lcom/huachenjie/works/bean/dorm/DormUserInfoBean;", "E0", "Lcom/huachenjie/works/bean/dorm/DormEnergyBean;", "D0", "Lcom/huachenjie/works/bean/dorm/DormExchangeBean;", "U", "perksNo", "charmCost", "L0", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/bean/SchoolmateConfigBean;", "x0", "tagNoList", "T0", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sex", "gradeCode", "Lcom/huachenjie/works/bean/SchoolMateBean;", "y0", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "O0", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class RequestModel extends BaseRepository<WorksApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RequestModel f36762a = new RequestModel();

    public static /* synthetic */ Object E(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return requestModel.D(i, str, str2, continuation);
    }

    public static /* synthetic */ Object J(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.I(i, str, continuation);
    }

    public static /* synthetic */ Object J0(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.I0(i, str, str2, continuation);
    }

    public static /* synthetic */ Object L(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.K(i, str, str2, continuation);
    }

    public static /* synthetic */ Object N(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.M(i, str, str2, continuation);
    }

    public static /* synthetic */ Object P(RequestModel requestModel, int i, String str, String str2, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.O(i, str, str2, str3, continuation);
    }

    public static /* synthetic */ Object Q0(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return requestModel.P0(i, str, str2, continuation);
    }

    public static /* synthetic */ Object R(RequestModel requestModel, int i, String str, String str2, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.Q(i, str, str2, str3, continuation);
    }

    public static /* synthetic */ Object c0(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.b0(i, str, str2, continuation);
    }

    public static /* synthetic */ Object e0(RequestModel requestModel, int i, String str, String str2, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.d0(i, str, str2, str3, continuation);
    }

    public static /* synthetic */ Object f(RequestModel requestModel, String str, int i, String str2, String str3, String str4, Continuation continuation, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            str4 = null;
        }
        return requestModel.e(str, i, str2, str3, str4, continuation);
    }

    public static /* synthetic */ Object h0(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return requestModel.g0(i, str, str2, continuation);
    }

    public static /* synthetic */ Object o0(RequestModel requestModel, String str, int i, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return requestModel.n0(str, i, str2, continuation);
    }

    public static /* synthetic */ Object u0(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.t0(i, str, continuation);
    }

    @Nullable
    public final Object A(@NotNull Continuation<? super BroadcastFloorBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryBroadcastFloor$2(null), continuation);
    }

    @Nullable
    public final Object A0(@NotNull Continuation<? super SearchHotSpotBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySearchHotSpot$2(null), continuation);
    }

    @Nullable
    public final Object B(int i, int i2, @NotNull String str, @NotNull Continuation<? super PageEntity<BroadcastFloorMessageBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryBroadcastFloorMatchMessages$2(i, i2, str, null), continuation);
    }

    @Nullable
    public final Object B0(@Nullable String str, int i, @Nullable String str2, @Nullable Integer num, @NotNull Continuation<? super PubWorksMenuPageEntity<UserInfoBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySelectUserList$2(str, i, str2, num, null), continuation);
    }

    @Nullable
    public final Object C(int i, int i2, @NotNull String str, @NotNull Continuation<? super PageEntity<BroadcastFloorMessageBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryBroadcastFloorMessages$2(i, i2, str, null), continuation);
    }

    @Nullable
    public final Object D(int i, @Nullable String str, @Nullable String str2, @NotNull Continuation<? super PageEntity<BuddyCardBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryBuddySearch$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object D0(@NotNull Continuation<? super DormEnergyBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySpaceEnergyStatus$2(null), continuation);
    }

    @Nullable
    public final Object E0(@NotNull Continuation<? super DormUserInfoBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySpaceHomePageMetaInfo$2(null), continuation);
    }

    @Nullable
    public final Object F(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Continuation<? super PageEntity<ChannelBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelList$2(i, str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object F0(@NotNull String str, @NotNull Continuation<? super PageEntity<WorksTagBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryTagList$2(str, null), continuation);
    }

    @Nullable
    public final Object G0(@NotNull String str, @NotNull Continuation<? super PageEntity<ChatGroupBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryTeamList$2(str, null), continuation);
    }

    @Nullable
    public final Object H(@NotNull Continuation<? super PageEntity<ChannelTabBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelTabList$2(null), continuation);
    }

    @Nullable
    public final Object H0(@Nullable String str, @NotNull Continuation<? super ThisSchoolBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryThisSchoolInfo$2(str, null), continuation);
    }

    @Nullable
    public final Object I(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<CommentOnMeBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryCommentOnMeList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object I0(int i, @Nullable String str, @NotNull String str2, @NotNull Continuation<? super PageEntity<WorkDetailBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryVideoWorkList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object K(int i, @Nullable String str, @NotNull String str2, @NotNull Continuation<? super PageEntity<CommentBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryCommentPageList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object K0(@NotNull String str, @NotNull Continuation<? super WorkDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryWorkDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object L0(@NotNull String str, int i, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$redeemMemberPerks$2(str, i, null), continuation);
    }

    @Nullable
    public final Object M(int i, @Nullable String str, @NotNull String str2, @NotNull Continuation<? super PageEntity<CommentBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryCommentQuotePageList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object M0(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$removePost$2(str, null), continuation);
    }

    @Nullable
    public final Object N0(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$removeWorks$2(str, null), continuation);
    }

    @Nullable
    public final Object O(int i, @Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super PageEntity<CommentReplyBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryCommentQuoteSubPageList$2(i, str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object O0(@NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$reportSocialSayHello$2(null), continuation);
    }

    @Nullable
    public final Object P0(int i, @Nullable String str, @Nullable String str2, @NotNull Continuation<? super PageEntity<UserInfoBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$searchUserList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object Q(int i, @Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super PageEntity<CommentReplyBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryCommentSubPageList$2(i, str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object R0(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$searchWorksList$2(i, str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object S(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super PageEntity<GoodStuffBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryGoodStuffList$2(i, str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object T(@NotNull Continuation<? super GoodStuffTabData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryGoodStuffTabList$2(null), continuation);
    }

    @Nullable
    public final Object T0(@NotNull List<String> list, @NotNull Continuation<Object> continuation) {
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("tagNoList", list));
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(mapMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(map)");
        return BaseRepositoryExtKt.a(this, new RequestModel$settingsTag$2(companion.create(json, MediaType.Companion.parse("application/json; charset=utf-8")), null), continuation);
    }

    @Nullable
    public final Object U(@NotNull Continuation<? super DormExchangeBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryMemberPerksList$2(null), continuation);
    }

    @Nullable
    public final Object U0(@Nullable String str, @Nullable Integer num, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateWorksVisit$2(str, num, null), continuation);
    }

    @Nullable
    public final Object V(int i, @NotNull Continuation<? super MultipleActivityData> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryMultipleActivity$2(i, null), continuation);
    }

    @Nullable
    public final Object V0(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$validPost$2(str, null), continuation);
    }

    @Nullable
    public final Object W(@NotNull Continuation<? super OperatorCheckBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryOperatorCount$2(null), continuation);
    }

    @Nullable
    public final Object W0(int i, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$validPublish$2(i, null), continuation);
    }

    @Nullable
    public final Object X(@NotNull Continuation<? super OriginalCategoryListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryOriginalChannelCategory$2(null), continuation);
    }

    @Nullable
    public final Object X0(@NotNull String str, @NotNull Continuation<? super ValidWorks> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$validWorks$2(str, null), continuation);
    }

    @Nullable
    public final Object Y(@Nullable String str, int i, @Nullable String str2, @NotNull Continuation<? super OriginalPageEntity> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryOriginalChannelHotspot$2(str, i, str2, null), continuation);
    }

    @Nullable
    public final Object Z(@NotNull Continuation<? super PostCategoryDataBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPostCategory$2(null), continuation);
    }

    @Nullable
    public final Object a0(@NotNull String str, @NotNull Continuation<? super PageEntity<PostCategoryBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPostCategoryTagList$2(str, null), continuation);
    }

    @Nullable
    public final Object b0(int i, @Nullable String str, @NotNull String str2, @NotNull Continuation<? super PageEntity<CommentBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPostCommentPageList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super Unit> continuation) {
        Object objA = BaseRepositoryExtKt.a(this, new RequestModel$applyBuddy$2(str, str2, null), continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Nullable
    public final Object d(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$checkBannerAdStatus$2(str, null), continuation);
    }

    @Nullable
    public final Object d0(int i, @Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super PageEntity<CommentReplyBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPostCommentSubPageList$2(i, str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object e(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$countSharePost$2(str, i, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object f0(@NotNull String str, @NotNull Continuation<? super PostDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPostDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object g(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$countShareWork$2(str, i, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object g0(int i, @Nullable String str, @Nullable String str2, @NotNull Continuation<? super PageEntity<PostItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPostHotList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object h(@NotNull String str, @NotNull Continuation<? super CreateTopicResultBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$createTopic$2(str, null), continuation);
    }

    @Nullable
    public final Object i(@NotNull String str, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$deleteComment$2(str, null), continuation);
    }

    @Nullable
    public final Object i0(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Continuation<? super PageEntity<PostItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPostList$2(i, str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object j(@NotNull String str, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$deleteLiveComment$2(str, null), continuation);
    }

    @Nullable
    public final Object k(@NotNull String str, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$deleteQuoteComment$2(str, null), continuation);
    }

    @Nullable
    public final Object k0(@NotNull Continuation<? super PageEntity<PostedSchoolBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPostedSchoolList$2(null), continuation);
    }

    @Nullable
    public final Object l(@NotNull Continuation<? super PubWorksRequestIdBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$getWorksRequestId$2(null), continuation);
    }

    @Nullable
    public final Object l0(@Nullable String str, int i, @Nullable String str2, @Nullable Integer num, @NotNull Continuation<? super PubWorksMenuPageEntity<PubWorkChannelBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPubWorksChannelList$2(str, i, str2, num, null), continuation);
    }

    @Nullable
    public final Object m(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$joinChannel$2(str, null), continuation);
    }

    @Nullable
    public final Object n(@NotNull String str, @NotNull String str2, @Nullable List<String> list, @Nullable CommentImageBean commentImageBean, @NotNull Continuation<? super CommentBean> continuation) {
        String jSONString = JSON.toJSONString(MapsKt.mapOf(new Pair[]{TuplesKt.to("content", str), TuplesKt.to(yj7.g.WORKS_NO, str2), TuplesKt.to("atUserList", list), TuplesKt.to("image", commentImageBean)}));
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new RequestModel$publishComment$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object n0(@Nullable String str, int i, @Nullable String str2, @NotNull Continuation<? super PubWorksMenuPageEntity<PubWorkTopicBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPubWorksTopicList$2(str, i, str2, null), continuation);
    }

    @Nullable
    public final Object o(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<String> list, @Nullable CommentImageBean commentImageBean, @NotNull Continuation<? super CommentReplyBean> continuation) {
        String jSONString = JSON.toJSONString(MapsKt.mapOf(new Pair[]{TuplesKt.to("content", str), TuplesKt.to(yj7.g.WORKS_NO, str2), TuplesKt.to("targetCommentNo", str3), TuplesKt.to("atUserList", list), TuplesKt.to("image", commentImageBean)}));
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new RequestModel$publishCommentReply$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object p(@NotNull String str, @NotNull String str2, @Nullable List<String> list, @Nullable CommentImageBean commentImageBean, @NotNull Continuation<? super CommentBean> continuation) {
        String jSONString = JSON.toJSONString(MapsKt.mapOf(new Pair[]{TuplesKt.to("content", str), TuplesKt.to("bizNo", str2), TuplesKt.to("atUserList", list), TuplesKt.to("image", commentImageBean)}));
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new RequestModel$publishLiveComment$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object p0(@NotNull Continuation<? super PubWorksRequestIdBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPublishPostRequestId$2(null), continuation);
    }

    @Nullable
    public final Object q(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<String> list, @Nullable CommentImageBean commentImageBean, @NotNull Continuation<? super CommentReplyBean> continuation) {
        String jSONString = JSON.toJSONString(MapsKt.mapOf(new Pair[]{TuplesKt.to("content", str), TuplesKt.to("bizNo", str2), TuplesKt.to("targetCommentNo", str3), TuplesKt.to("atUserList", list), TuplesKt.to("image", commentImageBean)}));
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new RequestModel$publishLiveCommentReply$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object q0(@NotNull String str, @NotNull Continuation<? super BroadcastFloorMessageBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryQuoteDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object r(@NotNull PublishPostRequestBean publishPostRequestBean, @NotNull Continuation<? super JSONObject> continuation) {
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(publishPostRequestBean);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(requestBean)");
        return BaseRepositoryExtKt.a(this, new RequestModel$publishPost$2(companion.create(json, MediaType.Companion.parse("application/json; charset=utf-8")), null), continuation);
    }

    @Nullable
    public final Object r0(@NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryQuoteRequestId$2(null), continuation);
    }

    @Nullable
    public final Object s(@Nullable String str, @Nullable BroadcastFloorMessageImageBean broadcastFloorMessageImageBean, @Nullable BroadcastFloorMessageVoiceBean broadcastFloorMessageVoiceBean, @NotNull String str2, @NotNull Continuation<Object> continuation) {
        int i = 1;
        Map mapMutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("requestId", str2)});
        if (!TextUtils.isEmpty(str)) {
            Intrinsics.checkNotNull(str);
            mapMutableMapOf.put("content", str);
        }
        if (broadcastFloorMessageImageBean != null) {
            mapMutableMapOf.put("image", broadcastFloorMessageImageBean);
        } else {
            i = 0;
        }
        if (broadcastFloorMessageVoiceBean != null) {
            mapMutableMapOf.put("voice", broadcastFloorMessageVoiceBean);
            i = 3;
        }
        mapMutableMapOf.put("attachmentType", Boxing.boxInt(i));
        String jSONString = JSON.toJSONString(mapMutableMapOf);
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new RequestModel$publishQuote$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object s0(@NotNull Continuation<? super PageEntity<RecommendWorksBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryRecommendList$2(null), continuation);
    }

    @Nullable
    public final Object t(@NotNull String str, @NotNull String str2, @Nullable List<String> list, @Nullable CommentImageBean commentImageBean, @NotNull Continuation<? super CommentBean> continuation) {
        String jSONString = JSON.toJSONString(MapsKt.mapOf(new Pair[]{TuplesKt.to("content", str), TuplesKt.to(yj7.g.BROADCAST_QUOTE_NO, str2), TuplesKt.to("atUserList", list), TuplesKt.to("image", commentImageBean)}));
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new RequestModel$publishQuoteComment$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object t0(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryRecommendPoolWorksList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object u(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<String> list, @Nullable CommentImageBean commentImageBean, @NotNull Continuation<? super CommentReplyBean> continuation) {
        String jSONString = JSON.toJSONString(MapsKt.mapOf(new Pair[]{TuplesKt.to("content", str), TuplesKt.to(yj7.g.BROADCAST_QUOTE_NO, str2), TuplesKt.to("targetCommentNo", str3), TuplesKt.to("atUserList", list), TuplesKt.to("image", commentImageBean)}));
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new RequestModel$publishQuoteCommentReply$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object v(@NotNull PublishWorksBean publishWorksBean, @NotNull Continuation<? super WorkDetailBean> continuation) {
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(publishWorksBean);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(worksBean)");
        return BaseRepositoryExtKt.a(this, new RequestModel$publishWorks$2(companion.create(json, MediaType.Companion.parse("application/json; charset=utf-8")), null), continuation);
    }

    @Nullable
    public final Object v0(int i, @Nullable String str, @NotNull String str2, int i2, @Nullable String str3, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryRecommendWorksList$2(i, str, str2, i2, str3, null), continuation);
    }

    @Nullable
    public final Object w(int i, @NotNull Continuation<? super OfficialActivityBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryActivityInfo$2(i, null), continuation);
    }

    @Nullable
    public final Object x(@NotNull String str, @NotNull Continuation<? super PageEntity<ChannelBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryAlumniChannelList$2(str, null), continuation);
    }

    @Nullable
    public final Object x0(@NotNull Continuation<? super SchoolmateConfigBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySchoolmateConfig$2(null), continuation);
    }

    @Nullable
    public final Object y(int i, @NotNull String str, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryAlumniChannelWorksList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object y0(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<String> list, @NotNull Continuation<? super PageEntity<SchoolMateBean>> continuation) {
        Map mapMutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("pageNum", Boxing.boxInt(i)), TuplesKt.to("pageSize", Boxing.boxInt(10))});
        if (str != null) {
            mapMutableMapOf.put("refreshTime", str);
        }
        if (str2 != null) {
            mapMutableMapOf.put("sex", str2);
        }
        if (str3 != null) {
            mapMutableMapOf.put("gradeCode", str3);
        }
        if (list != null) {
            mapMutableMapOf.put("tagNoList", list);
        }
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(mapMutableMapOf);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(map)");
        return BaseRepositoryExtKt.a(this, new RequestModel$querySchoolmateRecommendList$6(companion.create(json, MediaType.Companion.parse("application/json; charset=utf-8")), null), continuation);
    }

    @Nullable
    public final Object z(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<WorkDetailBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryAttentionWorksList$2(i, str, null), continuation);
    }
}
