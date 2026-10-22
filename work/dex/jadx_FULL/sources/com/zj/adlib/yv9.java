package com.zj.adlib;

import androidx.coroutines.BindingAdapter;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.channel.external.widget.FriendFollowButton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/zj/adlib/yv9;", "", "Lcom/huachenjie/channel/external/widget/FriendFollowButton;", "button", "Lcom/huachenjie/channel/external/bean/FansBean;", "fansBean", "", "source", "", "a", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class yv9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final yv9 f46127a = new yv9();

    @BindingAdapter(requireAll = true, value = {"fansBean", "source"})
    @JvmStatic
    public static final void a(@Nullable FriendFollowButton button, @Nullable FansBean fansBean, int source) {
        if (button == null || fansBean == null) {
            return;
        }
        button.setFansBean(fansBean);
        button.setSource(source);
    }
}
