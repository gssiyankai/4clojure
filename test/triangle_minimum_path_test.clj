(ns triangle_minimum_path_test
  (:use clojure.test)
  (:use triangle_minimum_path))

(deftest test-1
  (is (= 7 (min-path '([1]
                      [2 4]
                     [5 1 4]
                    [2 3 4 5]))))) ; 1->2->1->3

(deftest test-2
  (is (= 20 (min-path '([3]
                       [2 4]
                      [1 9 3]
                     [9 9 2 4]
                    [4 6 6 7 8]
                   [5 7 3 5 1 4]))))) ; 3->4->3->2->7->1


(run-tests 'triangle_minimum_path_test)