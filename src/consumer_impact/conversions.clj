(ns consumer-impact.conversions
  (:require [consumer-impact.periodic :as ci]))

(defn group-by-index
  "Group a collection of equal length vectors by index. "
  [data]
  (into []
    (for [i (range (count (first data)))]
      (reduce
        (fn [r c] (conj r (nth c i)))
        []
        data)
      ) ) )

(def AVAGADROS_NUM (* 6.02214076 (Math/pow 10.0 23.0)))

(def conversions
  "A map of unit conversions where each conversion pair is defined by [from to]
  and returns a function to act on the value."
  {
   ;; mass
   [:lb :g] (fn [v] (* v 453.5924))
   [:g :lb] (fn [v] (* v 0.002204623))
   [:kg :lb] (fn [v] (* v 2.204623))
   [:lb :kg] (fn [v] (* v 0.4535924))
   [:g :kg] (fn [v] (* v 1000.0))
   [:kg :g] (fn [v] (/ v 1000.0))
   ;; molecules
   [:mole :g] (fn [el v] (* v (-> ci/table el :mmass)))
   [:g :mole] (fn [el v] (/ v (-> ci/table el :mmass)))
   ;; temperature
   [:C :F] (fn [v] (+ 32.0 (* v (/ 9 5))))
   [:F :C] (fn [v] (* (/ 5 9) (- v 32.0)))
   ;; distance
   [:mm :in] (fn [v] (* v 0.03937))
   [:m :ft] (fn [v] (* v 3.28084))
   [:m :km] (fn [v] (* 1000.0 v))
   [:km :m] (fn [v] (/ v 1000.0))
   [:m :miles] (fn [v] (/ v 1609.344))
   [:miles :m] (fn [v] (* v 1609.344))
   [:ft :miles] (fn [v] (/ v 5280.0))
   ;; time
   [:s :hr] (fn [v] (/ 3600.0 v))
   [:hr :s] (fn [v] (* 3600.0 v))
   [:s :min] (fn [v] (/ v 60.0))
   [:min :hr] (fn [v] (/ v 60.0))
   [:hr :min] (fn [v] (* 60.0 v))
   ;; units-per
   [[:m :s] [:miles :hr]] (fn [v] ((conversions [:hr :s])
                                   ((conversions [:m :miles]) v)))
   [[:ft :s] [:miles :hr]] (fn [v] ((conversions [:hr :s])
                                     ((conversions [:ft :miles]) v)))

   [[:ft :s2] [:m :s2]] (fn [v] ((conversions [:ft :m]) v))
   } )

