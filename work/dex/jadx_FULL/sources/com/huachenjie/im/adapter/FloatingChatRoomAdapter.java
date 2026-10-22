package com.huachenjie.im.adapter;

import android.graphics.Color;
import android.view.View;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.chad.library.adapter.base.BaseDelegateMultiAdapter;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.im.R;
import com.huachenjie.im.audio.ImAudioPlayCallback;
import com.huachenjie.im.constants.ImMessageType;
import com.netease.nimlib.sdk.chatroom.model.ChatRoomMessage;
import com.netease.nimlib.sdk.msg.attachment.AudioAttachment;
import com.netease.nimlib.sdk.msg.constant.MsgTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.cr2;
import com.zj.adlib.dj1;
import com.zj.adlib.f64;
import com.zj.adlib.j64;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class FloatingChatRoomAdapter extends BaseDelegateMultiAdapter<ChatRoomMessage, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f34394a;

    public class a extends BaseMultiTypeDelegate<ChatRoomMessage> {
        public a() {
        }

        @Override // com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate
        public int getItemType(@NonNull List<? extends ChatRoomMessage> list, int i) {
            return FloatingChatRoomAdapter.this.getViewType(list.get(i));
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ChatRoomMessage f9632a;

        public class a implements ImAudioPlayCallback {
            public a() {
            }

            @Override // com.huachenjie.im.audio.ImAudioPlayCallback
            public void a(String str) {
                FloatingChatRoomAdapter.this.notifyItemChanged(FloatingChatRoomAdapter.this.i(str));
            }

            @Override // com.huachenjie.im.audio.ImAudioPlayCallback
            public void b(String str) {
                FloatingChatRoomAdapter.this.notifyItemChanged(FloatingChatRoomAdapter.this.i(str));
            }
        }

        public b(ChatRoomMessage chatRoomMessage) {
            this.f9632a = chatRoomMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AudioAttachment attachment = this.f9632a.getAttachment();
            if (attachment == null || !(attachment instanceof AudioAttachment)) {
                return;
            }
            f64.b().i(FloatingChatRoomAdapter.this.getContext(), attachment.getUrl(), this.f9632a.getUuid(), new a());
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34398a;

        static {
            int[] iArr = new int[MsgTypeEnum.values().length];
            f34398a = iArr;
            try {
                iArr[MsgTypeEnum.audio.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34398a[MsgTypeEnum.text.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34398a[MsgTypeEnum.video.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34398a[MsgTypeEnum.location.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34398a[MsgTypeEnum.undef.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34398a[MsgTypeEnum.file.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34398a[MsgTypeEnum.avchat.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f34398a[MsgTypeEnum.notification.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f34398a[MsgTypeEnum.tip.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f34398a[MsgTypeEnum.robot.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f34398a[MsgTypeEnum.nrtc_netcall.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f34398a[MsgTypeEnum.appCustom.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f34398a[MsgTypeEnum.qiyuCustom.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public FloatingChatRoomAdapter() {
        setMultiTypeDelegate(new a());
        getMultiTypeDelegate().addItemType(ImMessageType.TEXT.getValue(), R.layout.item_chat_room_text).addItemType(ImMessageType.AUDIO.getValue(), R.layout.item_chat_room_audio);
    }

    public final void g(BaseViewHolder baseViewHolder, ChatRoomMessage chatRoomMessage) {
        AudioAttachment attachment = chatRoomMessage.getAttachment();
        if (attachment == null || !(attachment instanceof AudioAttachment)) {
            baseViewHolder.setText(R.id.tvAudio, "0S");
        } else {
            baseViewHolder.setText(R.id.tvAudio, String.format("%dS", Long.valueOf(attachment.getDuration() / 1000)));
        }
        if (f64.b().c().equals(chatRoomMessage.getUuid())) {
            baseViewHolder.setGone(R.id.ivAudio, true);
            int i = R.id.jsonAudio;
            baseViewHolder.setGone(i, false);
            final LottieAnimationView lottieAnimationView = (LottieAnimationView) baseViewHolder.getView(i);
            lottieAnimationView.post(new Runnable() { // from class: com.zj.adlib.dj3
                @Override // java.lang.Runnable
                public final void run() {
                    lottieAnimationView.playAnimation();
                }
            });
        } else {
            baseViewHolder.setGone(R.id.ivAudio, false);
            int i2 = R.id.jsonAudio;
            baseViewHolder.setGone(i2, true);
            final LottieAnimationView lottieAnimationView2 = (LottieAnimationView) baseViewHolder.getView(i2);
            lottieAnimationView2.post(new Runnable() { // from class: com.zj.adlib.ej3
                @Override // java.lang.Runnable
                public final void run() {
                    lottieAnimationView2.cancelAnimation();
                }
            });
        }
        try {
            baseViewHolder.getView(R.id.fl_audio_container).setOnClickListener(new b(chatRoomMessage));
        } catch (Exception unused) {
        }
    }

    public int getViewType(ChatRoomMessage chatRoomMessage) {
        return c.f34398a[chatRoomMessage.getMsgType().ordinal()] != 1 ? ImMessageType.TEXT.getValue() : ImMessageType.AUDIO.getValue();
    }

    public final void h(BaseViewHolder baseViewHolder, ChatRoomMessage chatRoomMessage) {
        baseViewHolder.setText(R.id.tv_content, j64.b(chatRoomMessage.getMsgType(), chatRoomMessage.getContent(), chatRoomMessage.getAttachment(), Boolean.TRUE));
    }

    public int i(String str) {
        for (int i = 0; i < getData().size(); i++) {
            IMMessage iMMessage = getData().get(i);
            if (iMMessage != null && (iMMessage instanceof IMMessage) && str.equals(iMMessage.getUuid())) {
                return i;
            }
        }
        return 0;
    }

    public void l(boolean z) {
        this.f34394a = z;
        notifyItemChanged(0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseViewHolder baseViewHolder, ChatRoomMessage chatRoomMessage) {
        if (this.f34394a) {
            try {
                int itemPosition = getItemPosition(chatRoomMessage);
                View view = baseViewHolder.getView(R.id.chatRoomItem);
                if (itemPosition == 0) {
                    view.setPadding(cr2.c(view.getContext(), 12.0f), cr2.c(view.getContext(), 20.0f), chatRoomMessage.getMsgType() == MsgTypeEnum.audio ? cr2.c(view.getContext(), 10.0f) : cr2.c(view.getContext(), 20.0f), cr2.c(view.getContext(), 6.0f));
                } else {
                    view.setPadding(cr2.c(view.getContext(), 12.0f), cr2.c(view.getContext(), 6.0f), chatRoomMessage.getMsgType() == MsgTypeEnum.audio ? cr2.c(view.getContext(), 10.0f) : cr2.c(view.getContext(), 20.0f), cr2.c(view.getContext(), 6.0f));
                }
            } catch (Exception unused) {
            }
        }
        int i = R.id.tvName;
        baseViewHolder.setText(i, dj1.w(chatRoomMessage));
        int iX = dj1.x(chatRoomMessage);
        if (iX == 1 || iX == 2) {
            baseViewHolder.setTextColor(i, Color.parseColor("#FFFF9C9C"));
            baseViewHolder.setTextColor(R.id.tvNameTip, Color.parseColor("#FFFF9C9C"));
        } else {
            baseViewHolder.setTextColor(i, Color.parseColor("#FF09FFFD"));
            baseViewHolder.setTextColor(R.id.tvNameTip, Color.parseColor("#FF09FFFD"));
        }
        if (chatRoomMessage.getMsgType() == MsgTypeEnum.audio) {
            g(baseViewHolder, chatRoomMessage);
        } else {
            h(baseViewHolder, chatRoomMessage);
        }
    }
}
