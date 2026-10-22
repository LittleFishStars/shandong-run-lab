package com.huachenjie.mall.page.shopping_message;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.mall.bean.MessageContactBean;
import com.kuaishou.weapon.p0.t;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.zj.adlib.dj1;
import com.zj.adlib.i4a;
import com.zj.adlib.j64;
import com.zj.adlib.wt1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b+\u0010,J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0005J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002R%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u001fR0\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\n0!j\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\n`#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R%\u0010*\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010'0'0\u000f8\u0006¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0015¨\u0006-"}, d2 = {"Lcom/huachenjie/mall/page/shopping_message/ShoppingMessageVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "q", "", "Lcom/netease/nimlib/sdk/msg/model/RecentContact;", "recentList", "k", "contact", t.d, "Lcom/huachenjie/im/bean/FriendUserInfo;", "userList", "recentContactList", "Lcom/huachenjie/mall/bean/MessageContactBean;", "r", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", "p", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/mall/page/shopping_message/ShoppingMessageAdapter;", "c", "m", "adapter", "Lcom/huachenjie/im/bean/IMTokenBean;", "d", j.b, "s", "(Landroidx/lifecycle/MutableLiveData;)V", "tokenBean", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "remoteUserInfoMap", "", "e", "n", "officeUnreadCount", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nShoppingMessageVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShoppingMessageVM.kt\ncom/huachenjie/mall/page/shopping_message/ShoppingMessageVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,200:1\n1855#2,2:201\n1855#2:203\n1856#2:205\n1#3:204\n*S KotlinDebug\n*F\n+ 1 ShoppingMessageVM.kt\ncom/huachenjie/mall/page/shopping_message/ShoppingMessageVM\n*L\n83#1:201,2\n129#1:203\n129#1:205\n*E\n"})
public final class ShoppingMessageVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ShoppingMessageAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<IMTokenBean> tokenBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final HashMap<String, FriendUserInfo> remoteUserInfoMap = new HashMap<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> officeUnreadCount = new MutableLiveData<>(0);

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/mall/page/shopping_message/ShoppingMessageVM$a", "Lcom/huachenjie/im/DefaultCallback;", "", "Lcom/huachenjie/im/bean/FriendUserInfo;", "", "code", "userList", "", c.f25231a, "", "onResult", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DefaultCallback<List<? extends FriendUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List<RecentContact> f11156a;

        public a(List<RecentContact> list) {
            this.f11156a = list;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public /* bridge */ /* synthetic */ void onResult(int i, List<? extends FriendUserInfo> list, Throwable th) {
            onResult2(i, (List<FriendUserInfo>) list, th);
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(int code, @Nullable List<FriendUserInfo> userList, @Nullable Throwable exception) {
            List arrayList;
            MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM;
            ShoppingMessageAdapter value;
            ShoppingMessageAdapter value2;
            ShoppingMessageAdapter value3;
            ShoppingMessageAdapter value4;
            if (code != 200 || userList == null || userList.isEmpty()) {
                return;
            }
            i4a.a("userList size：" + userList.size());
            MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM2 = ShoppingMessageVM.this.m();
            if (mutableLiveDataM2 == null || (value4 = mutableLiveDataM2.getValue()) == null || (arrayList = value4.getData()) == null) {
                arrayList = new ArrayList();
            }
            if (arrayList.isEmpty()) {
                MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM3 = ShoppingMessageVM.this.m();
                if (mutableLiveDataM3 == null || (value3 = mutableLiveDataM3.getValue()) == null) {
                    return;
                }
                value3.setList(ShoppingMessageVM.this.r(userList, this.f11156a));
                return;
            }
            MutableLiveData<ShoppingMessageAdapter> mutableLiveDataM4 = ShoppingMessageVM.this.m();
            if (mutableLiveDataM4 != null && (value2 = mutableLiveDataM4.getValue()) != null) {
                value2.addData(0, (Collection) ShoppingMessageVM.this.r(userList, this.f11156a));
            }
            int size = this.f11156a.size();
            if (size <= 0 || size >= arrayList.size() || (mutableLiveDataM = ShoppingMessageVM.this.m()) == null || (value = mutableLiveDataM.getValue()) == null) {
                return;
            }
            value.notifyItemChanged(size + 1);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/mall/page/shopping_message/ShoppingMessageVM$b", "Lcom/huachenjie/im/DefaultCallback;", "", "Lcom/huachenjie/im/bean/FriendUserInfo;", "", "code", "userList", "", c.f25231a, "", "onResult", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DefaultCallback<List<? extends FriendUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List<RecentContact> f11157a;

        public b(List<RecentContact> list) {
            this.f11157a = list;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public /* bridge */ /* synthetic */ void onResult(int i, List<? extends FriendUserInfo> list, Throwable th) {
            onResult2(i, (List<FriendUserInfo>) list, th);
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(int code, @Nullable List<FriendUserInfo> userList, @Nullable Throwable exception) {
            MutableLiveData<Boolean> mutableLiveDataP = ShoppingMessageVM.this.p();
            Boolean bool = Boolean.FALSE;
            mutableLiveDataP.setValue(bool);
            if (code != 200 || userList == null || userList.isEmpty()) {
                i4a.a("用户列表是空的啊");
                ShoppingMessageVM.this.p().setValue(bool);
                ShoppingMessageAdapter value = ShoppingMessageVM.this.m().getValue();
                if (value != null) {
                    value.setList(null);
                }
                ShoppingMessageAdapter value2 = ShoppingMessageVM.this.m().getValue();
                if (value2 != null) {
                    value2.j();
                    return;
                }
                return;
            }
            ShoppingMessageAdapter value3 = ShoppingMessageVM.this.m().getValue();
            if (value3 != null) {
                ShoppingMessageVM shoppingMessageVM = ShoppingMessageVM.this;
                List<RecentContact> list = this.f11157a;
                Intrinsics.checkNotNullExpressionValue(list, "recentContactList");
                value3.setList(shoppingMessageVM.r(userList, list));
            }
            ShoppingMessageAdapter value4 = ShoppingMessageVM.this.m().getValue();
            if (value4 != null) {
                value4.f();
            }
        }
    }

    public final void k(@Nullable List<? extends RecentContact> recentList) {
        List arrayList;
        ShoppingMessageAdapter value;
        ShoppingMessageAdapter value2;
        MutableLiveData<ShoppingMessageAdapter> mutableLiveData = this.adapter;
        if (mutableLiveData == null || (value2 = mutableLiveData.getValue()) == null || (arrayList = value2.getData()) == null) {
            arrayList = new ArrayList();
        }
        ArrayList<RecentContact> arrayList2 = new ArrayList();
        if (recentList != null) {
            for (RecentContact recentContact : recentList) {
                if (recentContact != null) {
                    arrayList2.add(recentContact);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        for (RecentContact recentContact2 : arrayList2) {
            int size = arrayList.size();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = true;
                    break;
                }
                MessageContactBean messageContactBean = (MessageContactBean) arrayList.get(i);
                if (TextUtils.equals(recentContact2.getContactId(), messageContactBean.getAccId())) {
                    messageContactBean.setTime(recentContact2.getTime());
                    String content = recentContact2.getContent();
                    Intrinsics.checkNotNullExpressionValue(content, "newContact.content");
                    messageContactBean.setContent(content);
                    messageContactBean.setUnreadCount(recentContact2.getUnreadCount());
                    MutableLiveData<ShoppingMessageAdapter> mutableLiveData2 = this.adapter;
                    if (mutableLiveData2 != null && (value = mutableLiveData2.getValue()) != null) {
                        value.i(i);
                        break;
                    } else {
                        break;
                        break;
                    }
                }
                i++;
            }
            if (z) {
                arrayList3.add(recentContact2);
            }
        }
        if (arrayList3.isEmpty()) {
            i4a.a("不是新的会话");
            return;
        }
        i4a.a("新的会话");
        ArrayList arrayList4 = new ArrayList();
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            String contactId = ((RecentContact) it.next()).getContactId();
            Intrinsics.checkNotNullExpressionValue(contactId, "recent.contactId");
            arrayList4.add(contactId);
        }
        i4a.a("account size：" + arrayList4.size());
        dj1.H(arrayList4, new a(arrayList3));
    }

    public final void l(@Nullable RecentContact contact) {
        List arrayList;
        ShoppingMessageAdapter value;
        ShoppingMessageAdapter value2;
        if (contact == null) {
            return;
        }
        MutableLiveData<ShoppingMessageAdapter> mutableLiveData = this.adapter;
        if (mutableLiveData == null || (value2 = mutableLiveData.getValue()) == null || (arrayList = value2.getData()) == null) {
            arrayList = new ArrayList();
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(((MessageContactBean) arrayList.get(i)).getAccId(), contact.getContactId())) {
                MutableLiveData<ShoppingMessageAdapter> mutableLiveData2 = this.adapter;
                if (mutableLiveData2 == null || (value = mutableLiveData2.getValue()) == null) {
                    return;
                }
                value.removeAt(i);
                return;
            }
        }
    }

    @NotNull
    public final MutableLiveData<ShoppingMessageAdapter> m() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> n() {
        return this.officeUnreadCount;
    }

    @NotNull
    public final MutableLiveData<IMTokenBean> o() {
        return this.tokenBean;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.isRefreshing;
    }

    public final void q() {
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, this.isRefreshing.getValue())) {
            i4a.a("正在刷新最近会话列表");
            return;
        }
        this.isRefreshing.setValue(bool);
        List<RecentContact> listI = wt1.h().i().i();
        if (!listI.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<RecentContact> it = listI.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getContactId());
            }
            dj1.H(arrayList, new b(listI));
            return;
        }
        this.isRefreshing.setValue(Boolean.FALSE);
        ShoppingMessageAdapter value = this.adapter.getValue();
        if (value != null) {
            value.setList(null);
        }
        ShoppingMessageAdapter value2 = this.adapter.getValue();
        if (value2 != null) {
            value2.j();
        }
    }

    public final List<MessageContactBean> r(List<FriendUserInfo> userList, List<? extends RecentContact> recentContactList) {
        boolean zEquals;
        try {
            for (FriendUserInfo friendUserInfo : userList) {
                if (!TextUtils.isEmpty(friendUserInfo.getAccId())) {
                    HashMap<String, FriendUserInfo> map = this.remoteUserInfoMap;
                    String accId = friendUserInfo.getAccId();
                    Intrinsics.checkNotNull(accId);
                    map.put(accId, friendUserInfo);
                }
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList = new ArrayList();
        for (RecentContact recentContact : recentContactList) {
            MessageContactBean messageContactBean = new MessageContactBean(false, null, null, null, null, 0, 0L, 127, null);
            FriendUserInfo friendUserInfo2 = this.remoteUserInfoMap.get(recentContact.getContactId());
            if (friendUserInfo2 == null) {
                String contactId = recentContact.getContactId();
                Intrinsics.checkNotNullExpressionValue(contactId, "contactBean.contactId");
                messageContactBean.setAccId(contactId);
                String fromNick = recentContact.getFromNick();
                Intrinsics.checkNotNullExpressionValue(fromNick, "contactBean.fromNick");
                messageContactBean.setNickname(fromNick);
            } else {
                String accId2 = friendUserInfo2.getAccId();
                if (accId2 == null) {
                    accId2 = "";
                }
                messageContactBean.setAccId(accId2);
                messageContactBean.setNickname(friendUserInfo2.formatNickName());
                messageContactBean.setAvatarUrl(friendUserInfo2.getAvatar());
            }
            messageContactBean.setUnreadCount(recentContact.getUnreadCount());
            messageContactBean.setTime(recentContact.getTime());
            if (this.tokenBean.getValue() != null) {
                IMTokenBean value = this.tokenBean.getValue();
                zEquals = TextUtils.equals(value != null ? value.getAccid() : null, recentContact.getFromAccount());
            } else {
                zEquals = false;
            }
            String strB = j64.b(recentContact.getMsgType(), recentContact.getContent(), recentContact.getAttachment(), Boolean.valueOf(zEquals));
            Intrinsics.checkNotNullExpressionValue(strB, "content");
            messageContactBean.setContent(strB);
            arrayList.add(messageContactBean);
        }
        return arrayList;
    }

    public final void s(@NotNull MutableLiveData<IMTokenBean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.tokenBean = mutableLiveData;
    }
}
