package com.zj.adlib;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.huachenjie.im.constants.ImMessageType;
import com.huachenjie.im.custom.EmojiStickerAttachment;
import com.huachenjie.im.custom.GiftGivingAttachment;
import com.huachenjie.im.custom.MessageTimeAttachment;
import com.huachenjie.im.custom.MomentMessageAttachment;
import com.huachenjie.im.custom.MomentShareAttachment;
import com.huachenjie.im.custom.ShareChannelAttachment;
import com.huachenjie.im.custom.ShareCommodityAttachment;
import com.huachenjie.im.custom.ShareEmojiAttachment;
import com.huachenjie.im.custom.ShareGoodsAttachment;
import com.huachenjie.im.custom.ShareLinkAttachment;
import com.huachenjie.im.custom.ShareOrderAttachment;
import com.huachenjie.im.custom.ShareTopicAttachment;
import com.huachenjie.im.custom.ShareWorkAttachment;
import com.huachenjie.im.custom.StarAllianceAttachment;
import com.huachenjie.im.custom.TeamInvitationAttachment;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.constant.MsgTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class j64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f42518a = 60000;
    public static final long b = 3600000;
    public static final long c = 86400000;
    public static final long d = 604800000;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42519a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ImMessageType.values().length];
            b = iArr;
            try {
                iArr[ImMessageType.CUSTOM_SHARE_LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ImMessageType.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ImMessageType.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[ImMessageType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[ImMessageType.CUSTOM_EMOJI_STICKER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[ImMessageType.CUSTOM_MOMENTS_IMAGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[ImMessageType.CUSTOM_MOMENTS_AUDIO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[ImMessageType.CUSTOM_MOMENTS_VIDEO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[ImMessageType.CUSTOM_SHARE_MOMENTS_IMAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[ImMessageType.CUSTOM_SHARE_MOMENTS_VIDEO.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[ImMessageType.CUSTOM_SHARE_MOMENTS_AUDIO.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[ImMessageType.CUSTOM_SHARE_WORK.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[ImMessageType.CUSTOM_SHARE_CHANNEL.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[ImMessageType.CUSTOM_SHARE_TOPIC.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                b[ImMessageType.CUSTOM_SHARE_COMMODITY.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr2 = new int[MsgTypeEnum.values().length];
            f42519a = iArr2;
            try {
                iArr2[MsgTypeEnum.text.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f42519a[MsgTypeEnum.image.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f42519a[MsgTypeEnum.audio.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f42519a[MsgTypeEnum.video.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f42519a[MsgTypeEnum.location.ordinal()] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f42519a[MsgTypeEnum.file.ordinal()] = 6;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f42519a[MsgTypeEnum.notification.ordinal()] = 7;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f42519a[MsgTypeEnum.avchat.ordinal()] = 8;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f42519a[MsgTypeEnum.tip.ordinal()] = 9;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f42519a[MsgTypeEnum.robot.ordinal()] = 10;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f42519a[MsgTypeEnum.nrtc_netcall.ordinal()] = 11;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f42519a[MsgTypeEnum.appCustom.ordinal()] = 12;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f42519a[MsgTypeEnum.qiyuCustom.ordinal()] = 13;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f42519a[MsgTypeEnum.custom.ordinal()] = 14;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f42519a[MsgTypeEnum.undef.ordinal()] = 15;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f42519a[MsgTypeEnum.qchatCustom.ordinal()] = 16;
            } catch (NoSuchFieldError unused31) {
            }
        }
    }

    public static String a(String str) {
        try {
            return new JSONObject(str).optString("url");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b(MsgTypeEnum msgTypeEnum, String str, MsgAttachment msgAttachment, Boolean bool) {
        switch (a.f42519a[msgTypeEnum.ordinal()]) {
            case 1:
                if (str == null) {
                    str = "";
                }
                return str;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return msgTypeEnum.getSendMessageTip() + "消息";
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return "";
            case 14:
                if (msgAttachment == null) {
                    return "未定义消息";
                }
                i4a.a(msgAttachment.toJson(false));
                if (msgAttachment instanceof ShareLinkAttachment) {
                    return "网页分享";
                }
                if (msgAttachment instanceof GiftGivingAttachment) {
                    return "获赠消息";
                }
                if (msgAttachment instanceof TeamInvitationAttachment) {
                    return bool.booleanValue() ? "邀请入队消息" : "邀请你加入队伍";
                }
                if (msgAttachment instanceof EmojiStickerAttachment) {
                    return "动图消息";
                }
                if (msgAttachment instanceof StarAllianceAttachment) {
                    return "结盟消息";
                }
                if (msgAttachment instanceof ShareEmojiAttachment) {
                    return "动图分享";
                }
                if (msgAttachment instanceof MomentShareAttachment) {
                    return "此刻作品";
                }
                if (msgAttachment instanceof ShareWorkAttachment) {
                    return "作品分享";
                }
                if (msgAttachment instanceof ShareChannelAttachment) {
                    return "频道分享";
                }
                if (msgAttachment instanceof ShareTopicAttachment) {
                    return "话题分享";
                }
                if (msgAttachment instanceof ShareCommodityAttachment) {
                    return "商品分享";
                }
                if (msgAttachment instanceof ShareGoodsAttachment) {
                    return "咨询商品";
                }
                return msgAttachment instanceof ShareOrderAttachment ? "咨询订单" : "未定义消息";
            default:
                return "未知消息";
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String c(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (jCurrentTimeMillis <= 600000) {
            return "刚刚";
        }
        if (jCurrentTimeMillis <= 3600000) {
            return String.format("%d分钟前", Long.valueOf(jCurrentTimeMillis / 60000));
        }
        if (jCurrentTimeMillis <= 86400000) {
            return String.format("%d小时前", Long.valueOf(jCurrentTimeMillis / 3600000));
        }
        return jCurrentTimeMillis <= 604800000 ? String.format("%d天前", Long.valueOf(jCurrentTimeMillis / 86400000)) : "一周前";
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return c(Long.parseLong(str));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String e(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E", Locale.getDefault()).format(Long.valueOf(j));
    }

    public static boolean f(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean g(IMMessage iMMessage, String str) {
        Map remoteExtension;
        if (iMMessage == null || (remoteExtension = iMMessage.getRemoteExtension()) == null) {
            return false;
        }
        return f(remoteExtension.get(str));
    }

    public static float h(Object obj) {
        if (obj == null) {
            return 0.0f;
        }
        try {
            return ((Float) obj).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public static float i(IMMessage iMMessage, String str) {
        Map remoteExtension;
        if (iMMessage == null || (remoteExtension = iMMessage.getRemoteExtension()) == null) {
            return 0.0f;
        }
        return h(remoteExtension.get(str));
    }

    public static int j(Object obj) {
        if (obj == null) {
            return 0;
        }
        try {
            return ((Integer) obj).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int k(IMMessage iMMessage, String str) {
        Map remoteExtension;
        if (iMMessage == null || (remoteExtension = iMMessage.getRemoteExtension()) == null) {
            return 0;
        }
        return j(remoteExtension.get(str));
    }

    public static long l(Object obj) {
        if (obj == null) {
            return 0L;
        }
        try {
            return ((Long) obj).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long m(IMMessage iMMessage, String str) {
        Map remoteExtension;
        if (iMMessage == null || (remoteExtension = iMMessage.getRemoteExtension()) == null) {
            return 0L;
        }
        return l(remoteExtension.get(str));
    }

    public static ImMessageType n(IMMessage iMMessage) {
        return o(iMMessage, true);
    }

    public static ImMessageType o(IMMessage iMMessage, boolean z) {
        int i = a.f42519a[iMMessage.getMsgType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                return z ? ImMessageType.IMAGE : ImMessageType.IMAGE_FRIEND;
            }
            if (i == 3) {
                return z ? ImMessageType.AUDIO : ImMessageType.AUDIO_FRIEND;
            }
            if (i != 14) {
                return z ? ImMessageType.UNKNOWN : ImMessageType.UNKNOWN_FRIEND;
            }
            MsgAttachment attachment = iMMessage.getAttachment();
            if (attachment != null) {
                i4a.a(attachment.toJson(false));
                if (attachment instanceof ShareLinkAttachment) {
                    return z ? ImMessageType.CUSTOM_SHARE_LINK : ImMessageType.CUSTOM_SHARE_LINK_FRIEND;
                }
                if (attachment instanceof MessageTimeAttachment) {
                    return ImMessageType.CUSTOM_SEND_MESSAGE_TIME;
                }
                if (attachment instanceof GiftGivingAttachment) {
                    return z ? ImMessageType.CUSTOM_GIFT : ImMessageType.CUSTOM_GIFT_FRIEND;
                }
                if (attachment instanceof TeamInvitationAttachment) {
                    return z ? ImMessageType.CUSTOM_INVITATION : ImMessageType.CUSTOM_INVITATION_FRIEND;
                }
                if (attachment instanceof EmojiStickerAttachment) {
                    return z ? ImMessageType.CUSTOM_EMOJI_STICKER : ImMessageType.CUSTOM_EMOJI_STICKER_FRIEND;
                }
                if (attachment instanceof StarAllianceAttachment) {
                    return z ? ImMessageType.CUSTOM_STAR_ALLIANCE : ImMessageType.CUSTOM_STAR_ALLIANCE_FRIEND;
                }
                if (attachment instanceof ShareEmojiAttachment) {
                    return z ? ImMessageType.CUSTOM_SHARE_EMOJI : ImMessageType.CUSTOM_SHARE_EMOJI_FRIEND;
                }
                if (attachment instanceof MomentShareAttachment) {
                    int momentType = ((MomentMessageAttachment) attachment).getMomentType();
                    if (momentType == 0) {
                        return z ? ImMessageType.CUSTOM_SHARE_MOMENTS_IMAGE : ImMessageType.CUSTOM_SHARE_MOMENTS_IMAGE_FRIEND;
                    }
                    if (momentType == 1) {
                        return z ? ImMessageType.CUSTOM_SHARE_MOMENTS_AUDIO : ImMessageType.CUSTOM_SHARE_MOMENTS_AUDIO_FRIEND;
                    }
                    if (momentType == 2) {
                        return z ? ImMessageType.CUSTOM_SHARE_MOMENTS_VIDEO : ImMessageType.CUSTOM_SHARE_MOMENTS_VIDEO_FRIEND;
                    }
                } else {
                    if (attachment instanceof ShareWorkAttachment) {
                        return z ? ImMessageType.CUSTOM_SHARE_WORK : ImMessageType.CUSTOM_SHARE_WORK_FRIEND;
                    }
                    if (attachment instanceof ShareChannelAttachment) {
                        return z ? ImMessageType.CUSTOM_SHARE_CHANNEL : ImMessageType.CUSTOM_SHARE_CHANNEL_FRIEND;
                    }
                    if (attachment instanceof ShareTopicAttachment) {
                        return z ? ImMessageType.CUSTOM_SHARE_TOPIC : ImMessageType.CUSTOM_SHARE_TOPIC_FRIEND;
                    }
                    if (attachment instanceof ShareCommodityAttachment) {
                        return z ? ImMessageType.CUSTOM_SHARE_COMMODITY : ImMessageType.CUSTOM_SHARE_COMMODITY_FRIEND;
                    }
                    if (attachment instanceof ShareOrderAttachment) {
                        return z ? ImMessageType.CUSTOM_SHARE_ORDER : ImMessageType.CUSTOM_SHARE_ORDER_FRIEND;
                    }
                    if (attachment instanceof ShareGoodsAttachment) {
                        return z ? ImMessageType.CUSTOM_CURRENT_GOODS : ImMessageType.CUSTOM_CURRENT_GOODS_FRIEND;
                    }
                }
            }
        }
        return z ? ImMessageType.TEXT : ImMessageType.TEXT_FRIEND;
    }

    public static String p(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return (String) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String q(IMMessage iMMessage, String str) {
        Map remoteExtension;
        return (iMMessage == null || (remoteExtension = iMMessage.getRemoteExtension()) == null) ? "" : p(remoteExtension.get(str));
    }

    public static String r(Map<String, Object> map, String str) {
        return map == null ? "" : p(map.get(str));
    }

    public static String s(int i) {
        return i > 99 ? "99+" : String.valueOf(i);
    }

    public static boolean t(IMMessage iMMessage) {
        switch (a.b[n(iMMessage).ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }
}
