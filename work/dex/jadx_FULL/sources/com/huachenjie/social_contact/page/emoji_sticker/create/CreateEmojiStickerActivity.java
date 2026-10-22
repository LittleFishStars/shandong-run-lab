package com.huachenjie.social_contact.page.emoji_sticker.create;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.util.media_picker.MediaPicker;
import com.huachenjie.common.util.media_picker.MediaPickerLauncher;
import com.huachenjie.common.util.media_picker.MediaPickerListener;
import com.huachenjie.common.util.media_picker.MediaPickerResult;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.EmojiStickerAddBean;
import com.huachenjie.social_contact.bean.EmojiStickerFileBean;
import com.huachenjie.social_contact.bean.EmojiStickerImageBean;
import com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerActivity;
import com.huachenjie.social_contact.page.emoji_sticker.dialog.LoadingTipDialog;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import com.zj.adlib.o03;
import com.zj.adlib.pf6;
import com.zj.adlib.u66;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010!\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "", "tip", "z0", "o0", "t0", "m0", "n0", "", "position", "w0", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerLauncher;", "picker", "K", "I", "pickInsertPosition", "Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/LoadingTipDialog;", "Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/LoadingTipDialog;", "q0", "()Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/LoadingTipDialog;", "y0", "(Lcom/huachenjie/social_contact/page/emoji_sticker/dialog/LoadingTipDialog;)V", "loading", "x", "Ljava/lang/String;", bo.g, "()Ljava/lang/String;", "x0", "(Ljava/lang/String;)V", "emojiStickerCode", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class CreateEmojiStickerActivity extends BaseVmActivity<CreateEmojiStickerVM> {

    @NotNull
    public static final String y = "emojiStickerCode";

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pickInsertPosition;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public MediaPickerLauncher picker;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public LoadingTipDialog loading;

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @NotNull
    public String emojiStickerCode = "";

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerActivity$b", "Lcom/huachenjie/common/util/media_picker/MediaPickerListener;", "", "a", "Lcom/huachenjie/common/util/media_picker/MediaPickerResult;", "result", "b", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nCreateEmojiStickerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateEmojiStickerActivity.kt\ncom/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerActivity$init$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,292:1\n1549#2:293\n1620#2,3:294\n*S KotlinDebug\n*F\n+ 1 CreateEmojiStickerActivity.kt\ncom/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerActivity$init$1\n*L\n67#1:293\n67#1:294,3\n*E\n"})
    public static final class b implements MediaPickerListener {
        public b() {
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void a() {
            CreateEmojiStickerActivity.this.z0("正在处理中...");
        }

        @Override // com.huachenjie.common.util.media_picker.MediaPickerListener
        public void b(@NotNull MediaPickerResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            CreateEmojiStickerActivity.this.o0();
            if (!(result instanceof MediaPickerResult.Success)) {
                if ((result instanceof MediaPickerResult.a) || !(result instanceof MediaPickerResult.Error)) {
                    return;
                }
                fv5.b(((MediaPickerResult.Error) result).f());
                return;
            }
            MediaPickerResult.Success success = (MediaPickerResult.Success) result;
            if (success.g().isEmpty()) {
                return;
            }
            List<String> listG = success.g();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listG, 10));
            Iterator<T> it = listG.iterator();
            while (it.hasNext()) {
                arrayList.add(new EmojiStickerImageBean(null, (String) it.next(), null, true, 5, null));
            }
            CreateEmojiStickerAdapter<MultiItemEntity> value = ((CreateEmojiStickerVM) ((BaseVmActivity) CreateEmojiStickerActivity.this).f8507a).k().getValue();
            if (value != null) {
                CreateEmojiStickerActivity createEmojiStickerActivity = CreateEmojiStickerActivity.this;
                value.addData(createEmojiStickerActivity.pickInsertPosition, (Collection) arrayList);
                if (value.getData().size() > 16) {
                    value.removeAt(value.getData().size() - 1);
                }
                createEmojiStickerActivity.m0();
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36253a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36253a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36253a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36253a.invoke(obj);
        }
    }

    public static final void r0(CreateEmojiStickerAdapter createEmojiStickerAdapter, CreateEmojiStickerActivity createEmojiStickerActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(createEmojiStickerAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(createEmojiStickerActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (((MultiItemEntity) createEmojiStickerAdapter.getData().get(i)).getPostType() == 3) {
            createEmojiStickerActivity.w0(i);
        }
    }

    public static final void s0(CreateEmojiStickerActivity createEmojiStickerActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        CreateEmojiStickerAdapter<MultiItemEntity> value;
        List<T> data;
        MultiItemEntity multiItemEntity;
        Intrinsics.checkNotNullParameter(createEmojiStickerActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.iv_emoji_sticker_delete) {
            CreateEmojiStickerAdapter<MultiItemEntity> value2 = ((CreateEmojiStickerVM) ((BaseVmActivity) createEmojiStickerActivity).f8507a).k().getValue();
            if (value2 != null) {
                value2.removeAt(i);
            }
            if (baseQuickAdapter.getData().size() < 16) {
                CreateEmojiStickerAdapter<MultiItemEntity> value3 = ((CreateEmojiStickerVM) ((BaseVmActivity) createEmojiStickerActivity).f8507a).k().getValue();
                boolean z = false;
                if (value3 != null && (data = value3.getData()) != 0 && (multiItemEntity = (MultiItemEntity) CollectionsKt.last(data)) != null && multiItemEntity.getPostType() == 3) {
                    z = true;
                }
                if (!z && (value = ((CreateEmojiStickerVM) ((BaseVmActivity) createEmojiStickerActivity).f8507a).k().getValue()) != null) {
                    value.addData(baseQuickAdapter.getData().size(), new EmojiStickerAddBean());
                }
            }
            createEmojiStickerActivity.m0();
        }
    }

    public static final void u0(CreateEmojiStickerActivity createEmojiStickerActivity, View view) {
        Intrinsics.checkNotNullParameter(createEmojiStickerActivity, "this$0");
        createEmojiStickerActivity.finish();
    }

    public static final void v0(CreateEmojiStickerActivity createEmojiStickerActivity, View view) {
        Intrinsics.checkNotNullParameter(createEmojiStickerActivity, "this$0");
        createEmojiStickerActivity.n0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_emoji_sticker_create), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra("emojiStickerCode") : null;
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.emojiStickerCode = stringExtra;
        this.picker = MediaPicker.w(this, new b());
        t0();
        final CreateEmojiStickerAdapter<MultiItemEntity> value = ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).k().getValue();
        if (value != null) {
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.hx1
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    CreateEmojiStickerActivity.r0(value, this, baseQuickAdapter, view, i);
                }
            });
            value.addChildClickViewIds(R.id.iv_emoji_sticker_delete);
            value.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.ix1
                @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    CreateEmojiStickerActivity.s0(this.f42461a, baseQuickAdapter, view, i);
                }
            });
        }
        if (!TextUtils.isEmpty(this.emojiStickerCode)) {
            ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).l(this.emojiStickerCode);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EmojiStickerAddBean());
        CreateEmojiStickerAdapter<MultiItemEntity> value2 = ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).k().getValue();
        if (value2 != null) {
            value2.setList(arrayList);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).n().observe(this, new c(new Function1<String, Unit>() { // from class: com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                CreateEmojiStickerActivity.this.m0();
            }
        }));
        ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).q().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerActivity.initViewModel.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                CreateEmojiStickerActivity.this.o0();
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    o03 o03Var = o03.f43639a;
                    Context context = CreateEmojiStickerActivity.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    o03Var.d(context, CreateEmojiStickerActivity.this.getEmojiStickerCode());
                    CreateEmojiStickerActivity.this.finish();
                }
            }
        }));
        ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).p().observe(this, new c(new Function1<List<? extends EmojiStickerImageBean>, Unit>() { // from class: com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerActivity.initViewModel.3

            /* JADX INFO: renamed from: com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerActivity$initViewModel$3$a */
            @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\f"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerActivity$initViewModel$3$a", "Lcom/huachenjie/common/aliyun/file_upload/MultipleUploadCallback;", "", "position", "", "filePath", "", "b", "", "Lcom/zj/adlib/pf6;", "fileInfoList", "c", "social_contact_release"}, k = 1, mv = {1, 8, 0})
            public static final class a implements MultipleUploadCallback {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CreateEmojiStickerActivity f36254a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ List<EmojiStickerFileBean> f13063a;

                public a(CreateEmojiStickerActivity createEmojiStickerActivity, List<EmojiStickerFileBean> list) {
                    this.f36254a = createEmojiStickerActivity;
                    this.f13063a = list;
                }

                @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
                public void b(int position, @Nullable String filePath) {
                    this.f36254a.z0("正在上传第" + (position + 1) + "张表情");
                }

                @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
                public void c(@NotNull List<pf6> fileInfoList) {
                    Intrinsics.checkNotNullParameter(fileInfoList, "fileInfoList");
                    if (fileInfoList.size() == 0) {
                        this.f36254a.o0();
                        return;
                    }
                    for (pf6 pf6Var : fileInfoList) {
                        List<EmojiStickerFileBean> list = this.f13063a;
                        String strE = pf6Var.e();
                        String str = "";
                        if (strE == null) {
                            strE = "";
                        }
                        String strD = pf6Var.d();
                        if (strD != null) {
                            str = strD;
                        }
                        list.add(new EmojiStickerFileBean(strE, str));
                    }
                    ((CreateEmojiStickerVM) ((BaseVmActivity) this.f36254a).f8507a).h(this.f13063a);
                }
            }

            /* JADX INFO: renamed from: com.huachenjie.social_contact.page.emoji_sticker.create.CreateEmojiStickerActivity$initViewModel$3$b */
            @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016¨\u0006\f"}, d2 = {"com/huachenjie/social_contact/page/emoji_sticker/create/CreateEmojiStickerActivity$initViewModel$3$b", "Lcom/huachenjie/common/aliyun/file_upload/MultipleUploadCallback;", "", "position", "", "filePath", "", "b", "", "Lcom/zj/adlib/pf6;", "fileInfoList", "c", "social_contact_release"}, k = 1, mv = {1, 8, 0})
            public static final class b implements MultipleUploadCallback {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ CreateEmojiStickerActivity f36255a;

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ List<EmojiStickerFileBean> f13064a;

                public b(CreateEmojiStickerActivity createEmojiStickerActivity, List<EmojiStickerFileBean> list) {
                    this.f36255a = createEmojiStickerActivity;
                    this.f13064a = list;
                }

                @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
                public void b(int position, @Nullable String filePath) {
                    this.f36255a.z0("正在上传第" + (this.f13064a.size() + position + 1) + "张表情");
                }

                @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
                public void c(@Nullable List<pf6> fileInfoList) {
                    if (fileInfoList != null && fileInfoList.size() > 0) {
                        for (pf6 pf6Var : fileInfoList) {
                            List<EmojiStickerFileBean> list = this.f13064a;
                            String strE = pf6Var.e();
                            String str = "";
                            if (strE == null) {
                                strE = "";
                            }
                            String strD = pf6Var.d();
                            if (strD != null) {
                                str = strD;
                            }
                            list.add(new EmojiStickerFileBean(strE, str));
                        }
                    }
                    ((CreateEmojiStickerVM) ((BaseVmActivity) this.f36255a).f8507a).t(this.f36255a.getEmojiStickerCode(), this.f13064a);
                }
            }

            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<EmojiStickerImageBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<EmojiStickerImageBean> list) {
                if (list == null || list.isEmpty()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                if (TextUtils.isEmpty(CreateEmojiStickerActivity.this.getEmojiStickerCode())) {
                    CreateEmojiStickerActivity.this.z0("正在上传表情");
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<EmojiStickerImageBean> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next().getImgUrl());
                    }
                    u66.e(CreateEmojiStickerActivity.this.getContext(), UploadFileType.UPLOAD_EMOJI, arrayList2, new a(CreateEmojiStickerActivity.this, arrayList));
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                for (EmojiStickerImageBean emojiStickerImageBean : list) {
                    if (emojiStickerImageBean.isLocalFile()) {
                        arrayList3.add(emojiStickerImageBean.getImgUrl());
                    } else {
                        arrayList.add(new EmojiStickerFileBean(emojiStickerImageBean.getImgUrl(), emojiStickerImageBean.getFileMD5()));
                    }
                }
                CreateEmojiStickerActivity.this.z0("正在上传表情");
                u66.e(CreateEmojiStickerActivity.this.getContext(), UploadFileType.UPLOAD_EMOJI, arrayList3, new b(CreateEmojiStickerActivity.this, arrayList));
            }
        }));
    }

    public final void m0() {
        List<T> data;
        MutableLiveData<BindingTitleBean> mutableLiveDataO = ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).o();
        BindingTitleBean value = ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).o().getValue();
        if (value != null) {
            CreateEmojiStickerAdapter<MultiItemEntity> value2 = ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).k().getValue();
            value.setRightIconResId((((value2 == null || (data = value2.getData()) == 0) ? 0 : data.size()) <= 6 || TextUtils.isEmpty(((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).n().getValue())) ? R.drawable.ic_emoji_sticker_unfinish : R.drawable.ic_emoji_sticker_finish);
        } else {
            value = null;
        }
        mutableLiveDataO.setValue(value);
    }

    public final void n0() {
        List<T> data;
        if (TextUtils.isEmpty(((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).n().getValue())) {
            fv5.b("请输入表情包名称");
            return;
        }
        CreateEmojiStickerAdapter<MultiItemEntity> value = ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).k().getValue();
        if (((value == null || (data = value.getData()) == 0) ? 0 : data.size()) > 6) {
            ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).s();
        } else {
            fv5.b("请上传至少6张表情图");
        }
    }

    public final void o0() {
        LoadingTipDialog loadingTipDialog;
        LoadingTipDialog loadingTipDialog2 = this.loading;
        boolean z = false;
        if (loadingTipDialog2 != null && loadingTipDialog2.isShowing()) {
            z = true;
        }
        if (!z || (loadingTipDialog = this.loading) == null) {
            return;
        }
        loadingTipDialog.dismiss();
    }

    @NotNull
    /* JADX INFO: renamed from: p0, reason: from getter */
    public final String getEmojiStickerCode() {
        return this.emojiStickerCode;
    }

    @Nullable
    /* JADX INFO: renamed from: q0, reason: from getter */
    public final LoadingTipDialog getLoading() {
        return this.loading;
    }

    public final void t0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean rightIconClick = bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("创建表情包").setTitleTextColor(Color.parseColor("#FF2C3E50")).setBackground(Color.parseColor("#FFFFFF")).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(Color.parseColor("#FF2C3E50"))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.jx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateEmojiStickerActivity.u0(this.f42693a, view);
            }
        }).setShowRightIcon(true).setRightIconResId(R.drawable.ic_emoji_sticker_unfinish).setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.kx1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateEmojiStickerActivity.v0(this.f42936a, view);
            }
        });
        e.p3(this).G2(R.color.transparent).T2(true).x1("#FFFFFF").G1(true).a1();
        ((CreateEmojiStickerVM) ((BaseVmActivity) this).f8507a).o().setValue(rightIconClick);
    }

    public final void w0(int position) {
        this.pickInsertPosition = position;
        MediaPickerLauncher mediaPickerLauncher = this.picker;
        if (mediaPickerLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picker");
            mediaPickerLauncher = null;
        }
        MediaPickerLauncher.B(mediaPickerLauncher, 16 - position, 320, 0, true, 4, null);
    }

    public final void x0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.emojiStickerCode = str;
    }

    public final void y0(@Nullable LoadingTipDialog loadingTipDialog) {
        this.loading = loadingTipDialog;
    }

    public final void z0(@NotNull String tip) {
        LoadingTipDialog loadingTipDialog;
        Intrinsics.checkNotNullParameter(tip, "tip");
        if (this.loading == null) {
            this.loading = new LoadingTipDialog();
        }
        LoadingTipDialog loadingTipDialog2 = this.loading;
        if (loadingTipDialog2 != null) {
            loadingTipDialog2.setTip(tip);
        }
        LoadingTipDialog loadingTipDialog3 = this.loading;
        boolean z = false;
        if (loadingTipDialog3 != null && loadingTipDialog3.isShowing()) {
            z = true;
        }
        if (z || (loadingTipDialog = this.loading) == null) {
            return;
        }
        loadingTipDialog.show(getSupportFragmentManager(), "LoadingTipDialog");
    }
}
