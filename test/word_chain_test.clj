(ns word_chain_test
  (:use clojure.test)
  (:use word_chain))

(deftest test-0
;  (is (= true (can-chain #{"cot" "hot"})))
;  (is (= false (can-chain #{"cat" "hot"})))
;  (is (= false (can-chain #{"top" "taper"})))
  (is (= true (can-chain #{"to" "top"}))))

;(deftest test-1
;  (is (= true (can-chain #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"}))))
;
;(deftest test-2
;  (is (= false (can-chain #{"cot" "hot" "bat" "fat"}))))
;
;(deftest test-3
;  (is (= false (can-chain #{"to" "top" "stop" "tops" "toss"}))))
;
;(deftest test-4
;  (is (= true (can-chain #{"spout" "do" "pot" "pout" "spot" "dot"}))))
;
;(deftest test-5
;  (is (= true (can-chain #{"share" "hares" "shares" "hare" "are"}))))
;
;(deftest test-6
;  (is (= false (can-chain #{"share" "hares" "hare" "are"}))))

(run-tests 'word_chain_test)