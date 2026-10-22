package com.aliyun.svideosdk.editor.impl;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import com.aliyun.svideosdk.common.struct.project.AliyunEditorProject;
import com.aliyun.svideosdk.editor.AliyunIPipController;
import com.aliyun.svideosdk.editor.AliyunIPipManager;
import com.aliyun.svideosdk.editor.AliyunIPipTrack;
import com.aliyun.svideosdk.editor.NativeEditor;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class q implements AliyunIPipManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeEditor f25759a;
    private AliyunEditorProject b;
    private List<AliyunIPipTrack> c = new ArrayList();
    private WeakReference<f> d;

    public q(NativeEditor nativeEditor, AliyunEditorProject aliyunEditorProject, f fVar) {
        this.f25759a = nativeEditor;
        this.b = aliyunEditorProject;
        this.d = new WeakReference<>(fVar);
    }

    public void a() {
        for (AliyunIPipController aliyunIPipController : getAllPip()) {
            if (aliyunIPipController instanceof p) {
                ((p) aliyunIPipController).d();
            }
        }
        if (this.f25759a != null) {
            this.f25759a = null;
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public AliyunIPipController createNewPip(String str) {
        if (!new File(str).exists()) {
            Log.e("AliyunPip", "file not found error");
            return null;
        }
        r rVar = new r();
        this.c.add(rVar);
        rVar.a(this.c.size());
        p pVar = new p(this.f25759a, str, this.d.get());
        rVar.a(pVar);
        this.b.getTimeline().getVideoTracks().add(rVar.b());
        return pVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public AliyunIPipController createPipInTrack(String str, AliyunIPipTrack aliyunIPipTrack) {
        if (!new File(str).exists()) {
            Log.e("AliyunPip", "file not found error");
            return null;
        }
        p pVar = new p(this.f25759a, str, this.d.get());
        if (aliyunIPipTrack instanceof r) {
            ((r) aliyunIPipTrack).a(pVar);
        }
        return pVar;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public AliyunIPipController findTopPipController(long j, PointF pointF) {
        for (AliyunIPipController aliyunIPipController : getAllPip()) {
            RectF pipRectFInCurrentScreen = aliyunIPipController.getPipRectFInCurrentScreen();
            PointF position = aliyunIPipController.getLayoutController().getPosition();
            Matrix matrix = new Matrix();
            matrix.setTranslate(pointF.x, pointF.y);
            matrix.postRotate(-(aliyunIPipController.getLayoutController().getRotationRadian() * 57.32484f), position.x, position.y);
            float[] fArr = {0.0f, 0.0f};
            matrix.mapPoints(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            if (aliyunIPipController.getTimeLineStartTimeInMillis() <= j && aliyunIPipController.getTimeLineEndTimeInMillis() >= j && pipRectFInCurrentScreen.contains(f, f2)) {
                return aliyunIPipController;
            }
        }
        return null;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public List<AliyunIPipController> getAllPip() {
        ArrayList arrayList = new ArrayList();
        Iterator<AliyunIPipTrack> it = getPipTracks().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getPipClips());
        }
        return arrayList;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public List<AliyunIPipTrack> getPipTracks() {
        return new ArrayList(this.c);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public boolean movePipIntoTrack(AliyunIPipController aliyunIPipController, AliyunIPipTrack aliyunIPipTrack, long j) {
        r rVar = (r) aliyunIPipController.getOwnerTrack();
        int iB = rVar.b(aliyunIPipController);
        if (iB < 0) {
            return false;
        }
        if (iB == 0) {
            this.b.getTimeline().getVideoTracks().remove(rVar.b());
            this.c.remove(rVar);
        }
        aliyunIPipController.setTimelineStartTime(j, TimeUnit.MILLISECONDS);
        ((r) aliyunIPipTrack).a(aliyunIPipController);
        return false;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPipManager
    public boolean removePip(AliyunIPipController aliyunIPipController) {
        this.f25759a.removePipInPic(aliyunIPipController.getStreamId());
        r rVar = (r) aliyunIPipController.getOwnerTrack();
        int iB = rVar.b(aliyunIPipController);
        if (iB == -1) {
            return false;
        }
        if (iB != 0) {
            return true;
        }
        this.b.getTimeline().getVideoTracks().remove(rVar.b());
        this.c.remove(rVar);
        return true;
    }
}
