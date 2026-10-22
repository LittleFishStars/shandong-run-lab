package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.OperateCallback;
import com.huachenjie.im.bean.ErrorUserInfo;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.im.bean.RemoteExtBean;
import com.huachenjie.im.custom.MessageTimeAttachment;
import com.huachenjie.im.custom.ShareGoodsAttachment;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.RequestCallbackWrapper;
import com.netease.nimlib.sdk.chatroom.ChatRoomMessageBuilder;
import com.netease.nimlib.sdk.chatroom.ChatRoomService;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMessage;
import com.netease.nimlib.sdk.chatroom.model.EnterChatRoomData;
import com.netease.nimlib.sdk.chatroom.model.EnterChatRoomResultData;
import com.netease.nimlib.sdk.friend.FriendService;
import com.netease.nimlib.sdk.friend.constant.FriendFieldEnum;
import com.netease.nimlib.sdk.friend.constant.VerifyType;
import com.netease.nimlib.sdk.friend.model.AddFriendData;
import com.netease.nimlib.sdk.friend.model.Friend;
import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.SystemMessageService;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.constant.DeleteTypeEnum;
import com.netease.nimlib.sdk.msg.constant.MsgStatusEnum;
import com.netease.nimlib.sdk.msg.constant.MsgTypeEnum;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.constant.SystemMessageType;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.msg.model.SystemMessage;
import com.netease.nimlib.sdk.uinfo.UserService;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import com.netease.nimlib.session.IMMessageImpl;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class dj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RemoteExtBean f41189a = new RemoteExtBean();

    public class a extends DefaultCallback<List<NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41190a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f16002a;

        public a(List list, OperateCallback operateCallback) {
            this.f16002a = list;
            this.f41190a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public void onResult(int i, @Nullable List<NimUserInfo> list, @Nullable Throwable th) {
            try {
                if (i != 200 || list == null) {
                    dj1.L(this.f41190a);
                    return;
                }
                for (NimUserInfo nimUserInfo : list) {
                    if (nimUserInfo != null) {
                        this.f16002a.add(nimUserInfo);
                    }
                }
                this.f41190a.onSuccess(this.f16002a);
            } catch (Exception e) {
                dj1.L(this.f41190a);
                e.printStackTrace();
            }
        }
    }

    public class b extends RequestCallbackWrapper<List<NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41191a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f16003a;

        public b(List list, OperateCallback operateCallback) {
            this.f16003a = list;
            this.f41191a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, List<NimUserInfo> list, Throwable th) {
            i4a.a("查询总长度:" + this.f16003a.size());
            List listN = dj1.n(i, list, this.f16003a);
            OperateCallback operateCallback = this.f41191a;
            if (operateCallback != null) {
                operateCallback.onSuccess(listN);
            }
        }
    }

    public class c extends RequestCallbackWrapper<List<NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f41192a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ long f16004a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ OperateCallback f16005a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f16006a;
        public final /* synthetic */ List b;

        public c(List list, List list2, int i, long j, OperateCallback operateCallback) {
            this.f16006a = list;
            this.b = list2;
            this.f41192a = i;
            this.f16004a = j;
            this.f16005a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, List<NimUserInfo> list, Throwable th) {
            this.f16006a.addAll(dj1.n(i, list, this.b));
            i4a.a("第" + this.f41192a + "次查询耗时:" + (System.currentTimeMillis() - this.f16004a));
            this.f16005a.onSuccess(this.f16006a);
        }
    }

    public class d extends RequestCallbackWrapper<List<NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f41193a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ long f16007a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ OperateCallback f16008a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ UserService f16009a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f16010a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;

        public d(List list, List list2, int i, long j, UserService userService, List list3, OperateCallback operateCallback) {
            this.f16010a = list;
            this.b = list2;
            this.f41193a = i;
            this.f16007a = j;
            this.f16009a = userService;
            this.c = list3;
            this.f16008a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, List<NimUserInfo> list, Throwable th) {
            this.f16010a.addAll(dj1.n(i, list, this.b));
            i4a.a("第" + this.f41193a + "次查询耗时:" + (System.currentTimeMillis() - this.f16007a));
            dj1.E(this.f16009a, this.f16010a, this.f41193a + 1, this.c, this.f16008a);
        }
    }

    public class e extends RequestCallbackWrapper<List<NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41194a;
        public final /* synthetic */ String b;

        public e(String str, OperateCallback operateCallback) {
            this.b = str;
            this.f41194a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, List<NimUserInfo> list, Throwable th) {
            String str;
            boolean z;
            Friend friendByAccount;
            String alias = "";
            if (dj1.i(this.b)) {
                FriendService friendService = (FriendService) k44.a(FriendService.class);
                z = true;
                if (friendService != null && (friendByAccount = friendService.getFriendByAccount(this.b)) != null) {
                    alias = friendByAccount.getAlias();
                }
                str = alias;
            } else {
                str = "";
                z = false;
            }
            if (i != 200 || list == null || list.isEmpty() || list.get(0) == null) {
                OperateCallback operateCallback = this.f41194a;
                if (operateCallback != null) {
                    operateCallback.onSuccess(new FriendUserInfo(this.b, "陌生人", "", str, "", "", "", Boolean.FALSE));
                    return;
                }
                return;
            }
            FriendUserInfo friendUserInfoE0 = dj1.e0(list.get(0), str, z);
            OperateCallback operateCallback2 = this.f41194a;
            if (operateCallback2 != null) {
                operateCallback2.onSuccess(friendUserInfoE0);
            }
        }
    }

    public class f extends DefaultCallback<List<NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41195a;

        public f(OperateCallback operateCallback) {
            this.f41195a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public void onResult(int i, @Nullable List<NimUserInfo> list, @Nullable Throwable th) {
            try {
                if (i != 200 || list == null) {
                    dj1.L(this.f41195a);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NimUserInfo nimUserInfo : list) {
                    if (nimUserInfo != null) {
                        arrayList.add(dj1.i(nimUserInfo.getAccount()) ? dj1.e0(nimUserInfo, dj1.s(nimUserInfo.getAccount()), true) : dj1.e0(nimUserInfo, "", false));
                    }
                }
                this.f41195a.onSuccess(arrayList);
            } catch (Exception e) {
                dj1.L(this.f41195a);
                e.printStackTrace();
            }
        }
    }

    public class g extends DefaultCallback<IMTokenBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41196a;

        public g(OperateCallback operateCallback) {
            this.f41196a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, IMTokenBean iMTokenBean, Throwable th) {
            if (i == 200) {
                dj1.C(this.f41196a);
            } else {
                dj1.L(this.f41196a);
            }
        }
    }

    public class h extends DefaultCallback<List<NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41197a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f16011a;

        public h(Map map, OperateCallback operateCallback) {
            this.f16011a = map;
            this.f41197a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public void onResult(int i, @Nullable List<NimUserInfo> list, @Nullable Throwable th) {
            try {
                if (i != 200 || list == null) {
                    dj1.L(this.f41197a);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NimUserInfo nimUserInfo : list) {
                    if (nimUserInfo != null) {
                        Friend friend = (Friend) this.f16011a.get(nimUserInfo.getAccount());
                        arrayList.add(dj1.e0(nimUserInfo, friend == null ? "" : friend.getAlias(), true));
                    }
                }
                this.f41197a.onSuccess(arrayList);
            } catch (Exception e) {
                dj1.L(this.f41197a);
                e.printStackTrace();
            }
        }
    }

    public class i extends RequestCallbackWrapper<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41198a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ SessionTypeEnum f16012a;
        public final /* synthetic */ String b;

        public i(String str, SessionTypeEnum sessionTypeEnum, OperateCallback operateCallback) {
            this.b = str;
            this.f16012a = sessionTypeEnum;
            this.f41198a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, Void r3, Throwable th) {
            i4a.a("code：" + i);
            wt1.h().f(this.b, this.f16012a);
            OperateCallback operateCallback = this.f41198a;
            if (operateCallback != null) {
                operateCallback.onSuccess(r3);
            }
        }
    }

    public class j implements RequestCallback<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41199a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ IMMessage f16013a;

        public j(OperateCallback operateCallback, IMMessage iMMessage) {
            this.f41199a = operateCallback;
            this.f16013a = iMMessage;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            OperateCallback operateCallback = this.f41199a;
            if (operateCallback != null) {
                operateCallback.onSuccess(this.f16013a);
            }
        }

        public void onException(Throwable th) {
            OperateCallback operateCallback = this.f41199a;
            if (operateCallback != null) {
                operateCallback.onException(th);
            }
        }

        public void onFailed(int i) {
            i4a.b(p44.f18767a, "错误code：" + i);
            if (i != 7101) {
                OperateCallback operateCallback = this.f41199a;
                if (operateCallback != null) {
                    operateCallback.onFailed(i);
                    return;
                }
                return;
            }
            this.f16013a.setStatus(MsgStatusEnum.fail);
            Map remoteExtension = this.f16013a.getRemoteExtension();
            if (remoteExtension == null) {
                remoteExtension = new HashMap();
            }
            remoteExtension.put("isInBlackList", Boolean.TRUE);
            this.f16013a.setRemoteExtension(remoteExtension);
            OperateCallback operateCallback2 = this.f41199a;
            if (operateCallback2 != null) {
                operateCallback2.onSuccess(this.f16013a);
            }
        }
    }

    public class k extends DefaultCallback<IMTokenBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41200a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ MsgAttachment f16014a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f16015a;

        public k(MsgAttachment msgAttachment, String str, OperateCallback operateCallback) {
            this.f16014a = msgAttachment;
            this.f16015a = str;
            this.f41200a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, IMTokenBean iMTokenBean, Throwable th) {
            if (i == 200) {
                dj1.O(this.f16014a, this.f16015a, this.f41200a);
            } else {
                dj1.L(this.f41200a);
            }
        }
    }

    public class l extends DefaultCallback<IMTokenBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41201a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f16016a;

        public l(String str, OperateCallback operateCallback) {
            this.f16016a = str;
            this.f41201a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, IMTokenBean iMTokenBean, Throwable th) {
            if (i == 200) {
                dj1.S("已成功添加为好友，现在可以开始聊天了", this.f16016a, this.f41201a);
            } else {
                dj1.L(this.f41201a);
            }
        }
    }

    public class m implements RequestCallback<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41202a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ChatRoomMessage f16017a;

        public m(OperateCallback operateCallback, ChatRoomMessage chatRoomMessage) {
            this.f41202a = operateCallback;
            this.f16017a = chatRoomMessage;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            OperateCallback operateCallback = this.f41202a;
            if (operateCallback != null) {
                operateCallback.onSuccess(this.f16017a);
            }
        }

        public void onException(Throwable th) {
            OperateCallback operateCallback = this.f41202a;
            if (operateCallback != null) {
                operateCallback.onException(th);
            }
        }

        public void onFailed(int i) {
            i4a.b(p44.f18767a, "错误code：" + i);
            OperateCallback operateCallback = this.f41202a;
            if (operateCallback != null) {
                operateCallback.onFailed(i);
            }
        }
    }

    public class n implements RequestCallback<EnterChatRoomResultData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41203a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ MsgAttachment f16018a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f16019a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RemoteExtBean[] f16020a;

        public n(MsgAttachment msgAttachment, String str, RemoteExtBean[] remoteExtBeanArr, OperateCallback operateCallback) {
            this.f16018a = msgAttachment;
            this.f16019a = str;
            this.f16020a = remoteExtBeanArr;
            this.f41203a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(EnterChatRoomResultData enterChatRoomResultData) {
            dj1.U(this.f16018a, this.f16019a, this.f16020a[0], this.f41203a);
        }

        public void onException(Throwable th) {
            i4a.a("enter error");
            dj1.L(this.f41203a);
        }

        public void onFailed(int i) {
            i4a.a("enter room fail");
            dj1.L(this.f41203a);
        }
    }

    public class o extends DefaultCallback<RemoteExtBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41204a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RequestCallback f16021a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f16022a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RemoteExtBean[] f16023a;

        public o(RemoteExtBean[] remoteExtBeanArr, String str, RequestCallback requestCallback, OperateCallback operateCallback) {
            this.f16023a = remoteExtBeanArr;
            this.f16022a = str;
            this.f16021a = requestCallback;
            this.f41204a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, @Nullable RemoteExtBean remoteExtBean, @Nullable Throwable th) {
            ChatRoomService chatRoomService = (ChatRoomService) k44.a(ChatRoomService.class);
            if (i != 200 || remoteExtBean == null || chatRoomService == null) {
                dj1.L(this.f41204a);
            } else {
                this.f16023a[0] = remoteExtBean;
                chatRoomService.enterChatRoomEx(new EnterChatRoomData(this.f16022a), 1).setCallback(this.f16021a);
            }
        }
    }

    public class p extends DefaultCallback<IMTokenBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DefaultCallback f41205a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ OperateCallback f16024a;

        public p(DefaultCallback defaultCallback, OperateCallback operateCallback) {
            this.f41205a = defaultCallback;
            this.f16024a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, IMTokenBean iMTokenBean, Throwable th) {
            if (i == 200) {
                p44.m(this.f41205a);
            } else {
                dj1.L(this.f16024a);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class q<T> implements RequestCallback<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41206a;

        public q(OperateCallback operateCallback) {
            this.f41206a = operateCallback;
        }

        public void onException(Throwable th) {
            i4a.a("异常：" + th.getMessage());
            OperateCallback operateCallback = this.f41206a;
            if (operateCallback != null) {
                operateCallback.onException(th);
            }
        }

        public void onFailed(int i) {
            i4a.a("错误code：" + i);
            OperateCallback operateCallback = this.f41206a;
            if (operateCallback != null) {
                operateCallback.onFailed(i);
            }
        }

        public void onSuccess(T t) {
            OperateCallback operateCallback = this.f41206a;
            if (operateCallback != null) {
                operateCallback.onSuccess(t);
            }
        }
    }

    public class r extends DefaultCallback<List<NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f41207a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f16025a;

        public r(OperateCallback operateCallback, String str) {
            this.f41207a = operateCallback;
            this.f16025a = str;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public void onResult(int i, @Nullable List<NimUserInfo> list, @Nullable Throwable th) {
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            if (friendService == null) {
                dj1.L(this.f41207a);
            } else {
                friendService.ackAddFriendRequest(this.f16025a, true).setCallback(dj1.l(this.f41207a));
            }
        }
    }

    public static boolean A(String str) {
        try {
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            if (friendService == null) {
                return false;
            }
            return friendService.isInBlackList(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @UiThread
    public static void B(OperateCallback<List<FriendUserInfo>> operateCallback) {
        if (p44.r()) {
            C(operateCallback);
            return;
        }
        try {
            p44.j(new g(operateCallback));
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    @UiThread
    public static void C(OperateCallback<List<FriendUserInfo>> operateCallback) {
        UserService userService = (UserService) k44.a(UserService.class);
        FriendService friendService = (FriendService) k44.a(FriendService.class);
        if (userService == null || friendService == null) {
            L(operateCallback);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Friend> friends = friendService.getFriends();
        if (friends == null) {
            friends = new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Friend friend : friends) {
            if (friend != null) {
                linkedHashMap.put(friend.getAccount(), friend);
                arrayList.add(friend.getAccount());
            }
        }
        i4a.c("friend size:" + linkedHashMap.size());
        if (linkedHashMap.size() == 0) {
            operateCallback.onSuccess(new ArrayList());
        } else {
            D(arrayList, new h(linkedHashMap, operateCallback));
        }
    }

    @UiThread
    public static void D(List<String> list, OperateCallback<List<NimUserInfo>> operateCallback) {
        i4a.a("queryLocalUserInfo:");
        UserService userService = (UserService) k44.a(UserService.class);
        if (userService == null || list == null || list.size() == 0) {
            L(operateCallback);
            return;
        }
        List<NimUserInfo> userInfoList = userService.getUserInfoList(list);
        i4a.c("本地用户数:" + userInfoList.size());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (NimUserInfo nimUserInfo : userInfoList) {
            if (nimUserInfo != null) {
                arrayList2.add(nimUserInfo.getAccount());
                arrayList.add(nimUserInfo);
            }
        }
        i4a.c("本地用户（不为空）数:" + arrayList.size());
        if (list.size() == arrayList.size()) {
            operateCallback.onSuccess(arrayList);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (String str : list) {
            if (!arrayList2.contains(str)) {
                arrayList3.add(str);
            }
        }
        i4a.c("存在本地用户为空，未知用户数:" + arrayList3.size());
        F(arrayList3, new a(arrayList, operateCallback));
    }

    public static void E(UserService userService, List<NimUserInfo> list, int i2, List<String> list2, OperateCallback<List<NimUserInfo>> operateCallback) {
        i4a.a("开始:" + i2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i3 = (i2 + 1) * 150;
        if (i3 > list2.size()) {
            List<String> listSubList = list2.subList(i2 * 150, list2.size());
            i4a.a("查询长度:" + listSubList.size());
            userService.fetchUserInfo(listSubList).setCallback(new c(list, listSubList, i2, jCurrentTimeMillis, operateCallback));
            return;
        }
        List<String> listSubList2 = list2.subList(i2 * 150, i3);
        i4a.a("查询长度:" + listSubList2.size());
        userService.fetchUserInfo(listSubList2).setCallback(new d(list, listSubList2, i2, jCurrentTimeMillis, userService, list2, operateCallback));
    }

    @UiThread
    public static void F(List<String> list, OperateCallback<List<NimUserInfo>> operateCallback) {
        i4a.a("queryUserInfo:");
        try {
            G(list, operateCallback);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @UiThread
    public static void G(List<String> list, @NonNull OperateCallback<List<NimUserInfo>> operateCallback) {
        i4a.a("queryUserInfoByPage:");
        UserService userService = (UserService) k44.a(UserService.class);
        if (userService == null || list == null || list.size() == 0) {
            L(operateCallback);
            return;
        }
        if (list.size() <= 150) {
            userService.fetchUserInfo(list).setCallback(new b(list, operateCallback));
            return;
        }
        i4a.a("查询总长度:" + list.size());
        E(userService, new ArrayList(), 0, list, operateCallback);
    }

    public static void H(List<String> list, OperateCallback<List<FriendUserInfo>> operateCallback) {
        if (((UserService) k44.a(UserService.class)) == null) {
            L(operateCallback);
        } else {
            D(list, new f(operateCallback));
        }
    }

    public static void I(String str, String str2, int i2) {
        RemoteExtBean remoteExtBean = f41189a;
        remoteExtBean.setAvatar(str);
        remoteExtBean.setAvatarFrameImgUrl(str2);
        remoteExtBean.setRoleType(i2);
    }

    @UiThread
    public static void J(String str, OperateCallback<Void> operateCallback) {
        try {
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            if (friendService == null) {
                L(operateCallback);
            } else {
                friendService.ackAddFriendRequest(str, false).setCallback(l(operateCallback));
            }
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    public static void K(String str, OperateCallback<Void> operateCallback) {
        try {
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            if (friendService == null) {
                L(operateCallback);
            } else {
                friendService.removeFromBlackList(str).setCallback(l(operateCallback));
            }
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    public static void L(OperateCallback operateCallback) {
        if (operateCallback != null) {
            operateCallback.onFailed(404);
        }
    }

    @UiThread
    public static void M(String str, OperateCallback<IMMessage> operateCallback) {
        p44.j(new l(str, operateCallback));
    }

    @UiThread
    public static void N(File file, long j2, String str, OperateCallback<IMMessage> operateCallback) {
        Y((MsgService) k44.a(MsgService.class), MessageBuilder.createAudioMessage(str, SessionTypeEnum.P2P, file, j2), operateCallback);
    }

    @UiThread
    public static void O(@NonNull MsgAttachment msgAttachment, String str, OperateCallback<IMMessage> operateCallback) {
        Y((MsgService) k44.a(MsgService.class), MessageBuilder.createCustomMessage(str, SessionTypeEnum.P2P, msgAttachment), operateCallback);
    }

    @UiThread
    public static void P(@NonNull MsgAttachment msgAttachment, String str, OperateCallback<IMMessage> operateCallback) {
        p44.j(new k(msgAttachment, str, operateCallback));
    }

    @UiThread
    public static void Q(@NonNull MsgAttachment msgAttachment, String str, OperateCallback<ChatRoomMessage> operateCallback) {
        if (operateCallback == null) {
            return;
        }
        try {
            RemoteExtBean[] remoteExtBeanArr = {null};
            p44.j(new p(new o(remoteExtBeanArr, str, new n(msgAttachment, str, remoteExtBeanArr, operateCallback), operateCallback), operateCallback));
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    @UiThread
    public static void R(String str, String str2, OperateCallback<IMMessage> operateCallback) {
        SessionTypeEnum sessionTypeEnum = SessionTypeEnum.P2P;
        File file = new File(str);
        Y((MsgService) k44.a(MsgService.class), MessageBuilder.createImageMessage(str2, sessionTypeEnum, file, file.getName()), operateCallback);
    }

    @UiThread
    public static void S(String str, String str2, OperateCallback<IMMessage> operateCallback) {
        Y((MsgService) k44.a(MsgService.class), MessageBuilder.createTextMessage(str2, SessionTypeEnum.P2P, str), operateCallback);
    }

    @UiThread
    public static void T(File file, long j2, String str, @NonNull RemoteExtBean remoteExtBean, OperateCallback<ChatRoomMessage> operateCallback) {
        ChatRoomMessage chatRoomMessageCreateChatRoomAudioMessage = ChatRoomMessageBuilder.createChatRoomAudioMessage(str, file, j2);
        chatRoomMessageCreateChatRoomAudioMessage.setRemoteExtension(remoteExtBean.getRemoteExt());
        W((ChatRoomService) k44.a(ChatRoomService.class), chatRoomMessageCreateChatRoomAudioMessage, operateCallback);
    }

    @UiThread
    public static void U(MsgAttachment msgAttachment, String str, @NonNull RemoteExtBean remoteExtBean, OperateCallback<ChatRoomMessage> operateCallback) {
        ChatRoomMessage chatRoomMessageCreateChatRoomCustomMessage = ChatRoomMessageBuilder.createChatRoomCustomMessage(str, msgAttachment);
        chatRoomMessageCreateChatRoomCustomMessage.setRemoteExtension(remoteExtBean.getRemoteExt());
        W((ChatRoomService) k44.a(ChatRoomService.class), chatRoomMessageCreateChatRoomCustomMessage, operateCallback);
    }

    @UiThread
    public static void V(String str, String str2, @NonNull RemoteExtBean remoteExtBean, OperateCallback<ChatRoomMessage> operateCallback) {
        File file = new File(str);
        ChatRoomMessage chatRoomMessageCreateChatRoomImageMessage = ChatRoomMessageBuilder.createChatRoomImageMessage(str2, file, file.getName());
        chatRoomMessageCreateChatRoomImageMessage.setRemoteExtension(remoteExtBean.getRemoteExt());
        W((ChatRoomService) k44.a(ChatRoomService.class), chatRoomMessageCreateChatRoomImageMessage, operateCallback);
    }

    public static void W(@org.jetbrains.annotations.Nullable ChatRoomService chatRoomService, ChatRoomMessage chatRoomMessage, OperateCallback<ChatRoomMessage> operateCallback) {
        if (chatRoomService == null) {
            L(operateCallback);
        } else {
            chatRoomService.sendMessage(chatRoomMessage, false).setCallback(new m(operateCallback, chatRoomMessage));
        }
    }

    @UiThread
    public static void X(String str, String str2, @NonNull RemoteExtBean remoteExtBean, OperateCallback<ChatRoomMessage> operateCallback) {
        ChatRoomMessage chatRoomMessageCreateChatRoomTextMessage = ChatRoomMessageBuilder.createChatRoomTextMessage(str2, str);
        chatRoomMessageCreateChatRoomTextMessage.setRemoteExtension(remoteExtBean.getRemoteExt());
        W((ChatRoomService) k44.a(ChatRoomService.class), chatRoomMessageCreateChatRoomTextMessage, operateCallback);
    }

    public static void Y(@org.jetbrains.annotations.Nullable MsgService msgService, IMMessage iMMessage, OperateCallback<IMMessage> operateCallback) {
        if (msgService == null) {
            L(operateCallback);
        } else {
            iMMessage.setRemoteExtension(f41189a.getRemoteExt());
            msgService.sendMessage(iMMessage, false).setCallback(new j(operateCallback, iMMessage));
        }
    }

    @UiThread
    public static void Z(String str) {
        try {
            i4a.b(p44.f18767a, "setChattingAccount");
            MsgService msgService = (MsgService) k44.a(MsgService.class);
            if (msgService == null || TextUtils.isEmpty(str)) {
                return;
            }
            msgService.setChattingAccount(str, SessionTypeEnum.P2P);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @UiThread
    public static void a0(String str) {
        try {
            i4a.b(p44.f18767a, "setChattingTeamAccount:" + str);
            MsgService msgService = (MsgService) k44.a(MsgService.class);
            if (msgService != null) {
                msgService.setChattingAccount(str, SessionTypeEnum.Team);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @UiThread
    public static void b0(String str, String str2, ShareGoodsAttachment shareGoodsAttachment) {
        Postcard postcardWithInt = ARouter.getInstance().build(RoutePathConstants.IM.b).withString(UserConstants.CHAT_PARAMS.f33725a, str).withInt(UserConstants.CHAT_PARAMS.b, 4);
        if (str2 == null) {
            str2 = "";
        }
        Postcard postcardWithString = postcardWithInt.withString(UserConstants.CHAT_PARAMS.c, str2);
        if (shareGoodsAttachment != null) {
            postcardWithString.withParcelable(UserConstants.CHAT_PARAMS.d, shareGoodsAttachment);
        }
        postcardWithString.navigation();
    }

    @UiThread
    public static void c0(String str) {
        if (TextUtils.isEmpty(str)) {
            fv5.b("对方只接收好友消息～");
        } else {
            ARouter.getInstance().build(RoutePathConstants.IM.b).withString(UserConstants.CHAT_PARAMS.f33725a, str).navigation();
        }
    }

    public static void d0(String str, String str2, OperateCallback<Void> operateCallback) {
        try {
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            if (friendService == null) {
                L(operateCallback);
                return;
            }
            HashMap map = new HashMap();
            map.put(FriendFieldEnum.ALIAS, str2);
            friendService.updateFriendFields(str, map).setCallback(l(operateCallback));
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    public static FriendUserInfo e0(@NonNull NimUserInfo nimUserInfo, String str, boolean z) {
        Map extensionMap = nimUserInfo.getExtensionMap();
        if (extensionMap == null) {
            extensionMap = new HashMap();
        }
        String strR = j64.r(extensionMap, "appUserCode");
        String strR2 = j64.r(extensionMap, "avatarFrameImgUrl");
        i4a.c("account:" + nimUserInfo.getAccount() + " name:" + nimUserInfo.getName() + " avatar:" + nimUserInfo.getAvatar() + " alias:" + str + " appUserCode:" + strR + " avatarFrameImgUrl:" + strR2 + " isFriend:" + z);
        return new FriendUserInfo(nimUserInfo.getAccount(), nimUserInfo.getName(), nimUserInfo.getAvatar(), str, strR, strR2, nimUserInfo.getSignature(), Boolean.valueOf(z));
    }

    @UiThread
    public static void f(String str, String str2, OperateCallback<Void> operateCallback) {
        try {
            i4a.a("addFriend:" + str);
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            if (friendService == null) {
                L(operateCallback);
            } else {
                friendService.addFriend(new AddFriendData(str, VerifyType.VERIFY_REQUEST, str2)).setCallback(l(operateCallback));
            }
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    public static void g(String str, OperateCallback<Void> operateCallback) {
        try {
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            if (friendService == null) {
                L(operateCallback);
            } else {
                friendService.addToBlackList(str).setCallback(l(operateCallback));
            }
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    @UiThread
    public static void h(String str, OperateCallback<Void> operateCallback) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            F(arrayList, new r(operateCallback, str));
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    @UiThread
    public static boolean i(String str) {
        try {
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            if (friendService != null) {
                return friendService.isMyFriend(str);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @UiThread
    public static void j() {
        try {
            i4a.b(p44.f18767a, "clearChattingAccount");
            MsgService msgService = (MsgService) k44.a(MsgService.class);
            if (msgService != null) {
                msgService.setChattingAccount(MsgService.MSG_CHATTING_ACCOUNT_NONE, SessionTypeEnum.None);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @UiThread
    public static void k(String str, SessionTypeEnum sessionTypeEnum) {
        try {
            i4a.b(p44.f18767a, "clearUnreadCount");
            MsgService msgService = (MsgService) k44.a(MsgService.class);
            if (msgService != null) {
                msgService.clearUnreadCount(str, sessionTypeEnum);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static <T> RequestCallback<T> l(OperateCallback<T> operateCallback) {
        return new q(operateCallback);
    }

    public static IMMessage m(IMMessage iMMessage) {
        IMMessageImpl iMMessageImplCreateEmptyMessage = MessageBuilder.createEmptyMessage(iMMessage.getSessionId(), iMMessage.getSessionType(), iMMessage.getTime());
        if (iMMessageImplCreateEmptyMessage instanceof IMMessageImpl) {
            iMMessageImplCreateEmptyMessage.setMsgType(MsgTypeEnum.custom.getValue());
            iMMessageImplCreateEmptyMessage.setAttachment(new MessageTimeAttachment());
        }
        return iMMessageImplCreateEmptyMessage;
    }

    public static List<NimUserInfo> n(int i2, List<NimUserInfo> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        if (i2 != 200 || list == null) {
            i4a.a("查询失败");
            for (String str : list2) {
                ErrorUserInfo errorUserInfo = new ErrorUserInfo();
                errorUserInfo.setAccount(str);
                arrayList.add(errorUserInfo);
            }
        } else {
            i4a.a("查询成功:" + list.size());
            ArrayList arrayList2 = new ArrayList();
            for (NimUserInfo nimUserInfo : list) {
                if (nimUserInfo != null) {
                    arrayList.add(nimUserInfo);
                    arrayList2.add(nimUserInfo.getAccount());
                }
            }
            if (list.size() != list2.size()) {
                i4a.a("查询到空用户");
                ArrayList<String> arrayList3 = new ArrayList();
                for (String str2 : list2) {
                    if (!arrayList2.contains(str2)) {
                        arrayList3.add(str2);
                    }
                }
                for (String str3 : arrayList3) {
                    ErrorUserInfo errorUserInfo2 = new ErrorUserInfo();
                    errorUserInfo2.setAccount(str3);
                    arrayList.add(errorUserInfo2);
                }
            }
        }
        return arrayList;
    }

    @UiThread
    public static void o(String str, OperateCallback<Void> operateCallback) {
        try {
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            if (friendService == null) {
                L(operateCallback);
            } else {
                friendService.deleteFriend(str).setCallback(l(operateCallback));
            }
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    @UiThread
    public static void p(IMMessage iMMessage, OperateCallback<Long> operateCallback) {
        try {
            MsgService msgService = (MsgService) k44.a(MsgService.class);
            if (msgService == null) {
                L(operateCallback);
            } else {
                msgService.deleteMsgSelf(iMMessage, "").setCallback(l(operateCallback));
            }
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    @UiThread
    public static void q(String str, SessionTypeEnum sessionTypeEnum, OperateCallback<Void> operateCallback) {
        try {
            i4a.a("deleteRecentContact:");
            i4a.a("account:" + str);
            i4a.a("sessionType:" + sessionTypeEnum.toString());
            MsgService msgService = (MsgService) k44.a(MsgService.class);
            if (msgService == null) {
                L(operateCallback);
                return;
            }
            msgService.clearUnreadCount(str, sessionTypeEnum);
            msgService.clearChattingHistory(str, sessionTypeEnum, false);
            msgService.deleteRecentContact(str, sessionTypeEnum, DeleteTypeEnum.LOCAL, true).setCallback(new i(str, sessionTypeEnum, operateCallback));
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    @UiThread
    public static List<String> r() {
        try {
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            return friendService != null ? friendService.getFriendAccounts() : new ArrayList();
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList();
        }
    }

    @UiThread
    public static String s(String str) {
        Friend friendByAccount;
        String alias;
        try {
            FriendService friendService = (FriendService) k44.a(FriendService.class);
            return (friendService == null || (friendByAccount = friendService.getFriendByAccount(str)) == null || (alias = friendByAccount.getAlias()) == null) ? "" : alias;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @UiThread
    public static void t(int i2, int i3, OperateCallback<List<SystemMessage>> operateCallback) {
        try {
            if (i3 <= 0) {
                throw new InvalidParameterException("pageNum must start with 0");
            }
            SystemMessageService systemMessageService = (SystemMessageService) k44.a(SystemMessageService.class);
            if (systemMessageService == null) {
                L(operateCallback);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(SystemMessageType.AddFriend);
            systemMessageService.querySystemMessageByType(arrayList, i2 * (i3 - 1), 100).setCallback(l(operateCallback));
        } catch (Exception e2) {
            L(operateCallback);
            e2.printStackTrace();
        }
    }

    @UiThread
    public static void u(int i2, OperateCallback<List<SystemMessage>> operateCallback) {
        try {
            t(100, i2, operateCallback);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @UiThread
    @org.jetbrains.annotations.Nullable
    public static FriendUserInfo v(String str) {
        NimUserInfo userInfo;
        try {
            UserService userService = (UserService) k44.a(UserService.class);
            if (userService == null || (userInfo = userService.getUserInfo(str)) == null) {
                return null;
            }
            return i(str) ? e0(userInfo, s(str), true) : e0(userInfo, "", false);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String w(IMMessage iMMessage) {
        Map remoteExtension = iMMessage.getRemoteExtension();
        if (remoteExtension == null) {
            return "";
        }
        String strP = j64.p(remoteExtension.get(UserConstants.USER_PARAMS.b));
        return !TextUtils.isEmpty(strP) ? strP : "";
    }

    public static int x(IMMessage iMMessage) {
        Map remoteExtension = iMMessage.getRemoteExtension();
        if (remoteExtension != null) {
            return j64.j(remoteExtension.get("roleType"));
        }
        return 0;
    }

    public static int y(IMMessage iMMessage) {
        Map remoteExtension = iMMessage.getRemoteExtension();
        if (remoteExtension == null) {
            return 0;
        }
        try {
            return j64.j(remoteExtension.get("specialAbility"));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @UiThread
    public static void z(String str, OperateCallback<FriendUserInfo> operateCallback) {
        UserService userService = (UserService) k44.a(UserService.class);
        if (userService == null) {
            if (operateCallback != null) {
                operateCallback.onSuccess(new FriendUserInfo(str, "陌生人", "", "", "", "", "", Boolean.FALSE));
            }
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            userService.fetchUserInfo(arrayList).setCallback(new e(str, operateCallback));
        }
    }
}
