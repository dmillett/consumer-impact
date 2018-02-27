(ns consumer-impact.core-test
  (:require [clojure.test :refer :all]
            [consumer-impact.core :refer :all]))

(deftest test-add-amounts
  (let [amounts [(->Amount 13 "kg") (->Amount 345 "g")]]
    (is (= "2669/200 (approx. 13.345) kg [mass]" (str (add-amounts amounts))))
    ) )

