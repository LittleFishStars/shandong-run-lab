package com.huachenjie.push.interfaces;

import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.base.share.ShareLinkCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J$\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/push/interfaces/InternalShareLink;", "", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "", "json", "Lcom/huachenjie/base/share/ShareLinkCallback;", RenderCallContext.TYPE_CALLBACK, "", "b", "a", "base_release"}, k = 1, mv = {1, 8, 0})
public interface InternalShareLink {
    void a(@Nullable FragmentActivity fragmentActivity, @Nullable String json, @NotNull ShareLinkCallback callback);

    void b(@Nullable FragmentActivity fragmentActivity, @Nullable String json, @NotNull ShareLinkCallback callback);
}
