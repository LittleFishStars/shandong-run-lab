package com.huachenjie.im.bean;

import com.huachenjie.base.widget.OperatePopupWindow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/im/bean/EmojiListData;", "", "emojiBagList", "", "Lcom/huachenjie/im/bean/EmojiItemData;", "(Ljava/util/List;)V", "getEmojiBagList", "()Ljava/util/List;", "component1", OperatePopupWindow.g, "equals", "", "other", "hashCode", "", "toString", "", "IM_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EmojiListData {

    @Nullable
    private final List<EmojiItemData> emojiBagList;

    /* JADX WARN: Illegal instructions before constructor call */
    public EmojiListData() {
        List list = null;
        this(list, 1, list);
    }

    public EmojiListData(@Nullable List<EmojiItemData> list) {
        this.emojiBagList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmojiListData copy$default(EmojiListData emojiListData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = emojiListData.emojiBagList;
        }
        return emojiListData.copy(list);
    }

    @Nullable
    public final List<EmojiItemData> component1() {
        return this.emojiBagList;
    }

    @NotNull
    public final EmojiListData copy(@Nullable List<EmojiItemData> emojiBagList) {
        return new EmojiListData(emojiBagList);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof EmojiListData) && Intrinsics.areEqual(this.emojiBagList, ((EmojiListData) other).emojiBagList);
    }

    @Nullable
    public final List<EmojiItemData> getEmojiBagList() {
        return this.emojiBagList;
    }

    public int hashCode() {
        List<EmojiItemData> list = this.emojiBagList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "EmojiListData(emojiBagList=" + this.emojiBagList + ')';
    }

    public /* synthetic */ EmojiListData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }
}
