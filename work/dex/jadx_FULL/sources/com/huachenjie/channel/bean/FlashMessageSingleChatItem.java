package com.huachenjie.channel.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.college.page.home.CollegeTownItemFragment;
import com.huachenjie.im.bean.ContactUserBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\bHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/channel/bean/FlashMessageSingleChatItem;", "Lcom/huachenjie/channel/bean/FlashMessageItem;", "contact", "Lcom/huachenjie/im/bean/ContactUserBean;", "(Lcom/huachenjie/im/bean/ContactUserBean;)V", "getContact", "()Lcom/huachenjie/im/bean/ContactUserBean;", CollegeTownItemFragment.ITEM_TYPE, "", "getItemType", "()I", "component1", OperatePopupWindow.g, "equals", "", "other", "", "hashCode", "toString", "", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FlashMessageSingleChatItem implements FlashMessageItem {

    @NotNull
    private final ContactUserBean contact;
    private final int itemType;

    public FlashMessageSingleChatItem(@NotNull ContactUserBean contactUserBean) {
        Intrinsics.checkNotNullParameter(contactUserBean, "contact");
        this.contact = contactUserBean;
        this.itemType = 2;
    }

    public static /* synthetic */ FlashMessageSingleChatItem copy$default(FlashMessageSingleChatItem flashMessageSingleChatItem, ContactUserBean contactUserBean, int i, Object obj) {
        if ((i & 1) != 0) {
            contactUserBean = flashMessageSingleChatItem.contact;
        }
        return flashMessageSingleChatItem.copy(contactUserBean);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ContactUserBean getContact() {
        return this.contact;
    }

    @NotNull
    public final FlashMessageSingleChatItem copy(@NotNull ContactUserBean contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        return new FlashMessageSingleChatItem(contact);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FlashMessageSingleChatItem) && Intrinsics.areEqual(this.contact, ((FlashMessageSingleChatItem) other).contact);
    }

    @NotNull
    public final ContactUserBean getContact() {
        return this.contact;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.itemType;
    }

    public int hashCode() {
        return this.contact.hashCode();
    }

    @NotNull
    public String toString() {
        return "FlashMessageSingleChatItem(contact=" + this.contact + ')';
    }
}
