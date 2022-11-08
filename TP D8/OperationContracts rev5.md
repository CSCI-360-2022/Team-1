# Operation Contracts


## Contract CO1: Find Event

| Operation        | findEvent(eventId : int) : Event                                                         |
|------------------|------------------------------------------------------------------------------------------|
| Cross References | Use Cases: Searching for a Ticket                                                        |
| Preconditions    | An event with the specified id is in the database                                        |
| Postconditions   | An event has been fetched from the database and stored in an event object for future use |

## Contract CO2: Purchase a Ticket
| Operation       | purchase(cardNumber : int, expDate: LocalDate, cvv: int, name : String, address : String, state : String, country : String, zipCode : int)                                                                            |
|-----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchasing a Ticket                                                                                                                                                                                        |
| Preconditions   | User has confirmed that they wish to purchase the ticket, the ticket is available and is not in high demand                                                                                                           |
| Postconditions  | If checkPayment(paymentInfo): A transaction occurred. The user received a receipt via email. The user received confirmation in the UI that the purchase was successful. Else: An error message is displayed in the UI |


## Contract CO3: Search for Event
| Operation       | search(searchTerm : String, tags : String[])                                                                               |
|-----------------|----------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Searching for Events                                                                                            |
| Preconditions   | User typed a term into the search bar and optionally selected tags on what they want to see included in the search results |
| Postconditions  | findEvents(searchTerm, tags) was called and its results displayed back to the user in the UI                               |

## Contract CO4: Start Purchase
| Operation       | startPurchase(eventId : int)                                                                                        |
|-----------------|---------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchasing a Ticket                                                                                      |
| Preconditions   | User clicked the purchase ticket button on an event's page                                                          |
| Postconditions  | checkDemand(eventID) occurred and if that returned false, display purchase page. Otherwise display an error message |

## Contract CO5: Log in to System
| Operation       | login(username : String, password : String)                                                                       |
|-----------------|-------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Logging In                                                                                             |
| Preconditions   | User has entered in login info to respective text areas                                                           |
| Postconditions  | The user is logged into the site (loggedIn = true) or is given a failure message if their login info is not valid |

## Contract CO6: Password Hash
| Operation       | passwordHash(password : String) : String                         |
|-----------------|------------------------------------------------------------------|
| Cross Reference | Use Cases: Logging In, Creating an Account                       |
| Preconditions   | The users unhashed password was provided to the back end         |
| Postconditions  | The password was hashed using SHA-256 and returned by the method |

## Contract CO7: Check Payment Info
| Operation       | checkPayment(paymentInfo: PaymentInfo) : boolean                                     |
|-----------------|--------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchasing a Ticket                                                       |
| Preconditions   | paymentInfo has all the required fields necessary to complete a purchase             |
| Postconditions  | System receives a value true if the payment info is valid and false if it is invalid |

## Contract CO8: Find Events
| Operation       | findEvents(searchTerm : String, tags : String[]) : List<Event>                                                             |
|-----------------|----------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Searching for Events                                                                                            |
| Preconditions   | User typed a term into the search bar and optionally selected tags on what they want to see included in the search results |
| Postconditions  | Events that match the search parameters were fetched from the database (Stored in a List<Event> object)                    |

## Contract CO9: Build Receipt
| Operation       | buildReceipt() : String                                                                                                                |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchasing a Ticket                                                                                                         |
| Preconditions   | Receipt object created and has all of its fields filled with info.                                                                     |
| Postconditions  | A string representation of a receipt was built by the method and was returned. See ExampleReceipt.txt for how the receipt should look. |

## Contract CO10: Email Receipt
| Operation       | emailReceipt(receipt: Receipt, email : String)                    |
|-----------------|-------------------------------------------------------------------|
| Cross Reference | Use Case: Purchasing a Ticket                                     |
| Preconditions   | receipt has all of its fields filled. A transaction has been made |
| Postconditions  | An email has been sent to the user containing a built receipt     |

## Contract CO11: Change Webpage
| Operation       | changeWebpage(htmlFile : File)                       |
|-----------------|------------------------------------------------------|
| Cross Reference | Use Cases: All                                       |
| Preconditions   | The user hit a button that warrants a webpage change |
| Postconditions  | The webpage has been changed to the new webpage      |

## Contract CO12: Create User
| Operation       | createUser(userName: String, password: String, email: String)                                                                   |
|-----------------|---------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Creating an Account                                                                                                  |
| Preconditions   | The user has entered in the required data for creating an account in a UI window                                                |
| Postconditions  | A new user object was created and was added to the database. Confirmation was sent back to the user that an account was created |

## Contract CO13: Check Demand
| Operation       | checkDemand(id : int) : boolean                                                                                                                                                                                                                            |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Abuse case: purchasing all or most of a tickets stock                                                                                                                                                                                                      |
| Preconditions   | Ticket must be purchasable                                                                                                                                                                                                                                 |
| Post conditions | The ticket is checked if its a high seller or if its brand new and if it is the user is unable to purchase requested amount. If neither is true the requested amount is deemed fine to purchase and the user is not aware that the procedure even occurred |

## Contract CO14: Confirm Purchase
| Operation       | confirmPurchase(id : int)                                                                                                                                                        |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Misuse Case- Accidental Purchase of a Ticket                                                                                                                                     |
| Preconditions   | User must have already selected to purchase a ticket for some event                                                                                                              |
| Post-Conditions | A confirmation option is sent to the UI of the user. The user selects whether or not they confirm the purchase of their ticket. If Yes: purchase(id). Else: cancel purchase(id). | 

## Contract CO15: Cancel Purchase
| Operation       | cancelPurchase(id : int)                                                                                          |
|-----------------|-------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Misuse Case- Accidental Purchase of a Ticket                                                                      |
| Preconditions   | User must have already selected to purchase a ticket for some event                                               |
| Post-Conditions | A confirmation option is sent to the UI of the user. The user selects no. The purchase of the ticket is canceled. |

## Contract CO16: Save User
| Operation       | saveUser(user : User)                                          |
|-----------------|----------------------------------------------------------------|
| Cross Reference | Use Cases: Creating an account                                 |
| Preconditions   | A user object has been created with information about the user |
| Postconditions  | The user object was stored in the database                     |

## Contract CO17: Find User
| Operation       | findUser(String username)                                                                                  |
|-----------------|------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Logging in                                                                                      |
| Preconditions   | Username is not null                                                                                       |
| Postconditions  | A User with the specified username was fetched from the database if they exist, otherwise null is returned |
