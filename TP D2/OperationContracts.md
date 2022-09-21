# Operation Contracts

---

## Contract CO1: Request Ticket

| Operation        | requestTicket(id : integer)                                                                                                                                                                             |
|------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross References | Use Cases: Purchasing a Ticket                                                                                                                                                                          |
| Preconditions    | User is currently viewing a ticket                                                                                                                                                                      |
| Postconditions   | The system requests that the UI is shifted to a purchase screen where the user can input their payment information <br/> If the ticket was unavailible, the user is notified the ticket is out of stock<br/> |

## Contract CO2: Request Payment Info
| Operation        | requestPaymentInfo()                                                                            |
|------------------|-------------------------------------------------------------------------------------------------|
| Cross References | Use Cases: Purchasing a Ticket                                                                  |
| Preconditions    | The system knows which ticket is being purchased                                                |
| Postconditions   | The user has a GUI where they can enter in payment details and also see the price of the ticket |

## Contract CO3: Send Payment Info
| Operation        | sendPaymentInfo(cardInfo : CreditCard)                                                                                                                                                                                                    |
|------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Cross References | Use Cases: Purchasing a Ticket                                                                                                                                                                                                            |
| Preconditions    | Credit Card info was entered into the GUI                                                                                                                                                                                                 |
| Postconditions   | Payment system recieves the card info used to purchase the ticket<br/> Payment info is validated<br/>A reciept and proof of purchase is returned to the user and System respectively<br/>A ticket is returned to the user from the System |