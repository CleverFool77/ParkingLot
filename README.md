# ParkingLot

```
Simple Implementation of ParkingLot problem using Java, Google guice, guava and tested using Junit-Mockito. 
This was made to understand the concepts and for learning purpose.
```
> This code tries to follow and adapt Design Pattern such as Command and Factory pattern in it.

## Problem Statement
I own a parking lot that can hold up to &#39;n&#39; cars at any given point in time. Each slot is
given a number starting at 1 increasing with increasing distance from the entry point
in steps of one. I want to create an automated ticketing system that allows my
customers to use my parking lot without human intervention.
When a car enters my parking lot, I want to have a ticket issued to the driver. The
ticket issuing process includes us documenting the registration number (number
plate) and the colour of the car and allocating an available parking slot to the car
before actually handing over a ticket to the driver (we assume that our customers are
nice enough to always park in the slots allocated to them). The customer should be
allocated a parking slot which is nearest to the entry. At the exit the customer returns
the ticket which then marks the slot they were using as being available.
Due to government regulation, the system should provide me with the ability to find
out:
- Registration numbers of all cars of a particular colour.
- Slot number in which a car with a given registration number is parked.
- Slot numbers of all slots where a car of a particular colour is parked.
#
## Tech Stacks
1|2|3|4|
| --- | --- | --- | --- | 
Language - Java 8| Framework - Google Guice | Libraries - Guava | Testing - Junit, Mockito| 
## Usage
 ### Steps to Run
* Use any of the Java IDE to run this code
* Clone and Import in Intellij IDE (You can use anyone of them)
* Build gradle to install all dependencies
* Run Main Class
* You'll get two options to choose from which are file and interactive input.
* Choose anyone of them and here you go !!

### Commands 
* Create parking lot using `create_parking_lot capacity_Size`
* Park vehicle using `park regsitrationNumber color`
* Unpark vehicle using `leave slotNumber` 
* Check status of parking Lot `status`
* Get Registration numbers of all cars of a particular colour using `registration_numbers_for_cars_with_colour colorName`
* Get Slot number in which a car with a given color is parked using `slot_numbers_for_cars_with_colour colorname`
* Get Slot number in which a car with a given registration number is parked using `slot_number_for_registration_number registrationNumber`
* Exit using `exit`

<sup>[]()</sup>