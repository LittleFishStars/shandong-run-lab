package com.alibaba.triver.embed.video.video;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaMetadataRetriever;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.embed.video.R;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.android.exoplayer2.source.i;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecordVideoActivity extends Activity implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24888a = 0;
    public static final int b = 1;
    public static final int c = 2;
    static final int d = 1;
    private static final int e = 32;
    private static final String f = "RecordVideoActivity";
    private ImageView h;
    private SurfaceView i;
    private SurfaceHolder j;
    private Chronometer k;
    private int l;
    private File n;
    private Camera o;
    private MediaRecorder p;
    private String q;
    private int t;
    private int u;
    private ImageView v;
    private int w;
    private String x;
    private Executor g = Executors.newFixedThreadPool(1);
    private long m = 0;
    private String r = "";
    private MediaRecorder.OnErrorListener s = new MediaRecorder.OnErrorListener() { // from class: com.alibaba.triver.embed.video.video.RecordVideoActivity.1
        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(MediaRecorder mediaRecorder, int i, int i2) {
            if (mediaRecorder != null) {
                try {
                    mediaRecorder.reset();
                } catch (Exception e2) {
                    RVLogger.w(Log.getStackTraceString(e2));
                }
            }
        }
    };
    private SurfaceHolder.Callback y = new SurfaceHolder.Callback() { // from class: com.alibaba.triver.embed.video.video.RecordVideoActivity.3
        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            RecordVideoActivity.this.j.getSurface();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            RecordVideoActivity.this.e();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            RecordVideoActivity.this.g();
        }
    };

    private void i() {
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.p = mediaRecorder;
        mediaRecorder.reset();
        this.p.setCamera(this.o);
        this.p.setOnErrorListener(this.s);
        this.p.setPreviewDisplay(this.j.getSurface());
        this.p.setAudioSource(1);
        this.p.setVideoSource(1);
        this.p.setOutputFormat(0);
        this.p.setAudioEncoder(3);
        this.p.setVideoEncoder(2);
        this.p.setAudioEncodingBitRate(i.K);
        if (CamcorderProfile.hasProfile(4)) {
            CamcorderProfile camcorderProfile = CamcorderProfile.get(4);
            if (camcorderProfile.videoBitRate > 2097152) {
                this.p.setVideoEncodingBitRate(2097152);
            } else {
                this.p.setVideoEncodingBitRate(1048576);
            }
            this.p.setVideoFrameRate(camcorderProfile.videoFrameRate);
        } else {
            this.p.setVideoEncodingBitRate(1048576);
            this.p.setVideoFrameRate(30);
        }
        this.p.setOrientationHint(90);
        this.p.setVideoSize(640, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
        this.p.setOutputFile(this.q);
        int i = this.w;
        if (i > 0) {
            this.p.setMaxDuration(i * 1000);
            this.p.setOnInfoListener(new MediaRecorder.OnInfoListener() { // from class: com.alibaba.triver.embed.video.video.RecordVideoActivity.5
                @Override // android.media.MediaRecorder.OnInfoListener
                public void onInfo(MediaRecorder mediaRecorder2, int i2, int i3) throws IOException {
                    if (i2 == 800) {
                        System.out.println("-------->录制结束了");
                        RecordVideoActivity.this.b();
                        if (RecordVideoActivity.this.o != null) {
                            RecordVideoActivity.this.o.lock();
                        }
                        RecordVideoActivity.this.g();
                        RecordVideoActivity.this.h();
                        if ("".equals(RecordVideoActivity.this.r)) {
                            RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                            recordVideoActivity.r = recordVideoActivity.q;
                        }
                        RecordVideoActivity.this.l = 0;
                        RecordVideoActivity.this.a(h.f24906a);
                        RecordVideoActivity.this.finish();
                    }
                }
            });
        }
    }

    public void c() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        if (view.getId() == R.id.trv_record_control) {
            int i = this.l;
            if (i == 0) {
                if (com.alibaba.triver.embed.video.a.a.a(getApplicationContext()) == null) {
                    return;
                }
                this.q = com.alibaba.triver.embed.video.a.a.a(getApplicationContext()) + com.alibaba.triver.embed.video.a.a.a(com.alibaba.triver.embed.video.a.a.f24824a);
                if (a()) {
                    h();
                    this.l = 1;
                    return;
                }
                return;
            }
            if (i == 1) {
                b();
                this.o.lock();
                g();
                h();
                if ("".equals(this.r)) {
                    this.r = this.q;
                }
                this.l = 0;
                a(h.f24906a);
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView(R.layout.triver_activity_video);
        this.w = getIntent().getIntExtra(h.p, 0);
        this.x = getIntent().getStringExtra(h.n);
        d();
    }

    private void d() {
        this.i = (SurfaceView) findViewById(R.id.trv_record_surfaceView);
        this.h = (ImageView) findViewById(R.id.trv_record_control);
        this.k = (Chronometer) findViewById(R.id.trv_record_time);
        this.h.setOnClickListener(this);
        SurfaceHolder holder = this.i.getHolder();
        this.j = holder;
        holder.setType(3);
        this.t = this.i.getWidth();
        int height = this.i.getHeight();
        this.u = height;
        this.j.setFixedSize(this.t, height);
        this.j.setKeepScreenOn(true);
        this.j.addCallback(this.y);
        ImageView imageView = (ImageView) findViewById(R.id.trv_tiv_close);
        this.v = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.video.RecordVideoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordVideoActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.o != null) {
            g();
        }
        Camera cameraOpen = Camera.open();
        this.o = cameraOpen;
        if (cameraOpen == null) {
            TriverToastUtils.showToast(this, getString(R.string.triver_video_not_exist));
            return;
        }
        try {
            cameraOpen.setPreviewDisplay(this.j);
            f();
            this.o.startPreview();
        } catch (Exception e2) {
            RVLogger.d(f, "Error starting camera preview: " + e2.getMessage());
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    private void f() {
        Camera.Parameters parameters = this.o.getParameters();
        if (getResources().getConfiguration().orientation != 2) {
            parameters.set("orientation", RVParams.LONG_PORTRAIT);
            this.o.setDisplayOrientation(90);
        } else {
            parameters.set("orientation", "landscape");
            this.o.setDisplayOrientation(0);
        }
        parameters.setFocusMode("continuous-video");
        parameters.setRecordingHint(true);
        if (parameters.isVideoStabilizationSupported()) {
            parameters.setVideoStabilization(true);
        }
        this.o.setParameters(parameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Camera camera = this.o;
        if (camera != null) {
            camera.setPreviewCallback(null);
            this.o.stopPreview();
            this.o.release();
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int i = this.l;
        if (i == 0) {
            this.k.setBase(SystemClock.elapsedRealtime());
            this.k.start();
            this.h.setImageResource(R.mipmap.recordvideo_stop);
            this.h.setEnabled(false);
            new Handler().postDelayed(new Runnable() { // from class: com.alibaba.triver.embed.video.video.RecordVideoActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    RecordVideoActivity.this.h.setEnabled(true);
                }
            }, 1000L);
            return;
        }
        if (i == 1) {
            this.m = 0L;
            this.k.stop();
            this.h.setImageResource(R.mipmap.recordvideo_start);
        }
    }

    public void b() {
        this.p.setOnErrorListener(null);
        this.p.setPreviewDisplay(null);
        this.p.stop();
        this.p.reset();
        this.p.release();
        this.p = null;
    }

    public boolean a() {
        e();
        this.o.unlock();
        i();
        try {
            this.p.prepare();
            this.p.start();
            return true;
        } catch (Exception e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            return false;
        }
    }

    public void a(String str) throws IOException {
        Intent intent = new Intent(str);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(this.q);
        VideoModel videoModel = new VideoModel();
        videoModel.apFilePath = this.q;
        videoModel.duration = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / 1000;
        videoModel.height = Long.parseLong(mediaMetadataRetriever.extractMetadata(19));
        videoModel.width = Long.parseLong(mediaMetadataRetriever.extractMetadata(18));
        File file = new File(videoModel.apFilePath);
        if (file.exists()) {
            videoModel.size = (file.length() + AudioStats.AUDIO_AMPLITUDE_NONE) / 1024.0d;
        }
        intent.putExtra(h.c, videoModel);
        intent.putExtra(h.n, this.x);
        getApplication().sendBroadcast(intent);
        mediaMetadataRetriever.release();
    }
}
