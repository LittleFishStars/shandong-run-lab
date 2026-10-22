package com.huachenjie.channel.api;

import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;
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
import com.huachenjie.channel.bean.FriendApplyBean;
import com.huachenjie.channel.bean.JoinAllChannelEntity;
import com.huachenjie.channel.bean.JoinChannelCategoryListBean;
import com.huachenjie.channel.bean.NotifyBean;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.bean.OrganizeTeamBean;
import com.huachenjie.channel.bean.OrganizeTeamUserBean;
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
import com.huachenjie.common.bean.BaseEntity;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.external.bean.CommentOnMeBean;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kuaishou.weapon.p0.bo;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ9\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00052\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0014J%\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0014J?\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00052\b\b\u0001\u0010\u001a\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0014J%\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u001a\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0014J%\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u001a\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014J\u001b\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0005H§@ø\u0001\u0000¢\u0006\u0004\b \u0010!J%\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u00052\b\b\u0001\u0010\"\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b#\u0010\u0014JA\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0004\b&\u0010'JA\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0004\b)\u0010'Jc\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0\u00052\b\b\u0001\u0010\"\u001a\u00020\u000b2\b\b\u0001\u0010*\u001a\u00020\u000b2\b\b\u0001\u0010+\u001a\u00020\u000b2\b\b\u0001\u0010,\u001a\u00020\u000b2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010-\u001a\u00020\u000b2\b\b\u0001\u0010.\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b0\u00101J%\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0014J=\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b5\u0010'J%\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0014J%\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001070\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b8\u0010\u0014J9\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u00109\u001a\u00020\u000b2\b\b\u0001\u0010:\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b;\u0010<JK\u0010@\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020?\u0018\u00010>0\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0003\u0010=\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ+\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020B\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bC\u0010\u0014J/\u0010E\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010D\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ9\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010D\u001a\u00020\u000b2\b\b\u0001\u0010G\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ/\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010G\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bJ\u0010FJ\u001b\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010K0\u0005H§@ø\u0001\u0000¢\u0006\u0004\bL\u0010!JC\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010G\u001a\u00020\u000b2\b\b\u0001\u0010M\u001a\u00020\u000b2\b\b\u0001\u0010N\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bO\u0010PJC\u0010R\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010Q\u001a\u00020\u000b2\b\b\u0001\u0010M\u001a\u00020\u000b2\b\b\u0001\u0010N\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bR\u0010PJ9\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010G\u001a\u00020\u000b2\b\b\u0001\u0010Q\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bS\u0010IJ%\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010T0\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bU\u0010\u0014Ja\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010V\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0004\bW\u0010XJ3\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020[0\u00060\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010Z\u001a\u00020YH§@ø\u0001\u0000¢\u0006\u0004\b\\\u0010]J/\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010^\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\b_\u0010FJ9\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010^\u001a\u00020\u000b2\b\b\u0001\u0010`\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\ba\u0010IJ/\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010`\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bb\u0010FJ9\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010`\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bc\u0010IJC\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010`\u001a\u00020\u000b2\b\b\u0001\u0010d\u001a\u00020\u000b2\b\b\u0001\u0010e\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bf\u0010PJC\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000b2\b\b\u0001\u0010d\u001a\u00020\u000b2\b\b\u0001\u0010e\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bg\u0010PJ/\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010h\u001a\u00020\u000b2\b\b\u0001\u0010i\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bj\u0010kJ3\u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020l0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bm\u0010\tJ!\u0010o\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020n\u0018\u00010\u00060\u0005H§@ø\u0001\u0000¢\u0006\u0004\bo\u0010!J\u001b\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010p0\u0005H§@ø\u0001\u0000¢\u0006\u0004\bq\u0010!J!\u0010s\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020r\u0018\u00010\u00060\u0005H§@ø\u0001\u0000¢\u0006\u0004\bs\u0010!J%\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010u0\u00052\b\b\u0001\u0010t\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bv\u0010\u0014J%\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010t\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bw\u0010\u0014J%\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010t\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0004\bx\u0010\u0014J\u001b\u0010y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0004\by\u0010!Jc\u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020{0\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010z\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0004\b|\u0010}J5\u0010\u007f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020~\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u007f\u0010\tJM\u0010\u0080\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020?\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0003\u0010=\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\u001a\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b\u0080\u0001\u0010AJ.\u0010\u0082\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b\u0082\u0001\u0010\u0014J.\u0010\u0083\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b\u0083\u0001\u0010\u0014J2\u0010\u0085\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u001a\u001a\u00020\u000b2\t\b\u0001\u0010\u0084\u0001\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b\u0085\u0001\u0010FJ*\u0010\u0088\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\n\b\u0001\u0010\u0087\u0001\u001a\u00030\u0086\u0001H§@ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J7\u0010\u008a\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u008a\u0001\u0010\tJ?\u0010\u008b\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00060\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u008b\u0001\u0010\u0019JG\u0010\u008e\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\t\b\u0001\u0010\u008c\u0001\u001a\u00020\u000b2\b\b\u0001\u0010-\u001a\u00020\u000b2\t\b\u0001\u0010\u008d\u0001\u001a\u00020\u000b2\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b\u008e\u0001\u0010PJS\u0010\u0090\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\t\b\u0001\u0010\u008c\u0001\u001a\u00020\u000b2\b\b\u0001\u0010-\u001a\u00020\u000b2\t\b\u0001\u0010\u008d\u0001\u001a\u00020\u000b2\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J=\u0010\u0093\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\t\b\u0001\u0010\u0092\u0001\u001a\u00020\u000b2\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b\u0093\u0001\u0010IJ=\u0010\u0095\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0094\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u000b2\b\b\u0001\u0010M\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b\u0095\u0001\u0010IJ1\u0010\u0096\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010Q\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b\u0096\u0001\u0010FJO\u0010\u0099\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0098\u00010>0\u00052\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u000b2\u000b\b\u0001\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001JK\u0010\u009c\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u009b\u00010\u00060\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010:\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J*\u0010\u009e\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\n\b\u0001\u0010\u0087\u0001\u001a\u00030\u0086\u0001H§@ø\u0001\u0000¢\u0006\u0006\b\u009e\u0001\u0010\u0089\u0001J*\u0010\u009f\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\n\b\u0001\u0010\u0087\u0001\u001a\u00030\u0086\u0001H§@ø\u0001\u0000¢\u0006\u0006\b\u009f\u0001\u0010\u0089\u0001J2\u0010¡\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\t\b\u0001\u0010 \u0001\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010FJ2\u0010¢\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\t\b\u0001\u0010 \u0001\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b¢\u0001\u0010FJO\u0010¤\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030£\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\u000b\b\u0003\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0005\b¤\u0001\u0010AJA\u0010¥\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001040\u00060\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b¥\u0001\u0010\u0019J*\u0010¦\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\n\b\u0001\u0010\u0087\u0001\u001a\u00030\u0086\u0001H§@ø\u0001\u0000¢\u0006\u0006\b¦\u0001\u0010\u0089\u0001J(\u0010¨\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\t\b\u0001\u0010§\u0001\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b¨\u0001\u0010\u0014J&\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\t\b\u0001\u0010 \u0001\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b©\u0001\u0010\u0014J'\u0010ª\u0001\u001a\t\u0012\u0005\u0012\u00030£\u00010\u00052\t\b\u0001\u0010§\u0001\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\bª\u0001\u0010\u0014J'\u0010«\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\b\b\u0001\u0010\u0011\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0005\b«\u0001\u0010\u0014JC\u0010¬\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0005\b¬\u0001\u0010'JD\u0010®\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030\u00ad\u0001\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0005\b®\u0001\u0010'JC\u0010¯\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0005\b¯\u0001\u0010'JD\u0010°\u0001\u001a\u0011\u0012\r\u0012\u000b\u0012\u0005\u0012\u00030\u00ad\u0001\u0018\u00010\u00060\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0005\b°\u0001\u0010'J\u001c\u0010²\u0001\u001a\t\u0012\u0005\u0012\u00030±\u00010\u0005H§@ø\u0001\u0000¢\u0006\u0005\b²\u0001\u0010!JJ\u0010µ\u0001\u001a\t\u0012\u0005\u0012\u00030´\u00010\u00052\u000b\b\u0001\u0010³\u0001\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u000bH§@ø\u0001\u0000¢\u0006\u0006\bµ\u0001\u0010¶\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006·\u0001"}, d2 = {"Lcom/huachenjie/channel/api/ChannelApi;", "", "", "pageNum", "pageSize", "Lcom/huachenjie/common/bean/BaseEntity;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/channel/bean/notify/NotifyMailBoxBean;", "v0", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageType", "", RemoteMessageConst.MSGID, "readType", "Lcom/google/gson/JsonObject;", "C0", "(ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelNo", "Lcom/huachenjie/channel/bean/ChannelMainBean;", "L", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "K", "Lcom/huachenjie/channel/bean/ChannelTopicBean;", t.d, "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", yj7.b.SUBJECT_NO, "Lcom/huachenjie/channel/bean/TopicMainBean;", "w0", "n", "j", "Lcom/huachenjie/channel/bean/ClassificationListBean;", "W", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelClassificationNo", "m0", "refreshTime", "Lcom/huachenjie/channel/bean/notify/NotifyFavoritesBean;", "s", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/external/bean/FansBean;", "f", "childChannelClassificationNo", "logo", "channelName", "coverUrl", "coverHue", "Lcom/alibaba/fastjson/JSONObject;", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/bean/my_channel/MyChannelDetail;", "a0", "Lcom/huachenjie/channel/bean/OrganizeBean;", "X", "C", "Lcom/huachenjie/channel/bean/ChannelAdminListBean;", "w", "memberUserCode", "type", "k0", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", UserConstants.USER_PARAMS.b, "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "Lcom/huachenjie/channel/bean/ChannelMemberBean;", "s0", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/bean/my_channel/MyChannelChatTeamGroup;", "q0", "teamGroupTitle", "z0", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "teamGroupCode", "q", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "Lcom/huachenjie/channel/bean/ChannelLogoListBean;", "I", "teamTitle", "logoUrl", "v", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TeamMemberManageActivity.C, "Z", "t0", "Lcom/huachenjie/channel/bean/ChannelBasicInfo;", "A", "channelDescription", "u", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "subjectGroupFlag", "Lcom/huachenjie/channel/bean/my_channel/MyChannelTopicGroup;", "h0", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "subjectCategoryName", "G", "subjectCategoryNo", "D0", "y0", "m", "subjectName", "subjectImg", "r0", "F", "checkNo", "checkType", "e0", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/bean/ChannelHomeItemBean;", j.b, "Lcom/huachenjie/channel/bean/NotifyBean;", "E", "Lcom/huachenjie/channel/bean/notify/BuddyReviewReminderBean;", "T", "Lcom/huachenjie/channel/bean/notify/BuddyChatRoomBean;", "Q", "buddyCode", "Lcom/huachenjie/channel/bean/notify/BuddyDetailBean;", "Y", "f0", "N", "n0", "keyword", "Lcom/huachenjie/works/external/bean/WorkItemBean;", "e", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/bean/FriendApplyBean;", "B", "t", "Lcom/huachenjie/channel/bean/manage_topic_chat/ManageTopic;", "o0", y6b.g, "title", "A0", "Lokhttp3/RequestBody;", "body", "M", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "J", "i0", "clubName", "clubDescription", "c0", "clubCode", "g0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appUserCode", "u0", "Lcom/huachenjie/channel/bean/OrganizeTeamBean;", "r", "D", "clubUserName", "Lcom/huachenjie/channel/bean/OrganizeTeamUserBean;", "p", "(Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/channel/bean/AdvertiseBean;", "y", "(Ljava/lang/String;IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "H", y6b.f, "channelAdCode", "O", bo.g, "Lcom/huachenjie/channel/bean/ClubMessageBean;", "P", "x", "V", "messageCode", "d0", "S", j.o, "U", "x0", "Lcom/huachenjie/works/external/bean/CommentOnMeBean;", "B0", "l0", "b0", "Lcom/huachenjie/channel/bean/JoinChannelCategoryListBean;", "j0", "originalNo", "Lcom/huachenjie/channel/bean/JoinAllChannelEntity;", "R", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channel_release"}, k = 1, mv = {1, 8, 0})
public interface ChannelApi {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ Object a(ChannelApi channelApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryBroadCommentList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return channelApi.B0(i, i2, str, continuation);
        }

        public static /* synthetic */ Object b(ChannelApi channelApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryBroadFavorList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return channelApi.x0(i, i2, str, continuation);
        }

        public static /* synthetic */ Object c(ChannelApi channelApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryChannelMemberList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return channelApi.s0(i, i2, str, str2, continuation);
        }

        public static /* synthetic */ Object d(ChannelApi channelApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return channelApi.P(i, i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryClubMessageList");
        }

        public static /* synthetic */ Object e(ChannelApi channelApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryFansList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return channelApi.f(i, i2, str, continuation);
        }

        public static /* synthetic */ Object f(ChannelApi channelApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryFavorList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return channelApi.s(i, i2, str, continuation);
        }

        public static /* synthetic */ Object g(ChannelApi channelApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryPostCommentList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return channelApi.b0(i, i2, str, continuation);
        }

        public static /* synthetic */ Object h(ChannelApi channelApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryPostFavorList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return channelApi.l0(i, i2, str, continuation);
        }

        public static /* synthetic */ Object i(ChannelApi channelApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryTopicMemberList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return channelApi.t(i, i2, str, str2, continuation);
        }

        public static /* synthetic */ Object j(ChannelApi channelApi, int i, int i2, String str, String str2, String str3, String str4, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return channelApi.e(i, i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchWorksList");
        }

        public static /* synthetic */ Object k(ChannelApi channelApi, String str, String str2, String str3, String str4, String str5, String str6, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return channelApi.u(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateChannel");
        }
    }

    @FormUrlEncoded
    @POST("run-front/api/message/channelInfoBase")
    @Nullable
    Object A(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<ChannelBasicInfo>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/addSubjectTeamGroup")
    @Nullable
    Object A0(@Field(yj7.b.SUBJECT_NO) @NotNull String str, @Field("title") @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/user/friend/applyRecord")
    @Nullable
    Object B(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<FriendApplyBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/message/broadcastComment")
    @Nullable
    Object B0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<CommentOnMeBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelCancel")
    @Nullable
    Object C(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/clearRedDot")
    @Nullable
    Object C0(@Field("messageType") int i, @Field(RemoteMessageConst.MSGID) @NotNull String str, @Field("readType") int i2, @NotNull Continuation<? super BaseEntity<JsonObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/dissolveClubTeam")
    @Nullable
    Object D(@Field("channelNo") @NotNull String str, @Field(TeamMemberManageActivity.C) @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/updateSubjectCategory")
    @Nullable
    Object D0(@Field("channelNo") @NotNull String str, @Field("subjectCategoryName") @NotNull String str2, @Field("subjectCategoryNo") @NotNull String str3, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/message/getBoxMessage")
    @Nullable
    Object E(@NotNull Continuation<? super BaseEntity<PageEntity<NotifyBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/updateSubject")
    @Nullable
    Object F(@Field("channelNo") @NotNull String str, @Field(yj7.b.SUBJECT_NO) @NotNull String str2, @Field("subjectName") @NotNull String str3, @Field("subjectImg") @NotNull String str4, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/createSubjectCategory")
    @Nullable
    Object G(@Field("channelNo") @NotNull String str, @Field("subjectCategoryName") @NotNull String str2, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @POST("run-front/api/message/addChannelAd")
    @Nullable
    Object H(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/message/channelTeamImgList")
    @Nullable
    Object I(@NotNull Continuation<? super BaseEntity<ChannelLogoListBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/user/nonFriend")
    @Nullable
    Object J(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<String>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/leaveChannel")
    @Nullable
    Object K(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelHomepageDetail")
    @Nullable
    Object L(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<ChannelMainBean>> continuation);

    @POST("run-front/api/message/dissolveSubjectGroup")
    @Nullable
    Object M(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/buddy/exit")
    @Nullable
    Object N(@Field("buddyCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/deleteChannelAd")
    @Nullable
    Object O(@Field("channelNo") @NotNull String str, @Field("channelAdCode") @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/clubMessageList")
    @Nullable
    Object P(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("clubCode") @Nullable String str, @Field("channelNo") @Nullable String str2, @NotNull Continuation<? super BaseEntity<PageEntity<ClubMessageBean>>> continuation);

    @POST("run-front/buddy/chatRoom/list")
    @Nullable
    Object Q(@NotNull Continuation<? super BaseEntity<PageEntity<BuddyChatRoomBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/channel/original/hotspot/list")
    @Nullable
    Object R(@Field("originalNo") @Nullable String str, @Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str2, @NotNull Continuation<? super BaseEntity<JoinAllChannelEntity>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/checkChannelAd")
    @Nullable
    Object S(@Field("channelAdCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/buddy/apply/reviewReminder")
    @Nullable
    Object T(@NotNull Continuation<? super BaseEntity<BuddyReviewReminderBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/validChannelAd")
    @Nullable
    Object U(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/message/addClubMessage")
    @Nullable
    Object V(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/message/classificationList")
    @Nullable
    Object W(@NotNull Continuation<? super BaseEntity<ClassificationListBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelHomeClubList")
    @Nullable
    Object X(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<OrganizeBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/buddy/detail")
    @Nullable
    Object Y(@Field("buddyCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<BuddyDetailBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/updateChannelTeam")
    @Nullable
    Object Z(@Field("channelNo") @NotNull String str, @Field(TeamMemberManageActivity.C) @NotNull String str2, @Field("teamTitle") @NotNull String str3, @Field("logoUrl") @NotNull String str4, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelDetailV2")
    @Nullable
    Object a0(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<MyChannelDetail>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/postCommentList")
    @Nullable
    Object b0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<CommentOnMeBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/addChannelClub")
    @Nullable
    Object c0(@Field("clubName") @NotNull String str, @Field("coverUrl") @NotNull String str2, @Field("clubDescription") @NotNull String str3, @Field("channelNo") @NotNull String str4, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/joinChannel")
    @Nullable
    Object d(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/deleteClubMessage")
    @Nullable
    Object d0(@Field("messageCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/search/pageList")
    @Nullable
    Object e(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("keyword") @Nullable String str2, @Field("channelNo") @Nullable String str3, @Field(yj7.b.SUBJECT_NO) @Nullable String str4, @NotNull Continuation<? super BaseEntity<PageEntity<WorkItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/checkChannel")
    @Nullable
    Object e0(@Field("checkNo") @NotNull String str, @Field("checkType") int i, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/fansList")
    @Nullable
    Object f(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<FansBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/buddy/dissolve")
    @Nullable
    Object f0(@Field("buddyCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/message/updateChannelAd")
    @Nullable
    Object g(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/updateChannelClub")
    @Nullable
    Object g0(@Field("clubName") @NotNull String str, @Field("coverUrl") @NotNull String str2, @Field("clubDescription") @NotNull String str3, @Field("channelNo") @NotNull String str4, @Field("clubCode") @NotNull String str5, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/subjectOptions")
    @Nullable
    Object h(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<ManageTopic>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/subjectList")
    @Nullable
    Object h0(@Field("channelNo") @NotNull String str, @Field("subjectGroupFlag") boolean z, @NotNull Continuation<? super BaseEntity<PageEntity<MyChannelTopicGroup>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/deleteChannelTeamGroup")
    @Nullable
    Object i(@Field("channelNo") @NotNull String str, @Field("teamGroupCode") @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelClubList")
    @Nullable
    Object i0(@Field("channelNo") @NotNull String str, @Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<OrganizeBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/leaveSubject")
    @Nullable
    Object j(@Field(yj7.b.SUBJECT_NO) @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/channel/original/category/list")
    @Nullable
    Object j0(@NotNull Continuation<? super BaseEntity<JoinChannelCategoryListBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/createChannel")
    @Nullable
    Object k(@Field("channelClassificationNo") @NotNull String str, @Field("childChannelClassificationNo") @NotNull String str2, @Field("logo") @NotNull String str3, @Field("channelName") @NotNull String str4, @Field("channelNo") @Nullable String str5, @Field("coverUrl") @NotNull String str6, @Field("coverHue") @NotNull String str7, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/addChannelMember")
    @Nullable
    Object k0(@Field("channelNo") @NotNull String str, @Field("memberUserCode") @NotNull String str2, @Field("type") int i, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/pageSubjectList")
    @Nullable
    Object l(@Field("channelNo") @NotNull String str, @Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<ChannelTopicBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/postFavorList")
    @Nullable
    Object l0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<NotifyFavoritesBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/deleteSubject")
    @Nullable
    Object m(@Field("channelNo") @NotNull String str, @Field("subjectCategoryNo") @NotNull String str2, @Field(yj7.b.SUBJECT_NO) @NotNull String str3, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/classificationChildList")
    @Nullable
    Object m0(@Field("channelClassificationNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<ClassificationListBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/joinSubject")
    @Nullable
    Object n(@Field(yj7.b.SUBJECT_NO) @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/message/createChannelCheck")
    @Nullable
    Object n0(@NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelList")
    @Nullable
    Object o(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<ChannelHomeItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/subjectGroupList")
    @Nullable
    Object o0(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<ManageTopic>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelClubUser")
    @Nullable
    Object p(@Field("clubCode") @NotNull String str, @Field("clubUserName") @Nullable String str2, @Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PubWorksMenuPageEntity<OrganizeTeamUserBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/finishChannelAd")
    @Nullable
    Object p0(@Field("channelNo") @NotNull String str, @Field("channelAdCode") @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/updateChannelTeamGroup")
    @Nullable
    Object q(@Field("channelNo") @NotNull String str, @Field("teamGroupTitle") @NotNull String str2, @Field("teamGroupCode") @NotNull String str3, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelTeamGroupList")
    @Nullable
    Object q0(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<MyChannelChatTeamGroup>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/addChannelClubTeam")
    @Nullable
    Object r(@Field("channelNo") @NotNull String str, @Field("clubCode") @NotNull String str2, @Field("teamTitle") @NotNull String str3, @NotNull Continuation<? super BaseEntity<OrganizeTeamBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/createSubject")
    @Nullable
    Object r0(@Field("channelNo") @NotNull String str, @Field("subjectCategoryNo") @NotNull String str2, @Field("subjectName") @NotNull String str3, @Field("subjectImg") @NotNull String str4, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/favorList")
    @Nullable
    Object s(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<NotifyFavoritesBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelMemberList")
    @Nullable
    Object s0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field(UserConstants.USER_PARAMS.b) @Nullable String str, @Field("channelNo") @NotNull String str2, @NotNull Continuation<? super BaseEntity<PubWorksMenuPageEntity<ChannelMemberBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/subjectMemberList")
    @Nullable
    Object t(@Field("pageNum") int i, @Field("pageSize") int i2, @Field(UserConstants.USER_PARAMS.b) @Nullable String str, @Field(yj7.b.SUBJECT_NO) @NotNull String str2, @NotNull Continuation<? super BaseEntity<PageEntity<ChannelMemberBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/deleteChannelTeam")
    @Nullable
    Object t0(@Field("channelNo") @NotNull String str, @Field("teamGroupCode") @NotNull String str2, @Field(TeamMemberManageActivity.C) @NotNull String str3, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/updateChannel")
    @Nullable
    Object u(@Field("channelNo") @NotNull String str, @Field("logo") @Nullable String str2, @Field("coverUrl") @Nullable String str3, @Field("coverHue") @Nullable String str4, @Field("channelName") @Nullable String str5, @Field("channelDescription") @Nullable String str6, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/setChannelClubAdminUser")
    @Nullable
    Object u0(@Field("channelNo") @NotNull String str, @Field("appUserCode") @NotNull String str2, @Field("clubCode") @NotNull String str3, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/addChannelTeam")
    @Nullable
    Object v(@Field("channelNo") @NotNull String str, @Field("teamGroupCode") @NotNull String str2, @Field("teamTitle") @NotNull String str3, @Field("logoUrl") @NotNull String str4, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/messageBox")
    @Nullable
    Object v0(@Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<NotifyMailBoxBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelSubAdminList")
    @Nullable
    Object w(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<ChannelAdminListBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/subjectDetail")
    @Nullable
    Object w0(@Field(yj7.b.SUBJECT_NO) @NotNull String str, @NotNull Continuation<? super BaseEntity<TopicMainBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/myChannelClubList")
    @Nullable
    Object x(@Field("channelNo") @NotNull String str, @Field("pageNum") int i, @Field("pageSize") int i2, @NotNull Continuation<? super BaseEntity<PageEntity<OrganizeBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/message/broadcastLiked")
    @Nullable
    Object x0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<NotifyFavoritesBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/channelAdList")
    @Nullable
    Object y(@Field("channelNo") @NotNull String str, @Field("type") int i, @Field("pageNum") int i2, @Field("pageSize") int i3, @NotNull Continuation<? super BaseEntity<PageEntity<AdvertiseBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/deleteSubjectCategory")
    @Nullable
    Object y0(@Field("channelNo") @NotNull String str, @Field("subjectCategoryNo") @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/clubMessageDetail")
    @Nullable
    Object z(@Field("messageCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<ClubMessageBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/addChannelTeamGroup")
    @Nullable
    Object z0(@Field("channelNo") @NotNull String str, @Field("teamGroupTitle") @NotNull String str2, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);
}
