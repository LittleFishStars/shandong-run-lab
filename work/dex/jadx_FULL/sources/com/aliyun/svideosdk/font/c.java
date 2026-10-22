package com.aliyun.svideosdk.font;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f25770a;
    protected boolean b;
    protected int c;
    protected int d;
    protected StaticLayout e;
    protected float f = 0.0f;
    protected boolean g = false;
    protected ArrayList<ArrayList<b>> h;
    protected RectF[] i;
    protected RectF j;
    protected RectF k;
    protected float l;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PointF f25771a;
        public RectF b;
        public RectF c;
        public Path f;
        public int i;
        public boolean d = false;
        public boolean e = false;
        public int g = 0;
        public int h = 0;
    }

    /* JADX INFO: renamed from: com.aliyun.svideosdk.font.c$c, reason: collision with other inner class name */
    public static class C0232c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25772a;
        public int b;
        public int c;
        public int d;
        public float e;
        public boolean f;
        public float g;
        public float h;

        private C0232c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ArrayList<C0232c> f25773a;
        int b = 0;

        public d(ArrayList<C0232c> arrayList) {
            this.f25773a = arrayList;
        }

        private float a() {
            C0232c c0232c = this.f25773a.get(this.b);
            float f = c0232c.g;
            float f2 = c0232c.h;
            if (f == f2) {
                return !c0232c.f ? f : f - c0232c.e;
            }
            int i = this.b;
            if (i == 0) {
                return !c0232c.f ? f : f2 - c0232c.e;
            }
            C0232c c0232c2 = this.f25773a.get(i - 1);
            if (c0232c.f) {
                float f3 = c0232c.g;
                return f3 < c0232c2.g ? f3 - c0232c.e : c0232c.h - c0232c.e;
            }
            float f4 = c0232c.g;
            return f4 < c0232c2.g ? c0232c.h : f4;
        }

        public float b() {
            if (this.b >= this.f25773a.size()) {
                Log.e("AliyunTextLayout", "LineGlyphPositioner: glyph index out of range!");
                return 0.0f;
            }
            float fA = a();
            this.b++;
            return fA;
        }
    }

    public c(String str, TextPaint textPaint, float f, boolean z, int i, int i2, int i3, int i4) {
        this.c = 129;
        this.d = 1;
        this.l = 0.0f;
        this.b = z;
        if (str != null) {
            this.f25770a = str;
            this.c = i;
            this.d = i2;
            try {
                this.l = textPaint.getTextSize() * 0.05f;
                textPaint.measureText("X");
                a(textPaint, f, i3, i4);
            } catch (Exception e) {
                Log.e("AliyunTextLayout", "" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void a(TextPaint textPaint, float f, int i, int i2) {
        float f2;
        int iMin = i > 0 ? Math.min((int) Math.ceil(Layout.getDesiredWidth(this.f25770a, textPaint)), i) : (int) Math.ceil(Layout.getDesiredWidth(this.f25770a, textPaint));
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        if ((this.c & 4) != 0) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        }
        String str = this.f25770a;
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, iMin);
        builderObtain.setAlignment(alignment);
        builderObtain.setLineSpacing(f, 1.0f);
        builderObtain.setIncludePad(false);
        StaticLayout staticLayoutBuild = builderObtain.build();
        if (i2 > 0) {
            float height = staticLayoutBuild.getHeight();
            int i3 = this.c;
            if ((i3 & 64) != 0) {
                f2 = i2 - height;
            } else if ((i3 & 128) != 0) {
                f2 = (i2 - height) / 2.0f;
            }
            this.f = f2;
        }
        this.e = staticLayoutBuild;
    }

    private boolean a(String str, int i, int i2) {
        if (i2 == i + 1 && str.charAt(i) == ' ') {
            return false;
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != 8205 && cCharAt != 8204) {
                if (!Character.isHighSurrogate(cCharAt)) {
                    Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(cCharAt);
                    if (unicodeBlockOf != Character.UnicodeBlock.VARIATION_SELECTORS && unicodeBlockOf != Character.UnicodeBlock.ARROWS && unicodeBlockOf != Character.UnicodeBlock.BASIC_LATIN && unicodeBlockOf != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION && unicodeBlockOf != Character.UnicodeBlock.COMBINING_MARKS_FOR_SYMBOLS && unicodeBlockOf != Character.UnicodeBlock.DINGBATS && unicodeBlockOf != Character.UnicodeBlock.ENCLOSED_ALPHANUMERICS && unicodeBlockOf != Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS && unicodeBlockOf != Character.UnicodeBlock.GENERAL_PUNCTUATION && unicodeBlockOf != Character.UnicodeBlock.GEOMETRIC_SHAPES && unicodeBlockOf != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS && unicodeBlockOf != Character.UnicodeBlock.LATIN_1_SUPPLEMENT && unicodeBlockOf != Character.UnicodeBlock.LETTERLIKE_SYMBOLS && unicodeBlockOf != Character.UnicodeBlock.MISCELLANEOUS_TECHNICAL && unicodeBlockOf != Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS && unicodeBlockOf != Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_ARROWS && unicodeBlockOf != Character.UnicodeBlock.SUPPLEMENTAL_ARROWS_B) {
                        return false;
                    }
                } else {
                    if (i >= i2 - 1) {
                        return false;
                    }
                    i++;
                    char cCharAt2 = str.charAt(i);
                    if (!Character.isLowSurrogate(cCharAt2)) {
                        return false;
                    }
                    int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                    Character.UnicodeBlock unicodeBlockOf2 = Character.UnicodeBlock.of(codePoint);
                    if (unicodeBlockOf2 != Character.UnicodeBlock.VARIATION_SELECTORS_SUPPLEMENT && unicodeBlockOf2 != Character.UnicodeBlock.TAGS && ((codePoint < 128512 || codePoint > 128591) && ((codePoint < 127744 || codePoint > 128511) && ((codePoint < 129280 || codePoint > 129535) && ((codePoint < 128640 || codePoint > 128767) && ((codePoint < 126976 || codePoint > 127023) && ((codePoint < 127136 || codePoint > 127231) && ((codePoint < 127232 || codePoint > 127487) && ((codePoint < 127488 || codePoint > 127743) && ((codePoint < 128896 || codePoint > 129023) && (codePoint < 129648 || codePoint > 129791))))))))))) {
                        return false;
                    }
                }
            }
            i++;
        }
        return true;
    }

    private boolean b(String str, int i, int i2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= 1536 && cCharAt <= 1791) {
                return true;
            }
            i++;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x0434  */
    /* JADX WARN: Code duplicated, block: B:129:0x043b  */
    /* JADX WARN: Code duplicated, block: B:130:0x0440  */
    /* JADX WARN: Code duplicated, block: B:80:0x0354  */
    private void e() {
        int i;
        float f;
        float f2;
        float width;
        int i2;
        float f3;
        if (this.g) {
            return;
        }
        this.g = true;
        StaticLayout staticLayout = this.e;
        if (staticLayout != null) {
            Paint.FontMetrics fontMetrics = staticLayout.getPaint().getFontMetrics();
            float f4 = fontMetrics.ascent;
            float f5 = fontMetrics.descent;
            boolean z = (this.e.getPaint().getTypeface() != null && this.e.getPaint().getTypeface().isItalic()) || this.e.getPaint().getTextSkewX() != 0.0f;
            this.j = new RectF();
            int lineCount = this.e.getLineCount();
            this.i = new RectF[lineCount];
            this.h = new ArrayList<>();
            float fMax = 0.0f;
            int i3 = 0;
            int i4 = 0;
            while (i3 < lineCount) {
                this.i[i3] = new RectF();
                ArrayList<b> arrayList = new ArrayList<>();
                this.h.add(arrayList);
                int lineBaseline = this.e.getLineBaseline(i3);
                int lineStart = this.e.getLineStart(i3);
                int lineEnd = this.e.getLineEnd(i3);
                int i5 = lineEnd - lineStart;
                float[] fArr = new float[i5];
                int i6 = i4;
                if (this.e.getPaint().getTextWidths(this.f25770a, lineStart, lineEnd, fArr) != i5) {
                    Log.w("AliyunTextLayout", "Paint.getTextWidths() return unexpected value!");
                }
                ArrayList arrayList2 = new ArrayList();
                int i7 = lineStart;
                int i8 = i6;
                while (true) {
                    if (i7 >= lineEnd) {
                        i2 = lineCount;
                        f3 = fMax;
                        break;
                    }
                    i2 = lineCount;
                    int i9 = i7 + 1;
                    while (i9 < lineEnd && fArr[i9 - lineStart] == 0.0f) {
                        i9++;
                    }
                    int i10 = lineEnd;
                    f3 = fMax;
                    if (i9 - i7 == 1 && this.f25770a.charAt(i7) == '\n') {
                        break;
                    }
                    C0232c c0232c = new C0232c();
                    c0232c.f25772a = i8;
                    c0232c.b = this.f25770a.codePointAt(i7);
                    c0232c.c = i7;
                    c0232c.d = i9;
                    c0232c.e = fArr[i7 - lineStart];
                    c0232c.f = this.e.isRtlCharAt(i7);
                    c0232c.g = this.e.getPrimaryHorizontal(i7);
                    c0232c.h = this.e.getSecondaryHorizontal(i7);
                    arrayList2.add(c0232c);
                    i8++;
                    i7 = i9;
                    lineEnd = i10;
                    lineCount = i2;
                    fMax = f3;
                }
                int i11 = i8 + 1;
                d dVar = new d(arrayList2);
                int i12 = 0;
                while (i12 < arrayList2.size()) {
                    C0232c c0232c2 = (C0232c) arrayList2.get(i12);
                    int i13 = c0232c2.c;
                    ArrayList arrayList3 = arrayList2;
                    int i14 = c0232c2.d;
                    int i15 = i11;
                    b bVar = new b();
                    bVar.g = i13;
                    bVar.h = i14;
                    int i16 = i3;
                    bVar.d = false;
                    bVar.i = c0232c2.b;
                    bVar.e = b(this.f25770a, i13, i14);
                    float fB = dVar.b();
                    d dVar2 = dVar;
                    int i17 = lineBaseline;
                    bVar.f25771a = new PointF(fB, lineBaseline + this.f);
                    bVar.b = new RectF();
                    bVar.c = new RectF();
                    bVar.f = new Path();
                    TextPaint paint = this.e.getPaint();
                    String str = this.f25770a;
                    PointF pointF = bVar.f25771a;
                    int i18 = i12;
                    paint.getTextPath(str, i13, i14, pointF.x, pointF.y, bVar.f);
                    if (bVar.f.isEmpty()) {
                        if (a(this.f25770a, i13, i14)) {
                            bVar.d = true;
                        }
                        Rect rect = new Rect();
                        this.e.getPaint().getTextBounds(this.f25770a, i13, i14, rect);
                        bVar.b.set(rect);
                        RectF rectF = bVar.b;
                        PointF pointF2 = bVar.f25771a;
                        rectF.offset(pointF2.x, pointF2.y);
                        if (z && bVar.d) {
                            RectF rectF2 = bVar.b;
                            float f6 = rectF2.right;
                            rectF2.right = f6 + ((f6 - rectF2.left) * 0.1f);
                        }
                    } else if (bVar.e) {
                        float f7 = fArr[i13 - lineStart];
                        RectF rectF3 = bVar.b;
                        rectF3.left = fB;
                        float f8 = fB + f7;
                        rectF3.right = f8;
                        if (z) {
                            rectF3.right = f8 + ((int) (f7 * 0.3f));
                        }
                        float f9 = bVar.f25771a.y;
                        rectF3.top = fontMetrics.ascent + f9;
                        rectF3.bottom = f9 + fontMetrics.descent;
                    } else {
                        bVar.f.computeBounds(bVar.b, false);
                    }
                    bVar.c.set(bVar.b);
                    RectF rectF4 = bVar.c;
                    float f10 = bVar.f25771a.y;
                    rectF4.top = f10 + f4;
                    rectF4.bottom = f10 + f5;
                    arrayList.add(bVar);
                    i12 = i18 + 1;
                    arrayList2 = arrayList3;
                    i11 = i15;
                    i3 = i16;
                    dVar = dVar2;
                    lineBaseline = i17;
                }
                int i19 = i3;
                int i20 = i11;
                int i21 = lineBaseline;
                this.i[i19].left = this.e.getLineLeft(i19);
                this.i[i19].right = this.e.getLineRight(i19);
                this.i[i19].top = this.e.getLineTop(i19) + this.f;
                this.i[i19].bottom = this.e.getLineBottom(i19) + this.f;
                fMax = this.i[i19].isEmpty() ? f3 : Math.max(f3, this.i[i19].width());
                if (this.b && !arrayList.isEmpty()) {
                    RectF rectF5 = this.i[i19];
                    float f11 = rectF5.left;
                    float f12 = rectF5.right;
                    float f13 = i21 + f5 + this.f;
                    float f14 = this.l + f13;
                    b bVar2 = new b();
                    bVar2.f25771a = new PointF();
                    Path path = new Path();
                    bVar2.f = path;
                    path.moveTo(f11, f13);
                    bVar2.f.lineTo(f12, f13);
                    bVar2.f.lineTo(f12, f14);
                    bVar2.f.lineTo(f11, f14);
                    bVar2.f.lineTo(f11, f13);
                    bVar2.f.close();
                    RectF rectF6 = new RectF();
                    bVar2.b = rectF6;
                    bVar2.f.computeBounds(rectF6, true);
                    bVar2.c = new RectF(bVar2.b);
                    arrayList.add(bVar2);
                }
                i3 = i19 + 1;
                lineCount = i2;
                i4 = i20;
            }
            int i22 = lineCount;
            float f15 = fMax;
            if ((this.c & 3) != 0) {
                i = i22;
                for (int i23 = 0; i23 < i; i23++) {
                    if (!this.i[i23].isEmpty()) {
                        int paragraphDirection = this.e.getParagraphDirection(i23);
                        float lineRight = this.e.getLineRight(i23) - this.e.getLineLeft(i23);
                        int i24 = this.c;
                        if ((i24 & 1) != 0) {
                            if (paragraphDirection == -1) {
                                width = -(this.e.getWidth() - lineRight);
                            } else {
                                width = 0.0f;
                            }
                        } else if ((i24 & 2) == 0 || paragraphDirection != 1) {
                            width = 0.0f;
                        } else {
                            width = this.e.getWidth() - lineRight;
                        }
                        if (width != 0.0f) {
                            this.i[i23].offset(width, 0.0f);
                            for (b bVar3 : this.h.get(i23)) {
                                bVar3.f25771a.offset(width, 0.0f);
                                bVar3.b.offset(width, 0.0f);
                                Path path2 = bVar3.f;
                                if (path2 != null) {
                                    path2.offset(width, 0.0f);
                                }
                            }
                        }
                    }
                }
            } else {
                i = i22;
            }
            for (int i25 = 0; i25 < i; i25++) {
                if (this.j.isEmpty()) {
                    this.j.set(this.i[i25]);
                } else if (!this.i[i25].isEmpty()) {
                    this.j.union(this.i[i25]);
                }
            }
            if (this.b && !this.j.isEmpty()) {
                RectF rectF7 = this.j;
                float f16 = rectF7.top;
                float f17 = this.l;
                rectF7.top = f16 - f17;
                rectF7.bottom += f17;
            }
            RectF rectF8 = new RectF();
            this.k = rectF8;
            RectF rectF9 = this.j;
            rectF8.set(0.0f, 0.0f, rectF9.right + rectF9.left, rectF9.bottom + this.f);
            if ((this.c & 7) != this.d) {
                for (int i26 = 0; i26 < i; i26++) {
                    if (!this.i[i26].isEmpty()) {
                        float fWidth = this.i[i26].width();
                        int i27 = this.c;
                        if ((i27 & 1) != 0) {
                            int i28 = this.d;
                            if (i28 == 2) {
                                f = f15 - fWidth;
                                f2 = 0.0f;
                            } else {
                                if (i28 == 4) {
                                    f = (f15 - fWidth) / 2.0f;
                                } else {
                                    f = 0.0f;
                                }
                                f2 = 0.0f;
                            }
                        } else {
                            if ((i27 & 2) != 0) {
                                int i29 = this.d;
                                if (i29 == 1) {
                                    f = -(f15 - fWidth);
                                } else if (i29 == 4) {
                                    f = (-(f15 - fWidth)) / 2.0f;
                                } else {
                                    f = 0.0f;
                                }
                            } else {
                                int i30 = this.d;
                                if (i30 == 1) {
                                    f = (-(f15 - fWidth)) / 2.0f;
                                } else if (i30 == 2) {
                                    f = (f15 - fWidth) / 2.0f;
                                } else {
                                    f = 0.0f;
                                }
                            }
                            f2 = 0.0f;
                        }
                        if (f != f2) {
                            this.i[i26].offset(f, f2);
                            for (b bVar4 : this.h.get(i26)) {
                                bVar4.f25771a.offset(f, f2);
                                bVar4.b.offset(f, f2);
                                Path path3 = bVar4.f;
                                if (path3 != null) {
                                    path3.offset(f, f2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public int a(int i) {
        ArrayList<ArrayList<b>> arrayList;
        f();
        if (i < 0 || (arrayList = this.h) == null || i >= arrayList.size() || this.h.get(i) == null) {
            return 0;
        }
        return this.h.get(i).size();
    }

    public Layout a() {
        return this.e;
    }

    public b a(int i, int i2) {
        ArrayList<ArrayList<b>> arrayList;
        f();
        if (i < 0 || (arrayList = this.h) == null || i >= arrayList.size() || this.h.get(i) == null) {
            return null;
        }
        ArrayList<b> arrayList2 = this.h.get(i);
        if (i2 < 0 || i2 >= arrayList2.size()) {
            return null;
        }
        return arrayList2.get(i2);
    }

    public RectF b() {
        f();
        RectF rectF = this.k;
        return rectF != null ? rectF : new RectF();
    }

    public int c() {
        f();
        ArrayList<ArrayList<b>> arrayList = this.h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public String d() {
        return this.f25770a;
    }

    public void f() {
        try {
            e();
        } catch (Exception e) {
            Log.e("AliyunTextLayout", "" + e.getMessage());
            e.printStackTrace();
        }
    }
}
