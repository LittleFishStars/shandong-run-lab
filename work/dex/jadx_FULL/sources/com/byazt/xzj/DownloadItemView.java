package com.byazt.xzj;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.zb;
import com.byazt.ff.TTRatingBar;
import com.byazt.ff.TTRoundRectImageView;
import com.byazt.nr.z;
import com.byazt.vfu.a;
import com.byazt.xky.tt;
import com.byazt.zqa.c;
import com.king.zxing.camera.CameraManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, CameraManager.i, 1374})
public class DownloadItemView extends FrameLayout {
    public DownloadItemView(Context context) {
        super(context);
    }

    public void c(ic icVar) {
        String strTj;
        String strValueOf;
        if (icVar == null) {
            return;
        }
        Context context = getContext();
        addView(a.cu(context));
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) findViewById(2114387793);
        TextView textView = (TextView) findViewById(2114387875);
        TextView textView2 = (TextView) findViewById(2114387637);
        TextView textView3 = (TextView) findViewById(2114387830);
        TextView textView4 = (TextView) findViewById(2114387630);
        TTRatingBar tTRatingBar = (TTRatingBar) findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(pf.ve(context, 12.0f));
            tTRatingBar.setStarImageHeight(pf.ve(context, 12.0f));
            tTRatingBar.setStarImagePadding(pf.ve(context, 4.0f));
            tTRatingBar.c();
        }
        if (textView4 != null) {
            int iA = icVar.z() != null ? icVar.z().a() : 6870;
            if (iA > 10000) {
                strValueOf = (iA / 10000) + "万";
            } else {
                strValueOf = String.valueOf(iA);
            }
            textView4.setText(String.format("%1$s个评分", strValueOf));
        }
        if (tTRoundRectImageView != null) {
            zb zbVarTe = icVar.te();
            if (zbVarTe == null || TextUtils.isEmpty(zbVarTe.c())) {
                z.c(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView, 320);
            } else {
                tt.c(zbVarTe).to(tTRoundRectImageView);
            }
        }
        if (textView != null) {
            textView.setText(nb.gt(icVar));
        }
        if (textView2 != null) {
            textView2.setText(nb.rl(icVar));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(icVar.tj())) {
                strTj = icVar.i() != 4 ? "查看详情" : "立即下载";
            } else {
                strTj = icVar.tj();
            }
            textView3.setText(strTj);
        }
    }
}
