
void FUN_000971f0(undefined1 param_1 [16],undefined1 param_2 [16],undefined8 param_3,
                 undefined8 param_4,undefined8 *param_5,undefined8 param_6,uint param_7,
                 undefined4 param_8)

{
  byte *pbVar1;
  int iVar2;
  undefined1 in_ZR;
  bool bVar3;
  bool bVar4;
  undefined1 uVar5;
  int iVar6;
  uint uVar7;
  uint uVar8;
  int iVar9;
  undefined8 uVar10;
  long *plVar11;
  undefined8 *puVar12;
  long lVar13;
  undefined4 *puVar14;
  undefined8 uVar15;
  undefined8 *puVar16;
  code *pcVar17;
  undefined8 extraout_x1;
  undefined8 extraout_x1_00;
  long extraout_x1_01;
  undefined4 extraout_w8;
  undefined4 extraout_w8_00;
  long extraout_x8;
  ulong extraout_x8_00;
  long extraout_x8_01;
  ulong extraout_x8_02;
  long lVar18;
  ulong extraout_x8_03;
  undefined4 *puVar19;
  ulong extraout_x8_04;
  ulong extraout_x8_05;
  int extraout_w9;
  undefined8 extraout_x9;
  undefined8 extraout_x9_00;
  ulong extraout_x9_01;
  ulong extraout_x9_02;
  int *piVar20;
  ulong uVar21;
  ulong extraout_x9_03;
  ulong uVar22;
  ulong extraout_x9_04;
  undefined8 extraout_x10;
  undefined8 extraout_x10_00;
  int extraout_w11;
  ulong extraout_x11;
  ulong extraout_x11_00;
  int extraout_w12;
  ulong extraout_x12;
  ulong extraout_x12_00;
  ulong uVar23;
  long lVar24;
  undefined4 *puVar25;
  long lVar26;
  undefined4 *puVar27;
  ulong uVar28;
  long unaff_x27;
  undefined1 auVar29 [16];
  undefined8 uVar30;
  undefined1 auStack_308 [24];
  undefined1 local_2f0 [24];
  undefined1 local_2d8 [24];
  undefined1 auStack_2c0 [24];
  undefined1 auStack_2a8 [24];
  undefined1 local_290 [28];
  undefined1 auStack_274 [260];
  uint local_170 [2];
  int local_168;
  int local_164;
  ulong local_148;
  long local_68;
  
  uVar30 = param_2._8_8_;
  uVar15 = param_2._0_8_;
  FUN_000cff2c();
  FUN_000d1d30();
  local_68 = extraout_x8;
  FUN_000971b8(auStack_2c0,&DAT_0001cc43);
  FUN_000d6adc(local_2d8);
  FUN_000af6e0();
  FUN_000d0270(auStack_274,extraout_x1,0x104);
  FUN_000971b8(local_170,&DAT_0001cc60);
  FUN_000d7aa0((undefined1)local_170[0]);
  uVar23 = (ulong)local_2d8 | 1;
  uVar10 = extraout_x10;
  if (!(bool)in_ZR) {
    uVar10 = extraout_x9;
  }
  if ((extraout_x11 & 1) != 0) {
    uVar23 = extraout_x12;
  }
  FUN_000afa60(auStack_274,0x104,uVar10,uVar23);
  uVar10 = FUN_000d4680();
  if (param_7 == 5) {
    puVar12 = (undefined8 *)FUN_0004d9e0(0x58);
    uVar10 = DAT_00016840;
    uVar15 = *param_5;
    *puVar12 = 0xe0f48;
    puVar12[1] = param_5;
    *(undefined4 *)(puVar12 + 7) = param_8;
    puVar12[3] = param_6;
    puVar12[4] = 0;
    puVar12[2] = uVar15;
    *(undefined8 *)((long)puVar12 + 0x2c) = uVar10;
    puVar12[9] = 0;
    puVar12[10] = 0;
    puVar12[8] = puVar12 + 9;
    puVar12[6] = 0x500000008;
    FUN_0007fd74();
    FUN_000d248c();
    lVar18 = (**(code **)(extraout_x8_01 + 0x10))();
    if (lVar18 == 0) {
LAB_00097a18:
      uVar10 = 0;
    }
    else {
LAB_000973dc:
      lVar18 = FUN_000d3878();
      if (lVar18 == 0) goto LAB_00097a18;
      uVar10 = FUN_00097da4();
    }
    FUN_000d248c();
  }
  else {
    uVar5 = param_7 == 4;
    if ((bool)uVar5) {
      FUN_000d5ca8(uVar10,&DAT_00015ba2);
      FUN_000d6adc(auStack_308);
      FUN_000afe6c();
      FUN_0006f178(local_290);
      FUN_000d0270(local_170,extraout_x1_00,0x104);
      uVar10 = FUN_000d2fbc();
      FUN_000d42f8(uVar10,0x1c000);
      uVar10 = extraout_x10_00;
      if (!(bool)uVar5) {
        uVar10 = extraout_x9_00;
      }
      FUN_000971b8(auStack_2a8,extraout_x1_01 + 0xdbe);
      FUN_000d0108();
      uVar23 = (ulong)auStack_2a8 | 1;
      if ((extraout_x8_00 & 1) != 0) {
        uVar23 = extraout_x9_01;
      }
      FUN_000afa60(local_170,0x104,&DAT_00015e55,uVar10,uVar23);
      FUN_000cffb8();
      FUN_0004eb38(local_290,local_170);
      plVar11 = (long *)FUN_0008c920();
      uVar23 = (**(code **)(*plVar11 + 0x28))(plVar11,local_290);
      if ((uVar23 & 1) == 0) {
        FUN_000cfee0();
      }
      else {
        uVar10 = FUN_000d7928(local_2f0);
        FUN_000d10d0(local_290[0],uVar10,0x1c0);
        FUN_000d8fa0();
        FUN_000cfee0();
        FUN_000d5c90(0xe8378);
      }
      FUN_0004d9e0(0x70);
      puVar12 = (undefined8 *)FUN_000d0e4c();
      *puVar12 = 0xe0ed0;
      puVar16 = puVar12 + 8;
      *puVar16 = 0;
      pbVar1 = (byte *)(puVar12 + 0xb);
      uVar28 = (ulong)local_2f0 | 1;
      puVar12[7] = puVar16;
      puVar12[9] = 0;
      uVar23 = uVar28;
      if ((extraout_x8_02 & 1) != 0) {
        uVar23 = extraout_x9_02;
      }
      FUN_0006f178(pbVar1);
      uVar10 = *param_5;
      puVar12[4] = 0;
      puVar12[5] = param_6;
      *(undefined4 *)(puVar12 + 6) = 2;
      puVar12[1] = param_5;
      puVar12[2] = uVar10;
      FUN_0007eca0(*puVar16);
      puVar12[7] = puVar16;
      *puVar16 = 0;
      lVar18 = puVar12[2];
      puVar12[9] = 0;
      piVar20 = (int *)(lVar18 + (ulong)*(uint *)(lVar18 + 0x3c) + 0x40);
      puVar12[3] = lVar18 + *(int *)((long)piVar20 + (long)*piVar20 + 8);
      FUN_0004eb38(pbVar1,uVar23);
      *(undefined4 *)(puVar12 + 10) = param_8;
      piVar20 = (int *)(puVar12[2] + (ulong)*(uint *)(puVar12[2] + 0x3c) + 0x40);
      iVar9 = *piVar20;
      lVar18 = puVar12[3];
      FUN_0007ed58(local_290,&DAT_0001a036);
      FUN_000d0a30();
      iVar6 = FUN_000d7c38(lVar18);
      iVar2 = *(int *)(lVar18 + (ulong)*(uint *)(lVar18 + 100) + (long)iVar6 * 0x20 + 0x18);
      if (iVar2 != 0) {
        lVar24 = puVar12[2];
        lVar26 = (long)*(int *)((long)piVar20 + (long)iVar6 * 4 + (long)iVar9 + 0xc);
        lVar13 = lVar24 + lVar26 + 4;
        FUN_0008ec5c(local_170,lVar18 + iVar2);
        while (uVar21 = (ulong)local_170[0], uVar23 = local_148, local_148 < uVar21) {
          FUN_000d3224();
        }
        while ((uVar5 = (uVar21 & 0xffffffff) <= uVar23, (bool)uVar5 &&
               (FUN_000d31d0(), !(bool)uVar5))) {
          FUN_000d3224();
          FUN_000d78dc();
          uVar23 = extraout_x8_03;
          uVar21 = extraout_x9_03;
        }
        uVar8 = 0;
        while ((FUN_000d31c4(), (bool)uVar5 && (FUN_000d31b8(), !(bool)uVar5))) {
          uVar7 = FUN_000d6398();
          if (((uVar7 >> 8 & 1) != 0) && (lVar18 = FUN_000d7930(), lVar18 != 0)) {
            uVar10 = FUN_000d76f4();
            plVar11 = (long *)FUN_000d6dbc(uVar10,auStack_2a8);
            *plVar11 = lVar13;
            FUN_000cffb8();
          }
          FUN_000d3224();
          FUN_000d78dc();
          uVar8 = uVar8 + 1;
          lVar13 = lVar13 + 0x1c;
        }
        lVar18 = lVar26 + lVar24 + (ulong)uVar8 * 0x1c + 4;
        while ((FUN_000d1910(), (bool)uVar5 && (FUN_000d1e88(), !(bool)uVar5))) {
          uVar8 = FUN_000d6398();
          if (((uVar8 >> 8 & 1) != 0) && (lVar13 = FUN_000d7930(), lVar13 != 0)) {
            uVar10 = FUN_000d76f4();
            plVar11 = (long *)FUN_000d6dbc(uVar10,auStack_2a8);
            *plVar11 = lVar18;
            FUN_000cffb8();
          }
          FUN_000d3224();
          lVar18 = lVar18 + 0x1c;
        }
      }
      FUN_000cfee0();
      lVar13 = puVar12[5];
      lVar18 = 0x18;
      *(undefined4 *)(puVar12 + 6) = *(undefined4 *)(puVar12[2] + 0xc);
      uVar21 = (ulong)*(uint *)(lVar13 + 0x60);
      iVar9 = *(int *)(puVar12[2] + 0x3c) + *(uint *)(lVar13 + 0x60) * 4 + *(int *)(lVar13 + 0x20) +
              0x68;
      for (uVar23 = 0; uVar23 < uVar21; uVar23 = uVar23 + 1) {
        iVar9 = iVar9 + 4;
        iVar2 = *(int *)(puVar12[5] + (ulong)*(uint *)(lVar13 + 100) + lVar18);
        if (iVar2 != 0) {
          FUN_0008ec5c(local_170,puVar12[5] + (long)iVar2);
          uVar21 = (ulong)*(uint *)(lVar13 + 0x60);
          iVar9 = iVar9 + (local_164 + local_168) * 0x1c;
        }
        lVar18 = lVar18 + 0x20;
      }
      piVar20 = (int *)puVar12[1];
      uVar8 = iVar9 + 0xfffU & 0xfffff000;
      *(uint *)((long)puVar12 + 0x24) = uVar8;
      iVar9 = piVar20[4] + uVar8 + (*piVar20 - piVar20[2]);
      if (iVar9 == 0) {
LAB_00097af8:
        uVar10 = 0;
      }
      else {
        uVar8 = iVar9 + 0xfffU & 0xfffff000;
        *(uint *)(puVar12 + 4) = uVar8;
        puVar14 = (undefined4 *)FUN_000d8d30(0,(long)(int)uVar8,7,0x21,0xffffffff,0);
        if (puVar14 == (undefined4 *)0xffffffffffffffff) goto LAB_00097af8;
        FUN_000d87d0(puVar14,0,(long)*(int *)(puVar12 + 4));
        uVar10 = FUN_000d8d50(0,0,0);
        puVar19 = (undefined4 *)puVar12[2];
        *puVar14 = *puVar19;
        puVar14[1] = puVar19[1];
        puVar14[3] = puVar19[3];
        puVar14[4] = 1;
        *(undefined8 *)(puVar14 + 0xd) = *(undefined8 *)(puVar19 + 0xd);
        uVar8 = puVar19[0xf];
        puVar14[0xf] = uVar8;
        FUN_000d8760(puVar14 + 0x10,puVar19 + 0x10,(ulong)uVar8);
        lVar24 = puVar12[5];
        puVar19 = (undefined4 *)((long)(puVar14 + 0x10) + (ulong)uVar8);
        iVar9 = *(int *)(lVar24 + 0x60);
        *puVar19 = 0x1c;
        FUN_0007ed58(local_170,&DAT_0001a31f);
        auVar29 = FUN_000d2d24((undefined1)local_170[0],local_170);
        *(undefined1 (*) [16])(puVar19 + 4) = auVar29;
        *(undefined8 *)(puVar19 + 3) = uVar30;
        *(undefined8 *)(puVar19 + 1) = uVar15;
        uVar15 = FUN_0004e170();
        lVar18 = (long)puVar19 + (long)(iVar9 << 2) + 0x28;
        puVar19[8] = *(undefined4 *)(lVar24 + 8);
        puVar19[9] = (int)lVar18 - (int)puVar14;
        FUN_000d80a0(uVar15,puVar12[5],*(undefined4 *)(lVar24 + 0x20));
        puVar16 = (undefined8 *)FUN_000a9a08();
        FUN_000d5204(*puVar16,puVar16,lVar18,*(undefined4 *)(puVar12 + 10));
        FUN_00098014(lVar18,*(undefined4 *)(puVar12 + 10),1);
        lVar13 = puVar12[5];
        uVar8 = *(uint *)(lVar24 + 100);
        puVar27 = (undefined4 *)(lVar18 + (ulong)*(uint *)(lVar24 + 0x20));
        for (uVar23 = 0; bVar4 = (long)(uVar23 - *(uint *)(lVar24 + 0x60)) < 0,
            uVar23 < *(uint *)(lVar24 + 0x60); uVar23 = uVar23 + 1) {
          puVar25 = puVar27 + 1;
          *puVar27 = 7;
          puVar19[uVar23 + 10] = (int)puVar27 - (int)puVar14;
          iVar9 = *(int *)(lVar13 + (ulong)uVar8 + uVar23 * 0x20 + 0x18);
          if (iVar9 != 0) {
            FUN_0008ec5c(local_170,puVar12[5] + (long)iVar9);
            while (uVar22 = (ulong)local_170[0], uVar21 = local_148, local_148 < uVar22) {
              FUN_000d3224();
            }
            while ((uVar5 = (uVar22 & 0xffffffff) <= uVar21, (bool)uVar5 &&
                   (FUN_000d31d0(), !(bool)uVar5))) {
              FUN_000d3224();
              FUN_000d78dc();
              uVar21 = extraout_x8_04;
              uVar22 = extraout_x9_04;
            }
            puVar16 = (undefined8 *)(puVar27 + 2);
            puVar27 = puVar25;
            while ((FUN_000d31c4(), (bool)uVar5 && (FUN_000d31b8(), !(bool)uVar5))) {
              uVar7 = FUN_000d6398();
              if ((uVar7 >> 8 & 1) != 0) {
                FUN_0007ee64(local_170);
                FUN_0007ee34(local_170);
                uVar15 = FUN_000d5110();
                plVar11 = (long *)FUN_000d6dbc(uVar15,local_290);
                if (*plVar11 != 0) {
                  *(undefined8 *)(puVar27 + 1) = *(undefined8 *)(*plVar11 + 4);
                  FUN_000d3894();
                  *puVar27 = extraout_w8;
                }
                FUN_000cfee0();
              }
              FUN_000d3224();
              FUN_000d78dc();
              puVar27 = puVar27 + 7;
              puVar16 = (undefined8 *)((long)puVar16 + 0x1c);
            }
            while( true ) {
              FUN_000d1910();
              bVar4 = !(bool)uVar5;
              bVar3 = (uint)(extraout_w12 + extraout_w9) <= extraout_x8_05;
              uVar5 = bVar4 || bVar3;
              if (bVar4 || bVar3) break;
              uVar7 = FUN_000d6398();
              if ((uVar7 >> 8 & 1) != 0) {
                FUN_0007ee64(local_170);
                FUN_0007ee34(local_170);
                uVar15 = FUN_000d5110();
                plVar11 = (long *)FUN_000d6dbc(uVar15,local_290);
                if (*plVar11 != 0) {
                  *puVar16 = *(undefined8 *)(*plVar11 + 4);
                  FUN_000d3894();
                  *(undefined4 *)((long)puVar16 + -4) = extraout_w8_00;
                }
                FUN_000cfee0();
              }
              FUN_000d3224();
              puVar16 = (undefined8 *)((long)puVar16 + 0x1c);
            }
            puVar25 = puVar25 + (ulong)(uint)(extraout_w12 + extraout_w11) * 7;
          }
          puVar27 = puVar25;
        }
        FUN_000d4604(puVar12[1]);
        if (!bVar4) {
          FUN_000d8760((long)puVar14 + (long)*(int *)((long)puVar12 + 0x24));
        }
        FUN_000d8d50(uVar10,puVar14 + 2,*(int *)(puVar12 + 4) + -8);
        if ((*(byte *)(puVar12 + 0xb) & 1) == 0) {
          lVar18 = (long)puVar12 + 0x59;
        }
        else {
          lVar18 = puVar12[0xd];
        }
        lVar18 = FUN_000d3e88(lVar18);
        if (lVar18 == 0) {
LAB_00097aec:
          FUN_000d8d00(puVar14,(long)*(int *)(puVar12 + 4));
          goto LAB_00097af8;
        }
        FUN_0007ed08();
        FUN_0007ed58(local_170,&DAT_0001a021);
        pcVar17 = (code *)FUN_000d08b4((undefined1)local_170[0],lVar18);
        FUN_000d4680();
        if ((pcVar17 == Reset) ||
           (iVar9 = (*pcVar17)(puVar14,*(undefined4 *)(puVar12 + 4)), iVar9 == 0))
        goto LAB_00097aec;
        if ((*pbVar1 & 1) == 0) {
          lVar18 = (long)puVar12 + 0x59;
        }
        else {
          lVar18 = puVar12[0xd];
        }
        lVar18 = FUN_000d3e88(lVar18);
        if (lVar18 != 0) {
          FUN_0007ed08();
          FUN_0007ed58(local_170,&DAT_0001a003);
          pcVar17 = (code *)FUN_000d08b4((undefined1)local_170[0],lVar18);
          FUN_000d4680();
          if (pcVar17 != Reset) {
            (*pcVar17)((long)iVar9);
          }
        }
        FUN_000d270c();
        FUN_000d3488();
        if ((extraout_x11_00 & 1) != 0) {
          uVar28 = extraout_x12_00;
        }
        lVar18 = FUN_000d3e88(uVar28);
        if (lVar18 == 0) goto LAB_00097af8;
        FUN_0007ed08();
        FUN_000971b8(local_170,&DAT_0001cda2);
        pcVar17 = (code *)FUN_000d08b4((undefined1)local_170[0],lVar18);
        FUN_000d4680();
        if (pcVar17 == Reset) goto LAB_00097af8;
        auVar29 = FUN_000d1be0();
        lVar18 = (*pcVar17)(auVar29._0_8_,auVar29._8_8_,0);
        uVar10 = 0;
        if (lVar18 != 0) {
          uVar10 = FUN_000888d8();
          FUN_000971b8(local_170,&DAT_0001cd76);
          pcVar17 = (code *)FUN_000d08b4((undefined1)local_170[0],uVar10);
          FUN_000d4680();
          if (pcVar17 == Reset) goto LAB_00097af8;
          uVar10 = (*pcVar17)(lVar18);
        }
      }
      FUN_000d248c();
      FUN_000d84e4();
      uVar23 = FUN_00085c08(local_2f0,&DAT_00015ba2);
      if ((uVar23 & 1) != 0) {
        uVar15 = FUN_000d0e4c();
        FUN_000d2d50(uVar15,0);
        iVar9 = FUN_000d8f30();
        if (iVar9 == 0) {
          FUN_000d2d50(local_2f0[0]);
          FUN_000d8d20();
        }
      }
      FUN_000d0124();
      FUN_000d00b8();
      goto LAB_00097b44;
    }
    if ((param_7 & 0xfffffffe) != 6) {
      if (param_7 != 8) {
        uVar10 = 0;
        goto LAB_00097b44;
      }
      puVar12 = (undefined8 *)FUN_000d10c8();
      uVar10 = DAT_00016840;
      uVar15 = *param_5;
      puVar12[3] = param_6;
      puVar12[4] = 0;
      *(undefined4 *)(puVar12 + 7) = param_8;
      *puVar12 = 0xe0fa8;
      puVar12[1] = param_5;
      puVar12[2] = uVar15;
      *(undefined8 *)((long)puVar12 + 0x2c) = uVar10;
      puVar12[6] = 0x800000008;
      lVar18 = FUN_0007ef4c();
      if (lVar18 != 0) goto LAB_000973dc;
      goto LAB_00097a18;
    }
    puVar12 = (undefined8 *)FUN_000d10c8();
    *puVar12 = 0xe0ef0;
    puVar12[1] = param_5;
    uVar10 = DAT_00016840;
    uVar15 = *param_5;
    puVar12[3] = param_6;
    puVar12[4] = 0;
    *(undefined8 *)((long)puVar12 + 0x2c) = uVar10;
    puVar12[2] = uVar15;
    *(uint *)((long)puVar12 + 0x34) = param_7;
    *(undefined4 *)(puVar12 + 7) = param_8;
    lVar18 = FUN_0007ef4c();
    if ((lVar18 == 0) || (lVar18 = FUN_000d3878(), lVar18 == 0)) {
      uVar10 = 0;
    }
    else {
      uVar10 = FUN_00097da4();
    }
    FUN_000d59c8();
  }
  FUN_000d84e4();
LAB_00097b44:
  FUN_000d0774();
  FUN_000d04a4();
  if (*(long *)(unaff_x27 + 0x28) == local_68) {
    FUN_000cfdf0(uVar10);
    return;
  }
                    /* WARNING: Subroutine does not return */
  FUN_000d8770();
}

