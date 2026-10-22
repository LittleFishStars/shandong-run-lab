package com.huachenjie.channel.bean.notify;

import com.blankj.utilcode.util.Utils;
import com.huachenjie.channel.R;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zj.adlib.s72;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u0000 $2\u00020\u0001:\u0001$B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011¨\u0006%"}, d2 = {"Lcom/huachenjie/channel/bean/notify/NotifyMailBoxBean;", "", "createTime", "", "messageType", "", "messageSubType", "readFlag", "", "msgTitle", "", RemoteMessageConst.MessageBody.MSG_CONTENT, RemoteMessageConst.MSGID, "channelNo", yj7.g.WORKS_NO, "(JIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelNo", "()Ljava/lang/String;", "getCreateTime", "()J", "getMessageSubType", "()I", "getMessageType", "getMsgContent", "getMsgId", "getMsgTitle", "getReadFlag", "()Z", "setReadFlag", "(Z)V", "getWorksNo", "formatLetterTime", "formatPassBgColor", "formatPassStatus", "showLookDetail", "showPassStatus", "Companion", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NotifyMailBoxBean {
    private static final int MESSAGE_SUB_TYPE_CHANEL_DISSOLVE = 85;
    private static final int MESSAGE_SUB_TYPE_CHANNEL_NO_PASS = 82;
    private static final int MESSAGE_SUB_TYPE_CHANNEL_PASS = 81;
    private static final int MESSAGE_SUB_TYPE_WORKS_NO_PASS = 84;
    public static final int MESSAGE_TYPE_CHANNEL = 83;
    public static final int MESSAGE_TYPE_CHANNEL_DISSOLVE = 84;
    public static final int MESSAGE_TYPE_WORKS = 82;

    @NotNull
    private final String channelNo;
    private final long createTime;
    private final int messageSubType;
    private final int messageType;

    @NotNull
    private final String msgContent;

    @NotNull
    private final String msgId;

    @NotNull
    private final String msgTitle;
    private boolean readFlag;

    @NotNull
    private final String worksNo;

    public NotifyMailBoxBean() {
        this(0L, 0, 0, false, null, null, null, null, null, 511, null);
    }

    public NotifyMailBoxBean(long j, int i, int i2, boolean z, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "msgTitle");
        Intrinsics.checkNotNullParameter(str2, RemoteMessageConst.MessageBody.MSG_CONTENT);
        Intrinsics.checkNotNullParameter(str3, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(str4, "channelNo");
        Intrinsics.checkNotNullParameter(str5, yj7.g.WORKS_NO);
        this.createTime = j;
        this.messageType = i;
        this.messageSubType = i2;
        this.readFlag = z;
        this.msgTitle = str;
        this.msgContent = str2;
        this.msgId = str3;
        this.channelNo = str4;
        this.worksNo = str5;
    }

    @NotNull
    public final String formatLetterTime() {
        long j = this.createTime;
        if (j == 0) {
            return "";
        }
        if (s72.z(j)) {
            String strC = s72.A(this.createTime) ? s72.c(this.createTime, "HH:mm") : s72.c(this.createTime, "MM.dd HH:mm");
            Intrinsics.checkNotNullExpressionValue(strC, "{\n            if (DateUt…)\n            }\n        }");
            return strC;
        }
        String strC2 = s72.c(this.createTime, "yyyy.MM.dd");
        Intrinsics.checkNotNullExpressionValue(strC2, "{\n            DateUtil.f…, \"yyyy.MM.dd\")\n        }");
        return strC2;
    }

    public final int formatPassBgColor() {
        if (!showPassStatus()) {
            return 0;
        }
        int i = this.messageSubType;
        if (i == 81) {
            return R.color.color_00C97C;
        }
        if (i != 82) {
            return 0;
        }
        return R.color.color_FF3D3D;
    }

    @NotNull
    public final String formatPassStatus() {
        if (!showPassStatus()) {
            return "";
        }
        int i = this.messageSubType;
        if (i == 81) {
            String string = Utils.a().getString(R.string.channel_notify_channel_pass);
            Intrinsics.checkNotNullExpressionValue(string, "getApp()\n               …nnel_notify_channel_pass)");
            return string;
        }
        if (i != 82) {
            return "";
        }
        String string2 = Utils.a().getString(R.string.channel_notify_channel_no_pass);
        Intrinsics.checkNotNullExpressionValue(string2, "getApp()\n               …l_notify_channel_no_pass)");
        return string2;
    }

    @NotNull
    public final String getChannelNo() {
        return this.channelNo;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final int getMessageSubType() {
        return this.messageSubType;
    }

    public final int getMessageType() {
        return this.messageType;
    }

    @NotNull
    public final String getMsgContent() {
        return this.msgContent;
    }

    @NotNull
    public final String getMsgId() {
        return this.msgId;
    }

    @NotNull
    public final String getMsgTitle() {
        return this.msgTitle;
    }

    public final boolean getReadFlag() {
        return this.readFlag;
    }

    @NotNull
    public final String getWorksNo() {
        return this.worksNo;
    }

    public final void setReadFlag(boolean z) {
        this.readFlag = z;
    }

    public final boolean showLookDetail() {
        return this.messageType == 82;
    }

    public final boolean showPassStatus() {
        return this.messageType == 83;
    }

    public /* synthetic */ NotifyMailBoxBean(long j, int i, int i2, boolean z, String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) == 0 ? z : false, (i3 & 16) != 0 ? "" : str, (i3 & 32) != 0 ? "" : str2, (i3 & 64) != 0 ? "" : str3, (i3 & 128) != 0 ? "" : str4, (i3 & 256) == 0 ? str5 : "");
    }
}
