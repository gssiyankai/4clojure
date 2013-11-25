(ns read_roman_numerals_test
  (:use clojure.test)
  (:use read_roman_numerals))

(deftest test-0
  (is (= 1    (read-roman-numeral "I")))
  (is (= 5    (read-roman-numeral "V")))
  (is (= 10   (read-roman-numeral "X")))
  (is (= 50   (read-roman-numeral "L")))
  (is (= 100  (read-roman-numeral "C")))
  (is (= 500  (read-roman-numeral "D")))
  (is (= 1000 (read-roman-numeral "M")))
  (is (= 2    (read-roman-numeral "II")))
  (is (= 4    (read-roman-numeral "IV"))))

;(deftest test-1
;  (is (= 14 (read-roman-numeral "XIV"))))
;
;(deftest test-2
;  (is (= 827 (read-roman-numeral "DCCCXXVII"))))
;
;(deftest test-3
;  (is (= 3999 (read-roman-numeral "MMMCMXCIX"))))
;
;(deftest test-4
;  (is (= 48 (read-roman-numeral "XLVIII"))))


(run-tests 'read_roman_numerals_test)