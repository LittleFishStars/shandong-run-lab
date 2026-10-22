package com.huachenjie.base.widget.image_pick;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ImageUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.base.R;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.sw0;
import com.zj.adlib.u66;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ImagePickView extends RelativeLayout implements OnItemClickListener, OnItemChildClickListener {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f32987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImagePickAdapter f7330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImagePickBean f7331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImagePickCallback f7332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public UploadFileType f7333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MediaPickerLauncher f7334a;

    public interface ImagePickCallback {
        void a(List<ImagePickBean> list);

        void b();

        void showLoading();
    }

    public class a implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImagePickBean f32988a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f7336a;

        public a(final ImagePickBean val$bean, final String val$realFilePath) {
            this.f32988a = val$bean;
            this.f7336a = val$realFilePath;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, String message) {
            if (ImagePickView.this.f7332a != null) {
                ImagePickView.this.f7332a.b();
            }
            fv5.b("图片上传失败");
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(String fileUrl) {
            if (ImagePickView.this.f7332a != null) {
                ImagePickView.this.f7332a.b();
            }
            if (TextUtils.isEmpty(fileUrl)) {
                fv5.b("图片上传失败");
                return;
            }
            ImagePickView.this.e(this.f32988a, fileUrl);
            if (this.f7336a.equals(this.f32988a.getLocalPath())) {
                return;
            }
            new File(this.f7336a).delete();
        }
    }

    public ImagePickView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(MediaPickerResult mediaPickerResult) {
        if (mediaPickerResult instanceof MediaPickerResult.Success) {
            h(((MediaPickerResult.Success) mediaPickerResult).g());
        } else if (mediaPickerResult instanceof MediaPickerResult.Error) {
            fv5.b(((MediaPickerResult.Error) mediaPickerResult).f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ View l(Integer num) {
        return this.f7330a.getViewByPosition(num.intValue(), R.id.iv_commodity_image);
    }

    public void addData(ImagePickBean bean) {
        if (this.f7330a.getData().isEmpty()) {
            this.f7330a.addData(bean);
            this.f7330a.addData(this.f7331a);
        } else if (this.f7330a.getData().size() == this.K && ((ImagePickBean) this.f7330a.getData().get(this.K - 1)).getPostType() == 2) {
            this.f7330a.removeAt(this.K - 1);
            this.f7330a.addData(bean);
        } else {
            this.f7330a.addData(this.f7330a.getData().size() - 1, bean);
        }
        m();
    }

    public final void e(ImagePickBean bean, String url) {
        bean.setUrl(url);
        addData(bean);
    }

    public final void f(FragmentActivity activity) {
        if (this.f7334a != null) {
            return;
        }
        this.f7334a = MediaPicker.w(activity, new MediaPickerListener() { // from class: com.zj.adlib.r74
            @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
            public final void b(MediaPickerResult mediaPickerResult) {
                this.f44389a.k(mediaPickerResult);
            }
        });
    }

    public final String g(ImagePickBean bean) {
        try {
            String str = getContext().getCacheDir().getAbsolutePath() + File.separator + System.nanoTime() + ".webp";
            sw0.c(ImageUtils.Z(bean.getLocalPath(), 1920, 1920), str, "webp", 75);
            return str;
        } catch (Exception e) {
            i4a.d("图片压缩失败", e.getMessage());
            return bean.getLocalPath();
        }
    }

    public final void h(List<String> paths) {
        if (paths == null || paths.isEmpty()) {
            return;
        }
        for (String str : paths) {
            if (TextUtils.isEmpty(str)) {
                fv5.b("获取图片失败");
                return;
            }
            if (!new File(str).exists()) {
                fv5.b("图片不存在或已经被删除");
                return;
            }
            ImagePickBean imagePickBean = new ImagePickBean(1);
            imagePickBean.setLocalPath(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            imagePickBean.setWidth(options.outWidth);
            imagePickBean.setHeight(options.outHeight);
            p(imagePickBean);
        }
    }

    public final void i(Context context, AttributeSet attrs) {
        context.getTheme().obtainStyledAttributes(attrs, R.styleable.ImagePickView, 0, 0).recycle();
    }

    public void initPicker(@NonNull FragmentActivity activity, int maxLength, @Nullable String addTip, @NonNull UploadFileType uploadFileType) {
        f(activity);
        this.K = maxLength;
        if (!TextUtils.isEmpty(addTip)) {
            this.f7331a.setAddTip(addTip);
        }
        this.f7333a = uploadFileType;
        this.f7330a.setList(Collections.singletonList(this.f7331a));
    }

    public final void j(Context context) {
        this.f32987a = new RecyclerView(context);
        this.f32987a.setLayoutManager(new GridLayoutManager(context, 3));
        ImagePickAdapter imagePickAdapter = new ImagePickAdapter();
        this.f7330a = imagePickAdapter;
        imagePickAdapter.setOnItemClickListener(this);
        this.f7330a.addChildClickViewIds(R.id.iv_delete);
        this.f7330a.setOnItemChildClickListener(this);
        this.f32987a.setAdapter(this.f7330a);
        this.f32987a.setNestedScrollingEnabled(false);
        addView(this.f32987a, new RelativeLayout.LayoutParams(-1, -2));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m() {
        if (this.f7332a != null) {
            List<T> data = this.f7330a.getData();
            if (data.isEmpty()) {
                this.f7332a.a(data);
            } else if (((ImagePickBean) data.get(data.size() - 1)).getPostType() == 2) {
                this.f7332a.a(data.subList(0, data.size() - 1));
            } else {
                this.f7332a.a(data);
            }
        }
    }

    public final void n(int position) {
        ArrayList arrayList = new ArrayList();
        for (T t : this.f7330a.getData()) {
            if (t.getPostType() == 1) {
                arrayList.add(t.getLocalPath());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        PicturePreviewUtil.h(getContext(), arrayList, position, new Function1() { // from class: com.zj.adlib.q74
            public final Object invoke(Object obj) {
                return this.f44142a.l((Integer) obj);
            }
        });
    }

    public final void o() {
        if (this.f7334a == null) {
            fv5.b("图片选择器未初始化");
            return;
        }
        int size = this.f7330a.getData().size();
        int i = this.K;
        if (size <= i) {
            this.f7334a.T("为了能够正常上传图片，我们需要访问您终端设备的相机权限", (i - this.f7330a.getData().size()) + 1, 1080, 1024);
            return;
        }
        fv5.b("最多只能选择" + this.K + "张图片");
    }

    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
    public void onItemChildClick(@NonNull BaseQuickAdapter<?, ?> baseAdapter, @NonNull View view, int position) {
        if (view.getId() == R.id.iv_delete) {
            if (position == this.K - 1) {
                this.f7330a.removeAt(position);
                this.f7330a.addData(this.f7331a);
            } else {
                this.f7330a.removeAt(position);
            }
            m();
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> baseAdapter, @NonNull View view, int position) {
        if (((ImagePickBean) this.f7330a.getData().get(position)).getPostType() == 2) {
            o();
        } else {
            n(position);
        }
    }

    public final void p(ImagePickBean bean) {
        ImagePickCallback imagePickCallback = this.f7332a;
        if (imagePickCallback != null) {
            imagePickCallback.showLoading();
        }
        String strG = g(bean);
        u66.d(getContext(), this.f7333a, strG, new a(bean, strG));
    }

    public void setCallback(ImagePickCallback callback) {
        this.f7332a = callback;
    }

    public void setList(List<ImagePickBean> list) {
        if (list.size() >= this.K) {
            this.f7330a.setList(list);
        } else {
            list.add(this.f7331a);
            this.f7330a.setList(list);
        }
        m();
    }

    public void setMaxLength(int maxLength) {
        this.K = maxLength;
    }

    public ImagePickView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ImagePickView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f7331a = new ImagePickBean(2);
        this.K = 5;
        this.f7333a = UploadFileType.UPLOAD_CHANNEL_AD;
        i(context, attrs);
        j(context);
    }
}
