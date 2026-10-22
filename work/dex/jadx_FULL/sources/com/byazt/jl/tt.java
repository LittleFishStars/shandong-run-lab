package com.byazt.jl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 157, 13})
public class tt extends i<com.byazt.on.c, com.byazt.on.tt> {
    public final c da;
    public final Paint i;
    public com.byazt.on.tt sp;
    public int x;

    @com.byazt.zqa.c(c = {0, 1, 157, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c {
        public byte c;
        public Rect tt;
        public ByteBuffer ve;

        private c() {
            this.tt = new Rect();
        }
    }

    public tt(com.byazt.zt.tt ttVar, i.c cVar) {
        super(ttVar, cVar);
        Paint paint = new Paint();
        this.i = paint;
        this.da = new c();
        paint.setAntiAlias(true);
    }

    @Override // com.byazt.jl.i
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.byazt.on.tt uj() {
        if (this.sp == null) {
            this.sp = new com.byazt.on.tt();
        }
        return this.sp;
    }

    @Override // com.byazt.jl.i
    public int tt() {
        return this.x;
    }

    @Override // com.byazt.jl.i
    public void ve() {
        this.da.ve = null;
        this.sp = null;
    }

    @Override // com.byazt.jl.i
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.byazt.on.c ve(com.byazt.on.a aVar) {
        return new com.byazt.on.c(aVar);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.byazt.jl.i
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Rect tt(com.byazt.on.c cVar) throws IOException {
        List<n> listC = uj.c(cVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        ve veVar = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        for (n nVar : listC) {
            if (nVar instanceof com.byazt.jl.c) {
                this.x = ((com.byazt.jl.c) nVar).ve;
                z = true;
            } else if (nVar instanceof a) {
                veVar = new ve(cVar, (a) nVar);
                veVar.n = arrayList;
                veVar.ve = bArr;
                this.c.add(veVar);
            } else if (nVar instanceof sp) {
                if (veVar != null) {
                    veVar.uj.add(nVar);
                }
            } else if (nVar instanceof da) {
                if (!z) {
                    u uVar = new u(cVar);
                    uVar.x = i;
                    uVar.i = i2;
                    this.c.add(uVar);
                    this.x = 1;
                    break;
                }
                if (veVar != null) {
                    veVar.uj.add(nVar);
                }
            } else if (nVar instanceof t) {
                t tVar = (t) nVar;
                i = tVar.tt;
                i2 = tVar.ve;
                bArr = tVar.x;
            } else if (!(nVar instanceof sl)) {
                arrayList.add(nVar);
            }
        }
        int i3 = i * i2;
        int i4 = this.ve;
        this.n = ByteBuffer.allocate(((i3 / (i4 * i4)) + 1) * 4);
        c cVar2 = this.da;
        int i5 = this.ve;
        cVar2.ve = ByteBuffer.allocate(((i3 / (i5 * i5)) + 1) * 4);
        return new Rect(0, 0, i, i2);
    }

    @Override // com.byazt.jl.i
    public void c(x<com.byazt.on.c, com.byazt.on.tt> xVar) {
        if (xVar == null || this.f28698a == null) {
            return;
        }
        try {
            Bitmap bitmapC = c(this.f28698a.width() / this.ve, this.f28698a.height() / this.ve);
            Canvas canvas = this.uj.get(bitmapC);
            if (canvas == null) {
                canvas = new Canvas(bitmapC);
                this.uj.put(bitmapC, canvas);
            }
            Canvas canvas2 = canvas;
            if (xVar instanceof ve) {
                this.n.rewind();
                bitmapC.copyPixelsFromBuffer(this.n);
                if (this.tt == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.da.tt);
                    c cVar = this.da;
                    byte b = cVar.c;
                    if (b == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b == 2) {
                        cVar.ve.rewind();
                        bitmapC.copyPixelsFromBuffer(this.da.ve);
                    }
                    canvas2.restore();
                }
                if (((ve) xVar).tt == 2) {
                    c cVar2 = this.da;
                    if (cVar2.c != 2) {
                        cVar2.ve.rewind();
                        bitmapC.copyPixelsToBuffer(this.da.ve);
                    }
                }
                this.da.c = ((ve) xVar).tt;
                canvas2.save();
                if (((ve) xVar).c == 0) {
                    int i = xVar.da;
                    int i2 = this.ve;
                    int i3 = xVar.sl;
                    canvas2.clipRect(i / i2, i3 / i2, (i + xVar.x) / i2, (i3 + xVar.i) / i2);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                Rect rect = this.da.tt;
                int i4 = xVar.da;
                int i5 = this.ve;
                int i6 = xVar.sl;
                rect.set(i4 / i5, i6 / i5, (i4 + xVar.x) / i5, (i6 + xVar.i) / i5);
                canvas2.restore();
            }
            Bitmap bitmapC2 = c(xVar.x, xVar.i);
            c(xVar.c(canvas2, this.i, this.ve, bitmapC2, uj()));
            c(bitmapC2);
            this.n.rewind();
            bitmapC.copyPixelsToBuffer(this.n);
            c(bitmapC);
        } catch (Exception e) {
            m.c(e);
        }
    }
}
