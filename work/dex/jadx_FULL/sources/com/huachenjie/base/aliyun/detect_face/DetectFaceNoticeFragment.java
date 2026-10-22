package com.huachenjie.base.aliyun.detect_face;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.huachenjie.base.R;
import com.huachenjie.base.databinding.FragmentDetectFaceNoticeBinding;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.zj.adlib.sk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceNoticeFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/base/databinding/FragmentDetectFaceNoticeBinding;", "Lcom/huachenjie/base/aliyun/detect_face/DetectFaceNoticeVM;", "", "", "", "getVariables", "getLayoutResID", "<init>", "()V", "a", "base_release"}, k = 1, mv = {1, 8, 0})
public final class DetectFaceNoticeFragment extends BaseMVVMFragment<FragmentDetectFaceNoticeBinding, DetectFaceNoticeVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceNoticeFragment$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/base/aliyun/detect_face/DetectFaceNoticeFragment;)V", "base_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Fragment parentFragment = DetectFaceNoticeFragment.this.getParentFragment();
            if (parentFragment != null && (parentFragment instanceof DetectFaceFragment)) {
                ((DetectFaceFragment) parentFragment).showFaceUploadFragment();
            }
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.fragment_detect_face_notice;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(sk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(sk0.k), new a())});
    }
}
