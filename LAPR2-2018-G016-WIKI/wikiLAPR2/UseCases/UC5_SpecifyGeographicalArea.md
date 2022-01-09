# UC5 - Specify Geographical Area

## Brief Format

The administrative inicializes a specification of a new geographical area. The system asks the necessary data (i.e. name, zip code, operating radius, cost of travel). The administrative inserts the data. The system gets the zip codes covered by the new geographical area, validates and shows the data to the administrative and asks to confirm. The administrative confirms. The system register the new geographical area and informs the administrative about the success of the operation.

## SSD

![UC5_SSD.png](UC5_SSD.png)

## Complete Format

### Primary Actor

Administrative

### The stakeholders and their interests

* **Administrative:** pretends to specify the geographical areas and the cost of travel to each one.
* **Client:** pretends to know in each geographical area does the company provides services and the respective costs of travel.
* **Company**: pretends

### Pre-conditions

### Pos-conditions

## Main Sucess Scenario ()

1. The administrative inicializes the specification of a new geographical area.
2. The system asks the necessary data (i.e. name, zip code, operating radius, cost of travel).
3. The administrative inserts the data.
4. The system gets the zip codes covered by the new geographical area, validates and shows the data to the administrative and asks to confirm.
5. The administrative confirms.
6. The system register the new geographical area and informs the administrative about the success of the operation.

### Extensions (or alternative flows)

a. The administrative cancels the specification of the geographical area.
> The use case ends.

4a. Minimun required data missing.
>        1. The system informs what data is missing.
>        2. The system allows the addition of the missing data (step 3)
          > 2a. The administrative doesn't change the data. The use case ends.

4b. The system detects that the data (or some part of the data) introduced must be unique and are already in the system.
>       1. The system alers the administrative to the fact.
>       2. The system allows to change the data (step 3).
        > 2a. The administrative doesn't change the data. The use case ends.

4c. The system detects that the data (or some part of the data) are invalid.
>       1. The system alers the administrative to the fact.
>       2. The system allows the change to the data.
        > 2a. The administrative doesn't change the data. The use case ends.

4d. The system is not able to determinate all zip codes covered by the geographical area.
>       1. The system alerts the administrative to the fact.
> The use case ends.

### Special Requirements
\-

### Technology and Data Variations List
\-

### Frequency of Occurence
\-

### Open Questions

n/a
