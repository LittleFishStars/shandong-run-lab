package com.alibaba.triver.embed.video.video;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.camera.video.AudioStats;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.embed.video.R;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import com.google.android.exoplayer2.util.FileTypes;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VideoEditActivity extends Activity implements RangeBar.a {
    private static final String f = "VideoEditActivity";
    private String A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RecyclerView f24894a;
    RangeBar b;
    FrameLayout c;
    VideoView d;
    private String h;
    private String i;
    private long j;
    private Adapter k;
    private LinearLayoutManager l;
    private int r;
    private int s;
    private String t;
    private String u;
    private List<d> v;
    private TextView w;
    private TextView x;
    private int y;
    private long z;
    private final int g = 15;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 15;
    ExecutorService e = Executors.newFixedThreadPool(3);
    private RecyclerView.OnScrollListener B = new RecyclerView.OnScrollListener() { // from class: com.alibaba.triver.embed.video.video.VideoEditActivity.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                VideoEditActivity videoEditActivity = VideoEditActivity.this;
                videoEditActivity.n = videoEditActivity.l.findFirstVisibleItemPosition();
                VideoEditActivity videoEditActivity2 = VideoEditActivity.this;
                videoEditActivity2.o = videoEditActivity2.l.findLastVisibleItemPosition();
                List<d> listB = VideoEditActivity.this.k.b();
                for (int i2 = VideoEditActivity.this.n; i2 <= VideoEditActivity.this.o; i2++) {
                    if (!g.c(VideoEditActivity.this.i + listB.get(i2).b())) {
                        VideoEditActivity videoEditActivity3 = VideoEditActivity.this;
                        videoEditActivity3.a(i2, (videoEditActivity3.o - i2) + 1);
                        break;
                    }
                }
            }
            VideoEditActivity.this.c();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    };

    public interface a {
        void a(Bitmap bitmap, int i);
    }

    public void click2(View view) {
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView(R.layout.triver_activity_edit_video);
        Intent intent = getIntent();
        if (intent != null) {
            this.y = intent.getIntExtra(h.p, 0);
            this.z = intent.getLongExtra("duration", 0L);
        }
        this.A = WVNativeCallbackUtil.SEPERATER + this.z + "s";
        this.s = this.y;
        this.v = new ArrayList();
        this.f24894a = (RecyclerView) findViewById(R.id.trv_recyclerview);
        this.b = (RangeBar) findViewById(R.id.trv_rangeBar);
        this.c = (FrameLayout) findViewById(R.id.trv_fram);
        this.d = (VideoView) findViewById(R.id.trv_uVideoView);
        this.w = (TextView) findViewById(R.id.trv_bt_cut_video);
        this.b.setMaxDuration(this.y);
        String stringExtra = getIntent().getStringExtra("path");
        this.h = stringExtra;
        if (TextUtils.isEmpty(stringExtra) || !new File(this.h).exists()) {
            TriverToastUtils.showLongToast(this, getString(R.string.triver_video_not_exist));
            finish();
        }
        String str = "temp" + (System.currentTimeMillis() / 1000);
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("test");
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        this.i = sb.toString();
        this.t = Environment.getExternalStorageDirectory().getAbsolutePath() + str2 + "test" + str2 + "clicp";
        File file = new File(this.i);
        if (!file.exists()) {
            file.mkdirs();
        }
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0, 15);
        this.f24894a.setRecycledViewPool(recycledViewPool);
        this.j = g.a(this.h);
        b();
        a();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        VideoView videoView = this.d;
        if (videoView != null) {
            videoView.stopPlayback();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.d.pause();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.k.a(this.b.getMeasuredWidth() / 15);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i = this.q;
        int i2 = this.p;
        int i3 = i - i2;
        int i4 = this.n + i2;
        this.r = i4;
        this.s = i4 + i3;
        if (!this.d.isPlaying()) {
            this.d.start();
        }
        this.d.seekTo((this.r * 1000) / 2);
        this.x.setText(i3 + "s" + this.A);
    }

    private void b() {
        File file = new File(this.i);
        if (!file.exists()) {
            file.mkdirs();
        }
        a(0, 30);
    }

    private void a() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.l = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.f24894a.setLayoutManager(this.l);
        Adapter adapter = new Adapter(this, this.v);
        this.k = adapter;
        adapter.a(this.i);
        this.f24894a.setAdapter(this.k);
        this.f24894a.addOnScrollListener(this.B);
        this.b.setOnRangeBarChangeListener(this);
        this.d.setVideoPath(this.h);
        this.d.start();
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.video.VideoEditActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    try {
                        VideoEditActivity.this.e.execute(new Runnable() { // from class: com.alibaba.triver.embed.video.video.VideoEditActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    VideoEditActivity.this.a(h.b, com.alibaba.triver.embed.video.a.a.a(VideoEditActivity.this.getApplicationContext()) + com.alibaba.triver.embed.video.a.a.a(com.alibaba.triver.embed.video.a.a.f24824a));
                                } catch (Exception unused) {
                                    RVLogger.e(VideoEditActivity.f, "视频裁剪出问题了");
                                    TriverToastUtils.showLongToast(VideoEditActivity.this.getApplicationContext(), VideoEditActivity.this.getString(R.string.triver_video_cut_failed));
                                }
                            }
                        });
                    } catch (Exception e) {
                        RVLogger.w(Log.getStackTraceString(e));
                    }
                } finally {
                    VideoEditActivity.this.finish();
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.trv_tv_duration);
        this.x = textView;
        textView.setText(this.y + "s" + this.A);
    }

    public List<d> a(long j) {
        ArrayList arrayList = new ArrayList();
        int i = (int) (j / 1000);
        int i2 = 0;
        while (true) {
            this.m = i2;
            int i3 = this.m;
            if (i3 >= i * 2) {
                return arrayList;
            }
            arrayList.add(new d(i3, "temp" + this.m + FileTypes.F));
            i2 = this.m + 1;
        }
    }

    @Override // com.alibaba.triver.embed.video.video.RangeBar.a
    public void a(RangeBar rangeBar, int i, int i2) {
        this.p = i;
        this.q = i2;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        this.e.execute(new Runnable() { // from class: com.alibaba.triver.embed.video.video.VideoEditActivity.3
            @Override // java.lang.Runnable
            public void run() throws IOException {
                VideoEditActivity videoEditActivity = VideoEditActivity.this;
                videoEditActivity.a(videoEditActivity.h, 100, 2, null);
            }
        });
    }

    public void a(String str, int i, int i2, a aVar) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            int i3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9)) / 1000;
            for (int i4 = 0; i4 < i3; i4++) {
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(((i4 * 1000) * 1000) / 2, 2);
                e.a(frameAtTime, this.i, "temp" + i4 + FileTypes.F);
                this.v.add(new d(i4, "temp" + i4 + FileTypes.F));
                runOnUiThread(new Runnable() { // from class: com.alibaba.triver.embed.video.video.VideoEditActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoEditActivity.this.k.notifyDataSetChanged();
                    }
                });
                if (frameAtTime != null && !frameAtTime.isRecycled()) {
                    frameAtTime.recycle();
                }
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        int width;
        int height;
        int iMax;
        if (i <= 0 || (iMax = Math.max((width = bitmap.getWidth()), (height = bitmap.getHeight()))) <= i) {
            return bitmap;
        }
        float f2 = (i * 1.0f) / iMax;
        return Bitmap.createScaledBitmap(bitmap, Math.round(width * f2), Math.round(f2 * height), true);
    }

    public void a(String str, String str2) throws IOException {
        Intent intent = new Intent(str);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str2);
        VideoModel videoModel = new VideoModel();
        videoModel.apFilePath = str2;
        videoModel.duration = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / 1000;
        videoModel.height = Long.parseLong(mediaMetadataRetriever.extractMetadata(19));
        videoModel.width = Long.parseLong(mediaMetadataRetriever.extractMetadata(18));
        videoModel.size = (new File(videoModel.apFilePath).length() + AudioStats.AUDIO_AMPLITUDE_NONE) / 1024.0d;
        intent.putExtra(h.c, videoModel);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        mediaMetadataRetriever.release();
    }
}
