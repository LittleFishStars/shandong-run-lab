package com.aliyun.svideosdk.editor.e;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.Layout;
import android.util.Log;
import com.aliyun.svideosdk.common.struct.effect.EffectCaption;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.editor.NativeEditor;
import com.aliyun.svideosdk.editor.impl.text.TextBitmap;
import com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator;
import com.aliyun.svideosdk.nativerender.BitmapGenerator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class d implements BitmapGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeEditor f25715a;
    private int b;
    private int c;
    private com.aliyun.svideosdk.editor.e.b d;
    private EffectCaption e;
    private TextBitmapGenerator f;
    private TextBitmap g;
    private c h;
    private com.aliyun.svideosdk.editor.e.c i;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f25716a;
        public float b;
        public float c;
        public float d;
        public float e;

        private b() {
        }

        public String toString() {
            return "PasterParam{x=" + this.f25716a + ", y=" + this.b + ", w=" + this.c + ", h=" + this.d + ", r=" + this.e + '}';
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25717a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public String toString() {
            return "TextSizeSpec{textSize=" + this.f25717a + ", centerX=" + this.b + ", centerY=" + this.c + ", width=" + this.d + ", height=" + this.e + ", textWidth=" + this.f + ", textHeight=" + this.g + '}';
        }
    }

    public d(NativeEditor nativeEditor, com.aliyun.svideosdk.editor.e.b bVar, int i, int i2, c cVar, com.aliyun.svideosdk.editor.e.c cVar2) {
        this.f25715a = nativeEditor;
        this.d = bVar;
        this.b = i;
        this.c = i2;
        this.h = cVar;
        this.i = cVar2;
        Log.d("RollCaptionView", "Create RollCaptionView. captionInfo:" + bVar + ", textSizeSpec:" + cVar + ", captionStyle:" + cVar2);
    }

    private b a(EffectPaster effectPaster) {
        float xRatio;
        float yRatio;
        float widthRatio;
        float heightRatio;
        int i;
        b bVar = new b();
        int i2 = effectPaster.width;
        int i3 = effectPaster.height;
        float f = effectPaster.x;
        int i4 = this.b;
        if (i4 <= 0 || (i = this.c) <= 0) {
            xRatio = effectPaster.getXRatio();
            yRatio = effectPaster.getYRatio();
            widthRatio = effectPaster.getWidthRatio();
            heightRatio = effectPaster.getHeightRatio();
        } else {
            float f2 = i4;
            xRatio = f / f2;
            float f3 = i;
            yRatio = f / f3;
            widthRatio = i2 / f2;
            heightRatio = i3 / f3;
            effectPaster.setXRatio(xRatio);
            effectPaster.setYRatio(yRatio);
            effectPaster.setWidthRatio(widthRatio);
            effectPaster.setHeightRatio(heightRatio);
        }
        bVar.f25716a = xRatio;
        bVar.b = yRatio;
        bVar.c = widthRatio;
        bVar.d = heightRatio;
        bVar.e = -effectPaster.rotation;
        Log.d("RollCaptionView", "generatePasterParams params:" + bVar);
        return bVar;
    }

    private boolean a(BitmapGenerator bitmapGenerator, EffectCaption effectCaption) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = effectCaption.end - effectCaption.start;
        b bVarA = a(effectCaption);
        int iAddRollCaptionItemView = this.f25715a.addRollCaptionItemView(bitmapGenerator, bVarA.f25716a, bVarA.b, bVarA.c, bVarA.d, bVarA.e, this.b, this.c, effectCaption.start, j);
        if (iAddRollCaptionItemView <= 0 || iAddRollCaptionItemView > 268435456) {
            Log.w("RollCaptionView", "addCaptionPaster FAILED. native invoke ret " + iAddRollCaptionItemView);
            return false;
        }
        effectCaption.setViewId(iAddRollCaptionItemView);
        Log.d("RollCaptionView", "applyDisplay attach success., cost:" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ", vid:" + iAddRollCaptionItemView + ", start:" + effectCaption.start + ", end:" + effectCaption.end + ", duration:" + j + ", PasterParam:" + bVarA);
        return true;
    }

    private EffectCaption b() {
        EffectCaption effectCaption = new EffectCaption(new Source());
        effectCaption.start = this.d.a() * 1000;
        effectCaption.end = this.f25715a.getDuration();
        a(effectCaption, this.h);
        return effectCaption;
    }

    public void a(EffectCaption effectCaption, c cVar) {
        effectCaption.textColor = this.i.c();
        effectCaption.textStrokeColor = this.i.f();
        effectCaption.text = this.d.b();
        effectCaption.font = this.i.a();
        effectCaption.fontSource = this.i.b();
        effectCaption.hasStroke = this.i.f() != 0;
        effectCaption.textWidth = cVar.f;
        effectCaption.textHeight = cVar.g;
        effectCaption.width = cVar.d;
        effectCaption.height = cVar.e;
        effectCaption.mTextSize = cVar.f25717a;
        effectCaption.mTextMaxLines = 1;
        effectCaption.x = cVar.b;
        effectCaption.y = cVar.c;
        effectCaption.rotation = 0.0f;
    }

    public boolean a() {
        EffectCaption effectCaptionB = b();
        this.e = effectCaptionB;
        boolean zA = a(this, effectCaptionB);
        if (!zA) {
            this.e = null;
        }
        return zA;
    }

    @Override // com.aliyun.svideosdk.nativerender.BitmapGenerator
    public Bitmap generateBitmap(int i, int i2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f == null) {
            this.g = new TextBitmap();
            this.f = new TextBitmapGenerator();
        }
        EffectCaption effectCaption = this.e;
        TextBitmap textBitmap = this.g;
        textBitmap.mText = effectCaption.text;
        textBitmap.mFontPath = effectCaption.getFontPath();
        TextBitmap textBitmap2 = this.g;
        textBitmap2.mBmpWidth = i;
        textBitmap2.mBmpHeight = i2;
        textBitmap2.mTextWidth = effectCaption.textWidth;
        textBitmap2.mTextHeight = effectCaption.textHeight;
        textBitmap2.mTextColor = effectCaption.textColor;
        textBitmap2.mTextStrokeColor = effectCaption.textStrokeColor;
        Layout.Alignment alignment = Layout.Alignment.ALIGN_CENTER;
        textBitmap2.mBackgroundColor = effectCaption.textLabelColor;
        textBitmap2.mBackgroundBmp = effectCaption.mBackgroundBmp;
        textBitmap2.mTextSize = effectCaption.mTextSize;
        textBitmap2.mTextPaddingX = effectCaption.mTextPaddingX;
        textBitmap2.mTextPaddingY = effectCaption.mTextPaddingY;
        textBitmap2.mTextAlignment = effectCaption.mTextAlignment;
        textBitmap2.mMaxLines = effectCaption.mTextMaxLines;
        this.f.updateTextBitmap(textBitmap2);
        Bitmap bitmapGenerateBitmap = this.f.generateBitmap(i, i2);
        Log.d("RollCaptionView", "generateBitmap cost:" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ", CaptionInfo:" + this.d);
        return bitmapGenerateBitmap;
    }
}
