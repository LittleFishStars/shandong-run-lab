package com.zj.adlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class tw0 {
    public static int a(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        if (i <= reqHeight && i2 <= reqWidth) {
            return 1;
        }
        int iRound = Math.round(i / reqHeight);
        int iRound2 = Math.round(i2 / reqWidth);
        return iRound < iRound2 ? iRound : iRound2;
    }

    public static Bitmap b(View view) {
        view.setDrawingCacheEnabled(true);
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public static Bitmap c(View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(-1);
        view.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static boolean d(String picPath) {
        if (TextUtils.isEmpty(picPath)) {
            return false;
        }
        try {
            File file = new File(picPath);
            if (file.exists()) {
                return file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0061 A[Catch: IOException -> 0x005d, TRY_LEAVE, TryCatch #7 {IOException -> 0x005d, blocks: (B:30:0x0059, B:34:0x0061), top: B:54:0x0059 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0077 A[Catch: IOException -> 0x0073, TRY_LEAVE, TryCatch #1 {IOException -> 0x0073, blocks: (B:41:0x006f, B:45:0x0077), top: B:50:0x006f }] */
    /* JADX WARN: Code duplicated, block: B:50:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Bitmap e(Bitmap oriBitmap, long maxSize) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayInputStream byteArrayInputStream2;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                int i = 100;
                oriBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                while (byteArrayOutputStream.toByteArray().length > maxSize) {
                    i -= 16;
                    byteArrayOutputStream.reset();
                    if (i <= 0) {
                        break;
                    }
                    oriBitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                }
                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(byteArrayInputStream, null, null);
                    oriBitmap.recycle();
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return bitmapDecodeStream;
                } catch (OutOfMemoryError e2) {
                    byteArrayInputStream2 = byteArrayInputStream;
                    e = e2;
                    try {
                        e.printStackTrace();
                        oriBitmap.recycle();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                if (byteArrayInputStream2 != null) {
                                    byteArrayInputStream2.close();
                                }
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return null;
                            }
                        } else if (byteArrayInputStream2 != null) {
                            byteArrayInputStream2.close();
                        }
                        return null;
                    } catch (Throwable unused) {
                        byteArrayInputStream = byteArrayInputStream2;
                        oriBitmap.recycle();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                if (byteArrayInputStream != null) {
                                    byteArrayInputStream.close();
                                }
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return null;
                            }
                        } else if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable unused2) {
                    oriBitmap.recycle();
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                    } else if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    return null;
                }
            } catch (OutOfMemoryError e5) {
                e = e5;
                byteArrayInputStream2 = null;
            } catch (Throwable unused3) {
                byteArrayInputStream = null;
            }
        } catch (OutOfMemoryError e6) {
            e = e6;
            byteArrayInputStream2 = null;
            byteArrayOutputStream = null;
        } catch (Throwable unused4) {
            byteArrayInputStream = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[Catch: IOException -> 0x007e, TRY_LEAVE, TryCatch #10 {IOException -> 0x007e, blocks: (B:37:0x007a, B:41:0x0082), top: B:64:0x007a }] */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x009a A[Catch: IOException -> 0x0096, TRY_LEAVE, TryCatch #2 {IOException -> 0x0096, blocks: (B:49:0x0092, B:53:0x009a), top: B:58:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r6v9, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.io.ByteArrayOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static Bitmap f(String str, long j, int i, int i2) {
        ?? DecodeFile;
        ByteArrayInputStream byteArrayInputStream;
        ?? r6;
        ByteArrayInputStream byteArrayInputStream2;
        ?? byteArrayOutputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = a(options, i, i2);
            options.inJustDecodeBounds = false;
            DecodeFile = BitmapFactory.decodeFile(str, options);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    int i3 = 100;
                    DecodeFile.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                    while (byteArrayOutputStream.toByteArray().length > j) {
                        i3 -= 16;
                        byteArrayOutputStream.reset();
                        if (i3 <= 0) {
                            break;
                        }
                        DecodeFile.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                    }
                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    try {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(byteArrayInputStream);
                        DecodeFile.recycle();
                        try {
                            byteArrayOutputStream.close();
                            byteArrayInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return bitmapDecodeStream;
                    } catch (OutOfMemoryError e2) {
                        byteArrayInputStream2 = byteArrayInputStream;
                        e = e2;
                        DecodeFile = DecodeFile;
                        byteArrayOutputStream = byteArrayOutputStream;
                        try {
                            e.printStackTrace();
                            if (DecodeFile != 0) {
                                DecodeFile.recycle();
                            }
                            if (byteArrayOutputStream != 0) {
                                try {
                                    byteArrayOutputStream.close();
                                    if (byteArrayInputStream2 != null) {
                                        byteArrayInputStream2.close();
                                    }
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return null;
                                }
                            } else if (byteArrayInputStream2 != null) {
                                byteArrayInputStream2.close();
                            }
                            return null;
                        } catch (Throwable unused) {
                            byteArrayInputStream = byteArrayInputStream2;
                            if (DecodeFile != 0) {
                                DecodeFile.recycle();
                            }
                            if (byteArrayOutputStream != 0) {
                                try {
                                    byteArrayOutputStream.close();
                                    if (byteArrayInputStream != null) {
                                        byteArrayInputStream.close();
                                    }
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    return null;
                                }
                            } else if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            return null;
                        }
                    } catch (Throwable unused2) {
                        if (DecodeFile != 0) {
                            DecodeFile.recycle();
                        }
                        if (byteArrayOutputStream != 0) {
                            byteArrayOutputStream.close();
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                        } else if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        return null;
                    }
                } catch (OutOfMemoryError e5) {
                    e = e5;
                    byteArrayInputStream2 = null;
                    DecodeFile = DecodeFile;
                    byteArrayOutputStream = byteArrayOutputStream;
                } catch (Throwable unused3) {
                    byteArrayInputStream = null;
                }
            } catch (OutOfMemoryError e6) {
                e = e6;
                byteArrayInputStream2 = null;
                r6 = DecodeFile;
                byteArrayOutputStream = byteArrayInputStream2;
                DecodeFile = r6;
                e.printStackTrace();
                if (DecodeFile != 0) {
                    DecodeFile.recycle();
                }
                if (byteArrayOutputStream != 0) {
                    byteArrayOutputStream.close();
                    if (byteArrayInputStream2 != null) {
                        byteArrayInputStream2.close();
                    }
                } else if (byteArrayInputStream2 != null) {
                    byteArrayInputStream2.close();
                }
                return null;
            } catch (Throwable unused4) {
                byteArrayInputStream = null;
                DecodeFile = DecodeFile;
                byteArrayOutputStream = byteArrayInputStream;
                if (DecodeFile != 0) {
                    DecodeFile.recycle();
                }
                if (byteArrayOutputStream != 0) {
                    byteArrayOutputStream.close();
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                } else if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            }
        } catch (OutOfMemoryError e7) {
            e = e7;
            r6 = 0;
            byteArrayInputStream2 = null;
        } catch (Throwable unused5) {
            DecodeFile = 0;
            byteArrayInputStream = null;
        }
    }

    public static byte[] g(Bitmap oriBitmap, long maxSize) {
        byte[] bArr = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    int i = 100;
                    oriBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
                    while (byteArrayOutputStream2.toByteArray().length > maxSize) {
                        i -= 16;
                        byteArrayOutputStream2.reset();
                        if (i <= 0) {
                            break;
                        }
                        oriBitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream2);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    oriBitmap.recycle();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return byteArray;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    e.printStackTrace();
                    oriBitmap.recycle();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return bArr;
                } catch (Throwable unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    oriBitmap.recycle();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return bArr;
                }
            } catch (OutOfMemoryError e5) {
                e = e5;
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:92:0x0114 A[Catch: IOException -> 0x0110, TryCatch #6 {IOException -> 0x0110, blocks: (B:88:0x010c, B:92:0x0114, B:94:0x0119), top: B:98:0x010c }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0119 A[Catch: IOException -> 0x0110, TRY_LEAVE, TryCatch #6 {IOException -> 0x0110, blocks: (B:88:0x010c, B:92:0x0114, B:94:0x0119), top: B:98:0x010c }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static File h(Bitmap e, long j, String str, String str2) throws Throwable {
        ?? r10;
        ByteArrayInputStream byteArrayInputStream;
        ?? r7;
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        e.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                        int i = 100;
                        while (byteArrayOutputStream.toByteArray().length > j) {
                            i -= 16;
                            byteArrayOutputStream.reset();
                            if (i <= 0) {
                                break;
                            }
                            e.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                        }
                        byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(byteArrayInputStream, null, null);
                            try {
                                File file = new File((String) str, (String) str2);
                                if (!file.exists()) {
                                    file.createNewFile();
                                }
                                BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file));
                                try {
                                    bitmapDecodeStream.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream3);
                                    e.recycle();
                                    bitmapDecodeStream.recycle();
                                    try {
                                        byteArrayOutputStream.close();
                                        byteArrayInputStream.close();
                                        bufferedOutputStream3.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                    return file;
                                } catch (IOException e3) {
                                    e = e3;
                                    bufferedOutputStream2 = bufferedOutputStream3;
                                    str = bitmapDecodeStream;
                                    str2 = bufferedOutputStream2;
                                    e.printStackTrace();
                                    e.recycle();
                                    if (str != 0) {
                                        str.recycle();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    if (byteArrayInputStream != null) {
                                        byteArrayInputStream.close();
                                    }
                                    if (str2 != 0) {
                                        str2.close();
                                    }
                                    return null;
                                } catch (OutOfMemoryError e4) {
                                    e = e4;
                                    bufferedOutputStream = bufferedOutputStream3;
                                    str = bitmapDecodeStream;
                                    str2 = bufferedOutputStream;
                                    e.printStackTrace();
                                    e.recycle();
                                    if (str != 0) {
                                        str.recycle();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    if (byteArrayInputStream != null) {
                                        byteArrayInputStream.close();
                                    }
                                    if (str2 != 0) {
                                        str2.close();
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    r0 = bitmapDecodeStream;
                                    byteArrayInputStream = byteArrayInputStream;
                                    th = th;
                                    r7 = e;
                                    r10 = bufferedOutputStream3;
                                    r7.recycle();
                                    if (r0 != 0) {
                                        r0.recycle();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                            if (byteArrayInputStream != null) {
                                                byteArrayInputStream.close();
                                            }
                                            if (r10 != 0) {
                                                r10.close();
                                            }
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                            throw th;
                                        }
                                    } else {
                                        if (byteArrayInputStream != null) {
                                            byteArrayInputStream.close();
                                        }
                                        if (r10 != 0) {
                                            r10.close();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e6) {
                                bufferedOutputStream2 = null;
                                e = e6;
                            } catch (OutOfMemoryError e7) {
                                bufferedOutputStream = null;
                                e = e7;
                            } catch (Throwable th2) {
                                byteArrayInputStream = byteArrayInputStream;
                                th = th2;
                                r10 = 0;
                                r0 = bitmapDecodeStream;
                                r7 = e;
                            }
                        } catch (IOException e8) {
                            str = 0;
                            str2 = 0;
                            byteArrayInputStream = byteArrayInputStream;
                            e = e8;
                        } catch (OutOfMemoryError e9) {
                            str = 0;
                            str2 = 0;
                            byteArrayInputStream = byteArrayInputStream;
                            e = e9;
                        } catch (Throwable th3) {
                            r10 = 0;
                            byteArrayInputStream = byteArrayInputStream;
                            th = th3;
                            r7 = e;
                        }
                    } catch (IOException e10) {
                        e = e10;
                        byteArrayInputStream = null;
                        str = 0;
                        str2 = 0;
                    } catch (OutOfMemoryError e11) {
                        e = e11;
                        byteArrayInputStream = null;
                        str = 0;
                        str2 = 0;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayInputStream = null;
                        r10 = 0;
                        r7 = e;
                    }
                } catch (IOException e12) {
                    e = e12;
                    e.printStackTrace();
                    return null;
                }
            } catch (IOException e13) {
                e = e13;
                byteArrayInputStream = null;
                str = 0;
                str2 = 0;
                byteArrayOutputStream = null;
            } catch (OutOfMemoryError e14) {
                e = e14;
                byteArrayInputStream = null;
                str = 0;
                str2 = 0;
                byteArrayOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                byteArrayInputStream = null;
                r10 = 0;
                byteArrayOutputStream = null;
                r7 = e;
            }
        } catch (Throwable th6) {
            th = th6;
            r0 = str;
            r10 = str2;
            r7 = e;
        }
    }

    public static Bitmap i(Bitmap backBitmap, Bitmap frontBitmap) {
        if (backBitmap == null || backBitmap.isRecycled() || frontBitmap == null || frontBitmap.isRecycled()) {
            return null;
        }
        Bitmap bitmapCopy = backBitmap.copy(Bitmap.Config.ARGB_8888, true);
        new Canvas(bitmapCopy).drawBitmap(frontBitmap, new Rect(0, 0, frontBitmap.getWidth(), frontBitmap.getHeight()), new Rect(0, 0, Math.max(backBitmap.getWidth(), frontBitmap.getWidth()), Math.max(backBitmap.getHeight(), frontBitmap.getHeight())), (Paint) null);
        return bitmapCopy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.graphics.Bitmap] */
    public static File j(String str, String str2, Bitmap bitmap) throws Throwable {
        ?? r1 = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                try {
                    if (bitmap != 0) {
                        try {
                            File file = new File(str, (String) str2);
                            if (file.exists()) {
                                file.delete();
                            }
                            file.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return file;
                            } catch (FileNotFoundException e2) {
                                str2 = fileOutputStream;
                                e = e2;
                                e.printStackTrace();
                                if (str2 != 0) {
                                    str2.flush();
                                    str2.close();
                                    str2 = str2;
                                }
                                return null;
                            } catch (IOException e3) {
                                str2 = fileOutputStream;
                                e = e3;
                                e.printStackTrace();
                                if (str2 != 0) {
                                    str2.flush();
                                    str2.close();
                                    str2 = str2;
                                }
                                return null;
                            } catch (NullPointerException e4) {
                                str2 = fileOutputStream;
                                e = e4;
                                e.printStackTrace();
                                if (str2 != 0) {
                                    str2.flush();
                                    str2.close();
                                    str2 = str2;
                                }
                                return null;
                            } catch (Throwable th) {
                                r1 = fileOutputStream;
                                th = th;
                                if (r1 != 0) {
                                    try {
                                        r1.flush();
                                        r1.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e6) {
                            e = e6;
                            str2 = 0;
                        } catch (IOException e7) {
                            e = e7;
                            str2 = 0;
                        } catch (NullPointerException e8) {
                            e = e8;
                            str2 = 0;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                r1 = str2;
            }
        }
        return null;
    }
}
