package com.beizi.fusion;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout.LayoutModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.layout.par.LayoutParamModel;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class yl implements ge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutModel f28073a;
    private final xl b;
    private final Context c;
    private final Map d;
    private final String e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private RelativeLayout.LayoutParams m;
    private int n;
    private int o;
    private int p;
    private int q;
    private ge.a t;
    private boolean l = false;
    private ab r = null;
    private boolean s = false;
    private boolean u = false;

    public static class a {
        public static int a(Context context, TextView textView) {
            if (textView == null) {
                return 0;
            }
            int lineCount = textView.getLineCount() > 0 ? textView.getLineCount() : 1;
            float lineSpacingExtra = textView.getLineSpacingExtra();
            float lineSpacingMultiplier = textView.getLineSpacingMultiplier();
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            return ((fontMetricsInt.bottom - fontMetricsInt.top) * lineCount) + (gn.a.a(context, lineSpacingExtra * lineSpacingMultiplier) * (lineCount >= 1 ? lineCount - 1 : 0));
        }
    }

    public yl(Context context, LayoutModel layoutModel, xl xlVar, String str) {
        this.c = context;
        this.f28073a = layoutModel;
        this.b = xlVar;
        this.e = str;
        this.d = xlVar.i();
    }

    private void c(LayoutParamModel layoutParamModel, String str, RelativeLayout.LayoutParams layoutParams) {
        float fK;
        ab abVar;
        int i;
        if (layoutParamModel != null) {
            String size = layoutParamModel.getSize();
            String reference = layoutParamModel.getReference();
            String layout = layoutParamModel.getLayout();
            int iF = 0;
            if (TextUtils.isEmpty(size)) {
                fK = 1.0f;
            } else if (no.f(size)) {
                fK = no.k(size);
            } else {
                iF = Math.abs(gn.a.a(this.c, no.i(size)));
                om.f("RenderParams", str + " 设置定值 " + iF);
                fK = 1.0f;
            }
            if ("own".equalsIgnoreCase(reference)) {
                om.e("RenderParams", str + "不应该传入 own reference...");
                return;
            }
            if ("super".equalsIgnoreCase(reference)) {
                if (str.equalsIgnoreCase(layout)) {
                    if (no.f(size) && this.o > 0) {
                        iF = (int) (Math.abs(fK) * this.o);
                        om.f("RenderParams", str + " 根据父布局百分比计算 " + iF);
                    }
                    if (com.ipd.dsp.internal.e1.f.l.equalsIgnoreCase(str)) {
                        this.g = iF;
                        om.f("RenderParams", str + " 追加 ALIGN_PARENT_TOP");
                        layoutParams.addRule(10, -1);
                    }
                    if (com.ipd.dsp.internal.e1.f.n.equalsIgnoreCase(str)) {
                        this.f = iF;
                        om.f("RenderParams", str + " 追加 ALIGN_PARENT_BOTTOM");
                        layoutParams.addRule(12, -1);
                        return;
                    }
                    return;
                }
                return;
            }
            Map map = this.d;
            if (map == null || !map.containsKey(reference) || (abVar = (ab) this.d.get(reference)) == null || (i = no.i(abVar.b())) <= 0) {
                return;
            }
            if (com.ipd.dsp.internal.e1.f.l.equalsIgnoreCase(str)) {
                if (no.f(size)) {
                    iF = (int) ((fK + 1.0f) * abVar.a().b());
                    om.f("RenderParams", str + " 根据其他view右边距计算 " + iF);
                }
                this.g = iF;
                if (com.ipd.dsp.internal.e1.f.n.equalsIgnoreCase(layout)) {
                    om.f("RenderParams", str + " 追加 BELOW " + i);
                    layoutParams.addRule(3, i);
                    om.f("RenderParams", "设置above的节点 " + abVar);
                    this.r = abVar;
                }
                if (com.ipd.dsp.internal.e1.f.l.equalsIgnoreCase(layout)) {
                    om.f("RenderParams", str + " 追加 ALIGN_TOP " + i);
                    if (reference.equals(this.e)) {
                        layoutParams.addRule(10, -1);
                    } else {
                        layoutParams.addRule(6, i);
                    }
                }
            }
            if (com.ipd.dsp.internal.e1.f.n.equalsIgnoreCase(str)) {
                if (no.f(size)) {
                    iF = (int) ((fK + 1.0f) * abVar.a().f());
                }
                this.f = iF;
                if (com.ipd.dsp.internal.e1.f.n.equalsIgnoreCase(layout)) {
                    om.f("RenderParams", str + " 追加 ALIGN_BOTTOM " + i);
                    if (reference.equals(this.e)) {
                        layoutParams.addRule(12, -1);
                    } else {
                        layoutParams.addRule(8, i);
                    }
                }
                if (com.ipd.dsp.internal.e1.f.l.equalsIgnoreCase(layout)) {
                    om.f("RenderParams", str + " 追加 ABOVE " + i);
                    layoutParams.addRule(2, i);
                    om.f("RenderParams", "设置below的节点 " + abVar);
                    this.r = abVar;
                }
            }
        }
    }

    private boolean e(int i) {
        return i <= 0;
    }

    private void j() {
        if (this.k < 0) {
            this.k = -2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0085  */
    private int k() {
        int i;
        om.f("RenderParams", "尝试根据[素材]计算高度...");
        int i2 = 0;
        if (this.b.c()) {
            int i3 = this.p;
            if (i3 > 0 && (i = this.q) > 0) {
                int iD = d((int) (i * (this.j / (i3 * 1.0f))));
                om.f("RenderParams", this.b.b() + " 主要资源view计算..." + this.k + " calculate " + iD);
                if (this.o <= 0 || !this.f28073a.isAutoHeight()) {
                    i2 = iD;
                } else {
                    om.f("RenderParams", "容器高度固定时, 计算缩小的尺寸..." + this.r);
                    ab abVar = this.r;
                    if (abVar != null) {
                        int iA = this.o - abVar.a().a();
                        if (iA > 0) {
                            if (iA < iD) {
                                i2 = iA;
                            } else {
                                i2 = iD;
                            }
                        }
                    } else {
                        i2 = iD;
                    }
                }
                om.f("RenderParams", this.b.b() + " 高度根据素材计算 " + i2);
                return i2;
            }
        } else {
            Object objD = this.b.d();
            if (objD instanceof TextView) {
                return d(a.a(this.c, (TextView) objD));
            }
        }
        return 0;
    }

    private int l() {
        om.f("RenderParams", this.b.b() + " 开始根据[展开]计算...");
        this.u = true;
        List listH = this.b.h();
        if (listH != null && !listH.isEmpty()) {
            int size = listH.size();
            int[] iArr = new int[size];
            for (int i = 0; i < listH.size(); i++) {
                iArr[i] = ((ab) listH.get(i)).a().a();
            }
            Arrays.sort(iArr);
            int i2 = iArr[size - 1];
            if (i2 > 0) {
                return i2;
            }
        }
        return 0;
    }

    @Override // com.beizi.fusion.ge
    public void a(int i) {
        LayoutModel layoutModel = this.f28073a;
        if (layoutModel != null) {
            a(layoutModel.getMarginTop(), com.ipd.dsp.internal.e1.f.l, this.m, i);
            a(this.f28073a.getMarginBottom(), com.ipd.dsp.internal.e1.f.n, this.m, i);
        }
    }

    @Override // com.beizi.fusion.ge
    public int b() {
        if (!this.l) {
            c();
        }
        return this.g;
    }

    @Override // com.beizi.fusion.ge
    public int d() {
        if (!this.l) {
            c();
        }
        return this.k;
    }

    @Override // com.beizi.fusion.ge
    public int e() {
        if (!this.l) {
            c();
        }
        return this.i;
    }

    @Override // com.beizi.fusion.ge
    public int f() {
        if (!this.l) {
            c();
        }
        return this.f;
    }

    @Override // com.beizi.fusion.ge
    public int g() {
        if (!this.l) {
            c();
        }
        return this.h;
    }

    @Override // com.beizi.fusion.ge
    public int h() {
        if (!this.l) {
            c();
        }
        return this.j;
    }

    @Override // com.beizi.fusion.ge
    public RelativeLayout.LayoutParams i() {
        RelativeLayout.LayoutParams layoutParams = this.m;
        layoutParams.width = this.j;
        layoutParams.height = this.k;
        layoutParams.topMargin = this.g;
        layoutParams.rightMargin = this.i;
        layoutParams.bottomMargin = this.f;
        layoutParams.leftMargin = this.h;
        if (om.a(om.a.LOG_LEVEL_RENDER)) {
            om.f("RenderParams", this.b.b() + " 最后的计算结果: 宽: " + this.m.width + " 高: " + this.m.height + " 左边距: " + this.m.leftMargin + " 上边距: " + this.m.topMargin + " 右边距: " + this.m.rightMargin + " 下边距: " + this.m.bottomMargin);
        }
        return this.m;
    }

    private void a(LayoutParamModel layoutParamModel, String str, RelativeLayout.LayoutParams layoutParams, int i) {
        if (layoutParamModel != null) {
            String size = layoutParamModel.getSize();
            String reference = layoutParamModel.getReference();
            String layout = layoutParamModel.getLayout();
            if (TextUtils.isEmpty(size) || !no.f(size)) {
                return;
            }
            float fK = no.k(size);
            if ("super".equalsIgnoreCase(reference) && str.equalsIgnoreCase(layout)) {
                int iAbs = (!no.f(size) || i <= 0) ? 0 : (int) (Math.abs(fK) * i);
                if (com.ipd.dsp.internal.e1.f.l.equalsIgnoreCase(str)) {
                    layoutParams.topMargin = iAbs;
                }
                if (com.ipd.dsp.internal.e1.f.n.equalsIgnoreCase(str)) {
                    layoutParams.bottomMargin = iAbs;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005c  */
    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    /* JADX WARN: Code duplicated, block: B:18:0x0082  */
    /* JADX WARN: Code duplicated, block: B:20:0x0088  */
    /* JADX WARN: Code duplicated, block: B:22:0x008e  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:28:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:32:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x005c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:22:0x008e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:25:0x00b4, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:28:0x00d3, please report this as an issue */
    private void b(LayoutParamModel layoutParamModel, String str, RelativeLayout.LayoutParams layoutParams) throws vl {
        float fK;
        int iG;
        Map map;
        ab abVar;
        int i;
        if (layoutParamModel != null) {
            String size = layoutParamModel.getSize();
            String reference = layoutParamModel.getReference();
            String layout = layoutParamModel.getLayout();
            if (!TextUtils.isEmpty(size)) {
                if (no.f(size)) {
                    fK = no.k(size);
                } else {
                    int iAbs = Math.abs(gn.a.a(this.c, no.i(size)));
                    om.f("RenderParams", str + " 设置定值 " + iAbs);
                    iG = iAbs;
                    fK = 1.0f;
                }
                if ("own".equalsIgnoreCase(reference)) {
                    om.e("RenderParams", str + "不应该传入 own reference...");
                    return;
                }
                if ("super".equalsIgnoreCase(reference)) {
                    if (str.equalsIgnoreCase(layout)) {
                        if (no.f(size)) {
                            iG = (int) (Math.abs(fK) * this.n);
                            om.f("RenderParams", str + " 根据父布局百分比计算 " + iG);
                        }
                        if ("right".equalsIgnoreCase(str)) {
                            this.i = iG;
                            om.f("RenderParams", str + " 追加 ALIGN_PARENT_RIGHT");
                            layoutParams.addRule(11, -1);
                        }
                        if ("left".equalsIgnoreCase(str)) {
                            this.h = iG;
                            om.f("RenderParams", str + " 追加 ALIGN_PARENT_LEFT");
                            layoutParams.addRule(9, -1);
                            return;
                        }
                        return;
                    }
                    throw new vl("左右交叉... 无法渲染...");
                }
                map = this.d;
                if (map != null || !map.containsKey(reference) || (abVar = (ab) this.d.get(reference)) == null || (i = no.i(abVar.b())) <= 0) {
                    return;
                }
                if ("right".equalsIgnoreCase(str)) {
                    if (no.f(size)) {
                        iG = (int) ((fK + 1.0f) * abVar.a().e());
                        om.f("RenderParams", str + " 根据其他view右边距计算 " + iG);
                    }
                    this.i = iG;
                    if ("right".equalsIgnoreCase(layout)) {
                        om.f("RenderParams", str + " 追加 ALIGN_RIGHT " + i);
                        if (reference.equals(this.e)) {
                            layoutParams.addRule(11, -1);
                        } else {
                            layoutParams.addRule(7, i);
                        }
                    }
                    if ("left".equalsIgnoreCase(layout)) {
                        om.f("RenderParams", str + " 追加 LEFT_OF " + i);
                        layoutParams.addRule(0, i);
                    }
                }
                if ("left".equalsIgnoreCase(str)) {
                    if (no.f(size)) {
                        iG = (int) ((fK + 1.0f) * abVar.a().g());
                        om.f("RenderParams", str + " 根据其他view左边距计算 " + iG);
                    }
                    this.h = iG;
                    if ("left".equalsIgnoreCase(layout)) {
                        om.f("RenderParams", str + " 追加 ALIGN_LEFT " + i);
                        if (reference.equals(this.e)) {
                            layoutParams.addRule(9, -1);
                        } else {
                            layoutParams.addRule(5, i);
                        }
                    }
                    if ("right".equalsIgnoreCase(layout)) {
                        om.f("RenderParams", str + " 追加 RIGHT_OF " + i);
                        layoutParams.addRule(1, i);
                        return;
                    }
                    return;
                }
                return;
            }
            fK = 1.0f;
            iG = 0;
            if ("own".equalsIgnoreCase(reference)) {
                om.e("RenderParams", str + "不应该传入 own reference...");
                return;
            }
            if ("super".equalsIgnoreCase(reference)) {
                if (str.equalsIgnoreCase(layout)) {
                    if (no.f(size)) {
                        iG = (int) (Math.abs(fK) * this.n);
                        om.f("RenderParams", str + " 根据父布局百分比计算 " + iG);
                    }
                    if ("right".equalsIgnoreCase(str)) {
                        this.i = iG;
                        om.f("RenderParams", str + " 追加 ALIGN_PARENT_RIGHT");
                        layoutParams.addRule(11, -1);
                    }
                    if ("left".equalsIgnoreCase(str)) {
                        this.h = iG;
                        om.f("RenderParams", str + " 追加 ALIGN_PARENT_LEFT");
                        layoutParams.addRule(9, -1);
                        return;
                    }
                    return;
                }
                throw new vl("左右交叉... 无法渲染...");
            }
            map = this.d;
            if (map != null) {
            }
        }
    }

    private int d(int i) {
        float fH;
        float fH2;
        if (!this.f28073a.isAutoHeight()) {
            return i;
        }
        om.f("RenderParams", "当前节点, 高度自动调节, 需要根据最大, 最小值修正高度...");
        if (no.f(this.f28073a.getMaxHeight())) {
            fH = this.j * no.k(this.f28073a.getMaxHeight());
        } else {
            fH = no.h(this.f28073a.getMaxHeight());
        }
        if (no.f(this.f28073a.getMinHeight())) {
            fH2 = this.j * no.k(this.f28073a.getMinHeight());
        } else {
            fH2 = no.h(this.f28073a.getMinHeight());
        }
        om.f("RenderParams", "当前节点, 高度自动调节, 最大高度: " + fH + " 最小高度: " + fH2 + " calculate " + i);
        StringBuilder sb = new StringBuilder();
        sb.append("parent width ");
        sb.append(this.n);
        sb.append(" parent height ");
        sb.append(this.o);
        om.f("RenderParams", sb.toString());
        if (i <= this.o) {
            return i;
        }
        if (fH <= 0.0f || i <= fH) {
            return (fH2 <= 0.0f || ((float) i) >= fH2) ? i : (int) fH2;
        }
        return (int) fH;
    }

    private void a(LayoutParamModel layoutParamModel, String str, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParamModel != null) {
            if ("x".equals(str)) {
                layoutParams.addRule(14, -1);
            }
            if ("y".equals(str)) {
                layoutParams.addRule(15, -1);
                String reference = layoutParamModel.getReference();
                if (TextUtils.isEmpty(reference) || ((ab) this.d.get(reference)) == null) {
                    return;
                }
                layoutParams.addRule(4, no.i(reference));
            }
        }
    }

    private void a(LayoutParamModel layoutParamModel) throws vl {
        try {
            this.k = c(layoutParamModel);
        } catch (vl unused) {
            this.k = -2;
        }
        if (this.k <= 0) {
            try {
                this.k = k();
            } catch (vl unused2) {
                this.k = -2;
            }
        }
        if (this.k <= 0) {
            a("temp");
            this.k = l();
        }
        try {
            j();
            if (this.s) {
                this.j = (int) (no.k(this.f28073a.getWidth().getSize()) * this.k);
            }
            om.f("RenderParams", this.b.b() + " calculate self height " + this.k);
        } catch (vl unused3) {
            this.k = -2;
            throw new vl("高度无法修正...");
        }
    }

    @Override // com.beizi.fusion.ge
    public void a(ge.a aVar) {
        this.t = aVar;
        if (this.b.g() > 0) {
            Iterator it = this.b.h().iterator();
            while (it.hasNext()) {
                ((ab) it.next()).a().a(this.t);
            }
        }
    }

    private void a(String str) {
        List<ab> listH = this.b.h();
        if (listH == null || listH.isEmpty()) {
            return;
        }
        for (ab abVar : listH) {
            ge geVarA = abVar.a();
            if ("height".equalsIgnoreCase(str)) {
                geVarA.c(this.k);
            }
            if ("width".equalsIgnoreCase(str)) {
                geVarA.b(this.j);
            }
            if ("temp".equalsIgnoreCase(str) && abVar.c()) {
                geVarA.c(this.o);
            }
            om.f("RenderParams", abVar.b() + " 设置宽高 " + this.k + " " + this.j);
        }
    }

    private void b(LayoutParamModel layoutParamModel) {
        ab abVar;
        if (layoutParamModel != null) {
            String size = layoutParamModel.getSize();
            String reference = layoutParamModel.getReference();
            String layout = layoutParamModel.getLayout();
            int iA = -2;
            if (!TextUtils.isEmpty(size)) {
                if (no.f(size)) {
                    float fK = no.k(size);
                    if ("own".equalsIgnoreCase(reference)) {
                        if ("height".equalsIgnoreCase(layout)) {
                            int i = this.k;
                            if (i > 0) {
                                iA = (int) (i * Math.abs(fK));
                                om.f("RenderParams", "宽度根据[定高] * 百分比计算 " + fK + " : " + iA);
                            } else {
                                om.e("RenderParams", "宽度根据[高]计算, 但高度不定...");
                                this.s = true;
                            }
                        }
                    } else if ("super".equalsIgnoreCase(reference)) {
                        float fAbs = Math.abs(fK);
                        int i2 = this.n;
                        int i3 = (int) (fAbs * i2);
                        int i4 = this.h;
                        int i5 = this.i;
                        iA = (i3 + i4) + i5 > i2 ? (i2 - i4) - i5 : i3;
                        om.f("RenderParams", "宽度根据父布局 * 百分比计算 " + fK + " : " + iA);
                        int iB = b(layout);
                        if (iB > 0) {
                            iA = (int) (fK * iB);
                        }
                    } else {
                        Map map = this.d;
                        if (map != null && map.get(reference) != null && (abVar = (ab) this.d.get(reference)) != null) {
                            if ("width".equalsIgnoreCase(layout)) {
                                iA = (int) (abVar.a().h() * Math.abs(fK));
                                om.f("RenderParams", "宽度根据其他view的[宽]计算 " + iA);
                            }
                            if ("height".equalsIgnoreCase(layout)) {
                                iA = (int) (abVar.a().d() * Math.abs(fK));
                                om.f("RenderParams", "宽度根据其他view的[高]计算 " + iA);
                            }
                        }
                    }
                } else {
                    iA = gn.a.a(this.c, no.i(size));
                    om.f("RenderParams", "宽度根据model固定值计算 " + iA);
                }
            }
            this.j = iA;
            return;
        }
        this.j = (this.n - this.h) - this.i;
    }

    private int c(LayoutParamModel layoutParamModel) throws vl {
        int iA;
        ab abVar;
        om.f("RenderParams", "尝试根据[model]计算高度...");
        if (layoutParamModel != null) {
            String size = layoutParamModel.getSize();
            String reference = layoutParamModel.getReference();
            String layout = layoutParamModel.getLayout();
            if (!TextUtils.isEmpty(size)) {
                if (no.f(size)) {
                    float fK = no.k(size);
                    iA = 0;
                    if ("own".equalsIgnoreCase(reference)) {
                        if ("width".equalsIgnoreCase(layout)) {
                            if (!this.s) {
                                iA = (int) (Math.abs(fK) * this.j);
                                om.f("RenderParams", "高度根据[宽] * 百分比计算 " + Math.abs(fK) + " : " + iA);
                            } else {
                                throw new vl("宽高相互依赖自身值...");
                            }
                        }
                    } else if ("super".equalsIgnoreCase(reference)) {
                        if (this.o > 0) {
                            int iAbs = (int) (Math.abs(fK) * this.o);
                            int i = this.g;
                            int i2 = this.f;
                            int i3 = iAbs + i + i2;
                            int i4 = this.n;
                            iA = i3 > i4 ? (i4 - i) - i2 : iAbs;
                            om.f("RenderParams", "高度根据父布局[定高] * 百分比计算 " + Math.abs(fK) + " : " + iA);
                        }
                        int iB = b(layout);
                        if (iB > 0) {
                            iA = (int) (fK * iB);
                        }
                    } else {
                        Map map = this.d;
                        if (map != null && map.get(reference) != null && (abVar = (ab) this.d.get(reference)) != null) {
                            if ("width".equalsIgnoreCase(layout)) {
                                iA = (int) (abVar.a().h() * Math.abs(fK));
                                om.f("RenderParams", "高度根据其他view[宽] * 百分比计算 " + Math.abs(fK) + " : " + iA);
                            }
                            if ("height".equalsIgnoreCase(layout)) {
                                iA = (int) (abVar.a().d() * Math.abs(fK));
                                om.f("RenderParams", "高度根据其他view[高] * 百分比计算 " + Math.abs(fK) + " : " + iA);
                            }
                        }
                    }
                } else {
                    iA = gn.a.a(this.c, no.i(size));
                    om.f("RenderParams", "高度根据model固定值计算 " + iA);
                }
                om.f("RenderParams", this.b.b() + " 高度根据model计算 " + iA);
                return iA;
            }
        }
        throw new vl("height结构为空...");
    }

    @Override // com.beizi.fusion.ge
    public int a() {
        if (!this.l) {
            c();
        }
        int i = this.f + this.g + this.k;
        ab abVar = this.r;
        return abVar != null ? i + abVar.a().a() : i;
    }

    @Override // com.beizi.fusion.ge
    public void a(int i, int i2) {
        this.p = i;
        this.q = i2;
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        str.getClass();
        switch (str) {
            case "bottom":
                return this.f;
            case "top":
                return this.g;
            case "left":
                return this.h;
            case "right":
                return this.i;
            default:
                return 0;
        }
    }

    @Override // com.beizi.fusion.ge
    public void c() {
        if (this.l) {
            om.f("RenderParams", this.b.b() + "已经计算过宽高...");
            return;
        }
        om.f("RenderParams", "--------------------Render Calculate------------------ " + this.b.b());
        if (this.m == null) {
            this.m = new RelativeLayout.LayoutParams(-1, -2);
        }
        try {
            if (this.f28073a != null) {
                if (e(this.n)) {
                    this.n = gn.f(this.c);
                }
                om.f("RenderParams", this.b.b() + "开始计算[横向margin]...");
                b(this.f28073a.getMarginRight(), "right", this.m);
                b(this.f28073a.getMarginLeft(), "left", this.m);
                a(this.f28073a.getCenterX(), "x", this.m);
                om.f("RenderParams", this.b.b() + "开始计算[纵向margin]...");
                c(this.f28073a.getMarginTop(), com.ipd.dsp.internal.e1.f.l, this.m);
                c(this.f28073a.getMarginBottom(), com.ipd.dsp.internal.e1.f.n, this.m);
                a(this.f28073a.getCenterY(), "y", this.m);
                om.f("RenderParams", this.b.b() + "开始计算自身[宽]...");
                b(this.f28073a.getWidth());
                a("width");
                om.f("RenderParams", this.b.b() + "开始计算自身[高]...");
                a(this.f28073a.getHeight());
                a("height");
                this.l = true;
                om.f("RenderParams", "--------------------Calculate Finished------------------ " + this.b.b());
                ge.a aVar = this.t;
                if (aVar != null) {
                    aVar.b(this.b);
                }
                if (this.b.g() > 0) {
                    List<ab> listH = this.b.h();
                    Collections.sort(listH, ul.a());
                    for (ab abVar : listH) {
                        abVar.a().c();
                        if (this.u) {
                            abVar.a().a(this.m.height);
                        }
                    }
                    return;
                }
                return;
            }
            throw new vl("LayoutModel is null");
        } catch (vl e) {
            this.l = false;
            this.m = null;
            om.e("RenderParams", " RenderException " + e.getLocalizedMessage());
            om.a(e);
            ge.a aVar2 = this.t;
            if (aVar2 != null) {
                aVar2.a(this.b);
            }
        }
    }

    @Override // com.beizi.fusion.ge
    public void b(int i) {
        this.n = i;
    }

    @Override // com.beizi.fusion.ge
    public void c(int i) {
        this.o = i;
    }
}
