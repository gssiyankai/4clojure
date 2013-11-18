(ns number_maze_test
  (:use clojure.test)
  (:use number_maze))

(deftest test-1
  (is (= 1 (shortest-path 1 1))))

(deftest test-2
  (is (= 3 (shortest-path 3 12))))

(deftest test-3
  (is (= 3 (shortest-path 12 3))))

(deftest test-4
  (is (= 3 (shortest-path 5 9))))

(deftest test-5
  (is (= 9 (shortest-path 9 2))))

(deftest test-6
  (is (= 5 (shortest-path 9 12))))

(run-tests 'number_maze_test)