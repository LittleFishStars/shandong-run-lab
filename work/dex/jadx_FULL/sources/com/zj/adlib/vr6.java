package com.zj.adlib;

import android.content.Context;
import android.net.Uri;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class vr6 extends AbstractDraweeControllerBuilder<vr6, ImageRequest, rm1<CloseableImage>, ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s74 f45430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xr6 f20289a;

    public vr6(Context context, xr6 xr6Var, s74 s74Var, Set<ControllerListener> set) {
        super(context, set);
        this.f45430a = s74Var;
        this.f20289a = xr6Var;
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public vr6 c(Uri uri) {
        return (vr6) super.y(ImageRequest.a(uri));
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public vr6 e(@Nullable String str) {
        return (vr6) super.y(ImageRequest.b(str));
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public vr6 getThis() {
        return this;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public DataSource<rm1<CloseableImage>> getDataSourceForRequest(ImageRequest imageRequest, Object obj, boolean z) {
        return z ? this.f45430a.k(imageRequest, obj) : this.f45430a.i(imageRequest, obj);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public ur6 obtainController() {
        DraweeController draweeControllerN = n();
        if (!(draweeControllerN instanceof ur6)) {
            return this.f20289a.a(obtainDataSourceSupplier(), AbstractDraweeControllerBuilder.generateUniqueControllerId(), h());
        }
        ur6 ur6Var = (ur6) draweeControllerN;
        ur6Var.w(obtainDataSourceSupplier(), AbstractDraweeControllerBuilder.generateUniqueControllerId(), h());
        return ur6Var;
    }
}
