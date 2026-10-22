package com.zj.adlib;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.base.R;
import com.huachenjie.base.dialog.ShareDialog;
import com.huachenjie.common.constants.Environment;
import huachenjie.sdk.share.sharebody.WebPageBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J@\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¨\u0006\u0014"}, d2 = {"Lcom/zj/adlib/z88;", "", "", "shareFlavour", "", "a", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "title", "content", "postNo", "shareImageUrl", "Landroid/content/res/Resources;", "resources", "Lcom/huachenjie/base/dialog/ShareDialog$OnShareCallback;", RenderCallContext.TYPE_CALLBACK, "", "b", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class z88 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final z88 f46210a = new z88();

    public final int a(@NotNull String shareFlavour) {
        Intrinsics.checkNotNullParameter(shareFlavour, "shareFlavour");
        int iHashCode = shareFlavour.hashCode();
        if (iHashCode != -791770330) {
            if (iHashCode != 3616) {
                if (iHashCode != 3530377) {
                    if (iHashCode == 1235271283 && shareFlavour.equals(ShareDialog.MOMENTS)) {
                        return 5;
                    }
                } else if (shareFlavour.equals(ShareDialog.SINA)) {
                    return 6;
                }
            } else if (shareFlavour.equals(ShareDialog.QQ)) {
                return 4;
            }
        } else if (shareFlavour.equals(ShareDialog.WECHAT)) {
            return 3;
        }
        return 0;
    }

    public final void b(@NotNull FragmentManager fragmentManager, @NotNull String title, @NotNull String content, @NotNull String postNo, @Nullable String shareImageUrl, @NotNull Resources resources, @NotNull ShareDialog.OnShareCallback callback) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        WebPageBody webPageBody = new WebPageBody(content, Environment.c + "/#/post/s?code=" + postNo, title, content);
        if (TextUtils.isEmpty(shareImageUrl)) {
            webPageBody.setBitmap(BitmapFactory.decodeResource(resources, R.drawable.ic_share_post_default));
            ShareDialog.Companion.c(ShareDialog.INSTANCE, webPageBody, "", callback, false, 8, null).show(fragmentManager, "SHARE_DIALOG");
        } else {
            ShareDialog.Companion companion = ShareDialog.INSTANCE;
            if (shareImageUrl == null) {
                shareImageUrl = "";
            }
            ShareDialog.Companion.c(companion, webPageBody, shareImageUrl, callback, false, 8, null).show(fragmentManager, "SHARE_DIALOG");
        }
    }
}
