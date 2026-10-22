package com.aliyun.svideosdk.editor.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback;
import com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient;
import com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl;
import com.alibaba.sdk.android.vod.upload.model.SvideoInfo;
import com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig;
import com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo;
import com.aliyun.Visible;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.AliyunCaption;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoParam;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;
import com.aliyun.svideosdk.common.struct.effect.EffectCaption;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.effect.EffectText;
import com.aliyun.svideosdk.common.struct.effect.TrackEffect;
import com.aliyun.svideosdk.common.struct.encoder.VideoCodecs;
import com.aliyun.svideosdk.common.struct.project.AliyunEditorProject;
import com.aliyun.svideosdk.common.struct.project.CaptionTrack;
import com.aliyun.svideosdk.common.struct.project.GifPasterTrack;
import com.aliyun.svideosdk.common.struct.project.PasterTrack;
import com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack;
import com.aliyun.svideosdk.common.struct.project.ProjectUtil;
import com.aliyun.svideosdk.common.struct.project.RollCaptionTrack;
import com.aliyun.svideosdk.common.struct.project.SubTitleTrack;
import com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl;
import com.aliyun.svideosdk.editor.AliyunICompose;
import com.aliyun.svideosdk.editor.AliyunIComposeCallBack;
import com.aliyun.svideosdk.editor.AliyunIRenderCallback;
import com.aliyun.svideosdk.editor.AliyunPasterRender;
import com.aliyun.svideosdk.editor.AliyunRollCaptionComposer;
import com.aliyun.svideosdk.editor.EditorCallBack;
import com.aliyun.svideosdk.editor.OnPasterResumeAndSave;
import com.aliyun.svideosdk.editor.impl.text.TextBitmap;
import com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class AliyunCompose implements AliyunICompose {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f25724a;
    private AliyunPasterRender b;
    private String c;
    private AliyunIComposeCallBack d;
    private VODSVideoUploadClient e;
    private VodHttpClientConfig f;
    private int g;
    private int h;
    private Context j;
    private AliyunIRenderCallback k;
    private int i = 1;
    private EditorCallBack l = new a();
    private final OnPasterResumeAndSave m = new b();
    private final AliyunIComposeCallBack n = new c();

    @Visible
    public final class VODSVideoUploadCallbackImpl implements VODSVideoUploadCallback {
        AliyunICompose.AliyunIUploadCallBack mAliyunIUploadCallBack;

        public VODSVideoUploadCallbackImpl(AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack) {
            this.mAliyunIUploadCallBack = aliyunIUploadCallBack;
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onSTSTokenExpried() {
            AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack;
            Log.d("AliYunLog", "Status" + AliyunCompose.this.a() + "call Upload.");
            if (AliyunCompose.this.a() == 4 && (aliyunIUploadCallBack = this.mAliyunIUploadCallBack) != null) {
                aliyunIUploadCallBack.onSTSTokenExpired();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onUploadFailed(String str, String str2) {
            Log.d("AliYunLog", "Status" + AliyunCompose.this.a() + "call Upload.");
            if (AliyunCompose.this.a() != 4) {
                return;
            }
            AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack = this.mAliyunIUploadCallBack;
            if (aliyunIUploadCallBack != null) {
                aliyunIUploadCallBack.onUploadFailed(str, str2);
            }
            AliyunCompose.this.a(2);
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onUploadProgress(long j, long j2) {
            AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack;
            Log.d("AliYunLog", "Status" + AliyunCompose.this.a() + "call Upload.");
            if (AliyunCompose.this.a() == 4 && (aliyunIUploadCallBack = this.mAliyunIUploadCallBack) != null) {
                aliyunIUploadCallBack.onUploadProgress(j, j2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onUploadRetry(String str, String str2) {
            AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack;
            Log.d("AliYunLog", "Status" + AliyunCompose.this.a() + "call Upload.");
            if (AliyunCompose.this.a() == 4 && (aliyunIUploadCallBack = this.mAliyunIUploadCallBack) != null) {
                aliyunIUploadCallBack.onUploadRetry(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onUploadRetryResume() {
            AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack;
            Log.d("AliYunLog", "Status" + AliyunCompose.this.a() + "call Upload.");
            if (AliyunCompose.this.a() == 4 && (aliyunIUploadCallBack = this.mAliyunIUploadCallBack) != null) {
                aliyunIUploadCallBack.onUploadRetryResume();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback
        public void onUploadSucceed(String str, String str2) {
            Log.d("AliYunLog", "Status" + AliyunCompose.this.a() + "call Upload.");
            if (AliyunCompose.this.a() != 4) {
                return;
            }
            AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack = this.mAliyunIUploadCallBack;
            if (aliyunIUploadCallBack != null) {
                aliyunIUploadCallBack.onUploadSucceed(str, str2);
            }
            AliyunCompose.this.a(2);
        }
    }

    public class a extends EditorCallBack {
        public a() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onCustomRender(int i, int i2, int i3, long j) {
            return AliyunCompose.this.k != null ? AliyunCompose.this.k.onCustomRender(i, i2, i3, j) : i;
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onDataReady() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onEnd(int i) {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onError(int i) {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPlayProgress(long j, long j2) {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onRenderDestroy() {
            if (AliyunCompose.this.k != null) {
                AliyunCompose.this.k.onRenderDestroy();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onRenderSetup() {
            if (AliyunCompose.this.k != null) {
                AliyunCompose.this.k.onRenderSetup();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onTextureRender(int i, int i2, int i3, long j) {
            return AliyunCompose.this.k != null ? AliyunCompose.this.k.onTextureRender(i, i2, i3, j) : i;
        }
    }

    public class b implements OnPasterResumeAndSave {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        m f25726a = new m();

        public b() {
        }

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
        @Override // com.aliyun.svideosdk.editor.OnPasterResumeAndSave
        public void onPasterResume(List<PasterTrack> list) {
            PhotoPasterTrack photoPasterTrack;
            this.f25726a.a(AliyunCompose.this.g, AliyunCompose.this.h);
            for (PasterTrack pasterTrack : list) {
                if (pasterTrack.getType() == PasterTrack.Type.photo) {
                    PhotoPasterTrack photoPasterTrack2 = (PhotoPasterTrack) pasterTrack;
                    EffectImage effectImage = new EffectImage(photoPasterTrack2.getSource());
                    effectImage.setXRadio(photoPasterTrack2.getX());
                    effectImage.setYRatio(photoPasterTrack2.getY());
                    effectImage.setWidthRatio(photoPasterTrack2.getWidth());
                    effectImage.setHeightRatio(photoPasterTrack2.getHeight());
                    effectImage.setRotation(photoPasterTrack2.getRotation());
                    photoPasterTrack2.setId(AliyunCompose.this.f25724a.a(new TrackEffect<>((long) (photoPasterTrack2.getTimelineIn() * 1000.0f), (long) (photoPasterTrack2.getTimelineOut() * 1000.0f), effectImage)));
                    AliyunCompose.this.f25724a.a(photoPasterTrack2);
                } else if (pasterTrack.getType() == PasterTrack.Type.roll_captions) {
                    RollCaptionTrack rollCaptionTrack = (RollCaptionTrack) pasterTrack;
                    AliyunRollCaptionComposer aliyunRollCaptionComposerCreateRollCaptionComposer = AliyunCompose.this.f25724a.createRollCaptionComposer();
                    if (aliyunRollCaptionComposerCreateRollCaptionComposer instanceof com.aliyun.svideosdk.editor.e.a) {
                        ((com.aliyun.svideosdk.editor.e.a) aliyunRollCaptionComposerCreateRollCaptionComposer).a(rollCaptionTrack);
                    }
                } else {
                    if (pasterTrack.getType() == PasterTrack.Type.gif) {
                        GifPasterTrack gifPasterTrack = (GifPasterTrack) pasterTrack;
                        EffectPaster effectPaster = new EffectPaster(gifPasterTrack.getSource());
                        this.f25726a.c(effectPaster, gifPasterTrack);
                        AliyunCompose.this.b.addEffectPaster(effectPaster);
                        pasterTrack.setId(effectPaster.getViewId());
                        photoPasterTrack = gifPasterTrack;
                    } else {
                        PasterTrack.Type type = pasterTrack.getType();
                        PasterTrack.Type type2 = PasterTrack.Type.subtitle;
                        if (type == type2 || pasterTrack.getType() == PasterTrack.Type.bubble_caption) {
                            SubTitleTrack subTitleTrack = (SubTitleTrack) pasterTrack;
                            EffectText effectText = pasterTrack.getType() == type2 ? new EffectText(subTitleTrack.getFont()) : new EffectCaption(subTitleTrack.getSource());
                            this.f25726a.c(effectText, subTitleTrack);
                            this.f25726a.b(effectText, subTitleTrack);
                            String str = effectText.textBmpPath;
                            Bitmap bitmapDecodeFile = (TextUtils.isEmpty(str) || !new File(str).exists()) ? null : BitmapFactory.decodeFile(str);
                            effectText.needSaveBmp = false;
                            if (bitmapDecodeFile == null) {
                                TextBitmapGenerator textBitmapGenerator = new TextBitmapGenerator();
                                textBitmapGenerator.updateTextBitmap(TextBitmap.fromEffectText(effectText));
                                if (effectText instanceof EffectCaption) {
                                    AliyunCompose.this.b.addCaptionPaster(textBitmapGenerator, (EffectCaption) effectText);
                                } else {
                                    AliyunCompose.this.b.addSubtitle(textBitmapGenerator, effectText);
                                }
                            } else if (effectText instanceof EffectCaption) {
                                AliyunCompose.this.b.addCaptionPaster(bitmapDecodeFile, (EffectCaption) effectText);
                            } else {
                                AliyunCompose.this.b.addSubtitle(bitmapDecodeFile, effectText);
                            }
                            subTitleTrack.setId(effectText.getViewId());
                            photoPasterTrack = subTitleTrack;
                        } else if (pasterTrack.getType() == PasterTrack.Type.caption) {
                            CaptionTrack captionTrack = (CaptionTrack) pasterTrack;
                            AliyunCaption caption = captionTrack.toCaption();
                            AliyunCompose.this.b.addCaption(caption);
                            captionTrack.setId(caption.getId());
                        }
                    }
                    AliyunCompose.this.f25724a.a(photoPasterTrack);
                }
            }
        }
    }

    public class c implements AliyunIComposeCallBack {
        public c() {
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeCompleted() {
            AliyunCompose.this.a(2);
            if (AliyunCompose.this.d != null) {
                AliyunCompose.this.d.onComposeCompleted();
            }
            AliyunCompose.this.d = null;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeError(int i) {
            if (AliyunCompose.this.d != null) {
                AliyunCompose.this.d.onComposeError(i);
            }
            AliyunCompose.this.d = null;
        }

        @Override // com.aliyun.svideosdk.editor.AliyunIComposeCallBack
        public void onComposeProgress(int i) {
            if (AliyunCompose.this.d != null) {
                AliyunCompose.this.d.onComposeProgress(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i) {
        this.i = i;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int cancelCompose() {
        if (a() != 3) {
            Log.e("AliYunLog", "No compose task!");
            return -20011018;
        }
        this.f25724a.cancelCompose();
        a(2);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public int cancelUpload() {
        if (a() != 4) {
            Log.e("AliYunLog", "No upload task!");
            return -20011018;
        }
        this.e.cancel();
        a(2);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int compose(String str, String str2, AliyunIComposeCallBack aliyunIComposeCallBack) {
        File file;
        AliyunEditorProject project;
        String str3;
        if (a() == 1) {
            str3 = "Not initialize AliyunICompose";
        } else {
            if (a() == 2) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (project = ProjectUtil.readProject((file = new File(str)), new ProjectJSONSupportImpl())) == null) {
                    return -20011020;
                }
                AliyunVideoParam aliyunVideoParam = new AliyunVideoParam();
                aliyunVideoParam.setScaleMode(VideoDisplayMode.valueOf(project.getConfig().getDisplayMode()));
                aliyunVideoParam.setVideoQuality(VideoQuality.values()[project.getConfig().getVideoQuality()]);
                aliyunVideoParam.setBitrate(project.getConfig().getBitrate());
                aliyunVideoParam.setFrameRate(project.getConfig().getFps());
                aliyunVideoParam.setGop(project.getConfig().getGop());
                aliyunVideoParam.setCrf(project.getConfig().getCrf());
                aliyunVideoParam.setVideoCodec(VideoCodecs.getInstanceByValue(project.getConfig().getVideoCodec()));
                aliyunVideoParam.setScaleRate(project.getConfig().getScale());
                aliyunVideoParam.setAudioChannel(AliyunVideoParam.AudioChannel.getTypeByValue(project.getConfig().getAudioChannel()));
                aliyunVideoParam.setAudioSampleRate(AliyunVideoParam.AudioSampleRate.getTypeByValue(project.getConfig().getAudioSampleRate()));
                this.c = str2;
                this.d = aliyunIComposeCallBack;
                this.f25724a = new f(Uri.fromFile(file), this.l);
                this.g = (int) (project.getConfig().getOutputWidth() * project.getConfig().getScale());
                this.h = (int) (project.getConfig().getOutputHeight() * project.getConfig().getScale());
                AliyunPasterRender pasterRender = this.f25724a.getPasterRender();
                this.b = pasterRender;
                pasterRender.setOnPasterResumeAndSave(this.m);
                this.b.setDisplaySize(this.g, this.h);
                this.f25724a.a(com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE);
                this.f25724a.a(aliyunVideoParam);
                this.f25724a.setOutputPath(this.c);
                Size sizeA = this.f25724a.a(this.j);
                if (this.f25724a.init(null, this.j, sizeA.getWidth(), sizeA.getHeight()) != 0) {
                    return -20011021;
                }
                if (this.f25724a.compose(aliyunVideoParam, this.c, this.n) != 0) {
                    return 0;
                }
                a(3);
                return 0;
            }
            str3 = "Something is being done, can not do compose";
        }
        Log.e("AliYunLog", str3);
        return -20011018;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose, com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int init(Context context) {
        this.j = context;
        if (a() != 1) {
            Log.w("AliYunLog", "Don't need duplicate initialize");
            return 0;
        }
        this.f = new VodHttpClientConfig.Builder().setMaxRetryCount(2).setConnectionTimeout(30000).setSocketTimeout(30000).build();
        if (context == null) {
            Log.e("AliYunLog", "Context can not be null");
            return -20011021;
        }
        VODSVideoUploadClientImpl vODSVideoUploadClientImpl = new VODSVideoUploadClientImpl(context.getApplicationContext());
        this.e = vODSVideoUploadClientImpl;
        vODSVideoUploadClientImpl.setAppVersion("6.7.0");
        this.e.init();
        a(2);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int pauseCompose() {
        if (a() != 1) {
            return this.f25724a.pause();
        }
        Log.e("AliYunLog", "Not initialize AliyunICompose");
        return -20011018;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public void pauseUpload() {
        VODSVideoUploadClient vODSVideoUploadClient = this.e;
        if (vODSVideoUploadClient == null) {
            return;
        }
        vODSVideoUploadClient.pause();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public int refreshSTSToken(String str, String str2, String str3, String str4) {
        this.e.refreshSTSToken(str, str2, str3, str4);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose, com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public void release() {
        int i = this.i;
        if (i == 1) {
            Log.w("AliYunLog", "Not initialize");
            return;
        }
        if (i != 2) {
            Log.w("AliYunLog", "Something is been done,release will stop doing this");
            if (this.i == 3) {
                cancelCompose();
            } else {
                cancelUpload();
            }
        }
        VODSVideoUploadClient vODSVideoUploadClient = this.e;
        if (vODSVideoUploadClient != null) {
            vODSVideoUploadClient.release();
        }
        f fVar = this.f25724a;
        if (fVar != null) {
            fVar.onDestroy();
            this.f25724a = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        a(1);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int resumeCompose() {
        if (a() != 1) {
            return this.f25724a.resume();
        }
        Log.e("AliYunLog", "Not initialize AliyunICompose");
        return -20011018;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public void resumeUpload() {
        VODSVideoUploadClient vODSVideoUploadClient = this.e;
        if (vODSVideoUploadClient == null) {
            return;
        }
        vODSVideoUploadClient.resume();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public void setRenderCallback(AliyunIRenderCallback aliyunIRenderCallback) {
        this.k = aliyunIRenderCallback;
        this.l.mNeedRenderCallback = aliyunIRenderCallback.needRenderCallback();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public void setUploadRetryAndTimeout(int i, int i2, int i3) {
        this.f = new VodHttpClientConfig.Builder().setMaxRetryCount(i).setConnectionTimeout(i2).setSocketTimeout(i3).build();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunICompose
    public int uploadWithVideoAndImg(String str, String str2, String str3, String str4, String str5, SvideoInfo svideoInfo, boolean z, String str6, String str7, AliyunICompose.AliyunIUploadCallBack aliyunIUploadCallBack) {
        String str8;
        if (a() == 1) {
            str8 = "Not initialize AliyunICompose";
        } else {
            if (a() == 2) {
                if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str5)) {
                    return -20011020;
                }
                Log.d("AliYunLog", "Upload requestID: " + ((String) null));
                this.e.uploadWithVideoAndImg(new VodSessionCreateInfo.Builder().setImagePath(str).setVideoPath(this.c).setSvideoInfo(svideoInfo).setAccessKeyId(str2).setAccessKeySecret(str3).setExpriedTime(str5).setIsTranscode(Boolean.valueOf(z)).setSecurityToken(str4).setRequestID(null).setPartSize(1048576L).setTemplateGroupId(str7).setStorageLocation(str6).setVodHttpClientConfig(this.f).build(), new VODSVideoUploadCallbackImpl(aliyunIUploadCallBack));
                a(4);
                return 0;
            }
            str8 = "Something is being done, can not do upload";
        }
        Log.e("AliYunLog", str8);
        return -20011018;
    }
}
