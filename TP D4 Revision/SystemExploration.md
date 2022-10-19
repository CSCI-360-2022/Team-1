# System
### What the object knows
The System object is responsible for having a PaymentSystem object
### What the object does
The System object is responsible for requesting events from the database, searching for events based off of a search term, collecting data on what the user clicks on, changing the webpage, logging a user in, creating a new user, creating payment information, and emailing receipts.

# PaymentSystem
### What the object knows
The PaymentSystem object is not responsible for knowing anything
### What the object does
The PaymentSystem object is responsible for checking if a payment is valid, conducting transactions, and creating receipts

# Event
### What the object knows
The Event object is responsible for knowing its id, name, date, image, description, price, remaining seats, and any tags the event has
### What the object does
The Event object is responsible for getting and setting the things it knows

# User
### What the object knows
The User object is responsible for knowing a user's email, username, id, hashed password, and search history
### What the object does
The User object is responsible for getting and setting the things it knows

# Receipt
### What the object knows
The Receipt object knows the payment total, the event id, the customer id, the date, and a transaction id
### What the object does
The Receipt object is responsible for getting and setting the things it knows as well as building a receipt string

# PaymentInfo
### What the object knows
The PaymentInfo object is responsible for knowing a card number, expiration date, cvv, zip code, and any other info needed to carry out a transaction
### What the object does
The PaymentInfo object is responsible for getting and setting the things it knows