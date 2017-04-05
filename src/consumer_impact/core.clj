(ns consumer-impact.core
  (:require [consumer-impact.periodic :as periodic]))

(defrecord Type [name description])
(def types
  {:g (->Type "Good" "A tangible manufactured good, foodstuff, etc")
   :s (->Type "Service" "A provided service like accounting, legal, lawn care, etc")})

; A source of record documenting a product (manufacturer, third party, government agency, etc)
(defrecord ProductSource [type verification accreditation])
(def product_sources
  {:company (->ProductSource nil {} {})
   :individual (->ProductSource nil {} {})
   :government (->ProductSource nil {} {})
   :laboratory (->ProductSource nil {} {})
   :natural (->ProductSource nil {} {})})

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