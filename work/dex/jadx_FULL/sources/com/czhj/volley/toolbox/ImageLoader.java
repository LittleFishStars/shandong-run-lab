package com.czhj.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.czhj.volley.Request;
import com.czhj.volley.RequestQueue;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ImageLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RequestQueue f29488a;
    private final ImageCache b;
    private final HashMap<String, BatchedImageRequest> c = new HashMap<>();
    private final HashMap<String, BatchedImageRequest> d = new HashMap<>();
    private final Handler e = new Handler(Looper.getMainLooper());
    private int f = 100;
    private Runnable g;

    public static class BatchedImageRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Request<?> f29493a;
        private final List<ImageContainer> b;
        private Bitmap c;
        private VolleyError d;

        public BatchedImageRequest(Request<?> request, ImageContainer imageContainer) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            this.f29493a = request;
            arrayList.add(imageContainer);
        }

        public void addContainer(ImageContainer imageContainer) {
            this.b.add(imageContainer);
        }

        public VolleyError getError() {
            return this.d;
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer imageContainer) {
            this.b.remove(imageContainer);
            if (this.b.size() != 0) {
                return false;
            }
            this.f29493a.cancel();
            return true;
        }

        public void setError(VolleyError volleyError) {
            this.d = volleyError;
        }
    }

    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    public class ImageContainer {
        private final ImageListener b;
        private final String c;
        private final String d;
        private Bitmap e;

        public ImageContainer(Bitmap bitmap, String str, String str2, ImageListener imageListener) {
            this.e = bitmap;
            this.d = str;
            this.c = str2;
            this.b = imageListener;
        }

        public void cancelRequest() {
            HashMap map;
            Threads.a();
            if (this.b == null) {
                return;
            }
            BatchedImageRequest batchedImageRequest = (BatchedImageRequest) ImageLoader.this.c.get(this.c);
            if (batchedImageRequest == null) {
                BatchedImageRequest batchedImageRequest2 = (BatchedImageRequest) ImageLoader.this.d.get(this.c);
                if (batchedImageRequest2 == null) {
                    return;
                }
                batchedImageRequest2.removeContainerAndCancelIfNecessary(this);
                if (batchedImageRequest2.b.size() != 0) {
                    return;
                } else {
                    map = ImageLoader.this.d;
                }
            } else if (!batchedImageRequest.removeContainerAndCancelIfNecessary(this)) {
                return;
            } else {
                map = ImageLoader.this.c;
            }
            map.remove(this.c);
        }

        public Bitmap getBitmap() {
            return this.e;
        }

        public String getRequestUrl() {
            return this.d;
        }
    }

    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z);
    }

    public ImageLoader(RequestQueue requestQueue, ImageCache imageCache) {
        this.f29488a = requestQueue;
        this.b = imageCache;
    }

    private static String a(String str, int i, int i2, ImageView.ScaleType scaleType) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append("#S");
        sb.append(scaleType.ordinal());
        sb.append(str);
        return sb.toString();
    }

    private void a(String str, BatchedImageRequest batchedImageRequest) {
        this.d.put(str, batchedImageRequest);
        if (this.g == null) {
            Runnable runnable = new Runnable() { // from class: com.czhj.volley.toolbox.ImageLoader.4
                @Override // java.lang.Runnable
                public void run() {
                    for (BatchedImageRequest batchedImageRequest2 : ImageLoader.this.d.values()) {
                        for (ImageContainer imageContainer : batchedImageRequest2.b) {
                            if (imageContainer.b != null) {
                                if (batchedImageRequest2.getError() == null) {
                                    imageContainer.e = batchedImageRequest2.c;
                                    imageContainer.b.onResponse(imageContainer, false);
                                } else {
                                    imageContainer.b.onErrorResponse(batchedImageRequest2.getError());
                                }
                            }
                        }
                    }
                    ImageLoader.this.d.clear();
                    ImageLoader.this.g = null;
                }
            };
            this.g = runnable;
            this.e.postDelayed(runnable, this.f);
        }
    }

    public static ImageListener getImageListener(final ImageView imageView, final int i, final int i2) {
        return new ImageListener() { // from class: com.czhj.volley.toolbox.ImageLoader.1
            @Override // com.czhj.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                int i3 = i2;
                if (i3 != 0) {
                    imageView.setImageResource(i3);
                }
            }

            @Override // com.czhj.volley.toolbox.ImageLoader.ImageListener
            public void onResponse(ImageContainer imageContainer, boolean z) {
                if (imageContainer.getBitmap() != null) {
                    imageView.setImageBitmap(imageContainer.getBitmap());
                    return;
                }
                int i3 = i;
                if (i3 != 0) {
                    imageView.setImageResource(i3);
                }
            }
        };
    }

    public ImageContainer get(String str, ImageListener imageListener) {
        return get(str, imageListener, 0, 0);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2) {
        return get(str, imageListener, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2, ImageView.ScaleType scaleType) {
        Threads.a();
        String strA = a(str, i, i2, scaleType);
        Bitmap bitmap = this.b.getBitmap(strA);
        if (bitmap != null) {
            ImageContainer imageContainer = new ImageContainer(bitmap, str, null, null);
            imageListener.onResponse(imageContainer, true);
            return imageContainer;
        }
        ImageContainer imageContainer2 = new ImageContainer(null, str, strA, imageListener);
        imageListener.onResponse(imageContainer2, true);
        BatchedImageRequest batchedImageRequest = this.c.get(strA);
        if (batchedImageRequest != null) {
            batchedImageRequest.addContainer(imageContainer2);
            return imageContainer2;
        }
        Request<Bitmap> requestMakeImageRequest = makeImageRequest(str, i, i2, scaleType, strA);
        RequestQueue requestQueue = this.f29488a;
        if (requestQueue != null) {
            requestQueue.add(requestMakeImageRequest);
            this.c.put(strA, new BatchedImageRequest(requestMakeImageRequest, imageContainer2));
        }
        return imageContainer2;
    }

    public boolean isCached(String str, int i, int i2) {
        return isCached(str, i, i2, ImageView.ScaleType.CENTER_INSIDE);
    }

    public boolean isCached(String str, int i, int i2, ImageView.ScaleType scaleType) {
        Threads.a();
        return this.b.getBitmap(a(str, i, i2, scaleType)) != null;
    }

    public Request<Bitmap> makeImageRequest(String str, int i, int i2, ImageView.ScaleType scaleType, final String str2) {
        return new ImageRequest(str, new Response.Listener<Bitmap>() { // from class: com.czhj.volley.toolbox.ImageLoader.2
            @Override // com.czhj.volley.Response.Listener
            public void onResponse(Bitmap bitmap) {
                ImageLoader.this.onGetImageSuccess(str2, bitmap);
            }
        }, i, i2, scaleType, Bitmap.Config.RGB_565, new Response.ErrorListener() { // from class: com.czhj.volley.toolbox.ImageLoader.3
            @Override // com.czhj.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                ImageLoader.this.onGetImageError(str2, volleyError);
            }
        });
    }

    public void onGetImageError(String str, VolleyError volleyError) {
        BatchedImageRequest batchedImageRequestRemove = this.c.remove(str);
        if (batchedImageRequestRemove != null) {
            batchedImageRequestRemove.setError(volleyError);
            a(str, batchedImageRequestRemove);
        }
    }

    public void onGetImageSuccess(String str, Bitmap bitmap) {
        this.b.putBitmap(str, bitmap);
        BatchedImageRequest batchedImageRequestRemove = this.c.remove(str);
        if (batchedImageRequestRemove != null) {
            batchedImageRequestRemove.c = bitmap;
            a(str, batchedImageRequestRemove);
        }
    }

    public void setBatchedResponseDelay(int i) {
        this.f = i;
    }
}
