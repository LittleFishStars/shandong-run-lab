package com.ipd.dsp.internal.components.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ParcelFileDescriptorRewinder implements com.ipd.dsp.internal.components.glide.load.data.a<ParcelFileDescriptor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InternalRewinder f38257a;

    public static final class InternalRewinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ParcelFileDescriptor f38258a;

        public InternalRewinder(ParcelFileDescriptor parcelFileDescriptor) {
            this.f38258a = parcelFileDescriptor;
        }

        public ParcelFileDescriptor rewind() throws IOException {
            try {
                Os.lseek(this.f38258a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.f38258a;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    public static final class a implements com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<ParcelFileDescriptor> {
        @Override // com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a
        @NonNull
        public com.ipd.dsp.internal.components.glide.load.data.a<ParcelFileDescriptor> a(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
            return new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a
        @NonNull
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor parcelFileDescriptor) {
        this.f38257a = new InternalRewinder(parcelFileDescriptor);
    }

    public static boolean a() {
        return !"robolectric".equals(Build.FINGERPRINT);
    }

    @Override // com.ipd.dsp.internal.components.glide.load.data.a
    public void b() {
    }

    @Override // com.ipd.dsp.internal.components.glide.load.data.a
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor c() throws IOException {
        return this.f38257a.rewind();
    }
}
