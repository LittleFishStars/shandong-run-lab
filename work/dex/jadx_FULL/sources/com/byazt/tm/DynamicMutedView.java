package com.byazt.tm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.byazt.aq.x;
import com.byazt.nr.z;
import com.byazt.or.i;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION})
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.byazt.kn.tt {
    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        ImageView imageView = new ImageView(context);
        this.z = imageView;
        imageView.setTag(5);
        addView(this.z, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().p()) {
            return;
        }
        this.z.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.byazt.kn.tt
    public void setSoundMute(boolean z) {
        z.c(getContext(), z ? "tt_mute" : "tt_unmute", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.tm.DynamicMutedView.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                ((ImageView) DynamicMutedView.this.z).setImageDrawable(new BitmapDrawable(DynamicMutedView.this.getContext().getResources(), bitmap));
                if (((ImageView) DynamicMutedView.this.z).getDrawable() != null) {
                    ((ImageView) DynamicMutedView.this.z).getDrawable().setAutoMirrored(true);
                }
            }
        }, 320);
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public boolean uj() {
        return true;
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        if (com.byazt.sr.uj.c()) {
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.yp.tt);
        if (com.byazt.sr.uj.c()) {
            Drawable drawableC = com.byazt.or.uj.c(getContext(), this.t);
            if (drawableC != null) {
                ((ImageView) this.z).setBackground(drawableC);
            }
        } else {
            ((ImageView) this.z).setBackgroundDrawable(i.c(0, Integer.valueOf(this.t.md()), new int[]{this.x / 2}, null, null, null));
        }
        return true;
    }
}
