(ns consumer-impact.molecule
  (:require [consumer-impact.periodic :as p]))

; todo: graphql (lacinia) this website?
; http://www.reciprocalnet.org/recipnet/showsamplebasic.jsp?sampleId=27344879
(def molecule_sources
  {:reciprocal "http://www.reciprocalnet.org/edumodules/commonmolecules/list.html"}) ; see 'index.html'

(def molecule-pattern #"[A-Z][a-z]*\d*")

(defn parse-molecule
  "Parse a molecule into constituent elements and counts from a String
  or keyword. Example formulas: \"H2O\", \"H2_O\", :H2O, :H2_O
  result in: '(\"H2\" \"O\")"
  [molecule]
  (when molecule
    (re-seq molecule-pattern (name molecule))))

(defrecord MolarMass [value unit])


(defrecord Molecule [names formula molar_mass state]) ; CO2, 44.0095 g/mol,

(def molecules
  {:H2O (->Molecule "water" "H2O" (->MolarMass 18.0153 "g") (:liquid p/phases))
   :C13H18O2 (->Molecule "ibuprofen" "C13H18O2" nil (:solid p/phases))
   })

