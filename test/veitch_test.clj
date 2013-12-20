(ns veitch_test
  (:use clojure.test)
  (:use veitch))

(deftest test-1
  (is (= (simplify #{#{'a 'B 'C 'd}
                     #{'A 'b 'c 'd}
                     #{'A 'b 'c 'D}
                     #{'A 'b 'C 'd}
                     #{'A 'b 'C 'D}
                     #{'A 'B 'c 'd}
                     #{'A 'B 'c 'D}
                     #{'A 'B 'C 'd}})
          #{#{'A 'c}
              #{'A 'b}
              #{'B 'C 'd}})))

(deftest test-2
  (is (= (simplify #{#{'A 'B 'C 'D}
                     #{'A 'B 'C 'd}})
          #{#{'A 'B 'C}})))

(deftest test-3
  (is (= (simplify #{#{'a 'b 'c 'd}
                     #{'a 'B 'c 'd}
                     #{'a 'b 'c 'D}
                     #{'a 'B 'c 'D}
                     #{'A 'B 'C 'd}
                     #{'A 'B 'C 'D}
                     #{'A 'b 'C 'd}
                     #{'A 'b 'C 'D}})
          #{#{'a 'c}
              #{'A 'C}})))

(deftest test-4
  (is (= (simplify #{#{'a 'b 'c}
                     #{'a 'B 'c}
                     #{'a 'b 'C}
                     #{'a 'B 'C}})
          #{#{'a}})))

(deftest test-5
  (is (= (simplify #{#{'a 'B 'c 'd}
                     #{'A 'B 'c 'D}
                     #{'A 'b 'C 'D}
                     #{'a 'b 'c 'D}
                     #{'a 'B 'C 'D}
                     #{'A 'B 'C 'd}})
          #{#{'a 'B 'c 'd}
              #{'A 'B 'c 'D}
              #{'A 'b 'C 'D}
              #{'a 'b 'c 'D}
              #{'a 'B 'C 'D}
              #{'A 'B 'C 'd}})))

(deftest test-6
  (is (= (simplify #{#{'a 'b 'c 'd}
                     #{'a 'B 'c 'd}
                     #{'A 'B 'c 'd}
                     #{'a 'b 'c 'D}
                     #{'a 'B 'c 'D}
                     #{'A 'B 'c 'D}})
          #{#{'a 'c}
            #{'B 'c}})))

(deftest test-7
  (is (= (simplify #{#{'a 'B 'c 'd}
                     #{'A 'B 'c 'd}
                     #{'a 'b 'c 'D}
                     #{'a 'b 'C 'D}
                     #{'A 'b 'c 'D}
                     #{'A 'b 'C 'D}
                     #{'a 'B 'C 'd}
                     #{'A 'B 'C 'd}})
          #{#{'B 'd}
            #{'b 'D}})))

(deftest test-8
  (is (= (simplify #{#{'a 'b 'c 'd}
                 #{'A 'b 'c 'd}
                 #{'a 'B 'c 'D}
                 #{'A 'B 'c 'D}
                 #{'a 'B 'C 'D}
                 #{'A 'B 'C 'D}
                 #{'a 'b 'C 'd}
                 #{'A 'b 'C 'd}})
          #{#{'B 'D}
            #{'b 'd}})))

(run-tests 'veitch_test)