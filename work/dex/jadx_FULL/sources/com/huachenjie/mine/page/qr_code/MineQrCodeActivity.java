package com.huachenjie.mine.page.qr_code;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.ImageUtils;
import com.huachenjie.channel.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mine.bean.MineData;
import com.huachenjie.mine.databinding.MineActivityMyQrCodeBinding;
import com.huachenjie.mine.page.qr_code.MineQrCodeActivity;
import com.noober.background.view.BLConstraintLayout;
import com.zj.adlib.ai9;
import com.zj.adlib.dn1;
import com.zj.adlib.en6;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.ik0;
import com.zj.adlib.tw0;
import com.zj.adlib.wf3;
import com.zj.adlib.zn1;
import java.io.File;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\rB\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0002R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/mine/page/qr_code/MineQrCodeActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mine/databinding/MineActivityMyQrCodeBinding;", "Lcom/huachenjie/mine/page/qr_code/MineQrCodeVM;", "", "", "", "V", "getLayoutResID", "", "initView", "c0", "Lcom/huachenjie/mine/bean/MineData;", "b", "Lkotlin/Lazy;", "b0", "()Lcom/huachenjie/mine/bean/MineData;", "mineData", "<init>", "()V", "a", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class MineQrCodeActivity extends BaseMVVMActivity<MineActivityMyQrCodeBinding, MineQrCodeVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "userData";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy mineData = LazyKt.lazy(new Function0<MineData>() { // from class: com.huachenjie.mine.page.qr_code.MineQrCodeActivity$mineData$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MineData m609invoke() {
            Intent intent = this.this$0.getIntent();
            MineData mineData = intent != null ? (MineData) intent.getParcelableExtra("userData") : null;
            return mineData == null ? new MineData(null, null, null, null, null, null, null, null, null, 511, null) : mineData;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/mine/page/qr_code/MineQrCodeActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/mine/page/qr_code/MineQrCodeActivity;)V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            BLConstraintLayout bLConstraintLayout;
            Intrinsics.checkNotNullParameter(view, "view");
            MineActivityMyQrCodeBinding mineActivityMyQrCodeBindingA0 = MineQrCodeActivity.a0(MineQrCodeActivity.this);
            if (mineActivityMyQrCodeBindingA0 == null || (bLConstraintLayout = mineActivityMyQrCodeBindingA0.f11206a) == null) {
                return;
            }
            Bitmap bitmapC = tw0.c(bLConstraintLayout);
            String str = en6.K() + System.currentTimeMillis();
            i4a.a("图片路径:" + str);
            File file = new File(str);
            if (file.exists()) {
                file.delete();
                i4a.a("存在同名文件,已删除");
            }
            ImageUtils.B0(bitmapC, str, Bitmap.CompressFormat.PNG, true);
            i4a.a("新文件大小:" + file.length());
            if (wf3.n(file.getPath(), view.getContext())) {
                fv5.b("图片保存成功");
            } else {
                fv5.b("图片保存失败");
            }
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.mine.page.qr_code.MineQrCodeActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/mine/page/qr_code/MineQrCodeActivity$b;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/mine/bean/MineData;", "data", "", "a", "", "USER_DATA", "Ljava/lang/String;", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull MineData data) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            Intent intent = new Intent(context, (Class<?>) MineQrCodeActivity.class);
            intent.putExtra("userData", data);
            context.startActivity(intent);
        }
    }

    public static final /* synthetic */ MineActivityMyQrCodeBinding a0(MineQrCodeActivity mineQrCodeActivity) {
        return mineQrCodeActivity.getMBinding();
    }

    public static final void d0(MineQrCodeActivity mineQrCodeActivity, View view) {
        Intrinsics.checkNotNullParameter(mineQrCodeActivity, "this$0");
        mineQrCodeActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.k), new a())});
    }

    public final MineData b0() {
        return (MineData) this.mineData.getValue();
    }

    public final void c0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(0).setTitleName("我的二维码").setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.pp5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineQrCodeActivity.d0(this.f44036a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return com.huachenjie.mine.R.layout.mine_activity_my_qr_code;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        c0();
        getMViewModel().j().setValue(b0());
        getMBinding().f35297a.setImageBitmap(dn1.g(UserConstants.URL_PARAMS.c + ai9.e().getUserId(), 300, 0, -1, null, 0, null, 0, 0.0f, 496, null));
    }
}
