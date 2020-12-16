# Pay-Calculator
### Problem Statement
Foo Corporation needs a program to calculate how much to pay their hourly employees. The US Department of Labor requires that employees get paid time and a half for any hours over 40 that they work in a single week. For example, if an employee works 45 hours, they get 5 hours of overtime, at 1.5 times their base pay. The State of Massachusetts requires that hourly employees be paid at least $8.00 an hour. Foo Corp requires that an employee not work more than 60 hours in a week.

Calculation Logic : 
An employee gets paid (hours worked) × (base pay), for each hour up to 40 hours.
For every hour over 40, they get overtime = (base pay) × 1.5.
The base pay must not be less than the minimum wage ($8.00 an hour). If it is, print an error.
If the number of hours is greater than 60, print an error message.
Write a method that takes the base pay and hours worked as parameters, and prints the total pay or an error.  Write a main method that calls this method for each of these employees:
            
            Employee ID     Base Pay    HoursWorked
            
            Employee 1      $7.50       35
            Employee 2      $8.20       47
            Employee 3      $10.00      73 


#### Test Cases
1.) ~~It should return 0$ as Total Pay when Hours Worked is 0.~~

2.) ~~It should return 8$ as Total Pay when Hours Worked is 1 and Base Pay is 8$.~~

3.) ~~It should return 320$ as Total Pay when Hours Worked is 40 and Base Pay is 8$.~~

4.) ~~It should return 332$ as Total Pay when Hours Worked is 41 and Base Pay is 8$ because 
    after 40 hours the Base Pay is multiplied by 1.5 for each hour.~~

5.) ~~Set precision of Total Pay which is Big Decimal.~~

6.) ~~It should print error or throw exception when the Base Pay is less than 8$.~~

7.) ~~It should print error or throw exception when the Hours Worked is more than 60.~~

8.) ~~Fix Money class, make it more readable and Single Responsibility please.~~
