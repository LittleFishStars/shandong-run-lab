package com.aliyun.svideosdk.editor.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.AliyunCaption;
import com.aliyun.svideosdk.common.AliyunFontStyle;
import com.aliyun.svideosdk.common.AliyunTypeface;
import com.aliyun.svideosdk.common.struct.effect.EffectCaption;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.effect.EffectText;
import com.aliyun.svideosdk.common.struct.effect.TrackEffect;
import com.aliyun.svideosdk.common.struct.project.BubbleCaptionTrack;
import com.aliyun.svideosdk.common.struct.project.CaptionTrack;
import com.aliyun.svideosdk.common.struct.project.DynamicImage;
import com.aliyun.svideosdk.common.struct.project.GifPasterTrack;
import com.aliyun.svideosdk.common.struct.project.PasterTrack;
import com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack;
import com.aliyun.svideosdk.common.struct.project.RollCaptionTrack;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.common.struct.project.SubTitleTrack;
import com.aliyun.svideosdk.editor.AliyunIPasterController;
import com.aliyun.svideosdk.editor.AliyunPasterController;
import com.aliyun.svideosdk.editor.AliyunPasterManager;
import com.aliyun.svideosdk.editor.OnPasterRestored;
import com.aliyun.svideosdk.editor.OnPasterResumeAndSave;
import com.aliyun.svideosdk.editor.impl.text.TextBitmap;
import com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class n implements AliyunPasterManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f25751a;
    private com.aliyun.common.f.b b;
    private o c;
    private com.aliyun.common.c.b.b d;
    private OnPasterRestored e;
    private f f;
    private com.aliyun.svideosdk.editor.e.a g;
    private Map<EffectPaster, PhotoPasterTrack> h = new HashMap();
    private List<AliyunIPasterController> i;
    private final OnPasterResumeAndSave j;

    public class a implements OnPasterResumeAndSave {
        public a() {
        }

        @Override // com.aliyun.svideosdk.editor.OnPasterResumeAndSave
        public void onPasterResume(List<PasterTrack> list) {
            ArrayList arrayList = new ArrayList();
            for (PasterTrack pasterTrack : list) {
                if (pasterTrack.getType() == PasterTrack.Type.photo) {
                    PhotoPasterTrack photoPasterTrack = (PhotoPasterTrack) pasterTrack;
                    EffectImage effectImage = new EffectImage(photoPasterTrack.getSource());
                    effectImage.setXRadio(photoPasterTrack.getX());
                    effectImage.setYRatio(photoPasterTrack.getY());
                    effectImage.setWidthRatio(photoPasterTrack.getWidth());
                    effectImage.setHeightRatio(photoPasterTrack.getHeight());
                    effectImage.setRotation(photoPasterTrack.getRotation());
                    photoPasterTrack.setId(n.this.c.b(new TrackEffect<>((long) (photoPasterTrack.getTimelineIn() * 1000.0f), (long) ((photoPasterTrack.getTimelineOut() - photoPasterTrack.getTimelineIn()) * 1000.0f), effectImage)));
                    n.this.f.a(photoPasterTrack);
                } else if (pasterTrack.getType() == PasterTrack.Type.roll_captions) {
                    n.this.g.a((RollCaptionTrack) pasterTrack);
                } else if (pasterTrack.getType() == PasterTrack.Type.gif) {
                    GifPasterTrack gifPasterTrack = (GifPasterTrack) pasterTrack;
                    EffectPaster effectPaster = new EffectPaster(gifPasterTrack.getSource());
                    n.this.f25751a.c(effectPaster, gifPasterTrack);
                    com.aliyun.common.c.a.a.a("COMPOSE", "restore after : " + effectPaster.toString());
                    arrayList.add(new k(effectPaster, n.this.c, n.this, true));
                    if (!n.this.f25751a.a()) {
                        n.this.h.put(effectPaster, gifPasterTrack);
                    }
                    n.this.c.addEffectPaster(effectPaster);
                    pasterTrack.setId(effectPaster.getViewId());
                    if (!gifPasterTrack.getActions().isEmpty()) {
                        effectPaster.action = gifPasterTrack.getActions().get(gifPasterTrack.getActions().size() - 1);
                    }
                    n.this.f.a(gifPasterTrack);
                } else {
                    PasterTrack.Type type = pasterTrack.getType();
                    PasterTrack.Type type2 = PasterTrack.Type.subtitle;
                    Bitmap bitmapDecodeFile = null;
                    if (type == type2 || pasterTrack.getType() == PasterTrack.Type.bubble_caption) {
                        SubTitleTrack subTitleTrack = (SubTitleTrack) pasterTrack;
                        EffectText effectText = pasterTrack.getType() == type2 ? new EffectText(subTitleTrack.getFont()) : new EffectCaption(subTitleTrack.getSource());
                        n.this.f25751a.c(effectText, subTitleTrack);
                        n.this.f25751a.b(effectText, subTitleTrack);
                        com.aliyun.common.c.a.a.a("COMPOSE", "restore after rotation : " + effectText.rotation + " width : " + effectText.width + " height : " + effectText.height + "x : " + effectText.x + " y : " + effectText.y + " mirror : " + effectText.mirror + " name : " + effectText.name);
                        boolean z = effectText instanceof EffectCaption;
                        arrayList.add(z ? new j((EffectCaption) effectText, n.this.c, n.this, true) : new l(effectText, n.this.c, n.this, true));
                        String str = effectText.textBmpPath;
                        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                            bitmapDecodeFile = BitmapFactory.decodeFile(str);
                        }
                        effectText.needSaveBmp = false;
                        if (bitmapDecodeFile == null) {
                            TextBitmapGenerator textBitmapGenerator = new TextBitmapGenerator();
                            textBitmapGenerator.updateTextBitmap(TextBitmap.fromEffectText(effectText));
                            if (z) {
                                n.this.c.addCaptionPaster(textBitmapGenerator, (EffectCaption) effectText);
                            } else {
                                n.this.c.addSubtitle(textBitmapGenerator, effectText);
                            }
                        } else if (z) {
                            n.this.c.addCaptionPaster(bitmapDecodeFile, (EffectCaption) effectText);
                        } else {
                            n.this.c.addSubtitle(bitmapDecodeFile, effectText);
                        }
                        subTitleTrack.setId(effectText.getViewId());
                        if (!subTitleTrack.getActions().isEmpty()) {
                            effectText.action = subTitleTrack.getActions().get(subTitleTrack.getActions().size() - 1);
                        }
                        n.this.f.a(subTitleTrack);
                        if (!n.this.f25751a.a()) {
                            n.this.h.put(effectText, subTitleTrack);
                        }
                    } else if (pasterTrack.getType() == PasterTrack.Type.caption) {
                        CaptionTrack captionTrack = (CaptionTrack) pasterTrack;
                        captionTrack.setCaption(null);
                        AliyunCaption caption = captionTrack.toCaption();
                        n.this.c.addCaption(caption);
                        captionTrack.setId(caption.getId());
                        AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = new AliyunPasterControllerCompoundCaption(caption, n.this.c);
                        n.this.i.add(aliyunPasterControllerCompoundCaption);
                        arrayList.add(aliyunPasterControllerCompoundCaption);
                    }
                }
            }
            if (n.this.e != null) {
                n.this.e.onPasterRestored(arrayList);
            }
        }
    }

    public n(f fVar, o oVar, com.aliyun.common.c.b.b bVar, com.aliyun.common.f.b bVar2, com.aliyun.svideosdk.editor.e.a aVar) {
        a aVar2 = new a();
        this.j = aVar2;
        this.f = fVar;
        this.b = bVar2;
        this.c = oVar;
        this.g = aVar;
        this.d = bVar;
        this.f25751a = new m();
        this.c.setOnPasterResumeAndSave(aVar2);
        this.i = new ArrayList();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public AliyunPasterControllerCompoundCaption addCaptionWithStartTime(String str, Source source, Source source2, long j, long j2) {
        return addCaptionWithStartTime(str, source, source2, j, j2, TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public AliyunPasterControllerCompoundCaption addCaptionWithStartTime(String str, Source source, Source source2, long j, long j2, TimeUnit timeUnit) {
        AliyunCaption aliyunCaption = new AliyunCaption();
        aliyunCaption.setText(str);
        float fA = com.aliyun.common.utils.f.a(25.0f);
        Size displaySize = this.c.getDisplaySize();
        aliyunCaption.setFontStyle(new AliyunFontStyle(source2, fA / Math.min(displaySize.getWidth(), displaySize.getHeight()), AliyunTypeface.NORMAL));
        aliyunCaption.setBubbleSource(source);
        aliyunCaption.setStartTime(timeUnit.toMicros(j));
        aliyunCaption.setDuration(timeUnit.toMicros(j2));
        AliyunPasterControllerCompoundCaption aliyunPasterControllerCompoundCaption = new AliyunPasterControllerCompoundCaption(aliyunCaption, this.c);
        this.i.add(aliyunPasterControllerCompoundCaption);
        return aliyunPasterControllerCompoundCaption;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    @Deprecated
    public AliyunPasterControllerCompoundCaption addCaptionWithStartTime(String str, String str2, String str3, long j, long j2) {
        return addCaptionWithStartTime(str, new Source(str2), new Source(str3), j, j2);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public AliyunPasterControllerImage addImage(Source source) {
        AliyunPasterControllerImage aliyunPasterControllerImage = new AliyunPasterControllerImage(new TrackEffect(0L, 0L, new EffectImage(source)), this.c, this.f);
        this.i.add(aliyunPasterControllerImage);
        return aliyunPasterControllerImage;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public AliyunPasterController addPaster(Source source) {
        return addPasterWithStartTime(source, 0L, 0L);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    @Deprecated
    public AliyunPasterController addPaster(String str) {
        com.aliyun.common.c.b.b bVar = this.d;
        if (bVar != null) {
            bVar.a(str);
        }
        return addPasterWithStartTime(str, 0L, 0L);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public AliyunPasterController addPasterWithStartTime(Source source, long j, long j2) {
        return addPasterWithStartTime(source, j, j2, TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public AliyunPasterController addPasterWithStartTime(Source source, long j, long j2, TimeUnit timeUnit) {
        DynamicImage dynamicImage;
        AliyunPasterController kVar;
        if (source == null || com.aliyun.common.utils.q.b(source.getPath()) || (dynamicImage = (DynamicImage) this.b.b(source.getPath(), DynamicImage.class)) == null) {
            return null;
        }
        com.aliyun.common.c.b.b bVar = this.d;
        if (bVar != null) {
            bVar.a(source.getPath(), j, j2);
        }
        BubbleCaptionTrack bubbleCaptionTrack = new BubbleCaptionTrack();
        bubbleCaptionTrack.setSource(source);
        dynamicImage.fillPaster(bubbleCaptionTrack);
        long micros = timeUnit.toMicros(j);
        long micros2 = timeUnit.toMicros(j2);
        if (micros != 0) {
            bubbleCaptionTrack.setTimelineIn(micros / 1000000.0f);
        }
        if (micros2 != 0) {
            bubbleCaptionTrack.setTimelineOut(bubbleCaptionTrack.getTimelineIn() + (micros2 / 1000000.0f));
        }
        if (dynamicImage.type == 0) {
            EffectCaption effectCaption = new EffectCaption(source);
            this.f25751a.b((EffectPaster) effectCaption, (PhotoPasterTrack) bubbleCaptionTrack);
            this.f25751a.a((EffectText) effectCaption, (SubTitleTrack) bubbleCaptionTrack);
            kVar = new j(effectCaption, this.c, this);
        } else {
            EffectPaster effectPaster = new EffectPaster(source);
            this.f25751a.b(effectPaster, bubbleCaptionTrack);
            kVar = new k(effectPaster, this.c, this);
        }
        this.i.add(kVar);
        return kVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    @Deprecated
    public AliyunPasterController addPasterWithStartTime(String str, long j, long j2) {
        return addPasterWithStartTime(new Source(str), j, j2);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public AliyunPasterController addSubtitle(String str, Source source) {
        com.aliyun.common.c.b.b bVar = this.d;
        if (bVar != null) {
            bVar.a(str, source != null ? source.getPath() : null);
        }
        return addSubtitleWithStartTime(str, source, 0L, 0L);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    @Deprecated
    public AliyunPasterController addSubtitle(String str, String str2) {
        com.aliyun.common.c.b.b bVar = this.d;
        if (bVar != null) {
            bVar.a(str, str2);
        }
        return addSubtitleWithStartTime(str, str2, 0L, 0L);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public AliyunPasterController addSubtitleWithStartTime(String str, Source source, long j, long j2) {
        com.aliyun.common.c.b.b bVar = this.d;
        if (bVar != null) {
            bVar.a(str, source != null ? source.getPath() : null, j, j2);
        }
        EffectText effectText = new EffectText(source);
        DynamicImage textOnlyConfig = DynamicImage.getTextOnlyConfig();
        SubTitleTrack subTitleTrack = new SubTitleTrack();
        subTitleTrack.setFont(source);
        textOnlyConfig.fillPaster(subTitleTrack);
        if (j != 0) {
            subTitleTrack.setTimelineIn(j / 1000000.0f);
        }
        if (j2 != 0) {
            subTitleTrack.setTimelineOut(subTitleTrack.getTimelineIn() + (j2 / 1000000.0f));
        }
        this.f25751a.b((EffectPaster) effectText, (PhotoPasterTrack) subTitleTrack);
        this.f25751a.a(effectText, subTitleTrack);
        effectText.text = str;
        if (source != null) {
            effectText.font = source.getPath();
            effectText.fontSource = source;
        }
        l lVar = new l(effectText, this.c, this);
        this.i.add(lVar);
        return lVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    @Deprecated
    public AliyunPasterController addSubtitleWithStartTime(String str, String str2, long j, long j2) {
        return addSubtitleWithStartTime(str, new Source(str2), j, j2);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public AliyunIPasterController findControllerAtPoint(PointF pointF, long j) {
        return findControllerAtPoint(pointF, j, TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public AliyunIPasterController findControllerAtPoint(PointF pointF, long j, TimeUnit timeUnit) {
        boolean z;
        boolean z2 = true;
        int size = this.i.size() - 1;
        while (size >= 0) {
            AliyunIPasterController aliyunIPasterController = this.i.get(size);
            long startTime = aliyunIPasterController.getStartTime();
            long duration = aliyunIPasterController.getDuration();
            long micros = timeUnit.toMicros(j);
            if ((startTime > micros || micros > startTime + duration) ? false : z2) {
                PointF position = aliyunIPasterController.getPosition();
                RectF size2 = aliyunIPasterController.getSize();
                float scale = aliyunIPasterController instanceof AliyunPasterControllerCompoundCaption ? ((AliyunPasterControllerCompoundCaption) aliyunIPasterController).getScale() : 1.0f;
                float fWidth = (size2.width() * scale) / 2.0f;
                float fHeight = (size2.height() * scale) / 2.0f;
                float f = position.x;
                float f2 = position.y;
                RectF rectF = new RectF(f - fWidth, f2 - fHeight, f + fWidth, f2 + fHeight);
                Matrix matrix = new Matrix();
                matrix.setTranslate(pointF.x, pointF.y);
                matrix.postRotate(-((float) Math.toDegrees(aliyunIPasterController.getRotate())), position.x, position.y);
                float[] fArr = {0.0f, 0.0f};
                matrix.mapPoints(fArr);
                z = true;
                if (rectF.contains(fArr[0], fArr[1])) {
                    return aliyunIPasterController;
                }
            } else {
                z = z2;
            }
            size--;
            z2 = z;
        }
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public List<AliyunIPasterController> findControllersByType(int i) {
        ArrayList arrayList = new ArrayList();
        for (int size = this.i.size() - 1; size >= 0; size--) {
            AliyunIPasterController aliyunIPasterController = this.i.get(size);
            if (aliyunIPasterController.getType() == i) {
                arrayList.add(aliyunIPasterController);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public void remove(AliyunIPasterController aliyunIPasterController) {
        if (aliyunIPasterController instanceof g) {
            ((g) aliyunIPasterController).remove();
        }
        this.i.remove(aliyunIPasterController);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public void setDisplaySize(int i, int i2) {
        if (i == 0 || i2 == 0) {
            throw new IllegalStateException("width or height can not be zero");
        }
        com.aliyun.common.c.b.b bVar = this.d;
        if (bVar != null) {
            bVar.e(i, i2);
        }
        this.f25751a.a(i, i2);
        this.c.setDisplaySize(i, i2);
        for (Map.Entry<EffectPaster, PhotoPasterTrack> entry : this.h.entrySet()) {
            this.f25751a.c(entry.getKey(), entry.getValue());
            if ((entry.getKey() instanceof EffectText) && (entry.getValue() instanceof SubTitleTrack)) {
                this.f25751a.b((EffectText) entry.getKey(), (SubTitleTrack) entry.getValue());
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunPasterManager
    public void setOnPasterRestoreListener(OnPasterRestored onPasterRestored) {
        this.e = onPasterRestored;
    }
}
