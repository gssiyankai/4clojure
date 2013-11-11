(ns best_poker_hand_test
  (:use clojure.test)
  (:use best_poker_hand))

(deftest test-1
  (is (= :high-card (best-hand ["HA" "D2" "H3" "C9" "DJ"]))))

(deftest test-2
  (is (= :pair (best-hand ["HA" "HQ" "SJ" "DA" "HT"]))))

(deftest test-3
  (is (= :two-pair (best-hand ["HA" "DA" "HQ" "SQ" "HT"]))))

(deftest test-4
  (is (= :three-of-a-kind (best-hand ["HA" "DA" "CA" "HJ" "HT"]))))

(deftest test-5
  (is (= :straight (best-hand ["HA" "DK" "HQ" "HJ" "HT"]))))

(deftest test-6
  (is (= :straight (best-hand ["HA" "H2" "S3" "D4" "C5"]))))

(deftest test-7
  (is (= :flush (best-hand ["HA" "HK" "H2" "H4" "HT"]))))

(deftest test-8
  (is (= :full-house (best-hand ["HA" "DA" "CA" "HJ" "DJ"]))))

(deftest test-9
  (is (= :four-of-a-kind (best-hand ["HA" "DA" "CA" "SA" "DJ"]))))

(deftest test-10
  (is (= :straight-flush (best-hand ["HA" "HK" "HQ" "HJ" "HT"]))))

(run-tests 'best_poker_hand_test)