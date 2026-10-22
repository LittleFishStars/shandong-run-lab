package com.huachenjie.im.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseDelegateMultiAdapter;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.huachenjie.im.R;
import com.huachenjie.im.constants.ImMessageType;
import com.huachenjie.im.viewHolder.BaseChatViewHolder;
import com.huachenjie.im.viewHolder.ChatAudioViewHolder;
import com.huachenjie.im.viewHolder.ChatEmojiStickerViewHolder;
import com.huachenjie.im.viewHolder.ChatGiftViewHolder;
import com.huachenjie.im.viewHolder.ChatImageViewHolder;
import com.huachenjie.im.viewHolder.ChatInvitationViewHolder;
import com.huachenjie.im.viewHolder.ChatStarAllianceViewHolder;
import com.huachenjie.im.viewHolder.ChatTextViewHolder;
import com.huachenjie.im.viewHolder.ChatTimeViewHolder;
import com.huachenjie.im.viewHolder.CurrentGoodsViewHolder;
import com.huachenjie.im.viewHolder.ShareChannelViewHolder;
import com.huachenjie.im.viewHolder.ShareCommodityViewHolder;
import com.huachenjie.im.viewHolder.ShareEmojiViewHolder;
import com.huachenjie.im.viewHolder.ShareLinkViewHolder;
import com.huachenjie.im.viewHolder.ShareMomentAudioViewHolder;
import com.huachenjie.im.viewHolder.ShareMomentImageViewHolder;
import com.huachenjie.im.viewHolder.ShareMomentVideoViewHolder;
import com.huachenjie.im.viewHolder.ShareOrderViewHolder;
import com.huachenjie.im.viewHolder.ShareTopicViewHolder;
import com.huachenjie.im.viewHolder.ShareWorkViewHolder;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.j64;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ChatAdapter extends BaseDelegateMultiAdapter<IMMessage, BaseChatViewHolder> {
    public String f;

    public class a extends BaseMultiTypeDelegate<IMMessage> {
        public a() {
        }

        @Override // com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate
        public int getItemType(@NonNull List<? extends IMMessage> list, int i) {
            return ChatAdapter.this.getViewType(list.get(i));
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34391a;

        static {
            int[] iArr = new int[ImMessageType.values().length];
            f34391a = iArr;
            try {
                iArr[ImMessageType.CUSTOM_SHARE_LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_LINK_FRIEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34391a[ImMessageType.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34391a[ImMessageType.TEXT_FRIEND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34391a[ImMessageType.IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34391a[ImMessageType.IMAGE_FRIEND.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34391a[ImMessageType.AUDIO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f34391a[ImMessageType.AUDIO_FRIEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_GIFT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_GIFT_FRIEND.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_INVITATION.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_INVITATION_FRIEND.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_EMOJI_STICKER.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_EMOJI_STICKER_FRIEND.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_STAR_ALLIANCE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_STAR_ALLIANCE_FRIEND.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_EMOJI.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_EMOJI_FRIEND.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_MOMENTS_IMAGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_MOMENTS_IMAGE_FRIEND.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_MOMENTS_AUDIO.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_MOMENTS_AUDIO_FRIEND.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_MOMENTS_VIDEO.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_MOMENTS_VIDEO_FRIEND.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SEND_MESSAGE_TIME.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_WORK.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_WORK_FRIEND.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_CHANNEL.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_CHANNEL_FRIEND.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_TOPIC.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_TOPIC_FRIEND.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_COMMODITY.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_COMMODITY_FRIEND.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_ORDER.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_SHARE_ORDER_FRIEND.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_CURRENT_GOODS.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f34391a[ImMessageType.CUSTOM_CURRENT_GOODS_FRIEND.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
        }
    }

    public ChatAdapter(String str) {
        this.f = str;
        setMultiTypeDelegate(new a());
        getMultiTypeDelegate().addItemType(ImMessageType.TEXT.getValue(), R.layout.item_chat_text_mine).addItemType(ImMessageType.TEXT_FRIEND.getValue(), R.layout.item_chat_text_other).addItemType(ImMessageType.IMAGE.getValue(), R.layout.item_chat_image_mine).addItemType(ImMessageType.IMAGE_FRIEND.getValue(), R.layout.item_chat_image_other).addItemType(ImMessageType.AUDIO.getValue(), R.layout.item_chat_audio_mine).addItemType(ImMessageType.AUDIO_FRIEND.getValue(), R.layout.item_chat_audio_other).addItemType(ImMessageType.CUSTOM_GIFT.getValue(), R.layout.item_chat_custom_gift_mine).addItemType(ImMessageType.CUSTOM_GIFT_FRIEND.getValue(), R.layout.item_chat_custom_gift_other).addItemType(ImMessageType.CUSTOM_INVITATION.getValue(), R.layout.item_chat_custom_invitation_mine).addItemType(ImMessageType.CUSTOM_INVITATION_FRIEND.getValue(), R.layout.item_chat_custom_invitation_other).addItemType(ImMessageType.CUSTOM_EMOJI_STICKER.getValue(), R.layout.item_chat_custom_emoji_mine).addItemType(ImMessageType.CUSTOM_EMOJI_STICKER_FRIEND.getValue(), R.layout.item_chat_custom_emoji_other).addItemType(ImMessageType.CUSTOM_STAR_ALLIANCE.getValue(), R.layout.item_chat_custom_star_alliance_mine).addItemType(ImMessageType.CUSTOM_STAR_ALLIANCE_FRIEND.getValue(), R.layout.item_chat_custom_star_alliance_other).addItemType(ImMessageType.CUSTOM_SHARE_EMOJI.getValue(), R.layout.item_chat_custom_share_emoji_mine).addItemType(ImMessageType.CUSTOM_SHARE_EMOJI_FRIEND.getValue(), R.layout.item_chat_custom_share_emoji_other).addItemType(ImMessageType.CUSTOM_SHARE_MOMENTS_IMAGE.getValue(), R.layout.item_chat_share_moments_image_mine).addItemType(ImMessageType.CUSTOM_SHARE_MOMENTS_IMAGE_FRIEND.getValue(), R.layout.item_chat_share_moments_image_other).addItemType(ImMessageType.CUSTOM_SHARE_MOMENTS_AUDIO.getValue(), R.layout.item_chat_share_moments_audio_mine).addItemType(ImMessageType.CUSTOM_SHARE_MOMENTS_AUDIO_FRIEND.getValue(), R.layout.item_chat_share_moments_audio_other).addItemType(ImMessageType.CUSTOM_SHARE_MOMENTS_VIDEO.getValue(), R.layout.item_chat_share_moments_video_mine).addItemType(ImMessageType.CUSTOM_SHARE_MOMENTS_VIDEO_FRIEND.getValue(), R.layout.item_chat_share_moments_video_other).addItemType(ImMessageType.CUSTOM_SEND_MESSAGE_TIME.getValue(), R.layout.item_chat_send_time).addItemType(ImMessageType.CUSTOM_SHARE_LINK.getValue(), R.layout.item_chat_custom_share_link_mine).addItemType(ImMessageType.CUSTOM_SHARE_LINK_FRIEND.getValue(), R.layout.item_chat_custom_share_link_other).addItemType(ImMessageType.CUSTOM_SHARE_WORK.getValue(), R.layout.item_chat_custom_share_work_mine).addItemType(ImMessageType.CUSTOM_SHARE_WORK_FRIEND.getValue(), R.layout.item_chat_custom_share_work_other).addItemType(ImMessageType.CUSTOM_SHARE_CHANNEL.getValue(), R.layout.item_chat_custom_share_channel_mine).addItemType(ImMessageType.CUSTOM_SHARE_CHANNEL_FRIEND.getValue(), R.layout.item_chat_custom_share_channel_other).addItemType(ImMessageType.CUSTOM_SHARE_TOPIC.getValue(), R.layout.item_chat_custom_share_topic_mine).addItemType(ImMessageType.CUSTOM_SHARE_TOPIC_FRIEND.getValue(), R.layout.item_chat_custom_share_topic_other).addItemType(ImMessageType.CUSTOM_SHARE_COMMODITY.getValue(), R.layout.item_chat_custom_share_commodity_mine).addItemType(ImMessageType.CUSTOM_SHARE_COMMODITY_FRIEND.getValue(), R.layout.item_chat_custom_share_commodity_other).addItemType(ImMessageType.CUSTOM_SHARE_ORDER.getValue(), R.layout.item_chat_custom_share_order_mine).addItemType(ImMessageType.CUSTOM_SHARE_ORDER_FRIEND.getValue(), R.layout.item_chat_custom_share_order_other).addItemType(ImMessageType.CUSTOM_CURRENT_GOODS.getValue(), R.layout.item_chat_custom_current_goods_mine).addItemType(ImMessageType.CUSTOM_CURRENT_GOODS_FRIEND.getValue(), R.layout.item_chat_custom_current_goods_other);
    }

    @NonNull
    public BaseChatViewHolder createChatViewHolder(@NonNull View view, int i) {
        switch (b.f34391a[ImMessageType.get(i).ordinal()]) {
            case 1:
            case 2:
                return new ShareLinkViewHolder(view);
            case 3:
            case 4:
                return new ChatTextViewHolder(view);
            case 5:
            case 6:
                return new ChatImageViewHolder(view);
            case 7:
            case 8:
                return new ChatAudioViewHolder(view);
            case 9:
            case 10:
                return new ChatGiftViewHolder(view);
            case 11:
            case 12:
                return new ChatInvitationViewHolder(view);
            case 13:
            case 14:
                return new ChatEmojiStickerViewHolder(view);
            case 15:
            case 16:
                return new ChatStarAllianceViewHolder(view);
            case 17:
            case 18:
                return new ShareEmojiViewHolder(view);
            case 19:
            case 20:
                return new ShareMomentImageViewHolder(view);
            case 21:
            case 22:
                return new ShareMomentAudioViewHolder(view);
            case 23:
            case 24:
                return new ShareMomentVideoViewHolder(view);
            case 25:
                return new ChatTimeViewHolder(view);
            case 26:
            case 27:
                return new ShareWorkViewHolder(view);
            case 28:
            case 29:
                return new ShareChannelViewHolder(view);
            case 30:
            case 31:
                return new ShareTopicViewHolder(view);
            case 32:
            case 33:
                return new ShareCommodityViewHolder(view);
            case 34:
            case 35:
                return new ShareOrderViewHolder(view);
            case 36:
            case 37:
                return new CurrentGoodsViewHolder(view);
            default:
                return new ChatTextViewHolder(view);
        }
    }

    public void e(String str) {
        this.f = str;
    }

    public int getViewType(IMMessage iMMessage) {
        boolean zIsMine = isMine(iMMessage.getFromAccount());
        ImMessageType imMessageTypeO = j64.o(iMMessage, zIsMine);
        if (imMessageTypeO == ImMessageType.UNKNOWN || imMessageTypeO == ImMessageType.UNKNOWN_FRIEND) {
            return (zIsMine ? ImMessageType.TEXT : ImMessageType.TEXT_FRIEND).getValue();
        }
        return imMessageTypeO.getValue();
    }

    public boolean isMine(String str) {
        return str != null && str.equals(this.f);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseChatViewHolder baseChatViewHolder, IMMessage iMMessage) {
        try {
            baseChatViewHolder.setGone(R.id.llNickName, true);
        } catch (Exception unused) {
        }
        baseChatViewHolder.a(iMMessage);
    }

    @Override // com.chad.library.adapter.base.BaseDelegateMultiAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    @NonNull
    public BaseChatViewHolder onCreateDefViewHolder(@NonNull ViewGroup viewGroup, int i) {
        BaseMultiTypeDelegate<IMMessage> multiTypeDelegate = getMultiTypeDelegate();
        if (multiTypeDelegate == null) {
            throw new IllegalArgumentException("Please use setMultiTypeDelegate first!");
        }
        return createChatViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(multiTypeDelegate.getLayoutId(i), viewGroup, false), i);
    }
}
