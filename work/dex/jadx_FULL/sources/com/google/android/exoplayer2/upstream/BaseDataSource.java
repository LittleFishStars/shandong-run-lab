package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class BaseDataSource implements DataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DataSpec f5018a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<TransferListener> f5019a = new ArrayList<>(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5020a;

    public BaseDataSource(boolean z) {
        this.f5020a = z;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void b(TransferListener transferListener) {
        sb0.g(transferListener);
        if (this.f5019a.contains(transferListener)) {
            return;
        }
        this.f5019a.add(transferListener);
        this.f31103a++;
    }

    public final void bytesTransferred(int i) {
        DataSpec dataSpec = (DataSpec) gj9.k(this.f5018a);
        for (int i2 = 0; i2 < this.f31103a; i2++) {
            this.f5019a.get(i2).a(this, dataSpec, this.f5020a, i);
        }
    }

    public final void transferEnded() {
        DataSpec dataSpec = (DataSpec) gj9.k(this.f5018a);
        for (int i = 0; i < this.f31103a; i++) {
            this.f5019a.get(i).g(this, dataSpec, this.f5020a);
        }
        this.f5018a = null;
    }

    public final void transferInitializing(DataSpec dataSpec) {
        for (int i = 0; i < this.f31103a; i++) {
            this.f5019a.get(i).d(this, dataSpec, this.f5020a);
        }
    }

    public final void transferStarted(DataSpec dataSpec) {
        this.f5018a = dataSpec;
        for (int i = 0; i < this.f31103a; i++) {
            this.f5019a.get(i).e(this, dataSpec, this.f5020a);
        }
    }
}
