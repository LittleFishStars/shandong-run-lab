package cj.mobile.wm;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p4<A> implements v4<A, q4> {
    public final v4<A, InputStream> dexa;
    public final v4<A, ParcelFileDescriptor> dexb;

    public static class dexa implements y2<q4> {
        public final y2<InputStream> dexa;
        public final y2<ParcelFileDescriptor> dexb;

        public dexa(y2<InputStream> y2Var, y2<ParcelFileDescriptor> y2Var2) {
            this.dexa = y2Var;
            this.dexb = y2Var2;
        }

        @Override // cj.mobile.wm.y2
        public void a() {
            y2<InputStream> y2Var = this.dexa;
            if (y2Var != null) {
                y2Var.a();
            }
            y2<ParcelFileDescriptor> y2Var2 = this.dexb;
            if (y2Var2 != null) {
                y2Var2.a();
            }
        }

        @Override // cj.mobile.wm.y2
        public void b() {
            y2<InputStream> y2Var = this.dexa;
            if (y2Var != null) {
                y2Var.b();
            }
            y2<ParcelFileDescriptor> y2Var2 = this.dexb;
            if (y2Var2 != null) {
                y2Var2.b();
            }
        }

        @Override // cj.mobile.wm.y2
        /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
        public q4 dexa(com.wangmai.insightvision.openadsdk.image.b.i iVar) throws Exception {
            InputStream inputStreamDexa;
            y2<InputStream> y2Var = this.dexa;
            ParcelFileDescriptor parcelFileDescriptorDexa = null;
            if (y2Var != null) {
                try {
                    inputStreamDexa = y2Var.dexa(iVar);
                } catch (Exception e) {
                    if (Log.isLoggable("IVML", 2)) {
                        Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", e);
                    }
                    if (this.dexb == null) {
                        throw e;
                    }
                    inputStreamDexa = null;
                }
            } else {
                inputStreamDexa = null;
            }
            y2<ParcelFileDescriptor> y2Var2 = this.dexb;
            if (y2Var2 != null) {
                try {
                    parcelFileDescriptorDexa = y2Var2.dexa(iVar);
                } catch (Exception e2) {
                    if (Log.isLoggable("IVML", 2)) {
                        Log.v("IVML", "Exception fetching ParcelFileDescriptor", e2);
                    }
                    if (inputStreamDexa == null) {
                        throw e2;
                    }
                }
            }
            return new q4(inputStreamDexa, parcelFileDescriptorDexa);
        }

        @Override // cj.mobile.wm.y2
        public String getId() {
            y2<InputStream> y2Var = this.dexa;
            return y2Var != null ? y2Var.getId() : this.dexb.getId();
        }
    }

    public p4(v4<A, InputStream> v4Var, v4<A, ParcelFileDescriptor> v4Var2) {
        if (v4Var == null && v4Var2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.dexa = v4Var;
        this.dexb = v4Var2;
    }

    @Override // cj.mobile.wm.v4
    public y2<q4> dexa(A a2, int i, int i2) {
        v4<A, InputStream> v4Var = this.dexa;
        y2<InputStream> y2VarDexa = v4Var != null ? v4Var.dexa(a2, i, i2) : null;
        v4<A, ParcelFileDescriptor> v4Var2 = this.dexb;
        y2<ParcelFileDescriptor> y2VarDexa2 = v4Var2 != null ? v4Var2.dexa(a2, i, i2) : null;
        if (y2VarDexa == null && y2VarDexa2 == null) {
            return null;
        }
        return new dexa(y2VarDexa, y2VarDexa2);
    }
}
