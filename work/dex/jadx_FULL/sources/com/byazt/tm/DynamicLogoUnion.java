package com.byazt.tm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.byazt.aq.x;
import com.byazt.nr.z;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_NO_APPKEY})
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        ImageView imageView = new ImageView(context);
        this.z = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        if (com.byazt.sr.uj.c()) {
            this.x = Math.max(dynamicRootView.getLogoUnionHeight(), this.x);
        }
        addView(this.z, getWidgetLayoutParams());
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        if (com.byazt.sr.uj.c()) {
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        z.c(getContext(), "tt_ad_logo", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.tm.DynamicLogoUnion.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                ((ImageView) DynamicLogoUnion.this.z).setImageDrawable(new BitmapDrawable(DynamicLogoUnion.this.getContext().getResources(), bitmap));
                DynamicLogoUnion dynamicLogoUnion = DynamicLogoUnion.this;
                ((ImageView) dynamicLogoUnion.z).setColorFilter(dynamicLogoUnion.t.sp(), PorterDuff.Mode.SRC_IN);
            }
        }, 320);
        return true;
    }
}
