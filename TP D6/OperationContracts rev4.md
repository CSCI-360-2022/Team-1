# Operation Contracts


## Contract CO1: Request Event

| Operation        | requestEvent(id : int) : Event                                                           |
|------------------|------------------------------------------------------------------------------------------|
| Cross References | Use Cases: Purchasing a Ticket                                                           |
| Preconditions    | An event with the specified id is in the database                                        |
| Postconditions   | An event has been fetched from the database and stored in an event object for future use |

## Contract CO2: Create Payment Info
| Operation        | createPaymentInfo(cardNumber: String, expDate: String, cvv: String, zipCode: String) : PaymentInfo |
|------------------|----------------------------------------------------------------------------------------------------|
| Cross References | Use Cases: Purchasing a Ticket                                                                     |
| Preconditions    | Credit Card info was entered into the GUI                                                          |
| Postconditions   | A payment info object was created that stores the parameters above                                 |

## Contract CO3: Search for Event
| Operation       | search(searchTerm : String, preferences : Preferences)                                                                            |
|-----------------|-----------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Searching for Events                                                                                                   |
| Preconditions   | User typed a term into the search bar and optionally selected preferences on what they want to see included in the search results |
| Postconditions  | Events that match the search parameters were fetched from the database. They were then stored int a list which was returned.      |

## Contract CO4: Collect User Data
| Operation       | dataCollection(userData : Event)                                                     |
|-----------------|--------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Searching for Events                                                      |
| Preconditions   | User has interacted with some search results                                         |
| Postconditions  | The event id of the event the user interacted with was stored in the user's history. |

## Contract CO5: Log in to System
| Operation       | login(username : String, password : String)                                                     |
|-----------------|-------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Logging In                                                                           |
| Preconditions   | User has entered in login info to respective text areas                                         |
| Postconditions  | The user is logged into the site or is given a failure message if their login info is not valid |

## Contract CO6: Password Hash
| Operation       | hash(password : String)                                  |
|-----------------|----------------------------------------------------------|
| Cross Reference | Use Cases: Logging In, Creating an Account               |
| Preconditions   | The users unhashed password was provided to the back end |
| Postconditions  | The password was hashed and returned by the method       |

## Contract C07: Check Payment Info
| Operation       | checkPayment(paymentInfo: PaymentInfo) : boolean                                     |
|-----------------|--------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchasing a Ticket                                                       |
| Preconditions   | paymentInfo has all the required fields necessary to complete a purchase             |
| Postconditions  | System receives a value true if the payment info is valid and false if it is invalid |

## Contract C08: Create Receipt
| Operation       | createReceipt(paymentInfo: PaymentInfo, user : User, event : Event) : Receipt                                |
|-----------------|--------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchasing a Ticket                                                                               |
| Preconditions   | All parameters have all the data needed to create a Receipt object. Payment has been verified and transacted |
| Postconditions  | A Receipt object is created and returned to System                                                           |

## Contract C09: Build Receipt
| Operation       | buildReciept() : String                                                              |
|-----------------|--------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Purchasing a Ticket                                                       |
| Preconditions   | Receipt object created and has all of its fields filled with info.                   |
| Postconditions  | System receives a value true if the payment info is valid and false if it is invalid |

## Contract C010: Email Receipt
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
| Operation       | createUser(userName: String, password: String, email: String)                    |
|-----------------|----------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Creating an Account                                                   |
| Preconditions   | The user has entered in the required data for creating an account in a UI window |
| Postconditions  | A new user is added to the database                                              |

## Contract C013: Check Demand
| Operation       | checkDemand(id : int)                                                                                                                                                                                                                                      |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Abuse case: purchasing all or most of a tickets stock                                                                                                                                                                                                      |
| Preconditions   | Ticket must be purchasable                                                                                                                                                                                                                                 |
| Post conditions | The ticket is checked if its a high seller or if its brand new and if it is the user is unable to purchase requested amount. If neither is true the requested amount is deemed fine to purchase and the user is not aware that the procedure even occurred |

## Contract C014: Confirm Purchase
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

