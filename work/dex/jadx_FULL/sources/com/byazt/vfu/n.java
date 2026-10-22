package com.byazt.vfu;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import com.byazt.aas.pf;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC, 46})
public class n {
    public static LayerDrawable c() {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setColor(Color.parseColor("#AAAAAA"));
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RectShape());
        shapeDrawable2.getPaint().setColor(Color.parseColor("#09BB07"));
        shapeDrawable2.getPaint().setStyle(Paint.Style.FILL);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, new ClipDrawable(shapeDrawable2, 3, 1)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.progress);
        return layerDrawable;
    }

    public static GradientDrawable tt() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FFFBFA"), Color.parseColor("#FFEBE6")});
        return gradientDrawable;
    }

    public static GradientDrawable tt(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(pf.ve(context, 7.0f));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(new int[]{Color.parseColor("#C48959"), Color.parseColor("#92512D")});
        return gradientDrawable;
    }

    public static RotateDrawable c(Context context, Drawable drawable, int i, int i2, float f, float f2) {
        RotateDrawable rotateDrawable = new RotateDrawable();
        rotateDrawable.setDrawable(drawable);
        rotateDrawable.setFromDegrees(i);
        rotateDrawable.setToDegrees(i2);
        rotateDrawable.setPivotX(f);
        rotateDrawable.setPivotY(f2);
        rotateDrawable.setLevel(0);
        return rotateDrawable;
    }

    public static StateListDrawable c(Context context, Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable);
        stateListDrawable.addState(new int[0], drawable2);
        return stateListDrawable;
    }

    public static LayerDrawable c(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setShape(0);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FC1D56"), Color.parseColor("#FC881D")});
        gradientDrawable.setCornerRadius(pf.ve(context, 100.0f));
        gradientDrawable.setStroke(pf.ve(context, 1.0f), Color.parseColor("#FFD47F"));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable});
        int iVe = pf.ve(context, 2.0f);
        layerDrawable.setLayerInset(0, iVe, 0, iVe, 0);
        int iVe2 = pf.ve(context, 60.0f);
        layerDrawable.setLayerHeight(0, pf.ve(context, 20.0f));
        layerDrawable.setLayerWidth(0, iVe2);
        return layerDrawable;
    }
}
