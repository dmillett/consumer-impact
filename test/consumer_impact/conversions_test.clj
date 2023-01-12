(ns consumer-impact.conversions-test
  (:require [clojure.test :refer :all]
            [consumer-impact.conversions :refer :all]))

(deftest test_group-by-index
  (are [x y] (= x y)
    (group-by-index nil) []
    (group-by-index [[:a1 :b1]]) [[:a1] [:b1]]
    (group-by-index [[:a1 :b1] [:a2 :b2] [:a3 :b3]]) [[:a1 :a2 :a3] [:b1 :b2 :b3]]
    (group-by-index [[:a1 :b1 :c1] [:a2 :b2 :c2]]) [[:a1 :a2] [:b1 :b2] [:c1 :c2]]
   )
  (is (thrown? java.lang.IndexOutOfBoundsException
        (group-by-index [[:a1 :b1] [:b2]]))))

;; Might add a test for each conversion pair at a future date
(deftest test_conversion
  (are [x y] (= x y)
    ((conversions [:C :F]) 0.0) 32.0
    ((conversions [:s :hr]) 3600.0) 1.0
    (Math/ceil ((conversions [[:ft :s] [:miles :hr]]) 10)) 7.0
    ))