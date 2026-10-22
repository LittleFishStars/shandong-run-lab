package com.byazt.nr;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 133})
public class z {
    public static volatile File c;
    public static c tt;

    public interface c {
        String c();

        String tt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(String str, final com.byazt.qr.c<Bitmap> cVar, final int i) {
        c cVar2 = tt;
        ((com.byazt.yj.qy) com.byazt.ut.uj.getService("img_service")).from(((cVar2 == null || TextUtils.isEmpty(cVar2.c())) ? null : tt.c()) + str).config(Bitmap.Config.ARGB_8888).type(2).to(new com.byazt.yj.gr() { // from class: com.byazt.nr.z.4
            @Override // com.byazt.yj.gr
            public void onFailed(int i2, String str2, Throwable th) {
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(com.byazt.yj.m mVar) {
                Bitmap bitmap = mVar != null ? (Bitmap) mVar.getResult() : null;
                if (bitmap != null) {
                    z.tt(bitmap, (com.byazt.qr.c<Bitmap>) cVar, i);
                }
            }
        });
    }

    public static void c(final Context context, final String str, final View view, int i) {
        c(context, str, new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.nr.z.1
            @Override // com.byazt.qr.c
            public void c(final Bitmap bitmap) {
                z.tt(new Runnable() { // from class: com.byazt.nr.z.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            View view2 = view;
                            if (view2 != null) {
                                view2.setBackground(new BitmapDrawable(context.getResources(), bitmap));
                            }
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                });
            }
        }, i);
    }

    public static void c(final Context context, final String str, final ImageView imageView, int i) {
        c(context, str, new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.nr.z.2
            @Override // com.byazt.qr.c
            public void c(final Bitmap bitmap) {
                z.tt(new Runnable() { // from class: com.byazt.nr.z.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ImageView imageView2 = imageView;
                            if (imageView2 != null) {
                                imageView2.setImageDrawable(new BitmapDrawable(context.getResources(), bitmap));
                            }
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                });
            }
        }, i);
    }

    public static void c(Context context, final String str, final com.byazt.qr.c<Bitmap> cVar, final int i) {
        com.byazt.yj.yv yvVar = (com.byazt.yj.yv) com.byazt.ut.uj.getService("local_img_loader");
        File file = !TextUtils.isEmpty(tt.tt()) ? new File(c(context), tt.tt()) : null;
        String absolutePath = file != null ? file.getAbsolutePath() : null;
        yvVar.from(c(absolutePath, com.byazt.as.ve.c(str))).cacheDir(absolutePath).isLocalRes(true).sync(true).config(Bitmap.Config.ARGB_8888).type(2).to(new com.byazt.yj.gr() { // from class: com.byazt.nr.z.3
            @Override // com.byazt.yj.gr
            public void onFailed(int i2, String str2, Throwable th) {
                z.tt(str, (com.byazt.qr.c<Bitmap>) cVar, i);
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(com.byazt.yj.m mVar) {
                Bitmap bitmap = mVar != null ? (Bitmap) mVar.getResult() : null;
                if (bitmap != null) {
                    z.tt(bitmap, (com.byazt.qr.c<Bitmap>) cVar, i);
                } else {
                    z.tt(str, (com.byazt.qr.c<Bitmap>) cVar, i);
                }
            }
        }, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(final Bitmap bitmap, final com.byazt.qr.c<Bitmap> cVar, final int i) {
        if (bitmap.isRecycled()) {
            return;
        }
        tt(new Runnable() { // from class: com.byazt.nr.z.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i2 = i;
                    if (i2 >= 160) {
                        bitmap.setDensity(i2);
                    }
                    cVar.c(bitmap);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            da.tt().post(runnable);
        }
    }

    private static com.byazt.yj.md c(final String str, final String str2) {
        return new com.byazt.yj.md() { // from class: com.byazt.nr.z.6
            @Override // com.byazt.yj.md
            public SparseArray<Object> extra() {
                return null;
            }

            @Override // com.byazt.yj.md
            public String getCacheDir() {
                return str;
            }

            @Override // com.byazt.yj.md
            public int getMemoryCacheSize() {
                return 524288;
            }

            @Override // com.byazt.yj.md
            public String getName() {
                return str2;
            }

            @Override // com.byazt.yj.md
            public int getRawCacheSize() {
                return 0;
            }
        };
    }

    public static File c(Context context) {
        if (c == null) {
            try {
                File file = new File(sp.tt(context, false, null), "tt_img_cac");
                file.mkdirs();
                c = file;
            } catch (Throwable th) {
                m.uj("LocalResCacheHelp", th.getMessage());
            }
        }
        return c;
    }

    public static void c(c cVar) {
        tt = cVar;
    }
}
