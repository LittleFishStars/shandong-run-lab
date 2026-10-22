package androidx.camera.core;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.alibaba.android.arouter.utils.Consts;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
final class ImageProxyDownsampler {

    /* JADX INFO: renamed from: androidx.camera.core.ImageProxyDownsampler$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod;

        static {
            int[] iArr = new int[DownsamplingMethod.values().length];
            $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod = iArr;
            try {
                iArr[DownsamplingMethod.NEAREST_NEIGHBOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod[DownsamplingMethod.AVERAGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum DownsamplingMethod {
        NEAREST_NEIGHBOR,
        AVERAGING
    }

    public static final class ForwardingImageProxyImpl extends ForwardingImageProxy {
        private final int mDownsampledHeight;
        private final ImageProxy.PlaneProxy[] mDownsampledPlanes;
        private final int mDownsampledWidth;

        public ForwardingImageProxyImpl(ImageProxy imageProxy, ImageProxy.PlaneProxy[] planeProxyArr, int i, int i2) {
            super(imageProxy);
            this.mDownsampledPlanes = planeProxyArr;
            this.mDownsampledWidth = i;
            this.mDownsampledHeight = i2;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getHeight() {
            return this.mDownsampledHeight;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        @NonNull
        public ImageProxy.PlaneProxy[] getPlanes() {
            return this.mDownsampledPlanes;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getWidth() {
            return this.mDownsampledWidth;
        }
    }

    private ImageProxyDownsampler() {
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(int i, int i2, byte[] bArr) {
        return new ImageProxy.PlaneProxy(bArr, i, i2) { // from class: androidx.camera.core.ImageProxyDownsampler.1
            final ByteBuffer mBuffer;
            final /* synthetic */ byte[] val$data;
            final /* synthetic */ int val$pixelStride;
            final /* synthetic */ int val$rowStride;

            {
                this.val$data = bArr;
                this.val$rowStride = i;
                this.val$pixelStride = i2;
                this.mBuffer = ByteBuffer.wrap(bArr);
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            @NonNull
            public ByteBuffer getBuffer() {
                return this.mBuffer;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getPixelStride() {
                return this.val$pixelStride;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getRowStride() {
                return this.val$rowStride;
            }
        };
    }

    public static ForwardingImageProxy downsample(ImageProxy imageProxy, int i, int i2, DownsamplingMethod downsamplingMethod) {
        byte[] bArr;
        if (imageProxy.getFormat() != 35) {
            throw new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
        }
        if (imageProxy.getWidth() < i || imageProxy.getHeight() < i2) {
            throw new IllegalArgumentException("Downsampled dimension " + new Size(i, i2) + " is not <= original dimension " + new Size(imageProxy.getWidth(), imageProxy.getHeight()) + Consts.DOT);
        }
        if (imageProxy.getWidth() == i && imageProxy.getHeight() == i2) {
            return new ForwardingImageProxyImpl(imageProxy, imageProxy.getPlanes(), i, i2);
        }
        int[] iArr = {imageProxy.getWidth(), imageProxy.getWidth() / 2, imageProxy.getWidth() / 2};
        int[] iArr2 = {imageProxy.getHeight(), imageProxy.getHeight() / 2, imageProxy.getHeight() / 2};
        int i3 = i / 2;
        int[] iArr3 = {i, i3, i3};
        int i4 = i2 / 2;
        int[] iArr4 = {i2, i4, i4};
        ImageProxy.PlaneProxy[] planeProxyArr = new ImageProxy.PlaneProxy[3];
        for (int i5 = 0; i5 < 3; i5++) {
            ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[i5];
            ByteBuffer buffer = planeProxy.getBuffer();
            byte[] bArr2 = new byte[iArr3[i5] * iArr4[i5]];
            int i6 = AnonymousClass2.$SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod[downsamplingMethod.ordinal()];
            if (i6 == 1) {
                bArr = bArr2;
                resizeNearestNeighbor(buffer, iArr[i5], planeProxy.getPixelStride(), planeProxy.getRowStride(), iArr2[i5], bArr, iArr3[i5], iArr4[i5]);
            } else if (i6 != 2) {
                bArr = bArr2;
            } else {
                bArr = bArr2;
                resizeAveraging(buffer, iArr[i5], planeProxy.getPixelStride(), planeProxy.getRowStride(), iArr2[i5], bArr, iArr3[i5], iArr4[i5]);
            }
            planeProxyArr[i5] = createPlaneProxy(iArr3[i5], 1, bArr);
        }
        return new ForwardingImageProxyImpl(imageProxy, planeProxyArr, i, i2);
    }

    private static void resizeAveraging(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        float f = i / i5;
        float f2 = i4 / i6;
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = new byte[i3];
        int[] iArr = new int[i5];
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            iArr[i8] = ((int) (i8 * f)) * i2;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            int i9 = 0;
            while (i9 < i6) {
                int i10 = (int) (i9 * f2);
                int i11 = i4 - 1;
                int iMin = Math.min(i10, i11) * i3;
                int iMin2 = Math.min(i10 + 1, i11) * i3;
                int i12 = i9 * i5;
                byteBuffer.position(iMin);
                byteBuffer.get(bArr2, i7, Math.min(i3, byteBuffer.remaining()));
                byteBuffer.position(iMin2);
                byteBuffer.get(bArr3, i7, Math.min(i3, byteBuffer.remaining()));
                for (int i13 = i7; i13 < i5; i13++) {
                    int i14 = iArr[i13];
                    bArr[i12 + i13] = (byte) ((((((bArr2[i14] & 255) + (bArr2[i14 + i2] & 255)) + (bArr3[i14] & 255)) + (bArr3[i14 + i2] & 255)) / 4) & 255);
                }
                i9++;
                i7 = 0;
            }
        }
    }

    private static void resizeNearestNeighbor(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        float f = i / i5;
        float f2 = i4 / i6;
        byte[] bArr2 = new byte[i3];
        int[] iArr = new int[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            iArr[i7] = ((int) (i7 * f)) * i2;
        }
        synchronized (byteBuffer) {
            byteBuffer.rewind();
            for (int i8 = 0; i8 < i6; i8++) {
                int i9 = i8 * i5;
                byteBuffer.position(Math.min((int) (i8 * f2), i4 - 1) * i3);
                byteBuffer.get(bArr2, 0, Math.min(i3, byteBuffer.remaining()));
                for (int i10 = 0; i10 < i5; i10++) {
                    bArr[i9 + i10] = bArr2[iArr[i10]];
                }
            }
        }
    }
}
