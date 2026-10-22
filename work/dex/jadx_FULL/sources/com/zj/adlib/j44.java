package com.zj.adlib;

import com.huachenjie.im.api.IMApi;
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
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class j44 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IMApi f42504a;

    public static IMApi f() {
        if (f42504a == null) {
            synchronized (IMApi.class) {
                if (f42504a == null) {
                    f42504a = (IMApi) lo7.e().d(IMApi.class);
                }
            }
        }
        return f42504a;
    }

    public Observable<BaseEntity<Object>> a(String str) {
        return f().m(str);
    }

    public Observable<BaseEntity<Object>> b(String str) {
        return f().n(str);
    }

    public Observable<BaseEntity<AllianceInviteBean>> c(String str) {
        return f().b(str);
    }

    public Observable<BaseEntity<DealInviteBean>> d(String str, int i) {
        return f().k(str, i);
    }

    @FormUrlEncoded
    @POST("run-front/metaverse/team/getEnterTeamInfo")
    public Observable<BaseEntity<EnterRoomBean>> e(String str) {
        return f().a(str);
    }

    public Observable<BaseEntity<IMTokenBean>> g() {
        return f().i();
    }

    public Observable<BaseEntity<RemoteExtBean>> h() {
        return f().j();
    }

    public Observable<BaseEntity<TeamBean>> i(String str) {
        return f().d(str);
    }

    public Observable<BaseEntity<ChatUserBean>> j(String str) {
        return f().f(str);
    }

    public Observable<BaseEntity<Object>> k(String str) {
        return f().c(str);
    }

    public Observable<BaseEntity<Object>> l(String str) {
        return f().g(str);
    }

    public Observable<BaseEntity<FollowBean>> m(String str) {
        return f().o(str);
    }

    public Observable<BaseEntity<EmojiDetailData>> n(String str) {
        return f().e(str);
    }

    public Observable<BaseEntity<EmojiListData>> o() {
        return f().l();
    }

    public Observable<BaseEntity<Object>> p(String str, String str2) {
        return f().h(str, str2);
    }
}
