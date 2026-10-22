package com.aliyun.svideosdk.editor.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextUtils;
import android.util.SparseArray;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.AliyunCaption;
import com.aliyun.svideosdk.common.struct.CanvasInfo;
import com.aliyun.svideosdk.common.struct.effect.EffectCaption;
import com.aliyun.svideosdk.common.struct.effect.EffectFilter;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaint;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.effect.EffectText;
import com.aliyun.svideosdk.common.struct.effect.TrackEffect;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.common.struct.project.AliyunEditorProject;
import com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack;
import com.aliyun.svideosdk.common.struct.project.CaptionTrack;
import com.aliyun.svideosdk.common.struct.project.DynamicImage;
import com.aliyun.svideosdk.common.struct.project.EffectTrack;
import com.aliyun.svideosdk.common.struct.project.Filter;
import com.aliyun.svideosdk.common.struct.project.GifPasterTrack;
import com.aliyun.svideosdk.common.struct.project.PaintTrack;
import com.aliyun.svideosdk.common.struct.project.PasterTrack;
import com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.common.struct.project.SubTitleTrack;
import com.aliyun.svideosdk.editor.AliyunPasterRender;
import com.aliyun.svideosdk.editor.NativeEditor;
import com.aliyun.svideosdk.editor.OnPasterResumeAndSave;
import com.aliyun.svideosdk.nativerender.BitmapGenerator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class o implements AliyunPasterRender {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.aliyun.svideosdk.editor.b f25753a;
    private com.aliyun.common.f.b b;
    private AliyunEditorProject c;
    private Size i;
    private int j;
    private int k;
    private OnPasterResumeAndSave l;
    private com.aliyun.common.c.b.b m;
    private File n;
    private m d = new m();

    @Deprecated
    private u<a> f = new u<>(new SparseArray());

    @Deprecated
    private u<Bitmap> g = new u<>(new SparseArray());
    private u<EffectFilter> e = new u<>(new SparseArray());

    @Deprecated
    private u<BitmapGenerator> h = new u<>(new SparseArray());

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25754a = -1;
        int b = -1;

        public a(o oVar) {
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f25755a;
        public float b;
        public float c;
        public float d;
        public float e;

        public b(o oVar) {
        }
    }

    public o(com.aliyun.svideosdk.editor.b bVar, com.aliyun.common.c.b.b bVar2, AliyunEditorProject aliyunEditorProject, com.aliyun.common.f.b bVar3) {
        this.n = null;
        this.n = com.aliyun.common.utils.a.a().getExternalCacheDir();
        this.f25753a = bVar;
        this.b = bVar3;
        this.m = bVar2;
        this.c = aliyunEditorProject;
    }

    private int a(EffectImage effectImage) {
        Bitmap bitmap = effectImage.getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            return this.f25753a.addImgView(effectImage.getPath(), effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation(), 0L, 2147483647L, false, 0L, com.aliyun.svideosdk.editor.d.VIEW_TYPE_WATERMARK.a());
        }
        Bitmap bitmapA = a(effectImage.getPath());
        if (bitmapA == null) {
            return -20003013;
        }
        return this.f25753a.addImgView(bitmapA, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation(), 0L, 2147483647L, false, 0L, com.aliyun.svideosdk.editor.d.VIEW_TYPE_WATERMARK.a());
    }

    private Bitmap a(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return BitmapFactory.decodeFile(str);
        }
        return null;
    }

    private b a(EffectCaption effectCaption) {
        b bVar = new b(this);
        if (this.i.getWidth() <= 0 || this.i.getHeight() <= 0) {
            bVar.f25755a = effectCaption.getXRatio();
            bVar.b = effectCaption.getYRatio();
            bVar.c = effectCaption.getWidthRatio();
            bVar.d = effectCaption.getHeightRatio();
        } else {
            int i = effectCaption.textWidth;
            int i2 = effectCaption.textHeight;
            int i3 = effectCaption.textCenterY;
            int i4 = effectCaption.textCenterX;
            if (effectCaption.mirror) {
                int i5 = i / 2;
                i4 = ((effectCaption.width - i4) - i5) + i5;
            }
            float f = i4 + ((int) (effectCaption.x - (effectCaption.width / 2)));
            float f2 = i3 + ((int) (effectCaption.y - (effectCaption.height / 2)));
            Matrix matrix = new Matrix();
            matrix.setRotate((float) Math.toDegrees(effectCaption.rotation), effectCaption.x, effectCaption.y);
            float[] fArr = new float[2];
            matrix.mapPoints(fArr, 0, new float[]{f, f2}, 0, 1);
            float f3 = fArr[0];
            float f4 = fArr[1];
            float width = f3 / this.i.getWidth();
            float height = f4 / this.i.getHeight();
            bVar.f25755a = width;
            bVar.b = height;
            bVar.c = i / this.i.getWidth();
            bVar.d = i2 / this.i.getHeight();
            effectCaption.setXRatio(width);
            effectCaption.setYRatio(height);
            effectCaption.setWidthRatio(bVar.c);
            effectCaption.setHeightRatio(bVar.d);
        }
        float f5 = effectCaption.rotation;
        boolean z = effectCaption.mirror;
        float f6 = effectCaption.textRotation;
        if (z) {
            f6 = -f6;
        }
        bVar.e = -(f5 + f6);
        return bVar;
    }

    private void a(int i) {
        Bitmap bitmapB = this.g.b(i);
        if (bitmapB != null) {
            bitmapB.recycle();
            this.g.a(i);
        }
    }

    private void a(Bitmap bitmap, EffectText effectText) {
        if (effectText.needSaveBmp) {
            if (!TextUtils.isEmpty(effectText.mBackgroundBmpPath)) {
                File file = new File(effectText.mBackgroundBmpPath);
                if (file.exists()) {
                    file.delete();
                }
            }
            String strGenerateTextFinger = effectText.generateTextFinger();
            if (effectText.mBackgroundBmp != null) {
                File file2 = new File(this.n, strGenerateTextFinger + "_background");
                try {
                    if (!com.aliyun.common.utils.d.a(effectText.mBackgroundBmp, file2.getAbsolutePath(), "image/png")) {
                        com.aliyun.common.c.a.a.b("AliYunLog", "Text background image backup failed!");
                    }
                    effectText.mBackgroundBmpPath = file2.getAbsolutePath();
                } catch (IOException e) {
                    com.aliyun.common.c.a.a.b("AliYunLog", "Text background image backup failed!" + e.getMessage());
                }
            }
            if (bitmap == null) {
                return;
            }
            File file3 = new File(this.n, strGenerateTextFinger);
            String str = effectText.textBmpPath;
            if (TextUtils.equals(file3.getPath(), str)) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                File file4 = new File(str);
                if (file4.exists()) {
                    file4.delete();
                }
            }
            if (file3.exists()) {
                file3.delete();
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file3));
                effectText.textBmpPath = file3.getPath();
            } catch (IOException unused) {
            }
        }
    }

    private PhotoPasterTrack b(EffectPaster effectPaster) {
        PhotoPasterTrack bubbleCaptionTrack;
        if (effectPaster.getPasterType() == 0) {
            bubbleCaptionTrack = new GifPasterTrack();
        } else if (effectPaster.getPasterType() == 1) {
            bubbleCaptionTrack = new SubTitleTrack();
        } else {
            bubbleCaptionTrack = effectPaster.getPasterType() == 2 ? new BubbleCaptionTrack() : null;
        }
        if (bubbleCaptionTrack != null) {
            this.d.a(effectPaster, bubbleCaptionTrack);
        }
        return bubbleCaptionTrack;
    }

    private void b(EffectCaption effectCaption) {
        long j = effectCaption.end;
        long j2 = effectCaption.start;
        long j3 = j - j2;
        long j4 = effectCaption.duration;
        if (j3 >= j4 - 100000) {
            long j5 = effectCaption.preBegin;
            long j6 = (((j3 - j5) - (j4 - effectCaption.preEnd)) + j5) - j5;
            long j7 = j5 + j2;
            effectCaption.textBegin = j7;
            j = j7 + j6;
        } else {
            effectCaption.textBegin = j2;
        }
        effectCaption.textEnd = j;
    }

    public int a(int i, TransitionBase transitionBase) {
        if (transitionBase == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "TransitionCustom  object is null");
            return -20001005;
        }
        String jsonString = transitionBase.toJsonString();
        com.aliyun.common.c.a.a.a("AliYunLog", "updateTransition  params : " + jsonString);
        int iUpdateTransition = this.f25753a.updateTransition(i, jsonString);
        this.c.updateTransition(i, transitionBase);
        return iUpdateTransition;
    }

    public int a(EffectPaint effectPaint) {
        return this.f25753a.addImgView(effectPaint.getPath(), 0.5f, 0.5f, 1.0f, 1.0f, 0.0f, 0L, 2147483647L, false, 0L, com.aliyun.svideosdk.editor.d.VIEW_TYPE_GRAFFITI.a());
    }

    public int a(TrackEffect<EffectFilter> trackEffect) {
        if (trackEffect == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "animation filter object is null");
            return -20001005;
        }
        if (trackEffect.getSource() == null || com.aliyun.common.utils.q.b(trackEffect.getSource().getPath())) {
            return -20001005;
        }
        int iC = this.e.c();
        long startTime = trackEffect.getStartTime();
        if (startTime < 0) {
            com.aliyun.common.c.a.a.d("AliYunLog", "Invalid animation filter startTime " + startTime + ",auto change to 0");
            trackEffect.setStartTime(0L, TimeUnit.MICROSECONDS);
        }
        long duration = trackEffect.getDuration();
        if (duration < 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid animation filter duration" + duration);
            return -20003002;
        }
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.a(trackEffect);
        }
        EffectFilter effectFilter = (EffectFilter) trackEffect.getBean();
        for (int i = 0; i < iC; i++) {
            if (effectFilter.equals(this.e.f(i))) {
                ((NativeEditor) this.f25753a).deleteAnimationFilter(this.e.d(i));
                this.e.e(i);
                break;
            }
        }
        String jsonString = effectFilter.toJsonString();
        int iAddAnimationEff = this.f25753a.addAnimationEff(effectFilter.getPath(), trackEffect.getStartTime() * 1000, 1000 * trackEffect.getDuration(), jsonString);
        com.aliyun.common.c.a.a.a("AliYunLog", "addAnimationFilter  params : " + jsonString);
        trackEffect.setViewId(iAddAnimationEff);
        this.e.a(iAddAnimationEff, effectFilter);
        Filter filter = new Filter(effectFilter.getSource());
        filter.setType(EffectTrack.Type.animation_filter);
        filter.setTimelineIn(trackEffect.getStartTime() / 1000.0f);
        filter.setTimelineOut(filter.getTimelineIn() + (trackEffect.getDuration() / 1000.0f));
        filter.setId(effectFilter.getViewId());
        filter.setEffectConfig(effectFilter.getEffectConfig());
        this.c.addAnimationFilter(filter);
        com.aliyun.common.c.a.a.a("AliYunLog", "after add, mAnimationFilters.size " + this.e.c());
        return iAddAnimationEff;
    }

    public b a(EffectPaster effectPaster) {
        float xRatio;
        float yRatio;
        float widthRatio;
        float heightRatio;
        b bVar = new b(this);
        int i = effectPaster.width;
        int i2 = effectPaster.height;
        float f = effectPaster.y;
        float f2 = effectPaster.x;
        if (this.i.getWidth() <= 0 || this.i.getHeight() <= 0) {
            xRatio = effectPaster.getXRatio();
            yRatio = effectPaster.getYRatio();
            widthRatio = effectPaster.getWidthRatio();
            heightRatio = effectPaster.getHeightRatio();
        } else {
            xRatio = f2 / this.i.getWidth();
            yRatio = f / this.i.getHeight();
            widthRatio = i / this.i.getWidth();
            heightRatio = i2 / this.i.getHeight();
            effectPaster.setXRatio(xRatio);
            effectPaster.setYRatio(yRatio);
            effectPaster.setWidthRatio(widthRatio);
            effectPaster.setHeightRatio(heightRatio);
        }
        bVar.f25755a = xRatio;
        bVar.b = yRatio;
        bVar.c = widthRatio;
        bVar.d = heightRatio;
        bVar.e = -effectPaster.rotation;
        return bVar;
    }

    public void a() {
        if (this.e.c() > 0) {
            int iC = this.e.c();
            for (int i = 0; i < iC; i++) {
                ((NativeEditor) this.f25753a).deleteAnimationFilter(this.e.d(i));
            }
        }
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.f();
        }
        this.e.a();
        this.c.clearAnimationFilters();
    }

    public void a(File file) {
        this.n = file;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addCaption(AliyunCaption aliyunCaption) {
        if (aliyunCaption.isNativeRelease()) {
            return -4;
        }
        int iAddCaption = this.f25753a.addCaption(aliyunCaption);
        if (iAddCaption != 0) {
            aliyunCaption.releaseNativeHandle();
        } else {
            this.c.addPasterTrack(CaptionTrack.fromCaption(aliyunCaption));
        }
        return iAddCaption;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addCaptionPaster(Bitmap bitmap, EffectCaption effectCaption) {
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.a(effectCaption);
        }
        a(bitmap, effectCaption);
        b bVarA = a((EffectPaster) effectCaption);
        int iAddGifView = this.f25753a.addGifView(effectCaption.getSource().getPath(), bVarA.f25755a, bVarA.b, bVarA.c, bVarA.d, bVarA.e, effectCaption.mirror, effectCaption.start, effectCaption.end - effectCaption.start, true);
        if (iAddGifView <= 0 || iAddGifView > 268435456) {
            return iAddGifView;
        }
        effectCaption.gifViewId = iAddGifView;
        a aVar = new a(this);
        aVar.b = iAddGifView;
        b(effectCaption);
        long j = effectCaption.textBegin;
        long j2 = effectCaption.textEnd - j;
        b bVarA2 = a(effectCaption);
        int iAddImgView = this.f25753a.addImgView(bitmap, bVarA2.f25755a, bVarA2.b, bVarA2.c, bVarA2.d, bVarA2.e, j, j2, true, effectCaption.textBegin - effectCaption.start, com.aliyun.svideosdk.editor.d.VIEW_TYPE_TEXT.a());
        if (iAddImgView <= 0) {
            return iAddImgView;
        }
        aVar.f25754a = iAddImgView;
        effectCaption.setViewId(iAddImgView);
        this.c.addPasterTrack(b((EffectPaster) effectCaption));
        this.f.a(iAddImgView, aVar);
        this.g.a(iAddImgView, bitmap);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addCaptionPaster(BitmapGenerator bitmapGenerator, EffectCaption effectCaption) {
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.b(effectCaption);
        }
        b bVarA = a((EffectPaster) effectCaption);
        long j = effectCaption.end - effectCaption.start;
        a aVar = new a(this);
        b(effectCaption);
        long j2 = effectCaption.textBegin;
        long j3 = effectCaption.textEnd - j2;
        b bVarA2 = a(effectCaption);
        int iAddGifTextView = this.f25753a.addGifTextView(effectCaption.getSource().getPath(), bVarA.f25755a, bVarA.b, bVarA.c, bVarA.d, bVarA.e, effectCaption.mirror, effectCaption.start, j, true, bitmapGenerator, bVarA2.f25755a, bVarA2.b, bVarA2.c, bVarA2.d, bVarA2.e, this.i.getWidth(), this.i.getHeight(), j2, j3, true, effectCaption.textBegin - effectCaption.start);
        if (iAddGifTextView <= 0) {
            return iAddGifTextView;
        }
        aVar.f25754a = iAddGifTextView;
        effectCaption.setViewId(iAddGifTextView);
        this.c.addPasterTrack(b((EffectPaster) effectCaption));
        this.f.a(iAddGifTextView, aVar);
        this.h.a(iAddGifTextView, bitmapGenerator);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addEffectPaster(EffectPaster effectPaster) {
        if (effectPaster == null || effectPaster.getPath() == null || !new File(effectPaster.getPath()).exists()) {
            return -20003011;
        }
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.a(effectPaster);
        }
        long j = effectPaster.end - effectPaster.start;
        b bVarA = a(effectPaster);
        int iAddGifView = this.f25753a.addGifView(effectPaster.getPath(), bVarA.f25755a, bVarA.b, bVarA.c, bVarA.d, bVarA.e, effectPaster.mirror, effectPaster.start, j, false);
        if (iAddGifView <= 0 || iAddGifView > 268435456) {
            return iAddGifView;
        }
        effectPaster.setViewId(iAddGifView);
        this.c.addPasterTrack(b(effectPaster));
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addSubtitle(Bitmap bitmap, EffectText effectText) {
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.a(effectText);
        }
        a(bitmap, effectText);
        long j = effectText.end - effectText.start;
        b bVarA = a(effectText);
        int iAddImgView = this.f25753a.addImgView(bitmap, bVarA.f25755a, bVarA.b, bVarA.c, bVarA.d, bVarA.e, effectText.start, j, true, 0L, com.aliyun.svideosdk.editor.d.VIEW_TYPE_TEXT.a());
        if (iAddImgView <= 0 || iAddImgView > 268435456) {
            return iAddImgView;
        }
        effectText.setViewId(iAddImgView);
        this.c.addPasterTrack(b(effectText));
        this.g.a(iAddImgView, bitmap);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int addSubtitle(BitmapGenerator bitmapGenerator, EffectText effectText) {
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.b(effectText);
        }
        a((Bitmap) null, effectText);
        long j = effectText.end - effectText.start;
        b bVarA = a(effectText);
        int iAddImgView = this.f25753a.addImgView(bitmapGenerator, bVarA.f25755a, bVarA.b, bVarA.c, bVarA.d, bVarA.e, this.i.getWidth(), this.i.getHeight(), effectText.start, j, true, 0L);
        if (iAddImgView <= 0 || iAddImgView > 268435456) {
            return iAddImgView;
        }
        effectText.setViewId(iAddImgView);
        this.c.addPasterTrack(b(effectText));
        this.h.a(iAddImgView, bitmapGenerator);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public synchronized int applyPaintCanvas(EffectPaint effectPaint) {
        if (effectPaint != null) {
            if (effectPaint.getPath() != null) {
                File file = new File(effectPaint.getPath());
                if (!file.exists()) {
                    com.aliyun.common.c.a.a.b("AliYunLog", "Paint canvas image file not exist, path:" + file.getAbsolutePath());
                    return -20003013;
                }
                int i = this.k;
                if (i != 0) {
                    this.f25753a.deleteView(i, com.aliyun.svideosdk.editor.d.VIEW_TYPE_GRAFFITI.a());
                }
                int iA = a(effectPaint);
                if (iA < 0) {
                    return iA;
                }
                effectPaint.setViewId(iA);
                PaintTrack paintTrack = new PaintTrack();
                paintTrack.setSource(new Source(effectPaint.getPath()));
                CanvasInfo canvasInfo = effectPaint.getCanvasInfo();
                if (canvasInfo != null) {
                    paintTrack.setCanvasInfo(canvasInfo.convertCoordinate(getDisplaySize().getWidth(), getDisplaySize().getHeight(), false));
                }
                paintTrack.setTimelineIn(0.0f);
                paintTrack.setTimelineOut(2.1474836E9f);
                paintTrack.setId(iA);
                this.c.setCanvasTrack(paintTrack);
                this.k = iA;
                return 0;
            }
        }
        com.aliyun.common.c.a.a.b("AliYunLog", "Invalid effect paint object");
        return -20001005;
    }

    public int b(TrackEffect<EffectImage> trackEffect) {
        if (this.c.getPasterTrackByID(trackEffect.getViewId()) != null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Duplicated add image");
            return 1073754181;
        }
        EffectImage effectImage = (EffectImage) trackEffect.getBean();
        Bitmap bitmap = effectImage.getBitmap();
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = a(effectImage.getPath());
        }
        Bitmap bitmap2 = bitmap;
        if (bitmap2 == null) {
            return -20003013;
        }
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.b(trackEffect);
        }
        int iAddImgView = this.f25753a.addImgView(bitmap2, effectImage.getXRadio(), effectImage.getYRadio(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getRotation(), trackEffect.getStartTime() * 1000, 1000 * trackEffect.getDuration(), false, 0L, com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER.a());
        if (iAddImgView <= 0) {
            return iAddImgView;
        }
        effectImage.setViewId(iAddImgView);
        PhotoPasterTrack photoPasterTrack = new PhotoPasterTrack();
        photoPasterTrack.setId(iAddImgView);
        photoPasterTrack.setX(effectImage.getXRadio());
        photoPasterTrack.setY(effectImage.getYRadio());
        photoPasterTrack.setWidth(effectImage.getWidthRatio());
        photoPasterTrack.setHeight(effectImage.getHeightRatio());
        photoPasterTrack.setRotation(effectImage.getRotation());
        photoPasterTrack.setMirror(false);
        photoPasterTrack.setTimelineIn(trackEffect.getStartTime() / 1000.0f);
        photoPasterTrack.setTimelineOut(trackEffect.getEndTime() / 1000.0f);
        photoPasterTrack.setSource(effectImage.getSource());
        this.c.addPasterTrack(photoPasterTrack);
        return iAddImgView;
    }

    public void b() {
        this.e.a();
        this.f.a();
        this.g.a();
        this.h.a();
    }

    public void c() {
        if (this.c.getCanvasTrack() == null || !new File(this.c.getCanvasTrack().getSource().getPath()).exists()) {
            return;
        }
        EffectPaint effectPaint = new EffectPaint();
        effectPaint.setPath(this.c.getCanvasTrack().getSource().getPath());
        CanvasInfo canvasInfo = this.c.getCanvasTrack().getCanvasInfo();
        if (canvasInfo != null) {
            effectPaint.setCanvasInfo(canvasInfo.convertCoordinate(this.i.getWidth(), this.i.getHeight(), true));
        }
        applyPaintCanvas(effectPaint);
    }

    public void c(TrackEffect<EffectFilter> trackEffect) {
        int iA = this.e.a((EffectFilter) trackEffect.getBean());
        if (iA < 0) {
            return;
        }
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.c(trackEffect);
        }
        int iD = this.e.d(iA);
        ((NativeEditor) this.f25753a).deleteAnimationFilter(iD);
        this.e.e(iA);
        this.c.removeAnimationFilter(iD);
    }

    public void d() {
        if (this.l != null) {
            boolean z = this.c.getVersion() == 0;
            for (PasterTrack pasterTrack : this.c.getTimeline().getPasterTracks()) {
                try {
                    if (pasterTrack.getType() == PasterTrack.Type.gif) {
                        GifPasterTrack gifPasterTrack = (GifPasterTrack) pasterTrack;
                        DynamicImage dynamicImage = (DynamicImage) this.b.b(gifPasterTrack.getSource().getPath(), DynamicImage.class);
                        gifPasterTrack.setFrameArray(dynamicImage.frameArry);
                        gifPasterTrack.setTimeArray(dynamicImage.timeArry);
                        gifPasterTrack.setName(dynamicImage.n);
                        if (z) {
                            gifPasterTrack.setX(gifPasterTrack.getX() / m.d);
                            gifPasterTrack.setY(gifPasterTrack.getY() / m.d);
                            gifPasterTrack.setWidth(gifPasterTrack.getWidth() / this.i.getWidth());
                            gifPasterTrack.setHeight(gifPasterTrack.getHeight() / this.i.getHeight());
                        }
                    } else if (pasterTrack.getType() == PasterTrack.Type.subtitle || pasterTrack.getType() == PasterTrack.Type.bubble_caption) {
                        SubTitleTrack subTitleTrack = (SubTitleTrack) pasterTrack;
                        if (subTitleTrack.getTextSize() == 0.0f) {
                            String text = subTitleTrack.getText();
                            Rect rect = new Rect();
                            Paint paint = new Paint();
                            paint.setAntiAlias(true);
                            paint.setStrokeWidth(1.0f);
                            paint.setTextAlign(Paint.Align.CENTER);
                            paint.setTextSize(48.0f);
                            paint.getTextBounds(text, 0, text.length(), rect);
                            subTitleTrack.setTextWidth((rect.width() * 1.0f) / this.i.getWidth());
                            subTitleTrack.setTextHeight((rect.height() * 1.0f) / this.i.getWidth());
                            subTitleTrack.setTextSize(48.0f / this.i.getWidth());
                            subTitleTrack.setTextAlignment(Layout.Alignment.ALIGN_CENTER.ordinal());
                        }
                        if (z) {
                            subTitleTrack.setX(subTitleTrack.getX() / m.d);
                            subTitleTrack.setY(subTitleTrack.getY() / m.d);
                            subTitleTrack.setWidth(subTitleTrack.getWidth() / this.i.getWidth());
                            subTitleTrack.setHeight(subTitleTrack.getHeight() / this.i.getHeight());
                            subTitleTrack.setTextWidth(subTitleTrack.getTextWidth() / this.i.getWidth());
                            subTitleTrack.setTextHeight(subTitleTrack.getTextHeight() / this.i.getHeight());
                        }
                        if (subTitleTrack.getSource() != null) {
                            DynamicImage dynamicImage2 = (DynamicImage) this.b.b(subTitleTrack.getSource().getPath(), DynamicImage.class);
                            subTitleTrack.setFrameArray(dynamicImage2.frameArry);
                            subTitleTrack.setTimeArray(dynamicImage2.timeArry);
                            subTitleTrack.setName(dynamicImage2.n);
                            subTitleTrack.setTextRotation((float) Math.toRadians(dynamicImage2.tAngle));
                            subTitleTrack.setPreBegin((long) (dynamicImage2.tBegin * 1000000.0f));
                            subTitleTrack.setPreEnd((long) (dynamicImage2.tEnd * 1000000.0f));
                            if (z && pasterTrack.getType() == PasterTrack.Type.bubble_caption) {
                                ((BubbleCaptionTrack) subTitleTrack).setTextCenterX(((BubbleCaptionTrack) subTitleTrack).getTextCenterX() / this.i.getWidth());
                                ((BubbleCaptionTrack) subTitleTrack).setTextCenterY(((BubbleCaptionTrack) subTitleTrack).getTextCenterY() / this.i.getHeight());
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (z) {
                this.c.setVersion(1);
            }
            ArrayList arrayList = new ArrayList(this.c.getTimeline().getPasterTracks());
            this.c.getTimeline().getPasterTracks().clear();
            this.l.onPasterResume(arrayList);
        }
    }

    public void d(TrackEffect<EffectImage> trackEffect) {
        if (this.c.getPasterTrackByID(trackEffect.getViewId()) != null) {
            this.f25753a.deleteView(trackEffect.getViewId(), com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER.a());
            this.c.removePasterTrack(trackEffect.getViewId());
        }
    }

    public int e(TrackEffect<EffectFilter> trackEffect) {
        if (trackEffect == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "animation filter object is null");
            return -20001005;
        }
        EffectFilter effectFilter = (EffectFilter) trackEffect.getBean();
        String jsonString = effectFilter.toJsonString();
        com.aliyun.common.c.a.a.a("AliYunLog", "updateAnimationFilter  params : " + jsonString);
        int iUpdateAnimationEff = this.f25753a.updateAnimationEff(effectFilter.getViewId(), trackEffect.getStartTime() * 1000, 1000 * trackEffect.getDuration(), jsonString);
        this.c.updateAnimationFilter(effectFilter);
        return iUpdateAnimationEff;
    }

    public void e() {
        AliyunEditorProject aliyunEditorProject = this.c;
        if (aliyunEditorProject == null) {
            return;
        }
        for (PasterTrack pasterTrack : aliyunEditorProject.getTimeline().getPasterTracks()) {
            if (pasterTrack instanceof CaptionTrack) {
                ((CaptionTrack) pasterTrack).updateInfo();
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public List<AliyunCaption> findCaptions(long j) {
        return this.f25753a.findCaptions(j);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public Size getDisplaySize() {
        return this.i;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int hidePaster(EffectPaster effectPaster) {
        PasterTrack pasterTrackByID = this.c.getPasterTrackByID(effectPaster.getViewId());
        if (pasterTrackByID == null) {
            com.aliyun.common.c.a.a.b("AliyunPasterRenderImpl", "Not find effect paster:" + effectPaster);
            return -20003002;
        }
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.b(effectPaster);
        }
        int id = pasterTrackByID.getId();
        int iC = this.f.c(id);
        if (iC < 0) {
            return this.f25753a.deleteView(id, com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER.a());
        }
        a aVarF = this.f.f(iC);
        com.aliyun.svideosdk.editor.b bVar2 = this.f25753a;
        int i = aVarF.b;
        com.aliyun.svideosdk.editor.d dVar = com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER;
        int iDeleteView = bVar2.deleteView(i, dVar.a());
        if (iDeleteView != 0) {
            com.aliyun.common.c.a.a.b("AliyunPasterRenderImpl", "delete paster[" + effectPaster + "] failed!return " + iDeleteView);
        }
        int i2 = aVarF.f25754a;
        if (i2 >= 0 && (iDeleteView = this.f25753a.deleteView(i2, dVar.a())) != 0) {
            com.aliyun.common.c.a.a.b("AliyunPasterRenderImpl", "delete paster[" + effectPaster + "] bmp failed!return " + iDeleteView);
        }
        return iDeleteView;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public synchronized void removeCanvas() {
        int i = this.k;
        if (i != 0) {
            this.f25753a.deleteView(i, com.aliyun.svideosdk.editor.d.VIEW_TYPE_GRAFFITI.a());
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int removeCaption(AliyunCaption aliyunCaption) {
        if (this.c.getPasterTrackByID(aliyunCaption.getId()) == null) {
            com.aliyun.common.c.a.a.b("AliyunPasterRenderImpl", "Not find caption ");
            return -20003002;
        }
        this.c.removePasterTrack(aliyunCaption.getId());
        return this.f25753a.removeCaption(aliyunCaption);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int removePaster(EffectPaster effectPaster) {
        int iDeleteView;
        StringBuilder sb;
        PasterTrack pasterTrackByID = this.c.getPasterTrackByID(effectPaster.getViewId());
        if (pasterTrackByID == null) {
            com.aliyun.common.c.a.a.b("AliyunPasterRenderImpl", "Not find paster " + effectPaster);
            return -20003002;
        }
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.c(effectPaster);
        }
        int id = pasterTrackByID.getId();
        a aVarB = this.f.b(id);
        if (aVarB != null) {
            this.f.a(id);
            com.aliyun.svideosdk.editor.b bVar2 = this.f25753a;
            int i = aVarB.b;
            com.aliyun.svideosdk.editor.d dVar = com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER;
            iDeleteView = bVar2.deleteView(i, dVar.a());
            if (iDeleteView != 0) {
                com.aliyun.common.c.a.a.b("AliyunPasterRenderImpl", "delete paster[" + effectPaster + "] failed!return " + iDeleteView);
            }
            int i2 = aVarB.f25754a;
            if (i2 >= 0 && (iDeleteView = this.f25753a.deleteView(i2, dVar.a())) != 0) {
                sb = new StringBuilder();
                sb.append("delete paster[");
                sb.append(effectPaster);
                sb.append("] failed!return ");
                sb.append(iDeleteView);
                com.aliyun.common.c.a.a.b("AliyunPasterRenderImpl", sb.toString());
            }
        } else {
            iDeleteView = this.f25753a.deleteView(id, com.aliyun.svideosdk.editor.d.VIEW_TYPE_STATIC_PASTER.a());
            if (iDeleteView != 0) {
                sb = new StringBuilder();
                sb.append("delete paster[");
                sb.append(effectPaster);
                sb.append("] failed!return ");
                sb.append(iDeleteView);
                com.aliyun.common.c.a.a.b("AliyunPasterRenderImpl", sb.toString());
            }
        }
        this.c.removePasterTrack(id);
        a(pasterTrackByID.getId());
        return iDeleteView;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public void setDisplaySize(int i, int i2) {
        this.d.a(i, i2);
        this.i = new Size(i, i2);
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.e(i, i2);
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int setEffectWaterMark(EffectImage effectImage) {
        if (effectImage == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Watermark object is null");
            return -20001005;
        }
        com.aliyun.common.c.b.b bVar = this.m;
        if (bVar != null) {
            bVar.a(effectImage.getPath(), effectImage.getWidthRatio(), effectImage.getHeightRatio(), effectImage.getXRadio(), effectImage.getYRadio());
        }
        int i = this.j;
        if (i != 0) {
            this.f25753a.deleteView(i, com.aliyun.svideosdk.editor.d.VIEW_TYPE_WATERMARK.a());
        }
        int iA = a(effectImage);
        effectImage.setViewId(iA);
        this.j = iA;
        return iA;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public void setOnPasterResumeAndSave(OnPasterResumeAndSave onPasterResumeAndSave) {
        this.l = onPasterResumeAndSave;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int showCaptionPaster(Bitmap bitmap, EffectCaption effectCaption) {
        a(bitmap, effectCaption);
        removePaster(effectCaption);
        return addCaptionPaster(bitmap, effectCaption);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int showCaptionPaster(BitmapGenerator bitmapGenerator, EffectCaption effectCaption) {
        removePaster(effectCaption);
        return addCaptionPaster(bitmapGenerator, effectCaption);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int showPaster(EffectPaster effectPaster) {
        removePaster(effectPaster);
        return addEffectPaster(effectPaster);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int showTextPaster(Bitmap bitmap, EffectText effectText) {
        a(bitmap, effectText);
        if (bitmap == null) {
            return showPaster(effectText);
        }
        removePaster(effectText);
        return addSubtitle(bitmap, effectText);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int showTextPaster(BitmapGenerator bitmapGenerator, EffectText effectText) {
        if (bitmapGenerator == null) {
            return showPaster(effectText);
        }
        removePaster(effectText);
        return addSubtitle(bitmapGenerator, effectText);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterRender
    public int updateCaption(AliyunCaption aliyunCaption) {
        return this.f25753a.updateCaption(aliyunCaption);
    }
}
