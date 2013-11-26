(ns sum_some_set_subsets_test
  (:use clojure.test)
  (:use sum_some_set_subsets))

(deftest test-1
  (is (= true  (sum #{-1 1 99}
                    #{-2 2 888}
                    #{-3 3 7777}))))

(deftest test-2
  (is (= false (sum #{1}
                    #{2}
                    #{3}
                    #{4}))))

(deftest test-3
  (is (= true  (sum #{1}))))

(deftest test-4
  (is (= false (sum #{1 -3 51 9}
                    #{0}
                    #{9 2 81 33}))))

(deftest test-5
  (is (= true  (sum #{1 3 5}
                    #{9 11 4}
                    #{-3 12 3}
                    #{-3 4 -2 10}))))

(deftest test-6
  (is (= false (sum #{-1 -2 -3 -4 -5 -6}
                    #{1 2 3 4 5 6 7 8 9}))))

(deftest test-7
  (is (= true  (sum #{1 3 5 7}
                    #{2 4 6 8}))))

(deftest test-8
  (is (= true  (sum #{-1 3 -5 7 -9 11 -13 15}
                    #{1 -3 5 -7 9 -11 13 -15}
                    #{1 -1 2 -2 4 -4 8 -8}))))

(deftest test-8
  (is (= true  (sum #{-10 9 -8 7 -6 5 -4 3 -2 1}
                    #{10 -9 8 -7 6 -5 4 -3 2 -1}))))


(run-tests 'sum_some_set_subsets_test)