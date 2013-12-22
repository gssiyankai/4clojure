(ns latin_square_slicing_test
  (:use clojure.test)
  (:use latin_square_slicing))

(deftest test-0
  (is (= true (latin-square? '[[A B C]
                               [B C A]
                               [C A B]])))
  (is (= false (latin-square? '[[A B C]
                                [B C A]
                                [C A C]])))
  (is (= false (latin-square? '[[A B C]
                                [B D A]
                                [C A B]]))))

(deftest test-1
  (is (= (process '[[A B C D]
                    [A C D B]
                    [B A D C]
                    [D C A B]])
          {})))

(deftest test-2
  (is (= (process '[[A B C D E F]
                    [B C D E F A]
                    [C D E F A B]
                    [D E F A B C]
                    [E F A B C D]
                    [F A B C D E]])
        {6 1})))

(deftest test-3
  (is (= (process '[[A B C D]
                    [B A D C]
                    [D C B A]
                    [C D A B]])
        {4 1, 2 4})))

(deftest test-4
  (is (= (process '[[B D A C B]
                    [D A B C A]
                    [A B C A B]
                    [B C A B C]
                    [A D B C A]])
        {3 3})))

;(deftest test-5
;  (is (= (process [[2 4 6 3]
;                   [3 4 6 2]
;                   [6 2 4]])
;        {})))
;
;(deftest test-6
;  (is (= (process [[1]
;                   [1 2 1 2]
;                   [2 1 2 1]
;                   [1 2 1 2]
;                   []])
;        {2 2})))
;
;(deftest test-7
;  (is (= (process [[3 1 2]
;                   [1 2 3 1 3 4]
;                   [2 3 1 3]])
;        {3 1, 2 2})))
;
;(deftest test-8
;  (is (= (process [[8 6 7 3 2 5 1 4]
;                   [6 8 3 7]
;                   [7 3 8 6]
;                   [3 7 6 8 1 4 5 2]
;                   [1 8 5 2 4]
;                   [8 1 2 4 5]])
;        {4 1, 3 1, 2 7})))

(run-tests 'latin_square_slicing_test)