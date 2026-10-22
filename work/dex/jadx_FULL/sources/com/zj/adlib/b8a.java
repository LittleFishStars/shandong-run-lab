package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import com.alibaba.ariver.remotedebug.b.c;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002R\u001c\u0010\u000e\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\rR\u001c\u0010\u0011\u001a\n \f*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/zj/adlib/b8a;", "", "Landroid/media/Image;", "image", "Landroid/graphics/Bitmap;", c.g, "", "b", "Ljava/nio/ByteBuffer;", "outputBuffer", "a", "Landroid/renderscript/RenderScript;", "kotlin.jvm.PlatformType", "Landroid/renderscript/RenderScript;", "rs", "Landroid/renderscript/ScriptIntrinsicYuvToRGB;", "Landroid/renderscript/ScriptIntrinsicYuvToRGB;", "scriptYuvToRgb", "", "I", "pixelCount", "Ljava/nio/ByteBuffer;", "yuvBuffer", "Landroid/renderscript/Allocation;", "Landroid/renderscript/Allocation;", "inputAllocation", "outputAllocation", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final class b8a {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int pixelCount;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public Allocation inputAllocation;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final RenderScript rs;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final ScriptIntrinsicYuvToRGB scriptYuvToRgb;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public ByteBuffer yuvBuffer;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public Allocation outputAllocation;

    public b8a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RenderScript renderScriptCreate = RenderScript.create(context);
        this.rs = renderScriptCreate;
        this.scriptYuvToRgb = ScriptIntrinsicYuvToRGB.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        this.pixelCount = -1;
    }

    public final void a(Image image, ByteBuffer outputBuffer) {
        int i;
        int i2;
        int i3;
        image.getFormat();
        Rect cropRect = image.getCropRect();
        Image.Plane[] planes = image.getPlanes();
        Intrinsics.checkNotNullExpressionValue(planes, "imagePlanes");
        byte[] bArr = new byte[((Image.Plane) ArraysKt.first(planes)).getRowStride()];
        int length = planes.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            Image.Plane plane = planes[i4];
            int i6 = i5 + 1;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        planes = planes;
                    } else {
                        i2 = this.pixelCount;
                    }
                    i4++;
                    i5 = i6;
                    planes = planes;
                } else {
                    i2 = this.pixelCount + 1;
                }
                i = 2;
            } else {
                i = 1;
                i2 = 0;
            }
            ByteBuffer buffer = plane.getBuffer();
            int rowStride = plane.getRowStride();
            int pixelStride = plane.getPixelStride();
            Rect rect = i5 == 0 ? cropRect : new Rect(cropRect.left / 2, cropRect.top / 2, cropRect.right / 2, cropRect.bottom / 2);
            int iWidth = rect.width();
            int iHeight = rect.height();
            buffer.position((rect.top * rowStride) + (rect.left * pixelStride));
            for (int i7 = 0; i7 < iHeight; i7++) {
                if (pixelStride == 1 && i == 1) {
                    buffer.get(outputBuffer.array(), i2, iWidth);
                    i2 += iWidth;
                    i3 = iWidth;
                } else {
                    i3 = ((iWidth - 1) * pixelStride) + 1;
                    buffer.get(bArr, 0, i3);
                    for (int i8 = 0; i8 < iWidth; i8++) {
                        outputBuffer.array()[i2] = bArr[i8 * pixelStride];
                        i2 += i;
                    }
                }
                if (i7 < iHeight - 1) {
                    buffer.position((buffer.position() + rowStride) - i3);
                }
            }
            i4++;
            i5 = i6;
            planes = planes;
        }
    }

    public final synchronized void b(@NotNull Image image, @NotNull Bitmap output) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(output, c.g);
        if (this.yuvBuffer == null) {
            int iWidth = image.getCropRect().width() * image.getCropRect().height();
            this.pixelCount = iWidth;
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((iWidth * ImageFormat.getBitsPerPixel(35)) / 8);
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocateDirect, "allocateDirect(\n        …eFormat.YUV_420_888) / 8)");
            this.yuvBuffer = byteBufferAllocateDirect;
        }
        ByteBuffer byteBuffer = this.yuvBuffer;
        Allocation allocation = null;
        if (byteBuffer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yuvBuffer");
            byteBuffer = null;
        }
        a(image, byteBuffer);
        if (this.inputAllocation == null) {
            RenderScript renderScript = this.rs;
            Element elementU8 = Element.U8(renderScript);
            ByteBuffer byteBuffer2 = this.yuvBuffer;
            if (byteBuffer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yuvBuffer");
                byteBuffer2 = null;
            }
            Allocation allocationCreateSized = Allocation.createSized(renderScript, elementU8, byteBuffer2.array().length);
            Intrinsics.checkNotNullExpressionValue(allocationCreateSized, "createSized(rs, Element.…, yuvBuffer.array().size)");
            this.inputAllocation = allocationCreateSized;
        }
        if (this.outputAllocation == null) {
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(this.rs, output);
            Intrinsics.checkNotNullExpressionValue(allocationCreateFromBitmap, "createFromBitmap(rs, output)");
            this.outputAllocation = allocationCreateFromBitmap;
        }
        Allocation allocation2 = this.inputAllocation;
        if (allocation2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputAllocation");
            allocation2 = null;
        }
        ByteBuffer byteBuffer3 = this.yuvBuffer;
        if (byteBuffer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yuvBuffer");
            byteBuffer3 = null;
        }
        allocation2.copyFrom(byteBuffer3.array());
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = this.scriptYuvToRgb;
        Allocation allocation3 = this.inputAllocation;
        if (allocation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputAllocation");
            allocation3 = null;
        }
        scriptIntrinsicYuvToRGB.setInput(allocation3);
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB2 = this.scriptYuvToRgb;
        Allocation allocation4 = this.outputAllocation;
        if (allocation4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputAllocation");
            allocation4 = null;
        }
        scriptIntrinsicYuvToRGB2.forEach(allocation4);
        Allocation allocation5 = this.outputAllocation;
        if (allocation5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputAllocation");
        } else {
            allocation = allocation5;
        }
        allocation.copyTo(output);
    }
}
