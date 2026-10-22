
/* WARNING: Globals starting with '_' overlap smaller symbols at the same address */

void FUN_000a3460(undefined1 param_1 [16],undefined1 param_2 [16],undefined8 param_3,
                 undefined8 param_4,long param_5)

{
  ulong uVar1;
  char cVar2;
  bool bVar3;
  bool bVar4;
  byte bVar5;
  byte bVar6;
  code *pcVar7;
  bool bVar8;
  undefined1 uVar9;
  char cVar10;
  int iVar11;
  uint uVar12;
  int iVar13;
  int iVar14;
  long *plVar15;
  long *plVar16;
  ulong uVar17;
  long lVar18;
  undefined8 uVar19;
  long *plVar20;
  undefined8 *puVar21;
  long lVar22;
  long *plVar23;
  undefined8 uVar24;
  undefined8 uVar25;
  undefined8 uVar26;
  undefined8 uVar27;
  undefined8 uVar28;
  long **pplVar29;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  code *pcVar30;
  undefined1 *puVar31;
  char *pcVar32;
  undefined1 extraout_w8;
  undefined2 extraout_w8_00;
  undefined4 extraout_w8_01;
  undefined4 extraout_w8_02;
  int extraout_w8_03;
  undefined4 extraout_w8_04;
  long extraout_x8;
  code *extraout_x8_00;
  long *extraout_x8_01;
  long extraout_x8_02;
  long extraout_x8_03;
  long extraout_x8_04;
  long extraout_x8_05;
  long extraout_x8_06;
  undefined8 extraout_x8_07;
  undefined8 extraout_x8_08;
  long extraout_x8_09;
  code *extraout_x8_10;
  code *extraout_x8_11;
  code *extraout_x8_12;
  ulong extraout_x8_13;
  code *extraout_x8_14;
  code *extraout_x8_15;
  code *extraout_x8_16;
  code *extraout_x8_17;
  long extraout_x8_18;
  long extraout_x8_19;
  undefined8 extraout_x8_20;
  long extraout_x8_21;
  ulong extraout_x8_22;
  long extraout_x8_23;
  long extraout_x8_24;
  long extraout_x8_25;
  long extraout_x8_26;
  long extraout_x8_27;
  long extraout_x8_28;
  long extraout_x8_29;
  undefined1 extraout_w9;
  undefined1 extraout_w9_00;
  undefined1 extraout_w9_01;
  undefined1 extraout_w9_02;
  undefined1 extraout_w9_03;
  undefined2 extraout_w9_04;
  undefined8 extraout_x9;
  ulong extraout_x9_00;
  undefined8 extraout_x9_01;
  ulong extraout_x9_02;
  long *extraout_x9_03;
  undefined8 extraout_x9_04;
  undefined8 extraout_x9_05;
  ulong extraout_x9_06;
  undefined1 extraout_w10;
  undefined1 extraout_w10_00;
  ulong extraout_x10;
  ulong extraout_x10_00;
  undefined8 extraout_x10_01;
  ulong extraout_x10_02;
  undefined8 extraout_x10_03;
  ulong extraout_x10_04;
  undefined8 extraout_x10_05;
  ulong extraout_x10_06;
  ulong extraout_x10_07;
  undefined2 extraout_w11;
  undefined4 extraout_w11_00;
  long extraout_x11;
  ulong extraout_x11_00;
  ulong extraout_x11_01;
  ulong extraout_x11_02;
  ulong extraout_x11_03;
  undefined8 *extraout_x11_04;
  ulong extraout_x12;
  undefined8 extraout_x12_00;
  undefined8 extraout_x12_01;
  undefined8 extraout_x12_02;
  undefined8 extraout_x12_03;
  ulong extraout_x12_04;
  undefined8 extraout_x13;
  undefined8 extraout_x13_00;
  undefined8 extraout_x13_01;
  undefined8 extraout_x13_02;
  ulong uVar33;
  undefined4 uVar34;
  long lVar35;
  long lVar36;
  uint uVar37;
  long unaff_x29;
  undefined1 auVar38 [16];
  undefined1 auVar39 [16];
  undefined1 auVar40 [16];
  undefined4 local_2a4;
  long *local_2a0;
  undefined1 uStack_298;
  undefined1 uStack_297;
  undefined4 uStack_296;
  undefined2 uStack_292;
  undefined1 uStack_290;
  undefined1 uStack_28f;
  undefined4 uStack_28e;
  undefined2 uStack_28a;
  undefined1 uStack_288;
  undefined4 uStack_287;
  undefined1 uStack_283;
  undefined2 uStack_282;
  undefined5 uStack_280;
  undefined3 uStack_27b;
  undefined5 uStack_278;
  undefined1 local_190 [16];
  undefined4 local_180;
  undefined4 uStack_17c;
  undefined8 local_110;
  undefined8 uStack_108;
  undefined1 local_100;
  undefined7 uStack_ff;
  undefined8 local_f0;
  undefined7 uStack_e8;
  undefined1 uStack_e1;
  undefined7 uStack_e0;
  long *local_d0;
  undefined7 uStack_c8;
  undefined1 uStack_c1;
  undefined7 uStack_c0;
  undefined1 local_b0 [24];
  undefined8 local_98;
  long *local_90;
  long *local_88;
  long *local_80;
  long *plStack_78;
  code *local_70;
  long local_68;
  
  uVar27 = param_2._8_8_;
  uVar28 = param_2._0_8_;
  FUN_000cff2c();
  auVar38 = FUN_000d69b8();
  plVar15 = auVar38._0_8_;
  local_68 = extraout_x8;
  if (DAT_000e94a1 != '\0') {
    uVar34 = 1;
    goto LAB_000a55c8;
  }
  iVar11 = FUN_000b02c8();
  if (iVar11 < 0x13) {
    bVar3 = false;
  }
  else if (iVar11 < 0x18) {
    FUN_000ae7bc(&local_2a0,&DAT_0001e2f6);
    iVar11 = FUN_000d6a1c((ulong)local_2a0 & 0xff);
    FUN_000d0254();
    if (iVar11 == 0) {
      _DAT_000e84e0 = 3;
    }
    else {
      FUN_000ae7bc(&local_2a0,&DAT_0001e314);
      FUN_000d2c58();
      iVar11 = FUN_000d6a1c();
      FUN_000d0254();
      if (iVar11 == 0) {
        _DAT_000e84e0 = 4;
        goto LAB_000a34b8;
      }
    }
    FUN_000ae7bc(&local_2a0,&DAT_0001e2bd);
    lVar18 = FUN_000d2794((ulong)local_2a0 & 0xff);
    uVar19 = FUN_000d0254();
    for (; lVar18 != 0; lVar18 = *(long *)(lVar18 + 0xb0)) {
      uVar19 = FUN_000d0cd4(_DAT_000e8a38,lVar18);
      if (8 < (int)uVar19) {
        FUN_000ae7bc(lVar18 + (int)uVar19,&local_2a0,&DAT_0001e2c6);
        iVar11 = FUN_000d45d4();
        FUN_000d0254();
        if (iVar11 == 0) {
          bVar5 = 0;
          _DAT_000e84e0 = 2;
          bVar6 = 1;
        }
        else {
          FUN_000ae7bc(&local_2a0,&DAT_0001e2d0);
          iVar11 = FUN_000d45d4();
          FUN_000d0254();
          if (iVar11 == 0) {
            bVar6 = 0;
            bVar5 = 0;
            _DAT_000e84e0 = 1;
          }
          else {
            FUN_000ae7bc(&local_2a0,&DAT_0001e2da);
            lVar36 = FUN_000d45ec();
            FUN_000d0254();
            if (lVar36 == 0) {
              FUN_000ae7bc(&local_2a0,&DAT_0001e2ec);
              lVar36 = FUN_000d45ec();
              uVar19 = FUN_000d0254();
              if (lVar36 == 0) goto LAB_000a3644;
              bVar6 = 0;
              _DAT_000e84e0 = 4;
              bVar5 = 1;
            }
            else {
              bVar6 = 0;
              bVar5 = 0;
              _DAT_000e84e0 = 3;
            }
          }
        }
        bVar3 = (bool)(bVar6 | bVar5);
        goto LAB_000a3700;
      }
LAB_000a3644:
    }
    FUN_000d74a4(uVar19,&DAT_0001e2d0);
    FUN_000ae7bc();
    lVar18 = FUN_000d2794((ulong)local_2a0 & 0xff);
    FUN_000d0254();
    FUN_000ae7bc(&local_2a0,&DAT_0001e2c6);
    FUN_000d2c58();
    lVar36 = FUN_000d2794();
    FUN_000d0254();
    _DAT_000e84e0 = 0;
    bVar3 = lVar18 == 0 && lVar36 != 0;
  }
  else {
LAB_000a34b8:
    bVar3 = true;
  }
LAB_000a3700:
  FUN_000a9a08();
  FUN_000d1b8c();
  FUN_000d8608();
  plVar16 = (long *)FUN_000a9a08();
  uVar17 = (**(code **)(*plVar16 + 0x88))();
  FUN_0008ef78(&local_2a0);
  if ((uVar17 & 1) != 0) {
    cVar10 = *(char *)(param_5 + 0xd5);
    cVar2 = *(char *)(param_5 + 0xcb);
    iVar11 = FUN_000b02c8();
    uVar17 = FUN_000d4ec4(0xe9050,&DAT_00015000);
    if ((uVar17 & 1) == 0) {
      FUN_000d4488();
      auVar40 = FUN_000d1714(*plVar15,plVar15,s_android_os_Build_VERSION_00014956);
      if (auVar40._0_8_ != 0) {
        auVar39 = FUN_000d3314(*(undefined8 *)(*plVar15 + 0x480),plVar15,auVar40._8_8_,
                               s_RELEASE_0001618a,s_Ljava_lang_String__00015a0b);
        lVar18 = auVar39._0_8_;
        if (lVar18 == 0) {
          FUN_000d5314();
        }
        else {
          FUN_000d33f4(*(undefined8 *)(*plVar15 + 0x488),lVar18,auVar39._8_8_,lVar18);
          uVar19 = (*extraout_x8_00)();
          FUN_000d0fbc(local_190,plVar15,uVar19);
          FUN_000d508c(&local_2a0);
          FUN_000d0268();
          FUN_000cfb64(*plVar15,plVar15,uVar19);
        }
        FUN_000cfb64(*plVar15,plVar15,auVar40._0_8_);
      }
      FUN_0004ec04(0xe9050,&local_2a0);
      plStack_78 = (long *)CONCAT26(uStack_292,CONCAT42(uStack_296,CONCAT11(uStack_297,uStack_298)))
      ;
      local_70 = (code *)CONCAT26(uStack_28a,CONCAT42(uStack_28e,CONCAT11(uStack_28f,uStack_290)));
      local_80 = local_2a0;
      FUN_0006f178(&local_2a0);
      FUN_000d0254();
    }
    else {
      FUN_0004e08c(&local_80,0xe9050);
    }
    if ((iVar11 < 0x13) || (cVar10 == '\0')) {
LAB_000a38c8:
      if (iVar11 < 0x1a) goto LAB_000a3940;
    }
    else {
      FUN_000d15cc();
      local_190._0_8_ = extraout_x8_01;
      if (0x18 < iVar11) {
        FUN_00076d64(local_190,&local_98);
        FUN_000d5fd4();
        FUN_000d7a4c((ulong)local_2a0 & 0xff);
        FUN_000d4fc0();
        local_98._0_7_ = CONCAT43(extraout_w11_00,(undefined3)local_98);
        FUN_000718bc();
        FUN_000d57b8(local_190);
        lVar18 = FUN_000d3108();
        FUN_000d0268();
        FUN_000d0254();
        if (lVar18 != 0) {
          FUN_0006ab20(lVar18,0x91da8,&DAT_000e8978);
        }
        goto LAB_000a38c8;
      }
      FUN_00076d64(local_190,&local_98);
      FUN_000d5fd4();
      FUN_000d7a58((ulong)local_2a0 & 0xff);
      FUN_000d4fc0();
      local_98._0_6_ = CONCAT24(extraout_w11,(undefined4)local_98);
      FUN_000721ec();
      FUN_000d57b8(local_190);
      lVar18 = FUN_000d3108();
      FUN_000d0268();
      FUN_000d0254();
      if (lVar18 != 0) {
        FUN_0006ab20(lVar18,0x91d6c,&DAT_000e8970);
      }
LAB_000a3940:
      lVar18 = FUN_000d178c(&local_80,&DAT_000155a5);
      if ((!(bool)(iVar11 < 0x15 & (bVar3 ^ 1U))) && (lVar18 == -1)) {
        if ((iVar11 != 0x13) && (cVar10 == '\0')) {
          FUN_0006e06c(&local_2a0,&DAT_00013a90);
          iVar14 = FUN_00070dc8(&local_80,&local_2a0);
          if ((iVar11 < 0x19) || (iVar14 == 0)) {
            pcVar32 = s_execv_000138ef;
            uVar19 = 0x91d6c;
            puVar31 = &DAT_000e8970;
          }
          else {
            pcVar32 = s_execve_00014450;
            uVar19 = 0x91da8;
            puVar31 = &DAT_000e8978;
          }
          FUN_0006c20c(s____libart__so__00013a94,pcVar32,uVar19,puVar31);
          FUN_000d0254();
        }
        if (cVar2 != '\0') {
          FUN_000d770c();
          FUN_0004e08c();
          if ((iVar11 < 0x18) &&
             ((iVar11 != 0x17 || (lVar18 = FUN_000d178c(local_190,&DAT_00013a8e), lVar18 == -1)))) {
            FUN_000b0728(&local_2a0);
            uVar19 = FUN_000d8cb0(s_libart_so_0001490f,2);
            plVar16 = (long *)FUN_000d8cc0(uVar19,s__ZN3art7Runtime9instance_E_000156e7);
            if (plVar16 != (long *)0x0) {
              lVar18 = FUN_000d178c(&local_2a0,&DAT_000155a7);
              if (lVar18 == -1) {
                if (iVar11 < 0x15) {
                  FUN_000d6a44();
                  *(undefined1 *)(extraout_x8_03 + 0x11f) = extraout_w9_00;
                  *(undefined1 *)(*plVar16 + 0x120) = extraout_w9_00;
                }
                else {
                  if ((iVar11 < 0x17) &&
                     (lVar18 = FUN_000d178c(local_190,&DAT_00014d2f), lVar18 == -1)) {
                    lVar36 = *plVar16;
                    lVar18 = 0;
                    do {
                      if (*(char *)(lVar36 + lVar18 + 0x2d0) == -0x60) {
                        if (*(char *)(lVar36 + lVar18 + 0x2d1) == '\0') goto LAB_000a5624;
                      }
                      else if (0x300 < (int)lVar18 + 1U) goto LAB_000a3b04;
                      lVar18 = lVar18 + 1;
                    } while( true );
                  }
                  FUN_000d6a44();
                  *(undefined1 *)(extraout_x8_06 + 0x1f2) = extraout_w9_03;
                  *(undefined1 *)(*plVar16 + 499) = extraout_w9_03;
                }
              }
              else if (iVar11 == 0x16) {
                FUN_000d6a44();
                *(undefined1 *)(extraout_x8_04 + 0x20b) = extraout_w9_01;
                *(undefined1 *)(*plVar16 + 0x20c) = extraout_w9_01;
              }
              else if (iVar11 == 0x15) {
                FUN_000d6a44();
                *(undefined1 *)(extraout_x8_02 + 0x203) = extraout_w9;
                *(undefined1 *)(*plVar16 + 0x204) = extraout_w9;
              }
              else if (0x16 < iVar11) {
                FUN_000d6a44();
                *(undefined1 *)(extraout_x8_05 + 0x1ea) = extraout_w9_02;
                *(undefined1 *)(*plVar16 + 0x1e1) = extraout_w9_02;
              }
            }
            goto LAB_000a3b04;
          }
          goto LAB_000a3b08;
        }
      }
    }
    goto LAB_000a3b0c;
  }
LAB_000a4d00:
  uVar34 = 1;
  goto LAB_000a4d04;
LAB_000a5624:
  uVar12 = 5;
  for (pcVar32 = (char *)(lVar36 + lVar18 + 0x2db); pcVar32[-6] == '\0'; pcVar32 = pcVar32 + 1) {
    uVar12 = uVar12 + 1;
  }
  uVar37 = uVar12 - 5;
  if (uVar37 < 6) {
    do {
      cVar10 = *pcVar32;
      uVar37 = uVar12 + 1;
      pcVar32 = pcVar32 + 1;
      uVar12 = uVar37;
    } while (cVar10 == '\0');
  }
  *(undefined2 *)(lVar36 + (int)uVar37 + lVar18 + 0x2c8) = 0x101;
LAB_000a3b04:
  FUN_000d0254();
LAB_000a3b08:
  FUN_000d0268();
LAB_000a3b0c:
  FUN_0004e170(&local_80);
  if (bVar3) {
    FUN_000a9a08();
    lVar18 = FUN_000d04c4();
    FUN_000a9a08();
    uVar19 = FUN_000d1b8c();
    FUN_0008ef04(&local_d0,uVar19);
    bVar8 = false;
    plVar16 = local_d0;
    while (plVar16 != (long *)CONCAT17(uStack_c1,uStack_c8)) {
      lVar36 = *plVar16;
      if ((lVar36 == 0) || ((int)plVar16[1] == 0)) goto LAB_000a41ec;
      uVar34 = *(undefined4 *)((long)plVar16 + 0xc);
      cVar10 = *(char *)(lVar18 + 0xdd);
      FUN_000a9a08();
      plVar20 = (long *)FUN_000d7cec();
      if ((_DAT_000e84d0 == 0) || (_DAT_000e84d4 == 0)) {
        uVar12 = FUN_000b02c8();
        iVar11 = FUN_00088764(plVar20,&DAT_000e84d4);
        _DAT_000e84d0 = CONCAT44(_DAT_000e84d4,iVar11);
        if (iVar11 == 0) {
          puVar21 = (undefined8 *)FUN_000a9a08();
          iVar11 = FUN_000d2328(*puVar21,puVar21,&DAT_000e84d4);
          _DAT_000e84d0 = CONCAT44(_DAT_000e84d4,iVar11);
          if (iVar11 == 0) {
            if (uVar12 - 0x1d < 5) {
              _DAT_000e84d0 = 0xc000000aa;
            }
            else if (0x21 < uVar12) {
              _DAT_000e84d0 = 0xd000000e6;
            }
          }
        }
      }
      if ((cVar10 != '\0') && (iVar11 = FUN_000b02c8(), 0x1b < iVar11)) goto LAB_000a41ec;
      lVar35 = *plVar20;
      bVar8 = lVar35 == 0;
      uVar9 = bVar8;
      FUN_000d87d0(&local_2a0,0,0x104);
      FUN_000afe6c(local_b0,plVar15,auVar38._8_8_);
      FUN_000971b8(local_190,&DAT_0001c589);
      FUN_000d6624(local_190._0_8_ & 0xff);
      uVar19 = extraout_x8_07;
      if (!(bool)uVar9) {
        uVar19 = extraout_x9;
      }
      uVar17 = (ulong)local_b0 | 1;
      if ((extraout_x10 & 1) != 0) {
        uVar17 = *(ulong *)(extraout_x11 + 0xf0);
      }
      FUN_000afa60(&local_2a0,0x104,uVar19,uVar17);
      FUN_000d0268();
      if ((_DAT_000e84d4 != 8) || (bVar8)) {
LAB_000a3cc0:
        uVar17 = _DAT_000e84d0;
        if (0x26 < _DAT_000e84d0 || bVar8) {
          if (_DAT_000e84d0 < 0x72) {
            iVar11 = FUN_000b02c8();
            if ((iVar11 < 0x18) &&
               (lVar22 = FUN_00096c3c(lVar36,&local_2a0,uVar17 & 0xffffffff), lVar22 != 0))
            goto LAB_000a3db4;
            FUN_000d673c();
            FUN_000971b8(&local_80,&DAT_0001cb37);
            FUN_000971b8(&local_98,&DAT_0001cbbd);
            FUN_000d1880();
            lVar22 = FUN_00096bb0();
LAB_000a3da4:
            FUN_000d2178();
            FUN_000d0a28();
            FUN_000d0268();
          }
          else {
            if (_DAT_000e84d0 < 0x8a) {
              FUN_000d673c();
              FUN_000971b8(&local_80,&DAT_0001ca17);
              FUN_000971b8(&local_98,&DAT_0001caa7);
              FUN_000d1880();
              lVar22 = FUN_00096df8();
              goto LAB_000a3da4;
            }
            if (_DAT_000e84d0 < 0xa6) {
              FUN_000d38c4();
              FUN_000d6724();
              FUN_000d6714();
              FUN_000d1880();
              lVar22 = FUN_00096e7c();
              goto LAB_000a3da4;
            }
            if (_DAT_000e84d0 < 0xe6) {
LAB_000a3eac:
              lVar22 = FUN_00097c88(lVar36,&local_2a0);
            }
            else {
              FUN_000d38c4();
              FUN_000971b8(&local_80,&DAT_0001c5a5);
              FUN_000971b8(&local_98,&DAT_0001c67e);
              FUN_000d1880();
              lVar22 = FUN_0009708c();
              FUN_000d2178();
              FUN_000d0a28();
              FUN_000d0268();
              if (lVar22 == 0) {
                FUN_000d38c4();
                FUN_000d6724();
                FUN_000d6714();
                FUN_000d1880();
                lVar22 = FUN_00097014();
                FUN_000d2178();
                FUN_000d0a28();
                FUN_000d0268();
                if (lVar22 == 0) {
                  iVar11 = FUN_000b02c8();
                  if (iVar11 == 0x21) goto LAB_000a3eac;
                  lVar22 = 0;
                }
              }
            }
          }
LAB_000a3db4:
          FUN_00098014(lVar36,uVar34,1);
          if (lVar22 != 0) goto LAB_000a3dec;
        }
        bVar4 = false;
        if ((lVar35 != 0) && (_DAT_000e84d4 < 9)) {
          lVar22 = FUN_000d41c0();
          if (lVar22 != 0) goto LAB_000a3dec;
          bVar4 = false;
        }
      }
      else {
        FUN_000a9a08();
        lVar22 = FUN_000d04c4();
        if ((*(char *)(lVar22 + 0xf3) != '\0') || (lVar22 = FUN_000d41c0(), lVar22 == 0))
        goto LAB_000a3cc0;
LAB_000a3dec:
        plVar20 = (long *)FUN_000d1714(*plVar15,plVar15,s_dalvik_system_DexPathList_Elemen_00013cde)
        ;
        local_190._0_8_ = plVar20;
        if (plVar20 == (long *)0x0) {
          lVar22 = 0;
        }
        else {
          plVar23 = (long *)FUN_00090168(plVar15,lVar22);
          local_80 = plVar23;
          if (plVar23 == (long *)0x0) {
            lVar22 = 0;
          }
          else {
            FUN_00090d9c(plVar15,local_190,&local_80);
            uVar19 = FUN_000d6908();
            FUN_000cfb64(uVar19,plVar23);
          }
          FUN_000cfb64(*plVar15,plVar15,plVar20);
        }
        plVar20 = (long *)FUN_000a9a08();
        (**(code **)(*plVar20 + 0x78))(plVar20,lVar22);
        bVar4 = true;
      }
      *plVar16 = lVar36;
      FUN_0004e170(local_b0);
      bVar8 = true;
      plVar16 = plVar16 + 2;
      if (!bVar4) goto LAB_000a41ec;
    }
    if (bVar8) goto LAB_000a45f8;
LAB_000a41ec:
    iVar11 = FUN_000b02c8();
    uVar19 = FUN_0004d9e0(0xa8);
    pcVar32 = s_libart_so_0001490f;
    if (0x1b < iVar11) {
      pcVar32 = s_libdexfile_so_000158e3;
    }
    FUN_000b3394(uVar19,pcVar32,1);
    FUN_000d7a20(0x1bbdf);
    FUN_000d4478();
    uStack_28f = (undefined1)uVar27;
    uStack_28e = (undefined4)((ulong)uVar27 >> 8);
    uStack_28a = (undefined2)((ulong)uVar27 >> 0x28);
    uStack_288 = (undefined1)((ulong)uVar27 >> 0x38);
    uStack_297 = (undefined1)uVar28;
    uStack_296 = (undefined4)((ulong)uVar28 >> 8);
    uStack_292 = (undefined2)((ulong)uVar28 >> 0x28);
    uStack_290 = (undefined1)((ulong)uVar28 >> 0x38);
    FUN_00088f34();
    FUN_000d3d94(&local_80,local_190);
    pcVar30 = (code *)((ulong)local_b0 | 1);
    if (((ulong)local_80 & 1) != 0) {
      pcVar30 = local_70;
    }
    FUN_000b3b30(uVar19,pcVar30,0,0,&LAB_00091df0);
    FUN_000d0a28();
    FUN_000b39c8(uVar19);
    FUN_000d869c();
    FUN_000d7a2c(0x1c4e2);
    FUN_000d4478();
    uStack_28e = (undefined4)uVar27;
    uStack_28a = (undefined2)((ulong)uVar27 >> 0x20);
    uStack_288 = (undefined1)((ulong)uVar27 >> 0x30);
    uStack_287._0_1_ = (undefined1)((ulong)uVar27 >> 0x38);
    uStack_296 = (undefined4)uVar28;
    uStack_292 = (undefined2)((ulong)uVar28 >> 0x20);
    uStack_290 = (undefined1)((ulong)uVar28 >> 0x30);
    uStack_28f = (undefined1)((ulong)uVar28 >> 0x38);
    FUN_00088f0c();
    FUN_000d3858(&local_80);
    lVar18 = FUN_000d12dc(*plVar15,plVar15);
    FUN_000d0a28();
    if (lVar18 == 0) {
      FUN_000cff60(*plVar15,plVar15);
    }
    else {
      FUN_000d4744(0x1c4fc);
      FUN_000d4478();
      uStack_290 = (undefined1)extraout_x8_08;
      uStack_28f = (undefined1)((ulong)extraout_x8_08 >> 8);
      uStack_28e = (undefined4)((ulong)extraout_x8_08 >> 0x10);
      uStack_28a = (undefined2)((ulong)extraout_x8_08 >> 0x30);
      FUN_00090c50();
      FUN_000d3858(&local_80);
      FUN_000d8760(&local_2a0,&DAT_0001c514,0x4d);
      FUN_000929b0(&local_2a0,local_190);
      FUN_0006e06c(&local_98,local_190);
      uVar19 = FUN_000d41e4(*(undefined8 *)(*plVar15 + 0x388));
      lVar36 = FUN_000d0610(uVar19,lVar18);
      FUN_000d2178();
      FUN_000d0a28();
      if (lVar36 == 0) {
        FUN_000cff60(*plVar15,plVar15);
        uVar12 = 0;
      }
      else {
        FUN_000d276c(0x1c561);
        local_190 = FUN_000d770c();
        FUN_0007ec48();
        FUN_000d748c();
        uVar19 = FUN_000d0a50(*plVar15);
        FUN_000d0254();
        uVar24 = FUN_000d49f0(*(undefined8 *)(*plVar15 + 0x560),plVar15,
                              (ulong)(CONCAT17(uStack_c1,uStack_c8) - (long)local_d0) >> 4,uVar19);
        plVar16 = local_d0;
        for (lVar36 = CONCAT17(uStack_c1,uStack_c8) - (long)local_d0; lVar36 != 0;
            lVar36 = lVar36 + -0x10) {
          lVar35 = plVar16[1];
          iVar11 = *(int *)((long)plVar16 + 0xc);
          FUN_00098014(*plVar16,iVar11,1);
          auVar40 = FUN_000d6928();
          uVar25 = (**(code **)(extraout_x8_09 + 0x728))(auVar40._0_8_,auVar40._8_8_,(int)lVar35);
          (**(code **)(*plVar15 + 0x570))(plVar15,uVar24,iVar11 + -1,uVar25);
          FUN_000cfb64(*plVar15,plVar15,uVar25);
          plVar16 = plVar16 + 2;
        }
        FUN_000cfb64(*plVar15,plVar15,uVar19);
        FUN_000d276c(0x1c575);
        auVar40 = FUN_000d770c();
        local_180 = extraout_w8_01;
        local_190 = auVar40;
        FUN_0007ec48();
        uVar19 = FUN_000d77d4(&local_2a0,&local_80);
        uVar33 = (ulong)plVar16 | 1;
        uVar9 = ((ulong)local_2a0 & 1) == 0;
        uVar17 = uVar33;
        if (!(bool)uVar9) {
          uVar17 = CONCAT26(uStack_28a,CONCAT42(uStack_28e,CONCAT11(uStack_28f,uStack_290)));
        }
        uVar19 = FUN_000d0e74(*(undefined8 *)(*plVar15 + 0x30),uVar19,uVar17);
        FUN_000d0254();
        FUN_000d5fe4(&DAT_00020863);
        local_190._3_4_ = extraout_w8_02;
        FUN_000718bc();
        FUN_000d57b8(&local_2a0);
        FUN_000d328c(*plVar15);
        pcVar32 = s_0011111001111111111_00013ff0 + 0x10;
        auVar40 = FUN_000d52c8();
        if (!(bool)uVar9) {
          uVar33 = extraout_x10_00;
        }
        FUN_000d4b18(auVar40._0_8_,auVar40._8_8_,uVar33,pcVar32 + 0x677);
        (*extraout_x8_10)();
        FUN_000d0254();
        FUN_000d6774(plVar15);
        uVar25 = FUN_0007e3e0();
        FUN_000d6af4();
        lVar36 = FUN_0007e40c();
        cVar10 = FUN_000d00b0(*plVar15,plVar15);
        uVar12 = 0;
        if ((lVar36 != 0) && (cVar10 == '\0')) {
          FUN_000d4b0c(*plVar15);
          uVar12 = FUN_000d077c();
          for (uVar37 = 0; (uVar12 & ((int)uVar12 >> 0x1f ^ 0xffffffffU)) != uVar37;
              uVar37 = uVar37 + 1) {
            auVar40 = FUN_000d4b0c(*(undefined8 *)(*plVar15 + 0x568));
            uVar26 = (*extraout_x8_11)(auVar40._0_8_,auVar40._8_8_,uVar37);
            plVar16 = (long *)FUN_000a9a08();
            (**(code **)(*plVar16 + 0x78))(plVar16,uVar26);
          }
          FUN_000d4b0c(*(undefined8 *)(*plVar15 + 0xb8));
          (*extraout_x8_12)();
        }
        FUN_000cfb64(*plVar15,plVar15,uVar24);
        FUN_000cfb64(*plVar15,plVar15,uVar19);
        FUN_000cfb64(*plVar15,plVar15,uVar25);
      }
      FUN_000cfb64(*plVar15,plVar15,lVar18);
      if (uVar12 != 0) {
LAB_000a45f8:
        plVar16 = (long *)FUN_000a9a08();
        plVar16 = (long *)(**(code **)(*plVar16 + 0x80))();
        local_90 = (long *)0x0;
        local_88 = (long *)0x0;
        local_98 = (long *)0x0;
        if (plVar16[1] - *plVar16 != 0) {
          uVar17 = plVar16[1] - *plVar16 >> 3;
          if (uVar17 >> 0x3d != 0) {
                    /* WARNING: Subroutine does not return */
            FUN_00050954(&local_98);
          }
          plVar20 = (long *)FUN_00090d84(uVar17);
          local_88 = plVar20 + uVar17;
          lVar18 = *plVar16;
          lVar36 = plVar16[1];
          plVar16 = plVar20;
          local_98 = plVar20;
          local_90 = plVar20;
          if (0 < lVar36 - lVar18) {
            plVar16 = (long *)FUN_000d31f4(plVar20);
            local_90 = (long *)((long)plVar20 + (lVar36 - lVar18));
          }
        }
        FUN_000d74a4(plVar16,&DAT_0001b6ff);
        uVar27 = FUN_0008eecc();
        uVar33 = (ulong)local_190 | 1;
        uVar17 = uVar33;
        if (((ulong)local_2a0 & 1) != 0) {
          uVar17 = CONCAT26(uStack_28a,CONCAT42(uStack_28e,CONCAT11(uStack_28f,uStack_290)));
        }
        uVar27 = FUN_000d0e74(*(undefined8 *)(*plVar15 + 0x30),uVar27,uVar17);
        uVar28 = FUN_000d0254();
        FUN_000d4f9c(uVar28,&DAT_0001b70f);
        FUN_000d2c58();
        FUN_0008eecc(local_190,&DAT_0001b71e);
        FUN_000d320c(*plVar15);
        uVar28 = FUN_000d0610(plVar15,uVar27);
        FUN_000d0268();
        uVar19 = FUN_000d0254();
        FUN_000d4f9c(uVar19,&DAT_0001b738);
        uVar19 = FUN_000d12dc(*plVar15,plVar15);
        FUN_000d0254();
        uVar28 = FUN_00080334(plVar15,uVar19,uVar28);
        FUN_000cfb64(*plVar15,plVar15,uVar19);
        uVar27 = FUN_000cfb64(*plVar15,plVar15,uVar27);
        FUN_000d4f9c(uVar27,&DAT_0001b934);
        uVar27 = FUN_000d12dc(*plVar15,plVar15);
        uVar19 = FUN_000d0254();
        FUN_000d4f9c(uVar19,&DAT_0001b955);
        FUN_000d2c58();
        FUN_0008eecc(local_190,&DAT_0001b95e);
        uVar19 = FUN_000d49d0();
        uVar19 = FUN_000d120c(uVar19,uVar27);
        FUN_000d0268();
        FUN_000d0254();
        auVar40 = FUN_000d33f4(*plVar15);
        FUN_000d0d70(auVar40._0_8_,auVar40._8_8_,uVar19);
        uVar24 = FUN_000d6950();
        FUN_000cfb64(uVar24,uVar27);
        FUN_000cfb64(*plVar15,plVar15,uVar28);
        uVar27 = FUN_000d045c(*plVar15,plVar15,uVar19);
        FUN_000d4f9c(uVar27,&DAT_0001b97a);
        FUN_000d2c58();
        if ((extraout_x8_13 & 1) != 0) {
          uVar33 = extraout_x9_00;
        }
        FUN_0008eecc(local_190,&DAT_0001b986);
        uVar28 = FUN_000d49d0();
        uVar28 = (*extraout_x8_14)(uVar28,uVar27,uVar33);
        FUN_000d0268();
        FUN_000d0254();
        FUN_000d6af4(*plVar15);
        uVar24 = FUN_000d0d70();
        FUN_000cfb64(*plVar15,plVar15,uVar27);
        FUN_000d4f74(0x1bba3);
        FUN_00088470();
        FUN_000d3d94(&local_80,local_190);
        lVar18 = FUN_000d0a50(*plVar15);
        FUN_000d0a28();
        if (lVar18 == 0) {
          FUN_000d5314();
        }
        else {
          FUN_000d33f4(*(undefined8 *)(*plVar15 + 0x558));
          uVar12 = (*extraout_x8_15)();
          uVar27 = FUN_000d49f0(*(undefined8 *)(*plVar15 + 0x560),plVar15,
                                uVar12 + (int)((ulong)((long)local_90 - (long)local_98) >> 3),lVar18
                               );
          FUN_000a9a08();
          FUN_000d04c4();
          auVar40 = FUN_000d7020();
          uVar12 = uVar12 & ((int)uVar12 >> 0x1f ^ 0xffffffffU);
          if ((extraout_w8_03 < 10) || (*(char *)(auVar40._0_8_ + 0xc9) != '\0')) {
            iVar11 = 0;
            for (plVar16 = local_98; plVar16 != local_90; plVar16 = plVar16 + 1) {
              FUN_000d6938();
              auVar40 = (*extraout_x8_16)();
              iVar11 = iVar11 + 1;
            }
            for (uVar37 = 0; uVar12 != uVar37; uVar37 = uVar37 + 1) {
              auVar40 = FUN_000d33f4(*plVar15);
              uVar25 = FUN_000d1bb8(auVar40._0_8_,auVar40._8_8_,uVar37);
              (**(code **)(*plVar15 + 0x570))(plVar15,uVar27,iVar11 + uVar37,uVar25);
              FUN_000d33e8();
              auVar40 = FUN_000913b0();
            }
          }
          else {
            for (uVar37 = 0; plVar16 = local_98, uVar12 != uVar37; uVar37 = uVar37 + 1) {
              auVar40 = FUN_000d33f4(*plVar15);
              uVar27 = FUN_000d1bb8(auVar40._0_8_,auVar40._8_8_,uVar37);
              FUN_000913b0(plVar15,uVar27);
              FUN_000d6938();
              auVar40 = (*extraout_x8_17)();
            }
            for (; plVar16 != local_90; plVar16 = plVar16 + 1) {
              auVar40 = FUN_000d6928();
              auVar40 = (**(code **)(extraout_x8_18 + 0x570))(auVar40._0_8_,auVar40._8_8_,uVar12);
              uVar12 = uVar12 + 1;
            }
          }
          FUN_000d24ac(*plVar15,auVar40._0_8_,auVar40._8_8_,uVar28);
          (**(code **)(extraout_x8_19 + 0x340))();
          FUN_000cfb64(*plVar15,plVar15,lVar18);
        }
        FUN_000cfb64(*plVar15,plVar15,uVar19);
        FUN_000cfb64(*plVar15,plVar15,uVar24);
        FUN_00090ca0(&local_98);
        FUN_0008ef78(&local_d0);
        goto LAB_000a4a70;
      }
    }
    pplVar29 = &local_d0;
LAB_000a4930:
    FUN_0008ef78(pplVar29);
  }
  else {
    FUN_000a9a08();
    uVar19 = FUN_000d1b8c();
    FUN_0008ef04(&local_80,uVar19);
    bVar8 = false;
    for (plVar16 = local_80; plVar16 != plStack_78; plVar16 = plVar16 + 2) {
      lVar18 = *plVar16;
      if ((lVar18 == 0) || (iVar11 = (int)plVar16[1], iVar11 == 0)) goto LAB_000a41e0;
      uVar34 = *(undefined4 *)((long)plVar16 + 0xc);
      iVar13 = FUN_000b02c8();
      iVar14 = _DAT_000e84e0;
      FUN_000a9a08();
      lVar36 = FUN_000d04c4();
      if ((iVar14 != 3) && (*(char *)(lVar36 + 0xe8) == '\0')) {
LAB_000a417c:
        local_2a0 = (long *)0x0;
        if (iVar13 < 0xe) {
          lVar18 = FUN_0008f9f0(plVar15,1);
          if (lVar18 != 0) {
            FUN_000d824c();
            FUN_000d4618();
            FUN_00090084(iVar13,local_2a0);
            goto LAB_000a41d0;
          }
        }
        else {
          lVar18 = FUN_0008ef8c();
          if (lVar18 != 0) {
            FUN_000d8258();
            uVar19 = FUN_000d4618();
            FUN_0008f9b0(iVar13,local_2a0,uVar19);
LAB_000a41d0:
            if (iVar13 != 0) goto LAB_000a41d4;
          }
        }
LAB_000a41e0:
        pplVar29 = &local_80;
        goto LAB_000a4930;
      }
      FUN_000d4488();
      FUN_0008eecc(local_190,&DAT_0001bad0);
      FUN_000d508c(&local_2a0);
      FUN_000d0268();
      uVar19 = FUN_000d2c58();
      FUN_000d65ac(uVar19,1);
      lVar36 = FUN_000d8cb0();
      if (lVar36 == 0) {
        FUN_000d0254();
        goto LAB_000a417c;
      }
      FUN_000b02c8();
      FUN_0008eecc(local_190,&DAT_0001bae2);
      _DAT_000e8960 = (code *)FUN_000d1728(local_190._0_8_ & 0xff,lVar36);
      FUN_000d0268();
      if (_DAT_000e8960 == Reset) {
        FUN_0008eecc(local_190,&DAT_0001baf8);
        _DAT_000e8960 = (code *)FUN_000d1728(local_190._0_8_ & 0xff,lVar36);
        FUN_000d0268();
      }
      FUN_0008eecc(local_190,&DAT_0001bb1f);
      _DAT_000e8968 = (code *)FUN_000d1728(local_190._0_8_ & 0xff,lVar36);
      FUN_000d0268();
      if (_DAT_000e8968 == Reset) {
        FUN_0008eecc(local_190,&DAT_0001bb34);
        _DAT_000e8968 = (code *)FUN_000d1728(local_190._0_8_ & 0xff,lVar36);
        FUN_000d0268();
      }
      pcVar7 = _DAT_000e8968;
      pcVar30 = _DAT_000e8960;
      FUN_000d9190(lVar36);
      FUN_000d0254();
      if ((pcVar30 == Reset) || (pcVar7 == Reset)) goto LAB_000a417c;
      local_2a0 = (long *)0x0;
      iVar14 = (*_DAT_000e8960)(lVar18,iVar11,&local_2a0);
      if ((iVar14 != 0) || (lVar36 = FUN_000d7b24(), lVar36 == 0)) goto LAB_000a417c;
      iVar14 = FUN_000b02c8();
      if (0x12 < iVar14) {
        FUN_0009101c(local_2a0,lVar18,(long)iVar11);
      }
      pcVar30 = _DAT_000e8968;
      *(long **)(lVar36 + 8) = local_2a0;
      uVar19 = (*pcVar30)(*local_2a0);
      *(undefined8 *)(*local_2a0 + 0x48) = uVar19;
      FUN_00098014(lVar18,uVar34,1);
      lVar18 = FUN_00090fa8(plVar15,*(undefined8 *)(lVar36 + 8),lVar18);
      FUN_000d807c();
      if (lVar18 == 0) goto LAB_000a417c;
LAB_000a41d4:
      bVar8 = true;
    }
    FUN_0008ef78(&local_80);
    if (bVar8) {
LAB_000a4a70:
      lVar18 = FUN_00098f64();
      FUN_0009893c(&local_2a0,&DAT_0001ce82);
      FUN_00070ad0(lVar18 + 0x48,&local_2a0);
      FUN_000d0254();
      uVar27 = CONCAT17((undefined1)DAT_00014794,uRam000000000001478d);
      uStack_c8 = uRam0000000000012f76;
      uStack_c1 = (undefined1)DAT_00012f7d;
      local_d0 = _DAT_00012f6e;
      uStack_e8 = uRam000000000001478d;
      uStack_e1 = (undefined1)DAT_00014794;
      local_f0 = _DAT_00014785;
      uStack_108 = uRam000000000001494d;
      local_110 = _DAT_00014945;
      uVar28 = _DAT_00014785;
      auVar40 = FUN_000d5fc8(0x14e77);
      local_2a0 = auVar40._0_8_;
      uStack_c1 = (undefined1)extraout_x9_01;
      uStack_c0 = (undefined7)((ulong)extraout_x9_01 >> 8);
      uStack_e1 = (undefined1)extraout_x10_01;
      uStack_e0 = (undefined7)((ulong)extraout_x10_01 >> 8);
      local_100 = 0;
      uStack_298 = auVar40[8];
      uStack_297 = auVar40[9];
      uStack_296 = auVar40._10_4_;
      uStack_292 = auVar40._14_2_;
      uStack_288 = (undefined1)uVar27;
      uStack_287 = (undefined4)((ulong)uVar27 >> 8);
      uStack_283 = (undefined1)((ulong)uVar27 >> 0x28);
      uStack_282 = (undefined2)((ulong)uVar27 >> 0x30);
      uStack_290 = (undefined1)uVar28;
      uStack_28f = (undefined1)((ulong)uVar28 >> 8);
      uStack_28e = (undefined4)((ulong)uVar28 >> 0x10);
      uStack_28a = (undefined2)((ulong)uVar28 >> 0x30);
      uStack_280 = (undefined5)extraout_x8_20;
      uStack_27b = (undefined3)((ulong)extraout_x8_20 >> 0x28);
      uVar19 = FUN_0009893c(local_190,&DAT_0001cea8);
      plVar20 = (long *)((ulong)local_190 | 1);
      plVar16 = plVar20;
      if ((local_190._0_8_ & 1) != 0) {
        plVar16 = (long *)CONCAT44(uStack_17c,local_180);
      }
      lVar18 = FUN_000d0e74(*(undefined8 *)(*plVar15 + 0x30),uVar19,plVar16);
      FUN_000d0268();
      cVar10 = FUN_000d00b0(*plVar15,plVar15);
      if (cVar10 == '\0') {
        FUN_0009893c(local_190,&local_110);
        local_80 = plVar20;
        if ((local_190._0_8_ & 1) != 0) {
          local_80 = (long *)CONCAT44(uStack_17c,local_180);
        }
        plStack_78 = (long *)0x0;
        FUN_0009893c(&local_98,&local_2a0);
        if ((local_190._0_8_ & 1) != 0) {
          plVar20 = (long *)CONCAT44(uStack_17c,local_180);
        }
        plVar16 = (long *)((ulong)&local_98 | 1);
        if (((ulong)local_98 & 1) != 0) {
          plVar16 = local_88;
        }
        _DAT_000e8a08 =
             FUN_000d3520(*(undefined8 *)(*plVar15 + 0x388),plVar15,extraout_x1,plVar20,plVar16);
        local_70 = FUN_00098974;
        auVar40 = FUN_000d00b0(*plVar15,plVar15);
        if ((auVar40._0_8_ & 0xff) == 0) {
          _DAT_000e84d8 = 2;
        }
        else {
          FUN_000cff60(*plVar15,plVar15);
          FUN_0009893c(local_b0,&local_f0);
          FUN_000d7e44(&local_98);
          FUN_000d5708();
          _DAT_000e8a08 = FUN_000d1e40();
          local_70 = FUN_00098b08;
          auVar40 = FUN_000d00b0(*plVar15,plVar15);
          if ((auVar40._0_8_ & 0xff) == 0) {
            _DAT_000e84d8 = 1;
          }
          else {
            FUN_000cff60(*plVar15,plVar15);
            FUN_0009893c(local_b0,&local_d0);
            FUN_000d7e44(&local_98);
            FUN_000d5708();
            _DAT_000e8a08 = FUN_000d1e40();
            local_70 = FUN_00098b20;
            auVar40 = FUN_000d00b0(*plVar15,plVar15);
            if ((auVar40._0_8_ & 0xff) == 0) {
              _DAT_000e84d8 = 0;
            }
            else {
              auVar40 = FUN_000cff60(*plVar15,plVar15);
            }
          }
        }
        if (_DAT_000e8a08 != 0) {
          plStack_78 = (long *)((ulong)&local_98 | 1);
          if (((ulong)local_98 & 1) != 0) {
            plStack_78 = local_88;
          }
          FUN_000d24ac(*plVar15,auVar40._0_8_,auVar40._8_8_,&local_80,1);
          (**(code **)(extraout_x8_21 + 0x6b8))();
        }
        if (lVar18 != 0) {
          FUN_000cfb64(*plVar15,plVar15,lVar18);
        }
        FUN_000d2178();
        FUN_000d0268();
      }
      else {
        FUN_000cff60(*plVar15,plVar15);
      }
      goto LAB_000a4d00;
    }
  }
  uVar34 = 0;
LAB_000a4d04:
  uVar9 = _DAT_000e8eb0 == 0;
  DAT_000e8430 = !(bool)uVar9;
  FUN_000a9a08();
  lVar18 = FUN_000d04c4();
  DAT_000e842c = *(char *)(lVar18 + 0xc6);
  FUN_000a9a08();
  FUN_000d04c4();
  if (bVar3) {
    if (DAT_000e8430 != '\0' || DAT_000e842c != '\0') {
      iVar11 = FUN_000b02c8();
      uVar9 = iVar11 == 0x19;
      if ((bool)uVar9) {
        uStack_298 = (undefined1)uRam000000000001be9c;
        uStack_297 = (undefined1)((ulong)uRam000000000001be9c >> 8);
        uStack_296 = (undefined4)((ulong)uRam000000000001be9c >> 0x10);
        uStack_292 = (undefined2)((ulong)uRam000000000001be9c >> 0x30);
        local_2a0 = _DAT_0001be94;
        uStack_288 = (undefined1)uRam000000000001beac;
        uStack_287 = (undefined4)((uint5)uRam000000000001beac >> 8);
        uStack_290 = (undefined1)_DAT_0001bea4;
        uStack_28f = (undefined1)((ulong)_DAT_0001bea4 >> 8);
        uStack_28e = (undefined4)((ulong)_DAT_0001bea4 >> 0x10);
        uStack_28a = (undefined2)((ulong)_DAT_0001bea4 >> 0x30);
        uStack_27b = (undefined3)uRam000000000001beb9;
        uStack_278 = (undefined5)((ulong)uRam000000000001beb9 >> 0x18);
        uStack_283 = (undefined1)_DAT_0001beb1;
        uStack_282 = (undefined2)((uint3)_DAT_0001beb1 >> 8);
        uStack_280 = uRam000000000001beb4;
        FUN_000951ec(&local_2a0,local_190);
        uVar27 = FUN_000d3d94(&local_80,local_190);
        FUN_000d10d0((ulong)local_80 & 0xff,uVar27,0);
        iVar11 = FUN_0007e3c8();
        FUN_000d0a28();
        if (iVar11 == 0) goto LAB_000a5240;
      }
      FUN_0006f178(&local_80);
      FUN_000d7e80();
      FUN_000d7478();
      FUN_000817d4();
      FUN_0006e06c(&local_98,local_b0);
      iVar11 = FUN_000b02c8();
      if (iVar11 - 0x21U < 3) {
        FUN_000d8760(&local_2a0,&DAT_0001bf54,0x79);
        FUN_00095248(&local_2a0,local_190);
        FUN_000d3858(local_b0);
        FUN_000d7e44(&local_80);
        FUN_000d5708();
        FUN_000d6490();
        uVar17 = (ulong)&local_98 | 1;
        uVar33 = (ulong)&local_80 | 1;
        if ((extraout_x8_22 & 1) != 0) {
          uVar17 = extraout_x9_02;
        }
        uVar9 = (extraout_x10_02 & 1) == 0;
        uVar1 = uVar33;
        if (!(bool)uVar9) {
          uVar1 = extraout_x11_00;
        }
        uVar17 = FUN_000d6810(uVar17,uVar1,FUN_00095128,&DAT_000e8998);
        if ((uVar17 & 1) != 0) {
          FUN_000d2178();
          FUN_000d0a28();
          goto LAB_000a527c;
        }
        lVar18 = 0;
        while (lVar18 != 0x9a) {
          FUN_000d6228();
          *(undefined1 *)((long)&local_2a0 + extraout_x8_23) = extraout_w10;
          lVar18 = extraout_x8_23 + 1;
        }
        FUN_000d2674(local_190);
        FUN_000d508c(&local_80);
        FUN_000d0268();
        FUN_000d6490();
        uVar27 = FUN_000d2d50();
        uVar9 = (extraout_x10_04 & 1) == 0;
        if (!(bool)uVar9) {
          uVar33 = extraout_x11_02;
        }
        uVar17 = FUN_000d6810(uVar27,uVar33,FUN_00094c24,&DAT_000e8998);
LAB_000a5168:
        FUN_000d2178();
        FUN_000d0a28();
        if ((uVar17 & 1) != 0) goto LAB_000a527c;
      }
      else {
        uVar9 = iVar11 - 0x1dU == 3;
        if (iVar11 - 0x1dU < 4) {
          FUN_000d8760(&local_2a0,&DAT_0001c067,0x79);
          FUN_00095248(&local_2a0,local_190);
          FUN_000d3858(local_b0);
          FUN_00070ad0(&local_80,local_b0);
          FUN_000d5708();
          uVar28 = FUN_000d09f8();
          uVar27 = extraout_x13;
          if (!(bool)uVar9) {
            uVar27 = extraout_x12_00;
          }
          pcVar30 = FUN_00095128;
LAB_000a515c:
          uVar17 = FUN_00095214(uVar28,uVar27,pcVar30,&DAT_000e8998);
          goto LAB_000a5168;
        }
        if (iVar11 - 0x1aU < 3) {
          lVar18 = 0;
          while (uVar9 = lVar18 == 0x7a, !(bool)uVar9) {
            FUN_000d2048();
            lVar18 = extraout_x8_24;
          }
          FUN_000d2674(local_190);
          FUN_000d3e44();
          FUN_000d0268();
          uVar28 = FUN_000d09f8();
          uVar27 = extraout_x13_00;
          if (!(bool)uVar9) {
            uVar27 = extraout_x12_01;
          }
          pcVar30 = FUN_00095140;
          goto LAB_000a515c;
        }
        if (iVar11 - 0x17U < 3) {
          lVar18 = 0;
          while (uVar9 = lVar18 == 0x86, !(bool)uVar9) {
            FUN_000d2048();
            lVar18 = extraout_x8_25;
          }
          FUN_000d2674(local_190);
          FUN_000d3e44();
          FUN_000d0268();
          uVar28 = FUN_000d09f8();
          uVar27 = extraout_x13_01;
          if (!(bool)uVar9) {
            uVar27 = extraout_x12_02;
          }
          pcVar30 = FUN_00095158;
          goto LAB_000a515c;
        }
        if (iVar11 - 0x13U < 4) {
          lVar18 = 0;
          while (uVar9 = lVar18 == 0x77, !(bool)uVar9) {
            FUN_000d2048();
            lVar18 = extraout_x8_26;
          }
          FUN_000d2674(local_190);
          FUN_000d3e44();
          FUN_000d0268();
          uVar28 = FUN_000d09f8();
          uVar27 = extraout_x13_02;
          if (!(bool)uVar9) {
            uVar27 = extraout_x12_03;
          }
          pcVar30 = FUN_0009517c;
          goto LAB_000a515c;
        }
        FUN_000d2178();
        FUN_000d0a28();
      }
      FUN_0006f178(local_190);
      FUN_000d7478();
      FUN_000817d4();
      FUN_000d57b8(&local_80);
      iVar11 = FUN_000b02c8();
      uVar9 = iVar11 == 0x23;
      if (iVar11 < 0x23) {
        FUN_000d0a28();
        FUN_000d0268();
      }
      else {
        lVar18 = 0;
        while (uVar9 = lVar18 == 0x6b, !(bool)uVar9) {
          FUN_000d6228();
          *(undefined1 *)((long)&local_2a0 + extraout_x8_27) = extraout_w10_00;
          lVar18 = extraout_x8_27 + 1;
        }
        FUN_000d2674(&local_98);
        FUN_00070ad0(local_190,&local_98);
        FUN_000d2178();
        FUN_000d3488((ulong)local_80 & 0xff);
        uVar17 = (ulong)local_190 | 1;
        uVar27 = extraout_x10_05;
        if (!(bool)uVar9) {
          uVar27 = extraout_x9_05;
        }
        uVar9 = (extraout_x11_03 & 1) == 0;
        if (!(bool)uVar9) {
          uVar17 = extraout_x12_04;
        }
        uVar17 = FUN_000d6810(uVar27,uVar17,FUN_00094708,&DAT_000e8990);
        FUN_000d0a28();
        pplVar29 = (long **)local_190;
LAB_000a5238:
        FUN_0004e170(pplVar29);
        if ((uVar17 & 1) != 0) goto LAB_000a527c;
      }
      goto LAB_000a5240;
    }
  }
  else {
    if (DAT_000e8430 == '\0') goto LAB_000a527c;
    FUN_000d74a4();
    FUN_000b0728();
    uVar17 = FUN_00085c08(&local_2a0,&DAT_000155a7);
    FUN_000d0254();
    if ((uVar17 & 1) != 0) {
      FUN_000d2ce0(0x1bf2c);
      local_190._8_2_ = extraout_w8_00;
      local_190._0_8_ = extraout_x9_03;
      FUN_000817d4(local_190,local_b0);
      FUN_000d57b8(&local_2a0);
      FUN_000d1308((ulong)local_2a0 & 0xff,&local_80);
      FUN_000d3d94();
      FUN_000d0254();
      FUN_000d4738(0x1bf36);
      FUN_000d4478();
      uStack_28a = (undefined2)uVar27;
      uStack_288 = (undefined1)((ulong)uVar27 >> 0x10);
      uStack_287 = (undefined4)((ulong)uVar27 >> 0x18);
      uStack_283 = (undefined1)((ulong)uVar27 >> 0x38);
      uStack_292 = (undefined2)uVar28;
      uStack_290 = (undefined1)((ulong)uVar28 >> 0x10);
      uStack_28f = (undefined1)((ulong)uVar28 >> 0x18);
      uStack_28e = (undefined4)((ulong)uVar28 >> 0x20);
      FUN_0006e044();
      FUN_0006e06c(&local_98,local_190);
      FUN_000d2d68((ulong)local_98 & 0xff,&local_2a0);
      FUN_000d2178();
      FUN_000d42f8((ulong)local_80 & 0xff);
      uVar17 = (ulong)&local_2a0 | 1;
      uVar27 = extraout_x10_03;
      if (!(bool)uVar9) {
        uVar27 = extraout_x9_04;
      }
      uVar9 = (extraout_x11_01 & 1) == 0;
      if (!(bool)uVar9) {
        uVar17 = extraout_x12;
      }
      uVar17 = FUN_000d6810(uVar27,uVar17,FUN_000951b4,&DAT_000e89a0);
      FUN_000d0254();
      pplVar29 = &local_80;
      goto LAB_000a5238;
    }
LAB_000a5240:
    FUN_000a9a08();
    FUN_000d1b8c();
    FUN_000d8608();
    plVar16 = local_2a0;
    for (lVar18 = CONCAT26(uStack_292,CONCAT42(uStack_296,CONCAT11(uStack_297,uStack_298))) -
                  (long)local_2a0; lVar18 != 0; lVar18 = lVar18 + -0x10) {
      FUN_00098014(*plVar16,*(undefined4 *)((long)plVar16 + 0xc),0);
      plVar16 = plVar16 + 2;
    }
    FUN_0008ef78(&local_2a0);
  }
LAB_000a527c:
  if (*(char *)(param_5 + 0xe1) != '\0') {
    FUN_000a9a08();
    if (*(char *)(param_5 + 0xe2) == '\0') {
      puVar21 = (undefined8 *)FUN_000ce2e8(1);
      FUN_000d48c0(*puVar21);
      (**(code **)(extraout_x8_28 + 0x10))();
    }
    else {
      FUN_000d5fe4(0x1c278);
      local_190._3_4_ = extraout_w8_04;
      FUN_000718bc();
      FUN_000d77d4(&local_2a0,local_b0);
      uVar17 = FUN_000d3178();
      FUN_000d0254();
      if ((uVar17 & 1) != 0) {
        FUN_000d4488();
        for (lVar18 = 0; (int)lVar18 != 0x1d; lVar18 = lVar18 + 1) {
          FUN_000d001c((&DAT_0001c257)[lVar18],&local_2a0,1);
        }
        uVar27 = FUN_000d328c(*plVar15);
        uVar33 = (ulong)&local_2a0 | 1;
        uVar9 = (extraout_x9_06 & 1) == 0;
        uVar17 = uVar33;
        if (!(bool)uVar9) {
          uVar17 = extraout_x10_06;
        }
        lVar18 = FUN_000d0e74(*(undefined8 *)(extraout_x8_29 + 0x30),uVar27,uVar17);
        FUN_000d0254();
        if (lVar18 == 0) {
          FUN_000cff60(*plVar15,plVar15);
        }
        else {
          FUN_000d7a8c(0x1c275);
          FUN_000d770c();
          local_190[2] = extraout_w8;
          local_190._0_2_ = extraout_w9_04;
          FUN_00089f9c();
          FUN_000d748c();
          FUN_000d328c(*plVar15);
          pcVar32 = s_0011111001111111111_00013ff0 + 0x10;
          FUN_000d79e0();
          if (!(bool)uVar9) {
            uVar33 = extraout_x10_07;
          }
          lVar36 = FUN_000d3314(plVar15,extraout_x1_00,uVar33,pcVar32 + 0x93f);
          FUN_000d0254();
          if (lVar36 == 0) {
            FUN_000cff60(*plVar15,plVar15);
          }
          else {
            FUN_000d7fe8(plVar15);
            FUN_00081374();
          }
          FUN_000cfb64(*plVar15,plVar15,lVar18);
        }
      }
    }
  }
  FUN_0006f178(&local_f0);
  FUN_000d1cb0();
  FUN_0006e06c(&local_110);
  FUN_0004ed04(&local_110,s_163java2c0_0001411e);
  FUN_000d2a1c(CONCAT71(uStack_ff,local_100) + 9);
  if ((bool)uVar9) {
    *extraout_x11_04 = 0x88e3f4e4f1e4e7ef;
    FUN_00076d64(local_190,&local_98);
    FUN_000d77d4(&local_2a0,&local_98);
    FUN_000d3178();
    FUN_000d0254();
    FUN_000a9a08();
    lVar18 = FUN_000d04c4();
    if (*(char *)(lVar18 + 0xc6) != '\0') {
      local_2a4 = 0;
      plVar16 = (long *)FUN_000a9a08();
      lVar18 = (**(code **)(*plVar16 + 0x40))(plVar16,&local_2a4,10);
      if (lVar18 != 0) {
        local_2a0 = (long *)0x0;
        uStack_298 = 0;
        uStack_297 = 0;
        uStack_296 = 0;
        uStack_292 = 0;
        uStack_290 = 0;
        uStack_28f = 0;
        uStack_28e = 0;
        uStack_28a = 0;
        FUN_000968f4(lVar18,local_2a4,&local_2a0);
        plVar16 = (long *)CONCAT26(uStack_292,CONCAT42(uStack_296,CONCAT11(uStack_297,uStack_298)));
        for (plVar20 = local_2a0; plVar16 != plVar20; plVar20 = plVar20 + 1) {
          lVar18 = *plVar20;
          FUN_0004e08c(local_190,lVar18 + 0x18);
          FUN_0004e08c(&local_80,lVar18 + 0x30);
          FUN_000d331c(&local_98);
          FUN_00073660(&local_d0,&local_98,local_190);
          FUN_00071328(local_b0,&local_d0,&local_80);
          FUN_0004e170(&local_d0);
          FUN_000945e8(*(undefined4 *)(lVar18 + 0x50),local_b0);
          FUN_000d5708();
          FUN_000d2178();
          FUN_000d0a28();
          FUN_000d0268();
        }
        FUN_000d22a8();
        FUN_00095fc4(&local_2a0);
      }
    }
  }
  FUN_000d4680();
  FUN_0004e170(&local_f0);
  FUN_000afe6c(&local_80,plVar15,auVar38._8_8_);
  FUN_000d4f74(0x1f0de);
  FUN_00088470();
  FUN_000d3858(&local_98);
  FUN_00070a94(&local_2a0,&local_80,&local_98);
  FUN_000d2178();
  iVar11 = FUN_000d469c(_DAT_000e8a38);
  if (iVar11 != -1) {
    uVar27 = FUN_000d0c24();
    FUN_000d91b0(iVar11,uVar27);
    uVar27 = FUN_000d0c24();
    FUN_000d2438(0,uVar27,1,2,iVar11);
    FUN_000d262c(_DAT_000e8a38,iVar11);
  }
  FUN_000d0254();
  FUN_000d0a28();
LAB_000a55c8:
  if (*(long *)(unaff_x29 + 0x28) != local_68) {
                    /* WARNING: Subroutine does not return */
    FUN_000d8770();
  }
  FUN_000cfdf0(uVar34);
  return;
}

