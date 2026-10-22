package com.byazt.zk;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.ga.gt;
import com.byazt.nr.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 34})
public class a extends sp {
    public final List<String> da;
    public final LinearLayout.LayoutParams i;
    public int m;
    public com.byazt.ga.i.tt my;
    public int nu;
    public Camera rh;
    public final List<TextView> sl;
    public String t;
    public c u;
    public LinearLayout x;
    public SpannableStringBuilder yp;
    public SpannableStringBuilder z;

    @com.byazt.zqa.c(c = {0, 1, 909, 464})
    public static class c implements LineBackgroundSpan {
        public final Paint c = new Paint();
        public float n;
        public int tt;
        public int uj;
        public float ve;

        @Override // android.text.style.LineBackgroundSpan
        public void drawBackground(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, int i8) {
            if (this.ve > 0.0f) {
                this.c.setColor(this.tt);
                this.c.setStrokeWidth(this.ve);
                float f = i4 + this.ve;
                canvas.drawLine(i, f, i2, f, this.c);
            }
            if (this.n > 0.0f) {
                this.c.setColor(this.uj);
                this.c.setStrokeWidth(this.n);
                float f2 = (i5 + i3) / 2.0f;
                canvas.drawLine(i, f2, i2, f2, this.c);
            }
        }
    }

    public a(com.byazt.ga.x xVar, x xVar2, Context context) {
        List<com.byazt.ga.i.ve> listVe;
        super(xVar, xVar2);
        this.i = new LinearLayout.LayoutParams(-2, -2);
        this.da = new ArrayList();
        this.sl = new ArrayList();
        com.byazt.ga.i iVar = ((sp) this).sp;
        if (iVar == null || (listVe = iVar.ve()) == null || listVe.size() <= 0) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.x = linearLayout;
        linearLayout.setOrientation(0);
        tt(listVe.get(0).da);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(80);
        this.x.addView(linearLayout2);
        List<String> listZ = z();
        int i = 0;
        while (i < listVe.size()) {
            com.byazt.ga.i.ve veVar = listVe.get(i);
            TextView textView = new TextView(context);
            c(textView, veVar, (listZ == null || i >= listZ.size()) ? "" : listZ.get(i), i, listVe.size() - 1, listVe.get(0));
            int i2 = veVar.i;
            if (i2 != 0) {
                this.i.bottomMargin = (int) (i2 * com.byazt.kk.da.c());
                linearLayout2.addView(textView, this.i);
            } else {
                linearLayout2.addView(textView);
            }
            i++;
        }
        float fC = com.byazt.kk.da.c();
        this.m = (int) (((sp) this).sp.c() * fC);
        int iTt = (int) (((sp) this).sp.tt() * fC);
        this.nu = iTt;
        c(this.x, this.m, iTt);
        com.byazt.ga.i.tt ttVarSl = ((sp) this).sp.sl();
        this.my = ttVarSl;
        if (ttVarSl != null) {
            this.rh = new Camera();
        }
    }

    private void c(TextView textView, com.byazt.ga.i.ve veVar, String str, int i, int i2, com.byazt.ga.i.ve veVar2) {
        com.byazt.ga.x xVar;
        gt gtVarZm;
        if (TextUtils.isEmpty(str)) {
            str = "";
            textView.setText("");
        } else {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(veVar.ve)) {
            textView.setTextColor(Color.parseColor(veVar.ve));
        } else if (!TextUtils.isEmpty(veVar.uj)) {
            textView.setTextColor(Color.parseColor(veVar.uj));
        }
        if (!TextUtils.isEmpty(veVar.n)) {
            textView.setBackgroundColor(Color.parseColor(veVar.n));
        }
        if (veVar.x == 1) {
            textView.setTypeface(null, 1);
        } else {
            textView.setTypeface(null, 0);
        }
        textView.setGravity(17);
        textView.setTextSize(1, veVar.f28558a);
        if (!TextUtils.isEmpty(veVar.sp) && (xVar = this.tt) != null && (gtVarZm = xVar.zm()) != null) {
            try {
                int i3 = Integer.parseInt(gtVarZm.c(veVar.sp));
                if (i3 > 0) {
                    textView.setTextSize(1, i3);
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
        com.byazt.ga.i.ve.c cVar = veVar.sl;
        if (cVar != null && cVar.c > 0 && !TextUtils.isEmpty(cVar.tt)) {
            if (this.yp == null) {
                this.yp = new SpannableStringBuilder(str);
            }
            if (this.u == null) {
                this.u = new c();
            }
            this.u.tt = Color.parseColor(veVar.sl.tt);
            this.u.ve = veVar.sl.c * com.byazt.kk.da.c();
            this.yp.clear();
            this.yp.clearSpans();
            this.yp.append((CharSequence) str);
            this.yp.setSpan(this.u, 0, str.length(), 33);
            textView.setText(this.yp);
        }
        com.byazt.ga.i.ve.c cVar2 = veVar.t;
        if (cVar2 != null && cVar2.c > 0 && !TextUtils.isEmpty(cVar2.tt)) {
            if (this.z == null) {
                this.z = new SpannableStringBuilder(str);
            }
            if (this.u == null) {
                this.u = new c();
            }
            this.u.uj = Color.parseColor(veVar.t.tt);
            this.u.n = veVar.t.c * com.byazt.kk.da.c();
            this.z.clear();
            this.z.clearSpans();
            this.z.append((CharSequence) str);
            this.z.setSpan(this.u, 0, str.length(), 33);
            textView.setText(this.z);
        }
        int i4 = veVar2.yp;
        if (i4 > 0) {
            textView.setMaxLines(i4);
            if (veVar2.u == 2 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            }
            if (veVar2.u == 1 && i == 0) {
                textView.setEllipsize(TextUtils.TruncateAt.START);
            }
            if (veVar2.u == 0 && i == i2) {
                textView.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }

    private void tt(String str) {
        if (TextUtils.isEmpty(str)) {
            this.x.setGravity(17);
            return;
        }
        str.hashCode();
        if (str.equals("left")) {
            this.x.setGravity(19);
        } else if (str.equals("right")) {
            this.x.setGravity(21);
        } else {
            this.x.setGravity(17);
        }
    }

    private void ve(float f) {
        List<com.byazt.ga.i.ve> listVe;
        com.byazt.ga.i iVar = ((sp) this).sp;
        if (iVar == null || (listVe = iVar.ve()) == null || listVe.size() <= 0) {
            return;
        }
        this.x.setOrientation(0);
        tt(listVe.get(0).da);
        if (this.x.getChildCount() <= 0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.x.getChildAt(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        this.x.removeAllViews();
        if (linearLayout.getChildCount() != listVe.size()) {
            return;
        }
        List<String> listZ = z();
        this.sl.clear();
        int i = 0;
        while (i < listVe.size()) {
            com.byazt.ga.i.ve veVar = listVe.get(i);
            TextView textView = (TextView) linearLayout.getChildAt(i);
            this.sl.add(textView);
            c(textView, veVar, (listZ == null || i >= listZ.size()) ? "" : listZ.get(i), i, listVe.size() - 1, listVe.get(0));
            i++;
        }
        linearLayout.removeAllViews();
        for (int i2 = 0; i2 < listVe.size(); i2++) {
            com.byazt.ga.i.ve veVar2 = listVe.get(i2);
            TextView textView2 = this.sl.get(i2);
            textView2.setAlpha(f);
            linearLayout.setAlpha(f);
            int i3 = veVar2.i;
            if (i3 != 0) {
                this.i.bottomMargin = (int) (i3 * com.byazt.kk.da.c());
                linearLayout.addView(textView2, this.i);
            } else {
                linearLayout.addView(textView2);
            }
        }
        this.x.setAlpha(f);
        this.x.addView(linearLayout);
        c(this.x, this.m, this.nu);
    }

    private List<String> z() {
        com.byazt.ga.x xVar;
        gt gtVarZm;
        List<com.byazt.ga.i.ve> listVe;
        if (((sp) this).sp == null || (xVar = this.tt) == null || (gtVarZm = xVar.zm()) == null) {
            return null;
        }
        String strUj = ((sp) this).sp.uj();
        if ((!TextUtils.isEmpty(strUj) || !TextUtils.isEmpty(this.t)) && (listVe = ((sp) this).sp.ve()) != null) {
            String strC = this.t;
            if (TextUtils.isEmpty(strC)) {
                strC = gtVarZm.c(strUj);
            }
            if (!TextUtils.isEmpty(strC)) {
                int length = strC.length();
                this.da.clear();
                for (int i = 0; i < listVe.size(); i++) {
                    com.byazt.ga.i.ve veVar = listVe.get(i);
                    int iMax = veVar.c;
                    int iMax2 = veVar.tt;
                    if (iMax < 0) {
                        iMax = Math.max(iMax + length, 0);
                    }
                    if (iMax2 < 0) {
                        iMax2 = Math.max(iMax2 + length, 0);
                    }
                    if (iMax + iMax2 > length) {
                        this.da.add("");
                    } else {
                        if (listVe.size() == 1 && iMax == 0 && iMax2 == 0) {
                            iMax2 = length;
                        }
                        this.da.add(strC.substring(iMax, iMax2 + iMax));
                    }
                }
                return this.da;
            }
        }
        return null;
    }

    @Override // com.byazt.zk.sp, com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        View childAt;
        if (this.x != null) {
            canvas.save();
            canvas.concat(matrix);
            c(i);
            ve(x());
            if (this.rh != null) {
                com.byazt.ga.i.tt ttVar = this.my;
                if (ttVar.c != 0 || ttVar.tt != 0 || ttVar.ve != 0) {
                    int width = this.m >> 1;
                    int height = this.nu >> 1;
                    if (this.x.getChildCount() > 0 && (childAt = this.x.getChildAt(0)) != null) {
                        int left = childAt.getLeft() - this.x.getLeft();
                        int top = childAt.getTop() - this.x.getTop();
                        width = left + (childAt.getWidth() >> 1);
                        height = top + (childAt.getHeight() >> 1);
                    }
                    canvas.translate(width, height);
                    com.byazt.ga.i.tt ttVar2 = this.my;
                    if (ttVar2.c != 0 || ttVar2.tt != 0) {
                        this.rh.save();
                        int i2 = this.my.c;
                        if (i2 != 0) {
                            this.rh.rotateX(i2);
                        }
                        int i3 = this.my.tt;
                        if (i3 != 0) {
                            this.rh.rotateY(i3);
                        }
                        this.rh.applyToCanvas(canvas);
                        this.rh.restore();
                    }
                    int i4 = this.my.ve;
                    if (i4 != 0) {
                        canvas.rotate(i4);
                    }
                    canvas.translate(-width, -height);
                }
            }
            this.x.draw(canvas);
            canvas.restore();
            return;
        }
        super.tt(canvas, matrix, i);
    }

    private static void c(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void c(String str) {
        this.t = str;
    }
}
