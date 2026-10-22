package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class aqc implements ValueEncoderContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FieldDescriptor f40590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mpc f15341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15342a = false;
    public boolean b = false;

    public aqc(mpc mpcVar) {
        this.f15341a = mpcVar;
    }

    public final void a(FieldDescriptor fieldDescriptor, boolean z) {
        this.f15342a = false;
        this.f40590a = fieldDescriptor;
        this.b = z;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(double d) throws IOException {
        b();
        this.f15341a.a(this.f40590a, d, this.b);
        return this;
    }

    public final void b() {
        if (this.f15342a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f15342a = true;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(float f) throws IOException {
        b();
        this.f15341a.b(this.f40590a, f, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(int i) throws IOException {
        b();
        this.f15341a.d(this.f40590a, i, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(long j) throws IOException {
        b();
        this.f15341a.e(this.f40590a, j, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(@Nullable String str) throws IOException {
        b();
        this.f15341a.c(this.f40590a, str, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(boolean z) throws IOException {
        b();
        this.f15341a.d(this.f40590a, z ? 1 : 0, this.b);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public final ValueEncoderContext add(@NonNull byte[] bArr) throws IOException {
        b();
        this.f15341a.c(this.f40590a, bArr, this.b);
        return this;
    }
}
