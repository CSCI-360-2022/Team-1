# System 
Deals with fetching events from DB, returning information back to the user, changing webpages, creating and managing users, sending receipts, and creating payment info objects. Contains a PaymentSystem object for dealing with payments and creating receipt objects. System also is our go-between between the UI and backend. For example: A person clicks the create account button on the GUI. System changes the page to a registration page. The person enters the relevant info to create an account and hits the create account button. The system then calls its createUser method which creates a new user and adds it to a DB. The system then changes the webpage back to the home screen (or to a webpage containing user info if we have time).
# PaymentSystem
Manages verification of payment and receipt creation. For example, the System passes to the payment system payment info. The payment system verifies that it is valid and returns true back to the System. System then asks the payment system to create a receipt using the payment info, user, and event. The payment then returns a receipt object that the System can then send to an email address.
# Event
A basic storage object for data associated with events. Data includes id, name, date, an image, description, price, seats left, and tags.
# User
A basic storage object for data associated with users. Data includes username, password hash, email, user id, and a history of events viewed.
# Receipt
An object containing all the data in a receipt. Data includes total amount paid, the event bought, the user who bought the ticket, date of purchase, and a transaction id. Receipt objects, using this data, can build a receipt. The process of building a receipt involves taking all the data above and turning it into a single string. System would call this build method on the receipts before creating an email response.
# PaymentInfo
A basic storage object containing all the data necessary for completing a purchase. Data includes, card number, expiration date, cvv, zip code and any other info not included here needed to complete a purchase.