(ns levenshtein_distance_test
  (:use clojure.test)
  (:use levenshtein_distance))

(deftest test-1
  (is (= (distance "kitten" "sitting") 3)))

(deftest test-2
  (is (= (distance "closure" "clojure") (distance "clojure" "closure") 1)))

(deftest test-3
  (is (= (distance "xyx" "xyyyx") 2)))

(deftest test-4
  (is (= (distance "" "123456") 6)))

(deftest test-5
  (is (= (distance "Clojure" "Clojure") (distance "" "") (distance [] []) 0)))

(deftest test-6
  (is (= (distance [1 2 3 4] [0 2 3 4 5]) 2)))

(deftest test-7
  (is (= (distance '(:a :b :c :d) '(:a :d)) 2)))

(deftest test-8
  (is (= (distance "ttttattttctg" "tcaaccctaccat") 10)))

(deftest test-9
  (is (= (distance "gaattctaatctc" "caaacaaaaaattt") 9)))


(run-tests 'levenshtein_distance_test)