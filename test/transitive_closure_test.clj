(ns transitive_closure_test
  (:use clojure.test)
  (:use transitive_closure))

(deftest test-1
  (is (let [divides #{[8 4] [9 3] [4 2] [27 9]}]
        (= (generate divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))))

(deftest test-2
  (is (let [more-legs
            #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
        (= (generate more-legs)
            #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
              ["spider" "cat"] ["spider" "man"] ["spider" "snake"]}))))

(deftest test-3
  (is (let [progeny
            #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
        (= (generate progeny)
            #{["father" "son"] ["father" "grandson"]
              ["uncle" "cousin"] ["son" "grandson"]}))))

(run-tests 'transitive_closure_test)