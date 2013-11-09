(ns tic_tac_toe_test
  (:use clojure.test)
  (:use tic_tac_toe))

(deftest test-1
  (is (= nil (winner [[:e :e :e]
                      [:e :e :e]
                      [:e :e :e]]))))

(deftest test-2
  (is (= :x (winner [[:x :e :o]
                     [:x :e :e]
                     [:x :e :o]]))))

(deftest test-3
  (is (= :o (winner [[:e :x :e]
                     [:o :o :o]
                     [:x :e :x]]))))

(deftest test-4
  (is (= nil (winner [[:x :e :o]
                      [:x :x :e]
                      [:o :x :o]]))))

(deftest test-5
  (is (= :x (winner [[:x :e :e]
                     [:o :x :e]
                     [:o :e :x]]))))

(deftest test-6
  (is (= :o (winner [[:x :e :o]
                     [:x :o :e]
                     [:o :e :x]]))))

(deftest test-7
  (is (= nil (winner [[:x :o :x]
                      [:x :o :x]
                      [:o :x :o]]))))

(deftest test-8
  (is (= (solve :x [[:o :e :e]
                    [:o :x :o]
                    [:x :x :e]])
         #{[2 2] [0 1] [0 2]})))

(deftest test-9
  (is (= (solve :x [[:x :o :o]
                    [:x :x :e]
                    [:e :o :e]])
         #{[2 2] [1 2] [2 0]})))

(deftest test-10
  (is (= (solve :x [[:x :e :x]
                    [:o :x :o]
                    [:e :o :e]])
         #{[2 2] [0 1] [2 0]})))

(deftest test-11
  (is (= (solve :x [[:x :x :o]
                 [:e :e :e]
                 [:e :e :e]])
          #{})))

(deftest test-12
  (is (= (solve :o [[:x :x :o]
                 [:o :e :o]
                 [:x :e :e]])
         #{[2 2] [1 1]})))

(run-tests 'tic_tac_toe_test)