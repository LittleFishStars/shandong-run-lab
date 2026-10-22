package com.aliyun.common.c.b;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceView;
import androidx.constraintlayout.motion.widget.Key;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alipay.sdk.m.y.l;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.struct.common.VideoQuality;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.EffectSticker;
import com.aliyun.svideosdk.common.struct.encoder.VideoCodecs;
import com.aliyun.svideosdk.common.struct.recorder.CameraParam;
import com.aliyun.svideosdk.common.struct.recorder.CameraType;
import com.aliyun.svideosdk.common.struct.recorder.FlashType;
import com.aliyun.svideosdk.common.struct.recorder.MediaInfo;
import com.aliyun.svideosdk.conan.event.AlivcEventReporter;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends f {
    private String e = com.aliyun.common.c.c.a.a();

    public e(Context context) {
        AlivcEventReporter alivcEventReporterA = g.a(context.getApplicationContext());
        this.f25568a = alivcEventReporterA;
        if (alivcEventReporterA != null) {
            alivcEventReporterA.d(AliyunLogCommon.SubModule.RECORD);
            this.f25568a.c(this.e);
        }
        this.b = 2000;
    }

    public int a(long j) {
        HashMap<String, String> map = new HashMap<>();
        map.put("use_time", String.valueOf(j));
        return a(2100, map);
    }

    public void a(float f) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setExposureCompensationRatio");
        map.put("exposure_compensation", String.valueOf(f));
        a(map);
    }

    public void a(float f, float f2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setFocus");
        map.put("focus_point_x", String.valueOf(f));
        map.put("focus_point_y", String.valueOf(f2));
        a(map);
    }

    public void a(float f, float f2, float f3, float f4, EffectBase effectBase) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setEffectView");
        map.put("vid", effectBase != null ? String.valueOf(effectBase.getResId()) : "");
        map.put("res_width", String.valueOf(f3));
        map.put("res_height", String.valueOf(f4));
        map.put("pos_x", String.valueOf(f));
        map.put("pos_y", String.valueOf(f2));
        a(map);
    }

    public void a(float f, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "stopPreview");
        map.put("avg_fps", String.valueOf(f));
        map.put("slowly_render_count", String.valueOf(i));
        map.put("avg_inner_render_cost", String.valueOf(j));
        map.put("max_inner_render_cost", String.valueOf(j2));
        map.put("avg_oes_render_cost", String.valueOf(j3));
        map.put("max_oes_render_cost", String.valueOf(j4));
        map.put("avg_t2d_render_cost", String.valueOf(j5));
        map.put("max_t2d_render_cost", String.valueOf(j6));
        map.put("frame_count", String.valueOf(i2));
        a(map);
    }

    public void a(float f, int i, long j, long j2, long j3, long j4, long j5, long j6, int i2, int i3, int i4, int i5, int i6, VideoCodecs videoCodecs, VideoQuality videoQuality, int i7, int i8, String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "startRecording");
        map.put("avg_fps", String.valueOf(f));
        map.put("slowly_render_count", String.valueOf(i));
        map.put("avg_inner_render_cost", String.valueOf(j));
        map.put("max_inner_render_cost", String.valueOf(j2));
        map.put("avg_t2d_render_cost", String.valueOf(j5));
        map.put("max_t2d_render_cost", String.valueOf(j6));
        map.put("frame_count", String.valueOf(i2));
        map.put("avg_oes_render_cost", String.valueOf(j3));
        map.put("max_oes_render_cost", String.valueOf(j4));
        map.put("v_bitrate", String.valueOf(i3));
        map.put("crf", String.valueOf(i4));
        map.put("enc_fps", String.valueOf(i5));
        map.put("gop", String.valueOf(i6));
        map.put("enc_type", String.valueOf(videoCodecs));
        map.put("v_quality", String.valueOf(videoQuality));
        map.put("out_width", String.valueOf(i7));
        map.put("out_height", String.valueOf(i8));
        map.put("record_sid", str);
        a(map);
    }

    public void a(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeAnimationFilter");
        map.put("vid", String.valueOf(i));
        a(map);
    }

    public void a(int i, int i2, List<Camera.Size> list) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setPictureSize");
        map.put("width", String.valueOf(i));
        map.put("height", String.valueOf(i2));
        StringBuilder sb = new StringBuilder();
        for (Camera.Size size : list) {
            sb.append(size.width);
            sb.append("X");
            sb.append(size.height);
            sb.append(l.b);
        }
        map.put("pic_size_list", sb.toString());
        a(map);
    }

    public void a(int i, long j) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "switchCamera");
        map.put("res", String.valueOf(i));
        map.put("use_time", String.valueOf(j));
        a(map);
    }

    public void a(SurfaceView surfaceView) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setDisplayView");
        map.put("display_view", surfaceView == null ? "" : surfaceView.toString());
        a(map);
    }

    public void a(Size size, SortedSet<Size> sortedSet) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setPictureSize");
        map.put("width", String.valueOf(size.getWidth()));
        map.put("height", String.valueOf(size.getHeight()));
        StringBuilder sb = new StringBuilder();
        for (Size size2 : sortedSet) {
            sb.append(size2.getWidth());
            sb.append("X");
            sb.append(size2.getHeight());
            sb.append(l.b);
        }
        map.put("pic_size_list", sb.toString());
        a(map);
    }

    public void a(VideoQuality videoQuality) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setVideoQuality");
        map.put("v_quality", String.valueOf(videoQuality));
        a(map);
    }

    public void a(EffectImage effectImage, float f, float f2, float f3, float f4, float f5) {
        String strValueOf;
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addImage");
        if (effectImage != null) {
            map.put("res_path", effectImage.getBitmap() == null ? effectImage.getPath() : effectImage.getBitmap().toString());
            strValueOf = String.valueOf(effectImage.getResId());
        } else {
            strValueOf = "";
            map.put("res_path", "");
        }
        map.put("vid", strValueOf);
        map.put("res_width", String.valueOf(f3));
        map.put("res_height", String.valueOf(f4));
        map.put("pos_x", String.valueOf(f));
        map.put("pos_y", String.valueOf(f2));
        map.put(Key.ROTATION, String.valueOf(f5));
        a(map);
    }

    public void a(EffectSticker effectSticker, boolean z, String str, float f) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "addPaster");
        if (effectSticker != null) {
            map.put("res_path", effectSticker.getPath());
            map.put("vid", String.valueOf(effectSticker.getResId()));
        } else {
            map.put("res_path", "");
            map.put("vid", "");
        }
        map.put("inner_face_status", String.valueOf(z));
        map.put("face_model_path", str);
        map.put("face_rotation", String.valueOf(f));
        map.put("pos_x", String.valueOf(effectSticker.getXRadio()));
        map.put("pos_y", String.valueOf(effectSticker.getYRadio()));
        map.put("res_width", String.valueOf(effectSticker.getWidthRatio()));
        map.put("res_height", String.valueOf(effectSticker.getHeightRatio()));
        map.put(Key.ROTATION, String.valueOf(effectSticker.getRotation()));
        map.put("flip", String.valueOf(effectSticker.isFlipH()));
        a(map);
    }

    public void a(CameraParam cameraParam) {
        String strValueOf;
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setCameraParam");
        if (cameraParam != null) {
            map.put("flash_type", cameraParam.getFlashType());
            map.put("zoom", String.valueOf(cameraParam.getZoomRatio()));
            map.put("focus_mode", String.valueOf(cameraParam.getFocusMode()));
            strValueOf = String.valueOf(cameraParam.getExposureCompensationRatio());
        } else {
            strValueOf = "";
            map.put("flash_type", "");
            map.put("zoom", "");
            map.put("focus_mode", "");
        }
        map.put("exposure_compensation", strValueOf);
        a(map);
    }

    public void a(CameraType cameraType) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setCameraType");
        map.put("cam_type", String.valueOf(cameraType));
        a(map);
    }

    public void a(FlashType flashType) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "switchLight");
        map.put("res", String.valueOf(flashType));
        a(map);
    }

    public void a(FlashType flashType, boolean z) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setLight");
        map.put("flash_type", String.valueOf(flashType));
        map.put("res", String.valueOf(z));
        a(map);
    }

    public void a(MediaInfo mediaInfo) {
        String strValueOf;
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setMediaInfo");
        if (mediaInfo != null) {
            map.put("out_width", String.valueOf(mediaInfo.getVideoWidth()));
            map.put("out_height", String.valueOf(mediaInfo.getVideoHeight()));
            map.put("crf", String.valueOf(mediaInfo.getCrf()));
            map.put(AliyunLogKey.KEY_FPS, String.valueOf(mediaInfo.getFps()));
            map.put("enc_fps", String.valueOf(mediaInfo.getEncoderFps()));
            strValueOf = String.valueOf(mediaInfo.getVideoCodec());
        } else {
            strValueOf = "";
            map.put("out_width", "");
            map.put("out_height", "");
            map.put("crf", "");
            map.put(AliyunLogKey.KEY_FPS, "");
            map.put("enc_fps", "");
        }
        map.put("enc_type", strValueOf);
        a(map);
    }

    public void a(Object obj) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setOnFrameCallback");
        map.put(RenderCallContext.TYPE_CALLBACK, String.valueOf(obj));
        a(map);
    }

    public void a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "startPreview");
        map.put(RenderCallContext.TYPE_CALLBACK, String.valueOf(obj));
        map.put("capture_width", String.valueOf(i));
        map.put("capture_height", String.valueOf(i2));
        map.put("txt_width", String.valueOf(i3));
        map.put("txt_height", String.valueOf(i4));
        map.put("camera_return", String.valueOf(i5));
        map.put("beauty_level", String.valueOf(i6));
        map.put("camera_version", String.valueOf(i7));
        a(map);
    }

    public void a(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyFilter");
        map.put("res_path", str);
        a(map);
    }

    public void a(String str, int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "applyAnimationFilter");
        map.put("res_path", str);
        map.put("vid", String.valueOf(i));
        a(map);
    }

    public void a(String str, long j, long j2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setMusic");
        map.put("res_path", str);
        map.put("stream_start_time", String.valueOf(j));
        map.put("stream_duration", String.valueOf(j2));
        a(map);
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, float f, int i2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "cancelRecording");
        map.put("record_sid", str);
        map.put("avg_fps", String.valueOf(f));
        map.put("slowly_render_count", String.valueOf(i2));
        map.put("avg_inner_render_cost", String.valueOf(j));
        map.put("max_inner_render_cost", String.valueOf(j2));
        map.put("avg_oes_render_cost", String.valueOf(j3));
        map.put("max_oes_render_cost", String.valueOf(j4));
        map.put("avg_t2d_render_cost", String.valueOf(j5));
        map.put("max_t2d_render_cost", String.valueOf(j6));
        map.put("avg_enc_render_cost", String.valueOf(j7));
        map.put("max_enc_render_cost", String.valueOf(j8));
        map.put("frame_count", String.valueOf(i));
        a(map);
    }

    public void a(boolean z) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "needFaceTrackInternal");
        map.put("face_toggle", String.valueOf(z));
        a(map);
    }

    public void b(float f) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setRate");
        map.put("rate", String.valueOf(f));
        a(map);
    }

    public void b(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeImage");
        map.put("vid", String.valueOf(i));
        a(map);
    }

    public void b(long j) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "finishRecording");
        map.put("use_time", String.valueOf(j));
        a(map);
    }

    public void b(Object obj) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setRecordCallback");
        map.put(RenderCallContext.TYPE_CALLBACK, String.valueOf(obj));
        a(map);
    }

    public void b(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setFaceTrackInternalModelPath");
        map.put("face_model_path", str);
        File file = new File(str + "/face_all_data_130.dat");
        map.put("file_exist", String.valueOf(file.exists()));
        map.put("file_size", String.valueOf(file.length()));
        a(map);
    }

    public void b(String str, int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "updateAnimationFilter");
        map.put("res_path", str);
        map.put("vid", String.valueOf(i));
        a(map);
    }

    public void b(String str, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i, float f, int i2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "stopRecording");
        map.put("record_sid", str);
        map.put("avg_fps", String.valueOf(f));
        map.put("slowly_render_count", String.valueOf(i2));
        map.put("avg_inner_render_cost", String.valueOf(j));
        map.put("max_inner_render_cost", String.valueOf(j2));
        map.put("avg_oes_render_cost", String.valueOf(j3));
        map.put("max_oes_render_cost", String.valueOf(j4));
        map.put("avg_t2d_render_cost", String.valueOf(j5));
        map.put("max_t2d_render_cost", String.valueOf(j6));
        map.put("avg_enc_render_cost", String.valueOf(j7));
        map.put("max_enc_render_cost", String.valueOf(j8));
        map.put("frame_count", String.valueOf(i));
        a(map);
    }

    public void b(boolean z) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setBeautyStatus");
        map.put("beauty_status", String.valueOf(z));
        a(map);
    }

    public String c() {
        return this.e;
    }

    public void c(float f) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setZoom");
        map.put("zoom", String.valueOf(f));
        a(map);
    }

    public void c(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removePaster");
        map.put("vid", String.valueOf(i));
        a(map);
    }

    public void c(long j) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "resizePreviewSize");
        map.put("use_time", String.valueOf(j));
        a(map);
    }

    public void c(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setOutputPath");
        map.put("out_path", str);
        a(map);
    }

    public void c(boolean z) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setMute");
        map.put(com.alibaba.ariver.jsapi.multimedia.video.a.f, String.valueOf(z));
        a(map);
    }

    public void d() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "destroy");
        a(map);
    }

    public void d(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setBeautyLevel");
        map.put("beauty_level", String.valueOf(i));
        a(map);
    }

    public void d(String str) {
        AlivcEventReporter alivcEventReporter = this.f25568a;
        if (alivcEventReporter != null) {
            alivcEventReporter.d(str);
        }
    }

    public void e() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeFilter");
        a(map);
    }

    public void e(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setFaceDetectRotation");
        map.put(Key.ROTATION, String.valueOf(i));
        a(map);
    }

    public void f() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "removeMusic");
        a(map);
    }

    public void f(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setFaceTrackInternalMaxFaceCount");
        map.put("face_count", String.valueOf(i));
        a(map);
    }

    public void g() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", com.alibaba.ariver.jsapi.multimedia.camera.a.f24158a);
        a(map);
    }

    public void g(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setFocusMode");
        map.put("focus_mode", String.valueOf(i));
        a(map);
    }

    public void h() {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "takePicture");
        a(map);
    }

    public void h(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setGop");
        map.put("gop", String.valueOf(i));
        a(map);
    }

    public void i(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setRecordRotation");
        map.put(Key.ROTATION, String.valueOf(i));
        a(map);
    }

    public void j(int i) {
        HashMap<String, String> map = new HashMap<>();
        map.put("_interface", "setVideoBitrate");
        map.put("v_bitrate", String.valueOf(i));
        a(map);
    }
}
