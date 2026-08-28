CREATE EXTENSION IF NOT EXISTS vector;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE IF NOT EXISTS deliveries (
    id BIGSERIAL PRIMARY KEY,
    tracking_code VARCHAR(50) UNIQUE NOT NULL,
    customer_name VARCHAR(100) NOT NULL,
    hub_code VARCHAR(20) NOT NULL,
    status VARCHAR(30) NOT NULL,
    cod_amount DECIMAL(12,2) DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX IF NOT EXISTS idx_deliveries_tracking_code ON deliveries(tracking_code);
CREATE INDEX IF NOT EXISTS idx_deliveries_hub_code ON deliveries(hub_code);
CREATE INDEX IF NOT EXISTS idx_deliveries_status ON deliveries(status);
CREATE TABLE IF NOT EXISTS incidents (
    id BIGSERIAL PRIMARY KEY,
    tracking_code VARCHAR(50) NOT NULL,
    incident_type VARCHAR(50) NOT NULL,
    hub_code VARCHAR(20) NOT NULL,
    severity VARCHAR(20) NOT NULL,
    description TEXT NOT NULL,
    status VARCHAR(30) DEFAULT 'OPEN',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE INDEX IF NOT EXISTS idx_incidents_tracking_code ON incidents(tracking_code);
CREATE INDEX IF NOT EXISTS idx_incidents_hub_code ON incidents(hub_code);
CREATE INDEX IF NOT EXISTS idx_incidents_status ON incidents(status);
CREATE TABLE IF NOT EXISTS vector_store (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    content TEXT NOT NULL,
    metadata JSONB DEFAULT '{}',
    embedding vector(1536)
);
CREATE INDEX IF NOT EXISTS idx_vector_store_embedding ON vector_store USING hnsw (embedding vector_cosine_ops);
