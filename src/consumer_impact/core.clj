(ns consumer-impact.core
  (:require [consumer-impact.periodic :as p]
            [clojure.spec.alpha :as s])
  (:use [frinj.repl]))

(frinj-init!)

(defrecord Type [name description])
(def types
  {:g (->Type "Good" "A tangible good, foodstuff, etc")
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
(defrecord Provider [id name date location])
(defrecord Amount [value unit])
(defrecord Coordinate [lat lon])
(defrecord Component [molecule amount])
(defrecord Product [name version date type provider location source amount consumed produced])


(def chicago_ll (->Coordinate 41.886460, -87.637695))

(def water_bottle
  (->Product "nestle-steals" 1.0 "2018-01-01" (:g types) "nestle" "lat-lon" (:natural product_sources) (->Amount 16 "oz")
             [(->Product "ChicagoRiver" 1.0 "2018-01-01" (:g types) "Chicago" chicago_ll (:natural product_sources) (->Amount 16 "oz") nil nil)
              () ; plastic for bottle
              () ; plastic/paper for label
              () ; electricity used
              ]
             [() ; plastic emissions (oil refinery emissions, shipping oil to refinery emissions, mining oil emissions)
              () ; electricity emissions (solar, wind, nuclear, coal, natural gas, turkey dung, etc)
              () ; label emissions
              ]
             ))


; todo: add specs here
(defn add-amounts
  "Add Amount records and normalize units with 'frinj"
  [amounts]
  (reduce
    (fn [total amt]
      (if (number? total)
        (fj (:value amt) (:unit amt))
        (fj+ total (fj (:value amt) (:unit amt)))
        ) )
    0.0
    amounts))