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

## 📥 Input & Output

* **Input:** Payment request JSON containing amount, currency, paymentMethod, and requestId
* **Output:** Payment response containing id, provider, status, and transaction details

---

## 🔁 Retry & Failover Logic

* If the selected provider fails:

  * System retries with an alternative provider
* Improves reliability and success rate

---

## 🔒 Idempotency

* Each request contains a unique `requestId`
* Duplicate requests return the same response instead of creating new records

---

## 🔗 Integration Points

* Routing service integrates with provider services
* Provider services simulate external payment gateways
* Service layer interacts with database using JPA

---

## 🗄️ Database

* **H2 In-Memory Database** used for simplicity
* Can be replaced with MySQL/PostgreSQL in production

---

## ⚡ Non-Functional Requirements

* System should handle concurrent requests efficiently
* Ensures reliability using retry and failover mechanisms
* Idempotency ensures consistency and prevents duplicate transactions

---

## ⚙️ Performance Considerations

* Retry and failover improve transaction success rate
* In-memory database ensures fast operations during development
* Can be scaled using distributed caching (Redis)

---

## 🤖 AI Usage

AI tools were used to assist in structuring the application, generating boilerplate code, and improving development speed. All logic was implemented with proper understanding and validation.

---

## 🧪 Test Cases

Refer to:

```
test-cases.md
```

Includes:

* Sanity tests
* Regression tests
* Integration tests
* Negative scenarios
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

## 👨‍💻 Author Mekala Hemanthvarma

Hemanth Varma
