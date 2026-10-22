package com.huachenjie.social_contact.page;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.huachenjie.base.dsbridge_webview.SpineWebView;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.SpineSuitModelBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.mine.page.dressing_table.avatar.AvatarFragment;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.AvatarFrameInfo;
import com.huachenjie.social_contact.bean.PayBean;
import com.huachenjie.social_contact.bean.RoleInfo;
import com.huachenjie.social_contact.bean.SkillInfo;
import com.huachenjie.social_contact.bean.SuperPackInfo;
import com.huachenjie.social_contact.databinding.ActivitySuperPackBinding;
import com.huachenjie.social_contact.page.SuperPackActivity;
import com.huachenjie.social_contact.vm.SuperPackVM;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.f)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010*R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/huachenjie/social_contact/page/SuperPackActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/vm/SuperPackVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "init", "initViewModel", "initView", "", "code", "q0", "url", AvatarFragment.AVATAR_URL, "n0", "o0", "", "position", "r0", "Landroid/view/View;", "m0", "x", "Ljava/lang/String;", "packCode", "Lcom/huachenjie/base/dsbridge_webview/SpineWebView;", "a", "Lcom/huachenjie/base/dsbridge_webview/SpineWebView;", "characterSpine", "Landroid/widget/TextView;", "A", "Landroid/widget/TextView;", "mSpineDesc", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "avatarFrame", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "skillLottie", "", "Z", "hideSkill", "K", "I", "currentTab", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSuperPackActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperPackActivity.kt\ncom/huachenjie/social_contact/page/SuperPackActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,202:1\n1#2:203\n*E\n"})
public final class SuperPackActivity extends BaseVmActivity<SuperPackVM> {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    @Nullable
    public TextView mSpineDesc;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int currentTab;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public RelativeLayout avatarFrame;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public LottieAnimationView skillLottie;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public SpineWebView characterSpine;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean hideSkill;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = UserConstants.SOCIAL_CONTACT_PARAMS.c)
    @JvmField
    @Nullable
    public String packCode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\f"}, d2 = {"Lcom/huachenjie/social_contact/page/SuperPackActivity$a;", "", "Landroid/view/View;", "view", "", "b", "e", "a", "d", "c", "<init>", "(Lcom/huachenjie/social_contact/page/SuperPackActivity;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View view) {
            SuperPackActivity.this.r0(2);
        }

        public final void b(@Nullable View view) {
            SuperPackActivity.this.finish();
        }

        public final void c(@Nullable View view) {
            MutableLiveData<SuperPackInfo> mutableLiveDataI;
            SuperPackInfo value;
            SuperPackVM superPackVM = (SuperPackVM) ((BaseVmActivity) SuperPackActivity.this).f8507a;
            if (superPackVM == null || (mutableLiveDataI = superPackVM.i()) == null || (value = mutableLiveDataI.getValue()) == null) {
                return;
            }
            SuperPackActivity superPackActivity = SuperPackActivity.this;
            ARouter.getInstance().build(RoutePathConstants.SocialContact.i).withParcelable(UserConstants.SOCIAL_CONTACT_PARAMS.f33737a, new PayBean(2, 21, superPackActivity.packCode, value.getBuyPrice(), "超级礼包")).withTransition(R.anim.actionsheet_dialog_in, R.anim.actionsheet_dialog_out).navigation(superPackActivity.getContext());
        }

        public final void d(@Nullable View view) {
            SuperPackActivity.this.r0(3);
        }

        public final void e(@Nullable View view) {
            SuperPackActivity.this.r0(1);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36223a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36223a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36223a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36223a.invoke(obj);
        }
    }

    public static final void p0(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_super_pack), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        SuperPackVM superPackVM;
        initView();
        String str = this.packCode;
        if (str == null || (superPackVM = (SuperPackVM) ((BaseVmActivity) this).f8507a) == null) {
            return;
        }
        superPackVM.j(str);
    }

    public final void initView() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.ActivitySuperPackBinding");
        ActivitySuperPackBinding activitySuperPackBinding = (ActivitySuperPackBinding) binding;
        this.characterSpine = activitySuperPackBinding.f12804a;
        this.mSpineDesc = activitySuperPackBinding.f12809b;
        this.avatarFrame = activitySuperPackBinding.f12800a;
        this.skillLottie = activitySuperPackBinding.f12803a;
        r0(1);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        MutableLiveData<SuperPackInfo> mutableLiveDataI;
        SuperPackVM superPackVM = (SuperPackVM) ((BaseVmActivity) this).f8507a;
        if (superPackVM == null || (mutableLiveDataI = superPackVM.i()) == null) {
            return;
        }
        mutableLiveDataI.observe(this, new b(new Function1<SuperPackInfo, Unit>() { // from class: com.huachenjie.social_contact.page.SuperPackActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SuperPackInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SuperPackInfo superPackInfo) {
                String metaverseModelCode;
                RoleInfo role = superPackInfo.getRole();
                if (role != null && (metaverseModelCode = role.getMetaverseModelCode()) != null) {
                    SuperPackActivity.this.q0(metaverseModelCode);
                }
                AvatarFrameInfo avatarFrame = superPackInfo.getAvatarFrame();
                if (avatarFrame != null) {
                    SuperPackActivity superPackActivity = SuperPackActivity.this;
                    String backgroundImg = avatarFrame.getBackgroundImg();
                    if (backgroundImg == null) {
                        backgroundImg = "";
                    }
                    String avatarFrameImg = avatarFrame.getAvatarFrameImg();
                    if (avatarFrameImg == null) {
                        avatarFrameImg = "";
                    }
                    superPackActivity.n0(backgroundImg, avatarFrameImg);
                }
                if (superPackInfo.getSkill() == null) {
                    SuperPackActivity.this.hideSkill = true;
                    return;
                }
                SuperPackActivity.this.hideSkill = false;
                SkillInfo skill = superPackInfo.getSkill();
                if (skill != null) {
                    SuperPackActivity superPackActivity2 = SuperPackActivity.this;
                    String skillImg = skill.getSkillImg();
                    superPackActivity2.o0(skillImg != null ? skillImg : "");
                }
            }
        }));
    }

    public final View m0(int position) {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.ActivitySuperPackBinding");
        ActivitySuperPackBinding activitySuperPackBinding = (ActivitySuperPackBinding) binding;
        if (position == 1) {
            return activitySuperPackBinding.f12807b;
        }
        if (position == 2) {
            return activitySuperPackBinding.f12799a;
        }
        if (position != 3) {
            return null;
        }
        return activitySuperPackBinding.f12810c;
    }

    public final void n0(String url, String avatarUrl) {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.ActivitySuperPackBinding");
        ActivitySuperPackBinding activitySuperPackBinding = (ActivitySuperPackBinding) binding;
        ImageView imageView = activitySuperPackBinding.b;
        Glide.with(imageView).load(url).into(imageView);
        ImageView imageView2 = activitySuperPackBinding.f12798a;
        Glide.with(imageView2).load(avatarUrl).into(imageView2);
    }

    public final void o0(String url) {
        LottieAnimationView lottieAnimationView = this.skillLottie;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimationFromUrl(url);
            lottieAnimationView.setFailureListener(new LottieListener() { // from class: com.zj.adlib.rw8
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    SuperPackActivity.p0((Throwable) obj);
                }
            });
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(-1);
        }
        super.onCreate(savedInstanceState);
    }

    public final void q0(String code) {
        SpineSuitModelBean spineSuitModelBean = new SpineSuitModelBean(code, null, 2, null);
        SpineWebView spineWebView = this.characterSpine;
        if (spineWebView != null) {
            spineWebView.loadSpine(spineSuitModelBean);
        }
    }

    public final void r0(int position) {
        int i = this.currentTab;
        if (position == i) {
            return;
        }
        View viewM0 = m0(i);
        if (viewM0 != null) {
            viewM0.setBackgroundResource(R.drawable.bg_super_gift_skill);
        }
        View viewM1 = m0(position);
        if (viewM1 != null) {
            viewM1.setBackgroundResource(R.drawable.bg_super_gift_skill_selected);
        }
        SpineWebView spineWebView = this.characterSpine;
        if (spineWebView != null) {
            spineWebView.setVisibility(position == 1 ? 0 : 8);
        }
        TextView textView = this.mSpineDesc;
        if (textView != null) {
            textView.setVisibility(position == 1 ? 0 : 8);
        }
        RelativeLayout relativeLayout = this.avatarFrame;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(position == 2 ? 0 : 8);
        }
        if (this.hideSkill) {
            LottieAnimationView lottieAnimationView = this.skillLottie;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(8);
            }
        } else {
            LottieAnimationView lottieAnimationView2 = this.skillLottie;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setVisibility(position != 3 ? 8 : 0);
            }
        }
        this.currentTab = position;
    }
}
