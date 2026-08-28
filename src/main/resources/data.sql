INSERT INTO deliveries (tracking_code, customer_name, hub_code, status, cod_amount, created_at)
VALUES
    ('RK-2026-001', 'Nguyen Van A', 'HN-01', 'IN_TRANSIT', 150000.00, CURRENT_TIMESTAMP - INTERVAL '2 days'),
    ('RK-2026-002', 'Tran Thi B', 'SG-02', 'DELIVERED', 0.00, CURRENT_TIMESTAMP - INTERVAL '3 days'),
    ('RK-2026-003', 'Le Van C', 'DN-03', 'DELAYED', 350000.00, CURRENT_TIMESTAMP - INTERVAL '5 days'),
    ('RK-2026-004', 'Pham Minh D', 'HN-01', 'DAMAGED', 500000.00, CURRENT_TIMESTAMP - INTERVAL '1 days'),
    ('RK-2026-005', 'Hoang Quoc E', 'SG-02', 'IN_TRANSIT', 200000.00, CURRENT_TIMESTAMP)
ON CONFLICT (tracking_code) DO NOTHING;
INSERT INTO incidents (tracking_code, incident_type, hub_code, severity, description, status, created_at)
VALUES
    ('RK-2026-004', 'HỎNG_HÓC', 'HN-01', 'CRITICAL', 'Hàng bị va đập vỡ hộp carton trong quá trình bốc xếp tại kho Hà Nội', 'OPEN', CURRENT_TIMESTAMP - INTERVAL '1 days'),
    ('RK-2026-003', 'GIAO_TRỄ', 'DN-03', 'MEDIUM', 'Xe trung chuyển bị tắc đường do thời tiết xấu', 'IN_PROGRESS', CURRENT_TIMESTAMP - INTERVAL '2 days')
ON CONFLICT DO NOTHING;
