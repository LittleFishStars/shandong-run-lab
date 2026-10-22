package com.huachenjie.channel.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.google.android.exoplayer2.source.rtsp.j;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huachenjie.channel.bean.AdvertiseBean;
import com.huachenjie.channel.bean.ChannelAdminListBean;
import com.huachenjie.channel.bean.ChannelBasicInfo;
import com.huachenjie.channel.bean.ChannelHomeItemBean;
import com.huachenjie.channel.bean.ChannelLogoListBean;
import com.huachenjie.channel.bean.ChannelMainBean;
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.huachenjie.channel.bean.ChannelTopicBean;
import com.huachenjie.channel.bean.ClassificationListBean;
import com.huachenjie.channel.bean.ClubMessageBean;
import com.huachenjie.channel.bean.CreateAdvertiseRequestBean;
import com.huachenjie.channel.bean.FriendApplyBean;
import com.huachenjie.channel.bean.JoinAllChannelEntity;
import com.huachenjie.channel.bean.JoinChannelCategoryListBean;
import com.huachenjie.channel.bean.NotifyBean;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.bean.OrganizeTeamBean;
import com.huachenjie.channel.bean.OrganizeTeamUserBean;
import com.huachenjie.channel.bean.PublishClubMsgRequestBean;
import com.huachenjie.channel.bean.TopicMainBean;
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopic;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;
import com.huachenjie.channel.bean.my_channel.MyChannelDetail;
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;
import com.huachenjie.channel.bean.notify.BuddyChatRoomBean;
import com.huachenjie.channel.bean.notify.BuddyDetailBean;
import com.huachenjie.channel.bean.notify.BuddyReviewReminderBean;
import com.huachenjie.channel.bean.notify.NotifyFavoritesBean;
import com.huachenjie.channel.bean.notify.NotifyMailBoxBean;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseRepository;
import com.huachenjie.common.reconfig.net.BaseRepositoryExtKt;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.external.bean.CommentOnMeBean;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b¾\u0001\u0010¿\u0001J#\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0013J3\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0013J\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0013J/\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J/\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b%\u0010#J\u0015\u0010'\u001a\u0004\u0018\u00010&H\u0086@ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001d\u0010*\u001a\u0004\u0018\u00010&2\u0006\u0010)\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b*\u0010\u0013JO\u00101\u001a\u0004\u0018\u0001002\u0006\u0010)\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001d\u00104\u001a\u0004\u0018\u0001032\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0013J3\u00106\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0013J\u001d\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b:\u0010\u0013J-\u0010=\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b=\u0010>J7\u0010B\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010@2\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ#\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bE\u0010\u0013J%\u0010G\u001a\u0004\u0018\u0001002\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ-\u0010J\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ%\u0010L\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bL\u0010HJ\u0015\u0010N\u001a\u0004\u0018\u00010MH\u0086@ø\u0001\u0000¢\u0006\u0004\bN\u0010(J5\u0010Q\u001a\u0004\u0018\u0001002\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ5\u0010T\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bT\u0010RJ-\u0010U\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010S\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bU\u0010KJ\u001d\u0010W\u001a\u0004\u0018\u00010V2\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bW\u0010\u0013JY\u0010Y\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ+\u0010^\u001a\n\u0012\u0004\u0012\u00020]\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\\\u001a\u00020[H\u0086@ø\u0001\u0000¢\u0006\u0004\b^\u0010_J%\u0010a\u001a\u0004\u0018\u0001002\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010`\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\ba\u0010HJ-\u0010c\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010`\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bc\u0010KJ%\u0010d\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bd\u0010HJ5\u0010g\u001a\u0004\u0018\u0001002\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bg\u0010RJ-\u0010h\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bh\u0010KJ5\u0010i\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bi\u0010RJ%\u0010l\u001a\u0004\u0018\u00010\u00142\u0006\u0010j\u001a\u00020\n2\u0006\u0010k\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\bl\u0010mJ#\u0010o\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\bo\u0010\bJ\u001b\u0010q\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bq\u0010(J\u0015\u0010s\u001a\u0004\u0018\u00010rH\u0086@ø\u0001\u0000¢\u0006\u0004\bs\u0010(J\u001b\u0010u\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\bu\u0010(J\u001d\u0010x\u001a\u0004\u0018\u00010w2\u0006\u0010v\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bx\u0010\u0013J\u001d\u0010y\u001a\u0004\u0018\u00010\u00142\u0006\u0010v\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\by\u0010\u0013J\u001d\u0010z\u001a\u0004\u0018\u00010\u00142\u0006\u0010v\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\bz\u0010\u0013J\u0015\u0010{\u001a\u0004\u0018\u00010\u0014H\u0086@ø\u0001\u0000¢\u0006\u0004\b{\u0010(JS\u0010~\u001a\n\u0012\u0004\u0012\u00020}\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b~\u0010\u007fJ&\u0010\u0081\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0080\u0001\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0081\u0001\u0010\bJ9\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0082\u0001\u0010CJ&\u0010\u0084\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0084\u0001\u0010\u0013J&\u0010\u0085\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0085\u0001\u0010\u0013J(\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\n2\u0007\u0010\u0086\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0087\u0001\u0010HJ1\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u0088\u0001\u001a\u00020\n2\u000e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020\n0\u0089\u0001H\u0086@ø\u0001\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J%\u0010\u008d\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u008d\u0001\u0010\bJ6\u0010\u008f\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u008f\u0001\u0010\u001aJ\"\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00142\b\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0086@ø\u0001\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\"\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u00142\b\u0010\u0091\u0001\u001a\u00030\u0090\u0001H\u0086@ø\u0001\u0000¢\u0006\u0006\b\u0094\u0001\u0010\u0093\u0001J(\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0007\u0010\u0095\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0096\u0001\u0010HJ(\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0007\u0010\u0095\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u0097\u0001\u0010HJH\u0010\u009a\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0099\u0001\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J-\u0010\u009c\u0001\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b\u009c\u0001\u0010mJ9\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u009d\u0001\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0007\u0010\u009e\u0001\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b\u009f\u0001\u0010RJC\u0010 \u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u009d\u0001\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0007\u0010\u009e\u0001\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0006\b \u0001\u0010¡\u0001J1\u0010£\u0001\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0007\u0010¢\u0001\u001a\u00020\n2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b£\u0001\u0010KJ1\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00012\u0006\u0010\u0010\u001a\u00020\n2\u0007\u0010\u0098\u0001\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b¥\u0001\u0010KJ'\u0010¦\u0001\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010S\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b¦\u0001\u0010HJ:\u0010©\u0001\u001a\u000b\u0012\u0005\u0012\u00030¨\u0001\u0018\u00010@2\u0007\u0010\u0098\u0001\u001a\u00020\n2\t\u0010§\u0001\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\b©\u0001\u0010>J/\u0010ª\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u000105\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0005\bª\u0001\u0010mJ\"\u0010¬\u0001\u001a\u0004\u0018\u00010\u00142\b\u0010\u0091\u0001\u001a\u00030«\u0001H\u0086@ø\u0001\u0000¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J \u0010¯\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010®\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b¯\u0001\u0010\u0013J \u0010°\u0001\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u0095\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b°\u0001\u0010\u0013J!\u0010±\u0001\u001a\u0005\u0018\u00010\u0099\u00012\u0007\u0010®\u0001\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b±\u0001\u0010\u0013J\u001f\u0010²\u0001\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b²\u0001\u0010\u0013J1\u0010³\u0001\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b³\u0001\u0010#J2\u0010µ\u0001\u001a\u000b\u0012\u0005\u0012\u00030´\u0001\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0005\bµ\u0001\u0010#J1\u0010¶\u0001\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b¶\u0001\u0010#J2\u0010·\u0001\u001a\u000b\u0012\u0005\u0012\u00030´\u0001\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0005\b·\u0001\u0010#J\u0018\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0086@ø\u0001\u0000¢\u0006\u0005\b¹\u0001\u0010(J6\u0010¼\u0001\u001a\u0005\u0018\u00010»\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\nH\u0086@ø\u0001\u0000¢\u0006\u0006\b¼\u0001\u0010½\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006À\u0001"}, d2 = {"Lcom/huachenjie/channel/api/RequestModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseRepository;", "Lcom/huachenjie/channel/api/ChannelApi;", "", "pageNum", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/channel/bean/notify/NotifyMailBoxBean;", "z0", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageType", "", RemoteMessageConst.MSGID, "readType", "Lcom/google/gson/JsonObject;", "x0", "(ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelNo", "Lcom/huachenjie/channel/bean/ChannelMainBean;", "w0", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", j.o, "B", "pageSize", "Lcom/huachenjie/channel/bean/ChannelTopicBean;", "l0", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", yj7.b.SUBJECT_NO, "Lcom/huachenjie/channel/bean/TopicMainBean;", "B0", "A", "C", "refreshTime", "Lcom/huachenjie/channel/bean/notify/NotifyFavoritesBean;", "a0", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/external/bean/FansBean;", "Y", "Lcom/huachenjie/channel/bean/ClassificationListBean;", "U", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelClassificationNo", "T", "childChannelClassificationNo", "logo", "channelName", "coverUrl", "coverHue", "Lcom/alibaba/fastjson/JSONObject;", "j", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/bean/my_channel/MyChannelDetail;", "L", "Lcom/huachenjie/channel/bean/OrganizeBean;", "M", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", y6b.f, "Lcom/huachenjie/channel/bean/ChannelAdminListBean;", "Q", "memberUserCode", "type", "c", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", UserConstants.USER_PARAMS.b, "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "Lcom/huachenjie/channel/bean/ChannelMemberBean;", "O", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeamGroup;", "R", "teamGroupTitle", "e", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "teamGroupCode", "K0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "Lcom/huachenjie/channel/bean/ChannelLogoListBean;", "S", "teamTitle", "logoUrl", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TeamMemberManageActivity.C, "J0", "r", "Lcom/huachenjie/channel/bean/ChannelBasicInfo;", "N", "channelDescription", "F0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "subjectGroupFlag", "Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicGroup;", "m0", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subjectCategoryName", "p", "subjectCategoryNo", "M0", "v", "subjectName", "subjectImg", j.b, "u", "L0", "checkNo", "checkType", y6b.g, "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/bean/ChannelHomeItemBean;", "y0", "Lcom/huachenjie/channel/bean/NotifyBean;", "A0", "Lcom/huachenjie/channel/bean/notify/BuddyReviewReminderBean;", "v0", "Lcom/huachenjie/channel/bean/notify/BuddyChatRoomBean;", "r0", "buddyCode", "Lcom/huachenjie/channel/bean/notify/BuddyDetailBean;", "s0", "t0", "u0", t.d, "keyword", "Lcom/huachenjie/works/external/bean/WorkItemBean;", "C0", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/bean/FriendApplyBean;", "q0", "o0", "Lcom/huachenjie/channel/bean/manage_topic_chat/ManageTopic;", "k0", "n0", "title", "f", TeamMemberManageActivity.z, "", "accidList", "x", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "e0", "Lcom/huachenjie/channel/bean/AdvertiseBean;", "I", "Lcom/huachenjie/channel/bean/CreateAdvertiseRequestBean;", "requestBean", "k", "(Lcom/huachenjie/channel/bean/CreateAdvertiseRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "H0", "channelAdCode", "q", "y", "clubCode", "Lcom/huachenjie/channel/bean/ClubMessageBean;", "W", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "J", "clubName", "clubDescription", "m", "I0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appUserCode", "E0", "Lcom/huachenjie/channel/bean/OrganizeTeamBean;", "n", "w", "clubUserName", "Lcom/huachenjie/channel/bean/OrganizeTeamUserBean;", "K", "f0", "Lcom/huachenjie/channel/bean/PublishClubMsgRequestBean;", "D", "(Lcom/huachenjie/channel/bean/PublishClubMsgRequestBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageCode", "t", "i", "V", "N0", "G", "Lcom/huachenjie/works/external/bean/CommentOnMeBean;", "E", "i0", "g0", "Lcom/huachenjie/channel/bean/JoinChannelCategoryListBean;", "d0", "originalNo", "Lcom/huachenjie/channel/bean/JoinAllChannelEntity;", "c0", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class RequestModel extends BaseRepository<ChannelApi> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final RequestModel f33012a = new RequestModel();

    public static /* synthetic */ Object F(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.E(i, str, continuation);
    }

    public static /* synthetic */ Object H(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.G(i, str, continuation);
    }

    public static /* synthetic */ Object P(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.O(i, str, str2, continuation);
    }

    public static /* synthetic */ Object Z(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.Y(i, str, continuation);
    }

    public static /* synthetic */ Object b0(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.a0(i, str, continuation);
    }

    public static /* synthetic */ Object h0(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.g0(i, str, continuation);
    }

    public static /* synthetic */ Object j0(RequestModel requestModel, int i, String str, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.i0(i, str, continuation);
    }

    public static /* synthetic */ Object p0(RequestModel requestModel, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return requestModel.o0(i, str, str2, continuation);
    }

    @Nullable
    public final Object A(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$joinSubject$2(str, null), continuation);
    }

    @Nullable
    public final Object A0(@NotNull Continuation<? super PageEntity<NotifyBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestNotifyList$2(null), continuation);
    }

    @Nullable
    public final Object B(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$leaveChannel$2(str, null), continuation);
    }

    @Nullable
    public final Object B0(@NotNull String str, @NotNull Continuation<? super TopicMainBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestSubjectDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object C(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$leaveSubject$2(str, null), continuation);
    }

    @Nullable
    public final Object C0(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$searchWorksList$2(i, str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object D(@NotNull PublishClubMsgRequestBean publishClubMsgRequestBean, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$publishClubMessage$2(publishClubMsgRequestBean, null), continuation);
    }

    @Nullable
    public final Object E(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<CommentOnMeBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryBroadCommentList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object E0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$setOrganizeAdminUser$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object F0(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateChannel$2(str, str2, str3, str4, str5, str6, null), continuation);
    }

    @Nullable
    public final Object G(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<NotifyFavoritesBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryBroadFavorList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object H0(@NotNull CreateAdvertiseRequestBean createAdvertiseRequestBean, @NotNull Continuation<Object> continuation) {
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(createAdvertiseRequestBean);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(requestBean)");
        return BaseRepositoryExtKt.a(this, new RequestModel$updateChannelAd$2(companion.create(json, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object I(@NotNull String str, int i, int i2, @NotNull Continuation<? super PageEntity<AdvertiseBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelAdList$2(str, i, i2, null), continuation);
    }

    @Nullable
    public final Object I0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateChannelOrganize$2(str, str2, str3, str4, str5, null), continuation);
    }

    @Nullable
    public final Object J(@NotNull String str, int i, @NotNull Continuation<? super PageEntity<OrganizeBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelClubList$2(str, i, null), continuation);
    }

    @Nullable
    public final Object J0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateChannelTeam$2(str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object K(@NotNull String str, @Nullable String str2, int i, @NotNull Continuation<? super PubWorksMenuPageEntity<OrganizeTeamUserBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelClubUserList$2(str, str2, i, null), continuation);
    }

    @Nullable
    public final Object K0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateChannelTeamGroup$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object L(@NotNull String str, @NotNull Continuation<? super MyChannelDetail> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object L0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateSubject$2(str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object M(int i, int i2, @NotNull String str, @NotNull Continuation<? super PageEntity<OrganizeBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelHomeClubList$2(i, i2, str, null), continuation);
    }

    @Nullable
    public final Object M0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$updateSubjectCategory$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object N(@NotNull String str, @NotNull Continuation<? super ChannelBasicInfo> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelInfoBase$2(str, null), continuation);
    }

    @Nullable
    public final Object N0(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$validCreateChannelAd$2(str, null), continuation);
    }

    @Nullable
    public final Object O(int i, @Nullable String str, @NotNull String str2, @NotNull Continuation<? super PubWorksMenuPageEntity<ChannelMemberBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelMemberList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object Q(@NotNull String str, @NotNull Continuation<? super ChannelAdminListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelSubAdminList$2(str, null), continuation);
    }

    @Nullable
    public final Object R(@NotNull String str, @NotNull Continuation<? super PageEntity<MyChannelChatTeamGroup>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelTeamGroupList$2(str, null), continuation);
    }

    @Nullable
    public final Object S(@NotNull Continuation<? super ChannelLogoListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryChannelTeamImgList$2(null), continuation);
    }

    @Nullable
    public final Object T(@NotNull String str, @NotNull Continuation<? super ClassificationListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryClassificationChildList$2(str, null), continuation);
    }

    @Nullable
    public final Object U(@NotNull Continuation<? super ClassificationListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryClassificationList$2(null), continuation);
    }

    @Nullable
    public final Object V(@NotNull String str, @NotNull Continuation<? super ClubMessageBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryClubMessageDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object W(int i, int i2, @Nullable String str, @Nullable String str2, @NotNull Continuation<? super PageEntity<ClubMessageBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryClubMessageList$2(i, i2, str, str2, null), continuation);
    }

    @Nullable
    public final Object Y(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<FansBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryFansList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object a0(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<NotifyFavoritesBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryFavorList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object c(@NotNull String str, @NotNull String str2, int i, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$addChannelMember$2(str, str2, i, null), continuation);
    }

    @Nullable
    public final Object c0(@Nullable String str, int i, @Nullable String str2, @NotNull Continuation<? super JoinAllChannelEntity> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryJoinAllChannelHotspot$2(str, i, str2, null), continuation);
    }

    @Nullable
    public final Object d(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$addChannelTeam$2(str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object d0(@NotNull Continuation<? super JoinChannelCategoryListBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryJoinChannelCategory$2(null), continuation);
    }

    @Nullable
    public final Object e(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$addChannelTeamGroup$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object e0(int i, @NotNull Continuation<? super PageEntity<String>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryMayKnowFriends$2(i, null), continuation);
    }

    @Nullable
    public final Object f(@NotNull String str, @NotNull String str2, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$addSubjectTeamGroup$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object f0(@NotNull String str, int i, @NotNull Continuation<? super PageEntity<OrganizeBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryMyChannelClubList$2(str, i, null), continuation);
    }

    @Nullable
    public final Object g(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$channelCancel$2(str, null), continuation);
    }

    @Nullable
    public final Object g0(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<CommentOnMeBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPostCommentList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object h(@NotNull String str, int i, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$checkChannel$2(str, i, null), continuation);
    }

    @Nullable
    public final Object i(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$checkChannelAd$2(str, null), continuation);
    }

    @Nullable
    public final Object i0(int i, @Nullable String str, @NotNull Continuation<? super PageEntity<NotifyFavoritesBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryPostFavorList$2(i, str, null), continuation);
    }

    @Nullable
    public final Object j(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, @NotNull String str6, @NotNull String str7, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$createChannel$2(str, str2, str3, str4, str5, str6, str7, null), continuation);
    }

    @Nullable
    public final Object k(@NotNull CreateAdvertiseRequestBean createAdvertiseRequestBean, @NotNull Continuation<Object> continuation) {
        RequestBody.Companion companion = RequestBody.Companion;
        String json = new Gson().toJson(createAdvertiseRequestBean);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(requestBean)");
        return BaseRepositoryExtKt.a(this, new RequestModel$createChannelAd$2(companion.create(json, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object k0(@NotNull String str, @NotNull Continuation<? super PageEntity<ManageTopic>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySubjectGroupList$2(str, null), continuation);
    }

    @Nullable
    public final Object l(@NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$createChannelCheck$2(null), continuation);
    }

    @Nullable
    public final Object l0(@NotNull String str, int i, int i2, @NotNull Continuation<? super PageEntity<ChannelTopicBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySubjectList$2(str, i, i2, null), continuation);
    }

    @Nullable
    public final Object m(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$createChannelOrganize$2(str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object m0(@NotNull String str, boolean z, @NotNull Continuation<? super PageEntity<MyChannelTopicGroup>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySubjectList$4(str, z, null), continuation);
    }

    @Nullable
    public final Object n(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super OrganizeTeamBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$createOrganizeTeam$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object n0(@NotNull String str, @NotNull Continuation<? super PageEntity<ManageTopic>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$querySubjectOptions$2(str, null), continuation);
    }

    @Nullable
    public final Object o(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$createSubject$2(str, str2, str3, str4, null), continuation);
    }

    @Nullable
    public final Object o0(int i, @Nullable String str, @NotNull String str2, @NotNull Continuation<? super PageEntity<ChannelMemberBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$queryTopicMemberList$2(i, str, str2, null), continuation);
    }

    @Nullable
    public final Object p(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super JSONObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$createSubjectCategory$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object q(@NotNull String str, @NotNull String str2, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$deleteChannelAd$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object q0(int i, @NotNull Continuation<? super PageEntity<FriendApplyBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestApplyFriendList$2(i, null), continuation);
    }

    @Nullable
    public final Object r(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$deleteChannelTeam$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object r0(@NotNull Continuation<? super PageEntity<BuddyChatRoomBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestBuddyChatRoomList$2(null), continuation);
    }

    @Nullable
    public final Object s(@NotNull String str, @NotNull String str2, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$deleteChannelTeamGroup$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object s0(@NotNull String str, @NotNull Continuation<? super BuddyDetailBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestBuddyDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object t(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$deleteClubMessage$2(str, null), continuation);
    }

    @Nullable
    public final Object t0(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestBuddyDissolve$2(str, null), continuation);
    }

    @Nullable
    public final Object u(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$deleteSubject$2(str, str2, str3, null), continuation);
    }

    @Nullable
    public final Object u0(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestBuddyExit$2(str, null), continuation);
    }

    @Nullable
    public final Object v(@NotNull String str, @NotNull String str2, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$deleteSubjectCategory$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object v0(@NotNull Continuation<? super BuddyReviewReminderBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestBuddyReviewReminder$2(null), continuation);
    }

    @Nullable
    public final Object w(@NotNull String str, @NotNull String str2, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$dissolveOrganizeGroup$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object w0(@NotNull String str, @NotNull Continuation<? super ChannelMainBean> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestChannelHomepageDetail$2(str, null), continuation);
    }

    @Nullable
    public final Object x(@NotNull String str, @NotNull List<String> list, @NotNull Continuation<Object> continuation) {
        String jSONString = JSON.toJSONString(MapsKt.mapOf(new Pair[]{TuplesKt.to(TeamMemberManageActivity.z, str), TuplesKt.to("accidList", list)}));
        RequestBody.Companion companion = RequestBody.Companion;
        Intrinsics.checkNotNullExpressionValue(jSONString, "jsonString");
        return BaseRepositoryExtKt.a(this, new RequestModel$dissolveSubjectGroup$2(companion.create(jSONString, MediaType.Companion.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE)), null), continuation);
    }

    @Nullable
    public final Object x0(int i, @NotNull String str, int i2, @NotNull Continuation<? super JsonObject> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestClearRedDot$2(i, str, i2, null), continuation);
    }

    @Nullable
    public final Object y(@NotNull String str, @NotNull String str2, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$finishChannelAd$2(str, str2, null), continuation);
    }

    @Nullable
    public final Object y0(int i, @NotNull Continuation<? super PageEntity<ChannelHomeItemBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestJoinChannelList$2(i, null), continuation);
    }

    @Nullable
    public final Object z(@NotNull String str, @NotNull Continuation<Object> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$joinChannel$2(str, null), continuation);
    }

    @Nullable
    public final Object z0(int i, @NotNull Continuation<? super PageEntity<NotifyMailBoxBean>> continuation) {
        return BaseRepositoryExtKt.a(this, new RequestModel$requestMailBoxList$2(i, null), continuation);
    }
}
