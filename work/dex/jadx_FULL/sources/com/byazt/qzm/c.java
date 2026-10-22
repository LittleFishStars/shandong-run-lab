package com.byazt.qzm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.byazt.ete.ic;
import com.byazt.ff.TTProgressBar;
import com.byazt.nr.z;
import com.byazt.un.a;
import com.byazt.un.n;
import com.byazt.un.uj;
import com.byazt.wol.LayoutVideoDetail;
import java.util.EnumSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 694, 20})
public class c extends uj {
    public c(Context context, ViewGroup viewGroup, ic icVar, String str, boolean z, boolean z2, boolean z3) {
        super(context, viewGroup, icVar, str, z, z2, z3);
    }

    @Override // com.byazt.un.uj
    public a c(Context context, EnumSet<com.byazt.dh.tt.c> enumSet) {
        View viewC = this.t ? c(context) : new LayoutVideoDetail(context);
        if (viewC == null) {
            return null;
        }
        return this.t ? new a(context, viewC, true, enumSet, this.f28832a, this, or(), null) : new n(context, viewC, true, enumSet, this.f28832a, this, false);
    }

    private View c(final Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387631);
        layoutParams2.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams2);
        z.c(context, "tt_normalscreen_loading", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.qzm.c.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(com.byazt.vfu.n.c(context, new BitmapDrawable(context.getResources(), bitmap), 0, 360, 0.5f, 0.5f));
            }
        }, 320);
        relativeLayout2.addView(tTProgressBar);
        return relativeLayout;
    }
}
