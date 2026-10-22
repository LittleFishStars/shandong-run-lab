package com.huachenjie.channel.bean;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/channel/bean/JoinAllChannelEntity;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/channel/bean/JoinAllChannelBean;", TypedValues.CycleType.S_WAVE_OFFSET, "", "position", "(II)V", "getOffset", "()I", "setOffset", "(I)V", "getPosition", "setPosition", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JoinAllChannelEntity extends PageEntity<JoinAllChannelBean> {
    private int offset;
    private int position;

    /* JADX WARN: Illegal instructions before constructor call */
    public JoinAllChannelEntity() {
        int i = 0;
        this(i, i, 3, null);
    }

    public /* synthetic */ JoinAllChannelEntity(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getOffset() {
        return this.offset;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setOffset(int i) {
        this.offset = i;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public JoinAllChannelEntity(int i, int i2) {
        this.offset = i;
        this.position = i2;
    }
}
