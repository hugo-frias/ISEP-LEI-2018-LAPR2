# UC11 - Decide on the proposed period for services

## Brief format

The client initiates the decision process regarding the proposed period for performing the service. The system presents the data. The client confirms the period proposed for performing service. The system regists the confirmation and informs the client about the sucess of the operation.

## SSD

![SDD_UC11_IT4.jpg](SDD_UC11_IT4.jpg)

## Complete format

### Primary Actor

Client

### The stakeholders and their interests

* ** Client: ** pretends to confirm the proposed period to perfom the service.
* ** Company: ** wants the client to be able to decide about the proposed period to perform the service.

### Pre-conditions
n/a

### Pos-conditions
n/a

## Main Sucess Sceneraio()

1. The client initiates the decision process regarding the proposed period for performing the service.
2. The system presents the data.
3. The client confirms the period proposed for performing service.
4. The system regists the confirmation and informs the client about the sucess of the operation.

### Extensions(or alternative flows)

a. The client requests the cancellation of the decision process regarding the proposed periodo for perfoming the service.
> The use case ends.

3a.The client doesn't accept the proposed period for perfoming the service.
> 1. The proposed period is rejected.
> 2. The system register that the proposed time was rejected and saves that information.

### Special Requirements
-
### Techonology and Data Variations List
-
### Frequency of Occurence
-
### Open Questions

n/a