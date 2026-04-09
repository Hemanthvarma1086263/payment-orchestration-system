# Payment Orchestration System

## 🧾 Overview

This project is a simplified backend implementation of a **Payment Orchestration System**, inspired by real-world platforms like Yuno.

The system processes payment requests, routes them to appropriate providers, handles failures with retry logic, ensures idempotency, and tracks payment status.

---

## 🏗️ Architecture

```
Client → Controller → Service → Routing → Provider → Database → Idempotency Check
```

### Components:

* **Controller Layer** → Handles API requests
* **Service Layer** → Core business logic
* **Routing Layer** → Decides provider based on payment method
* **Provider Layer** → Simulates external payment providers
* **Persistence Layer** → Stores payment data (H2 DB)
* **Idempotency Logic** → Prevents duplicate transactions

---

## ⚙️ Features Implemented

* ✅ Create Payment API
* ✅ Fetch Payment API
* ✅ Routing Logic

  * CARD → PROVIDER_A
  * UPI → PROVIDER_B
* ✅ Retry & Failover Mechanism
* ✅ Idempotency (Duplicate Request Prevention)
* ✅ Payment Status Tracking (CREATED, SUCCESS, FAILED)

---

## 🔌 APIs

### 1. Create Payment

**POST** `/payments`

#### Request:

```json
{
  "amount": 1000,
  "currency": "INR",
  "paymentMethod": "CARD",
  "requestId": "abc123"
}
```

#### Response:

```json
{
  "id": 1,
  "amount": 1000,
  "currency": "INR",
  "paymentMethod": "CARD",
  "status": "SUCCESS",
  "provider": "PROVIDER_A",
  "requestId": "abc123"
}
```

---

### 2. Fetch Payment

**GET** `/payments/{id}`

#### Response:

```json
{
  "id": 1,
  "amount": 1000,
  "currency": "INR",
  "paymentMethod": "CARD",
  "status": "SUCCESS",
  "provider": "PROVIDER_A"
}
```

---

## 🔁 Retry & Failover Logic

* If the selected provider fails:

  * System automatically retries with another provider
* Ensures higher success rate of transactions

---

## 🔒 Idempotency

* Each request contains a unique `requestId`
* If the same request is sent again:

  * Existing payment is returned
  * No duplicate record is created

---

## 🗄️ Database

* **H2 In-Memory Database** used for simplicity
* Can be replaced with MySQL/PostgreSQL in production

---

## 🧪 Test Cases

Refer to:

```
test-cases.md
```

Includes:

* Sanity tests
* Negative tests
* Retry scenarios
* Idempotency validation

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* H2 Database
* Maven

---

## 🚀 How to Run

1. Clone the repository
2. Open project in STS / IntelliJ
3. Run `PaymentAppApplication`
4. Use Postman to test APIs

---

## 💡 Future Improvements

* Add Redis for idempotency storage
* Implement proper exception handling
* Add unit and integration tests
* Add authentication & security
* Replace mock providers with real integrations

---

## 👨‍💻 Author

Hemanth Varma
