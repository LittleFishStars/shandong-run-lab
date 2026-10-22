package com.huachenjie.im.page.base;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.RoomChatHelper;
import com.huachenjie.im.vm.BaseSignalTowerVM;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMessage;
import com.zj.adlib.dq1;
import com.zj.adlib.f64;
import com.zj.adlib.i4a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class BaseSignalTowerFragment<T extends BaseSignalTowerVM> extends BaseRoomChatFragment<T> {
    public static final String OVERT_TYPE = "overtType";
    public static final int PUB_INDEX = 1;
    public static final int PUB_NATIONWIDE = 1;
    public static final int PUB_OVERT = 0;
    public static final String TAB_INDEX = "tabIndex";
    public static final int TEAM_INDEX = 0;
    public static final int TYPE_PUB = 1;
    public static final int TYPE_PUB_TEAM = 2;
    public static final int TYPE_TEAM = 3;
    public BaseQuickAdapter mNationwideAdapter;
    public RecyclerView mNationwideRecycler;
    public BaseQuickAdapter mOvertAdapter;
    public RecyclerView mOvertRecycler;
    public int mRoomChatType;
    public BaseQuickAdapter mTeamAdapter;
    public RecyclerView mTeamRecycler;
    public String metaverseTeamCode;
    public String nationwideId;
    public String overtId;
    public int showType;
    public String teamId;
    public int requestHistoryTeamChatNum = 0;
    public int requestHistoryOvertChatNum = 0;
    public ArrayList<String> roomUserList = new ArrayList<>();
    public Boolean hideNationwide = Boolean.FALSE;

    public static Bundle createArguments(String str, String str2, int i, int i2, ArrayList<String> arrayList, String str3, Boolean bool, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("teamId", str);
        bundle.putString(UserConstants.CHAT_PARAMS.j, str2);
        bundle.putInt(UserConstants.CHAT_PARAMS.o, i);
        bundle.putInt(UserConstants.CHAT_PARAMS.p, i2);
        bundle.putStringArrayList(UserConstants.CHAT_PARAMS.k, arrayList);
        bundle.putString(UserConstants.CHAT_PARAMS.l, str3);
        bundle.putBoolean(UserConstants.CHAT_PARAMS.q, bool.booleanValue());
        bundle.putInt(UserConstants.CHAT_PARAMS.n, i3);
        return bundle;
    }

    @Override // com.huachenjie.im.page.base.BaseRoomChatFragment
    public int getHistoryRoomChatNum(String str) {
        if (str.equals(this.teamId)) {
            return this.requestHistoryTeamChatNum;
        }
        if (str.equals(this.overtId) || str.equals(this.nationwideId)) {
            return this.requestHistoryOvertChatNum;
        }
        return 0;
    }

    @Override // com.huachenjie.im.page.base.BaseRoomChatFragment
    public List<String> getRoomUserList(String str) {
        if (str.equals(this.teamId)) {
            return this.roomUserList;
        }
        return null;
    }

    @Override // com.huachenjie.im.page.base.BaseRoomChatFragment
    public String getTeamCode(String str) {
        if (str.equals(this.teamId)) {
            return this.metaverseTeamCode;
        }
        return null;
    }

    @Override // com.huachenjie.im.page.base.BaseChatFragment
    public void handleArguments(Bundle bundle) {
        if (bundle != null) {
            this.teamId = bundle.getString("teamId");
            this.overtId = bundle.getString(UserConstants.CHAT_PARAMS.j);
            this.requestHistoryTeamChatNum = bundle.getInt(UserConstants.CHAT_PARAMS.o, 0);
            this.requestHistoryOvertChatNum = bundle.getInt(UserConstants.CHAT_PARAMS.p, 0);
            this.roomUserList = bundle.getStringArrayList(UserConstants.CHAT_PARAMS.k);
            this.metaverseTeamCode = bundle.getString(UserConstants.CHAT_PARAMS.l);
            this.hideNationwide = Boolean.valueOf(bundle.getBoolean(UserConstants.CHAT_PARAMS.q));
            this.mRoomChatType = bundle.getInt(UserConstants.CHAT_PARAMS.n, 0);
            if (this.hideNationwide.booleanValue()) {
                this.nationwideId = "";
            } else {
                this.nationwideId = dq1.e().getPublicRoomId();
            }
            if (TextUtils.isEmpty(this.teamId)) {
                this.showType = 1;
            } else if (TextUtils.isEmpty(this.overtId) && TextUtils.isEmpty(this.nationwideId)) {
                this.showType = 3;
            } else {
                this.showType = 2;
            }
        }
    }

    public void initChatRecycler(RecyclerView recyclerView, BaseQuickAdapter baseQuickAdapter) {
        if (recyclerView.getItemAnimator() != null) {
            recyclerView.setItemAnimator(null);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(baseQuickAdapter);
        recyclerView.setOverScrollMode(2);
    }

    @Override // com.huachenjie.im.page.base.BaseRoomChatFragment
    public void initRoomIdList(List<String> list) {
        if (!TextUtils.isEmpty(this.teamId)) {
            list.add(this.teamId);
        }
        if (!TextUtils.isEmpty(this.overtId)) {
            list.add(this.overtId);
        }
        if (TextUtils.isEmpty(this.nationwideId)) {
            return;
        }
        list.add(this.nationwideId);
    }

    @Override // com.huachenjie.im.page.base.BaseRoomChatFragment
    public void onReceiveMessage(String str, List<ChatRoomMessage> list) {
        i4a.a("onReceiveMessage");
        if (str.equals(this.teamId)) {
            if (this.mTeamAdapter != null) {
                i4a.a("队伍" + list.size());
                this.mTeamAdapter.addData((Collection) list);
                smoothScrollToBottom(this.mTeamRecycler);
                return;
            }
            return;
        }
        if (str.equals(this.overtId)) {
            if (this.mOvertAdapter != null) {
                i4a.a("全校" + list.size());
                this.mOvertAdapter.addData((Collection) list);
                smoothScrollToBottom(this.mOvertRecycler);
                return;
            }
            return;
        }
        if (!str.equals(this.nationwideId) || this.mNationwideAdapter == null) {
            return;
        }
        i4a.a("全国" + list.size());
        this.mNationwideAdapter.addData((Collection) list);
        smoothScrollToBottom(this.mNationwideRecycler);
    }

    @Override // com.huachenjie.im.page.base.BaseRoomChatFragment
    public boolean shouldRequestEnterTeam(String str) {
        ArrayList<String> arrayList;
        return str.equals(this.teamId) && this.requestHistoryTeamChatNum > 0 && (arrayList = this.roomUserList) != null && arrayList.size() > 0 && !TextUtils.isEmpty(this.metaverseTeamCode);
    }

    public void smoothScrollToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(recyclerView.getAdapter().getItemCount() - 1, Integer.MIN_VALUE);
        }
    }

    @Override // com.huachenjie.im.page.base.BaseRoomChatFragment
    public void withdrawMessage(ChatRoomMessage chatRoomMessage, String str, long j) {
        BaseQuickAdapter baseQuickAdapter;
        String strL = RoomChatHelper.k().l(chatRoomMessage);
        if (strL.equals(this.teamId)) {
            baseQuickAdapter = this.mTeamAdapter;
        } else if (strL.equals(this.overtId)) {
            baseQuickAdapter = this.mOvertAdapter;
        } else {
            baseQuickAdapter = strL.equals(this.nationwideId) ? this.mNationwideAdapter : null;
        }
        if (baseQuickAdapter == null) {
            return;
        }
        for (Object obj : baseQuickAdapter.getData()) {
            if (obj != null && (obj instanceof ChatRoomMessage)) {
                ChatRoomMessage chatRoomMessage2 = (ChatRoomMessage) obj;
                String uuid = chatRoomMessage2.getUuid();
                long time = chatRoomMessage2.getTime();
                if (str.equals(uuid) && j == time) {
                    f64.b().k(chatRoomMessage2.getUuid());
                    baseQuickAdapter.remove(obj);
                    return;
                }
            }
        }
    }
}
