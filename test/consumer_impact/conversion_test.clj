(ns consumer-impact.conversion-test
  (:require [clojure.test :refer :all]
            [consumer-impact.conversion :refer :all]
            [consumer-impact.conversions :as cvrs]))

(deftest test-convert
  (is (= 32.0 (convert cvrs/conversions [:C :F] 0.0)))
  (is (= 7.0 (Math/ceil (convert cvrs/conversions [[:ft :s] [:miles :hr]] 10.0))))
  )
