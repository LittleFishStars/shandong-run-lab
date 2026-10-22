package com.byazt.wol;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.aas.pf;
import com.byazt.ff.TTProgressBar;
import com.byazt.lbn.TTViewStub;
import com.byazt.nr.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 352, 2066})
public class LayoutVideoPlayLayoutForLive extends RelativeLayout {
    public LayoutVideoPlayLayoutForLive(Context context) {
        super(context);
        c(context);
    }

    private void c(final Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387651);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387631);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(pf.ve(context, 60.0f), pf.ve(context, 60.0f));
        layoutParams.addRule(13);
        tTProgressBar.setLayoutParams(layoutParams);
        z.c(context, "tt_normalscreen_loading", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.wol.LayoutVideoPlayLayoutForLive.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(com.byazt.vfu.n.c(context, new BitmapDrawable(context.getResources(), bitmap), 0, 360, 0.5f, 0.5f));
            }
        }, 320);
        relativeLayout2.addView(imageView);
        relativeLayout2.addView(tTProgressBar);
        relativeLayout.addView(relativeLayout2);
        View viewInflate = new ve().inflate(context);
        viewInflate.setId(2114387888);
        relativeLayout.addView(viewInflate);
        View viewInflate2 = new uj().inflate(context);
        viewInflate2.setId(2114387688);
        relativeLayout.addView(viewInflate2);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387626);
        imageView2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        z.c(context, "tt_new_play_video", imageView2, 320);
        imageView2.setVisibility(8);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        tTProgressBar2.setIndeterminate(false);
        tTProgressBar2.setId(2114387653);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, pf.ve(context, 1.5f));
        layoutParams2.addRule(12);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        tTProgressBar2.setMax(100);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float fVe = pf.ve(context, 1.0f);
        gradientDrawable.setCornerRadius(fVe);
        int iVe = pf.ve(context, 2.0f);
        gradientDrawable.setSize(-1, iVe);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(fVe);
        gradientDrawable2.setSize(-1, iVe);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(fVe);
        gradientDrawable3.setSize(-1, iVe);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        relativeLayout.addView(tTProgressBar2, layoutParams2);
        View tTViewStub = new TTViewStub(context, new a());
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(tTViewStub);
        View tTViewStub2 = new TTViewStub(context, new tt());
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(tTViewStub2);
        View tTViewStub3 = new TTViewStub(context, new sp());
        tTViewStub3.setId(2114387828);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        tTViewStub3.setLayoutParams(layoutParams3);
        relativeLayout.addView(tTViewStub3);
        addView(relativeLayout);
    }
}
