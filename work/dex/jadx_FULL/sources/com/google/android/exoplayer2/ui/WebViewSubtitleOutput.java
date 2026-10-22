package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.ipd.dsp.internal.e1.f;
import com.zj.adlib.bv9;
import com.zj.adlib.e24;
import com.zj.adlib.gj9;
import com.zj.adlib.gv8;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class WebViewSubtitleOutput extends FrameLayout implements SubtitleView.Output {
    public static final float c = 1.2f;
    public static final String f = "default_bg";
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f31081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WebView f4968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CanvasSubtitleOutput f4969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CaptionStyleCompat f4970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Cue> f4971a;
    public float b;

    public class a extends WebView {
        public a(WebViewSubtitleOutput webViewSubtitleOutput, Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31082a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f31082a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31082a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31082a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WebViewSubtitleOutput(Context context) {
        this(context, null);
    }

    public static int a(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String b(@Nullable Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = b.f31082a[alignment.ordinal()];
        if (i != 1) {
            return i != 2 ? "center" : "end";
        }
        return "start";
    }

    public static String c(CaptionStyleCompat captionStyleCompat) {
        int i = captionStyleCompat.d;
        if (i == 1) {
            return gj9.H("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", e24.b(captionStyleCompat.e));
        }
        if (i == 2) {
            return gj9.H("0.1em 0.12em 0.15em %s", e24.b(captionStyleCompat.e));
        }
        if (i != 3) {
            return i != 4 ? "unset" : gj9.H("-0.05em -0.05em 0.15em %s", e24.b(captionStyleCompat.e));
        }
        return gj9.H("0.06em 0.08em 0.15em %s", e24.b(captionStyleCompat.e));
    }

    public static String e(int i) {
        if (i != 1) {
            return i != 2 ? "horizontal-tb" : "vertical-lr";
        }
        return "vertical-rl";
    }

    public static String g(Cue cue) {
        float f2 = cue.f;
        if (f2 == 0.0f) {
            return "";
        }
        int i = cue.P;
        return gj9.H("%s(%.2fdeg)", (i == 2 || i == 1) ? "skewY" : "skewX", Float.valueOf(f2));
    }

    public final String d(int i, float f2) {
        float fH = gv8.h(i, f2, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return fH == -3.4028235E38f ? "unset" : gj9.H("%.2fpx", Float.valueOf(fH / getContext().getResources().getDisplayMetrics().density));
    }

    public void f() {
        this.f4968a.destroy();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:26:0x0107  */
    /* JADX WARN: Code duplicated, block: B:29:0x0121  */
    /* JADX WARN: Code duplicated, block: B:30:0x0124  */
    /* JADX WARN: Code duplicated, block: B:33:0x013b  */
    /* JADX WARN: Code duplicated, block: B:35:0x013e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x0140  */
    /* JADX WARN: Code duplicated, block: B:38:0x0144 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0147 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0149  */
    /* JADX WARN: Code duplicated, block: B:48:0x015b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0183  */
    /* JADX WARN: Code duplicated, block: B:58:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x021f  */
    /* JADX WARN: Code duplicated, block: B:63:0x023b  */
    public final void h() {
        String strH;
        int iA;
        int i;
        float f2;
        String strH2;
        int i2;
        int i3;
        int i4;
        String str;
        String str2;
        String str3;
        int i5;
        String str4;
        int i6;
        c.b bVarA;
        Iterator it;
        c.b bVar;
        Layout.Alignment alignment;
        String str5;
        boolean z;
        WebViewSubtitleOutput webViewSubtitleOutput = this;
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        int i8 = 1;
        float f3 = 1.2f;
        sb.append(gj9.H("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", e24.b(webViewSubtitleOutput.f4970a.f4727a), webViewSubtitleOutput.d(webViewSubtitleOutput.K, webViewSubtitleOutput.f31081a), Float.valueOf(1.2f), c(webViewSubtitleOutput.f4970a)));
        HashMap map = new HashMap();
        map.put(e24.a(f), gj9.H("background-color:%s;", e24.b(webViewSubtitleOutput.f4970a.b)));
        int i9 = 0;
        while (i9 < webViewSubtitleOutput.f4971a.size()) {
            Cue cue = webViewSubtitleOutput.f4971a.get(i9);
            float f4 = cue.b;
            float f5 = f4 != -3.4028235E38f ? f4 * 100.0f : 50.0f;
            int iA2 = a(cue.M);
            float f6 = cue.f4519a;
            if (f6 != -3.4028235E38f) {
                if (cue.K != i8) {
                    Object[] objArr = new Object[i8];
                    objArr[i7] = Float.valueOf(f6 * 100.0f);
                    strH = gj9.H("%.2f%%", objArr);
                    iA = cue.P == i8 ? -a(cue.L) : a(cue.L);
                } else if (f6 >= 0.0f) {
                    Object[] objArr2 = new Object[i8];
                    objArr2[i7] = Float.valueOf(f6 * f3);
                    strH = gj9.H("%.2fem", objArr2);
                    iA = i7;
                    i = iA;
                } else {
                    Object[] objArr3 = new Object[i8];
                    objArr3[i7] = Float.valueOf(((-f6) - 1.0f) * f3);
                    strH = gj9.H("%.2fem", objArr3);
                    iA = i7;
                    i = i8;
                }
                f2 = cue.c;
                if (f2 != -3.4028235E38f) {
                    Object[] objArr4 = new Object[i8];
                    objArr4[0] = Float.valueOf(f2 * 100.0f);
                    strH2 = gj9.H("%.2f%%", objArr4);
                } else {
                    strH2 = "fit-content";
                }
                String strB = b(cue.f4521a);
                String strE = e(cue.P);
                String strD = webViewSubtitleOutput.d(cue.O, cue.e);
                if (cue.f4523a) {
                    i2 = cue.N;
                } else {
                    i2 = webViewSubtitleOutput.f4970a.c;
                }
                String strB2 = e24.b(i2);
                i3 = iA;
                i4 = cue.P;
                str = "right";
                str2 = "left";
                str3 = f.l;
                if (i4 != 1) {
                    if (i != 0) {
                        str = "left";
                    }
                    str2 = f.l;
                    i5 = 2;
                    str3 = str;
                } else if (i4 != 2) {
                    if (i != 0) {
                        str3 = f.n;
                    }
                    i5 = 2;
                } else {
                    if (i == 0) {
                        str = "left";
                    }
                    str2 = f.l;
                    i5 = 2;
                    str3 = str;
                }
                if (i4 != i5 || i4 == 1) {
                    str4 = "height";
                    i6 = i3;
                    i3 = iA2;
                } else {
                    str4 = "width";
                    i6 = iA2;
                }
                bVarA = c.a(cue.f4522a, getContext().getResources().getDisplayMetrics().density);
                it = map.keySet().iterator();
                while (it.hasNext()) {
                    Iterator it2 = it;
                    String str6 = (String) it.next();
                    c.b bVar2 = bVarA;
                    str5 = (String) map.put(str6, (String) map.get(str6));
                    if (str5 != null || str5.equals(map.get(str6))) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb0.i(z);
                    it = it2;
                    bVarA = bVar2;
                }
                bVar = bVarA;
                sb.append(gj9.H("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i9), str2, Float.valueOf(f5), str3, strH, str4, strH2, strB, strE, strD, strB2, Integer.valueOf(i6), Integer.valueOf(i3), g(cue)));
                sb.append(gj9.H("<span class='%s'>", f));
                alignment = cue.f4524b;
                if (alignment != null) {
                    sb.append(gj9.H("<span style='display:inline-block; text-align:%s;'>", b(alignment)));
                    sb.append(bVar.f31086a);
                    sb.append("</span>");
                } else {
                    sb.append(bVar.f31086a);
                }
                sb.append("</span>");
                sb.append("</div>");
                i9++;
                f3 = 1.2f;
                i7 = 0;
                webViewSubtitleOutput = this;
                i8 = 1;
            } else {
                Object[] objArr5 = new Object[i8];
                objArr5[i7] = Float.valueOf((1.0f - webViewSubtitleOutput.b) * 100.0f);
                strH = gj9.H("%.2f%%", objArr5);
                iA = -100;
            }
            i = i7;
            f2 = cue.c;
            if (f2 != -3.4028235E38f) {
                Object[] objArr6 = new Object[i8];
                objArr6[0] = Float.valueOf(f2 * 100.0f);
                strH2 = gj9.H("%.2f%%", objArr6);
            } else {
                strH2 = "fit-content";
            }
            String strB3 = b(cue.f4521a);
            String strE2 = e(cue.P);
            String strD2 = webViewSubtitleOutput.d(cue.O, cue.e);
            if (cue.f4523a) {
                i2 = cue.N;
            } else {
                i2 = webViewSubtitleOutput.f4970a.c;
            }
            String strB4 = e24.b(i2);
            i3 = iA;
            i4 = cue.P;
            str = "right";
            str2 = "left";
            str3 = f.l;
            if (i4 != 1) {
                if (i != 0) {
                    str = "left";
                }
                str2 = f.l;
                i5 = 2;
                str3 = str;
            } else if (i4 != 2) {
                if (i != 0) {
                    str3 = f.n;
                }
                i5 = 2;
            } else {
                if (i == 0) {
                    str = "left";
                }
                str2 = f.l;
                i5 = 2;
                str3 = str;
            }
            if (i4 != i5) {
                str4 = "height";
                i6 = i3;
                i3 = iA2;
            } else {
                str4 = "height";
                i6 = i3;
                i3 = iA2;
            }
            bVarA = c.a(cue.f4522a, getContext().getResources().getDisplayMetrics().density);
            it = map.keySet().iterator();
            while (it.hasNext()) {
                Iterator it3 = it;
                String str7 = (String) it.next();
                c.b bVar3 = bVarA;
                str5 = (String) map.put(str7, (String) map.get(str7));
                if (str5 != null) {
                    z = true;
                } else {
                    z = true;
                }
                sb0.i(z);
                it = it3;
                bVarA = bVar3;
            }
            bVar = bVarA;
            sb.append(gj9.H("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i9), str2, Float.valueOf(f5), str3, strH, str4, strH2, strB3, strE2, strD2, strB4, Integer.valueOf(i6), Integer.valueOf(i3), g(cue)));
            sb.append(gj9.H("<span class='%s'>", f));
            alignment = cue.f4524b;
            if (alignment != null) {
                sb.append(gj9.H("<span style='display:inline-block; text-align:%s;'>", b(alignment)));
                sb.append(bVar.f31086a);
                sb.append("</span>");
            } else {
                sb.append(bVar.f31086a);
            }
            sb.append("</span>");
            sb.append("</div>");
            i9++;
            f3 = 1.2f;
            i7 = 0;
            webViewSubtitleOutput = this;
            i8 = 1;
        }
        sb.append("</div></body></html>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<html><head><style>");
        for (String str8 : map.keySet()) {
            sb2.append(str8);
            sb2.append(bv9.b);
            sb2.append((String) map.get(str8));
            sb2.append("}");
        }
        sb2.append("</style></head>");
        sb.insert(0, sb2.toString());
        this.f4968a.loadData(Base64.encodeToString(sb.toString().getBytes(com.google.common.base.b.c), 1), "text/html", "base64");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.f4971a.isEmpty()) {
            return;
        }
        h();
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void update(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f2, int i, float f3) {
        this.f4970a = captionStyleCompat;
        this.f31081a = f2;
        this.K = i;
        this.b = f3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Cue cue = list.get(i2);
            if (cue.f4520a != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.f4971a.isEmpty() || !arrayList2.isEmpty()) {
            this.f4971a = arrayList2;
            h();
        }
        this.f4969a.update(arrayList, captionStyleCompat, f2, i, f3);
        invalidate();
    }

    public WebViewSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4971a = Collections.emptyList();
        this.f4970a = CaptionStyleCompat.f31056a;
        this.f31081a = 0.0533f;
        this.K = 0;
        this.b = 0.08f;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.f4969a = canvasSubtitleOutput;
        a aVar = new a(this, context, attributeSet);
        this.f4968a = aVar;
        aVar.setBackgroundColor(0);
        addView(canvasSubtitleOutput);
        addView(aVar);
    }
}
