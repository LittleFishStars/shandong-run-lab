package com.zj.adlib;

import androidx.fragment.app.FragmentManager;
import com.huachenjie.channel.bean.BaseChannelBean;
import com.huachenjie.channel.bean.TopicMainBean;
import com.huachenjie.im.custom.ShareChannelAttachment;
import com.huachenjie.im.custom.ShareTopicAttachment;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.share.OnShareCallback;
import com.huachenjie.works.page.share.ShareWorksDialog;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\r"}, d2 = {"Lcom/zj/adlib/w88;", "", "Lcom/huachenjie/channel/bean/BaseChannelBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "b", "Lcom/huachenjie/channel/bean/TopicMainBean;", "topicBean", "c", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class w88 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w88 f45544a = new w88();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"com/zj/adlib/w88$a", "Lcom/huachenjie/works/page/share/OnShareCallback;", "Lcom/netease/nimlib/sdk/msg/attachment/MsgAttachment;", "f", "", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements OnShareCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseChannelBean f45545a;

        public a(BaseChannelBean baseChannelBean) {
            this.f45545a = baseChannelBean;
        }

        @Override // com.huachenjie.works.page.share.OnShareCallback
        @NotNull
        public String b() {
            return this.f45545a.getChannelNo();
        }

        @Override // com.huachenjie.works.page.share.OnShareCallback
        @NotNull
        public MsgAttachment f() {
            ShareChannelAttachment shareChannelAttachment = new ShareChannelAttachment();
            shareChannelAttachment.setChannelName(this.f45545a.getChannelName());
            shareChannelAttachment.setChannelNo(this.f45545a.getChannelNo());
            shareChannelAttachment.setCoverUrl(this.f45545a.getCoverUrl());
            shareChannelAttachment.setChannelUserValue(this.f45545a.getChannelUserValue());
            shareChannelAttachment.setPopularityValue(this.f45545a.getPopularityValue());
            shareChannelAttachment.setAvatarList(this.f45545a.getAvatarList());
            return shareChannelAttachment;
        }
    }

    @JvmStatic
    public static final void b(@NotNull BaseChannelBean bean, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        ShareWorksDialog.INSTANCE.a(new a(bean)).show(fragmentManager, ShareWorksDialog.class.getName());
    }

    @JvmStatic
    public static final void c(@NotNull final TopicMainBean topicBean, @NotNull FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(topicBean, "topicBean");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        ShareWorksDialog.INSTANCE.c(new OnShareCallback() { // from class: com.zj.adlib.v88
            @Override // com.huachenjie.works.page.share.OnShareCallback
            public final MsgAttachment f() {
                return w88.d(topicBean);
            }
        }).show(fragmentManager, ShareWorksDialog.class.getName());
    }

    public static final MsgAttachment d(TopicMainBean topicMainBean) {
        Intrinsics.checkNotNullParameter(topicMainBean, "$topicBean");
        ShareTopicAttachment shareTopicAttachment = new ShareTopicAttachment();
        shareTopicAttachment.setSubjectName(topicMainBean.getSubjectName());
        shareTopicAttachment.setSubjectImg(topicMainBean.getSubjectImg());
        shareTopicAttachment.setSubjectNo(topicMainBean.getSubjectNo());
        shareTopicAttachment.setPopularityValue(topicMainBean.getPopularityValue());
        return shareTopicAttachment;
    }
}
