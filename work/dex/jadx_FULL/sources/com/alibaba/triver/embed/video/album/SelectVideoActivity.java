package com.alibaba.triver.embed.video.album;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.embed.video.R;
import com.alibaba.triver.embed.video.video.VideoModel;
import com.alibaba.triver.embed.video.video.h;
import com.fl.saas.base.cache.DatabaseHelper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SelectVideoActivity extends Activity {
    private static final String c = "video/mp4";
    private static final int e = 34;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<VideoInfo> f24825a;
    Activity b;
    private final int d = 123;
    private ImageView f;
    private a g;
    private String h;

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView(R.layout.triver_activity_select_video);
        this.f24825a = new ArrayList();
        this.b = this;
        this.h = getIntent().getStringExtra(h.m);
        GridView gridView = (GridView) findViewById(R.id.trv_gridview);
        a aVar = new a(this, this.f24825a);
        this.g = aVar;
        gridView.setAdapter((ListAdapter) aVar);
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.triver.embed.video.album.SelectVideoActivity.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                SelectVideoActivity.this.a();
            }
        });
        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() { // from class: com.alibaba.triver.embed.video.album.SelectVideoActivity.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                System.out.println("-------->收到了选择信息的广播");
                VideoInfo videoInfo = (VideoInfo) intent.getExtras().get(h.i);
                System.out.println("----->" + videoInfo);
            }
        }, new IntentFilter(h.h));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.alibaba.triver.embed.video.album.SelectVideoActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) throws IOException {
                SelectVideoActivity.this.a(h.h, ((VideoInfo) SelectVideoActivity.this.g.getItem(i)).path);
                SelectVideoActivity.this.finish();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.trv_tiv_close);
        this.f = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.album.SelectVideoActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SelectVideoActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Bitmap bitmap;
        super.onDestroy();
        for (VideoInfo videoInfo : this.f24825a) {
            if (videoInfo != null && (bitmap = videoInfo.frame) != null && !bitmap.isRecycled()) {
                videoInfo.frame.recycle();
                videoInfo.frame = null;
            }
        }
    }

    public void a() throws IOException {
        Cursor cursorQuery = getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{DatabaseHelper.COLUMN_ID, "_data", "title", com.google.android.exoplayer2.offline.a.f3586e, "_display_name", "_size", "date_added", "duration", "width", "height"}, "mime_type=?", new String[]{"video/mp4"}, "date_added DESC");
        if (cursorQuery == null) {
            return;
        }
        while (cursorQuery.moveToNext()) {
            VideoInfo videoInfoA = a(cursorQuery.getString(cursorQuery.getColumnIndex("_data")));
            if (!TextUtils.isEmpty(videoInfoA.path)) {
                this.f24825a.add(videoInfoA);
            }
            this.b.runOnUiThread(new Runnable() { // from class: com.alibaba.triver.embed.video.album.SelectVideoActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    SelectVideoActivity.this.g.notifyDataSetChanged();
                }
            });
        }
        cursorQuery.close();
    }

    public VideoInfo a(String str) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        VideoInfo videoInfo = new VideoInfo();
        try {
            try {
                try {
                    File file = new File(str);
                    if (file.exists() && file.length() > 0) {
                        mediaMetadataRetriever.setDataSource(str);
                        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 2);
                        videoInfo.path = str;
                        videoInfo.frame = frameAtTime;
                        videoInfo.duration = strExtractMetadata;
                    }
                    mediaMetadataRetriever.release();
                    return videoInfo;
                } catch (Exception e2) {
                    RVLogger.w(Log.getStackTraceString(e2));
                    mediaMetadataRetriever.release();
                    return videoInfo;
                }
            } catch (RuntimeException unused) {
                return null;
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
                return videoInfo;
            } catch (RuntimeException unused2) {
                throw th;
            }
        }
    }

    public void a(String str, String str2) throws IOException {
        Intent intent = new Intent(str);
        intent.putExtra(h.m, this.h);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str2);
        VideoModel videoModel = new VideoModel();
        videoModel.apFilePath = str2;
        videoModel.duration = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / 1000;
        videoModel.height = Long.parseLong(mediaMetadataRetriever.extractMetadata(19));
        videoModel.width = Long.parseLong(mediaMetadataRetriever.extractMetadata(18));
        videoModel.size = new File(videoModel.apFilePath).length() / 1024;
        intent.putExtra(h.c, videoModel);
        mediaMetadataRetriever.release();
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        getApplication().sendBroadcast(intent);
    }
}
