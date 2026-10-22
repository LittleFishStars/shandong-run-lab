package com.huachenjie.im.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/im/bean/EmojiDetailData;", "", "emojiList", "", "Lcom/huachenjie/im/bean/EmojiBean;", "(Ljava/util/List;)V", "getEmojiList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiDetailData {

    @Nullable
    private final List<EmojiBean> emojiList;

    /* JADX WARN: Illegal instructions before constructor call */
    public EmojiDetailData() {
        List list = null;
        this(list, 1, list);
    }

    public EmojiDetailData(@Nullable List<EmojiBean> list) {
        this.emojiList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmojiDetailData copy$default(EmojiDetailData emojiDetailData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = emojiDetailData.emojiList;
        }
        return emojiDetailData.copy(list);
    }

    @Nullable
    public final List<EmojiBean> component1() {
        return this.emojiList;
    }

    @NotNull
    public final EmojiDetailData copy(@Nullable List<EmojiBean> emojiList) {
        return new EmojiDetailData(emojiList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EmojiDetailData) && Intrinsics.areEqual(this.emojiList, ((EmojiDetailData) other).emojiList);
    }

    @Nullable
    public final List<EmojiBean> getEmojiList() {
        return this.emojiList;
    }

    public int hashCode() {
        List<EmojiBean> list = this.emojiList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmojiDetailData(emojiList=" + this.emojiList + ')';
    }

    public /* synthetic */ EmojiDetailData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }
}
