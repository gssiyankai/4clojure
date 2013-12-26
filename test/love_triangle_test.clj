(ns love_triangle_test
  (:use clojure.test)
  (:use love_triangle))

(deftest test-0
  (is (= [[1 1 1 1]] (to-binary [15])))
  (is (= [[1 1]] (to-binary [3])))
  (is (= [[1 0]] (to-binary [2])))
  (is (= [[1 0 0 0 1]] (to-binary [17])))
  (is (= [[1 0 0 0 1]
          [1 0 1 1 0]
          [0 0 1 1 0]
          [0 1 1 1 0]
          [1 0 1 1 0]] (to-binary [17 22 6 14 22]))))

(deftest test-1
  (is (= 10 (area [15 15 15 15 15]))))
    ; 1111      1111
    ; 1111      *111
    ; 1111  ->  **11
    ; 1111      ***1
    ; 1111      ****))

(deftest test-2
  (is (= 15 (area [1 3 7 15 31]))))
    ; 00001      0000*
    ; 00011      000**
    ; 00111  ->  00***
    ; 01111      0****
    ; 11111      *****

(deftest test-3
  (is (= 3 (area [3 3]))))
    ; 11      *1
    ; 11  ->  **))

(deftest test-4
  (is (= 4 (area [7 3]))))
    ; 111      ***
    ; 011  ->  0*1))

(deftest test-5
  (is (= 6 (area [17 22 6 14 22]))))
    ; 10001      10001
    ; 10110      101*0
    ; 00110  ->  00**0
    ; 01110      0***0
    ; 10110      10110))

(deftest test-6
  (is (= 9 (area [18 7 14 14 6 3]))))
    ; 10010      10010
    ; 00111      001*0
    ; 01110      01**0
    ; 01110  ->  0***0
    ; 00110      00**0
    ; 00011      000*1))

(deftest test-7
  (is (= nil (area [21 10 21 10]))))
    ; 10101      10101
    ; 01010      01010
    ; 10101  ->  10101
    ; 01010      01010

(deftest test-8
  (is (= nil (area [0 31 0 31 0]))))
    ; 00000      00000
    ; 11111      11111
    ; 00000  ->  00000
    ; 11111      11111
    ; 00000      00000

(run-tests 'love_triangle_test)