package com.huachenjie.im;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.huachenjie.im.RoomChatHelper;
import com.huachenjie.im.bean.EnterRoomBean;
import com.huachenjie.im.bean.RemoteExtBean;
import com.huachenjie.im.custom.EmojiStickerAttachment;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.RequestCallbackWrapper;
import com.netease.nimlib.sdk.chatroom.ChatRoomService;
import com.netease.nimlib.sdk.chatroom.ChatRoomServiceObserver;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMessage;
import com.netease.nimlib.sdk.chatroom.model.EnterChatRoomData;
import com.netease.nimlib.sdk.chatroom.model.EnterChatRoomResultData;
import com.netease.nimlib.sdk.msg.model.QueryDirectionEnum;
import com.zj.adlib.d60;
import com.zj.adlib.dj1;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.j44;
import com.zj.adlib.k44;
import com.zj.adlib.p59;
import huachenjie.sdk.http.BaseEntity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class RoomChatHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RoomChatHelper f34382a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f9624a = "RoomChatHelper";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f9626a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, List<ChatRoomMessage>> f9627a = new HashMap();
    public Map<String, List<OperateCallback<EnterChatRoomResultData>>> b = new HashMap();
    public Map<String, Observer<List<ChatRoomMessage>>> c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Observer<List<ChatRoomMessage>> f9625a = new Observer<List<ChatRoomMessage>>() { // from class: com.huachenjie.im.RoomChatHelper.1
        public void onEvent(List<ChatRoomMessage> list) {
            if (list != null && list.size() > 0) {
                for (ChatRoomMessage chatRoomMessage : list) {
                    String strL = RoomChatHelper.this.l(chatRoomMessage);
                    List list2 = (List) RoomChatHelper.this.f9627a.get(strL);
                    if (list2 != null) {
                        list2.add(chatRoomMessage);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(chatRoomMessage);
                        RoomChatHelper.this.f9627a.put(strL, arrayList);
                    }
                }
            }
            if (RoomChatHelper.this.c == null || RoomChatHelper.this.c.size() <= 0) {
                return;
            }
            Iterator it = RoomChatHelper.this.c.keySet().iterator();
            while (it.hasNext()) {
                Observer observer = (Observer) RoomChatHelper.this.c.get((String) it.next());
                if (observer != null) {
                    observer.onEvent(list);
                }
            }
        }
    };

    public class a implements RequestCallback<EnterChatRoomResultData> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f9628a;

        public a(String str) {
            this.f9628a = str;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(EnterChatRoomResultData enterChatRoomResultData) {
            RoomChatHelper.this.f9626a.add(this.f9628a);
            if (RoomChatHelper.this.b.get(this.f9628a) != null) {
                Iterator it = ((List) RoomChatHelper.this.b.get(this.f9628a)).iterator();
                while (it.hasNext()) {
                    ((OperateCallback) it.next()).onSuccess(enterChatRoomResultData);
                }
                RoomChatHelper.this.b.remove(this.f9628a);
            }
        }

        public void onException(Throwable th) {
            if (RoomChatHelper.this.b.get(this.f9628a) != null) {
                Iterator it = ((List) RoomChatHelper.this.b.get(this.f9628a)).iterator();
                while (it.hasNext()) {
                    ((OperateCallback) it.next()).onException(th);
                }
                RoomChatHelper.this.b.remove(this.f9628a);
            }
        }

        public void onFailed(int i) {
            i4a.a("错误code：" + i);
            if (RoomChatHelper.this.b.get(this.f9628a) != null) {
                Iterator it = ((List) RoomChatHelper.this.b.get(this.f9628a)).iterator();
                while (it.hasNext()) {
                    ((OperateCallback) it.next()).onFailed(i);
                }
                RoomChatHelper.this.b.remove(this.f9628a);
            }
        }
    }

    public class b extends DefaultCallback<ChatRoomMessage> {
        public b() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, ChatRoomMessage chatRoomMessage, Throwable th) {
            if (i != 200 || chatRoomMessage == null) {
                fv5.b("发送失败");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(chatRoomMessage);
            RoomChatHelper.this.f9625a.onEvent(arrayList);
        }
    }

    public class c extends DefaultCallback<ChatRoomMessage> {
        public c() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, ChatRoomMessage chatRoomMessage, Throwable th) {
            if (i != 200 || chatRoomMessage == null) {
                fv5.b("发送失败");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(chatRoomMessage);
            RoomChatHelper.this.f9625a.onEvent(arrayList);
        }
    }

    public class d extends DefaultCallback<ChatRoomMessage> {
        public d() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, ChatRoomMessage chatRoomMessage, Throwable th) {
            if (i != 200 || chatRoomMessage == null) {
                fv5.b("发送失败");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(chatRoomMessage);
            RoomChatHelper.this.f9625a.onEvent(arrayList);
        }
    }

    public class e extends DefaultCallback<ChatRoomMessage> {
        public e() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, ChatRoomMessage chatRoomMessage, Throwable th) {
            if (i != 200 || chatRoomMessage == null) {
                fv5.b("发送失败");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(chatRoomMessage);
            RoomChatHelper.this.f9625a.onEvent(arrayList);
        }
    }

    public class f extends RequestCallbackWrapper<List<ChatRoomMessage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f34388a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f9630a;
        public final /* synthetic */ String b;

        public f(String str, List list, long j) {
            this.b = str;
            this.f9630a = list;
            this.f34388a = j;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, List<ChatRoomMessage> list, Throwable th) {
            i4a.a("pullMessageHistory success");
            i4a.a("code ：" + i);
            RoomChatHelper.this.i(true, this.b, list, this.f9630a, this.f34388a);
        }
    }

    public class g implements rx.Observer<BaseEntity<EnterRoomBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f34389a;

        public g(OperateCallback operateCallback) {
            this.f34389a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseEntity<EnterRoomBean> baseEntity) {
            long j;
            if (baseEntity == null) {
                i4a.b(RoomChatHelper.f9624a, "getEnterTeamRoomTime : bean is null");
                this.f34389a.onFailed(404);
                return;
            }
            Object obj = baseEntity.data;
            if (obj == null) {
                i4a.b(RoomChatHelper.f9624a, "getEnterTeamRoomTime bean.data is null");
                this.f34389a.onFailed(404);
                return;
            }
            String enterTeamTime = ((EnterRoomBean) obj).getEnterTeamTime();
            i4a.b(RoomChatHelper.f9624a, "enterTeamTime:" + enterTeamTime);
            try {
                j = Long.parseLong(enterTeamTime);
            } catch (Exception unused) {
                j = 0;
            }
            this.f34389a.onSuccess(Long.valueOf(j));
        }

        public void onCompleted() {
            i4a.b(RoomChatHelper.f9624a, "getEnterTeamRoomTime onCompleted");
        }

        public void onError(Throwable th) {
            i4a.b(RoomChatHelper.f9624a, "getEnterTeamRoomTime onError");
            this.f34389a.onException(th);
            th.printStackTrace();
        }
    }

    public static RoomChatHelper k() {
        RoomChatHelper roomChatHelper;
        synchronized (RoomChatHelper.class) {
            if (f34382a == null) {
                f34382a = new RoomChatHelper();
            }
            roomChatHelper = f34382a;
        }
        return roomChatHelper;
    }

    public static /* synthetic */ void m(String str, rx.Observer observer) {
        new j44().e(str).I6(Schedulers.io()).G3(d60.c()).o5(observer);
    }

    public void h(String str, OperateCallback<EnterChatRoomResultData> operateCallback) {
        i4a.a("enterChatRoom -> roomId = " + str);
        if (this.f9626a.contains(str)) {
            i4a.a("enterChatRoom -> roomId has enter");
            if (operateCallback != null) {
                operateCallback.onSuccess(null);
                return;
            }
            return;
        }
        if (this.b.get(str) != null) {
            i4a.a("enterChatRoom -> roomId is login");
            this.b.get(str).add(operateCallback);
            return;
        }
        ChatRoomService chatRoomService = (ChatRoomService) k44.a(ChatRoomService.class);
        if (chatRoomService == null) {
            if (operateCallback != null) {
                operateCallback.onFailed(404);
            }
        } else {
            EnterChatRoomData enterChatRoomData = new EnterChatRoomData(str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(operateCallback);
            this.b.put(str, arrayList);
            chatRoomService.enterChatRoomEx(enterChatRoomData, 5).setCallback(new a(str));
        }
    }

    public final void i(boolean z, String str, List<ChatRoomMessage> list, List<String> list2, long j) {
        i4a.a("filterHistoryMessage");
        if (list == null) {
            i4a.a("result is null");
            list = new ArrayList<>();
        }
        if (list.size() == 0) {
            i4a.a("result size is 0");
        }
        i4a.a("filter list size：" + list.size());
        ArrayList<ChatRoomMessage> arrayList = new ArrayList();
        for (ChatRoomMessage chatRoomMessage : list) {
            if (list2 == null || list2.size() == 0) {
                arrayList.add(chatRoomMessage);
            } else if (j > 0) {
                if (chatRoomMessage.getTime() >= j) {
                    int iX = dj1.x(chatRoomMessage);
                    if (iX == 1 || iX == 2) {
                        arrayList.add(chatRoomMessage);
                    } else if (list2.contains(chatRoomMessage.getFromAccount())) {
                        arrayList.add(chatRoomMessage);
                    } else {
                        i4a.a("离开聊天室人员的历史消息");
                    }
                } else {
                    i4a.a("早于入队时间的历史消息");
                }
            }
        }
        if (z) {
            Collections.reverse(arrayList);
            if (arrayList.size() > 0) {
                for (ChatRoomMessage chatRoomMessage2 : arrayList) {
                    String strL = l(chatRoomMessage2);
                    List<ChatRoomMessage> list3 = this.f9627a.get(strL);
                    if (list3 != null) {
                        list3.add(chatRoomMessage2);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(chatRoomMessage2);
                        this.f9627a.put(strL, arrayList2);
                    }
                }
            }
        }
        Observer<List<ChatRoomMessage>> observer = this.c.get(str);
        if (observer != null) {
            observer.onEvent(arrayList);
        }
    }

    public void j(final String str, OperateCallback<Long> operateCallback) {
        i4a.b(f9624a, "getEnterTeamRoomTime");
        final g gVar = new g(operateCallback);
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.bj7
            @Override // java.lang.Runnable
            public final void run() {
                RoomChatHelper.m(str, gVar);
            }
        });
    }

    public String l(ChatRoomMessage chatRoomMessage) {
        String sessionId = chatRoomMessage.getSessionId();
        return !TextUtils.isEmpty(sessionId) ? sessionId : "";
    }

    @UiThread
    public void n(String str, Observer<List<ChatRoomMessage>> observer) {
        Map<String, Observer<List<ChatRoomMessage>>> map = this.c;
        if (map == null || map.isEmpty()) {
            i4a.a("observeReceiveMessage");
            ChatRoomServiceObserver chatRoomServiceObserver = (ChatRoomServiceObserver) k44.a(ChatRoomServiceObserver.class);
            if (chatRoomServiceObserver != null) {
                chatRoomServiceObserver.observeReceiveMessage(this.f9625a, true);
            }
        }
        i4a.a("put  observer -> " + observer);
        this.c.put(str, observer);
    }

    public void o(String str, String str2, int i) {
        p(str, str2, i, null, -1L);
    }

    public void p(String str, String str2, int i, List<String> list, long j) {
        i4a.a("requestHistoryMessage:");
        i4a.a("uuid:" + str);
        i4a.a("roomId:" + str2);
        i4a.a("limit:" + i);
        if (i <= 0) {
            return;
        }
        int i2 = i > 100 ? 100 : i;
        List<ChatRoomMessage> list2 = this.f9627a.get(str2);
        if (list2 != null && list2.size() > 0) {
            i4a.a("load local history message:");
            i(false, str, list2, list, j);
            return;
        }
        i4a.a("enterTime:" + j);
        if (j == 0) {
            return;
        }
        i4a.a("requestHistoryMessage:" + i2);
        ChatRoomService chatRoomService = (ChatRoomService) k44.a(ChatRoomService.class);
        if (chatRoomService != null) {
            i4a.a("service is not null.---> pullMessageHistoryEx");
            chatRoomService.pullMessageHistoryEx(str2, System.currentTimeMillis(), i2, QueryDirectionEnum.QUERY_OLD).setCallback(new f(str, list, j));
        }
    }

    @UiThread
    public void q(EmojiStickerAttachment emojiStickerAttachment, String str, @NonNull RemoteExtBean remoteExtBean) {
        dj1.U(emojiStickerAttachment, str, remoteExtBean, new e());
    }

    @UiThread
    public void r(File file, long j, String str, @NonNull RemoteExtBean remoteExtBean) {
        dj1.T(file, j, str, remoteExtBean, new d());
    }

    @UiThread
    public void s(String str, String str2, @NonNull RemoteExtBean remoteExtBean) {
        dj1.V(str, str2, remoteExtBean, new c());
    }

    @UiThread
    public void t(String str, String str2, @NonNull RemoteExtBean remoteExtBean) {
        dj1.X(str, str2, remoteExtBean, new b());
    }

    @UiThread
    public void u(String str, List<String> list, Observer<List<ChatRoomMessage>> observer) {
        i4a.a("remove  observer -> " + observer);
        this.c.remove(str);
        Map<String, Observer<List<ChatRoomMessage>>> map = this.c;
        if (map == null || map.isEmpty()) {
            this.f9627a.clear();
            ChatRoomServiceObserver chatRoomServiceObserver = (ChatRoomServiceObserver) k44.a(ChatRoomServiceObserver.class);
            if (chatRoomServiceObserver != null) {
                i4a.a("unregisterChatRoomReceiveMessage");
                chatRoomServiceObserver.observeReceiveMessage(this.f9625a, false);
            }
            ChatRoomService chatRoomService = (ChatRoomService) k44.a(ChatRoomService.class);
            if (chatRoomService == null || list == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    i4a.a("exitChatRoom -> roomId = " + str2);
                    chatRoomService.exitChatRoom(str2);
                    this.f9626a.remove(str2);
                    if (this.b.get(str2) != null) {
                        this.b.remove(str2);
                    }
                }
            }
        }
    }
}
