(ns squares_squared_test
  (:use clojure.test)
  (:use squares_squared))

(deftest test-0
  (is (= (squares 2 2) [2]))
  (is (= (squares 2 4) [2 4]))
  (is (= (squares 2 256) [2 4 16 256]))
  (is (= (tokenize [3 9 81]) [\3 \9 \8 \1]))
  (is (= (tokenize [2 4 16 256]) [\2 \4 \1 \6 \2 \5 \6 \* \*])))

(deftest test-1
  (is (= (transform 2 2) ["2"])))

(deftest test-2
  (is (= (transform 2 4) [" 2 "
                          "* 4"
                          " * "])))

(deftest test-3
  (is (= (transform 3 81) [" 3 "
                           "1 9"
                           " 8 "])))

(deftest test-4
  (is (= (transform 4 20) [" 4 "
                           "* 1"
                           " 6 "])))

(deftest test-5
  (is (= (transform 2 256) ["  6  "
                            " 5 * "
                            "2 2 *"
                            " 6 4 "
                            "  1  "])))

(deftest test-6
  (is (= (transform 10 10000) ["   0   "
                               "  1 0  "
                               " 0 1 0 "
                               "* 0 0 0"
                               " * 1 * "
                               "  * *  "
                               "   *   "])))

(run-tests 'squares_squared_test)