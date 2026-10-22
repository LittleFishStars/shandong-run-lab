package com.aliyun.svideosdk.editor.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.WindowManager;
import com.aliyun.common.log.struct.AliyunLogInfo;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.AliyunCaption;
import com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType;
import com.aliyun.svideosdk.common.struct.common.AliyunClip;
import com.aliyun.svideosdk.common.struct.common.AliyunImageClip;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoClip;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoParam;
import com.aliyun.svideosdk.common.struct.common.MediaType;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.aliyun.svideosdk.common.struct.effect.BlurBackground;
import com.aliyun.svideosdk.common.struct.effect.EffectBean;
import com.aliyun.svideosdk.common.struct.effect.EffectFilter;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPicture;
import com.aliyun.svideosdk.common.struct.effect.LUTEffectBean;
import com.aliyun.svideosdk.common.struct.effect.TrackAudioStream;
import com.aliyun.svideosdk.common.struct.effect.TrackEffect;
import com.aliyun.svideosdk.common.struct.effect.TrackEffectFilter;
import com.aliyun.svideosdk.common.struct.effect.TrackEffectMV;
import com.aliyun.svideosdk.common.struct.effect.TrackEffectWaterMark;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.common.struct.effect.TransitionShutter;
import com.aliyun.svideosdk.common.struct.encoder.VideoCodecs;
import com.aliyun.svideosdk.common.struct.project.AliyunEditorProject;
import com.aliyun.svideosdk.common.struct.project.AliyunIProjectInfo;
import com.aliyun.svideosdk.common.struct.project.AliyunProjectInfo;
import com.aliyun.svideosdk.common.struct.project.AudioEffect;
import com.aliyun.svideosdk.common.struct.project.AudioFade;
import com.aliyun.svideosdk.common.struct.project.AudioTrack;
import com.aliyun.svideosdk.common.struct.project.AudioTrackClip;
import com.aliyun.svideosdk.common.struct.project.CanvasAction;
import com.aliyun.svideosdk.common.struct.project.Effect;
import com.aliyun.svideosdk.common.struct.project.EffectTrack;
import com.aliyun.svideosdk.common.struct.project.Filter;
import com.aliyun.svideosdk.common.struct.project.MVFilter;
import com.aliyun.svideosdk.common.struct.project.MainVideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack;
import com.aliyun.svideosdk.common.struct.project.PipVideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.ProjectUtil;
import com.aliyun.svideosdk.common.struct.project.RunningDisplayMode;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.common.struct.project.TailWaterMark;
import com.aliyun.svideosdk.common.struct.project.TimeFilter;
import com.aliyun.svideosdk.common.struct.project.VideoTrack;
import com.aliyun.svideosdk.common.struct.project.VideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.WaterMark;
import com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl;
import com.aliyun.svideosdk.editor.AliyunICanvasController;
import com.aliyun.svideosdk.editor.AliyunIComposeCallBack;
import com.aliyun.svideosdk.editor.AliyunIEditor;
import com.aliyun.svideosdk.editor.AliyunIPipController;
import com.aliyun.svideosdk.editor.AliyunIPipManager;
import com.aliyun.svideosdk.editor.AliyunIPipTrack;
import com.aliyun.svideosdk.editor.AliyunIPlayerController;
import com.aliyun.svideosdk.editor.AliyunISourcePartManager;
import com.aliyun.svideosdk.editor.AliyunPasterManager;
import com.aliyun.svideosdk.editor.AliyunPasterRender;
import com.aliyun.svideosdk.editor.AliyunRollCaptionComposer;
import com.aliyun.svideosdk.editor.AudioEffectType;
import com.aliyun.svideosdk.editor.EditorCallBack;
import com.aliyun.svideosdk.editor.EffectType;
import com.aliyun.svideosdk.editor.NativeEditor;
import com.aliyun.svideosdk.editor.OnAnimationFilterRestored;
import com.aliyun.svideosdk.editor.OnAnimationFilterRestoredListener;
import com.aliyun.svideosdk.editor.ShapeType;
import com.aliyun.svideosdk.editor.TimeEffectType;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class f implements AliyunIEditor {
    private OnAnimationFilterRestoredListener A;
    private SurfaceView B;
    private TextureView C;
    private AliyunLogInfo D;
    private int F;
    private int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeEditor f25741a;
    private AliyunISourcePartManager b;
    private ProjectJSONSupportImpl c;
    private com.aliyun.svideosdk.editor.impl.d d;
    private String f;
    private long h;
    private AliyunEditorProject i;
    private AliyunVideoParam j;
    private Surface l;
    private AliyunIPlayerController n;
    private boolean p;
    private AliyunProjectInfo r;
    private n s;
    private o t;
    private com.aliyun.svideosdk.editor.e.a u;
    private q v;
    private EditorCallBack w;
    private OnAnimationFilterRestored z;
    private com.aliyun.svideosdk.editor.c e = com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY;
    private long g = 0;
    private VideoDisplayMode k = VideoDisplayMode.FILL;
    private boolean m = false;
    private volatile int o = 0;
    private com.aliyun.common.c.b.b q = null;
    private AliyunIComposeCallBack x = null;
    private com.aliyun.svideosdk.editor.a y = null;
    private long E = 0;
    private final TextureView.SurfaceTextureListener H = new a();
    private final SurfaceHolder.Callback I = new b();
    private EditorCallBack J = new c();

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            String str;
            Log.e("AliYunLog", "onSurfaceTextureAvailable ");
            if (f.this.f25741a == null) {
                str = "onSurfaceTextureAvailable mEditor is null!";
            } else {
                f.this.F = i;
                f.this.G = i2;
                f.this.u.a(f.this.F, f.this.G);
                if (f.this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
                    Log.d("AliYunLog", "compose mode not set display");
                    return;
                }
                if (f.this.f25741a.setDisplaySize(f.this.F, f.this.G) == 0) {
                    Log.d("AliYunLog", "display size invalid");
                    f.this.l = new Surface(surfaceTexture);
                    if (f.this.f25741a.setDisplay(f.this.l) != 0) {
                        Log.e("AliYunLog", "Set display failed!");
                        return;
                    }
                    return;
                }
                str = "Set display size failed!";
            }
            Log.e("AliYunLog", str);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (f.this.f25741a == null) {
                Log.e("AliYunLog", "surfaceDestroyed mEditor is null!");
                return true;
            }
            Log.e("AliYunLog", "surfaceDestroyed setDisplay null");
            f.this.v();
            f.this.l = null;
            f.this.f25741a.setDisplay(f.this.l);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Log.e("AliYunLog", "surfaceChanged ");
            if (f.this.f25741a == null) {
                Log.e("AliYunLog", "surfaceChanged mEditor is null!");
                return;
            }
            if (f.this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
                if (f.this.f25741a.setDisplaySize(i, i2) != 0) {
                    Log.e("AliYunLog", "Set display size failed!");
                }
                if (f.this.l == null) {
                    f.this.l = new Surface(surfaceTexture);
                    if (f.this.f25741a.setDisplay(f.this.l) != 0) {
                        Log.e("AliYunLog", "Set display failed!");
                    }
                }
            }
            f.this.F = i;
            f.this.G = i2;
            f.this.u.a(f.this.F, f.this.G);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Log.e("AliYunLog", "surfaceChanged ");
            if (f.this.m) {
                if (f.this.f25741a == null) {
                    Log.e("AliYunLog", "surfaceChanged mEditor is null!");
                    return;
                }
                if (f.this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
                    if (f.this.f25741a.setDisplaySize(i2, i3) != 0) {
                        Log.e("AliYunLog", "Set display size failed!");
                    }
                    if (f.this.l == null) {
                        f.this.l = surfaceHolder.getSurface();
                        if (f.this.f25741a.setDisplay(f.this.l) != 0) {
                            Log.e("AliYunLog", "Set display failed!");
                        }
                    }
                }
                f.this.F = i2;
                f.this.G = i3;
                f.this.u.a(f.this.F, f.this.G);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.e("AliYunLog", "surfaceCreated ");
            if (f.this.f25741a == null) {
                Log.e("AliYunLog", "surfaceCreated mEditor is null!");
                return;
            }
            if (!f.this.m) {
                if (f.this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
                    surfaceHolder.setFixedSize(f.this.F, f.this.G);
                    if (f.this.f25741a.setDisplaySize(f.this.F, f.this.G) != 0) {
                        Log.e("AliYunLog", "Set display size failed!");
                        return;
                    }
                    Log.d("AliYunLog", "display size invalid");
                    f.this.l = surfaceHolder.getSurface();
                    if (f.this.f25741a.setDisplay(f.this.l) == 0) {
                        return;
                    }
                    Log.e("AliYunLog", "Set display failed!");
                    return;
                }
                Log.d("AliYunLog", "compose mode not set display");
            }
            f fVar = f.this;
            fVar.F = fVar.B.getMeasuredWidth();
            f fVar2 = f.this;
            fVar2.G = fVar2.B.getMeasuredHeight();
            f.this.u.a(f.this.F, f.this.G);
            if (f.this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
                if (f.this.f25741a.setDisplaySize(f.this.F, f.this.G) != 0) {
                    Log.e("AliYunLog", "Set display size failed!");
                    return;
                }
                Log.d("AliYunLog", "display size invalid");
                f.this.l = surfaceHolder.getSurface();
                if (f.this.f25741a.setDisplay(f.this.l) == 0) {
                    return;
                }
                Log.e("AliYunLog", "Set display failed!");
                return;
            }
            Log.d("AliYunLog", "compose mode not set display");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (f.this.f25741a == null) {
                Log.e("AliYunLog", "surfaceDestroyed mEditor is null!");
                return;
            }
            Log.e("AliYunLog", "surfaceDestroyed setDisplay null");
            f.this.v();
            f.this.l = null;
            f.this.f25741a.setDisplay(f.this.l);
        }
    }

    public class c extends EditorCallBack {
        public c() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onCustomRender(int i, int i2, int i3, long j) {
            int iOnCustomRender;
            return (f.this.w == null || (iOnCustomRender = f.this.w.onCustomRender(i, i2, i3, j)) <= 0) ? i : iOnCustomRender;
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onDataReady() {
            if (f.this.w != null) {
                f.this.w.onDataReady();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onEnd(int i) {
            Log.d("testEditor", "sdk onend");
            f.this.a(3);
            int i2 = C0230f.c[f.this.e.ordinal()];
            if (i2 == 1) {
                if (f.this.w != null) {
                    f.this.w.onEnd(i);
                }
            } else {
                if (i2 != 2) {
                    return;
                }
                if (f.this.x != null) {
                    f.this.x.onComposeCompleted();
                }
                if (f.this.y != null) {
                    f.this.y.onComposeCompleted();
                }
                f.this.x = null;
                f.this.a(4);
                if (f.this.f != null) {
                    f.this.q.a(f.this.f, i, f.this.E);
                }
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onError(int i) {
            f.this.a(4);
            int i2 = C0230f.c[f.this.e.ordinal()];
            if (i2 == 1) {
                if (f.this.w != null) {
                    Log.e("AliYunLog", "EditorCallBack::onError, case PROCESS_MODE_PLAY, rv = " + i);
                    f.this.w.onError(i);
                }
                f.this.q.b(i);
                return;
            }
            if (i2 != 2) {
                return;
            }
            if (f.this.x != null) {
                Log.e("AliYunLog", "EditorCallBack::onError, case PROCESS_MODE_COMPOSE, rv = " + i);
                f.this.x.onComposeError(i);
            }
            f.this.x = null;
            f.this.a(4);
            f.this.q.a(f.this.f, i);
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPacketSeek(long j, int i) {
            if (f.this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE || f.this.y == null) {
                return;
            }
            f.this.y.a(j, i);
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPlayProgress(long j, long j2) {
            int i = C0230f.c[f.this.e.ordinal()];
            if (i == 1) {
                if (f.this.w != null) {
                    f.this.w.onPlayProgress(j, j2);
                }
            } else if (i == 2 && f.this.x != null && f.this.g > 0) {
                f.this.x.onComposeProgress((int) ((j * 100) / f.this.g));
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onRenderDestroy() {
            if (f.this.w != null) {
                f.this.w.onRenderDestroy();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onRenderSetup() {
            if (f.this.w != null) {
                f.this.w.onRenderSetup();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onTextureRender(int i, int i2, int i3, long j) {
            int iOnTextureRender;
            return (f.this.w == null || (iOnTextureRender = f.this.w.onTextureRender(i, i2, i3, j)) <= 0) ? i : iOnTextureRender;
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onWritePacket(ByteBuffer byteBuffer, int i) {
            if (f.this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE || f.this.y == null) {
                return;
            }
            f.this.y.a(byteBuffer, i);
        }
    }

    public class d implements Comparator<VideoTrackClip> {
        public d() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(VideoTrackClip videoTrackClip, VideoTrackClip videoTrackClip2) {
            long jA = f.this.a(videoTrackClip) - f.this.a(videoTrackClip2);
            if (jA == 0) {
                return 0;
            }
            return jA > 0 ? 1 : -1;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f25746a;

        public e(Bitmap bitmap) {
            this.f25746a = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = new Matrix();
            matrix.postRotate(180.0f);
            matrix.postScale(-1.0f, 1.0f);
            Bitmap bitmap = this.f25746a;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f25746a.getHeight(), matrix, true);
            String str = f.this.i.getProjectDir().getAbsolutePath() + File.separator + "cover.jpeg";
            com.aliyun.common.utils.d.a(str, bitmapCreateBitmap, Bitmap.CompressFormat.JPEG, 80);
            f.this.i.setCover(new Source(str));
            bitmapCreateBitmap.recycle();
            ProjectUtil.writeProject(f.this.i, f.this.i.getProjectFile(), f.this.c);
        }
    }

    /* JADX INFO: renamed from: com.aliyun.svideosdk.editor.impl.f$f, reason: collision with other inner class name */
    public static /* synthetic */ class C0230f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25747a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.aliyun.svideosdk.editor.c.values().length];
            c = iArr;
            try {
                iArr[com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EffectType.values().length];
            b = iArr2;
            try {
                iArr2[EffectType.EFFECT_TYPE_MV.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[EffectType.EFFECT_TYPE_MIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[EffectType.EFFECT_TYPE_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[EffectType.EFFECT_TYPE_MV_AUDIO.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[VideoAugmentationType.values().length];
            f25747a = iArr3;
            try {
                iArr3[VideoAugmentationType.BRIGHTNESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25747a[VideoAugmentationType.CONTRAST.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25747a[VideoAugmentationType.SATURATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25747a[VideoAugmentationType.SHARPNESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25747a[VideoAugmentationType.VIGNETTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public f(Uri uri, EditorCallBack editorCallBack) {
        this.r = null;
        this.w = null;
        com.aliyun.common.c.a.a.a("AliYunLog", "create AliyunEditor.");
        this.c = new ProjectJSONSupportImpl();
        if (uri == null) {
            throw new IllegalArgumentException("Uri cannot be null");
        }
        AliyunEditorProject project = ProjectUtil.readProject(new File(uri.getPath()), this.c);
        this.i = project;
        if (project == null) {
            throw new IllegalArgumentException("Editor init project failed, Verify that the original video filePath is valid,uri:" + uri.toString());
        }
        this.r = new AliyunProjectInfo(project);
        this.h = c();
        this.w = editorCallBack;
        NativeEditor nativeEditor = new NativeEditor();
        this.f25741a = nativeEditor;
        com.aliyun.common.f.b bVar = new com.aliyun.common.f.b(this.c);
        this.t = new o(nativeEditor, this.q, this.i, bVar);
        com.aliyun.svideosdk.editor.e.a aVar = new com.aliyun.svideosdk.editor.e.a(this.f25741a, this.i);
        this.u = aVar;
        this.s = new n(this, this.t, this.q, bVar, aVar);
        this.v = new q(this.f25741a, this.i, this);
    }

    private int a() {
        int iAddImageElement;
        for (VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip.getType() == 1) {
                iAddImageElement = this.f25741a.addImageElement(videoTrackClip.getSource().getPath(), (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000000.0f), videoTrackClip.getTransition(), videoTrackClip.getWidth(), videoTrackClip.getHeight(), 1.0f, 0.0f);
                if (iAddImageElement < 0) {
                    Log.e("AliYunLog", "Editor add image element failed!");
                    return -20003020;
                }
            } else if (videoTrackClip.getType() != 0) {
                continue;
            } else {
                iAddImageElement = this.f25741a.addVideoElement(videoTrackClip.getSource().getPath(), (long) (videoTrackClip.getIn() * 1000000.0f), (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000000.0f), videoTrackClip.getTransition(), videoTrackClip.getWidth(), videoTrackClip.getHeight(), 1.0f, 0.0f);
                if (iAddImageElement < 0) {
                    Log.e("AliYunLog", "Editor add image element failed!");
                    return -20003020;
                }
            }
            videoTrackClip.setClipId(iAddImageElement);
        }
        return 0;
    }

    private int a(int i, float f) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById == null) {
            return -10008008;
        }
        int brightness = this.f25741a.setBrightness(i, f);
        if (brightness != 0) {
            return brightness;
        }
        videoTrackClipById.setBrightness(f);
        return brightness;
    }

    private int a(TrackEffectFilter trackEffectFilter) {
        if (trackEffectFilter == null) {
            return 1073754197;
        }
        if (!this.f25741a.isNativePrepared()) {
            return -20002001;
        }
        int iA = this.t.a(trackEffectFilter);
        if (iA != 0) {
            Log.e("AliYunLog", "set animation filter failed, resources path " + trackEffectFilter.getBean().getPath() + ", startTime " + trackEffectFilter.getStartTime() + ", duration " + trackEffectFilter.getDuration());
        }
        return iA;
    }

    private int a(String str, float f, long j, long j2, int i) {
        NativeEditor nativeEditor = this.f25741a;
        if (nativeEditor == null) {
            return -20011019;
        }
        int lutFilter = nativeEditor.setLutFilter(i, str, f, j * 1000, j2 * 1000);
        if (lutFilter != 0) {
            Log.e("AliYunLog", "set lut effect filter failed, , startTime " + j + ", duration " + j2);
        }
        return lutFilter;
    }

    private int a(String str, long j, long j2, int i) {
        NativeEditor nativeEditor = this.f25741a;
        if (nativeEditor == null) {
            return -20011019;
        }
        int iSwitchEff = nativeEditor.switchEff(str, j, j2, i);
        if (iSwitchEff != 0) {
            Log.e("AliYunLog", "set effect filter failed, resources path " + str + ", startTime " + j + ", duration " + j2);
        }
        return iSwitchEff;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(VideoTrackClip videoTrackClip) {
        return (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000.0f);
    }

    private EffectImage a(WaterMark waterMark) {
        EffectImage effectImage = new EffectImage(waterMark.getSource().getPath());
        effectImage.setWidthRatio(waterMark.getWidth());
        effectImage.setHeightRatio(waterMark.getHeight());
        effectImage.setXRadio(waterMark.getX());
        effectImage.setYRatio(waterMark.getY());
        return effectImage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.aliyun.svideosdk.common.struct.effect.BlurBackground, com.aliyun.svideosdk.common.struct.project.VideoEffect] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.aliyun.svideosdk.common.struct.project.VideoEffect] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.aliyun.svideosdk.common.struct.project.RunningDisplayMode, com.aliyun.svideosdk.common.struct.project.VideoEffect, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.StringBuilder] */
    private void a(int i, List<Effect> list) {
        ?? r0;
        int iApplyBlurBackground;
        String str;
        for (Effect effect : list) {
            if (effect.getType() == Effect.Type.blur_background) {
                r0 = (BlurBackground) effect;
                iApplyBlurBackground = this.f25741a.applyBlurBackground(i, (long) (r0.getIn() * 1000000.0f), (long) ((r0.getOut() - r0.getIn()) * 1000000.0f), r0.getBlurRadius());
                if (iApplyBlurBackground < 0) {
                    str = "Resume blur background failed!return ret:" + iApplyBlurBackground;
                    com.aliyun.common.c.a.a.b("AliYunLog", str);
                } else {
                    r0.setId(iApplyBlurBackground);
                }
            } else if (effect.getType() == Effect.Type.running_display_mode) {
                r0 = (RunningDisplayMode) effect;
                iApplyBlurBackground = this.f25741a.setRunningDisplayMode(i, r0.getDisplayMode(), (long) (r0.getIn() * 1000000.0f), (long) ((r0.getOut() - r0.getIn()) * 1000000.0f));
                if (iApplyBlurBackground >= 0) {
                    r0.setId(iApplyBlurBackground);
                } else {
                    str = "Add running display mode failed!" + r0;
                    com.aliyun.common.c.a.a.b("AliYunLog", str);
                }
            } else if (effect.getType() == Effect.Type.audio_effect) {
                AudioEffect audioEffect = (AudioEffect) effect;
                this.f25741a.audioEffect(i, audioEffect.mEffectType.getEffectType(), audioEffect.mEffectParam / 100.0f);
            } else if (effect.getType() == Effect.Type.audio_fade) {
                AudioFade audioFade = (AudioFade) effect;
                boolean z = audioFade.isFadeIn;
                int i2 = 1;
                int i3 = audioFade.shapeType;
                if (z) {
                    i2 = i3 == 1 ? 2 : 0;
                } else if (i3 != 0) {
                    i2 = 3;
                }
                this.f25741a.setAudioFadeInFadeOut(i, i2, (long) (audioFade.duration * 1000.0f), z);
            }
        }
    }

    private void a(VideoTrackClip videoTrackClip, long j) {
        long jMin = Math.min(this.h, j);
        TransitionBase transition = videoTrackClip.getTransition();
        if (transition != null) {
            transition.setOverlapDuration(jMin, TimeUnit.MILLISECONDS);
            videoTrackClip.setTransition(transition);
        }
    }

    private void a(boolean z) {
        this.f25741a.setMute(z);
        this.i.getConfig().setMute(z);
    }

    private int b() {
        int display;
        int i;
        SurfaceView surfaceView = this.B;
        Surface surface = surfaceView != null ? surfaceView.getHolder().getSurface() : null;
        TextureView textureView = this.C;
        if (textureView != null && textureView.isAvailable()) {
            surface = new Surface(this.C.getSurfaceTexture());
        }
        int i2 = this.F;
        if (i2 != 0 && (i = this.G) != 0) {
            display = this.f25741a.setDisplaySize(i2, i);
            String str = display != 0 ? "Set display size failed!" : "Set display failed!";
            Log.e("AliYunLog", str);
            return display;
        }
        Log.d("AliYunLog", "display size invalid");
        display = 0;
        if (surface == null || !surface.isValid() || (display = this.f25741a.setDisplay(surface)) == 0) {
            return display;
        }
        Log.e("AliYunLog", str);
        return display;
    }

    private int b(int i, float f) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById == null) {
            return -10008008;
        }
        int contrast = this.f25741a.setContrast(i, f);
        if (contrast != 0) {
            return contrast;
        }
        videoTrackClipById.setContrast(f);
        return contrast;
    }

    private int c(int i, float f) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById == null) {
            return -10008008;
        }
        int saturation = this.f25741a.setSaturation(i, f);
        if (saturation != 0) {
            return saturation;
        }
        videoTrackClipById.setSaturation(f);
        return saturation;
    }

    private long c() {
        List<VideoTrackClip> videoTrackClips = this.i.getTimeline().getPrimaryTrack().getVideoTrackClips();
        if (videoTrackClips == null || videoTrackClips.size() == 0) {
            return 0L;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(videoTrackClips);
        Collections.sort(arrayList, new d());
        return (a((VideoTrackClip) arrayList.get(0)) / 2) - 100;
    }

    private int d(int i, float f) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById == null) {
            return -10008008;
        }
        int sharpness = this.f25741a.setSharpness(i, f);
        if (sharpness != 0) {
            return sharpness;
        }
        videoTrackClipById.setSharpness(f);
        return sharpness;
    }

    private int e(int i, float f) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById == null) {
            return -10008008;
        }
        int vignette = this.f25741a.setVignette(i, f);
        if (vignette != 0) {
            return vignette;
        }
        videoTrackClipById.setVignette(f);
        return vignette;
    }

    private boolean h() {
        NativeEditor nativeEditor = this.f25741a;
        if (nativeEditor == null) {
            return false;
        }
        return nativeEditor.isNativePrepared();
    }

    private synchronized boolean i() {
        return this.o == 4;
    }

    private int j() {
        int i;
        EditorCallBack editorCallBack = this.w;
        if (editorCallBack != null) {
            this.J.mNeedRenderCallback = editorCallBack.mNeedRenderCallback;
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "nativeInit");
        this.J.mNeedPacketCallback = this.y != null;
        NativeEditor nativeEditor = this.f25741a;
        int outputWidth = this.i.getConfig().getOutputWidth();
        int outputHeight = this.i.getConfig().getOutputHeight();
        int i2 = Build.VERSION.SDK_INT;
        com.aliyun.common.c.b.b bVar = this.q;
        int iInit = nativeEditor.init(outputWidth, outputHeight, i2, bVar == null ? 0L : bVar.a(), this.J);
        if (iInit != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Editor init failed");
            return iInit;
        }
        int display = this.f25741a.setDisplay(null);
        if (display != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Set null display failed!");
            return display;
        }
        int outputWidth2 = (int) (this.i.getConfig().getOutputWidth() * this.i.getConfig().getScale());
        if (outputWidth2 % 2 != 0) {
            outputWidth2--;
        }
        int i3 = outputWidth2;
        int outputHeight2 = (int) (this.i.getConfig().getOutputHeight() * this.i.getConfig().getScale());
        if (outputHeight2 % 2 != 0) {
            outputHeight2--;
        }
        int i4 = outputHeight2;
        if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE) {
            int encodeParam = this.f25741a.setEncodeParam(this.j.getBitrate(), this.j.getFrameRate(), this.j.getGop(), this.j.getVideoQuality().ordinal(), this.j.getCrf(), this.j.getVideoCodec().ordinal(), i3, i4, this.j.getAudioSampleRate().getValue(), this.j.getAudioChannel().getValue());
            if (encodeParam != 0) {
                com.aliyun.common.c.a.a.b("AliYunLog", "Set compose param failed!");
                return encodeParam;
            }
            int outputPath = this.f25741a.setOutputPath(this.f);
            if (outputPath != 0) {
                com.aliyun.common.c.a.a.b("AliYunLog", "Set output path failed!");
                return outputPath;
            }
        }
        int mode = this.f25741a.setMode(this.e);
        if (mode != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Set mode failed!");
            return mode;
        }
        int iA = a();
        if (iA != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Apply source failed!");
            return iA;
        }
        if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
            int i5 = this.F;
            if (i5 == 0 || (i = this.G) == 0) {
                com.aliyun.common.c.a.a.a("AliYunLog", "display size invalid, displayWidth " + this.F + ", displayHeight " + this.G);
            } else {
                this.f25741a.setDisplaySize(i5, i);
            }
        }
        int iPrepare = this.f25741a.prepare();
        if (iPrepare != 0) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Editor prepare failed!");
            return iPrepare;
        }
        setVolume(this.i.getConfig().getVolume());
        this.f25741a.onStartBatchEdit();
        s();
        this.f25741a.onSubmitBatchEdit();
        o();
        p();
        u();
        r();
        m();
        t();
        q();
        l();
        n();
        for (VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            a(videoTrackClip.getClipId(), videoTrackClip.getEffects());
        }
        Iterator<AudioTrack> it = this.i.getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                a(audioTrackClip.getClipId(), audioTrackClip.getEffects());
            }
        }
        this.f25741a.setFillBackgroundColor(this.i.getConfig().getBackgroundColor());
        setAudioSilence(this.i.getConfig().isMute());
        this.p = true;
        if (this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE && !this.i.getTimeline().getPrimaryTrack().getVideoTrackClips().isEmpty()) {
            b();
        }
        int displayMode = setDisplayMode(this.k);
        if (displayMode != 0) {
            Log.e("AliYunLog", "Set display mode failed!");
            return displayMode;
        }
        this.o = 1;
        return displayMode;
    }

    private synchronized int k() {
        if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
            stop();
        } else {
            int iCancelCompose = cancelCompose();
            if (iCancelCompose != 0) {
                Log.e("AliYunLog", "Cancel compose failed!");
                return iCancelCompose;
            }
        }
        this.t.b();
        this.f25741a.release();
        int iJ = j();
        if (iJ != 0) {
            Log.e("AliYunLog", "Native editor init failed!");
            return iJ;
        }
        this.f25741a.setVolume(this.i.getConfig().getVolume());
        return iJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        AliyunEditorProject aliyunEditorProject;
        if (this.f25741a == null || this.l == null || this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY || (aliyunEditorProject = this.i) == null || aliyunEditorProject.isCustomCover() || this.f25741a.getPlayTime() <= -1) {
            return;
        }
        NativeEditor nativeEditor = this.f25741a;
        Executors.newSingleThreadExecutor().submit(new e(nativeEditor.getFrameAtTime(nativeEditor.getPlayTime())));
    }

    private int w() {
        NativeEditor nativeEditor;
        int clipId;
        int volume;
        if (!h()) {
            return -20011019;
        }
        Iterator<AudioTrack> it = this.i.getTimeline().getAudioTracks().iterator();
        int iMixAlpha = 0;
        while (it.hasNext()) {
            for (AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (com.aliyun.common.utils.g.c(audioTrackClip.getSource().getPath())) {
                    iMixAlpha = this.f25741a.mixAlpha(audioTrackClip.getClipId(), audioTrackClip.getMixWeight());
                    if (iMixAlpha != 0) {
                        Log.e("AliYunLog", "mixAlpha error,ret is " + iMixAlpha + " id is " + audioTrackClip.getClipId());
                    }
                    if (audioTrackClip.getDenoiseWeight() != 0 && (iMixAlpha = this.f25741a.denoise(audioTrackClip.getClipId(), audioTrackClip.getDenoiseWeight() / 100.0f)) != 0) {
                        Log.e("AliYunLog", "denoise error,ret is " + iMixAlpha + " id is " + audioTrackClip.getClipId());
                    }
                }
            }
        }
        for (VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip.getMixWeight() >= 0) {
                nativeEditor = this.f25741a;
                clipId = videoTrackClip.getClipId();
                volume = videoTrackClip.getMixWeight();
            } else {
                nativeEditor = this.f25741a;
                clipId = videoTrackClip.getClipId();
                volume = this.i.getConfig().getVolume();
            }
            int iMixAlpha2 = nativeEditor.mixAlpha(clipId, volume);
            if (iMixAlpha2 != 0) {
                Log.e("AliYunLog", "mixAlpha error,ret is " + iMixAlpha2 + " id is " + videoTrackClip.getClipId());
            }
            if (videoTrackClip.getDenoiseWeight() != 0 && (iMixAlpha2 = this.f25741a.denoise(videoTrackClip.getClipId(), videoTrackClip.getDenoiseWeight() / 100.0f)) != 0) {
                Log.e("AliYunLog", "denoise error,ret is " + iMixAlpha2 + " id is " + videoTrackClip.getClipId());
            }
            iMixAlpha = iMixAlpha2;
        }
        if (this.i.getMVEffect() != null && (iMixAlpha = this.f25741a.mixAlpha(this.i.getMVEffect().getId(), this.i.getMVEffect().getMixWeight())) != 0) {
            Log.e("AliYunLog", " mv setAudioWeight error,ret is " + iMixAlpha + " id is " + this.i.getMVEffect().getId());
        }
        return iMixAlpha;
    }

    public int a(TrackEffect<EffectImage> trackEffect) {
        if (trackEffect == null) {
            return -2;
        }
        this.q.b(trackEffect);
        int iB = this.t.b(trackEffect);
        trackEffect.setViewId(iB);
        return iB;
    }

    public int a(Map<Integer, TransitionBase> map) {
        int i;
        List<VideoTrackClip> videoTrackClips = this.i.getTimeline().getPrimaryTrack().getVideoTrackClips();
        for (Map.Entry<Integer, TransitionBase> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            TransitionBase value = entry.getValue();
            if (value == null) {
                value = new TransitionShutter();
                value.setOverlapDuration(0L);
            }
            if (iIntValue >= 0 && (i = iIntValue + 1) < videoTrackClips.size()) {
                VideoTrackClip videoTrackClip = videoTrackClips.get(i);
                VideoTrackClip videoTrackClip2 = videoTrackClips.get(i - 1);
                long out = (long) ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000000.0f);
                long out2 = (long) ((videoTrackClip2.getOut() - videoTrackClip2.getIn()) * 1000000.0f);
                long overlapDuration = value.getOverlapDuration();
                if (out >= overlapDuration && out2 >= overlapDuration) {
                    a(videoTrackClip, value.getOverlapDuration(TimeUnit.MILLISECONDS));
                    if (value.getOverlapDuration() != 0 || videoTrackClip.getTransition() == null) {
                        videoTrackClip.setTransition(value);
                    } else {
                        videoTrackClip.getEffects().remove(videoTrackClip.getTransition());
                    }
                }
            }
            return -20011022;
        }
        return k();
    }

    public Size a(Context context) {
        int outputWidth = this.i.getConfig().getOutputWidth();
        int outputHeight = this.i.getConfig().getOutputHeight();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int i = point.x;
        return new Size(i, (outputHeight * i) / outputWidth);
    }

    public void a(int i) {
        EditorCallBack editorCallBack;
        this.o = i;
        if (this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY || (editorCallBack = this.w) == null) {
            return;
        }
        editorCallBack.onPlayStateChanged(this.o == 2);
    }

    public void a(AliyunVideoParam aliyunVideoParam) {
        this.j = aliyunVideoParam;
    }

    public void a(PhotoPasterTrack photoPasterTrack) {
        ArrayList<ActionBase> arrayList = new ArrayList(photoPasterTrack.getActions());
        photoPasterTrack.getActions().clear();
        for (ActionBase actionBase : arrayList) {
            actionBase.setTargetId(photoPasterTrack.getId());
            actionBase.setIsStream(false);
            addFrameAnimation(actionBase);
        }
    }

    public void a(com.aliyun.svideosdk.editor.a aVar) {
        this.y = aVar;
    }

    public void a(com.aliyun.svideosdk.editor.c cVar) {
        this.e = cVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addAnimationFilter(EffectFilter effectFilter) {
        if (effectFilter == null) {
            return -2;
        }
        return addAnimationFilter(effectFilter.toTrackEffectFilter());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addAnimationFilter(TrackEffectFilter trackEffectFilter) {
        this.q.a(trackEffectFilter);
        return this.t.a(trackEffectFilter);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addFrameAnimation(ActionBase actionBase) {
        if (actionBase == null) {
            return -20003002;
        }
        if (this.f25741a == null) {
            return -20011019;
        }
        this.q.a(actionBase);
        int iAddFrameAnimation = this.f25741a.addFrameAnimation(actionBase.getTargetId(), actionBase);
        if (iAddFrameAnimation > 0) {
            actionBase.setId(iAddFrameAnimation);
        }
        this.i.addAction(actionBase);
        return iAddFrameAnimation;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addImage(EffectPicture effectPicture) {
        if (effectPicture == null) {
            return -2;
        }
        TrackEffect<EffectImage> trackEffectImage = effectPicture.toTrackEffectImage();
        int iA = a(trackEffectImage);
        effectPicture.setViewId(trackEffectImage.getViewId());
        return iA;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addRunningDisplayMode(VideoDisplayMode videoDisplayMode, int i, long j, long j2) {
        if (!this.p) {
            Log.e("AliYunLog", "Editor not initialized!, addRunningDisplayMode failed.");
            return -4;
        }
        if (videoDisplayMode == null) {
            Log.e("AliYunLog", "Invalid display mode!");
            return -20003002;
        }
        this.q.a(videoDisplayMode, i, j, j2);
        int runningDisplayMode = this.f25741a.setRunningDisplayMode(i, videoDisplayMode.getDisplayMode(), j * 1000, j2 * 1000);
        RunningDisplayMode runningDisplayMode2 = new RunningDisplayMode(i, runningDisplayMode, j, j2, videoDisplayMode.getDisplayMode());
        VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            videoTrackClipById.getEffects().add(runningDisplayMode2);
        }
        return runningDisplayMode;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addTailWaterMark(TrackEffectWaterMark trackEffectWaterMark, long j, TimeUnit timeUnit) {
        String path = trackEffectWaterMark.getPath();
        if (path == null || !new File(path).exists()) {
            return -20003013;
        }
        if (!h()) {
            return -20011019;
        }
        long micros = timeUnit.toMicros(j);
        this.q.a(path, trackEffectWaterMark.getWidthRatio(), trackEffectWaterMark.getHeightRatio(), trackEffectWaterMark.getXRadio(), trackEffectWaterMark.getYRadio(), micros);
        int tailBmp = this.f25741a.setTailBmp(path, trackEffectWaterMark.getWidthRatio(), trackEffectWaterMark.getHeightRatio(), trackEffectWaterMark.getXRadio(), trackEffectWaterMark.getYRadio(), micros);
        if (tailBmp < 0) {
            Log.e("AliYunLog", "addTailWaterMark failed ret is " + tailBmp);
            return tailBmp;
        }
        TailWaterMark tailWaterMark = new TailWaterMark();
        tailWaterMark.setSource(new Source(path));
        tailWaterMark.setDuration(micros);
        tailWaterMark.setWidth(trackEffectWaterMark.getWidthRatio());
        tailWaterMark.setHeight(trackEffectWaterMark.getHeightRatio());
        tailWaterMark.setX(trackEffectWaterMark.getXRadio());
        tailWaterMark.setY(trackEffectWaterMark.getYRadio());
        tailWaterMark.setId(tailBmp);
        this.i.setTailWaterMark(tailWaterMark);
        return tailBmp;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int addTailWaterMark(String str, float f, float f2, float f3, float f4, long j) {
        return addTailWaterMark(new TrackEffectWaterMark.Builder().source(new Source(str)).setXRadio(f3).setYRatio(f4).setWidthRatio(f).setHeightRatio(f2).build(), j, TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyAudioEffect(int i, AudioEffectType audioEffectType, int i2) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        if (audioEffectType == null) {
            return -2;
        }
        if (audioEffectType == AudioEffectType.EFFECT_TYPE_DENOISE) {
            Log.e("AliYunLog", "AudioEffectType.EFFECT_TYPE_DENOISE has been deprecated");
            return -2;
        }
        if (!h()) {
            Log.e("AliYunLog", "audioEffect but not prepared!");
            return -20011019;
        }
        this.f25741a.pause();
        int iAudioEffect = this.f25741a.audioEffect(i, audioEffectType.getEffectType(), i2 / 100.0f);
        this.i.addEffect(i, new AudioEffect(audioEffectType, i2));
        a(3);
        return iAudioEffect;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyBlurBackground(int i, long j, long j2, float f) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not applyBlurBackground");
            return -20011019;
        }
        if (!h()) {
            return -20011019;
        }
        this.q.a(i, j, j2, f);
        int iApplyBlurBackground = this.f25741a.applyBlurBackground(i, j * 1000, j2 * 1000, f);
        BlurBackground blurBackground = new BlurBackground(i, iApplyBlurBackground, j, j2, f);
        VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            videoTrackClipById.getEffects().add(blurBackground);
        }
        a(3);
        return iApplyBlurBackground;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyDub(EffectBean effectBean) {
        if (effectBean == null) {
            return -2;
        }
        return applyDub(effectBean.toTrackAudioStream());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyDub(TrackAudioStream trackAudioStream) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not apply dub");
            return -20011019;
        }
        if (trackAudioStream == null || trackAudioStream.getSource() == null || com.aliyun.common.utils.q.b(trackAudioStream.getSource().getPath()) || !new File(trackAudioStream.getSource().getPath()).exists()) {
            return -2;
        }
        if (!h()) {
            return -20011019;
        }
        this.f25741a.pause();
        this.q.a(trackAudioStream);
        int iDub = this.f25741a.dub(trackAudioStream.getSource().getPath(), trackAudioStream.getAudioWeight() / 10, trackAudioStream.getStartTime() * 1000, (trackAudioStream.getStartTime() + trackAudioStream.getStreamDuration()) * 1000, trackAudioStream.getStreamStartTime() * 1000, trackAudioStream.getStreamDuration() * 1000);
        trackAudioStream.setStreamId(iDub);
        AudioTrackClip audioTrackClip = new AudioTrackClip();
        audioTrackClip.setClipId(iDub);
        audioTrackClip.setType(AudioTrackClip.Type.Dubs);
        audioTrackClip.setSource(trackAudioStream.getSource());
        audioTrackClip.setIn(trackAudioStream.getStreamStartTime() / 1000.0f);
        audioTrackClip.setOut(audioTrackClip.getIn() + (trackAudioStream.getStreamDuration() / 1000.0f));
        audioTrackClip.setTimelineIn(trackAudioStream.getStartTime() / 1000.0f);
        audioTrackClip.setTimelineOut((trackAudioStream.getStartTime() + trackAudioStream.getStreamDuration()) / 1000.0f);
        audioTrackClip.setMixWeight(trackAudioStream.getAudioWeight());
        this.i.addAudioTrackClip(audioTrackClip);
        a(3);
        return iDub;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyFilter(EffectBean effectBean) {
        return TextUtils.isEmpty(effectBean.getPath()) ? removeFilter() : applyFilter(effectBean.toTrackEffectFilter());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyFilter(TrackEffectFilter trackEffectFilter) {
        if (!this.p) {
            return -20011019;
        }
        if (trackEffectFilter == null) {
            return -20003014;
        }
        if (trackEffectFilter.getSource() != null && trackEffectFilter.getSource().getPath() != null && !new File(trackEffectFilter.getSource().getPath()).exists()) {
            return -20003014;
        }
        this.q.a(trackEffectFilter.getBean());
        int iA = a(trackEffectFilter.getSource() == null ? null : trackEffectFilter.getSource().getPath(), trackEffectFilter.getStartTime() * 1000, trackEffectFilter.getDuration() * 1000, 1);
        if (iA == 0 && trackEffectFilter.getSource() != null) {
            if (trackEffectFilter.getSource() != null && com.aliyun.common.utils.q.b(trackEffectFilter.getSource().getId())) {
                trackEffectFilter.getSource().setId(String.valueOf(trackEffectFilter.getResId()));
            }
            Filter filter = new Filter(trackEffectFilter.getSource());
            filter.setType(EffectTrack.Type.filter);
            filter.setTimelineIn(trackEffectFilter.getStartTime() / 1000.0f);
            filter.setTimelineOut(filter.getTimelineIn() + (trackEffectFilter.getDuration() / 1000.0f));
            filter.setSource(trackEffectFilter.getSource());
            filter.setId(trackEffectFilter.getResId());
            this.i.setColorEffect(filter);
        }
        return iA;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyLutFilter(LUTEffectBean lUTEffectBean) {
        if (!this.p) {
            return -20011019;
        }
        if (lUTEffectBean == null) {
            int iA = a(null, 0.0f, 0L, 0L, 1);
            this.i.setLutEffect(null);
            return iA;
        }
        if (lUTEffectBean.getSource() != null && lUTEffectBean.getSource().getPath() != null && !new File(lUTEffectBean.getSource().getPath()).exists()) {
            return -20003014;
        }
        this.q.a(lUTEffectBean);
        int iA2 = a(lUTEffectBean.getSource() != null ? lUTEffectBean.getSource().getPath() : null, lUTEffectBean.getIntensity(), 0L, 2147483647L, 1);
        if (iA2 == 0) {
            Filter filter = new Filter(lUTEffectBean.getSource());
            filter.setType(EffectTrack.Type.lut_filter);
            filter.setTimelineIn(0.0f);
            filter.setTimelineOut(filter.getTimelineIn() + 2147483.8f);
            filter.setIntensity(lUTEffectBean.getIntensity());
            this.i.setLutEffect(filter);
        }
        return iA2;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMV(EffectBean effectBean) {
        if (effectBean == null) {
            return -2;
        }
        return applyMV(effectBean.toTrackMV());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMV(TrackEffectMV trackEffectMV) {
        if (!this.p) {
            return -20011019;
        }
        if (trackEffectMV == null || trackEffectMV.getSource() == null || trackEffectMV.getSource().getPath() == null || !new File(trackEffectMV.getSource().getPath()).exists()) {
            return -20003022;
        }
        this.f25741a.pause();
        this.q.a(trackEffectMV);
        int iApplyMv = this.f25741a.applyMv(trackEffectMV.getSource().getPath(), trackEffectMV.getStartTime() * 1000, 1000 * trackEffectMV.getDuration());
        trackEffectMV.setViewId(iApplyMv);
        trackEffectMV.setAudioStreamId(this.f25741a.getMvAudioId());
        if (trackEffectMV.getSource() != null && com.aliyun.common.utils.q.b(trackEffectMV.getSource().getId())) {
            trackEffectMV.getSource().setId(String.valueOf(trackEffectMV.getViewId()));
        }
        MVFilter mVFilter = new MVFilter();
        mVFilter.setId(this.f25741a.getMvAudioId());
        mVFilter.setSource(trackEffectMV.getSource());
        mVFilter.setTimelineIn(trackEffectMV.getStartTime() / 1000.0f);
        mVFilter.setTimelineOut((trackEffectMV.getStartTime() + trackEffectMV.getDuration()) / 1000.0f);
        this.i.setMVEffect(mVFilter);
        a(3);
        return iApplyMv;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMusic(EffectBean effectBean) {
        if (effectBean == null) {
            return -2;
        }
        return applyMusic(effectBean.toTrackAudioStream());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMusic(TrackAudioStream trackAudioStream) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not apply music");
            return -20011019;
        }
        if (trackAudioStream == null || trackAudioStream.checkIsInvalid()) {
            return -2;
        }
        if (!h()) {
            return -20011019;
        }
        this.f25741a.pause();
        this.q.b(trackAudioStream);
        int iMix = this.f25741a.mix(trackAudioStream.getSource().getPath(), trackAudioStream.getAudioWeight() / 10, trackAudioStream.getStartTime() * 1000, (trackAudioStream.getStartTime() + trackAudioStream.getStreamDuration()) * 1000, trackAudioStream.getStreamStartTime() * 1000, trackAudioStream.getStreamDuration() * 1000);
        trackAudioStream.setStreamId(iMix);
        AudioTrackClip audioTrackClip = new AudioTrackClip();
        audioTrackClip.setClipId(iMix);
        audioTrackClip.setType(AudioTrackClip.Type.Music);
        audioTrackClip.setSource(trackAudioStream.getSource());
        audioTrackClip.setIn(trackAudioStream.getStreamStartTime() / 1000.0f);
        audioTrackClip.setOut(audioTrackClip.getIn() + (trackAudioStream.getStreamDuration() / 1000.0f));
        audioTrackClip.setTimelineIn(trackAudioStream.getStartTime() / 1000.0f);
        audioTrackClip.setTimelineOut((trackAudioStream.getStartTime() + trackAudioStream.getStreamDuration()) / 1000.0f);
        audioTrackClip.setMixWeight(trackAudioStream.getAudioWeight());
        this.i.addAudioTrackClip(audioTrackClip);
        a(3);
        return iMix;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMusicMixWeight(int i, int i2) {
        String str;
        if (!this.p) {
            str = "Not initialized ,so can not apply music mix weight";
        } else {
            if (h()) {
                int i3 = i2 > 50 ? 100 - ((i2 - 50) * 2) : 100;
                int i4 = i2 < 50 ? 100 - ((50 - i2) * 2) : 100;
                this.q.a(i, i2);
                int iMixAlpha = this.f25741a.mixAlpha(i, ((i4 - 1) / 10) + 1);
                this.i.setMusicWeight(i, i4);
                if (iMixAlpha != 0) {
                    return iMixAlpha;
                }
                for (VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
                    int iMixAlpha2 = this.f25741a.mixAlpha(videoTrackClip.getClipId(), ((i3 - 1) / 10) + 1);
                    if (iMixAlpha2 != 0) {
                        return iMixAlpha2;
                    }
                    videoTrackClip.setMixWeight(i3);
                }
                return 0;
            }
            str = "Not prepare ,so can not apply music mix weight";
        }
        Log.e("AliYunLog", str);
        return -20011019;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyMusicWeight(int i, int i2) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not apply music mix weight");
            return -20011019;
        }
        if (i2 < 0) {
            i2 = 50;
        }
        int i3 = i2 != 0 ? ((i2 - 1) / 10) + 1 : i2;
        this.q.b(i, i2);
        int iMixAlpha = this.f25741a.mixAlpha(i, i3);
        if (iMixAlpha != 0) {
            return iMixAlpha;
        }
        this.i.setMusicWeight(i, i2);
        return iMixAlpha;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applySourceChange() {
        String str;
        if (this.b == null) {
            return -20003019;
        }
        this.q.d();
        int mediaPartCount = this.b.getMediaPartCount();
        MainVideoTrackClip[] mainVideoTrackClipArr = new MainVideoTrackClip[mediaPartCount];
        VideoTrack primaryTrack = this.i.getTimeline().getPrimaryTrack();
        primaryTrack.getVideoTrackClips().clear();
        for (int i = 0; i < this.b.getMediaPartCount(); i++) {
            AliyunClip mediaPart = this.b.getMediaPart(i);
            String source = mediaPart.getSource();
            if (!TextUtils.isEmpty(source) && new File(source).exists()) {
                MainVideoTrackClip mainVideoTrackClip = new MainVideoTrackClip();
                mainVideoTrackClip.setSource(new Source(mediaPart.getSource()));
                mainVideoTrackClip.setTransition(mediaPart.getTransition());
                mainVideoTrackClip.setDisplayMode(mediaPart.getDisplayMode().ordinal());
                if (mediaPart.getMediaType() == MediaType.ANY_IMAGE_TYPE) {
                    mainVideoTrackClip.setIn(0.0f);
                    mainVideoTrackClip.setOut(((AliyunImageClip) mediaPart).getDuration() / 1000.0f);
                    mainVideoTrackClip.setDuration(9.223372E18f);
                    mainVideoTrackClip.setType(1);
                } else if (mediaPart.getMediaType() == MediaType.ANY_VIDEO_TYPE) {
                    AliyunVideoClip aliyunVideoClip = (AliyunVideoClip) mediaPart;
                    mainVideoTrackClip.setIn(aliyunVideoClip.getStartTime() / 1000.0f);
                    mainVideoTrackClip.setOut(aliyunVideoClip.getEndTime() / 1000.0f);
                    mainVideoTrackClip.setDuration(aliyunVideoClip.getDuration() / 1000.0f);
                    mainVideoTrackClip.setRotation(aliyunVideoClip.getRotation());
                    mainVideoTrackClip.setType(0);
                }
                mainVideoTrackClip.setClipId(mediaPart.getId());
                mainVideoTrackClip.setWidth(mediaPart.getClipWidth());
                mainVideoTrackClip.setHeight(mediaPart.getClipHeight());
                if (i < this.i.getTimeline().getPrimaryTrack().getVideoTrackClips().size()) {
                    mainVideoTrackClip.getEffects().addAll(this.i.getTimeline().getPrimaryTrack().getVideoTrackClips().get(i).getEffects());
                }
                mainVideoTrackClipArr[i] = mainVideoTrackClip;
                primaryTrack.getVideoTrackClips().add(mainVideoTrackClip);
            }
        }
        this.i.refreshTimeLine();
        this.h = c();
        for (VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip.getTransition() != null) {
                a(videoTrackClip, videoTrackClip.getTransition().getOverlapDuration(TimeUnit.MILLISECONDS));
            }
        }
        if (mediaPartCount == 0) {
            stop();
            this.f25741a.release();
            return 0;
        }
        if (g()) {
            return 0;
        }
        int iK = k();
        if (iK != 0) {
            str = "reset failed!";
        } else {
            iK = stop();
            if (iK == 0) {
                if (this.b != null) {
                    this.b.updateAllClips(new t(this.i.getTimeline().getPrimaryTrack().getVideoTrackClips(), this).getAllClips());
                }
                return iK;
            }
            str = "Stop play failed!";
        }
        Log.e("AliYunLog", str);
        return iK;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyWaterMark(TrackEffectWaterMark trackEffectWaterMark) {
        WaterMark waterMark = new WaterMark();
        waterMark.setX(trackEffectWaterMark.getXRadio());
        waterMark.setY(trackEffectWaterMark.getYRadio());
        waterMark.setWidth(trackEffectWaterMark.getWidthRatio());
        waterMark.setHeight(trackEffectWaterMark.getHeightRatio());
        waterMark.setSource(trackEffectWaterMark.getSource());
        this.q.a(trackEffectWaterMark.getPath(), trackEffectWaterMark.getXRadio(), trackEffectWaterMark.getYRadio(), trackEffectWaterMark.getWidthRatio(), trackEffectWaterMark.getHeightRatio());
        int effectWaterMark = this.t.setEffectWaterMark(a(waterMark));
        if (effectWaterMark >= 0) {
            waterMark.setId(effectWaterMark);
            this.i.setWaterMark(waterMark);
            return effectWaterMark;
        }
        Log.e("AliYunLog", "applyWaterMark failed ret is " + effectWaterMark);
        return effectWaterMark;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int applyWaterMark(String str, float f, float f2, float f3, float f4) {
        return applyWaterMark(new TrackEffectWaterMark.Builder().source(new Source(str)).setXRadio(f3).setYRatio(f4).setWidthRatio(f).setHeightRatio(f2).build());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int audioEffect(int i, AudioEffectType audioEffectType, int i2) {
        return applyAudioEffect(i, audioEffectType, i2);
    }

    public void b(TrackEffect<EffectImage> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        this.q.d(trackEffect);
        this.t.d(trackEffect);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int cancelCompose() {
        if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE && this.o == 5) {
            this.q.e();
            this.f25741a.stop();
            a(4);
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void clearAllAnimationFilter() {
        this.q.f();
        this.t.a();
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:29:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:32:0x010a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0112  */
    /* JADX WARN: Code duplicated, block: B:37:0x011b  */
    /* JADX WARN: Code duplicated, block: B:44:0x013c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0180  */
    /* JADX WARN: Code duplicated, block: B:47:0x0184  */
    /* JADX WARN: Code duplicated, block: B:49:0x018c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0190  */
    /* JADX WARN: Code duplicated, block: B:52:0x019a  */
    /* JADX WARN: Code duplicated, block: B:53:0x019e  */
    /* JADX WARN: Code duplicated, block: B:56:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:57:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e2  */
    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int compose(AliyunVideoParam aliyunVideoParam, String str, AliyunIComposeCallBack aliyunIComposeCallBack) {
        AliyunVideoParam aliyunVideoParam2;
        int outputWidth;
        int outputHeight;
        int i;
        int displayMode;
        int iStart;
        String str2;
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call compose!");
            return -4;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("AliYunLog", "Output path is null!");
            return -20011020;
        }
        File parentFile = new File(str).getParentFile();
        if (parentFile != null) {
            displayMode = -10001010;
            if (parentFile.exists() && !parentFile.isDirectory()) {
                str2 = "Cannot generate mp4,because exist same name file in parent dir!";
            } else if (parentFile.exists() || parentFile.mkdirs()) {
                if (aliyunVideoParam == null) {
                    aliyunVideoParam2 = new AliyunVideoParam();
                    aliyunVideoParam2.setScaleMode(VideoDisplayMode.valueOf(this.i.getConfig().getDisplayMode()));
                    aliyunVideoParam2.setVideoQuality(VideoQuality.values()[this.i.getConfig().getVideoQuality()]);
                    aliyunVideoParam2.setBitrate(this.i.getConfig().getBitrate());
                    aliyunVideoParam2.setFrameRate(this.i.getConfig().getFps());
                    aliyunVideoParam2.setGop(this.i.getConfig().getGop());
                    aliyunVideoParam2.setCrf(this.i.getConfig().getCrf());
                    aliyunVideoParam2.setVideoCodec(VideoCodecs.getInstanceByValue(this.i.getConfig().getVideoCodec()));
                    aliyunVideoParam2.setScaleRate(this.i.getConfig().getScale());
                } else {
                    aliyunVideoParam2 = aliyunVideoParam;
                }
                outputWidth = (int) (this.i.getConfig().getOutputWidth() * aliyunVideoParam2.getScaleRate());
                if (outputWidth % 2 != 0) {
                    outputWidth--;
                }
                outputHeight = (int) (this.i.getConfig().getOutputHeight() * aliyunVideoParam2.getScaleRate());
                if (outputHeight % 2 != 0) {
                    outputHeight--;
                }
                i = outputHeight;
                if (this.o == 5) {
                    Log.e("AliYunLog", "Duplicate compose!");
                    return -20011018;
                }
                if (this.f25741a.isNativePrepared() && stop() != 0) {
                    Log.e("AliYunLog", "Editor has been prepared, stop failed before composing!");
                }
                this.g = this.f25741a.getDuration();
                if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
                    this.e = com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE;
                    displayMode = this.f25741a.setEncodeParam(aliyunVideoParam2.getBitrate(), aliyunVideoParam2.getFrameRate(), aliyunVideoParam2.getGop(), aliyunVideoParam2.getVideoQuality().ordinal(), aliyunVideoParam2.getCrf(), aliyunVideoParam2.getVideoCodec().ordinal(), outputWidth, i, aliyunVideoParam2.getAudioSampleRate().getValue(), aliyunVideoParam2.getAudioChannel().getValue());
                    if (displayMode != 0) {
                        str2 = "Set compose param failed!";
                    } else {
                        displayMode = this.f25741a.setOutputPath(str);
                        if (displayMode != 0) {
                            str2 = "Set output path failed!";
                        } else {
                            displayMode = this.f25741a.setMode(this.e);
                            if (displayMode != 0) {
                                str2 = "Set editor mode failed!";
                            }
                        }
                    }
                }
                displayMode = this.f25741a.setDisplayMode(aliyunVideoParam2.getScaleMode().ordinal());
                if (displayMode == 0) {
                    str2 = "Set editor display mode failed!";
                } else {
                    if (!this.f25741a.isNativePrepared() || (displayMode = this.f25741a.prepare()) == 0) {
                        this.q.a(aliyunVideoParam2, str);
                        this.f25741a.setDisplaySize(outputWidth, i);
                        iStart = this.f25741a.start();
                        if (iStart != 0) {
                            Log.e("AliYunLog", "Compose failed!");
                            return iStart;
                        }
                        this.j = aliyunVideoParam2;
                        this.x = aliyunIComposeCallBack;
                        this.e = com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE;
                        a(5);
                        this.E = System.nanoTime();
                        return 0;
                    }
                    str2 = "Editor prepare failed!";
                }
            } else {
                str2 = "Invalid output path:" + str;
            }
        } else {
            if (aliyunVideoParam == null) {
                aliyunVideoParam2 = new AliyunVideoParam();
                aliyunVideoParam2.setScaleMode(VideoDisplayMode.valueOf(this.i.getConfig().getDisplayMode()));
                aliyunVideoParam2.setVideoQuality(VideoQuality.values()[this.i.getConfig().getVideoQuality()]);
                aliyunVideoParam2.setBitrate(this.i.getConfig().getBitrate());
                aliyunVideoParam2.setFrameRate(this.i.getConfig().getFps());
                aliyunVideoParam2.setGop(this.i.getConfig().getGop());
                aliyunVideoParam2.setCrf(this.i.getConfig().getCrf());
                aliyunVideoParam2.setVideoCodec(VideoCodecs.getInstanceByValue(this.i.getConfig().getVideoCodec()));
                aliyunVideoParam2.setScaleRate(this.i.getConfig().getScale());
            } else {
                aliyunVideoParam2 = aliyunVideoParam;
            }
            outputWidth = (int) (this.i.getConfig().getOutputWidth() * aliyunVideoParam2.getScaleRate());
            if (outputWidth % 2 != 0) {
                outputWidth--;
            }
            outputHeight = (int) (this.i.getConfig().getOutputHeight() * aliyunVideoParam2.getScaleRate());
            if (outputHeight % 2 != 0) {
                outputHeight--;
            }
            i = outputHeight;
            if (this.o == 5) {
                Log.e("AliYunLog", "Duplicate compose!");
                return -20011018;
            }
            if (this.f25741a.isNativePrepared()) {
                Log.e("AliYunLog", "Editor has been prepared, stop failed before composing!");
            }
            this.g = this.f25741a.getDuration();
            if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
                this.e = com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE;
                displayMode = this.f25741a.setEncodeParam(aliyunVideoParam2.getBitrate(), aliyunVideoParam2.getFrameRate(), aliyunVideoParam2.getGop(), aliyunVideoParam2.getVideoQuality().ordinal(), aliyunVideoParam2.getCrf(), aliyunVideoParam2.getVideoCodec().ordinal(), outputWidth, i, aliyunVideoParam2.getAudioSampleRate().getValue(), aliyunVideoParam2.getAudioChannel().getValue());
                if (displayMode != 0) {
                    str2 = "Set compose param failed!";
                } else {
                    displayMode = this.f25741a.setOutputPath(str);
                    if (displayMode != 0) {
                        str2 = "Set output path failed!";
                    } else {
                        displayMode = this.f25741a.setMode(this.e);
                        if (displayMode != 0) {
                            str2 = "Set editor mode failed!";
                        }
                    }
                }
            }
            displayMode = this.f25741a.setDisplayMode(aliyunVideoParam2.getScaleMode().ordinal());
            if (displayMode == 0) {
                if (this.f25741a.isNativePrepared()) {
                }
                this.q.a(aliyunVideoParam2, str);
                this.f25741a.setDisplaySize(outputWidth, i);
                iStart = this.f25741a.start();
                if (iStart != 0) {
                    Log.e("AliYunLog", "Compose failed!");
                    return iStart;
                }
                this.j = aliyunVideoParam2;
                this.x = aliyunIComposeCallBack;
                this.e = com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE;
                a(5);
                this.E = System.nanoTime();
                return 0;
            }
            str2 = "Set editor display mode failed!";
        }
        Log.e("AliYunLog", str2);
        return displayMode;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunPasterManager createPasterManager() {
        return this.s;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunRollCaptionComposer createRollCaptionComposer() {
        return this.u;
    }

    public int d() {
        return this.G;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int deleteBlurBackground(int i, int i2) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not applyBlurBackground");
            return -20011019;
        }
        if (!h()) {
            return -20011019;
        }
        this.q.c(i, i2);
        int iDeleteBlurBackground = this.f25741a.deleteBlurBackground(i, i2);
        VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            for (Effect effect : videoTrackClipById.getEffects()) {
                if (effect.getType() == Effect.Type.blur_background && (effect instanceof RunningDisplayMode) && ((RunningDisplayMode) effect).getId() == i2) {
                    videoTrackClipById.getEffects().remove(effect);
                }
            }
        }
        a(3);
        return iDeleteBlurBackground;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int deleteTimeEffect(int i) {
        this.f25741a.pause();
        this.q.a(i);
        int iDeleteTimeEffect = this.f25741a.deleteTimeEffect(i);
        if (iDeleteTimeEffect != 0) {
            return iDeleteTimeEffect;
        }
        this.i.removeTimeFilter(i);
        a(3);
        return iDeleteTimeEffect;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int denoise(int i, int i2) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not denoise");
            return -20011019;
        }
        this.q.a(i, i2 != 0);
        int iDenoise = this.f25741a.denoise(i, i2 / 100.0f);
        if (iDenoise != 0) {
            return iDenoise;
        }
        this.i.setDenoise(i, i2);
        return iDenoise;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int denoise(int i, boolean z) {
        return denoise(i, z ? 20 : 0);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int draw(long j) {
        return draw(j, TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int draw(long j, TimeUnit timeUnit) {
        int iPrepare = (!this.p || this.f25741a.isNativePrepared()) ? 0 : this.f25741a.prepare();
        if (iPrepare != 0) {
            Log.e("AliYunLog", "Editor prepare failed!");
            return iPrepare;
        }
        if (!h() || i()) {
            return -20011019;
        }
        int iDraw = this.f25741a.draw(timeUnit.toMicros(j));
        a(3);
        return iDraw;
    }

    public int e() {
        return this.F;
    }

    public int f() {
        return this.i.getConfig().getOutputWidth();
    }

    public synchronized boolean g() {
        return this.o == 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunLogInfo getAliyunLogInfo() {
        return this.D;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public long getClipStartTime(int i) {
        if (this.p) {
            return this.f25741a.getClipStartTime(i);
        }
        Log.e("AliYunLog", "Not initialized ,so can not get clip startTime");
        return -20011019L;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public Bitmap getCurrentFrame() {
        NativeEditor nativeEditor = this.f25741a;
        Bitmap frameAtTime = nativeEditor.getFrameAtTime(nativeEditor.getPlayTime());
        if (frameAtTime == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(180.0f);
        matrix.postScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public long getCurrentPlayPosition() {
        NativeEditor nativeEditor;
        if (!this.p || (nativeEditor = this.f25741a) == null) {
            return 0L;
        }
        return nativeEditor.getPlayTime();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public long getCurrentStreamPosition() {
        NativeEditor nativeEditor;
        if (!this.p || (nativeEditor = this.f25741a) == null) {
            return 0L;
        }
        return nativeEditor.getStreamPlayTime();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public long getDuration() {
        NativeEditor nativeEditor;
        if (!this.p || (nativeEditor = this.f25741a) == null) {
            return 0L;
        }
        return nativeEditor.getDuration();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunEditorProject getEditorProject() {
        return this.i;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getFilterLastApplyId() {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so no filter id");
            return -20011019;
        }
        Filter colorEffect = this.i.getColorEffect();
        if (colorEffect != null) {
            return colorEffect.getSource().getIntId();
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getMVLastApplyId() {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so no mv id");
            return -20011019;
        }
        MVFilter mVEffect = this.i.getMVEffect();
        if (mVEffect != null) {
            return mVEffect.getSource().getIntId();
        }
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getMusicLastApplyId() {
        if (this.p) {
            return this.i.getAudioId();
        }
        Log.e("AliYunLog", "Not initialized ,so no music id");
        return -20011019;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public Paint getPaintLastApply() {
        List<CanvasAction> listTransfer;
        if (!this.p) {
            Log.e("AliYunLog", "Editor not initialized, so get last applied paint,return null");
            return null;
        }
        if (this.i.getCanvasTrack() == null) {
            Log.i("AliYunLog", "Project getCanvasInfo is null, so get last applied paint, return null");
            return null;
        }
        if (this.i.getCanvasTrack().getCanvasInfo() == null || (listTransfer = this.i.getCanvasTrack().getCanvasInfo().convertCoordinate(this.F, this.G, true).transfer()) == null || listTransfer.size() <= 0) {
            return null;
        }
        return listTransfer.get(listTransfer.size() - 1).getPaint();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunPasterManager getPasterManager() {
        return this.s;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunPasterRender getPasterRender() {
        return this.t;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunIPipManager getPipManager() {
        return this.v;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunIPlayerController getPlayerController() {
        if (this.n == null) {
            this.n = new s(this);
        }
        return this.n;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunIProjectInfo getProjectInfo() {
        return this.r;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getRotation() {
        AliyunEditorProject aliyunEditorProject = this.i;
        if (aliyunEditorProject == null || aliyunEditorProject.getTimeline().getPrimaryTrack().getVideoTrackClips().size() <= 0) {
            return 0;
        }
        return this.i.getTimeline().getPrimaryTrack().getVideoTrackClips().get(0).getRotation();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunISourcePartManager getSourcePartManager() {
        AliyunEditorProject aliyunEditorProject = this.i;
        if (aliyunEditorProject == null) {
            Log.e("AliYunLog", "Project or primary track is null,so create AliyunIPlayer failed");
            return null;
        }
        if (this.b == null) {
            this.b = new t(aliyunEditorProject.getTimeline().getPrimaryTrack().getVideoTrackClips(), this);
        }
        return this.b;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public long getStreamDuration() {
        NativeEditor nativeEditor;
        if (!this.p || (nativeEditor = this.f25741a) == null) {
            return 0L;
        }
        return nativeEditor.getStreamDuration();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public TimeEffectType getTimeEffect() {
        if (h()) {
            int timeEffect = this.f25741a.getTimeEffect();
            if (timeEffect >= 0 && timeEffect <= TimeEffectType.values().length) {
                TimeEffectType typeByValue = TimeEffectType.getTypeByValue(timeEffect);
                if (typeByValue == null) {
                    Log.e("AliYunLog", "Invalid return value " + timeEffect);
                }
                return typeByValue;
            }
            Log.e("AliYunLog", "Editor error!ErrorCode:" + timeEffect);
        }
        Log.e("AliYunLog", "Editor not initialized!,getTimeEffect failed.");
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getVideoHeight() {
        return this.i.getConfig().getOutputHeight();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int getVideoWidth() {
        return this.i.getConfig().getOutputWidth();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int init(SurfaceView surfaceView, Context context) {
        Size sizeA = a(context);
        return init(surfaceView, context, sizeA.getWidth(), sizeA.getHeight());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int init(SurfaceView surfaceView, Context context, int i, int i2) {
        StringBuilder sb;
        String str;
        if (this.q == null) {
            AliyunEditorProject aliyunEditorProject = this.i;
            this.q = new com.aliyun.common.c.b.b(context, aliyunEditorProject == null ? "0" : aliyunEditorProject.getRequestID());
        }
        this.t.a(context.getExternalFilesDir(""));
        this.q.g();
        this.D = new AliyunLogInfo(f.class.getName());
        AliyunEditorProject aliyunEditorProject2 = this.i;
        if (aliyunEditorProject2 == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Editor init project failed");
            return -20003019;
        }
        int outputWidth = aliyunEditorProject2.getConfig().getOutputWidth();
        int outputHeight = this.i.getConfig().getOutputHeight();
        if (outputWidth <= 0 || outputHeight <= 0) {
            sb = new StringBuilder();
            str = "Invalid output size, width[";
        } else {
            this.F = i;
            this.G = i2;
            this.u.a(i, i2);
            if (outputWidth % 2 == 0 && outputHeight % 2 == 0) {
                if (surfaceView != null) {
                    this.B = surfaceView;
                    surfaceView.getHolder().addCallback(this.I);
                }
                this.u.a(context);
                return j();
            }
            sb = new StringBuilder();
            str = "Output size must be even number, width[";
        }
        sb.append(str);
        sb.append(outputWidth);
        sb.append("],height[");
        sb.append(outputHeight);
        sb.append("]");
        com.aliyun.common.c.a.a.b("AliYunLog", sb.toString());
        return -2;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int invert() {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call invert!");
            return -4;
        }
        if (this.f25741a.pause() == 0) {
            a(3);
        } else {
            Log.w("AliYunLog", "invert pause failed!");
        }
        this.q.h();
        int iInvert = this.f25741a.invert();
        if (iInvert != 0) {
            return iInvert;
        }
        this.i.addTimeFilter(new TimeFilter(iInvert, 0L, 0L, TimeEffectType.TIME_EFFECT_TYPE_INVERT.ordinal(), 0.0f, false));
        return iInvert;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public boolean isAudioSilence() {
        AliyunEditorProject aliyunEditorProject = this.i;
        if (aliyunEditorProject == null) {
            return false;
        }
        return aliyunEditorProject.getConfig().isMute();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public boolean isPaused() {
        return this.o == 3;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public boolean isPlaying() {
        return this.o == 2;
    }

    public void l() {
        this.t.c();
    }

    public void m() {
        int repeat;
        if (this.i.getTimeline().getEffectTracks() == null || this.i.getTimeline().getEffectTracks().isEmpty()) {
            return;
        }
        ArrayList<EffectTrack> arrayList = new ArrayList();
        arrayList.addAll(this.i.getTimeline().getEffectTracks());
        this.i.getTimeline().getEffectTracks().clear();
        ArrayList arrayList2 = new ArrayList();
        for (EffectTrack effectTrack : arrayList) {
            if (effectTrack.getType() == EffectTrack.Type.time_effect) {
                TimeFilter timeFilter = (TimeFilter) effectTrack;
                if (timeFilter.getTimeFilterType() == TimeEffectType.TIME_EFFECT_TYPE_INVERT.ordinal()) {
                    repeat = this.f25741a.invert();
                } else if (timeFilter.getTimeFilterType() == TimeEffectType.TIME_EFFECT_TYPE_RATE.ordinal()) {
                    repeat = this.f25741a.setRate(timeFilter.getParam(), timeFilter.getStartTime() * 1000, timeFilter.getDuration() * 1000, timeFilter.isNeedOriginDuration());
                } else {
                    if (timeFilter.getTimeFilterType() == TimeEffectType.TIME_EFFECT_TYPE_REPEAT.ordinal()) {
                        repeat = this.f25741a.setRepeat((int) timeFilter.getParam(), timeFilter.getStartTime() * 1000, timeFilter.getDuration() * 1000, timeFilter.isNeedOriginDuration());
                    }
                    this.i.addTimeFilter(timeFilter);
                }
                timeFilter.setId(repeat);
                this.i.addTimeFilter(timeFilter);
            } else if (effectTrack.getType() == EffectTrack.Type.filter) {
                Filter filter = (Filter) effectTrack;
                if (com.aliyun.common.utils.g.c(filter.getSource().getPath())) {
                    a(filter.getSource().getPath(), (long) (filter.getTimelineIn() * 1000000.0f), (long) ((filter.getTimelineIn() - filter.getTimelineOut()) * 1000000.0f), 1);
                }
                this.i.setColorEffect(filter);
            } else if (effectTrack.getType() == EffectTrack.Type.animation_filter) {
                Filter filter2 = (Filter) effectTrack;
                TrackEffectFilter.Builder builder = new TrackEffectFilter.Builder();
                long duration = filter2.getDuration();
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                TrackEffectFilter trackEffectFilterBuild = builder.duration(duration, timeUnit).startTime(filter2.getStartTime(), timeUnit).source(filter2.getSource()).effectConfig(filter2.getEffectConfig()).build();
                a(trackEffectFilterBuild);
                arrayList2.add(trackEffectFilterBuild);
            } else if (effectTrack.getType() == EffectTrack.Type.mv) {
                MVFilter mVFilter = (MVFilter) effectTrack;
                if (com.aliyun.common.utils.g.c(mVFilter.getSource().getPath())) {
                    this.f25741a.applyMv(mVFilter.getSource().getPath(), (long) (mVFilter.getTimelineIn() * 1000000.0f), (long) (mVFilter.getTimelineOut() * 1000000.0f));
                    mVFilter.setId(this.f25741a.getMvAudioId());
                    if (mVFilter.isMute()) {
                        this.f25741a.resetEffect(EffectType.EFFECT_TYPE_MV_AUDIO.ordinal());
                    }
                }
                this.i.setMVEffect(mVFilter);
            } else if (effectTrack.getType() == EffectTrack.Type.lut_filter) {
                Filter filter3 = (Filter) effectTrack;
                if (com.aliyun.common.utils.g.c(filter3.getSource().getPath())) {
                    a(filter3.getSource().getPath(), filter3.getIntensity(), (long) (filter3.getTimelineIn() * 1000.0f), (long) ((filter3.getTimelineOut() - filter3.getTimelineIn()) * 1000.0f), 1);
                }
                this.i.setLutEffect(filter3);
            }
        }
        OnAnimationFilterRestoredListener onAnimationFilterRestoredListener = this.A;
        if (onAnimationFilterRestoredListener != null) {
            onAnimationFilterRestoredListener.onAnimationFilterRestored(arrayList2);
        }
    }

    public void n() {
        for (VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            this.f25741a.setHorizontalFlip(videoTrackClip.getClipId(), videoTrackClip.isHorizontalFlip());
        }
    }

    public void o() {
        Iterator<AudioTrack> it = this.i.getTimeline().getAudioTracks().iterator();
        while (it.hasNext()) {
            for (AudioTrackClip audioTrackClip : it.next().getAudioTrackClips()) {
                if (com.aliyun.common.utils.g.c(audioTrackClip.getSource().getPath())) {
                    audioTrackClip.setClipId(audioTrackClip.getType() == AudioTrackClip.Type.Music ? this.f25741a.mix(audioTrackClip.getSource().getPath(), audioTrackClip.getMixWeight() / 10, (long) (audioTrackClip.getTimelineIn() * 1000000.0f), (long) ((audioTrackClip.getTimelineOut() - audioTrackClip.getTimelineIn()) * 1000000.0f), (long) (audioTrackClip.getIn() * 1000000.0f), (long) ((audioTrackClip.getOut() - audioTrackClip.getIn()) * 1000000.0f)) : this.f25741a.dub(audioTrackClip.getSource().getPath(), audioTrackClip.getMixWeight() / 10, (long) (audioTrackClip.getTimelineIn() * 1000000.0f), (long) ((audioTrackClip.getTimelineOut() - audioTrackClip.getTimelineIn()) * 1000000.0f), (long) (audioTrackClip.getIn() * 1000000.0f), (long) ((audioTrackClip.getOut() - audioTrackClip.getIn()) * 1000000.0f)));
                }
            }
        }
        w();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public AliyunICanvasController obtainCanvasController(Context context, int i, int i2) {
        if (context == null || i <= 0 || i2 <= 0) {
            return null;
        }
        com.aliyun.svideosdk.editor.impl.d dVar = this.d;
        if (dVar != null && dVar.b() == i && this.d.a() == i2) {
            return this.d;
        }
        com.aliyun.svideosdk.editor.impl.d dVar2 = new com.aliyun.svideosdk.editor.impl.d(context, this.i, this, i, i2);
        this.d = dVar2;
        return dVar2;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void onDestroy() {
        Log.d("AliYunLog", "onDestroy");
        a(0);
        this.p = false;
        if (this.f25741a != null) {
            Log.d("AliYunLog", "onDestroy stop");
            v();
            this.f25741a.stop();
            Log.d("AliYunLog", "onDestroy release");
            this.f25741a.release();
        }
        com.aliyun.svideosdk.editor.impl.d dVar = this.d;
        if (dVar != null) {
            dVar.release();
            this.d = null;
        }
        if (this.f25741a != null) {
            Log.d("AliYunLog", "onDestroy dispose");
            this.f25741a.dispose();
            this.f25741a = null;
        }
        SurfaceView surfaceView = this.B;
        if (surfaceView != null) {
            surfaceView.getHolder().removeCallback(this.I);
            this.B = null;
        }
        n nVar = this.s;
        if (nVar != null) {
            nVar.setOnPasterRestoreListener(null);
        }
        com.aliyun.common.c.b.b bVar = this.q;
        if (bVar != null) {
            bVar.i();
            this.q.b();
        }
        q qVar = this.v;
        if (qVar != null) {
            qVar.a();
        }
        this.w = null;
        this.A = null;
        this.x = null;
        this.y = null;
        Log.d("AliYunLog", "onDestroy finish");
    }

    public void p() {
        this.t.d();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int pause() {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pause!");
            return -4;
        }
        a(3);
        if (!h()) {
            return -20011019;
        }
        this.q.j();
        return this.f25741a.pause();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int play() {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call play!");
            return -4;
        }
        com.aliyun.common.c.a.a.a("AliYunLog", "editor play");
        int iPrepare = 0;
        if (isPlaying()) {
            Log.w("AliYunLog", "Duplicate play!");
            return 0;
        }
        this.q.k();
        b();
        if (this.e == com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE) {
            com.aliyun.svideosdk.editor.c cVar = com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY;
            this.e = cVar;
            iPrepare = this.f25741a.setMode(cVar);
        }
        if (iPrepare != 0) {
            Log.e("AliYunLog", "Set play mode failed!");
            return iPrepare;
        }
        if (!this.f25741a.isNativePrepared()) {
            iPrepare = this.f25741a.prepare();
        }
        if (iPrepare != 0) {
            Log.e("AliYunLog", "Editor prepare failed!");
            return iPrepare;
        }
        int displayMode = setDisplayMode(this.k);
        if (displayMode != 0) {
            Log.e("AliYunLog", "Set display mode failed!");
            return displayMode;
        }
        int iStart = this.f25741a.start();
        if (iStart != 0) {
            Log.e("AliYunLog", "Play failed!");
        }
        a(2);
        this.e = com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY;
        return iStart;
    }

    public void q() {
        AliyunIPipTrack ownerTrack;
        AliyunIPipController aliyunIPipControllerCreatePipInTrack;
        ArrayList arrayList = new ArrayList(this.i.getTimeline().getPipTracks());
        this.i.getTimeline().getVideoTracks().removeAll(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int i = 0;
            AliyunIPipTrack aliyunIPipTrack = null;
            for (VideoTrackClip videoTrackClip : ((VideoTrack) it.next()).getVideoTrackClips()) {
                if (videoTrackClip instanceof PipVideoTrackClip) {
                    PipVideoTrackClip pipVideoTrackClip = (PipVideoTrackClip) videoTrackClip;
                    if (i == 0) {
                        aliyunIPipControllerCreatePipInTrack = this.v.createNewPip(pipVideoTrackClip.getSource().getPath());
                        ownerTrack = aliyunIPipControllerCreatePipInTrack.getOwnerTrack();
                    } else {
                        ownerTrack = aliyunIPipTrack;
                        aliyunIPipControllerCreatePipInTrack = this.v.createPipInTrack(pipVideoTrackClip.getSource().getPath(), aliyunIPipTrack);
                    }
                    p pVar = (p) aliyunIPipControllerCreatePipInTrack;
                    p pVarA = pVar.a((long) (pipVideoTrackClip.getDuration() * 1000000.0f));
                    long in = (long) pipVideoTrackClip.getIn();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    pVarA.setClipStartTime(in, timeUnit).setClipEndTime((long) pipVideoTrackClip.getOut(), timeUnit).setTimelineStartTime(((long) pipVideoTrackClip.getTimelineIn()) * 1000000, TimeUnit.MICROSECONDS).setBorderColor(pipVideoTrackClip.getBorder().getColor()).setBorderWidth(pipVideoTrackClip.getBorder().getWidth() * this.i.getConfig().getOutputWidth()).setBorderCornerRadius(pipVideoTrackClip.getBorder().getCornerRadius() * this.i.getConfig().getOutputWidth()).setHorizontalFlip(pipVideoTrackClip.getHorizontalFlip()).apply();
                    pVar.getLayoutController().setScale(pipVideoTrackClip.getScale()).setAlpha(pipVideoTrackClip.getAlpha()).setRotation(pipVideoTrackClip.getRotationRadian()).setPosition(pipVideoTrackClip.getCenterX(), pipVideoTrackClip.getCenterY()).apply();
                    pVar.getAugmentationController().setBrightness(pipVideoTrackClip.getBrightness()).setSharpness(pipVideoTrackClip.getSharpness()).setSaturation(pipVideoTrackClip.getSaturation()).setContrast(pipVideoTrackClip.getContrast()).setVignette(pipVideoTrackClip.getVignette()).apply();
                    pVar.getAudioController().setVolume(pipVideoTrackClip.getMixWeight()).denoise(pipVideoTrackClip.getDenoiseWeight()).apply();
                    for (Effect effect : pipVideoTrackClip.getEffects()) {
                        if (effect.getType() == Effect.Type.audio_effect) {
                            AudioEffect audioEffect = (AudioEffect) effect;
                            pVar.getAudioController().setAudioEffect(audioEffect.mEffectType, audioEffect.mEffectParam / 100.0f);
                        } else if (effect.getType() == Effect.Type.audio_fade) {
                            AudioFade audioFade = (AudioFade) effect;
                            ShapeType shapeType = ShapeType.SHAPE_TYPE_LINEAR;
                            int i2 = audioFade.shapeType;
                            if (i2 == 1 || i2 == 3) {
                                shapeType = ShapeType.SHAPE_TYPE_SIN;
                            }
                            if (audioFade.isFadeIn) {
                                pVar.getAudioController().setAudioFadeIn(shapeType, com.aliyun.common.d.b.c(audioFade.duration));
                            } else {
                                pVar.getAudioController().setAudioFadeOut(shapeType, com.aliyun.common.d.b.c(audioFade.duration));
                            }
                        }
                    }
                    pVar.getAudioController().apply();
                    Iterator<ActionBase> it2 = pipVideoTrackClip.getActions().iterator();
                    while (it2.hasNext()) {
                        pVar.getAnimationController().addFrameAnimation(it2.next());
                    }
                    i++;
                    aliyunIPipTrack = ownerTrack;
                }
            }
        }
    }

    public void r() {
        TailWaterMark tailWaterMark = this.i.getTailWaterMark();
        if (tailWaterMark != null) {
            tailWaterMark.setId(this.f25741a.setTailBmp(tailWaterMark.getSource().getPath(), tailWaterMark.getWidth(), tailWaterMark.getHeight(), tailWaterMark.getX(), tailWaterMark.getY(), tailWaterMark.getDuration()));
            for (ActionBase actionBase : tailWaterMark.getActions()) {
                actionBase.setTargetId(tailWaterMark.getId());
                actionBase.setId(this.f25741a.addFrameAnimation(actionBase.getTargetId(), actionBase));
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int rate(float f, long j, long j2, boolean z) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call rate!");
            return -4;
        }
        if (this.f25741a.pause() == 0) {
            a(3);
        } else {
            Log.w("AliYunLog", "rate pause failed!");
        }
        this.q.a(f, j, j2, z);
        int rate = this.f25741a.setRate(f, j * 1000, j2 * 1000, z);
        if (rate < 0) {
            return rate;
        }
        this.i.addTimeFilter(new TimeFilter(rate, j, j2, TimeEffectType.TIME_EFFECT_TYPE_RATE.ordinal(), f, z));
        return rate;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void removeAnimationFilter(EffectFilter effectFilter) {
        if (effectFilter == null) {
            return;
        }
        removeAnimationFilter(effectFilter.toTrackEffectFilter());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void removeAnimationFilter(TrackEffectFilter trackEffectFilter) {
        if (this.t != null) {
            this.q.c(trackEffectFilter);
            this.t.c(trackEffectFilter);
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeAudioEffect(int i, AudioEffectType audioEffectType) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        if (audioEffectType == null) {
            return -2;
        }
        if (!h()) {
            Log.e("AliYunLog", "audioEffect but not prepared!");
            return -20011019;
        }
        this.f25741a.pause();
        int iRemoveAudioEffect = this.f25741a.removeAudioEffect(i, audioEffectType.getEffectType());
        AudioEffect audioEffect = new AudioEffect();
        audioEffect.mEffectType = audioEffectType;
        this.i.removeEffect(i, audioEffect);
        a(3);
        return iRemoveAudioEffect;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeAudioFadeIn(int i) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        if (!h()) {
            Log.e("AliYunLog", "audioEffect but not prepared!");
            return -20011019;
        }
        int audioFadeInFadeOut = this.f25741a.setAudioFadeInFadeOut(i, 0, 0L, true);
        this.i.removeEffect(i, new AudioFade(0, 0.0f, true));
        return audioFadeInFadeOut;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeAudioFadeOut(int i) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        if (!h()) {
            Log.e("AliYunLog", "audioEffect but not prepared!");
            return -20011019;
        }
        int audioFadeInFadeOut = this.f25741a.setAudioFadeInFadeOut(i, 0, 0L, false);
        this.i.removeEffect(i, new AudioFade(0, 0.0f, false));
        return audioFadeInFadeOut;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeDub(EffectBean effectBean) {
        if (effectBean == null) {
            return -2;
        }
        return removeDub(effectBean.toTrackAudioStream());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeDub(TrackAudioStream trackAudioStream) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not apply music");
            return -20011019;
        }
        if (trackAudioStream == null) {
            return -2;
        }
        if (!h()) {
            return -20011019;
        }
        this.f25741a.pause();
        this.q.c(trackAudioStream);
        int iRemoveDub = this.f25741a.removeDub(trackAudioStream.getStreamId());
        if (iRemoveDub != 0) {
            return iRemoveDub;
        }
        this.i.removeAudioTrackClip(trackAudioStream.getStreamId());
        a(3);
        return iRemoveDub;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeFilter() {
        if (!this.p) {
            return -20011019;
        }
        this.q.l();
        int iA = a(null, 0L, 0L, 1);
        if (iA != 0) {
            return iA;
        }
        this.i.clearColorEffect();
        return iA;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeFrameAnimation(ActionBase actionBase) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ");
            return -20011019;
        }
        if (actionBase == null) {
            return -2;
        }
        this.i.removeActionById(actionBase.getId());
        this.q.b(actionBase);
        return this.f25741a.removeFrameAnimation(actionBase.getTargetId(), actionBase);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void removeImage(EffectPicture effectPicture) {
        if (effectPicture == null) {
            return;
        }
        b(effectPicture.toTrackEffectImage());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeMusic(EffectBean effectBean) {
        if (effectBean == null) {
            return -2;
        }
        return removeMusic(effectBean.toTrackAudioStream());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeMusic(TrackAudioStream trackAudioStream) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not apply music");
            return -20011019;
        }
        if (trackAudioStream == null) {
            return -2;
        }
        if (!h()) {
            return -20011019;
        }
        this.f25741a.pause();
        this.q.d(trackAudioStream);
        int iRemoveMix = this.f25741a.removeMix(trackAudioStream.getStreamId());
        if (iRemoveMix != 0) {
            return iRemoveMix;
        }
        this.i.removeAudioTrackClip(trackAudioStream.getStreamId());
        a(3);
        return iRemoveMix;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int removeRunningDisplayMode(int i, int i2) {
        if (!this.p) {
            Log.e("AliYunLog", "Editor not initialized!, removeRunningDisplayMode failed.");
            return -4;
        }
        VideoTrackClip videoTrackClipById = this.i.getVideoTrackClipById(i);
        if (videoTrackClipById != null) {
            for (Effect effect : videoTrackClipById.getEffects()) {
                if (effect.getType() == Effect.Type.running_display_mode && ((RunningDisplayMode) effect).getId() == i2) {
                    videoTrackClipById.getEffects().remove(effect);
                }
            }
        }
        this.q.d(i, i2);
        return this.f25741a.removeRunningDisplayMode(i2);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int repeat(int i, long j, long j2, boolean z) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call repeat!");
            return -4;
        }
        if (this.f25741a.pause() == 0) {
            a(3);
        } else {
            Log.w("AliYunLog", "repeat pause failed!");
        }
        float f = i;
        this.q.b(f, j, j2, z);
        int repeat = this.f25741a.setRepeat(i, j * 1000, j2 * 1000, z);
        if (repeat != 0) {
            return repeat;
        }
        this.i.addTimeFilter(new TimeFilter(repeat, j, j2, TimeEffectType.TIME_EFFECT_TYPE_REPEAT.ordinal(), f, z));
        return repeat;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int replay() {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call resume!");
            return -4;
        }
        this.q.m();
        int iSeek = this.f25741a.seek(0L);
        if (iSeek == 0) {
            int iResume = this.f25741a.resume();
            a(2);
            return iResume;
        }
        Log.e("AliYunLog", "replay seek failed ! ret is " + iSeek);
        return iSeek;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int resetEffect(EffectType effectType) {
        MVFilter mVEffect;
        Log.d("AliyunEditor", "AliyunIEditor.resetEffect");
        if (effectType == null) {
            return -2;
        }
        if (!h()) {
            return -20011019;
        }
        int i = C0230f.b[effectType.ordinal()];
        if (i == 1) {
            this.i.setMVEffect(null);
        } else if (i == 2) {
            this.i.clearMusic();
        } else if (i == 3) {
            this.i.clearTimeFilters();
        } else if (i == 4 && (mVEffect = this.i.getMVEffect()) != null) {
            mVEffect.setMute(true);
        }
        this.f25741a.pause();
        this.q.a(effectType);
        int iResetEffect = this.f25741a.resetEffect(effectType.getEffectType());
        a(3);
        return iResetEffect;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int resetVideoAugmentation(int i, VideoAugmentationType videoAugmentationType) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        int i2 = C0230f.f25747a[videoAugmentationType.ordinal()];
        if (i2 == 1) {
            return a(i, 0.5f);
        }
        if (i2 == 2) {
            return b(i, 0.25f);
        }
        if (i2 == 3) {
            return c(i, 0.5f);
        }
        if (i2 == 4) {
            return d(i, 0.0f);
        }
        if (i2 != 5) {
            return -4;
        }
        return e(i, 0.0f);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int resume() {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call resume!");
            return -4;
        }
        if (!isPaused()) {
            return -20011019;
        }
        this.q.n();
        int iResume = this.f25741a.resume();
        a(2);
        return iResume;
    }

    public void s() {
        if (this.i.getTimeline().getVideoTracks() == null || this.i.getTimeline().getVideoTracks().isEmpty()) {
            return;
        }
        for (VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            this.f25741a.setBrightness(videoTrackClip.getClipId(), videoTrackClip.getBrightness());
            this.f25741a.setContrast(videoTrackClip.getClipId(), videoTrackClip.getContrast());
            this.f25741a.setSaturation(videoTrackClip.getClipId(), videoTrackClip.getSaturation());
            this.f25741a.setSharpness(videoTrackClip.getClipId(), videoTrackClip.getSharpness());
            this.f25741a.setVignette(videoTrackClip.getClipId(), videoTrackClip.getVignette());
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int saveEffectToLocal() {
        if (this.i == null) {
            return -20003019;
        }
        this.q.o();
        this.t.e();
        this.i.updateFileSize();
        AliyunEditorProject aliyunEditorProject = this.i;
        ProjectUtil.writeProject(aliyunEditorProject, aliyunEditorProject.getProjectFile(), this.c);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int seek(long j) {
        return seek(j, TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int seek(long j, TimeUnit timeUnit) {
        int iPrepare = (!this.p || this.f25741a.isNativePrepared()) ? 0 : this.f25741a.prepare();
        if (iPrepare != 0) {
            Log.e("AliYunLog", "Editor prepare failed!");
            return iPrepare;
        }
        if (!h() || i()) {
            return -20011019;
        }
        int iSeek = this.f25741a.seek(timeUnit.toMicros(j));
        a(3);
        return iSeek;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void setAnimationRestoredListener(OnAnimationFilterRestored onAnimationFilterRestored) {
        this.z = onAnimationFilterRestored;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setAudioFadeIn(int i, ShapeType shapeType, long j) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        if (shapeType == null) {
            return -2;
        }
        if (!h()) {
            Log.e("AliYunLog", "audioEffect but not prepared!");
            return -20011019;
        }
        int i2 = shapeType == ShapeType.SHAPE_TYPE_LINEAR ? 0 : 2;
        AudioFade audioFade = new AudioFade(shapeType.ordinal(), j / 1000.0f, true);
        this.i.removeEffect(i, audioFade);
        this.i.addEffect(i, audioFade);
        return this.f25741a.setAudioFadeInFadeOut(i, i2, j, true);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setAudioFadeOut(int i, ShapeType shapeType, long j) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        if (shapeType == null) {
            return -2;
        }
        if (!h()) {
            Log.e("AliYunLog", "audioEffect but not prepared!");
            return -20011019;
        }
        int i2 = shapeType == ShapeType.SHAPE_TYPE_LINEAR ? 1 : 3;
        AudioFade audioFade = new AudioFade(shapeType.ordinal(), j / 1000.0f, false);
        this.i.removeEffect(i, audioFade);
        this.i.addEffect(i, audioFade);
        return this.f25741a.setAudioFadeInFadeOut(i, i2, j, false);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void setAudioSilence(boolean z) {
        this.q.a(z);
        a(z);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setDisplayMode(VideoDisplayMode videoDisplayMode) {
        if (!this.p) {
            Log.e("AliYunLog", "Editor not initialized!, setDisplayMode failed.");
            return -4;
        }
        if (videoDisplayMode == null) {
            Log.e("AliYunLog", "Invalid display mode!");
            return -20003002;
        }
        this.k = videoDisplayMode;
        this.q.a(videoDisplayMode);
        this.i.getConfig().setDisplayMode(videoDisplayMode.getDisplayMode());
        return this.f25741a.setDisplayMode(videoDisplayMode.getDisplayMode());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setDisplayView(SurfaceView surfaceView) {
        int display;
        String str;
        com.aliyun.common.c.a.a.a("AliYunLog", "setDisplayView");
        if (!this.p) {
            str = "Editor not initialized, setDisplayView SurfaceView failed.";
        } else {
            if (this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE) {
                this.q.p();
                if (surfaceView == null) {
                    com.aliyun.common.c.a.a.b("AliYunLog", "SurfaceView is null");
                    return -2;
                }
                Surface surface = surfaceView.getHolder().getSurface();
                if (surface == null || !surface.isValid()) {
                    display = 0;
                } else {
                    this.l = surface;
                    display = this.f25741a.setDisplay(surface);
                }
                TextureView textureView = this.C;
                if (textureView != null) {
                    textureView.setSurfaceTextureListener(null);
                }
                this.C = null;
                SurfaceView surfaceView2 = this.B;
                if (surfaceView2 != null) {
                    surfaceView2.getHolder().removeCallback(this.I);
                }
                this.B = surfaceView;
                surfaceView.getHolder().addCallback(this.I);
                return display;
            }
            str = "compose mode not support set display view";
        }
        com.aliyun.common.c.a.a.b("AliYunLog", str);
        return -4;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040  */
    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setDisplayView(TextureView textureView) {
        int display;
        String str;
        com.aliyun.common.c.a.a.a("AliYunLog", "setDisplayView");
        if (!this.p) {
            str = "Editor not initialized, setDisplayView TextureView failed.";
        } else {
            if (this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE) {
                this.q.p();
                if (textureView == null) {
                    com.aliyun.common.c.a.a.b("AliYunLog", "SurfaceView is null");
                    return -2;
                }
                if (textureView.isAvailable()) {
                    Surface surface = new Surface(textureView.getSurfaceTexture());
                    if (surface.isValid()) {
                        this.l = surface;
                        display = this.f25741a.setDisplay(surface);
                    } else {
                        display = 0;
                    }
                } else {
                    display = 0;
                }
                SurfaceView surfaceView = this.B;
                if (surfaceView != null) {
                    surfaceView.getHolder().removeCallback(this.I);
                    this.B = null;
                }
                TextureView textureView2 = this.C;
                if (textureView2 != null) {
                    textureView2.setSurfaceTextureListener(null);
                }
                this.C = textureView;
                textureView.setSurfaceTextureListener(this.H);
                return display;
            }
            str = "compose mode not support set display view";
        }
        com.aliyun.common.c.a.a.b("AliYunLog", str);
        return -4;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setFillBackgroundColor(int i) {
        if (!this.p) {
            Log.e("AliYunLog", "Editor not initialized!, setFillBackgroundColor failed.");
            return -4;
        }
        this.i.getConfig().setBackgroundColor(i);
        this.q.c(i);
        return this.f25741a.setFillBackgroundColor(i);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setHorizontalFlip(int i, boolean z) {
        int horizontalFlip = !this.p ? -20011019 : this.f25741a.setHorizontalFlip(i, z);
        if (horizontalFlip == 0) {
            for (VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
                if (videoTrackClip.getClipId() == i) {
                    videoTrackClip.setHorizontalFlip(z);
                    break;
                }
            }
        }
        return horizontalFlip;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void setMonitorSurfaceChange(boolean z) {
        if (this.p) {
            return;
        }
        this.m = z;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void setOnAnimationRestoredListener(OnAnimationFilterRestoredListener onAnimationFilterRestoredListener) {
        this.A = onAnimationFilterRestoredListener;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void setOutputPath(String str) {
        this.f = str;
        if (h()) {
            this.q.b(str);
            this.f25741a.setOutputPath(this.f);
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setTransition(int i, TransitionBase transitionBase) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not apply Transition");
            return -20011019;
        }
        HashMap map = new HashMap();
        map.put(Integer.valueOf(i), transitionBase);
        StringBuilder sb = new StringBuilder();
        sb.append("setTransition  params : ");
        sb.append(transitionBase == null ? null : transitionBase.toJsonString());
        com.aliyun.common.c.a.a.a("AliYunLog", sb.toString());
        this.q.a(i, transitionBase);
        return a(map);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setTransition(Map<Integer, TransitionBase> map) {
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not apply music");
            return -20011019;
        }
        if (map == null) {
            return -2;
        }
        this.q.q();
        return a(map);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setVideoAugmentation(int i, VideoAugmentationType videoAugmentationType, float f) {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call pitch!");
            return -4;
        }
        int i2 = C0230f.f25747a[videoAugmentationType.ordinal()];
        if (i2 == 1) {
            return a(i, f);
        }
        if (i2 == 2) {
            return b(i, f);
        }
        if (i2 == 3) {
            return c(i, f);
        }
        if (i2 == 4) {
            return d(i, f);
        }
        if (i2 != 5) {
            return -4;
        }
        return e(i, f);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int setVolume(int i) {
        if (!h()) {
            return -20011019;
        }
        this.q.d(i);
        int volume = this.f25741a.setVolume(i);
        this.i.getConfig().setVolume(i);
        return volume;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int stop() {
        if (!this.p) {
            Log.e("AliYunLog", "Init failed!Cannot call stop!");
            return -4;
        }
        if (this.e != com.aliyun.svideosdk.editor.c.PROCESS_MODE_PLAY) {
            return 0;
        }
        if (!h() || i()) {
            return -20011019;
        }
        this.q.r();
        a(4);
        return this.f25741a.stop();
    }

    public void t() {
        for (VideoTrackClip videoTrackClip : this.i.getTimeline().getPrimaryTrack().getVideoTrackClips()) {
            if (videoTrackClip instanceof MainVideoTrackClip) {
                for (ActionBase actionBase : ((MainVideoTrackClip) videoTrackClip).getActions()) {
                    actionBase.setIsStream(true);
                    actionBase.setTargetId(videoTrackClip.getClipId());
                    this.f25741a.addFrameAnimation(videoTrackClip.getClipId(), actionBase);
                }
            }
        }
    }

    public void u() {
        WaterMark waterMark = this.i.getWaterMark();
        if (waterMark != null) {
            waterMark.setId(this.t.setEffectWaterMark(a(waterMark)));
            for (ActionBase actionBase : waterMark.getActions()) {
                actionBase.setTargetId(waterMark.getId());
                actionBase.setId(this.f25741a.addFrameAnimation(actionBase.getTargetId(), actionBase));
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int updateAnimationFilter(EffectFilter effectFilter) {
        return updateAnimationFilter(effectFilter.toTrackEffectFilter());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int updateAnimationFilter(TrackEffectFilter trackEffectFilter) {
        this.q.e(trackEffectFilter);
        return this.t.e(trackEffectFilter);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int updateCaption(AliyunCaption aliyunCaption) {
        return this.f25741a.updateCaption(aliyunCaption);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public void updateCover(Source source) throws Throwable {
        if (source == null) {
            this.i.setCustomCover(false);
            return;
        }
        if (source.getPath() == null || !new File(source.getPath()).exists()) {
            return;
        }
        File file = new File(source.getPath());
        String str = this.i.getProjectDir().getAbsolutePath() + File.separator + "cover.jpeg";
        File file2 = new File(str);
        try {
            if (file.getPath().endsWith(file2.getPath())) {
                this.i.setCover(source);
            } else {
                com.aliyun.common.utils.g.a(file, file2);
                Source source2 = new Source(str);
                source2.setURL(source.getURL());
                this.i.setCover(source2);
            }
            this.i.setCustomCover(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public int updateTransition(int i, TransitionBase transitionBase) {
        int i2;
        if (!this.p) {
            Log.e("AliYunLog", "Not initialized ,so can not update Transition");
            return -20011019;
        }
        List<VideoTrackClip> videoTrackClips = this.i.getTimeline().getPrimaryTrack().getVideoTrackClips();
        if (i < 0 || (i2 = i + 1) >= videoTrackClips.size()) {
            return -20011022;
        }
        int clipId = videoTrackClips.get(i2).getClipId();
        this.q.a(i, transitionBase);
        return this.t.a(clipId, transitionBase);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIEditor
    public String version() {
        return "6.7.0";
    }
}
