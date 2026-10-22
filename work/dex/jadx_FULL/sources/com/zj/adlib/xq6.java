package com.zj.adlib;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.resource.gif.GifBitmapProvider;
import com.bumptech.glide.util.ByteBufferUtil;
import com.huachenjie.common.util.media_picker.MediaPickerConstants;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J,\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00132\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/zj/adlib/xq6;", "", "Landroid/content/Context;", "context", "Ljava/io/File;", "sourceFile", "Lcom/zj/adlib/u64;", "compressConfig", "", "a", "", "maxWidth", "b", "Lcom/bumptech/glide/gifdecoder/GifHeader;", "header", "", "f", "srcWidth", "srcHeight", "Lkotlin/Pair;", "d", "Lcom/bumptech/glide/gifdecoder/StandardGifDecoder;", "decoder", "index", "c", "e", "(Lcom/bumptech/glide/gifdecoder/GifHeader;)Ljava/lang/Integer;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPickerGifCompressor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PickerGifCompressor.kt\ncom/huachenjie/common/util/media_picker/PickerGifCompressor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,136:1\n1#2:137\n*E\n"})
public final class xq6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final xq6 f45878a = new xq6();

    @NotNull
    public final String a(@NotNull Context context, @NotNull File sourceFile, @NotNull ImageCompressConfig compressConfig) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sourceFile, "sourceFile");
        Intrinsics.checkNotNullParameter(compressConfig, "compressConfig");
        if (!sourceFile.exists() || sourceFile.length() == 0 || compressConfig.h() <= 0) {
            String absolutePath = sourceFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "sourceFile.absolutePath");
            return absolutePath;
        }
        try {
            String strB = b(context, sourceFile, compressConfig.h());
            if (strB == null || strB.length() == 0) {
                strB = sourceFile.getAbsolutePath();
            } else if (!Intrinsics.areEqual(strB, sourceFile.getAbsolutePath())) {
                sourceFile.delete();
            }
            Intrinsics.checkNotNullExpressionValue(strB, "{\n            val output…h\n            }\n        }");
            return strB;
        } catch (Exception e) {
            e.printStackTrace();
            String absolutePath2 = sourceFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "{\n            exception.…le.absolutePath\n        }");
            return absolutePath2;
        }
    }

    public final String b(Context context, File sourceFile, int maxWidth) throws Throwable {
        ByteBuffer byteBufferFromFile = ByteBufferUtil.fromFile(sourceFile);
        Intrinsics.checkNotNullExpressionValue(byteBufferFromFile, "fromFile(sourceFile)");
        GifHeader header = new GifHeaderParser().setData(byteBufferFromFile).parseHeader();
        Intrinsics.checkNotNullExpressionValue(header, "GifHeaderParser().setDat…byteBuffer).parseHeader()");
        if (f(header, maxWidth)) {
            return sourceFile.getAbsolutePath();
        }
        Glide glide = Glide.get(context);
        Intrinsics.checkNotNullExpressionValue(glide, "get(context)");
        StandardGifDecoder standardGifDecoder = new StandardGifDecoder(new GifBitmapProvider(glide.getBitmapPool(), glide.getArrayPool()), header, byteBufferFromFile, 1);
        int frameCount = standardGifDecoder.getFrameCount();
        if (frameCount <= 0) {
            return null;
        }
        Pair<Integer, Integer> pairD = d(header.getWidth(), header.getHeight(), maxWidth);
        int iIntValue = ((Number) pairD.component1()).intValue();
        int iIntValue2 = ((Number) pairD.component2()).intValue();
        File fileB = MediaPickerConstants.f8905a.b();
        yq6 yq6Var = yq6.f46098a;
        String name = sourceFile.getName();
        Intrinsics.checkNotNullExpressionValue(name, "sourceFile.name");
        String name2 = sourceFile.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "sourceFile.name");
        File file = new File(fileB, yq6Var.e(StringsKt.substringBeforeLast(name, '.', name2) + "_compressed.gif"));
        p60 p60Var = new p60();
        p60Var.m(0);
        p60Var.n(iIntValue, iIntValue2);
        Integer numE = e(header);
        if (numE != null) {
            p60Var.k(numE.intValue());
        }
        if (!p60Var.q(file.getAbsolutePath())) {
            return null;
        }
        standardGifDecoder.resetFrameIndex();
        for (int i = 0; i < frameCount; i++) {
            standardGifDecoder.advance();
            Bitmap nextFrame = standardGifDecoder.getNextFrame();
            if (nextFrame == null) {
                p60Var.e();
                file.delete();
                return null;
            }
            Bitmap bitmapH = yq6.f46098a.h(nextFrame, maxWidth);
            if (bitmapH != nextFrame && !nextFrame.isRecycled()) {
                nextFrame.recycle();
            }
            p60Var.g(c(standardGifDecoder, i));
            p60Var.a(bitmapH);
            if (!bitmapH.isRecycled()) {
                bitmapH.recycle();
            }
        }
        p60Var.e();
        if (!(file.exists() && file.length() > 0)) {
            file = null;
        }
        if (file != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public final int c(StandardGifDecoder decoder, int index) {
        int delay = decoder.getDelay(index);
        if (delay > 0) {
            return delay;
        }
        return 100;
    }

    public final Pair<Integer, Integer> d(int srcWidth, int srcHeight, int maxWidth) {
        if (srcWidth <= 0 || srcHeight <= 0) {
            return TuplesKt.to(Integer.valueOf(maxWidth), Integer.valueOf(maxWidth));
        }
        if (srcWidth <= maxWidth && srcHeight <= maxWidth) {
            return TuplesKt.to(Integer.valueOf(srcWidth), Integer.valueOf(srcHeight));
        }
        float f = maxWidth;
        float f2 = srcWidth;
        float f3 = srcHeight;
        float fMin = Math.min(f / f2, f / f3);
        return TuplesKt.to(Integer.valueOf(RangesKt.coerceAtLeast((int) (f2 * fMin), 1)), Integer.valueOf(RangesKt.coerceAtLeast((int) (f3 * fMin), 1)));
    }

    public final Integer e(GifHeader header) {
        try {
            Field declaredField = GifHeader.class.getDeclaredField("gctSize");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(header);
            if (i > 0) {
                return Integer.valueOf((int) ((Math.log(i) / Math.log(2.0d)) - ((double) 1)));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean f(GifHeader header, int maxWidth) {
        int width = header.getWidth();
        int height = header.getHeight();
        return width > 0 && height > 0 && width <= maxWidth && height <= maxWidth;
    }
}
