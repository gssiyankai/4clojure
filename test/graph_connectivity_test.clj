(ns graph_connectivity_test
  (:use clojure.test)
  (:use graph_connectivity))

(deftest test-1
  (is (= true (connected #{[:a :a]}))))

(deftest test-2
  (is (= true (connected #{[:a :b]}))))

(deftest test-3
  (is (= false (connected #{[1 2] [2 3] [3 1]
                            [4 5] [5 6] [6 4]}))))

(deftest test-4
  (is (= true (connected #{[1 2] [2 3] [3 1]
                           [4 5] [5 6] [6 4] [3 4]}))))

(deftest test-5
  (is (= false (connected #{[:a :b] [:b :c] [:c :d]
                            [:x :y] [:d :a] [:b :e]}))))

(deftest test-5
  (is (= true (connected #{[:a :b] [:b :c] [:c :d]
                           [:x :y] [:d :a] [:b :e] [:x :a]}))))

(run-tests 'graph_connectivity_test)