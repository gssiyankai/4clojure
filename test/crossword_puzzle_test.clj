(ns crossword_puzzle_test
  (:use clojure.test)
  (:use crossword_puzzle))

(deftest test-1
  (is (= true (can-place "the" ["_ # _ _ e"]))))

(deftest test-2
  (is (= false (can-place "the" ["c _ _ _"
                                 "d _ # e"
                                 "r y _ _"]))))

(deftest test-3
  (is (= true (can-place "joy" ["c _ _ _"
                                "d _ # e"
                                "r y _ _"]))))

(deftest test-4
  (is (= false (can-place "joy" ["c o n j"
                                 "_ _ y _"
                                 "r _ _ #"]))))

(deftest test-5
  (is (= true (can-place "clojure" ["_ _ _ # j o y"
                                    "_ _ o _ _ _ _"
                                    "_ _ f _ # _ _"]))))


(run-tests 'crossword_puzzle_test)