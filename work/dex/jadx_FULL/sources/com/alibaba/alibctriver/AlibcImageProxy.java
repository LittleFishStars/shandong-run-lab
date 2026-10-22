package com.alibaba.alibctriver;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.download.RVDownloadRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.kit.api.proxy.IImageProxy;
import com.alibaba.triver.utils.CommonUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcImageProxy implements IImageProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23639a = "AlibcImage";

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(String str) throws Throwable {
        File fileB = b(str);
        if (fileB.exists()) {
            try {
                return BitmapFactory.decodeFile(fileB.getAbsolutePath());
            } catch (Exception e) {
                fileB.delete();
                RVLogger.w(Log.getStackTraceString(e));
            }
        }
        RVHttpRequest rVHttpRequestBuild = RVHttpRequest.newBuilder().url(str).build();
        new RVDownloadRequest().setDownloadUrl(str);
        try {
            byte[] bArrA = a(((RVTransportService) RVProxy.get(RVTransportService.class)).httpRequest(rVHttpRequestBuild).getResStream());
            writeToFile(bArrA, fileB);
            return BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (InterruptedException e3) {
            e3.printStackTrace();
            return null;
        } catch (ExecutionException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private File b(String str) {
        return new File(a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()), CommonUtils.MD5(str));
    }

    @Override // com.alibaba.triver.kit.api.proxy.IImageProxy
    public void loadImage(final String str, IImageProxy.ImageStrategy imageStrategy, final IImageProxy.ImageListener imageListener) {
        final RVExecutorService rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class);
        rVExecutorService.getExecutor(ExecutorType.URGENT).execute(new Runnable() { // from class: com.alibaba.alibctriver.AlibcImageProxy.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (imageListener != null) {
                    final Bitmap bitmapA = AlibcImageProxy.this.a(str);
                    rVExecutorService.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.alibctriver.AlibcImageProxy.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapA != null) {
                                imageListener.onImageFinish(new BitmapDrawable(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getResources(), bitmapA));
                            } else {
                                imageListener.onImageFinish(null);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.alibaba.triver.kit.api.proxy.IImageProxy
    public void setImageUrl(final ImageView imageView, final String str, IImageProxy.ImageStrategy imageStrategy) {
        final RVExecutorService rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class);
        rVExecutorService.getExecutor(ExecutorType.URGENT).execute(new Runnable() { // from class: com.alibaba.alibctriver.AlibcImageProxy.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                final Bitmap bitmapA = AlibcImageProxy.this.a(str);
                rVExecutorService.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.alibctriver.AlibcImageProxy.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmapA);
                    }
                });
            }
        });
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x002c -> B:29:0x0033). Please report as a decompilation issue!!! */
    public void writeToFile(byte[] bArr, File file) throws Throwable {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.flush();
                        bufferedOutputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        bufferedOutputStream = bufferedOutputStream2;
                        RVLogger.w(Log.getStackTraceString(e));
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e2) {
                                RVLogger.w(Log.getStackTraceString(e2));
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            RVLogger.w(Log.getStackTraceString(e4));
        }
    }

    private String a(Context context) {
        File file = new File(context.getFilesDir() + File.separator + f23639a);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
