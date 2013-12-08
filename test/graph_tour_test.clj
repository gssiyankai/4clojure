(ns graph_tour_test
  (:use clojure.test)
  (:use graph_tour))

(deftest test-1
  (is (= true (tour [[:a :b]]))))

(deftest test-2
  (is (= false (tour [[:a :a] [:b :b]]))))

(deftest test-3
  (is (= false (tour [[:a :b] [:a :b] [:a :c] [:c :a]
                    [:a :d] [:b :d] [:c :d]]))))

(deftest test-4
  (is (= false (tour [[:a :b] [:a :b] [:a :c] [:c :a]
                    [:a :d] [:b :d] [:c :d]]))))

(deftest test-5
  (is (= true (tour [[:a :b] [:a :c] [:c :b] [:a :e]
                   [:b :e] [:a :d] [:b :d] [:c :e]
                   [:d :e] [:c :f] [:d :f]]))))

(deftest test-5
  (is (= false (tour [[1 2] [2 3] [2 4] [2 5]]))))

(run-tests 'graph_tour_test)