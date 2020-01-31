# consumer-impact

A Clojure library designed to track and educate resource utilization, via consumption and production
for all goods and services. In essence, how much was consumed and produced for any product or
service purchased. The vast majority of these resources are already itemized and used as capital
expenditures by corporations and services entities as part of normal financial operations. The Consumers
deserve to know what they are buying and how it is manufactured/provided.  

As an example:

#### A gallon of 87 octane gasoline purchased from a gas station
Think in per-unit terms how many element/molecular resources are consumed & produced
when mining crude oil and processing it to gasoline, diesel, jet fuel, etc.

   - **delivery to gas station from refinery:**
     - consumed: tanker truck fuel per unit consumption/emissions
     - produced: (CO, CO2, H2O, hydrocarbons) transporting fuel to gas station
   - **refining of oil to gasoline:**
     - consumed: H20, chemicals, heat from source(s) to refine, 
                 infrastructure material, crude oil, etc
     - produced: gasoline, diesel, polymers, chemicals, emissions, etc
   - **transporting oil to refinery:** 
     - consumed: pipeline? (steel, electricity, mining); ocean tanker (steel, fuel, etc)
     - produced: combustion process and/or electricity during transit
   - **retrieving oil from a geographic location:**
     - 

## Usage

There should be a product database that details, on a per-unit basis, what element and molecular
resources were consumed & produced for a given product. It becomes easy to calculate which and how
much was consumed & produced via recursion.

### clojars (todo) 

### parsing molecular formulas

```clojure
; Handles keyword with/without '_'
=> (def water (parse-molecule :H2O))
'("H2" "O")

; Handles strings with/without '_'
=> (def ibuprofen (parse-molecule "C13_H18_O2"))
'("C13" "H18" "O2")

; Determines molar mass
=> (def mm_water (molar-mass :H2O))
18.0185

=> (def mm_ibuprofen (molar-mass :C13_H18_O2))
206.285
```

## License

Copyright © 2016 dmillett

Distributed under the GNU Lesser General Public License, version 2.1.
