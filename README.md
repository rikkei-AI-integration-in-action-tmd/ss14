SS14 - MINI PROJECT: SMARTHUB AI-POWERED SMART LOGISTICS OPERATIONS CENTER

1. TONG QUAN DU AN
SmartHub la he thong Trung tam dieu hanh va ho tro van tai thong minh tich hop Tri tue nhan tao (AI) phuc vu doanh nghiep logistics RikkeiExpress, bao gom 4 chuyen de nghien cuu trong tam:
- Chuyen de 1: He thong RAG tra cuu quy che van chuyen voi chien luoc Chunking & Vector DB.
- Chuyen de 2: Tro ly van hanh tu dong xu ly su co voi Agent & Function Calling.
- Chuyen de 3: Ung dung Model Context Protocol (MCP) trong doi soat du lieu va phong ve SQL an toan.
- Chuyen de 4: He thong do luong va danh gia chi phi LLMOps voi Langfuse & OpenTelemetry.

2. NEN TANG CONG NGHE & CAU TRUC DU AN
- Ngon ngu: Java 17 / 21 LTS
- Framework: Spring Boot 3.3.5, Spring AI 1.0.0-M6
- Co so du lieu: PostgreSQL + PgVector Extension (Supabase Cloud / Local Docker)
- Giao thuc & Giam sat: Model Context Protocol (Stdio Transport), Langfuse / OpenTelemetry Tracing

3. DANH SACH ENTITY VA BANG CO SO DU LIEU
3.1. Bang "deliveries" (Entity Delivery):
- id: BIGSERIAL, Primary Key
- tracking_code: VARCHAR(50), UNIQUE, NOT NULL (Ma van don)
- customer_name: VARCHAR(100), NOT NULL (Ten khach hang)
- hub_code: VARCHAR(20), NOT NULL (Ma buu cuc/kho xu ly)
- status: VARCHAR(30), NOT NULL (IN_TRANSIT, DELIVERED, DELAYED, DAMAGED)
- cod_amount: DECIMAL(12,2), DEFAULT 0 (Tien thu ho COD)
- created_at: TIMESTAMP, DEFAULT CURRENT_TIMESTAMP

3.2. Bang "incidents" (Entity Incident):
- id: BIGSERIAL, Primary Key
- tracking_code: VARCHAR(50), NOT NULL (Ma van don)
- incident_type: VARCHAR(50), NOT NULL (HONG_HOC, GIAO_TRE, THAT_LAC)
- hub_code: VARCHAR(20), NOT NULL (Ma buu cuc)
- severity: VARCHAR(20), NOT NULL (LOW, MEDIUM, CRITICAL)
- description: TEXT, NOT NULL (Noi dung mo ta chi tiet)
- status: VARCHAR(30), DEFAULT 'OPEN' (OPEN, IN_PROGRESS, RESOLVED)
- created_at: TIMESTAMP, DEFAULT CURRENT_TIMESTAMP

3.3. Bang "vector_store" (PgVector Store):
- id: UUID, Primary Key
- content: TEXT, NOT NULL
- metadata: JSONB, DEFAULT '{}'
- embedding: vector(1536) / vector(768)

4. DANH SACH DTO & TOOL SCHEMAS
- Module RAG: RagQueryRequest, RagQueryResponse, SourceDocumentDto, DocumentIngestRequest, DocumentIngestResponse.
- Module Operations/Agent: OperationsChatRequest, OperationsChatResponse, DeliveryDto, IncidentDto.
- Module Function Calling Tools: CreateIncidentInput, CreateIncidentOutput, UpdateDeliveryStatusInput, UpdateDeliveryStatusOutput, GetDeliveryInfoInput, GetDeliveryInfoOutput.
- Module MCP Analytics: McpQueryRequest, McpQueryResponse, HubAnalyticsDto, SafeSqlValidationResult.
- Module LLMOps: TraceMetricsDto, LangfuseScoreRequest.
- Common: ApiResponse, ErrorResponse.

5. CAU HINH HE THONG
- application.yml: Cau hinh trung tam, HikariCP, Pgvector, OpenTelemetry exporter sang Langfuse, Stdio Pollution defense.
- application-cloud.yml: Profile Cloud voi OpenAI / OpenRouter LLM va Embedding text-embedding-3-small (1536 dim).
- application-local.yml: Profile Local voi Ollama qwen2.5:1.5b va nomic-embed-text (768 dim).
- logback-spring.xml: Dieu huong toan bo log sang System.err de bao ve duong truyen JSON-RPC cua MCP.
- schema.sql & data.sql: Khoi tao cau truc bang va du lieu mau.
