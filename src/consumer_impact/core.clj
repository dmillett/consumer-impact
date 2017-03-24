(ns consumer-impact.core
  (:require [consumer-impact.periodic :as periodic]))

(defrecord Molecule [name code formula elements molar_mass weight state]) ; CO2, 44.0095 g/mol,

