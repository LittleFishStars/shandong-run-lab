package com.huachenjie.channel.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/huachenjie/channel/bean/FlashMessageItem;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Companion", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FlashMessageItem extends MultiItemEntity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int TYPE_BUDDY_CHAT = 1;
    public static final int TYPE_SINGLE_CHAT = 2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/channel/bean/FlashMessageItem$Companion;", "", "()V", "TYPE_BUDDY_CHAT", "", "TYPE_SINGLE_CHAT", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int TYPE_BUDDY_CHAT = 1;
        public static final int TYPE_SINGLE_CHAT = 2;

        private Companion() {
        }
    }
}
