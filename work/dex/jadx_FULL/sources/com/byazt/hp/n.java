package com.byazt.hp;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import androidx.camera.video.AudioStats;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1019, 46})
public class n extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28620a;
    public Path da;
    public boolean i;
    public Paint n;
    public Path sl;
    public String sp;
    public Path t;
    public PorterDuffXfermode u;
    public float uj;
    public float ve;
    public boolean x;

    public n(com.byazt.xj.ve veVar, JSONObject jSONObject) {
        super(veVar, jSONObject);
        this.x = true;
        this.i = true;
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.tt.i().setLayerType(2, null);
        this.u = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.da = new Path();
        this.sl = new Path();
        this.t = new Path();
        this.n.setXfermode(this.u);
    }

    private void ve(Canvas canvas) {
        if (this.tt.l() <= 0.0f) {
            this.n.setXfermode(this.u);
            canvas.drawRect(0.0f, 0.0f, this.ve, this.uj, this.n);
            return;
        }
        int iL = (int) (this.ve * this.tt.l());
        int iL2 = (int) (this.uj * this.tt.l());
        this.n.setXfermode(this.u);
        String str = this.sp;
        str.hashCode();
        switch (str) {
            case "bottom":
                canvas.drawRect(0.0f, iL2, this.ve, this.uj, this.n);
                break;
            case "center":
                this.da.reset();
                this.sl.reset();
                this.t.reset();
                this.da.addCircle(this.ve / 2.0f, this.uj / 2.0f, iL, Path.Direction.CW);
                Path path = this.sl;
                float f = this.ve;
                path.addRect(f / 2.0f, 0.0f, f, this.uj, Path.Direction.CW);
                this.sl.op(this.da, Path.Op.DIFFERENCE);
                this.t.addRect(0.0f, 0.0f, this.ve / 2.0f, this.uj, Path.Direction.CW);
                this.t.op(this.da, Path.Op.DIFFERENCE);
                canvas.drawPath(this.sl, this.n);
                canvas.drawPath(this.t, this.n);
                break;
            case "top":
                canvas.drawRect(0.0f, 0.0f, this.ve, this.uj - iL2, this.n);
                break;
            case "left":
                canvas.drawRect(0.0f, 0.0f, this.ve - iL, this.uj, this.n);
                break;
            case "right":
                canvas.drawRect(iL, 0.0f, this.ve, this.uj, this.n);
                break;
        }
    }

    @Override // com.byazt.hp.c
    public void c(Canvas canvas) {
        ve(canvas);
    }

    @Override // com.byazt.hp.c
    public void tt() {
        this.f28620a = (float) this.c.optDouble("start", AudioStats.AUDIO_AMPLITUDE_NONE);
        this.sp = this.c.optString(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "center");
    }

    @Override // com.byazt.hp.c
    public void c(int i, int i2) {
        if (i > 0 && this.x) {
            this.ve = i;
            this.x = false;
        }
        if (i2 <= 0 || !this.i) {
            return;
        }
        this.uj = i2;
        this.i = false;
    }

    @Override // com.byazt.hp.c
    public void tt(Canvas canvas) {
        ve(canvas);
    }

    @Override // com.byazt.hp.c
    public List<PropertyValuesHolder> ve() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(uj(), this.f28620a, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
