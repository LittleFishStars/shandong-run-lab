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
public class ShareMomentImageViewHolder extends BaseChatViewHolder {
    public ShareMomentImageViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        try {
            List<MomentMessageAttachment.MomentMessageFileBean> fileList = ((iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof MomentShareAttachment)) ? new MomentShareAttachment() : (MomentShareAttachment) iMMessage.getAttachment()).getFileList();
            String linkUrl = "";
            int size = 0;
            if (fileList != null && !fileList.isEmpty()) {
                linkUrl = fileList.get(0).getLinkUrl();
                size = fileList.size();
            }
            ImageView imageView = (ImageView) getView(R.id.shareMomentImage);
            Glide.with(imageView).load(linkUrl).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) ju3.o).into(imageView);
            setText(R.id.shareMomentImageNum, String.valueOf(size));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
