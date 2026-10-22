package com.aliyun.svideosdk.recorder.impl;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.aliyun.svideosdk.common.struct.project.AliyunEditorProject;
import com.aliyun.svideosdk.common.struct.project.Config;
import com.aliyun.svideosdk.common.struct.project.ProjectUtil;
import com.aliyun.svideosdk.common.struct.project.VideoTrackClip;
import com.aliyun.svideosdk.common.struct.project.json.ProjectJSONSupportImpl;
import com.aliyun.svideosdk.recorder.AliyunIClipManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c implements AliyunIClipManager {
    private int c;
    private File e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<VideoTrackClip> f25838a = new CopyOnWriteArrayList<>();
    private int b = Integer.MAX_VALUE;
    private long d = 0;
    private AliyunEditorProject f = null;
    private com.aliyun.common.b.a g = new ProjectJSONSupportImpl();

    public class a extends AsyncTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f25839a;

        public a(c cVar, String[] strArr) {
            this.f25839a = strArr;
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object[] objArr) {
            for (String str : this.f25839a) {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            }
            return null;
        }
    }

    public c(Context context) {
        this.e = ProjectUtil.newProjectDir(context.getExternalFilesDir(null).getAbsolutePath() + File.separator + AliyunEditorProject.DRAFT_DIR);
    }

    private void a(int i) {
        AliyunEditorProject aliyunEditorProject = this.f;
        if (aliyunEditorProject == null) {
            return;
        }
        aliyunEditorProject.getTimeline().getPrimaryTrack().getVideoTrackClips().remove(i);
        this.f.refreshTimeLine();
    }

    private void a(String[] strArr) {
        new a(this, strArr).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Object[0]);
    }

    private void b(VideoTrackClip videoTrackClip) {
        if (this.f == null) {
            this.f = ProjectUtil.newProject(this.e);
        }
        this.f.getTimeline().getPrimaryTrack().getVideoTrackClips().add(videoTrackClip);
        this.f.refreshTimeLine();
    }

    private void d() {
        com.aliyun.common.utils.g.c(this.e);
        this.f = null;
    }

    private void e() {
        AliyunEditorProject aliyunEditorProject = this.f;
        if (aliyunEditorProject == null) {
            return;
        }
        List<VideoTrackClip> videoTrackClips = aliyunEditorProject.getTimeline().getPrimaryTrack().getVideoTrackClips();
        if (videoTrackClips.size() > 0) {
            videoTrackClips.remove(videoTrackClips.size() - 1);
        }
        this.f.refreshTimeLine();
    }

    public CopyOnWriteArrayList<VideoTrackClip> a() {
        return this.f25838a;
    }

    public void a(VideoTrackClip videoTrackClip) {
        this.f25838a.add(videoTrackClip);
        this.d = (long) (this.d + ((videoTrackClip.getOut() - videoTrackClip.getIn()) * 1000000.0f));
        b(videoTrackClip);
    }

    public void a(String str) {
        AliyunEditorProject aliyunEditorProject = this.f;
        if (aliyunEditorProject == null) {
            return;
        }
        aliyunEditorProject.setRequestID(str);
    }

    public Config b() {
        return this.f.getConfig();
    }

    public Uri c() {
        f();
        return Uri.fromFile(AliyunEditorProject.getProjectFile(this.e));
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void deleteAllPart() {
        d();
        Iterator<VideoTrackClip> it = this.f25838a.iterator();
        while (it.hasNext()) {
            a(new String[]{it.next().getSource().getPath()});
        }
        this.f25838a.clear();
        this.d = 0L;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void deleteLastPart() {
        if (this.f25838a.size() == 0) {
            return;
        }
        CopyOnWriteArrayList<VideoTrackClip> copyOnWriteArrayList = this.f25838a;
        VideoTrackClip videoTrackClipRemove = copyOnWriteArrayList.remove(copyOnWriteArrayList.size() - 1);
        this.d = (long) (this.d - ((videoTrackClipRemove.getOut() - videoTrackClipRemove.getIn()) * 1000000.0f));
        e();
        a(new String[]{videoTrackClipRemove.getSource().getPath()});
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void deletePart() {
        deleteLastPart();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void deletePart(int i) {
        if (i < this.f25838a.size()) {
            VideoTrackClip videoTrackClipRemove = this.f25838a.remove(i);
            this.d = (long) (this.d - ((videoTrackClipRemove.getOut() - videoTrackClipRemove.getIn()) * 1000000.0f));
            a(i);
            a(new String[]{videoTrackClipRemove.getSource().getPath()});
        }
    }

    public void f() {
        AliyunEditorProject aliyunEditorProject = this.f;
        if (aliyunEditorProject == null) {
            return;
        }
        ProjectUtil.writeProject(aliyunEditorProject, aliyunEditorProject.getProjectFile(), this.g);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public int getDuration() {
        return (int) getDuration(TimeUnit.MILLISECONDS);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public long getDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.d, TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public int getMaxDuration() {
        return this.b;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public int getMinDuration() {
        return this.c;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public int getPartCount() {
        return this.f25838a.size();
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public List<String> getVideoPathList() {
        ArrayList arrayList = new ArrayList();
        Iterator<VideoTrackClip> it = this.f25838a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getSource().getPath());
        }
        return arrayList;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void setMaxDuration(int i) {
        this.b = i;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIClipManager
    public void setMinDuration(int i) {
        this.c = i;
    }
}
