package com.byazt.hg;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.ete.ic;
import com.byazt.ui.UpieImageView;
import com.byazt.xj.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1236, 20})
public class c extends ve<UpieImageView> {
    public ImageView.ScaleType c;
    public boolean yo;

    public c(Context context) {
        super(context);
        this.c = ImageView.ScaleType.FIT_XY;
    }

    private ImageView.ScaleType sl(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public UpieImageView c() {
        return new UpieImageView(this.tt, null, null, null);
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        ic icVarC = com.byazt.omf.c.c(this.uj);
        if (icVarC != null) {
            ((UpieImageView) this.n).c(com.byazt.ic.c.c(icVarC, this.uj), com.byazt.nj.c.c(icVarC), com.byazt.ic.c.da(icVarC));
            ((UpieImageView) this.n).setScaleType(this.c);
        }
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.c = sl(str2);
                break;
            case "isBgGaussianBlur":
                this.yo = com.byazt.cd.ve.c(str2, false);
                break;
        }
    }
}
