package com.byazt.zk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.byazt.ga.rl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 215})
public class yp extends sp {
    public int da;
    public int i;
    public Path x;

    public yp(com.byazt.ga.x xVar, x xVar2, Context context) {
        super(xVar, xVar2);
        this.x = null;
        this.i = -1;
        this.da = -1;
        if (((sp) this).sp != null) {
            float fC = com.byazt.kk.da.c();
            this.i = (int) (((sp) this).sp.c() * fC);
            this.da = (int) (((sp) this).sp.tt() * fC);
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, this.i, this.da);
            Path path = new Path();
            this.x = path;
            float f = fC * 40.0f;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    private static void c(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.byazt.zk.sp, com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        rl rlVarC = this.tt.c();
        View viewC = rlVarC != null ? rlVarC.c("videoview:", null) : null;
        if (this.i <= 0 || viewC == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        c(i);
        float fX = x();
        c(viewC, this.i, this.da);
        viewC.setAlpha(fX);
        canvas.clipPath(this.x);
        viewC.draw(canvas);
        canvas.restore();
    }
}
