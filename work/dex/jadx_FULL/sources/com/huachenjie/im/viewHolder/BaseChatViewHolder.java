package com.huachenjie.im.viewHolder;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.im.R;
import com.huachenjie.im.bean.RemoteExtBean;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.dj1;
import com.zj.adlib.j64;
import com.zj.adlib.ug9;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class BaseChatViewHolder extends BaseViewHolder {
    public BaseChatViewHolder(@NonNull View view) {
        super(view);
    }

    public void a(IMMessage iMMessage) {
        RemoteExtBean remoteExtBeanE = e(iMMessage);
        AvatarView avatarView = (AvatarView) getView(R.id.ivAvatar);
        if (avatarView != null) {
            avatarView.loadAvatar(remoteExtBeanE.getAvatar());
            avatarView.loadAvatarFrame(remoteExtBeanE.getAvatarFrameImgUrl());
        }
        b(iMMessage);
        c(iMMessage);
    }

    public void b(IMMessage iMMessage) {
        View view = getView(R.id.llNickName);
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (16 == iMMessage.getFromClientType()) {
            setText(R.id.tvName, "管理员");
            setGone(R.id.ivAttributeImage, true);
            return;
        }
        int iX = dj1.x(iMMessage);
        if (iX == 1 || iX == 2) {
            setText(R.id.tvName, dj1.w(iMMessage));
            setGone(R.id.ivAttributeImage, true);
            return;
        }
        int i = R.id.ivAttributeImage;
        setGone(i, false);
        ImageView imageView = (ImageView) getView(i);
        if (imageView != null) {
            int iY = dj1.y(iMMessage);
            if (iY > 0) {
                imageView.setVisibility(0);
                Resources resources = imageView.getResources();
                ug9 ug9Var = ug9.f45145a;
                int color = resources.getColor(ug9.c(Integer.valueOf(iY)));
                imageView.setImageResource(ug9.d(Integer.valueOf(iY)));
                imageView.setColorFilter(color);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
        }
        setText(R.id.tvName, d(iMMessage));
    }

    public void c(IMMessage iMMessage) {
    }

    public String d(IMMessage iMMessage) {
        Map remoteExtension = iMMessage.getRemoteExtension();
        if (remoteExtension == null) {
            return iMMessage.getFromNick();
        }
        String strP = j64.p(remoteExtension.get(UserConstants.USER_PARAMS.b));
        if (TextUtils.isEmpty(strP)) {
            return "";
        }
        String strP2 = j64.p(remoteExtension.get("attitudeName"));
        int iJ = j64.j(remoteExtension.get("section"));
        int iJ2 = j64.j(remoteExtension.get("starLevel"));
        ug9 ug9Var = ug9.f45145a;
        String strA = ug9Var.a(strP2, iJ, iJ2);
        if (TextUtils.isEmpty(strA) && TextUtils.isEmpty(strP)) {
            return iMMessage.getFromNick();
        }
        return TextUtils.isEmpty(strA) ? strP : String.format("%s %s", strP, ug9Var.a(strP2, iJ, iJ2));
    }

    public final RemoteExtBean e(IMMessage iMMessage) {
        return RemoteExtBean.getInstance(iMMessage.getRemoteExtension());
    }
}
