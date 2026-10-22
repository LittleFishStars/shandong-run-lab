package com.google.android.exoplayer2.upstream;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Deprecated
public final class d implements DataSource.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f31143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DataSource.Factory f5202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final TransferListener f5203a;

    public d(Context context) {
        this(context, (String) null, (TransferListener) null);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c a() {
        c cVar = new c(this.f31143a, this.f5202a.a());
        TransferListener transferListener = this.f5203a;
        if (transferListener != null) {
            cVar.b(transferListener);
        }
        return cVar;
    }

    public d(Context context, @Nullable String str) {
        this(context, str, (TransferListener) null);
    }

    public d(Context context, @Nullable String str, @Nullable TransferListener transferListener) {
        this(context, transferListener, new e.b().l(str));
    }

    public d(Context context, DataSource.Factory factory) {
        this(context, (TransferListener) null, factory);
    }

    public d(Context context, @Nullable TransferListener transferListener, DataSource.Factory factory) {
        this.f31143a = context.getApplicationContext();
        this.f5203a = transferListener;
        this.f5202a = factory;
    }
}
