package com.huachenjie.im.constants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public enum ImMessageType {
    UNKNOWN(-2),
    UNKNOWN_FRIEND(-1),
    DEFAULT(0),
    TEXT(1),
    TEXT_FRIEND(2),
    IMAGE(3),
    IMAGE_FRIEND(4),
    AUDIO(5),
    AUDIO_FRIEND(6),
    CUSTOM_GIFT(7),
    CUSTOM_GIFT_FRIEND(8),
    CUSTOM_INVITATION(9),
    CUSTOM_INVITATION_FRIEND(10),
    CUSTOM_EMOJI_STICKER(11),
    CUSTOM_EMOJI_STICKER_FRIEND(12),
    CUSTOM_STAR_ALLIANCE(13),
    CUSTOM_STAR_ALLIANCE_FRIEND(14),
    CUSTOM_SHARE_EMOJI(15),
    CUSTOM_SHARE_EMOJI_FRIEND(16),
    CUSTOM_MOMENTS_IMAGE(17),
    CUSTOM_MOMENTS_AUDIO(18),
    CUSTOM_MOMENTS_VIDEO(19),
    CUSTOM_MOMENTS_AT(20),
    CUSTOM_MOMENTS_FOLLOW(21),
    CUSTOM_SHARE_MOMENTS_IMAGE(22),
    CUSTOM_SHARE_MOMENTS_IMAGE_FRIEND(23),
    CUSTOM_SHARE_MOMENTS_AUDIO(24),
    CUSTOM_SHARE_MOMENTS_AUDIO_FRIEND(25),
    CUSTOM_SHARE_MOMENTS_VIDEO(26),
    CUSTOM_SHARE_MOMENTS_VIDEO_FRIEND(27),
    CUSTOM_SEND_MESSAGE_TIME(28),
    CUSTOM_SHARE_WORK(29),
    CUSTOM_SHARE_WORK_FRIEND(30),
    CUSTOM_SHARE_CHANNEL(31),
    CUSTOM_SHARE_CHANNEL_FRIEND(32),
    CUSTOM_SHARE_TOPIC(33),
    CUSTOM_SHARE_TOPIC_FRIEND(34),
    CUSTOM_SHARE_COMMODITY(35),
    CUSTOM_SHARE_COMMODITY_FRIEND(36),
    CUSTOM_SHARE_LINK(37),
    CUSTOM_SHARE_LINK_FRIEND(38),
    CUSTOM_SHARE_ORDER(39),
    CUSTOM_SHARE_ORDER_FRIEND(40),
    CUSTOM_CURRENT_GOODS(41),
    CUSTOM_CURRENT_GOODS_FRIEND(42);

    private int value;

    ImMessageType(int i) {
        this.value = i;
    }

    public static ImMessageType get(int i) {
        switch (i) {
            case -2:
                return UNKNOWN;
            case -1:
                return UNKNOWN_FRIEND;
            case 0:
            default:
                return DEFAULT;
            case 1:
                return TEXT;
            case 2:
                return TEXT_FRIEND;
            case 3:
                return IMAGE;
            case 4:
                return IMAGE_FRIEND;
            case 5:
                return AUDIO;
            case 6:
                return AUDIO_FRIEND;
            case 7:
                return CUSTOM_GIFT;
            case 8:
                return CUSTOM_GIFT_FRIEND;
            case 9:
                return CUSTOM_INVITATION;
            case 10:
                return CUSTOM_INVITATION_FRIEND;
            case 11:
                return CUSTOM_EMOJI_STICKER;
            case 12:
                return CUSTOM_EMOJI_STICKER_FRIEND;
            case 13:
                return CUSTOM_STAR_ALLIANCE;
            case 14:
                return CUSTOM_STAR_ALLIANCE_FRIEND;
            case 15:
                return CUSTOM_SHARE_EMOJI;
            case 16:
                return CUSTOM_SHARE_EMOJI_FRIEND;
            case 17:
                return CUSTOM_MOMENTS_IMAGE;
            case 18:
                return CUSTOM_MOMENTS_AUDIO;
            case 19:
                return CUSTOM_MOMENTS_VIDEO;
            case 20:
                return CUSTOM_MOMENTS_AT;
            case 21:
                return CUSTOM_MOMENTS_FOLLOW;
            case 22:
                return CUSTOM_SHARE_MOMENTS_IMAGE;
            case 23:
                return CUSTOM_SHARE_MOMENTS_IMAGE_FRIEND;
            case 24:
                return CUSTOM_SHARE_MOMENTS_AUDIO;
            case 25:
                return CUSTOM_SHARE_MOMENTS_AUDIO_FRIEND;
            case 26:
                return CUSTOM_SHARE_MOMENTS_VIDEO;
            case 27:
                return CUSTOM_SHARE_MOMENTS_VIDEO_FRIEND;
            case 28:
                return CUSTOM_SEND_MESSAGE_TIME;
            case 29:
                return CUSTOM_SHARE_WORK;
            case 30:
                return CUSTOM_SHARE_WORK_FRIEND;
            case 31:
                return CUSTOM_SHARE_CHANNEL;
            case 32:
                return CUSTOM_SHARE_CHANNEL_FRIEND;
            case 33:
                return CUSTOM_SHARE_TOPIC;
            case 34:
                return CUSTOM_SHARE_TOPIC_FRIEND;
            case 35:
                return CUSTOM_SHARE_COMMODITY;
            case 36:
                return CUSTOM_SHARE_COMMODITY_FRIEND;
            case 37:
                return CUSTOM_SHARE_LINK;
            case 38:
                return CUSTOM_SHARE_LINK_FRIEND;
            case 39:
                return CUSTOM_SHARE_ORDER;
            case 40:
                return CUSTOM_SHARE_ORDER_FRIEND;
            case 41:
                return CUSTOM_CURRENT_GOODS;
            case 42:
                return CUSTOM_CURRENT_GOODS_FRIEND;
        }
    }

    public int getValue() {
        return this.value;
    }
}
