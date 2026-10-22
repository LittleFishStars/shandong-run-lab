package com.byazt.wol;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ff.TTProgressBar;
import com.byazt.lbn.TTViewStub;
import com.byazt.nr.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 352, 2179})
public class LayoutVideoDetail extends RelativeLayout {
    public Drawable c;
    public Drawable tt;

    public LayoutVideoDetail(Context context) {
        super(context);
        c(context);
    }

    private View a(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387605);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387897);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = pf.ve(context, 12.0f);
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int color = Color.parseColor("#959595");
        com.byazt.vfu.c cVar = new com.byazt.vfu.c(48);
        cVar.c(color);
        float fVe = pf.ve(context, 2.0f);
        cVar.c(fVe);
        int color2 = Color.parseColor("#FFFFFF");
        com.byazt.vfu.c cVar2 = new com.byazt.vfu.c(48);
        cVar2.c(color2);
        cVar2.c(fVe);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, cVar);
        stateListDrawable.addState(new int[0], cVar2);
        imageView.setImageDrawable(stateListDrawable);
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387706);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        textView.setGravity(16);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        int i = com.byazt.lbn.tt.c.uj;
        textView.setPadding(i, 0, i, 0);
        relativeLayout.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387797);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(i, 0, i, 0);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387846);
        textView2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        textView2.setTextSize(2, 12.0f);
        textView2.setTextColor(-1);
        linearLayout.addView(textView2);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    private StateListDrawable da(Context context) {
        int color = Color.parseColor("#959595");
        com.byazt.vfu.c cVar = new com.byazt.vfu.c(48);
        cVar.c(color);
        float fVe = pf.ve(context, 2.0f);
        cVar.c(fVe);
        int color2 = Color.parseColor("#FFFFFF");
        com.byazt.vfu.c cVar2 = new com.byazt.vfu.c(48);
        cVar2.c(color2);
        cVar2.c(fVe);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, cVar);
        stateListDrawable.addState(new int[0], cVar2);
        return stateListDrawable;
    }

    private View i(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387759);
        textView.setBackgroundColor(0);
        textView.setMinHeight(pf.ve(context, 44.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = pf.ve(context, 12.0f);
        textView.setLayoutParams(layoutParams);
        textView.setCompoundDrawablesWithIntrinsicBounds(da(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(da(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setText("关闭");
        return textView;
    }

    private View n(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387730);
        textView.setGravity(8388659);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(false);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        textView.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        textView.setBackground(gradientDrawable);
        int i = com.byazt.lbn.tt.c.uj;
        textView.setPadding(i, com.byazt.lbn.tt.c.n, i, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        layoutParams.addRule(10);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private View sp(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        tTProgressBar.setIndeterminate(false);
        tTProgressBar.setId(2114387653);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, pf.ve(context, 1.5f));
        layoutParams.addRule(12);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setBackground(null);
        tTProgressBar.setMax(100);
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
        com.byazt.vfu.sp.c(tTProgressBar, new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar.setVisibility(8);
        return tTProgressBar;
    }

    private View uj(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387678);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(pf.ve(context, 4.0f));
        imageView.setBackground(gradientDrawable);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int color = Color.parseColor("#959595");
        com.byazt.vfu.c cVar = new com.byazt.vfu.c(48);
        cVar.c(color);
        float fVe = pf.ve(context, 2.0f);
        cVar.c(fVe);
        int color2 = Color.parseColor("#FFFFFF");
        com.byazt.vfu.c cVar2 = new com.byazt.vfu.c(48);
        cVar2.c(color2);
        cVar2.c(fVe);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, cVar);
        stateListDrawable.addState(new int[0], cVar2);
        imageView.setImageDrawable(stateListDrawable);
        int iVe = pf.ve(context, 30.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iVe, iVe);
        layoutParams.addRule(21);
        layoutParams.addRule(11);
        int iVe2 = pf.ve(context, 7.0f);
        layoutParams.setMargins(0, iVe2, iVe2, 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private View ve(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387626);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        z.c(context, "tt_new_play_video", imageView, 320);
        imageView.setVisibility(8);
        return imageView;
    }

    private View x(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387628);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, pf.ve(context, 40.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387811);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(pf.ve(context, 16.0f), 0, pf.ve(context, 12.0f), 0);
        textView.setLayoutParams(layoutParams2);
        textView.setText("00:00");
        textView.setTextColor(-1);
        textView.setTextSize(2, 10.0f);
        linearLayout.addView(textView);
        SeekBar seekBar = new SeekBar(context);
        seekBar.setId(2114387872);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams3.gravity = 16;
        seekBar.setLayoutParams(layoutParams3);
        seekBar.setBackground(null);
        seekBar.setMax(100);
        if (Build.VERSION.SDK_INT >= 29) {
            seekBar.setMaxHeight(pf.ve(context, 4.0f));
            seekBar.setMinHeight(pf.ve(context, 4.0f));
        } else {
            layoutParams3.height = pf.ve(context, 4.0f);
        }
        seekBar.setPadding(0, 0, 0, 0);
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
        seekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int iVe2 = pf.ve(context, 15.0f);
        shapeDrawable.setIntrinsicWidth(iVe2);
        shapeDrawable.setIntrinsicHeight(iVe2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(pf.ve(context, 1.0f));
        paint.setColor(Color.parseColor("#1E000000"));
        seekBar.setThumb(shapeDrawable);
        seekBar.setThumbOffset(0);
        linearLayout.addView(seekBar);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387668);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(pf.ve(context, 12.0f), 0, pf.ve(context, 16.0f), 0);
        textView2.setLayoutParams(layoutParams4);
        textView2.setText("00:00");
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 10.0f);
        linearLayout.addView(textView2);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387661);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams5.setMargins(pf.ve(context, 16.0f), 0, pf.ve(context, 16.0f), 0);
        imageView.setLayoutParams(layoutParams5);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setVisibility(8);
        z.c(context, "tt_enlarge_video", imageView, 320);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    private View tt(final Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387900);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387651);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387631);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(pf.ve(context, 60.0f), pf.ve(context, 60.0f));
        layoutParams.addRule(13);
        tTProgressBar.setLayoutParams(layoutParams);
        z.c(context, "tt_normalscreen_loading", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.wol.LayoutVideoDetail.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(com.byazt.vfu.n.c(context, new BitmapDrawable(context.getResources(), bitmap), 0, 360, 0.5f, 0.5f));
            }
        }, 320);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387823);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setVisibility(8);
        final ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387618);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        z.c(context, "tt_refreshing_video_textpage_pressed", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.wol.LayoutVideoDetail.2
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                LayoutVideoDetail.this.c = new BitmapDrawable(context.getResources(), bitmap);
                LayoutVideoDetail.this.c(context, imageView2);
            }
        }, 320);
        z.c(context, "tt_refreshing_video_textpage_normal", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.wol.LayoutVideoDetail.3
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                LayoutVideoDetail.this.tt = new BitmapDrawable(context.getResources(), bitmap);
                LayoutVideoDetail.this.c(context, imageView2);
            }
        }, 320);
        TextView textView = new TextView(context);
        textView.setId(2114387860);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText("加载失败，点击重试");
        textView.setTextColor(10066329);
        linearLayout.addView(imageView2);
        linearLayout.addView(textView);
        relativeLayout.addView(imageView);
        relativeLayout.addView(tTProgressBar);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    private void c(Context context) {
        setId(2114387714);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setBackgroundColor(-1);
        addView(tt(context));
        addView(new uj().inflate(context));
        addView(ve(context));
        addView(uj(context));
        addView(n(context));
        addView(a(context));
        addView(sp(context));
        addView(x(context));
        TTViewStub tTViewStub = new TTViewStub(context, new a());
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new tt());
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub2);
        addView(i(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, ImageView imageView) {
        Drawable drawable;
        Drawable drawable2 = this.c;
        if (drawable2 == null || (drawable = this.tt) == null) {
            return;
        }
        imageView.setImageDrawable(com.byazt.vfu.n.c(context, drawable2, drawable));
    }
}
