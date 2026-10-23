import React from 'react';

/* 自绘移动端组件，替代 antd（不引入 antd，体积与触屏体验优先）。
   所有组件保持 antd 同名 API 的 JSX 调用点。 */

/* ── Button ── */
export function Button({ children, type, shape, size, loading, disabled, className, onClick, ...rest }) {
  const cls = [
    'mb-btn',
    type === 'primary' ? 'primary' : '',
    shape === 'circle' ? 'circle' : '',
    size === 'small' ? 'small' : '',
    loading ? 'loading' : '',
    className || '',
  ].filter(Boolean).join(' ');
  return (
    <button
      type="button"
      className={cls}
      disabled={disabled || loading}
      onClick={onClick}
      {...rest}
    >
      {loading ? <span className="mb-spin" /> : null}
      {children}
    </button>
  );
}

/* ── Input ── */
export function Input({ value, onChange, placeholder, type, onPressEnter, ...rest }) {
  const handleKey = onPressEnter
    ? (e) => { if (e.key === 'Enter') onPressEnter(e); }
    : undefined;
  return (
    <input
      className="mb-input"
      type={type || 'text'}
      value={value}
      placeholder={placeholder}
      onChange={onChange}
      onKeyDown={handleKey}
      {...rest}
    />
  );
}

Input.Password = function Password({ value, onChange, placeholder, ...rest }) {
  return (
    <input
      className="mb-input"
      type="password"
      value={value}
      placeholder={placeholder}
      onChange={onChange}
      {...rest}
    />
  );
};

/* ── Input.Number（模拟 antd InputNumber） ── */
export function InputNumber({ value, min, max, step, onChange, ...rest }) {
  return (
    <input
      className="mb-input"
      type="number"
      value={value == null ? '' : value}
      min={min}
      max={max}
      step={step}
      onChange={(e) => {
        const v = e.target.value === '' ? null : Number(e.target.value);
        if (onChange) onChange(v);
      }}
      {...rest}
    />
  );
}

/* ── Select：底部滑出式选项面板（触屏友好） ── */
export function Select({ value, options = [], onChange, disabled, placeholder }) {
  const [open, setOpen] = React.useState(false);
  const sel = (options || []).find((o) => String(o.value) === String(value));
  return (
    <>
      <button
        type="button"
        className="mb-select"
        disabled={disabled}
        onClick={() => setOpen(!open)}
      >
        <span className="mb-select-value">{sel ? sel.label : (placeholder || '请选择')}</span>
        <span className="mb-select-arrow">▾</span>
      </button>
      {open ? (
        <div className="mb-mask" onClick={() => setOpen(false)}>
          <div className="mb-sheet" onClick={(e) => e.stopPropagation()}>
            <div className="mb-sheet-title">请选择</div>
            <div className="mb-sheet-body">
              <div className="mb-select-options">
                {(options || []).map((o) => (
                  <button
                    key={String(o.value)}
                    type="button"
                    className={`mb-select-option${String(o.value) === String(value) ? ' sel' : ''}`}
                    onClick={() => { if (onChange) onChange(o.value); setOpen(false); }}
                  >
                    {o.label}
                  </button>
                ))}
              </div>
            </div>
          </div>
        </div>
      ) : null}
    </>
  );
}

/* ── Modal：居中卡片 ── */
export function Modal({ title, open, onCancel, children, footer }) {
  if (!open) return null;
  return (
    <div className="mb-modal-mask" onClick={onCancel}>
      <div className="mb-modal" onClick={(e) => e.stopPropagation()}>
        {title ? <div className="mb-modal-title">{title}</div> : null}
        <div className="mb-modal-body">{children}</div>
        {footer ? <div className="mb-modal-footer">{footer}</div> : null}
      </div>
    </div>
  );
}

/* ── message / Toast ── */
export function showToast(text, kind) {
  if (!document.getElementById('mb-toast-root')) {
    const div = document.createElement('div');
    div.id = 'mb-toast-root';
    document.body.appendChild(div);
  }
  const root = document.getElementById('mb-toast-root');
  const el = document.createElement('div');
  el.className = `mb-toast ${kind || ''}`;
  el.textContent = text;
  root.appendChild(el);
  setTimeout(() => { el.classList.add('show'); }, 10);
  setTimeout(() => { el.classList.remove('show'); setTimeout(() => el.remove(), 200); }, 2200);
}

export const message = {
  success: (t) => showToast(t, 'ok'),
  error: (t) => showToast(t, 'err'),
  info: (t) => showToast(t, ''),
  warn: (t) => showToast(t, 'warn'),
};

/* ── Spin ── */
export function Spin({ size }) {
  return <span className={`mb-spin${size === 'large' ? ' large' : ''}`} />;
}

/* ── Typography ── */
export const Typography = {
  Text: ({ children, type, style }) => (
    <span className={`mb-text${type === 'secondary' ? ' secondary' : ''}`} style={style}>{children}</span>
  ),
};

/* ── List ── */
export function List({ dataSource, renderItem, className }) {
  return (
    <div className={`mb-list ${className || ''}`}>
      {(dataSource || []).map((item, i) => renderItem(item, i))}
    </div>
  );
}
List.Item = function ListItem({ children, className }) {
  return <div className={`mb-list-item ${className || ''}`}>{children}</div>;
};

/* ── Checkbox ── */
export function Checkbox({ checked, onChange, children }) {
  return (
    <label className="mb-checkbox">
      <input
        type="checkbox"
        checked={checked}
        onChange={onChange}
      />
      <span className="mb-checkbox-label">{children}</span>
    </label>
  );
}

/* ── Radio.Group / Radio.Button（地图右上角瓦片切换） ── */
export function RadioGroup({ value, onChange, children, className }) {
  const kids = React.Children.map(children, (child) => {
    if (!child) return null;
    return React.cloneElement(child, {
      active: child.props.value === value,
      onPick: () => onChange && onChange({ target: { value: child.props.value } }),
    });
  });
  return <div className={`mb-radio-group ${className || ''}`}>{kids}</div>;
}

export function RadioButton({ children, active, onPick }) {
  return (
    <button type="button" className={`mb-radio-btn${active ? ' active' : ''}`} onClick={onPick}>
      {children}
    </button>
  );
}
export const Radio = { Group: RadioGroup, Button: RadioButton };