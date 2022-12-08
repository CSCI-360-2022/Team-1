# Operation Contracts


# System
## Contract C01: Log in to System
| Operation       | login(username : String, password : String) : String                                            |
|-----------------|-------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Logging In                                                                           |
| Preconditions   | User has entered in login info to respective text areas                                         |
| Postconditions  | The user is logged into the site or is given a failure message if their login info is not valid |
## Contract C02: Display Add Event Page
| Operation       | displayAddEventPage() : String                               |
|-----------------|--------------------------------------------------------------|
| Cross Reference | GUI way to add events. Not necessarily a part of the website |
| Preconditions   | None                                                         |
| Postconditions  | GUI with a way to add an event to the database displayed     |
## Contract C03: Select Event
| Operation       | selectEvent(eventID: int, model: Model) : String                                                                                                                            |
|-----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Searching for an Event                                                                                                                                           |
| Preconditions   | User has clicked on an event on the search page.                                                                                                                            |
| Postconditions  | The user was directed to the event page for the event specified by event ID. The product details page was populated with the event data of the event specified by event id. |
## Contract C04: Purchase
| Operation       | purchase(eventID: int, cardNumber: String, expDate: String, cvv: int, zipCode: int, model: Model) : String                               |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchasing a ticket                                                                                                           |
| Preconditions   | User has confirmed the purchase                                                                                                          |
| Postconditions  | If the payment info was vaild, go to the purchase success screen and decrement seats left for the event, otherwise go to an error screen |
## Contract C05: Cancel Purchase
| Operation       | cancelPurchase(eventId : int, model Model) : String                                                 |
|-----------------|-----------------------------------------------------------------------------------------------------|
| Cross Reference | Misuse Case: Accidental Purchase of a Ticket                                                        |
| Preconditions   | User selected the cancel purchase button on the confirm purchase screen                             |
| Postconditions  | The user was redirected back to the product details screen through a call of the selectEvent method |
## Contract C06: AddEvent
| Operation       | addEvent(eventName : String, description: String, price: double, seatsLeft: int, tags: String, location: String, date: String) : String |
|-----------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | GUI way to add events. Not necessarily a part of the website                                                                            |
| Preconditions   | User has pressed the add event button on the add event gui page                                                                         |
| Postconditions  | A new event object was added to the database with the following above parameters                                                        |
## Contract C07: Password Hash
| Operation       | hash(password : String) : String                                                                            |
|-----------------|-------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Logging In, Creating an Account                                                                  |
| Preconditions   | The users un-hashed password was provided to the back end when the user creates an account or is logging in |
| Postconditions  | The password was hashed using SHA-256 and returned by the method                                            |
## Contract C08: Confirm Purchase
| Operation       | confirmPurchase(eventID: int, cardNumber: String, expDate: String, cvv: int, zipCode: int) : String                                                                                  |
|-----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Misuse Case: Accidental Purchase of a Ticket                                                                                                                                         |
| Preconditions   | User must have already selected to purchase a ticket for some event and filled out their payment details                                                                             |
| Postconditions  | A confirmation option was sent to the UI of the user. The user can select whether or not they confirm the purchase of their ticket. If Yes: purchase(id). Else: cancel purchase(id). | 
## Contract C09: Confirm Login
| Operation       | confirmLogin(username: String, password: String, service: Service) : boolean                                                                                                                                                                                                |
|-----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Case: Logging In                                                                                                                                                                                                                                                        |
| Preconditions   | User entered in their login details and hit the login button in the GUI                                                                                                                                                                                                     |
| Postconditions  | The username was checked to see if there exists a user in the database. If not, return false. If true, the password was hashed and checked to see if it matches the hashed password listed in the database. If they match, true was returned. Otherwise, false was returned | 
## Contract C10: Display Register Page
| Operation       | displayRegisterPage() : String             |
|-----------------|--------------------------------------------|
| Cross Reference | Use Case: Creating an Account              |
| Preconditions   | User hit the register button on any screen |
| Postconditions  | The register UI was displayed              |
## Contract C11: Create User
| Operation       | createUser(email: String, username: String, password: String, model: Model) : String                                                                                                                                                                                                                                                                                                                                                                                                                                           |
|-----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Case: Creating an Account                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| Preconditions   | User entered in account info on the register UI page and pressed the register button                                                                                                                                                                                                                                                                                                                                                                                                                                           |
| Postconditions  | The username is checked to see if it already exists in the database and the password is checked to see if it matches MVP requirements (15 letters, lowercase & uppercase letters, at least 1 number, at least one special characters). If a user already exists in the database with the username provided or the password did not comply with requirements, the user was taken to an error screen. Otherwise, the password was hashed, the user was added to the database, and the user is redirected back to the home screen | 
## Contract C12: Start Purchase
| Operation       | startPurchase(evnetId : int, model: Model) : String                                                                                                                                                                                                                                    |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Case: Purchasing a Ticket, Abuse Case: Buying all of a tickets stock (Scalping)                                                                                                                                                                                                    |
| Preconditions   | User clicked the buy now on the product page                                                                                                                                                                                                                                           |
| Postconditions  | If the buy now button was clicked 5 times in the last 5 seconds (can be adjusted), return an error. If the user is not logged in, display the login screen. If event has no seats left, return an error. Otherwise, go to the purchase UI screen and add the event details to the page | 
## Contract C13: Display Login Page
| Operation       | displayLoginPage()                        |
|-----------------|-------------------------------------------|
| Cross Reference | Use Case: Logging In                      |
| Preconditions   | User pressed the login button on any page |
| Postconditions  | The login UI page was displayed           | 

# User, Event, Receipt, and PaymentInfo
## Contract C14: Get Attribute
| Operation       | getAttribute()          |
|-----------------|-------------------------|
| Cross Reference | Use Case: All           |
| Preconditions   | Object was instantiated |
| Postconditions  | Attribute was returned  |

# User, Event, and Receipt
## Contract C15: Set Attribute
| Operation       | setAttribute(attribute: ObjectType)           |
|-----------------|-----------------------------------------------|
| Cross Reference | Use Case: All                                 |
| Preconditions   | Object was instantiated                       |
| Postconditions  | The old attribute was replaced with attribute |

# Receipt
## Contract C16: Build Receipt (Unused)
| Operation       | buildReciept() : String                                            |
|-----------------|--------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchasing a Ticket                                     |
| Preconditions   | Receipt object created and has all of its fields filled with info. |
| Postconditions  | A string is created with all of the fields needed for a receipt    |

# Service
## Contract C17: Find User
| Operation       | findUser(userId: int) : User              |
|-----------------|-------------------------------------------|
| Cross Reference | Use Cases: All                            |
| Preconditions   | User with specified id is in the database |
| Postconditions  | User with specified id was returned       |
## Contract C18: Find Event
| Operation       | findEvent(eventId: int) : Event            |
|-----------------|--------------------------------------------|
| Cross Reference | Use Cases: All                             |
| Preconditions   | Event with specified id is in the database |
| Postconditions  | Event with specified id was returned       |
## Contract C19: Save Event
| Operation       | saveEvent(event: Event)                           |
|-----------------|---------------------------------------------------|
| Cross Reference | Use Cases: All                                    |
| Preconditions   | event is not null                                 |
| Postconditions  | Event with specified id was saved to the database |
## Contract C20: Delete By User ID
| Operation       | deleteUserById(userId: int)                   |
|-----------------|-----------------------------------------------|
| Cross Reference | Test cases                                    |
| Preconditions   | User with specified id is in the database     |
| Postconditions  | User with specified id was removed from the database |
## Contract C21: Find User by Username
| Operation       | findUser(username: String) : User               |
|-----------------|-------------------------------------------------|
| Cross Reference | Use Cases: All                                  |
| Preconditions   | User with specified username is in the database |
| Postconditions  | User with specified username was returned       |
## Contract C22: Update Event
| Operation       | updateEvent(event: Event, eventId: int)                         |
|-----------------|-----------------------------------------------------------------|
| Cross Reference | Use Cases: Purchasing a Ticket                                  |
| Preconditions   | Event with specified id is in the database                      |
| Postconditions  | Event with specified id was replaced with event in the database |
## Contract C23: Save User
| Operation       | saveUser(user: User)                             |
|-----------------|--------------------------------------------------|
| Cross Reference | Use Cases: All                                   |
| Preconditions   | user is not null                                 |
| Postconditions  | User with specified id was saved to the database |
## Contract C24: Delete Event By Id
| Operation       | deleteEventById(eventId: int)                         |
|-----------------|-------------------------------------------------------|
| Cross Reference | Test cases                                            |
| Preconditions   | Event with specified id is in the database            |
| Postconditions  | Event with specified id was removed from the database |
## Contract C25: Find Events
| Operation       | findEvents(searchTerm: String, tags: String[]) : List<Event>                 |
|-----------------|------------------------------------------------------------------------------|
| Cross Reference | Searching for an event                                                       |
| Preconditions   | Search term is not null                                                      |
| Postconditions  | A list of events that are related to the search terms and tags were returned |
# UserRepository
## Contract C26: Find By User ID (Unused)
| Operation       | findByUserID(userId: int) : User          |
|-----------------|-------------------------------------------|
| Cross Reference | None                                      |
| Preconditions   | User with specified id is in the database |
| Postconditions  | User with specified id was returned       |
## Contract C27: Delete By Username (Unused)
| Operation       | deleteUserById(username: String) : User                |
|-----------------|--------------------------------------------------------|
| Cross Reference | None                                                   |
| Preconditions   | User with specified username is in the database        |
| Postconditions  | User with specified user was removed from the database |
## Contract C28: Find By Username
| Operation       | findUser(username: String) : User               |
|-----------------|-------------------------------------------------|
| Cross Reference | Use Cases: All                                  |
| Preconditions   | User with specified username is in the database |
| Postconditions  | User with specified username was returned       |
# EventRepository
## Contract C29: Find By Event ID (Unused)
| Operation       | findEvent(eventId: int) : Event            |
|-----------------|--------------------------------------------|
| Cross Reference | Use Cases: All                             |
| Preconditions   | Event with specified id is in the database |
| Postconditions  | Event with specified id was returned       |
## Contract C30: Search for Events
| Operation       | findEventsByEventNameContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrDescriptionContainsIgnoreCaseOrderByEventName(name: String, description: String, tags: String) : List<Event> |
|-----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Searching for an event                                                                                                                                                               |
| Preconditions   | None                                                                                                                                                                                 |
| Postconditions  | A list of events that are related to the name, description, and tags were returned                                                                                                   |
# PaymentSystem
## Contract C31: Sum Odd
| Operation       | sumodd(cnumber: long) : int               |
|-----------------|-------------------------------------------|
| Cross Reference | Use Cases: Purchase a Ticket              |
| Preconditions   | none                                      |
| Postconditions  | Return sum of odd-place digits in cnumber |
## Contract C32: Prefix Match
| Operation       | prefixmatch(cnumber: long, d int) : boolean                                |
|-----------------|----------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchase a Ticket                                               |
| Preconditions   | none                                                                       |
| Postconditions  | Return true if the digit d is a prefix for cnumber. Otherwise return false |
## Contract C33: Get Digit
| Operation       | getDigit(cnumber: int) : int                                                             |
|-----------------|------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchase a Ticket                                                             |
| Preconditions   | none                                                                                     |
| Postconditions  | Return this cnumber if it is a single digit, otherwise, return the sum of the two digits |
## Contract C34: Get Prefix
| Operation       | getprefix(cnumber: int, k int) : long                                                                               |
|-----------------|---------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchase a Ticket                                                                                        |
| Preconditions   | none                                                                                                                |
| Postconditions  | Return the first k number of digits from cnumber. If the number of digits in number is less than k, return cnumber. |
## Contract C35: Number of Digits
| Operation       | thesize(d: long) : int           |
|-----------------|----------------------------------|
| Cross Reference | Use Cases: Purchase a Ticket     |
| Preconditions   | none                             |
| Postconditions  | Return the number of digits in d |
## Contract C36: Check Payment
| Operation       | checkPayment(paymentInfo: PaymentInfo) : boolean                                          |
|-----------------|-------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchase a Ticket                                                              |
| Preconditions   | paymentInfo is instantiated                                                               |
| Postconditions  | Return true if the fields of paymentInfo are set to valid values. Otherwise, return false |
## Contract C37: Sum Double Even
| Operation       | sumdoubleeven(cnumber: long) : int                   |
|-----------------|------------------------------------------------------|
| Cross Reference | Use Cases: Purchase a Ticket                         |
| Preconditions   | none                                                 |
| Postconditions  | Return the sum of all even digits in cnumber doubled |
# Csci360TeamProjectApplication
## Contract C38: Main
| Operation       | main(args: String[])     |
|-----------------|--------------------------|
| Cross Reference | Use Cases: All           |
| Preconditions   | None                     |
| Postconditions  | The project was launched |


