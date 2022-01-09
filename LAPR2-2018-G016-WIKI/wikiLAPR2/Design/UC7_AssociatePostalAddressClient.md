# UC7 Associate Postal Address with Client Realization
==========================================

Rational
--------

| Main Flow |Question: Which class...|Answer|Justification                                                                  |
|-------------------------------------------------------------------------------|----------------------------------------------------|----------------------------------|---------------------------------------------------------------------------------------------------------|
| 1. The client initiates the association of a new postal address with their information.                   |…interacts with the user?|AssociatePostalAddressUI| PureFabrication|
|                                                                               | 	…coordinates the UC?| AssociatePostalAddressController | Controller                                                                                              |
| 2. The system requests the required (address postal) data.|                                                |                                  |                                                                                                         |
| 3. The client introduces the requested data.|...creates PostalAddress?| Client| Creator (rule 4)                                                                                       |
|                                                                               | ... saves the data?|PostalAddress|Information Expert (IE) - instance created in step 1                                                    |
|||ZipCode|IE. PostalAddress has one ZipCode|
| 4. The system validates and presents the data, asking that confirms them.| ...validate postal address’ data (local validation)?  | PostalAddress    | 	IE: PostalAddress has its own data                         |
|                                                                               | … validade postal address’s data (global validation)? | Client                          | IE: Client contains PostalAddresses.                                |
| 5. The client confirms.|                                                    |                                  |                                                                                                         |
| 6. The system associates the postal address to the customer and it informs him of the success of the operation.| ...saves the PostalAddress created?        | Client                 |IE: Client contains all his PostalAddresses.                           |
|                                                                               | ... notifies the user?                        | AssociatePostalAddressUI|                                                                                                         |



Systematization
--------------

From the rational results that the conceptual classes promoted to softwares classes are:

- Company

- Client

- PostalAddress

- ZipCode

Other software classes (i.e Pure Fabrication) identified:

-   AssociatePostalAddressUI

-   AssociatePostalAddressController

Sequence Diagram
---------------------

![SD_UC7_IT4.png](SD_UC7_IT4.png)

**Note:** Was not considered relevant to promote (for application of HC+LC) the list of Postal Addresses of a Client to a software class. However, such thing would be perfectly valid.

Classes Diagram
-------------------

![CD_UC7_IT4.png](CD_UC7_IT4.png)