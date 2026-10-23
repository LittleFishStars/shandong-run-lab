import React, { useEffect, useRef, useState } from 'react';

/* 摇杆：拖动产生方向与力度（0..1），松手即停；也支持方向键 */
export default function Joystick({ onMove, onEnd, disabled }) {
  const boxRef = useRef(null);
  const knobRef = useRef(null);
  const [active, setActive] = useState(false);
  const state = useRef({ down: false, key: null });

  const apply = (dx, dy) => {
    const box = boxRef.current;
    if (!box) return;
    const r = box.getBoundingClientRect();
    const rad = r.width / 2 - 10;
    const len = Math.hypot(dx, dy);
    const mag = Math.min(1, len / rad);
    if (mag < 0.02) {
      // 中心死区：只回中并发 0，不能结束拖动（否则按下后再拖就失效）
      if (knobRef.current) knobRef.current.style.transform = '';
      onMove && onMove(0, 0, 0);
      return;
    }
    // 后端约定：dx/dy 是单位方向（东/北为正），mag ∈ [0,1] 是推杆幅度；
    // 屏幕 y 向下为正，向北要取反，否则上下会翻转
    const east = dx / (len || 1);
    const north = -dy / (len || 1);
    const kx = east * mag * rad * 0.72;
    const ky = -north * mag * rad * 0.72;
    if (knobRef.current) knobRef.current.style.transform = `translate(${kx.toFixed(1)}px, ${ky.toFixed(1)}px)`;
    onMove && onMove(east, north, mag);
  };

  const reset = () => {
    if (knobRef.current) knobRef.current.style.transform = '';
    setActive(false);
    state.current.down = false;
    onEnd && onEnd();
  };

  useEffect(() => {
    const onKey = (e) => {
      if (disabled) return;
      const map = { ArrowUp: [0, -1], ArrowDown: [0, 1], ArrowLeft: [-1, 0], ArrowRight: [1, 0] };
      if (!map[e.key]) return;
      e.preventDefault();
      setActive(true);
      apply(map[e.key][0] * 100, map[e.key][1] * 100);
    };
    const onKeyUp = (e) => {
      if (['ArrowUp', 'ArrowDown', 'ArrowLeft', 'ArrowRight'].includes(e.key)) reset();
    };
    window.addEventListener('keydown', onKey);
    window.addEventListener('keyup', onKeyUp);
    return () => {
      window.removeEventListener('keydown', onKey);
      window.removeEventListener('keyup', onKeyUp);
    };
  }, [disabled]);

  const onPointerDown = (e) => {
    if (disabled) return;
    e.currentTarget.setPointerCapture?.(e.pointerId);
    state.current.down = true;
    setActive(true);
    const box = boxRef.current.getBoundingClientRect();
    apply(e.clientX - (box.left + box.width / 2), e.clientY - (box.top + box.height / 2));
  };
  const onPointerMove = (e) => {
    if (!state.current.down) return;
    const box = boxRef.current.getBoundingClientRect();
    apply(e.clientX - (box.left + box.width / 2), e.clientY - (box.top + box.height / 2));
  };
  const onPointerUp = () => {
    if (state.current.down) reset();
  };

  return (
    <div
      ref={boxRef}
      className={`joy${active ? ' active' : ''}`}
      onPointerDown={onPointerDown}
      onPointerMove={onPointerMove}
      onPointerUp={onPointerUp}
      onPointerCancel={onPointerUp}
    >
      <div className="joy-ring" />
      <div className="joy-knob" ref={knobRef} />
    </div>
  );
}
