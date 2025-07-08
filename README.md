
---

```
Faqry Challenge.2
Quantum book store: Starting comprehensive tests...

--- testing book addition ---
Quantum book store: Added book - 'Networks' by Ahmed Nasr (ISBN: 1, Year: 2004, Price: $15.99) [Paper Book - Stock: 50]
Quantum book store: Added book - 'Data Structure' by Hazem Zidan (ISBN: 2, Year: 2008, Price: $29.99) [EBook - Format: PDF]
Quantum book store: Added book - 'Operating Systems' by Abdelrahman Sherif (ISBN: 3, Year: 2015, Price: $20.99) [Showcase Book - Not for Sale]
Quantum book store: Added book - 'Algorithms' by Nour Mohamed (ISBN: 4, Year: 2005, Price: $8.99) [Paper Book - Stock: 25]
Quantum book store: Added 4 books to inventory

--- testing book purchases ---
Quantum book store: Purchase test failed: Quantum book store: Book with ISBN '15' not found in inventory!

---- testing outdated book removal ---
Quantum book store: Added book - 'Programming' by Mostafa Amr (ISBN: 17, Year: 2025, Price: $5.99) [Paper Book - Stock: 10]
Quantum book store: Checking for outdated books (older than 20 years)...
Quantum book store: No outdated books found.
Quantum book store: Removed 0 outdated books

--- testing error handling ---
Quantum book store: Correctly caught error: Quantum book store: Book with ISBN 'INVALID-ISBN' not found in inventory!
Exception in thread "main" java.lang.IllegalArgumentException: Quantum book store: Book with ISBN '20' not found in inventory!
	at services.QuantumBookstore.buyBook(QuantumBookstore.java:50)
	at QuantumBookstoreFullTest.testErrorHandling(Main.java:88)
	at QuantumBookstoreFullTest.runAllTests(Main.java:18)
	at QuantumBookstoreFullTest.main(Main.java:155)

Process finished with exit code 1
```

---



