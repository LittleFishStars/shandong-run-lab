package com.byazt.hp;

import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.byazt.cd.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1019, 15})
public class uj extends c {
    public static final float m;
    public static final float nu;
    public static final float yp;
    public static final float z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.cd.c.C0376c f28622a;
    public int da;
    public float i;
    public Path n;
    public float rh;
    public int sl;
    public int sp;
    public boolean t;
    public Path u;
    public Paint uj;
    public int ve;
    public int x;

    static {
        float radians = (float) Math.toRadians(30.0d);
        yp = radians;
        z = (float) Math.tan(radians);
        m = (float) Math.cos(radians);
        nu = (float) Math.sin(radians);
    }

    public uj(com.byazt.xj.ve veVar, JSONObject jSONObject) {
        super(veVar, jSONObject);
        this.t = true;
        Paint paint = new Paint();
        this.uj = paint;
        paint.setAntiAlias(true);
        this.n = new Path();
        this.i = this.tt.rl();
        this.u = new Path();
    }

    private void ve(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.tt.lr() > 0.0f) {
                int i = this.da;
                float f = z;
                float fLr = (i + (i * f)) * this.tt.lr();
                this.u.reset();
                this.u.moveTo(fLr, 0.0f);
                int i2 = this.sl;
                float f2 = fLr - (i2 * f);
                this.u.lineTo(f2, i2);
                this.u.lineTo(f2 + this.ve, this.sl);
                this.u.lineTo(this.ve + fLr, 0.0f);
                this.u.close();
                float f3 = this.rh;
                float f4 = m * f3;
                float f5 = f3 * nu;
                if (!this.t || this.f28622a == null) {
                    float f6 = fLr + f4;
                    int i3 = this.x;
                    linearGradient = new LinearGradient(fLr, 0.0f, f6, f5, new int[]{i3, this.sp, i3}, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    linearGradient = new LinearGradient(fLr, 0.0f, fLr + f4, f5, this.f28622a.tt, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.uj.setShader(linearGradient);
                Path path = this.n;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.u, this.uj);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.hp.c
    @SuppressLint({"DrawAllocation"})
    public void c(Canvas canvas) {
        ve(canvas);
    }

    @Override // com.byazt.hp.c
    public void tt() {
        this.ve = (int) x.c(this.tt.i().getContext(), this.c.optInt("shineWidth", 30));
        String strOptString = this.c.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(strOptString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : strOptString;
        if (str.startsWith("linear")) {
            this.f28622a = com.byazt.cd.c.tt(str);
        } else {
            int iC = com.byazt.cd.c.c(str);
            this.sp = iC;
            this.x = com.byazt.cd.c.c(iC, 32);
            this.t = false;
        }
        this.rh = m * this.ve;
    }

    @Override // com.byazt.hp.c
    public void c(int i, int i2) {
        this.da = i;
        this.sl = i2;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Path path = this.n;
            float f = this.i;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.hp.c
    public void tt(Canvas canvas) {
        ve(canvas);
    }

    @Override // com.byazt.hp.c
    public List<PropertyValuesHolder> ve() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(uj(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
