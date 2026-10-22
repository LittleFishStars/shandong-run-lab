package com.huachenjie.im.viewHolder;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.alibaba.android.arouter.utils.Consts;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.im.R;
import com.huachenjie.im.custom.ShareOrderAttachment;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.b49;
import com.zj.adlib.c49;
import com.zj.adlib.ju3;
import com.zj.adlib.qv1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ShareOrderViewHolder extends BaseChatViewHolder {
    public ShareOrderViewHolder(@NonNull View view) {
        super(view);
    }

    @Override // com.huachenjie.im.viewHolder.BaseChatViewHolder
    public void c(IMMessage iMMessage) {
        ShareOrderAttachment shareOrderAttachment = (iMMessage.getAttachment() == null || !(iMMessage.getAttachment() instanceof ShareOrderAttachment)) ? new ShareOrderAttachment() : (ShareOrderAttachment) iMMessage.getAttachment();
        try {
            ImageView imageView = (ImageView) getView(R.id.share_order_image);
            Glide.with(imageView).load(shareOrderAttachment.getGoodsImage()).diskCacheStrategy(DiskCacheStrategy.ALL).apply((BaseRequestOptions<?>) ju3.m).into(imageView);
            setText(R.id.tv_order_goods_name, shareOrderAttachment.getGoodsName());
            setText(R.id.tv_order_goods_spec, shareOrderAttachment.getGoodsSpec());
            setText(R.id.tv_order_goods_num, "x" + shareOrderAttachment.getGoodsCount());
            setText(R.id.tv_order_goods_price, f(shareOrderAttachment.getPayAmount()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final CharSequence f(String str) {
        c49 c49VarF = c49.f();
        c49VarF.g(new b49().o("¥").q(qv1.W(12.0f)).r(1).p(Color.parseColor("#FF2C3E50")));
        if (str.contains(Consts.DOT)) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length > 1) {
                c49VarF.g(new b49().o(strArrSplit[0]).q(qv1.W(18.0f)).p(Color.parseColor("#FF2C3E50")).r(1)).g(new b49().o(Consts.DOT + strArrSplit[1]).q(qv1.W(12.0f)).p(Color.parseColor("#FF2C3E50")).r(1));
            } else {
                c49VarF.g(new b49().o(str).q(qv1.W(18.0f)).r(1).p(Color.parseColor("#FF2C3E50")));
            }
        } else {
            c49VarF.g(new b49().o(str).q(qv1.W(18.0f)).r(1).p(Color.parseColor("#FF2C3E50")));
        }
        return c49VarF.e();
    }
}
