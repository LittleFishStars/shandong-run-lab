package com.huachenjie.channel.page.home;

import android.content.Context;
import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.bean.FlashMessageBuddyChatBean;
import com.huachenjie.channel.bean.FlashMessageSingleChatItem;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.ContactUserBean;
import com.huachenjie.im.bean.FriendUserInfo;
import com.huachenjie.im.bean.IMTokenBean;
import com.igexin.push.g.o;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.zj.adlib.dj1;
import com.zj.adlib.j64;
import com.zj.adlib.p44;
import com.zj.adlib.pn3;
import com.zj.adlib.wt1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0002J\u0016\u0010\u0016\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0002R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010*\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R0\u0010.\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00190+j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0019`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010-R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020/0\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00100R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u0012028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00100¨\u00067"}, d2 = {"Lcom/huachenjie/channel/page/home/FlashMessageVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "x", "v", "", "Lcom/netease/nimlib/sdk/msg/model/RecentContact;", "recentList", "n", "contact", j.b, "", pn3.FRIEND_ACCOUNT, pn3.FRIEND_ALIAS, j.o, "Landroid/content/Context;", "context", "s", "Lcom/huachenjie/im/bean/ContactUserBean;", "newContacts", "t", "p2pContactList", "w", "r", "A", "Lcom/huachenjie/im/bean/FriendUserInfo;", "userList", "contactList", "u", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/home/FlashMessageAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "p", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "Lcom/huachenjie/im/bean/IMTokenBean;", "Lcom/huachenjie/im/bean/IMTokenBean;", "q", "()Lcom/huachenjie/im/bean/IMTokenBean;", "y", "(Lcom/huachenjie/im/bean/IMTokenBean;)V", "tokenBean", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "remoteUserInfoMap", "Lcom/huachenjie/channel/bean/FlashMessageBuddyChatBean;", "Ljava/util/List;", "buddyChatList", "", "c", "singleChatList", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFlashMessageVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlashMessageVM.kt\ncom/huachenjie/channel/page/home/FlashMessageVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n350#2,7:226\n1549#2:233\n1620#2,3:234\n1549#2:237\n1620#2,3:238\n1549#2:241\n1620#2,3:242\n1549#2:245\n1620#2,3:246\n1855#2:249\n1856#2:251\n1855#2,2:252\n1#3:250\n*S KotlinDebug\n*F\n+ 1 FlashMessageVM.kt\ncom/huachenjie/channel/page/home/FlashMessageVM\n*L\n116#1:226,7\n124#1:233\n124#1:234,3\n146#1:237\n146#1:238,3\n168#1:241\n168#1:242,3\n173#1:245\n173#1:246,3\n193#1:249\n193#1:251\n196#1:252,2\n*E\n"})
public final class FlashMessageVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public IMTokenBean tokenBean;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<FlashMessageAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final HashMap<String, FriendUserInfo> remoteUserInfoMap = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public List<FlashMessageBuddyChatBean> buddyChatList = CollectionsKt.emptyList();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public List<ContactUserBean> singleChatList = new ArrayList();

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/channel/page/home/FlashMessageVM$a", "Lcom/huachenjie/im/DefaultCallback;", "", "Lcom/huachenjie/im/bean/FriendUserInfo;", "", "code", "result", "", c.f25231a, "", "onResult", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DefaultCallback<List<? extends FriendUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List<ContactUserBean> f8286a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends ContactUserBean> list) {
            this.f8286a = list;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public /* bridge */ /* synthetic */ void onResult(int i, List<? extends FriendUserInfo> list, Throwable th) {
            onResult2(i, (List<FriendUserInfo>) list, th);
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(int code, @Nullable List<FriendUserInfo> result, @Nullable Throwable exception) {
            if (code == 200) {
                List<FriendUserInfo> list = result;
                if (list == null || list.isEmpty()) {
                    return;
                }
                FlashMessageVM.this.singleChatList.addAll(0, FlashMessageVM.this.u(result, this.f8286a));
                FlashMessageVM.this.r();
            }
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/channel/page/home/FlashMessageVM$b", "Lcom/huachenjie/im/DefaultCallback;", "", "Lcom/huachenjie/im/bean/FriendUserInfo;", "", "code", "result", "", c.f25231a, "", "onResult", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DefaultCallback<List<? extends FriendUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List<ContactUserBean> f8287a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<? extends ContactUserBean> list) {
            this.f8287a = list;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public /* bridge */ /* synthetic */ void onResult(int i, List<? extends FriendUserInfo> list, Throwable th) {
            onResult2(i, (List<FriendUserInfo>) list, th);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0026  */
        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(int code, @Nullable List<FriendUserInfo> result, @Nullable Throwable exception) {
            List mutableList;
            FlashMessageVM flashMessageVM = FlashMessageVM.this;
            if (code != 200) {
                mutableList = CollectionsKt.toMutableList(this.f8287a);
            } else {
                List<FriendUserInfo> list = result;
                if (list == null || list.isEmpty()) {
                    mutableList = CollectionsKt.toMutableList(this.f8287a);
                } else {
                    mutableList = CollectionsKt.toMutableList(FlashMessageVM.this.u(result, this.f8287a));
                }
            }
            flashMessageVM.singleChatList = mutableList;
            FlashMessageVM.this.r();
        }
    }

    public final List<ContactUserBean> A(List<? extends RecentContact> recentList) {
        List<? extends RecentContact> list = recentList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (RecentContact recentContact : list) {
            IMTokenBean iMTokenBean = this.tokenBean;
            boolean zEquals = TextUtils.equals(iMTokenBean != null ? iMTokenBean.getAccid() : null, recentContact.getFromAccount());
            ContactUserBean contactUserBean = new ContactUserBean();
            contactUserBean.setAccid(recentContact.getContactId());
            contactUserBean.setUnreadCount(recentContact.getUnreadCount());
            contactUserBean.setTime(recentContact.getTime());
            contactUserBean.setContent(j64.b(recentContact.getMsgType(), recentContact.getContent(), recentContact.getAttachment(), Boolean.valueOf(zEquals)));
            arrayList.add(contactUserBean);
        }
        return arrayList;
    }

    public final void n(@NotNull List<? extends RecentContact> recentList) {
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        List<ContactUserBean> listA = A(recentList);
        ArrayList arrayList = new ArrayList();
        for (ContactUserBean contactUserBean : listA) {
            int size = this.singleChatList.size();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = true;
                    break;
                }
                ContactUserBean contactUserBean2 = this.singleChatList.get(i);
                if (TextUtils.equals(contactUserBean.getAccid(), contactUserBean2.getAccid())) {
                    contactUserBean2.setContent(contactUserBean.getContent());
                    contactUserBean2.setUnreadCount(contactUserBean.getUnreadCount());
                    contactUserBean2.setTime(contactUserBean.getTime());
                    contactUserBean2.setMyFriend(Boolean.valueOf(dj1.i(contactUserBean2.getAccid())));
                    if (i <= 0) {
                        break;
                    }
                    this.singleChatList.add(0, this.singleChatList.remove(i));
                    break;
                }
                i++;
            }
            if (z) {
                arrayList.add(contactUserBean);
            }
        }
        if (arrayList.isEmpty()) {
            r();
        } else {
            t(arrayList);
        }
    }

    public final void o(@NotNull final RecentContact contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        CollectionsKt.removeAll(this.singleChatList, new Function1<ContactUserBean, Boolean>() { // from class: com.huachenjie.channel.page.home.FlashMessageVM$deleteContact$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ContactUserBean contactUserBean) {
                Intrinsics.checkNotNullParameter(contactUserBean, o.f);
                return Boolean.valueOf(TextUtils.equals(contactUserBean.getAccid(), contact.getContactId()));
            }
        });
        r();
    }

    @NotNull
    public final MutableLiveData<FlashMessageAdapter> p() {
        return this.adapter;
    }

    @Nullable
    /* JADX INFO: renamed from: q, reason: from getter */
    public final IMTokenBean getTokenBean() {
        return this.tokenBean;
    }

    public final void r() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.buddyChatList);
        List<ContactUserBean> list = this.singleChatList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(new FlashMessageSingleChatItem((ContactUserBean) it.next()));
        }
        arrayList.addAll(arrayList2);
        FlashMessageAdapter value = this.adapter.getValue();
        if (value != null) {
            value.setList(arrayList);
        }
    }

    public final void s(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BaseViewModelExtKt.b(this, true, false, null, null, new FlashMessageVM$openBuddyReviewReminder$1(context, null), 14, null);
    }

    public final void t(List<? extends ContactUserBean> newContacts) {
        List<? extends ContactUserBean> list = newContacts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ContactUserBean) it.next()).getAccid());
        }
        dj1.H(arrayList, new a(newContacts));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<ContactUserBean> u(List<FriendUserInfo> userList, List<? extends ContactUserBean> contactList) {
        for (FriendUserInfo friendUserInfo : userList) {
            String accId = friendUserInfo.getAccId();
            if (accId != null) {
                this.remoteUserInfoMap.put(accId, friendUserInfo);
            }
        }
        for (ContactUserBean contactUserBean : contactList) {
            FriendUserInfo friendUserInfo2 = this.remoteUserInfoMap.get(contactUserBean.getAccid());
            if (friendUserInfo2 != null) {
                contactUserBean.setNickName(friendUserInfo2.getName());
                contactUserBean.setRemarkNickname(friendUserInfo2.getAlias());
                contactUserBean.setAvatar(friendUserInfo2.getAvatar());
                contactUserBean.setAvatarFrameImgUrl(friendUserInfo2.getAvatarFrameImgUrl());
                contactUserBean.setAppUserCode(friendUserInfo2.getAppUserCode());
                contactUserBean.setMyFriend(Boolean.valueOf(Intrinsics.areEqual(friendUserInfo2.isFriend(), Boolean.TRUE)));
            }
        }
        return contactList;
    }

    public final void v() {
        if (p44.r()) {
            List<RecentContact> listI = wt1.h().j().i();
            List<RecentContact> list = listI;
            if (list == null || list.isEmpty()) {
                this.singleChatList.clear();
                r();
            } else {
                Intrinsics.checkNotNullExpressionValue(listI, "contacts");
                w(A(listI));
            }
        }
    }

    public final void w(List<? extends ContactUserBean> p2pContactList) {
        if (p2pContactList.isEmpty()) {
            this.singleChatList.clear();
            r();
            return;
        }
        List<? extends ContactUserBean> list = p2pContactList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ContactUserBean) it.next()).getAccid());
        }
        dj1.H(arrayList, new b(p2pContactList));
    }

    public final void x() {
        BaseViewModelExtKt.b(this, false, false, null, null, new FlashMessageVM$requestList$1(this, null), 15, null);
    }

    public final void y(@Nullable IMTokenBean iMTokenBean) {
        this.tokenBean = iMTokenBean;
    }

    public final void z(@NotNull String friendAccount, @NotNull String friendAlias) {
        Intrinsics.checkNotNullParameter(friendAccount, pn3.FRIEND_ACCOUNT);
        Intrinsics.checkNotNullParameter(friendAlias, pn3.FRIEND_ALIAS);
        FriendUserInfo friendUserInfo = this.remoteUserInfoMap.get(friendAccount);
        if (friendUserInfo != null) {
            friendUserInfo.setAlias(friendAlias);
        }
        Iterator<ContactUserBean> it = this.singleChatList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getAccid(), friendAccount)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            this.singleChatList.get(i).setRemarkNickname(friendAlias);
            r();
        }
    }
}
