package com.huachenjie.works.page.share;

import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.im.custom.ShareWorkAttachment;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.bean.WorkImageBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import huachenjie.sdk.share.sharebody.SharedBody;
import huachenjie.sdk.share.sharebody.WebPageBody;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/works/page/share/a;", "", "Lcom/huachenjie/works/bean/WorkDetailBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/huachenjie/works/page/share/OnShareSuccessCallback;", RenderCallContext.TYPE_CALLBACK, "", "c", "", "b", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f37329a = new a();

    /* JADX INFO: renamed from: com.huachenjie.works.page.share.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"com/huachenjie/works/page/share/a$a", "Lcom/huachenjie/works/page/share/OnShareCallback;", "Lcom/netease/nimlib/sdk/msg/attachment/MsgAttachment;", "f", "", "a", "Lhuachenjie/sdk/share/sharebody/SharedBody;", "e", "Lcom/huachenjie/works/bean/WorkDetailBean;", "d", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class C0836a implements OnShareCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WorkDetailBean f37330a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ OnShareSuccessCallback f14945a;

        public C0836a(WorkDetailBean workDetailBean, OnShareSuccessCallback onShareSuccessCallback) {
            this.f37330a = workDetailBean;
            this.f14945a = onShareSuccessCallback;
        }

        @Override // com.huachenjie.works.page.share.OnShareCallback
        public void a() {
            OnShareSuccessCallback onShareSuccessCallback = this.f14945a;
            if (onShareSuccessCallback != null) {
                onShareSuccessCallback.a();
            }
        }

        @Override // com.huachenjie.works.page.share.OnShareCallback
        @NotNull
        /* JADX INFO: renamed from: d, reason: from getter */
        public WorkDetailBean getF37330a() {
            return this.f37330a;
        }

        @Override // com.huachenjie.works.page.share.OnShareCallback
        @NotNull
        public SharedBody e() {
            return new WebPageBody(this.f37330a.getUserInfo().getNickName() + "的校友作品", Environment.c + "/#/works/s?code=" + this.f37330a.getWorksNo(), TextUtils.isEmpty(this.f37330a.getTitle()) ? "校友" : this.f37330a.getTitle(), a.f37329a.b(this.f37330a));
        }

        @Override // com.huachenjie.works.page.share.OnShareCallback
        @NotNull
        public MsgAttachment f() {
            ShareWorkAttachment shareWorkAttachment = new ShareWorkAttachment();
            WorkImageBean coverBean = this.f37330a.formatCoverBean();
            shareWorkAttachment.setCoverUrl(coverBean.getPath());
            shareWorkAttachment.setCoverWidth(coverBean.getWidth());
            shareWorkAttachment.setCoverHeight(coverBean.getHeight());
            shareWorkAttachment.setTitle(this.f37330a.getTitle());
            shareWorkAttachment.setChannelName(this.f37330a.getChannelName());
            shareWorkAttachment.setAvatar(this.f37330a.formatAvatarUrl());
            shareWorkAttachment.setNickName(this.f37330a.formatNickName());
            shareWorkAttachment.setType(this.f37330a.getAttachmentType());
            shareWorkAttachment.setPopularityValue(this.f37330a.getPopularityValue());
            shareWorkAttachment.setWorksNo(this.f37330a.getWorksNo());
            return shareWorkAttachment;
        }
    }

    @JvmStatic
    public static final void c(@NotNull WorkDetailBean bean, @NotNull FragmentManager fragmentManager, @Nullable OnShareSuccessCallback callback) {
        Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        ShareWorksDialog.INSTANCE.d(bean.formatCoverBean().getPath(), new C0836a(bean, callback)).show(fragmentManager, ShareWorksDialog.class.getName());
    }

    public static /* synthetic */ void d(WorkDetailBean workDetailBean, FragmentManager fragmentManager, OnShareSuccessCallback onShareSuccessCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            onShareSuccessCallback = null;
        }
        c(workDetailBean, fragmentManager, onShareSuccessCallback);
    }

    public final String b(WorkDetailBean bean) {
        if (!TextUtils.isEmpty(bean.getContent())) {
            String string = new SpannableString(Html.fromHtml(bean.getContent())).toString();
            Intrinsics.checkNotNullExpressionValue(string, "SpannableString(Html.fro…bean.content)).toString()");
            return string;
        }
        return bean.getUserInfo().getNickName() + "的校友作品";
    }
}
