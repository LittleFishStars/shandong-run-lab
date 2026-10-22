package com.huachenjie.im.viewHolder;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.ShareTopicAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareTopicViewHolder extends BaseChatViewHolder {
    public ShareTopicViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        ShareTopicAttachment shareTopicAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof ShareTopicAttachment)) ? new ShareTopicAttachment() : (ShareTopicAttachment) iMMessage.getAttachment();
        try {
            ImageView imageView = (ImageView) getView(R.id.topicImage);
            RequestBuilder requestBuilderDiskCacheStrategy = Glide.with(imageView).load(shareTopicAttachment.getSubjectImg()).diskCacheStrategy(DiskCacheStrategy.ALL);
            int i = R.drawable.bg_topic_image_empty;
            requestBuilderDiskCacheStrategy.placeholder(i).error(i).into(imageView);
            setText(R.id.tvTopicName, "#" + shareTopicAttachment.getSubjectName());
            setText(R.id.tvHot, shareTopicAttachment.getPopularityValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
