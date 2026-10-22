package com.aliyun.svideosdk.editor.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
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
import com.aliyun.svideosdk.editor.AliyunIBaseCompose;
import com.aliyun.svideosdk.editor.AliyunIComposeCallBack;
import com.aliyun.svideosdk.editor.AliyunIRenderCallback;
import com.aliyun.svideosdk.editor.AliyunPasterRender;
import com.aliyun.svideosdk.editor.AliyunRollCaptionComposer;
import com.aliyun.svideosdk.editor.EditorCallBack;
import com.aliyun.svideosdk.editor.OnPasterResumeAndSave;
import com.aliyun.svideosdk.editor.impl.text.TextBitmap;
import com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunBaseCompose implements AliyunIBaseCompose {
    private static WeakReference<Context> contextWeakReference;
    private f mAliyunEditor;
    private int mHeight;
    private AliyunPasterRender mPasterRender;
    private AliyunIRenderCallback mRenderCallback;
    private int mWidth;
    private com.aliyun.svideosdk.editor.a packetCallBack;
    private final EditorCallBack mEditorCallback = new a();
    private final OnPasterResumeAndSave onPasterResumeAndSave = new b();

    public class a extends EditorCallBack {
        public a() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onCustomRender(int i, int i2, int i3, long j) {
            return AliyunBaseCompose.this.mRenderCallback != null ? AliyunBaseCompose.this.mRenderCallback.onCustomRender(i, i2, i3, j) : i;
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
            if (AliyunBaseCompose.this.mRenderCallback != null) {
                AliyunBaseCompose.this.mRenderCallback.onRenderDestroy();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onRenderSetup() {
            if (AliyunBaseCompose.this.mRenderCallback != null) {
                AliyunBaseCompose.this.mRenderCallback.onRenderSetup();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onTextureRender(int i, int i2, int i3, long j) {
            return AliyunBaseCompose.this.mRenderCallback != null ? AliyunBaseCompose.this.mRenderCallback.onTextureRender(i, i2, i3, j) : i;
        }
    }

    public class b implements OnPasterResumeAndSave {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        m f25723a = new m();

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
            this.f25723a.a(AliyunBaseCompose.this.mWidth, AliyunBaseCompose.this.mHeight);
            for (PasterTrack pasterTrack : list) {
                if (pasterTrack.getType() == PasterTrack.Type.photo) {
                    PhotoPasterTrack photoPasterTrack2 = (PhotoPasterTrack) pasterTrack;
                    EffectImage effectImage = new EffectImage(photoPasterTrack2.getSource());
                    effectImage.setXRadio(photoPasterTrack2.getX());
                    effectImage.setYRatio(photoPasterTrack2.getY());
                    effectImage.setWidthRatio(photoPasterTrack2.getWidth());
                    effectImage.setHeightRatio(photoPasterTrack2.getHeight());
                    effectImage.setRotation(photoPasterTrack2.getRotation());
                    photoPasterTrack2.setId(AliyunBaseCompose.this.mAliyunEditor.a(new TrackEffect<>((long) (photoPasterTrack2.getTimelineIn() * 1000.0f), (long) (photoPasterTrack2.getTimelineOut() * 1000.0f), effectImage)));
                    AliyunBaseCompose.this.mAliyunEditor.a(photoPasterTrack2);
                } else if (pasterTrack.getType() == PasterTrack.Type.roll_captions) {
                    RollCaptionTrack rollCaptionTrack = (RollCaptionTrack) pasterTrack;
                    AliyunRollCaptionComposer aliyunRollCaptionComposerCreateRollCaptionComposer = AliyunBaseCompose.this.mAliyunEditor.createRollCaptionComposer();
                    if (aliyunRollCaptionComposerCreateRollCaptionComposer instanceof com.aliyun.svideosdk.editor.e.a) {
                        ((com.aliyun.svideosdk.editor.e.a) aliyunRollCaptionComposerCreateRollCaptionComposer).a(rollCaptionTrack);
                    }
                } else {
                    if (pasterTrack.getType() == PasterTrack.Type.gif) {
                        GifPasterTrack gifPasterTrack = (GifPasterTrack) pasterTrack;
                        EffectPaster effectPaster = new EffectPaster(gifPasterTrack.getSource());
                        this.f25723a.c(effectPaster, gifPasterTrack);
                        AliyunBaseCompose.this.mPasterRender.addEffectPaster(effectPaster);
                        pasterTrack.setId(effectPaster.getViewId());
                        photoPasterTrack = gifPasterTrack;
                    } else {
                        PasterTrack.Type type = pasterTrack.getType();
                        PasterTrack.Type type2 = PasterTrack.Type.subtitle;
                        if (type == type2 || pasterTrack.getType() == PasterTrack.Type.bubble_caption) {
                            SubTitleTrack subTitleTrack = (SubTitleTrack) pasterTrack;
                            EffectText effectText = pasterTrack.getType() == type2 ? new EffectText(subTitleTrack.getFont()) : new EffectCaption(subTitleTrack.getSource());
                            this.f25723a.c(effectText, subTitleTrack);
                            this.f25723a.b(effectText, subTitleTrack);
                            String str = effectText.textBmpPath;
                            Bitmap bitmapDecodeFile = (TextUtils.isEmpty(str) || !new File(str).exists()) ? null : BitmapFactory.decodeFile(str);
                            effectText.needSaveBmp = false;
                            if (bitmapDecodeFile == null) {
                                TextBitmapGenerator textBitmapGenerator = new TextBitmapGenerator();
                                textBitmapGenerator.updateTextBitmap(TextBitmap.fromEffectText(effectText));
                                if (effectText instanceof EffectCaption) {
                                    AliyunBaseCompose.this.mPasterRender.addCaptionPaster(textBitmapGenerator, (EffectCaption) effectText);
                                } else {
                                    AliyunBaseCompose.this.mPasterRender.addSubtitle(textBitmapGenerator, effectText);
                                }
                            } else if (effectText instanceof EffectCaption) {
                                AliyunBaseCompose.this.mPasterRender.addCaptionPaster(bitmapDecodeFile, (EffectCaption) effectText);
                            } else {
                                AliyunBaseCompose.this.mPasterRender.addSubtitle(bitmapDecodeFile, effectText);
                            }
                            subTitleTrack.setId(effectText.getViewId());
                            photoPasterTrack = subTitleTrack;
                        } else if (pasterTrack.getType() == PasterTrack.Type.caption) {
                            CaptionTrack captionTrack = (CaptionTrack) pasterTrack;
                            AliyunCaption caption = captionTrack.toCaption();
                            AliyunBaseCompose.this.mPasterRender.addCaption(caption);
                            captionTrack.setId(caption.getId());
                        }
                    }
                    AliyunBaseCompose.this.mAliyunEditor.a(photoPasterTrack);
                }
            }
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int cancelCompose() {
        f fVar = this.mAliyunEditor;
        if (fVar == null) {
            Log.d("AliYunLog", "Not initialize AliyunBaseCompose");
            return -20011023;
        }
        int iCancelCompose = fVar.cancelCompose();
        if (iCancelCompose == 0) {
            return 0;
        }
        Log.d("AliYunLog", "cancelCompose failed!");
        return iCancelCompose;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int compose(String str, String str2, AliyunIComposeCallBack aliyunIComposeCallBack) {
        File file = new File(str);
        AliyunEditorProject project = ProjectUtil.readProject(file, new ProjectJSONSupportImpl());
        if (project == null) {
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
        this.mAliyunEditor = new f(Uri.fromFile(file), this.mEditorCallback);
        this.mWidth = (int) (project.getConfig().getOutputWidth() * project.getConfig().getScale());
        this.mHeight = (int) (project.getConfig().getOutputHeight() * project.getConfig().getScale());
        AliyunPasterRender pasterRender = this.mAliyunEditor.getPasterRender();
        this.mPasterRender = pasterRender;
        pasterRender.setOnPasterResumeAndSave(this.onPasterResumeAndSave);
        this.mPasterRender.setDisplaySize(this.mWidth, this.mHeight);
        this.mAliyunEditor.a(com.aliyun.svideosdk.editor.c.PROCESS_MODE_COMPOSE);
        this.mAliyunEditor.a(aliyunVideoParam);
        this.mAliyunEditor.setOutputPath(str2);
        this.mAliyunEditor.a(this.packetCallBack);
        Size sizeA = this.mAliyunEditor.a(contextWeakReference.get());
        if (this.mAliyunEditor.init(null, contextWeakReference.get(), sizeA.getWidth(), sizeA.getHeight()) != 0) {
            return -20011021;
        }
        this.mAliyunEditor.compose(aliyunVideoParam, str2, aliyunIComposeCallBack);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int init(Context context) {
        contextWeakReference = new WeakReference<>(context);
        return 0;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int pauseCompose() {
        f fVar = this.mAliyunEditor;
        if (fVar == null) {
            Log.d("AliYunLog", "Not initialize AliyunBaseCompose");
            return -20011018;
        }
        int iPause = fVar.pause();
        if (iPause == 0) {
            return 0;
        }
        Log.d("AliYunLog", "pauseCompose failed!");
        return iPause;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public void release() {
        f fVar = this.mAliyunEditor;
        if (fVar == null) {
            Log.d("AliYunLog", "Not initialize AliyunBaseCompose");
        } else {
            this.packetCallBack = null;
            fVar.onDestroy();
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int resumeCompose() {
        f fVar = this.mAliyunEditor;
        if (fVar == null) {
            Log.d("AliYunLog", "Not initialize AliyunBaseCompose");
            return -20011018;
        }
        int iResume = fVar.resume();
        if (iResume == 0) {
            return 0;
        }
        Log.d("AliYunLog", "resumeCompose failed!");
        return iResume;
    }

    public void setPacketCallBack(com.aliyun.svideosdk.editor.a aVar) {
        this.packetCallBack = aVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public void setRenderCallback(AliyunIRenderCallback aliyunIRenderCallback) {
        this.mRenderCallback = aliyunIRenderCallback;
        this.mEditorCallback.mNeedRenderCallback = aliyunIRenderCallback.needRenderCallback();
    }
}
