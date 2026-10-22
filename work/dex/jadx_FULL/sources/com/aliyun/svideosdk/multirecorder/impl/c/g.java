package com.aliyun.svideosdk.multirecorder.impl.c;

import android.content.Context;
import android.view.View;
import com.aliyun.svideosdk.AlivcSdkCore;
import com.aliyun.svideosdk.common.AliyunRecordVideoSource;
import com.aliyun.svideosdk.common.struct.common.AliyunBorderParam;
import com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam;
import com.aliyun.svideosdk.multirecorder.AliyunICameraCapture;
import com.aliyun.svideosdk.multirecorder.AliyunIVideoCapture;
import com.aliyun.svideosdk.multirecorder.AliyunIViewCapture;
import com.aliyun.svideosdk.recorder.NativeRecorder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g implements d, AliyunIVideoCapture, e.c, com.aliyun.svideosdk.multirecorder.impl.c.c.b {
    private com.aliyun.svideosdk.multirecorder.impl.c.b d;
    private com.aliyun.svideosdk.multirecorder.impl.c.c f;
    private Context g;
    private NativeRecorder h;
    private com.aliyun.common.c.b.e i;
    private c k;
    private com.aliyun.svideosdk.multirecorder.impl.b l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f25801a = false;
    private volatile boolean b = false;
    private boolean e = false;
    private com.aliyun.svideosdk.a.f.a j = com.aliyun.svideosdk.a.f.a.CAMERA1;
    private Integer m = null;
    private Integer n = null;
    private Integer o = null;
    private Map<Integer, e> c = new ConcurrentHashMap();

    public class a implements e.b<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f25802a;

        public a(e eVar) {
            this.f25802a = eVar;
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.b
        public void a(Object obj) {
            if (obj != null) {
                if (this.f25802a.e() != e.a.BITMAP) {
                    g.this.h.addVideoBuffer(this.f25802a.b(), ((Integer) obj).intValue());
                    return;
                }
                com.aliyun.common.d.a aVar = (com.aliyun.common.d.a) obj;
                g.this.h.addVideoBufferBitmap(this.f25802a.b(), aVar.d());
                aVar.c();
            }
        }
    }

    public class b implements com.aliyun.svideosdk.multirecorder.impl.c.b.e {
        public b() {
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.b.e
        public void a(int i) {
            if (g.this.k != null) {
                g.this.k.a(i);
            }
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.b.e
        public void a(int i, float f, float f2, float f3, float f4) {
            g.this.d.b().getStickerManager().updateStickerPosition(i, f, f2, f3, f4);
        }

        @Override // com.aliyun.svideosdk.multirecorder.impl.c.b.e
        public void onInitReady() {
            if (g.this.k != null) {
                g.this.k.onInitReady();
            }
        }
    }

    public interface c {
        void a();

        void a(int i);

        void onInitReady();
    }

    public g(Context context, NativeRecorder nativeRecorder, com.aliyun.svideosdk.multirecorder.impl.b bVar, com.aliyun.common.c.b.e eVar) {
        this.g = context;
        this.h = nativeRecorder;
        this.l = bVar;
        this.i = eVar;
    }

    private void b(e eVar, AliyunLayoutParam aliyunLayoutParam) {
        AliyunRecordVideoSource aliyunRecordVideoSourceCreateVideoWithInfo = AliyunRecordVideoSource.createVideoWithInfo(1, 1);
        aliyunRecordVideoSourceCreateVideoWithInfo.setLayoutInfo(new AliyunRecordVideoSource.LayoutInfo(aliyunLayoutParam.getWidthRatio(), aliyunLayoutParam.getHeightRatio(), aliyunLayoutParam.getCenterX(), aliyunLayoutParam.getCenterY(), 0, aliyunLayoutParam.getDisplayMode().ordinal(), eVar.c(), eVar.d()));
        aliyunRecordVideoSourceCreateVideoWithInfo.setVideoNeedOutput(true);
        aliyunRecordVideoSourceCreateVideoWithInfo.setVideoNeedRender(eVar.h());
        this.h.addSource(aliyunRecordVideoSourceCreateVideoWithInfo);
        eVar.a(aliyunRecordVideoSourceCreateVideoWithInfo, aliyunLayoutParam, this.l);
        eVar.a(this);
    }

    private void i() {
        if (l() && !this.f25801a) {
            throw new RuntimeException("You have to call prepare() before startPreview() or startRecording()");
        }
        if (this.f25801a) {
            return;
        }
        prepare();
    }

    private void j() {
        System.currentTimeMillis();
        boolean z = !this.b;
        ArrayList<e> arrayList = new ArrayList();
        for (e eVar : this.c.values()) {
            if (!z || eVar.h()) {
                arrayList.add(eVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        for (e eVar2 : arrayList) {
            eVar2.a(new a(eVar2));
        }
    }

    private boolean k() {
        Collection<e> collectionValues = this.c.values();
        if (collectionValues.isEmpty()) {
            return true;
        }
        Iterator<e> it = collectionValues.iterator();
        while (it.hasNext()) {
            if (!it.next().a()) {
                return false;
            }
        }
        return true;
    }

    private boolean l() {
        return AlivcSdkCore.AlivcLogLevel.AlivcLogClose != AlivcSdkCore.getLogLevel() && AlivcSdkCore.AlivcLogLevel.AlivcLogDebug.getValue() >= AlivcSdkCore.getLogLevel().getValue();
    }

    private void m() {
        Integer num = this.m;
        if (num != null) {
            a(num.intValue());
            this.m = null;
        }
        Integer num2 = this.n;
        if (num2 == null || this.o == null) {
            return;
        }
        a(num2.intValue(), this.o.intValue());
        this.n = null;
        this.o = null;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(int i) {
        if (!this.f25801a) {
            this.m = Integer.valueOf(i);
            return;
        }
        Iterator<e> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().a(i);
        }
        com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(int i, int i2) {
        if (!this.f25801a) {
            this.n = Integer.valueOf(i);
            this.o = Integer.valueOf(i2);
        } else {
            Iterator<e> it = this.c.values().iterator();
            while (it.hasNext()) {
                it.next().a(i, i2);
            }
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void a(e eVar) {
        if (eVar.f()) {
            g();
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void a(e eVar, AliyunBorderParam aliyunBorderParam, int i, int i2) {
        float cornerRadius = aliyunBorderParam.getCornerRadius();
        if (cornerRadius < 0.0f) {
            cornerRadius = (aliyunBorderParam.getCorner() * 1.0f) / i;
        }
        eVar.b().setPureColorBorder((aliyunBorderParam.getBorderWidth() * 1.0f) / i, aliyunBorderParam.getBorderColor(), cornerRadius);
        this.h.updateSource(eVar.b());
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void a(e eVar, AliyunLayoutParam aliyunLayoutParam) {
        eVar.b().setLayoutInfo(new AliyunRecordVideoSource.LayoutInfo(aliyunLayoutParam.getWidthRatio(), aliyunLayoutParam.getHeightRatio(), aliyunLayoutParam.getCenterX(), aliyunLayoutParam.getCenterY(), 0, aliyunLayoutParam.getDisplayMode().ordinal(), eVar.c(), eVar.d()));
        this.h.updateSource(eVar.b());
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void a(e eVar, boolean z) {
        eVar.b().setMirrorInfo(z ? 1 : 0);
        this.h.updateSource(eVar.b());
    }

    public void a(c cVar) {
        this.k = cVar;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void a(boolean z) {
        this.b = false;
        com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
        if (cVar != null && !this.e) {
            cVar.d();
        }
        Iterator<e> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().a(z);
        }
    }

    public boolean a() {
        return k();
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoCapture
    public AliyunICameraCapture addCameraCapture(AliyunLayoutParam aliyunLayoutParam) {
        if (this.f25801a) {
            throw new RuntimeException("Have to call addCameraCapture() before AliyunIVideoRecorder#prepare() called");
        }
        if (this.d != null) {
            throw new RuntimeException("You can only add one camera capture");
        }
        com.aliyun.svideosdk.multirecorder.impl.c.b bVar = new com.aliyun.svideosdk.multirecorder.impl.c.b(this.g, this.j, this.h, this.i);
        this.d = bVar;
        b(bVar, aliyunLayoutParam);
        this.d.a(new b());
        this.c.put(Integer.valueOf(this.d.n()), this.d);
        return this.d;
    }

    @Override // com.aliyun.svideosdk.multirecorder.AliyunIVideoCapture
    public AliyunIViewCapture addViewCapture(AliyunLayoutParam aliyunLayoutParam, View view) {
        if (this.f25801a) {
            throw new RuntimeException("Have to call addViewCapture() before AliyunIVideoRecorder#prepare() called");
        }
        h hVar = new h();
        hVar.a(this.n.intValue(), this.o.intValue());
        hVar.setCaptureView(view);
        b(hVar, aliyunLayoutParam);
        this.c.put(Integer.valueOf(hVar.n()), hVar);
        return hVar;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void b(e eVar) {
        c cVar;
        if (!k() || (cVar = this.k) == null) {
            return;
        }
        cVar.a();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.e.c
    public void c(e eVar) {
        eVar.b().setPureColorBorder(0.0f, 0, 0.0f);
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void destroy() {
        com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
        this.d = null;
        for (e eVar : this.c.values()) {
            eVar.destroy();
            this.h.removeSource(eVar.b());
            eVar.b().release();
        }
        this.c.clear();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.c.b
    public void g() {
        j();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void prepare() {
        c cVar;
        if (this.f25801a) {
            return;
        }
        if (this.c.isEmpty()) {
            throw new RuntimeException("You have to add at least one video capture");
        }
        boolean z = true;
        for (e eVar : this.c.values()) {
            eVar.prepare();
            if (eVar.f()) {
                if (!z) {
                    throw new RuntimeException("You have to set only one main capture");
                }
                z = false;
            }
        }
        if (z) {
            this.f = new com.aliyun.svideosdk.multirecorder.impl.c.c(this);
        }
        if (this.d == null && (cVar = this.k) != null) {
            cVar.onInitReady();
        }
        this.f25801a = true;
        m();
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startPreview() {
        i();
        int iStartPreview = 0;
        boolean z = false;
        for (e eVar : this.c.values()) {
            if (eVar.h()) {
                z = true;
            }
            iStartPreview = eVar.startPreview();
            if (iStartPreview != 0) {
                break;
            }
        }
        if (!z) {
            return iStartPreview;
        }
        if (iStartPreview == 0) {
            com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
            if (cVar != null) {
                this.e = true;
                cVar.a(false);
            }
        } else {
            stopPreview();
        }
        return iStartPreview;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public int startRecording() {
        i();
        this.b = true;
        Iterator<e> it = this.c.values().iterator();
        int iStartRecording = 0;
        while (it.hasNext() && (iStartRecording = it.next().startRecording()) == 0) {
        }
        if (iStartRecording == 0) {
            com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
            if (cVar != null && !this.e) {
                cVar.a(false);
            }
        } else {
            a(true);
        }
        return iStartRecording;
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.d
    public void stopPreview() {
        com.aliyun.svideosdk.multirecorder.impl.c.c cVar = this.f;
        if (cVar != null) {
            this.e = false;
            cVar.d();
        }
        Iterator<e> it = this.c.values().iterator();
        while (it.hasNext()) {
            it.next().stopPreview();
        }
    }
}
