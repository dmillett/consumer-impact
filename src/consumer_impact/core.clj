(ns consumer-impact.core
  (:require [consumer-impact.periodic :as periodic]))

; todo: move these to 'periodic?
(defrecord MolarMass [value unit])
(defrecord Molecule [name code formula molar_mass state]) ; CO2, 44.0095 g/mol,
(def molecules {:H2O (->Molecule "water" "H2O" "H2O" (->MolarMass 18.0153 "g") (:liquid periodic/states))})

(defrecord Type [name description])
(def types {:g (->Type "Good" "A tangible manufactured good, foodstuff, etc")
            :s (->Type "Service" "A provided service like accounting, legal, lawn care, etc")})

; A source of record documenting a product (manufacturer, third party, government agency, etc)
(defrecord Source [name type verification accreditation])
(def sources {:company (->Source "Company" nil {} {})
              :individual (->Source "Individual" nil {} {})
              :government (->Source "Government" nil {} {})
              :laboratory (->Source "Laboratory" nil {} {})})

; A company or individual creating/manufacturing the product
(defrecord Provider [id date location])

; todo: work with 'frinj and conversions
(defrecord Amount [value unit])

;
; (def water_bottle_consumed (->Consumed 1 [{:product nil, :molecule (:H2O molecules), :amount (->Amount 24 "oz")}
;                                           {:product (:some_plastic), :molecule nil, :amount (->Amount 2.1 "oz")}
;                                           {:product (:some_energy), :molecule nil, :amount (->Amount 20 "joules")}])
;
; todo notes: Water purification uses excess energy or water
; todo notes: nearly 1:1 passthrough from consumed to produced for the plastic water bottle itself (research numbers)
; (def water_bottle_produced (->Produced 1 [{:product nil, :molecule (:H2O molecules), :amount (->Amount 12 "oz")}
;                                           {:product (:some_plastic), :molecule nil, :amount (->Amount 2.0 "oz")}])
;
; 1 product unit consumed X1 mixed units, produced Y1 mixed units
; 8 product units consumed X8 mixed units, produced Y8 mixed units
(defrecord Consumed [product_units composition_units])
(defrecord Produced [product_units produced_units])

(defrecord Product [id version date type provider location source consumed produced])