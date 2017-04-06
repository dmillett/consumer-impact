(ns consumer-impact.molecule
  (:require [consumer-impact.periodic :as p]))

(defrecord Molecule [names formula molar_mass state]) ; CO2, 44.0095 g/mol,
(defrecord MolarMass [value unit])

; todo: graphql (lacinia) this website?
; http://www.reciprocalnet.org/recipnet/showsamplebasic.jsp?sampleId=27344879
(def molecule_sources
  {:reciprocal "http://www.reciprocalnet.org/edumodules/commonmolecules/list.html"}) ; see 'index.html'

(def pattern-element-groups #"[A-Z][a-z]*\d*")
(def pattern-element #"([A-Z][a-z]*)(\d*)")

(defn parse-molecule
  "Parse a molecule into constituent elements and counts from a String
  or keyword. Example formulas: \"H2O\", \"H2_O\", :H2O, :H2_O
  result in: '(\"H2\" \"O\")"
  [molecule]
  (when molecule
    (re-seq pattern-element-groups (name molecule))))

(defn molar-mass
  "Calculate the molar mass of a molecule or element based on 'consumer-impact.periodic/table.
  The result should be in 'g/mol'"
  [molecule]
  (reduce
    (fn [total_mass ce]
      (try
        (let [[_ e n] (re-find pattern-element ce)
              emass (get-in p/table [(keyword e) :mmass])
              ecount (if (empty? n) 1 (Integer/parseInt n))]
          (+ total_mass (* ecount emass)) )
        (catch Exception ex (println "Could Not Lookup Element: " ce) nil) ) )
    0.0
    (parse-molecule molecule)
    ) )


(def molecules
  {:H2O (->Molecule "water" "H2O" (->MolarMass 18.0153 "g") (:liquid p/phases))
   :C13H18O2 (->Molecule "ibuprofen" "C13H18O2" nil (:solid p/phases))
   })

