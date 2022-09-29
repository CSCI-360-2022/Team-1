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
| Operation       | search(searchTerm : String, preferences : Preferences)                                                                                |
|-----------------|---------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Searching for Events                                                                                                       |
| Preconditions   | User typed a term into the search bar and optionally selected preferences on what they want to see included in the search results     |
| Postconditions  | Search results are returned to the user and are displayed in some sort of UI where they can select an event to view it in more detail |

## Contract CO4: Collect User Data
| Operation       | dataCollection(userData : Event)                                                                                                                                                         |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross Reference | Use Cases: Searching for Events                                                                                                                                                          |
| Preconditions   | User has interacted with some search results                                                                                                                                             |
| Postconditions  | User is taken to a event description page <br/> Back End stores the userInformation for future reference so that when the User searches something else, we can recommend a similar event |

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
| Postconditions  | The password now hashed                                  |

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
