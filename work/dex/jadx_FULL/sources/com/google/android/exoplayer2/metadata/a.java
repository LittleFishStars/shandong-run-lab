package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.xn5;
import com.zj.adlib.yk3;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a extends BaseRenderer implements Handler.Callback {
    public static final int N = 0;
    public static final String f = "MetadataRenderer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Handler f30776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Metadata f3469a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MetadataDecoder f3470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MetadataDecoderFactory f3471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MetadataOutput f3472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xn5 f3473a;
    public boolean c;
    public long d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3474d;
    public long e;

    public a(MetadataOutput metadataOutput, @Nullable Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.f30775a);
    }

    @Override // com.google.android.exoplayer2.RendererCapabilities
    public int e(d dVar) {
        if (this.f3471a.a(dVar)) {
            return RendererCapabilities.create(dVar.a0 == 0 ? 4 : 2);
        }
        return RendererCapabilities.create(0);
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        m((Metadata) message.obj);
        return true;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.f3474d;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    public final void k(Metadata metadata, List<Metadata.Entry> list) {
        for (int i = 0; i < metadata.length(); i++) {
            d wrappedMetadataFormat = metadata.get(i).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.f3471a.a(wrappedMetadataFormat)) {
                list.add(metadata.get(i));
            } else {
                MetadataDecoder metadataDecoderB = this.f3471a.b(wrappedMetadataFormat);
                byte[] bArr = (byte[]) sb0.g(metadata.get(i).getWrappedMetadataBytes());
                this.f3473a.b();
                this.f3473a.k(bArr.length);
                ((ByteBuffer) gj9.k(((DecoderInputBuffer) this.f3473a).f2588a)).put(bArr);
                this.f3473a.l();
                Metadata metadataA = metadataDecoderB.a(this.f3473a);
                if (metadataA != null) {
                    k(metadataA, list);
                }
            }
        }
    }

    public final void l(Metadata metadata) {
        Handler handler = this.f30776a;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            m(metadata);
        }
    }

    public final void m(Metadata metadata) {
        this.f3472a.b(metadata);
    }

    public final boolean n(long j) {
        boolean z;
        Metadata metadata = this.f3469a;
        if (metadata == null || this.e > j) {
            z = false;
        } else {
            l(metadata);
            this.f3469a = null;
            this.e = -9223372036854775807L;
            z = true;
        }
        if (this.c && this.f3469a == null) {
            this.f3474d = true;
        }
        return z;
    }

    public final void o() {
        if (this.c || this.f3469a != null) {
            return;
        }
        this.f3473a.b();
        yk3 formatHolder = getFormatHolder();
        int source = readSource(formatHolder, this.f3473a, 0);
        if (source != -4) {
            if (source == -5) {
                this.d = ((d) sb0.g(formatHolder.f46052a)).f2565a;
                return;
            }
            return;
        }
        if (this.f3473a.f()) {
            this.c = true;
            return;
        }
        xn5 xn5Var = this.f3473a;
        xn5Var.b = this.d;
        xn5Var.l();
        Metadata metadataA = ((MetadataDecoder) gj9.k(this.f3470a)).a(this.f3473a);
        if (metadataA != null) {
            ArrayList arrayList = new ArrayList(metadataA.length());
            k(metadataA, arrayList);
            if (arrayList.isEmpty()) {
                return;
            }
            this.f3469a = new Metadata(arrayList);
            this.e = ((DecoderInputBuffer) this.f3473a).f30576a;
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.f3469a = null;
        this.e = -9223372036854775807L;
        this.f3470a = null;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) {
        this.f3469a = null;
        this.e = -9223372036854775807L;
        this.c = false;
        this.f3474d = false;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(d[] dVarArr, long j, long j2) {
        this.f3470a = this.f3471a.b(dVarArr[0]);
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) {
        boolean zN = true;
        while (zN) {
            o();
            zN = n(j);
        }
    }

    public a(MetadataOutput metadataOutput, @Nullable Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        super(5);
        this.f3472a = (MetadataOutput) sb0.g(metadataOutput);
        this.f30776a = looper == null ? null : gj9.x(looper, this);
        this.f3471a = (MetadataDecoderFactory) sb0.g(metadataDecoderFactory);
        this.f3473a = new xn5();
        this.e = -9223372036854775807L;
    }
}
