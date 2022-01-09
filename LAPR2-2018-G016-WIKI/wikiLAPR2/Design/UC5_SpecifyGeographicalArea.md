# Realization of UC5 - Specify Geographical Area

## Rational

| Primary Flow                                                                                       | Question: Which class...                                      | Answer                                       | Justification                                                                                                         |
|:-------------------------------------------------------------------------------------------------------|:------------------------------------------------------------|:-----------------------------------------------|:---------------------------------------------------------------------------------------------------------------------|
| 1. The administrative starts the specification of a new geographical area. | ... interacts with the user? | SpecifyGeographicalAreaUI.                          | Pure Fabrication. |
|| ... coordenates the UC?                                                                              | SpecifyGeographicalAreaController                               | Controller.                                    |                                                                                                                      |
|| ...creates/instance the new geographical area?          | GeographicalAreaRegistry                                               | Creator (Rule 1) + HC + LC : Company delegates in GeographicalAreaRegistry.                             |                                                                                                                      |
| 2. The system request the data (i.e. name, zip code, operating radius, cost of travel).  |                  |                                                |                                                                                                                      |
| 3. The administrative inserts the data.   | ... saves the data?                    |GeographicalArea                               | Information Expert (IE) - instance created on step 1                                                                                              |
| 4. The system gets the zip codes covered by the new geographical area, validates and shows to the administrative, asking to confirm.                                                              | ... validates the data from GeographicalArea (local validation)? | GeographicalArea                                     | IE: GeographicalArea has its own data.                                                                                                                   |
|| ... validates the data from GeographicalArea (global validation)?                                           | GeographicalAreaRegistry                                               | IE: GeographicalAreaRegistry contains GeographicalArea |                                                                                                                      |
||... provides the zip codes within the operating radius |ExternalService|IE: In DM ExternalService provides that data. |
||... what is the expected result from ExternalService|List\<OperatesAt>|IE: In DM ExternalService informs several "OperatesAt". |
||... knows the ExternalService|Company|IE: no MD Empresa define ServicoExterno. Protected Variation on ExternalService since the system must support several external services.|
| 5. The administrative confirms.                                                                     |                                                             |                                                |                                                                                                                      |
| 6.	The system register the data and informs the administrative about the sucess of the operation.                           | ... saves the GeographicalArea specified/created?                            | Company                                 | IE. In DM, the Company operates in differents geographical areas.                                                                |
|| ... notifies the user?                                                                                   | SpecifyGeographicalAreaUI                                        |                                                |                                                                                                                      |

## Sistematization ##

From the rational results
 Do racional resulta que as classes conceptuais promovidas a classes de software são:

 * Company
 * Geographical Area
 * External Service
 * OperatesAt

Other class of software (i.e. Pure Fabrication) identified:

 * SpecifyGeographicalAreaUI
 * SpecifyGeographicalAreaController
 * GeographicalAreaRegistry


##	Sequence Diagram
![SD_UC5_IT4.png] (SD_UC5_IT4.png)


##	Class Diagram
![CD_UC5_IT4.png] (CD_UC5_IT4.png)