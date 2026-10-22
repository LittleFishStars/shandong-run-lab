package com.huachenjie.im.custom.base;

import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.huachenjie.im.custom.EmojiStickerAttachment;
import com.huachenjie.im.custom.GiftGivingAttachment;
import com.huachenjie.im.custom.MessageTimeAttachment;
import com.huachenjie.im.custom.MomentAtAttachment;
import com.huachenjie.im.custom.MomentFollowAttachment;
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
import com.netease.nimlib.sdk.msg.attachment.MsgAttachmentParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class CustomAttachParser implements MsgAttachmentParser {
    @Nullable
    private MsgAttachment createAttachmentByJson(String str, Class<? extends MsgAttachment> cls) {
        try {
            return (MsgAttachment) new Gson().fromJson(str, (Class) cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public MsgAttachment parse(String str) {
        try {
            int iOptInt = new JSONObject(str).optInt("customType");
            if (iOptInt == 100) {
                return createAttachmentByJson(str, ShareLinkAttachment.class);
            }
            switch (iOptInt) {
                case -1:
                    return createAttachmentByJson(str, MessageTimeAttachment.class);
                case 0:
                    return createAttachmentByJson(str, GiftGivingAttachment.class);
                case 1:
                    return createAttachmentByJson(str, TeamInvitationAttachment.class);
                case 2:
                    return createAttachmentByJson(str, EmojiStickerAttachment.class);
                case 3:
                    return createAttachmentByJson(str, StarAllianceAttachment.class);
                case 4:
                    return createAttachmentByJson(str, ShareEmojiAttachment.class);
                case 5:
                    return createAttachmentByJson(str, MomentAtAttachment.class);
                case 6:
                    return createAttachmentByJson(str, MomentMessageAttachment.class);
                case 7:
                    return createAttachmentByJson(str, MomentFollowAttachment.class);
                case 8:
                    return createAttachmentByJson(str, MomentShareAttachment.class);
                case 9:
                    return createAttachmentByJson(str, ShareWorkAttachment.class);
                case 10:
                    return createAttachmentByJson(str, ShareChannelAttachment.class);
                case 11:
                    return createAttachmentByJson(str, ShareTopicAttachment.class);
                case 12:
                    return createAttachmentByJson(str, ShareCommodityAttachment.class);
                case 13:
                    return createAttachmentByJson(str, ShareOrderAttachment.class);
                case 14:
                    return createAttachmentByJson(str, ShareGoodsAttachment.class);
                default:
                    return createAttachmentByJson(str, GiftGivingAttachment.class);
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
