package com.aliyun.svideosdk.editor.impl;

import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.svideosdk.common.AliyunPip;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.aliyun.svideosdk.common.struct.project.BorderInfo;
import com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.editor.AliyunIAnimationController;
import com.aliyun.svideosdk.editor.AliyunIAudioController;
import com.aliyun.svideosdk.editor.AliyunIAugmentationController;
import com.aliyun.svideosdk.editor.AliyunILayoutController;
import com.aliyun.svideosdk.editor.AliyunIPipController;
import com.aliyun.svideosdk.editor.AliyunIPipTrack;
import com.aliyun.svideosdk.editor.NativeEditor;
import com.aliyun.svideosdk.transcode.NativeParser;
import com.fl.saas.common.util.FileTypeUtils;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class p implements AliyunIPipController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeEditor f25756a;
    private c c;
    private com.aliyun.svideosdk.editor.impl.b d;
    private AliyunPip e;
    private WeakReference<AliyunIPipTrack> f;
    private final PipVideoTrackClip g;
    private WeakReference<f> h;
    private h i;
    private boolean b = false;
    private AliyunIControllerCallback j = new a();
    private AliyunIAnimationController k = new b();

    public class a implements AliyunIControllerCallback {
        public a() {
        }

        @Override // com.aliyun.svideosdk.editor.impl.AliyunIControllerCallback
        public int onApply() {
            p.this.g();
            if (p.this.h.get() != null) {
                ((f) p.this.h.get()).saveEffectToLocal();
            }
            return p.this.f();
        }
    }

    public class b implements AliyunIAnimationController {
        public b() {
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIAnimationController
        public int addFrameAnimation(ActionBase actionBase) {
            actionBase.setTargetId(p.this.e.getStreamId());
            actionBase.setIsStream(true);
            int iAddFrameAnimation = ((f) p.this.h.get()).addFrameAnimation(actionBase);
            if (p.this.h.get() != null) {
                ((f) p.this.h.get()).saveEffectToLocal();
            }
            return iAddFrameAnimation;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIAnimationController
        public int removeFrameAnimation(ActionBase actionBase) {
            int iRemoveFrameAnimation = ((f) p.this.h.get()).removeFrameAnimation(actionBase);
            if (p.this.h.get() != null) {
                ((f) p.this.h.get()).saveEffectToLocal();
            }
            return iRemoveFrameAnimation;
        }
    }

    public p(NativeEditor nativeEditor, String str, f fVar) {
        this.f25756a = nativeEditor;
        AliyunPip aliyunPip = new AliyunPip();
        this.e = aliyunPip;
        aliyunPip.setFilePath(str);
        PipVideoTrackClip pipVideoTrackClip = new PipVideoTrackClip();
        this.g = pipVideoTrackClip;
        this.h = new WeakReference<>(fVar);
        this.c = new c(this.f25756a, this.e, pipVideoTrackClip, fVar);
        this.d = new com.aliyun.svideosdk.editor.impl.b(this.f25756a, this.e, pipVideoTrackClip, fVar);
        this.i = new h(this.e.getLayoutParams(), this.j);
        e();
    }

    private int a() {
        return this.f25756a.addPicInPic(this.e.getNativeHandle());
    }

    private static String a(String str) {
        String lowerCase = str.substring(str.lastIndexOf(Consts.DOT) + 1).toLowerCase(Locale.US);
        if (lowerCase != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        }
        return null;
    }

    private long b() {
        return this.e.getDuration();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.aliyun.svideosdk.transcode.NativeParser] */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.aliyun.svideosdk.transcode.NativeParser] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.aliyun.svideosdk.common.AliyunPip] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.aliyun.svideosdk.common.AliyunPip] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void e() {
        long j;
        ?? r1;
        int i;
        int i2;
        long j2;
        int i3;
        String filePath = this.e.getFilePath();
        String strA = a(filePath);
        int i4 = 0;
        if ((strA != null && strA.startsWith("video")) || filePath.endsWith(FileTypeUtils.FILE_TYPE_GIF) || filePath.endsWith("GIF")) {
            this.g.setType(0);
            ?? nativeParser = new NativeParser();
            nativeParser.init(filePath);
            int i5 = 16;
            try {
                try {
                    i2 = Integer.parseInt(nativeParser.getValue(6));
                    try {
                        i5 = Integer.parseInt(nativeParser.getValue(7));
                        i4 = Integer.parseInt(nativeParser.getValue(14));
                        j2 = Long.parseLong(nativeParser.getValue(3));
                        i3 = i2;
                    } catch (Exception unused) {
                        Log.e("AliYunLog", "parse rotation failed");
                        j2 = 0;
                        i3 = i2;
                    }
                } catch (Throwable th) {
                    nativeParser.release();
                    nativeParser.dispose();
                    throw th;
                }
            } catch (Exception unused2) {
                i2 = 9;
            }
            nativeParser.release();
            nativeParser.dispose();
            nativeParser = i5;
            j = j2;
            i = i3;
            r1 = nativeParser;
        } else {
            this.g.setType(1);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(filePath, options);
            j = 3000000;
            i = options.outWidth;
            r1 = options.outHeight;
        }
        this.e.setWidth((i4 == 90 || i4 == 270) ? r1 : i == true ? 1 : 0);
        ?? r5 = this.e;
        ?? r0 = i;
        r0 = i;
        if (i4 != 90 && i4 != 270) {
            r0 = r1;
        }
        r5.setHeight(r0);
        this.e.setDuration(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        return this.f25756a.updatePicInPic(this.e.getNativeHandle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Source source = new Source();
        source.setPath(this.e.getFilePath());
        this.g.setSource(source);
        this.g.setClipId(this.e.getStreamId());
        BorderInfo borderInfo = new BorderInfo();
        borderInfo.setColor(this.e.getBoarderColor());
        borderInfo.setWidth(this.e.getBoarderWidth());
        borderInfo.setCornerRadius(this.e.getCornerRadius());
        this.g.setBorder(borderInfo);
        this.g.setRotationRadian(this.e.getRotationRadian());
        PointF position = this.e.getPosition();
        this.g.setCenterX(position.x);
        this.g.setCenterY(position.y);
        this.g.setWidth(this.e.getWidth());
        this.g.setHeight(this.e.getHeight());
        this.g.setScale(this.e.getScale());
        this.g.setAlpha(this.e.getAlpha());
        this.g.setMixWeight(this.e.getVolume() * 100);
        this.g.setDenoiseWeight(this.e.getDenoiseWeight());
        this.g.setTimelineIn(com.aliyun.common.d.b.a(this.e.getTimelineStartTime()));
        this.g.setTimelineOut(com.aliyun.common.d.b.a(this.e.getTimelineEndTime()));
        this.g.setIn(com.aliyun.common.d.b.a(this.e.getStartTime()));
        this.g.setOut(com.aliyun.common.d.b.a(this.e.getEndTime()));
        this.g.setDuration(com.aliyun.common.d.b.a(this.e.getDuration()));
        this.g.setHorizontalFlip(this.e.getHorizontalFlip());
    }

    public AliyunIPipController a(int i) {
        this.e.setLayerIndex(i);
        return this;
    }

    public p a(long j) {
        this.e.setDuration(j);
        return this;
    }

    public void a(AliyunIPipTrack aliyunIPipTrack) {
        this.f = new WeakReference<>(aliyunIPipTrack);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public int apply() {
        int iF;
        if (this.b) {
            iF = f();
        } else {
            iF = a();
            this.b = true;
        }
        g();
        if (this.h.get() != null) {
            this.h.get().saveEffectToLocal();
        }
        return iF;
    }

    public PipVideoTrackClip c() {
        return this.g;
    }

    public void d() {
        NativeEditor nativeEditor = this.f25756a;
        if (nativeEditor != null) {
            nativeEditor.removePipInPic(this.e.getStreamId());
            this.f25756a = null;
        }
        AliyunPip aliyunPip = this.e;
        if (aliyunPip != null) {
            aliyunPip.release();
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunIAnimationController getAnimationController() {
        if (this.b) {
            return this.k;
        }
        throw new IllegalStateException("must call com.aliyun.svideosdk.editor.AliyunIPipController.apply() first");
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunIAudioController getAudioController() {
        if (this.b) {
            return this.d;
        }
        throw new IllegalStateException("must call com.aliyun.svideosdk.editor.AliyunIPipController.apply() first");
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunIAugmentationController getAugmentationController() {
        if (this.b) {
            return this.c;
        }
        throw new IllegalStateException("must call com.aliyun.svideosdk.editor.AliyunIPipController.apply() first");
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public long getClipDurationInMillis() {
        return com.aliyun.common.d.b.a(this.e.getDuration());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public long getClipStartTimeInMillis() {
        return com.aliyun.common.d.b.a(this.e.getStartTime());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public int getHeight() {
        return this.e.getHeight();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunILayoutController getLayoutController() {
        if (this.b) {
            return this.i;
        }
        throw new IllegalStateException("must call com.aliyun.svideosdk.editor.AliyunIPipController.apply() first");
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipController
    public AliyunIPipTrack getOwnerTrack() {
        return this.f.get();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public String getPath() {
        return this.e.getFilePath();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipController
    public RectF getPipRectFInCurrentScreen() {
        float scale;
        float f;
        int iE = this.h.get().e();
        int iD = this.h.get().d();
        float width = getWidth();
        float f2 = width * 1.0f;
        float f3 = iE;
        float f4 = f2 / f3;
        float height = getHeight();
        float f5 = 1.0f * height;
        float f6 = iD;
        if (f4 > f5 / f6) {
            scale = getLayoutController().getScale();
            f = ((f3 * scale) * (f5 / width)) / f6;
        } else {
            float scale2 = getLayoutController().getScale();
            scale = ((f6 * scale2) * (f2 / height)) / f3;
            f = scale2;
        }
        PointF position = getLayoutController().getPosition();
        float f7 = position.x;
        float f8 = scale / 2.0f;
        float f9 = position.y;
        float f10 = f / 2.0f;
        return new RectF(f7 - f8, f9 - f10, f7 + f8, f9 + f10);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public int getStreamId() {
        return this.e.getStreamId();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public long getTimeLineEndTimeInMillis() {
        return com.aliyun.common.d.b.a(this.e.getTimelineEndTime());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public long getTimeLineStartTimeInMillis() {
        return com.aliyun.common.d.b.a(this.e.getTimelineStartTime());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public int getWidth() {
        return this.e.getWidth();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunIPipController setBorderColor(int i) {
        this.e.setBoarderColor(i);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunIPipController setBorderCornerRadius(float f) {
        this.e.setCornerRadius(f / this.h.get().f());
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunIPipController setBorderWidth(float f) {
        this.e.setBoarderWidth(f / this.h.get().f());
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunIPipController setClipEndTime(long j, TimeUnit timeUnit) {
        long micros = timeUnit.toMicros(j);
        this.e.setEndTime(micros);
        long startTime = micros - this.e.getStartTime();
        if (startTime > 0) {
            this.e.setDuration(startTime);
        }
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunIPipController setClipStartTime(long j, TimeUnit timeUnit) {
        long micros = timeUnit.toMicros(j);
        if (micros < 0) {
            micros = 0;
        } else if (micros > b()) {
            micros = b();
        }
        this.e.setStartTime(micros);
        this.e.setEndTime(micros + b());
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunIPipController setHorizontalFlip(boolean z) {
        this.e.setHorizontalFlip(z);
        return this;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunISteamController
    public AliyunIPipController setTimelineStartTime(long j, TimeUnit timeUnit) {
        this.e.setTimelineStartTime(timeUnit.toMicros(j));
        return this;
    }
}
