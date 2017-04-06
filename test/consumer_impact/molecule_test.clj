(ns consumer-impact.molecule-test
  (:require [clojure.test :refer :all]
            [consumer-impact.molecule :refer :all]))

(deftest test-parse-molecule
  (let [water '("H2" "O")]
    (are [x y] (= x y)
      water (parse-molecule "H2O")
      water (parse-molecule "H2_O")
      water (parse-molecule :H2O)
      water (parse-molecule :H2_O)
      nil (parse-molecule :xx123)
      nil (parse-molecule nil)
      '("C13" "H18" "O2") (parse-molecule :C13H18O2) ; ibuprofen - developer candy
      )))

(deftest test-molar-mass
  (are [x y] (= x y)
    nil (molar-mass :X1)
    18.015 (molar-mass :H2O)
    206.285 (molar-mass :C13H18O2)
    ) )