(ns write_roman_numerals_test
  (:use clojure.test)
  (:use write_roman_numerals))

(deftest test-1
  (is (= "I" (write-roman-numeral 1))))

(deftest test-2
  (is (= "XXX" (write-roman-numeral 30))))

;(deftest test-3
;  (is (= "IV" (write-roman-numeral 4))))

;(deftest test-4
;  (is (= "CXL" (write-roman-numeral 140))))
;
;(deftest test-5
;  (is (= "DCCCXXVII" (write-roman-numeral 827))))
;
;(deftest test-5
;  (is (= "MMMCMXCIX" (write-roman-numeral 3999))))

;(deftest test-5
;  (is (= "XLVIII" (write-roman-numeral 48))))


(run-tests 'write_roman_numerals_test)