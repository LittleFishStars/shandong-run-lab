package com.huachenjie.social_contact.page.emoji_sticker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.broadcast.emoji.EmojiStickerListener;
import com.huachenjie.base.broadcast.emoji.EmojiStickerReceiver;
import com.huachenjie.common.base.data_binding.BaseDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiPropBean;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.huachenjie.social_contact.databinding.ActivityEmojiStickerBinding;
import com.huachenjie.social_contact.dialog.share_emoji.ShareEmojiFriendDialog;
import com.huachenjie.social_contact.page.emoji_sticker.EmojiStickerActivity;
import com.huachenjie.social_contact.page.emoji_sticker.adapter.EmojiStickerAdapter;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerExplainDialog;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.EmojiStickerSuccessDialog;
import com.huachenjie.social_contact.page.emoji_sticker.mine.MineEmojiStickerActivity;
import com.huachenjie.social_contact.page.emoji_sticker.search.SearchEmojiStickerActivity;
import com.zj.adlib.bw9;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import com.zj.adlib.o03;
import com.zj.adlib.p03;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.j)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0005H\u0015J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\u0005H\u0014J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/EmojiStickerActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/page/emoji_sticker/EmojiStickerVM;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "onDestroy", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "onResume", "init", "", "dark", "v0", "initViewModel", "r0", "q0", "", "position", "w0", "", "", "a", "Ljava/util/Map;", "changeEmojiCodeMap", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerReceiver;", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerReceiver;", "mReceiver", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class EmojiStickerActivity extends BaseVmActivity<EmojiStickerVM> {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Map<String, Boolean> changeEmojiCodeMap = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final EmojiStickerReceiver mReceiver = new EmojiStickerReceiver(new b());

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/EmojiStickerActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/social_contact/page/emoji_sticker/EmojiStickerActivity;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            EmojiStickerActivity.this.startActivity(new Intent(EmojiStickerActivity.this.getContext(), (Class<?>) MineEmojiStickerActivity.class));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/EmojiStickerActivity$b", "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerListener;", "", "emojiStickerCode", "", "c", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements EmojiStickerListener {
        public b() {
        }

        @Override // com.huachenjie.base.broadcast.emoji.EmojiStickerListener
        public void b(@NotNull String emojiStickerCode) {
            Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
            i4a.a("onReceiveEmojiDownload:" + emojiStickerCode);
            EmojiStickerActivity.this.changeEmojiCodeMap.put(emojiStickerCode, Boolean.TRUE);
        }

        @Override // com.huachenjie.base.broadcast.emoji.EmojiStickerListener
        public void c(@NotNull String emojiStickerCode) {
            Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
            i4a.a("onReceiveEmojiDelete:" + emojiStickerCode);
            EmojiStickerActivity.this.changeEmojiCodeMap.put(emojiStickerCode, Boolean.FALSE);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36235a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36235a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36235a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36235a.invoke(obj);
        }
    }

    public static final void o0(EmojiStickerAdapter emojiStickerAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MultiItemEntity multiItemEntity;
        Intrinsics.checkNotNullParameter(emojiStickerAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (((MultiItemEntity) emojiStickerAdapter.getData().get(i)).getPostType() == 2 && (multiItemEntity = (MultiItemEntity) emojiStickerAdapter.getData().get(i)) != null && (multiItemEntity instanceof EmojiStickerBean)) {
            p03.f43868a.a(emojiStickerAdapter.getContext(), (EmojiStickerBean) multiItemEntity, 2);
        }
    }

    public static final void p0(EmojiStickerAdapter emojiStickerAdapter, EmojiStickerActivity emojiStickerActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MultiItemEntity multiItemEntity;
        Intrinsics.checkNotNullParameter(emojiStickerAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(emojiStickerActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (((MultiItemEntity) emojiStickerAdapter.getData().get(i)).getPostType() == 2 && (multiItemEntity = (MultiItemEntity) emojiStickerAdapter.getData().get(i)) != null && (multiItemEntity instanceof EmojiStickerBean)) {
            if (view.getId() == R.id.v_bottom_first) {
                EmojiStickerBean emojiStickerBean = (EmojiStickerBean) multiItemEntity;
                if (emojiStickerBean.getItemStatusType() == 4) {
                    ((EmojiStickerVM) ((BaseVmActivity) emojiStickerActivity).f8507a).k(emojiStickerBean, i);
                    return;
                }
            }
            if (view.getId() == R.id.v_bottom_second) {
                EmojiStickerBean emojiStickerBean2 = (EmojiStickerBean) multiItemEntity;
                ShareEmojiFriendDialog.INSTANCE.a(emojiStickerBean2.getEmojiBagCode(), emojiStickerBean2.getEmojiBagName(), emojiStickerBean2.formatEmojiUrl(0)).show(emojiStickerActivity.getSupportFragmentManager(), "LabelSelectDialog");
            }
        }
    }

    public static final void s0(EmojiStickerActivity emojiStickerActivity, View view) {
        Intrinsics.checkNotNullParameter(emojiStickerActivity, "this$0");
        emojiStickerActivity.finish();
    }

    public static final void t0(EmojiStickerActivity emojiStickerActivity, View view) {
        Intrinsics.checkNotNullParameter(emojiStickerActivity, "this$0");
        EmojiStickerExplainDialog.INSTANCE.a().show(emojiStickerActivity.getSupportFragmentManager(), "EmojiStickerExplainDialog");
    }

    public static final void u0(EmojiStickerActivity emojiStickerActivity, View view) {
        Intrinsics.checkNotNullParameter(emojiStickerActivity, "this$0");
        emojiStickerActivity.startActivity(new Intent(emojiStickerActivity.getContext(), (Class<?>) SearchEmojiStickerActivity.class));
    }

    public static final void x0(EmojiStickerActivity emojiStickerActivity, int i) {
        Intrinsics.checkNotNullParameter(emojiStickerActivity, "this$0");
        emojiStickerActivity.w0(i + 1);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_emoji_sticker), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        ((EmojiStickerVM) ((BaseVmActivity) this).f8507a).n();
        r0();
        q0();
        final EmojiStickerAdapter<MultiItemEntity> value = ((EmojiStickerVM) ((BaseVmActivity) this).f8507a).m().getValue();
        if (value != null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_emoji_sticker_header, (ViewGroup) null, false);
            value.setHeaderWithEmptyEnable(true);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "headerView");
            BaseQuickAdapter.setHeaderView$default(value, viewInflate, 0, 0, 6, null);
            ((EmojiStickerVM) ((BaseVmActivity) this).f8507a).u();
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.i03
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    EmojiStickerActivity.o0(value, baseQuickAdapter, view, i);
                }
            });
            value.addChildClickViewIds(R.id.v_bottom_first, R.id.v_bottom_second);
            value.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.j03
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    EmojiStickerActivity.p0(value, this, baseQuickAdapter, view, i);
                }
            });
        }
        ActivityEmojiStickerBinding activityEmojiStickerBinding = (ActivityEmojiStickerBinding) getBinding();
        if (activityEmojiStickerBinding != null) {
            bw9 bw9Var = bw9.f40853a;
            RecyclerView recyclerView = activityEmojiStickerBinding.f12686a;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "emojiStickerRecycler");
            bw9Var.d(recyclerView);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((EmojiStickerVM) ((BaseVmActivity) this).f8507a).o().observe(this, new c(new Function1<List<? extends EmojiPropBean>, Unit>() { // from class: com.huachenjie.social_contact.page.emoji_sticker.EmojiStickerActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<EmojiPropBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<EmojiPropBean> list) {
                if (list != null) {
                    EmojiStickerActivity.this.w0(0);
                }
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        o03.f43639a.a(this, this.mReceiver);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        o03.f43639a.e(this, this.mReceiver);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"NotifyDataSetChanged"})
    public void onResume() {
        super.onResume();
        if (((EmojiStickerVM) ((BaseVmActivity) this).f8507a).m().getValue() == null) {
            if (((EmojiStickerVM) ((BaseVmActivity) this).f8507a).m().getValue() == null) {
                i4a.a("adapter is null ");
                return;
            }
            EmojiStickerAdapter<MultiItemEntity> value = ((EmojiStickerVM) ((BaseVmActivity) this).f8507a).m().getValue();
            if ((value != null ? value.getData() : null) == null) {
                i4a.a("adapter data is null ");
                return;
            }
        }
        EmojiStickerAdapter<MultiItemEntity> value2 = ((EmojiStickerVM) ((BaseVmActivity) this).f8507a).m().getValue();
        if (value2 != null) {
            if (this.changeEmojiCodeMap.isEmpty()) {
                i4a.a("changeEmojiCodeMap data is null ");
                return;
            }
            for (T t : value2.getData()) {
                if (t instanceof EmojiStickerBean) {
                    EmojiStickerBean emojiStickerBean = (EmojiStickerBean) t;
                    Boolean bool = this.changeEmojiCodeMap.get(emojiStickerBean.getEmojiBagCode());
                    if (bool != null) {
                        emojiStickerBean.setDownloadFlag(bool.booleanValue());
                        if (emojiStickerBean.getDownloadFlag()) {
                            emojiStickerBean.setItemStatusType(5);
                        } else {
                            emojiStickerBean.setItemStatusType(4);
                        }
                    }
                }
            }
            this.changeEmojiCodeMap.clear();
            value2.notifyDataSetChanged();
        }
    }

    public final void q0() {
        final View viewFindViewById = findViewById(R.id.cl_title);
        ActivityEmojiStickerBinding activityEmojiStickerBinding = (ActivityEmojiStickerBinding) getBinding();
        if (activityEmojiStickerBinding != null) {
            activityEmojiStickerBinding.f12686a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.social_contact.page.emoji_sticker.EmojiStickerActivity$initScroll$1$1

                /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
                public int offsetY;

                /* JADX INFO: renamed from: a, reason: from getter */
                public final int getOffsetY() {
                    return this.offsetY;
                }

                public final void b(int i) {
                    this.offsetY = i;
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    this.offsetY += dy;
                    View view = viewFindViewById;
                    EmojiStickerActivity emojiStickerActivity = this;
                    if (view.getHeight() == 0) {
                        return;
                    }
                    float height = this.offsetY / view.getHeight();
                    if (height < 0.0f) {
                        height = 0.0f;
                    }
                    if (height > 1.0f) {
                        height = 1.0f;
                    }
                    MutableLiveData<BindingTitleBean> mutableLiveDataQ = ((EmojiStickerVM) ((BaseVmActivity) ((BaseVmActivity) emojiStickerActivity)).f8507a).q();
                    BindingTitleBean value = ((EmojiStickerVM) ((BaseVmActivity) ((BaseVmActivity) emojiStickerActivity)).f8507a).q().getValue();
                    if (value != null) {
                        float f = 255;
                        value.setBackground(Color.argb((int) (height * f), 255, 255, 255));
                        int i = (int) ((1.0f - height) * f);
                        int iArgb = Color.argb(255, i, i, i);
                        value.setTitleTextColor(iArgb);
                        value.setBackTintColor(Integer.valueOf(iArgb));
                        value.setRightIconTintColor(Integer.valueOf(iArgb));
                        value.setRightSubIconTintColor(Integer.valueOf(iArgb));
                    } else {
                        value = null;
                    }
                    mutableLiveDataQ.setValue(value);
                    emojiStickerActivity.v0(((double) height) >= 0.5d);
                }
            });
        }
    }

    public final void r0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((EmojiStickerVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean rightIconClick = bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("表情包宿舍").setTitleTextColor(Color.parseColor("#FFFFFF")).setBackTintColor(Integer.valueOf(Color.parseColor("#FFFFFF"))).setBackground(Color.parseColor("#00000000")).setBackIconResId(R.drawable.ic_back_white).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.f03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmojiStickerActivity.s0(this.f41561a, view);
            }
        }).setShowRightIcon(true).setRightSubIconResId(R.drawable.ic_emoji_sticker_help).setRightSubIconClick(new View.OnClickListener() { // from class: com.zj.adlib.g03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmojiStickerActivity.t0(this.f41787a, view);
            }
        }).setShowRightSubIcon(true).setRightIconResId(R.drawable.ic_emoji_sticker_search).setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.h03
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmojiStickerActivity.u0(this.f42021a, view);
            }
        });
        v0(false);
        ((EmojiStickerVM) ((BaseVmActivity) this).f8507a).q().setValue(rightIconClick);
    }

    public final void v0(boolean dark) {
        e.p3(this).G2(R.color.transparent).T2(dark).x1("#FFFFFF").G1(true).a1();
    }

    public final void w0(final int position) {
        List<EmojiPropBean> value;
        EmojiPropBean emojiPropBean;
        List<EmojiPropBean> value2 = ((EmojiStickerVM) ((BaseVmActivity) this).f8507a).o().getValue();
        if (position >= (value2 != null ? value2.size() : 0) || (value = ((EmojiStickerVM) ((BaseVmActivity) this).f8507a).o().getValue()) == null || (emojiPropBean = value.get(position)) == null) {
            return;
        }
        EmojiStickerSuccessDialog emojiStickerSuccessDialogA = EmojiStickerSuccessDialog.INSTANCE.a(emojiPropBean);
        emojiStickerSuccessDialogA.setFragmentDialogDismissCallback(new BaseDialogFragment.FragmentDialogDismissCallback() { // from class: com.zj.adlib.k03
            @Override // com.huachenjie.common.base.data_binding.BaseDialogFragment.FragmentDialogDismissCallback
            public final void onDismiss() {
                EmojiStickerActivity.x0(this.f17535a, position);
            }
        });
        emojiStickerSuccessDialogA.show(getSupportFragmentManager(), "EmojiStickerSuccessDialog-" + position);
    }
}
