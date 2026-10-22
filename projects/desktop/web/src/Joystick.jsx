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
    const max = r.width / 2 - 12;
    const len = Math.hypot(dx, dy) || 1;
    const scale = Math.min(max, len) / len;
    const x = dx * scale, y = dy * scale;
    if (knobRef.current) knobRef.current.style.transform = `translate(${x}px, ${y}px)`;
    onMove && onMove(dx / max, dy / max, Math.min(1, len / max));
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
