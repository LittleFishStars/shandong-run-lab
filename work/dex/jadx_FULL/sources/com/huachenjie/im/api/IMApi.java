package com.huachenjie.im.api;

import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.bean.AllianceInviteBean;
import com.huachenjie.im.bean.ChatUserBean;
import com.huachenjie.im.bean.DealInviteBean;
import com.huachenjie.im.bean.EmojiDetailData;
import com.huachenjie.im.bean.EmojiListData;
import com.huachenjie.im.bean.EnterRoomBean;
import com.huachenjie.im.bean.FollowBean;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.im.bean.RemoteExtBean;
import com.huachenjie.im.bean.TeamBean;
import huachenjie.sdk.http.BaseEntity;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IMApi {
    @FormUrlEncoded
    @POST("run-front/metaverse/team/getEnterTeamInfo")
    Observable<BaseEntity<EnterRoomBean>> a(@Field(UserConstants.CHAT_PARAMS.l) String str);

    @FormUrlEncoded
    @POST("run-front/covenantGod/inviteStatus")
    Observable<BaseEntity<AllianceInviteBean>> b(@Field("metaverseCovenantInviteCode") String str);

    @FormUrlEncoded
    @POST("run-front/metaverse/team/inviteStatus")
    Observable<BaseEntity<Object>> c(@Field("inviteRecordCode") String str);

    @FormUrlEncoded
    @POST("run-front/metaverse/team/detail")
    Observable<BaseEntity<TeamBean>> d(@Field(UserConstants.CHAT_PARAMS.l) String str);

    @FormUrlEncoded
    @POST("run-front/emoji/syncEmoji")
    Observable<BaseEntity<EmojiDetailData>> e(@Field("emojiBagCode") String str);

    @FormUrlEncoded
    @POST("run-front/metaverse/user/getUser")
    Observable<BaseEntity<ChatUserBean>> f(@Field("accid") String str);

    @FormUrlEncoded
    @POST("run-front/covenantGod/rejectedFriend")
    Observable<BaseEntity<Object>> g(@Field("metaverseCovenantInviteCode") String str);

    @FormUrlEncoded
    @POST("run-front/api/user/friend/updateAlias")
    Observable<BaseEntity<Object>> h(@Field("friendAccId") String str, @Field("alias") String str2);

    @POST("run-front/account/getYunXinToken")
    Observable<BaseEntity<IMTokenBean>> i();

    @POST("run-front/metaverse/user/getMetaverseUserInfo")
    Observable<BaseEntity<RemoteExtBean>> j();

    @FormUrlEncoded
    @POST("run-front/metaverse/team/dealInviteRecord")
    Observable<BaseEntity<DealInviteBean>> k(@Field("inviteRecordCode") String str, @Field("status") int i);

    @POST("run-front/emoji/syncEmojiBag")
    Observable<BaseEntity<EmojiListData>> l();

    @FormUrlEncoded
    @POST("run-front/covenantGod/agreeFriend")
    Observable<BaseEntity<Object>> m(@Field("metaverseCovenantInviteCode") String str);

    @FormUrlEncoded
    @POST("run-front/metaverse/friend/agreeFriendGoods")
    Observable<BaseEntity<Object>> n(@Field("sendFriendCode") String str);

    @FormUrlEncoded
    @POST("run-front/api/my/isFollow")
    Observable<BaseEntity<FollowBean>> o(@Field("accid") String str);
}
