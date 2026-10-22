package com.aliyun.common.c.b;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.motion.widget.Key;
import com.aliyun.svideosdk.common.struct.common.AliyunVideoParam;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.aliyun.svideosdk.common.struct.effect.EffectCaption;
import com.aliyun.svideosdk.common.struct.effect.EffectFilter;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectPaster;
import com.aliyun.svideosdk.common.struct.effect.EffectText;
import com.aliyun.svideosdk.common.struct.effect.LUTEffectBean;
import com.aliyun.svideosdk.common.struct.effect.TrackAudioStream;
import com.aliyun.svideosdk.common.struct.effect.TrackEffect;
import com.aliyun.svideosdk.common.struct.effect.TrackEffectMV;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.conan.event.AlivcEventReporter;
import com.aliyun.svideosdk.editor.EffectType;
import com.aliyun.svideosdk.transcode.NativeParser;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.fl.saas.common.util.FileTypeUtils;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends f {
    private static final String e = d.class.getName();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f25566a;
        final /* synthetic */ NativeParser b;
        final /* synthetic */ HashMap c;

        public a(String str, NativeParser nativeParser, HashMap map) {
            this.f25566a = str;
            this.b = nativeParser;
            this.c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.f25566a);
            if (file.exists()) {
                this.b.init(this.f25566a);
                try {
                    this.c.put("size", String.valueOf(file.length()));
                    String value = this.b.getValue(6);
                    HashMap map = this.c;
                    if ("unknown".equals(value)) {
                        value = "0";
                    }
                    map.put("width", value);
                    String value2 = this.b.getValue(7);
                    HashMap map2 = this.c;
                    if ("unknown".equals(value2)) {
                        value2 = "0";
                    }
                    map2.put("height", value2);
                    String value3 = this.b.getValue(13);
                    HashMap map3 = this.c;
                    if ("unknown".equals(value3)) {
                        value3 = "0";
                    }
                    map3.put(AliyunLogKey.KEY_FPS, value3);
                    String value4 = this.b.getValue(5);
                    HashMap map4 = this.c;
                    if ("unknown".equals(value4)) {
                        value4 = "0";
                    }
                    map4.put(MediaFormat.KEY_BIT_RATE, value4);
                    this.c.put("format", this.b.getValue(10));
                    String value5 = this.b.getValue(28);
                    HashMap map5 = this.c;
                    if ("unknown".equals(value5)) {
                        value5 = "0";
                    }
                    map5.put("duration", value5);
                    String value6 = this.b.getValue(3);
                    HashMap map6 = this.c;
                    if ("unknown".equals(value6)) {
                        value6 = "0";
                    }
                    map6.put("videoDuration", value6);
                    String value7 = this.b.getValue(18);
                    HashMap map7 = this.c;
                    if ("unknown".equals(value7)) {
                        value7 = "0";
                    }
                    map7.put("audioDuration", value7);
                } catch (Exception unused) {
                    this.c.put("width", "0");
                    this.c.put("height", "0");
                    this.c.put(AliyunLogKey.KEY_FPS, "0");
                    this.c.put(MediaFormat.KEY_BIT_RATE, "0");
                    this.c.put("format", "unknown");
                    this.c.put("duration", "0");
                    this.c.put("videoDuration", "0");
                    this.c.put("audioDuration", "0");
                }
                this.b.release();
                this.b.dispose();
            }
            b.this.a(3056, this.c);
            Log.d("AlivcReporter", "send sendComposeCompleteEvent");
            b bVar = b.this;
            bVar.d = false;
            if (bVar.c) {
                bVar.b();
            }
        }
    }

    /* JADX INFO: renamed from: com.aliyun.common.c.b.b$b, reason: collision with other inner class name */
    public class C0214b implements Thread.UncaughtExceptionHandler {
        public C0214b(b bVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            Log.e(b.e, "parse File failed, msg is " + th.getMessage());
        }
    }

    public b(Context context, String str) {
        AlivcEventReporter alivcEventReporterA = g.a(context);
        this.f25568a = alivcEventReporterA;
        if (alivcEventReporterA != null) {
            alivcEventReporterA.c(str);
            this.f25568a.d(AliyunLogCommon.SubModule.EDIT);
        }
        this.b = 3000;
    }

    public void a(float f, long j, long j2, boolean z) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "rate");
        map.put("rate", String.valueOf(f));
        map.put("startTime", String.valueOf(j));
        map.put("duration", String.valueOf(j2));
        map.put("needOriginDuration", String.valueOf(z));
        a(map);
    }

    public void a(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "deleteTimeEffect");
        map.put("id", String.valueOf(i));
        a(map);
    }

    public void a(int i, int i2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyMusicMixWeight");
        map.put("id", String.valueOf(i));
        map.put("musicWeight", String.valueOf(i2));
        a(map);
    }

    public void a(int i, long j, long j2, float f) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyBlurBackground");
        map.put("streamID", String.valueOf(i));
        map.put("startTime", String.valueOf(j));
        map.put("duration", String.valueOf(j2));
        map.put("blurRadius", String.valueOf(f));
        a(map);
    }

    public void a(int i, TransitionBase transitionBase) {
        if (transitionBase == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setTransition");
        map.put("id", String.valueOf(i));
        map.put("type", String.valueOf(transitionBase.mType));
        map.put("overlapDuration", String.valueOf(transitionBase.getOverlapDuration()));
        a(map);
    }

    public void a(int i, boolean z) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "denoise");
        map.put("id", String.valueOf(i));
        map.put("needDenoise", String.valueOf(z));
        a(map);
    }

    public void a(AliyunVideoParam aliyunVideoParam, String str) {
        if (aliyunVideoParam == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "compose");
        a(3000, map);
        map.clear();
        map.put("outputPath", str);
        map.put(MediaFormat.KEY_BIT_RATE, String.valueOf(aliyunVideoParam.getBitrate()));
        map.put(AliyunLogKey.KEY_FPS, String.valueOf(aliyunVideoParam.getFrameRate()));
        map.put("gop", String.valueOf(aliyunVideoParam.getGop()));
        map.put("crf", String.valueOf(aliyunVideoParam.getCrf()));
        map.put("scaleRate", String.valueOf(aliyunVideoParam.getScaleRate()));
        map.put("videoQuality", String.valueOf(aliyunVideoParam.getVideoQuality()));
        map.put("videoDisplayMode", String.valueOf(aliyunVideoParam.getScaleMode().getDisplayMode()));
        map.put("videoCodec", String.valueOf(aliyunVideoParam.getVideoCodec()));
        a(3053, map);
    }

    public void a(VideoDisplayMode videoDisplayMode) {
        if (videoDisplayMode == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setDisplayMode");
        map.put("videoDisplayMode", String.valueOf(videoDisplayMode.getDisplayMode()));
        a(map);
    }

    public void a(VideoDisplayMode videoDisplayMode, int i, long j, long j2) {
        if (videoDisplayMode == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addRunningDisplayMode");
        map.put("videoDisplayMode", String.valueOf(videoDisplayMode.getDisplayMode()));
        map.put("streamID", String.valueOf(i));
        map.put("startTime", String.valueOf(j));
        map.put("duration", String.valueOf(j2));
        a(map);
    }

    public void a(ActionBase actionBase) {
        if (actionBase == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addFrameAnimation");
        map.put("targetID", String.valueOf(actionBase.getTargetId()));
        map.put("id", String.valueOf(actionBase.getId()));
        map.put("type", String.valueOf(actionBase.getType().ordinal()));
        map.put("startTime", String.valueOf(actionBase.getStartTime()));
        map.put("duration", String.valueOf(actionBase.getDuration()));
        a(map);
    }

    public void a(EffectCaption effectCaption) {
        if (effectCaption == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addCaption");
        map.put("type", FileTypeUtils.FILE_TYPE_BMP);
        map.put("param", effectCaption.toString());
        a(map);
    }

    public void a(EffectFilter effectFilter) {
        if (effectFilter == null && effectFilter.getSource() == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyFilter");
        map.put("path", String.valueOf(effectFilter.getSource().getPath()));
        a(map);
    }

    public void a(EffectPaster effectPaster) {
        if (effectPaster == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addPaster");
        map.put("param", effectPaster.toString());
        a(map);
    }

    public void a(EffectText effectText) {
        if (effectText == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addSubtitle");
        map.put("type", FileTypeUtils.FILE_TYPE_BMP);
        map.put("param", effectText.toString());
        a(map);
    }

    public void a(LUTEffectBean lUTEffectBean) {
        if (lUTEffectBean == null && lUTEffectBean.getSource() == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyLutFilter");
        map.put("path", String.valueOf(lUTEffectBean.getSource().getPath()));
        a(map);
    }

    public void a(TrackAudioStream trackAudioStream) {
        if (trackAudioStream == null && trackAudioStream.getSource() == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyDub");
        map.put("path", trackAudioStream.getSource().getPath());
        map.put("startTime", String.valueOf(trackAudioStream.getStartTime()));
        map.put("duration", String.valueOf(trackAudioStream.getDuration()));
        map.put("streamStartTime", String.valueOf(trackAudioStream.getStreamStartTime()));
        map.put("streamDuration", String.valueOf(trackAudioStream.getStreamDuration()));
        map.put("musicWeight", String.valueOf(trackAudioStream.getAudioWeight()));
        a(map);
    }

    public void a(TrackEffect<EffectFilter> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addAnimationFilter");
        map.put("path", String.valueOf(((EffectFilter) trackEffect.getBean()).getPath()));
        map.put("startTime", String.valueOf(trackEffect.getStartTime()));
        map.put("duration", String.valueOf(trackEffect.getDuration()));
        a(map);
    }

    public void a(TrackEffectMV trackEffectMV) {
        if (trackEffectMV == null && trackEffectMV.getSource() == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyMV");
        map.put("path", String.valueOf(trackEffectMV.getSource().getPath()));
        a(map);
    }

    public void a(EffectType effectType) {
        if (effectType == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "resetEffect");
        map.put("type", String.valueOf(effectType.getEffectType()));
        a(map);
    }

    public void a(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addPaster");
        map.put("path", str);
        a(map);
    }

    public void a(String str, float f, float f2, float f3, float f4) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyWaterMark");
        map.put("path", String.valueOf(str));
        map.put("width", String.valueOf(f));
        map.put("height", String.valueOf(f2));
        map.put("posX", String.valueOf(f3));
        map.put("posY", String.valueOf(f4));
        a(map);
    }

    public void a(String str, float f, float f2, float f3, float f4, long j) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addTailWaterMark");
        map.put("path", str);
        map.put("width", String.valueOf(f));
        map.put("height", String.valueOf(f2));
        map.put("posX", String.valueOf(f3));
        map.put("posY", String.valueOf(f4));
        map.put("duration", String.valueOf(j));
        a(map);
    }

    public void a(String str, int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("errorCode", String.valueOf(i));
        a(3054, map);
    }

    public void a(String str, int i, long j) {
        if (str == null || str.isEmpty()) {
            Log.e(e, "compose outputPath is invalid");
            return;
        }
        NativeParser nativeParser = new NativeParser();
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "composeComplete");
        a(3000, map);
        map.clear();
        map.put("composeTime", String.valueOf((System.nanoTime() - j) / 1000));
        Thread thread = new Thread(new a(str, nativeParser, map));
        thread.setUncaughtExceptionHandler(new C0214b(this));
        this.d = true;
        thread.start();
    }

    public void a(String str, long j, long j2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addPasterWithStartTime");
        map.put("path", str);
        map.put("startTime", String.valueOf(j));
        map.put("duration", String.valueOf(j2));
        a(map);
    }

    public void a(String str, String str2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addSubtitle");
        map.put("text", str);
        map.put(com.google.common.net.e.f6416j, str2);
        a(map);
    }

    public void a(String str, String str2, long j, long j2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addSubtitleWithStartTime");
        map.put("text", str);
        map.put(com.google.common.net.e.f6416j, str2);
        map.put("startTime", String.valueOf(j));
        map.put("duration", String.valueOf(j2));
        a(map);
    }

    public void a(boolean z) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setAudioSilence");
        map.put(com.alibaba.ariver.jsapi.multimedia.video.a.f, String.valueOf(z));
        a(map);
    }

    public void b(float f, long j, long j2, boolean z) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "repeat");
        map.put("repeat", String.valueOf(f));
        map.put("startTime", String.valueOf(j));
        map.put("duration", String.valueOf(j2));
        map.put("needOriginDuration", String.valueOf(z));
        a(map);
    }

    public void b(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("errorCode", String.valueOf(i));
        a(3057, map);
    }

    public void b(int i, int i2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyMusicWeight");
        map.put("id", String.valueOf(i));
        map.put("musicWeight", String.valueOf(i2));
        a(map);
    }

    public void b(ActionBase actionBase) {
        if (actionBase == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeFrameAnimation");
        map.put("targetID", String.valueOf(actionBase.getTargetId()));
        map.put("id", String.valueOf(actionBase.getId()));
        map.put("isStream", String.valueOf(actionBase.isStream()));
        a(map);
    }

    public void b(EffectCaption effectCaption) {
        if (effectCaption == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addCaption");
        map.put("type", "generator");
        map.put("param", effectCaption.toString());
        a(map);
    }

    public void b(EffectPaster effectPaster) {
        if (effectPaster == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "hidePaster");
        map.put("param", effectPaster.toString());
        a(map);
    }

    public void b(EffectText effectText) {
        if (effectText == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addSubtitle");
        map.put("type", "generator");
        map.put("param", effectText.toString());
        a(map);
    }

    public void b(TrackAudioStream trackAudioStream) {
        if (trackAudioStream == null && trackAudioStream.getSource() == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyMusic");
        map.put("path", trackAudioStream.getSource().getPath());
        map.put("startTime", String.valueOf(trackAudioStream.getStartTime()));
        map.put("duration", String.valueOf(trackAudioStream.getStartTime() + trackAudioStream.getStreamDuration()));
        map.put("streamStartTime", String.valueOf(trackAudioStream.getStreamStartTime()));
        map.put("streamDuration", String.valueOf(trackAudioStream.getStreamDuration()));
        map.put("musicWeight", String.valueOf(trackAudioStream.getAudioWeight()));
        a(map);
    }

    public void b(TrackEffect<EffectImage> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        EffectImage effectImage = (EffectImage) trackEffect.getBean();
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addImage");
        map.put("path", String.valueOf(effectImage.getPath()));
        map.put("width", String.valueOf(effectImage.getWidthRatio()));
        map.put("height", String.valueOf(effectImage.getHeightRatio()));
        map.put("posX", String.valueOf(effectImage.getXRadio()));
        map.put("posY", String.valueOf(effectImage.getYRadio()));
        map.put("startTime", String.valueOf(trackEffect.getStartTime()));
        map.put("duration", String.valueOf(trackEffect.getDuration()));
        map.put(Key.ROTATION, String.valueOf(effectImage.getRotation()));
        a(map);
    }

    public void b(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setOutputPath");
        map.put("outputPath", str);
        a(map);
    }

    public void c(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setFillBackgroundColor");
        map.put("color", String.valueOf(i));
        a(map);
    }

    public void c(int i, int i2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "deleteBlurBackground");
        map.put("streamID", String.valueOf(i));
        map.put("id", String.valueOf(i2));
        a(map);
    }

    public void c(EffectPaster effectPaster) {
        if (effectPaster == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removePaster");
        map.put("param", effectPaster.toString());
        a(map);
    }

    public void c(TrackAudioStream trackAudioStream) {
        if (trackAudioStream == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeDub");
        map.put("id", String.valueOf(trackAudioStream.getStreamId()));
        a(map);
    }

    public void c(TrackEffect<EffectFilter> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeAnimationFilter");
        map.put("id", String.valueOf(trackEffect.getViewId()));
        a(map);
    }

    public void d() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applySourceChange");
        a(map);
    }

    public void d(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setVolume");
        map.put("volume", String.valueOf(i));
        a(map);
    }

    public void d(int i, int i2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeRunningDisplayMode");
        map.put("streamID", String.valueOf(i));
        map.put("id", String.valueOf(i2));
        a(map);
    }

    public void d(TrackAudioStream trackAudioStream) {
        if (trackAudioStream == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeMusic");
        map.put("id", String.valueOf(trackAudioStream.getStreamId()));
        a(map);
    }

    public void d(TrackEffect<EffectImage> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeImage");
        map.put("id", String.valueOf(trackEffect.getViewId()));
        a(map);
    }

    public void e() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "cancelCompose");
        a(3000, map);
        map.clear();
        a(3055, map);
    }

    public void e(int i, int i2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setDisplaySize");
        map.put("width", String.valueOf(i));
        map.put("height", String.valueOf(i2));
        a(map);
    }

    public void e(TrackEffect<EffectFilter> trackEffect) {
        if (trackEffect == null) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "updateAnimationFilter");
        map.put("path", String.valueOf(((EffectFilter) trackEffect.getBean()).getPath()));
        map.put("startTime", String.valueOf(trackEffect.getStartTime()));
        map.put("duration", String.valueOf(trackEffect.getDuration()));
        a(map);
    }

    public void f() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "clearAllAnimationFilter");
        a(map);
    }

    public void g() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "init");
        a(map);
    }

    public void h() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "invert");
        a(map);
    }

    public void i() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "onDestroy");
        a(map);
    }

    public void j() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "pause");
        a(map);
    }

    public void k() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "play");
        a(map);
    }

    public void l() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeFilter");
        a(map);
    }

    public void m() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "replay");
        a(map);
    }

    public void n() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "resume");
        a(map);
    }

    public void o() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "saveEffectToLocal");
        a(map);
    }

    public void p() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setDisplayView");
        a(map);
    }

    public void q() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setTransitions");
        a(map);
    }

    public void r() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "stop");
        a(map);
    }
}
