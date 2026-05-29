# E-Commerce MVP Management System

A simple Java console app where a customer picks products from a catalog and gets an order summary with total price and receipt.

---

## Contributors
- Nahom ketema — [https://github.com/nahomnnm](https://github.com/nahomnnm)
- Natnael Solomon — [https://github.com/Nati200](https://github.com/partner-username)

---




---

## Files

- Order.java — base class for all orders
- PhysicalOrder.java — order with shipping fee
- DigitalOrder.java — order with download link
- Product.java — products in the catalog
- ECommerceSystem.java — runs the program

---

## OOP Concepts

**Classes and Objects**
- Classes defined in all 5 files
- Objects created in ECommerceSystem.java lines 13–18 and 54–56

**Encapsulation**
- Private fields in Order.java lines 7–9
- Getters in Order.java lines 19–21
- Setter with validation in Order.java lines 24–30

**Inheritance**
- PhysicalOrder extends Order — PhysicalOrder.java line 3
- DigitalOrder extends Order — DigitalOrder.java line 3
- super() used in both subclasses line 11

**Polymorphism**
- calculateTotal() overridden in PhysicalOrder.java line 22 and DigitalOrder.java line 22
- displayOrderSummary() overridden in PhysicalOrder.java line 29 and DigitalOrder.java line 29
- sendNotification overloaded in ECommerceSystem.java lines 100 and 105
- List of Order holds both subclasses — ECommerceSystem.java line 22