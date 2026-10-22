package com.huachenjie.im.viewHolder;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.MomentMessageAttachment;
import com.huachenjie.im.custom.MomentShareAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.ju3;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareMomentAudioViewHolder extends BaseChatViewHolder {
    public ShareMomentAudioViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        MomentShareAttachment momentShareAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof MomentShareAttachment)) ? new MomentShareAttachment() : (MomentShareAttachment) iMMessage.getAttachment();
        try {
            ImageView imageView = (ImageView) getView(R.id.shareMomentBackground);
            Glide.with(imageView).load(momentShareAttachment.getVoiceBackGroundImgUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) ju3.o).into(imageView);
            List<MomentMessageAttachment.MomentMessageFileBean> fileList = momentShareAttachment.getFileList();
            if (fileList == null || fileList.isEmpty()) {
                setGone(R.id.ivAudioPlayer, true);
            } else {
                setGone(R.id.ivAudioPlayer, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
