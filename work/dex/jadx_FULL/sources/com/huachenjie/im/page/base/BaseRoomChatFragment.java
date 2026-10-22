package com.huachenjie.im.page.base;

import android.text.TextUtils;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.RoomChatHelper;
import com.huachenjie.im.vm.BaseChatVM;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMessage;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomRecallAttachment;
import com.netease.nimlib.sdk.chatroom.model.EnterChatRoomResultData;
import com.netease.nimlib.sdk.msg.constant.NotificationType;
import com.zj.adlib.i4a;
import com.zj.adlib.ia7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class BaseRoomChatFragment<T extends BaseChatVM> extends BaseChatFragment<T> {
    private OnReceivedMessageListener mReceivedMessageListener;
    private String uuid = ia7.f42314a.a();
    public List<String> roomIdList = new ArrayList();
    private Observer<List<ChatRoomMessage>> messageObserver = new Observer<List<ChatRoomMessage>>() { // from class: com.huachenjie.im.page.base.BaseRoomChatFragment.1
        public void onEvent(List<ChatRoomMessage> list) {
            i4a.a("onEvent -> onReceivedMessage");
            if (BaseRoomChatFragment.this.mReceivedMessageListener != null) {
                BaseRoomChatFragment.this.mReceivedMessageListener.a(list);
            }
            if (list == null || list.size() == 0) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> it = BaseRoomChatFragment.this.roomIdList.iterator();
            while (it.hasNext()) {
                linkedHashMap.put(it.next(), new ArrayList());
            }
            for (ChatRoomMessage chatRoomMessage : list) {
                ChatRoomRecallAttachment attachment = chatRoomMessage.getAttachment();
                if (attachment != null && (attachment instanceof ChatRoomRecallAttachment)) {
                    ChatRoomRecallAttachment chatRoomRecallAttachment = attachment;
                    if (chatRoomRecallAttachment.getType().getValue() == NotificationType.ChatRoomRecall.getValue()) {
                        BaseRoomChatFragment.this.withdrawMessage(chatRoomMessage, chatRoomRecallAttachment.getMsgUuid(), chatRoomRecallAttachment.getMsgTime());
                    }
                }
                List list2 = (List) linkedHashMap.get(RoomChatHelper.k().l(chatRoomMessage));
                if (list2 != null) {
                    list2.add(chatRoomMessage);
                }
            }
            for (String str : linkedHashMap.keySet()) {
                List<ChatRoomMessage> list3 = (List) linkedHashMap.get(str);
                if (list3 != null && list3.size() > 0) {
                    BaseRoomChatFragment.this.onReceiveMessage(str, list3);
                }
            }
        }
    };

    public interface OnReceivedMessageListener {
        void a(List<ChatRoomMessage> list);
    }

    public class a extends DefaultCallback<EnterChatRoomResultData> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f9902a;

        /* JADX INFO: renamed from: com.huachenjie.im.page.base.BaseRoomChatFragment$a$a, reason: collision with other inner class name */
        public class C0812a extends DefaultCallback<Long> {
            public C0812a() {
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int i, Long l, Throwable th) {
                if (i == 200) {
                    RoomChatHelper roomChatHelperK = RoomChatHelper.k();
                    String str = BaseRoomChatFragment.this.uuid;
                    a aVar = a.this;
                    String str2 = aVar.f9902a;
                    int historyRoomChatNum = BaseRoomChatFragment.this.getHistoryRoomChatNum(str2);
                    a aVar2 = a.this;
                    roomChatHelperK.p(str, str2, historyRoomChatNum, BaseRoomChatFragment.this.getRoomUserList(aVar2.f9902a), l.longValue());
                    return;
                }
                RoomChatHelper roomChatHelperK2 = RoomChatHelper.k();
                String str3 = BaseRoomChatFragment.this.uuid;
                a aVar3 = a.this;
                String str4 = aVar3.f9902a;
                int historyRoomChatNum2 = BaseRoomChatFragment.this.getHistoryRoomChatNum(str4);
                a aVar4 = a.this;
                roomChatHelperK2.p(str3, str4, historyRoomChatNum2, BaseRoomChatFragment.this.getRoomUserList(aVar4.f9902a), -1L);
            }
        }

        public a(String str) {
            this.f9902a = str;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, EnterChatRoomResultData enterChatRoomResultData, Throwable th) {
            if (BaseRoomChatFragment.this.getHistoryRoomChatNum(this.f9902a) <= 0) {
                i4a.a("需要查询的历史消息数为0:" + this.f9902a);
                return;
            }
            if (i != 200) {
                i4a.a("创建聊天失败,请稍后重试");
                return;
            }
            String teamCode = BaseRoomChatFragment.this.getTeamCode(this.f9902a);
            if (BaseRoomChatFragment.this.shouldRequestEnterTeam(this.f9902a) && !TextUtils.isEmpty(teamCode)) {
                RoomChatHelper.k().j(teamCode, new C0812a());
                return;
            }
            RoomChatHelper roomChatHelperK = RoomChatHelper.k();
            String str = BaseRoomChatFragment.this.uuid;
            String str2 = this.f9902a;
            roomChatHelperK.p(str, str2, BaseRoomChatFragment.this.getHistoryRoomChatNum(str2), BaseRoomChatFragment.this.getRoomUserList(this.f9902a), -1L);
        }
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void afterLoginSuccess() {
        initRoomIdList(this.roomIdList);
        RoomChatHelper.k().n(this.uuid, this.messageObserver);
        Iterator<String> it = this.roomIdList.iterator();
        while (it.hasNext()) {
            enterChatRoomAndRefreshHistory(it.next());
        }
    }

    public void enterChatRoomAndRefreshHistory(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RoomChatHelper.k().h(str, new a(str));
    }

    public abstract int getHistoryRoomChatNum(String str);

    public abstract List<String> getRoomUserList(String str);

    public abstract String getTeamCode(String str);

    public abstract void initRoomIdList(List<String> list);

    public abstract void onReceiveMessage(String str, List<ChatRoomMessage> list);

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void registerMessageChange() {
    }

    public void setOnReceivedMessageListener(OnReceivedMessageListener onReceivedMessageListener) {
        this.mReceivedMessageListener = onReceivedMessageListener;
    }

    public abstract boolean shouldRequestEnterTeam(String str);

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void unregisterMessageChange() {
        RoomChatHelper.k().u(this.uuid, this.roomIdList, this.messageObserver);
    }

    public abstract void withdrawMessage(ChatRoomMessage chatRoomMessage, String str, long j);
}
