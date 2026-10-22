package com.huachenjie.works.api;

import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.common.bean.BaseEntity;
import com.huachenjie.works.bean.BroadcastFloorBean;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
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
import com.huachenjie.works.bean.RecommendWorksBean;
import com.huachenjie.works.bean.SchoolMateBean;
import com.huachenjie.works.bean.SchoolmateConfigBean;
import com.huachenjie.works.bean.ThisSchoolBean;
import com.huachenjie.works.bean.ValidWorks;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.bean.WorksTagBean;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import com.huachenjie.works.bean.dorm.DormEnergyBean;
import com.huachenjie.works.bean.dorm.DormExchangeBean;
import com.huachenjie.works.bean.dorm.DormUserInfoBean;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.huachenjie.works.bean.publish.PubWorkTopicBean;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import com.huachenjie.works.bean.publish.PubWorksRequestIdBean;
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
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000eJW\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00042\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\tH§@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016JK\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00130\u00042\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019JW\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00130\u00042\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\tH§@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0016J#\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u00042\b\b\u0001\u0010 \u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\bJ#\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\b\b\u0001\u0010 \u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b#\u0010\bJ\u0019\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0004H§@ø\u0001\u0000¢\u0006\u0004\b%\u0010&Jc\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b)\u0010*JK\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b+\u0010,Jc\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b/\u0010*JK\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b2\u0010,J/\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u00103\u001a\u00020\u00022\b\b\u0001\u00104\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b5\u00106J)\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00050\u00042\b\b\u0001\u0010'\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b8\u0010\bJI\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010 \u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b:\u0010,JI\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010;\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b<\u0010,JS\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010 \u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b?\u0010@JS\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010 \u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bA\u0010@J#\u0010B\u001a\b\u0012\u0004\u0012\u0002090\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ#\u0010C\u001a\b\u0012\u0004\u0012\u0002090\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0004\bC\u0010\u001fJ#\u0010D\u001a\b\u0012\u0004\u0012\u00020>0\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ#\u0010E\u001a\b\u0012\u0004\u0012\u00020>0\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0004\bE\u0010\u001fJ\u001f\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u00050\u0004H§@ø\u0001\u0000¢\u0006\u0004\bG\u0010&J)\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\u00050\u00042\b\b\u0001\u0010H\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bJ\u0010\bJ?\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\bK\u0010\u000eJ_\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010L\u001a\u00020\u00022\b\b\u0003\u0010M\u001a\u00020\t2\n\b\u0003\u0010N\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ#\u0010S\u001a\b\u0012\u0004\u0012\u00020R0\u00042\b\b\u0001\u0010Q\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0004\bS\u0010TJA\u0010V\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020U\u0018\u00010\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\bV\u0010\u000eJ\u001f\u0010X\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0\u00050\u0004H§@ø\u0001\u0000¢\u0006\u0004\bX\u0010&J%\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Z0\u00042\b\b\u0001\u0010Y\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b[\u0010\bJ%\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\\0\u00042\b\b\u0001\u0010Q\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0004\b]\u0010TJO\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010 \u001a\u00020\u00022\b\b\u0001\u0010^\u001a\u00020\t2\b\b\u0001\u0010_\u001a\u00020\u00022\b\b\u0001\u0010`\u001a\u00020\u00022\n\b\u0001\u0010a\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\bb\u0010cJI\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010d\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\be\u0010,J%\u0010f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010 \u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bf\u0010\bJ3\u0010h\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010g\u001a\u0004\u0018\u00010\tH§@ø\u0001\u0000¢\u0006\u0004\bh\u0010iJ\u001b\u0010k\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010j0\u0004H§@ø\u0001\u0000¢\u0006\u0004\bk\u0010&J%\u0010m\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010l0\u00042\b\b\u0001\u0010=\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bm\u0010\bJ%\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010l0\u00042\b\b\u0001\u0010=\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bn\u0010\bJ\u0019\u0010p\u001a\b\u0012\u0004\u0012\u00020o0\u0004H§@ø\u0001\u0000¢\u0006\u0004\bp\u0010&JG\u0010s\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0\u00050\u00042\b\b\u0001\u0010q\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bs\u0010tJG\u0010u\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0\u00050\u00042\b\b\u0001\u0010q\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bu\u0010tJ%\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0004\bv\u0010\u001fJ\u001b\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010l0\u0004H§@ø\u0001\u0000¢\u0006\u0004\bw\u0010&J%\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010r0\u00042\b\b\u0001\u0010;\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\bx\u0010\bJ\u0019\u0010z\u001a\b\u0012\u0004\u0012\u00020y0\u0004H§@ø\u0001\u0000¢\u0006\u0004\bz\u0010&JE\u0010}\u001a\b\u0012\u0004\u0012\u00020|0\u00042\n\b\u0001\u0010{\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0004\b}\u0010\u0019J%\u0010\u007f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010~\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0004\b\u007f\u0010TJ)\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010\u00042\u000b\b\u0001\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u0082\u0001\u0010\bJ(\u0010\u0084\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\t\b\u0001\u0010\u0083\u0001\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u0084\u0001\u0010\bJ\u001c\u0010\u0086\u0001\u001a\t\u0012\u0005\u0012\u00030\u0085\u00010\u0004H§@ø\u0001\u0000¢\u0006\u0005\b\u0086\u0001\u0010&J-\u0010\u0089\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0088\u00010\u00050\u00042\t\b\u0001\u0010\u0087\u0001\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u0089\u0001\u0010\bJi\u0010\u008d\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008c\u00010\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000b\b\u0001\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0001\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0001\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u008d\u0001\u0010*JO\u0010\u008e\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008c\u00010\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000b\b\u0001\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u008e\u0001\u0010,J'\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010\u00042\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u0091\u0001\u0010\bJ\u001d\u0010\u0092\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010j0\u0004H§@ø\u0001\u0000¢\u0006\u0005\b\u0092\u0001\u0010&J'\u0010\u0093\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010l0\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0005\b\u0093\u0001\u0010\u001fJL\u0010\u0095\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\t\b\u0001\u0010\u0094\u0001\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u0095\u0001\u0010,JV\u0010\u0096\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\n\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u00022\t\b\u0001\u0010\u0094\u0001\u001a\u00020\u00022\b\b\u0001\u0010=\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u0096\u0001\u0010@J%\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u0002090\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0005\b\u0097\u0001\u0010\u001fJ%\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020>0\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0005\b\u0098\u0001\u0010\u001fJ'\u0010\u0099\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010l0\u00042\b\b\u0001\u0010=\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u0099\u0001\u0010\bJ(\u0010\u009a\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u009a\u0001\u0010\bJ(\u0010\u009b\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u009b\u0001\u0010\bJR\u0010\u009c\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\t\b\u0001\u0010\u008f\u0001\u001a\u00020\u00022\b\b\u0001\u0010^\u001a\u00020\t2\b\b\u0001\u0010_\u001a\u00020\u00022\b\b\u0001\u0010`\u001a\u00020\u00022\n\b\u0001\u0010a\u001a\u0004\u0018\u00010\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u009c\u0001\u0010cJ'\u0010\u009d\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010'\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b\u009d\u0001\u0010\bJ\u001e\u0010\u009f\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u009e\u00010\u0004H§@ø\u0001\u0000¢\u0006\u0005\b\u009f\u0001\u0010&J\"\u0010¡\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030 \u00010\u00050\u0004H§@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010&J\u001c\u0010£\u0001\u001a\t\u0012\u0005\u0012\u00030¢\u00010\u0004H§@ø\u0001\u0000¢\u0006\u0005\b£\u0001\u0010&JW\u0010¨\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030§\u00010\u00050\u00042\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\t\b\u0001\u0010¤\u0001\u001a\u00020\u00022\t\b\u0001\u0010¥\u0001\u001a\u00020\u00022\t\b\u0001\u0010¦\u0001\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0005\b¨\u0001\u0010@J\u001c\u0010ª\u0001\u001a\t\u0012\u0005\u0012\u00030©\u00010\u0004H§@ø\u0001\u0000¢\u0006\u0005\bª\u0001\u0010&J\u001c\u0010¬\u0001\u001a\t\u0012\u0005\u0012\u00030«\u00010\u0004H§@ø\u0001\u0000¢\u0006\u0005\b¬\u0001\u0010&J\u001c\u0010®\u0001\u001a\t\u0012\u0005\u0012\u00030\u00ad\u00010\u0004H§@ø\u0001\u0000¢\u0006\u0005\b®\u0001\u0010&J4\u0010±\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\t\b\u0001\u0010¯\u0001\u001a\u00020\u00022\t\b\u0001\u0010°\u0001\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0006\b±\u0001\u0010²\u0001J\u001c\u0010´\u0001\u001a\t\u0012\u0005\u0012\u00030³\u00010\u0004H§@ø\u0001\u0000¢\u0006\u0005\b´\u0001\u0010&J'\u0010µ\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0005\bµ\u0001\u0010\u001fJ,\u0010·\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030¶\u00010\u00050\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u001cH§@ø\u0001\u0000¢\u0006\u0005\b·\u0001\u0010\u001fJ\u001b\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H§@ø\u0001\u0000¢\u0006\u0005\b¸\u0001\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006¹\u0001"}, d2 = {"Lcom/huachenjie/works/api/WorksApi;", "", "", "refreshTime", "Lcom/huachenjie/common/bean/BaseEntity;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/works/external/bean/ChannelBean;", "p", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "pageNum", "pageSize", "Lcom/huachenjie/works/external/bean/WorkItemBean;", "c0", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/bean/WorkDetailBean;", "D", "keyword", "type", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;", bo.g, "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/bean/publish/PubWorkTopicBean;", "C", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/base/bean/UserInfoBean;", "o0", "Lokhttp3/RequestBody;", "body", "n", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", yj7.g.WORKS_NO, "Lcom/huachenjie/works/bean/ValidWorks;", "x", "L", "Lcom/huachenjie/works/bean/search/SearchHotSpotBean;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelNo", yj7.b.SUBJECT_NO, "e", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g0", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "channelClassificationNo", "channelNumber", "u", "title", "Lcom/huachenjie/works/bean/BuddyCardBean;", "j", "buddyCode", "applyMessage", "f", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/bean/ChatGroupBean;", "Z", "Lcom/huachenjie/works/bean/comment/CommentBean;", "A", yj7.g.BROADCAST_QUOTE_NO, "l0", "commentNo", "Lcom/huachenjie/works/bean/comment/CommentReplyBean;", "R", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i0", "M", "s", "m", "I", "Lcom/huachenjie/works/bean/RecommendWorksBean;", "Y", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "Lcom/huachenjie/works/bean/WorksTagBean;", j.o, "q0", "channelCategoryNo", "sportFlag", "workCategoryNo", "n0", "(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ActivityListActivity.t, "Lcom/huachenjie/works/bean/OfficialActivityBean;", "k", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/external/bean/CommentOnMeBean;", "V", "Lcom/huachenjie/works/bean/ChannelTabBean;", "v0", "subjectName", "Lcom/huachenjie/works/bean/CreateTopicResultBean;", "a0", "Lcom/huachenjie/works/bean/MultipleActivityData;", "X", "targetType", "authorNo", "shareAppUserCode", "targetNo", "v", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currWorksNo", "c", j.b, "visit", "w", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/bean/publish/PubWorksRequestIdBean;", "w0", "Lcom/alibaba/fastjson/JSONObject;", "T", "J", "Lcom/huachenjie/works/bean/BroadcastFloorBean;", "q", "scope", "Lcom/huachenjie/works/bean/BroadcastFloorMessageBean;", "x0", "(IIILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j0", "r0", "F", t.d, "Lcom/huachenjie/works/bean/OriginalCategoryListBean;", "H", "originalNo", "Lcom/huachenjie/works/bean/OriginalPageEntity;", "u0", "attachmentType", y6b.f, "schoolCode", "Lcom/huachenjie/works/bean/ThisSchoolBean;", "G", "adCode", "z0", "Lcom/huachenjie/works/bean/PostCategoryDataBean;", "y0", "postTypeId", "Lcom/huachenjie/works/bean/PostCategoryBean;", "k0", "postType", "tagNo", "Lcom/huachenjie/works/bean/PostItemBean;", "s0", "t", "postNo", "Lcom/huachenjie/works/bean/PostDetailBean;", "b0", "U", "e0", "bizNo", "i", "B", "f0", "P", "O", "y", "A0", y6b.g, "d", "Lcom/huachenjie/works/bean/OperatorCheckBean;", "d0", "Lcom/huachenjie/works/bean/PostedSchoolBean;", "N", "Lcom/huachenjie/works/bean/GoodStuffTabData;", "Q", "zoneNo", "deviceType", "deviceNumber", "Lcom/huachenjie/works/bean/GoodStuffBean;", "a", "Lcom/huachenjie/works/bean/dorm/DormUserInfoBean;", "t0", "Lcom/huachenjie/works/bean/dorm/DormEnergyBean;", "h0", "Lcom/huachenjie/works/bean/dorm/DormExchangeBean;", "E", "perksNo", "charmCost", "W", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/huachenjie/works/bean/SchoolmateConfigBean;", "m0", "b", "Lcom/huachenjie/works/bean/SchoolMateBean;", "K", "S", "works_release"}, k = 1, mv = {1, 8, 0})
public interface WorksApi {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ Object a(WorksApi worksApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return worksApi.j(i, i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryBuddySearch");
        }

        public static /* synthetic */ Object b(WorksApi worksApi, int i, int i2, String str, String str2, String str3, String str4, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return worksApi.u(i, i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryChannelList");
        }

        public static /* synthetic */ Object c(WorksApi worksApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryCommentOnMeList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return worksApi.V(i, i2, str, continuation);
        }

        public static /* synthetic */ Object d(WorksApi worksApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryCommentPageList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return worksApi.A(i, i2, str, str2, continuation);
        }

        public static /* synthetic */ Object e(WorksApi worksApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryCommentQuotePageList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return worksApi.l0(i, i2, str, str2, continuation);
        }

        public static /* synthetic */ Object f(WorksApi worksApi, int i, int i2, String str, String str2, String str3, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryCommentQuoteSubPageList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return worksApi.i0(i, i2, str, str2, str3, continuation);
        }

        public static /* synthetic */ Object g(WorksApi worksApi, int i, int i2, String str, String str2, String str3, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryCommentSubPageList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return worksApi.R(i, i2, str, str2, str3, continuation);
        }

        public static /* synthetic */ Object h(WorksApi worksApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryPostCommentPageList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return worksApi.i(i, i2, str, str2, continuation);
        }

        public static /* synthetic */ Object i(WorksApi worksApi, int i, int i2, String str, String str2, String str3, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryPostCommentSubPageList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return worksApi.B(i, i2, str, str2, str3, continuation);
        }

        public static /* synthetic */ Object j(WorksApi worksApi, String str, int i, int i2, String str2, Integer num, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return worksApi.p0((i3 & 1) != 0 ? null : str, i, i2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : num, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryPubWorksChannelList");
        }

        public static /* synthetic */ Object k(WorksApi worksApi, String str, int i, int i2, String str2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return worksApi.C((i3 & 1) != 0 ? null : str, i, i2, (i3 & 8) != 0 ? null : str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryPubWorksTopicList");
        }

        public static /* synthetic */ Object l(WorksApi worksApi, int i, int i2, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryRecommendPoolWorksList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return worksApi.q0(i, i2, str, continuation);
        }

        public static /* synthetic */ Object m(WorksApi worksApi, int i, int i2, String str, String str2, int i3, String str3, Continuation continuation, int i4, Object obj) {
            if (obj == null) {
                return worksApi.n0(i, i2, (i4 & 4) != 0 ? null : str, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? 0 : i3, (i4 & 32) != 0 ? null : str3, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryRecommendWorksList");
        }

        public static /* synthetic */ Object n(WorksApi worksApi, String str, int i, int i2, String str2, Integer num, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return worksApi.o0((i3 & 1) != 0 ? null : str, i, i2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : num, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: querySelectUserList");
        }

        public static /* synthetic */ Object o(WorksApi worksApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryVideoWorkList");
            }
            if ((i3 & 4) != 0) {
                str = null;
            }
            return worksApi.c(i, i2, str, str2, continuation);
        }

        public static /* synthetic */ Object p(WorksApi worksApi, int i, int i2, String str, String str2, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return worksApi.g0(i, i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchUserList");
        }

        public static /* synthetic */ Object q(WorksApi worksApi, int i, int i2, String str, String str2, String str3, String str4, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                return worksApi.e(i, i2, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchWorksList");
        }
    }

    @FormUrlEncoded
    @POST("run-front/api/works/comment/pageList")
    @Nullable
    Object A(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field(yj7.g.WORKS_NO) @NotNull String str2, @NotNull Continuation<? super BaseEntity<PageEntity<CommentBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/live/remove")
    @Nullable
    Object A0(@Field("postNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/live/comment/sub/pageList")
    @Nullable
    Object B(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("bizNo") @NotNull String str2, @Field("commentNo") @NotNull String str3, @NotNull Continuation<? super BaseEntity<PageEntity<CommentReplyBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/channel/subject/page/selectList")
    @Nullable
    Object C(@Field("keyword") @Nullable String str, @Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str2, @NotNull Continuation<? super BaseEntity<PubWorksMenuPageEntity<PubWorkTopicBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/follow/list")
    @Nullable
    Object D(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<WorkDetailBean>>> continuation);

    @POST("run-front/api/member/perks/list")
    @Nullable
    Object E(@NotNull Continuation<? super BaseEntity<DormExchangeBean>> continuation);

    @POST("run-front/api/social/quote/requestId")
    @Nullable
    Object F(@NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/mySchool/simpleInfo")
    @Nullable
    Object G(@Field("schoolCode") @Nullable String str, @NotNull Continuation<? super BaseEntity<ThisSchoolBean>> continuation);

    @POST("run-front/api/channel/original/category/list")
    @Nullable
    Object H(@NotNull Continuation<? super BaseEntity<OriginalCategoryListBean>> continuation);

    @POST("run-front/api/social/quote/comment/reply/post")
    @Nullable
    Object I(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<CommentReplyBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/quote/comment/remove")
    @Nullable
    Object J(@Field("commentNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @POST("run-front/api/schoolmate/recommend/search")
    @Nullable
    Object K(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<PageEntity<SchoolMateBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/details")
    @Nullable
    Object L(@Field(yj7.g.WORKS_NO) @NotNull String str, @NotNull Continuation<? super BaseEntity<WorkDetailBean>> continuation);

    @POST("run-front/api/works/comment/post")
    @Nullable
    Object M(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<CommentBean>> continuation);

    @POST("run-front/school/getPostedSchoolList")
    @Nullable
    Object N(@NotNull Continuation<? super BaseEntity<PageEntity<PostedSchoolBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/live/comment/remove")
    @Nullable
    Object O(@Field("commentNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @POST("run-front/api/social/live/comment/reply/post")
    @Nullable
    Object P(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<CommentReplyBean>> continuation);

    @POST("run-front/api/union/ad/zone/adZoneList")
    @Nullable
    Object Q(@NotNull Continuation<? super BaseEntity<GoodStuffTabData>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/comment/sub/pageList")
    @Nullable
    Object R(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field(yj7.g.WORKS_NO) @NotNull String str2, @Field("commentNo") @NotNull String str3, @NotNull Continuation<? super BaseEntity<PageEntity<CommentReplyBean>>> continuation);

    @POST("run-front/api/social/sayHello")
    @Nullable
    Object S(@NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/comment/remove")
    @Nullable
    Object T(@Field("commentNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @POST("run-front/api/social/live/requestId")
    @Nullable
    Object U(@NotNull Continuation<? super BaseEntity<PubWorksRequestIdBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/commentList")
    @Nullable
    Object V(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<CommentOnMeBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/member/perks/redeem")
    @Nullable
    Object W(@Field("perksNo") @NotNull String str, @Field("charmCost") int i, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/activity/list")
    @Nullable
    Object X(@Field(ActivityListActivity.t) int i, @NotNull Continuation<? super BaseEntity<MultipleActivityData>> continuation);

    @POST("run-front/api/works/category/list")
    @Nullable
    Object Y(@NotNull Continuation<? super BaseEntity<PageEntity<RecommendWorksBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/userGroup")
    @Nullable
    Object Z(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<ChatGroupBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/union/goods/page")
    @Nullable
    Object a(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("zoneNo") @NotNull String str, @Field("deviceType") @NotNull String str2, @Field("deviceNumber") @NotNull String str3, @NotNull Continuation<? super BaseEntity<PageEntity<GoodStuffBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/createSubject")
    @Nullable
    Object a0(@Field("subjectName") @NotNull String str, @NotNull Continuation<? super BaseEntity<CreateTopicResultBean>> continuation);

    @POST("run-front/api/user/tag/settings")
    @Nullable
    Object b(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/live/post/details")
    @Nullable
    Object b0(@Field("postNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<PostDetailBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/video/list")
    @Nullable
    Object c(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("currWorksNo") @NotNull String str2, @NotNull Continuation<? super BaseEntity<PageEntity<WorkDetailBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/channel/hotspot/works/list")
    @Nullable
    Object c0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<WorkItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/message/joinChannel")
    @Nullable
    Object d(@Field("channelNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/social/live/operator/count")
    @Nullable
    Object d0(@NotNull Continuation<? super BaseEntity<OperatorCheckBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/search/pageList")
    @Nullable
    Object e(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("keyword") @Nullable String str2, @Field("channelNo") @Nullable String str3, @Field(yj7.b.SUBJECT_NO) @Nullable String str4, @NotNull Continuation<? super BaseEntity<PageEntity<WorkItemBean>>> continuation);

    @POST("run-front/api/social/live/post")
    @Nullable
    Object e0(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<JSONObject>> continuation);

    @FormUrlEncoded
    @POST("run-front/buddy/apply")
    @Nullable
    Object f(@Field("buddyCode") @NotNull String str, @Field("applyMessage") @NotNull String str2, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/social/live/comment/post")
    @Nullable
    Object f0(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<CommentBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/access/valid")
    @Nullable
    Object g(@Field("attachmentType") int i, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/user/search/pageList")
    @Nullable
    Object g0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("keyword") @Nullable String str2, @NotNull Continuation<? super BaseEntity<PageEntity<UserInfoBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/mySchool/share")
    @Nullable
    Object h(@Field("postNo") @NotNull String str, @Field("targetType") int i, @Field("authorNo") @NotNull String str2, @Field("shareAppUserCode") @NotNull String str3, @Field("targetNo") @Nullable String str4, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/space/energy/status")
    @Nullable
    Object h0(@NotNull Continuation<? super BaseEntity<DormEnergyBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/live/comment/pageList")
    @Nullable
    Object i(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("bizNo") @NotNull String str2, @NotNull Continuation<? super BaseEntity<PageEntity<CommentBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/quote/comment/sub/pageList")
    @Nullable
    Object i0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field(yj7.g.BROADCAST_QUOTE_NO) @NotNull String str2, @Field("commentNo") @NotNull String str3, @NotNull Continuation<? super BaseEntity<PageEntity<CommentReplyBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/buddy/search")
    @Nullable
    Object j(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("title") @Nullable String str2, @NotNull Continuation<? super BaseEntity<PageEntity<BuddyCardBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/quote/match/list")
    @Nullable
    Object j0(@Field("scope") int i, @Field("pageNum") int i2, @Field("pageSize") int i3, @Field("refreshTime") @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<BroadcastFloorMessageBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/home/activityEntry")
    @Nullable
    Object k(@Field(ActivityListActivity.t) int i, @NotNull Continuation<? super BaseEntity<OfficialActivityBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/live/post/tag/findByType")
    @Nullable
    Object k0(@Field("postTypeId") @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<PostCategoryBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/quote")
    @Nullable
    Object l(@Field(yj7.g.BROADCAST_QUOTE_NO) @NotNull String str, @NotNull Continuation<? super BaseEntity<BroadcastFloorMessageBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/quote/comment/pageList")
    @Nullable
    Object l0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field(yj7.g.BROADCAST_QUOTE_NO) @NotNull String str2, @NotNull Continuation<? super BaseEntity<PageEntity<CommentBean>>> continuation);

    @POST("run-front/api/works/comment/reply/post")
    @Nullable
    Object m(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<CommentReplyBean>> continuation);

    @POST("run-front/api/schoolmate/search/config")
    @Nullable
    Object m0(@NotNull Continuation<? super BaseEntity<SchoolmateConfigBean>> continuation);

    @POST("run-front/api/works/submit/note")
    @Nullable
    Object n(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<WorkDetailBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/recommend/list")
    @Nullable
    Object n0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("channelCategoryNo") @NotNull String str2, @Field("sportFlag") int i3, @Field("workCategoryNo") @Nullable String str3, @NotNull Continuation<? super BaseEntity<PageEntity<WorkItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/remove")
    @Nullable
    Object o(@Field(yj7.g.WORKS_NO) @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/user/page/selectList")
    @Nullable
    Object o0(@Field("keyword") @Nullable String str, @Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str2, @Field("type") @Nullable Integer num, @NotNull Continuation<? super BaseEntity<PubWorksMenuPageEntity<UserInfoBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/channel/hotspot/list")
    @Nullable
    Object p(@Field("refreshTime") @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<ChannelBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/channel/page/selectList")
    @Nullable
    Object p0(@Field("keyword") @Nullable String str, @Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str2, @Field("type") @Nullable Integer num, @NotNull Continuation<? super BaseEntity<PubWorksMenuPageEntity<PubWorkChannelBean>>> continuation);

    @POST("run-front/api/social/broadcast/home")
    @Nullable
    Object q(@NotNull Continuation<? super BaseEntity<BroadcastFloorBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/recommend/pool/list")
    @Nullable
    Object q0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @NotNull Continuation<? super BaseEntity<PageEntity<WorkItemBean>>> continuation);

    @POST("run-front/api/channel/subject/hotspot/rank")
    @Nullable
    Object r(@NotNull Continuation<? super BaseEntity<SearchHotSpotBean>> continuation);

    @POST("run-front/api/social/quote/submit")
    @Nullable
    Object r0(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/social/quote/comment/post")
    @Nullable
    Object s(@Body @NotNull RequestBody requestBody, @NotNull Continuation<? super BaseEntity<CommentBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/live/post/feed")
    @Nullable
    Object s0(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("postType") @Nullable String str2, @Field("tagNo") @Nullable String str3, @Field("schoolCode") @Nullable String str4, @NotNull Continuation<? super BaseEntity<PageEntity<PostItemBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/live/post/hot")
    @Nullable
    Object t(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("schoolCode") @Nullable String str2, @NotNull Continuation<? super BaseEntity<PageEntity<PostItemBean>>> continuation);

    @POST("run-front/api/space/homePageMetaInfo")
    @Nullable
    Object t0(@NotNull Continuation<? super BaseEntity<DormUserInfoBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/channel/search/pageList")
    @Nullable
    Object u(@Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str, @Field("keyword") @Nullable String str2, @Field("channelClassificationNo") @Nullable String str3, @Field("channelNumber") @Nullable String str4, @NotNull Continuation<? super BaseEntity<PageEntity<ChannelBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/channel/original/hotspot/list")
    @Nullable
    Object u0(@Field("originalNo") @Nullable String str, @Field("pageNum") int i, @Field("pageSize") int i2, @Field("refreshTime") @Nullable String str2, @NotNull Continuation<? super BaseEntity<OriginalPageEntity>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/share")
    @Nullable
    Object v(@Field(yj7.g.WORKS_NO) @NotNull String str, @Field("targetType") int i, @Field("authorNo") @NotNull String str2, @Field("shareAppUserCode") @NotNull String str3, @Field("targetNo") @Nullable String str4, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/channel/classification/pageList")
    @Nullable
    Object v0(@NotNull Continuation<? super BaseEntity<PageEntity<ChannelTabBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/updateVisit")
    @Nullable
    Object w(@Field(yj7.g.WORKS_NO) @Nullable String str, @Field("visit") @Nullable Integer num, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/works/note/requestId")
    @Nullable
    Object w0(@NotNull Continuation<? super BaseEntity<PubWorksRequestIdBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/valid")
    @Nullable
    Object x(@Field(yj7.g.WORKS_NO) @NotNull String str, @NotNull Continuation<? super BaseEntity<ValidWorks>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/quote/list")
    @Nullable
    Object x0(@Field("scope") int i, @Field("pageNum") int i2, @Field("pageSize") int i3, @Field("refreshTime") @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<BroadcastFloorMessageBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/social/live/post/query/valid")
    @Nullable
    Object y(@Field("postNo") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);

    @POST("run-front/api/social/live/post/type/list")
    @Nullable
    Object y0(@NotNull Continuation<? super BaseEntity<PostCategoryDataBean>> continuation);

    @FormUrlEncoded
    @POST("run-front/api/works/category/tag/list")
    @Nullable
    Object z(@Field(yj7.g.WORKS_PUBLISH_CATEGORY_NO) @NotNull String str, @NotNull Continuation<? super BaseEntity<PageEntity<WorksTagBean>>> continuation);

    @FormUrlEncoded
    @POST("run-front/mySchool/checkAd")
    @Nullable
    Object z0(@Field("adCode") @NotNull String str, @NotNull Continuation<? super BaseEntity<Object>> continuation);
}
