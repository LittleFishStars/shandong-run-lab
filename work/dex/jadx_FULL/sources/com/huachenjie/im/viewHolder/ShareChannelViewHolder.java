package com.huachenjie.im.viewHolder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.ShareChannelAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.i4a;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareChannelViewHolder extends BaseChatViewHolder {
    public ShareChannelViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        i4a.c("1");
        ShareChannelAttachment shareChannelAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof ShareChannelAttachment)) ? new ShareChannelAttachment() : (ShareChannelAttachment) iMMessage.getAttachment();
        try {
            i4a.c("2");
            ImageView imageView = (ImageView) getView(R.id.channelImage);
            RequestBuilder requestBuilderDiskCacheStrategy = Glide.with(imageView).load(shareChannelAttachment.getCoverUrl()).diskCacheStrategy(DiskCacheStrategy.ALL);
            int i = R.drawable.bg_channel_image_empty;
            requestBuilderDiskCacheStrategy.placeholder(i).error(i).into(imageView);
            f(R.id.ivAvatar_1, 0, shareChannelAttachment.getAvatarList());
            f(R.id.ivAvatar_2, 1, shareChannelAttachment.getAvatarList());
            f(R.id.ivAvatar_3, 2, shareChannelAttachment.getAvatarList());
            setText(R.id.tvChannelName, "@" + shareChannelAttachment.getChannelName());
            String popularityValue = shareChannelAttachment.getPopularityValue();
            String str = "0";
            if (TextUtils.isEmpty(popularityValue)) {
                popularityValue = "0";
            }
            setText(R.id.tvHot, popularityValue);
            String channelUserValue = shareChannelAttachment.getChannelUserValue();
            if (!TextUtils.isEmpty(channelUserValue)) {
                str = channelUserValue;
            }
            setText(R.id.tvChannelUserNum, str + " 人在这里");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void f(int i, int i2, List<String> list) {
        if (list == null || list.isEmpty()) {
            setGone(i, true);
            return;
        }
        boolean z = i2 >= list.size();
        setGone(i, z);
        if (z) {
            return;
        }
        ((AvatarView) findView(i)).loadAvatar(list.get(i2));
    }
}
