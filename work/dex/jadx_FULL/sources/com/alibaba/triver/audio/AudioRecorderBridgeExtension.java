package com.alibaba.triver.audio;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaRecorder;
import android.util.Log;
import androidx.camera.video.AudioStats;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingApiContext;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.basic.api.RequestPermission;
import com.alibaba.triver.embed.video.R;
import com.alibaba.triver.kit.api.utils.FileUtils;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AudioRecorderBridgeExtension implements BridgeExtension {
    private static int I = 1;
    public static final int REQUEST_AUDIO_RECORD_PERMISSION_CODE = 111;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24647a = "mp3";
    private static final String b = "aac";
    private static final String c = "silk";
    private static final String d = "auto";
    private static final String e = "mic";
    private static final String f = "camcorder";
    private static final String g = "voice_communication";
    private static final String h = "voice_recognition";
    private static final String i = "text";
    private static final String j = "recordStart";
    private static final String k = "recordStop";
    private static final String l = "recordError";
    private static final String m = "recordPause";
    private static final String n = "recordFrameRecorded";
    private static final String o = "recordResume";
    private static final String p = "error";
    private static final String q = "apFilePath";
    private static final String r = "identifier";
    private static final String s = "duration";
    private static final String t = "errorMessage";
    private static final int u = 0;
    private static final int v = -1;
    private static final int w = -2;
    private String A;
    private Timer H;
    private boolean x;
    private volatile boolean y;
    private MediaRecorder z;
    private int B = 10000;
    private int C = 1;
    private int D = 8000;
    private int E = 2;
    private int F = 48000;
    private String G = "acc";
    private Timer J = null;

    public static class PerReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b f24650a;

        public PerReceiver(b bVar) {
            this.f24650a = bVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                boolean z = false;
                if (intent.getIntExtra(RequestPermission.REQUEST_CODE, 0) == 111) {
                    int[] intArrayExtra = intent.getIntArrayExtra(RequestPermission.GRANT_RESULTS);
                    String[] stringArrayExtra = intent.getStringArrayExtra(RequestPermission.PERMISSIONS);
                    int i = 0;
                    while (true) {
                        if (intArrayExtra == null || i >= intArrayExtra.length) {
                            z = true;
                            break;
                        } else {
                            if (intArrayExtra[i] != 0) {
                                this.f24650a.a(stringArrayExtra[i]);
                                break;
                            }
                            i++;
                        }
                    }
                    if (z) {
                        this.f24650a.a();
                    }
                }
                LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            } catch (Throwable th) {
                RVLogger.e("Bridge", Log.getStackTraceString(th));
            }
        }
    }

    public class a extends TimerTask {
        private ApiContext b;
        private BridgeCallback c;

        public a(ApiContext apiContext, BridgeCallback bridgeCallback) {
            this.b = apiContext;
            this.c = bridgeCallback;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int maxAmplitude;
            try {
                if (!AudioRecorderBridgeExtension.this.x || !AudioRecorderBridgeExtension.this.y || AudioRecorderBridgeExtension.this.z == null || this.b == null || (maxAmplitude = AudioRecorderBridgeExtension.this.z.getMaxAmplitude()) == 0) {
                    return;
                }
                double d = maxAmplitude;
                double dLog10 = d > 1.0d ? Math.log10(d / ((double) AudioRecorderBridgeExtension.I)) * 20.0d : AudioStats.AUDIO_AMPLITUDE_NONE;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("db", (Object) Double.valueOf(dLog10));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", (Object) jSONObject);
                this.b.sendEvent(AudioRecorderBridgeExtension.n, jSONObject2, null);
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
                if (AudioRecorderBridgeExtension.this.J != null) {
                    AudioRecorderBridgeExtension.this.J.cancel();
                    AudioRecorderBridgeExtension.this.J = null;
                }
            }
        }
    }

    public interface b {
        void a();

        void a(String str);
    }

    public class c extends TimerTask {
        private ApiContext b;
        private BridgeCallback c;

        public c(ApiContext apiContext, BridgeCallback bridgeCallback) {
            this.b = apiContext;
            this.c = bridgeCallback;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AudioRecorderBridgeExtension.this.b(this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ApiContext apiContext, final BridgeCallback bridgeCallback) {
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.z = mediaRecorder;
        mediaRecorder.setAudioSource(0);
        this.z.setOutputFormat(2);
        this.z.setAudioEncoder(3);
        String strA = a(apiContext);
        this.A = strA;
        this.z.setOutputFile(strA);
        MediaRecorder mediaRecorder2 = this.z;
        int i2 = this.B;
        if (i2 <= 1000) {
            i2 = 10000;
        }
        mediaRecorder2.setMaxDuration(i2);
        this.z.setOnInfoListener(new MediaRecorder.OnInfoListener() { // from class: com.alibaba.triver.audio.AudioRecorderBridgeExtension.1
            @Override // android.media.MediaRecorder.OnInfoListener
            public void onInfo(MediaRecorder mediaRecorder3, int i3, int i4) {
                if (i3 == 800) {
                    AudioRecorderBridgeExtension.this.b(apiContext, bridgeCallback);
                    RVLogger.e(AudioRecorderBridgeExtension.k, "Yes");
                } else if (i3 == 801) {
                    AudioRecorderBridgeExtension.this.b(apiContext, bridgeCallback);
                    RVLogger.e(AudioRecorderBridgeExtension.k, "Yes1");
                } else {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errorMessage", (Object) Integer.valueOf(i3));
                    RVLogger.e(AudioRecorderBridgeExtension.k, jSONObject.toJSONString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ApiContext apiContext, BridgeCallback bridgeCallback) {
        MediaRecorder mediaRecorder = this.z;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (IllegalStateException e2) {
                RVLogger.w(Log.getStackTraceString(e2));
            }
            this.y = false;
            a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tempFilePath", (Object) FileUtils.filePathToApUrl(this.A, "audio"));
            bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            apiContext.sendEvent(k, jSONObject2, null);
            Timer timer = this.H;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = this.J;
            if (timer2 != null) {
                timer2.cancel();
                this.J = null;
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        a();
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse pauseAudioRecord(@BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        RVLogger.d("AudioRecord", "pauseRecord, apiContext=" + apiContext + ", bridgeCallback=" + bridgeCallback);
        RVLogger.e("AudioRecord", "Android platform do not support Pause and Resume Record operation ");
        return BridgeResponse.UNKNOWN_ERROR;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse resumeAudioRecord(@BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        RVLogger.d("AudioRecord", "cancelRecord, apiContext=" + apiContext + ", bridgeCallback=" + bridgeCallback);
        RVLogger.e("AudioRecord", "Android platform do not support Pause and Resume Record operation ");
        return BridgeResponse.UNKNOWN_ERROR;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    public BridgeResponse startAudioRecord(@BindingApiContext final ApiContext apiContext, @BindingRequest final JSONObject jSONObject, @BindingCallback final BridgeCallback bridgeCallback) {
        RVLogger.d("AudioRecord", "startAudioRecord, apiContext=" + apiContext + ", params=" + jSONObject + ", bridgeCallback=" + bridgeCallback);
        if (this.y) {
            apiContext.sendEvent(l, null, null);
            return BridgeResponse.UNKNOWN_ERROR;
        }
        a(apiContext.getActivity(), new b() { // from class: com.alibaba.triver.audio.AudioRecorderBridgeExtension.2
            @Override // com.alibaba.triver.audio.AudioRecorderBridgeExtension.b
            public void a() {
                JSONObject jSONObject2 = jSONObject;
                if (jSONObject2 != null && jSONObject2.size() != 0) {
                    if (jSONObject.containsKey("duration")) {
                        AudioRecorderBridgeExtension.this.B = jSONObject.getInteger("duration").intValue();
                    }
                    if (jSONObject.containsKey("frameSize")) {
                        AudioRecorderBridgeExtension.this.x = true;
                    }
                }
                if (AudioRecorderBridgeExtension.this.z == null) {
                    AudioRecorderBridgeExtension.this.a(apiContext, bridgeCallback);
                    try {
                        AudioRecorderBridgeExtension.this.z.prepare();
                        AudioRecorderBridgeExtension.this.z.start();
                        if (AudioRecorderBridgeExtension.this.J != null) {
                            AudioRecorderBridgeExtension.this.J.cancel();
                            AudioRecorderBridgeExtension.this.J = null;
                        }
                        AudioRecorderBridgeExtension.this.J = new Timer();
                        AudioRecorderBridgeExtension.this.J.schedule(AudioRecorderBridgeExtension.this.new a(apiContext, bridgeCallback), 100L, 33L);
                        apiContext.sendEvent(AudioRecorderBridgeExtension.j, null, null);
                        AudioRecorderBridgeExtension.this.y = true;
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("success", (Object) Boolean.TRUE);
                        bridgeCallback.sendJSONResponse(jSONObject3);
                        AudioRecorderBridgeExtension.this.H = new Timer();
                        AudioRecorderBridgeExtension.this.H.schedule(AudioRecorderBridgeExtension.this.new c(apiContext, bridgeCallback), AudioRecorderBridgeExtension.this.B);
                    } catch (IOException e2) {
                        RVLogger.w(Log.getStackTraceString(e2));
                    }
                }
            }

            @Override // com.alibaba.triver.audio.AudioRecorderBridgeExtension.b
            public void a(String str) {
                TriverToastUtils.showLongToast(apiContext.getActivity(), InternationalUtil.getString(apiContext, R.string.triver_video_permissions_denied_msg));
            }
        }, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", com.hjq.permissions.Permission.RECORD_AUDIO);
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public void stopAudioRecord(@BindingApiContext ApiContext apiContext, @BindingCallback BridgeCallback bridgeCallback) {
        RVLogger.d("AudioRecord", "stopAudioRecord, apiContext=" + apiContext + ", bridgeCallback=" + bridgeCallback);
        if (this.z != null) {
            b(apiContext, bridgeCallback);
        } else {
            RVLogger.e("AudioRecord", "stopAudioRecord called when RecordService NULL!");
        }
    }

    private String a(ApiContext apiContext) {
        String strA = com.alibaba.triver.embed.video.a.a.a(apiContext.getAppContext());
        if (strA == null) {
            strA = apiContext.getAppContext().getCacheDir().getAbsolutePath();
        }
        return strA + File.separator + System.currentTimeMillis() + ".m4a";
    }

    private void a() {
        MediaRecorder mediaRecorder = this.z;
        if (mediaRecorder != null) {
            mediaRecorder.release();
            this.z = null;
        }
    }

    private void a(Activity activity, b bVar, String... strArr) {
        try {
            if (PermissionChecker.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") == 0 && PermissionChecker.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && PermissionChecker.checkSelfPermission(activity, com.hjq.permissions.Permission.RECORD_AUDIO) == 0) {
                bVar.a();
            } else {
                ActivityCompat.requestPermissions(activity, strArr, 111);
                LocalBroadcastManager.getInstance(activity).registerReceiver(new PerReceiver(bVar), new IntentFilter(RequestPermission.ACTION_REQUEST_PERMISSIONS_RESULT));
            }
        } catch (Throwable th) {
            RVLogger.e("Bridge", Log.getStackTraceString(th));
        }
    }
}
