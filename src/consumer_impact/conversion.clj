(ns consumer-impact.conversion
  (:require [frinj.core :as fc]
            [frinj.ops :as fo])
  (:use [consumer-impact.core]
        [consumer-impact.conversions]))

; Use units tables from 'frinj
; g, kg, ml, l, oz, ...

; Product database
; (->Product)

;; Frinj example for add-unit
;; (add-unit! :h2energy (fj 2000 :ml :per :molarvolume 19 :percent 285.8 :kJ :per :mol))
;;
;(defn add-conversion
;  [unit_name frj_statement]
;  (fc/add-unit! nil nil))

;; todo: add spec to ensure conversions-fx adheres to structure of (conversions)
(defn convert
  "A conversion function that converts a value(s) between two different units.
  (convert [:lb :g] 1.0)
  => 454 g

  (convert [:mole :g] :N 1.0)
  => 14.007 g
  "
  [conversions-fx units & values]
  (apply (conversions-fx units) values))
