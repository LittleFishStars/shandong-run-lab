package com.fl.saas.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.android.general.media.gif.FrameSequence;
import com.android.general.media.gif.FrameSequenceDrawable;
import com.fl.saas.base.rest.PreResManager;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.http.HttpCallbackBytesListener;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.FileHelper;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ImageLoader {

    /* JADX INFO: renamed from: com.fl.saas.common.util.ImageLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements HttpCallbackBytesListener {
        final /* synthetic */ Consumer val$load;
        final /* synthetic */ Function val$mapper;
        final /* synthetic */ Consumer val$onFail;

        public AnonymousClass1(Consumer consumer, Function function, Consumer consumer2) {
            this.val$onFail = consumer;
            this.val$mapper = function;
            this.val$load = consumer2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onError$3(Consumer consumer, Exception exc) {
            consumer.accept(YdError.create(20405, "NetWork Exception:" + exc.getMessage()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSuccess$0(Consumer consumer) {
            consumer.accept(new YdError(20405, "response is null"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSuccess$1(Object obj, Consumer consumer, Consumer consumer2) {
            if (obj != null) {
                if (consumer != null) {
                    consumer.accept(obj);
                }
            } else if (consumer2 != null) {
                consumer2.accept(YdError.create(20405, "img load is null"));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onSuccess$2(Consumer consumer, Exception exc) {
            consumer.accept(YdError.create(20405, "img load Exception:" + exc.getMessage()));
        }

        @Override // com.fl.saas.config.http.HttpCallbackBytesListener
        public void onError(final Exception exc) {
            final Consumer consumer = this.val$onFail;
            if (consumer != null) {
                DeviceUtil.postUI(new Runnable() { // from class: com.fl.saas.common.util.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageLoader.AnonymousClass1.lambda$onError$3(consumer, exc);
                    }
                });
            }
        }

        @Override // com.fl.saas.config.http.HttpCallbackBytesListener
        public void onSuccess(byte[] bArr) {
            try {
                if (bArr == null) {
                    final Consumer consumer = this.val$onFail;
                    if (consumer != null) {
                        DeviceUtil.postUI(new Runnable() { // from class: com.fl.saas.common.util.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                ImageLoader.AnonymousClass1.lambda$onSuccess$0(consumer);
                            }
                        });
                        return;
                    }
                    return;
                }
                final Object objApply = this.val$mapper.apply(bArr);
                final Consumer consumer2 = this.val$load;
                final Consumer consumer3 = this.val$onFail;
                DeviceUtil.postUI(new Runnable() { // from class: com.fl.saas.common.util.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageLoader.AnonymousClass1.lambda$onSuccess$1(objApply, consumer2, consumer3);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                final Consumer consumer4 = this.val$onFail;
                if (consumer4 != null) {
                    DeviceUtil.postUI(new Runnable() { // from class: com.fl.saas.common.util.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            ImageLoader.AnonymousClass1.lambda$onSuccess$2(consumer4, e);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadImageBitmap$0(Consumer consumer) {
        consumer.accept(YdError.create(20405, "img load Exception"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadImageBitmap$1(Consumer consumer, Exception exc) {
        consumer.accept(YdError.create(20405, "img load Exception:" + exc.getMessage()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Drawable lambda$loadImageDrawable$2(byte[] bArr) {
        if (!FileTypeUtils.FILE_TYPE_GIF.equals(FileTypeUtils.getFileType(Arrays.copyOfRange(bArr, 0, Math.min(bArr.length, 10))))) {
            return ImageUtils.byteArrayToDrawable(bArr);
        }
        try {
            FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(FrameSequence.decodeByteArray(bArr));
            frameSequenceDrawable.setLoopBehavior(2);
            return frameSequenceDrawable;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void loadImage(String str, final ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        loadImageBitmap(str, new Consumer() { // from class: com.zj.adlib.f74
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                imageView.setImageBitmap((Bitmap) obj);
            }
        });
    }

    public static void loadImageBitmap(String str, @Nullable Consumer<Bitmap> consumer) {
        loadImageBitmap(str, consumer, null);
    }

    public static void loadImageBitmap(String str, @Nullable Consumer<Bitmap> consumer, @Nullable final Consumer<YdError> consumer2) {
        String strCheckImageCache = PreResManager.checkImageCache(str);
        if (TextUtils.isEmpty(strCheckImageCache)) {
            loadImageBytes(str, consumer, consumer2, new Function() { // from class: com.zj.adlib.i74
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ImageUtils.byteArrayToBitmap((byte[]) obj);
                }
            });
            return;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(strCheckImageCache, options);
            if (bitmapDecodeFile == null) {
                FileHelper.deleteFile(new File(strCheckImageCache));
                if (consumer2 != null) {
                    DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.g74
                        @Override // java.lang.Runnable
                        public final void run() {
                            ImageLoader.lambda$loadImageBitmap$0(consumer2);
                        }
                    });
                }
            } else if (consumer != null) {
                consumer.accept(bitmapDecodeFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (consumer2 != null) {
                DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.h74
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImageLoader.lambda$loadImageBitmap$1(consumer2, e);
                    }
                });
            }
        }
    }

    private static <T> void loadImageBytes(String str, @Nullable Consumer<T> consumer, @Nullable Consumer<YdError> consumer2, @NonNull Function<byte[], T> function) {
        if (!TextUtils.isEmpty(str)) {
            AdHttpUtils.getInstance().doGet(str, new AnonymousClass1(consumer2, function, consumer));
        } else if (consumer2 != null) {
            consumer2.accept(YdError.create(20405, "imgUrl is empty"));
        }
    }

    public static void loadImageDrawable(String str, @Nullable Consumer<Drawable> consumer) {
        loadImageDrawable(str, consumer, null);
    }

    public static void loadImageDrawable(String str, @Nullable Consumer<Drawable> consumer, @Nullable Consumer<YdError> consumer2) {
        loadImageBytes(str, consumer, consumer2, new Function() { // from class: com.zj.adlib.e74
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return ImageLoader.lambda$loadImageDrawable$2((byte[]) obj);
            }
        });
    }
}
