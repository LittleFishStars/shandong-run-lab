package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mdc implements ValueEncoderContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FieldDescriptor f43277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final bdc f18178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18179a = false;
    public boolean b = false;

    public mdc(bdc bdcVar) {
        this.f18178a = bdcVar;
    }

    public final void a(FieldDescriptor fieldDescriptor, boolean z) {
        this.f18179a = false;
        this.f43277a = fieldDescriptor;
        this.b = z;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(double d) throws IOException {
        b();
        this.f18178a.a(this.f43277a, d, this.b);
        return this;
    }

    public final void b() {
        if (this.f18179a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f18179a = true;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(float f) throws IOException {
        b();
        this.f18178a.b(this.f43277a, f, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(int i) throws IOException {
        b();
        this.f18178a.d(this.f43277a, i, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(long j) throws IOException {
        b();
        this.f18178a.e(this.f43277a, j, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(@Nullable String str) throws IOException {
        b();
        this.f18178a.c(this.f43277a, str, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(boolean z) throws IOException {
        b();
        this.f18178a.d(this.f43277a, z ? 1 : 0, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(@NonNull byte[] bArr) throws IOException {
        b();
        this.f18178a.c(this.f43277a, bArr, this.b);
        return this;
    }
}
