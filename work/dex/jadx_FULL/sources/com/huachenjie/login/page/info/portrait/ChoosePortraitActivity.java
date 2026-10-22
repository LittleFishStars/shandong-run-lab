package com.huachenjie.login.page.info.portrait;

import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.channel.widget.UploadPictureButton;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.login.R;
import com.huachenjie.login.bean.RegisterConfigHeadBean;
import com.huachenjie.login.databinding.LoginActivityChoosePortraitBinding;
import com.huachenjie.login.page.info.portrait.ChoosePortraitActivity;
import com.huachenjie.login.page.info.university.ChooseUniversityActivity;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.pg3;
import com.zj.adlib.zk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u000fB\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0002R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/login/page/info/portrait/ChoosePortraitActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/login/databinding/LoginActivityChoosePortraitBinding;", "Lcom/huachenjie/login/page/info/portrait/ChoosePortraitVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "position", "e0", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "<init>", "()V", "ClickProxy", "login_release"}, k = 1, mv = {1, 8, 0})
public final class ChoosePortraitActivity extends BaseMVVMActivity<LoginActivityChoosePortraitBinding, ChoosePortraitVM> {
    public static final int K = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public MediaPickerLauncher picker;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/login/page/info/portrait/ChoosePortraitActivity$ClickProxy;", "", "Landroid/view/View;", "v", "", "c", "d", "e", "b", "<init>", "(Lcom/huachenjie/login/page/info/portrait/ChoosePortraitActivity;)V", "login_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void b() {
            RegisterConfigHeadBean value = ChoosePortraitActivity.a0(ChoosePortraitActivity.this).j().getValue();
            if (value != null) {
                pg3.portraitUrl = value.getHeadImgUrl();
                pg3.f18845a.i(value.getHeadImgCode());
            }
            ChoosePortraitActivity.this.startActivity(new Intent(ChoosePortraitActivity.this, (Class<?>) ChooseUniversityActivity.class));
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ChoosePortraitActivity.this.getOnBackPressedDispatcher().onBackPressed();
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (ChoosePortraitActivity.a0(ChoosePortraitActivity.this).l().getValue() != null) {
                ChoosePortraitActivity.this.e0(-1);
            }
            MediaPickerLauncher mediaPickerLauncher = ChoosePortraitActivity.this.picker;
            if (mediaPickerLauncher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("picker");
                mediaPickerLauncher = null;
            }
            MediaPickerLauncher.Y(mediaPickerLauncher, UploadPictureButton.g, 0, 1080, 1024, true, 0.0f, 0.0f, false, 226, null);
        }

        public final void e(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            Integer value = ChoosePortraitActivity.a0(ChoosePortraitActivity.this).n().getValue();
            if (value != null && value.intValue() == -1) {
                ChoosePortraitActivity.a0(ChoosePortraitActivity.this).o(ChoosePortraitActivity.this, new Function1<String, Unit>() { // from class: com.huachenjie.login.page.info.portrait.ChoosePortraitActivity$ClickProxy$onNext$1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull String str) {
                        Intrinsics.checkNotNullParameter(str, o.f);
                        this.this$0.b();
                    }
                });
            } else {
                b();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/login/page/info/portrait/ChoosePortraitActivity$b", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "", "b", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements MediaPickerListener {
        public b() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!(result instanceof MediaPickerResult.Success)) {
                if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                    return;
                }
                fv5.b(((MediaPickerResult.Error) result).f());
                return;
            }
            String str = (String) CollectionsKt.getOrNull(((MediaPickerResult.Success) result).g(), 0);
            if (str == null) {
                return;
            }
            ChoosePortraitActivity.a0(ChoosePortraitActivity.this).l().setValue(str);
            ChoosePortraitActivity.this.e0(-1);
        }
    }

    public static final /* synthetic */ ChoosePortraitVM a0(ChoosePortraitActivity choosePortraitActivity) {
        return choosePortraitActivity.getMViewModel();
    }

    public static final void d0(ChoosePortraitActivity choosePortraitActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(choosePortraitActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        choosePortraitActivity.e0(i);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(zk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(zk0.k), new ClickProxy())});
    }

    public final void e0(int position) {
        Integer value = getMViewModel().n().getValue();
        if (value != null && value.intValue() == position) {
            return;
        }
        getMViewModel().n().setValue(Integer.valueOf(position));
        if (position >= 0) {
            getMViewModel().j().setValue(getMViewModel().k().get(position));
        }
        ChoosePortraitAdapter value2 = getMViewModel().m().getValue();
        if (value2 != null) {
            value2.notifyDataSetChanged();
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.login_activity_choose_portrait;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        MutableLiveData<ChoosePortraitAdapter> mutableLiveDataM = getMViewModel().m();
        ChoosePortraitAdapter choosePortraitAdapter = new ChoosePortraitAdapter(getMViewModel().n());
        choosePortraitAdapter.setList(getMViewModel().k());
        choosePortraitAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.lk1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ChoosePortraitActivity.d0(this.f43087a, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataM.setValue(choosePortraitAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        this.picker = MediaPicker.w(this, new b());
    }
}
