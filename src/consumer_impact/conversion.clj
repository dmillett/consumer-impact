(ns consumer-impact.conversion
  (:require [frinj.core :as fc]
            [frinj.ops :as fo])
  (:use [consumer-impact.core]))

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