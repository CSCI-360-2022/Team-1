# Operation Contracts


## Contract CO1: Request Ticket

| Operation        | requestTicket(id : int)                                                                                                                                                                             |
|------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross References | Use Cases: Purchasing a Ticket                                                                                                                                                                         |
| Preconditions    | User is currently viewing a ticket                                                                                                                                                                     |
| Postconditions   | The system requests that the UI is shifted to a purchase screen where the user can input their payment information <br/> If the ticket was unavailable, the user is notified the ticket is out of stock<br/> |


## Contract CO2: Send Payment Info
| Operation        | sendPaymentInfo(cardInfo : CreditCard)                                                                                                                                                                                                    |
|------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross References | Use Cases: Purchasing a Ticket                                                                                                                                                                                                            |
| Preconditions    | Credit Card info was entered into the GUI                                                                                                                                                                                                 |
| Postconditions   | Payment system receives the card info used to purchase the ticket<br/> Payment info is validated<br/>A receipt and proof of purchase is returned to the user and System respectively<br/>A ticket is returned to the user from the System |

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
| Cross Reference | Use Cases: Logging In                                    |
| Preconditions   | The users unhashed password was provided to the back end |
| Postconditions  | The password now hashed                                  |

